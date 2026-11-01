#!/usr/bin/env python3
"""
Patch libscript.js to integrate all 21 groups, 99 themes, prism overlays,
dynamic group slots, and card inventory.
"""
import sys

def main():
    path = "app/src/main/assets/libscript.js"
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()

    # 1. State variable declarations around line 3845
    target_vars = """                var loonaGroupData = NULL;
                var loonaThemeData = NULL;
                var loonaThemeTypeData = NULL;
                var loonaArtistDataMap = {};
                var loonaCardControlDataMap = {};
                var loonaGroupItemObj = NULL;
                var loonaArtistListFastArray = NULL;"""
    replacement_vars = """                var loonaGroupData = NULL;
                var loonaThemeData = NULL;
                var loonaThemeTypeData = NULL;
                var loonaArtistDataMap = {};
                var loonaCardControlDataMap = {};
                var loonaGroupItemObj = NULL;
                var allInvenGroupItems = {};
                var allCbGroupItemMap = {};
                var allCbGroupItemList = [];
                var allGroupArtistListMap = {};
                var currentSelectedGroupCode = 1001;
                var loonaArtistListFastArray = NULL;"""
    assert target_vars in content, "target_vars not found!"
    content = content.replace(target_vars, replacement_vars, 1)

    # 2. In ensureLoonaMocks(): populate allGroupArtistListMap for all 21 groups
    target_artist_fa = """                            // Build FastArray for LOONA 1001
                            var artistItems = [];
                            for (var ai = 1; ai <= 11; ai++) {
                                artistItems.push(loonaArtistDataMap[ai] || NULL);
                            }
                            loonaArtistListFastArray = createFastArray(artistItems, 'artist');
                            if (il2cpp_gchandle_new && loonaArtistListFastArray && !loonaArtistListFastArray.isNull()) {
                                il2cpp_gchandle_new(loonaArtistListFastArray, 2);
                            }
                            if (loonaGroupData && !loonaGroupData.isNull()) {
                                loonaGroupData.add(0x30).writePointer(loonaArtistListFastArray);
                            }"""
    replacement_artist_fa = """                            // Build FastArray for LOONA 1001
                            var artistItems = [];
                            for (var ai = 1; ai <= 11; ai++) {
                                artistItems.push(loonaArtistDataMap[ai] || NULL);
                            }
                            loonaArtistListFastArray = createFastArray(artistItems, 'artist');
                            if (il2cpp_gchandle_new && loonaArtistListFastArray && !loonaArtistListFastArray.isNull()) {
                                il2cpp_gchandle_new(loonaArtistListFastArray, 2);
                            }
                            if (loonaGroupData && !loonaGroupData.isNull()) {
                                loonaGroupData.add(0x30).writePointer(loonaArtistListFastArray);
                            }
                            allGroupArtistListMap[1001] = loonaArtistListFastArray;

                            // Build FastArrays for all other playable groups
                            for (var pgi = 0; pgi < playables.length; pgi++) {
                                var pGroupCode = playables[pgi];
                                if (allGroupArtistListMap[pGroupCode]) continue;
                                var pMeta = (meta && meta.groups) ? meta.groups[pGroupCode] : null;
                                var pArtistCodes = (pMeta && pMeta.artistCodes) ? pMeta.artistCodes : [];
                                var pArtists = [];
                                for (var pai = 0; pai < pArtistCodes.length; pai++) {
                                    var pac = pArtistCodes[pai];
                                    if (allArtistDataMap[pac]) {
                                        pArtists.push(allArtistDataMap[pac]);
                                    }
                                }
                                if (pArtists.length > 0) {
                                    var pFa = createFastArray(pArtists, 'artist');
                                    if (il2cpp_gchandle_new && pFa && !pFa.isNull()) {
                                        il2cpp_gchandle_new(pFa, 2);
                                    }
                                    allGroupArtistListMap[pGroupCode] = pFa;
                                    if (allGroupDataMap[pGroupCode] && !allGroupDataMap[pGroupCode].isNull()) {
                                        allGroupDataMap[pGroupCode].add(0x30).writePointer(pFa);
                                    }
                                }
                            }"""
    assert target_artist_fa in content, "target_artist_fa not found!"
    content = content.replace(target_artist_fa, replacement_artist_fa, 1)

    # 3. GroupControl.Find (0xB9EF94), GroupControl.Data getters, ThemeControl.Find, ThemeTypeControl.Find, ArtistControl.Find, ArtistControl.Data getters, GroupItem getters
    target_grp_and_art = """                // Proxy GroupControl.Find (0xB9EF94)
                try {
                    Interceptor.replace(baseAddr.add(0xB9EF94), new NativeCallback(function (code, methodInfo) {
                        if (code === 1001) {
                            ensureLoonaMocks();
                            return loonaGroupData || NULL;
                        }
                        return NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupControl.Find (0xB9EF94)!");
                } catch (eGcf) {
                    log("[-] Error replacing GroupControl.Find: " + eGcf.message);
                }

                // Proxy GroupControl.Data getters
                try {
                    Interceptor.replace(baseAddr.add(0xCA4B88), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1001;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4CA0), new NativeCallback(function (thisPtr, methodInfo) {
                        return 12;
                    }, "int16", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4E10), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4C2C), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4CD8), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4BB8), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4F3C), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4EC0), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1001;
                    }, "int16", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4EA4), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xC9A4E8), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA5074), new NativeCallback(function (thisPtr, methodInfo) {
                        return 12;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4CBC), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4D4C), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));

                    log("[+] Interceptor.replace installed on all GroupControl.Data getters!");
                } catch (eGcg) {
                    log("[-] Error replacing GroupControl.Data getters: " + eGcg.message);
                }

                // Proxy ThemeControl.Find (0xB1A12C)
                try {
                    Interceptor.replace(baseAddr.add(0xB1A12C), new NativeCallback(function (code, methodInfo) {
                        ensureLoonaMocks();
                        return loonaThemeData || NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeControl.Find (0xB1A12C)!");
                } catch (eTcf) {
                    log("[-] Error replacing ThemeControl.Find: " + eTcf.message);
                }

                // Proxy ThemeTypeControl.Find (0xB1C144)
                try {
                    Interceptor.replace(baseAddr.add(0xB1C144), new NativeCallback(function (code, methodInfo) {
                        ensureLoonaMocks();
                        return loonaThemeTypeData || NULL;
                    }, "pointer", ["int16", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeTypeControl.Find (0xB1C144)!");
                } catch (eTtf) {
                    log("[-] Error replacing ThemeTypeControl.Find: " + eTtf.message);
                }

                // Replace ThemeTypeControl.Data.GetGradeImagePath (0xC8ADD8)
                try {
                    Interceptor.replace(baseAddr.add(0xC8ADD8), keepCb(new NativeCallback(function (thisPtr, grade, type, methodInfo) {
                        var tc = 0;
                        try {
                            if (thisPtr && !thisPtr.isNull()) {
                                var model = thisPtr.add(0x10).readPointer();
                                if (!model.isNull()) {
                                    tc = model.add(0x10).readS32();
                                }
                            }
                        } catch (eTc) {}
                        return getGradeFrameDownloadPath(grade, type, false, tc);
                    }, "pointer", ["pointer", "int", "int", "pointer"])));
                    log("[+] Interceptor.replace installed on ThemeTypeControl.Data.GetGradeImagePath (0xC8ADD8)!");
                } catch (eGgi) {
                    log("[-] Error replacing ThemeTypeControl.Data.GetGradeImagePath: " + eGgi.message);
                }

                // Proxy ArtistControl.Find (0xAD04DC)
                try {
                    Interceptor.replace(baseAddr.add(0xAD04DC), new NativeCallback(function (code, methodInfo) {
                        ensureLoonaMocks();
                        var mIdx = code > 1000 ? (code - 1000) : (code > 0 ? code : 1);
                        if (mIdx > 12) mIdx = ((mIdx - 1) % 12) + 1;
                        return loonaArtistDataMap[mIdx] || loonaArtistDataMap[1] || NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on ArtistControl.Find (0xAD04DC)!");
                } catch (eAcf) {
                    log("[-] Error replacing ArtistControl.Find: " + eAcf.message);
                }

                // Proxy ArtistControl.Data getters
                try {
                    Interceptor.replace(baseAddr.add(0xEBB39C), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        for (var i = 1; i <= 11; i++) {
                            if (loonaArtistDataMap[i] && loonaArtistDataMap[i].equals(thisPtr)) return (i - 1);
                        }
                        return 0;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB3D4), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        for (var i = 1; i <= 11; i++) {
                            if (loonaArtistDataMap[i] && loonaArtistDataMap[i].equals(thisPtr)) {
                                return createIl2CppString(LOONA_MEMBERS[i - 1].name);
                            }
                        }
                        return createIl2CppString("HeeJin");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB380), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        for (var i = 1; i <= 11; i++) {
                            if (loonaArtistDataMap[i] && loonaArtistDataMap[i].equals(thisPtr)) return i;
                        }
                        return 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB448), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1001;
                    }, "int", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ArtistControl.Data getters!");
                } catch (eAcg) {
                    log("[-] Error replacing ArtistControl.Data getters: " + eAcg.message);
                }"""

    replacement_grp_and_art = """                // Proxy GroupControl.Find (0xB9EF94)
                try {
                    Interceptor.replace(baseAddr.add(0xB9EF94), new NativeCallback(function (code, methodInfo) {
                        ensureLoonaMocks();
                        if (allGroupDataMap[code]) return allGroupDataMap[code];
                        return loonaGroupData || NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupControl.Find (0xB9EF94)!");
                } catch (eGcf) {
                    log("[-] Error replacing GroupControl.Find: " + eGcf.message);
                }

                // Proxy GroupControl.Data getters
                try {
                    function getGroupCodeFromData(thisPtr) {
                        if (!thisPtr || thisPtr.isNull()) return 1001;
                        var gd = thisPtr.add(0x10).readPointer();
                        if (!gd.isNull()) return gd.add(0x10).readS32();
                        return 1001;
                    }

                    Interceptor.replace(baseAddr.add(0xCA4B88), new NativeCallback(function (thisPtr, methodInfo) {
                        return getGroupCodeFromData(thisPtr);
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4CA0), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return gMeta ? (gMeta.memberCount || 11) : 11;
                    }, "int16", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4E10), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return gMeta ? (gMeta.orderIndex || 1) : 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4C2C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return createIl2CppString(gMeta ? gMeta.name : "LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4CD8), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return createIl2CppString(gMeta ? gMeta.name : "LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4BB8), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return createIl2CppString(gMeta ? gMeta.name : "LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4F3C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        var emb = gMeta ? gMeta.emblemPath : ("asiudgasg/asodhsg/aweoijs/" + gc + ".i.bytes");
                        return createDownloadPath(emb);
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4EC0), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return gMeta ? (gMeta.majorGroupCode || gc) : gc;
                    }, "int16", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4EA4), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return gMeta ? (gMeta.isMajorGroup ? 1 : 0) : 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xC9A4E8), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA5074), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return gMeta ? (gMeta.equipableSlot || 11) : 11;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4CBC), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        return createIl2CppString(gMeta ? gMeta.name : "LOONA");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xCA4D4C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = getGroupCodeFromData(thisPtr);
                        var gMeta = getGroupMetadata(gc);
                        var emb = gMeta ? gMeta.emblemPath : ("asiudgasg/asodhsg/aweoijs/" + gc + ".i.bytes");
                        return createDownloadPath(emb);
                    }, "pointer", ["pointer", "pointer"]));

                    log("[+] Interceptor.replace installed on all GroupControl.Data getters!");
                } catch (eGcg) {
                    log("[-] Error replacing GroupControl.Data getters: " + eGcg.message);
                }

                // Proxy ThemeControl.Find (0xB1A12C)
                try {
                    Interceptor.replace(baseAddr.add(0xB1A12C), new NativeCallback(function (code, methodInfo) {
                        ensureLoonaMocks();
                        return getOrCreateThemeData(code);
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeControl.Find (0xB1A12C)!");
                } catch (eTcf) {
                    log("[-] Error replacing ThemeControl.Find: " + eTcf.message);
                }

                // Proxy ThemeTypeControl.Find (0xB1C144)
                try {
                    Interceptor.replace(baseAddr.add(0xB1C144), new NativeCallback(function (code, methodInfo) {
                        ensureLoonaMocks();
                        return getOrCreateThemeTypeData(code);
                    }, "pointer", ["int16", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeTypeControl.Find (0xB1C144)!");
                } catch (eTtf) {
                    log("[-] Error replacing ThemeTypeControl.Find: " + eTtf.message);
                }

                // Replace ThemeTypeControl.Data.GetGradeImagePath (0xC8ADD8)
                try {
                    Interceptor.replace(baseAddr.add(0xC8ADD8), keepCb(new NativeCallback(function (thisPtr, grade, type, methodInfo) {
                        var tc = 0;
                        try {
                            if (thisPtr && !thisPtr.isNull()) {
                                var model = thisPtr.add(0x10).readPointer();
                                if (!model.isNull()) {
                                    tc = model.add(0x10).readS32();
                                }
                            }
                        } catch (eTc) {}
                        return getGradeFrameDownloadPath(grade, type, false, tc);
                    }, "pointer", ["pointer", "int", "int", "pointer"])));
                    log("[+] Interceptor.replace installed on ThemeTypeControl.Data.GetGradeImagePath (0xC8ADD8)!");
                } catch (eGgi) {
                    log("[-] Error replacing ThemeTypeControl.Data.GetGradeImagePath: " + eGgi.message);
                }

                // Proxy ArtistControl.Find (0xAD04DC)
                try {
                    Interceptor.replace(baseAddr.add(0xAD04DC), new NativeCallback(function (code, methodInfo) {
                        ensureLoonaMocks();
                        if (allArtistDataMap[code]) return allArtistDataMap[code];
                        var mIdx = code > 1000 ? (code - 1000) : (code > 0 ? code : 1);
                        if (mIdx > 12) mIdx = ((mIdx - 1) % 12) + 1;
                        return loonaArtistDataMap[mIdx] || loonaArtistDataMap[1] || NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on ArtistControl.Find (0xAD04DC)!");
                } catch (eAcf) {
                    log("[-] Error replacing ArtistControl.Find: " + eAcf.message);
                }

                // Proxy ArtistControl.Data getters
                try {
                    function getArtistModel(thisPtr) {
                        if (!thisPtr || thisPtr.isNull()) return NULL;
                        return thisPtr.add(0x10).readPointer();
                    }

                    Interceptor.replace(baseAddr.add(0xEBB39C), new NativeCallback(function (thisPtr, methodInfo) {
                        var ad = getArtistModel(thisPtr);
                        if (!ad.isNull()) return ad.add(0x98).readS16();
                        return 0;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB3D4), new NativeCallback(function (thisPtr, methodInfo) {
                        var ad = getArtistModel(thisPtr);
                        if (!ad.isNull()) {
                            var strPtr = ad.add(0x88).readPointer();
                            if (!strPtr.isNull()) return strPtr;
                            var ac = ad.add(0x10).readS32();
                            var aMeta = getArtistMetadata(ac);
                            if (aMeta && aMeta.name) return createIl2CppString(aMeta.name);
                        }
                        return createIl2CppString("Artist");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB380), new NativeCallback(function (thisPtr, methodInfo) {
                        var ad = getArtistModel(thisPtr);
                        if (!ad.isNull()) return ad.add(0x10).readS32();
                        return 1001;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB448), new NativeCallback(function (thisPtr, methodInfo) {
                        var ad = getArtistModel(thisPtr);
                        if (!ad.isNull()) return ad.add(0x18).readS32();
                        return 1001;
                    }, "int", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ArtistControl.Data getters!");
                } catch (eAcg) {
                    log("[-] Error replacing ArtistControl.Data getters: " + eAcg.message);
                }"""
    assert target_grp_and_art in content, "target_grp_and_art not found!"
    content = content.replace(target_grp_and_art, replacement_grp_and_art, 1)

    # 4. GroupItem getters (0xB56E7C, 0xB56E40, 0xB56EB8)
    target_gi_getters = """                // Replace GroupItem getters for name and emblem
                try {
                    Interceptor.replace(baseAddr.add(0xB56E7C), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("LOONA");
                    }, "pointer", ["pointer", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xB56E40), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("LOONA");
                    }, "pointer", ["pointer", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xB56EB8), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupItem getters (0xB56E7C, 0xB56E40, 0xB56EB8)!");
                } catch (eGig) {
                    log("[-] Error replacing GroupItem getters: " + eGig.message);
                }"""
    replacement_gi_getters = """                // Replace GroupItem getters for name and emblem
                try {
                    Interceptor.replace(baseAddr.add(0xB56E7C), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = (!thisPtr.isNull()) ? thisPtr.add(0x50).readS32() : 1001;
                        var gMeta = getGroupMetadata(gc);
                        return createIl2CppString(gMeta ? gMeta.name : "LOONA");
                    }, "pointer", ["pointer", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xB56E40), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = (!thisPtr.isNull()) ? thisPtr.add(0x50).readS32() : 1001;
                        var gMeta = getGroupMetadata(gc);
                        return createIl2CppString(gMeta ? gMeta.name : "LOONA");
                    }, "pointer", ["pointer", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xB56EB8), new NativeCallback(function (thisPtr, methodInfo) {
                        var gc = (!thisPtr.isNull()) ? thisPtr.add(0x50).readS32() : 1001;
                        var gMeta = getGroupMetadata(gc);
                        var emb = gMeta ? gMeta.emblemPath : ("asiudgasg/asodhsg/aweoijs/" + gc + ".i.bytes");
                        return createDownloadPath(emb);
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupItem getters (0xB56E7C, 0xB56E40, 0xB56EB8)!");
                } catch (eGig) {
                    log("[-] Error replacing GroupItem getters: " + eGig.message);
                }"""
    assert target_gi_getters in content, "target_gi_getters not found!"
    content = content.replace(target_gi_getters, replacement_gi_getters, 1)

    # 5. Prism getters and cardGettersRetZero / cardGettersRetNull
    target_card_getters = """                var cardGettersRetZero = [
                    0xE43328, // CardControl.Data.get_Type -> 0
                    0xE43344, // CardControl.Data.get_IsPrism -> 0
                    0xE43368, // CardControl.Data.get_Prism -> 0
                    0xE433D4, // CardControl.Data.get_IsSelectCard -> 0
                    0xE433F0, // CardControl.Data.get_IntensifyPercentage -> 0
                    0xE435FC, // CardControl.Data.get_IsEquipCard -> 0
                    0xE43694, // CardControl.Data.get_GetCardBookScoreType -> 0
                    0xBD90BC, // PrismControl.Data.get_Code -> 0
                    0xBD90F4, // PrismControl.Data.get_ServerDataUse -> 0
                    0xB55F24  // CardItem.get_IsUnAvailableCard -> 0
                ];
                cardGettersRetZero.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 8, "rwx");
                        baseAddr.add(rva).writeByteArray([0xe0, 0x03, 0x1f, 0x2a, 0xc0, 0x03, 0x5f, 0xd6]); // mov w0, wzr; ret
                    } catch (e) {}
                });"""
    replacement_card_getters = """                var cardGettersRetZero = [
                    0xE43328, // CardControl.Data.get_Type -> 0
                    0xE43368, // CardControl.Data.get_Prism -> 0
                    0xE433D4, // CardControl.Data.get_IsSelectCard -> 0
                    0xE433F0, // CardControl.Data.get_IntensifyPercentage -> 0
                    0xE435FC, // CardControl.Data.get_IsEquipCard -> 0
                    0xE43694, // CardControl.Data.get_GetCardBookScoreType -> 0
                    0xBD90BC, // PrismControl.Data.get_Code -> 0
                    0xBD90F4, // PrismControl.Data.get_ServerDataUse -> 0
                    0xB55F24  // CardItem.get_IsUnAvailableCard -> 0
                ];
                cardGettersRetZero.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 8, "rwx");
                        baseAddr.add(rva).writeByteArray([0xe0, 0x03, 0x1f, 0x2a, 0xc0, 0x03, 0x5f, 0xd6]); // mov w0, wzr; ret
                    } catch (e) {}
                });

                // Proxy CardControl.Data.get_IsPrism (0xE43344)
                try {
                    Interceptor.replace(baseAddr.add(0xE43344), keepCb(new NativeCallback(function (thisPtr, methodInfo) {
                        if (!thisPtr.isNull()) {
                            var cd = thisPtr.add(0x10).readPointer();
                            if (!cd.isNull()) {
                                var cId = cd.add(0x10).readS32();
                                var meta = getCardMetadata(cId);
                                if (meta && meta.isPrism) return 1;
                                return cd.add(0x14).readS32() === 1 ? 1 : 0;
                            }
                        }
                        return 0;
                    }, "int", ["pointer", "pointer"])));
                    log("[+] Interceptor.replace installed on CardControl.Data.get_IsPrism (0xE43344)!");
                } catch (eIpr) {
                    log("[-] Error replacing CardControl.Data.get_IsPrism: " + eIpr.message);
                }"""
    assert target_card_getters in content, "target_card_getters not found!"
    content = content.replace(target_card_getters, replacement_card_getters, 1)

    target_prism_paths = """                var cardGettersRetNull = [
                    0xE433C4, // CardControl.Data.get_PrismData -> NULL
                    0xBD90D8, // PrismControl.Data.get_Locale -> NULL
                    0xBD9110, // PrismControl.Data.get_PrismImageSmallPath -> NULL
                    0xBD91E8  // PrismControl.Data.get_PrismImageLargePath -> NULL
                ];
                cardGettersRetNull.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 8, "rwx");
                        baseAddr.add(rva).writeByteArray([0xe0, 0x03, 0x1f, 0xaa, 0xc0, 0x03, 0x5f, 0xd6]); // mov x0, xzr; ret
                    } catch (e) {}
                });"""
    replacement_prism_paths = """                var cardGettersRetNull = [
                    0xE433C4, // CardControl.Data.get_PrismData -> NULL
                    0xBD90D8  // PrismControl.Data.get_Locale -> NULL
                ];
                cardGettersRetNull.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 8, "rwx");
                        baseAddr.add(rva).writeByteArray([0xe0, 0x03, 0x1f, 0xaa, 0xc0, 0x03, 0x5f, 0xd6]); // mov x0, xzr; ret
                    } catch (e) {}
                });

                // Proxy PrismControl.Data prism overlay download paths
                try {
                    Interceptor.replace(baseAddr.add(0xBD9110), keepCb(new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/uhg/1_s.i.bytes");
                    }, "pointer", ["pointer", "pointer"])));
                    Interceptor.replace(baseAddr.add(0xBD91E8), keepCb(new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/uhg/1_l.i.bytes");
                    }, "pointer", ["pointer", "pointer"])));
                    log("[+] Interceptor.replace installed on PrismControl.Data prism paths (0xBD9110, 0xBD91E8)!");
                } catch (ePrismP) {
                    log("[-] Error replacing PrismControl prism paths: " + ePrismP.message);
                }"""
    assert target_prism_paths in content, "target_prism_paths not found!"
    content = content.replace(target_prism_paths, replacement_prism_paths, 1)

    # 6. GroupItem..ctor (0xB56EF4)
    target_gic = """                // 1. GroupItem..ctor (0xB56EF4) - Safe replacement that never throws NullReferenceException
                try {
                    Interceptor.replace(baseAddr.add(0xB56EF4), new NativeCallback(function (thisPtr, code, map, subItem, methodInfo) {
                        log("[🃏 INVENTORY] Safe GroupItem..ctor executed for code: " + code);
                        try {
                            ensureLoonaMocks();
                            thisPtr.add(0x10).writePointer(loonaGroupData || NULL);
                            thisPtr.add(0x18).writePointer(NULL);
                            thisPtr.add(0x20).writePointer(NULL);
                            thisPtr.add(0x28).writePointer(loonaCardListFastArray || NULL);
                            thisPtr.add(0x30).writePointer(loonaEachThemeBestCardMap || NULL);
                            thisPtr.add(0x38).writeS16(-1);
                            thisPtr.add(0x40).writePointer(NULL);
                            thisPtr.add(0x48).writeS16(-1);
                            thisPtr.add(0x4A).writeS16(4);
                            thisPtr.add(0x4C).writeS32(0);
                            thisPtr.add(0x50).writeS32(1001);
                            thisPtr.add(0x54).writeS32(1);
                            thisPtr.add(0x58).writeS32(0);
                            thisPtr.add(0x5C).writeS32(0);
                        } catch (e) {
                            log("[-] Error in GroupItem..ctor replacement: " + e.message);
                        }
                    }, "void", ["pointer", "int", "pointer", "pointer", "pointer"]));"""
    replacement_gic = """                // 1. GroupItem..ctor (0xB56EF4) - Safe replacement that never throws NullReferenceException
                try {
                    Interceptor.replace(baseAddr.add(0xB56EF4), new NativeCallback(function (thisPtr, code, map, subItem, methodInfo) {
                        log("[🃏 INVENTORY] Safe GroupItem..ctor executed for code: " + code);
                        try {
                            ensureLoonaMocks();
                            var gObj = allGroupDataMap[code] || loonaGroupData || NULL;
                            var fa = allGroupArtistListMap[code] || loonaCardListFastArray || NULL;
                            thisPtr.add(0x10).writePointer(gObj);
                            thisPtr.add(0x18).writePointer(NULL);
                            thisPtr.add(0x20).writePointer(NULL);
                            thisPtr.add(0x28).writePointer(fa);
                            thisPtr.add(0x30).writePointer(NULL);
                            thisPtr.add(0x38).writeS16(-1);
                            thisPtr.add(0x40).writePointer(NULL);
                            thisPtr.add(0x48).writeS16(-1);
                            thisPtr.add(0x4A).writeS16(4);
                            thisPtr.add(0x4C).writeS32(0);
                            thisPtr.add(0x50).writeS32(code);
                            thisPtr.add(0x54).writeS32(1);
                            thisPtr.add(0x58).writeS32(0);
                            thisPtr.add(0x5C).writeS32(0);
                        } catch (e) {
                            log("[-] Error in GroupItem..ctor replacement: " + e.message);
                        }
                    }, "void", ["pointer", "int", "pointer", "pointer", "pointer"]));"""
    assert target_gic in content, "target_gic not found!"
    content = content.replace(target_gic, replacement_gic, 1)

    # 7. GroupControl.Data.get_ArtistList (0xCA5054)
    target_gal = """                // 3. GroupControl.Data.get_ArtistList (0xCA5054) -> return loonaArtistListFastArray
                try {
                    Interceptor.replace(baseAddr.add(0xCA5054), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        return loonaArtistListFastArray || NULL;
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupControl.Data.get_ArtistList (0xCA5054)!");
                } catch (eGal) {
                    log("[-] Error replacing get_ArtistList: " + eGal.message);
                }"""
    replacement_gal = """                // 3. GroupControl.Data.get_ArtistList (0xCA5054) -> return group specific FastArray
                try {
                    Interceptor.replace(baseAddr.add(0xCA5054), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        if (!thisPtr.isNull()) {
                            var gd = thisPtr.add(0x10).readPointer();
                            if (!gd.isNull()) {
                                var gc = gd.add(0x10).readS32();
                                if (allGroupArtistListMap[gc]) return allGroupArtistListMap[gc];
                            }
                        }
                        return loonaArtistListFastArray || NULL;
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupControl.Data.get_ArtistList (0xCA5054)!");
                } catch (eGal) {
                    log("[-] Error replacing get_ArtistList: " + eGal.message);
                }"""
    assert target_gal in content, "target_gal not found!"
    content = content.replace(target_gal, replacement_gal, 1)

    # 8. FindToGroupItem (0xF29604), get_SelectedGroupCode (0xF26F64), set_SelectedGroupCode (0xF26FBC)
    target_fgi_sgc = """                // 4. InventoryControl.FindToGroupItem (0xF29604) -> return loonaGroupItemObj
                try {
                    Interceptor.replace(baseAddr.add(0xF29604), new NativeCallback(function (groupCode, methodInfo) {
                        return loonaGroupItemObj || NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.FindToGroupItem (0xF29604)!");
                } catch (eFgi) {
                    log("[-] Error replacing FindToGroupItem: " + eFgi.message);
                }

                // 5. InventoryControl.get_SelectedGroupCode (0xF26F64) -> return 1001
                try {
                    Interceptor.replace(baseAddr.add(0xF26F64), new NativeCallback(function (methodInfo) {
                        return 1001;
                    }, "int", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_SelectedGroupCode (0xF26F64) -> 1001");
                } catch (eSgc) {
                    log("[-] Error replacing get_SelectedGroupCode: " + eSgc.message);
                }"""
    replacement_fgi_sgc = """                // 4. InventoryControl.FindToGroupItem (0xF29604) -> return group specific GroupItem
                try {
                    Interceptor.replace(baseAddr.add(0xF29604), new NativeCallback(function (groupCode, methodInfo) {
                        if (allInvenGroupItems[groupCode]) return allInvenGroupItems[groupCode];
                        return loonaGroupItemObj || NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.FindToGroupItem (0xF29604)!");
                } catch (eFgi) {
                    log("[-] Error replacing FindToGroupItem: " + eFgi.message);
                }

                // 5. InventoryControl.get_SelectedGroupCode (0xF26F64) -> dynamic group code
                try {
                    Interceptor.replace(baseAddr.add(0xF26F64), new NativeCallback(function (methodInfo) {
                        return currentSelectedGroupCode;
                    }, "int", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_SelectedGroupCode (0xF26F64)!");
                } catch (eSgc) {
                    log("[-] Error replacing get_SelectedGroupCode: " + eSgc.message);
                }

                // 5b. InventoryControl.set_SelectedGroupCode (0xF26FBC) -> store dynamic group code
                try {
                    Interceptor.replace(baseAddr.add(0xF26FBC), new NativeCallback(function (value, methodInfo) {
                        currentSelectedGroupCode = value;
                        log("[🃏 INVENTORY] InventoryControl.SelectedGroupCode set to: " + value);
                    }, "void", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.set_SelectedGroupCode (0xF26FBC)!");
                } catch (eSetSgc) {
                    log("[-] Error replacing set_SelectedGroupCode: " + eSetSgc.message);
                }"""
    assert target_fgi_sgc in content, "target_fgi_sgc not found!"
    content = content.replace(target_fgi_sgc, replacement_fgi_sgc, 1)

    # 9. createMockSmallCardParams & createMockLargeCardParams prism support
    target_small_params = """                function createMockSmallCardParams(cardId, grade, level, isEquip) {
                    try {
                        var baseItem = NULL;
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var i = 0; i < loonaCardItems.length; i++) {
                                var it = loonaCardItems[i];
                                if (it && !it.isNull()) {
                                    var r = it.add(0x10).readPointer();
                                    if (!r.isNull() && r.add(0x20).readS32() === cardId) {
                                        baseItem = it;
                                        break;
                                    }
                                }
                            }
                            if (!baseItem || baseItem.isNull()) baseItem = loonaCardItems[0];
                        }
                        var p = NULL;
                        if (baseItem && !baseItem.isNull()) {
                            var getSmallFn = new NativeFunction(baseAddr.add(0xABEB30), "pointer", ["pointer", "pointer", "bool", "pointer"]);
                            p = getSmallFn(baseItem, NULL, 0, NULL);
                        }
                        if (!p || p.isNull()) {
                            try {
                                var csvParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "CardSmallView/Params");
                                if (csvParamsKlass && !csvParamsKlass.isNull()) {
                                    p = il2cpp_object_new(csvParamsKlass);
                                }
                            } catch (eCsvK) {}
                        }
                        if (!p || p.isNull()) return NULL;
                        if (il2cpp_gchandle_new) il2cpp_gchandle_new(p, 2);

                        var cFolder = "wadceg";
                        var photoDp = createDownloadPath("asiudgasg/asodhsg/" + cFolder + "/" + cardId + "_s.i.bytes");
                        var tierDp = getGradeFrameDownloadPath(grade, 1);
                        var maxLvl = (grade === 4) ? 50 : 5;
                        var safeLvl = (grade === 4) ? level : Math.min(Math.max(level, 1), 5);

                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(tierDp || NULL);
                        p.add(0x20).writeU8(0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(NULL);"""
    replacement_small_params = """                function createMockSmallCardParams(cardId, grade, level, isEquip, isPrism) {
                    try {
                        var baseItem = NULL;
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var i = 0; i < loonaCardItems.length; i++) {
                                var it = loonaCardItems[i];
                                if (it && !it.isNull()) {
                                    var r = it.add(0x10).readPointer();
                                    if (!r.isNull() && r.add(0x20).readS32() === cardId) {
                                        baseItem = it;
                                        break;
                                    }
                                }
                            }
                            if (!baseItem || baseItem.isNull()) baseItem = loonaCardItems[0];
                        }
                        var p = NULL;
                        if (baseItem && !baseItem.isNull()) {
                            var getSmallFn = new NativeFunction(baseAddr.add(0xABEB30), "pointer", ["pointer", "pointer", "bool", "pointer"]);
                            p = getSmallFn(baseItem, NULL, 0, NULL);
                        }
                        if (!p || p.isNull()) {
                            try {
                                var csvParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "CardSmallView/Params");
                                if (csvParamsKlass && !csvParamsKlass.isNull()) {
                                    p = il2cpp_object_new(csvParamsKlass);
                                }
                            } catch (eCsvK) {}
                        }
                        if (!p || p.isNull()) return NULL;
                        if (il2cpp_gchandle_new) il2cpp_gchandle_new(p, 2);

                        var cFolder = "wadceg";
                        var photoDp = createDownloadPath("asiudgasg/asodhsg/" + cFolder + "/" + cardId + "_s.i.bytes");
                        var tierDp = getGradeFrameDownloadPath(grade, 1);
                        var maxLvl = (grade === 4) ? 50 : 5;
                        var safeLvl = (grade === 4) ? level : Math.min(Math.max(level, 1), 5);
                        var prismDp = isPrism ? createDownloadPath("asiudgasg/asodhsg/uhg/1_s.i.bytes") : NULL;

                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(tierDp || NULL);
                        p.add(0x20).writeU8(isPrism ? 1 : 0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(prismDp || NULL);"""
    assert target_small_params in content, "target_small_params not found!"
    content = content.replace(target_small_params, replacement_small_params, 1)

    # In createMockLargeCardParams: write prismPath
    target_large_params = """                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(tierDp || NULL);
                        p.add(0x20).writeU8(isPrism ? 1 : 0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(NULL);"""
    replacement_large_params = """                        var prismLargeDp = isPrism ? createDownloadPath("asiudgasg/asodhsg/uhg/1_l.i.bytes") : NULL;
                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(tierDp || NULL);
                        p.add(0x20).writeU8(isPrism ? 1 : 0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(prismLargeDp || NULL);"""
    assert target_large_params in content, "target_large_params not found!"
    content = content.replace(target_large_params, replacement_large_params, 1)

    # In ViewControl.GetSmallCardViewData (0xABEB30): pass isPrism
    target_get_small = """                                        var objIdStr = raw.add(0x10).readU64().toString();
                                        cId = raw.add(0x20).readS32();
                                        gr = raw.add(0x24).readS32();
                                        lvl = raw.add(0x1C).readS16();
                                        var profile = loadPlayerProfile();
                                        if (profile && profile.inventoryCards) {
                                            var found = profile.inventoryCards.find(function(c) {
                                                return c.objectID && c.objectID.toString() === objIdStr;
                                            });
                                            if (found) {
                                                isEq = !!found.isEquip;
                                                gr = (found.grade !== undefined) ? found.grade : gr;
                                                lvl = found.level || lvl;
                                            } else {
                                                isEq = (raw.add(0x28).readU8() === 1);
                                            }
                                        } else {
                                            isEq = (raw.add(0x28).readU8() === 1);
                                        }
                                    }
                                }
                            } catch (e) {}
                            return createMockSmallCardParams(cId, gr, lvl, isEq);"""
    replacement_get_small = """                                        var objIdStr = raw.add(0x10).readU64().toString();
                                        cId = raw.add(0x20).readS32();
                                        gr = raw.add(0x24).readS32();
                                        lvl = raw.add(0x1C).readS16();
                                        var isPrism = (raw.add(0x2A).readU8() === 1);
                                        var profile = loadPlayerProfile();
                                        if (profile && profile.inventoryCards) {
                                            var found = profile.inventoryCards.find(function(c) {
                                                return c.objectID && c.objectID.toString() === objIdStr;
                                            });
                                            if (found) {
                                                isEq = !!found.isEquip;
                                                gr = (found.grade !== undefined) ? found.grade : gr;
                                                lvl = found.level || lvl;
                                                if (found.isPrism !== undefined) isPrism = !!found.isPrism;
                                            } else {
                                                isEq = (raw.add(0x28).readU8() === 1);
                                            }
                                        } else {
                                            isEq = (raw.add(0x28).readU8() === 1);
                                        }
                                    }
                                }
                            } catch (e) {}
                            return createMockSmallCardParams(cId, gr, lvl, isEq, isPrism);"""
    assert target_get_small in content, "target_get_small not found!"
    content = content.replace(target_get_small, replacement_get_small, 1)

    # 10. InventoryScene.GetGroupViewData (0x105E8E4) dynamic group support
    target_get_group_view = """                            // Populate fields safely
                            p.add(0x10).writePointer(createIl2CppString("LOONA"));
                            p.add(0x18).writeS32(11); // memberCount = 11"""
    replacement_get_group_view = """                            var gCode = currentSelectedGroupCode;
                            if (groupItem && !groupItem.isNull()) {
                                var giCode = groupItem.add(0x50).readS32();
                                if (giCode > 0) gCode = giCode;
                            }
                            var gMeta = getGroupMetadata(gCode);
                            var gName = gMeta ? gMeta.name : "LOONA";
                            var slotCount = gMeta ? gMeta.equipableSlot : 11;

                            // Populate fields safely
                            p.add(0x10).writePointer(createIl2CppString(gName));
                            p.add(0x18).writeS32(slotCount);"""
    assert target_get_group_view in content, "target_get_group_view not found!"
    content = content.replace(target_get_group_view, replacement_get_group_view, 1)

    # 11. InvenGroupItemView.Refresh (0xF23954) dynamic slots (11, 10, 4, 3) and names
    target_refresh_group = """                                    var profile = loadPlayerProfile();
                                    var eqCards = (profile && profile.inventoryCards) ? profile.inventoryCards.filter(function(c) { return c.isEquip; }) : [];
                                    for (var i = 0; i < cardCount; i++) {
                                        var cardSmallView = cardItemsPtr.add(0x20 + i * 8).readPointer();
                                        if (!cardSmallView.isNull()) {
                                            if (i >= 11) {
                                                try {
                                                    var go = getGameObjectFn(cardSmallView, NULL);
                                                    if (!go.isNull()) {
                                                        setActiveFn(go, 0, NULL);
                                                    }
                                                } catch (eHide) {}
                                                continue;
                                            }
                                            try {
                                                var go = getGameObjectFn(cardSmallView, NULL);
                                                if (!go.isNull()) {
                                                    setActiveFn(go, 1, NULL);
                                                }
                                            } catch (eShow) {}

                                            var mIdx = (i % 11);
                                            var targetCard = eqCards.find(function(c) { return ((c.cardID - 1001) % 11) === mIdx; });"""

    replacement_refresh_group = """                                    var profile = loadPlayerProfile();
                                    var curGroupCode = currentSelectedGroupCode;
                                    var curGroupMeta = getGroupMetadata(curGroupCode);
                                    var curSlotCount = curGroupMeta ? curGroupMeta.equipableSlot : 11;
                                    var curArtistCodes = (curGroupMeta && curGroupMeta.artistCodes) ? curGroupMeta.artistCodes : [];

                                    var eqCards = (profile && profile.inventoryCards) ? profile.inventoryCards.filter(function(c) { return c.isEquip; }) : [];
                                    for (var i = 0; i < cardCount; i++) {
                                        var cardSmallView = cardItemsPtr.add(0x20 + i * 8).readPointer();
                                        if (!cardSmallView.isNull()) {
                                            if (i >= curSlotCount) {
                                                try {
                                                    var go = getGameObjectFn(cardSmallView, NULL);
                                                    if (!go.isNull()) {
                                                        setActiveFn(go, 0, NULL);
                                                    }
                                                } catch (eHide) {}
                                                continue;
                                            }
                                            try {
                                                var go = getGameObjectFn(cardSmallView, NULL);
                                                if (!go.isNull()) {
                                                    setActiveFn(go, 1, NULL);
                                                }
                                            } catch (eShow) {}

                                            var targetArtistCode = (i < curArtistCodes.length) ? curArtistCodes[i] : null;
                                            var targetCard = eqCards.find(function(c) {
                                                var cm = getCardMetadata(c.cardID);
                                                return cm && cm.group === curGroupCode && cm.artistID === targetArtistCode;
                                            });"""
    assert target_refresh_group in content, "target_refresh_group not found!"
    content = content.replace(target_refresh_group, replacement_refresh_group, 1)

    # 12. InvenGroupItemView.Refresh: pass isPrism to createMockSmallCardParams for equipped slot
    target_card_param_call = """                                                var cId = targetCard.cardID;
                                                var gr = targetCard.grade;
                                                var lvl = targetCard.level;
                                                var cardParam = createMockSmallCardParams(cId, gr, lvl, false);"""
    replacement_card_param_call = """                                                var cId = targetCard.cardID;
                                                var gr = targetCard.grade;
                                                var lvl = targetCard.level;
                                                var isPrism = !!targetCard.isPrism;
                                                var cardParam = createMockSmallCardParams(cId, gr, lvl, false, isPrism);"""
    assert target_card_param_call in content, "target_card_param_call not found!"
    content = content.replace(target_card_param_call, replacement_card_param_call, 1)

    # 13. CardBookControl.GetGroupItem & CardBookScene.GetGroupItemOfIndex
    target_cb_getters = """                // 3f. CardBookControl.GetGroupItem (0x11C83DC) & GetMajorGroupItem (0x11C8528) -> Safe LOONA group return
                try {
                    Interceptor.replace(baseAddr.add(0x11C83DC), new NativeCallback(function (groupList, groupCode, methodInfo) {
                        return cachedLoonaCbGroupItem || NULL;
                    }, "pointer", ["pointer", "int", "pointer"]));
                    Interceptor.replace(baseAddr.add(0x11C8528), new NativeCallback(function (groupList, groupCode, methodInfo) {
                        return cachedLoonaCbGroupItem || NULL;
                    }, "pointer", ["pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookControl.GetGroupItem & GetMajorGroupItem!");
                } catch (eGgi) {
                    log("[-] Error replacing GetGroupItem: " + eGgi.message);
                }

                // 3g. CardBookScene.GetGroupItemOfIndex (0x11D1D60) -> Return LOONA for index 0
                try {
                    Interceptor.replace(baseAddr.add(0x11D1D60), new NativeCallback(function (scenePtr, infoPtr, index, methodInfo) {
                        if (index === 0) return cachedLoonaCbGroupItem || NULL;
                        return NULL;
                    }, "pointer", ["pointer", "pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookScene.GetGroupItemOfIndex (0x11D1D60)!");
                } catch (eGgioi) {
                    log("[-] Error replacing GetGroupItemOfIndex: " + eGgioi.message);
                }"""
    replacement_cb_getters = """                // 3f. CardBookControl.GetGroupItem (0x11C83DC) & GetMajorGroupItem (0x11C8528) -> Dynamic group return
                try {
                    Interceptor.replace(baseAddr.add(0x11C83DC), new NativeCallback(function (groupList, groupCode, methodInfo) {
                        if (allCbGroupItemMap[groupCode]) return allCbGroupItemMap[groupCode];
                        return cachedLoonaCbGroupItem || NULL;
                    }, "pointer", ["pointer", "int", "pointer"]));
                    Interceptor.replace(baseAddr.add(0x11C8528), new NativeCallback(function (groupList, groupCode, methodInfo) {
                        if (allCbGroupItemMap[groupCode]) return allCbGroupItemMap[groupCode];
                        return cachedLoonaCbGroupItem || NULL;
                    }, "pointer", ["pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookControl.GetGroupItem & GetMajorGroupItem!");
                } catch (eGgi) {
                    log("[-] Error replacing GetGroupItem: " + eGgi.message);
                }

                // 3g. CardBookScene.GetGroupItemOfIndex (0x11D1D60) -> Return group item by index
                try {
                    Interceptor.replace(baseAddr.add(0x11D1D60), new NativeCallback(function (scenePtr, infoPtr, index, methodInfo) {
                        if (index >= 0 && index < allCbGroupItemList.length) {
                            return allCbGroupItemList[index];
                        }
                        return cachedLoonaCbGroupItem || NULL;
                    }, "pointer", ["pointer", "pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookScene.GetGroupItemOfIndex (0x11D1D60)!");
                } catch (eGgioi) {
                    log("[-] Error replacing GetGroupItemOfIndex: " + eGgioi.message);
                }"""
    assert target_cb_getters in content, "target_cb_getters not found!"
    content = content.replace(target_cb_getters, replacement_cb_getters, 1)

    # 14. DisplayGroupList initializer
    target_dgl = """                        var listKlass = getClass("mscorlib", "System.Collections.Generic", "List`1");
                        if (listKlass && !listKlass.isNull()) {
                            var newDgl = il2cpp_object_new(listKlass);
                            if (!newDgl.isNull()) {
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(newDgl, 2);
                                var arrKlass = (loonaGroupItemObj && !loonaGroupItemObj.isNull()) ? loonaGroupItemObj.readPointer() : listKlass;
                                var arr = il2cpp_array_new(arrKlass, 8);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(arr, 2);
                                newDgl.add(0x10).writePointer(arr);
                                if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                                    arr.add(0x20).writePointer(loonaGroupItemObj);
                                    newDgl.add(0x18).writeS32(1);
                                } else {
                                    newDgl.add(0x18).writeS32(0);
                                }
                                var setDglFn = new NativeFunction(baseAddr.add(0xF27770), "void", ["pointer", "pointer"]);
                                setDglFn(newDgl, NULL);
                                cachedDglInstance = newDgl;
                                log("[🃏 INVENTORY] Created authentic IL2CPP List<GroupItem> for DisplayGroupList: " + newDgl + " (count=" + newDgl.add(0x18).readS32() + ")");
                                return newDgl;
                            }
                        }"""
    replacement_dgl = """                        var listKlass = getClass("mscorlib", "System.Collections.Generic", "List`1");
                        if (listKlass && !listKlass.isNull()) {
                            var newDgl = il2cpp_object_new(listKlass);
                            if (!newDgl.isNull()) {
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(newDgl, 2);
                                var meta = getGlobalMetadata();
                                var playables = (meta && meta.playableGroups) ? meta.playableGroups : PLAYABLE_GROUP_CODES;
                                var totalGroups = playables.length;
                                var arrKlass = (loonaGroupItemObj && !loonaGroupItemObj.isNull()) ? loonaGroupItemObj.readPointer() : listKlass;
                                var arr = il2cpp_array_new(arrKlass, totalGroups + 8);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(arr, 2);
                                newDgl.add(0x10).writePointer(arr);
                                var actualCount = 0;
                                for (var pi = 0; pi < totalGroups; pi++) {
                                    var gCode = playables[pi];
                                    var gi = allInvenGroupItems[gCode] || (gCode === 1001 ? loonaGroupItemObj : NULL);
                                    if (gi && !gi.isNull()) {
                                        arr.add(0x20 + actualCount * 8).writePointer(gi);
                                        actualCount++;
                                    }
                                }
                                newDgl.add(0x18).writeS32(actualCount);
                                var setDglFn = new NativeFunction(baseAddr.add(0xF27770), "void", ["pointer", "pointer"]);
                                setDglFn(newDgl, NULL);
                                cachedDglInstance = newDgl;
                                log("[🃏 INVENTORY] Created authentic IL2CPP List<GroupItem> for DisplayGroupList: " + newDgl + " (count=" + actualCount + ")");
                                return newDgl;
                            }
                        }"""
    assert target_dgl in content, "target_dgl not found!"
    content = content.replace(target_dgl, replacement_dgl, 1)

    # 15. populateOfflineInventoryCards: validCards filter, group item population for all 21 groups
    target_pop_filter = """                        var validCards = profile.inventoryCards.filter(function(c) {
                            return c && c.cardID >= 1001 && c.cardID <= 1021;
                        });"""
    replacement_pop_filter = """                        var validCards = profile.inventoryCards.filter(function(c) {
                            return c && c.cardID >= 1001 && c.cardID <= 30005;
                        });"""
    assert target_pop_filter in content, "target_pop_filter not found!"
    content = content.replace(target_pop_filter, replacement_pop_filter, 1)

    # Also sortCardIndex and isMaterial in cardItem creation
    target_card_fields = """                                var formulaCode = (gr < 4) ? (gr * 5 + Math.min(4, lvl - 1)) : (20 + Math.min(98, lvl - 1));
                                cardItemObj.add(0x20).writeS16(formulaCode); // <IntensifyCode>
                                cardItemObj.add(0x24).writeU32(0x3F800000); // 1.0f
                                cardItemObj.add(0x28).writeS32(100); // <SellPrice>
                                cardItemObj.add(0x2C).writeU8(0); // isMaterial = false
                                var meta = getCardMetadata(cId);
                                var memberIdx = (meta.artistID >= 1000) ? (meta.artistID - 1000) : meta.artistID;
                                if (memberIdx < 1 || memberIdx > 11) memberIdx = ((cId - 1001) % 11) + 1;
                                cardItemObj.add(0x30).writeS32(1001 * 10000 + 1 * 100 + memberIdx); // sortCardIndex"""
    replacement_card_fields = """                                var formulaCode = (gr < 4) ? (gr * 5 + Math.min(4, lvl - 1)) : (20 + Math.min(98, lvl - 1));
                                cardItemObj.add(0x20).writeS16(formulaCode); // <IntensifyCode>
                                cardItemObj.add(0x24).writeU32(0x3F800000); // 1.0f
                                cardItemObj.add(0x28).writeS32(100); // <SellPrice>
                                var meta = getCardMetadata(cId);
                                var isMat = (cData.isMaterial || (meta && meta.isMaterial) || (cId >= 30001 && cId <= 30005));
                                cardItemObj.add(0x2C).writeU8(isMat ? 1 : 0); // isMaterial
                                var gCode = (meta && meta.group) ? meta.group : 1001;
                                var aId = (meta && meta.artistID) ? meta.artistID : 1001;
                                var memberIdx = (aId >= 1000) ? (aId % 1000) : aId;
                                cardItemObj.add(0x30).writeS32(gCode * 10000 + 1 * 100 + memberIdx); // sortCardIndex"""
    assert target_card_fields in content, "target_card_fields not found!"
    content = content.replace(target_card_fields, replacement_card_fields, 1)

    # In populateOfflineInventoryCards: populate all 21 GroupItems
    target_all_gi = """                        // Ensure GroupItem and DisplayGroupList
                        try {
                            var groupItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/GroupItem");
                            if (groupItemKlass && !groupItemKlass.isNull()) {
                                var groupItemObj = il2cpp_object_new(groupItemKlass);
                                groupItemObj.add(0x10).writePointer(loonaGroupData || NULL);
                                groupItemObj.add(0x18).writePointer(NULL);
                                groupItemObj.add(0x20).writePointer(NULL);
                                groupItemObj.add(0x28).writePointer(loonaCardListFastArray || NULL);
                                groupItemObj.add(0x30).writePointer(loonaEachThemeBestCardMap || NULL);
                                groupItemObj.add(0x38).writeS16(-1);
                                groupItemObj.add(0x40).writePointer(NULL);
                                groupItemObj.add(0x48).writeS16(-1);
                                groupItemObj.add(0x4A).writeS16(4);
                                groupItemObj.add(0x4C).writeS32(0);
                                groupItemObj.add(0x50).writeS32(1001);
                                groupItemObj.add(0x54).writeS32(1);
                                groupItemObj.add(0x58).writeS32(0);
                                groupItemObj.add(0x5C).writeS32(0);
                                loonaGroupItemObj = groupItemObj;
                                log("[🃏 INVENTORY] Created LOONA GroupItem(1001)! loonaGroupItemObj=" + loonaGroupItemObj);
                            }
                            ensureDisplayGroupList();
                        } catch (eGme) {
                            log("[-] Error verifying GroupMap: " + eGme.message);
                        }"""
    replacement_all_gi = """                        // Ensure GroupItem and DisplayGroupList for all 21 groups
                        try {
                            var groupItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/GroupItem");
                            if (groupItemKlass && !groupItemKlass.isNull()) {
                                var metaAll = getGlobalMetadata();
                                var playables = (metaAll && metaAll.playableGroups) ? metaAll.playableGroups : PLAYABLE_GROUP_CODES;
                                for (var pgi = 0; pgi < playables.length; pgi++) {
                                    var gCode = playables[pgi];
                                    var gMeta = (metaAll && metaAll.groups) ? metaAll.groups[gCode] : null;
                                    var slotCount = gMeta ? gMeta.equipableSlot : 11;
                                    var artistCodes = (gMeta && gMeta.artistCodes) ? gMeta.artistCodes : [];

                                    var gEquippedCards = [];
                                    for (var si = 0; si < slotCount; si++) {
                                        var targetArtist = (si < artistCodes.length) ? artistCodes[si] : null;
                                        var foundCard = null;
                                        for (var ci = 0; ci < loonaCardItems.length; ci++) {
                                            var itm = loonaCardItems[ci];
                                            var raw = itm.add(0x10).readPointer();
                                            var cid = raw.add(0x20).readS32();
                                            var isEq = (raw.add(0x28).readU8() === 1);
                                            var cMeta = getCardMetadata(cid);
                                            if (isEq && cMeta && cMeta.group === gCode && cMeta.artistID === targetArtist) {
                                                foundCard = itm;
                                                break;
                                            }
                                        }
                                        if (foundCard) gEquippedCards.push(foundCard);
                                    }

                                    var groupCardFastArray = createFastArray(gEquippedCards, 'card');
                                    if (il2cpp_gchandle_new && groupCardFastArray && !groupCardFastArray.isNull()) {
                                        il2cpp_gchandle_new(groupCardFastArray, 2);
                                    }

                                    var groupItemObj = il2cpp_object_new(groupItemKlass);
                                    if (il2cpp_gchandle_new && !groupItemObj.isNull()) {
                                        il2cpp_gchandle_new(groupItemObj, 2);
                                    }
                                    groupItemObj.add(0x10).writePointer(allGroupDataMap[gCode] || loonaGroupData || NULL);
                                    groupItemObj.add(0x18).writePointer(NULL);
                                    groupItemObj.add(0x20).writePointer(NULL);
                                    groupItemObj.add(0x28).writePointer(groupCardFastArray || NULL);
                                    groupItemObj.add(0x30).writePointer(NULL);
                                    groupItemObj.add(0x38).writeS16(-1);
                                    groupItemObj.add(0x40).writePointer(NULL);
                                    groupItemObj.add(0x48).writeS16(-1);
                                    groupItemObj.add(0x4A).writeS16(4);
                                    groupItemObj.add(0x4C).writeS32(0);
                                    groupItemObj.add(0x50).writeS32(gCode);
                                    groupItemObj.add(0x54).writeS32(1);
                                    groupItemObj.add(0x58).writeS32(0);
                                    groupItemObj.add(0x5C).writeS32(0);

                                    allInvenGroupItems[gCode] = groupItemObj;
                                    if (gCode === 1001) loonaGroupItemObj = groupItemObj;
                                }
                                log("[🃏 INVENTORY] Created GroupItems for all " + playables.length + " groups!");
                            }
                            ensureDisplayGroupList();
                        } catch (eGme) {
                            log("[-] Error verifying GroupMap: " + eGme.message);
                        }"""
    assert target_all_gi in content, "target_all_gi not found!"
    content = content.replace(target_all_gi, replacement_all_gi, 1)

    # 16. ensureCardBookControlData for all 21 groups and 99 themes (limited count = 0)
    target_cb_data = """                        // 3. Build ThemeList for LOONA (Hi High 1001 to Make you mine 1009)
                        var themeItems = [];
                        if (cbThemeItemKlass && !cbThemeItemKlass.isNull()) {
                            var themeCtorFn = new NativeFunction(baseAddr.add(0xB9766C), "void", ["pointer", "pointer", "int", "pointer"]);
                            var themeCodes = [1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009];
                            for (var t = 0; t < themeCodes.length; t++) {
                                var tCode = themeCodes[t];
                                var tData = getOrCreateThemeData(tCode);
                                var tItem = il2cpp_object_new(cbThemeItemKlass);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(tItem, 2);
                                themeCtorFn(tItem, tData, 11, NULL);
                                tItem.add(0x28).writeS32(2400); // themeGradePoint
                                tItem.add(0x2C).writeS32(11);   // Count
                                themeItems.push(tItem);
                            }
                        }

                        // Wrap ThemeList in managed list structure
                        var themeListManaged = createManagedList(themeItems, 'theme');
                        if (!themeListManaged || themeListManaged.isNull()) {
                            log("[⚠️ CARDBOOK] createManagedList('theme') returned NULL, using fallback");
                            themeListManaged = Memory.alloc(64);
                            var themeArr = il2cpp_array_new(cbThemeItemKlass, Math.max(themeItems.length + 4, 16));
                            if (il2cpp_gchandle_new) il2cpp_gchandle_new(themeArr, 2);
                            for (var ti = 0; ti < themeItems.length; ti++) {
                                themeArr.add(0x20 + ti * 8).writePointer(themeItems[ti]);
                            }
                            themeListManaged.add(0x10).writePointer(themeArr);
                            themeListManaged.add(0x18).writeS32(themeItems.length);
                        }

                        // 4. Instantiate CardBookControl.GroupItem for LOONA (1001)
                        var loonaCbGroupItem = il2cpp_object_new(cbGroupItemKlass);
                        if (il2cpp_gchandle_new) il2cpp_gchandle_new(loonaCbGroupItem, 2);
                        cachedLoonaCbGroupItem = loonaCbGroupItem;
                        loonaCbGroupItem.add(0x10).writePointer(loonaGroupData || NULL); // Group
                        loonaCbGroupItem.add(0x18).writePointer(NULL);                  // SubGroupList
                        loonaCbGroupItem.add(0x20).writePointer(NULL);                  // majorGroup
                        loonaCbGroupItem.add(0x28).writePointer(themeListManaged);      // ThemeList
                        loonaCbGroupItem.add(0x30).writePointer(NULL);                  // CardListByGroupCode
                        loonaCbGroupItem.add(0x38).writeS32(4);                         // grade = CardGrade.R (4)
                        loonaCbGroupItem.add(0x3C).writeS32(4);                         // GradeNext = CardGrade.R (4)
                        loonaCbGroupItem.add(0x40).writeS32(2400);                      // Point
                        loonaCbGroupItem.add(0x44).writeS32(2400);                      // NextPoint
                        loonaCbGroupItem.add(0x48).writeFloat(1.0);                     // Gauge
                        loonaCbGroupItem.add(0x4C).writeS32(50);                        // Level
                        loonaCbGroupItem.add(0x50).writeS32(24);                        // Count
                        loonaCbGroupItem.add(0x60).writeU8(0);                          // IsNew = false
                        loonaCbGroupItem.add(0x61).writeU8(0);                          // IsGradeup = false
                        loonaCbGroupItem.add(0x62).writeU8(1);                          // IsView = true
                        loonaCbGroupItem.add(0x63).writeU8(0);                          // IsUpdatedTheme = false
                        loonaCbGroupItem.add(0x68).writePointer(gradeInfo || NULL);     // MyCardBookGradeInfo

                        // 5. Wrap GroupList in managed list structure
                        var groupListManaged = createManagedList([loonaCbGroupItem], 'group');
                        if (!groupListManaged || groupListManaged.isNull()) {
                            log("[⚠️ CARDBOOK] createManagedList('group') returned NULL, using fallback");
                            groupListManaged = Memory.alloc(64);
                            var groupArr = il2cpp_array_new(cbGroupItemKlass, 8);
                            if (il2cpp_gchandle_new) il2cpp_gchandle_new(groupArr, 2);
                            groupArr.add(0x20).writePointer(loonaCbGroupItem);
                            groupListManaged.add(0x10).writePointer(groupArr);
                            groupListManaged.add(0x18).writeS32(1); // Count = 1
                        }

                        // 6. Populate CardBookControl.Info fields
                        info.add(0x10).writePointer(loonaCbGroupItem);   // BestCardBook
                        info.add(0x18).writePointer(groupListManaged);   // GroupList
                        info.add(0x20).writeS32(2400);                   // CardCollectTotalPoint
                        info.add(0x24).writeS32(2400);                   // CardCollectCurrentPoint
                        info.add(0x28).writePointer(NULL);               // Person = NULL (crucial for isMe = true)"""

    replacement_cb_data = """                        // 3. Build CardBookControl.GroupItem for all 21 groups with all 99 themes
                        var metaAll = getGlobalMetadata();
                        var playables = (metaAll && metaAll.playableGroups) ? metaAll.playableGroups : PLAYABLE_GROUP_CODES;
                        var themeCtorFn = new NativeFunction(baseAddr.add(0xB9766C), "void", ["pointer", "pointer", "int", "pointer"]);

                        allCbGroupItemMap = {};
                        allCbGroupItemList = [];
                        var totalCollectPoints = 0;

                        for (var pgi = 0; pgi < playables.length; pgi++) {
                            var gCode = playables[pgi];
                            var gMeta = (metaAll && metaAll.groups) ? metaAll.groups[gCode] : null;
                            var slotCount = gMeta ? gMeta.equipableSlot : 11;
                            var themeCodes = (gMeta && gMeta.themeCodes) ? gMeta.themeCodes : [];

                            var themeItems = [];
                            var groupObtainedCards = 0;
                            var groupPoints = 0;

                            for (var t = 0; t < themeCodes.length; t++) {
                                var tCode = themeCodes[t];
                                var tMeta = (metaAll && metaAll.themes) ? metaAll.themes[tCode] : null;
                                var isLimited = (tMeta && tMeta.limitedType !== 0);

                                var tData = getOrCreateThemeData(tCode);
                                var tItem = il2cpp_object_new(cbThemeItemKlass);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(tItem, 2);
                                themeCtorFn(tItem, tData, slotCount, NULL);

                                if (isLimited) {
                                    // USER CONSTRAINT: "evita las cartas limited como las que aparezcan que se van a tener como obtenidas en la cuenta"
                                    tItem.add(0x28).writeS32(0); // themeGradePoint = 0
                                    tItem.add(0x2C).writeS32(0); // Count = 0 (unobtained)
                                } else {
                                    tItem.add(0x28).writeS32(2400); // themeGradePoint = 2400
                                    tItem.add(0x2C).writeS32(slotCount); // Count = slotCount (obtained)
                                    groupObtainedCards += slotCount;
                                    groupPoints += 2400;
                                }
                                themeItems.push(tItem);
                            }

                            var themeListManaged = createManagedList(themeItems, 'theme');
                            if (!themeListManaged || themeListManaged.isNull()) {
                                themeListManaged = Memory.alloc(64);
                                var themeArr = il2cpp_array_new(cbThemeItemKlass, Math.max(themeItems.length + 4, 16));
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(themeArr, 2);
                                for (var ti = 0; ti < themeItems.length; ti++) {
                                    themeArr.add(0x20 + ti * 8).writePointer(themeItems[ti]);
                                }
                                themeListManaged.add(0x10).writePointer(themeArr);
                                themeListManaged.add(0x18).writeS32(themeItems.length);
                            }

                            var cbGroupGradeInfo = NULL;
                            if (cbGradeInfoKlass && !cbGradeInfoKlass.isNull()) {
                                cbGroupGradeInfo = il2cpp_object_new(cbGradeInfoKlass);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(cbGroupGradeInfo, 2);
                                cbGroupGradeInfo.add(0x10).writeS32(4);     // grade = CardGrade.R (4)
                                cbGroupGradeInfo.add(0x14).writeS32(50);    // currentLevel = 50
                                cbGroupGradeInfo.add(0x18).writeS32(50);    // maxLevel = 50
                                cbGroupGradeInfo.add(0x1C).writeS32(groupPoints);  // currentPoint
                                cbGroupGradeInfo.add(0x20).writeS32(groupPoints);  // nextPoint
                                cbGroupGradeInfo.add(0x24).writeS32(groupObtainedCards); // cardCount
                                cbGroupGradeInfo.add(0x28).writeU8(1);      // isMaxLevel = true
                            }

                            var cbGroupItem = il2cpp_object_new(cbGroupItemKlass);
                            if (il2cpp_gchandle_new) il2cpp_gchandle_new(cbGroupItem, 2);
                            var gData = allGroupDataMap[gCode] || loonaGroupData || NULL;
                            cbGroupItem.add(0x10).writePointer(gData);
                            cbGroupItem.add(0x18).writePointer(NULL);
                            cbGroupItem.add(0x20).writePointer(NULL);
                            cbGroupItem.add(0x28).writePointer(themeListManaged);
                            cbGroupItem.add(0x30).writePointer(NULL);
                            cbGroupItem.add(0x38).writeS32(4);
                            cbGroupItem.add(0x3C).writeS32(4);
                            cbGroupItem.add(0x40).writeS32(groupPoints);
                            cbGroupItem.add(0x44).writeS32(groupPoints);
                            cbGroupItem.add(0x48).writeFloat(1.0);
                            cbGroupItem.add(0x4C).writeS32(50);
                            cbGroupItem.add(0x50).writeS32(groupObtainedCards);
                            cbGroupItem.add(0x60).writeU8(0);
                            cbGroupItem.add(0x61).writeU8(0);
                            cbGroupItem.add(0x62).writeU8(1);
                            cbGroupItem.add(0x63).writeU8(0);
                            cbGroupItem.add(0x68).writePointer(cbGroupGradeInfo || NULL);

                            allCbGroupItemMap[gCode] = cbGroupItem;
                            allCbGroupItemList.push(cbGroupItem);
                            totalCollectPoints += groupPoints;

                            if (gCode === 1001) {
                                cachedLoonaCbGroupItem = cbGroupItem;
                            }
                        }

                        // 5. Wrap GroupList in managed list structure
                        var groupListManaged = createManagedList(allCbGroupItemList, 'group');
                        if (!groupListManaged || groupListManaged.isNull()) {
                            log("[⚠️ CARDBOOK] createManagedList('group') returned NULL, using fallback");
                            groupListManaged = Memory.alloc(64);
                            var groupArr = il2cpp_array_new(cbGroupItemKlass, allCbGroupItemList.length + 8);
                            if (il2cpp_gchandle_new) il2cpp_gchandle_new(groupArr, 2);
                            for (var gi = 0; gi < allCbGroupItemList.length; gi++) {
                                groupArr.add(0x20 + gi * 8).writePointer(allCbGroupItemList[gi]);
                            }
                            groupListManaged.add(0x10).writePointer(groupArr);
                            groupListManaged.add(0x18).writeS32(allCbGroupItemList.length);
                        }

                        // 6. Populate CardBookControl.Info fields
                        info.add(0x10).writePointer(cachedLoonaCbGroupItem || allCbGroupItemList[0]);
                        info.add(0x18).writePointer(groupListManaged);
                        info.add(0x20).writeS32(totalCollectPoints);
                        info.add(0x24).writeS32(totalCollectPoints);
                        info.add(0x28).writePointer(NULL);"""
    assert target_cb_data in content, "target_cb_data not found!"
    content = content.replace(target_cb_data, replacement_cb_data, 1)

    with open(path, "w", encoding="utf-8") as f:
        f.write(content)

    print("Successfully patched libscript.js!")

if __name__ == "__main__":
    main()
