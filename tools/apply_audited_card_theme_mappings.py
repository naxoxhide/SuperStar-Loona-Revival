#!/usr/bin/env python3
"""
tools/apply_audited_card_theme_mappings.py
Applies 100% verified, audited theme-to-empty card mappings from docs/audit_themes_and_cards.json
into app/src/main/assets/libscript.js for CardBook and Equip Theme scenes.
"""
import json
import re

def main():
    with open("docs/audit_themes_and_cards.json", "r", encoding="utf-8") as f:
        audit = json.load(f)

    correct_map = {}
    for g in audit["groups"].values():
        for t in g["themes"]:
            t_code = t["code"]
            for c in t["cards"]:
                if c["type"] == 0:
                    key = f"{t_code}_{c['artistCode']}"
                    correct_map[key] = c["unequipped"]["targetCode"]

    print(f"Extracted {len(correct_map)} theme_artist empty mappings from audit.")

    with open("app/src/main/assets/libscript.js", "r", encoding="utf-8") as f:
        content = f.read()

    # 1. Replace themeArtistEmptyMap
    old_pattern = r"var themeArtistEmptyMap\s*=\s*\{.*?\};"
    new_json_str = json.dumps(correct_map, sort_keys=True)
    new_theme_artist_empty = f"var themeArtistEmptyMap = {new_json_str};"

    match = re.search(old_pattern, content)
    assert match, "themeArtistEmptyMap pattern not found in libscript.js"
    content = content[:match.start()] + new_theme_artist_empty + content[match.end():]
    print("[1/2] Replaced themeArtistEmptyMap with 731 verified entries.")

    # 2. Fix redundant lookup in sdhgauwehdnu
    old_empty_lookup = """if (relPath.indexOf("sdhgauwehdnu/") !== -1) {
                                var matchEmpty = relPath.match(/(\\d+)_([sl])\\.i\\.bytes/);
                                if (matchEmpty) {
                                    var aCode = parseInt(matchEmpty[1], 10);
                                    var emptyCode = (typeof cardIdToEmptyArtistMap !== "undefined" && cardIdToEmptyArtistMap[aCode]) || aCode;
                                    tex = getOrCreateEmptyCardTexture(emptyCode, matchEmpty[2] === "l");
                                }"""

    new_empty_lookup = """if (relPath.indexOf("sdhgauwehdnu/") !== -1) {
                                var matchEmpty = relPath.match(/(\\d+)_([sl])\\.i\\.bytes/);
                                if (matchEmpty) {
                                    var aCode = parseInt(matchEmpty[1], 10);
                                    tex = getOrCreateEmptyCardTexture(aCode, matchEmpty[2] === "l");
                                }"""

    if old_empty_lookup in content:
        content = content.replace(old_empty_lookup, new_empty_lookup, 1)
        print("[2/2] Fixed sdhgauwehdnu texture handler to prevent redundant lookup.")
    else:
        print("[2/2] sdhgauwehdnu texture handler already patched.")

    with open("app/src/main/assets/libscript.js", "w", encoding="utf-8") as f:
        f.write(content)

    # Also synchronize libscript.so
    import shutil
    shutil.copyfile("app/src/main/assets/libscript.js", "app/src/main/lib/arm64-v8a/libscript.so")
    print("Successfully synchronized app/src/main/lib/arm64-v8a/libscript.so!")

    print("Successfully updated app/src/main/assets/libscript.js!")

if __name__ == "__main__":
    main()
