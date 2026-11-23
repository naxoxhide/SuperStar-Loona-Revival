import re

with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    content = f.read()

target = """                        ensureLoonaMocks();
                        log("[🎨 LIVE THEME] Building authentic offline LiveTheme data structures...");

                        var initClassFn = new NativeFunction(baseAddr.add(0xA43BE8), "void", ["pointer"]);

                        // 1. LiveThemeData model"""

replacement = """                        ensureLoonaMocks();
                        log("[🎨 LIVE THEME] Building authentic offline LiveTheme data structures...");

                        log("[🔍 STEP 1] LiveThemeData model...");
                        // 1. LiveThemeData model"""

content = content.replace(target, replacement, 1)

target2 = """                        // 2. LiveThemeDataControl.Data"""
replacement2 = """                        log("[🔍 STEP 2] LiveThemeDataControl.Data...");
                        // 2. LiveThemeDataControl.Data"""
content = content.replace(target2, replacement2, 1)

target3 = """                        // 3. Classes for Cards"""
replacement3 = """                        log("[🔍 STEP 3] Classes for Cards...");
                        // 3. Classes for Cards"""
content = content.replace(target3, replacement3, 1)

target4 = """                        for (var i = 0; i < 11; i++) {"""
replacement4 = """                        log("[🔍 STEP 3b] Card loop start...");
                        for (var i = 0; i < 11; i++) {"""
content = content.replace(target4, replacement4, 1)

target5 = """                        // 4. Authentic FastArray of ThemeCardItem"""
replacement5 = """                        log("[🔍 STEP 4] FastArray of ThemeCardItem...");
                        // 4. Authentic FastArray of ThemeCardItem"""
content = content.replace(target5, replacement5, 1)

target6 = """                        // 5. LiveThemeControl.LiveThemeItem"""
replacement6 = """                        log("[🔍 STEP 5] LiveThemeControl.LiveThemeItem...");
                        // 5. LiveThemeControl.LiveThemeItem"""
content = content.replace(target6, replacement6, 1)

target7 = """                        // 6. Authentic Managed List of LiveThemeItem"""
replacement7 = """                        log("[🔍 STEP 6] Managed List of LiveThemeItem...");
                        // 6. Authentic Managed List of LiveThemeItem"""
content = content.replace(target7, replacement7, 1)

target8 = """                        // 7. Static fields of LiveThemeControl"""
replacement8 = """                        log("[🔍 STEP 7] Static fields of LiveThemeControl...");
                        // 7. Static fields of LiveThemeControl"""
content = content.replace(target8, replacement8, 1)

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(content)

with open('app/src/main/lib/arm64-v8a/libscript.so', 'w', encoding='utf-8') as f:
    f.write(content)

print("[+] Step logs added successfully!")
