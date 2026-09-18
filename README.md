# 🌟 SuperStar LOONA Revival

> Proyecto de ingeniería inversa, emulación de servidor y preservación para el videojuego móvil rítmico **SuperStar LOONA** (`com.dalcomsoft.sslo`), desarrollado originalmente por Dalcomsoft sobre Unity IL2CPP.

---

## 📌 Visión General

Tras el cierre de los servidores oficiales de la franquicia SuperStar, este proyecto tiene como objetivo restaurar la funcionalidad completa del cliente de juego, permitiendo la ejecución offline y local a través de una arquitectura compuesta por:

1. **Mock Server Local:** Emulación de las rutas API REST/JSON y endpoints binarios de Dalcomsoft (Autenticación, Sesiones de Miembro, Lobby, Inventario, Catálogo de Canciones/MSD, y CardBook).
2. **Motor de Criptografía de Datos Dalcomsoft:** Decodificación y re-serialización del formato propietario binario `.bin` (AES-128-CBC con ofuscación por bloques y validación de hash) para archivos de configuración como `msd.bin`, `lbg.bin`, `cdd.bin`, etc.
3. **Parches de Cliente e Instrumentación IL2CPP:**
   - Desensamblado y mapeo de símbolos en ARM64 / ARMv7 mediante Il2CppDumper, Ghidra e IDA Pro.
   - Scripts de instrumentación con Frida para bypass de SSL Pinning en BestHTTP, redirección de tráfico de red y parches de memoria en tiempo de ejecución.
   - Neutralización de excepciones nulas en navegación de escenas (`LobbyScene` [3] ⇄ `InventoryScene` [4] ⇄ `CardBookScene` [5]).
4. **Reconstrucción del Cliente Android:** Proyecto Gradle estructurado para compilar, firmar y empaquetar el APK modificado con soporte para depuración y parches nativos.

---

## 📁 Estructura del Repositorio

```text
├── .agents/               # Reglas obligatorias (AGENTS.md) y skills de ingeniería para agentes IA
│   └── skills/            # Procedimientos especializados (criptografía, bypass de red, reversing)
├── app/                   # Código fuente del cliente Android reconstruido (Java, Smali, Assets, Libs nativas)
│   ├── src/main/          # Manifiesto, librerías nativas (libil2cpp.so), recursos y assets de Unity
│   └── src/files/         # Metadatos del juego y assets descifrados de Dalcomsoft
├── docs/                  # Fuente de verdad acumulativa y documentación técnica
│   └── CONTEXT.md         # Registro de avances, memoria de offsets, análisis de red y decisiones de diseño
├── dump/                  # Dumps de IL2CPP (dump.cs, il2cpp.h, script.json, stringliteral.json, DummyDll)
├── server/                # Servidor mock local en Python (FastAPI/Flask) y rutas estáticas
│   ├── app/               # Endpoints emulados (auth, lobby, inventory, cardbook, etc.)
│   ├── static/            # Archivos estáticos y binarios servidos al cliente
│   └── run.py             # Punto de entrada del servidor mock
├── tools/                 # Herramientas CLI auxiliares
│   ├── decrypt_dalcom.py  # Algoritmo de desencriptación/encriptación para archivos .bin
│   └── normalize_assets.py# Normalización de nombres de assets y hashes de descarga
├── deploy_card_assets.py  # Script de sincronización de assets al emulador Android vía ADB
├── build.gradle           # Configuración de compilación raíz de Gradle
├── settings.gradle        # Declaración de módulos del proyecto
└── cdd.json               # Definiciones y catálogo completo de cartas (Card Data Definition)
```

---

## 🛠️ Requisitos Previos

- **Python 3.10+**
- **Android SDK & Command Line Tools** (con `adb` en el PATH)
- **Java Development Kit (JDK 17)**
- **Frida & Frida-Tools:**
  ```bash
  pip install frida frida-tools
  ```
- **Dispositivo o Emulador Android:**
  - Arquitectura soportada: `arm64-v8a` / `armeabi-v7a` (con root para inyección de Frida).

---

## 🚀 Puesta en Marcha

### 1. Iniciar el Servidor Mock Local

```bash
cd server
python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
python run.py
```

El servidor escuchará por defecto en `http://0.0.0.0:8000` (o el puerto asignado en la configuración).

### 2. Sincronizar Assets al Dispositivo/Emulador

Asegúrate de que tu emulador o dispositivo esté conectado vía `adb`:

```bash
adb devices
python deploy_card_assets.py
```

### 3. Compilar el Cliente Android (APK)

```bash
./gradlew assembleDebug
```

El APK resultante se generará en `app/build/outputs/apk/debug/app-debug.apk`.

### 4. Ejecutar Frida para Redirección e Inyección de Parches

Con el servidor mock corriendo y el emulador activo:

```bash
frida -U -f com.dalcomsoft.sslo -l tools/frida_agent.js
```

---

## 🔐 Criptografía Dalcomsoft

Los archivos `.bin` de configuración (`msd.bin`, `lbg.bin`, `cdd.bin`) utilizan un esquema de cifrado propietario basado en:
- Cifrado simétrico **AES-128-CBC**.
- Vector de Inicialización (IV) y Clave derivados internamente por el motor de Dalcomsoft.
- Rotación y ofuscación de encabezados para validación de integridad.

Para inspeccionar o modificar datos de canciones o cartas:

```bash
# Desencriptar binario a JSON legible
python tools/decrypt_dalcom.py decrypt app/src/files/asiudgasg/sdisgkdc/msd.bin msd.json

# Re-encriptar JSON modificado a binario para el cliente
python tools/decrypt_dalcom.py encrypt msd.json msd.bin
```

---

## 🤖 Directrices para Agentes de IA

Este repositorio incluye una suite de reglas y habilidades en `.agents/`:
- **[.agents/AGENTS.md](.agents/AGENTS.md):** Reglas operativas estrictas, incluyendo la actualización obligatoria de `docs/CONTEXT.md` en cada iteración.
- **[.agents/skills/](.agents/skills/):** Procedimientos documentados para ingeniería inversa, bypass de red y criptografía de Dalcomsoft.

> Nota: Los archivos de trabajo efímeros, transcripciones, capturas temporales y caches de IDEs de IA están excluidos del control de versiones mediante `.gitignore`.

---

## ⚖️ Aviso Legal y Propiedad Intelectual

Este proyecto ha sido desarrollado exclusivamente con fines educativos, de investigación técnica y de preservación histórica de software. 

- Todos los activos visuales, pistas de audio, marcas registradas y derechos de autor pertenecen a **Dalcomsoft Inc.** y las respectivas agencias de representación artística (**Blockberry Creative**, **MODHAUS**).
- No se comercializa ni se persigue lucro directo o indirecto con este código.
