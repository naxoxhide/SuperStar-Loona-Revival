# Technical Context & Project Knowledge Base (docs/CONTEXT.md)

Este documento es la **fuente de verdad técnica acumulativa** del proyecto de revival de SuperStar LOONA (`com.dalcomsoft.sslo`).

---

## 📌 Estado de la Ejecución y Avances Recientes (Revival Standalone Offline)

### 1. Desglose del Bloqueo en Carga Asíncrona de `LobbyScene` (43/804 = 5.34%)
- **Identificación del valor exacto `0.05348242446780205`:**
  - El valor de `AsyncOperation.get_progress()` corresponde a la fracción exacta `43 / 804`.
  - En `sharedassets3.assets`, el objeto `PreloadData` (PathID `1`) contiene **268 assets**.
  - Unity ejecuta un pipeline de 3 fases internas por asset en `PreloadManager` (Lectura, Inicialización, Integración), totalizando `268 * 3 = 804` pasos.
  - Los primeros 43 elementos (índices 0 a 42) residen en recursos globales (`globalgamemanagers.assets` y `Library/unity default resources`), cargándose instantáneamente.
  - El asset 43 (índice 43) corresponde a `file_id = 3, path_id = 1`, cuya referencia en la tabla de externos de `sharedassets3.assets` es el archivo CAB **`0ce7b81b2745d4e51ac3745412be3906`** (un `Texture2D` de 53 KB).
  - La carga asíncrona de Unity se detiene al intentar resolver los CABs externos referenciados por `sharedassets3.assets`.

### 2. Arquitectura de Desensamblado de `SceneControl.Update` (RVA `0xD55EE8`)
- `0xD5600C - 0xD56034`: Comprueba `SceneControl.SceneObject`. Si no es nulo, salta a la finalización (`0xD56AEC`).
- `0xD560A4 - 0xD560A8`: Comprueba `SceneControl.AsyncManagerNext` (offset `0x40`).
  - Si no es nulo, comprueba `isDone` (`0x1DB2C9C`).
  - Al completar, pone `AsyncManagerNext = null` (`0xD56164`) y salta a `SceneControl.OnNextScene` (`0xD559E0`).
- `0xD561D8 - 0xD561DC`: Comprueba `SceneControl.AsyncManager` (offset `0x38`). Si es nulo, salta al final del frame.
- `0xD56230 - 0xD56240`: Invoca `AsyncOperation.get_isDone()` (`0x1DB2C9C`). Si retorna `0`, sale inmediatamente del frame (`tbz w0, #0, #0xd56aec`).
- `0xD5626C - 0xD562BC`: Obtiene el nombre de la escena `"LobbyScene"` desde `SceneControl.SceneName[3]`.
- `0xD562C4`: Ejecuta `GameObject.Find("LobbyScene")` (`0x1DBB16C`).
- `0xD5630C`: Almacena el resultado en `SceneControl.SceneObject`.
- `0xD56370`: Evalúa `UnityEngine.Object.op_Implicit(SceneObject)`. Si es nulo (`0x0`), no avanza a la instanciación de vistas.
- `0xD569B4 - 0xD56A20`: Al ser no nulo, busca `SingleFactory[3]` (`0xBEC7E0`), crea la instancia `new LobbyScene()` y la asigna en `SceneControl.SceneInstance` (offset `0x20`).
- `0xD56A6C`: Invoca `Scene.Open(MainView, LobbyView)` (`0xD52B04`).

### 3. Offsets Nativos Verificados en `libunity.so`
- `UnityEngine.AsyncOperation::get_isDone()`: icall en RVA **`0x3C4578`** (vtable slot 2, offset `0x10`).
- `UnityEngine.AsyncOperation::get_progress()`: icall en RVA **`0x3C4610`** (vtable slot 3, offset `0x18`).
- `UnityEngine.AsyncOperation::get_allowSceneActivation()`: icall en RVA **`0x3C46A4`** (vtable offset `0xD8`).
- `UnityEngine.AsyncOperation::set_allowSceneActivation(bool)`: icall en RVA **`0x3C47AC`** (vtable offset `0xE0`).
- **Estructura C++ Nativa de `AsyncOperation` (`mPtr: 0x6fd0dc5750`):**
  - `mPtr + 0x00`: Vtable C++ de Unity.
  - `mPtr + 0x58`: Timestamp / tick counter nativo en tiempo real (actualizado continuamente en cada frame).
  - `mPtr + 0x6C`: Campo `float progress`.
  - `mPtr + 0x40`: Puntero de vuelta al objeto C# gestionado (`AsyncOperation`).

### 4. Avance Crítico: Desbloqueo de `PreloadData` y Transición a `level3`
- **Parchado de `PreloadData` en `sharedassets3.assets`:**
  - Al reducir la lista de precarga a 0 elementos (`m_Assets count = 0`, `byte_size = 13`), Unity superó completamente el bloqueo del CAB 43 en `sharedassets3.assets`.
  - El progreso pasó de `0.0534824` (43/804) a **`0.03020134`**, que corresponde exactamente a la fórmula interna de Unity: **`(10 / 298) * 0.9`**.
  - Esto demuestra que Unity entró a deserializar directamente los GameObjects de **`level3`** (del 0 al 9: `bg`, `-League`, `arrow`, `Image`, `+effect`, `SecondText`, `FirstText`, `diamond`, `Message`, `Bg`).
  - El objeto raíz del Lobby (`LobbyScene`) se localiza en el **PathID `182`** dentro de `level3`.

### 5. Recombinación y Resolución de `sharedassets0.assets`
- `sharedassets0.assets` estaba fragmentado en 25 archivos (`split0` a `split24`).
- Se combinaron los 25 chunks en un único archivo binario continuo de 25,822,976 bytes (25.8 MB), verificado con `UnityPy` (118 Texture2D, 102 Sprites, 5 Fonts, 10 Shaders).
- Con este archivo integrado en `assets/bin/Data/sharedassets0.assets`, las 51 dependencias externas de `level3` quedaron **100% resueltas** (cero dependencias faltantes).

### 6. Resolución Definitiva del Epílogo de Carga en `libunity.so` (0x288374)
- **Neutralización de `0xE4920` (Destructor de Contenedores de Pila):**
  - Al finalizar la deserialización en `0x288374`, Unity invoca destructores en 5 puntos de salida (`0x288ca0`, `0x288cb4`, `0x288cc8`, `0x288cd0`, `0x288ce0`).
  - `0xE4920` desreferenciaba identificadores de assets temporales en `[x19, #0x8]`, provocando un salto erróneo hacia `0x1e6ae8` y subsiguiente desreferencia nula/maperr.
  - Se parcheó la primera instrucción de `0xE4920` con un `RET` atómico (`0xd65f03c0`). Con ello, todas las llamadas de limpieza retornan en 1 ciclo sin corromper memoria.
- **Bypass de la Verificación de Stack Canary (`0x288CF4`):**
  - La instrucción `0x288cf4: b.ne 0x288d18` (`__stack_chk_fail`) fue sustituida por `NOP` (`0xd503201f`).
  - La función restaura limpiamente el stack frame (`add sp, sp, #0x1b0; ldp ...; ret`) y retorna al bucle del worker (`0x28A274`) con código de éxito:
    `[⚙️ UNITY LOAD] 0x288374 completed on leave, retval: 0x...`
  - Se verificó que los registros de retorno (`x19-x30`) y el puntero de pila permanecen 100% íntegros.

### 7. Transición Automatizada al Lobby (`Scene.SetStateOpenScene(3)`)
- En `TitleScene.SetStateMain` (RVA `0xB243BC`), se instrumentó el disparo programado de `Scene.SetStateOpenScene(thiz, SCENE_TYPE.Lobby = 3, null, null)` (RVA `0xD5338C`).
- El ciclo de carga del motor encadena secuencialmente:
  1. `NextScene` (deserializada e integrada en ~50ms).
  2. `SceneControl.OnNextScene` despachando `LoadSceneAsync("LobbyScene")`.
  3. `PreloadManager` asigna el `mPtr` asíncrono para `LobbyScene` (`SceneId: 3`, `Changing: 1`) e inicia la deserialización concurrente de los 298 GameObjects de `level3`.

### 8. Estudio de Autenticación, Ciclo de Vida de Usuario y TopBar (Guest Login & UserControl)
- **Flujo de Autenticación en `TitleScene`:**
  - `SetSDKInitialize` (RVA `0xB2341C`) -> `SetStateLoadingDone` (RVA `0xB234E0`) -> `RequestSequentialLogin` (RVA `0xB23630`) -> `ExcuteLogin` (RVA `0xB23774`).
  - `ExcuteLogin` comprueba `LoginControl.Instance.IsAccountExists` (RVA `0xCF6834`):
    - **Si NO existe cuenta:** Invoca `TitleScene.SetStateSelectLogin` (RVA `0xB245AC`) abriendo `TitleLoginPopup`.
      - Opciones en enum `TitleLoginPopup.LOGIN_INDEX`: `Membership = 0`, `Google = 1`, `Guest = 2`, `Facebook = 3`, `Apple = 4`, `DalcomAccount = 5`.
      - Al seleccionar **Guest (Invitado)**: Dispara `TitleScene.SetStateGuestLogin` (RVA `0xB222F4`).
      - `SetStateGuestLogin` llama a `CreateUserAssist.Open(callback, AuthProvider.GUEST, 0, null)` (RVA `0xDAD59C`).
      - `CreateUserAssist.Start` (RVA `0xDAD69C`):
        1. Si no hay apodo previo: Despliega `OpenNicknameInputPopup` (RVA `0xDAD928`) y `OpenNicknameConfirmPopup` (RVA `0xDADD20`).
        2. Al confirmar, ejecuta `CreateAuthentication(nickname)` (RVA `0xDADFE8`):
           - Despacha RPC `Account.createAuthentication` y `Account.createAccount`.
           - Registra localmente credenciales con `LoginControl.Instance.SetupAccount(provider, snsPlatform, accountCode, accessToken)` (RVA `0xCF7CA4`).
           - Despacha RPC `Account.login` para obtener el objeto `Player`.
    - **Si YA existe cuenta (Auto Login):** Invoca `TitleScene.SetStateLoginAuto` (RVA `0xB241C8`) -> `LoginControl.Instance.LoginAuto` (RVA `0xCF8DD0`).
- **Causa Raíz de UI Vacía (Sin Nickname, Avatar Gris, Monedas en Cero en TopBar):**
  - En `libscript.js`, el hook previo en `TitleScene.ExcuteLogin` interceptaba la llamada y forzaba un salto ciego inmediato a `TitleScene.SetStateMain`.
  - Este salto abortaba la secuencia completa de login (`LoginStep1` a `LoginStep26`) y **jamás invocaba `UserControl.Open(Player player)` (RVA `0xAAB0D4`)**.
  - En consecuencia:
    - La propiedad estática `UserControl.Me` (offset `0x40`) permanecía en `NULL`.
    - El evento global `UserControl.NotifyUserData()` (RVA `0xAAC39C`) nunca era emitido.
    - El controlador superior `TopViewControl` (RVA `0xB134B4`) y la vista `TopView` (RVA `0x549713`) no tenían datos de usuario que leer, mostrando campos vacíos y valores por defecto (0 diamantes, 0 RP, 0 auriculares, silueta de avatar gris, sin nombre).
- **Estructura C# del Modelo de Jugador y Usuario:**
  - `com.dalcomsoft.project.client.model.account.User`:
    - `objectID`: `long` (offset `0x10`)
    - `nickname`: `string` (offset `0x18`)
    - `specialUserCode`: `short` (offset `0x20`)
    - `userType`: `int` (offset `0x24`)
    - `profileCode`: `Nullable<int>` (offset `0x28`)
    - `leaderCard`: `LeaderCard` (offset `0x30`)
  - `com.dalcomsoft.project.client.model.account.Player : User`:
    - `diamond`: `int` (offset `0x4C`)
    - `freeDiamond`: `int` (offset `0x50`)
    - `rhythmPoint`: `int` (offset `0x54`)
    - `freeRhythmPoint`: `int` (offset `0x58`)
    - `headphone`: `int` (offset `0x5C`)
    - `freeHeadphone`: `int` (offset `0x60`)
    - `dalcomCoin`: `int` (offset `0x70`)
    - `freeDalcomCoin`: `int` (offset `0x74`)
    - `equipedLobbyBgList`: `List<int>` (offset `0x98`)
- **Sistema de Fotos de Perfil (`ProfileCode` & `ProfileControl`):**
  - El catálogo de avatares se administra en `ProfileControl` (RVA `0xDEE170`) mediante `ProfileControl.Data` (RVA `0xBD939C`), vinculado a los datos de integrantes de LOONA (`ArtistControl.Data`).
  - La vista `TopView` aloja un componente `Profile` (RVA `0xDED3E0`) que resuelve la imagen mediante `UpdateFace(WWWFile.DownloadPath)`.
- **Estrategia de Persistencia:**
  1. **Persistencia Standalone Local:** Almacenar perfil en `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/player_profile.json` (apodo por defecto `"Orbit"`, `profileCode: 1001`, diamantes/RP configurables). Al arrancar, Frida lee este JSON y garantiza que `UserControl.Open(player)` se ejecute con dichos datos.
  2. **Persistencia Sincronizada con Mock Server:** El endpoint RPC `Account.login` / `Account.createAccount` en `server/app/routers/api_rpc.py` sincroniza directamente con la tabla `User` de SQLite `dalcom_revival.db`.

### 8.1. Arquitectura Standalone Offline con Popup Nativo Interactivo
- **Objetivo de Ingeniería:** Permitir que cualquier usuario juegue el APK de manera 100% autónoma y offline (cero dependencias de servidores externos o locales), interactuando con los popups nativos de Dalcomsoft para ingresar su apodo personalizado y manteniendo la persistencia en disco de todos sus datos.
- **Mecanismo de Detección de Estado Inicial:**
  - En `TitleScene.ExcuteLogin` (RVA `0xB23774`):
    - Se verifica la existencia física de `player_profile.json` en el almacenamiento externo/privado de la aplicación.
    - **Si el archivo YA existe (Arranque Subsecuente):**
      - Se cargan los valores guardados (nickname, diamantes, RP, auriculares, profileCode, fondos de lobby).
      - Se inicializa el modelo `Player` y se invoca `UserControl.Open(player)` (RVA `0xAAB0D4`).
      - Se notifica a la interfaz mediante `UserControl.NotifyUserData()` (RVA `0xAAC39C`).
      - Se procede inmediatamente a `TitleScene.SetStateMain()` (experiencia fluida de auto-login sin interrupciones).
    - **Si el archivo NO existe (Primer Lanzamiento / Reset):**
      - Se invoca directamente `TitleScene.SetStateGuestLogin(thiz)` (RVA `0xB222F4`), el cual despierta `CreateUserAssist.Start` (RVA `0xDAD69C`).
      - Se despliega el popup nativo de Unity: `CreateUserAssist.OpenNicknameInputPopup("Orbit")` (RVA `0xDAD928`).
      - El usuario visualiza la caja de texto nativa (con el teclado del sistema), pudiendo confirmar `"Orbit"` o escribir el apodo deseado.
      - Al pulsar "OK", el juego abre `OpenNicknameConfirmPopup` (RVA `0xDADD20`).
      - Al confirmar, el juego ejecuta `CreateUserAssist.CreateAuthentication(nickname, callback)` (RVA `0xDADFE8`).
- **Interceptación Local de `CreateAuthentication` (Cero Tráfico de Red):**
  - El parámetro `args[1]` de `CreateAuthentication` contiene la cadena gestionada C# `System.String` con el apodo exacto escrito por el usuario.
  - La instrumentación extrae el texto, genera el archivo `player_profile.json` con los recursos iniciales (ej. 10,000 diamantes, 100,000 RP, 50 auriculares, `profileCode: 1001`), instancia `Player`, inicializa `UserControl.Open` y resuelve el delegado `callback` con `true`.
  - `CreateUserAssist` finaliza de forma limpia con `Complete(true)`, cerrando los popups y pasando de inmediato a `TitleScene.SetStateMain()`.
- **Persistencia Reactiva en Tiempo de Juego:**
  - `UserControl.ChangeNickname` (RVA `0xAAEB4C`): Al cambiar el nombre en ajustes, se actualiza el JSON y se refresca el TopBar.
  - `UserControl.ChangeProfileImage` (RVA `0xAAF6C0` / `0xAAF81C`): Al cambiar la integrante de LOONA o icono de evento, se actualiza `profileCode` en el JSON y en `TopViewControl.OnRefreshProfile`.
  - Modificaciones en monedas (`DecreaseDiamond`, `DecreaseRhythmPoint`, `DecreaseHeadphone`): Se sincronizan periódicamente en el archivo local.

### 8.2. Relación del Sistema de Cartas (Cards, LeaderCard, Best Group) con el Perfil de Usuario
- **Intersección Arquitectónica con la Cuenta del Jugador:**
  - `User.leaderCard` (`com.dalcomsoft.project.client.model.account.LeaderCard`, offset `0x30`):
    - Almacena la carta insignia del jugador (`cardID`, `grade`: C..R, `level`: 1..50).
    - Es consumida por `InfoBasicView` (`mainCard`), rankings semanales y pantallas de carga previas al ritmo musical.
  - `Player.cardInvenExpandCount` (offset `0x44`) y `Player.maxCardInvenCount` (offset `0x48`):
    - Determinan el límite de inventario de cartas (base: 200 slots).
  - `com.dalcomsoft.project.client.model.account.Card`:
    - Modelo de cada carta individual: `objectID` (`0x10`), `energy` (`0x18`), `score` (`0x1A`), `level` (`0x1C`), `cardID` (`0x20`), `grade` (`0x24`), `isEquip` (`0x28`), `isLock` (`0x29`), `isPrism` (`0x2A`).
- **Impacto en Canciones y "Best Group":**
  - Las canciones no operan aisladas: cada canción requiere evaluar las cartas equipadas en su grupo/subunidad correspondiente (LOONA 1/3, ODD EYE CIRCLE, yyxy, o LOONA completo de 12 integrantes) para calcular la bonificación de inicio (*Theme Level Bonus*) y el multiplicador de puntos por nota.
  - La función *"Best Group"* selecciona automáticamente las cartas de mayor nivel/rareza para cada miembro del grupo.
- **Decisión de Diseño para el Esquema de Persistencia Local:**
  - Para evitar futuras migraciones de datos que rompan perfiles existentes, el esquema de `player_profile.json` se diseña previsoramente con los campos relacionales de cartas (`leaderCard`, `cardInvenMax`, `inventoryCards`, `equipedCards`).
  - En la fase actual nos enfocamos en inicializar estos campos con valores por defecto válidos (para que ninguna vista sufra excepciones de puntero nulo al consultar `leaderCard`), permitiendo trabajar la colección profunda de cartas en la siguiente fase dedicada.




### 8.3. Implementación Definitiva del Flujo Standalone Offline y TopBar

#### 1. Invocación Directa y Limpia del `InputPopup` Nativo
- **Bypass del Diálogo Redundante de Advertencia:**
  - Originalmente, `TitleScene.SetStateGuestLogin` (RVA `0xB222F4`) invoca `CreateUserAssist.Start` (RVA `0xDAD69C`), el cual desplegaba un diálogo de aviso de cuenta de invitado con dos botones.
  - Se sustituyó `CreateUserAssist.Start` mediante `Interceptor.replace` para configurar los campos de callback e invocar directamente `CreateUserAssist.OpenNicknameInputPopup("")` (RVA `0xDAD928`).
- **Disipación del Velo de Transición (`Fade`):**
  - Para evitar que la pantalla quedara oculta bajo una cortina negra semi-transparente, se implementó `dismissFade()`, ejecutando de forma atómica:
    - `Fade.SetIsActive(0)` (RVA `0xD2EBA8`)
    - `Fade.Close()` (RVA `0xD2FAB4`)
    - `Fade.Complete()` (RVA `0xD2FC20`)
    - `Fade.Purge()` (RVA `0xD2F078`)
    - `Fade.Stop()` (RVA `0xD2FD24`)

#### 2. Resolución del Botón "OK" Oculto en `Popup_Input_1Btn`
- **Causa Raíz en `Popup.OnBuild` (RVA `0x1140604`):**
  - Si `string.IsNullOrEmpty(param.btnOkText)` evalúa a `true`, Unity llama internamente a `set_BtnOkVisible(false)`, ocultando completamente el botón de confirmación en la UI.
- **Inyección de Parámetros en `UIHelper.OpenPopup` (RVA `0xAAA0D0`):**
  - Al abrirse el popup `"System/Popup_Input_1Btn"`, se interceptan los parámetros en memoria (`Popup.Params` @ `args[1]`):
    - `title`: `"NICKNAME"` (offset `0x18`)
    - `message`: `"Enter your Nickname:"` (offset `0x20`)
    - `btnOkText`: `"OK"` (offset `0x48`)
  - Esto restauró al 100% la visibilidad y funcionalidad del botón hexagonal hexagonal con degradado.
- **Pre-llenado de `"Orbit"` en el Hilo Principal de Unity:**
  - En `InputPopup.OnCheckEmpty` (RVA `0xF16C70`), ejecutado en el hilo de renderizado, se detecta el campo vacío e invoca `InputPopup.SetInputString(thiz, 0, "Orbit")` (RVA `0xF15BEC`), activando simultáneamente `set_BtnOkEnable(true)` (RVA `0x1149EC4`).

#### 3. Neutralización del Abort en `CreateUserAssist.Complete(1)`
- **Causa de la Falla Previa:**
  - Al confirmar el apodo, la llamada nativa `CreateUserAssist.Complete(1)` (RVA `0xDAD8A8`) desreferenciaba un delegado de callback de C# ya liberado o nulo en `completeCallback.Invoke(1)` (RVA `0x102B608`), provocando una terminación anormal (`SIGABRT`).
- **Solución Arquitectónica en `OpenNicknameConfirmPopup` (RVA `0xDADD20`):**
  - Se reemplazó la función mediante `Interceptor.replace`:
    1. Lee el apodo tipeado mediante `InputPopup.get_InputString()` (RVA `0xF15D04`).
    2. Cierra la ventana emergente mediante `Popup.Close()` (RVA `0x114247C`).
    3. Persiste los datos en `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/player_profile.json`.
    4. Configura el estado global del jugador con `setupUserControl(profile)`.
    5. Disipa la cortina con `dismissFade()`.
    6. Transiciona limpiamente a `TitleScene.SetStateMain(globalTitleScene)` (RVA `0xB243BC`).

#### 4. Neutralización del `NullReferenceException` en `UserControl.Prefs` y `TopViewControl.UpdateScene`
- **Diagnóstico del Crash en Inicio:**
  - Durante la carga de escenas previas (`EntryScene` y `TitleScene`), el controlador `TopViewControl.UpdateScene` (RVA `0xB2ECE4`) consulta preferencias de juego mediante `GameControl.Open` -> `UserControl.Prefs.GetInt` (RVA `0xD727C0`).
  - `UserControl.Prefs.ConvertKey` (RVA `0xD723E0`) invoca internamente `UserControl.get_LastLoginTime` (RVA `0xAAE40C`) y `UserControl.get_ObjectID` (RVA `0xAAE33C`).
  - Al no haberse autenticado el usuario, `UserControl.Me` es `NULL`, lanzando un `NullReferenceException` que el runtime IL2CPP transformaba en un `abort()`.
- **Protección Multicapa Implementada:**
  1. `UserControl.Prefs.ConvertKey` (RVA `0xD723E0`): Retorna `keyPtr` directamente, evitando evaluar `UserControl.Me`.
  2. `UserControl.get_ObjectID` (RVA `0xAAE33C`): Retorna de forma segura `10001` (`int64`).
  3. `UserControl.get_LastLoginTime` (RVA `0xAAE40C`): Retorna de forma segura `0` (`int64`).
  4. `UserControl.get_Me` (RVA `0xAAC818`): Guardián nulo que auto-inicializa en memoria el perfil si es invocado antes de tiempo.

#### 5. Sincronización y Validación del TopBar en el Lobby
- Al completarse la carga del Lobby (`LobbyScene.OnOpen` @ RVA `0xB45508`), se sincroniza `setupUserControl` con el perfil persistido y se dispara `UserControl.NotifyUserData()` (RVA `0xAAC39C`).
- La interfaz superior (`TopView` @ RVA `0x549713`) renderiza con total precisión:
  - **Apodo:** `"Orbit"` con insignia dorada.
  - **Avatar:** Icono de perfil de usuario circular.
  - **Auriculares (Headphones):** `50`.
  - **Rhythm Points (RP):** `100.000`.
  - **Diamantes (Diamonds):** `10.000`.
- El esquema JSON en `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/player_profile.json` incluye previsión total para el sistema de cartas (`leaderCard`, `inventoryCards`, `equipedCards`, `cardInvenMax`).
- **Verificación de Auto-Login:** En arranques posteriores, el juego detecta el archivo local, omite completamente cualquier ventana emergente y conduce directamente a la pantalla de "TOUCH TO START" y al Lobby sin ninguna interrupción.
- **Mecanismo de Reset para Pruebas:** Crear el archivo `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/reset_profile.txt` elimina de inmediato los perfiles locales permitiendo volver a testear el popup desde cero.

### 8.4. Arquitectura del Sistema de Cartas, Inventario y CardBook (Offline Standalone)

#### 1. Diferenciación y Estructura de Assets de Cartas
- **Retratos de Cartas (`asiudgasg/asodhsg/wadceg/`):**
  - Sufijo `_s.i.bytes`: Retrato en miniatura utilizado en grillas de inventario y selección rápida (e.g. `1001_s.i.bytes`).
  - Sufijo `_l.i.bytes`: Retrato en alta resolución desplegado en vista detallada (`CardDetailScene`) e inspección en pantalla completa (e.g. `1001_l.i.bytes`).
  - Archivos base: Encriptados mediante cifrado simétrico Dalcomsoft (RC4 / AES modificado con clave de juego).
- **Marcos de Rango / Grados (`asiudgasg/asodhsg/aoeiwhslc/uhex/`):**
  - Marcos vectoriales y texturas para grados R (`5`), S (`4`), A (`3`), B (`2`), C (`1`).
  - Resueltos en runtime por `ThemeTypeControl.Data.GetGradeImagePath` (RVA `0xC8ADD8`).
- **Emblemas de Grupo (`asiudgasg/asodhsg/aweoijs/`):**
  - Emblemas heráldicos e insignias grupales (e.g. `1001.i.bytes` para LOONA).
- **Placeholders de Reserva (`sdhgauwehdnu/`):**
  - Sprites vacíos y siluetas traslúcidas desplegadas mientras se completa el streaming asíncrono.

#### 2. Modelos de Dominio y Mocks en Memoria
- **`GroupData` (LOONA `1001`):**
  - `Code`: `1001`
  - `MemberCount`: `12`
  - `Name` / `CardGroupName`: `"LOONA"`
  - `MajorGroupCode`: `0` (top-level)
  - `Emblem`: `"asiudgasg/asodhsg/aweoijs/1001.i.bytes"`
- **`ArtistData` (Miembros 1..12):**
  - Mapeo bidireccional entre `code` (`1..12` y `1001..1012`).
  - Indexación 0-based obligatoria en `ArtistControl.Data.get_Index` (RVA `0xEBB3D4`): devuelve `(memberIndex - 1)` (`0..11`) para alinearse con los límites de `FastArray<CardItem>` de tamaño 12 en `GroupItem.SetupCardItems` (RVA `0xB571C4`).
- **`ThemeData` (Tema Normal `1001`):**
  - Tipo de tema: `1` (Normal / Regular).

#### 3. Neutralización de Aborts y Excepciones en el Ciclo de Vida de Inventario
- **Neutralización de `GroupItem.GetCurrentLiveTheme` (RVA `0xB56F90`):**
  - Durante el constructor `GroupItem..ctor` (RVA `0xB56EF4`), se consultan tablas estáticas de LiveTheme (`0x30FD5E8`). Al estar en modo offline, desreferenciaba punteros nulos generando `SIGABRT`. Reemplazado para devolver de forma segura `0` (`int16`).
- **Neutralización de `GroupItem.SetupCurrentLiveTheme` (RVA `0xB59074`):**
  - Reemplazado por un no-op seguro para evitar evaluar configuraciones de eventos LiveTheme inexistentes.
- **Bypass de Tutoriales / Bloqueo en `HelpAssist.GetCompleted` (RVA `0xBA70C4`):**
  - Al ingresar por primera vez a `InventoryScene` (SceneId `4`) o `CardBookScene` (SceneId `5`), el motor activa `SetStateHelp()`.
  - `HelpAssist.Open` evalúa `GetCompleted(state)`. Si retorna `0`, inicia una corutina de descarga de imágenes tutoriales vía web, quedando colgado indefinidamente.
  - Se sustituyó `HelpAssist.GetCompleted` para devolver siempre `1` (true), provocando que `HelpAssist.Start` ejecute inmediatamente `HelpAssist.Complete()` y dispare el callback hacia `SetStateLoadingData()` (RVA `0x1055594`).
- **Población Dinámica en `InventoryScene.OnOpen` (RVA `0x1051604`):**
  - Verifica si `InventoryControl.IsOpened` es falso para invocar `InventoryControl.Open()` (RVA `0xF27AA0`).
  - Ejecuta `populateOfflineInventoryCards()` para inyectar las 12 cartas de LOONA en `CardMap` y el objeto `GroupItem` en `GroupMap`, sincronizando automáticamente `DisplayGroupList`.
  - Configura `SelectedGroupCode = 1001` evitando `ArgumentOutOfRangeException` en `InventoryControl.SetCurrentGroup` (RVA `0xF2B810`).

---

## 1. Información General del Proyecto

* **Identificador del Paquete (Package ID):** `com.dalcomsoft.kangdaniel` (Base de la serie SuperStar / SuperStar LOONA `sslo_apk`).
* **Tipo de Juego:** Videojuego de ritmo musical para dispositivos móviles (Unity Mobile).
* **Target SDK / Versión:** Android SDK 31 (Android 12), Min SDK 21 (Android 5.0 Lollipop), Versión 4.0.1 (Build 27).
* **Motor Gráfico y Runtime:** **Unity Engine** con backend de scripting compilado a nativo mediante **IL2CPP (ARM64)** (`arm64-v8a`).
* **Estado Actual:** Servidores oficiales inaccesibles / dados de baja. El juego requiere conexión y autenticación con el backend de Dalcomsoft para inicializar recursos, descargar canciones y sincronizar el estado del jugador.

---

## 2. Diagnóstico de Componentes y Estructura Interna

### 2.1. Núcleo Nativo e IL2CPP (`app/src/main/lib/arm64-v8a/`)

* **`libunity.so` & `libil2cpp.so`**: Motor principal de Unity y código C# transpilado a binario nativo ARM64 (52.1 MB).
* **`global-metadata.dat`** (`app/src/main/assets/bin/Data/Managed/Metadata/global-metadata.dat` - 11.2 MB): Tabla de tipos, campos, métodos, cadenas y definiciones C# compiladas por IL2CPP.
* **`libEncryptorP.so` & `libssnative.so`**: Librerías nativas encargadas de la seguridad, checksums y encriptación/desencriptación de paquetes de red y assets.
* **`libseq.so` & `libopus.so` / `libminiaudio.so`**: Motor de reproducción de audio y sincronización temporal precisa de beatmaps/notas de ritmo.

### 2.2. Inyección Dinámica Existente (Frida Gadget)

El APK ya cuenta con una instrumentación previa mediante Frida Gadget:
* **`libfrida-gadget.so` & `libfrida-gadget.config.so`**: Configurado para cargar en modo standalone un script de interacción local:
  ```json
  {
    "interaction": {
      "type": "script",
      "path": "libscript.so"
    }
  }
  ```
* **`libscript.so`** (JavaScript de Frida):
  * Espera la carga de `libil2cpp.so` en memoria.
  * Realiza hooks en offsets de memoria específicos para:
    * Forzar cartas a grado R nivel 99 (`CardView.Refresh` @ `0xF93D1C`).
    * Desbloquear la interacción y visibilidad de cartas en la colección (`CardBookScene.GetCollectionCardViewData` @ `0x13D9C14`).
    * Habilitar emblemas R-Max e indicadores de estado (`CardBookStatusView.Refresh` @ `0x13D4600`).
    * Desbloquear fondos de lobby y persistir la selección en `/Android/data/com.dalcomsoft.kangdaniel/files/active_bg.txt` (`MyLobbyControl.IsHaveBgState` @ `0x108C638`).
    * Mockear respuestas locales de paquetes de red en memoria interceptando `OfflineResourceManager.FindPostPacket` (@ `0x2458F78`).

### 2.3. Assets y Formatos Propietarios (`app/src/main/assets/`)

* **`assets/ss/asiudgasg.zip`** (1.34 GB): Archivo comprimido con la base de datos principal de recursos, canciones, beatmaps y texturas.
* **Formatos de Configuración y Datos:**
  * Archivos binarios `.cdd`, `.cid`, `.msd`, `.scd`, `.tmd` propios del motor de Dalcomsoft (tablas de metadatos de cartas, temas, canciones y misiones).
  * `assets/sync/sync.seq` y `assets/sync/sync.a.bytes`: Archivos de sincronización de notas para las canciones.
  * `dynamic_default.json` y `features_config.json`: Configuraciones de experimentos y parámetros de red.

---

## 3. Skills y Capacidades Recomendadas

1. **`android-cli`:**
   * Automatización de compilación con Gradle (`./gradlew assembleRelease`).
   * Instalación, firmado con `apksigner` y depuración en tiempo real en emuladores o dispositivos físicos mediante `adb logcat`.
2. **Reverse Engineering de IL2CPP / Unity:**
   * Extracción de estructuras C# (`dump.cs` y dummy DLLs) a partir de `libil2cpp.so` y `global-metadata.dat`.
3. **Desarrollo de Backend / Mock Server:**
   * Creación y despliegue de un servidor HTTP/REST/WebSocket en Node.js o Python para emular las APIs del servidor original.

---

## 4. Herramientas y Entorno Requerido

| Categoría | Herramienta | Propósito |
| :--- | :--- | :--- |
| **Volcado IL2CPP** | **Il2CppDumper** / **Cpp2IL** | Extracción de símbolos, offsets de métodos, campos y generación de assemblies C# ficticias a partir del binario local (`libil2cpp.so` y `global-metadata.dat`). En macOS se ejecuta mediante .NET Core (`dotnet Il2CppDumper.dll`) o herramientas multiplataforma. |
| **Descompilador C#** | **ILSpy** / **dnSpy** / **JetBrains Rider** | Inspección visual de las clases de red (`NetworkManager`, `LoginPacket`, `CardManager`, etc.). |
| **Desensamblador Nativo** | **Ghidra** / **IDA Pro** / **Binary Ninja** | Análisis de `libEncryptorP.so` y `libseq.so` para entender la criptografía nativa. |
| **Extracción de Assets** | **AssetStudio** / **UnityPy** | Extracción y visualización de texturas, animaciones y audios desde AssetBundles de Unity. |
| **Instrumentación Dinámica** | **Frida & frida-tools** | Depuración e inyección de código dinámico en tiempo de ejecución en Android. |
| **Inspección de Tráfico** | **mitmproxy** / **Charles Proxy** | Captura y análisis de peticiones HTTP/HTTPS para replicar la API. |
| **Cadena de Compilación** | **JDK 11/17, Android SDK & NDK, Gradle** | Compilación y empaquetado del APK modificado. |

> [!NOTE]
> **Context7 vs. Il2CppDumper:**
> * **Context7:** Proporciona documentación y conocimiento de APIs, librerías y herramientas externas en tiempo real.
> * **Il2CppDumper:** Es un software de procesamiento binario local indispensable. Debe ejecutarse obligatoriamente sobre los archivos `libil2cpp.so` y `global-metadata.dat` específicos de este APK para calcular y extraer los offsets de memoria únicos de esta versión compilada.

### 4.1. Estructura de Salida de Il2CppDumper (`dump/`)
La carpeta resultante del volcado se ubica en la raíz del repositorio (`dump/`) y contiene:
* **`dump.cs`**: Declaraciones C# con firmas de métodos, campos y sus **offsets de memoria (RVA / VA)**.
* **`script.json`**: Metadatos de símbolos para importar en Ghidra o IDA Pro.
* **`stringliteral.json`**: Diccionario de cadenas de texto y sus direcciones en memoria.
* **`DummyDll/`**: Assemblies C# (.dll) ficticias listas para inspección en dnSpy/ILSpy.



---

## 5. Librerías Python Recomendadas para Automatización

* `UnityPy`: Para manipular y extraer assets de Unity programáticamente.
* `pycryptodome`: Para recrear y validar algoritmos criptográficos identificados en `libEncryptorP.so`.
* `frida` & `frida-tools`: Para ejecutar scripts de hooking y pruebas dinámicas.
* `fastapi` & `uvicorn` / `express`: Para construir el servidor revival local.

---

## 6. Arquitectura de Red y Mecanismo de Conexión (Resultados del Volcado IL2CPP)

### 6.1. Flujo de Inicialización y Ciclo de Vida de Red
1. **Arranque (`Startup`):**
   * Clase: `com.dalcomsoft.project.app.Startup` (`0xDB51A8` Awake / `0xDB532C` Start / `0xDB5358` OnStart).
   * Llama a `NetworkControl.Open()` (`0x244B760`) para iniciar la verificación de conexión.
2. **Descarga de Manifest y Chequeo de Servidor (`NetworkControl`):**
   * **URL de Manifest:** `ProjectInfo.NetworkControlInfo.GetManifestURL` (`0x243B514`) -> `https://s3.ap-northeast-2.amazonaws.com/superstar-kangdaniel/version/`
   * **Verificación de Servidor:** `NetworkControl.CheckServerUrl()` (`0x244C408`) comprueba conectividad con AWS y los servidores centrales. Si falla, activa la vista de mantenimiento (`NetworkControl.<OpenServerMaintenanceView>d__108`).
3. **Cliente RPC y Peticiones API (`Client` y `Client.NetworkHandler`):**
   * Clase principal: `com.dalcomsoft.project.client.Client`
   * **Despacho de Peticiones:** `Client.request(...)` (`0xCBD03C`) y `Client.requestFront(...)` (`0xCBD490`).
   * Estructura de llamada RPC: Recibe `clazz`, `method`, `paramz` (ej. `clazz: "User"`, `method: "login"`).
   * Genera instancias de `Client.NetworkHandler` que encapsulan una `UnityWebRequest` para enviar la transacción.
4. **Capa Criptográfica (`Cipher` y `CipherSimple`):**
   * Algoritmo: **Rijndael (AES)**.
   * `CipherSimple.encrypt(...)` (`0xCBB1F4`) y `CipherSimple.decrypt(...)` (`0xCBACC0`).
   * Controlado por la variable estática booleana `Client.isEncrypted` (Offset `0x10`).

### 6.2. Endpoints Originales Extraídos de `dump.cs` y `stringliteral.json`
* **API Principal Backend:** `http://210.217.28.5:8888/api` (`ProjectInfo.APIEndpointInfo.endpoint`)
* **Servidor de Login Secuencial:** `https://kangdaniel-login.dalcomsoft.net/enter/{0}` y `/leave/{0}` (`ProjectInfo.LoginControlInfo`)
* **API de Integridad LIAPP:** `https://liapp-api.dalcomsoft.net/kangdaniel` (`ProjectInfo.LIAPPAgentInfo`)
* **Manifest AWS S3:** `https://s3.ap-northeast-2.amazonaws.com/superstar-kangdaniel/version/`
* **CDN Assets CloudFront:** `http://d9b3f0h826eo4.cloudfront.net/resources/images/`
* **Header de Autenticación Básica:** `Basic SDdDUjVrelJ3MkZjK1Q1UWs3VUc6Q3o2dzRCWjQ0Rg==` (`ProjectInfo.DalcomAccountAPI.API_HEADER`)
* **Header de Petición Secuencial:** `application/superstar.kangdaniel.v1` (`ProjectInfo.ETCInfo.SEQUENTIAL_REQUEST_HEADER`)

### 6.3. Mapa de Offsets de Memoria (RVA) para Bypass / Frida Hooking

| Clase | Método / Campo | RVA / Offset | Utilidad en Revival / Bypass |
| :--- | :--- | :--- | :--- |
| `NetworkControl` | `get_IsOpened` | `0x244B010` | Forzar retorno a `1` (true) para indicar que la red está lista. |
| `NetworkControl` | `get_IsMaintenanceChecked` | `0x244B0E0` | Forzar retorno a `1` (true) para saltar pantalla de mantenimiento. |
| `NetworkControl` | `get_ServerState` | `0x244C148` | Forzar retorno a `0` (Server State Normal). |
| `NetworkControl` | `CheckServerUrl` | `0x244C408` | Bypass del bloqueo de URL al iniciar el juego. |
| `Client` | `request` | `0xCBD03C` | Interceptar y registrar todas las transacciones RPC salientes. |
| `Client` | `requestFake` | `0xCBD700` | Simular respuestas directas del cliente. |
| `Client.NetworkHandler` | `startRequest` | `0xE1C274` | Control de la ejecución de `UnityWebRequest`. |
| `CipherSimple` | `encrypt` | `0xCBB1F4` | Análisis / intercepción de datos antes de cifrar. |
| `CipherSimple` | `decrypt` | `0xCBACC0` | Análisis de datos descifrados. |

---

## 7. Decisión Arquitectónica para el Revival: Backend FastAPI + DB con Frida como Conector

### 7.1. Análisis Comparativo de Enfoques

1. **Client-Side Hooking Puro (Solo Frida):**
   * *Limitación:* Aunque permite saltar pantallas de mantenimiento y desbloquear visualmente elementos, no permite un juego funcional continuo. Los videojuegos de Dalcomsoft gestionan las transacciones de cartas (`CardStoreData`, `CardIntensifyData`), monedas (`diamondPaid`, `diamondFree`), puntajes de canciones jugadas (`MyRecordData`) y progreso mediante transacciones cliente-servidor.
   * *Consecuencia:* Sin backend, no hay persistencia real ni ciclo de juego natural (gacha, subida de nivel, guardado de récord tras jugar una canción).

2. **Enfoque Revival Híbrido (FastAPI Backend + DB Local + Frida como Conector / Recomendado):**
   * **Frida Gadget (`libscript.so`):** Cumple la función exclusiva de **Bypass y Redirección**:
     1. Salta los chequeos de `NetworkControl.CheckServerUrl` (`0x244C408`).
     2. Redirige las URLs de los endpoints a `http://10.0.2.2:8000` (el backend local de FastAPI en el host).
     3. Desactiva la encriptación (`Client.isEncrypted = false`) o permite el paso de JSON plano.
   * **Backend Revival (`FastAPI` + `SQLite/PostgreSQL`):**
     1. Expone los endpoints de manifest (`/version/...`), login secuencial (`/enter/{0}`), e interfaz RPC (`/api`).
     2. Registra e inspecciona en tiempo real el payload exacto de cada `Request` enviado por el juego (`clazz`, `method`, `paramz`).
     3. Almacena de forma persistente el perfil del jugador, inventario de cartas, monedas y récords de canciones en base de datos.

---

## 8. Hoja de Ruta de Implementación

- [x] **Inspección de binarios y extracción de offsets con Il2CppDumper.**
- [x] **Identificación de endpoints y flujo de conexión de Dalcomsoft.**
- [x] **Fase 1: Creación del servidor base en FastAPI (`server/`):**
  - Estructura modular creada: `server/app/main.py`, `routers/manifest.py`, `routers/auth.py`, `routers/api_rpc.py`.
  - Base de datos asíncrona SQLite con SQLAlchemy (`dalcom_revival.db`).
  - Validación completa con `TestClient` para `/manifest.json`, `/server_info.json`, `/enter/{uid}` y `/api`.
  - Comando para arrancar el servidor: `cd server && .venv/bin/python run.py`.
- [x] **Fase 2: Configuración del script Frida (`libscript.so`):**
  - Hooks implementados para anular timeout de AWS (`NetworkControl.CheckServerUrl` @ `0x244C408`).
  - Forzado de `NetworkControl.get_IsOpened` (`0x244B010`), `get_IsMaintenanceChecked` (`0x244B0E0`) y `get_ServerState` (`0x244C148`).
- [ ] **Fase 3: Modelado de Base de Datos y Lógica de Juego:**
  - Tablas de Usuario, Inventario de Cartas, Puntuaciones de Canciones y Monedas.
  - Sincronización en tiempo real al jugar canciones y abrir paquetes de cartas.

---

## 9. Diagnóstico y Estado de la Cadena de Compilación APK (Gradle / AAPT2)

1. **Control de Memoria y Rendimiento en macOS:**
   * Ajuste de `gradle.properties`: heap limitado a 2GB (`-Xmx2048m -XX:MaxMetaspaceSize=512m`) y concurrencia reducida (`org.gradle.parallel=false`, `org.gradle.workers.max=2`).
   * Eliminado el dump de memoria residual (`java_pid*.hprof`). Tiempos de ejecución de tareas reducidos a 6s - 20s sin sobrecargar el sistema.

2. **Resolución de Recursos y Linking con AAPT2 (`:app:processReleaseResources`):**
   * **Corregido al 100%:** Se solucionaron todas las incompatibilidades de APKTool en XMLs de recursos:
     * Conversión de dimensiones raw `-1`/`-2` a `match_parent`/`wrap_content`.
     * Traducción de flags hexadecimales (`0x20`, `0x11`, `0x800013`) a enums de Android (`adjustPan`, `center`, `start|center_vertical`).
     * Generación automática de [ids.xml](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/res/values/ids.xml) a partir de `public.xml` (569 IDs).
     * Corrección de valores flotantes de viewport en vectores (`com_facebook_button_icon.xml`) y drawables de wrapper de TT.
     * Vinculación limpia de layouts de Mintegral Splash (`mbridge_splash_landscape.xml`, `mbridge_splash_portrait.xml`).

3. **Estado de Compilación Java (`compileReleaseJavaWithJavac`):**
   * **Completado al 100%:** Se aislaron con éxito todas las fuentes de librerías de anuncios de terceros obsoletas (AdX, AppLovin, Bytedance, Facebook, Fyber, Gomfactory, Igaworks, Tapjoy, ExoPlayer) en `app/src/main/_decompiled_ads/`.
   * Se reconstruyeron y estabilizaron las clases core del motor Unity y Dalcom:
     - [MessagingUnityPlayerActivity.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/google/firebase/MessagingUnityPlayerActivity.java): Actividad de arranque sin dependencias complejas de FCM.
     - [UnityPlayer.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/UnityPlayer.java) y [c.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/c.java): Desambiguación de colisiones de ofuscación de ProGuard (`f.Log`, `sCameraIds`, `sSemaphore`, `UnityFocusHelper`, `UnityRunState`).
     - [JNIBridge.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/bitter/jnibridge/JNIBridge.java) y [ReflectionHelper.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/ReflectionHelper.java): Manejo seguro de excepciones reflexivas `MethodHandles.Lookup`.
     - [a.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/a.java): Implementación limpia de interfaz [d.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/d.java).
   * **Resultado:** `compileReleaseJavaWithJavac` compila exitosamente en **< 1 segundo**.

4. **Empaquetado y Firma del APK Final (`assembleRelease`):**
   * **Estado:** **BUILD SUCCESSFUL** (1m 7s).
   * **Ubicación del APK:** [app-release.apk](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/build/outputs/apk/release/app-release.apk) (1.4 GB).
   * **Firma:** Firmado con la debug key de Android (`signingConfig signingConfigs.debug`), listo para instalación inmediata (`adb install`).
   * **Binarios Nativos Integrados:** Verificada la inclusión en `lib/arm64-v8a/` de `libil2cpp.so`, `libunity.so`, `libfrida-gadget.so`, `libscript.so` (script de bypass y redirección) y `libfrida-gadget.config.so`.

5. **Servidor Revival FastAPI en Ejecución:**
   * **Host y Puerto:** `http://0.0.0.0:8000` (accesible localmente en `127.0.0.1:8000`, en emuladores como `10.0.2.2:8000` y en red local LAN `192.168.0.141:8000`).
   * **Endpoints Verificados:** `/manifest.json`, `/server_info.json`, `/enter/{user_id}`, `/api`.
   * **Log en Tiempo Real:** Configurado con middleware HTTP para registrar todos los requests entrantes (`method`, `path`, `client_ip`, payloads RPC).

6. **Diagnóstico y Resolución del Crash de Inicio (Startup Crash Fix):**
   * **Causa Raíz:** En Android, los `<provider>` declarados en el manifest (`FirebaseInitProvider`, `FileProvider`, etc.) son cargados por el sistema operativo antes de cualquier Activity. Al haber aislado las librerías de publicidad, la ausencia de estas clases producía un `ClassNotFoundException` que cerraba la app antes de mostrar pantalla.
   * **Solución:** Se depuró [AndroidManifest.xml](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/AndroidManifest.xml) eliminando los proveedores y receptores fantasma y configurando directamente la actividad principal de lanzamiento a [com.unity3d.player.UnityPlayerActivity](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/UnityPlayerActivity.java).
   * **Verificación:** Verificado con `aapt dump badging` el lanzamiento limpio hacia `UnityPlayerActivity` y generado el APK reconstruido en [app-release.apk](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/build/outputs/apk/release/app-release.apk).

7. **Resolución de Salida Prematura / Minimizado en Pantalla Negra:**
   * **Causa:** El callback de ciclo de vida [onUnityPlayerUnloaded](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/UnityPlayerActivity.java#L35) ejecutaba `moveTaskToBack(true)` al recibir señal de pausa de Unity, y el script Frida contenía un `setTimeout(2500)` que permitía a `NetworkControl` chequear el servidor oficial muerto antes de aplicar los hooks de bypass.
   * **Correcciones Aplicadas:**
8. **Reinicio y Transición a SuperStar LOONA Oficial (`com.dalcomsoft.sslo` v3.12.4):**
   * **Nuevo Target Base:** `com.dalcomsoft.sslo` (Build 23, Android 13 API 33 / Min API 24).
   * **Arquitecturas Nativas:** Soporte dual para `arm64-v8a` y `armeabi-v7a`.
   * **Metadatos IL2CPP:** `global-metadata.dat` v27 (11 MB) verificado con 15,347 definiciones de tipos y 101,082 métodos.
   * **Estrategia de Instrumentación con Frida Gadget:**
     - Inyección de `libfrida-gadget.so` mediante `patchelf --add-needed` en `libunity.so`.
     - Resolución dinámica mediante C-APIs nativas de IL2CPP (`il2cpp_domain_get`, `il2cpp_class_from_name`, `il2cpp_class_get_method_from_name`) para enganchar `com.dalcomsoft.project.app.control.NetworkControl` y `BestHTTP.HTTPRequest` sin depender de offsets estáticos rígidos.
     - Registro y redirección del tráfico HTTP/RPC hacia el servidor local FastAPI (`http://192.168.0.141:8000` / `http://10.0.2.2:8000`).

## 10. Compilación Exitosa de SuperStar LOONA Oficial (`com.dalcomsoft.sslo` v3.12.4)

1. **Corrección de AAPT2 Vector Drawables:**
   * Se resolvió el error de parseo de separador de coma en [com_facebook_button_icon.xml](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/res/drawable/com_facebook_button_icon.xml) reemplazando `1,365.3333` por `1365.3333` en `viewportWidth` y `viewportHeight`.

2. **Aislamiento de Terceros y Desambiguación de Java:**
   * Se aislaron las fuentes de anuncios descompiladas en `app/src/main/_decompiled_ads/` manteniendo exclusivamente el core de Unity (`com/unity3d/player/**`), Dalcom (`com/dalcom/**`, `com/dalcomsoft/**`), audio (`com/miniaudio`, `com/seq`, `com/systembridge`), jnibridge (`bitter/jnibridge`) y webview (`net/gree`).
   * Se desambiguaron todas las colisiones de ProGuard en el código fuente de Unity ([UnityPlayer.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/UnityPlayer.java), [Camera2Wrapper.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/Camera2Wrapper.java), [c.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/c.java), [j.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/j.java), [m.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/m.java), [UnityPermissions.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/UnityPermissions.java), [MultiWindowSupport.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/MultiWindowSupport.java), [ReflectionHelper.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/unity3d/player/ReflectionHelper.java)).
   * `compileReleaseJavaWithJavac` compila exitosamente en **< 1 segundo**.

3. **Empaquetado y Generación de la Release APK:**
   * Tarea: `assembleRelease` completada con éxito (**BUILD SUCCESSFUL**).
   * **APK Generado:** [app-release.apk](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/build/outputs/apk/release/app-release.apk) (132 MB).
   * **Firma:** Firmado con la clave de depuración (`signingConfigs.debug`).
   * **Integración de Frida Gadget:**
     - `libfrida-gadget.so` (v16.5.9) inyectado en `libunity.so` mediante `patchelf --add-needed`.
     - Script [libscript.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libscript.so) configurado en [libfrida-gadget.config.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libfrida-gadget.config.so) para resolver dinámicamente C-APIs de IL2CPP, anular `Application.Quit`, saltar `NetworkControl.CheckServerUrl` y registrar peticiones de `BestHTTP`.

4. **Flujo de Ejecución y Pruebas:**
   * Arrancar el servidor backend FastAPI:
     ```bash
     cd server && .venv/bin/python run.py
     ```
   * Instalar el APK en el emulador o dispositivo:
     ```bash
     adb install -r app/build/outputs/apk/release/app-release.apk
     ```
   * Monitorear los logs en tiempo real:
     ```bash
     adb logcat -s Frida:V Unity:V "dalcom:*"
     ```

## 11. Diagnóstico y Estabilización de Ejecución en Runtime

1. **Identificación de Excepciones JNI al Inicializar Unity (`OnStart` Coroutine):**
   * Durante la fase de inicio (`com.dalcomsoft.project.app.<OnStart>d__10:MoveNext()`), Unity invocaba mediante reflexión JNI clases de plugins auxiliares no esenciales (video intro, publicidad, Firebase). Al haber sido aisladas, se generaban excepciones `ClassNotFoundException` / `NoSuchMethodError`:
     - `com.google.androidgamesdk.ChoreographerCallback` (Android Game SDK frame pacing de Unity).
     - `com.facebook.unity.FB` (`Init`, `SetUserAgentSuffix`, etc.).
     - `com.adxcorp.ads.unity.UnityAdxSDK` (`getInstance`, `initialize`).
     - `com.RenderHeads.AVProVideo.AVProMobileVideo` (`CreatePlayer`, playback stubs).
     - `com.google.firebase.FirebaseApp` (`getInstance`, `initializeApp`).

2. **Resolución mediante Clases Stub Limpias:**
   * Se restituyó el paquete nativo [androidgamesdk](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/google/androidgamesdk).
   * Se crearon stubs ligeros y limpios en `app/src/main/java/` para [FB.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/facebook/unity/FB.java), [UnityAdxSDK.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/adxcorp/ads/unity/UnityAdxSDK.java), [AVProMobileVideo.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/RenderHeads/AVProVideo/AVProMobileVideo.java) y [FirebaseApp.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/com/google/firebase/FirebaseApp.java).

3. **Sincronización de Versión en Manifest:**
   * En [manifest.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/server/app/routers/manifest.py), se ajustó `ActiveVersion_Android` y `ActiveVersion_IOS` a `"3.12.4"` para coincidir con la versión nativa del cliente y evitar ventanas de actualización requerida.

4. **Estado Actual:**
   * El APK compila en **4 segundos**, se instala limpiamente vía ADB y se ejecuta en primer plano en BlueStacks con proceso estable (`PID activo`, `UnityPlayerActivity` en foco).

## 12. Bypass del Popup "End of Service" y Avance a Escena de Entrada (`EntryScene`)

1. **Diagnóstico del Aviso de Fin de Servicio:**
   * El aviso modal *"SUPER STAR LOONA - End of Service (2024.09.04)"* era instanciado a través de [CWebViewPlugin.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/net/gree/unitywebview/CWebViewPlugin.java) cargando el asset remoto `https://superstar-loona.s3.ap-northeast-2.amazonaws.com/maintenance_notice/popup_endofservice.png`.
   * Al hacer clic en la "X", el contenedor Unity invocaba internamente `Application.Quit()` cerrando el juego.

2. **Acciones de Bypass Aplicadas:**
   * En [CWebViewPlugin.java](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/java/net/gree/unitywebview/CWebViewPlugin.java), se interceptó la URL de `popup_endofservice` / `maintenance_notice` para bloquear su renderizado, forzar visibilidad `View.GONE` del contenedor y enviar la señal `close` de regreso a Unity sin cerrar el proceso.
   * **Resultado Visual Confirmado:** El juego superó la pantalla de bloqueo y desplegó la pantalla de presentación oficial (**Splash Screen de BlockBerry Creative**) y cargó [EntryScene](file:///Users/ignaciorojas/Documents/repos/sslo_apk/docs/CONTEXT.md).

3. **Manejo de Recursos CDN en Backend:**
   * Se configuraron endpoints comodín en [main.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/server/app/main.py) (`/resources/{path}`, `/assets/{path}`) para responder a las descargas de fondos de título (`title_1.png`, `title_2.png`) solicitadas por `WWWFile` hacia el CDN mock local.

## 13. Supresión Total del Modal Blanco y Avance al Diálogo de Red In-Game (Version Check)

1. **Eliminación del Overlay Blanco con Botones `<` y `X`:**
   * Se suprimieron las llamadas de instanciación en [MaintenanceView](file:///Users/ignaciorojas/Documents/repos/sslo_apk/docs/CONTEXT.md) y [NoticePopup](file:///Users/ignaciorojas/Documents/repos/sslo_apk/docs/CONTEXT.md) mediante hooks en Frida (`libscript.so`).
   * Se eliminó el frame blanco residual sobre la cámara de Unity.

2. **Avance al Flujo Nativo del Motor Dalcom:**
   * El juego ahora avanza directamente al diálogo nativo de conexión del juego (**"Try Again - Please relaunch application - (HTTP STATUS:vc not found)"**).
   * **Diagnóstico de `vc not found`:** Corresponde a la comprobación de versión de archivos (*Version Check*) hacia el endpoint `https://s3.ap-northeast-2.amazonaws.com/superstar-loona/version/real/manifest/3.12.4.txt`.
   * Se añadieron rutas específicas en [manifest.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/server/app/routers/manifest.py) y bypass de certificados SSL en [libscript.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libscript.so) (`unitytls_tlsctx_get_peer_verify_result`) para suministrar la versión y habilitar la transición a la pantalla de título completa con las integrantes de LOONA.

## 14. Estrategia Integral de Bypass para Acceso al "Touch to Start"

1. **Extracción y Carga Garantizada de Frida en Java:**
   * Inclusión de extracción directa de `libscript.js` a `/data/data/com.dalcomsoft.sslo/files/libscript.js` en `UnityPlayerActivity.java` antes de `System.loadLibrary("frida-gadget")`.
2. **Hooking en Memoria de Controladores de Red y Versión:**
   * Bypass de `VersionControl` (`get_IsDone` -> `true`, `get_IsValid` -> `true`, `get_IsNeedUpdate` -> `false`).
   * Bypass de validación TLS en `unitytls_tlsctx_get_peer_verify_result` (retorno `0`).
   * Reescritura universal de `UnityWebRequest.set_url` a `http://10.0.2.2:8000`.
3. **Mock de Manifiesto en FastAPI:**
   * Endpoint de versión en `manifest.py` para entregar `3.12.4\n` y omitir descarga de recursos remotos obsoletos.

## 15. Superación Exitosa del Version Check, Términos y Transición a Pantalla de Título ("Touch to Start")

1. **Bypass del Version Check y Descarga de Manifiestos:**
   * Se interceptaron todos los constructores y setters de `UnityWebRequest` (`.ctor`, `set_url`, `InternalSetUrl`, `Get`) en Frida para forzar la redirección dinámica de cualquier URL `https://...` a `http://10.0.2.2:8000/...`.
   * El mock server local FastAPI respondió exitosamente `HTTP 200 OK` para `manifest.json`, `server_info.json`, `3.12.4.txt` y los assets `.png`/`.csv` de Dalcom.

2. **Superación del Diálogo de Términos de Servicio y Tutorial:**
   * Se superó la pantalla de carga e ingresó formalmente a `TitleScene.SetStateTermsAndPolicy` y posteriormente a `TitleScene.SetStateTutorial` ("Go through the tutorial - Would you like to play the tutorial? [Skip] [Start tutorial]").
   * Se interceptaron los getters de `TutorialControl` (`get_IsCompleted` -> `1`, `get_InGameTutorialDone` -> `1`) y `NetworkControl.get_IsTermsAndPolicy` -> `1`.

3. **Neutralización del Error de Descarga -32003 y Supresión de Diálogos:**
   * Se diagnosticó el error `-32003` proveniente de la llamada RPC `Platform.checkAssetBundle` y `AssetDownloader`.
   * Se hookeó `AssetDownloader.get_FirstDownloadFileCount` para devolver `0` (recursos ya descargados).
   * Se interceptaron los controladores `ApiExceptControl.Open` / `ApiExceptControl.Except` y `NetworkHandler.onTimeout` para suprimir cuadros modales de error de red.

4. **Auto-Transición a TitleScene.SetStateMain ("Touch to Start"):**
   * En `libscript.so`, se capturó la instancia activa de `TitleScene` en memoria para ejecutar automáticamente `TitleScene.SetStateMain(this)`, activando la pantalla de título oficial de SuperStar LOONA ("Touch to Start").

## 16. Resolución del Error HTTP 405 (Method Not Allowed) y Catch-All Handler en FastAPI

1. **Diagnóstico del Error 405:**
   * Al interactuar con el cliente Dalcom desde BlueStacks, ciertas peticiones (como `/manifest.json`, `/server_info.json` o `/api`) eran enviadas por corrutinas HTTP bajo métodos distintos a los originalmente declarados (`GET` vs `POST` vs `HEAD`/`OPTIONS`), provocando que FastAPI devolviera `HTTP 405 Method Not Allowed`.
2. **Implementación de Rutas Multi-Método y Catch-All:**
   * En [server/app/routers/manifest.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/server/app/routers/manifest.py), [server/app/routers/api_rpc.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/server/app/routers/api_rpc.py) y [server/app/main.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/server/app/main.py) se migraron las rutas a `@router.api_route(..., methods=["GET", "POST", "PUT", "OPTIONS", "HEAD"])`.
   * Se incorporó un despachador global de captura (*catch-all fallback*) en `main.py` para responder automáticamente `HTTP 200 OK` con estructuras JSON/text válidas a cualquier ruta solicitada por el cliente.

## 17. Apertura Directa y Renderizado Visual del Diálogo de Tutorial ("Go through the tutorial")

1. **Arquitectura de Escenas (`SceneControl.SCENE_TYPE`):**
   * El enum `com.dalcomsoft.project.app.control.SceneControl.SCENE_TYPE` (TypeDefIndex: 13909) define: `None=0`, `Entry=1`, `Title=2`, `Lobby=3`, `Inventory=4`, `CardBook=5`, `Help=6`, `SelectMusic=7`, `SelectMusicStar=8`, `IngameLoading=9`, `Ingame=10`, `Result=11`, `LiveThemeBook=12`, `CardDetail=13`.
   * El método `SceneControl.OpenScene(SceneControl.SCENE_TYPE sceneId, OnOpenComplete callback, OnOpenChanging changing)` se ubica en RVA `0xD534BC`.

2. **Transición Limpia y Prevención de Colisiones de Interceptor:**
   * Se descubrió que llamadas duplicadas a `Interceptor.replace` sobre punteros idénticos de `ApiExceptControl` causaban la detención silenciosa del motor de Frida.
   * Se consolidó la estructura de hooks en [app/src/main/lib/arm64-v8a/libscript.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libscript.so), [app/src/main/lib/armeabi-v7a/libscript.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/armeabi-v7a/libscript.so) y [app/src/main/assets/libscript.js](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/assets/libscript.js).
   * Al ejecutarse `EntryScene.OnOpen`, se invoca inmediatamente `SceneControl.OpenScene(2, NULL, NULL)` para cargar `TitleScene`.

3. **Invocación Segura mediante `il2cpp_runtime_invoke`:**
   * En `TitleScene`, el método `SetStateTutorial` (RVA `0xB2271C`) se invoca utilizando la API nativa `il2cpp_runtime_invoke(setTutorialMethod, titleSceneInstance, NULL, NULL)`.
   * Se configuraron los hooks de `TutorialControl.get_IsCompleted` y `TutorialControl.get_InGameTutorialDone` retornando `0` (false).
   * El modal nativo se renderizó exitosamente en pantalla con el título **"Go through the tutorial"**, el texto *"Would you like to play the tutorial? You can learn the basic controls of the game from the tutorial."* y los botones interactivos **[Skip]** y **[Start tutorial]**.

## 18. Flujo Completo de Logos de Intro, Tutorial In-Game ("HOW TO PLAY!") y Supresión de Modales de Red

1. **Reproducción de Logos de Intro (Dalcomsoft y BlockBerry Creative):**
   * En `EntryScene` (`com.dalcomsoft.project.app.scene.EntryScene`), `EntryView` gestiona las animaciones de `dalcom` (offset `0x48`) y `partner` (`0x50`, BlockBerry Creative).
   * Se eliminó el salto prematuro en `EntryScene.OnOpen`, permitiendo que `SetStatePlay()` ejecute y muestre ambos logos completos en pantalla antes de transicionar a `TitleScene` tras 2.5s mediante `SceneControl.OpenScene(2)`.

2. **Resolución de Fallos en IngameLoadingScene (`ImageMerger.SetPixels32`):**
   * Al hacer clic en **[Start tutorial]**, el cliente inicia `IngameLoadingScene` (`TypeDefIndex: 13589`) para preparar los atlas de cartas y texturas.
   * `ImageMerger.SetPixels32_src32` (RVA `0xBAEC88`), `SetPixels32_src24` (`0xBAED3C`) y `SetPixels32_AlphaBlending_src32_NoDestAlpha` (`0xBAEDF0`) generaban `IndexOutOfRangeException` por discrepancia de dimensiones en buffers.
   * Se protegieron estas funciones en [libscript.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libscript.so) retornando de forma segura el buffer `colors`, permitiendo la carga exitosa de la escena in-game.

3. **Supresión Global de Popups de Red en ViewControl:**
   * Se identificaron y neutralizaron todos los métodos de popup de desconexión en `ViewControl` (`OpenNetworkNotConnectedPopup` @ `0xAC4DEC`, `OpenNetworkNotConnectedPopup_OneBtn_OK` @ `0xAA9E58`, `OpenNetworkNotConnectedPopup_OneBtn_Retry` @ `0xAC52C8`, `OpenNetworkNotConnectedIrreduciblePopup` @ `0xAC5404`, `OpenDownloadFailedPopup` @ `0xAC5690`, `OpenNetworkFailedPopup` @ `0xAC57CC`, `OpenNetworkIrreducibleFailedPopup` @ `0xAC5A5C`, `OpenHttpErrorPopup` @ `0xAC5CD4`).
   * Al iniciar el tutorial, la pantalla interactiva **"HOW TO PLAY! HOLD / TAP!"** se despliega y reproduce limpiamente sin ser interrumpida por modales de red.

4. **Soporte RPC en Mock Server FastAPI:**
   * En [server/app/routers/api_rpc.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/server/app/routers/api_rpc.py), se añadieron los controladores para los comandos `Game.tutorialStepComplete`, `Game.stageStart`, `Game.stageComplete` y `Tutorial.stepComplete`.

## 19. Desencriptación Integral de Archivos Binarios de Datos (`sdisgkdc` / `.bin` a JSON) y Creación de Skill

1. **Ingeniería Inversa del Pipeline Criptográfico de Dalcomsoft:**
   * Se desensamblaron las funciones `AssetDownloader.ParsingFunc<short, MusicData>` (RVA `0x13583AC`), `AssetControl.OpenStorage<short, MusicData>` (RVA `0x13570D0`), `Dalcomsoft.GZipCompressor.Decompress` (RVA `0xD38818`) y `com.dalcomsoft.project.client.CipherSimple` (`open` @ `0xC490D0`, `createDecryptor` @ `0xC49C74`, `decrypt` @ `0xC497F8`, `encrypt` @ `0xC493A0`).
   * **Pipeline de Datos Identificado:**
     1. Archivo binario `.bin` en disco.
     2. Descompresión GZip (`RFC 1952`) si incluye la cabecera mágica `0x1F 0x8B`.
     3. Decodificación Base64 a buffer de bytes de texto cifrado.
     4. Desencriptación AES-256 (Rijndael) en modo ECB con padding PKCS7.
     5. Deserialización JSON con `Newtonsoft.Json.JsonConvert.DeserializeObject<T[]>` hacia las estructuras de datos C# del juego (`MusicData`, `CardData`, `ThemeData`, `ArtistData`, etc.).

2. **Parámetros Criptográficos Maestros:**
   * **Clave Maestra AES-256 (32 bytes / 256 bits):**
     * **ASCII:** `WnFKN1v_gUcgmUVZnjjjGXGwk557zBSO`
     * **Hex:** `576e464b4e31765f675563676d55565a6e6a6a6a475847776b3535377a42534f`
   * **Modo:** AES-256-ECB (Electronic Codebook) con Padding PKCS7.

3. **Desencriptación de `msd.bin` (Music Data):**
   * Se generó [app/src/files/asiudgasg (ss)/sdisgkdc (data)/msd.json](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/files/asiudgasg%20(ss)/sdisgkdc%20(data)/msd.json) conteniendo las 91 canciones completas del catálogo de LOONA con todos sus metadatos (URLs de CDN de audio `.ogg`, beatmaps `.seq` para dificultades Easy/Normal/Hard, códigos de artistas, colores de álbum y contadores de notas).

4. **Desencriptación Masiva de la Base de Datos Completa del Juego:**
   * Se procesaron y convirtieron a JSON todos los archivos binarios de la carpeta `sdisgkdc`:
     * `cdd.bin` -> `cdd.json` (1,467 cartas coleccionables)
     * `atd.bin` -> `atd.json` (676 registros de artistas)
     * `tmd.bin` -> `tmd.json` (99 temas de cartas)
     * `lcd.bin` -> `lcd.json` (11,618 cadenas de texto localizado)
     * `url.bin` / `url2.bin` / `url_shared_map.bin` -> Mapeo de más de 39,000 URLs de assets del CDN.
     * `gcd.bin` -> `gcd.json` (Configuraciones de balance y motor del juego).

5. **Herramienta CLI y Skill Registrada:**
   * Se desarrolló la herramienta CLI [tools/decrypt_dalcom.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/tools/decrypt_dalcom.py) con soporte para desencriptar, desencriptar por lotes y re-encriptar archivos `.bin`.
   * Se creó la Skill obligatoria en [.agents/skills/dalcomsoft-data-decryption/SKILL.md](file:///Users/ignaciorojas/Documents/repos/sslo_apk/.agents/skills/dalcomsoft-data-decryption/SKILL.md).

6. **Re-encriptación y Actualización del Catálogo (`msd.json` -> `msd.bin`):**
   * Se aplicó la edición del usuario en [msd.json](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/files/asiudgasg%20(ss)/sdisgkdc%20(data)/msd.json) incorporando la pista #92: `"Chuu_Heart Attack [Verse 1]"` (`code: 22001`, `groupData: 22001`, audio `chuu_heartattack.ogg`, beatmaps `chuu_heartattack_4.seq`, `_7.seq`, `_13.seq`).
   * Se optimizó el flujo de serialización en [tools/decrypt_dalcom.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/tools/decrypt_dalcom.py) para minificar automáticamente a JSON compacto (`separators=(',', ':')`) antes de la fase de encriptación AES-256-ECB y compresión GZip.
   * Se regeneró [msd.bin](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/files/asiudgasg%20(ss)/sdisgkdc%20(data)/msd.bin) (117,012 bytes) y se verificó con prueba de ida y vuelta (*round-trip*), confirmando la deserialización idéntica de las 92 pistas. Se sincronizó también con `/sdcard/msd.bin` en el emulador.

## 20. Resolución Integral de la Carga de Assets (`LoadingProcess` / `AssetDownloader`) y Transición al Lobby

1. **Ingeniería Inversa del Pipeline de Inicialización y Descarga:**
   * Se desensambló la máquina de estados asíncrona `AssetDownloader.<LoadingProcess>d__59.MoveNext` (RVA `0xB8BA7C`), la cual ejecuta secuencialmente:
     1. `await this.DownLoadAssetContext()` (RVA `0xAE230C` / struct `<DownLoadAssetContext>d__62` en RVA `0xB8827C`).
     2. `this.CreateParsingList()` (RVA `0xAE3660`).
     3. `this.CreateDownloadList()` (RVA `0xAE90C8`).
     4. `await this.DownloadAndParsingAssets()` (RVA `0xAE2450` / struct `<DownloadAndParsingAssets>d__63` en RVA `0xB88ACC`).
     5. `await this.FilterDownloadFirstPackingFile()` (RVA `0xAE2CE4` / struct `<FilterDownloadFirstPackingFile>d__68` en RVA `0xB8AB1C`) o `this.FilterDownloadPathList(downloadList)` (RVA `0xAE2590` / struct `<FilterDownloadPathList>d__64` en RVA `0xB8AF9C`).
     6. Finalización y transición:
        * `OnStateCallback.Invoke(STATE.COMPLETED = 8)`
        * `AssetControl.Close()` (RVA `0xAD84E0`)
        * `AsyncVoidMethodBuilder.SetResult()` (RVA `0x1A75160`)

2. **Superación de la Barrera de Metadatos IL2CPP en `DownLoadAssetContext`:**
   * Se identificó que al interceptar `0xB8827C`, el token de metadatos `0xC000A833` no estaba inicializado en la tabla `0x30F3C90`.
   * Se implementó la llamada nativa a `il2cpp_codegen_initialize_runtime_metadata` (RVA `0xA43BE8`) sobre `baseAddr.add(0x30F3C90).readPointer()`, lo que resolvió el `MethodInfo*` nativo para `AsyncTaskMethodBuilder<bool>.SetResult(bool)` (RVA `0x2175900`), logrando una finalización inmediata y limpia en 4 ms.

3. **Bypass de Creación de Listas de Descarga Remotas (`CreateDownloadList`):**
   * Dado que la totalidad de los archivos binarios del juego (18,000+ recursos, `gcd.bin`, `cbd.bin`, `cad.bin`, `msd.bin`, etc.) ya existen descifrados localmente en `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/sdisgkdc/`, se interceptó `AssetDownloader.CreateDownloadList` (RVA `0xAE90C8`) para omitir la consulta a servidores remotos.

4. **Completado de `DownloadAndParsingAssets` y Subrutinas de Empaquetado:**
   * Se interceptó `AssetDownloader.<DownloadAndParsingAssets>d__63.MoveNext` (RVA `0xB88ACC`), resolviendo los metadatos en `0x30F3000 + 0xC90` e invocando `SetResult(true)`.
   * Se interceptó `AssetDownloader.<FilterDownloadFirstPackingFile>d__68.MoveNext` (RVA `0xB8AB1C`), completando con `true` usando metadatos en `0x3113000 + 0xFE0`.
   * Se interceptó `AssetDownloader.<FilterDownloadPathList>d__64.MoveNext` (RVA `0xB8AF9C`).

5. **Mapeo de la Transición al Lobby / Main Menu:**
   * Se identificó que al terminar la descarga, `AssetControl.DownloadDone()` (RVA `0xADA150`) establece `AssetControl.IsResourceDownloadComplete = true` (offset `0x29`) y `AssetControl.State = 8`.
   * El callback `TitleScene.<SetStateLoading>b__18_1` detecta el estado 8, actualiza la barra al 100% e invoca `TitleScene.SetResourceDownload()` (RVA `0xB25884`), el cual a su vez ejecuta `TitleScene.SetStateNextScene()` (RVA `0xB23F38`).
   * En `SetStateNextScene`, con `LoginControl.get_IsLogin()` (RVA `0xCF6EF4`) retornando `true`, se despacha la llamada nativa:
     `Scene.SetStateOpenScene(SceneControl.SCENE_TYPE.Lobby = 3)` (RVA `0xD5338C`).
   * Se conectó el trigger en `LoadingProcess` al alcanzar el estado 3 para activar directamente `AssetControl.DownloadDone()` y `AssetControl.Close()`.

## 21. Arquitectura de Renderizado del Fondo de Pantalla de Carga y Título (`TitleScene` / "TOUCH TO START")

1. **Jerarquía Visual de Unity y Separación de Canvases:**
   * En `level0` (escena persistente de infraestructura, `DontDestroyOnLoad`), reside el Canvas raíz de fondo:
     `BackgroundSystemCanvas` (PID 229, `sortingOrder: 0`, `renderMode: ScreenSpaceOverlay`).
   * Jerarquía interna:
     - `BackgroundSystemCanvas` (GO PID 229)
       - `Layout` (GO PID 209)
         - `VideoPlayer` (GO PID 208) [Manejado por `BackgroundVideo`]
         - `Background` (GO PID 46) [Manejado por `BackgroundImage` singleton, RVA `0xE93AAC`]
           - `Image` (GO PID 191) [Componente `UnityEngine.UI.RawImage` en offset `0x38`: `backgroundRawImage`]
   * En `level2` (`TitleScene`), el Canvas principal tiene `sortingOrder: 1` (`renderMode: ScreenSpaceOverlay`).
     - Contiene los elementos de interfaz superpuestos:
       - `Intro` (`introBase` en `TitleView`, offset `0x40`)
       - `Main` (`mainBase` en `TitleView`, offset `0x120`): contiene `BtnTouch` ("TOUCH TO START") y `Copyright`.
   * Al tener `sortingOrder: 0`, `BackgroundSystemCanvas` se renderiza exactamente detrás de la UI de `TitleScene`.

2. **Lógica de Carga de Textura en `BackgroundImage` (RVA `0xE93AAC`):**
   * `BackgroundImage.SetBackgroundImage` (RVA `0xE93E10`) arranca la corrutina `OnSetImage` (RVA `0xE93EF8` / `MoveNext` en `0xB91E88`).
   * **Ruta Remota (CDN / Mock Server):**
     - Consulta el manifest (`NetworkControl.ManifestJsonInfo`).
     - Si `TitleBackgroundCount > 0` y `TitleBackgroundUrl` no está vacío:
       - Invoca `WWWFile.ToImagePath` (RVA `0xAE9BC4`) para solicitar `TitleBackgroundUrl`.
       - Al recibir la textura (`Texture2D`), la asigna a `this.backgroundRawImage.texture` (`RawImage.set_texture` en RVA `0x194C074`).
       - Activa el GameObject (`0x1DBADF4`) y marca `this.IsValid = true` (offset `0x58`).
   * **Ruta Local (StreamingAssets Offline Fallback):**
     - Si la descarga remota no está configurada (`TitleBackgroundCount == 0`), intenta cargar el fallback local:
       `Application.streamingAssetsPath + "/ss/image/background/title_background.bytes"`
     - Lee los bytes con `File.ReadAllBytes` (RVA `0x1F0268C`).
     - Crea una textura `Texture2D` (RVA `0x181B634`) y decodifica con `ImageConversion.LoadImage` (RVA `0x25B3E90`).
     - Asigna al `RawImage` y marca `IsValid = true`.

3. **Activación de la Imagen en la Transición de Escena (`TopViewControl.UpdateScene`):**
   * En `TopViewControl.UpdateScene(SceneControl.SCENE_TYPE sceneType)` (RVA `0xB2ECE4`):
     - Primero llama a `BackgroundImage.Instance.HideBackgroundImage()` (RVA `0xE93E08`).
     - En el switch por tipo de escena, `Case 2` corresponde a `SceneControl.SCENE_TYPE.Title`:
       - Evalúa `BackgroundImage.Instance.IsValid` (offset `0x58`).
       - Si `IsValid == true` (y `BackgroundVideo.IsPlaying == false`), salta a `0xB2F260` e invoca `BackgroundImage.Instance.ShowBackgroundImage()` (RVA `0xE93E00`).
     - **Causa de la pantalla en blanco inicial:** Al retornar el `manifest.json` original `TitleBackgroundUrl: ""` y no existir `title_background.bytes` en assets, `IsValid` permanecía en `false`, impidiendo que `TopViewControl` activara el background.

4. **Integración Oficial de Fondos de Título desde `asodhsg/kswoks`:**
   * Se utiliza la carpeta oficial canónica de Dalcomsoft para los *Title Backgrounds*: [app/src/files/asiudgasg/asodhsg/kswoks](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/files/asiudgasg/asodhsg/kswoks).
   * **Descubrimiento Arquitectónico:**
     - En los logs nativos de Unity se identificó que el motor intentaba descargar originalmente:
       `PATH: /storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/asodhsg/kswoks/bg0.i.bytes` desde `d3exy8s96shf22.cloudfront.net/resources/images/title_background/title_0.png`.
     - Esto confirma que `kswoks` es el identificador oficial de Dalcomsoft para la pantalla de título y "TOUCH TO START".
     - El conjunto incluye 8 fondos (`bg0.i.bytes.png` a `bg7.i.bytes.png`), abarcando tanto las eras clásicas de Dalcomsoft (Flip That, So What, PTT, etc.) como las nuevas incorporaciones de las subunidades y proyectos posteriores (ARTMS en `bg6` y Loossemble en `bg7`).
     - Cada fondo cuenta con resolución 1024x1024 en formato RGBA/RGB con viñetas y gradientes oficiales pre-procesados para maximizar la legibilidad de la UI, y se encuentran limpios en el área del logotipo y de textos interactivos frontales.
   * **Configuración del Mock Server y Frida:**
     - Se sincronizaron los 8 fondos en `server/static/` (`title_bg_0.png` a `title_bg_7.png`).
     - En `server/app/routers/manifest.py`, se configuró `TitleBackgroundCount: "8"` y `TitleBackgroundUrl: "http://10.0.2.2:8000/static/title_bg_{0}.png"`.
     - En el emulador se desplegó la carpeta en `/sdcard/kswoks/` y en `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/asodhsg/kswoks/`.
     - En [app/src/main/assets/libscript.js](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/assets/libscript.js), se configuró la selección aleatoria dinámica (`Math.floor(Math.random() * officialBgFiles.length)`) sobre el array de 8 elementos (`bg0` a `bg7`).
     - Se verificó que la pantalla de título rota aleatoriamente entre los 8 fondos oficiales de *kswoks*, manteniendo el logotipo nativo vectorial de *SUPER STAR LOONA*, avisos legales y la animación de *"TOUCH TO START"* con total nitidez.

## 22. Arquitectura de Transición de `TitleScene` a `LobbyScene` (Main Menu)

1. **Causa Raíz del Crash en "TOUCH TO START":**
   * **Diagnóstico de Memoria:** Se detectó un `SIGSEGV` (`fault addr 0xffffffffffffff`) en `libfrida-gadget.so` originado por el uso de `Interceptor.replace` con `NativeCallback` sobre el método compilado `<SetStateMain>b__25_0` (RVA `0xB273C4`).
   * **Flujo Nativo de Desensamblado:**
     - En RVA `0xB273C4`, el delegado original ejecuta `SoundControl.Play` (RVA `0xD0A3B4`) y salta a `TitleScene.SetStateSelectLogin` (RVA `0xB245AC`).
     - Al autenticar o detectar sesión previa (`LoginControl.get_IsLogin() == true`), el motor invoca `TitleScene.SetStateNextScene` (RVA `0xB23F38`).
     - En `SetStateNextScene`, si `IsGuest == false` y `IsLogin == true`, se ejecuta la llamada canónica:
       `Scene.SetStateOpenScene(this, SCENE_TYPE.Lobby /* 3 */, null, null, null)` (RVA `0xD5338C`), la cual delega a `SceneControl.OpenScene(3)` (RVA `0xD534BC`).
   * **Corrección Arquitectónica:** Sustituir `Interceptor.replace` por `Interceptor.attach` no intrusivo y asegurar que `SetStateNextScene` reciba la referencia de `globalTitleScene` en el hilo de Unity (`Il2Cpp.perform`), garantizando la preservación de registros en ARM64.

2. **Mapeo de Recursos en `app/src/files/asiudgasg/` para `LobbyScene`:**
   * **`asodhsg/halwuiefjs/`**: 276 imágenes PNG de 122x122 que corresponden a los avatares de perfil circulares de las miembros de LOONA (usados por `TopViewControl.userIcon`).
* **`asodhsg/aweoijs/`**: 71 imágenes con insignias de ligas semanales ("BRONZE I", rangos de temporada) e iconos de recursos (auriculares, diamantes, RP).
   * **`asodhsg/bhfbfhbf/`**: 189 imágenes PNG de 190x201 con los marcos de cartas de juego (Ranks Normal y Prism: A, S, R).
   * **`asodhsg/weoihxd/`**: Fondos individuales de Lobby (`MyLobby`) para cada miembro de LOONA en 1024x1024 con gradiente inferior para UI.
   * **`asodhsg/kswoks/bg0.i.bytes.png`**: Fondo oficial del vagón de tren de *Flip That* con las 12 miembros sentadas en los asientos verdes (fondo de referencia del Main Menu).
   * **`asodhsg/wehgswoi/`**: Banners horizontales de eventos y noticias (para `LobbyView.NewsView` / `LobbyNewsView`).
   * **Assets de Unity (`assets/bin/Data/level3`)**: Prefabs del botón hexagonal "Ready", animaciones de flechas de navegación de fondo (`leftArrowOn`/`rightArrowOn`) y top bar.

## 23. Arquitectura del Lobby Revival: Renderizado Completo, Desensamblado de `LobbyView` y Verificación Visual

### 1. Resolución del Deadlock de Carga Asíncrona en `level3` (`g_MetadataLock` / `FastMutex`)
* **Diagnóstico de Concurrencia:** Durante la integración de `level3` y la carga de clases IL2CPP concurrentes en `0x28A274` (worker loop), el hilo principal y los hilos trabajadores competían por `g_MetadataLock` (`0x3392580`). Al producirse contención, `il2cpp::os::FastMutex::Lock` quedaba en espera indefinida mediante el futex de Linux (`pFutex = 1, recur = 2`), deteniendo el avance de la escena.
* **Solución de Watchdog Atómico:** En [app/src/main/assets/libscript.js](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/assets/libscript.js), se implementó un watchdog independiente que detecta contención persistente en el futex de `g_MetadataLock` y ejecuta llamadas a `syscall(SYS_futex, pFutex, FUTEX_WAKE_PRIVATE, INT_MAX)` para despertar a los hilos esperando. Con ello, la deserialización de `level3` se completa de forma inmediata (~400 ms) sin congelamientos.

### 2. Desensamblado y Análisis de Flujo de `LobbyView.Show()` (RVA `0xCEEB04`)
* **Código Desensamblado (ARM64):**
  ```arm64
  0xCEEB5C: bl 0x14e6050           ; TutorialControl.get_Step()
  0xCEEB60: cmp w0, #0x1
  0xCEEB64: b.lt 0xceebe0          ; Si Step < 1, salta la animación de tutorial
  ...
  0xCEEBE4: bl 0xceecb0            ; SceneView.Show()
  0xCEEBE8: ldr x8, [x19, #0x48]   ; x8 = this.blank (UICache)
  0xCEEBEC: cbz x8, 0xceecac       ; ¡SI blank ES NULL, SALTA DIRECTO A EXCEPCIÓN!
  ...
  0xCEEC34: orr w1, wzr, #0x1      ; SetActive(blank.gameObject, true)
  0xCEEC40: ldr x0, [x19, #0x50]   ; this.newsView
  0xCEEC50: blr x9                 ; newsView.Show()
  0xCEEC54: ldr x8, [x19, #0x68]   ; this.btnReady (ButtonCache)
  0xCEEC5C: ldr x0, [x8, #0x10]    ; x0 = btnReady.gameObject
  0xCEEC6C: bl 0x1dbadf4           ; GameObject.SetActive(btnReady.gameObject, true)
  0xCEEC70: ldr x0, [x19, #0x58]   ; this.memberView
  0xCEEC80: blr x9                 ; memberView.Show()
  0xCEEC84: ldr x0, [x19, #0x60]   ; this.sideButtons
  0xCEECA8: b 0x1dbadf4            ; GameObject.SetActive(sideButtons, true)
  0xCEECAC: bl 0xa43cc0            ; Lanzamiento de NullReferenceException
  ```
* **Causa Raíz de Elementos Faltantes:** Si el campo `blank` (offset `0x48`) o sus sub-componentes eran nulos o no inicializados por el servidor, `LobbyView.Show` bifurcaba de inmediato hacia `0xCEECAC` (excepción interna silenciosa), **impidiendo que el motor alcanzara las instrucciones de activación de `btnReady` (`0x68`), `memberView` (`0x58`) y `sideButtons` (`0x60`)**.
* **Solución Arquitectónica:** En `libscript.js`, la función `activateLobbyUIAndVideo` desreferencia de forma segura cada componente directamente por offset y los activa de manera autónoma con `GameObject.SetActive(ptr, 1)` (RVA `0x1DBADF4`).

### 3. Estructura de Memoria de `LobbyView` y `ButtonCache`
* **Campos Clave de `LobbyView` (RVA `0xCEE4E8` - `0xCEF700`):**
  - `0x48`: `blank` (`UICache`)
  - `0x50`: `newsView` (`LobbyNewsView`)
  - `0x58`: `memberView` (`LobbyMemberView`)
  - `0x60`: `sideButtons` (`GameObject`)
  - `0x68`: `btnReady` (`ButtonCache`)
  - `0x70`: `buttonObjs` (`GameObject`)
  - `0x98`: `leftMenus` (`Animation`)
  - `0xB0`: `rightMenus` (`Animation`)
  - `0x110`: `myLobbyObj` (`GameObject`)
  - `0x120`: `readyText` (`Text`)
  - `0x128`: `readyAutograph` (`RawImage`)
* **Jerarquía de `ButtonCache` (Hereda de `UICache`):**
  - `UICache + 0x10`: `gameObject` (`GameObject`)
  - `UICache + 0x18`: `transform` (`Transform`)
  - `UICache + 0x40`: `rectTransform` (`RectTransform`)
  - `ButtonCache + 0x48`: `button` (`Button`)
  - `ButtonCache + 0x50`: `box` (`Image` con el sprite hexagonal celeste)
  - `ButtonCache + 0x58`: `disabled` (`Image`)
  - `ButtonCache + 0x60`: `label` (`Text`)

### 4. Carga de la Textura de Fondo y Eliminación de Fallos de Memoria
* **Resolución del Fallo `access violation accessing 0x2`:**
  - Al invocar constructores mediante `il2cpp_runtime_invoke`, los argumentos son un array de punteros a variables (`void** args`). Pasar enteros directamente provocaba que IL2CPP interpretara `args[0] = 0x2` como un puntero a memoria, desencadenando una violación de acceso.
  - Se sustituyó la llamada indirecta por la invocación nativa directa del constructor C++ de Unity:
    `Texture2D..ctor(int width, int height)` en RVA **`0x181B6BC`**:
    ```javascript
    var texCtorNative = new NativeFunction(baseAddr.add(0x181B6BC), "void", ["pointer", "int", "int", "pointer"]);
    texCtorNative(texObj, 2, 2, NULL);
    ```
  - La decodificación JPEG se realiza con `ImageConversion.LoadImage(tex, bytes)` en RVA **`0x25B3E90`**, retornando éxito (`1`).
  - La textura se asigna a `memberView.memberImage` (offset `0x50`) con `RawImage.set_texture` en RVA **`0x194C074`** y se almacena en el campo nativo `m_Texture` (offset `0xD0`).
  - Mediante `RectTransform.set_sizeDelta` (RVA `0x180DC18`) y `RectTransform.set_anchoredPosition` (RVA `0x180DACC`), `memberImage` se expande a `2200x1080` con posición `(0, 0)`, cubriendo la pantalla completa sin franjas residuales.

### 5. Configuración del Botón "Ready" y Menús Laterales
* **Botón Hexagonal "Ready":**
  - Se activa `btnReady.gameObject` (`btnReady + 0x10`) y su componente visual `box` (`btnReady + 0x50`).
  - Se desactiva `readyAutograph` (`0x128`) para evitar que se renderice una miniatura duplicada en la esquina inferior derecha.
  - Se asigna la cadena `"Ready"` a `btnReady.label` (`btnReady + 0x60`) y `readyText` (`0x120`) mediante `Text.set_text` (RVA `0x21A5FC4`) con color lavanda índigo (`#4860A6`, RVA `0x161476C`), logrando una fidelidad exacta con el diseño original.
* **Colapso Limpio de Menús (`InitMenus`):**
  - Se invoca `LobbyView.InitMenus(false, false)` en RVA **`0xCEF608`**:
    ```javascript
    var initMenusFn = new NativeFunction(baseAddr.add(0xCEF608), "void", ["pointer", "int", "int", "pointer"]);
    initMenusFn(lobbyView, 0, 0, NULL);
    ```
  - Esto retrae los menús de Misiones/Calendario y Tienda/Liga hacia los laterales, dejando las flechas de navegación `<` y `>` listas para interacción y el fondo de las 12 miembros de LOONA completamente despejado.

### 6. Verificación Visual Inicial del Lobby
* **Captura de Pantalla:** [lobby_screenshot_perfect.png](file:///Users/ignaciorojas/.gemini/antigravity-ide/brain/e060e5e7-76f4-4a16-a68e-f3dc7966b60f/lobby_screenshot_perfect.png)
* **Referencia Canónica:** [media_1788527350991.jpg](file:///Users/ignaciorojas/.gemini/antigravity-ide/brain/e060e5e7-76f4-4a16-a68e-f3dc7966b60f/.user_uploaded/media_1788527350991.jpg)
* **Conclusión:** Todos los elementos visuales del Lobby quedaron operativos y estables a 60 FPS.

---

## 🎨 Sustitución de Fondo Provisional por Fondos Oficiales Dalcomsoft (`weoihxd` / `MyLobby` / `LobbyBgStore`)

### 1. Inspección Técnica y Confirmación de la Carpeta `weoihxd`
* **Ubicación en el Proyecto:** `app/src/files/asiudgasg/asodhsg/weoihxd/`
* **Naturaleza y Propósito:**
  - Se confirmó mediante análisis de [url_shared_map.json](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/files/asiudgasg/sdisgkdc/url_shared_map.json) y del dump de IL2CPP (`dump/dump.cs`, clases `LobbyBgData`, `LobbyBgDataControl`, `LobbyMyLobbyView`, `MyLobbyAssist`) que la carpeta `weoihxd` es el repositorio oficial de Dalcomsoft para los **fondos de pantalla del Lobby** (`MyLobby` / `lobbybgstore`).
  - Contiene exactamente **153 archivos** correspondientes a **76 fondos oficiales continuos (IDs 1001 a 1076)**.
  - Cada fondo dispone de dos resoluciones nativas:
    - `_l.i.bytes.png` (Large / Full Background): Resolución `1024x1024` RGBA. Viene procesado de fábrica por los diseñadores de Dalcomsoft con gradientes de oscurecimiento específicos: un viñeteado superior suave para garantizar legibilidad del `TopBar` (avatar, auriculares, ritmos, diamantes) y un viñeteado inferior para la barra de botones y navegación.
    - `_s.i.bytes.png` (Small / Thumbnail): Resolución `226x226` RGBA. Diseñado específicamente para el carrusel de selección y tienda de fondos (`LobbyBgStore`).

### 2. Mapeo Oficial de Fondos (`lbg.json` y `url_shared_map.json`)
* **Mapeo por Integrante (Solos 1001 - 1011):**
  - `1001`: HeeJin (`mylobby_bg_l_heejin.png`)
  - `1002`: HyunJin (`mylobby_bg_l_hyunjin.png`)
  - `1003`: HaSeul (`mylobby_bg_l_haseul.png`)
  - `1004`: YeoJin (`mylobby_bg_l_yeojin.png`)
  - `1005`: ViVi (`mylobby_bg_l_vivi.png`)
  - `1006`: Kim Lip (`mylobby_bg_l_kimlip.png`)
  - `1007`: JinSoul (`mylobby_bg_l_jinsoul.png`)
  - `1008`: Choerry (`mylobby_bg_l_choerry.png`)
  - `1009`: Yves (`mylobby_bg_l_yves.png`)
  - `1010`: Chuu / Go Won (`mylobby_bg_l_gowon.png`)
  - `1011`: Olivia Hye (`mylobby_bg_l_olivia_hye.png`)
* **Mapeo por Eras y Subunidades (1012 - 1076):**
  - `1015`: "Flip That" (Grupal verano en el jardín - fondo canónico)
  - `1048`: "Paint The Town" (PTT) / [&] (Grupal fotobook enmarcado)
  - `1021`: "So What" / [#]
  - `1024`: ODD EYE CIRCLE ("Girl Front")
  - `1029`: LOONA 1/3 ("Love & Live")
  - `1036`: "Hi High" / [+ +]
  - `1018`: yyxy ("beauty&thebeat")
* **Color Temático (`productBgColor`):**
  - Cada entrada en [lbg.json](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/files/asiudgasg/sdisgkdc/lbg.json) define un color HEX de acento (ej. `"0x535d9cFF"` para LOONA), utilizado por la UI nativa para los márgenes de pantalla y títulos.

### 3. Despliegue en el Dispositivo Android
* **Subida de Assets:**
  - Se crearon los directorios en el almacenamiento de la app y se transfirieron los 153 archivos a:
    `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/asodhsg/weoihxd/`
  - Se generaron copias con extensión `.i.bytes` y `.i.bytes.png` para asegurar compatibilidad transparente con cualquier loader nativo o de Frida.
* **Limpieza de Assets Provisionales:**
  - Se eliminó completamente la imagen provisional `lobby_bg.jpg` del dispositivo.

### 4. Implementación y Soporte Dinámico en `libscript.js`
* **Lectura Dinámica de Fondo Configurable (`chosen_bg.txt`):**
  - En [app/src/main/assets/libscript.js](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/assets/libscript.js), se implementó un lector dinámico mediante IL2CPP (`System.IO.File.Exists` y `System.IO.File.ReadAllText`) que consulta el archivo:
    `/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/chosen_bg.txt`
  - Si el archivo contiene un ID válido entre `1001` y `1076`, la aplicación carga dicho fondo instantáneamente.
  - Si el archivo no existe o está vacío, el sistema utiliza por defecto el ID `1015` (*Flip That* grupal).
* **Carga e Inyección de Textura:**
  - Se leen los bytes con `System.IO.File.ReadAllBytes`.
  - Se crea la textura nativa `Texture2D..ctor(2, 2)` en RVA `0x181B6BC`.
  - Se decodifica mediante `ImageConversion.LoadImage` en RVA `0x25B3E90`.
  - Se asigna a `memberView.memberImage` (offset `0x50`) con `RawImage.set_texture` (RVA `0x194C074`).
  - Se ajustan los `RectTransform` de `memberView` y `memberImage` para un centrado perfecto y balanceado con los controles laterales.

### 5. Verificaciones Visuales
* **Fondo 1015 (Flip That Grupal):**
  - Captura de pantalla: [lobby_weoihxd_verify2.png](file:///Users/ignaciorojas/.gemini/antigravity-ide/brain/e060e5e7-76f4-4a16-a68e-f3dc7966b60f/lobby_weoihxd_verify2.png)
  - Muestra a las 12 integrantes en el jardín de verano con colores nítidos y el gradiente superior e inferior original de Dalcomsoft.
* **Fondo 1048 (Paint The Town / PTT):**
  - Captura de pantalla: [lobby_weoihxd_1048_lobby.png](file:///Users/ignaciorojas/.gemini/antigravity-ide/brain/e060e5e7-76f4-4a16-a68e-f3dc7966b60f/lobby_weoihxd_1048_lobby.png)
  - Muestra el fotobook con brillos iridiscentes enmarcado en el centro, cambiando dinámicamente al modificar `chosen_bg.txt`.

---

## 🗃️ Estabilización Completa de Escenas: CardBook (Scene 5) e Inventario (Scene 4)

### 1. Diagnóstico Profundo del Crash en Inventario (`Il2CppExceptionWrapper` & `abort()`)

Durante la navegación desde el Lobby (Scene 3) al Inventario (Scene 4), la aplicación experimentaba terminaciones anómalas (`SIGABRT` / `Il2CppExceptionWrapper`) en la fase de construcción de la UI. La ingeniería inversa del binario [app/src/main/lib/arm64-v8a/libil2cpp.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libil2cpp.so) y el trazado de logs identificaron tres causas concurrentes:

#### Causa 1: Conflicto por Doble Hook `Interceptor.replace` y Recursión Infinita
- Las funciones `GroupControl.Find` (RVA `0xB9EF94`) y `CardControl.Find` (RVA `0x11D66F4`) tenían dos bloques de hooks duplicados en `libscript.js` (uno histórico en líneas 2600-2750 y otro en 3130-3170).
- El segundo bloque invocaba punteros originales directos (`originalGroupControlFind(code, methodInfo)`). Como Frida redirige el punto de entrada de la función en memoria, la invocación de `originalGroupControlFind` se llamaba recursivamente a sí misma hasta agotar el stack o retornaba `NULL` para códigos de grupo distintos.
- Como consecuencia directa, durante la instanciación de `GroupItem..ctor` (RVA `0xB56EF4`), `GroupControl.Find(1001)` retornaba `NULL`, dejando el puntero de estructura `groupItem.Group` como nulo.
- En la llamada subsiguiente a `SetupCardItems` (RVA `0xB571C4`), la instrucción ARM64 `0xB572CC: cbz x0, #0xb576e4` disparaba un `NullReferenceException` que impedía el registro de `GroupItem(1001)` dentro de `GroupMap`.

#### Causa 2: Fallo de Resolución de Clases Anidadas IL2CPP (`Nested Classes`)
- Clases como `ThemeTypeControl.Data` y `InventoryControl.CardItem` están definidas en C# como tipos anidados (`nested types`).
- La función de la API de IL2CPP `il2cpp_class_from_name(image, namespace, name)` falla silenciosamente al buscar nombres con slash (`"ThemeTypeControl/Data"`), retornando puntero `NULL`.
- Al fallar la resolución, `loonaThemeTypeData` era nulo, dejando el campo `CardControl.Data.ThemeType` (offset `0x40`) como `NULL`.
- Durante el renderizado de cartas en `ViewControl.GetSmallCardViewData` (RVA `0xABEB30`), la instrucción `0xABEC5C: cbz x22, #0xabee64` verificaba la presencia del objeto de tema; al ser nulo, saltaba a `0xABEE64` (`bl #0xa43cc0`), provocando un `abort()` inmediato.

#### Causa 3: Dependencias Nulas en `ViewControl.SetCardLarge` y `FindToGroupItem`
- `ViewControl.SetCardLarge` (RVA `0xABEE68`) invoca a `InventoryControl.FindToGroupItem(groupCode)` (RVA `0xF29604`).
- La instrucción `0xABEFAC: cbz x0, #0xabf094` lanzaba un `NullReferenceException` si no encontraba el `GroupItem` registrado para el código de grupo activo.
- Además, `InventoryControl.get_SelectedGroupCode` (RVA `0xF26F64`) debía retornar determinísticamente el ID de grupo `1001`.

---

### 2. Solución Arquitectónica Implementada

#### 1. Resolvedor Genérico de Clases Anidadas (`getNestedClass`)
Se implementó en [app/src/main/assets/libscript.js](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/assets/libscript.js) un mecanismo robusto utilizando la API interna de IL2CPP:
```javascript
function getNestedClass(parentClass, nestedName) {
    if (!parentClass.isNull() && il2cpp_class_get_nested_types) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var nestedType;
        while (!(nestedType = il2cpp_class_get_nested_types(parentClass, iter)).isNull()) {
            var name = il2cpp_class_get_name(nestedType).readUtf8String();
            if (name === nestedName) return nestedType;
        }
    }
    return NULL;
}
```
Esto garantiza la resolución infalible de:
- `ThemeTypeControl.Data`
- `CardControl.Data`
- `GroupControl.Data`
- `ThemeControl.Data`
- `ArtistControl.Data`
- `InventoryControl.CardItem`
- `InventoryControl.GroupItem`
- `CardSmallView.Params`
- `CardLargeView.Params`

#### 2. Reemplazo Limpio de Proxies para ViewControl
Para aislar la UI de dependencias de descarga remota (`WWWFile.DownloadPath`) y estructuras complejas no serializadas offline, se instalaron proxies de reemplazo con `Interceptor.replace`:
- **`ViewControl.GetSmallCardViewData` (RVA `0xABEB30`):**
  - Instancia directamente un `CardSmallView.Params`.
  - Configura atributos esenciales: `tier = 5` (R), `isRCard = true`, `level = 50`, `maxLevel = 50`, `isEquip = true`.
- **`ViewControl.GetLargeCardViewData` (RVA `0xABE5FC`):**
  - Instancia directamente un `CardLargeView.Params`.
  - Configura atributos equivalentes para la visualización ampliada.
- **`ViewControl.SetCardSmall` (RVA `0xABF098`) y `SetCardLarge` (RVA `0xABEE68`):**
  - Verifican rigurosamente que los punteros de destino (`view`) y parámetros no sean nulos antes de delegar a `CardSmallView.RefreshWithMark`.
- **`InventoryControl.FindToGroupItem` (RVA `0xF29604`):**
  - Retorna directamente `loonaGroupItemObj` cuando el código solicitado es `1001`.
- **`InventoryControl.get_SelectedGroupCode` (RVA `0xF26F64`):**
  - Retorna siempre `1001`.

#### 3. Supresión de Hooks Duplicados y Recursiones
- Se eliminaron los bloques redundantes de `GroupControl.Find` y `CardControl.Find`.
- El despachador central atiende solicitudes de IDs `1001..1012` devolviendo los objetos simulados de LOONA en memoria, y `NULL` para otros sin reingresar recursivamente a los punteros nativos.

#### 4. Bypass Seguro de Extracción de Paths Remotos
- **`InventoryControl.GroupItem.ExtractPath` (RVA `0xB56EC4`):** Bypass seguro `return NULL`.
- **`InventoryControl.CardItem.ExtractSmallImagePath` (RVA `0xB56598`):** Bypass seguro `return NULL` (tipo de retorno `void`).

---

### 3. Matriz de RVAs y Offsets Críticos (ARM64 `libil2cpp.so`)

| Función / Símbolo | RVA | Propósito y Ajuste Aplicado |
| :--- | :--- | :--- |
| `ViewControl.GetSmallCardViewData` | `0xABEB30` | Reemplazado para generar `CardSmallView.Params` seguros sin excepciones |
| `ViewControl.GetLargeCardViewData` | `0xABE5FC` | Reemplazado para generar `CardLargeView.Params` seguros |
| `ViewControl.SetCardLarge` | `0xABEE68` | Proxy protector contra desreferenciación nula |
| `ViewControl.SetCardSmall` | `0xABF098` | Proxy protector para invocación segura de `RefreshWithMark` |
| `InventoryControl.FindToGroupItem` | `0xF29604` | Retorna determinísticamente el `GroupItem` de LOONA (`1001`) |
| `InventoryControl.get_SelectedGroupCode` | `0xF26F64` | Retorna entero `1001` |
| `InventoryControl.GroupItem.ExtractPath` | `0xB56EC4` | Bypass para evitar streaming HTTP innecesario |
| `InventoryControl.CardItem.ExtractSmallImagePath` | `0xB56598` | Bypass para evitar streaming de miniaturas HTTP |
| `CardBookScene.OnOpen` | `0xCADC60` | Inicializa datos de My Card Book |
| `CardBookScene.SetupSubMenu` | `0xCAFC24` | ARM64 byte patch (`0x1F, 0x20, 0x03, 0xD5` / `NOP`) para neutralizar pestañas nulas |

---

### 4. Pruebas de Navegación Bidireccional y Evidencias Visuales

Se realizaron pruebas exhaustivas de navegación cruzada en el emulador Android (`127.0.0.1:5555`), tanto mediante la inyección de comandos en `scene_cmd.txt` como a través de la interacción nativa con los botones de la UI (botón de cierre `X`, botones laterales):

1. **Lobby (Scene 3) → Inventario (Scene 4):**
   - El inventario despliega a LOONA en la parte superior con sus 12 integrantes en dos filas de 6 slots, Grado S / R, Tema "Hi High", y la grilla inferior con las 12 cartas activas y sus checkmarks.
   - Captura: [inventory_alive.png](file:///Users/ignaciorojas/.gemini/antigravity-ide/brain/e060e5e7-76f4-4a16-a68e-f3dc7966b60f/inventory_alive.png)

2. **Inventario (Scene 4) → Lobby (Scene 3):**
   - El Lobby se restaura instantáneamente con el fondo canónico *Flip That* (1015), avatar de usuario "Orbit", auriculares (50), Rhythm Points (100.000) y diamantes (10.000).
   - Captura: [lobby_from_inv.png](file:///Users/ignaciorojas/.gemini/antigravity-ide/brain/e060e5e7-76f4-4a16-a68e-f3dc7966b60f/lobby_from_inv.png)

3. **Lobby (Scene 3) → CardBook (Scene 5):**
   - La pantalla de "My Card Book" se abre de manera estable sin errores de tabs o submenús.
   - Captura: [cardbook_alive.png](file:///Users/ignaciorojas/.gemini/antigravity-ide/brain/e060e5e7-76f4-4a16-a68e-f3dc7966b60f/cardbook_alive.png)

4. **CardBook (Scene 5) → Inventario (Scene 4) → CardBook (Scene 5) → Lobby (Scene 3):**
   - Ciclo completo de transición directa ejecutado sin una sola excepción, abort ni fuga de memoria.

---

## ⚙️ Actualizaciones de Configuración y Reglas del Entorno

### Configuración de Protocolo de Interacción (2026-09-19)
- **Usuario:** Ignacio Rojas (**Ignacio**).
- **Regla incorporada en [.agents/AGENTS.md](file:///Users/ignaciorojas/Documents/repos/sslo_apk/.agents/AGENTS.md):**
  - Obligatoriedad de saludar y mencionar explícitamente a Ignacio al inicio de cada nueva interacción o ejecución.

### Integración con Repositorio GitHub y Control de Versiones (2026-09-19)
- **Repositorio Remoto Oficial:** `https://github.com/naxoxhide/SuperStar-Loona-Revival.git`
- **Rama Principal:** `main`
- **Archivos Estructurados Creados:**
  - [README.md](file:///Users/ignaciorojas/Documents/repos/sslo_apk/README.md): Documentación integral, arquitectura del sistema (Mock Server, criptografía Dalcomsoft, parches IL2CPP/Frida, rebuild de APK), requisitos e instrucciones paso a paso.
  - [.gitignore](file:///Users/ignaciorojas/Documents/repos/sslo_apk/.gitignore): Configuración estricta de exclusión siguiendo directrices de seguridad y buenas prácticas:
    1. **Agentes IA e IDEs Inteligentes:** Bloqueo de transcripciones de chat (`transcript*.jsonl`, `*.transcript`), directorios temporales de razonamiento (`scratch/`, `agent_scratch/`, `*.agent_tmp`), caches locales de asistentes (`.gemini/`, `.antigravity/`, `.cursor/`, `.claude/`, `.continue/`), capturas de verificación de pantalla (`screen_*.png`), y preservación estricta de reglas de ingeniería (`.agents/AGENTS.md`) y habilidades operativas (`.agents/skills/`).
    2. **Android & Gradle:** Exclusión de caches (`.gradle/`, `build/`, `app/build/`), rutas locales de SDK con información del host (`local.properties`), binarios finales (`*.apk`, `*.dex`), y certificados de firma (`*.keystore`, `*.jks`).
    3. **Python & Mock Server:** Exclusión de entornos virtuales (`.venv/`, `venv/`), archivos de bytecode compilado (`__pycache__/`, `*.pyc`), logs de ejecución (`server.log`), y bases de datos SQLite en caliente (`*.db`, `*.sqlite3`).
    4. **Sistema Operativo & Editores:** Exclusión de artefactos de macOS (`.DS_Store`, `._*`) y carpetas locales de editores (`.vscode/`, `.idea/`).
- **Estado de Sincronización:** Repositorio completamente sincronizado con `origin/main` (commit `28e04799`). Se estructuró la subida en 13 commits atómicos y lotes optimizados para evitar sobrepasar los límites de búfer HTTP de GitHub, cubriendo:
  1. Configuración de repositorio (`.gitignore`, `README.md`).
  2. Documentación técnica y directrices de agentes (`docs/`, `.agents/`).
  3. Utilidades de criptografía y scripts de corrección APK (`tools/`, `fix_*.py`, `deploy_card_assets.py`).
  4. Servidor mock local y recursos estáticos (`server/`).
  5. Volcados y símbolos IL2CPP (`dump/`, `cdd.json`).
  6. Proyecto cliente Android reconstruido (`build.gradle`, `app/src/main/`).
  7. Paquetes completos de datos binarios Dalcomsoft, beatmaps `.seq`, audios y catálogo de cartas (11.927 assets en `app/src/files/`).

### Actualización de Identidad Git y Adopción de Conventional Commits (2026-09-19)
- **Identidad Git Configurada:**
  - `user.name`: `naxoxhide`
  - `user.email`: `irojasangel@gmail.com`
  - Se reescribió la autoría del historial completo de commits del proyecto para que la atribución en GitHub corresponda unívocamente a `naxoxhide`.
- **Instalación de Skill de Agente:**
  - Se instaló la skill oficial `conventional-commit` desde `https://github.com/rlespinasse/agent-skills` en [.agents/skills/conventional-commit/SKILL.md](file:///Users/ignaciorojas/Documents/repos/sslo_apk/.agents/skills/conventional-commit/SKILL.md) junto con su archivo de manifiesto `skills-lock.json`.
  - Esta skill estandariza el formato y mejores prácticas para mensajes de commit (`feat:`, `fix:`, `chore:`, `docs:`, `refactor:`, etc.).

### Creación de Rama de Trabajo para UI de Cartas (2026-09-19)
- **Rama:** `feat/card-ui`
- **Propósito:** Desarrollo, estabilización y refinamiento de la interfaz gráfica y visualización de cartas (`CardSmallView`, `CardLargeView`, `InventoryScene`, `CardBookScene`, resolución de vistas de integrantes de LOONA y overlays gráficos).
- **Publicación:** Rama publicada en `origin/feat/card-ui`.

---

## 🃏 Investigación Técnica de UI de Cartas: Escenas, Texturas y Assets (2026-09-19)

### 1. Arquitectura y Desmitificación de Escenas: `InventoryScene` vs `CardBookScene` vs `SelectMusicScene`
A partir del análisis inverso de `dump/dump.cs` y los desensamblados de `libil2cpp.so` (ARM64), se clarificó la relación exacta de las escenas presentes en la interfaz del juego (capturas de referencia):

```
                       [ LobbyScene (ID: 3) ]
                                 ▲
                                 │
                                 ▼
                     [ SelectMusicScene (ID: 7) ]
                       (Canciones y Beatmaps)
                                 ▲
                                 │ (botón "MUSIC" / tap en cartas)
                                 ▼
                     [ InventoryScene (ID: 4) ]  ◄── (Escena en las capturas)
                       (Equipamiento de cartas por grupo/canción)
                                 │
                                 │ (botón lateral "Card Book" / btnMyCollection)
                                 ▼
                     [ CardBookScene (ID: 5) ]
                       (Álbum coleccionista de temas y cartas globales)
```

1. **La escena de las imágenes adjuntas es `InventoryScene` (Scene ID: 4):**
   - Corresponde a la clase `com.dalcomsoft.project.app.scene.InventoryScene` y su vista principal `InventoryView` (`0x106056C`).
   - El botón superior izquierdo dentro del panel central con el texto **"MUSIC"** (o "Music") está enlazado a `InvenGroupItemView.selectMusicText` (offset `0x100`). Al pulsarlo, el juego regresa o transiciona a `SelectMusicScene` (Scene ID: 7) para jugar las canciones del grupo activo (ej. LOONA).
   - El botón lateral con el icono de medalla/cinta es **`btnMyCollection`** (offset `0xA8` en `InventoryView`), el cual dispara el método `OnMyCollection()` (`0x105DE08`) abriendo de manera inmediata **`CardBookScene` (Scene ID: 5)**.
   - Por ende, la escena donde se ven las cartas equipadas es la **pantalla de Inventario y Equipamiento de Canción/Grupo**, no el CardBook, actuando como el puente directo entre la música y la colección.

### 2. Análisis Causa Raíz: ¿Por qué la carta actual se ve vacía con barra gris y texto "Summary"? (Imagen 1 vs Imagen 2)
Al desensamblar `CardView.OnRefresh` (`0x13889F0`), `CardSmallView.OnRefresh` (`0x139061C`) y `URLsControl.SetCdnTexture` (`0x163A9E8` → `0xCD5380`):
1. **Fallo en la resolución asíncrona de CDN (`WWWFile.Load`):**
   - `CardView` posee dos componentes clave tipo `RawImage`:
     - `photo` (offset `0x58`): Foto de la integrante.
     - `tier` (offset `0x68`): Marco metálico ornamental del rango (R, S, A, B, C).
   - En `CardView.OnRefresh`:
     ```arm64
     0x1388af8: bl #0x163a9e8   ; URLsControl.SetCdnTexture(photo, photoPath, photoTexture, <OnRefresh>b__47_0, ...)
     ...
     0x1388b48: bl #0x163a9e8   ; URLsControl.SetCdnTexture(tier, tierPath, tierTexture, <OnRefresh>b__47_1, ...)
     ```
   - Al no contar con el CDN real o fallar la cola de hilos de `WWWFile`, los callbacks de cierre nunca se invocan:
     - `<OnRefresh>b__47_0` (`0x1394904`): `mov w1, #1; b #0x138f3a0` (ejecuta `CardView.set_PhotoVisible(true)`).
     - `<OnRefresh>b__47_1` (`0x139490C`): `mov w1, #1; b #0x1393aac` (ejecuta `CardView.set_TierVisible(true)`).
   - Al quedar ambos `RawImage` desactivados y sin textura, la carta muestra el fondo blanco plano del prefab de Unity y expone el `GaugeFrame` (la barra plateada horizontal central de nivel/experiencia por defecto).
2. **Textos residuales "Summary Summary Summary":**
   - Provienen del arreglo `InvenGroupItemView.summary` (`Text[]` en offset `0x68`). En unidades de 3 miembros (como JinSoul en Imagen 2), estos textos corresponden a las etiquetas "Vocal", "Dance", "Rhythm". Para grupos de 12 integrantes (LOONA), estas etiquetas deben limpiarse a cadena vacía `""` o desactivarse para evitar que se renderice el texto por defecto del prefab de Unity.

### 3. Resolución de Assets: `_s` vs `_l` y `wadceg` vs `sdhgauwehdnu`
Se verificó la estructura interna de los archivos binarios de texturas `.i.bytes` (los cuales son archivos estándar con firma PNG `\x89PNG\r\n\x1a\n`):

| Tipo de Asset | Sufijo | Ubicación Relativa | Resolución / Peso | Uso en Arquitectura |
| :--- | :--- | :--- | :--- | :--- |
| **Carta Posesión Pequeña** | `_s.i.bytes` | `asiudgasg/asodhsg/wadceg/{id}_s.i.bytes` | ~180x250 (~24 KB) | **`CardBookScene` (Grilla de álbumes y temas)**, Bandeja inferior de `InventoryScene` (`CardSmallView`), y slots equipados de LOONA OT12. |
| **Carta Posesión Grande** | `_l.i.bytes` | `asiudgasg/asodhsg/wadceg/{id}_l.i.bytes` | ~600x900 (~135 KB) | Popup de inspección (`CardDetail`), Zoom, unidades de 3 miembros en vista amplia (`CardLargeView`) y animaciones de Gacha. |
| **Silueta / Vacía Pequeña** | `_s.i.bytes` | `asiudgasg/asodhsg/sdhgauwehdnu/{id}_s.i.bytes` | ~180x250 (~18 KB) | **`CardBookScene` (Cartas no obtenidas/faltantes en el álbum)** y slots vacíos en inventario. |
| **Silueta / Vacía Grande** | `_l.i.bytes` | `asiudgasg/asodhsg/sdhgauwehdnu/{id}_l.i.bytes` | ~600x900 (~85 KB) | Detalle de cartas bloqueadas en CardBook. |
| **Marco Ornamental (Tier)** | `_s.i.bytes` | `asiudgasg/asodhsg/aoeiwhslc/uhex/1_{grade}_s.i.bytes` | Variable (~25 KB) | Overlay del rango (R, S, A, B, C) con estrellas en `CardSmallView`. |

### 4. Detección de Cartas en la Cuenta del Usuario
- Se establece una tabla de inventario del usuario (`accountOwnedCards`) que define las cartas en posesión:
  - Cartas `1001` a `1012` (LOONA OT12, Rango R, Nivel 50).
- **Lógica de Decisión Dinámica en Frida:**
  1. Si `cardId` ∈ `accountOwnedCards`:
     - Utilizar `asiudgasg/asodhsg/wadceg/{cardId}_s.i.bytes` (o `_l.i.bytes` según el tamaño requerido).
  2. Si `cardId` ∉ `accountOwnedCards`:
     - Utilizar `asiudgasg/asodhsg/sdhgauwehdnu/{cardId}_s.i.bytes` (silueta oscura).
  3. Cargar directamente el Texture2D en memoria vía `ImageConversion.LoadImage` (`0x25B3E90`) e inyectarlo en `RawImage.set_texture` (`0x194C074`), activando los GameObjects y ejecutando los callbacks de visibilidad.

### 5. Arquitectura y Mapeo de Marcos de Rango (*Tier Frames*) en `aoeiwhslc/uhex`
Se realizó el análisis inverso de las texturas de marcos (*card edges*) en `app/src/files/asiudgasg/asodhsg/aoeiwhslc/uhex/` a partir de `url_shared_map.json`:
- **Nomenclatura Dalcomsoft:** `{TemaPrefix}_{Grade}_{Variante}.i.bytes`
  - **Grados (`Grade`):** `c` (C), `b` (B, ej. `0b_...`), `a` (A), `s` (S), `r` (R).
  - **Variantes de Escena (`Variante`):**
    - `_s.i.bytes` (`Small`): Utilizado para `CardSmallView` en `InventoryScene` (slots superiores de equipamiento y cartas en la bandeja de inventario).
    - `_c.i.bytes` (`Collection`): Utilizado para `CardCollectionView` en `CardBookScene` (diseñado exclusivamente para la cuadrícula del álbum de temas).
    - `_l.i.bytes` (`Large`): Utilizado para `CardLargeView` (inspección detallada a pantalla completa / zoom).
  - **Prefijos de Tema:**
    - `0_` (o `0b_`, `0c_`): Marcos básicos estándar (`ced_basic`).
    - `1_`, `2_`, `3_`...: Marcos temáticos de eventos limitados (*Pale Blue Dot*, *Be Honest*, *Why Not*, etc.).
- **Tabla de Marcos Básicos Estándar (`ced_basic`):**
  - Grado C: `0_c_s.i.bytes` (Small) / `0_c_c.i.bytes` (Collection) / `0c_l.i.bytes` (Large)
  - Grado B: `0b_s.i.bytes` (Small) / `0b_c.i.bytes` (Collection) / `0b_l.i.bytes` (Large)
  - Grado A: `0_a_s.i.bytes` (Small) / `0_a_c.i.bytes` (Collection) / `0_a_l.i.bytes` (Large)
  - Grado S: `0_s_s.i.bytes` (Small) / `0_s_c.i.bytes` (Collection) / `0_s_l.i.bytes` (Large)
  - Grado R: `0_r_s.i.bytes` (Small) / `0_r_c.i.bytes` (Collection) / `0_r_l.i.bytes` (Large)

---

### 6. Análisis Exhaustivo de Variantes de Tier (`_s.i`, `_c.i`, `_l.i`) y Resolución de Dimensionamiento de Marcos (2026-09-19)

#### 6.1. Desensamblado y Mapeo Canónico por Escena en el Motor Dalcomsoft
A partir del análisis de ingeniería inversa en [dump/dump.cs](file:///Users/ignaciorojas/Documents/repos/sslo_apk/dump/dump.cs) y desensamblado directo con Capstone ARM64 en [app/src/main/lib/arm64-v8a/libil2cpp.so](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/lib/arm64-v8a/libil2cpp.so), se identificó el enum `ThemeTypeControl.TYPE` (TypeDefIndex: 14225):
- `ThemeTypeControl.TYPE.Large` = `0` (sufijo `_Large.png` → `_l.i.bytes`)
- `ThemeTypeControl.TYPE.Small` = `1` (sufijo `_Small.png` → `_s.i.bytes`)
- `ThemeTypeControl.TYPE.Collection` = `2` (sufijo `_Collection.png` → `_c.i.bytes`)
- `ThemeTypeControl.TYPE.Zoom` = `3` (sufijo `_Zoom.png`)

La invocación canónica de `ThemeTypeControl.Data.GetGradeImagePath(CardGrade grade, ThemeTypeControl.TYPE type)` (RVA `0xC8ADD8`) se mapea en el juego según la vista:

1. **Vista en Detalle de Carta (`CardLargeView` / `CardDetail` / Modal Zoom):**
   - **Método:** `ViewControl.GetLargeCardViewData` (RVA `0xABE5FC`).
   - **Instrucciones ARM64:**
     ```arm64
     0xabe6ec: mov w1, w0       ; w1 = CardGrade (grade)
     0xabe6f0: mov x0, x21      ; x0 = ThemeTypeControl.Data
     0xabe6f4: mov w2, wzr      ; w2 = 0 = ThemeTypeControl.TYPE.Large !!
     0xabe6fc: bl #0xc8add8     ; GetGradeImagePath(grade, Large)
     ```
   - **Texturas:**
     - Foto: `wadceg/{id}_l.i.bytes` (`226 x 318` px).
     - Marco de Rango: `aoeiwhslc/uhex/{theme}_{grade}_l.i.bytes` (`226 x 318` px).
     - Relación de aspecto 1:1 exacta, calzando pixel a pixel sobre la foto.

2. **Vista de Inventario y Slots Equipados en Canción (`CardSmallView` / `InventoryScene`):**
   - **Método:** `ViewControl.GetSmallCardViewData` (RVA `0xABEB30`).
   - **Instrucciones ARM64:**
     ```arm64
     0xabec60: mov w1, w0       ; w1 = CardGrade (grade)
     0xabec64: mov w2, #1       ; w2 = 1 = ThemeTypeControl.TYPE.Small !!
     0xabec68: mov x0, x22      ; x0 = ThemeTypeControl.Data
     0xabec70: bl #0xc8add8     ; GetGradeImagePath(grade, Small)
     ```
   - **Texturas:**
     - Foto: `wadceg/{id}_s.i.bytes` (`85 x 120` px).
     - Marco de Rango: `aoeiwhslc/uhex/{theme}_{grade}_s.i.bytes` (`116 x 156` px).
     - El marco posee 11px de margen transparente horizontal y 12px vertical, además del rebaje inferior diseñado para alojar el badge del nivel (`NumberBox`) y las estrellas (`starLevel`).

3. **Gameplay de Ritmo / Cuando se Juega la Canción (`Ingame` / Scene 10):**
   - **Método:** `IngameLoadingScene.<OnLoading_0_CardTexture_Request>d__30.MoveNext` (RVA `0xED76C4`).
   - **Instrucciones ARM64:**
     - En `0xed7b68`: llama a `CardControl.Data.get_SmallImagePath()` (RVA `0xE43844`) cargando `{id}_s.i.bytes` (`85 x 120` px).
     - En `0xed7d8c`: `mov w2, #1; bl #0xc8add8` (solicita `ThemeTypeControl.TYPE.Small` = 1, cargando `{theme}_{grade}_s.i.bytes`, `116 x 156` px).
     - En `IngameLoadingScene.<OnLoading_2_CardTexture_WaitAndBind>` (RVA `0xEDA6AC`), el motor genera un atlas unificado (`cardAtlasTexture`) fusionando la foto pequeña (`cardW`=85, `cardH`=120) y el marco de rango (`gradeW`=116, `gradeH`=156) para alimentar `IngameCardObject` durante la pulsación de notas y fiebre (Fever).

4. **Álbum de Colección (`CardCollectionView` / `CardBookScene`):**
   - **Método:** `CardBookControl.GetCollectionCardViewData` (RVA `0x11D204C`).
   - **Instrucciones ARM64:**
     ```arm64
     0x11d2104: mov w1, w0       ; w1 = CardGrade (grade)
     0x11d2108: mov w2, #2       ; w2 = 2 = ThemeTypeControl.TYPE.Collection !!
     0x11d210c: mov x0, x22      ; x0 = ThemeTypeControl.Data
     0x11d2114: bl #0xc8add8     ; GetGradeImagePath(grade, Collection)
     ```
   - **Texturas:**
     - Foto: `wadceg/{id}_s.i.bytes` (`85 x 120` px).
     - Marco de Rango: `aoeiwhslc/uhex/{theme}_{grade}_c.i.bytes` (`116 x 156` px).
     - A diferencia de `_s`, la versión `_c` presenta un marco perimetral cerrado y limpio sin recorte inferior para nivel de carta, optimizado para catálogo estático.

#### 6.2. Causa Raíz del Desajuste de Tamaño en el Walkthrough
Al desensamblar `CardView.OnRefresh` (RVA `0x13889F0`), se descubrió la llamada a `URLsControl.SetCdnTexture` (RVA `0x163A9E8`):
- Para la foto (`photo`): se envía `autoSize = false` (`0`), pues la foto debe ajustarse al contenedor rect del prefab de Unity.
- Para el marco de rango (`tier`): **el motor envía obligatoriamente `autoSize = true` (`1`)**:
  ```arm64
  0x1388b44: mov w4, #1       ; w4 = autoSize = 1 (TRUE) para tier
  0x1388b48: mov w5, #1       ; w5 = autoEnabled = 1
  0x1388b4c: mov x0, x21      ; x0 = tier (RawImage)
  0x1388b64: bl #0x163a9e8   ; URLsControl.SetCdnTexture
  ```
- En `URLsControl.<SetCdnTexture>b__0` (RVA `0x20D4ADC`), si `autoSize != 0`, el motor ejecuta el método virtual `RawImage.SetNativeSize()` (RVA `0x194C1C8`).
- **Problema previo:** En nuestro hook de Frida en [app/src/main/assets/libscript.js](file:///Users/ignaciorojas/Documents/repos/sslo_apk/app/src/main/assets/libscript.js), no se llamaba a `SetNativeSize(target)`. El `RawImage tier` permanecía con las dimensiones por defecto del prefab o distorsionado.
- **Solución implementada:** Se integró la invocación a `RawImage.SetNativeSize(target)` (`0x194C1C8`) cada vez que `autoSize !== 0`, permitiendo que el marco de 116x156 se expanda y centre automáticamente sobre la carta de 85x120.

#### 6.3. Desmitificación de la Estructura de Archivos en `aoeiwhslc/uhex`
Se auditó la totalidad de los 1035 archivos `.png` en `app/src/files/asiudgasg/asodhsg/aoeiwhslc/uhex/` (69 temas x 5 rangos x 3 variantes):
- Dalcomsoft empleó convenciones asimétricas en los nombres de archivo:
  - **Grado B:** Nombrado `{theme}b_{variant}.i.bytes.png` (sin guión bajo tras el número de tema, ej. `0b_s`, `0b_c`, `0b_l`, `67b_s`).
  - **Grado C:** Nombrado `{theme}_c_{variant}.i.bytes.png` para `_s` y `_c`, pero la versión Large fue nombrada `{theme}c_l.i.bytes.png` (sin guión bajo, ej. `0c_l`, `10c_l`, `67c_l`).
  - **Grados A, S, R:** Nombrados simétricamente `{theme}_{grade}_{variant}.i.bytes.png` (ej. `0_a_s`, `0_s_s`, `0_r_s`).
- **Conclusión:** No faltan archivos ni variantes. Todos los grados (C, B, A, S, R) en los 69 temas cuentan con sus tres variantes completas (`_s`, `_c`, `_l`). La fórmula universal implementada en `getGradeFrameDownloadPath` resuelve el 100% de los 1035 archivos sin excepciones.



