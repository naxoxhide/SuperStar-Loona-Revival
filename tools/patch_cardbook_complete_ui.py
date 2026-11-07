#!/usr/bin/env python3
"""
tools/patch_cardbook_complete_ui.py
Restores all UI elements, textures (emblems, backgrounds, theme logos, badges)
and offline handlers for CardBookScene in libscript.js using genuine IL2CPP objects.
"""
import json
import re

def main():
    # 1. Load tmd.json and grd.json to extract mappings
    with open("app/src/files/asiudgasg/sdisgkdc/grd.json") as f:
        grd = json.load(f)
    with open("app/src/files/asiudgasg/sdisgkdc/tmd.json") as f:
        tmd = json.load(f)

    bg_map = {}
    emblem_map = {}
    for g in grd:
        c = g["code"]
        bg = g.get("bestCardbookImage", "")
        em = g.get("emblemImage", "")
        # base group code (e.g. 1001 for 1001..1009)
        if c < 10000:
            base_c = (c // 1000) * 1000 + 1
        else:
            base_c = (c // 10000) * 10000 + ((c % 10000) // 1000) * 1000 + 1
        if bg:
            clean_bg = bg.split("?")[0].split("/")[-1]
            bg_map[clean_bg] = str(base_c)
        if em:
            clean_em = em.split("?")[0].split("/")[-1]
            emblem_map[clean_em] = str(base_c)

    theme_logo_map = {}
    theme_badge_codes = {}
    for t in tmd:
        c = t["code"]
        nl = t.get("nameImageLarge", "")
        ns = t.get("nameImageSmall", "")
        if nl:
            theme_logo_map[nl.split("?")[0].split("/")[-1]] = f"{c}_l"
        if ns:
            theme_logo_map[ns.split("?")[0].split("/")[-1]] = f"{c}_s"
        b_str = t.get("cardbookMarkCode", "")
        if b_str:
            try:
                b_list = json.loads(b_str)
                valid = [b for b in b_list if b in [901, 902, 903]]
                if valid:
                    theme_badge_codes[c] = valid
            except Exception:
                pass

    badge_map = {
        "icon_limited.png": "901",
        "icon_event.png": "902",
        "icon_original.png": "903"
    }

    # 2. Read libscript.js
    path = "app/src/main/assets/libscript.js"
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()

    # 2a. Add 'download_path' support into createManagedList
    target_managed_list = """                        } else if (type === 'string') {
                            klassSlotRva = 0x31E3228;  // System.Collections.Generic.List<string>_TypeInfo
                            ctorSlotRva = 0x3209ED0;   // Method$System.Collections.Generic.List<string>..ctor()
                            addSlotRva = 0x3209EE8;    // Method$System.Collections.Generic.List<string>.Add()
                        }"""
    replacement_managed_list = """                        } else if (type === 'string') {
                            klassSlotRva = 0x31E3228;  // System.Collections.Generic.List<string>_TypeInfo
                            ctorSlotRva = 0x3209ED0;   // Method$System.Collections.Generic.List<string>..ctor()
                            addSlotRva = 0x3209EE8;    // Method$System.Collections.Generic.List<string>.Add()
                        } else if (type === 'download_path') {
                            klassSlotRva = 0x31E3878;  // System.Collections.Generic.List<WWWFile.DownloadPath>_TypeInfo
                            ctorSlotRva = 0x320BDD8;   // Method$System.Collections.Generic.List<WWWFile.DownloadPath>..ctor()
                            addSlotRva = 0x320BDE8;    // Method$System.Collections.Generic.List<WWWFile.DownloadPath>.Add()
                        }"""
    assert target_managed_list in content, "target_managed_list not found!"
    content = content.replace(target_managed_list, replacement_managed_list, 1)

    # 2b. Define JS tables and helper functions
    maps_js = f"""
                // CardBook UI & Asset Resolution Dictionaries
                var cardbookBgMap = {json.dumps(bg_map)};
                var cardbookEmblemMap = {json.dumps(emblem_map)};
                var cardbookBadgeMap = {json.dumps(badge_map)};
                var cardbookThemeLogoMap = {json.dumps(theme_logo_map)};
                var cardbookThemeBadges = {json.dumps(theme_badge_codes)};

                function getBaseGroupCode(gc) {{
                    gc = parseInt(gc, 10) || 1001;
                    if (gc >= 1001 && gc <= 1009) return 1001;
                    if (gc >= 2001 && gc <= 2007) return 2001;
                    if (gc >= 3001 && gc <= 3008) return 3001;
                    if (gc >= 4001 && gc <= 4012) return 4001;
                    if (gc >= 5001 && gc <= 5010) return 5001;
                    if (gc >= 6001 && gc <= 6008) return 6001;
                    if (gc >= 7001 && gc <= 7002) return 7001;
                    if (gc >= 8001 && gc <= 8002) return 8001;
                    if (gc >= 9001 && gc <= 9002) return 9001;
                    if (gc >= 10001 && gc <= 10002) return 10001;
                    if (gc >= 11001 && gc <= 11002) return 11001;
                    if (gc >= 12001 && gc <= 12002) return 12001;
                    if (gc >= 13001 && gc <= 13002) return 13001;
                    if (gc >= 14001 && gc <= 14002) return 14001;
                    if (gc >= 15001 && gc <= 15002) return 15001;
                    if (gc >= 16001 && gc <= 16002) return 16001;
                    if (gc >= 17001 && gc <= 17002) return 17001;
                    if (gc >= 18001 && gc <= 18003) return 18001;
                    if (gc >= 19001 && gc <= 19003) return 19001;
                    if (gc >= 20001 && gc <= 20002) return 20001;
                    if (gc >= 21001 && gc <= 21002) return 21001;
                    return gc;
                }}

                function createDownloadPathList(paths) {{
                    if (!paths || paths.length === 0) return NULL;
                    try {{
                        var items = [];
                        for (var i = 0; i < paths.length; i++) {{
                            var dp = createDownloadPath(paths[i]);
                            if (dp && !dp.isNull()) items.push(dp);
                        }}
                        return createManagedList(items, 'download_path');
                    }} catch (eDpl) {{
                        log("[-] Error creating DownloadPathList: " + eDpl.message);
                        return NULL;
                    }}
                }}
"""

    # Insert JS tables before SetCdnTexture or after emptyCardTexturePool
    target_pool = "var emptyCardTexturePool = {};"
    assert target_pool in content, "emptyCardTexturePool not found!"
    content = content.replace(target_pool, target_pool + maps_js, 1)

    # 3. Update GroupControl.Data getters (0xCA4F3C for emblem, 0xCA4D4C for bestCardbook)
    old_emblem_hook = """                    Interceptor.replace(baseAddr.add(0xCA4F3C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        var emb = gMeta ? gMeta.emblemPath : ("asiudgasg/asodhsg/aweoijs/" + gc + ".i.bytes");
                        return createDownloadPath(emb);
                    }, "pointer", ["pointer", "pointer"]));"""
    new_emblem_hook = """                    Interceptor.replace(baseAddr.add(0xCA4F3C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var baseGc = getBaseGroupCode(gc);
                        return createDownloadPath("asiudgasg/asodhsg/aweoijs/" + baseGc + ".i.bytes");
                    }, "pointer", ["pointer", "pointer"]));"""
    assert old_emblem_hook in content, "old_emblem_hook not found!"
    content = content.replace(old_emblem_hook, new_emblem_hook, 1)

    old_bg_hook = """                    Interceptor.replace(baseAddr.add(0xCA4D4C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        var emb = gMeta ? gMeta.emblemPath : ("asiudgasg/asodhsg/aweoijs/" + gc + ".i.bytes");
                        return createDownloadPath(emb);
                    }, "pointer", ["pointer", "pointer"]));"""
    new_bg_hook = """                    Interceptor.replace(baseAddr.add(0xCA4D4C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var baseGc = getBaseGroupCode(gc);
                        return createDownloadPath("asiudgasg/asodhsg/foewghkc/" + baseGc + ".i.bytes");
                    }, "pointer", ["pointer", "pointer"]));"""
    assert old_bg_hook in content, "old_bg_hook not found!"
    content = content.replace(old_bg_hook, new_bg_hook, 1)

    # 4. Update ThemeControl.Data getters (0xC89CA4 for largeName, 0xC89BCC for smallName)
    old_theme_large_hook = """                // Proxy ThemeControl.Data.get_LargeNameImagePath (0xC89CA4)
                try {
                    Interceptor.replace(baseAddr.add(0xC89CA4), keepCb(new NativeCallback(function (thisPtr, methodInfo) {
                        if (!thisPtr.isNull()) {
                            var dp = thisPtr.add(0x38).readPointer();
                            if (!dp.isNull()) return dp;
                        }
                        return createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/1001_l.i.bytes");
                    }, "pointer", ["pointer", "pointer"])));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_LargeNameImagePath (0xC89CA4)!");
                } catch (eLnip) {
                    log("[-] Error replacing ThemeControl.Data.get_LargeNameImagePath: " + eLnip.message);
                }"""
    new_theme_large_hook = """                // Proxy ThemeControl.Data.get_LargeNameImagePath (0xC89CA4)
                try {
                    Interceptor.replace(baseAddr.add(0xC89CA4), keepCb(new NativeCallback(function (thisPtr, methodInfo) {
                        var themeCode = 1001;
                        if (!thisPtr.isNull()) {
                            var dp = thisPtr.add(0x38).readPointer();
                            if (!dp.isNull() && dp.compare(ptr(0x1000)) > 0) return dp;
                            var model = thisPtr.add(0x10).readPointer();
                            if (!model.isNull() && model.compare(ptr(0x1000)) > 0) {
                                var c = model.add(0x10).readS32();
                                if (c > 0) themeCode = c;
                            }
                        }
                        var newDp = createDownloadPath("asiudgasg/asodhsg/agewfcbxhaa/" + themeCode + "_l.i.bytes");
                        if (!thisPtr.isNull()) {
                            thisPtr.add(0x38).writePointer(newDp);
                        }
                        return newDp;
                    }, "pointer", ["pointer", "pointer"])));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_LargeNameImagePath (0xC89CA4)!");
                } catch (eLnip) {
                    log("[-] Error replacing ThemeControl.Data.get_LargeNameImagePath: " + eLnip.message);
                }"""
    assert old_theme_large_hook in content, "old_theme_large_hook not found!"
    content = content.replace(old_theme_large_hook, new_theme_large_hook, 1)

    old_theme_small_hook = """                // Proxy ThemeControl.Data.get_SmallNameImagePath (0xC89BCC)
                try {
                    Interceptor.replace(baseAddr.add(0xC89BCC), keepCb(new NativeCallback(function (thisPtr, methodInfo) {
                        if (!thisPtr.isNull()) {
                            var dp = thisPtr.add(0x30).readPointer();
                            if (!dp.isNull()) return dp;
                        }
                        return createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/1001_s.i.bytes");
                    }, "pointer", ["pointer", "pointer"])));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_SmallNameImagePath (0xC89BCC)!");
                } catch (eTip) {
                    log("[-] Error replacing ThemeControl.Data.get_SmallNameImagePath: " + eTip.message);
                }"""
    new_theme_small_hook = """                // Proxy ThemeControl.Data.get_SmallNameImagePath (0xC89BCC)
                try {
                    Interceptor.replace(baseAddr.add(0xC89BCC), keepCb(new NativeCallback(function (thisPtr, methodInfo) {
                        var themeCode = 1001;
                        if (!thisPtr.isNull()) {
                            var dp = thisPtr.add(0x30).readPointer();
                            if (!dp.isNull() && dp.compare(ptr(0x1000)) > 0) return dp;
                            var model = thisPtr.add(0x10).readPointer();
                            if (!model.isNull() && model.compare(ptr(0x1000)) > 0) {
                                var c = model.add(0x10).readS32();
                                if (c > 0) themeCode = c;
                            }
                        }
                        var newDp = createDownloadPath("asiudgasg/asodhsg/agewfcbxhaa/" + themeCode + "_s.i.bytes");
                        if (!thisPtr.isNull()) {
                            thisPtr.add(0x30).writePointer(newDp);
                        }
                        return newDp;
                    }, "pointer", ["pointer", "pointer"])));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_SmallNameImagePath (0xC89BCC)!");
                } catch (eTip) {
                    log("[-] Error replacing ThemeControl.Data.get_SmallNameImagePath: " + eTip.message);
                }"""
    assert old_theme_small_hook in content, "old_theme_small_hook not found!"
    content = content.replace(old_theme_small_hook, new_theme_small_hook, 1)

    # 5. In getOrCreateThemeData: safely clear offset 0x20 and populate CardBookMarkList (offset 0x18)
    old_theme_data_setup = """                        tObj.add(0x20).writePointer(createIl2CppString(tName));
                        tObj.add(0x30).writePointer(createDownloadPath(sPath));
                        tObj.add(0x38).writePointer(createDownloadPath(lPath));
                        tObj.add(0x40).writePointer(createDownloadPath(lPath));"""
    new_theme_data_setup = """                        tObj.add(0x20).writePointer(NULL);
                        tObj.add(0x30).writePointer(createDownloadPath(sPath));
                        tObj.add(0x38).writePointer(createDownloadPath(lPath));
                        tObj.add(0x40).writePointer(createDownloadPath(lPath));

                        // Populate CardBookMarkList for theme badges (Limited, Event, Original) with genuine managed list
                        if (cardbookThemeBadges && cardbookThemeBadges[themeId]) {
                            var bCodes = cardbookThemeBadges[themeId];
                            var bPaths = [];
                            for (var bi = 0; bi < bCodes.length; bi++) {
                                bPaths.push("asiudgasg/asodhsg/bhfbfhbf/" + bCodes[bi] + ".i.bytes");
                            }
                            var badgeListObj = createDownloadPathList(bPaths);
                            if (badgeListObj && !badgeListObj.isNull()) {
                                tObj.add(0x18).writePointer(badgeListObj);
                            }
                        }"""
    assert old_theme_data_setup in content, "old_theme_data_setup not found!"
    content = content.replace(old_theme_data_setup, new_theme_data_setup, 1)

    # 6. In URLsControl.SetCdnTexture: extend URL resolution with all asset dictionaries
    old_cdn_resolve = """                                        var idx = fullUrl.indexOf("asiudgasg/");
                                        if (idx !== -1) {
                                            relPath = fullUrl.substring(idx);
                                        } else {
                                            var cleanUrl = fullUrl.split("?")[0];
                                            if (urlToCardMap && urlToCardMap[cleanUrl]) {
                                                var uInfo = urlToCardMap[cleanUrl];
                                                var uFolder = "wadceg";
                                                relPath = "asiudgasg/asodhsg/" + uFolder + "/" + uInfo.cId + "_" + uInfo.type + ".i.bytes";
                                            }
                                        }"""
    new_cdn_resolve = """                                        var idx = fullUrl.indexOf("asiudgasg/");
                                        if (idx !== -1) {
                                            relPath = fullUrl.substring(idx);
                                        } else {
                                            var cleanUrl = fullUrl.split("?")[0];
                                            var filename = cleanUrl.split("/").pop();

                                            if (cardbookBgMap && cardbookBgMap[filename]) {
                                                relPath = "asiudgasg/asodhsg/foewghkc/" + cardbookBgMap[filename] + ".i.bytes";
                                            } else if (cardbookEmblemMap && cardbookEmblemMap[filename]) {
                                                relPath = "asiudgasg/asodhsg/aweoijs/" + cardbookEmblemMap[filename] + ".i.bytes";
                                            } else if (cardbookBadgeMap && cardbookBadgeMap[filename]) {
                                                relPath = "asiudgasg/asodhsg/bhfbfhbf/" + cardbookBadgeMap[filename] + ".i.bytes";
                                            } else if (cardbookThemeLogoMap && cardbookThemeLogoMap[filename]) {
                                                relPath = "asiudgasg/asodhsg/agewfcbxhaa/" + cardbookThemeLogoMap[filename] + ".i.bytes";
                                            } else if (urlToCardMap && urlToCardMap[cleanUrl]) {
                                                var uInfo = urlToCardMap[cleanUrl];
                                                var uFolder = "wadceg";
                                                relPath = "asiudgasg/asodhsg/" + uFolder + "/" + uInfo.cId + "_" + uInfo.type + ".i.bytes";
                                            }
                                        }"""
    assert old_cdn_resolve in content, "old_cdn_resolve not found!"
    content = content.replace(old_cdn_resolve, new_cdn_resolve, 1)

    # 7. Add offline hooks for CardBook protocols: getReward (0xE9EFB4), setFavoriteGroup (0xE9F2A4)
    target_cb_hooks = "// CardBook Stabilization Hooks"
    assert target_cb_hooks in content, "target_cb_hooks marker not found!"
    cb_protocol_hooks = """// CardBook Protocol Offline Handlers
                var offlineFavoriteGroups = [1001, 2001, 3001, 4001, 5001];

                try {
                    // CardBook.getReward (0xE9EFB4)
                    Interceptor.replace(baseAddr.add(0xE9EFB4), keepCb(new NativeCallback(function (callback, achievementCode, achievementType, methodInfo) {
                        log("[🏆 CARDBOOK] CardBook.getReward called offline: achievementCode=" + achievementCode + " type=" + achievementType);
                        try {
                            if (!callback.isNull()) {
                                var nhClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client", "NetworkHandler") || getClass("Assembly-CSharp", "", "NetworkHandler");
                                var nhObj = il2cpp_object_new(nhClass);
                                if (il2cpp_gchandle_new && !nhObj.isNull()) il2cpp_gchandle_new(nhObj, 2);

                                var methodPtr = callback.add(0x10).readPointer();
                                var targetObj = callback.add(0x20).readPointer();
                                if (!methodPtr.isNull() && !targetObj.isNull()) {
                                    var cbFn = new NativeFunction(methodPtr, "void", ["pointer", "pointer", "pointer", "pointer"]);
                                    cbFn(targetObj, nhObj, NULL, NULL);
                                    log("[✅ CARDBOOK] getReward callback successfully invoked offline!");
                                }
                            }
                        } catch (eGr) {
                            log("[-] Error in CardBook.getReward offline: " + eGr.message);
                        }
                        return NULL;
                    }, "pointer", ["pointer", "int64", "int16", "pointer"])));
                    log("[+] Interceptor.replace installed on CardBook.getReward (0xE9EFB4)!");
                } catch (eHgr) {
                    log("[-] Error replacing CardBook.getReward: " + eHgr.message);
                }

                try {
                    // CardBook.setFavoriteGroup (0xE9F2A4)
                    Interceptor.replace(baseAddr.add(0xE9F2A4), keepCb(new NativeCallback(function (callback, groupList, methodInfo) {
                        log("[⭐ CARDBOOK] CardBook.setFavoriteGroup called offline");
                        try {
                            if (!callback.isNull()) {
                                var nhClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client", "NetworkHandler") || getClass("Assembly-CSharp", "", "NetworkHandler");
                                var nhObj = il2cpp_object_new(nhClass);
                                if (il2cpp_gchandle_new && !nhObj.isNull()) il2cpp_gchandle_new(nhObj, 2);
                                var methodPtr = callback.add(0x10).readPointer();
                                var targetObj = callback.add(0x20).readPointer();
                                if (!methodPtr.isNull() && !targetObj.isNull()) {
                                    var cbFn = new NativeFunction(methodPtr, "void", ["pointer", "pointer", "pointer"]);
                                    cbFn(targetObj, nhObj, NULL);
                                }
                            }
                        } catch (eSfg) {
                            log("[-] Error in setFavoriteGroup offline: " + eSfg.message);
                        }
                        return NULL;
                    }, "pointer", ["pointer", "pointer", "pointer"])));
                    log("[+] Interceptor.replace installed on CardBook.setFavoriteGroup (0xE9F2A4)!");
                } catch (eHsfg) {
                    log("[-] Error replacing CardBook.setFavoriteGroup: " + eHsfg.message);
                }

                // CardBook Stabilization Hooks"""
    content = content.replace(target_cb_hooks, cb_protocol_hooks, 1)

    with open(path, "w", encoding="utf-8") as f:
        f.write(content)

    print("Successfully patched libscript.js with CardBook UI, assets, and offline protocols!")

if __name__ == "__main__":
    main()
