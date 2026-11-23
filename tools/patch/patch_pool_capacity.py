with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Update Step 4 in buildOfflineLiveThemeData to allocate pool with capacity 32
old_step4 = """                        log("[🔍 STEP 4] FastArray of ThemeCardItem... themeCardItemKlass=" + themeCardItemKlass);
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
                        log("[✅ FAST_ARRAY] Direct zero-crash FastArray<ThemeCardItem> allocated at: " + tciFastArray + " pool=" + pool + " pool.max_length=" + (pool.isNull() ? "NULL" : pool.add(0x18).readS32()));"""

new_step4 = """                        log("[🔍 STEP 4] FastArray of ThemeCardItem... themeCardItemKlass=" + themeCardItemKlass);
                        // 4. Authentic FastArray of ThemeCardItem with 32 elements (prevents IndexOutOfRange)
                        var poolCap = 32;
                        var pool = il2cpp_array_new(themeCardItemKlass, poolCap);
                        if (il2cpp_gchandle_new && !pool.isNull()) il2cpp_gchandle_new(pool, 2);
                        for (var ti = 0; ti < poolCap; ti++) {
                            var item = (ti < loonaThemeCardItems.length) ? loonaThemeCardItems[ti] : loonaThemeCardItems[loonaThemeCardItems.length - 1];
                            pool.add(0x20 + ti * 8).writePointer(item || NULL);
                            if (!loonaThemeCardMap[ti]) loonaThemeCardMap[ti] = item;
                        }
                        var tciFastArray = Memory.alloc(64);
                        var sampleFaKlass = (loonaGroupData && !loonaGroupData.isNull() && !loonaGroupData.add(0x30).readPointer().isNull()) ? loonaGroupData.add(0x30).readPointer().readPointer() : resolveMetadataSlot(0x31E1800);
                        tciFastArray.writePointer(sampleFaKlass);
                        tciFastArray.add(0x8).writePointer(NULL);
                        tciFastArray.add(0x10).writePointer(pool);
                        tciFastArray.add(0x18).writeS32(poolCap); // capacity
                        tciFastArray.add(0x1C).writeS32(poolCap); // length
                        log("[✅ FAST_ARRAY] Direct zero-crash FastArray<ThemeCardItem> allocated at: " + tciFastArray + " pool=" + pool + " pool.max_length=" + (pool.isNull() ? "NULL" : pool.add(0x18).readS32()));"""

if old_step4 not in content:
    print("[-] old_step4 not found in libscript.js!")
    exit(1)

content = content.replace(old_step4, new_step4, 1)

# 2. Update SetStateWait (0xC2C7C0) to perform clean direct transition without calling broken native trampoline
old_ssw = """                    // 3. LiveThemeBookScene.SetStateWait (0xC2C7C0)
                    var origSetStateWait = new NativeFunction(baseAddr.add(0xC2C7C0), "void", ["pointer", "pointer"]);
                    Interceptor.replace(baseAddr.add(0xC2C7C0), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[🎨 LIVE THEME] SetStateWait entered -> ensuring live theme data...");
                        ensureLiveThemeData();
                        try {
                            origSetStateWait(sceneThis, methodInfo);
                            log("[🎨 LIVE THEME] Native SetStateWait dispatched successfully!");
                        } catch (eLtw) {
                            log("[-] Error in native SetStateWait, applying fallback transition: " + eLtw.message);
                            try {
                                var setStateWaitDoneFn = new NativeFunction(baseAddr.add(0xC2C9E4), "void", ["pointer", "pointer"]);
                                setStateWaitDoneFn(sceneThis, NULL);
                                var setStateDefaultFn = new NativeFunction(baseAddr.add(0xC2CA84), "void", ["pointer", "pointer"]);
                                setStateDefaultFn(sceneThis, NULL);
                            } catch (eFallback) {}
                        }
                    }, "void", ["pointer", "pointer"]));"""

new_ssw = """                    // 3. LiveThemeBookScene.SetStateWait (0xC2C7C0) -> direct offline transition
                    Interceptor.replace(baseAddr.add(0xC2C7C0), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[🎨 LIVE THEME] SetStateWait entered -> direct offline transition to WaitDone & Default");
                        ensureLiveThemeData();
                        try {
                            var setStateWaitDoneFn = new NativeFunction(baseAddr.add(0xC2C9E4), "void", ["pointer", "pointer"]);
                            setStateWaitDoneFn(sceneThis, NULL);
                            var setStateDefaultFn = new NativeFunction(baseAddr.add(0xC2CA84), "void", ["pointer", "pointer"]);
                            setStateDefaultFn(sceneThis, NULL);
                        } catch (eFallback) {
                            log("[-] Error in direct transition: " + eFallback.message);
                        }
                    }, "void", ["pointer", "pointer"]));"""

if old_ssw not in content:
    print("[-] old_ssw not found in libscript.js!")
    exit(1)

content = content.replace(old_ssw, new_ssw, 1)

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(content)

with open('app/src/main/lib/arm64-v8a/libscript.so', 'w', encoding='utf-8') as f:
    f.write(content)

print("[SUCCESS] Patched pool capacity to 32 and direct SetStateWait transition!")
