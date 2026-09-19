# Walkthrough: Perfeccionamiento de la UI del Inventario (Estrellas no-R, OT11 y Contadores)

**Fecha:** 2026-09-19  
**Autor:** Antigravity (Pair Programming con Ignacio)  
**Entorno:** Android ARM64 (IL2CPP / Frida Gadget Standalone Offline) / BlueStacks macOS

---

## 🎯 Objetivos Cumplidos

1. **Corrección del Rectángulo Blanco Sólido en Cartas no-R (C, B, A, S):**
   - Se analizó el desensamblado de `CardView.SetLevel(p)` (RVA `0x1394858`) y la indexación nativa de `starSprites`:
     $$\text{index} = (\text{tier} \times \text{maxLevel}) + \text{level} - 1$$
   - En rangos no-R (`grade < 4`), `maxLevel` debe ser 5 (en lugar de 50) y `level` debe acotarse a $[1, 5]$.
   - Al restablecer los límites canónicos, Dalcomsoft carga los sprites dorados oficiales de 1 a 5 estrellas, eliminando por completo el renderizado del quad blanco por omisión de textura.

2. **Alineación Canónica OT11 y Desactivación del Slot 12:**
   - Se comprobó mediante desencriptación de `grd.bin` y `atd.bin` que el grupo 1001 (`[+ +]`) contiene oficialmente 11 integrantes (`equipableSlot: 11`).
   - El prefab de Unity `InvenGroupItemView` posee 12 GameObjects fijos en su jerarquía (`cardList`).
   - Se resolvió `Component.get_gameObject` (RVA `0x1DB6AD4`) y `GameObject.SetActive` (RVA `0x1DBADF4`) para desactivar dinámicamente cualquier slot con índice $i \ge 11$.
   - Se alinearon a módulo 11 (`% 11`) las rutinas de equipamiento individual (`handleCardEquipOffline`), desequipamiento (`handleCardUnequipOffline`) y auto-equipamiento (`handleAutoEquipOffline`).

3. **Visibilidad y Formato de Contadores:**
   - Contador de cartas en bandeja inferior (`InvenCardView + 0x38`): **`14 / 200`** (14 cartas en posesión de 200 de capacidad máxima).
   - Contador de grupos en panel de selección (`InvenGroupView + 0x38`): **`1 / 1`** (Grupo 1 de 1 disponible).

4. **Flujo de Hot-Reload Ultrarrápido:**
   - Aprovechando la rutina de `UnityPlayerActivity.java` (`getExternalFilesDir(null)/libscript.js`), se implementó la inyección instantánea vía streaming stdin sobre ADB (`~1 segundo`), acelerando drásticamente los ciclos de prueba sin reconstrucción de APK.

---

## 📸 Evidencia Visual de Verificación

A continuación se presenta la captura final tomada directamente desde el emulador BlueStacks:

![Inventario Final Perfeccionado](file:///Users/ignaciorojas/Documents/repos/sslo_apk/inventory_final_check.png)

### Observaciones de la Captura:
- **Cabecera de LOONA:** Muestra las 11 integrantes canónicas (HeeJin, HyunJin, HaSeul, YeoJin, ViVi, Kim Lip en fila 1; JinSoul, Choerry, Yves, Go Won, Olivia Hye en fila 2).
- **Slot 12 Eliminado:** No existe duplicación de HeeJin en la posición 12.
- **Grado y Tema Activos:** Insignia brillante `Group Grade: R +500.000` y `Group Theme: Lv 3 Hi High` (`ULTRA RAVE`).
- **Cartas no-R en Bandeja:** Cartas Grado A y Grado S muestran su estrella dorada nítida y su fondo degradado característico, sin artefactos blancos.
- **Contadores Activos:** `14 / 200` en la esquina inferior izquierda y `1 / 1` en la esquina superior derecha.

---

## 🛠️ Archivos Modificados

- [`app/src/main/assets/libscript.js`](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/assets/libscript.js): Lógica de ocultamiento de slot 12, módulo 11 y fórmulas de estrellas no-R.
- [`app/src/main/lib/arm64-v8a/libscript.so`](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libscript.so): Binario sincronizado con `libscript.js`.
- [`docs/CONTEXT.md`](file:///Users/ignaciorojas/Documents/repos/sslo_apk/docs/CONTEXT.md): Incorporada Sección 16.11 con los hallazgos de ingeniería inversa y decisiones arquitectónicas.
