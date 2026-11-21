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
SDHGAU_DIR = os.path.join(FILES_DIR, "asiudgasg/asodhsg/sdhgauwehdnu")
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
        # Mapear primero las cartas normales (type == 0) para vincular el cardEmpty correcto a cada miembro
        normal_cards_by_artist = {c["artistID"]: c for c in t_cards if c.get("type", 0) == 0}

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

            # 1. IMÁGENES EQUIPADAS (wadceg/)
            # Ambas son versiones de la carta EQUIPADA (foto del idol) usadas según situación (S o L)
            eq_s_rel = f"asiudgasg/asodhsg/wadceg/{c_code}_s.i.bytes.png"
            eq_l_rel = f"asiudgasg/asodhsg/wadceg/{c_code}_l.i.bytes.png"
            eq_s_abs = os.path.join(FILES_DIR, eq_s_rel)
            eq_l_abs = os.path.join(FILES_DIR, eq_l_rel)

            eq_s_exists = os.path.exists(eq_s_abs)
            eq_l_exists = os.path.exists(eq_l_abs)

            was_upscaled = False
            if not eq_l_exists and eq_s_exists:
                was_upscaled = ensure_upscaled_fallback(eq_s_abs, eq_l_abs)
                if was_upscaled:
                    eq_l_exists = True
                    audit_results["summary"]["cards_upscaled_fallback"] += 1
                    audit_results["summary"]["anomalies"].append({
                        "cardCode": c_code,
                        "themeCode": t_code,
                        "artist": a_name,
                        "type": "Missing large card image in official Dalcom CDN, synthesized Lanczos fallback (226x318)"
                    })

            if eq_s_exists:
                audit_results["summary"]["cards_with_small_img"] += 1
            if eq_l_exists:
                audit_results["summary"]["cards_with_large_img"] += 1

            # Extraer dimensiones de equipadas
            eq_s_dim = None
            eq_l_dim = None
            if eq_s_exists:
                try:
                    with Image.open(eq_s_abs) as im:
                        eq_s_dim = list(im.size)
                except Exception:
                    pass
            if eq_l_exists:
                try:
                    with Image.open(eq_l_abs) as im:
                        eq_l_dim = list(im.size)
                except Exception:
                    pass

            # 2. IMÁGENES NO EQUIPADAS / EMPTY (sdhgauwehdnu/)
            # Regla de Ignacio: Las cartas Prismas comparten exactamente el mismo cardEmpty que su carta normal en ese tema.
            norm_card = normal_cards_by_artist.get(a_code, c)
            empty_s_rel = None
            empty_l_rel = None
            empty_source_type = "theme_cdn"
            empty_target_code = norm_card["code"]

            # Intentar resolver vía URL _em.png del CDN para la carta normal de ese tema
            norm_s_url = norm_card.get("cardImageSmall", "").split("?")[0]
            norm_em_url = norm_s_url.replace(".png", "_em.png")
            for k, v in usm.items():
                if norm_em_url in k:
                    empty_s_rel = "asiudgasg/" + v + ".png" if not v.endswith(".png") else "asiudgasg/" + v
                    l_val = v.replace("_s.i.bytes", "_l.i.bytes")
                    empty_l_rel = "asiudgasg/" + l_val + ".png" if not l_val.endswith(".png") else "asiudgasg/" + l_val
                    empty_source_type = "theme_cdn"
                    break

            # Si no se encuentra vía CDN del tema, recurrir a emptyImageSmall canónico en atd.json
            if not empty_s_rel or not os.path.exists(os.path.join(FILES_DIR, empty_s_rel)):
                a_empty_s_url = a_info.get("emptyImageSmall", "")
                if a_empty_s_url and a_empty_s_url in usm:
                    v_s = usm[a_empty_s_url]
                    empty_s_rel = "asiudgasg/" + v_s + ".png" if not v_s.endswith(".png") else "asiudgasg/" + v_s
                    a_empty_l_url = a_info.get("emptyImageLarge", "")
                    v_l = usm.get(a_empty_l_url, v_s.replace("_s.i.bytes", "_l.i.bytes"))
                    empty_l_rel = "asiudgasg/" + v_l + ".png" if not v_l.endswith(".png") else "asiudgasg/" + v_l
                    empty_source_type = "artist_canonical_atd"
                    empty_target_code = a_code

            # Fallback seguro por artistCode
            if not empty_s_rel or not os.path.exists(os.path.join(FILES_DIR, empty_s_rel)):
                empty_s_rel = f"asiudgasg/asodhsg/sdhgauwehdnu/{a_code}_s.i.bytes.png"
                empty_l_rel = f"asiudgasg/asodhsg/sdhgauwehdnu/{a_code}_l.i.bytes.png"
                empty_source_type = "artist_id_fallback"
                empty_target_code = a_code

            empty_s_abs = os.path.join(FILES_DIR, empty_s_rel)
            empty_l_abs = os.path.join(FILES_DIR, empty_l_rel)
            empty_s_exists = os.path.exists(empty_s_abs)
            empty_l_exists = os.path.exists(empty_l_abs)

            empty_s_dim = None
            empty_l_dim = None
            if empty_s_exists:
                try:
                    with Image.open(empty_s_abs) as im:
                        empty_s_dim = list(im.size)
                except Exception:
                    pass
            if empty_l_exists:
                try:
                    with Image.open(empty_l_abs) as im:
                        empty_l_dim = list(im.size)
                except Exception:
                    pass

            card_entry = {
                "cardCode": c_code,
                "artistCode": a_code,
                "artistName": a_name,
                "type": c_type,
                "typeName": "Prism" if c_type == 1 else "Normal",
                "equipped": {
                    "small": {
                        "path": eq_s_rel,
                        "exists": eq_s_exists,
                        "dimensions": eq_s_dim,
                        "usage": "Equipada (S) / Miniatura Grid Inventario & CardBook obtenido"
                    },
                    "large": {
                        "path": eq_l_rel,
                        "exists": eq_l_exists,
                        "dimensions": eq_l_dim,
                        "isUpscaledFallback": was_upscaled,
                        "usage": "Equipada (L) / Pedestal Inventario, CardDetailView, In-Game"
                    }
                },
                "unequipped": {
                    "sourceType": empty_source_type,
                    "targetCode": empty_target_code,
                    "small": {
                        "path": empty_s_rel,
                        "exists": empty_s_exists,
                        "dimensions": empty_s_dim,
                        "usage": "No Equipada (S) / Slot Vacío Miniatura (cardEmpty / artistEmpty)"
                    },
                    "large": {
                        "path": empty_l_rel,
                        "exists": empty_l_exists,
                        "dimensions": empty_l_dim,
                        "usage": "No Equipada (L) / Slot Vacío Pedestal (cardEmpty / artistEmpty)"
                    }
                },
                # Mantenemos retrocompatibilidad con las claves previas
                "smallImage": {
                    "path": eq_s_rel,
                    "exists": eq_s_exists,
                    "dimensions": eq_s_dim,
                    "usage": "Equipada (S)"
                },
                "largeImage": {
                    "path": eq_l_rel,
                    "exists": eq_l_exists,
                    "dimensions": eq_l_dim,
                    "isUpscaledFallback": was_upscaled,
                    "usage": "Equipada (L)"
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
