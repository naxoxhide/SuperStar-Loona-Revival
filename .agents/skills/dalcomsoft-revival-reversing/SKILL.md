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


