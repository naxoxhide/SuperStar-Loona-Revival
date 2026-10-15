# Ingeniería Inversa: Estadísticas de Cartas, Balance y Sistema de Intensify / Grade Up (Dalcomsoft Engine)

Este documento detalla los hallazgos de ingeniería inversa obtenidos a partir de la descompilación de metadatos IL2CPP (`dump/dump.cs`) y la desencriptación criptográfica de las tablas maestras de datos (`app/src/files/asiudgasg/sdisgkdc/`) en el motor de **SuperStar LOONA** (`com.dalcomsoft.sslo`).

---

## 1. Arquitectura de Almacenamiento Criptográfico (`sdisgkdc`)

En el motor Dalcomsoft, las tablas estáticas del juego residen en la carpeta de recursos `app/src/files/asiudgasg/sdisgkdc/` con extensión `.bin`.
Cada archivo atraviesa el siguiente pipeline criptográfico simétrico:

```
[ Archivo .bin en disco ]
         │
         ▼
[ GZip Decompression (RFC 1952) ] (detectado por cabecera 0x1F, 0x8B)
         │
         ▼
[ Base64 Decoding (ASCII UTF-8) ]
         │
         ▼
[ AES-256-ECB Decryption ] (Clave: "WnFKN1v_gUcgmUVZnjjjGXGwk557zBSO", Padding PKCS7)
         │
         ▼
[ Plaintext UTF-8 JSON Data ]
```

---

## 2. Desglose de Archivos de Configuración Binarios

### 2.1. `cbd.bin` (`CardBalanceData` — 119 Registros)
Es la **tabla maestra de estadísticas** que rige el Score y Energy de cada carta en el juego. Contiene exactamente 119 entradas indexadas de `0` a `118`.

#### Fórmula Matemática de Mapeo de Niveles:
Para los grados C, B, A y S (5 niveles cada uno):
$$\text{Código} = (\text{Grado} \times 5) + (\text{Nivel} - 1)$$

Para el grado R (hasta nivel 99 / capado a 50 en SuperStar LOONA):
$$\text{Código} = 20 + (\text{Nivel} - 1)$$

#### Tabla de Estadísticas por Grado y Nivel:

| Grado | Niveles | Códigos en `cbd.bin` | Min Score | Max Score | Min Energy | Max Energy | Prizm Score |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **C** | 1 — 5 | `0` — `4` | 10 — 22 | 12 — 24 | 10 — 22 | 12 — 24 | +10 |
| **B** | 1 — 5 | `5` — `9` | 25 — 37 | 27 — 39 | 25 — 37 | 27 — 39 | +10 |
| **A** | 1 — 5 | `10` — `14` | 40 — 60 | 44 — 64 | 40 — 60 | 44 — 64 | +10 |
| **S** | 1 — 5 | `15` — `19` | 65 — 93 | 71 — 99 | 65 — 93 | 71 — 99 | +10 |
| **R (Inicio)** | 1 | `20` | 101 | 101 | 100 | 100 | +10 |
| **R (Intermedio)** | 25 | `44` | 149 | 149 | 100 | 100 | +10 |
| **R (Cap SSLO)** | **50** | **`69`** | **199** | **199** | **100** | **100** | **+10** |
| **R (Máx Engine)** | 99 | `118` | 199 | 199 | 100 | 100 | +10 |

> [!NOTE]
> * **Score:** Multiplicador directo de puntos por nota durante las canciones. Una carta R50 (Score 199) produce un rendimiento ~20 veces superior al de una carta C1 (Score 10).
> * **Energy:** Salud de la barra de vida y resistencia a fallos (*Miss*). A partir de Grado R nivel 1, la energía se fija en su límite absoluto (`100`), haciendo a la integrante casi invulnerable al "Song Failed".
> * **PrizmScore (+10):** Las cartas con `isPrism = true` suman +10 puntos planos directamente sobre su Score base.

---

### 2.2. `cgd.bin` (`CardGradeBonusData` — 5 Registros)
Define las bonificaciones macro asociadas al grado de la carta:

| Grado (Code) | Nombre | `gradeValue` | `abilityValue` | `cardBookValue` |
| :---: | :---: | :---: | :---: | :---: |
| `0` | **Grado C** | 0.0 | 10,000 | 1 |
| `1` | **Grado B** | 1.0 | 20,000 | 2 |
| `2` | **Grado A** | 2.5 | 30,000 | 3 |
| `3` | **Grado S** | 4.0 | 50,000 | 4 |
| `4` | **Grado R** | 5.0 | 100,000 | 0 |

* **Bonificación de Inicio (`gradeScore` / Start Grade Bonus):**
  Al iniciar una canción, el juego calcula el promedio ponderado de los grados de las 11 cartas equipadas. Si todas las integrantes de LOONA tienen equipado Grado R (`abilityValue = 100,000`), el jugador arranca la partida con **+500,000 puntos** automáticos en pantalla (`Group Grade R`).

---

### 2.3. `cid.bin` (`CardIntensifyData` — Matriz de Mejora)
Estructura matricial que define las reglas para subir de nivel una carta consumiendo cartas de material:

1. **Precios en Rhythm Points (RP) por Intento (`Price`):**
   * Grado C: C1 = 93 RP, C2 = 97 RP, C3 = 100 RP, C4 = 103 RP, C5 = 107 RP.
   * Grado B: B1 = 110 RP, B2 = 114 RP, B3 = 118 RP, B4 = 122 RP, B5 = 126 RP.
   * Grado A: A1 = 131 RP, A2 = 135 RP, A3 = 140 RP, A4 = 144 RP, A5 = 149 RP.
   * Grado S: S1 = 154 RP, S2 = 159 RP, S3 = 164 RP, S4 = 170 RP, S5 = 175 RP.
   * Grado R: R1 = 176 RP ... R50 = 225 RP (crecimiento progresivo de +1 RP por nivel).
2. **Probabilidades de Éxito (`Rate` en %):**
   * Usar material de mayor grado que la carta base otorga 100% de éxito.
   * Usar material de igual grado otorga ~70% de éxito.
   * Usar material de menor grado reduce la tasa a ~10% - 25%.
   * Valores `-2.0` en la matriz señalan combinaciones no permitidas.

---

### 2.4. `csd.bin` (`CardSellData` — Precios de Venta)
* Grado C: 200 RP
* Grado B: 400 RP
* Grado A: 600 RP
* Grado S: 800 RP
* Grado R: 1,200 RP

---

## 3. Arquitectura del Ciclo de Vida en IL2CPP C# (dump.cs)

### 3.1. Clases y Métodos Críticos de Mejora

```
InventoryScene
  ├── OnEquipCardIntensify() (0x578603)
  └── GetIntensifyViewData(...) (0x578699)
        │
        ▼
InvenCardIntensifyView (0xF22024)
  ├── OnMaterial(GameObject go) (0xF226A4)   ← Selección de hasta 5 cartas material
  ├── OnRecommend() (0xF22704)               ← Auto-selección inteligente
  └── OnTry() (0xF22758)                     ← Confirmación de Power Up
        │
        ▼
InventoryControl.Intensify (0xF1DCCC)        ← MÉTODO RPC ORIGINAL DE RED
  ├── Intensify_Step_2 (0xF2C84C)            ← Callback de respuesta del servidor
  └── Intensify_Step_3 (0xF2CE50)            ← Aplicación de resultados
        │
        ▼
CardIntensifyPopup (0xE45344)                ← Ventana emergente nativa con animación
  ├── soundSucceed / soundFailed
  └── onResultSucceed / onResultFailed
```

### 3.2. Clases de Soporte de Datos
* `CardIntensifyControl`: RVA `0x137F7E0` (Administra el diccionario de probabilidades).
* `CardIntensifyControl.Item`: Contiene campos `<Rate>k__BackingField` (`0x10`) y `<Price>k__BackingField` (`0x18`).
* `CardIntensifyResult` (Enum): `SUCCESS = 0`, `FAILED = 1`, `ABORT = 2`.

---

## 4. Persistencia Local Standalone (`player_profile.json`)

Para mantener el funcionamiento 100% offline, el resultado de cualquier mejora se persiste directamente en:
`/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/player_profile.json`

Estructura de cada carta en `inventoryCards`:
```json
{
  "objectID": 100001,
  "cardID": 1001,
  "grade": 4,
  "level": 50,
  "energy": 100,
  "score": 199,
  "isEquip": true,
  "isLock": false,
  "isPrism": false
}
```

Al completarse un intento de mejora con éxito:
1. `level` se incrementa en +1.
2. `score` y `energy` se consultan en la tabla `cbd` y se actualizan en el JSON.
3. Se descuenta el `price` de los Rhythm Points (`rhythmPoint`).
4. Se eliminan del arreglo `inventoryCards` las cartas utilizadas como material de sacrificio.
