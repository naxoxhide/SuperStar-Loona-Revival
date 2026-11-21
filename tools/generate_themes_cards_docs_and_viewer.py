#!/usr/bin/env python3
"""
tools/generate_themes_cards_docs_and_viewer.py
Genera la documentación Markdown exhaustiva (docs/THEMES_CARDS_MAPPING.md)
y el visor interactivo visual (docs/card_catalog_viewer.html) para el chequeo manual de Ignacio.
Incluye tanto las variantes EQUIPADAS (wadceg S y L) como las NO EQUIPADAS / EMPTY (sdhgauwehdnu S y L).
"""

import os
import json

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
AUDIT_FILE = os.path.join(BASE_DIR, "docs/audit_themes_and_cards.json")
DOCS_MD = os.path.join(BASE_DIR, "docs/THEMES_CARDS_MAPPING.md")
VIEWER_HTML = os.path.join(BASE_DIR, "docs/card_catalog_viewer.html")
OVERRIDES_JSON = os.path.join(BASE_DIR, "data/theme_card_overrides.json")

def main():
    print("[1/3] Cargando audit_themes_and_cards.json...")
    with open(AUDIT_FILE, "r", encoding="utf-8") as f:
        data = json.load(f)

    groups = data["groups"]
    summary = data["summary"]

    print("[2/3] Generando docs/THEMES_CARDS_MAPPING.md...")
    md_lines = []
    md_lines.append("# 📖 Catálogo y Mapeo Técnico Exhaustivo de Temas y Cartas (Dalcomsoft Engine - SSLO)\n")
    md_lines.append("**Proyecto:** Revival Standalone SuperStar LOONA  ")
    md_lines.append(f"**Total de Grupos:** {len(groups)}  ")
    md_lines.append(f"**Total de Temas:** {summary['total_themes']} ({summary['normal_themes']} Normales, {summary['limited_themes']} Limited Edition)  ")
    md_lines.append(f"**Total de Cartas:** {summary['total_cards']} ({summary['normal_cards']} Normales, {summary['prism_cards']} Prismas)  \n")
    md_lines.append("### 📐 Arquitectura de Assets: Equipadas vs. No Equipadas / Empty\n")
    md_lines.append("1. **Cartas EQUIPADAS (`wadceg/`):** Ambas variantes contienen la foto del idol con arte completo:")
    md_lines.append("   - **Equipada (S)** ($85 \\times 120$ px): Miniatura utilizada en la cuadrícula inferior del inventario y en CardBook cuando la carta está obtenida/poseída.")
    md_lines.append("   - **Equipada (L)** ($226 \\times 318$ px): Imagen grande en alta resolución utilizada en los pedestales superiores del inventario, en `CardDetailView`, `CardBookDetailPopup` y durante el gameplay.")
    md_lines.append("2. **Cartas NO EQUIPADAS / EMPTY (`sdhgauwehdnu/`):** Ambas variantes representan el slot vacío / silueta (`cardEmpty` / `artistEmpty` con sufijo CDN `_em.png`):")
    md_lines.append("   - **No Equipada (S)** ($85 \\times 120$ px): Miniatura de slot vacío en inventario o CardBook cuando el jugador no posee la carta.")
    md_lines.append("   - **No Equipada (L)** ($226 \\times 318$ px): Imagen grande de slot vacío en pedestal de inventario cuando no hay carta asignada al slot.")
    md_lines.append("   - **Resolución de Empty:** Dalcom utiliza empty temático específico (`<cardCode>_s/l`) cuando el tema posee bordes/diseño exclusivo; de lo contrario, utiliza el empty canónico del artista (`<artistCode>_s/l`).\n")
    md_lines.append("---\n")

    md_lines.append("## 📌 Índice de Grupos y Eras\n")
    for g_code, g in sorted(groups.items(), key=lambda x: int(x[0])):
        g_anchor = f"grupo-{g_code}-{g['name'].lower().replace(' ', '-').replace('[', '').replace(']', '').replace('+', '').replace('&', '')}"
        md_lines.append(f"- [Grupo {g_code}: {g['name']}](#{g_anchor}) ({len(g['themes'])} temas)")
    md_lines.append("\n---\n")

    for g_code, g in sorted(groups.items(), key=lambda x: int(x[0])):
        g_anchor = f"grupo-{g_code}-{g['name'].lower().replace(' ', '-').replace('[', '').replace(']', '').replace('+', '').replace('&', '')}"
        md_lines.append(f"## <a id=\"{g_anchor}\"></a>Grupo {g_code}: {g['name']}")
        md_lines.append(f"- **Equipable Slots:** {g['equipableSlot']}")
        md_lines.append(f"- **Emblema del Grupo:** [`{g['emblem_path']}`](file://{os.path.join(BASE_DIR, 'app/src/files', g['emblem_path'])})")
        md_lines.append(f"- **Cantidad de Temas:** {len(g['themes'])}\n")

        for t in g["themes"]:
            t_type_badge = "🌟 **LIMITED EDITION (LE)**" if t["isLimited"] else "🔹 **NORMAL**"
            md_lines.append(f"### Tema {t['code']}: {t['name']} — {t_type_badge}")
            md_lines.append(f"- **Theme Code:** `{t['code']}` | **ThemeType Code:** `{t['themeTypeCode']}` | **CardBook Mark:** `{t['cardbookMarkCode']}`")
            if t["logoLargePath"]:
                md_lines.append(f"- **Logo Grande (Equipada):** [`{t['logoLargePath']}`](file://{os.path.join(BASE_DIR, 'app/src/files', t['logoLargePath'])})")
            if t["logoSmallPath"]:
                md_lines.append(f"- **Logo Pequeño (No Equipada):** [`{t['logoSmallPath']}`](file://{os.path.join(BASE_DIR, 'app/src/files', t['logoSmallPath'])})")

            md_lines.append("\n| Miembro / Slot | Tipo | Card ID | Equipada (S) [wadceg] | Equipada (L) [wadceg] | No Equipada (S) [empty] | No Equipada (L) [empty] | Estado |")
            md_lines.append("| :--- | :---: | :---: | :--- | :--- | :--- | :--- | :---: |")

            for c in t["cards"]:
                card_type = "**Prism**" if c["type"] == 1 else "Normal"
                
                eq_s_link = f"[`{c['cardCode']}_s.png`](file://{os.path.join(BASE_DIR, 'app/src/files', c['equipped']['small']['path'])})"
                eq_l_link = f"[`{c['cardCode']}_l.png`](file://{os.path.join(BASE_DIR, 'app/src/files', c['equipped']['large']['path'])})"
                
                empty_target = c['unequipped']['targetCode']
                neq_s_link = f"[`{empty_target}_s_em.png`](file://{os.path.join(BASE_DIR, 'app/src/files', c['unequipped']['small']['path'])})"
                neq_l_link = f"[`{empty_target}_l_em.png`](file://{os.path.join(BASE_DIR, 'app/src/files', c['unequipped']['large']['path'])})"

                status_str = "✅ OK"
                if c["equipped"]["large"].get("isUpscaledFallback"):
                    status_str = "⚠️ Fallback Lanczos"
                elif not c["equipped"]["large"]["exists"] or not c["equipped"]["small"]["exists"]:
                    status_str = "❌ Falta Asset"

                md_lines.append(f"| **{c['artistName']}** | {card_type} | `{c['cardCode']}` | {eq_s_link} | {eq_l_link} | {neq_s_link} | {neq_l_link} | {status_str} |")

            md_lines.append("\n")

    with open(DOCS_MD, "w", encoding="utf-8") as f:
        f.write("\n".join(md_lines))
    print(f"  -> Generado {DOCS_MD}")

    print("[3/3] Generando docs/card_catalog_viewer.html...")
    json_embedded = json.dumps(data, ensure_ascii=False)

    html_content = f"""<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SuperStar LOONA - Catálogo Visual de Temas y Cartas (Equipadas y No Equipadas)</title>
    <style>
        :root {{
            --bg-primary: #0d0f18;
            --bg-secondary: #161824;
            --bg-card: #1f2233;
            --bg-section: #282c42;
            --accent: #6c5ce7;
            --accent-equipped: #00cec9;
            --accent-empty: #fdcb6e;
            --accent-le: #e17055;
            --accent-prism: #74b9ff;
            --text-main: #f8f9fa;
            --text-muted: #a4b0be;
            --border: #2f3542;
            --success: #2ed573;
            --warning: #ffa502;
            --danger: #ff4757;
        }}
        * {{ box-sizing: border-box; margin: 0; padding: 0; font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif; }}
        body {{ background-color: var(--bg-primary); color: var(--text-main); min-height: 100vh; padding: 20px; }}
        header {{
            background: linear-gradient(135deg, #1e1b4b 0%, #0d0f18 100%);
            border: 1px solid var(--border);
            padding: 24px;
            border-radius: 12px;
            margin-bottom: 24px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.5);
        }}
        h1 {{ font-size: 26px; margin-bottom: 8px; color: #fff; }}
        .subtitle {{ color: var(--text-muted); font-size: 14px; margin-bottom: 16px; line-height: 1.5; }}
        .stats-bar {{
            display: flex;
            flex-wrap: wrap;
            gap: 14px;
            padding-top: 14px;
            border-top: 1px solid var(--border);
            font-size: 13px;
        }}
        .stat-pill {{
            background: var(--bg-card);
            padding: 6px 14px;
            border-radius: 6px;
            border: 1px solid var(--border);
        }}
        .stat-pill strong {{ color: #fff; }}
        .controls {{
            display: flex;
            flex-wrap: wrap;
            gap: 12px;
            background: var(--bg-secondary);
            padding: 16px;
            border-radius: 10px;
            margin-bottom: 24px;
            border: 1px solid var(--border);
            align-items: center;
        }}
        select, input[type="text"] {{
            background: var(--bg-card);
            border: 1px solid var(--border);
            color: var(--text-main);
            padding: 8px 12px;
            border-radius: 6px;
            font-size: 14px;
            outline: none;
        }}
        select:focus, input[type="text"]:focus {{ border-color: var(--accent); }}
        .btn {{
            background: var(--accent);
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 6px;
            cursor: pointer;
            font-weight: 600;
            font-size: 13px;
            transition: all 0.2s;
        }}
        .btn:hover {{ opacity: 0.9; transform: translateY(-1px); }}
        .btn-outline {{
            background: transparent;
            border: 1px solid var(--border);
            color: var(--text-main);
        }}
        .group-section {{
            margin-bottom: 40px;
            background: var(--bg-secondary);
            border-radius: 12px;
            padding: 20px;
            border: 1px solid var(--border);
        }}
        .group-header {{
            display: flex;
            align-items: center;
            gap: 16px;
            border-bottom: 1px solid var(--border);
            padding-bottom: 12px;
            margin-bottom: 20px;
        }}
        .group-title {{ font-size: 20px; font-weight: bold; color: #fff; }}
        .theme-section {{
            margin-bottom: 30px;
            background: var(--bg-card);
            border-radius: 10px;
            padding: 16px;
            border: 1px solid var(--border);
        }}
        .theme-header {{
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 16px;
            padding-bottom: 8px;
            border-bottom: 1px dashed var(--border);
        }}
        .theme-title-area {{ display: flex; align-items: center; gap: 12px; }}
        .theme-name {{ font-size: 18px; font-weight: 700; }}
        .badge-le {{
            background: linear-gradient(135deg, #d35400, #e17055);
            color: #fff;
            font-weight: 800;
            font-size: 11px;
            padding: 3px 8px;
            border-radius: 4px;
            letter-spacing: 0.5px;
        }}
        .badge-normal {{
            background: #2b3a55;
            color: #70a1ff;
            font-weight: 600;
            font-size: 11px;
            padding: 3px 8px;
            border-radius: 4px;
        }}
        .cards-grid {{
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(480px, 1fr));
            gap: 20px;
        }}
        .card-card {{
            background: var(--bg-secondary);
            border: 1px solid var(--border);
            border-radius: 10px;
            padding: 14px;
            display: flex;
            flex-direction: column;
            gap: 12px;
        }}
        .card-card.prism {{
            border-color: rgba(116, 185, 255, 0.4);
            box-shadow: 0 0 12px rgba(116, 185, 255, 0.1);
        }}
        .card-header-info {{
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 13px;
        }}
        .card-artist {{ font-weight: 700; color: #fff; font-size: 15px; }}
        .card-type-tag {{
            font-size: 11px;
            padding: 2px 8px;
            border-radius: 4px;
            font-weight: 600;
        }}
        .card-type-tag.prism {{ background: rgba(116, 185, 255, 0.15); color: var(--accent-prism); border: 1px solid var(--accent-prism); }}
        .card-type-tag.normal {{ background: rgba(255, 255, 255, 0.1); color: var(--text-muted); }}
        
        .variants-container {{
            display: flex;
            gap: 14px;
            justify-content: space-between;
        }}
        .variant-box {{
            flex: 1;
            background: var(--bg-primary);
            border-radius: 8px;
            padding: 10px;
            border: 1px solid var(--border);
            display: flex;
            flex-direction: column;
            gap: 8px;
        }}
        .variant-box.box-equipped {{
            border-color: rgba(0, 206, 201, 0.3);
            background: rgba(0, 206, 201, 0.03);
        }}
        .variant-box.box-empty {{
            border-color: rgba(253, 203, 110, 0.3);
            background: rgba(253, 203, 110, 0.03);
        }}
        .variant-title {{
            font-size: 11px;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.5px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }}
        .variant-title.equipped {{ color: var(--accent-equipped); }}
        .variant-title.empty {{ color: var(--accent-empty); }}
        .variant-imgs-row {{
            display: flex;
            gap: 10px;
            align-items: flex-end;
            justify-content: center;
        }}
        .img-col {{
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 4px;
        }}
        .img-col label {{
            font-size: 10px;
            color: var(--text-muted);
            font-weight: 600;
        }}
        .img-preview-l {{
            width: 100px;
            height: 141px;
            object-fit: cover;
            border-radius: 4px;
            border: 1px solid var(--border);
            background: #000;
        }}
        .img-preview-s {{
            width: 70px;
            height: 99px;
            object-fit: cover;
            border-radius: 4px;
            border: 1px solid var(--border);
            background: #000;
        }}
        .card-footer {{
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 11px;
            color: var(--text-muted);
            border-top: 1px solid var(--border);
            padding-top: 8px;
        }}
        .badge-warning {{ color: var(--warning); font-weight: 600; }}
        .badge-ok {{ color: var(--success); font-weight: 600; }}
    </style>
</head>
<body>
    <header>
        <h1>🔍 SuperStar LOONA — Catálogo Visual de Temas y Cartas</h1>
        <div class="subtitle">
            Auditoría de Variantes <strong>EQUIPADAS (wadceg/)</strong> y <strong>NO EQUIPADAS / EMPTY (sdhgauwehdnu/)</strong><br>
            Desarrollado para el Chequeo Manual de Ignacio | Total: 99 Temas y 1.467 Cartas
        </div>
        <div class="stats-bar" id="statsBar">
            <!-- Estadísticas dinámicas -->
        </div>
    </header>

    <div class="controls">
        <label>Grupo / Era:
            <select id="groupSelect">
                <option value="ALL">Todos los Grupos</option>
            </select>
        </label>

        <label>Tipo de Tema:
            <select id="typeSelect">
                <option value="ALL">Todos (Normal y LE)</option>
                <option value="LE">Solo Limited Edition (LE)</option>
                <option value="NORMAL">Solo Temas Normales</option>
            </select>
        </label>

        <label>Tipo de Carta:
            <select id="cardTypeSelect">
                <option value="ALL">Normales y Prismas</option>
                <option value="0">Solo Normales</option>
                <option value="1">Solo Prismas</option>
            </select>
        </label>

        <label>Modo de Vista:
            <select id="viewModeSelect">
                <option value="ALL">Comparativa Completa (Equipadas + No Equipadas)</option>
                <option value="EQUIPPED_ONLY">Solo Equipadas (wadceg - S y L)</option>
                <option value="EMPTY_ONLY">Solo No Equipadas / Empty (sdhgauwehdnu - S y L)</option>
                <option value="LARGE_ONLY">Comparativa Directa (Equipada L vs No Equipada L)</option>
            </select>
        </label>

        <input type="text" id="searchInput" placeholder="Buscar por tema, miembro, ID..." style="min-width: 220px;">

        <button class="btn btn-outline" id="resetBtn">Restablecer Filtros</button>
    </div>

    <div id="contentArea">
        <!-- Contenido generado dinámicamente -->
    </div>

    <script>
        const AUDIT_DATA = {json_embedded};
        const BASE_FILES_PATH = "../app/src/files/";

        function init() {{
            renderStats();
            populateGroupSelect();
            setupEventListeners();
            renderCatalog();
        }}

        function renderStats() {{
            const s = AUDIT_DATA.summary;
            const bar = document.getElementById("statsBar");
            bar.innerHTML = `
                <div class="stat-pill">Temas: <strong>${{s.total_themes}}</strong> (${{s.normal_themes}} Normales, ${{s.limited_themes}} LE)</div>
                <div class="stat-pill">Cartas: <strong>${{s.total_cards}}</strong> (${{s.normal_cards}} Normales, ${{s.prism_cards}} Prismas)</div>
                <div class="stat-pill" style="border-color: var(--accent-equipped); color: var(--accent-equipped);">Equipadas (wadceg): <strong>${{s.cards_with_large_img}}</strong></div>
                <div class="stat-pill" style="border-color: var(--accent-empty); color: var(--accent-empty);">No Equipadas (sdhgauwehdnu): <strong>${{s.cards_with_small_img}}</strong></div>
            `;
        }}

        function populateGroupSelect() {{
            const sel = document.getElementById("groupSelect");
            const groups = AUDIT_DATA.groups;
            Object.keys(groups).sort((a,b) => parseInt(a) - parseInt(b)).forEach(gid => {{
                const g = groups[gid];
                const opt = document.createElement("option");
                opt.value = gid;
                opt.textContent = `Grupo ${{gid}}: ${{g.name}} (${{g.themes.length}} temas)`;
                sel.appendChild(opt);
            }});
        }}

        function setupEventListeners() {{
            document.getElementById("groupSelect").addEventListener("change", renderCatalog);
            document.getElementById("typeSelect").addEventListener("change", renderCatalog);
            document.getElementById("cardTypeSelect").addEventListener("change", renderCatalog);
            document.getElementById("viewModeSelect").addEventListener("change", renderCatalog);
            document.getElementById("searchInput").addEventListener("input", renderCatalog);
            document.getElementById("resetBtn").addEventListener("click", () => {{
                document.getElementById("groupSelect").value = "ALL";
                document.getElementById("typeSelect").value = "ALL";
                document.getElementById("cardTypeSelect").value = "ALL";
                document.getElementById("viewModeSelect").value = "ALL";
                document.getElementById("searchInput").value = "";
                renderCatalog();
            }});
        }}

        function renderCatalog() {{
            const groupFilter = document.getElementById("groupSelect").value;
            const typeFilter = document.getElementById("typeSelect").value;
            const cardTypeFilter = document.getElementById("cardTypeSelect").value;
            const viewMode = document.getElementById("viewModeSelect").value;
            const search = document.getElementById("searchInput").value.toLowerCase().trim();

            const container = document.getElementById("contentArea");
            container.innerHTML = "";

            const groups = AUDIT_DATA.groups;
            let totalRenderedThemes = 0;

            Object.keys(groups).sort((a,b) => parseInt(a) - parseInt(b)).forEach(gid => {{
                if (groupFilter !== "ALL" && groupFilter !== gid) return;

                const g = groups[gid];
                let matchingThemes = g.themes.filter(t => {{
                    if (typeFilter === "LE" && !t.isLimited) return false;
                    if (typeFilter === "NORMAL" && t.isLimited) return false;
                    if (search) {{
                        const matchThemeName = t.name.toLowerCase().includes(search);
                        const matchThemeCode = t.code.toString().includes(search);
                        const matchCard = t.cards.some(c => 
                            c.artistName.toLowerCase().includes(search) || 
                            c.cardCode.toString().includes(search)
                        );
                        if (!matchThemeName && !matchThemeCode && !matchCard) return false;
                    }}
                    return true;
                }});

                if (matchingThemes.length === 0) return;

                const groupSec = document.createElement("div");
                groupSec.className = "group-section";
                groupSec.innerHTML = `
                    <div class="group-header">
                        <div class="group-title">Grupo ${{gid}}: ${{g.name}}</div>
                        <div class="subtitle" style="margin:0;">Equipable Slots: ${{g.equipableSlot}} | Temas Visibles: ${{matchingThemes.length}}</div>
                    </div>
                `;

                matchingThemes.forEach(t => {{
                    totalRenderedThemes++;
                    const themeSec = document.createElement("div");
                    themeSec.className = "theme-section";

                    const badgeHtml = t.isLimited 
                        ? `<span class="badge-le">LIMITED EDITION (LE)</span>`
                        : `<span class="badge-normal">NORMAL THEME</span>`;

                    themeSec.innerHTML = `
                        <div class="theme-header">
                            <div class="theme-title-area">
                                <span class="theme-name">Tema ${{t.code}}: ${{t.name}}</span>
                                ${{badgeHtml}}
                                <span class="subtitle" style="margin:0; font-size:12px;">ThemeType: ${{t.themeTypeCode}} | CardBook Mark: ${{t.cardbookMarkCode || 'N/A'}}</span>
                            </div>
                        </div>
                        <div class="cards-grid" id="theme_cards_${{t.code}}"></div>
                    `;

                    const cardsGrid = themeSec.querySelector(`#theme_cards_${{t.code}}`);

                    let visibleCards = t.cards.filter(c => {{
                        if (cardTypeFilter !== "ALL" && c.type.toString() !== cardTypeFilter) return false;
                        if (search) {{
                            const matchCard = c.artistName.toLowerCase().includes(search) || c.cardCode.toString().includes(search) || t.name.toLowerCase().includes(search);
                            if (!matchCard) return false;
                        }}
                        return true;
                    }});

                    visibleCards.forEach(c => {{
                        const cardDiv = document.createElement("div");
                        cardDiv.className = `card-card ${{c.type === 1 ? 'prism' : ''}}`;

                        const eqSPath = BASE_FILES_PATH + c.equipped.small.path;
                        const eqLPath = BASE_FILES_PATH + c.equipped.large.path;
                        const neqSPath = BASE_FILES_PATH + c.unequipped.small.path;
                        const neqLPath = BASE_FILES_PATH + c.unequipped.large.path;

                        let statusBadge = `<span class="badge-ok">✅ Assets OK</span>`;
                        if (c.equipped.large.isUpscaledFallback) {{
                            statusBadge = `<span class="badge-warning">⚠️ Fallback Lanczos (226x318)</span>`;
                        }}

                        let variantsHtml = "";

                        if (viewMode === "ALL") {{
                            variantsHtml = `
                                <div class="variants-container">
                                    <div class="variant-box box-equipped">
                                        <div class="variant-title equipped">
                                            <span>Equipada (wadceg)</span>
                                            <span style="font-size:9px; opacity:0.8;">Foto Idol</span>
                                        </div>
                                        <div class="variant-imgs-row">
                                            <div class="img-col">
                                                <label>S (85x120)</label>
                                                <img class="img-preview-s" src="${{eqSPath}}" alt="${{c.cardCode}}_s" loading="lazy">
                                            </div>
                                            <div class="img-col">
                                                <label>L (226x318)</label>
                                                <img class="img-preview-l" src="${{eqLPath}}" alt="${{c.cardCode}}_l" loading="lazy">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="variant-box box-empty">
                                        <div class="variant-title empty">
                                            <span>No Equipada (sdhgau)</span>
                                            <span style="font-size:9px; opacity:0.8;">cardEmpty</span>
                                        </div>
                                        <div class="variant-imgs-row">
                                            <div class="img-col">
                                                <label>S (85x120)</label>
                                                <img class="img-preview-s" src="${{neqSPath}}" alt="${{c.unequipped.targetCode}}_s_em" loading="lazy">
                                            </div>
                                            <div class="img-col">
                                                <label>L (226x318)</label>
                                                <img class="img-preview-l" src="${{neqLPath}}" alt="${{c.unequipped.targetCode}}_l_em" loading="lazy">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            `;
                        }} else if (viewMode === "EQUIPPED_ONLY") {{
                            variantsHtml = `
                                <div class="variant-box box-equipped">
                                    <div class="variant-title equipped">
                                        <span>Carta Equipada (wadceg) — Foto Idol</span>
                                        <span style="font-size:9px;">Miniatura vs Pedestal</span>
                                    </div>
                                    <div class="variant-imgs-row" style="gap:20px;">
                                        <div class="img-col">
                                            <label>Equipada S (85x120)</label>
                                            <img class="img-preview-s" style="width:85px; height:120px;" src="${{eqSPath}}" alt="${{c.cardCode}}_s" loading="lazy">
                                        </div>
                                        <div class="img-col">
                                            <label>Equipada L (226x318)</label>
                                            <img class="img-preview-l" style="width:113px; height:159px;" src="${{eqLPath}}" alt="${{c.cardCode}}_l" loading="lazy">
                                        </div>
                                    </div>
                                </div>
                            `;
                        }} else if (viewMode === "EMPTY_ONLY") {{
                            variantsHtml = `
                                <div class="variant-box box-empty">
                                    <div class="variant-title empty">
                                        <span>Carta No Equipada / Empty (sdhgauwehdnu)</span>
                                        <span style="font-size:9px;">Slot: ${{c.unequipped.targetCode}} (${{c.unequipped.sourceType}})</span>
                                    </div>
                                    <div class="variant-imgs-row" style="gap:20px;">
                                        <div class="img-col">
                                            <label>No Equipada S (85x120)</label>
                                            <img class="img-preview-s" style="width:85px; height:120px;" src="${{neqSPath}}" alt="${{c.unequipped.targetCode}}_s_em" loading="lazy">
                                        </div>
                                        <div class="img-col">
                                            <label>No Equipada L (226x318)</label>
                                            <img class="img-preview-l" style="width:113px; height:159px;" src="${{neqLPath}}" alt="${{c.unequipped.targetCode}}_l_em" loading="lazy">
                                        </div>
                                    </div>
                                </div>
                            `;
                        }} else if (viewMode === "LARGE_ONLY") {{
                            variantsHtml = `
                                <div class="variants-container">
                                    <div class="variant-box box-equipped">
                                        <div class="variant-title equipped">Equipada (L - 226x318)</div>
                                        <div class="variant-imgs-row">
                                            <img class="img-preview-l" style="width:113px; height:159px;" src="${{eqLPath}}" alt="${{c.cardCode}}_l" loading="lazy">
                                        </div>
                                    </div>
                                    <div class="variant-box box-empty">
                                        <div class="variant-title empty">No Equipada (L - 226x318)</div>
                                        <div class="variant-imgs-row">
                                            <img class="img-preview-l" style="width:113px; height:159px;" src="${{neqLPath}}" alt="${{c.unequipped.targetCode}}_l_em" loading="lazy">
                                        </div>
                                    </div>
                                </div>
                            `;
                        }}

                        cardDiv.innerHTML = `
                            <div class="card-header-info">
                                <span class="card-artist">${{c.artistName}}</span>
                                <span class="card-type-tag ${{c.type === 1 ? 'prism' : 'normal'}}">${{c.typeName}} (ID: ${{c.cardCode}})</span>
                            </div>
                            ${{variantsHtml}}
                            <div class="card-footer">
                                <div>Slot Artista: ${{c.artistCode}} | Empty: ${{c.unequipped.targetCode}}</div>
                                ${{statusBadge}}
                            </div>
                        `;
                        cardsGrid.appendChild(cardDiv);
                    }});

                    groupSec.appendChild(themeSec);
                }});

                container.appendChild(groupSec);
            }});

            if (totalRenderedThemes === 0) {{
                container.innerHTML = `
                    <div style="text-align:center; padding: 60px; color: var(--text-muted); font-size: 16px;">
                        No se encontraron temas o cartas con los filtros seleccionados.
                    </div>
                `;
            }}
        }}

        window.addEventListener("DOMContentLoaded", init);
    </script>
</body>
</html>
"""
    with open(VIEWER_HTML, "w", encoding="utf-8") as f:
        f.write(html_content)
    print(f"  -> Generado {VIEWER_HTML}")

if __name__ == "__main__":
    main()
