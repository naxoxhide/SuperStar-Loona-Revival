---
name: dalcomsoft-qa-testing
description: Procedimientos y herramientas para pruebas automatizadas, inyección de comandos ADB, aserciones de logcat y verificación de integridad de guardado para juegos móviles Dalcomsoft (SuperStar Series).
---

# Skill: Dalcomsoft QA Testing & Automation

Esta skill define la metodología, scripts y flujos de trabajo de aseguramiento de calidad (QA) para validar experimentalmente el cliente de videojuegos de Dalcomsoft (Unity + IL2CPP / ARM64) en emuladores (BlueStacks) o dispositivos físicos Android.

---

## 1. Conexión y Diagnóstico de Entorno

* **Conexión al Emulador:**
  ```bash
  adb connect 127.0.0.1:5555
  adb devices
  ```
* **Comprobación de Proceso Activo:**
  ```bash
  adb shell ps -A | grep "com.dalcomsoft.sslo"
  ```
* **Ubicación de Datos en Dispositivo:**
  `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/`

---

## 2. Inyección de Comandos y Navegación Dinámica (`scene_cmd.txt`)

El script de instrumentación en memoria (`libscript.js`) monitorea el archivo `scene_cmd.txt` cada 30 frames para permitir la manipulación y navegación directa sin interacción táctil manual:

| Comando | Propósito | Ejemplo ADB |
| :--- | :--- | :--- |
| `<SceneId>` | Cambiar de escena mediante `SceneControl.OpenScene` (`0xD534BC`) | `adb shell "echo 4 > /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt"` |
| `card:<index>` | Abrir detalle de carta de inventario por índice | `adb shell "echo card:2 > /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt"` |
| `change` | Disparar vista de comparación y cambio (`InvenCardEquipView`) | `adb shell "echo change > /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt"` |
| `back` / `close` | Restaurar estado base (`InventoryScene.SetStateDefault`) | `adb shell "echo back > /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt"` |

---

## 3. Automatización de Toques Físicos e Interacción de UI

Para botones de Unity que responden a eventos de `EventSystem` / `GraphicRaycaster`, inyectar toques táctiles con coordenadas canónicas en resolución 1920x1080 (Landscape):

* **Botón EQUIP (`btnEquip` en `InvenCardEquipView`):**
  ```bash
  adb shell input tap 1670 875
  ```
* **Botón CANCEL (`btnCancel` en `InvenCardEquipView`):**
  ```bash
  adb shell input tap 1350 875
  ```
* **Slot 1 de Cuadrícula de LOONA (HeeJin):**
  ```bash
  adb shell input tap 400 350
  ```

---

## 4. Captura de Evidencias y Prevención de Regresiones Visuales

Toda validación de interfaz debe capturar una imagen del estado de pantalla y almacenarla en la carpeta canónica de documentación de walkthroughs:

```bash
# 1. Capturar pantalla en el dispositivo
adb shell screencap -p /sdcard/screen_qa.png

# 2. Transferir imagen a la carpeta del repositorio
adb pull /sdcard/screen_qa.png docs/walkthroughs/media/<nombre_descriptivo>.png

# 3. Limpiar archivo temporal en dispositivo
adb shell rm /sdcard/screen_qa.png
```

---

## 5. Auditoría de Integridad de Datos (`player_profile.json`)

Para verificar que las acciones de juego persisten correctamente en el cliente sin corrupción:

1. **Lectura y Formateo:**
   ```bash
   adb shell cat /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/player_profile.json | python3 -m json.tool | head -n 30
   ```
2. **Aserciones Críticas:**
   * **Sintaxis JSON Válida:** No debe arrojar errores de parseo `JSONDecodeError`.
   * **Consistencia de `isEquip`:** Solo una carta por miembro/artista puede tener `isEquip: true`.
   * **Arreglo de Grupo Sincronizado:** `equipedCards["1001"]` debe contener exactamente 11 IDs correspondientes a las cartas activas de cada integrante de LOONA.

---

## 6. Monitoreo y Filtrado de Logs en Tiempo Real

Para vigilar la ejecución de Frida y detectar excepciones nativas de inmediato:

* **Filtrar Logs de FridaSSL0:**
  ```bash
  adb logcat -d | grep "FridaSSLO" | tail -n 40
  ```
* **Detectar Fallos Nativos y Crashes:**
  ```bash
  adb logcat -d | grep -E "DEBUG|tombstone|SIGSEGV|AndroidRuntime|Unity" | tail -n 50
  ```

---

## 7. Protocolo de Validación Visual y Control de Intentos en Power Up (`CardIntensifyPopup`)

Para validar visualmente y certificar que la cantidad de intentos y las cartas de material corresponden fielmente a los pedestales seleccionados:

1. **Poblado de Pedestales ($1$ a $5$ Materiales):**
   ```bash
   adb shell "echo recommend > /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt"
   ```
2. **Configuración de Modos de Intento:**
   * `cmd:step`: Demostración escalonada (Intento 1 Fails $\rightarrow$ Next $\rightarrow$ Intentos posteriores Succeed $\rightarrow$ OK).
   * `cmd:fail`: Todos los intentos fallan.
   * `cmd:success`: Todos los intentos tienen éxito.
   * `cmd:normal`: Cálculo estocástico de tasa de éxito Dalcomsoft.
   ```bash
   adb shell "echo cmd:step > /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt"
   ```
3. **Apertura del Modal e Inicio de Try:**
   * Abrir modal TRY: `adb shell input tap 1650 700`
   * Iniciar animación de Try ("Rating Up"): `adb shell input tap 1220 890`
4. **Validación de Secuencia de Intentos y Botón:**
   * En los intentos intermedios ($1 .. N-1$), verificar banner de resultado y botón **"Next"** (`(960, 890)`).
   * En el intento final ($N$), verificar que el botón conmuta a **"OK"** (`(960, 890)`).
   * Pulsar "OK" y confirmar que el modal se cierra y la vista de pedestales queda limpia y lista sin bloqueos.

