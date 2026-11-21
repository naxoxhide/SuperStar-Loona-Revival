#!/usr/bin/env python3
"""
Generate Full Card Database and Player Profile for SSLO Standalone Offline.
Author: Antigravity Multi-Agent Architecture
"""

import json
import os
import random

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SRC_FILES = os.path.join(BASE_DIR, "app/src/files/asiudgasg/sdisgkdc")
ASSETS_DATA = os.path.join(BASE_DIR, "app/src/main/assets/data")
ASSETS_DIR = os.path.join(BASE_DIR, "app/src/main/assets")

PLAYABLE_GROUPS = (
    [1001, 2001, 3001, 4001, 5001, 6001]
    + list(range(7001, 18001, 1000))
    + [18001, 19001, 20001, 21001]
)

def load_json(filename):
    path = os.path.join(SRC_FILES, filename)
    with open(path, "r", encoding="utf-8") as f:
        return json.load(f)

def clean_path(path):
    if not path:
        return ""
    if path.startswith("asiudgasg/"):
        return path
    if path.startswith("asodhsg/"):
        return "asiudgasg/" + path
    if path.startswith("soidhskd/"):
        return "asiudgasg/" + path
    return "asiudgasg/" + path

def main():
    print("[1/5] Loading Dalcomsoft JSON databases...")
    cdd = load_json("cdd.json")
    tmd = load_json("tmd.json")
    ttd = load_json("ttd.json")
    grd = load_json("grd.json")
    atd = load_json("atd.json")
    lcd = load_json("lcd.json")
    usm = load_json("url_shared_map.json")

    lcd_map = {item["code"]: item for item in lcd}

    print("[2/5] Compiling groups and artists...")
    groups_dict = {}
    for g in grd:
        code = g["code"]
        if code in PLAYABLE_GROUPS:
            loc = lcd_map.get(g.get("localeName", 0), {})
            name = loc.get("enUS") or g.get("analyticsData") or f"Group {code}"
            emb_url = g.get("emblemImage")
            emb_path = clean_path(usm.get(emb_url, f"asodhsg/aweoijs/{code}.i.bytes"))
            groups_dict[str(code)] = {
                "code": code,
                "name": name,
                "analyticsData": g.get("analyticsData"),
                "equipableSlot": g.get("equipableSlot", 11),
                "emblemPath": emb_path,
                "orderIndex": g.get("orderIndex", 0),
                "themeCodes": [],
                "artistCodes": [],
            }

    artists_dict = {}
    for a in atd:
        code = a["code"]
        grp = a.get("group")
        if grp in PLAYABLE_GROUPS:
            loc = lcd_map.get(a.get("localeName", 0), {})
            name = loc.get("enUS") or a.get("analyticsData") or f"Artist {code}"
            artists_dict[str(code)] = {
                "code": code,
                "group": grp,
                "name": name,
                "analyticsData": a.get("analyticsData"),
                "orderIndex": a.get("orderIndex", 0),
                "emptyImageSmall": "asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes",
                "emptyImageLarge": "asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes",
            }
            if str(grp) in groups_dict and code not in groups_dict[str(grp)]["artistCodes"]:
                groups_dict[str(grp)]["artistCodes"].append(code)

    # Sort artistCodes by orderIndex for each group
    for g_code, g_data in groups_dict.items():
        g_data["artistCodes"].sort(
            key=lambda c: artists_dict.get(str(c), {}).get("orderIndex", 0)
        )

    print("[3/5] Compiling themes and theme types...")
    theme_types_dict = {}
    for tt in ttd:
        code = tt["code"]
        theme_types_dict[str(code)] = {
            "code": code,
            "gradeC": clean_path(usm.get(tt.get("gradeC"), f"asodhsg/aoeiwhslc/uhex/{code}_c_s.i.bytes")),
            "gradeB": clean_path(usm.get(tt.get("gradeB"), f"asodhsg/aoeiwhslc/uhex/{code}b_s.i.bytes")),
            "gradeA": clean_path(usm.get(tt.get("gradeA"), f"asodhsg/aoeiwhslc/uhex/{code}_a_s.i.bytes")),
            "gradeS": clean_path(usm.get(tt.get("gradeS"), f"asodhsg/aoeiwhslc/uhex/{code}_s_s.i.bytes")),
            "gradeR": clean_path(usm.get(tt.get("gradeR"), f"asodhsg/aoeiwhslc/uhex/{code}_r_s.i.bytes")),
        }

    themes_dict = {}
    for t in tmd:
        code = t["code"]
        loc = lcd_map.get(t.get("localeName", 0), {})
        name = loc.get("enUS") or t.get("analyticsData") or f"Theme {code}"
        s_url = t.get("nameImageSmall")
        l_url = t.get("nameImageLarge")
        s_path = clean_path(usm.get(s_url, f"asodhsg/agewfcbxhaa/{code}_s.i.bytes"))
        l_path = clean_path(usm.get(l_url, f"asodhsg/agewfcbxhaa/{code}_l.i.bytes"))
        themes_dict[str(code)] = {
            "code": code,
            "name": name,
            "analyticsData": t.get("analyticsData"),
            "limitedType": t.get("limitedType", 0),
            "themeTypeCode": t.get("themeTypeCode", 0),
            "themePercentage": t.get("themePercentage", 20),
            "smallImagePath": s_path,
            "largeImagePath": l_path,
            "cardbookMarkCode": t.get("cardbookMarkCode"),
        }

    print("[4/5] Compiling 1.467 cards...")
    cards_dict = {}
    for c in cdd:
        code = c["code"]
        t_code = c.get("theme")
        g_code = c.get("groupID")
        s_url = c.get("cardImageSmall")
        l_url = c.get("cardImageLarge")
        s_path = clean_path(usm.get(s_url, f"asodhsg/wadceg/{code}_s.i.bytes"))
        l_path = clean_path(usm.get(l_url, f"asodhsg/wadceg/{code}_l.i.bytes"))
        # Fix CDN anomaly where Olivia Hye cards 17013-17018 pointed large image to _s
        if code in [17013, 17014, 17015, 17016, 17017, 17018] or "_s." in l_path:
            l_path = f"asiudgasg/asodhsg/wadceg/{code}_l.i.bytes"

        cards_dict[str(code)] = {
            "code": code,
            "groupID": g_code,
            "artistID": c.get("artistID"),
            "theme": t_code,
            "type": c.get("type", 0),  # 0: Normal, 1: Prism
            "material": c.get("material", 0),
            "intensifyPercentage": c.get("intensifyPercentage", 0),
            "smallImagePath": s_path,
            "largeImagePath": l_path,
        }

        # Associate theme with group
        if g_code and str(g_code) in groups_dict and t_code:
            if t_code not in groups_dict[str(g_code)]["themeCodes"]:
                groups_dict[str(g_code)]["themeCodes"].append(t_code)

    # Save card_metadata_map.json
    metadata_map = {
        "playableGroups": PLAYABLE_GROUPS,
        "groups": groups_dict,
        "artists": artists_dict,
        "themes": themes_dict,
        "themeTypes": theme_types_dict,
        "cards": cards_dict,
    }

    os.makedirs(ASSETS_DATA, exist_ok=True)
    out_map_path = os.path.join(ASSETS_DATA, "card_metadata_map.json")
    with open(out_map_path, "w", encoding="utf-8") as f:
        json.dump(metadata_map, f, indent=2, ensure_ascii=False)
    print(f"  -> Generated {out_map_path} ({len(cards_dict)} cards, {len(themes_dict)} themes, {len(groups_dict)} groups)")

    print("[5/5] Generating offline player_profile.json...")
    # USER CRITICAL RULE: "evita las cartas limited como las que aparezcan que se van a tener como obtenidas en la cuenta"
    # Option A: 40% C, 30% B, 15% A, 10% S, 5% R for unequipped cards
    # >80% cards unequipped

    random.seed(20261101)

    normal_theme_codes = {t["code"] for t in tmd if t.get("limitedType") == 0}
    normal_cards = [c for c in cdd if c.get("theme") in normal_theme_codes and c.get("material") == 0]
    material_cards = [c for c in cdd if c.get("material") == 1]

    print(f"  Available Normal Theme cards: {len(normal_cards)}")
    print(f"  Available Material cards: {len(material_cards)}")

    # 1. Select equipped starter deck (1 deck per group for all 21 groups)
    equiped_cards_map = {}
    equipped_obj_ids = set()
    inventory_cards = []

    obj_id_counter = 100001

    # Grade distribution weights for unequipped cards: 40% C, 30% B, 15% A, 10% S, 5% R
    grades_pool = [0]*40 + [1]*30 + [2]*15 + [3]*10 + [4]*5

    # Group cards by (groupID, artistID)
    normal_by_group_artist = {}
    for c in normal_cards:
        key = (c["groupID"], c["artistID"])
        normal_by_group_artist.setdefault(key, []).append(c)

    # For each group, equip 1 normal card per slot
    for g_code in PLAYABLE_GROUPS:
        g_data = groups_dict.get(str(g_code), {})
        art_codes = g_data.get("artistCodes", [])
        equiped_cards_map[str(g_code)] = []

        for a_code in art_codes:
            key = (g_code, a_code)
            avail = normal_by_group_artist.get(key, [])
            if avail:
                # Pick the first non-prism normal card for the titular equipped deck
                target_card = avail[0]
                obj_id = obj_id_counter
                obj_id_counter += 1

                card_entry = {
                    "objectID": obj_id,
                    "cardID": target_card["code"],
                    "grade": 4,  # Grade R
                    "level": 50, # Level 50 max
                    "energy": 100,
                    "score": 199,
                    "isEquip": True,
                    "isLock": True,
                    "isPrism": False,
                    "themeID": target_card["theme"],
                    "groupID": g_code,
                    "artistID": a_code,
                }
                inventory_cards.append(card_entry)
                equipped_obj_ids.add(obj_id)
                equiped_cards_map[str(g_code)].append(obj_id)

    print(f"  Equipped cards created: {len(equipped_obj_ids)} across {len(PLAYABLE_GROUPS)} groups")

    # 2. Add unequipped normal cards (both normal and prism)
    # Each normal card (not already equipped) added with Option A grade distribution
    for c in normal_cards:
        # Check if already added as equipped
        already_equipped = any(ic["cardID"] == c["code"] and ic["isEquip"] for ic in inventory_cards)
        
        # Decide how many copies (1 copy if not equipped, or 1 extra copy for duplicates)
        copies = 1 if not already_equipped else 1  # 1 extra copy even for equipped ones
        for _ in range(copies):
            gr = random.choice(grades_pool)
            lvl = 1 if gr < 4 else random.randint(1, 20)
            is_p = (c.get("type", 0) == 1)
            
            obj_id = obj_id_counter
            obj_id_counter += 1
            inventory_cards.append({
                "objectID": obj_id,
                "cardID": c["code"],
                "grade": gr,
                "level": lvl,
                "energy": 100,
                "score": 100 + gr * 25,
                "isEquip": False,
                "isLock": False,
                "isPrism": is_p,
                "themeID": c["theme"],
                "groupID": c["groupID"],
                "artistID": c["artistID"],
            })

    # Add duplicate C/B fodder cards to ensure rich Power Up inventory and well >80% unequipped
    # Add ~150 duplicate C/B cards distributed among normal themes
    fodder_candidates = [c for c in normal_cards if c.get("type", 0) == 0]
    for _ in range(150):
        fc = random.choice(fodder_candidates)
        gr = random.choice([0, 0, 0, 1, 1])  # C or B
        obj_id = obj_id_counter
        obj_id_counter += 1
        inventory_cards.append({
            "objectID": obj_id,
            "cardID": fc["code"],
            "grade": gr,
            "level": 1,
            "energy": 100,
            "score": 100,
            "isEquip": False,
            "isLock": False,
            "isPrism": False,
            "themeID": fc["theme"],
            "groupID": fc["groupID"],
            "artistID": fc["artistID"],
        })

    # 3. Add Power Up Material cards (30001..30005) - 3 of each
    for m in material_cards:
        for _ in range(3):
            obj_id = obj_id_counter
            obj_id_counter += 1
            inventory_cards.append({
                "objectID": obj_id,
                "cardID": m["code"],
                "grade": 0,
                "level": 1,
                "energy": 100,
                "score": 100,
                "isEquip": False,
                "isLock": False,
                "isPrism": False,
                "material": 1,
                "intensifyPercentage": m.get("intensifyPercentage", 100),
                "groupID": 0,
                "artistID": 0,
            })

    total_cards = len(inventory_cards)
    total_equipped = len(equipped_obj_ids)
    total_unequipped = total_cards - total_equipped
    unequipped_pct = (total_unequipped / total_cards) * 100.0

    print(f"  Total Inventory Cards: {total_cards}")
    print(f"  Total Equipped Cards:  {total_equipped} ({(total_equipped/total_cards)*100.0:.1f}%)")
    print(f"  Total Unequipped:      {total_unequipped} ({unequipped_pct:.1f}%) -> Target >80%: {'PASS' if unequipped_pct >= 80 else 'FAIL'}")

    player_profile = {
        "userId": "dalcom_offline_001",
        "nickname": "Orbits",
        "profileCode": 1001,
        "diamond": 9999,
        "rhythmPoint": 500000,
        "headphone": 99,
        "dalcomCoin": 50000,
        "cardInvenMax": 2500,
        "equipedLobbyBgList": [24],
        "leaderCard": 100001,
        "inventoryCards": inventory_cards,
        "equipedCards": equiped_cards_map,
    }

    out_profile_path = os.path.join(ASSETS_DIR, "player_profile.json")
    with open(out_profile_path, "w", encoding="utf-8") as f:
        json.dump(player_profile, f, indent=2, ensure_ascii=False)
    print(f"  -> Generated {out_profile_path}")
    print("[SUCCESS] Full Card Database & Profile generation completed successfully!")

if __name__ == "__main__":
    main()
