with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    js = f.read()

# 1. Fix ensureListBuffer (remove reading 0x31F3060 token)
old_buf_klass = '''                            if (!cachedCardItemKlass || cachedCardItemKlass.isNull()) {
                                var itemSlot = baseAddr.add(0x31F3060).readPointer();
                                if (!itemSlot.isNull()) cachedCardItemKlass = itemSlot;
                                if (!cachedCardItemKlass || cachedCardItemKlass.isNull()) {
                                    cachedCardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");
                                }
                            }'''

new_buf_klass = '''                            if (!cachedCardItemKlass || cachedCardItemKlass.isNull()) {
                                cachedCardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");
                            }'''

if old_buf_klass in js:
    js = js.replace(old_buf_klass, new_buf_klass, 1)
    print("1. Successfully updated ensureListBuffer!")
else:
    print("FAIL 1: old_buf_klass not found")

# 2. Fix populateOfflineInventoryCards (remove reading 0x31F3060 token)
old_pop_klass = '''                        var cardItemKlass = NULL;
                        try {
                            var itemSlot = baseAddr.add(0x31F3060).readPointer();
                            if (!itemSlot.isNull()) cardItemKlass = itemSlot;
                        } catch (e2) {}
                        if (!cardItemKlass || cardItemKlass.isNull()) {
                            cardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");
                        }'''

new_pop_klass = '''                        var cardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");'''

if old_pop_klass in js:
    js = js.replace(old_pop_klass, new_pop_klass, 1)
    print("2. Successfully updated populateOfflineInventoryCards cardItemKlass!")
else:
    print("FAIL 2: old_pop_klass not found")

# 3. Fix ensureDisplayGroupList to use createManagedList
old_dgl = '''                        var listKlass = getClass("mscorlib", "System.Collections.Generic", "List`1");
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
                        }'''

new_dgl = '''                        var meta = getGlobalMetadata();
                        var playables = (meta && meta.playableGroups) ? meta.playableGroups : PLAYABLE_GROUP_CODES;
                        var groupItems = [];
                        for (var pi = 0; pi < playables.length; pi++) {
                            var gCode = playables[pi];
                            var gi = allInvenGroupItems[gCode] || (gCode === 1001 ? loonaGroupItemObj : NULL);
                            if (gi && !gi.isNull()) {
                                groupItems.push(gi);
                            }
                        }
                        var newDgl = createManagedList(groupItems, 'group');
                        if (newDgl && !newDgl.isNull()) {
                            var setDglFn = new NativeFunction(baseAddr.add(0xF27770), "void", ["pointer", "pointer"]);
                            setDglFn(newDgl, NULL);
                            cachedDglInstance = newDgl;
                            log("[🃏 INVENTORY] Created authentic IL2CPP List<GroupItem> for DisplayGroupList: " + newDgl + " (count=" + groupItems.length + ")");
                            return newDgl;
                        }'''

if old_dgl in js:
    js = js.replace(old_dgl, new_dgl, 1)
    print("3. Successfully updated ensureDisplayGroupList!")
else:
    print("FAIL 3: old_dgl not found")

# 4. Remove dead Memory.alloc in GetGroupViewData
old_dead_alloc = '''                                        // Try direct il2cpp_object_new for a generic list klass via metadata
                                        // Fallback: build a raw array-based list structure in native memory
                                        var listMem = Memory.alloc(0x30);
                                        listMem.add(0x00).writePointer(NULL); // vtable placeholder (null ok for Frida-controlled read)
                                        listMem.add(0x10).writePointer(NULL); // _items inner array
                                        listMem.add(0x18).writeS32(cardSmallParamsList.length); // _size
                                        listMem.add(0x1C).writeS32(cardSmallParamsList.length); // _version

                                        // Build inner object[] array: header (vtable + m_maxLength + m_size) + items
                                        var arrMem = Memory.alloc(0x20 + cardSmallParamsList.length * 8);
                                        arrMem.add(0x18).writeS32(cardSmallParamsList.length); // array length
                                        for (var ai = 0; ai < cardSmallParamsList.length; ai++) {
                                            arrMem.add(0x20 + ai * 8).writePointer(cardSmallParamsList[ai] || NULL);
                                        }
                                        listMem.add(0x10).writePointer(arrMem);
                                        smallCardParamListObj = listMem;
                                        log("[✅ GROUP_VIEW] Built cardParams List<CardSmallView.Params> with " + cardSmallParamsList.length + " items");'''

new_dead_alloc = '''                                        log("[✅ GROUP_VIEW] Built cardParams List<CardSmallView.Params> with " + cardSmallParamsList.length + " items");'''

if old_dead_alloc in js:
    js = js.replace(old_dead_alloc, new_dead_alloc, 1)
    print("4. Successfully cleaned up GetGroupViewData allocations!")
else:
    print("FAIL 4: old_dead_alloc not found")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(js)
