import sys

with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Update createFastArray to support 'livetheme_card'
target1 = """                        } else if (type === 'cardbook_card') {
                            klassSlotRva = 0x31E1810;  // Ext.Collection.AntiGC.FastArray<CardBookControl.CardItem>_TypeInfo
                            methodSlotRva = 0x3203628; // Method$Ext.Collection.AntiGC.FastArray<CardBookControl.CardItem>..ctor()
                        } else {"""

replacement1 = """                        } else if (type === 'cardbook_card') {
                            klassSlotRva = 0x31E1810;  // Ext.Collection.AntiGC.FastArray<CardBookControl.CardItem>_TypeInfo
                            methodSlotRva = 0x3203628; // Method$Ext.Collection.AntiGC.FastArray<CardBookControl.CardItem>..ctor()
                        } else if (type === 'livetheme_card') {
                            klassSlotRva = 0x31DD5D8;  // Ext.Collection.AntiGC.FastArray<LiveThemeControl.ThemeCardItem>_TypeInfo
                            methodSlotRva = 0x320F3B8; // Method$Ext.Collection.AntiGC.FastArray<LiveThemeControl.ThemeCardItem>..ctor()
                        } else {"""

if target1 not in content:
    print("[-] target1 not found in libscript.js!")
    sys.exit(1)
content = content.replace(target1, replacement1, 1)
print("[+] Applied FastArray livetheme_card patch")

# 2. Update createManagedList to support 'livetheme_item'
target2 = """                        } else if (type === 'download_path') {
                            klassSlotRva = 0x31E3878;  // System.Collections.Generic.List<WWWFile.DownloadPath>_TypeInfo
                            ctorSlotRva = 0x320BDD8;   // Method$System.Collections.Generic.List<WWWFile.DownloadPath>..ctor()
                            addSlotRva = 0x320BDE8;    // Method$System.Collections.Generic.List<WWWFile.DownloadPath>.Add()
                        }"""

replacement2 = """                        } else if (type === 'download_path') {
                            klassSlotRva = 0x31E3878;  // System.Collections.Generic.List<WWWFile.DownloadPath>_TypeInfo
                            ctorSlotRva = 0x320BDD8;   // Method$System.Collections.Generic.List<WWWFile.DownloadPath>..ctor()
                            addSlotRva = 0x320BDE8;    // Method$System.Collections.Generic.List<WWWFile.DownloadPath>.Add()
                        } else if (type === 'livetheme_item') {
                            klassSlotRva = 0x31FBB38;  // System.Collections.Generic.List<LiveThemeControl.LiveThemeItem>_TypeInfo
                            ctorSlotRva = 0x31F0BD8;   // Method$System.Collections.Generic.List<LiveThemeControl.LiveThemeItem>..ctor()
                            addSlotRva = 0x31FD758;    // Method$System.Collections.Generic.List<LiveThemeControl.LiveThemeItem>.Add()
                        }"""

if target2 not in content:
    print("[-] target2 not found in libscript.js!")
    sys.exit(1)
content = content.replace(target2, replacement2, 1)
print("[+] Applied ManagedList livetheme_item patch")

# 3. Replace the LiveThemeControl ensureLiveThemeData block with full authentic offline pipeline
target3 = """                var isLiveThemeDataInitialized = false;
                function ensureLiveThemeData() {
                    if (isLiveThemeDataInitialized) return true;
                    try {
                        // 1. LiveThemeDataControl.Open (0xB37F60)
                        try {
                            var ltDataOpenFn = new NativeFunction(baseAddr.add(0xB37F60), "void", []);
                            ltDataOpenFn();
                            log("[🎨 LIVE THEME] LiveThemeDataControl.Open() ok");
                        } catch (eLtd) {
                            log("[-] Error calling LiveThemeDataControl.Open: " + eLtd.message);
                        }

                        // 2. LiveThemeCardDataControl.Open (0xC328B8)
                        try {
                            var ltCardDataOpenFn = new NativeFunction(baseAddr.add(0xC328B8), "void", []);
                            ltCardDataOpenFn();
                            log("[🎨 LIVE THEME] LiveThemeCardDataControl.Open() ok");
                        } catch (eLtcd) {
                            log("[-] Error calling LiveThemeCardDataControl.Open: " + eLtcd.message);
                        }

                        // 3. LiveThemeControl.Open (0xB33C24)
                        try {
                            var openFn = new NativeFunction(baseAddr.add(0xB33C24), "void", []);
                            openFn();
                            log("[🎨 LIVE THEME] LiveThemeControl.Open() executed successfully!");

                            // Force IsLiveThemeOpen = true and IsOpened = true
                            try {
                                var ltCtrlKlassHandle = baseAddr.add(0x30FD5E8).readPointer();
                                if (!ltCtrlKlassHandle.isNull()) {
                                    var ltCtrlKlass = ltCtrlKlassHandle.readPointer();
                                    if (!ltCtrlKlass.isNull()) {
                                        var staticFields = ltCtrlKlass.add(0xB8).readPointer();
                                        if (!staticFields.isNull()) {
                                            staticFields.add(0x0).writeU8(1); // IsLiveThemeOpen = true
                                            staticFields.add(0x1).writeU8(1); // IsOpened = true
                                            log("[🎨 LIVE THEME] Forced IsLiveThemeOpen=1, IsOpened=1 in static fields");
                                        }
                                    }
                                }
                            } catch (eSf) {
                                log("[-] Error updating static fields: " + eSf.message);
                            }

                            // Update display list (isAll = true, groupID = -1)
                            try {
                                var updateDisplayFn = new NativeFunction(baseAddr.add(0xB36F88), "void", ["bool", "int", "pointer"]);
                                updateDisplayFn(1, -1, NULL);
                                log("[🎨 LIVE THEME] UpdateDisplayLiveThemeList(true, -1) executed successfully!");
                            } catch (eUdl) {}
                        } catch (eLtc) {
                            log("[-] Error calling LiveThemeControl.Open: " + eLtc.message);
                        }

                        isLiveThemeDataInitialized = true;
                        log("[🎨 LIVE THEME] LiveTheme offline subsystem fully initialized!");
                        return true;
                    } catch (e) {
                        log("[-] Error in ensureLiveThemeData: " + e.message);
                        return false;
                    }
                }"""

replacement3 = """                var isLiveThemeDataInitialized = false;
                var loonaLiveThemeItem = NULL;
                var loonaLiveThemeListManaged = NULL;
                var loonaThemeCardItems = [];
                var loonaThemeCardMap = {};

                function buildOfflineLiveThemeData() {
                    if (loonaLiveThemeItem && !loonaLiveThemeItem.isNull()) return true;
                    try {
                        ensureLoonaMocks();
                        log("[🎨 LIVE THEME] Building authentic offline LiveTheme data structures...");

                        var initClassFn = new NativeFunction(baseAddr.add(0xA43BE8), "void", ["pointer"]);

                        // 1. LiveThemeData model
                        var ltdKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "LiveThemeData");
                        if (!ltdKlass || ltdKlass.isNull()) {
                            log("[-] Could not find LiveThemeData class");
                            return false;
                        }
                        try { initClassFn(ltdKlass); } catch (eLtdK) {}
                        var ltdObj = il2cpp_object_new(ltdKlass);
                        if (il2cpp_gchandle_new && !ltdObj.isNull()) il2cpp_gchandle_new(ltdObj, 2);
                        ltdObj.add(0x10).writeS16(0); // code = 0
                        ltdObj.add(0x14).writeS32(181418001); // localeName
                        ltdObj.add(0x18).writeS32(181419001); // saleLocaleName
                        ltdObj.add(0x1C).writeS16(0); // orderIndex = 0
                        ltdObj.add(0x20).writeS32(1001); // groupID = 1001 (LOONA)
                        ltdObj.add(0x28).writePointer(createIl2CppString("0xB8FFF12C")); // auraColor

                        // 2. LiveThemeDataControl.Data
                        var ltdcDataKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeDataControl/Data");
                        if (!ltdcDataKlass || ltdcDataKlass.isNull()) {
                            log("[-] Could not find LiveThemeDataControl/Data class");
                            return false;
                        }
                        try { initClassFn(ltdcDataKlass); } catch (eLtdcK) {}
                        var ltdcDataObj = il2cpp_object_new(ltdcDataKlass);
                        if (il2cpp_gchandle_new && !ltdcDataObj.isNull()) il2cpp_gchandle_new(ltdcDataObj, 2);
                        var gData = allGroupDataMap[1001] || loonaGroupData || NULL;
                        ltdcDataObj.add(0x10).writePointer(ltdObj);
                        ltdcDataObj.add(0x18).writePointer(gData);
                        ltdcDataObj.add(0x20).writePointer(NULL);

                        // 3. Classes for Cards
                        var ltCardDataKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "LiveThemeCardData");
                        var ltCardDataControlKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeCardDataControl/Data");
                        var ltCardKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.account", "LiveThemeCard");
                        var themeCardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeControl/ThemeCardItem");

                        if (ltCardDataKlass && !ltCardDataKlass.isNull()) { try { initClassFn(ltCardDataKlass); } catch (e1) {} }
                        if (ltCardDataControlKlass && !ltCardDataControlKlass.isNull()) { try { initClassFn(ltCardDataControlKlass); } catch (e2) {} }
                        if (ltCardKlass && !ltCardKlass.isNull()) { try { initClassFn(ltCardKlass); } catch (e3) {} }
                        if (themeCardItemKlass && !themeCardItemKlass.isNull()) { try { initClassFn(themeCardItemKlass); } catch (e4) {} }

                        loonaThemeCardItems = [];
                        loonaThemeCardMap = {};

                        for (var i = 0; i < 11; i++) {
                            var artistId = 1001 + i;
                            var artistObj = allArtistDataMap[artistId] || loonaArtistDataMap[i + 1] || NULL;

                            // 3a. LiveThemeCardData (model)
                            var cDataObj = il2cpp_object_new(ltCardDataKlass);
                            if (il2cpp_gchandle_new && !cDataObj.isNull()) il2cpp_gchandle_new(cDataObj, 2);
                            cDataObj.add(0x10).writeS16(i); // code
                            cDataObj.add(0x12).writeS16(0); // liveThemeID = 0
                            cDataObj.add(0x14).writeS32(artistId); // artistID
                            cDataObj.add(0x18).writePointer(NULL); // emptyImageSmall
                            cDataObj.add(0x20).writePointer(NULL); // emptyImageLarge
                            var sCardRel = "asiudgasg/asodhsg/wadceg/1001" + i + "_s.i.bytes";
                            var lCardRel = "asiudgasg/asodhsg/wadceg/1001" + i + "_l.i.bytes";
                            cDataObj.add(0x28).writePointer(createIl2CppString(sCardRel));
                            cDataObj.add(0x30).writePointer(createIl2CppString(lCardRel));
                            cDataObj.add(0x38).writePointer(NULL);
                            cDataObj.add(0x40).writePointer(NULL);
                            cDataObj.add(0x48).writePointer(NULL);
                            cDataObj.add(0x50).writePointer(NULL);
                            cDataObj.add(0x60).writePointer(createIl2CppString("Fresher LOONA " + (i + 1)));

                            // 3b. LiveThemeCardDataControl.Data
                            var cdcObj = il2cpp_object_new(ltCardDataControlKlass);
                            if (il2cpp_gchandle_new && !cdcObj.isNull()) il2cpp_gchandle_new(cdcObj, 2);
                            cdcObj.add(0x10).writePointer(cDataObj);
                            cdcObj.add(0x18).writePointer(ltdcDataObj);
                            cdcObj.add(0x20).writePointer(artistObj);
                            cdcObj.add(0x28).writePointer(createDownloadPath(sCardRel)); // emptyImageSmall
                            cdcObj.add(0x30).writePointer(createDownloadPath(lCardRel)); // emptyImageLarge
                            cdcObj.add(0x38).writePointer(createDownloadPath(sCardRel)); // liveThemeImageSmall
                            cdcObj.add(0x40).writePointer(createDownloadPath(lCardRel)); // liveThemeImageLarge
                            cdcObj.add(0x48).writePointer(createDownloadPath(lCardRel)); // removeBGImageLarge
                            cdcObj.add(0x50).writePointer(NULL);
                            cdcObj.add(0x58).writePointer(NULL);
                            cdcObj.add(0x60).writePointer(NULL);

                            // 3c. LiveThemeCard (account)
                            var cardAcc = il2cpp_object_new(ltCardKlass);
                            if (il2cpp_gchandle_new && !cardAcc.isNull()) il2cpp_gchandle_new(cardAcc, 2);
                            cardAcc.add(0x10).writeS64(90000000 + i); // objectID
                            cardAcc.add(0x18).writeS16(i); // cardID
                            cardAcc.add(0x1A).writeU8(1); // isEquip = true
                            cardAcc.add(0x1B).writeU8(1); // isBackground = true
                            cardAcc.add(0x1C).writeS16(1); // soundState value
                            cardAcc.add(0x1E).writeU8(1);  // soundState hasValue = true
                            cardAcc.add(0x20).writeS16(1); // videoState value
                            cardAcc.add(0x22).writeU8(1);  // videoState hasValue = true

                            // 3d. LiveThemeControl.ThemeCardItem
                            var tciObj = il2cpp_object_new(themeCardItemKlass);
                            if (il2cpp_gchandle_new && !tciObj.isNull()) il2cpp_gchandle_new(tciObj, 2);
                            tciObj.add(0x10).writePointer(cardAcc);
                            tciObj.add(0x18).writePointer(cdcObj);
                            tciObj.add(0x20).writeU8(0); // isNew = false
                            tciObj.add(0x21).writeU8(1); // isHave = true
                            tciObj.add(0x24).writeS32(1); // soundState = 1
                            tciObj.add(0x28).writeS32(1); // videoState = 1

                            loonaThemeCardItems.push(tciObj);
                            loonaThemeCardMap[i] = tciObj;
                        }

                        // 4. FastArray of ThemeCardItem
                        var tciFastArray = createFastArray(loonaThemeCardItems, 'livetheme_card');
                        if (il2cpp_gchandle_new && tciFastArray && !tciFastArray.isNull()) {
                            il2cpp_gchandle_new(tciFastArray, 2);
                        }

                        // 5. LiveThemeControl.LiveThemeItem
                        var ltItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeControl/LiveThemeItem");
                        if (!ltItemKlass || ltItemKlass.isNull()) {
                            log("[-] Could not find LiveThemeItem class");
                            return false;
                        }
                        try { initClassFn(ltItemKlass); } catch (eLtIK) {}
                        loonaLiveThemeItem = il2cpp_object_new(ltItemKlass);
                        if (il2cpp_gchandle_new && !loonaLiveThemeItem.isNull()) il2cpp_gchandle_new(loonaLiveThemeItem, 2);
                        loonaLiveThemeItem.add(0x10).writePointer(ltdcDataObj);
                        loonaLiveThemeItem.add(0x18).writePointer(gData);
                        loonaLiveThemeItem.add(0x20).writePointer(NULL);
                        loonaLiveThemeItem.add(0x28).writePointer(NULL);
                        loonaLiveThemeItem.add(0x30).writePointer(tciFastArray);

                        // 6. Managed List of LiveThemeItem
                        loonaLiveThemeListManaged = createManagedList([loonaLiveThemeItem], 'livetheme_item');
                        if (il2cpp_gchandle_new && loonaLiveThemeListManaged && !loonaLiveThemeListManaged.isNull()) {
                            il2cpp_gchandle_new(loonaLiveThemeListManaged, 2);
                        }

                        // 7. Static fields of LiveThemeControl
                        var ltCtrlKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeControl");
                        if (ltCtrlKlass && !ltCtrlKlass.isNull()) {
                            try { initClassFn(ltCtrlKlass); } catch (eLtcK) {}
                            var sf = ltCtrlKlass.add(0xB8).readPointer();
                            if (!sf.isNull()) {
                                sf.add(0x0).writeU8(1);  // IsLiveThemeOpen = true
                                sf.add(0x1).writeU8(1);  // IsOpened = true
                                sf.add(0x2).writeU8(0);  // IsNew = false
                                sf.add(0x18).writePointer(loonaLiveThemeListManaged); // AllLiveThemeList
                                sf.add(0x28).writePointer(loonaLiveThemeListManaged); // DisplayLiveThemeList
                                sf.add(0x40).writeS16(0); // selectedLiveThemeCardCode = 0
                                sf.add(0x42).writeS16(0); // selectedLiveThemeIndex = 0
                                sf.add(0x44).writeS16(0); // liveThemeLeaderCode = 0
                                log("[🎨 LIVE THEME] Static fields of LiveThemeControl successfully populated!");
                            }
                        }

                        log("[🎨 LIVE THEME] Authentic offline LiveTheme data built with success! (1 theme, 11 cards)");
                        return true;
                    } catch (eBuild) {
                        log("[-] Error in buildOfflineLiveThemeData: " + eBuild.message);
                        return false;
                    }
                }

                function ensureLiveThemeData() {
                    if (isLiveThemeDataInitialized) return true;
                    try {
                        buildOfflineLiveThemeData();
                        isLiveThemeDataInitialized = true;
                        log("[🎨 LIVE THEME] LiveTheme offline subsystem fully initialized!");
                        return true;
                    } catch (e) {
                        log("[-] Error in ensureLiveThemeData: " + e.message);
                        return false;
                    }
                }

                // Interceptors for LiveThemeControl and LiveThemeDataControl
                try {
                    // 1. LiveThemeControl.Open (0xB33C24) -> offline data builder
                    Interceptor.replace(baseAddr.add(0xB33C24), new NativeCallback(function (methodInfo) {
                        log("[🎨 LIVE THEME] LiveThemeControl.Open called -> running buildOfflineLiveThemeData");
                        buildOfflineLiveThemeData();
                    }, "void", ["pointer"]));

                    // 2. LiveThemeControl.UpdateDisplayLiveThemeList (0xB36F88)
                    Interceptor.replace(baseAddr.add(0xB36F88), new NativeCallback(function (isAll, groupID, methodInfo) {
                        log("[🎨 LIVE THEME] LiveThemeControl.UpdateDisplayLiveThemeList called (isAll=" + isAll + ", groupID=" + groupID + ")");
                        buildOfflineLiveThemeData();
                        var ltCtrlKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeControl");
                        if (ltCtrlKlass && !ltCtrlKlass.isNull()) {
                            var sf = ltCtrlKlass.add(0xB8).readPointer();
                            if (!sf.isNull() && loonaLiveThemeListManaged && !loonaLiveThemeListManaged.isNull()) {
                                sf.add(0x28).writePointer(loonaLiveThemeListManaged);
                            }
                        }
                    }, "void", ["bool", "int", "pointer"]));

                    // 3. LiveThemeControl.FindToLiveThemeItem (0xB34C68)
                    Interceptor.replace(baseAddr.add(0xB34C68), new NativeCallback(function (code, methodInfo) {
                        buildOfflineLiveThemeData();
                        log("[🎨 LIVE THEME] FindToLiveThemeItem called (code=" + code + ") -> returning loonaLiveThemeItem");
                        return loonaLiveThemeItem || NULL;
                    }, "pointer", ["short", "pointer"]));

                    // 4. LiveThemeControl.FindToThemeCardItem (0xB34DB0)
                    Interceptor.replace(baseAddr.add(0xB34DB0), new NativeCallback(function (code, methodInfo) {
                        buildOfflineLiveThemeData();
                        log("[🎨 LIVE THEME] FindToThemeCardItem called (code=" + code + ")");
                        if (loonaThemeCardMap[code]) return loonaThemeCardMap[code];
                        return (loonaThemeCardItems && loonaThemeCardItems[0]) ? loonaThemeCardItems[0] : NULL;
                    }, "pointer", ["short", "pointer"]));

                    // 5. LiveThemeDataControl.Data.get_LocaleName (0xE7204C) & get_SaleLocaleName (0xE720C0)
                    Interceptor.replace(baseAddr.add(0xE7204C), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("Fresher Edition");
                    }, "pointer", ["pointer", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xE720C0), new NativeCallback(function (thisPtr, methodInfo) {
                        return createIl2CppString("Fresher Edition");
                    }, "pointer", ["pointer", "pointer"]));

                    log("[+] Interceptor.replace installed on LiveThemeControl methods & locale getters!");
                } catch (eLtcHooks) {
                    log("[-] Error installing LiveThemeControl method hooks: " + eLtcHooks.message);
                }"""

if target3 not in content:
    print("[-] target3 not found in libscript.js!")
    sys.exit(1)
content = content.replace(target3, replacement3, 1)
print("[+] Applied LiveThemeControl full offline pipeline patch")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(content)

with open('app/src/main/lib/arm64-v8a/libscript.so', 'w', encoding='utf-8') as f:
    f.write(content)

print("[SUCCESS] Successfully updated libscript.js and libscript.so!")
