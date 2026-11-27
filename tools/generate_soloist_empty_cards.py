#!/usr/bin/env python3
"""
tools/generate_soloist_empty_cards.py
Genera las 33 cartas vacías (EmptyCard) para los 11 temas solistas Limited Edition
en Dalcomsoft SuperStar LOONA (7003..17003) donde Dalcom omitió subir los _em.png al CDN.

Utiliza los componentes oficiales existentes:
- Foto base equipada (wadceg/{cardCode}_l.i.bytes.png)
- Emblema oficial de firma (aweoijs/{artistCode}.i.bytes.png)
- Rótulo oficial de posición (vhydigygvd/{posCode}.i.bytes.png)
- Atenuación y desaturación idéntica a la fórmula de Dalcomsoft
- Generación de _l (226x318) y _s (85x120 con Lanczos)
"""

import os
from PIL import Image, ImageOps

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
FILES_DIR = os.path.join(BASE_DIR, "app/src/files/asiudgasg/asodhsg")
WADCEG_DIR = os.path.join(FILES_DIR, "wadceg")
SDHGAU_DIR = os.path.join(FILES_DIR, "sdhgauwehdnu")
AWEOIJS_DIR = os.path.join(FILES_DIR, "aweoijs")
VHYDIG_DIR = os.path.join(FILES_DIR, "vhydigygvd")

# 11 Soloists: (baseArtistCode, themeCode, startCardCode)
SOLOISTS = [
    (7001, 7003, 7013),   # HeeJin (VIVID MIX)
    (8001, 8003, 8013),   # HyunJin (Baby Cat)
    (9001, 9003, 9013),   # HaSeul (Hasuli)
    (10001, 10003, 10013), # YeoJin (Kong)
    (11001, 11003, 11013), # ViVi (ViVi WAY)
    (12001, 12003, 12013), # Kim Lip (Queen Lip)
    (13001, 13003, 13013), # JinSoul (Jindori)
    (14001, 14003, 14013), # Choerry (Cherry)
    (15001, 15003, 15013), # Yves (Baby Apple)
    (16001, 16003, 16013), # Go Won (My Fairy)
    (17001, 17003, 17013), # Olivia Hye (Olivia Honey)
    (22001, 22001, 22001), # Chuu (Chuu)
]

def generate_empty_cards():
    os.makedirs(SDHGAU_DIR, exist_ok=True)
    generated_count = 0

    for base_artist, theme_code, start_card in SOLOISTS:
        # Load artist emblem
        emblem_path = os.path.join(AWEOIJS_DIR, f"{base_artist}.i.bytes.png")
        if not os.path.exists(emblem_path):
            print(f"[-] Emblem not found: {emblem_path}")
            continue
        emblem_img = Image.open(emblem_path).convert("RGBA")

        # 3 positions: 0: Vocal, 1: Dance, 2: Rhythm
        for pos_idx in range(3):
            card_code = start_card + pos_idx
            pos_artist_code = base_artist + pos_idx
            pos_name_path = os.path.join(VHYDIG_DIR, f"{pos_artist_code}.i.bytes.png")
            if not os.path.exists(pos_name_path):
                print(f"[-] Position name not found: {pos_name_path}")
                continue
            name_img = Image.open(pos_name_path).convert("RGBA")

            # Base equipped image (Large)
            eq_l_path = os.path.join(WADCEG_DIR, f"{card_code}_l.i.bytes.png")
            if not os.path.exists(eq_l_path):
                print(f"[-] Base equipped image not found: {eq_l_path}")
                continue
            eq_l = Image.open(eq_l_path).convert("RGBA")

            # 1. Grayscale & Dalcom dimming
            gray = ImageOps.grayscale(eq_l)
            gray_rgb = ImageOps.colorize(gray, black="#000000", white="#a0a0a0")
            empty_l = gray_rgb.convert("RGBA")
            empty_l.putalpha(eq_l.split()[-1]) # Preservar bordes redondeados y canal alfa

            # 2. Overlay emblem at top-left
            # Height = 24 px, keep aspect ratio
            emb_h = 24
            emb_w = int(round(emblem_img.width * (emb_h / emblem_img.height)))
            emb_resized = emblem_img.resize((emb_w, emb_h), Image.Resampling.LANCZOS)
            empty_l.alpha_composite(emb_resized, (11, 14))

            # 3. Overlay position name at bottom-right
            # Target size: w=100, h=18 (aspect 150:27 = 5.55 -> 100:18 = 5.55)
            name_w = 100
            name_h = 18
            name_resized = name_img.resize((name_w, name_h), Image.Resampling.LANCZOS)
            pos_x = empty_l.width - name_w - 12
            pos_y = empty_l.height - name_h - 21
            empty_l.alpha_composite(name_resized, (pos_x, pos_y))

            # 4. Generate small card (85x120) with Lanczos
            empty_s = empty_l.resize((85, 120), Image.Resampling.LANCZOS)

            # 5. Save both images to sdhgauwehdnu
            out_l_path = os.path.join(SDHGAU_DIR, f"{card_code}_l.i.bytes.png")
            out_s_path = os.path.join(SDHGAU_DIR, f"{card_code}_s.i.bytes.png")
            empty_l.save(out_l_path, format="PNG")
            empty_s.save(out_s_path, format="PNG")

            print(f"[+] Generated EmptyCard {card_code} (Theme {theme_code}, Artist {pos_artist_code}):")
            print(f"    - {out_l_path} ({empty_l.size})")
            print(f"    - {out_s_path} ({empty_s.size})")
            generated_count += 2

    print(f"\n[DONE] Successfully generated {generated_count} empty card assets (33 large + 33 small)!")

if __name__ == "__main__":
    generate_empty_cards()
