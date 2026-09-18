---
name: dalcomsoft-data-decryption
description: "Metodología, arquitectura criptográfica, algoritmos y herramientas para desencriptar, analizar y editar archivos binarios de datos (.bin) en juegos Dalcomsoft (SuperStar Series)."
---

# Dalcomsoft Data Asset Decryption & Analysis Skill

Esta skill proporciona las especificaciones técnicas, algoritmos, claves maestras y procedimientos automatizados para desencriptar, serializar y modificar todos los archivos de configuración, música, cartas, artistas y recursos (`.bin`) de los juegos basados en el motor Dalcomsoft (ej. *SuperStar LOONA*, *SuperStar SMTOWN*, *SuperStar JYPNATION*, *SuperStar Kang Daniel*).

---

## 1. Arquitectura de Almacenamiento de Datos (`sdisgkdc`)

En los juegos Dalcomsoft / Unity IL2CPP, la base de datos estática y dinámica del juego reside en la carpeta obfustada `sdisgkdc` (o subcarpetas de assets `asiudgasg`). Todos los archivos de datos se almacenan con extensión `.bin`.

### Pipeline Criptográfico de Dalcomsoft (.bin -> JSON)

```
[ Archivo .bin en disco ]
         │
         ▼
[ GZip Decompression (RFC 1952) ] (si empieza por cabecera 0x1F 0x8B)
         │
         ▼
[ Base64 Decoding (ASCII UTF-8) ]
         │
         ▼
[ AES-256-ECB / Rijndael Decryption ] (Padding PKCS7)
         │
         ▼
[ Plaintext UTF-8 JSON Data ]
         │
         ▼
[ Newtonsoft.Json -> C# Models (MusicData[], CardData[], etc.) ]
```

---

## 2. Parámetros Criptográficos Maestros

* **Algoritmo:** AES (Rijndael)
* **Tamaño de Clave:** 256 bits (32 bytes)
* **Modo de Operación:** ECB (Electronic Codebook)
* **Padding:** PKCS7
* **Clave Maestra AES-256:**
  * **ASCII:** `WnFKN1v_gUcgmUVZnjjjGXGwk557zBSO`
  * **Hex:** `576e464b4e31765f675563676d55565a6e6a6a6a475847776b3535377a42534f`

> [!NOTE]
> La clase interna de C# `com.dalcomsoft.project.client.CipherSimple` configura `cryptoAlg.Key` utilizando `Encoding.UTF8.GetBytes("WnFKN1v_gUcgmUVZnjjjGXGwk557zBSO")`. Aunque internamente define `CipherMode.CBC` para llamadas de red con transform, los archivos `.bin` estáticos generados por el pipeline de build de Dalcomsoft están empaquetados en bloques independientes alineados (ECB / Zero-vector CBC) con PKCS7.

---

## 3. Mapeo de Archivos `.bin` y Estructuras C#

| Archivo `.bin` | Clase C# en `Assembly-CSharp.dll` | Tipo de Clave | Descripción |
| :--- | :--- | :--- | :--- |
| `msd.bin` | `com.dalcomsoft.project.app.data.MusicData` | `short` (code) | Listado de canciones, URLs de audio (`.ogg`), beatmaps (`.seq`), portadas, colores de fondo y dificultad |
| `cdd.bin` | `com.dalcomsoft.project.app.data.CardData` | `int` (code) | Catálogo de cartas coleccionables, grados (C a R), temas, artistas y estadísticas |
| `tmd.bin` | `com.dalcomsoft.project.app.data.ThemeData` | `int` (code) | Definición de temas visuales para cartas |
| `atd.bin` | `com.dalcomsoft.project.app.data.ArtistData` | `int` (code) | Información de miembros/artistas y grupos |
| `gpd.bin` | `com.dalcomsoft.project.app.data.GroupData` | `int` (code) | Definición de subunidades y grupos principales |
| `lcd.bin` | `com.dalcomsoft.project.app.data.LocaleData` | `int` (code) | Textos localizados en múltiples idiomas (11,000+ strings) |
| `gcd.bin` | `com.dalcomsoft.project.app.data.GameConfigData` | `int` (code) | Parámetros de balance, timing de notas y configuración global |
| `url.bin` | `com.dalcomsoft.project.app.data.UrlMap` | `string` | Mapeo maestro de URLs de CDN (18,000+ recursos) |
| `lbg.bin` | `com.dalcomsoft.project.app.data.LobbyBgData` | `short` (code) | Fondos de pantalla del lobby |
| `emd.bin` | `com.dalcomsoft.project.app.data.EventMissionData`| `short` (code) | Misiones y eventos |

---

## 4. Estructura de `MusicData` (`msd.json`)

El archivo `msd.json` contiene la definición exacta de cada canción en el juego:

```json
{
  "code": 1001,
  "albumName": 10080101,
  "analyticsData": "[+ +]_Hi High [Verse 1]",
  "sound": "http://d3exy8s96shf22.cloudfront.net/resources/sounds/hi_high/loona_hi_high.ogg?v=22083001",
  "previewSound": "http://d3exy8s96shf22.cloudfront.net/resources/sounds/hi_high/loona_hi_high_preview.ogg?v=22083001",
  "seqEasy": "http://d3exy8s96shf22.cloudfront.net/resources/sounds/hi_high/loona_hi_high_4.seq?v=22083001",
  "seqNormal": "http://d3exy8s96shf22.cloudfront.net/resources/sounds/hi_high/loona_hi_high_7.seq?v=22083001",
  "seqHard": "http://d3exy8s96shf22.cloudfront.net/resources/sounds/hi_high/loona_hi_high_13.seq?v=22083001",
  "artistCode": "[1001,1002,1003,1004,1005,1006,1007,1008,1009,1010,1011]",
  "easyPatternCount": 378,
  "normalPatternCount": 537,
  "hardPatternCount": 777,
  "albumBgColor": "0x1c3f43FF",
  "albumFontColor": "0xFFFFFFFF",
  "challengable": true,
  "isLocked": false
}
```

---

## 5. Herramienta CLI (`tools/decrypt_dalcom.py`)

La herramienta [tools/decrypt_dalcom.py](file:///Users/ignaciorojas/Documents/repos/sslo_apk/tools/decrypt_dalcom.py) automatiza la desencriptación y re-encriptación de archivos individuales y por lotes.

### Desencriptar un archivo binario a JSON:
```bash
python tools/decrypt_dalcom.py decrypt "app/src/files/asiudgasg (ss)/sdisgkdc (data)/msd.bin" -o msd.json
```

### Desencriptar todos los archivos `.bin` de una carpeta:
```bash
python tools/decrypt_dalcom.py batch-decrypt "app/src/files/asiudgasg (ss)/sdisgkdc (data)/"
```

### Re-encriptar un archivo JSON modificado a `.bin`:
```bash
python tools/decrypt_dalcom.py encrypt msd.json -o "app/src/files/asiudgasg (ss)/sdisgkdc (data)/msd.bin"
```
