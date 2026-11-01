import re

with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    js = f.read()

# 1. Replace createFastArray and createManagedList with authentic metadata-slot implementations
old_collections_block = '''                function createFastArray(items, type) {
                    try {
                        var klassTablePtr = NULL;
                        var methodInfoTablePtr = NULL;
                        if (type === 'artist') {
                            klassTablePtr = baseAddr.add(0x30F5BD0);
                            methodInfoTablePtr = baseAddr.add(0x31154D8);
                        } else {
                            klassTablePtr = baseAddr.add(0x3129040);
                            methodInfoTablePtr = baseAddr.add(0x31080E8);
                        }

                        var initMetaFn = new NativeFunction(baseAddr.add(0xA43BE8), "void", ["pointer"]);

                        var klass = NULL;
                        try {
                            var ptr1 = klassTablePtr.readPointer();
                            if (!ptr1.isNull()) {
                                initMetaFn(ptr1);
                                klass = ptr1.readPointer();
                            }
                        } catch (eKp) {}

                        if (klass && !klass.isNull()) {
                            var fa = il2cpp_object_new(klass);
                            if (fa && !fa.isNull()) {
                                var len = items ? items.length : 0;
                                var methodInfo = NULL;
                                try {
                                    var miPtr1 = methodInfoTablePtr.readPointer();
                                    if (!miPtr1.isNull()) {
                                        initMetaFn(miPtr1);
                                        methodInfo = miPtr1.readPointer();
                                    }
                                } catch (eMip) {}

                                var ctorFn = new NativeFunction(baseAddr.add(0x1C48A4C), "void", ["pointer", "int", "int", "pointer"]);
                                ctorFn(fa, len, len, methodInfo);

                                var pool = fa.add(0x10).readPointer();
                                if (!pool.isNull()) {
                                    for (var i = 0; i < len; i++) {
                                        pool.add(0x20 + i * 8).writePointer(items[i] || NULL);
                                    }
                                }
                                fa.add(0x1C).writeS32(len);
                                log("[✅ FAST_ARRAY] Created genuine FastArray<" + type + "> at: " + fa + " (len: " + len + ")");
                                return fa;
                            }
                        }
                    } catch (eFa) {
                        log("[-] Error creating FastArray: " + eFa.message);
                    }
                    return NULL;
                }

                function createManagedList(items, type) {
                    try {
                        var klassTablePtr = NULL;
                        var methodInfoTablePtr = NULL;
                        if (type === 'group') {
                            klassTablePtr = baseAddr.add(0x30EE228);
                            methodInfoTablePtr = baseAddr.add(0x3122270);
                        } else if (type === 'theme') {
                            klassTablePtr = baseAddr.add(0x30D6870);
                            methodInfoTablePtr = baseAddr.add(0x31120D0);
                        }

                        var initMetaFn = new NativeFunction(baseAddr.add(0xA43BE8), "void", ["pointer"]);

                        var klass = NULL;
                        try {
                            var ptr1 = klassTablePtr.readPointer();
                            if (!ptr1.isNull()) {
                                initMetaFn(ptr1);
                                klass = ptr1.readPointer();
                            }
                        } catch (eKp) {}

                        if (klass && !klass.isNull()) {
                            var listObj = il2cpp_object_new(klass);
                            if (listObj && !listObj.isNull()) {
                                var len = items ? items.length : 0;
                                var cap = Math.max(len + 4, 16);
                                var methodInfo = NULL;
                                try {
                                    var miPtr1 = methodInfoTablePtr.readPointer();
                                    if (!miPtr1.isNull()) {
                                        initMetaFn(miPtr1);
                                        methodInfo = miPtr1.readPointer();
                                    }
                                } catch (eMip) {}

                                var ctorFn = new NativeFunction(baseAddr.add(0x23CD880), "void", ["pointer", "int", "pointer"]);
                                ctorFn(listObj, cap, methodInfo);

                                var pool = listObj.add(0x10).readPointer();
                                if (!pool.isNull()) {
                                    for (var i = 0; i < len; i++) {
                                        pool.add(0x20 + i * 8).writePointer(items[i] || NULL);
                                    }
                                }
                                listObj.add(0x18).writeS32(len);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(listObj, 2);
                                log("[✅ MANAGED_LIST] Created genuine List<" + type + "> at: " + listObj + " (len: " + len + ", cap: " + cap + ")");
                                return listObj;
                            }
                        }
                    } catch (eList) {
                        log("[-] Error creating ManagedList: " + eList.message);
                    }
                    return NULL;
                }'''

new_collections_block = '''                var initMetaFnNative = null;
                function resolveMetadataSlot(slotRva) {
                    try {
                        if (!initMetaFnNative) {
                            initMetaFnNative = new NativeFunction(baseAddr.add(0xA43BE8), "void", ["pointer"]);
                        }
                        var slot = baseAddr.add(slotRva);
                        initMetaFnNative(slot);
                        return slot.readPointer();
                    } catch (eRms) {
                        log("[-] Error in resolveMetadataSlot(0x" + slotRva.toString(16) + "): " + eRms.message);
                        return NULL;
                    }
                }

                function createFastArray(items, type) {
                    try {
                        var klassSlotRva = 0;
                        var methodSlotRva = 0;
                        if (type === 'artist') {
                            klassSlotRva = 0x31E1800;  // Ext.Collection.AntiGC.FastArray<ArtistControl.Data>_TypeInfo
                            methodSlotRva = 0x32035E0; // Method$Ext.Collection.AntiGC.FastArray<ArtistControl.Data>..ctor()
                        } else if (type === 'cardbook_card') {
                            klassSlotRva = 0x31E1810;  // Ext.Collection.AntiGC.FastArray<CardBookControl.CardItem>_TypeInfo
                            methodSlotRva = 0x3203628; // Method$Ext.Collection.AntiGC.FastArray<CardBookControl.CardItem>..ctor()
                        } else {
                            // 'card' -> InventoryControl.CardItem
                            klassSlotRva = 0x31E1848;  // Ext.Collection.AntiGC.FastArray<InventoryControl.CardItem>_TypeInfo
                            methodSlotRva = 0x3203738; // Method$Ext.Collection.AntiGC.FastArray<InventoryControl.CardItem>..ctor()
                        }

                        var klass = resolveMetadataSlot(klassSlotRva);
                        var methodInfo = resolveMetadataSlot(methodSlotRva);

                        if (klass && !klass.isNull()) {
                            var fa = il2cpp_object_new(klass);
                            if (fa && !fa.isNull()) {
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(fa, 2);
                                var len = items ? items.length : 0;
                                var cap = Math.max(len, 4);

                                var ctorFn = new NativeFunction(baseAddr.add(0x1C48A4C), "void", ["pointer", "int", "int", "pointer"]);
                                ctorFn(fa, cap, len, methodInfo);

                                var pool = fa.add(0x10).readPointer();
                                if (!pool.isNull()) {
                                    if (il2cpp_gchandle_new) il2cpp_gchandle_new(pool, 2);
                                    for (var i = 0; i < len; i++) {
                                        pool.add(0x20 + i * 8).writePointer(items[i] || NULL);
                                    }
                                }
                                fa.add(0x1C).writeS32(len);
                                log("[✅ FAST_ARRAY] Created genuine FastArray<" + type + "> at: " + fa + " (len: " + len + ", cap: " + cap + ")");
                                return fa;
                            }
                        }
                    } catch (eFa) {
                        log("[-] Error creating FastArray: " + eFa.message);
                    }
                    return NULL;
                }

                function createManagedList(items, type) {
                    try {
                        var klassSlotRva = 0;
                        var methodSlotRva = 0;
                        if (type === 'group') {
                            klassSlotRva = 0x31E3588;  // System.Collections.Generic.List<InventoryControl.GroupItem>_TypeInfo
                            methodSlotRva = 0x320AF90; // Method$System.Collections.Generic.List<InventoryControl.GroupItem>..ctor()
                        } else if (type === 'card') {
                            klassSlotRva = 0x31E3580;  // System.Collections.Generic.List<InventoryControl.CardItem>_TypeInfo
                            methodSlotRva = 0x320AF28; // Method$System.Collections.Generic.List<InventoryControl.CardItem>..ctor()
                        } else if (type === 'cardbook_group') {
                            klassSlotRva = 0x31E3440;  // System.Collections.Generic.List<CardBookControl.GroupItem>_TypeInfo
                            methodSlotRva = 0x320A908; // Method$System.Collections.Generic.List<CardBookControl.GroupItem>..ctor()
                        } else if (type === 'cardbook_theme' || type === 'theme') {
                            klassSlotRva = 0x31E3448;  // System.Collections.Generic.List<CardBookControl.ThemeItem>_TypeInfo
                            methodSlotRva = 0x320A948; // Method$System.Collections.Generic.List<CardBookControl.ThemeItem>..ctor()
                        }

                        var klass = resolveMetadataSlot(klassSlotRva);
                        var methodInfo = resolveMetadataSlot(methodSlotRva);

                        if (klass && !klass.isNull()) {
                            var listObj = il2cpp_object_new(klass);
                            if (listObj && !listObj.isNull()) {
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(listObj, 2);
                                var len = items ? items.length : 0;
                                var cap = Math.max(len + 4, 16);

                                var ctorFn = new NativeFunction(baseAddr.add(0x23CD880), "void", ["pointer", "int", "pointer"]);
                                ctorFn(listObj, cap, methodInfo);

                                var pool = listObj.add(0x10).readPointer();
                                if (!pool.isNull()) {
                                    if (il2cpp_gchandle_new) il2cpp_gchandle_new(pool, 2);
                                    for (var i = 0; i < len; i++) {
                                        pool.add(0x20 + i * 8).writePointer(items[i] || NULL);
                                    }
                                }
                                listObj.add(0x18).writeS32(len);
                                log("[✅ MANAGED_LIST] Created genuine List<" + type + "> at: " + listObj + " (len: " + len + ", cap: " + cap + ")");
                                return listObj;
                            }
                        }
                    } catch (eList) {
                        log("[-] Error creating ManagedList: " + eList.message);
                    }
                    return NULL;
                }'''

if old_collections_block in js:
    js = js.replace(old_collections_block, new_collections_block, 1)
    print("1. Successfully updated createFastArray and createManagedList!")
else:
    print("FAIL 1: old_collections_block not found")

# 2. Update ensureListBuffer and populateOfflineInventoryCards
old_buf_resolve = 'cachedCardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");'
new_buf_resolve = 'cachedCardItemKlass = resolveMetadataSlot(0x31F3060);'
if old_buf_resolve in js:
    js = js.replace(old_buf_resolve, new_buf_resolve, 1)
    print("2. Successfully updated ensureListBuffer cachedCardItemKlass!")
else:
    print("FAIL 2: old_buf_resolve not found")

old_pop_resolve = 'var cardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");'
new_pop_resolve = 'var cardItemKlass = resolveMetadataSlot(0x31F3060);'
if old_pop_resolve in js:
    js = js.replace(old_pop_resolve, new_pop_resolve, 1)
    print("3. Successfully updated populateOfflineInventoryCards cardItemKlass!")
else:
    print("FAIL 3: old_pop_resolve not found")

# 3. Update ensureInventoryLists to resolve 0x31E3580
old_eil = '''                        var klass = NULL;
                        var dcl = scene.add(0x58).readPointer();
                        if (!dcl.isNull()) {
                            klass = dcl.readPointer();
                            cachedListCardItemKlass = klass;
                        } else if (cachedListCardItemKlass && !cachedListCardItemKlass.isNull()) {
                            klass = cachedListCardItemKlass;
                        }
                        if (!klass || klass.isNull()) return;'''

new_eil = '''                        var klass = resolveMetadataSlot(0x31E3580);
                        if (!klass || klass.isNull()) {
                            var dcl = scene.add(0x58).readPointer();
                            if (!dcl.isNull()) klass = dcl.readPointer();
                        }
                        if (!klass || klass.isNull()) return;'''

if old_eil in js:
    js = js.replace(old_eil, new_eil, 1)
    print("4. Successfully updated ensureInventoryLists klass resolution!")
else:
    print("FAIL 4: old_eil not found")

# 4. Clean up CardBookControl createManagedList and remove Memory.alloc fallbacks
old_cb_lists = '''                            var themeListManaged = createManagedList(themeItems, 'theme');
                            if (!themeListManaged || themeListManaged.isNull()) {
                                themeListManaged = Memory.alloc(64);
                                var themeArr = il2cpp_array_new(cbThemeItemKlass, Math.max(themeItems.length + 4, 16));
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(themeArr, 2);
                                for (var ti = 0; ti < themeItems.length; ti++) {
                                    themeArr.add(0x20 + ti * 8).writePointer(themeItems[ti]);
                                }
                                themeListManaged.add(0x10).writePointer(themeArr);
                                themeListManaged.add(0x18).writeS32(themeItems.length);
                            }'''

new_cb_lists = '''                            var themeListManaged = createManagedList(themeItems, 'cardbook_theme');'''

if old_cb_lists in js:
    js = js.replace(old_cb_lists, new_cb_lists, 1)
    print("5. Successfully cleaned up CardBookControl themeListManaged!")
else:
    print("FAIL 5: old_cb_lists not found")

old_cb_groups = '''                        // 5. Wrap GroupList in managed list structure
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
                        }'''

new_cb_groups = '''                        // 5. Wrap GroupList in genuine managed list structure
                        var groupListManaged = createManagedList(allCbGroupItemList, 'cardbook_group');'''

if old_cb_groups in js:
    js = js.replace(old_cb_groups, new_cb_groups, 1)
    print("6. Successfully cleaned up CardBookControl groupListManaged!")
else:
    print("FAIL 6: old_cb_groups not found")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(js)
print("All patches processed!")
