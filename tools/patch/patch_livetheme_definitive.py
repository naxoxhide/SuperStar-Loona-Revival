with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    content = f.read()

# Replace Step 4 through Step 6 with clean sampleFaKlass & sampleListKlass
old_block = """                        log("[🔍 STEP 4] FastArray of ThemeCardItem...");
                        // 4. Authentic FastArray of ThemeCardItem (Memory.alloc direct zero-crash layout)
                        var pool = il2cpp_array_new(themeCardItemKlass, 11);
                        if (il2cpp_gchandle_new && !pool.isNull()) il2cpp_gchandle_new(pool, 2);
                        for (var ti = 0; ti < loonaThemeCardItems.length; ti++) {
                            pool.add(0x20 + ti * 8).writePointer(loonaThemeCardItems[ti] || NULL);
                        }
                        var tciFastArray = Memory.alloc(64);
                        var sampleFaKlass = (loonaArtistFastArray && !loonaArtistFastArray.isNull()) ? loonaArtistFastArray.readPointer() : themeCardItemKlass;
                        tciFastArray.writePointer(sampleFaKlass);
                        tciFastArray.add(0x8).writePointer(NULL);
                        tciFastArray.add(0x10).writePointer(pool);
                        tciFastArray.add(0x18).writeS32(11); // capacity
                        tciFastArray.add(0x1C).writeS32(11); // length
                        log("[✅ FAST_ARRAY] Direct zero-crash FastArray<ThemeCardItem> allocated at: " + tciFastArray + " (len: 11)");

                        log("[🔍 STEP 5] LiveThemeControl.LiveThemeItem...");
                        // 5. LiveThemeControl.LiveThemeItem
                        var ltItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeControl/LiveThemeItem");
                        if (!ltItemKlass || ltItemKlass.isNull()) {
                            log("[-] Could not find LiveThemeItem class");
                            return false;
                        }
                        loonaLiveThemeItem = il2cpp_object_new(ltItemKlass);
                        if (il2cpp_gchandle_new && !loonaLiveThemeItem.isNull()) il2cpp_gchandle_new(loonaLiveThemeItem, 2);
                        loonaLiveThemeItem.add(0x10).writePointer(ltdcDataObj);
                        loonaLiveThemeItem.add(0x18).writePointer(gData);
                        loonaLiveThemeItem.add(0x20).writePointer(NULL);
                        loonaLiveThemeItem.add(0x28).writePointer(NULL);
                        loonaLiveThemeItem.add(0x30).writePointer(tciFastArray);

                        log("[🔍 STEP 6] Managed List of LiveThemeItem...");
                        // 6. Authentic Managed List of LiveThemeItem (Memory.alloc direct zero-crash layout)
                        var itemsArr = il2cpp_array_new(ltItemKlass, 4);
                        if (il2cpp_gchandle_new && !itemsArr.isNull()) il2cpp_gchandle_new(itemsArr, 2);
                        itemsArr.add(0x20).writePointer(loonaLiveThemeItem);

                        loonaLiveThemeListManaged = Memory.alloc(64);
                        var sampleListKlass = (loonaGroupListManaged && !loonaGroupListManaged.isNull()) ? loonaGroupListManaged.readPointer() : ltItemKlass;
                        loonaLiveThemeListManaged.writePointer(sampleListKlass);
                        loonaLiveThemeListManaged.add(0x8).writePointer(NULL);
                        loonaLiveThemeListManaged.add(0x10).writePointer(itemsArr);
                        loonaLiveThemeListManaged.add(0x18).writeS32(1); // _size = 1
                        loonaLiveThemeListManaged.add(0x1C).writeS32(1); // _version = 1
                        loonaLiveThemeListManaged.add(0x20).writePointer(NULL);
                        log("[✅ MANAGED_LIST] Direct zero-crash List<LiveThemeItem> allocated at: " + loonaLiveThemeListManaged + " (len: 1)");"""

new_block = """                        log("[🔍 STEP 4] FastArray of ThemeCardItem...");
                        // 4. Authentic FastArray of ThemeCardItem (Memory.alloc direct zero-crash layout)
                        var pool = il2cpp_array_new(themeCardItemKlass, 11);
                        if (il2cpp_gchandle_new && !pool.isNull()) il2cpp_gchandle_new(pool, 2);
                        for (var ti = 0; ti < loonaThemeCardItems.length; ti++) {
                            pool.add(0x20 + ti * 8).writePointer(loonaThemeCardItems[ti] || NULL);
                        }
                        var tciFastArray = Memory.alloc(64);
                        var sampleFaKlass = (loonaGroupData && !loonaGroupData.isNull() && !loonaGroupData.add(0x30).readPointer().isNull()) ? loonaGroupData.add(0x30).readPointer().readPointer() : resolveMetadataSlot(0x31E1800);
                        tciFastArray.writePointer(sampleFaKlass);
                        tciFastArray.add(0x8).writePointer(NULL);
                        tciFastArray.add(0x10).writePointer(pool);
                        tciFastArray.add(0x18).writeS32(11); // capacity
                        tciFastArray.add(0x1C).writeS32(11); // length
                        log("[✅ FAST_ARRAY] Direct zero-crash FastArray<ThemeCardItem> allocated at: " + tciFastArray + " (len: 11)");

                        log("[🔍 STEP 5] LiveThemeControl.LiveThemeItem...");
                        // 5. LiveThemeControl.LiveThemeItem
                        var ltItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "LiveThemeControl/LiveThemeItem");
                        if (!ltItemKlass || ltItemKlass.isNull()) {
                            log("[-] Could not find LiveThemeItem class");
                            return false;
                        }
                        loonaLiveThemeItem = il2cpp_object_new(ltItemKlass);
                        if (il2cpp_gchandle_new && !loonaLiveThemeItem.isNull()) il2cpp_gchandle_new(loonaLiveThemeItem, 2);
                        loonaLiveThemeItem.add(0x10).writePointer(ltdcDataObj);
                        loonaLiveThemeItem.add(0x18).writePointer(gData);
                        loonaLiveThemeItem.add(0x20).writePointer(NULL);
                        loonaLiveThemeItem.add(0x28).writePointer(NULL);
                        loonaLiveThemeItem.add(0x30).writePointer(tciFastArray);

                        log("[🔍 STEP 6] Managed List of LiveThemeItem...");
                        // 6. Authentic Managed List of LiveThemeItem (Memory.alloc direct zero-crash layout)
                        var itemsArr = il2cpp_array_new(ltItemKlass, 4);
                        if (il2cpp_gchandle_new && !itemsArr.isNull()) il2cpp_gchandle_new(itemsArr, 2);
                        itemsArr.add(0x20).writePointer(loonaLiveThemeItem);

                        loonaLiveThemeListManaged = Memory.alloc(64);
                        var sampleListKlass = resolveMetadataSlot(0x31E3878);
                        loonaLiveThemeListManaged.writePointer(sampleListKlass);
                        loonaLiveThemeListManaged.add(0x8).writePointer(NULL);
                        loonaLiveThemeListManaged.add(0x10).writePointer(itemsArr);
                        loonaLiveThemeListManaged.add(0x18).writeS32(1); // _size = 1
                        loonaLiveThemeListManaged.add(0x1C).writeS32(1); // _version = 1
                        loonaLiveThemeListManaged.add(0x20).writePointer(NULL);
                        log("[✅ MANAGED_LIST] Direct zero-crash List<LiveThemeItem> allocated at: " + loonaLiveThemeListManaged + " (len: 1)");"""

if old_block not in content:
    print("[-] old_block not found in libscript.js!")
    exit(1)

content = content.replace(old_block, new_block, 1)

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(content)

with open('app/src/main/lib/arm64-v8a/libscript.so', 'w', encoding='utf-8') as f:
    f.write(content)

print("[SUCCESS] Applied updated patch!")
