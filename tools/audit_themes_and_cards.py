#!/usr/bin/env python3
"""
tools/audit_themes_and_cards.py
Auditoría Forense y Extracción Exhaustiva de Temas y Cartas (Normales y LE) en Dalcomsoft SSLO.
Genera la base de datos normalizada para la documentación técnica y el visor visual interactivo.
"""

import os
import json
import sys
from PIL import Image

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
DATA_DIR = os.path.join(BASE_DIR, "app/src/files/asiudgasg/sdisgkdc")
FILES_DIR = os.path.join(BASE_DIR, "app/src/files")
WADCEG_DIR = os.path.join(FILES_DIR, "asiudgasg/asodhsg/wadceg")
AGEW_DIR = os.path.join(FILES_DIR, "asiudgasg/asodhsg/agewfcbxhaa")
UHEX_DIR = os.path.join(FILES_DIR, "asiudgasg/asodhsg/aoeiwhslc/uhex")

PLAYABLE_GROUPS = (
    [1001, 2001, 3001, 4001, 5001, 6001]
    + list(range(7001, 18001, 1000))
    + [18001, 19001, 20001, 21001]
)

def load_json(filename):
    path = os.path.join(DATA_DIR, filename)
    with open(path, "r", encoding="utf-8") as f:
        return json.load(f)

def ensure_upscaled_fallback(small_path, large_path):
    """
    Si falta la imagen grande (como en 17013-17018), genera un fallback con Lanczos
    a resolución nativa de carta grande (226x318) para evitar pantallas blancas o roturas.
    """
    if os.path.exists(large_path):
        return False
    if not os.path.exists(small_path):
        return False
    try:
        with Image.open(small_path) as im:
            upscaled = im.resize((226, 318), Image.Resampling.LANCZOS)
            os.makedirs(os.path.dirname(large_path), exist_ok=True)
            upscaled.save(large_path, format="PNG")
            return True
    except Exception as e:
        print(f"Error upscaling {small_path}: {e}", file=sys.stderr)
        return False

def main():
    print("[1/5] Cargando bases de datos de metadatos Dalcomsoft...")
    cdd = load_json("cdd.json")
    tmd = load_json("tmd.json")
    ttd = load_json("ttd.json")
    grd = load_json("grd.json")
    atd = load_json("atd.json")
    lcd = load_json("lcd.json")
    usm = load_json("url_shared_map.json")

    lcd_map = {item["code"]: item for item in lcd}
    grd_map = {g["code"]: g for g in grd}
    atd_map = {a["code"]: a for a in atd}
    ttd_map = {tt["code"]: tt for tt in ttd}
    tmd_map = {t["code"]: t for t in tmd}

    print(f"  -> Total Temas en tmd: {len(tmd)}")
    print(f"  -> Total Cartas en cdd: {len(cdd)}")
    print(f"  -> Total ThemeTypes en ttd: {len(ttd)}")

    # Indexar cartas por tema y artista
    cards_by_theme = {}
    for c in cdd:
        t_id = c.get("theme")
        cards_by_theme.setdefault(t_id, []).append(c)

    print("[2/5] Auditando y verificando assets físicos en disco...")
    audit_results = {
        "groups": {},
        "summary": {
            "total_themes": len(tmd),
            "normal_themes": 0,
            "limited_themes": 0,
            "total_cards": len(cdd),
            "normal_cards": 0,
            "prism_cards": 0,
            "cards_with_small_img": 0,
            "cards_with_large_img": 0,
            "cards_upscaled_fallback": 0,
            "anomalies": []
        }
    }

    # Procesar grupos
    for g_code in PLAYABLE_GROUPS:
        g = grd_map.get(g_code, {})
        loc = lcd_map.get(g.get("localeName", 0), {})
        g_name = loc.get("enUS") or g.get("analyticsData") or f"Group {g_code}"
        
        audit_results["groups"][str(g_code)] = {
            "code": g_code,
            "name": g_name,
            "analyticsData": g.get("analyticsData"),
            "equipableSlot": g.get("equipableSlot", 11),
            "emblem_path": f"asiudgasg/asodhsg/aweoijs/{g_code}.i.bytes.png",
            "themes": []
        }

    # Procesar temas
    for t in tmd:
        t_code = t["code"]
        loc = lcd_map.get(t.get("localeName", 0), {})
        t_name = loc.get("enUS") or t.get("analyticsData") or f"Theme {t_code}"
        is_le = t.get("limitedType", 0) != 0
        tt_code = t.get("themeTypeCode", 0)
        tt_info = ttd_map.get(tt_code, {})

        if is_le:
            audit_results["summary"]["limited_themes"] += 1
        else:
            audit_results["summary"]["normal_themes"] += 1

        # Encontrar grupo al que pertenece este tema
        t_cards = cards_by_theme.get(t_code, [])
        g_code = t_cards[0].get("groupID") if t_cards else None

        # Verificar logos de tema
        t_logo_s_rel = f"asiudgasg/asodhsg/agewfcbxhaa/{t_code}_s.i.bytes.png"
        t_logo_l_rel = f"asiudgasg/asodhsg/agewfcbxhaa/{t_code}_l.i.bytes.png"
        t_logo_s_abs = os.path.join(FILES_DIR, t_logo_s_rel)
        t_logo_l_abs = os.path.join(FILES_DIR, t_logo_l_rel)

        theme_entry = {
            "code": t_code,
            "name": t_name,
            "analyticsData": t.get("analyticsData"),
            "isLimited": is_le,
            "limitedType": t.get("limitedType", 0),
            "themeTypeCode": tt_code,
            "cardbookMarkCode": t.get("cardbookMarkCode"),
            "logoSmallPath": t_logo_s_rel if os.path.exists(t_logo_s_abs) else None,
            "logoLargePath": t_logo_l_rel if os.path.exists(t_logo_l_abs) else None,
            "themeTypeFrames": {
                "gradeC": f"asiudgasg/asodhsg/aoeiwhslc/uhex/{tt_code}_c_s.i.bytes.png",
                "gradeB": f"asiudgasg/asodhsg/aoeiwhslc/uhex/{tt_code}b_s.i.bytes.png",
                "gradeA": f"asiudgasg/asodhsg/aoeiwhslc/uhex/{tt_code}_a_s.i.bytes.png",
                "gradeS": f"asiudgasg/asodhsg/aoeiwhslc/uhex/{tt_code}_s_s.i.bytes.png",
                "gradeR": f"asiudgasg/asodhsg/aoeiwhslc/uhex/{tt_code}_r_s.i.bytes.png",
            },
            "cards": []
        }

        # Procesar cartas dentro del tema
        for c in t_cards:
            c_code = c["code"]
            a_code = c.get("artistID")
            a_info = atd_map.get(a_code, {})
            a_loc = lcd_map.get(a_info.get("localeName", 0), {})
            a_name = a_loc.get("enUS") or a_info.get("analyticsData") or f"Artist {a_code}"
            c_type = c.get("type", 0)  # 0: Normal, 1: Prism

            if c_type == 1:
                audit_results["summary"]["prism_cards"] += 1
            else:
                audit_results["summary"]["normal_cards"] += 1

            s_rel = f"asiudgasg/asodhsg/wadceg/{c_code}_s.i.bytes.png"
            l_rel = f"asiudgasg/asodhsg/wadceg/{c_code}_l.i.bytes.png"
            s_abs = os.path.join(FILES_DIR, s_rel)
            l_abs = os.path.join(FILES_DIR, l_rel)

            s_exists = os.path.exists(s_abs)
            l_exists = os.path.exists(l_abs)

            was_upscaled = False
            if not l_exists and s_exists:
                was_upscaled = ensure_upscaled_fallback(s_abs, l_abs)
                if was_upscaled:
                    l_exists = True
                    audit_results["summary"]["cards_upscaled_fallback"] += 1
                    audit_results["summary"]["anomalies"].append({
                        "cardCode": c_code,
                        "themeCode": t_code,
                        "artist": a_name,
                        "type": "Missing large card image in official Dalcom CDN, synthesized Lanczos fallback (226x318)"
                    })

            if s_exists:
                audit_results["summary"]["cards_with_small_img"] += 1
            if l_exists:
                audit_results["summary"]["cards_with_large_img"] += 1

            # Extraer dimensiones reales
            s_dim = None
            l_dim = None
            if s_exists:
                try:
                    with Image.open(s_abs) as im:
                        s_dim = list(im.size)
                except Exception:
                    pass
            if l_exists:
                try:
                    with Image.open(l_abs) as im:
                        l_dim = list(im.size)
                except Exception:
                    pass

            card_entry = {
                "cardCode": c_code,
                "artistCode": a_code,
                "artistName": a_name,
                "type": c_type,
                "typeName": "Prism" if c_type == 1 else "Normal",
                "smallImage": {
                    "path": s_rel,
                    "exists": s_exists,
                    "dimensions": s_dim,
                    "usage": "Carta No Equipada / Inventario Grid / CardBook miniatura"
                },
                "largeImage": {
                    "path": l_rel,
                    "exists": l_exists,
                    "dimensions": l_dim,
                    "isUpscaledFallback": was_upscaled,
                    "usage": "Carta Equipada / Inventario Pedestal / CardBook Detail Popup"
                },
                "rawCdnUrlSmall": c.get("cardImageSmall"),
                "rawCdnUrlLarge": c.get("cardImageLarge")
            }
            theme_entry["cards"].append(card_entry)

        # Ordenar cartas por artistCode y type
        theme_entry["cards"].sort(key=lambda x: (x["artistCode"], x["type"]))

        if g_code and str(g_code) in audit_results["groups"]:
            audit_results["groups"][str(g_code)]["themes"].append(theme_entry)

    # Ordenar temas por code en cada grupo
    for g_code, g_data in audit_results["groups"].items():
        g_data["themes"].sort(key=lambda x: x["code"])

    print("[3/5] Guardando auditoría estructurada en docs/audit_themes_and_cards.json...")
    out_json = os.path.join(BASE_DIR, "docs/audit_themes_and_cards.json")
    os.makedirs(os.path.dirname(out_json), exist_ok=True)
    with open(out_json, "w", encoding="utf-8") as f:
        json.dump(audit_results, f, indent=2, ensure_ascii=False)
    print(f"  -> Generado {out_json}")

    print("\n[=== RESUMEN DE AUDITORÍA ===]")
    print(f"Total Temas Auditados: {audit_results['summary']['total_themes']}")
    print(f"  - Temas Normales: {audit_results['summary']['normal_themes']}")
    print(f"  - Temas Limited Edition (LE): {audit_results['summary']['limited_themes']}")
    print(f"Total Cartas Auditadas: {audit_results['summary']['total_cards']}")
    print(f"  - Cartas Normales: {audit_results['summary']['normal_cards']}")
    print(f"  - Cartas Prismas: {audit_results['summary']['prism_cards']}")
    print(f"  - Con Imagen Pequeña (_s, No Equipada): {audit_results['summary']['cards_with_small_img']}")
    print(f"  - Con Imagen Grande (_l, Equipada): {audit_results['summary']['cards_with_large_img']}")
    print(f"  - Fallbacks Lanczos sintetizados: {audit_results['summary']['cards_upscaled_fallback']}")
    print(f"Total Anomalías Detectadas: {len(audit_results['summary']['anomalies'])}")
    for an in audit_results["summary"]["anomalies"]:
        print(f"  * [Carta {an['cardCode']}] Tema {an['themeCode']} ({an['artist']}): {an['type']}")

if __name__ == "__main__":
    main()
