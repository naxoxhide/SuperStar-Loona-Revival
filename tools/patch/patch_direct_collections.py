with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    content = f.read()

# Replace the FastArray and ManagedList creation inside buildOfflineLiveThemeData with direct authentic allocation
target = """                        // 4. FastArray of ThemeCardItem
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
                        }"""

replacement = """                        // 4. Authentic FastArray of ThemeCardItem (zero-crash direct layout)
                        var faKlass = resolveMetadataSlot(0x31DD5D8);
                        var tciFastArray = NULL;
                        if (faKlass && !faKlass.isNull()) {
                            tciFastArray = il2cpp_object_new(faKlass);
                            if (il2cpp_gchandle_new && !tciFastArray.isNull()) il2cpp_gchandle_new(tciFastArray, 2);
                            var pool = il2cpp_array_new(themeCardItemKlass, 11);
                            if (il2cpp_gchandle_new && !pool.isNull()) il2cpp_gchandle_new(pool, 2);
                            for (var ti = 0; ti < loonaThemeCardItems.length; ti++) {
                                pool.add(0x20 + ti * 8).writePointer(loonaThemeCardItems[ti] || NULL);
                            }
                            tciFastArray.add(0x10).writePointer(pool);
                            tciFastArray.add(0x18).writeS32(11); // capacity
                            tciFastArray.add(0x1C).writeS32(11); // length
                            log("[✅ FAST_ARRAY] Direct authentic FastArray<ThemeCardItem> allocated at: " + tciFastArray + " (len: 11)");
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

                        // 6. Authentic Managed List of LiveThemeItem (zero-crash direct layout)
                        var listKlass = resolveMetadataSlot(0x31FBB38);
                        if (listKlass && !listKlass.isNull()) {
                            loonaLiveThemeListManaged = il2cpp_object_new(listKlass);
                            if (il2cpp_gchandle_new && !loonaLiveThemeListManaged.isNull()) il2cpp_gchandle_new(loonaLiveThemeListManaged, 2);
                            var itemsArr = il2cpp_array_new(ltItemKlass, 4);
                            if (il2cpp_gchandle_new && !itemsArr.isNull()) il2cpp_gchandle_new(itemsArr, 2);
                            itemsArr.add(0x20).writePointer(loonaLiveThemeItem);
                            loonaLiveThemeListManaged.add(0x10).writePointer(itemsArr);
                            loonaLiveThemeListManaged.add(0x18).writeS32(1); // _size = 1
                            loonaLiveThemeListManaged.add(0x1C).writeS32(1); // _version = 1
                            log("[✅ MANAGED_LIST] Direct authentic List<LiveThemeItem> allocated at: " + loonaLiveThemeListManaged + " (len: 1)");
                        }"""

if target not in content:
    print("[-] target block not found in libscript.js!")
    exit(1)

content = content.replace(target, replacement, 1)

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(content)

with open('app/src/main/lib/arm64-v8a/libscript.so', 'w', encoding='utf-8') as f:
    f.write(content)

print("[+] Successfully updated libscript.js and libscript.so with direct authentic collection allocators!")
