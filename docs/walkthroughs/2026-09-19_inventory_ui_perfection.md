# Walkthrough: Perfeccionamiento de la IU de Inventario y Localización de Textos

**Fecha:** 19 de Septiembre de 2026  
**Objetivo:** Implementar los textos faltantes en botones (`Shop`, `Card Book`, `Sell All`, `Choose Group`, `High`) e integrar la función nativa que alimenta el contador de cartas (`14 / 200`) y contador de grupo (`1 / 1`) de acuerdo a las pantallas oficiales de tutorial de SuperStar LOONA.

---

## 1. Textos de Interfaz y Localización Standalone

Se identificaron las llamadas internas a `LanguageControl.GetString(int code32)` (RVA `0xCF1064`) ejecutadas por la lógica nativa del juego durante `InventoryScene.OnOpen` (RVA `0x1051604`) y `InvenSortView.Init` (RVA `0xF25D6C`). Se configuró un mapa de respaldo offline para suministrar las cadenas correspondientes:

| Elemento de IU | Offset / Componente | Clave de Localización | Texto Asignado |
|---|---|---|---|
| `btnStore` | `InventoryView + 0x90` | `0x2FC86C1` | `"Shop"` |
| `btnSellBundle` | `InventoryView + 0x98` | `0x30423FA` | `"Sell All"` |
| `btnSelectGroup` | `InventoryView + 0xA0` | `0xAD02876` | `"Choose Group"` |
| `btnMyCollection` | `InventoryView + 0xA8` | `0x1D9405D` / `0x1D94064` | `"Card Book"` |
| `sortText` (High) | `InvenSortView + 0x40` | `0x14B1DA9` | `"High"` |
| `sortText` (New) | `InvenSortView + 0x40` | `0x2FE0979` | `"New"` |
| `sortText` (Low) | `InvenSortView + 0x40` | `0x2FE097D` | `"Low"` |
| `InvenCardView.count` | `InvenCardView + 0x38` | `0x3072969` | `"{0} / {1}"` |
| `InvenGroupView.count` | `InvenGroupView + 0x38` | `0x3072D51` | `"{0} / {1}"` |

---

## 2. Localización y Pipeline del Contador de Cartas

Se realizó la ingeniería inversa de la función nativa que alimenta el contador de cartas en el binario ARM64 (`libil2cpp.so`):

- **Función Nativa Identificada:** `InventoryScene.OnUpdateCardCount(object[] args)` en **RVA `0x1054BB4`**.
- **Flujo de Ejecución:**
  1. `0x1054C78: bl #0xAB1C1C`: Invoca `UserData.get_CardInvenMaxCount()` -> Lee la capacidad máxima de inventario (200 ranuras).
  2. `0x1054CB8: bl #0xCF1064`: Invoca `LanguageControl.GetString(0x3072969)` -> Retorna el formato `"{0} / {1}"`.
  3. `0x1054CE8: bl #0xF275E8`: Invoca `InventoryControl.get_CardMapCount()` -> Retorna la cantidad de cartas en posesión (14).
  4. `0x1054D2C: bl #0x2205FC4`: Invoca `System.String.Format("{0} / {1}", count, max)` -> Genera `"14 / 200"`.
  5. `0x1054D40: bl #0xf23260`: Invoca `InvenCardView.set_Count(cardView, "14 / 200")`, asignando el texto en el componente `Text count` (offset `0x38`).

---

## 3. Arquitectura del Ciclo de Vida Seguro (`InventoryView.ShowDefaultLayout`)

Para evitar excepciones de reconstrucción de layout en Unity (`libunity.so!0x2d416c`), se trasladó la invocación de actualización al hook de salida (`onLeave`) de `InventoryView.ShowDefaultLayout` (RVA `0x1055ED0`):

```javascript
Interceptor.attach(baseAddr.add(0x1055ED0), {
    onLeave: function (retval) {
        if (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) {
            // 1. Contador de cartas nativo
            var onUpdateCardCountFn = new NativeFunction(baseAddr.add(0x1054BB4), "void", ["pointer", "pointer"]);
            onUpdateCardCountFn(activeInventorySceneInstance, NULL);

            // 2. Contador de páginas de grupos
            var setGroupViewCountFn = new NativeFunction(baseAddr.add(0x1053E18), "void", ["pointer"]);
            setGroupViewCountFn(activeInventorySceneInstance);

            // 3. Etiqueta de ordenamiento
            var sceneView = activeInventorySceneInstance.add(0x48).readPointer();
            if (!sceneView.isNull()) {
                var sortView = sceneView.add(0x80).readPointer();
                if (!sortView.isNull()) {
                    var sortText = sortView.add(0x40).readPointer();
                    if (!sortText.isNull()) {
                        var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                        setTextFn(sortText, createIl2CppString("High"), NULL);
                    }
                }
            }
        }
    }
});
```

---

## 4. Verificación en Emulador

Captura de pantalla verificada: [`inventory_screen_verified.png`](file:///Users/ignaciorojas/Documents/repos/sslo_apk/inventory_screen_verified.png)

- Botones de la izquierda (`Shop`, `Card Book`, `Sell All`) muestran sus textos e iconos correspondientes.
- Botones de la derecha (`Choose Group`, `Equip Theme`, `Auto Equip`, `Unequip All`) muestran sus textos completos.
- Botón de ordenamiento inferior muestra flecha `^` y etiqueta `"High"`.
