#!/usr/bin/env python3
"""
tools/generate_themes_cards_docs_and_viewer.py
Genera la documentación Markdown exhaustiva (docs/THEMES_CARDS_MAPPING.md)
y el visor interactivo visual (docs/card_catalog_viewer.html) para el chequeo manual de Ignacio.
"""

import os
import json
import base64

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
    md_lines.append(f"**Total de Cartas:** {summary['total_cards']} ({summary['normal_cards']} Normales, {summary['prism_cards']} Prismas)  ")
    md_lines.append(f"**Assets Validados:** {summary['cards_with_small_img']} No Equipadas (_s), {summary['cards_with_large_img']} Equipadas (_l)  ")
    if summary["cards_upscaled_fallback"] > 0:
        md_lines.append(f"**Fallbacks Lanczos Sintetizados:** {summary['cards_upscaled_fallback']} cartas (Olivia Hye 17013–17018)  \n")
    md_lines.append("---\n")

    md_lines.append("## 📌 Índice de Grupos y Eras\n")
    for g_code, g in sorted(groups.items(), key=lambda x: int(x[0])):
        md_lines.append(f"- [Grupo {g_code}: {g['name']}](#grupo-{g_code}-{g['name'].lower().replace(' ', '-').replace('[', '').replace(']', '').replace('+', '').replace('&', '')}) ({len(g['themes'])} temas)")
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

            md_lines.append("\n| Miembro / Slot | Tipo | Card ID | Imagen Equipada (_l, 226x318) | Imagen No Equipada (_s, 85x120) | Estado / Nota |")
            md_lines.append("| :--- | :---: | :---: | :--- | :--- | :---: |")

            for c in t["cards"]:
                card_type = "**Prism**" if c["type"] == 1 else "Normal"
                l_link = f"[`{c['cardCode']}_l.png`](file://{os.path.join(BASE_DIR, 'app/src/files', c['largeImage']['path'])})"
                s_link = f"[`{c['cardCode']}_s.png`](file://{os.path.join(BASE_DIR, 'app/src/files', c['smallImage']['path'])})"
                
                status_str = "✅ OK"
                if c["largeImage"].get("isUpscaledFallback"):
                    status_str = "⚠️ Fallback Lanczos"
                elif not c["largeImage"]["exists"] or not c["smallImage"]["exists"]:
                    status_str = "❌ Falta Asset"

                md_lines.append(f"| **{c['artistName']}** | {card_type} | `{c['cardCode']}` | {l_link} | {s_link} | {status_str} |")

            md_lines.append("\n")

    with open(DOCS_MD, "w", encoding="utf-8") as f:
        f.write("\n".join(md_lines))
    print(f"  -> Generado {DOCS_MD}")

    print("[3/3] Generando docs/card_catalog_viewer.html...")
    # Creamos un visor interactivo SPA moderno con filtros reactivos por JS nativo
    # Embebe audit_themes_and_cards.json directamente para funcionar offline sin CORS ni servidor
    json_embedded = json.dumps(data, ensure_ascii=False)

    html_content = f"""<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SuperStar LOONA - Catálogo Visual de Temas y Cartas (Chequeo Manual)</title>
    <style>
        :root {{
            --bg-primary: #0f111a;
            --bg-secondary: #1a1c29;
            --bg-card: #222638;
            --accent: #5e60ce;
            --accent-le: #e0a96d;
            --accent-prism: #4ea8de;
            --text-main: #f0f3f6;
            --text-muted: #8b9bb4;
            --border: #2e344e;
            --success: #38b000;
            --warning: #ffb703;
            --danger: #d90429;
        }}
        * {{ box-sizing: border-box; margin: 0; padding: 0; font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif; }}
        body {{ background-color: var(--bg-primary); color: var(--text-main); min-height: 100vh; padding: 20px; }}
        header {{
            background: linear-gradient(135deg, #1f1d36 0%, #0f111a 100%);
            border: 1px solid var(--border);
            padding: 24px;
            border-radius: 12px;
            margin-bottom: 24px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.4);
        }}
        h1 {{ font-size: 26px; margin-bottom: 8px; color: #fff; }}
        .subtitle {{ color: var(--text-muted); font-size: 14px; margin-bottom: 16px; }}
        .stats-bar {{
            display: flex;
            flex-wrap: wrap;
            gap: 16px;
            padding-top: 12px;
            border-top: 1px solid var(--border);
            font-size: 13px;
        }}
        .stat-pill {{
            background: var(--bg-card);
            padding: 6px 12px;
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
        .btn-outline.active {{
            background: var(--accent);
            border-color: var(--accent);
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
            background: linear-gradient(135deg, #b8860b, #e0a96d);
            color: #000;
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
            grid-template-columns: repeat(auto-fill, minmax(360px, 1fr));
            gap: 16px;
        }}
        .card-card {{
            background: var(--bg-secondary);
            border: 1px solid var(--border);
            border-radius: 8px;
            padding: 12px;
            display: flex;
            flex-direction: column;
            gap: 10px;
        }}
        .card-card.prism {{
            border-color: rgba(78, 168, 222, 0.4);
            box-shadow: 0 0 10px rgba(78, 168, 222, 0.1);
        }}
        .card-header-info {{
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 13px;
        }}
        .card-artist {{ font-weight: 700; color: #fff; font-size: 14px; }}
        .card-type-tag {{
            font-size: 11px;
            padding: 2px 6px;
            border-radius: 4px;
            font-weight: 600;
        }}
        .card-type-tag.prism {{ background: rgba(78, 168, 222, 0.2); color: var(--accent-prism); border: 1px solid var(--accent-prism); }}
        .card-type-tag.normal {{ background: rgba(255, 255, 255, 0.1); color: var(--text-muted); }}
        .card-images-row {{
            display: flex;
            gap: 16px;
            align-items: flex-end;
            background: var(--bg-primary);
            padding: 12px;
            border-radius: 6px;
            justify-content: space-around;
        }}
        .img-col {{
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 6px;
        }}
        .img-col label {{
            font-size: 11px;
            color: var(--text-muted);
            text-transform: uppercase;
            font-weight: 600;
        }}
        .img-preview-l {{
            width: 113px;
            height: 159px;
            object-fit: cover;
            border-radius: 4px;
            border: 1px solid var(--border);
            background: #000;
        }}
        .img-preview-s {{
            width: 85px;
            height: 120px;
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
        .img-link {{ color: var(--accent-prism); text-decoration: none; }}
        .img-link:hover {{ text-decoration: underline; }}
    </style>
</head>
<body>
    <header>
        <h1>🔍 SuperStar LOONA — Catálogo Visual de Temas y Cartas</h1>
        <div class="subtitle">Herramienta de Auditoría y Chequeo Manual de Asociaciones para Collect Book e Inventario | Desarrollado para Ignacio</div>
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
                <option value="ALERT">Solo Alertas / Fallbacks</option>
            </select>
        </label>

        <label>Tipo de Carta:
            <select id="cardTypeSelect">
                <option value="ALL">Normales y Prismas</option>
                <option value="0">Solo Normales</option>
                <option value="1">Solo Prismas</option>
            </select>
        </label>

        <input type="text" id="searchInput" placeholder="Buscar por tema, miembro, ID..." style="min-width: 250px;">

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
                <div class="stat-pill">Temas Totales: <strong>${{s.total_themes}}</strong></div>
                <div class="stat-pill">Normales: <strong>${{s.normal_themes}}</strong></div>
                <div class="stat-pill" style="border-color: var(--accent-le); color: var(--accent-le);">Limited Edition: <strong>${{s.limited_themes}}</strong></div>
                <div class="stat-pill">Cartas Totales: <strong>${{s.total_cards}}</strong></div>
                <div class="stat-pill">Normales: <strong>${{s.normal_cards}}</strong> | Prism: <strong>${{s.prism_cards}}</strong></div>
                <div class="stat-pill" style="border-color: var(--warning); color: var(--warning);">Alertas CDN / Fallbacks: <strong>${{s.anomalies.length}}</strong></div>
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
            document.getElementById("searchInput").addEventListener("input", renderCatalog);
            document.getElementById("resetBtn").addEventListener("click", () => {{
                document.getElementById("groupSelect").value = "ALL";
                document.getElementById("typeSelect").value = "ALL";
                document.getElementById("cardTypeSelect").value = "ALL";
                document.getElementById("searchInput").value = "";
                renderCatalog();
            }});
        }}

        function renderCatalog() {{
            const groupFilter = document.getElementById("groupSelect").value;
            const typeFilter = document.getElementById("typeSelect").value;
            const cardTypeFilter = document.getElementById("cardTypeSelect").value;
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
                    if (typeFilter === "ALERT") {{
                        const hasAlert = t.cards.some(c => c.largeImage.isUpscaledFallback || !c.largeImage.exists || !c.smallImage.exists);
                        if (!hasAlert) return false;
                    }}
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
                        if (typeFilter === "ALERT" && !c.largeImage.isUpscaledFallback) return false;
                        if (search) {{
                            const matchCard = c.artistName.toLowerCase().includes(search) || c.cardCode.toString().includes(search) || t.name.toLowerCase().includes(search);
                            if (!matchCard) return false;
                        }}
                        return true;
                    }});

                    visibleCards.forEach(c => {{
                        const cardDiv = document.createElement("div");
                        cardDiv.className = `card-card ${{c.type === 1 ? 'prism' : ''}}`;

                        const sPath = BASE_FILES_PATH + c.smallImage.path;
                        const lPath = BASE_FILES_PATH + c.largeImage.path;

                        let statusBadge = `<span class="badge-ok">✅ Asset OK</span>`;
                        if (c.largeImage.isUpscaledFallback) {{
                            statusBadge = `<span class="badge-warning">⚠️ Fallback Lanczos (226x318)</span>`;
                        }}

                        cardDiv.innerHTML = `
                            <div class="card-header-info">
                                <span class="card-artist">${{c.artistName}}</span>
                                <span class="card-type-tag ${{c.type === 1 ? 'prism' : 'normal'}}">${{c.typeName}} (ID: ${{c.cardCode}})</span>
                            </div>
                            <div class="card-images-row">
                                <div class="img-col">
                                    <label>No Equipada (_s)</label>
                                    <img class="img-preview-s" src="${{sPath}}" alt="${{c.cardCode}}_s" loading="lazy">
                                    <span style="font-size:10px; color:var(--text-muted);">${{c.smallImage.dimensions ? c.smallImage.dimensions.join('x') : '85x120'}}</span>
                                </div>
                                <div class="img-col">
                                    <label>Equipada (_l)</label>
                                    <img class="img-preview-l" src="${{lPath}}" alt="${{c.cardCode}}_l" loading="lazy">
                                    <span style="font-size:10px; color:var(--text-muted);">${{c.largeImage.dimensions ? c.largeImage.dimensions.join('x') : '226x318'}}</span>
                                </div>
                            </div>
                            <div class="card-footer">
                                <div>Slot: ${{c.artistCode}}</div>
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

    # Template para theme_card_overrides.json si no existe
    if not os.path.exists(OVERRIDES_JSON):
        overrides_template = {
            "$schema_description": "Diccionario de sobreescritura manual para corregir posibles desalineaciones de cartas o texturas.",
            "card_overrides": {
                "example_17013": {
                    "note": "Ejemplo de override para Olivia Hye si se reemplaza el fallback con un arte alternativo custom",
                    "overrideLargePath": "asiudgasg/asodhsg/wadceg/17013_l.i.bytes.png",
                    "overrideSmallPath": "asiudgasg/asodhsg/wadceg/17013_s.i.bytes.png"
                }
            },
            "theme_overrides": {}
        }
        os.makedirs(os.path.dirname(OVERRIDES_JSON), exist_ok=True)
        with open(OVERRIDES_JSON, "w", encoding="utf-8") as f:
            json.dump(overrides_template, f, indent=2, ensure_ascii=False)
        print(f"  -> Generado {OVERRIDES_JSON}")

if __name__ == "__main__":
    main()
