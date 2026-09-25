---
name: dalcomsoft-revival-reversing
description: Procedimientos y herramientas para ingeniería inversa, volcado IL2CPP, análisis de encriptación y desarrollo de revival para juegos móviles Dalcomsoft (SuperStar Series).
---

# Skill: Dalcomsoft Revival Reversing & Engineering

Esta skill define los pasos estándar y flujos de trabajo para analizar, desensamblar, modificar y emular el cliente de videojuegos de Dalcomsoft (Unity + IL2CPP).

## Flujos de Trabajo Principales

### 1. Volcado y Extracción de Metadata IL2CPP
* **Archivos fuente:**
  * Binario: `app/src/main/lib/arm64-v8a/libil2cpp.so`
  * Metadata: `app/src/main/assets/bin/Data/Managed/Metadata/global-metadata.dat`
* **Procedimiento:**
  1. Ejecutar `Il2CppDumper <libil2cpp.so> <global-metadata.dat> <output_dir>`.
  2. Obtener `dump.cs`, `script.json` (para Ghidra/IDA) y la carpeta `DummyDll/`.
  3. Analizar clases críticas en `DummyDll/` (e.g., `Dalcomsoft.Network`, `CardView`, `OfflineResourceManager`, `GameManager`).

### 2. Hooking y Parcheo Dinámico con Frida
* **Archivos fuente:**
  * Config: `app/src/main/lib/arm64-v8a/libfrida-gadget.config.so`
  * Script JS: `app/src/main/lib/arm64-v8a/libscript.so`
* **Procedimiento:**
  1. Localizar los offsets de memoria de las funciones objetivo en `dump.cs` o Ghidra.
  2. Implementar `Interceptor.attach(il2cpp.add(ptr(<OFFSET>)), { ... })` en `libscript.so`.
  3. Interceptar llamadas a paquetes, deshabilitar chequeos de integridad o emular respuestas JSON.

### 3. Emulación de Red y Servidor Privado (Mock Server)
* **Objetivo:** Reemplazar las peticiones HTTP/HTTPS que van a los servidores oficiales de Dalcomsoft.
* **Componentes a emular:**
  * Handshake / Login inicial.
  * Sincronización de usuario y catálogo de cartas.
  * Catálogo de canciones y beatmaps (`.seq`).

### 4. Gestión de Fondos de Lobby y Assets Oficiales (`weoihxd` / `MyLobby`)
* **Ubicación de Assets:** `app/src/files/asiudgasg/asodhsg/weoihxd/` (76 fondos oficiales `1001`-`1076`).
* **Formatos:**
  * `_l.i.bytes.png`: Fondos de alta definición (1024x1024 RGBA) con viñeteado nativo superior e inferior.
  * `_s.i.bytes.png`: Miniaturas (226x226 RGBA) para tienda/selector (`LobbyBgStore`).
* **Inyección en Tiempo de Ejecución:**
  * Carga con `File.ReadAllBytes` e instanciación nativa con `Texture2D..ctor` (RVA `0x181B6BC`) y `ImageConversion.LoadImage` (RVA `0x25B3E90`).
  * Asignación a `memberView.memberImage` (offset `0x50`) con `RawImage.set_texture` (RVA `0x194C074`).
  * Selección dinámica mediante lectura de `chosen_bg.txt` en el almacenamiento externo de la aplicación.

### 5. Resolución de Clases Anidadas IL2CPP y Estabilización de Escenas (Inventario / CardBook)
* **Limitación de `il2cpp_class_from_name`:**
  * La API nativa falla al consultar tipos anidados con delimitadores slash (e.g. `"ThemeTypeControl/Data"` o `"CardSmallView/Params"`).
  * **Solución Estándar:** Iterar sobre los tipos anidados de la clase padre mediante `il2cpp_class_get_nested_types(parentClass, iter)` y comparar el nombre con `il2cpp_class_get_name(nestedType)`.
* **Estabilización de UI en Escenas de Cartas:**
  * Para evitar excepciones de puntero nulo al consultar `WWWFile.DownloadPath` offline, interceptar con `Interceptor.replace`:
    * `ViewControl.GetSmallCardViewData` (RVA `0xABEB30`): Instanciar y retornar directamente `CardSmallView.Params` con atributos de grado/nivel simulados.
    * `ViewControl.GetLargeCardViewData` (RVA `0xABE5FC`): Retornar `CardLargeView.Params`.
    * `InventoryControl.CardItem.ExtractSmallImagePath` (RVA `0xB56598`): Retornar `void` (no procesar descargas).
    * `InventoryControl.GroupItem.ExtractPath` (RVA `0xB56EC4`): Retornar `NULL`.
  * Parchear submenús con tabs huérfanas o nulas (`CardBookScene.SetupSubMenu` @ RVA `0xCAFC24`) con instrucciones `NOP` (`0x1F, 0x20, 0x03, 0xD5`).

### 6. Pipeline Nativo de Carga Directa de Texturas y DetailView de Cartas
* **RVAs Nativo para Carga y Renderizado Rápido:**
  * `File.Exists(path)`: RVA `0x1F01DF4`
  * `File.ReadAllBytes(path)`: RVA `0x1F0268C`
  * `Texture2D..ctor(int, int)`: RVA `0x181B6BC`
  * `ImageConversion.LoadImage(tex, bytes, methodInfo)`: RVA `0x25B3E90` (Firma ARM64 con 3 parámetros; pasar `NULL` en `methodInfo`).
  * `Texture.set_filterMode(FilterMode)`: RVA `0x181A580` (Usar `2` para Trilinear).
  * `Texture.set_anisoLevel(int)`: RVA `0x181A640` (Usar `8`).
  * `RawImage.set_texture(Texture)`: RVA `0x194C074`
  * `Graphic.SetNativeSize()`: RVA `0x1949574`
* **Offsets Estructurales de `CardLargeView` (`CardView`):**
  * `+0x58`: `photo` (`RawImage*` para textura de retrato de alta resolución).
  * `+0x68`: `tier` (`RawImage*` para textura del marco de rango / estrella).
* **Transición y Estabilización de `DetailView`:**
  * `InventoryView.ShowMainLayout(bool isSelectedItem)`: RVA `0x10571EC`
  * `InvenCardMainView.Refresh(Params)`: RVA `0xF227B4`
  * `InvenCardSelectView.Refresh(Params)`: RVA `0xF22C34`
  * **Prevención de Violación de Acceso `0x132`:** En `InvenCardSelectView.Params`, escribir `NULL` en el offset `+0x48` en lugar de llamar a `GetCardThemeInfoViewData` (RVA `0xABFF78`), el cual desreferencia campos de tema inexistentes en `CardItem` virtuales.

### 7. Ciclo de Vida de Equipamiento de Cartas, InvenCardEquipView y Persistencia Local de Perfil
* **Flujo Nativo de Eventos e Interceptores:**
  * En `InvenCardMainView`, el botón `Equip` (`btnChange` @ offset `0x48`) dispara `InvenCardMainView.OnChange` (RVA `0xF22A88`), el cual invoca `InventoryScene.OnChange` (RVA `0x105A61C`).
  * `InventoryScene.OnChange` configura los punteros nativos de carta en la escena:
    * `sceneThis + 0x88` (`selectedCardItem`): Carta seleccionada a inspeccionar / equipar.
    * `sceneThis + 0x90` (`equippedCardItem`): Carta actualmente equipada en el slot del grupo.
  * Llama a `InventoryView.ShowEquipLayout()` (RVA `0x1057760`), ocultando el carrusel inferior y desplegando la vista comparativa `InvenCardEquipView`.
  * `InventoryScene.GetEquipViewData` (RVA `0x10577DC`): Instancia `InvenCardEquipView.Params`, calcula `deltaScore` y `deltaEnergy`, e inicializa los textos de los botones (`Equip`, `Cancel`, `Level Up`).
  * `InvenCardEquipView.Refresh` (RVA `0xF219B4`): Aplica los parámetros en pantalla sin dependencias de red.
* **Confirmación de Equipamiento (`OnEquip`) y Persistencia Atómica:**
  * Al pulsar `btnEquip` (`InvenCardEquipView + 0x78`), se invoca `InvenCardEquipView.OnEquip` (RVA `0xF21D7C`), el cual llama a `InventoryScene.OnEquip` (RVA `0x105AFC8`).
  * En el interceptor de `InventoryScene.OnEquip`:
    1. Se obtienen `beforeCard` (`0x88`) y `newCard` (`0x90`).
    2. Se ejecuta `handleCardEquipOffline(beforeCard, newCard)`.
    3. Se calcula el slot del miembro `memberIdx = ((cardID - 1001) % 11)`.
    4. Se actualizan los atributos `isEquip` en `inventoryCards` y el arreglo de slots en `equipedCards["1001"]` de `player_profile.json` en disco.
    5. Se actualiza en memoria el byte de estado de equipamiento (`rawCard + 0x28`) para todos los objetos `CardItem` de LOONA.
    6. Se reconstruye el `FastArray` del grupo (`loonaCardListFastArray`) y se reasigna a `loonaGroupItemObj + 0x28`.
    7. Se refrescan los contadores de cabecera y el carrusel mediante `refreshInventoryHeaderView()` y `refreshInventoryCardList()`.
    8. Se retorna a la vista principal del inventario mediante `InventoryScene.SetStateDefault(sceneThis, 1, 0, NULL)` (RVA `0x1053B88`), restaurando la cuadrícula general de 11 miembros con insignias recalculadas en tiempo real.


