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

### 8. Calibración Dimensional, Aspect Ratio y Pipeline HD de Cartas (`CardSmallView` / `InvenCardCellView`)
* **Geometría Nativa Dalcomsoft:**
  * `photoRawImg`: Configurar `sizeDelta` a `Vector2(92.0, 130.0)` (`BasicSize` según RVA `0x13908fc`). No aplicar `SetNativeSize()` sobre la foto para evitar deformación del marco.
  * `tierRawImg`: Invocar obligatoriamente `RawImage.SetNativeSize()` (RVA `0x194C1C8` / `0x1949574`). La textura nativa de `116 x 156` px escalada por el `CanvasScaler` a 1080p (`1.0517x`) rinde exactamente `122.0` px de ancho en pantalla.
* **Escala de Celdas (`itemScale`):**
  * `InvenCardCellView`: El offset `cell + 0x40` define `itemScale = Vector3(0.8f, 0.8f, 1.0f)`. Respetar este valor nativo (`0.8f`) en el `transform` de `cardSmallView` para mantener el espaciado e interleaving canónico del carrusel.
* **Resolución HD y Downsampling GPU:**
  * Cargar prioritariamente `files/asiudgasg/asodhsg/wadceg/{cardID}_l.i.bytes` (`226 x 318` px) con `filterMode = 2` (Trilinear) y `anisoLevel = 8` para erradicar la pixelación de miniaturas `_s` (`85 x 120` px).
* **Botón 'X' (`btnBack`):**
  * Desactivar el componente `box` (`Image` en `ButtonCache + 0x50`) con `setEnabledFn(bBox, 0, NULL)` y `SetActive(boxGo, 0)` para suprimir el recuadro negro sólido de 82x82 px.

### 9. Motor Standalone de Video de Fondo, Protección de Texturas GC y Escudo Libunity (0x3746CC)
* **Arquitectura de Reproducción Offline de Video:**
  * En emuladores o entornos sin códecs propietarios de AVPro Video, los videos WebM (`main_24.webm` / `title_24.webm` en `app/src/files/soidhskd/`) se descomprimen en secuencias de fotogramas PNG cargados en memoria como `Texture2D`.
  * La reproducción se orquesta en `SceneControl.Update` (RVA `0xAB2468`) en el hilo principal (`UnityMain`), aplicando secuencialmente los fotogramas en `BackgroundImage.Instance.backgroundRawImage` (`0x20`) y forzando `CanvasRenderer.SetTexture` (RVA `0x1945110`).
* **Protección contra Recolección Temprana del Garbage Collector:**
  * Las instancias dinámicas de `Texture2D` creadas con `il2cpp_object_new` son eliminadas por Unity durante `Resources.UnloadUnusedAssets()` al transicionar escenas.
  * **Solución Mandatoria:**
    1. `setHideFlags(texObj, 52)` (RVA `0x1DC7FF4`): Establece `HideFlags.DontSave` (`DontSaveInEditor | DontSaveInBuild | DontUnloadUnusedAsset = 32`).
    2. `DontDestroyOnLoad(texObj)` (RVA `0x1DC7FB4`): Previene la destrucción del objeto de Unity entre cambios de escena.
    3. `il2cpp_gchandle_new(texObj, 1)`: Fija el objeto en el recolector de basura de Mono/IL2CPP.
* **Escudo Crítico de Libunity (Crash en Integración de Escenas `0x3746CC`):**
  * Durante la integración de escenas (`IntegrateSceneAsync` / vtable[12] @ RVA `0x288F00`), `libunity.so` recorre objetos registrados vía `0x293364` -> `0x37469c` -> `0x3746CC` (`ProcessObject`).
  * Para objetos con vtable corrupta o incompleta (e.g., instanceID `0x41144` / 266564), `0x3746CC` intenta ejecutar el slot `0x98` de la vtable (`ldr x8, [x8, #0x98]; blr x8`), saltando a `0x0` (`SIGSEGV`).
  * **Intervención Quirúrgica:** Interceptar con `Interceptor.replace` el prólogo de `0x3746CC`. Si `instanceID === 0x41144` o si el puntero de vtable / slot `0x98` es nulo, retornar inmediatamente el `instanceID` sin disparar el salto nulo, permitiendo la integración suave y continua de escenas sin fugas de memoria ni caídas de proceso.






### 10. Pipeline Offline de Intensify / Power Up y Mitigación de Desreferenciaciones Nulas en Popups
* **Arquitectura de Resiliencia ARM64 en Dalcomsoft Popups:**
  * **Null Guard en `Popup.OnClick` (RVA `0x114B7A4`):**
    * Dalcomsoft asume por defecto que todos los popups contienen `btnOk` (`+0xC8`), `btnCancel` (`+0xD0`) y `btnX` (`+0xD8`).
    * En popups especializados como `CardIntensifyPopup`, `btnX` es nulo, provocando una caída por desreferenciación nula en `0x114B8AC`.
    * **Parche ARM64:** Escribir en `0x114B8AC` la instrucción `cbz x8, #0x114b8e4` (`c8 01 00 b4`) para omitir `btnX` si es nulo. Análogamente, en `0x114B994` escribir `cbz x8, #0x114ba94` (`08 08 00 b4`) para omitir `btnCancel` si es nulo.
  * **Null Guard en `InventoryScene.OnIntensifyTry` (RVA `0x105BA9C`):**
    * Los offsets `0x105BC4C` y `0x105BC6C` desreferencian `sceneView.btnBoxSprites` (`0xC0`), que en offline está ausente.
    * **Parche ARM64:** Escribir `stur xzr, [x29, #-0x30]; b #0x14; nop; nop; nop` para continuar la ejecución de forma segura.
  * **Null Guard en `GetLargeCardViewData` (RVA `0xABE5FC`):**
    * Al procesar cartas R o prismáticas, `0xABE7D0` desreferencia `CardSpritesControl.Instance`.
    * **Parche ARM64:** Escribir `cbz x21, #0xabe7e8` (`d5 00 00 b4`) para omitir la lectura de sprites prismáticos sin abortar.
* **Consumo Atómico y Descuento en Tiempo Real:**
  * La rutina `commitConsumedMaterials` actualiza en memoria `loonaCardItems`, persiste el nuevo estado en `player_profile.json` en disco, descuenta el saldo de Rhythm Points (RP) y llama a `TopView.RefreshRhythmPoint` (RVA `0xB2BE9C`) para refrescar la UI superior en vivo.
  * Desregistra las cartas consumidas en `InventoryControl.CardMap` (RVA `0xF2751C`).
* **Interacción Táctil y Smart Recommendation:**
  * **Smart Recommend (`0x105B4F4`):** Accesible físicamente en `(x=1200, y=690)`. Monta las cartas de menor grado disponibles.
  * **Desregistro Táctil de Pedestales (`InvenMaterialView`, `0xF226A4`):** Al tocar cualquier pedestal con material montado, la carta se libera inmediatamente (`+`), el badge del carrusel se revierte a `N` y el costo de RP en el botón TRY se recalcula en tiempo real.

### 11. Deducción Dinámica de RP y Gestión de Fondos Insuficientes (Shortage Popup)
* **Arquitectura Reactiva de UI Superior (`TopViewControl`):**
  - Los getters de `UserControl` (`get_RhythmPoint` `0xAB127C`, `get_FreeRhythmPoint` `0xAB1094`, `get_PaidRhythmPoint` `0xAB0EAC`) deben consultar dinámicamente el perfil local (`loadPlayerProfile()`) para evitar revertir el saldo a valores estáticos (`1.000.000`).
  - La sincronización en vivo se efectúa resolviendo la instancia singleton `TopViewControl.Instance` (RVA `0xB13204`), actualizando la estructura de memoria nativa `globalPlayerObj + 0x54`, y llamando a `TopView.RefreshRhythmPoint` (RVA `0xB2BE9C`) con `(topView, rp, 999999999, NULL)`.
  - Esta rutina debe ser invocada atómicamente en `commitConsumedMaterials`, ventas de inventario y al salir de escenas en `TopViewControl.UpdateScene` (RVA `0xB2ECE4`).
* **Manejo Nativo de 0 RP y Bloqueo de Power Up:**
  - En `IntensifyAssist.Start` (RVA `0xF1CD34`), si `price > RP`, el motor invoca `UIHelper.OpenRhythmPointShortagePopup` (RVA `0xAC1FD0`).
  - El modal oficial `System/Popup_Notice_1Btn` requiere los códigos de localización Dalcomsoft: `0x399A569` (*"Notice"*), `0x399AD3A` (*"Rhythm Points are insufficient."*), y `0x399B121` (*"OK"*).
  - Al pulsar "OK", el callback `InventoryScene.<OnIntensifyTry>b__1` (RVA `0xB5B3E8`) intenta abrir la tienda en línea llamando a `StorePopup.Open` (RVA `0xB6EE4C`).
  - **Interceptor de Seguridad:** Reemplazar `StorePopup.Open` (RVA `0xB6EE4C`) con un stub que absorbe la apertura en modo offline y llama al callback de retorno de forma segura, evitando el crash por falta de conexión y preservando la integridad del inventario.
