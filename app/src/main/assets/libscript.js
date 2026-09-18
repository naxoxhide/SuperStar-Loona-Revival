/**
 * SuperStar LOONA Revival & Network Interceptor Script (Frida Gadget)
 * Dynamic IL2CPP C-API Hooking Engine, DNS Redirection & Traffic Logger
 */

var __android_log_print = null;
try {
    var logPtr = Module.findExportByName("liblog.so", "__android_log_print");
    if (logPtr) {
        __android_log_print = new NativeFunction(logPtr, "int", ["int", "pointer", "pointer", "pointer"]);
    }
} catch (e) {}

var tag = Memory.allocUtf8String("FridaSSLO");
var logFmt = Memory.allocUtf8String("%s");
function log(msg) {
    try {
        if (__android_log_print) {
            var str = Memory.allocUtf8String(String(msg));
            __android_log_print(3, tag, logFmt, str);
        }
    } catch (e) {}
    console.log(msg);
}

log("[🌟] SuperStar LOONA Revival Frida Gadget Initialized!");

var abortPtr = Module.findExportByName("libc.so", "abort");
if (abortPtr) {
    Interceptor.attach(abortPtr, {
        onEnter: function (args) {
            log("🚨 [CRASH ABORT] libc.so!abort called! Backtrace:\n" +
                Thread.backtrace(this.context, Backtracer.ACCURATE)
                .map(DebugSymbol.fromAddress).join("\n"));
        }
    });
}

var globalTitleScene = null;
var il2cppInitialized = false;
function tryInitAll() {
    if (il2cppInitialized) return;
    var mod = Process.findModuleByName("libil2cpp.so");
    if (mod) {
        il2cppInitialized = true;
        log("[🚀 IL2CPP AUTO-INIT] libil2cpp.so detected at: " + mod.base);
        initIl2Cpp(mod);
    }
}

// --- 0. LOW-LEVEL LIBC DNS REDIRECT & PORT REDIRECT ---
try {
    var getaddrinfoPtr = Module.findExportByName("libc.so", "getaddrinfo");
    if (getaddrinfoPtr) {
        Interceptor.attach(getaddrinfoPtr, {
            onEnter: function (args) {
                tryInitAll();
                try {
                    if (!args[0].isNull()) {
                        var host = args[0].readCString();
                        if (host && (host.indexOf("dalcomsoft") !== -1 || host.indexOf("sslo") !== -1 || host.indexOf("cloudfront") !== -1 || host.indexOf("amazonaws") !== -1 || host === "localhost" || host === "127.0.0.1")) {
                            log("[🌐 DNS REDIRECT] " + host + " -> 10.0.2.2 (Local Revival Server)");
                            this.newHost = Memory.allocUtf8String("10.0.2.2");
                            args[0] = this.newHost;
                        }
                    }
                } catch (e) {}
            }
        });
        log("[+] Hooked libc.so!getaddrinfo for universal DNS redirection");
    }

    // Comprehensive File Access Monitor for CAB and Data loading
    function checkFilePath(path, funcName) {
        if (!path) return;
        if (path.indexOf("0ce") !== -1 || path.indexOf("level3") !== -1 || path.indexOf("sharedassets3") !== -1 || path.indexOf("bin/Data") !== -1) {
            log("[📂 " + funcName + "] " + path);
        }
    }

    var aAssetOpen = Module.findExportByName("libandroid.so", "AAssetManager_open");
    if (aAssetOpen) {
        Interceptor.attach(aAssetOpen, {
            onEnter: function (args) {
                try {
                    this.name = args[1].readCString();
                    checkFilePath(this.name, "AAsset_open");
                } catch (e) {}
            },
            onLeave: function (retval) {
                if (this.name && (this.name.indexOf("0ce") !== -1 || this.name.indexOf("sharedassets3") !== -1)) {
                    log("[📂 AAsset_open RESULT] " + this.name + " -> " + retval);
                }
            }
        });
    }

    var openPtr = Module.findExportByName("libc.so", "open");
    if (openPtr) {
        Interceptor.attach(openPtr, {
            onEnter: function (args) {
                try {
                    this.path = args[0].readCString();
                    checkFilePath(this.path, "open");
                } catch (e) {}
            },
            onLeave: function (retval) {
                if (this.path && (this.path.indexOf("0ce") !== -1 || this.path.indexOf("sharedassets3") !== -1)) {
                    log("[📂 open RESULT] " + this.path + " -> fd: " + retval.toInt32());
                }
            }
        });
    }

    var openatPtr = Module.findExportByName("libc.so", "openat");
    if (openatPtr) {
        Interceptor.attach(openatPtr, {
            onEnter: function (args) {
                try {
                    this.path = args[1].readCString();
                    checkFilePath(this.path, "openat");
                } catch (e) {}
            },
            onLeave: function (retval) {
                if (this.path && (this.path.indexOf("0ce") !== -1 || this.path.indexOf("sharedassets3") !== -1)) {
                    log("[📂 openat RESULT] " + this.path + " -> fd: " + retval.toInt32());
                }
            }
        });
    }

    var connectPtr = Module.findExportByName("libc.so", "connect");
    if (connectPtr) {
        Interceptor.attach(connectPtr, {
            onEnter: function (args) {
                tryInitAll();
                try {
                    var sockAddr = args[1];
                    if (!sockAddr.isNull()) {
                        var family = sockAddr.readU16();
                        if (family === 2) { // AF_INET
                            var port = (sockAddr.add(2).readU8() << 8) | sockAddr.add(3).readU8();
                            if (port === 80) {
                                // Redirect port 80 -> 8000 (0x1F40 -> 0x1F, 0x40 in network byte order)
                                sockAddr.add(2).writeU8(0x1F);
                                sockAddr.add(3).writeU8(0x40);
                                // Universal IPv4 redirection to 10.0.2.2 (Local Revival Server)
                                sockAddr.add(4).writeU8(10);
                                sockAddr.add(5).writeU8(0);
                                sockAddr.add(6).writeU8(2);
                                sockAddr.add(7).writeU8(2);
                                log("[🔌 PORT REDIRECT] Redirected port 80 and IP -> 10.0.2.2:8000 (HTTP Revival Server)");
                            }
                        }
                    }
                } catch (e) {}
            }
        });
        log("[+] Hooked libc.so!connect for port redirection");
        // 1.5 Hook AAssetManager_open to log every asset file opened by Unity
        try {
            var assetOpen = Module.findExportByName("libandroid.so", "AAssetManager_open");
            if (assetOpen) {
                Interceptor.attach(assetOpen, {
                    onEnter: function (args) {
                        try {
                            var filename = args[1].readUtf8String();
                            if (filename && filename.indexOf("bin/Data") !== -1) {
                                log("[📦 AAsset] Opened: " + filename);
                            }
                        } catch (e) {}
                    }
                });
                log("[+] Hooked libandroid.so!AAssetManager_open");
            }
        } catch (e) {
            log("[-] AAssetManager hook error: " + e.message);
        }
    }
} catch (e) {
    log("[-] DNS/Socket hook error: " + e.message);
}

function onLibraryLoaded(libName, callback) {
    var fired = false;
    function trigger(m) {
        if (fired) return;
        fired = true;
        log("[🚀 MODULE DETECTED] " + libName + " loaded at: " + m.base);
        callback(m);
    }

    var mod = Process.findModuleByName(libName);
    if (mod) {
        trigger(mod);
        return;
    }

    var interval = setInterval(function () {
        var m = Process.findModuleByName(libName);
        if (m) {
            clearInterval(interval);
            trigger(m);
        }
    }, 100);
}

onLibraryLoaded("libunity.so", function (module) {
    try {
        var verifyFn = Module.findExportByName("libunity.so", "unitytls_tlsctx_get_peer_verify_result");
        if (verifyFn) {
            Interceptor.attach(verifyFn, {
                onLeave: function (retval) {
                    retval.replace(0); // UNITYTLS_SUCCESS (0)
                }
            });
            log("[+] Hooked unitytls_tlsctx_get_peer_verify_result -> 0 (SUCCESS - SSL Bypass Active)");
        }
    } catch (e) {
        log("[-] unitytls hook error: " + e.message);
    }
});

onLibraryLoaded("libil2cpp.so", function (module) {
    tryInitAll();
});

function initIl2Cpp(module) {
    var il2cppBase = module.base;
    log("[+] libil2cpp.so active at base: " + il2cppBase);

    // --- RESOLVE IL2CPP EXPORTED C-APIs ---
    function getExport(name, retType, argTypes) {
        var addr = Module.findExportByName("libil2cpp.so", name);
        if (!addr) {
            log("[-] Export not found: " + name);
            return null;
        }
        return new NativeFunction(addr, retType, argTypes);
    }

    var il2cpp_domain_get = getExport("il2cpp_domain_get", "pointer", []);
    var il2cpp_domain_assembly_open = getExport("il2cpp_domain_assembly_open", "pointer", ["pointer", "pointer"]);
    var il2cpp_assembly_get_image = getExport("il2cpp_assembly_get_image", "pointer", ["pointer"]);
    var il2cpp_class_from_name = getExport("il2cpp_class_from_name", "pointer", ["pointer", "pointer", "pointer"]);
    var il2cpp_class_get_method_from_name = getExport("il2cpp_class_get_method_from_name", "pointer", ["pointer", "pointer", "int"]);
    var il2cpp_class_get_methods = getExport("il2cpp_class_get_methods", "pointer", ["pointer", "pointer"]);
    var il2cpp_method_get_name = getExport("il2cpp_method_get_name", "pointer", ["pointer"]);
    var il2cpp_method_get_param_count = getExport("il2cpp_method_get_param_count", "uint32", ["pointer"]);
    var il2cpp_string_new = getExport("il2cpp_string_new", "pointer", ["pointer"]);
    var il2cpp_domain_get_assemblies = getExport("il2cpp_domain_get_assemblies", "pointer", ["pointer", "pointer"]);
    var il2cpp_runtime_invoke = getExport("il2cpp_runtime_invoke", "pointer", ["pointer", "pointer", "pointer", "pointer"]);
    var il2cpp_object_new = getExport("il2cpp_object_new", "pointer", ["pointer"]);
    var il2cpp_thread_attach = getExport("il2cpp_thread_attach", "pointer", ["pointer"]);
    var il2cpp_class_get_nested_types = getExport("il2cpp_class_get_nested_types", "pointer", ["pointer", "pointer"]);
    var il2cpp_class_get_name = getExport("il2cpp_class_get_name", "pointer", ["pointer"]);

    function getNestedClass(parentClass, nestedName) {
        if (!parentClass || parentClass.isNull() || !il2cpp_class_get_nested_types || !il2cpp_class_get_name) return NULL;
        try {
            var iter = Memory.alloc(Process.pointerSize);
            iter.writePointer(NULL);
            var nested;
            while (!(nested = il2cpp_class_get_nested_types(parentClass, iter)).isNull()) {
                var nNamePtr = il2cpp_class_get_name(nested);
                if (!nNamePtr.isNull() && nNamePtr.readUtf8String() === nestedName) {
                    return nested;
                }
            }
        } catch (e) {
            log("[-] getNestedClass error: " + e.message);
        }
        return NULL;
    }

    function createIl2CppString(str) {
        if (il2cpp_string_new) {
            return il2cpp_string_new(Memory.allocUtf8String(str));
        }
        return NULL;
    }

    function readIl2CppString(strPtr) {
        if (!strPtr || strPtr.isNull()) return "";
        try {
            var len = strPtr.add(Process.pointerSize * 2).readInt();
            if (len > 0 && len < 20000) {
                return strPtr.add(Process.pointerSize * 2 + 4).readUtf16String(len);
            }
        } catch (e) {}
        return "";
    }

    function installNativeRvaHooks(baseAddr) {
        log("[🚀 RVA HOOKS] Installing direct RVA hooks at libil2cpp base: " + baseAddr);
        try {
            // 1. Platform.<getRegion>b__0 (0xEF87D0) - Evitar ArgumentNullException de Newtonsoft
            var getRegionCallbackHandlerPtr = baseAddr.add(0xEF87D0);
            Interceptor.replace(getRegionCallbackHandlerPtr, new NativeCallback(function (thiz, handle) {
                log("[🌍 PLATFORM] Platform.<getRegion>b__0 intercepted -> safely invoking callback('KR', false)");
                try {
                    var cb = thiz.add(0x10).readPointer();
                    if (!cb.isNull()) {
                        var invokePtr = baseAddr.add(0x18F3F30);
                        var invokeFn = new NativeFunction(invokePtr, "void", ["pointer", "pointer", "pointer", "bool", "pointer"]);
                        var methodInfo = baseAddr.add(0x30FB000).add(0xC70).readPointer();
                        invokeFn(cb, handle, createIl2CppString("KR"), 0, methodInfo);
                        log("[🌟 SUCCESS] Platform.<getRegion>b__0 safely invoked with KR!");
                    }
                } catch (e) {
                    log("[-] Error in getRegion callback bypass: " + e.message);
                }
            }, "void", ["pointer", "pointer"]));
            log("[+] Hooked Platform.<getRegion>b__0 at: " + getRegionCallbackHandlerPtr);

            // 1b. Platform.<getTimestamp>b__0 (0xEF8130) - Evitar InvalidCastException de JObject a Int64
            var getTimestampCallbackHandlerPtr = baseAddr.add(0xEF8130);
            Interceptor.replace(getTimestampCallbackHandlerPtr, new NativeCallback(function (thiz, handle) {
                log("[🌍 PLATFORM] Platform.<getTimestamp>b__0 intercepted -> invoking callback with timestamp");
                try {
                    var cb = thiz.add(0x10).readPointer();
                    if (!cb.isNull()) {
                        var invokePtr = baseAddr.add(0x18F0658);
                        var invokeFn = new NativeFunction(invokePtr, "void", ["pointer", "pointer", "int64", "pointer"]);
                        var methodInfo = baseAddr.add(0x30EE000).add(0xEA8).readPointer();
                        var now = Date.now();
                        invokeFn(cb, handle, now, methodInfo);
                        log("[🌟 SUCCESS] Platform.<getTimestamp>b__0 safely invoked with: " + now);
                    }
                } catch (e) {
                    log("[-] Error in getTimestamp callback bypass: " + e.message);
                }
            }, "void", ["pointer", "pointer"]));
            // 1c. Platform.<checkAssetBundle>b__0 (0xEF820C) - Evitar NullReferenceException al deserializar AssetContext
            var checkAssetBundleCallbackHandlerPtr = baseAddr.add(0xEF820C);
            Interceptor.replace(checkAssetBundleCallbackHandlerPtr, new NativeCallback(function (thiz, handle) {
                log("[📦 PLATFORM] Platform.<checkAssetBundle>b__0 intercepted -> safely invoking callback with local AssetContext");
                try {
                    var cb = thiz.add(0x10).readPointer();
                    if (!cb.isNull()) {
                        var assetContextClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "AssetContext");
                        if (assetContextClass && !assetContextClass.isNull()) {
                            var assetContextObj = il2cpp_object_new(assetContextClass);
                            var assetContextCtor = new NativeFunction(baseAddr.add(0xAD7468), 'void', ['pointer']);
                            assetContextCtor(assetContextObj);
                            assetContextObj.add(0x10).writeU32(23); // version = 23

                            var invokePtr = baseAddr.add(0xEF8344);
                            var invokeFn = new NativeFunction(invokePtr, "int", ["pointer", "pointer", "pointer"]);
                            var res = invokeFn(cb, handle, assetContextObj);
                            log("[🌟 SUCCESS] Platform.OnInstallAsset.Invoke safely executed! res: " + res);
                        }
                    }
                } catch (e) {
                    log("[-] Error in checkAssetBundle callback bypass: " + e.message);
                }
            }, "void", ["pointer", "pointer"]));
            log("[+] Hooked Platform.<checkAssetBundle>b__0 at: " + checkAssetBundleCallbackHandlerPtr);

            // 2. AssetControl bypass (forzar IsResourceDownloadComplete=true, State=Done=8 y Progress=1.0)
            var assetControlReqTryDownloadPtr = baseAddr.add(0xAD792C);
            var assetControlResCompletePtr = baseAddr.add(0xAD7CC8);
            var assetControlDownloadedSizePtr = baseAddr.add(0xAD7B2C);
            var assetControlConfirmedDownloadPtr = baseAddr.add(0xAD7BF8);
            var assetControlOpenPtr = baseAddr.add(0xAD8000);
            var assetControlGetStatePtr = baseAddr.add(0xAD785C);
            var assetControlGetProgressPtr = baseAddr.add(0xAD7790);
            var assetControlGetIsDownloadingPtr = baseAddr.add(0xAD79FC);

            var isAssetOpenCalled = false;

            Interceptor.replace(assetControlReqTryDownloadPtr, new NativeCallback(function () {
                log("[📦 ASSET] get_IsRequireTryDownload -> false (bypass download popup)");
                return 0;
            }, "int", []));

            Interceptor.replace(assetControlResCompletePtr, new NativeCallback(function () {
                return 1;
            }, "int", []));

            Interceptor.replace(assetControlDownloadedSizePtr, new NativeCallback(function () {
                return ptr(0);
            }, "pointer", []));

            Interceptor.replace(assetControlConfirmedDownloadPtr, new NativeCallback(function () {
                return 1;
            }, "int", []));

            Interceptor.replace(assetControlGetIsDownloadingPtr, new NativeCallback(function () {
                return 0;
            }, "int", []));

            Interceptor.attach(assetControlOpenPtr, {
                onEnter: function (args) {
                    log("[📦 ASSET] AssetControl.Open called -> Setting isAssetOpenCalled = true");
                    isAssetOpenCalled = true;
                }
            });

            Interceptor.attach(assetControlGetStatePtr, {
                onLeave: function (retval) {
                    if (isAssetOpenCalled) {
                        try {
                            retval.replace(8); // STATE.Done = 8
                        } catch (e) {}
                    }
                }
            });
            log("[+] AssetControl.get_State hooked via attach -> Done=8 when Open is called");
            log("[+] Hooked AssetControl methods");

            // 2.1 UpdateNoticeControl bypass (RVA 0x164335C) - Evita NullReferenceException en OpenAssetContents
            var updateNoticeOpenPtr = baseAddr.add(0x164335C);
            var actionInvokePtr = baseAddr.add(0x1DEBE44);
            var actionInvokeFn = null;
            try {
                actionInvokeFn = new NativeFunction(actionInvokePtr, "void", ["pointer", "pointer"]);
            } catch (e) {}

            Interceptor.replace(updateNoticeOpenPtr, new NativeCallback(function (cb) {
                log("[📢 NOTICE] UpdateNoticeControl.Open invoked -> safely bypassing");
                try {
                    var setIsOpenedFn = new NativeFunction(baseAddr.add(0x1643158), "void", ["int"]);
                    setIsOpenedFn(1);
                } catch (e) {}
                if (!cb.isNull() && actionInvokeFn) {
                    try {
                        actionInvokeFn(cb, ptr(0));
                        log("[📢 NOTICE] UpdateNotice callback invoked cleanly!");
                    } catch (e) {
                        log("[-] Error invoking updateNotice callback: " + e.message);
                    }
                }
            }, "void", ["pointer"]));

            // 2.2 MusicControl.SortAlphabetCache protection (RVA 0xAFC500)
            var sortAlphabetCachePtr = baseAddr.add(0xAFC500);
            Interceptor.replace(sortAlphabetCachePtr, new NativeCallback(function () {
                log("[🎵 MUSIC] MusicControl.SortAlphabetCache protected bypass");
            }, "void", []));

            // 2.3 TitleScene.SetSDKInitialize bypass (0xB2341C) -> Skip Firebase/GooglePlay hang and call SetStateLoadingDone (0xB234E0)
            var setStateLoadingDonePtr = baseAddr.add(0xB234E0);
            var setStateLoadingDoneFn = null;
            try {
                setStateLoadingDoneFn = new NativeFunction(setStateLoadingDonePtr, "void", ["pointer"]);
            } catch (e) {}

            var setSDKInitializePtr = baseAddr.add(0xB2341C);
            Interceptor.replace(setSDKInitializePtr, new NativeCallback(function (thiz) {
                log("[🚀 SDK BYPASS] TitleScene.SetSDKInitialize called -> immediately calling SetStateLoadingDone!");
                if (setStateLoadingDoneFn && !thiz.isNull()) {
                    try {
                        setStateLoadingDoneFn(thiz);
                    } catch (e) {
                        log("[-] Error calling SetStateLoadingDone: " + e.message);
                    }
                }
            }, "void", ["pointer"]));

            // 2.4 Standalone Offline Authentication & Profile Persistence System
            var fopenPtr = Module.findExportByName("libc.so", "fopen");
            var freadPtr = Module.findExportByName("libc.so", "fread");
            var fwritePtr = Module.findExportByName("libc.so", "fwrite");
            var fclosePtr = Module.findExportByName("libc.so", "fclose");
            var accessPtr = Module.findExportByName("libc.so", "access");
            var strlenPtr = Module.findExportByName("libc.so", "strlen");
            var unlinkPtr = Module.findExportByName("libc.so", "unlink");

            var fopenFn = fopenPtr ? new NativeFunction(fopenPtr, "pointer", ["pointer", "pointer"]) : null;
            var freadFn = freadPtr ? new NativeFunction(freadPtr, "size_t", ["pointer", "size_t", "size_t", "pointer"]) : null;
            var fwriteFn = fwritePtr ? new NativeFunction(fwritePtr, "size_t", ["pointer", "size_t", "size_t", "pointer"]) : null;
            var fcloseFn = fclosePtr ? new NativeFunction(fclosePtr, "int", ["pointer"]) : null;
            var accessFn = accessPtr ? new NativeFunction(accessPtr, "int", ["pointer", "int"]) : null;
            var strlenFn = strlenPtr ? new NativeFunction(strlenPtr, "size_t", ["pointer"]) : null;
            var unlinkFn = unlinkPtr ? new NativeFunction(unlinkPtr, "int", ["pointer"]) : null;

            var PROFILE_DIR = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/";
            var PROFILE_PATH = PROFILE_DIR + "player_profile.json";
            var FALLBACK_PATH = "/data/data/com.dalcomsoft.sslo/files/player_profile.json";

            function fileExists(path) {
                if (!accessFn) return false;
                try {
                    var cPath = Memory.allocUtf8String(path);
                    return accessFn(cPath, 0) === 0;
                } catch (e) {
                    return false;
                }
            }

            function checkProfileResetTrigger() {
                var triggerPath = PROFILE_DIR + "reset_profile.txt";
                if (fileExists(triggerPath)) {
                    log("[🔄 PROFILE RESET] reset_profile.txt detected! Resetting offline profile...");
                    if (unlinkFn) {
                        try { unlinkFn(Memory.allocUtf8String(PROFILE_PATH)); } catch (e) {}
                        try { unlinkFn(Memory.allocUtf8String(FALLBACK_PATH)); } catch (e) {}
                        try { unlinkFn(Memory.allocUtf8String(triggerPath)); } catch (e) {}
                    }
                    cachedProfile = null;
                }
            }

            var cachedProfile = null;

            function writeTextFile(path, text) {
                if (!fopenFn || !fwriteFn || !fcloseFn) return false;
                try {
                    var cPath = Memory.allocUtf8String(path);
                    var cMode = Memory.allocUtf8String("wb");
                    var fp = fopenFn(cPath, cMode);
                    if (!fp.isNull()) {
                        var cText = Memory.allocUtf8String(text);
                        var len = strlenFn ? Number(strlenFn(cText)) : text.length;
                        fwriteFn(cText, 1, len, fp);
                        fcloseFn(fp);
                        return true;
                    }
                } catch (e) {
                    log("[-] Error writing file " + path + ": " + e.message);
                }
                return false;
            }

            function readTextFile(path) {
                if (!fopenFn || !freadFn || !fcloseFn) return null;
                try {
                    var cPath = Memory.allocUtf8String(path);
                    var cMode = Memory.allocUtf8String("rb");
                    var fp = fopenFn(cPath, cMode);
                    if (!fp.isNull()) {
                        var buf = Memory.alloc(65536);
                        var readRes = freadFn(buf, 1, 65535, fp);
                        var bytesRead = Number(readRes);
                        fcloseFn(fp);
                        if (bytesRead > 0) {
                            return buf.readUtf8String(bytesRead);
                        }
                    }
                } catch (e) {
                    log("[-] Error reading file " + path + ": " + e.message);
                }
                return null;
            }

            function createDefaultProfile(nickname) {
                return {
                    userId: 10001,
                    nickname: nickname || "Orbit",
                    profileCode: 1001,
                    diamond: 10000,
                    rhythmPoint: 100000,
                    headphone: 50,
                    dalcomCoin: 5000,
                    cardInvenMax: 200,
                    equipedLobbyBgList: [100001],
                    leaderCard: {
                        cardID: 10001,
                        grade: 4,
                        level: 50
                    },
                    inventoryCards: [],
                    equipedCards: {}
                };
            }

            function savePlayerProfile(profile) {
                cachedProfile = profile;
                var jsonStr = JSON.stringify(profile, null, 2);
                var ok = writeTextFile(PROFILE_PATH, jsonStr);
                writeTextFile(FALLBACK_PATH, jsonStr);
                if (ok) {
                    log("[💾 PROFILE] Player profile saved successfully to " + PROFILE_PATH + " (" + profile.nickname + ")");
                } else {
                    log("[-] Warning: Failed to write to " + PROFILE_PATH + ", saved to fallback path");
                }
                return ok;
            }

            function loadPlayerProfile() {
                checkProfileResetTrigger();
                if (cachedProfile) return cachedProfile;
                if (fileExists(PROFILE_PATH)) {
                    var content = readTextFile(PROFILE_PATH);
                    if (content) {
                        try {
                            cachedProfile = JSON.parse(content);
                            return cachedProfile;
                        } catch (e) {
                            log("[-] Error parsing player profile JSON from PROFILE_PATH: " + e.message);
                        }
                    }
                }
                if (fileExists(FALLBACK_PATH)) {
                    var content = readTextFile(FALLBACK_PATH);
                    if (content) {
                        try {
                            cachedProfile = JSON.parse(content);
                            return cachedProfile;
                        } catch (e) {
                            log("[-] Error parsing player profile JSON from FALLBACK_PATH: " + e.message);
                        }
                    }
                }
                return null;
            }

            // Function to setup and initialize UserControl.Me in native memory
            var userControlOpenPtr = baseAddr.add(0xAAB0D4);
            var notifyUserDataPtr = baseAddr.add(0xAAC39C);
            var playerCtorPtr = baseAddr.add(0x113B7CC);
            var actionBoolInvokePtr = baseAddr.add(0x18DA934);
            var actionIntInvokePtr = baseAddr.add(0x18DDF3C);

            var userControlOpenFn = null;
            var notifyUserDataFn = null;
            var playerCtorFn = null;
            var actionBoolInvokeFn = null;
            var actionIntInvokeFn = null;

            try { userControlOpenFn = new NativeFunction(userControlOpenPtr, "void", ["pointer"]); } catch (e) {}
            try { notifyUserDataFn = new NativeFunction(notifyUserDataPtr, "void", []); } catch (e) {}
            try { playerCtorFn = new NativeFunction(playerCtorPtr, "void", ["pointer"]); } catch (e) {}
            try { actionBoolInvokeFn = new NativeFunction(actionBoolInvokePtr, "void", ["pointer", "bool"]); } catch (e) {}
            try { actionIntInvokeFn = new NativeFunction(actionIntInvokePtr, "void", ["pointer", "int"]); } catch (e) {}

            function setupUserControl(profile) {
                if (!profile) return;
                try {
                    log("[👤 USER] Initializing UserControl for: " + profile.nickname);

                    var domain = il2cpp_domain_get ? il2cpp_domain_get() : NULL;
                    if (domain && !domain.isNull() && il2cpp_thread_attach) {
                        try { il2cpp_thread_attach(domain); } catch (e) {}
                    }

                    var playerClass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.account", "Player");
                    if (!playerClass || playerClass.isNull()) {
                        playerClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.account", "Player");
                    }
                    log("[DEBUG USER] playerClass: " + playerClass);

                    var playerObj = (playerClass && !playerClass.isNull() && il2cpp_object_new) ? il2cpp_object_new(playerClass) : null;
                    if (!playerObj || playerObj.isNull()) {
                        log("[⚠️ USER] Allocating Player buffer in native memory...");
                        playerObj = Memory.alloc(0xB0);
                        if (playerClass && !playerClass.isNull()) {
                            playerObj.writePointer(playerClass);
                        }
                    }
                    log("[DEBUG USER] playerObj: " + playerObj);

                    if (playerCtorFn) {
                        try { playerCtorFn(playerObj); } catch (e) {}
                    }

                    // Populate fields
                    // objectID: long at 0x10
                    playerObj.add(0x10).writeInt(profile.userId || 10001);
                    playerObj.add(0x14).writeInt(0);

                    // nickname: string at 0x18
                    var nickStr = createIl2CppString(profile.nickname || "Orbit");
                    playerObj.add(0x18).writePointer(nickStr);

                    // specialUserCode: short at 0x20
                    playerObj.add(0x20).writeShort(0);

                    // userType: int at 0x24 (0 = Guest)
                    playerObj.add(0x24).writeInt(0);

                    // profileCode: Nullable<int> at 0x28 (value at 0x28, hasValue at 0x2C)
                    playerObj.add(0x28).writeInt(profile.profileCode || 1001);
                    playerObj.add(0x2C).writeU8(1);

                    // leaderCard: LeaderCard at 0x30
                    try {
                        var leaderClass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.account", "LeaderCard");
                        if (!leaderClass || leaderClass.isNull()) {
                            leaderClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.account", "LeaderCard");
                        }
                        var leaderObj = (leaderClass && !leaderClass.isNull() && il2cpp_object_new) ? il2cpp_object_new(leaderClass) : null;
                        if (!leaderObj || leaderObj.isNull()) {
                            leaderObj = Memory.alloc(0x30);
                            if (leaderClass && !leaderClass.isNull()) {
                                leaderObj.writePointer(leaderClass);
                            }
                        }
                        var lInfo = profile.leaderCard || { cardID: 10001, grade: 4, level: 50 };
                        leaderObj.add(0x10).writeInt(lInfo.cardID || 10001);
                        leaderObj.add(0x14).writeInt(lInfo.grade !== undefined ? lInfo.grade : 4);
                        leaderObj.add(0x18).writeShort(lInfo.level || 50);
                        playerObj.add(0x30).writePointer(leaderObj);
                    } catch (e) {
                        log("[-] Error initializing LeaderCard: " + e.message);
                    }

                    // cardInvenExpandCount: int at 0x44
                    playerObj.add(0x44).writeInt(0);
                    // maxCardInvenCount: int at 0x48
                    playerObj.add(0x48).writeInt(profile.cardInvenMax || 200);

                    // diamond: int at 0x4C, freeDiamond: int at 0x50
                    playerObj.add(0x4C).writeInt(profile.diamond !== undefined ? profile.diamond : 10000);
                    playerObj.add(0x50).writeInt(0);

                    // rhythmPoint: int at 0x54, freeRhythmPoint: int at 0x58
                    playerObj.add(0x54).writeInt(profile.rhythmPoint !== undefined ? profile.rhythmPoint : 100000);
                    playerObj.add(0x58).writeInt(0);

                    // headphone: int at 0x5C, freeHeadphone: int at 0x60
                    playerObj.add(0x5C).writeInt(profile.headphone !== undefined ? profile.headphone : 50);
                    playerObj.add(0x60).writeInt(0);

                    // dalcomCoin: int at 0x70, freeDalcomCoin: int at 0x74
                    playerObj.add(0x70).writeInt(profile.dalcomCoin !== undefined ? profile.dalcomCoin : 5000);
                    playerObj.add(0x74).writeInt(0);

                    // Invoke UserControl.Open(player) (RVA 0xAAB0D4)
                    if (userControlOpenFn) {
                        userControlOpenFn(playerObj);
                        log("[✅ USER] UserControl.Open(player) executed successfully!");
                    }

                    // Invoke UserControl.NotifyUserData() (RVA 0xAAC39C)
                    if (notifyUserDataFn) {
                        notifyUserDataFn();
                        log("[📢 USER] UserControl.NotifyUserData() executed successfully!");
                    }
                } catch (e) {
                    log("[-] Error in setupUserControl: " + e.message);
                }
            }

            // Hook UserControl.get_Me (0xAAC818) to ensure non-null return value
            try {
                Interceptor.attach(baseAddr.add(0xAAC818), {
                    onLeave: function (retval) {
                        if (retval.isNull()) {
                            log("[🛡️ NULL GUARD] UserControl.get_Me returned null! Re-initializing UserControl...");
                            var p = loadPlayerProfile() || createDefaultProfile("Orbit");
                            setupUserControl(p);
                        }
                    }
                });
            } catch (eMeHook) {}

            // UserControl.Prefs.ConvertKey (0xD723E0) - Return key directly to prevent startup NullReferenceException
            try {
                Interceptor.replace(baseAddr.add(0xD723E0), new NativeCallback(function (keyPtr) {
                    return keyPtr;
                }, "pointer", ["pointer"]));
                log("[🛡️ PREFS GUARD] UserControl.Prefs.ConvertKey safely protected!");
            } catch (eKey) {}

            // UserControl.get_ObjectID (0xAAE33C) & get_LastLoginTime (0xAAE40C) null guards
            try {
                Interceptor.replace(baseAddr.add(0xAAE33C), new NativeCallback(function () {
                    return ptr(10001);
                }, "pointer", []));
                Interceptor.replace(baseAddr.add(0xAAE40C), new NativeCallback(function () {
                    return ptr(0);
                }, "pointer", []));
                log("[🛡️ USER GUARD] UserControl.ObjectID & LastLoginTime safely protected!");
            } catch (eUserG) {}

            // TitleScene Hooks
            var requestSequentialLoginPtr = baseAddr.add(0xB23630);
            var titleSceneSetStateMainPtr = baseAddr.add(0xB243BC);
            var titleSceneExcuteLoginPtr = baseAddr.add(0xB23774);
            var titleSceneSetStateGuestLoginPtr = baseAddr.add(0xB222F4);
            var titleSceneSetStateLoginAutoPtr = baseAddr.add(0xB241C8);

            var setStateMainFn = null;
            var setStateGuestLoginFn = null;
            try { setStateMainFn = new NativeFunction(titleSceneSetStateMainPtr, "void", ["pointer"]); } catch (e) {}
            try { setStateGuestLoginFn = new NativeFunction(titleSceneSetStateGuestLoginPtr, "void", ["pointer"]); } catch (e) {}

            Interceptor.attach(requestSequentialLoginPtr, {
                onEnter: function (args) {
                    log("[🔐 LOGIN] TitleScene.RequestSequentialLogin called");
                    var cb = args[1];
                    if (!cb.isNull() && actionInvokeFn) {
                        try {
                            actionInvokeFn(cb, ptr(0));
                            log("[🔐 LOGIN] RequestSequentialLogin callback invoked!");
                        } catch (e) {
                            log("[-] Error invoking sequential callback: " + e.message);
                        }
                    }
                }
            });

            function dismissFade() {
                try {
                    var fadeSetIsActiveFn = new NativeFunction(baseAddr.add(0xD2EBA8), "void", ["int"]);
                    fadeSetIsActiveFn(0);
                    var fadeCloseFn = new NativeFunction(baseAddr.add(0xD2FAB4), "void", []);
                    fadeCloseFn();
                    var fadeCompleteFn = new NativeFunction(baseAddr.add(0xD2FC20), "void", []);
                    fadeCompleteFn();
                    var fadePurgeFn = new NativeFunction(baseAddr.add(0xD2F078), "void", []);
                    fadePurgeFn();
                    var fadeStopFn = new NativeFunction(baseAddr.add(0xD2FD24), "void", []);
                    fadeStopFn();
                    log("[🛡️ FADE DISMISSED] Fade closed & purged!");
                } catch (e) {
                    log("[-] Error dismissing Fade: " + e.message);
                }
            }

            var openNickPopupFn = null;
            try {
                openNickPopupFn = new NativeFunction(baseAddr.add(0xDAD928), "void", ["pointer", "pointer"]);
            } catch (e) {
                log("[-] Error resolving OpenNicknameInputPopup: " + e.message);
            }

            // Diagnostic & flow hooks for Nickname Input
            try {
                Interceptor.attach(baseAddr.add(0xDAD59C), {
                    onEnter: function (args) {
                        log("[🔍 AUTH FLOW] CreateUserAssist.Open called | cb: " + args[0] + " | provider: " + args[1].toInt32());
                    }
                });
                // Replace CreateUserAssist.Start to bypass warning notice and open InputPopup directly
                Interceptor.replace(baseAddr.add(0xDAD69C), new NativeCallback(function (assistThiz, cbPtr, provider, snsPlatform, idTokenPtr) {
                    log("[🔍 AUTH FLOW] CreateUserAssist.Start intercepted! Setting fields and opening Nickname InputPopup directly...");
                    assistThiz.add(0x10).writePointer(cbPtr);
                    assistThiz.add(0x18).writeInt(provider);
                    assistThiz.add(0x1C).writeInt(snsPlatform);
                    assistThiz.add(0x20).writePointer(idTokenPtr);

                    dismissFade();

                    if (openNickPopupFn) {
                        try {
                            var emptyStr = createIl2CppString("");
                            openNickPopupFn(assistThiz, emptyStr);
                            log("[🎉 NICKNAME POPUP] CreateUserAssist.OpenNicknameInputPopup called directly!");
                        } catch (e) {
                            log("[-] Error calling OpenNicknameInputPopup: " + e.message);
                        }
                    }
                }, "void", ["pointer", "pointer", "int", "int", "pointer"]));

                Interceptor.attach(baseAddr.add(0xDAD928), {
                    onEnter: function (args) {
                        log("[🔍 AUTH FLOW] CreateUserAssist.OpenNicknameInputPopup called!");
                    }
                });
                var activeInputPopup = null;
                var setInputStringFn = null;
                var setBtnOkEnableFn = null;
                var setBtnOkVisibleFn = null;
                try {
                    setInputStringFn = new NativeFunction(baseAddr.add(0xF15BE0), "void", ["pointer", "pointer"]);
                    setBtnOkEnableFn = new NativeFunction(baseAddr.add(0x1149EC4), "void", ["pointer", "int"]);
                    setBtnOkVisibleFn = new NativeFunction(baseAddr.add(0x11494B8), "void", ["pointer", "int"]);
                } catch (e) {}

                // Replace OpenNicknameConfirmPopup to directly accept the entered nickname without extra redundant dialogs
                Interceptor.replace(baseAddr.add(0xDADD20), new NativeCallback(function (assistThiz, inputPopup) {
                    log("[🔍 CONFIRM] OpenNicknameConfirmPopup intercepted on inputPopup: " + inputPopup);
                    var nickStr = "Orbit";
                    if (!inputPopup.isNull()) {
                        try {
                            var getStrFn = new NativeFunction(baseAddr.add(0xF15D04), "pointer", ["pointer"]);
                            var nickPtr = getStrFn(inputPopup);
                            var readNick = readIl2CppString(nickPtr);
                            if (readNick && readNick.trim() !== "") {
                                nickStr = readNick.trim();
                            }
                            log("[🎉 NICKNAME INPUT] User confirmed nickname from popup: '" + nickStr + "'!");
                        } catch (e) {
                            log("[-] Error reading nickname string: " + e.message);
                        }
                        try {
                            var closePopupFn = new NativeFunction(baseAddr.add(0x114247C), "void", ["pointer"]);
                            closePopupFn(inputPopup);
                            log("[🚪 POPUP] InputPopup closed cleanly!");
                        } catch (e) {
                            log("[-] Error closing input popup: " + e.message);
                        }
                    }

                    // Save and setup profile offline
                    var newProfile = createDefaultProfile(nickStr);
                    savePlayerProfile(newProfile);
                    setupUserControl(newProfile);

                    dismissFade();

                    // Transition to TitleScene.SetStateMain directly without calling unsafe CreateUserAssist.Complete
                    if (globalTitleScene && !globalTitleScene.isNull()) {
                        try {
                            log("[🌟 TRANSITION] Invoking TitleScene.SetStateMain directly after nickname confirmation...");
                            if (setStateMainFn) {
                                setStateMainFn(globalTitleScene);
                                log("[🌟 SUCCESS] TitleScene.SetStateMain dispatched successfully!");
                            } else {
                                var mainFn = new NativeFunction(baseAddr.add(0xB243BC), "void", ["pointer"]);
                                mainFn(globalTitleScene);
                                log("[🌟 SUCCESS] TitleScene.SetStateMain invoked directly via NativeFunction!");
                            }
                        } catch (e) {
                            log("[-] Error transitioning to TitleScene.SetStateMain: " + e.message);
                        }
                    } else {
                        log("[-] globalTitleScene is null during confirm!");
                    }
                }, "void", ["pointer", "pointer"]));

                // Hook InputPopup.OnCheckEmpty (RVA 0xF16C70) - called on main thread whenever text is checked or updated
                var hasPrefilled = false;
                Interceptor.attach(baseAddr.add(0xF16C70), {
                    onEnter: function (args) {
                        var thiz = args[0];
                        activeInputPopup = thiz;
                        var textPtr = args[1];
                        var text = readIl2CppString(textPtr);
                        if ((!text || text.trim() === "") && !hasPrefilled) {
                            hasPrefilled = true;
                            log("[✨ PREFILL] Setting initial nickname 'Orbit' on main thread in OnCheckEmpty...");
                            try {
                                var setInputStrFn = new NativeFunction(baseAddr.add(0xF15BEC), "void", ["pointer", "int", "pointer"]);
                                var defNickIl2Cpp = createIl2CppString("Orbit");
                                setInputStrFn(thiz, 0, defNickIl2Cpp);

                                var setOkVisFn = new NativeFunction(baseAddr.add(0x11494B8), "void", ["pointer", "int"]);
                                setOkVisFn(thiz, 1);

                                var setOkEnFn = new NativeFunction(baseAddr.add(0x1149EC4), "void", ["pointer", "int"]);
                                setOkEnFn(thiz, 1);
                                log("[✨ PREFILL] Default nickname 'Orbit' pre-filled and OK button enabled cleanly!");
                            } catch (e) {
                                log("[-] Error prefilling in OnCheckEmpty: " + e.message);
                            }
                            try {
                                var btnOkCache = thiz.add(0xC8).readPointer();
                                if (!btnOkCache.isNull()) {
                                    var btn = btnOkCache.add(0x48).readPointer();
                                    if (!btn.isNull()) {
                                        var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                        var btnGo = getGoFn(btn, NULL);
                                        var getTransFn = new NativeFunction(baseAddr.add(0x1DBADB0), "pointer", ["pointer", "pointer"]);
                                        var trans = getTransFn(btnGo, NULL);
                                        var getPosFn = new NativeFunction(baseAddr.add(0x1DB64F4), "void", ["pointer", "pointer", "pointer"]);
                                        var posBuf = Memory.alloc(12);
                                        getPosFn(trans, posBuf, NULL);
                                        log("[📍 BUTTON POS] btnOk world position: X=" + posBuf.readFloat() + ", Y=" + posBuf.add(4).readFloat() + ", Z=" + posBuf.add(8).readFloat());
                                    }
                                }
                            } catch (ePos) {
                                log("[-] Error getting button position: " + ePos.message);
                            }
                        }
                    }
                });

                Interceptor.attach(baseAddr.add(0xAAA0D0), {
                    onEnter: function (args) {
                        this.pName = readIl2CppString(args[0]);
                        log("[🔍 POPUP] UIHelper.OpenPopup called for popup: '" + this.pName + "'");
                        if (this.pName === "System/Popup_Input_1Btn" && !args[1].isNull()) {
                            var pParams = args[1];
                            try {
                                pParams.add(0x18).writePointer(createIl2CppString("NICKNAME"));
                                pParams.add(0x20).writePointer(createIl2CppString("Enter your Nickname:"));
                                pParams.add(0x48).writePointer(createIl2CppString("OK"));
                                log("[✨ POPUP PARAMS] Injected title='NICKNAME', message, and btnOkText='OK' into Popup.Params!");
                            } catch (eParam) {
                                log("[-] Error injecting Popup.Params: " + eParam.message);
                            }
                        }
                    }
                });
            } catch (e) {
                log("[-] Error attaching auth hooks: " + e.message);
            }

            Interceptor.replace(titleSceneExcuteLoginPtr, new NativeCallback(function (thiz) {
                globalTitleScene = thiz;
                log("[🎉 TITLE SCENE] TitleScene.ExcuteLogin intercepted on thread: " + Process.getCurrentThreadId());
                dismissFade();
                var profile = loadPlayerProfile();
                if (profile && profile.nickname) {
                    log("[👤 OFFLINE LOGIN] Existing profile detected for '" + profile.nickname + "'. Performing Auto-login...");
                    setupUserControl(profile);
                    if (setStateMainFn && !thiz.isNull()) {
                        try {
                            setStateMainFn(thiz);
                            log("[🌟 TITLE SCENE] Auto-login complete -> TitleScene.SetStateMain dispatched!");
                        } catch (e) {
                            log("[-] Error in SetStateMain: " + e.message);
                        }
                    }
                } else {
                    log("[🆕 OFFLINE LOGIN] No profile found! Triggering native Guest Login popup synchronously...");
                    if (setStateGuestLoginFn && !thiz.isNull()) {
                        try {
                            setStateGuestLoginFn(thiz);
                            log("[✨ TITLE SCENE] TitleScene.SetStateGuestLogin dispatched cleanly!");
                        } catch (e) {
                            log("[-] Error in SetStateGuestLogin: " + e.message);
                            var defProfile = createDefaultProfile("Orbit");
                            savePlayerProfile(defProfile);
                            setupUserControl(defProfile);
                            if (setStateMainFn) setStateMainFn(thiz);
                        }
                    } else {
                        log("[-] setStateGuestLoginFn is null, falling back to default profile...");
                        var defProfile = createDefaultProfile("Orbit");
                        savePlayerProfile(defProfile);
                        setupUserControl(defProfile);
                        if (setStateMainFn) setStateMainFn(thiz);
                    }
                }
            }, "void", ["pointer"]));

            // Hook CreateUserAssist.CreateAuthentication (RVA 0xDADFE8)
            // Interceptor.replace to completely block network RPC calls to Dalcom servers
            var createAuthPtr = baseAddr.add(0xDADFE8);
            Interceptor.replace(createAuthPtr, new NativeCallback(function (assistThiz, nickPtr, cbPtr) {
                var enteredNick = readIl2CppString(nickPtr);
                if (!enteredNick || enteredNick.trim() === "") {
                    enteredNick = "Orbit";
                }
                log("[🎉 NICKNAME INPUT] User confirmed nickname from popup: '" + enteredNick + "'!");

                var newProfile = createDefaultProfile(enteredNick);
                savePlayerProfile(newProfile);
                setupUserControl(newProfile);

                if (!cbPtr.isNull() && actionBoolInvokeFn) {
                    try {
                        actionBoolInvokeFn(cbPtr, 1);
                        log("[✅ AUTH] CreateAuthentication callback(true) invoked cleanly!");
                    } catch (e) {
                        log("[-] Error invoking callback: " + e.message);
                    }
                }
            }, "void", ["pointer", "pointer", "pointer"]));

            // Hook TitleScene.SetStateLoginAuto (RVA 0xB241C8)
            Interceptor.attach(titleSceneSetStateLoginAutoPtr, {
                onEnter: function (args) {
                    var thiz = args[0];
                    globalTitleScene = thiz;
                    log("[🔄 LOGIN AUTO] TitleScene.SetStateLoginAuto called -> transitioning to SetStateMain");
                    var profile = loadPlayerProfile();
                    if (!profile) {
                        profile = createDefaultProfile("Orbit");
                        savePlayerProfile(profile);
                    }
                    setupUserControl(profile);
                    if (setStateMainFn && !thiz.isNull()) {
                        setTimeout(function () {
                            try {
                                setStateMainFn(thiz);
                                log("[🌟 TITLE SCENE] TitleScene.SetStateMain dispatched from SetStateLoginAuto!");
                            } catch (e) {
                                log("[-] Error in SetStateMain: " + e.message);
                            }
                        }, 200);
                    }
                }
            });

            // Failsafes and reactive persistence
            try {
                // LoginControl.IsAccountExists (0xCF6834)
                Interceptor.attach(baseAddr.add(0xCF6834), {
                    onLeave: function (retval) {
                        if (loadPlayerProfile()) {
                            retval.replace(ptr(1));
                        }
                    }
                });

                // LoginControl.IsLogined (0xCF6F20)
                Interceptor.attach(baseAddr.add(0xCF6F20), {
                    onLeave: function (retval) {
                        if (loadPlayerProfile()) {
                            retval.replace(ptr(1));
                        }
                    }
                });

                // LoginControl.IsGuest (0xCF6E28)
                Interceptor.attach(baseAddr.add(0xCF6E28), {
                    onLeave: function (retval) {
                        retval.replace(ptr(1));
                    }
                });

                // UserControl.IsOpened (0xAAADEC)
                Interceptor.attach(baseAddr.add(0xAAADEC), {
                    onLeave: function (retval) {
                        if (loadPlayerProfile()) {
                            retval.replace(ptr(1));
                        }
                    }
                });

                // NetworkStatusCheck.CheckStatus (0xC09598) & GetNetworkType (0xC096E8)
                // Use Interceptor.replace to completely bypass the crashing JNI NewRef call in Android
                Interceptor.replace(baseAddr.add(0xC09598), new NativeCallback(function () {
                    return 1; // Always online (true)
                }, "bool", []));
                Interceptor.replace(baseAddr.add(0xC096E8), new NativeCallback(function () {
                    return 1; // 1 = WIFI
                }, "int", []));

                // In-game Nickname change: UserControl.ChangeNickname (0xAAEB4C)
                Interceptor.attach(baseAddr.add(0xAAEB4C), {
                    onEnter: function (args) {
                        var newNick = readIl2CppString(args[0]);
                        var cb = args[1];
                        log("[✏️ NICKNAME] UserControl.ChangeNickname called with: " + newNick);
                        if (newNick && newNick.trim() !== "") {
                            var p = loadPlayerProfile() || createDefaultProfile("Orbit");
                            p.nickname = newNick;
                            savePlayerProfile(p);
                            setupUserControl(p);
                        }
                        if (!cb.isNull() && actionIntInvokeFn) {
                            try {
                                actionIntInvokeFn(cb, 0); // 0 = SUCCESS
                                log("[✅ NICKNAME] ChangeNickname callback(0) invoked!");
                            } catch (e) {}
                        }
                    }
                });

                // In-game Profile Picture change: UserControl.set_ProfileCode (0xAAF588)
                Interceptor.attach(baseAddr.add(0xAAF588), {
                    onEnter: function (args) {
                        var newCode = args[0].toInt32();
                        log("[🖼️ PROFILE] UserControl.set_ProfileCode called with: " + newCode);
                        var p = loadPlayerProfile() || createDefaultProfile("Orbit");
                        p.profileCode = newCode;
                        savePlayerProfile(p);
                    }
                });
            } catch (e) {
                log("[-] Error attaching failsafe hooks: " + e.message);
            }

            // 3. ImageMerger protection
            var imgMerger32Ptr = baseAddr.add(0xBAEC88);
            var imgMerger24Ptr = baseAddr.add(0xBAED3C);
            var imgMergerAlphaPtr = baseAddr.add(0xBAEDF0);
            Interceptor.replace(imgMerger32Ptr, new NativeCallback(function (c, cw, x, y, w, h, cs, sx, sy, sw) { return c; }, "pointer", ["pointer", "int", "int", "int", "int", "int", "pointer", "int", "int", "int"]));
            Interceptor.replace(imgMerger24Ptr, new NativeCallback(function (c, cw, x, y, w, h, cs, sx, sy, sw) { return c; }, "pointer", ["pointer", "int", "int", "int", "int", "int", "pointer", "int", "int", "int"]));
            Interceptor.replace(imgMergerAlphaPtr, new NativeCallback(function (c, cw, x, y, w, h, cs, sx, sy, sw) { return c; }, "pointer", ["pointer", "int", "int", "int", "int", "int", "pointer", "int", "int", "int"]));
            log("[+] ImageMerger protected");

            // 4. ApiExcept bypass
            var apiExceptOpenPtr = baseAddr.add(0x11162C4);
            var apiExceptHandlerPtr = baseAddr.add(0x1116314);
            var apiExceptCodePtr = baseAddr.add(0x1116364);
            Interceptor.replace(apiExceptOpenPtr, new NativeCallback(function () {}, "void", []));
            Interceptor.replace(apiExceptHandlerPtr, new NativeCallback(function (h) {}, "void", ["pointer"]));
            Interceptor.replace(apiExceptCodePtr, new NativeCallback(function (c, cb) {
                try {
                    if (!cb.isNull()) {
                        var invokePtr = cb.add(Process.pointerSize * 2).readPointer();
                        if (!invokePtr.isNull()) {
                            var invokeFn = new NativeFunction(invokePtr, "void", ["pointer"]);
                            invokeFn(cb);
                        }
                    }
                } catch (e) {}
            }, "void", ["int", "pointer"]));
            log("[+] ApiExcept bypassed");

            // 4. dalcomsoft JObject.get_Item bypass
            var jObjectGetItemPtr = baseAddr.add(0x10B1BB0);
            Interceptor.attach(jObjectGetItemPtr, {
                onEnter: function (args) {
                    try {
                        var propName = readIl2CppString(args[1]);
                        this.prop = propName;
                    } catch (e) {}
                },
                onLeave: function (retval) {
                    if (this.prop && retval.isNull()) {
                        log("[⚠️ JSON LOOKUP NULL] Property '" + this.prop + "' was NULL in JObject!");
                    }
                }
            });
            log("[+] JObject.get_Item monitored for null properties");

            // 6. UnityWebRequest HTTPS -> HTTP Universal Rewriter
            function rewriteUrlArg(args, index) {
                try {
                    if (args[index] && !args[index].isNull()) {
                        var u = readIl2CppString(args[index]);
                        if (u) {
                            var newU = u;
                            if (newU.indexOf("https://") === 0) {
                                newU = newU.replace("https://", "http://");
                            }
                            if (newU.indexOf("/api") !== -1 || newU.indexOf("dalcomsoft.net") !== -1 || newU.indexOf("amazonaws.com") !== -1) {
                                if (newU.indexOf(":8000") === -1) {
                                    newU = newU.replace(/http:\/\/[^\/]*dalcomsoft\.net/g, "http://10.0.2.2:8000");
                                    newU = newU.replace(/http:\/\/[^\/]*amazonaws\.com/g, "http://10.0.2.2:8000");
                                }
                            }
                            if (newU !== u) {
                                args[index] = createIl2CppString(newU);
                                log("[🌐 URL REWRITE] " + u + " -> " + newU);
                            } else {
                                log("[🌐 UWR REQ] " + u);
                            }
                        }
                    }
                } catch (e) {}
            }

            var uwrCtor1 = baseAddr.add(0x254FCA4);
            var uwrCtor2 = baseAddr.add(0x254FF4C);
            var uwrSetUrl = baseAddr.add(0x254FD24);
            var uwrInternalSetUrl = baseAddr.add(0x2550E08);

            Interceptor.attach(uwrCtor1, { onEnter: function (args) { rewriteUrlArg(args, 1); } });
            Interceptor.attach(uwrCtor2, { onEnter: function (args) { rewriteUrlArg(args, 1); } });
            Interceptor.attach(uwrSetUrl, { onEnter: function (args) { rewriteUrlArg(args, 1); } });
            Interceptor.attach(uwrInternalSetUrl, { onEnter: function (args) { rewriteUrlArg(args, 1); } });
            log("[+] UnityWebRequest HTTPS -> HTTP rewriters active");

            // 2.6 Client Configuration & RPC Monitoring
            try {
                var clientClassPtr = baseAddr.add(0x3118AE8).readPointer();
                if (!clientClassPtr.isNull()) {
                    var staticFields = clientClassPtr.add(0xB8).readPointer();
                    if (!staticFields.isNull()) {
                        // Force endpoint to 10.0.2.2:8000/api
                        staticFields.add(0x8).writePointer(createIl2CppString("http://10.0.2.2:8000/api"));
                        // Disable encryption and decryption so it uses plain JSON
                        staticFields.add(0x10).writeU8(0);
                        staticFields.add(0x11).writeU8(0);
                        log("[🔧 CLIENT CONFIG] Client.endpoint forced to http://10.0.2.2:8000/api | isEncrypted=0, isDecrypted=0");
                    }
                }
            } catch (e) {
                log("[-] Error configuring Client static fields: " + e.message);
            }

            var clientRequestPtr = baseAddr.add(0xC4BB60);
            Interceptor.attach(clientRequestPtr, {
                onEnter: function (args) {
                    try {
                        var clazz = readIl2CppString(args[3]);
                        var method = readIl2CppString(args[4]);
                        log("[📡 CLIENT RPC] -> Clazz: " + clazz + " | Method: " + method);

                        var clientClassSlot = baseAddr.add(0x3138358).readPointer();
                        if (!clientClassSlot.isNull()) {
                            var staticFields = clientClassSlot.add(0xB8).readPointer();
                            if (!staticFields.isNull()) {
                                staticFields.add(0x8).writePointer(createIl2CppString("http://10.0.2.2:8000/api"));
                                staticFields.add(0x10).writeU8(0); // isEncrypted = false
                                staticFields.add(0x11).writeU8(0); // isDecrypted = false
                            }
                        }
                    } catch (e) {}
                }
            });

            // 2.7 Account.<createAuthentication>b__0 bypass (RVA 0xCE7FC8)
            var createAuthCbPtr = baseAddr.add(0xCE7FC8);
            Interceptor.replace(createAuthCbPtr, new NativeCallback(function (displayClass, handle) {
                log("[🚀 AUTH] Account.<createAuthentication>b__0 invoked!");
                try {
                    var authClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.account", "Authentication");
                    if (authClass && !authClass.isNull()) {
                        var authObj = il2cpp_object_new(authClass);
                        var authCtor = new NativeFunction(baseAddr.add(0xE92BDC), 'void', ['pointer']);
                        authCtor(authObj);
                        authObj.add(0x10).writeU64(100001); // userObjectID
                        authObj.add(0x18).writeU32(0);      // provider = 0 (Guest)
                        authObj.add(0x20).writePointer(createIl2CppString("guest_orbit")); // userID
                        authObj.add(0x28).writePointer(createIl2CppString("password123")); // localPassword

                        var cb = displayClass.add(0x10).readPointer();
                        if (!cb.isNull()) {
                            var methodInfoSlot = baseAddr.add(0x311F048).readPointer();
                            var methodInfo = methodInfoSlot.isNull() ? ptr(0) : methodInfoSlot.readPointer();
                            var invokeFn = new NativeFunction(baseAddr.add(0x18F0A98), "void", ["pointer", "pointer", "pointer", "pointer"]);
                            invokeFn(cb, handle, authObj, methodInfo);
                            log("[🌟 SUCCESS] Invoked createAuthentication callback cleanly with valid Authentication!");
                        }
                    }
                } catch (e) {
                    log("[-] Error in createAuthentication callback bypass: " + e.message);
                }
            }, "void", ["pointer", "pointer"]));

            // 2.8 NetworkHandler.onComplete status protection
            var networkHandlerOnCompletePtr = baseAddr.add(0x1025648);
            Interceptor.attach(networkHandlerOnCompletePtr, {
                onEnter: function (args) {
                    try {
                        var handle = args[0];
                        if (!handle.isNull()) {
                            var request = handle.add(0x38).readPointer();
                            var clazz = "";
                            var method = "";
                            if (!request.isNull()) {
                                clazz = readIl2CppString(request.add(0x28).readPointer());
                                method = readIl2CppString(request.add(0x30).readPointer());
                            }
                            var www = handle.add(0x10).readPointer();
                            var resp = handle.add(0x20).readPointer();
                            log("[📥 ON_COMPLETE] " + clazz + "." + method + " | www: " + www + " | resp: " + resp);
                            if (!resp.isNull()) {
                                handle.add(0x18).writeU32(1);
                            } else {
                                handle.add(0x18).writeU32(0); // Do NOT force success on null response
                            }
                        }
                    } catch (e) {}
                }
            });

            // 2.8 NetworkHandler.isSuccess safe check (RVA 0x1024FC8)
            var networkHandlerIsSuccessPtr = baseAddr.add(0x1024FC8);
            Interceptor.replace(networkHandlerIsSuccessPtr, new NativeCallback(function (handle) {
                if (handle.isNull()) return 0;
                var resp = handle.add(0x20).readPointer();
                if (resp.isNull()) {
                    return 0; // Null response must return 0 to prevent NullReferenceException in deserializers
                }
                var status = handle.add(0x18).readU32();
                return (status === 1) ? 1 : 0;
            }, "int", ["pointer"]));
            log("[+] NetworkHandler.isSuccess null-safe check active");

            // Guard non-essential lobby RPC commands that expect complex online responses
            var bypassedRpcMethods = [
                { rva: 0xCC8678, name: "Mission.getMissionList", retNull: true },
                { rva: 0xCC88C4, name: "Mission.getEventMissionList", retNull: true },
                { rva: 0xDF04D4, name: "Promotion.getAdminInfo", retNull: true },
                { rva: 0xDF0F74, name: "Promotion.getGMEvent", retNull: true },
                { rva: 0x1223704, name: "ADControl.GetAdminInfo", retNull: false },
                { rva: 0xD11660, name: "StarPass.getPassStatus", retNull: true },
                { rva: 0xD11B48, name: "StarPass.getMissionList", retNull: true }
            ];

            var rpcLogCounts = {};
            bypassedRpcMethods.forEach(function (rpc) {
                try {
                    var p = baseAddr.add(rpc.rva);
                    if (rpc.retNull) {
                        Interceptor.replace(p, new NativeCallback(function () {
                            var cnt = (rpcLogCounts[rpc.name] || 0) + 1;
                            rpcLogCounts[rpc.name] = cnt;
                            if (cnt <= 2) {
                                log("[🛡️ RPC BYPASS] " + rpc.name + " cleanly bypassed (returned NULL)!");
                            }
                            return NULL;
                        }, "pointer", ["pointer", "pointer"]));
                    } else {
                        Interceptor.replace(p, new NativeCallback(function () {
                            var cnt = (rpcLogCounts[rpc.name] || 0) + 1;
                            rpcLogCounts[rpc.name] = cnt;
                            if (cnt <= 2) {
                                log("[🛡️ RPC BYPASS] " + rpc.name + " cleanly bypassed (void)!");
                            }
                            return;
                        }, "void", ["pointer", "pointer"]));
                    }
                } catch (e) {
                    log("[-] Error bypassing " + rpc.name + ": " + e.message);
                }
            });

            // 2.9 AssetDownloader.CheckAssetBundleCallback monitor & safety (RVA 0xAE3200)
            var checkAssetBundleCallbackPtr = baseAddr.add(0xAE3200);
            Interceptor.attach(checkAssetBundleCallbackPtr, {
                onEnter: function (args) {
                    try {
                        var assetDownloader = args[0];
                        var handle = args[1];
                        var context = args[2];
                        log("[📦 ASSET] CheckAssetBundleCallback called | context: " + context);
                        if (context.isNull()) {
                            var assetContextClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "AssetContext");
                            if (assetContextClass && !assetContextClass.isNull()) {
                                var assetContextObj = il2cpp_object_new(assetContextClass);
                                var assetContextCtor = new NativeFunction(baseAddr.add(0xAD7468), 'void', ['pointer']);
                                assetContextCtor(assetContextObj);
                                assetContextObj.add(0x10).writeU32(23); // version = 23
                                args[2] = assetContextObj;
                                log("[🌟 SUCCESS] Replaced null context with clean local AssetContext (v23)!");
                            }
                        }
                    } catch (e) {
                        log("[-] Error in CheckAssetBundleCallback hook: " + e.message);
                    }
                }
            });

            // 2.10 AssetDownloader.CreateDownloadList safety guard (RVA 0xAE90C8)
            var createDownloadListPtr = baseAddr.add(0xAE90C8);
            Interceptor.attach(createDownloadListPtr, {
                onEnter: function (args) {
                    try {
                        var assetDownloader = args[0];
                        if (!assetDownloader.isNull()) {
                            var ctx = assetDownloader.add(0x30).readPointer();
                            if (ctx.isNull()) {
                                var assetContextClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "AssetContext");
                                if (assetContextClass && !assetContextClass.isNull()) {
                                    var assetContextObj = il2cpp_object_new(assetContextClass);
                                    var assetContextCtor = new NativeFunction(baseAddr.add(0xAD7468), 'void', ['pointer']);
                                    assetContextCtor(assetContextObj);
                                    assetContextObj.add(0x10).writeU32(23);
                                    assetDownloader.add(0x30).writePointer(assetContextObj);
                                    log("[🌟 SUCCESS] Ensured AssetDownloader._assetContext is non-null before CreateDownloadList!");
                                }
                            }
                        }
                    } catch (e) {
                        log("[-] Error in createDownloadList hook: " + e.message);
                    }
                }
            });
            log("[+] AssetDownloader safety guards active");

            // 2.10b AssetDownloader.<DownLoadAssetContext>d__62.MoveNext universal completion (RVA 0xB8827C)
            var downloadAssetContextMoveNextPtr = baseAddr.add(0xB8827C);
            Interceptor.replace(downloadAssetContextMoveNextPtr, new NativeCallback(function (sm) {
                log("[📦 ASSET] <DownLoadAssetContext>d__62.MoveNext intercepted -> completing immediately with true");
                try {
                    var assetDownloader = sm.add(0x20).readPointer();
                    if (!assetDownloader.isNull()) {
                        var assetContextClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "AssetContext");
                        if (assetContextClass && !assetContextClass.isNull()) {
                            var assetContextObj = il2cpp_object_new(assetContextClass);
                            var assetContextCtor = new NativeFunction(baseAddr.add(0xAD7468), 'void', ['pointer']);
                            assetContextCtor(assetContextObj);
                            assetContextObj.add(0x10).writeU32(23); // version = 23
                            assetDownloader.add(0x30).writePointer(assetContextObj); // _assetContext
                            assetDownloader.add(0x28).writeU8(1); // _isReceivePacket = true
                            log("[🌟 SUCCESS] Assigned local AssetContext (v23) to AssetDownloader._assetContext!");
                        }
                    }
                    var initMetadata = new NativeFunction(baseAddr.add(0xA43BE8), 'void', ['pointer']);
                    var methodInfoTable = baseAddr.add(0x30F3000).add(0xC90).readPointer();
                    initMetadata(methodInfoTable);
                    var methodInfo = methodInfoTable.readPointer();
                    var setResultFn = new NativeFunction(baseAddr.add(0x2175900), 'void', ['pointer', 'bool', 'pointer']);
                    setResultFn(sm.add(8), 1, methodInfo);
                    sm.writeS32(-2); // state = -2 (Done)
                    log("[🌟 SUCCESS] <DownLoadAssetContext>d__62.MoveNext successfully completed with true!");
                } catch (e) {
                    log("[-] Error in DownLoadAssetContext MoveNext: " + e.message);
                }
            }, "void", ["pointer"]));
            // 2.10c AssetDownloader.CreateDownloadList bypass (RVA 0xAE90C8)
            var createDownloadListPtr = baseAddr.add(0xAE90C8);
            Interceptor.replace(createDownloadListPtr, new NativeCallback(function (thiz) {
                log("[📦 ASSET] CreateDownloadList intercepted -> skipping download list creation (all files exist locally)");
            }, "void", ["pointer"]));
            log("[+] Patched CreateDownloadList bypass active");

            // 2.10d AssetDownloader.<DownloadAndParsingAssets>d__63.MoveNext universal completion (RVA 0xB88ACC)
            var downloadAndParsingAssetsMoveNextPtr = baseAddr.add(0xB88ACC);
            Interceptor.replace(downloadAndParsingAssetsMoveNextPtr, new NativeCallback(function (sm) {
                log("[📦 ASSET] <DownloadAndParsingAssets>d__63.MoveNext intercepted -> completing immediately with true");
                try {
                    var initMetadata = new NativeFunction(baseAddr.add(0xA43BE8), 'void', ['pointer']);
                    var methodInfoTable = baseAddr.add(0x30F3000).add(0xC90).readPointer();
                    initMetadata(methodInfoTable);
                    var methodInfo = methodInfoTable.readPointer();
                    var setResultFn = new NativeFunction(baseAddr.add(0x2175900), 'void', ['pointer', 'bool', 'pointer']);
                    setResultFn(sm.add(8), 1, methodInfo);
                    sm.writeS32(-2); // state = -2 (Done)
                    log("[🌟 SUCCESS] <DownloadAndParsingAssets>d__63.MoveNext successfully completed with true!");
                } catch (e) {
                    log("[-] Error in DownloadAndParsingAssets MoveNext: " + e.message);
                }
            }, "void", ["pointer"]));
            // 2.10e AssetDownloader.<FilterDownloadFirstPackingFile>d__68.MoveNext (RVA 0xB8AB1C)
            var filterDownloadFirstPackingFilePtr = baseAddr.add(0xB8AB1C);
            Interceptor.replace(filterDownloadFirstPackingFilePtr, new NativeCallback(function (sm) {
                log("[📦 ASSET] <FilterDownloadFirstPackingFile>d__68.MoveNext intercepted -> completing with true");
                try {
                    var initMetadata = new NativeFunction(baseAddr.add(0xA43BE8), 'void', ['pointer']);
                    var methodInfoTable = baseAddr.add(0x3113000).add(0xFE0).readPointer();
                    initMetadata(methodInfoTable);
                    var methodInfo = methodInfoTable.readPointer();
                    var setResultFn = new NativeFunction(baseAddr.add(0x2175900), 'void', ['pointer', 'bool', 'pointer']);
                    setResultFn(sm.add(8), 1, methodInfo);
                    sm.writeS32(-2);
                    log("[🌟 SUCCESS] <FilterDownloadFirstPackingFile>d__68.MoveNext completed with true!");
                } catch (e) {
                    log("[-] Error in FilterDownloadFirstPackingFile MoveNext: " + e.message);
                }
            }, "void", ["pointer"]));
            log("[+] Patched <FilterDownloadFirstPackingFile>d__68.MoveNext active");

            // 2.10f AssetDownloader.<FilterDownloadPathList>d__64.MoveNext (RVA 0xB8AF9C)
            var filterDownloadPathListPtr = baseAddr.add(0xB8AF9C);
            Interceptor.replace(filterDownloadPathListPtr, new NativeCallback(function (sm) {
                log("[📦 ASSET] <FilterDownloadPathList>d__64.MoveNext intercepted -> completing immediately");
                sm.writeS32(-2);
            }, "void", ["pointer"]));
            log("[+] Patched <FilterDownloadPathList>d__64.MoveNext active");

            // 2.10g AssetControl.<StartResourceDownload>d__77.MoveNext (RVA 0xB86134)
            var startResourceDownloadMoveNextPtr = baseAddr.add(0xB86134);
            Interceptor.replace(startResourceDownloadMoveNextPtr, new NativeCallback(function (sm) {
                log("[📦 ASSET] <StartResourceDownload>d__77.MoveNext intercepted -> invoking DownloadDone");
                try {
                    var downloadDoneFn = new NativeFunction(baseAddr.add(0xADA150), 'void', []);
                    downloadDoneFn();
                    sm.writeS32(-2);
                    var setResFn = new NativeFunction(baseAddr.add(0x1A75160), 'void', ['pointer']);
                    setResFn(sm.add(8));
                    log("[🌟 SUCCESS] StartResourceDownload successfully completed!");
                } catch (e) {
                    log("[-] Error in StartResourceDownload MoveNext: " + e.message);
                }
            }, "void", ["pointer"]));
            log("[+] Patched <StartResourceDownload>d__77.MoveNext active");

            // 2.10h LoginControl.get_IsLogin (RVA 0xCF6EF4)
            var isLoginPtr = baseAddr.add(0xCF6EF4);
            Interceptor.replace(isLoginPtr, new NativeCallback(function (thiz) {
                return 1;
            }, 'bool', ['pointer']));
            log("[+] Patched LoginControl.get_IsLogin active -> returns true");

            // 2.11 Diagnostic Hooks for AssetDownloader Flow & Global Exception Logger
            try {
                var il2cpp_format_exception = new NativeFunction(baseAddr.add(0x9C4B20), 'void', ['pointer', 'pointer', 'int']);
                var il2cpp_throw = baseAddr.add(0x9F3CB8);
                Interceptor.attach(il2cpp_throw, {
                    onEnter: function (args) {
                        try {
                            var ex = args[0];
                            if (!ex.isNull()) {
                                var buf = Memory.alloc(2048);
                                il2cpp_format_exception(ex, buf, 2048);
                                log("[💥 THROWN EXCEPTION]: " + buf.readUtf8String());
                            }
                        } catch (err) {
                            log("[-] Error formatting exception: " + err.message);
                        }
                    }
                });
                log("[+] Global IL2CPP exception tracker (0x9F3CB8) active");
            } catch (e) {
                log("[-] Error installing exception tracker: " + e.message);
            }

            var downloadDoneCalled = false;
            function ensureDownloadDone() {
                if (downloadDoneCalled) return;
                downloadDoneCalled = true;
                log("[📦 ASSET] ensureDownloadDone invoked -> calling AssetControl.DownloadDone (0xADA150)");
                try {
                    var downloadDoneFn = new NativeFunction(baseAddr.add(0xADA150), 'void', []);
                    downloadDoneFn();
                } catch (e) {
                    log("[-] Error calling DownloadDone: " + e.message);
                }
            }

            try {
                Interceptor.attach(baseAddr.add(0xB8BA7C), {
                    onEnter: function (args) {
                        var state = args[0].readS32();
                        log("[📦 ASSET] <LoadingProcess>d__59.MoveNext entered | state: " + state);
                        if (state === 3) {
                            ensureDownloadDone();
                        } else {
                            setTimeout(ensureDownloadDone, 1500);
                        }
                    }
                });
                Interceptor.attach(baseAddr.add(0xAE3660), {
                    onEnter: function (args) {
                        log("[📦 ASSET] CreateParsingList entered");
                    }
                });
                Interceptor.attach(baseAddr.add(0xAE90C8), {
                    onEnter: function (args) {
                        log("[📦 ASSET] CreateDownloadList entered");
                    }
                });
                Interceptor.attach(baseAddr.add(0xAE2450), {
                    onEnter: function (args) {
                        log("[📦 ASSET] DownloadAndParsingAssets entered");
                    }
                });
                Interceptor.attach(baseAddr.add(0xAD84E0), {
                    onEnter: function (args) {
                        log("[📦 ASSET] AssetControl.Close entered");
                    }
                });
                Interceptor.attach(baseAddr.add(0xB234E0), {
                    onEnter: function (args) {
                        log("[🚀 TITLE] TitleScene.SetStateLoadingDone entered!");
                    }
                });

                var officialBgFiles = [
                    "bg0.i.bytes.png",
                    "bg1.i.bytes.png",
                    "bg2.i.bytes.png",
                    "bg3.i.bytes.png",
                    "bg4.i.bytes.png",
                    "bg5.i.bytes.png",
                    "bg6.i.bytes.png",
                    "bg7.i.bytes.png"
                ];

                function loadAndApplyTitleBackground() {
                    try {
                        if (globalSceneId !== 2 && globalSceneId !== 0) {
                            return;
                        }
                        log("[🎨 BACKGROUND] Selecting random official title background from kswoks...");
                        var getBgInstancePtr = baseAddr.add(0xE93AAC);
                        var getBgInstanceFn = new NativeFunction(getBgInstancePtr, "pointer", []);
                        var bgInstance = getBgInstanceFn();
                        log("[🎨 BACKGROUND] BackgroundImage.Instance: " + bgInstance);
                        if (!bgInstance || bgInstance.isNull()) {
                            if (globalSceneId === 2) {
                                log("[-] BackgroundImage.Instance is null, scheduling retry in 500ms...");
                                setTimeout(loadAndApplyTitleBackground, 500);
                            }
                            return;
                        }

                        var rawImage = bgInstance.add(0x38).readPointer();
                        log("[🎨 BACKGROUND] backgroundRawImage (RawImage): " + rawImage);
                        if (!rawImage || rawImage.isNull()) {
                            log("[-] backgroundRawImage is null!");
                            return;
                        }

                        // 1. Elegir fondo aleatorio entre los 8 oficiales de kswoks
                        var randIdx = Math.floor(Math.random() * officialBgFiles.length);
                        var selectedFileName = officialBgFiles[randIdx];
                        var primaryPath = "/sdcard/kswoks/" + selectedFileName;
                        log("[🎲 RANDOM BACKGROUND] Selected index " + randIdx + ": " + selectedFileName);

                        var readAllBytesMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllBytes", 1);
                        var pathStr = createIl2CppString(primaryPath);
                        var args1 = Memory.alloc(Process.pointerSize);
                        args1.writePointer(pathStr);
                        var exc = Memory.alloc(Process.pointerSize);
                        exc.writePointer(NULL);
                        var bytesObj = il2cpp_runtime_invoke(readAllBytesMethod, NULL, args1, exc);
                        if (!bytesObj || bytesObj.isNull()) {
                            var altPath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/asodhsg/kswoks/" + selectedFileName;
                            pathStr = createIl2CppString(altPath);
                            args1.writePointer(pathStr);
                            bytesObj = il2cpp_runtime_invoke(readAllBytesMethod, NULL, args1, exc);
                        }

                        if (!bytesObj || bytesObj.isNull()) {
                            log("[-] Failed to read background file: " + selectedFileName);
                            return;
                        }
                        var byteLen = bytesObj.add(0x18).readInt();
                        log("[🎨 BACKGROUND] Loaded official PNG bytes length: " + byteLen);

                        // 2. Crear Texture2D(2, 2)
                        var tex2dClass = getClass("UnityEngine.CoreModule", "UnityEngine", "Texture2D");
                        var texObj = il2cpp_object_new(tex2dClass);
                        var texCtor = findMethod("UnityEngine.CoreModule", "UnityEngine", "Texture2D", ".ctor", 2);
                        var pWidth = Memory.alloc(4);
                        pWidth.writeInt(2);
                        var pHeight = Memory.alloc(4);
                        pHeight.writeInt(2);
                        var argsCtor = Memory.alloc(Process.pointerSize * 2);
                        argsCtor.writePointer(pWidth);
                        argsCtor.add(Process.pointerSize).writePointer(pHeight);
                        il2cpp_runtime_invoke(texCtor, texObj, argsCtor, exc);

                        // 3. ImageConversion.LoadImage(texObj, bytesObj)
                        var loadImagePtr = baseAddr.add(0x25B3E90);
                        var loadImageFn = new NativeFunction(loadImagePtr, "int", ["pointer", "pointer"]);
                        var loadSuccess = loadImageFn(texObj, bytesObj);
                        log("[🎨 BACKGROUND] ImageConversion.LoadImage result: " + loadSuccess);

                        // 4. RawImage.set_texture(texObj)
                        var setTexturePtr = baseAddr.add(0x194C074);
                        var setTextureFn = new NativeFunction(setTexturePtr, "void", ["pointer", "pointer", "pointer"]);
                        setTextureFn(rawImage, texObj, NULL);

                        // 5. Activar GameObject del RawImage
                        var getGoPtr = baseAddr.add(0x1DB6AD4);
                        var getGoFn = new NativeFunction(getGoPtr, "pointer", ["pointer", "pointer"]);
                        var rawImageGo = getGoFn(rawImage, NULL);
                        var setActivePtr = baseAddr.add(0x1DBADF4);
                        var setActiveFn = new NativeFunction(setActivePtr, "void", ["pointer", "int", "pointer"]);
                        setActiveFn(rawImageGo, 1, NULL);

                        // 6. Activar GameObject de BackgroundImage y marcar IsValid
                        var bgGo = getGoFn(bgInstance, NULL);
                        setActiveFn(bgGo, 1, NULL);

                        bgInstance.add(0x58).writeU8(1); // IsValid = true
                        bgInstance.add(0x40).writeU8(1); // isSetDone = true

                        // 7. ShowBackgroundImage
                        var showBgPtr = baseAddr.add(0xE93E00);
                        var showBgFn = new NativeFunction(showBgPtr, "void", ["pointer"]);
                        showBgFn(bgInstance);

                        // 8. Asegurar que Intro y Title nativos de Unity permanezcan activos
                        try {
                            if (globalTitleScene && !globalTitleScene.isNull()) {
                                var sceneView = globalTitleScene.add(0x48).readPointer();
                                if (sceneView && !sceneView.isNull()) {
                                    var introBase = sceneView.add(0x40).readPointer();
                                    if (introBase && !introBase.isNull()) {
                                        setActiveFn(introBase, 1, NULL);
                                    }
                                }
                            }
                        } catch (eIntro) {}

                        log("[🎉 BACKGROUND SUCCESS] Official randomized background (" + selectedFileName + ") active!");
                    } catch (e) {
                        log("[-] Error in loadAndApplyTitleBackground: " + e.message);
                    }
                }

                var isAtTouchToStart = false;
                Interceptor.attach(baseAddr.add(0xB243BC), {
                    onEnter: function (args) {
                        log("[🚀 TITLE] TitleScene.SetStateMain entered! Loading background image...");
                        globalTitleScene = args[0];
                        isAtTouchToStart = true;
                        hasTriggeredLobbyTransition = false;
                        dismissFade();
                        loadAndApplyTitleBackground();
                        setTimeout(loadAndApplyTitleBackground, 500);
                        setTimeout(loadAndApplyTitleBackground, 1500);
                    }
                });
                Interceptor.attach(baseAddr.add(0xB23F38), {
                    onEnter: function (args) {
                        log("[🚀 TITLE] TitleScene.SetStateNextScene entered on instance: " + args[0]);
                        globalTitleScene = args[0];
                    }
                });
                Interceptor.attach(baseAddr.add(0xD5338C), {
                    onEnter: function (args) {
                        log("[🎉 SCENE TRANSITION] Scene.SetStateOpenScene CALLED! -> Target SceneType: " + args[1].toInt32());
                    }
                });

                // 2.12 TOUCH TO START Handler -> Direct Lobby Transition
                var hasTriggeredLobbyTransition = false;
                function triggerLobbyTransition(source) {
                    if (!isAtTouchToStart) {
                        log("[⚠️ TRANSITION BLOCKED] Lobby transition attempted before TOUCH TO START was reached (from " + source + ")");
                        return;
                    }
                    if (hasTriggeredLobbyTransition) return;
                    hasTriggeredLobbyTransition = true;
                    log("[🚀 TITLE SCENE] Triggering Lobby transition from: " + source);
                    try {
                        var getLoginInstance = new NativeFunction(baseAddr.add(0xCF4848), 'pointer', []);
                        var loginCtrl = getLoginInstance();
                        if (!loginCtrl.isNull()) {
                            loginCtrl.add(0x79).writeU8(0); // IsGuest = 0
                        }
                        if (globalTitleScene && !globalTitleScene.isNull()) {
                            log("[🚀 TITLE SCENE] Calling TitleScene.SetStateNextScene on globalTitleScene: " + globalTitleScene);
                            var setNextSceneFn = new NativeFunction(baseAddr.add(0xB23F38), 'void', ['pointer']);
                            setNextSceneFn(globalTitleScene);
                            log("[🌟 SUCCESS] TitleScene.SetStateNextScene dispatched cleanly!");
                        } else {
                            log("[-] globalTitleScene is null, dispatching directly to SceneControl.OpenScene(3)...");
                            var openSceneFn = new NativeFunction(baseAddr.add(0xD534BC), 'void', ['int', 'pointer', 'pointer']);
                            openSceneFn(3, NULL, NULL);
                            log("[🌟 SUCCESS] SceneControl.OpenScene(3) dispatched directly!");
                        }
                    } catch (e) {
                        log("[-] Error in triggerLobbyTransition: " + e.message);
                    }
                }

                // Click handler en <SetStateMain>b__25_0 (0xB273C4)
                var setStateMainClickHandler = baseAddr.add(0xB273C4);
                Interceptor.attach(setStateMainClickHandler, {
                    onEnter: function (args) {
                        log("[🎉 TOUCH TO START] Click event detected on <SetStateMain>b__25_0!");
                        triggerLobbyTransition("<SetStateMain>b__25_0");
                    }
                });

                // TitleView.OnLogin (0xB2A4B4)
                Interceptor.attach(baseAddr.add(0xB2A4B4), {
                    onEnter: function (args) {
                        log("[🎉 TITLEVIEW ONLOGIN] TitleView.OnLogin called!");
                        triggerLobbyTransition("TitleView.OnLogin");
                    }
                });

                // TitleScene.SetStateSelectLogin (0xB245AC)
                Interceptor.attach(baseAddr.add(0xB245AC), {
                    onEnter: function (args) {
                        log("[🚀 TITLE SCENE] TitleScene.SetStateSelectLogin called on instance: " + args[0]);
                        globalTitleScene = args[0];
                    }
                });

                // Input.GetMouseButtonDown (0x25A5624) para detectar toques en pantalla durante TitleScene
                Interceptor.attach(baseAddr.add(0x25A5624), {
                    onLeave: function (retval) {
                        if (retval.toInt32() === 1 && !hasTriggeredLobbyTransition && isAtTouchToStart) {
                            if (globalTitleScene && !globalTitleScene.isNull()) {
                                log("[👆 INPUT TAP] Touch/Click detected on screen during TitleScene TOUCH TO START!");
                                triggerLobbyTransition("Input.GetMouseButtonDown");
                            }
                        }
                    }
                });

                Interceptor.attach(baseAddr.add(0xD534BC), {
                    onEnter: function (args) {
                        log("[🎬 SCENE] SceneControl.OpenScene -> sceneId: " + args[0].toInt32());
                    }
                });
                Interceptor.attach(baseAddr.add(0xD5512C), {
                    onEnter: function (args) {
                        log("[🎬 SCENE] SceneControl.OpenSceneWait -> sceneId: " + args[0].toInt32());
                    }
                });
                Interceptor.attach(baseAddr.add(0xD559E0), {
                    onEnter: function (args) {
                        log("[🎬 SCENE] SceneControl.OnNextScene entered!");
                    },
                    onLeave: function (retval) {
                        log("[🎬 SCENE] SceneControl.OnNextScene finished!");
                    }
                });

                var lobbyLoadStartTime = 0;
                var lobbyAsyncOp = NULL;

                Interceptor.attach(baseAddr.add(0x163FE7C), {
                    onEnter: function (args) {
                        try {
                            var strLen = args[0].add(0x10).readU32();
                            var sceneName = args[0].add(0x14).readUtf16String(strLen);
                            log("[🎬 SCENE] LoadSceneAsync called for: '" + sceneName + "' (additive: " + args[1].toInt32() + ")");
                            if (sceneName === "LobbyScene") {
                                lobbyLoadStartTime = Date.now();
                                log("[🎬 SCENE] LobbyScene load initiated at " + lobbyLoadStartTime);
                            }
                        } catch (e) {
                            log("[🎬 SCENE] LoadSceneAsync error: " + e.message);
                        }
                    },
                    onLeave: function (retval) {
                        log("[🎬 SCENE] LoadSceneAsync returned: " + retval);
                        if (lobbyLoadStartTime > 0 && lobbyAsyncOp.isNull()) {
                            lobbyAsyncOp = retval;
                            log("[🎬 SCENE] Captured LobbyScene AsyncOperation: " + lobbyAsyncOp);
                        }
                    }
                });

                // Hook AsyncOperation.get_isDone (RVA 0x1DB2C9C)
                Interceptor.attach(baseAddr.add(0x1DB2C9C), {
                    onEnter: function (args) {
                        this.isLobbyOp = (!lobbyAsyncOp.isNull() && args[0].equals(lobbyAsyncOp));
                    },
                    onLeave: function (retval) {
                        if (this.isLobbyOp && lobbyLoadStartTime > 0) {
                            var naturalDone = retval.toInt32();
                            if (naturalDone === 1) {
                                log("[🎉 ISDONE NATURAL] Unity reported natural isDone = 1 for LobbyScene!");
                            }
                        }
                    }
                });

                // Hook MediaPlayer.OpenVideoFromFile (0xCAEFC4) to redirect compressed APK videos to sdcard
                try {
                    var openVideoFn = baseAddr.add(0xCAEFC4);
                    Interceptor.attach(openVideoFn, {
                        onEnter: function (args) {
                            try {
                                var location = args[1].toInt32();
                                var pathStr = "";
                                if (!args[2].isNull()) {
                                    pathStr = readIl2CppString(args[2]);
                                }
                                log("[🎬 AVPRO] MediaPlayer.OpenVideoFromFile location=" + location + " path=" + pathStr);

                                var newPath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/main_24.webm";
                                if (pathStr && pathStr.indexOf("title") !== -1) {
                                    newPath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/title_24.webm";
                                }
                                this.newStr = createIl2CppString(newPath);
                                args[1] = ptr(0); // MediaPlayer.FileLocation.AbsolutePathOrURL = 0
                                args[2] = this.newStr;
                                log("[🎬 AVPRO] Redirected video to AbsolutePath: " + newPath);
                            } catch (e) {
                                log("[-] Error in OpenVideoFromFile hook: " + e.message);
                            }
                        }
                    });
                    log("[+] Hooked MediaPlayer.OpenVideoFromFile (0xCAEFC4) for seamless video playback");
                } catch (e) {
                    log("[-] Error hooking OpenVideoFromFile: " + e.message);
                }

                // Hook TutorialControl to prevent tutorial mode from hiding Lobby buttons
                try {
                    // TutorialControl.get_IsCompleted (0x14E5230) -> returns true (1)
                    Interceptor.replace(baseAddr.add(0x14E5230), new NativeCallback(function () {
                        return 1;
                    }, "int", []));
                    // TutorialControl.get_InGameTutorialDone (0x14E60AC) -> returns true (1)
                    Interceptor.replace(baseAddr.add(0x14E60AC), new NativeCallback(function () {
                        return 1;
                    }, "int", []));
                    // TutorialControl.get_Step (0x14E6050) -> returns NONE (-1)
                    Interceptor.replace(baseAddr.add(0x14E6050), new NativeCallback(function () {
                        return -1;
                    }, "int", []));
                    log("[🎓 TUTORIAL] Hooked TutorialControl methods to report completed tutorial");
                } catch (te) {
                    log("[-] Error hooking TutorialControl: " + te.message);
                }

                var lobbyUIActivated = false;
                function activateLobbyUIAndVideo(lobbySceneInstance) {
                    if (!lobbySceneInstance || lobbySceneInstance.isNull()) return;
                    try {
                        log("[🎨 LOBBY ACTIVATOR] Starting comprehensive Lobby UI & Video activation...");
                        var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer"]);
                        var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int"]);

                        // 1. Resolve LobbyView (offset 0x48 in LobbyScene, or offset 0x18 in Scene base)
                        var lobbyView = lobbySceneInstance.add(0x48).readPointer();
                        if (lobbyView.isNull()) {
                            lobbyView = lobbySceneInstance.add(0x18).readPointer();
                        }

                        if (!lobbyView.isNull()) {
                            log("[🎨 LOBBY ACTIVATOR] Found LobbyView at: " + lobbyView);

                            // Call SceneView.ShowCanvases (0xD47D00)
                            try {
                                var showCanvasesFn = new NativeFunction(baseAddr.add(0xD47D00), "void", ["pointer"]);
                                showCanvasesFn(lobbyView);
                                log("[🎨 LOBBY ACTIVATOR] SceneView.ShowCanvases() called!");
                            } catch (ce) {
                                log("[-] Error calling ShowCanvases: " + ce.message);
                            }

                            // Call LobbyView.Show (0xCEEB04)
                            try {
                                var lobbyShowFn = new NativeFunction(baseAddr.add(0xCEEB04), "void", ["pointer"]);
                                lobbyShowFn(lobbyView);
                                log("[🎨 LOBBY ACTIVATOR] LobbyView.Show() called!");
                            } catch (se) {
                                log("[-] Error calling LobbyView.Show: " + se.message);
                            }

                            // Explicitly ensure critical GameObjects are active
                            try {
                                // sideButtons (offset 0x60, GameObject)
                                var sideButtons = lobbyView.add(0x60).readPointer();
                                if (!sideButtons.isNull()) {
                                    setActiveFn(sideButtons, 1);
                                    log("[🎨 LOBBY ACTIVATOR] Activated sideButtons GameObject: " + sideButtons);
                                }

                                // buttonObjs (offset 0x70, GameObject)
                                var buttonObjs = lobbyView.add(0x70).readPointer();
                                if (!buttonObjs.isNull()) {
                                    setActiveFn(buttonObjs, 1);
                                    log("[🎨 LOBBY ACTIVATOR] Activated buttonObjs GameObject: " + buttonObjs);
                                }

                                // btnReady (offset 0x68, ButtonCache which inherits from UICache)
                                // In UICache: gameObject is field at offset 0x10!
                                var btnReady = lobbyView.add(0x68).readPointer();
                                var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                var strReady = createIl2CppString("Ready");

                                if (!btnReady.isNull()) {
                                    var btnGo = btnReady.add(0x10).readPointer();
                                    if (!btnGo.isNull()) {
                                        setActiveFn(btnGo, 1);
                                        log("[🎉 READY BUTTON] Activated btnReady.gameObject: " + btnGo);
                                    }
                                    // box (Image, offset 0x50)
                                    var box = btnReady.add(0x50).readPointer();
                                    if (!box.isNull()) {
                                        var boxGo = getGoFn(box);
                                        if (!boxGo.isNull()) setActiveFn(boxGo, 1);
                                        log("[🎉 READY BUTTON] Activated box: " + boxGo);
                                    }
                                    // label (Text, offset 0x60)
                                    var label = btnReady.add(0x60).readPointer();
                                    if (!label.isNull()) {
                                        setTextFn(label, strReady, NULL);
                                        var labelGo = getGoFn(label);
                                        if (!labelGo.isNull()) setActiveFn(labelGo, 1);
                                        try {
                                            var setColorFn = new NativeFunction(baseAddr.add(0x161476C), "void", ["pointer", "float", "float", "float", "float", "pointer"]);
                                            setColorFn(label, 0.28, 0.38, 0.65, 1.0, NULL);
                                        } catch (ce) {}
                                        log("[🎉 READY BUTTON] Set text 'Ready' on label: " + labelGo);
                                    }
                                }

                                // readyText (offset 0x120, Text) & readyAutograph (offset 0x128, RawImage)
                                var readyText = lobbyView.add(0x120).readPointer();
                                if (!readyText.isNull()) {
                                    setTextFn(readyText, strReady, NULL);
                                    var rtGo = getGoFn(readyText);
                                    if (!rtGo.isNull()) {
                                        setActiveFn(rtGo, 1);
                                        try {
                                            var setColorFn = new NativeFunction(baseAddr.add(0x161476C), "void", ["pointer", "float", "float", "float", "float", "pointer"]);
                                            setColorFn(readyText, 0.28, 0.38, 0.65, 1.0, NULL);
                                        } catch (ce) {}
                                    }
                                }
                                var readyAuto = lobbyView.add(0x128).readPointer();
                                if (!readyAuto.isNull()) {
                                    var raGo = getGoFn(readyAuto);
                                    if (!raGo.isNull()) {
                                        setActiveFn(raGo, 0); // Hide duplicate autograph thumbnail
                                        log("[🎉 READY BUTTON] Deactivated readyAutograph: " + raGo);
                                    }
                                }

                                // blank (offset 0x48, UICache)
                                var blank = lobbyView.add(0x48).readPointer();
                                if (!blank.isNull()) {
                                    var blankGo = blank.add(0x10).readPointer();
                                    if (!blankGo.isNull()) {
                                        setActiveFn(blankGo, 1);
                                    }
                                }

                                // newsView (offset 0x50, LobbyNewsView)
                                // Deactivate empty placeholder box so it doesn't obstruct background
                                var newsView = lobbyView.add(0x50).readPointer();
                                if (!newsView.isNull()) {
                                    var newsGo = getGoFn(newsView);
                                    if (!newsGo.isNull()) {
                                        setActiveFn(newsGo, 0);
                                        log("[🎨 LOBBY ACTIVATOR] NewsView placeholder deactivated to keep view clean");
                                    }
                                }

                                // memberView (offset 0x58, LobbyMemberView)
                                var memberView = lobbyView.add(0x58).readPointer();
                                if (!memberView.isNull()) {
                                    var memberGo = getGoFn(memberView);
                                    if (!memberGo.isNull()) {
                                        setActiveFn(memberGo, 1);
                                        log("[🎨 LOBBY ACTIVATOR] Activated memberView GameObject: " + memberGo);
                                    }

                                    // Load official Lobby Background from asiudgasg/asodhsg/weoihxd/
                                    try {
                                        var memberImg = memberView.add(0x50).readPointer();
                                        if (!memberImg.isNull()) {
                                            var weoihxdDir = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/asodhsg/weoihxd/";
                                            // Default: Canonical Flip That group background (1015)
                                            var chosenBgId = 1015;
                                            try {
                                                var bgCfgPath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/chosen_bg.txt";
                                                var readAllTextMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllText", 1);
                                                var existsMethod = findMethod("mscorlib", "System.IO", "File", "Exists", 1);
                                                var cfgPathStr = createIl2CppString(bgCfgPath);
                                                var aCheck = Memory.alloc(Process.pointerSize);
                                                aCheck.writePointer(cfgPathStr);
                                                var exc = Memory.alloc(Process.pointerSize);
                                                exc.writePointer(NULL);
                                                var cfgExists = il2cpp_runtime_invoke(existsMethod, NULL, aCheck, exc);
                                                if (cfgExists.toInt32() !== 0) {
                                                    var aRead = Memory.alloc(Process.pointerSize);
                                                    aRead.writePointer(cfgPathStr);
                                                    var txtObj = il2cpp_runtime_invoke(readAllTextMethod, NULL, aRead, exc);
                                                    if (!txtObj.isNull()) {
                                                        var rawTxt = readIl2CppString(txtObj).trim();
                                                        var parsed = parseInt(rawTxt);
                                                        if (!isNaN(parsed) && parsed >= 1001 && parsed <= 1076) {
                                                            chosenBgId = parsed;
                                                            log("[🎨 LOBBY BG] Loaded custom chosenBgId: " + chosenBgId);
                                                        }
                                                    }
                                                }
                                            } catch (cfge) {}

                                            var bgFilePath = weoihxdDir + chosenBgId + "_l.i.bytes";

                                            var readAllBytesMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllBytes", 1);
                                            var existsMethod = findMethod("mscorlib", "System.IO", "File", "Exists", 1);
                                            var pathIl2cppStr = createIl2CppString(bgFilePath);
                                            var argsCheck = Memory.alloc(Process.pointerSize);
                                            argsCheck.writePointer(pathIl2cppStr);
                                            var exc = Memory.alloc(Process.pointerSize);
                                            exc.writePointer(NULL);
                                            var fileExists = il2cpp_runtime_invoke(existsMethod, NULL, argsCheck, exc);

                                            if (fileExists.toInt32() === 0) {
                                                bgFilePath = weoihxdDir + chosenBgId + "_l.i.bytes.png";
                                                pathIl2cppStr = createIl2CppString(bgFilePath);
                                            }

                                            var argsRead = Memory.alloc(Process.pointerSize);
                                            argsRead.writePointer(pathIl2cppStr);
                                            var bytesObj = il2cpp_runtime_invoke(readAllBytesMethod, NULL, argsRead, exc);

                                            if (!bytesObj.isNull()) {
                                                var tex2dClass = getClass("UnityEngine.CoreModule", "UnityEngine", "Texture2D");
                                                var texObj = il2cpp_object_new(tex2dClass);
                                                
                                                // Call Texture2D..ctor(int width, int height) at RVA 0x181B6BC directly
                                                var texCtorNative = new NativeFunction(baseAddr.add(0x181B6BC), "void", ["pointer", "int", "int", "pointer"]);
                                                texCtorNative(texObj, 2, 2, NULL);

                                                // Call ImageConversion.LoadImage(tex, bytes) at RVA 0x25B3E90
                                                var loadImageFn = new NativeFunction(baseAddr.add(0x25B3E90), "int", ["pointer", "pointer", "pointer"]);
                                                var loadSuccess = loadImageFn(texObj, bytesObj, NULL);
                                                log("[🎨 LOBBY BG] Official weoihxd background (" + chosenBgId + ") loaded: " + loadSuccess + " (tex: " + texObj + ")");

                                                if (loadSuccess) {
                                                    // RawImage.set_texture(tex) at RVA 0x194C074
                                                    var setTextureFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                                    setTextureFn(memberImg, texObj, NULL);
                                                    memberImg.add(0xD0).writePointer(texObj);

                                                    // Graphic.set_color(Color.white) at RVA 0x161476C
                                                    try {
                                                        var setColorFn = new NativeFunction(baseAddr.add(0x161476C), "void", ["pointer", "float", "float", "float", "float", "pointer"]);
                                                        setColorFn(memberImg, 1.0, 1.0, 1.0, 1.0, NULL);
                                                    } catch (ce) {}

                                                    // Disable raycastTarget on memberImg so it doesn't block UI button clicks
                                                    try {
                                                        var setRaycastTargetFn = new NativeFunction(baseAddr.add(0x16147BC), "void", ["pointer", "int", "pointer"]);
                                                        setRaycastTargetFn(memberImg, 0, NULL);
                                                        log("[🎨 LOBBY BG] Disabled raycastTarget on memberImg!");
                                                    } catch (re) {}

                                                    // Adjust RectTransform dimensions for optimal full-screen 16:9 display
                                                    try {
                                                        var getTransformFn = new NativeFunction(baseAddr.add(0x1DB6B10), "pointer", ["pointer"]);
                                                        var setSizeDeltaFn = new NativeFunction(baseAddr.add(0x180DC18), "void", ["pointer", "float", "float"]);
                                                        var setAnchoredPosFn = new NativeFunction(baseAddr.add(0x180DACC), "void", ["pointer", "float", "float"]);

                                                        var memberViewRt = getTransformFn(memberView);
                                                        if (!memberViewRt.isNull()) {
                                                            setSizeDeltaFn(memberViewRt, 1920.0, 1080.0);
                                                            setAnchoredPosFn(memberViewRt, 0.0, 0.0);
                                                        }

                                                        var memberRt = getTransformFn(memberImg);
                                                        if (!memberRt.isNull()) {
                                                            setSizeDeltaFn(memberRt, 1920.0, 1080.0);
                                                            setAnchoredPosFn(memberRt, 0.0, 0.0);
                                                        }
                                                    } catch (re) {}

                                                    var memberImgGo = getGoFn(memberImg);
                                                    if (!memberImgGo.isNull()) {
                                                        setActiveFn(memberImgGo, 1);
                                                        log("[🎨 LOBBY BG] Activated memberImage GameObject: " + memberImgGo);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (bge) {
                                        log("[-] Error applying lobby background image: " + bge.message);
                                    }
                                }

                                // Initialize side menus with right menu open to display Submenu actions (InitMenus at RVA 0xCEF608)
                                try {
                                    var initMenusFn = new NativeFunction(baseAddr.add(0xCEF608), "void", ["pointer", "int", "int", "pointer"]);
                                    initMenusFn(lobbyView, 0, 1, NULL); // (isLeftOpen=0, isRightOpen=1)
                                    log("[🎨 LOBBY] InitMenus(0, 1) called -> Right submenu expanded with navigation ready!");
                                } catch (ime) {
                                    log("[-] Error in InitMenus: " + ime.message);
                                }

                                // Adjust Camera clearFlags to avoid solid color blocking
                                try {
                                    var getAllCamerasFn = new NativeFunction(baseAddr.add(0x1DB54EC), "pointer", []);
                                    var camArray = getAllCamerasFn();
                                    if (!camArray.isNull()) {
                                        var camCount = camArray.add(Process.pointerSize * 3).readInt();
                                        log("[📷 CAMERAS] Total active cameras: " + camCount);
                                        var getClearFlagsFn = new NativeFunction(baseAddr.add(0x1DB4A80), "int", ["pointer"]);
                                        var setClearFlagsFn = new NativeFunction(baseAddr.add(0x1DB4AC0), "void", ["pointer", "int"]);
                                        for (var ci = 0; ci < camCount; ci++) {
                                            var cam = camArray.add(Process.pointerSize * 4 + ci * Process.pointerSize).readPointer();
                                            if (!cam.isNull()) {
                                                var cflags = getClearFlagsFn(cam);
                                                log("[📷 CAMERA " + ci + "] clearFlags = " + cflags);
                                                if (ci > 0 && cflags === 2) {
                                                    setClearFlagsFn(cam, 3);
                                                    log("[📷 CAMERA " + ci + "] Changed clearFlags from 2 (SolidColor) to 3 (Depth)");
                                                }
                                            }
                                        }
                                    }
                                } catch (came) {
                                    log("[-] Error adjusting cameras: " + came.message);
                                }

                                // myLobbyObj (offset 0x110, GameObject)
                                var myLobbyObj = lobbyView.add(0x110).readPointer();
                                if (!myLobbyObj.isNull()) {
                                    setActiveFn(myLobbyObj, 1);
                                    log("[🎨 LOBBY ACTIVATOR] Activated myLobbyObj: " + myLobbyObj);
                                }

                                // openAnim (offset 0xF0, Animation)
                                var openAnim = lobbyView.add(0xF0).readPointer();
                                if (!openAnim.isNull()) {
                                    try {
                                        var animPlayFn = new NativeFunction(baseAddr.add(0x257E91C), "int", ["pointer"]);
                                        animPlayFn(openAnim);
                                        log("[🎨 LOBBY ACTIVATOR] Played openAnim: " + openAnim);
                                    } catch (ae) {}
                                }
                            } catch (ge) {
                                log("[-] Error activating UI GameObjects: " + ge.message);
                            }
                        } else {
                            log("[-] LobbyView is NULL on lobbySceneInstance: " + lobbySceneInstance);
                        }

                        // 2. VideoControl Activation & Native Movie Loading
                        try {
                            var videoControlGetInstance = new NativeFunction(baseAddr.add(0xABAE34), "pointer", []);
                            var vc = videoControlGetInstance();
                            if (!vc.isNull()) {
                                log("[🎬 VIDEO ACTIVATOR] VideoControl instance: " + vc);

                                var videoPath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/main_24.webm";
                                var strIl2CppUri = createIl2CppString(videoPath);
                                var strIl2CppFile = createIl2CppString("main_24.webm");

                                // VideoControl.set_IsInit(vc, 1) (0xABAFDC)
                                var setIsInitFn = new NativeFunction(baseAddr.add(0xABAFDC), "void", ["pointer", "int"]);
                                setIsInitFn(vc, 1);

                                // VideoControl.set_IsSetDone(vc, 1) (0xABB0A8)
                                var setIsSetDoneFn = new NativeFunction(baseAddr.add(0xABB0A8), "void", ["pointer", "int"]);
                                setIsSetDoneFn(vc, 1);

                                // VideoControl.SetForceVideo(vc, 1) (0xABBCEC)
                                var setForceFn = new NativeFunction(baseAddr.add(0xABBCEC), "void", ["pointer", "int"]);
                                setForceFn(vc, 1);

                                // VideoControl.AddUri(vc, 1, uri, fileName) (0xABB9C4)
                                var addUriFn = new NativeFunction(baseAddr.add(0xABB9C4), "void", ["pointer", "int", "pointer", "pointer"]);
                                addUriFn(vc, 1, strIl2CppUri, strIl2CppFile);

                                // VideoControl.SetDefaultUri(vc, uri, fileName) (0xABBC2C)
                                var setDefaultUriFn = new NativeFunction(baseAddr.add(0xABBC2C), "void", ["pointer", "pointer", "pointer"]);
                                setDefaultUriFn(vc, strIl2CppUri, strIl2CppFile);

                                // VideoControl.Show(vc) (0xABBDA8)
                                var vcShowFn = new NativeFunction(baseAddr.add(0xABBDA8), "void", ["pointer"]);
                                vcShowFn(vc);

                                // VideoControl.Open(vc, MOVIE_TYPE.Main = 1, isPrepare = 0) (0xABBC34)
                                var vcOpenFn = new NativeFunction(baseAddr.add(0xABBC34), "void", ["pointer", "int", "int"]);
                                vcOpenFn(vc, 1, 0);
                                log("[🎬 VIDEO ACTIVATOR] VideoControl fully initialized and Open(MOVIE_TYPE.Main = 1) dispatched!");

                                // Get current MediaPlayer and link to DisplayUGUI (offset 0x28)
                                var getCurMpFn = new NativeFunction(baseAddr.add(0xABB000), "pointer", ["pointer"]);
                                var mp = getCurMpFn(vc);
                                var display = vc.add(0x28).readPointer();
                                if (!display.isNull() && !mp.isNull()) {
                                    display.add(0xD0).writePointer(mp); // _mediaPlayer in DisplayUGUI
                                    var dispGo = getGoFn(display);
                                    if (!dispGo.isNull()) {
                                        setActiveFn(dispGo, 1);
                                        log("[🎬 VIDEO ACTIVATOR] Activated VideoControl display: " + dispGo);
                                    }
                                }

                                if (!mp.isNull()) {
                                    var mpGo = getGoFn(mp);
                                    if (!mpGo.isNull()) {
                                        setActiveFn(mpGo, 1);
                                    }
                                    var openVideoFn = new NativeFunction(baseAddr.add(0xCAEFC4), "int", ["pointer", "int", "pointer", "int"]);
                                    var playFn = new NativeFunction(baseAddr.add(0xCB0170), "void", ["pointer"]);

                                    var res = openVideoFn(mp, 0, strIl2CppUri, 1);
                                    playFn(mp);
                                    log("[🎬 VIDEO ACTIVATOR] Direct MediaPlayer.OpenVideoFromFile returned: " + res + " and Play() called!");
                                }
                            }
                        } catch (ve) {
                            log("[-] Error activating VideoControl: " + ve.message);
                        }

                        // 3. Dismiss & Purge Fade Overlay (Screen Veil)
                        try {
                            var fadeSetIsActiveFn = new NativeFunction(baseAddr.add(0xD2EBA8), "void", ["int"]);
                            fadeSetIsActiveFn(0);

                            var fadeCloseFn = new NativeFunction(baseAddr.add(0xD2FAB4), "void", []);
                            fadeCloseFn();

                            var fadeCompleteFn = new NativeFunction(baseAddr.add(0xD2FC20), "void", []);
                            fadeCompleteFn();

                            var fadePurgeFn = new NativeFunction(baseAddr.add(0xD2F078), "void", []);
                            fadePurgeFn();

                            var fadeStopFn = new NativeFunction(baseAddr.add(0xD2FD24), "void", []);
                            fadeStopFn();
                            log("[🛡️ FADE DISMISSED] Fade.Close, Complete, Purge & Stop called successfully!");

                            var fadeNames = ["Fade", "Fade(Clone)", "ScreenFade", "LoadingFade", "Curtain", "Dim", "Vanish"];
                            fadeNames.forEach(function (fname) {
                                try {
                                    var fgo = findGameObjectFn(createIl2CppString(fname), NULL);
                                    if (!fgo.isNull()) {
                                        setActiveFn(fgo, 0);
                                        log("[🛡️ FADE DISMISSED] Deactivated Fade GameObject: " + fname);
                                    }
                                } catch (e) {}
                            });
                        } catch (fe) {
                            log("[-] Error dismissing Fade: " + fe.message);
                        }

                        // --- Submenu Customization: Ocultar botón de Ranking (-League / Weekly League) ---
                        // (Para reactivar el botón de Ranking en el Lobby, comenta este bloque o cambia el valor a 1)
                        try {
                            var leaguePaths = [
                                "LobbyScene/Buttons/RightMenu/-extraMenu/BtnMyLobby/-League",
                                "-League",
                                "RightMenu/-extraMenu/BtnMyLobby/-League"
                            ];
                            leaguePaths.forEach(function (lpath) {
                                try {
                                    var lgo = findGameObjectFn(createIl2CppString(lpath), NULL);
                                    if (!lgo.isNull()) {
                                        setActiveFn(lgo, 0); // 0 = Ocultar / 1 = Mostrar
                                        log("[🏆 SUBMENU] Ranking button (-League) hidden successfully! (" + lpath + ")");
                                    }
                                } catch (e) {}
                            });
                        } catch (eLeague) {
                            log("[-] Error hiding -League ranking button: " + eLeague.message);
                        }

                        // --- Initialize InventoryControl on Lobby startup ---
                        try {
                            var invenOpenFn = new NativeFunction(baseAddr.add(0xF27AA0), "void", ["pointer"]);
                            invenOpenFn(NULL);
                            log("[🃏 INVENTORY] InventoryControl.Open() executed on Lobby init!");
                            populateOfflineInventoryCards();
                        } catch (eInv) {
                            log("[-] Error calling InventoryControl.Open on Lobby init: " + eInv.message);
                        }

                        lobbyUIActivated = true;
                    } catch (e) {
                        log("[-] General error in activateLobbyUIAndVideo: " + e.message);
                    }
                }

                // =========================================================================
                // 🃏 DALCOMSOFT OFFLINE CARD SYSTEM & INVENTORY POPULATOR
                // =========================================================================
                var LOONA_MEMBERS = [
                    { index: 1, name: "HeeJin", krName: "희진" },
                    { index: 2, name: "HyunJin", krName: "현진" },
                    { index: 3, name: "HaSeul", krName: "하슬" },
                    { index: 4, name: "YeoJin", krName: "여진" },
                    { index: 5, name: "ViVi", krName: "비비" },
                    { index: 6, name: "Kim Lip", krName: "김립" },
                    { index: 7, name: "JinSoul", krName: "진솔" },
                    { index: 8, name: "Choerry", krName: "최리" },
                    { index: 9, name: "Yves", krName: "이브" },
                    { index: 10, name: "Chuu", krName: "츄" },
                    { index: 11, name: "Go Won", krName: "고원" },
                    { index: 12, name: "Olivia Hye", krName: "올리비아 혜" }
                ];

                var downloadPathKlass = NULL;
                function getDownloadPathClass() {
                    if (downloadPathKlass && !downloadPathKlass.isNull()) {
                        return downloadPathKlass;
                    }

                    // Strategy 1: Check if the TypeInfo slot is already resolved to a valid Il2CppClass*
                    try {
                        var slotVal = baseAddr.add(0x31F74F8).readPointer();
                        // A valid Il2CppClass* will be a high heap address, not a metadata token like 0xc000ae17
                        if (!slotVal.isNull() && slotVal.compare(ptr(0x100000000)) > 0) {
                            downloadPathKlass = slotVal;
                            log("[+] Resolved WWWFile.DownloadPath class from pre-resolved TypeInfo slot: " + slotVal);
                            return downloadPathKlass;
                        }
                    } catch (eSlot) {}

                    // Strategy 2: Use nested types API (primary safe method)
                    try {
                        var wwwFileKlass = getClass("Assembly-CSharp", "Ext.Unity3D.Cdn", "WWWFile");
                        if (!wwwFileKlass || wwwFileKlass.isNull()) {
                            wwwFileKlass = getClass("Assembly-CSharp-firstpass", "Ext.Unity3D.Cdn", "WWWFile");
                        }
                        if (wwwFileKlass && !wwwFileKlass.isNull()) {
                            var getNestedFn = new NativeFunction(Module.findExportByName("libil2cpp.so", "il2cpp_class_get_nested_types"), 'pointer', ['pointer', 'pointer']);
                            var getNameFn = new NativeFunction(Module.findExportByName("libil2cpp.so", "il2cpp_class_get_name"), 'pointer', ['pointer']);
                            var iter = Memory.alloc(Process.pointerSize);
                            iter.writePointer(NULL);
                            var nested;
                            while (!(nested = getNestedFn(wwwFileKlass, iter)).isNull()) {
                                var nName = getNameFn(nested).readUtf8String();
                                if (nName === "DownloadPath") {
                                    downloadPathKlass = nested;
                                    log("[+] Resolved WWWFile.DownloadPath class via nested types: " + nested);
                                    return downloadPathKlass;
                                }
                            }
                        }
                    } catch (eNest) {
                        log("[-] Error resolving DownloadPath via nested types: " + eNest.message);
                    }
                    return NULL;
                }

                function createDownloadPath(relPath) {
                    try {
                        var klass = getDownloadPathClass();
                        if (!klass || klass.isNull()) return NULL;
                        var dp = il2cpp_object_new(klass);
                        if (!dp || dp.isNull()) return NULL;
                        dp.add(0x10).writePointer(createIl2CppString("https://dalcom.local/" + relPath));
                        dp.add(0x18).writePointer(createIl2CppString(relPath));
                        dp.add(0x20).writePointer(createIl2CppString("1"));
                        dp.add(0x28).writeU8(0);
                        dp.add(0x29).writeU8(0); // shared = false (local file path)
                        dp.add(0x2A).writeU8(0);
                        dp.add(0x30).writePointer(NULL);
                        dp.add(0x38).writeS32(1); // Texture = 1
                        return dp;
                    } catch (eDp) {
                        log("[-] Error creating DownloadPath for " + relPath + ": " + eDp.message);
                        return NULL;
                    }
                }

                var accountOwnedCards = {
                    1001: { grade: 4, level: 50 },
                    1002: { grade: 4, level: 50 },
                    1003: { grade: 4, level: 50 },
                    1004: { grade: 4, level: 50 },
                    1005: { grade: 4, level: 50 },
                    1006: { grade: 4, level: 50 },
                    1007: { grade: 4, level: 50 },
                    1008: { grade: 4, level: 50 },
                    1009: { grade: 4, level: 50 },
                    1010: { grade: 4, level: 50 },
                    1011: { grade: 4, level: 50 },
                    1012: { grade: 4, level: 50 }
                };

                // grade: 0=C, 1=B, 2=A, 3=S, 4=R
                // type: 0=Large (_l), 1=Small (_s), 2=Collection (_c)
                function getGradeFrameDownloadPath(grade, type, isCollection) {
                    var gStr = "0_c";
                    if (grade === 1) gStr = "0b";
                    else if (grade === 2) gStr = "0_a";
                    else if (grade === 3) gStr = "0_s";
                    else if (grade === 4) gStr = "0_r";

                    var variant = "s";
                    if (isCollection || type === 2) variant = "c";
                    else if (type === 0) variant = "l";

                    var fname = gStr + "_" + variant + ".i.bytes";
                    if (grade === 1 && variant === "l") fname = "0b_l.i.bytes";
                    else if (grade === 0 && variant === "l") fname = "0c_l.i.bytes";

                    return createDownloadPath("asiudgasg/asodhsg/aoeiwhslc/uhex/" + fname);
                }

                var loonaGroupData = NULL;
                var loonaThemeData = NULL;
                var loonaThemeTypeData = NULL;
                var loonaArtistDataMap = {};
                var loonaCardControlDataMap = {};
                var loonaGroupItemObj = NULL;
                var loonaArtistListFastArray = NULL;
                var loonaCardListFastArray = NULL;
                var loonaEachThemeBestCardMap = NULL;

                function createFastArray(items, type) {
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

                        var klass = NULL;
                        try {
                            var ptr1 = klassTablePtr.readPointer();
                            if (!ptr1.isNull()) {
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

                function ensureLoonaMocks() {
                    try {
                        if (!loonaGroupData || loonaGroupData.isNull()) {
                            var grpKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "GroupControl/Data");
                            if (grpKlass && !grpKlass.isNull()) {
                                loonaGroupData = il2cpp_object_new(grpKlass);
                                loonaGroupData.add(0x18).writePointer(createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes"));
                                loonaGroupData.add(0x28).writePointer(createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes"));
                                try {
                                    var gdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "GroupData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "GroupData");
                                    if (gdKlass && !gdKlass.isNull()) {
                                        var gd = il2cpp_object_new(gdKlass);
                                        gd.add(0x10).writeS32(1001); // code = 1001
                                        gd.add(0x14).writeS16(1001); // majorGroupCode = 1001
                                        gd.add(0x18).writeS16(12);   // memberCount = 12
                                        gd.add(0x80).writeS16(1);    // index = 1
                                        gd.add(0x82).writeS16(1);    // index2 = 1
                                        loonaGroupData.add(0x10).writePointer(gd);
                                        log("[+] Instantiated GroupData model for LOONA: " + gd);
                                    } else {
                                        log("[-] Failed to resolve GroupData class!");
                                    }
                                } catch (gdErr) {}
                            }
                        }
                        if (!loonaThemeData || loonaThemeData.isNull()) {
                            var thmKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "ThemeControl/Data");
                            if (thmKlass && !thmKlass.isNull()) {
                                loonaThemeData = il2cpp_object_new(thmKlass);
                                loonaThemeData.add(0x30).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes"));
                                loonaThemeData.add(0x38).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                loonaThemeData.add(0x40).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                try {
                                    var tdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "ThemeData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "ThemeData");
                                    if (tdKlass && !tdKlass.isNull()) {
                                        var td = il2cpp_object_new(tdKlass);
                                        td.add(0x10).writeS32(1001);
                                        td.add(0x18).writePointer(createIl2CppString("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes"));
                                        td.add(0x20).writePointer(createIl2CppString("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                        td.add(0x48).writePointer(createIl2CppString("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                        loonaThemeData.add(0x10).writePointer(td);
                                    }
                                } catch (tdErr) {}
                            }
                        }
                        if (!loonaThemeTypeData || loonaThemeTypeData.isNull()) {
                            var ttKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "ThemeTypeControl/Data");
                            if (ttKlass && !ttKlass.isNull()) {
                                loonaThemeTypeData = il2cpp_object_new(ttKlass);
                                try {
                                    var ttdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "ThemeTypeData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "ThemeTypeData");
                                    if (ttdKlass && !ttdKlass.isNull()) {
                                        var ttd = il2cpp_object_new(ttdKlass);
                                        ttd.add(0x10).writeS16(1); // code = 1
                                        loonaThemeTypeData.add(0x10).writePointer(ttd);
                                    }
                                } catch (ttdErr) {}
                                log("[+] Instantiated loonaThemeTypeData: " + loonaThemeTypeData);
                            } else {
                                log("[-] Failed to resolve ThemeTypeControl/Data class!");
                            }
                        }
                        var artKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "ArtistControl/Data");
                        if (artKlass && !artKlass.isNull()) {
                            var adKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "ArtistData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "ArtistData");
                            for (var i = 0; i < LOONA_MEMBERS.length; i++) {
                                var m = LOONA_MEMBERS[i];
                                if (!loonaArtistDataMap[m.index]) {
                                    var aObj = il2cpp_object_new(artKlass);
                                    aObj.add(0x20).writePointer(createIl2CppString("LOONA"));
                                    aObj.add(0x38).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes"));
                                    aObj.add(0x40).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                    try {
                                        if (adKlass && !adKlass.isNull()) {
                                            var ad = il2cpp_object_new(adKlass);
                                            ad.add(0x10).writeS32(m.index);
                                            ad.add(0x18).writeS32(1001);
                                            ad.add(0x88).writePointer(createIl2CppString(m.name));
                                            ad.add(0x98).writeS16(m.index);
                                            aObj.add(0x10).writePointer(ad);
                                        }
                                    } catch (adErr) {}
                                    loonaArtistDataMap[m.index] = aObj;
                                }
                            }
                            var artistItems = [];
                            for (var ai = 1; ai <= 12; ai++) {
                                artistItems.push(loonaArtistDataMap[ai] || NULL);
                            }
                            loonaArtistListFastArray = createFastArray(artistItems, 'artist');
                            if (loonaGroupData && !loonaGroupData.isNull()) {
                                loonaGroupData.add(0x30).writePointer(loonaArtistListFastArray);
                            }
                        }
                    } catch (eMocks) {
                        log("[-] Error ensuring LOONA mocks: " + eMocks.message);
                    }
                }

                function getOrCreateCardControlData(cardId) {
                    ensureLoonaMocks();
                    if (loonaCardControlDataMap[cardId]) {
                        return loonaCardControlDataMap[cardId];
                    }
                    try {
                        var ccdKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "CardControl/Data");
                        if (!ccdKlass || ccdKlass.isNull()) return NULL;
                        var ccd = il2cpp_object_new(ccdKlass);
                        var memberIdx = ((cardId - 1001) % 12) + 1;
                        ccd.add(0x18).writePointer(createIl2CppString("LOONA"));
                        ccd.add(0x20).writeS32(1001);
                        ccd.add(0x28).writePointer(loonaGroupData || NULL);
                        ccd.add(0x30).writePointer(loonaArtistDataMap[memberIdx] || NULL);
                        ccd.add(0x38).writePointer(loonaThemeData || NULL);
                        ccd.add(0x40).writePointer(loonaThemeTypeData || NULL);
                        ccd.add(0x48).writePointer(NULL);
                        ccd.add(0x50).writeU8(1);
                        ccd.add(0x51).writeU8(1);
                        ccd.add(0x58).writePointer(createDownloadPath("asiudgasg/asodhsg/wadceg/" + cardId + "_s.i.bytes"));
                        ccd.add(0x60).writePointer(createDownloadPath("asiudgasg/asodhsg/wadceg/" + cardId + "_l.i.bytes"));
                        try {
                            var cdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "CardData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "CardData");
                            if (cdKlass && !cdKlass.isNull()) {
                                var cd = il2cpp_object_new(cdKlass);
                                cd.add(0x10).writeS32(cardId);
                                cd.add(0x14).writeS32(0); // type = 0
                                cd.add(0x20).writePointer(createIl2CppString("asiudgasg/asodhsg/wadceg/" + cardId + "_s.i.bytes")); // cardImageSmall
                                cd.add(0x28).writePointer(createIl2CppString("asiudgasg/asodhsg/wadceg/" + cardId + "_l.i.bytes")); // cardImageLarge
                                cd.add(0x30).writeS32(1001); // theme = 1001
                                cd.add(0x70).writeS32(1001); // group = 1001
                                cd.add(0x74).writeS32(memberIdx); // artist = memberIdx
                                ccd.add(0x10).writePointer(cd);
                            }
                        } catch (cdErr) {}
                        loonaCardControlDataMap[cardId] = ccd;
                        return ccd;
                    } catch (eCcd) {
                        log("[-] Error creating CardControl.Data for " + cardId + ": " + eCcd.message);
                        return NULL;
                    }
                }

                // Safely stub Storage<long, Card>.get_Values (0x1E63A14) to return NULL so OpenCard does not fault
                try {
                    Interceptor.replace(baseAddr.add(0x1E63A14), new NativeCallback(function (methodInfo) {
                        return NULL;
                    }, "pointer", ["pointer"]));
                    log("[+] Interceptor.replace installed on Storage<long, Card>.get_Values (0x1E63A14)!");
                } catch (eRep) {
                    log("[-] Error replacing Storage.get_Values: " + eRep.message);
                }

                // Replace CardItem..ctor(Card account) (0xB55850) with safe direct initialization
                try {
                    Interceptor.replace(baseAddr.add(0xB55850), new NativeCallback(function (thisPtr, accountPtr, methodInfo) {
                        try {
                            if (thisPtr.isNull() || accountPtr.isNull()) return;
                            var grade = accountPtr.add(0x24).readS32();
                            var level = accountPtr.add(0x1C).readS16();
                            var cardId = accountPtr.add(0x20).readS32();

                            thisPtr.add(0x10).writePointer(accountPtr); // <Raw>k__BackingField
                            var ccd = getOrCreateCardControlData(cardId);
                            thisPtr.add(0x18).writePointer(ccd || NULL); // <Card>k__BackingField
                            thisPtr.add(0x20).writeS16(grade * 100 + level); // <IntensifyCode>
                            thisPtr.add(0x24).writeU32(0x3F800000); // <CardGradeBonusValue> = 1.0f
                            thisPtr.add(0x28).writeS32(100); // <SellPrice>
                            thisPtr.add(0x2C).writeU8(0); // isMaterial = false
                            var memberIdx = ((cardId - 1001) % 12) + 1;
                            thisPtr.add(0x30).writeS32(1001 * 10000 + 1 * 100 + memberIdx); // sortCardIndex
                            thisPtr.add(0x34).writeU8(0); // isNew = false
                            thisPtr.add(0x38).writeS32(1); // <ThemeLevel>
                            thisPtr.add(0x3C).writeU8(0); // isEquipLiveTheme = false
                            thisPtr.add(0x3E).writeS16(-1); // equipLiveThemeCode = -1
                            thisPtr.add(0x40).writePointer(NULL); // <themeCardItem>
                        } catch (eCicInner) {
                            log("[-] Error in CardItem..ctor hook: " + eCicInner.message);
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardItem..ctor (0xB55850)!");
                } catch (eCic) {
                    log("[-] Error replacing CardItem..ctor: " + eCic.message);
                }

                // Proxy CardControl.Find (0x11D66F4)
                try {
                    Interceptor.replace(baseAddr.add(0x11D66F4), new NativeCallback(function (code, methodInfo) {
                        if (code >= 1001 && code <= 1012) {
                            return getOrCreateCardControlData(code);
                        }
                        return NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on CardControl.Find (0x11D66F4)!");
                } catch (eCcf) {
                    log("[-] Error replacing CardControl.Find: " + eCcf.message);
                }

                // Replace CardControl.Data.get_IsMaterial (0xE4340C) -> false
                try {
                    Interceptor.replace(baseAddr.add(0xE4340C), new NativeCallback(function (thisPtr, methodInfo) {
                        return 0;
                    }, "int", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardControl.Data.get_IsMaterial (0xE4340C)!");
                } catch (eIm) {
                    log("[-] Error replacing CardControl.Data.get_IsMaterial: " + eIm.message);
                }

                // Proxy CardControl.Data.get_SmallImagePath (0xE43844)
                try {
                    Interceptor.replace(baseAddr.add(0xE43844), new NativeCallback(function (thisPtr, methodInfo) {
                        if (!thisPtr.isNull()) {
                            var ptr = thisPtr.add(0x58).readPointer();
                            if (!ptr.isNull()) return ptr;
                            var cd = thisPtr.add(0x10).readPointer();
                            var cId = (!cd.isNull()) ? cd.add(0x10).readS32() : 1001;
                            if (cId <= 0) cId = 1001;
                            var dp = createDownloadPath("asiudgasg/asodhsg/wadceg/" + cId + "_s.i.bytes");
                            if (dp && !dp.isNull()) {
                                thisPtr.add(0x58).writePointer(dp);
                                return dp;
                            }
                        }
                        return NULL;
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardControl.Data.get_SmallImagePath (0xE43844)!");
                } catch (eSip) {
                    log("[-] Error replacing CardControl.Data.get_SmallImagePath: " + eSip.message);
                }

                // Proxy CardControl.Data.get_LargeImagePath (0xE4391C)
                try {
                    Interceptor.replace(baseAddr.add(0xE4391C), new NativeCallback(function (thisPtr, methodInfo) {
                        if (!thisPtr.isNull()) {
                            var ptr = thisPtr.add(0x60).readPointer();
                            if (!ptr.isNull()) return ptr;
                            var cd = thisPtr.add(0x10).readPointer();
                            var cId = (!cd.isNull()) ? cd.add(0x10).readS32() : 1001;
                            if (cId <= 0) cId = 1001;
                            var dp = createDownloadPath("asiudgasg/asodhsg/wadceg/" + cId + "_l.i.bytes");
                            if (dp && !dp.isNull()) {
                                thisPtr.add(0x60).writePointer(dp);
                                return dp;
                            }
                        }
                        return NULL;
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardControl.Data.get_LargeImagePath (0xE4391C)!");
                } catch (eLip) {
                    log("[-] Error replacing CardControl.Data.get_LargeImagePath: " + eLip.message);
                }

                // Proxy CardControl.Data.get_ZoomUpCardImagePath (0xE439F4)
                try {
                    Interceptor.replace(baseAddr.add(0xE439F4), new NativeCallback(function (thisPtr, methodInfo) {
                        if (!thisPtr.isNull()) {
                            var ptr = thisPtr.add(0x68).readPointer();
                            if (!ptr.isNull()) return ptr;
                            var cd = thisPtr.add(0x10).readPointer();
                            var cId = (!cd.isNull()) ? cd.add(0x10).readS32() : 1001;
                            if (cId <= 0) cId = 1001;
                            var dp = createDownloadPath("asiudgasg/asodhsg/wadceg/" + cId + "_l.i.bytes");
                            if (dp && !dp.isNull()) {
                                thisPtr.add(0x68).writePointer(dp);
                                return dp;
                            }
                        }
                        return NULL;
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardControl.Data.get_ZoomUpCardImagePath (0xE439F4)!");
                } catch (eZip) {
                    log("[-] Error replacing CardControl.Data.get_ZoomUpCardImagePath: " + eZip.message);
                }

                // Proxy GroupControl.Find (0xB9EF94)
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
                    Interceptor.replace(baseAddr.add(0xC8ADD8), new NativeCallback(function (thisPtr, grade, type, methodInfo) {
                        return getGradeFrameDownloadPath(grade, type);
                    }, "pointer", ["pointer", "int", "int", "pointer"]));
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
                        for (var i = 1; i <= 12; i++) {
                            if (loonaArtistDataMap[i] && loonaArtistDataMap[i].equals(thisPtr)) return (i - 1);
                        }
                        return 0;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB3D4), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        for (var i = 1; i <= 12; i++) {
                            if (loonaArtistDataMap[i] && loonaArtistDataMap[i].equals(thisPtr)) {
                                return createIl2CppString(LOONA_MEMBERS[i - 1].name);
                            }
                        }
                        return createIl2CppString("HeeJin");
                    }, "pointer", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xEBB380), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        for (var i = 1; i <= 12; i++) {
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
                }

                // Direct byte patch on GroupItem.SetupLiveThemeItems (0xB577C8) -> ret
                try {
                    Memory.protect(baseAddr.add(0xB577C8), 4, "rwx");
                    baseAddr.add(0xB577C8).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.SetupLiveThemeItems (0xB577C8): ret");
                } catch (eSlt) {
                    log("[-] Error patching SetupLiveThemeItems: " + eSlt.message);
                }

                // Direct byte patch on GroupItem.GetCurrentLiveTheme (0xB56F90) -> mov w0, wzr; ret
                try {
                    Memory.protect(baseAddr.add(0xB56F90), 8, "rwx");
                    baseAddr.add(0xB56F90).writeByteArray([0xe0, 0x03, 0x1f, 0x2a, 0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.GetCurrentLiveTheme (0xB56F90): mov w0, wzr; ret");
                } catch (eGclt) {
                    log("[-] Error patching GetCurrentLiveTheme: " + eGclt.message);
                }

                // Direct byte patch on GroupItem.SetupCurrentLiveTheme (0xB59074) -> ret
                try {
                    Memory.protect(baseAddr.add(0xB59074), 4, "rwx");
                    baseAddr.add(0xB59074).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.SetupCurrentLiveTheme (0xB59074): ret");
                } catch (eSclt) {
                    log("[-] Error patching SetupCurrentLiveTheme: " + eSclt.message);
                }

                // Direct byte patch on CardBookControl.RegistWithCardItemMap (0x11C9A9C) -> ret
                try {
                    Memory.protect(baseAddr.add(0x11C9A9C), 4, "rwx");
                    baseAddr.add(0x11C9A9C).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on CardBookControl.RegistWithCardItemMap (0x11C9A9C): ret");
                } catch (eCbR) {
                    log("[-] Error patching RegistWithCardItemMap: " + eCbR.message);
                }

                // Direct byte patch on GroupItem.BonusCheck (0xB57C88) -> ret
                try {
                    Memory.protect(baseAddr.add(0xB57C88), 4, "rwx");
                    baseAddr.add(0xB57C88).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.BonusCheck (0xB57C88): ret");
                } catch (eBc) {
                    log("[-] Error patching BonusCheck: " + eBc.message);
                }

                // Direct byte patch on GroupItem.SetMajorGroup (0xB57BC4) -> ret
                try {
                    Memory.protect(baseAddr.add(0xB57BC4), 4, "rwx");
                    baseAddr.add(0xB57BC4).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.SetMajorGroup (0xB57BC4): ret");
                } catch (eSmg) {
                    log("[-] Error patching SetMajorGroup: " + eSmg.message);
                }

                // Replace GroupItem getters for name and emblem
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
                }

                // Direct byte patch on GroupItem.get_IsSubGroup (0xB56B2C) -> mov w0, wzr; ret
                try {
                    Memory.protect(baseAddr.add(0xB56B2C), 8, "rwx");
                    baseAddr.add(0xB56B2C).writeByteArray([0xe0, 0x03, 0x1f, 0x2a, 0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.get_IsSubGroup (0xB56B2C): mov w0, wzr; ret");
                } catch (eIsg) {
                    log("[-] Error patching GroupItem.get_IsSubGroup: " + eIsg.message);
                }

                // Direct byte patch on GroupItem.IsDisplayed (0xB59238) -> mov w0, #1; ret
                try {
                    Memory.protect(baseAddr.add(0xB59238), 8, "rwx");
                    baseAddr.add(0xB59238).writeByteArray([0x20, 0x00, 0x80, 0x52, 0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.IsDisplayed (0xB59238): mov w0, #1; ret");
                } catch (eIdp) {
                    log("[-] Error patching GroupItem.IsDisplayed: " + eIdp.message);
                }

                // Direct byte patches on CardControl.Data and PrismControl.Data getters to safely return valid defaults without null dereferences
                var cardGettersRetZero = [
                    0xE43328, // CardControl.Data.get_Type -> 0
                    0xE43344, // CardControl.Data.get_IsPrism -> 0
                    0xE43368, // CardControl.Data.get_Prism -> 0
                    0xE433D4, // CardControl.Data.get_IsSelectCard -> 0
                    0xE433F0, // CardControl.Data.get_IntensifyPercentage -> 0
                    0xE4340C, // CardControl.Data.get_IsMaterial -> 0
                    0xE435FC, // CardControl.Data.get_IsEquipCard -> 0
                    0xE43694, // CardControl.Data.get_GetCardBookScoreType -> 0
                    0xBD90BC, // PrismControl.Data.get_Code -> 0
                    0xBD90F4, // PrismControl.Data.get_ServerDataUse -> 0
                    0xB55F08, // CardItem.get_IsMaterialCard -> 0
                    0xB55F24  // CardItem.get_IsUnAvailableCard -> 0
                ];
                cardGettersRetZero.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 8, "rwx");
                        baseAddr.add(rva).writeByteArray([0xe0, 0x03, 0x1f, 0x2a, 0xc0, 0x03, 0x5f, 0xd6]); // mov w0, wzr; ret
                    } catch (e) {}
                });

                var cardGettersRetOne = [
                    0xE43660, // CardControl.Data.get_IsCardUseType -> 1
                    0xE436C8, // CardControl.Data.get_WithinPeriod -> 1
                    0xB55FC8  // CardItem.get_IsViewCard -> 1
                ];
                cardGettersRetOne.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 8, "rwx");
                        baseAddr.add(rva).writeByteArray([0x20, 0x00, 0x80, 0x52, 0xc0, 0x03, 0x5f, 0xd6]); // mov w0, #1; ret
                    } catch (e) {}
                });

                var cardGettersRetNull = [
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
                });

                // Direct branch patches to bypass Prism lookup in card view generation
                try {
                    // GetSmallCardViewData: 0xABECAC -> b 0xabed50 (+0xA4 bytes, 41 insns = 0x14000029)
                    Memory.protect(baseAddr.add(0xABECAC), 4, "rwx");
                    baseAddr.add(0xABECAC).writeByteArray([0x29, 0x00, 0x00, 0x14]);
                    log("[+] Byte patch at 0xABECAC: b 0xabed50 (bypass Prism in GetSmallCardViewData)");
                } catch (ePsm) {
                    log("[-] Error patching 0xABECAC: " + ePsm.message);
                }

                try {
                    // GetLargeCardViewData: 0xABE744 -> b 0xabe7e8 (+0xA4 bytes, 41 insns = 0x14000029)
                    Memory.protect(baseAddr.add(0xABE744), 4, "rwx");
                    baseAddr.add(0xABE744).writeByteArray([0x29, 0x00, 0x00, 0x14]);
                    log("[+] Byte patch at 0xABE744: b 0xabe7e8 (bypass Prism in GetLargeCardViewData)");
                } catch (ePlg) {
                    log("[-] Error patching 0xABE744: " + ePlg.message);
                }

                // Direct byte patch on GroupItem.BonusCheck (0xB57C88) -> ret
                try {
                    Memory.protect(baseAddr.add(0xB57C88), 4, "rwx");
                    baseAddr.add(0xB57C88).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GroupItem.BonusCheck (0xB57C88): ret");
                } catch (eBc) {}

                // =========================================================================
                // INVENTORY STABILIZATION HOOKS & PROXIES
                // =========================================================================
                // 1. GroupItem..ctor (0xB56EF4) - Safe replacement that never throws NullReferenceException
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
                    }, "void", ["pointer", "int", "pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupItem..ctor (0xB56EF4)!");
                } catch (eGic) {
                    log("[-] Error replacing GroupItem..ctor: " + eGic.message);
                }

                // 2. ArtistControl.Data.get_ArtistType (0xEBB7A8) -> return 0 (Active artist)
                try {
                    Interceptor.replace(baseAddr.add(0xEBB7A8), new NativeCallback(function (thisPtr, methodInfo) {
                        return 0;
                    }, "int16", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ArtistControl.Data.get_ArtistType (0xEBB7A8) -> 0");
                } catch (eAt) {
                    log("[-] Error replacing get_ArtistType: " + eAt.message);
                }

                // 3. GroupControl.Data.get_ArtistList (0xCA5054) -> return loonaArtistListFastArray
                try {
                    Interceptor.replace(baseAddr.add(0xCA5054), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        return loonaArtistListFastArray || NULL;
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupControl.Data.get_ArtistList (0xCA5054)!");
                } catch (eGal) {
                    log("[-] Error replacing get_ArtistList: " + eGal.message);
                }

                // 4. InventoryControl.FindToGroupItem (0xF29604) -> return loonaGroupItemObj
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
                }

                function createMockSmallCardParams(cardId, grade, level) {
                    try {
                        var csvParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "CardSmallView/Params");
                        if (!csvParamsKlass || csvParamsKlass.isNull()) return NULL;
                        var p = il2cpp_object_new(csvParamsKlass);
                        if (!p || p.isNull()) return NULL;

                        var photoDp = createDownloadPath("asiudgasg/asodhsg/wadceg/" + cardId + "_s.i.bytes");
                        var tierDp = getGradeFrameDownloadPath(grade, 1);

                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(tierDp || NULL);
                        p.add(0x20).writeU8(0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(NULL);
                        p.add(0x38).writeU8(0);
                        p.add(0x3C).writeS32(grade);
                        p.add(0x40).writeU8(grade === 4 ? 1 : 0);
                        p.add(0x41).writeU8(0);
                        p.add(0x44).writeS32(50);
                        p.add(0x48).writeS32(level);
                        p.add(0x4C).writeU8(0);
                        p.add(0x4E).writeS16(0);
                        p.add(0x50).writeU8(1); // isEquip
                        p.add(0x51).writeU8(0);
                        p.add(0x52).writeU8(0);
                        p.add(0x53).writeU8(0);
                        p.add(0x54).writeU8(0);
                        p.add(0x55).writeU8(0);
                        p.add(0x56).writeU8(0);
                        p.add(0x57).writeU8(0);
                        return p;
                    } catch (eMscp) {
                        log("[-] Error in createMockSmallCardParams: " + eMscp.message);
                        return NULL;
                    }
                }

                function createMockLargeCardParams(cardId, grade, level) {
                    try {
                        var clvParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "CardLargeView/Params");
                        if (!clvParamsKlass || clvParamsKlass.isNull()) return NULL;
                        var p = il2cpp_object_new(clvParamsKlass);
                        if (!p || p.isNull()) return NULL;

                        var photoDp = createDownloadPath("asiudgasg/asodhsg/wadceg/" + cardId + "_l.i.bytes");
                        var tierDp = getGradeFrameDownloadPath(grade, 0);

                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(tierDp || NULL);
                        p.add(0x20).writeU8(0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(NULL);
                        p.add(0x38).writeU8(0);
                        p.add(0x3C).writeS32(grade);
                        p.add(0x40).writeU8(grade === 4 ? 1 : 0);
                        p.add(0x41).writeU8(0);
                        p.add(0x44).writeS32(50);
                        p.add(0x48).writeS32(level);
                        p.add(0x4C).writeU8(0);
                        p.add(0x4E).writeS16(0);
                        p.add(0x50).writeU8(1);
                        p.add(0x51).writeU8(0);
                        p.add(0x52).writeU8(0);
                        p.add(0x53).writeU8(0);
                        p.add(0x54).writeU8(0);
                        p.add(0x55).writeU8(0);
                        p.add(0x56).writeU8(0);
                        p.add(0x57).writeU8(0);
                        p.add(0x58).writeU8(0);
                        p.add(0x59).writeU8(0);
                        p.add(0x5A).writeU8(0);
                        return p;
                    } catch (eMlcp) {
                        log("[-] Error in createMockLargeCardParams: " + eMlcp.message);
                        return NULL;
                    }
                }

                // 6. ViewControl.GetSmallCardViewData (0xABEB30)
                try {
                    Interceptor.replace(baseAddr.add(0xABEB30), new NativeCallback(function (cardItem, artistData, isViewCard, methodInfo) {
                        ensureLoonaMocks();
                        try {
                            var cId = 1001;
                            var gr = 4;
                            var lvl = 50;
                            try {
                                if (cardItem && !cardItem.isNull()) {
                                    var raw = cardItem.add(0x10).readPointer();
                                    if (!raw.isNull()) {
                                        cId = raw.add(0x20).readS32();
                                        gr = raw.add(0x24).readS32();
                                        lvl = raw.add(0x1C).readS16();
                                    }
                                }
                            } catch (e) {}
                            return createMockSmallCardParams(cId, gr, lvl);
                        } catch (eGscv) {
                            log("[-] Error in GetSmallCardViewData proxy: " + eGscv.message);
                            return NULL;
                        }
                    }, "pointer", ["pointer", "pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on ViewControl.GetSmallCardViewData (0xABEB30)!");
                } catch (eGscvRep) {
                    log("[-] Error replacing GetSmallCardViewData: " + eGscvRep.message);
                }

                // 7. ViewControl.GetLargeCardViewData (0xABE5FC)
                try {
                    Interceptor.replace(baseAddr.add(0xABE5FC), new NativeCallback(function (cardItem, artistData, isViewCard, methodInfo) {
                        ensureLoonaMocks();
                        try {
                            var cId = 1001;
                            var gr = 4;
                            var lvl = 50;
                            try {
                                if (cardItem && !cardItem.isNull()) {
                                    var raw = cardItem.add(0x10).readPointer();
                                    if (!raw.isNull()) {
                                        cId = raw.add(0x20).readS32();
                                        gr = raw.add(0x24).readS32();
                                        lvl = raw.add(0x1C).readS16();
                                    }
                                }
                            } catch (e) {}
                            return createMockLargeCardParams(cId, gr, lvl);
                        } catch (eGlcv) {
                            log("[-] Error in GetLargeCardViewData proxy: " + eGlcv.message);
                            return NULL;
                        }
                    }, "pointer", ["pointer", "pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on ViewControl.GetLargeCardViewData (0xABE5FC)!");
                } catch (eGlcvRep) {
                    log("[-] Error replacing GetLargeCardViewData: " + eGlcvRep.message);
                }

                // 8. InventoryScene.GetGroupViewData (0x105E8E4) -> Safe InvenGroupItemView.Params generator
                try {
                    var getGroupViewDataAddr = baseAddr.add(0x105E8E4);
                    Interceptor.replace(getGroupViewDataAddr, new NativeCallback(function (sceneThis, groupItem, shared, methodInfo) {
                        try {
                            log("[🃏 GROUP_VIEW] GetGroupViewData entered for groupItem: " + groupItem);
                            var p = shared;
                            if (!p || p.isNull()) {
                                var paramsKlassSlot = baseAddr.add(0x3115188).readPointer();
                                var paramsKlass = !paramsKlassSlot.isNull() ? paramsKlassSlot.readPointer() : NULL;
                                if (paramsKlass && !paramsKlass.isNull()) {
                                    p = il2cpp_object_new(paramsKlass);
                                }
                            }
                            if (!p || p.isNull()) {
                                log("[-] Failed to get InvenGroupItemView.Params object!");
                                return NULL;
                            }

                            // Populate fields
                            p.add(0x10).writePointer(createIl2CppString("LOONA"));
                            p.add(0x18).writeS32(12); // memberCount
                            p.add(0x1C).writeS32(0);  // summaryCount

                            // 1. exposeArtistIndexList: List<int>
                            try {
                                var intListKlassSlot = baseAddr.add(0x30EF598).readPointer();
                                var intListKlass = !intListKlassSlot.isNull() ? intListKlassSlot.readPointer() : NULL;
                                var intListObj = (intListKlass && !intListKlass.isNull()) ? il2cpp_object_new(intListKlass) : NULL;
                                if (intListObj && !intListObj.isNull()) {
                                    var ctorMethodSlot = baseAddr.add(0x310BAA0).readPointer();
                                    var ctorMethod = !ctorMethodSlot.isNull() ? ctorMethodSlot.readPointer() : NULL;
                                    var listCtorFn = new NativeFunction(baseAddr.add(0x2494E98), "void", ["pointer", "int", "pointer"]);
                                    listCtorFn(intListObj, 12, ctorMethod);
                                    var addMethodSlot = baseAddr.add(0x314BC0).readPointer();
                                    var addMethod = !addMethodSlot.isNull() ? addMethodSlot.readPointer() : NULL;
                                    var listAddFn = new NativeFunction(baseAddr.add(0x2495BA0), "void", ["pointer", "int", "pointer"]);
                                    for (var i = 0; i < 12; i++) {
                                        listAddFn(intListObj, i, addMethod);
                                    }
                                    p.add(0x20).writePointer(intListObj);
                                }
                            } catch (eIl) {}

                            // 2. cardParams: List<CardSmallView.Params>
                            try {
                                var cardParamsListKlassSlot = baseAddr.add(0x3132B38).readPointer();
                                var cardParamsListKlass = !cardParamsListKlassSlot.isNull() ? cardParamsListKlassSlot.readPointer() : NULL;
                                var cardParamsListObj = (cardParamsListKlass && !cardParamsListKlass.isNull()) ? il2cpp_object_new(cardParamsListKlass) : NULL;
                                if (cardParamsListObj && !cardParamsListObj.isNull()) {
                                    var ctorMethodSlot = baseAddr.add(0x31275B0).readPointer();
                                    var ctorMethod = !ctorMethodSlot.isNull() ? ctorMethodSlot.readPointer() : NULL;
                                    var listCtorFn = new NativeFunction(baseAddr.add(0x23CD880), "void", ["pointer", "int", "pointer"]);
                                    listCtorFn(cardParamsListObj, 12, ctorMethod);
                                    var addMethodSlot = baseAddr.add(0x3130588).readPointer();
                                    var addMethod = !addMethodSlot.isNull() ? addMethodSlot.readPointer() : NULL;
                                    var listAddFn = new NativeFunction(baseAddr.add(0x23CE41C), "void", ["pointer", "pointer", "pointer"]);
                                    for (var ci = 0; ci < 12; ci++) {
                                        var cardId = 1001 + ci;
                                        var smParam = createMockSmallCardParams(cardId, 4, 50);
                                        listAddFn(cardParamsListObj, smParam, addMethod);
                                    }
                                    p.add(0x28).writePointer(cardParamsListObj);
                                }
                            } catch (eCp) {}

                            // 3. summary: List<string> (empty list)
                            try {
                                var strListKlassSlot = baseAddr.add(0x31222C0).readPointer();
                                var strListKlass = !strListKlassSlot.isNull() ? strListKlassSlot.readPointer() : NULL;
                                var strListObj = (strListKlass && !strListKlass.isNull()) ? il2cpp_object_new(strListKlass) : NULL;
                                if (strListObj && !strListObj.isNull()) {
                                    var ctorMethodSlot = baseAddr.add(0x3126CD8).readPointer();
                                    var ctorMethod = !ctorMethodSlot.isNull() ? ctorMethodSlot.readPointer() : NULL;
                                    var listCtorFn = new NativeFunction(baseAddr.add(0x23CD880), "void", ["pointer", "int", "pointer"]);
                                    listCtorFn(strListObj, 0, ctorMethod);
                                    p.add(0x30).writePointer(strListObj);
                                }
                            } catch (eSl) {}

                            // 4. Texts & values
                            p.add(0x38).writePointer(createIl2CppString("GRADE"));
                            p.add(0x40).writePointer(createIl2CppString("-"));
                            p.add(0x48).writeS32(4); // gradeValue
                            p.add(0x4C).writeS32(0); // gradeScore
                            p.add(0x50).writePointer(createIl2CppString("THEME"));
                            p.add(0x58).writePointer(createIl2CppString("-"));
                            p.add(0x60).writeS32(1); // themeLevel
                            p.add(0x68).writePointer(NULL);
                            p.add(0x70).writePointer(createIl2CppString("Hi High"));
                            p.add(0x78).writePointer(createIl2CppString("AUTO EQUIP"));
                            p.add(0x80).writePointer(NULL); // LOONA has no sub-groups!
                            p.add(0x88).writePointer(createIl2CppString("UNEQUIP ALL"));
                            p.add(0x90).writePointer(createIl2CppString("EQUIP"));
                            p.add(0x98).writePointer(createIl2CppString("MUSIC"));

                            log("[✅ GROUP_VIEW] GetGroupViewData populated successfully!");
                            return p;
                        } catch (eGvd) {
                            log("[-] Error in GetGroupViewData replacement: " + eGvd.message);
                            return shared || NULL;
                        }
                    }, "pointer", ["pointer", "pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GetGroupViewData (0x105E8E4)!");
                } catch (eHgvd) {
                    log("[-] Error replacing GetGroupViewData: " + eHgvd.message);
                }

                // 9. InvenGroupItemView.Refresh (0xF23954) -> Safe replacement
                try {
                    Interceptor.replace(baseAddr.add(0xF23954), new NativeCallback(function (view, p, methodInfo) {
                        try {
                            log("[🃏 GROUP_ITEM_VIEW] Safe Refresh called! view: " + view + ", p: " + p);
                            if (view.isNull() || p.isNull()) return;

                            // 1. Set group name text ("LOONA")
                            try {
                                var groupName = view.add(0x48).readPointer();
                                if (!groupName.isNull()) {
                                    var nameStr = p.add(0x10).readPointer();
                                    if (!nameStr.isNull()) {
                                        var textVTable = groupName.readPointer();
                                        var setTextFn = new NativeFunction(textVTable.add(0x5E8).readPointer(), "void", ["pointer", "pointer", "pointer"]);
                                        setTextFn(groupName, nameStr, textVTable.add(0x5F0).readPointer());
                                    }
                                }
                            } catch (eGn) {}

                            // 2. Set cardList cards
                            try {
                                var cardList = view.add(0x60).readPointer();
                                if (!cardList.isNull()) {
                                    var cardCount = cardList.add(0x18).readS32();
                                    var cardItemsPtr = cardList.add(0x10).readPointer();
                                    log("[🃏 GROUP_ITEM_VIEW] Populating " + cardCount + " cards in cardList directly...");
                                    var cardRefreshFn = new NativeFunction(baseAddr.add(0x137F570), "void", ["pointer", "pointer", "pointer"]);
                                    for (var i = 0; i < cardCount; i++) {
                                        var cardSmallView = cardItemsPtr.add(0x20 + i * 8).readPointer();
                                        if (!cardSmallView.isNull()) {
                                            var cId = 1001 + (i % 12);
                                            var cardParam = createMockSmallCardParams(cId, 4, 50);
                                            if (cardParam && !cardParam.isNull()) {
                                                cardRefreshFn(cardSmallView, cardParam, NULL);
                                            }
                                        }
                                    }
                                }
                            } catch (eCl) {
                                log("[-] Error populating cardList: " + eCl.message);
                            }

                            // 3. Hide selectSubGroup button
                            try {
                                var subGroupGo = view.add(0x108).readPointer();
                                if (!subGroupGo.isNull()) {
                                    var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);
                                    setActiveFn(subGroupGo, 0, NULL);
                                }
                            } catch (eSg) {}

                            // 4. Set grade text
                            try {
                                var gradeText = view.add(0xA0).readPointer();
                                if (!gradeText.isNull()) {
                                    var textVTable = gradeText.readPointer();
                                    var setTextFn = new NativeFunction(textVTable.add(0x5E8).readPointer(), "void", ["pointer", "pointer", "pointer"]);
                                    setTextFn(gradeText, createIl2CppString("R"), textVTable.add(0x5F0).readPointer());
                                }
                            } catch (eGt) {}

                            // 5. Set theme text
                            try {
                                var themeText = view.add(0xD8).readPointer();
                                if (!themeText.isNull()) {
                                    var textVTable = themeText.readPointer();
                                    var setTextFn = new NativeFunction(textVTable.add(0x5E8).readPointer(), "void", ["pointer", "pointer", "pointer"]);
                                    setTextFn(themeText, createIl2CppString("Hi High"), textVTable.add(0x5F0).readPointer());
                                }
                            } catch (eTt) {}

                            // 6. Clear & hide summary texts for LOONA OT12 (removes "Summary Summary Summary")
                            try {
                                var summaryArr = view.add(0x68).readPointer();
                                if (!summaryArr.isNull()) {
                                    var sLen = summaryArr.add(0x18).readS32();
                                    var emptyStr = createIl2CppString("");
                                    var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                    var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);
                                    for (var si = 0; si < sLen; si++) {
                                        var txtObj = summaryArr.add(0x20 + si * 8).readPointer();
                                        if (!txtObj.isNull()) {
                                            var textVTable = txtObj.readPointer();
                                            var setTextFn = new NativeFunction(textVTable.add(0x5E8).readPointer(), "void", ["pointer", "pointer", "pointer"]);
                                            setTextFn(txtObj, emptyStr, textVTable.add(0x5F0).readPointer());
                                            var txtGo = getGoFn(txtObj, NULL);
                                            if (!txtGo.isNull()) {
                                                setActiveFn(txtGo, 0, NULL);
                                            }
                                        }
                                    }
                                }
                            } catch (eSum) {}

                            log("[✅ GROUP_ITEM_VIEW] Safe Refresh completed successfully!");
                        } catch (eGiv) {
                            log("[-] Error in InvenGroupItemView.Refresh replacement: " + eGiv.message);
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InvenGroupItemView.Refresh (0xF23954)!");
                } catch (eSdh) {
                    log("[-] Error replacing Refresh: " + eSdh.message);
                }

                // 10. URLsControl.SetCdnTexture (0x163A9E8) -> Native Texture2D loader with disk cache
                var loadedTextureCache = {};

                function loadLocalTexture2D(relPath) {
                    if (loadedTextureCache[relPath]) {
                        return loadedTextureCache[relPath];
                    }
                    try {
                        var basePath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/";
                        var fullPath = basePath + relPath;

                        var readAllBytesMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllBytes", 1);
                        var fileExistsMethod = findMethod("mscorlib", "System.IO", "File", "Exists", 1);
                        if (!readAllBytesMethod || readAllBytesMethod.isNull()) return NULL;

                        var args1 = Memory.alloc(Process.pointerSize);
                        var exc = Memory.alloc(Process.pointerSize);
                        exc.writePointer(NULL);

                        // Try primary path
                        args1.writePointer(createIl2CppString(fullPath));
                        var existsObj = il2cpp_runtime_invoke(fileExistsMethod, NULL, args1, exc);
                        var exists = (!existsObj.isNull()) ? existsObj.add(0x10).readU8() : 0;

                        if (!exists) {
                            fullPath = fullPath + ".png";
                            args1.writePointer(createIl2CppString(fullPath));
                            existsObj = il2cpp_runtime_invoke(fileExistsMethod, NULL, args1, exc);
                            exists = (!existsObj.isNull()) ? existsObj.add(0x10).readU8() : 0;
                        }

                        if (!exists && relPath.indexOf(".i.bytes") !== -1) {
                            fullPath = basePath + relPath.replace(".i.bytes", ".png");
                            args1.writePointer(createIl2CppString(fullPath));
                            existsObj = il2cpp_runtime_invoke(fileExistsMethod, NULL, args1, exc);
                            exists = (!existsObj.isNull()) ? existsObj.add(0x10).readU8() : 0;
                        }

                        if (!exists) {
                            return NULL;
                        }

                        var bytesObj = il2cpp_runtime_invoke(readAllBytesMethod, NULL, args1, exc);
                        if (!bytesObj || bytesObj.isNull()) return NULL;

                        // Create Texture2D(2, 2)
                        var tex2dClass = getClass("UnityEngine.CoreModule", "UnityEngine", "Texture2D");
                        var texObj = il2cpp_object_new(tex2dClass);
                        var texCtor = findMethod("UnityEngine.CoreModule", "UnityEngine", "Texture2D", ".ctor", 2);
                        var pWidth = Memory.alloc(4);
                        pWidth.writeInt(2);
                        var pHeight = Memory.alloc(4);
                        pHeight.writeInt(2);
                        var argsCtor = Memory.alloc(Process.pointerSize * 2);
                        argsCtor.writePointer(pWidth);
                        argsCtor.add(Process.pointerSize).writePointer(pHeight);
                        il2cpp_runtime_invoke(texCtor, texObj, argsCtor, exc);

                        // ImageConversion.LoadImage(texObj, bytesObj)
                        var loadImagePtr = baseAddr.add(0x25B3E90);
                        var loadImageFn = new NativeFunction(loadImagePtr, "int", ["pointer", "pointer"]);
                        var ok = loadImageFn(texObj, bytesObj);
                        if (ok) {
                            loadedTextureCache[relPath] = texObj;
                            log("[🖼️ TEXTURE] Loaded and cached: " + relPath);
                            return texObj;
                        }
                    } catch (eLt) {
                        log("[-] Error in loadLocalTexture2D for " + relPath + ": " + eLt.message);
                    }
                    return NULL;
                }

                try {
                    var setCdnTextureAddr = baseAddr.add(0x163A9E8);
                    Interceptor.replace(setCdnTextureAddr, new NativeCallback(function (target, path, emptyTexture, handleResult, autoSize, autoEnabled, processing, methodInfo) {
                        try {
                            if (target.isNull()) return NULL;
                            if (path.isNull()) {
                                if (!emptyTexture.isNull()) {
                                    var setTexFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                    setTexFn(target, emptyTexture, NULL);
                                }
                                return NULL;
                            }

                            // Read relative path from DownloadPath offset 0x18
                            var fpPtr = path.add(0x18).readPointer();
                            var relPath = "";
                            if (!fpPtr.isNull()) {
                                var len = fpPtr.add(0x10).readS32();
                                if (len > 0) {
                                    relPath = fpPtr.add(0x14).readUtf16String(len);
                                }
                            }
                            if (!relPath || relPath.length === 0) {
                                var urlPtr = path.add(0x10).readPointer();
                                if (!urlPtr.isNull()) {
                                    var uLen = urlPtr.add(0x10).readS32();
                                    if (uLen > 0) {
                                        var fullUrl = urlPtr.add(0x14).readUtf16String(uLen);
                                        var idx = fullUrl.indexOf("asiudgasg/");
                                        if (idx !== -1) relPath = fullUrl.substring(idx);
                                    }
                                }
                            }

                            if (!relPath || relPath.length === 0) return NULL;

                            // Ownership Check: wadceg vs sdhgauwehdnu
                            if (relPath.indexOf("wadceg/") !== -1 || relPath.indexOf("sdhgauwehdnu/") !== -1) {
                                var match = relPath.match(/(\d+)_([sl])\.i\.bytes/);
                                if (match) {
                                    var cId = parseInt(match[1]);
                                    var sz = match[2];
                                    if (accountOwnedCards[cId]) {
                                        relPath = "asiudgasg/asodhsg/wadceg/" + cId + "_" + sz + ".i.bytes";
                                    } else {
                                        relPath = "asiudgasg/asodhsg/sdhgauwehdnu/" + cId + "_" + sz + ".i.bytes";
                                    }
                                }
                            }

                            // Load texture from disk or cache
                            var tex = loadLocalTexture2D(relPath);
                            if (!tex || tex.isNull()) {
                                if (!emptyTexture.isNull()) tex = emptyTexture;
                            }

                            if (tex && !tex.isNull()) {
                                // RawImage.set_texture(target, tex)
                                var setTextureFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                setTextureFn(target, tex, NULL);

                                // Activate RawImage GameObject
                                var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                var targetGo = getGoFn(target, NULL);
                                if (!targetGo.isNull()) {
                                    var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);
                                    setActiveFn(targetGo, 1, NULL);
                                }

                                // Trigger handleResult callback: <OnRefresh>b__47_0 (PhotoVisible) / b__47_1 (TierVisible)
                                if (!handleResult.isNull()) {
                                    var cbPtr = handleResult.add(0x18).readPointer();
                                    if (!cbPtr.isNull()) {
                                        var cbFn = new NativeFunction(cbPtr, "void", ["pointer", "int", "pointer", "pointer"]);
                                        cbFn(handleResult.add(0x10).readPointer(), 1, tex, NULL);
                                    }
                                }
                            }
                        } catch (eSct) {
                            log("[-] Error in SetCdnTexture replacement: " + eSct.message);
                        }
                        return NULL;
                    }, "pointer", ["pointer", "pointer", "pointer", "pointer", "int", "int", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on URLsControl.SetCdnTexture (0x163A9E8)!");
                } catch (eHsct) {
                    log("[-] Error replacing SetCdnTexture: " + eHsct.message);
                }

                // CardBook Stabilization Patches
                // 1. CardBookView.SetTabView (0x11CF5BC) -> mov w0, #1; ret
                try {
                    Memory.protect(baseAddr.add(0x11CF5BC), 8, "rwx");
                    baseAddr.add(0x11CF5BC).writeByteArray([0x20, 0x00, 0x80, 0x52, 0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on CardBookView.SetTabView (0x11CF5BC): mov w0, #1; ret");
                } catch (eStv) {
                    log("[-] Error patching SetTabView: " + eStv.message);
                }

                // 2. CardBookView.InitTabObjectSetting (0x11D431C) -> ret
                try {
                    Memory.protect(baseAddr.add(0x11D431C), 4, "rwx");
                    baseAddr.add(0x11D431C).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on CardBookView.InitTabObjectSetting (0x11D431C): ret");
                } catch (eItos) {
                    log("[-] Error patching InitTabObjectSetting: " + eItos.message);
                }

                // 3. CardBookScene.SetStateWait (0x11CF4E0) -> b 0x11cf528 (+0x48 bytes = 0x14000012)
                try {
                    Memory.protect(baseAddr.add(0x11CF4E0), 4, "rwx");
                    baseAddr.add(0x11CF4E0).writeByteArray([0x12, 0x00, 0x00, 0x14]);
                    log("[+] Byte patch on CardBookScene.SetStateWait (0x11CF4E0): b 0x11cf528");
                } catch (eSsw) {
                    log("[-] Error patching SetStateWait: " + eSsw.message);
                }

                // 4. CardBookScene UI Refresh Safety Patches (guard against NullReferenceException)
                var cardBookSafetyRetRVAs = [
                    0x11D0CD4, // CardBookScene.RefreshLiveBookBtn -> ret
                    0x11D0B64, // CardBookScene.RefreshAchieveNewMark -> ret
                    0x11D0C1C, // CardBookScene.RefreshGroupNewMark -> ret
                    0x11CFB80, // CardBookScene.RefreshOthers -> ret
                    0x11CFE18, // CardBookScene.RefreshBestCardBook -> ret
                    0x11D0048, // CardBookScene.RefreshFavoriteGroupFive -> ret
                    0x11D0300, // CardBookScene.RefreshCollection -> ret
                    0x11CF768, // CardBookScene.RefreshSetGroupViewPage -> ret
                    0x11CFB40, // CardBookScene.RefreshGroup -> ret
                    0x11CFDD8  // CardBookScene.RefreshSetMainView -> ret
                ];
                cardBookSafetyRetRVAs.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 4, "rwx");
                        baseAddr.add(rva).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    } catch (eRva) {}
                });
                log("[+] Patched " + cardBookSafetyRetRVAs.length + " CardBookScene refresh methods to ret");

                // 5. CardBookScene.<SetStateWait>b__0 (0xE43148) -> ldp x29, x30, [sp, #0x10]; ldp x20, x19, [sp], #0x20; ret
                try {
                    Memory.protect(baseAddr.add(0xE43148), 12, "rwx");
                    baseAddr.add(0xE43148).writeByteArray([0xfd, 0x7b, 0x41, 0xa9, 0xf4, 0x4f, 0xc2, 0xa8, 0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on CardBookScene.<SetStateWait>b__0 (0xE43148): early return epilogue");
                } catch (eSswb) {
                    log("[-] Error patching <SetStateWait>b__0: " + eSswb.message);
                }

                // 6. CardBookScene.OnBack (0x11CEF00) -> b 0x11cef24 (+0x24 bytes = 0x14000009)
                // Avoid NullReferenceException when CardBookControl.SharedInfo is null, safely navigating back to PrevSceneId
                try {
                    Memory.protect(baseAddr.add(0x11CEF00), 4, "rwx");
                    baseAddr.add(0x11CEF00).writeByteArray([0x09, 0x00, 0x00, 0x14]);
                    log("[+] Byte patch on CardBookScene.OnBack (0x11CEF00): b 0x11cef24");
                } catch (eObp) {
                    log("[-] Error patching CardBookScene.OnBack: " + eObp.message);
                }

                // 7. CardBookScene.OnClose (0x11CE97C) -> ret
                // Prevent crash during scene unload when unbinding null views/delegates or calling uninitialized favorites
                try {
                    Memory.protect(baseAddr.add(0x11CE97C), 4, "rwx");
                    baseAddr.add(0x11CE97C).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on CardBookScene.OnClose (0x11CE97C): ret");
                } catch (eOcp) {
                    log("[-] Error patching CardBookScene.OnClose: " + eOcp.message);
                }

                // 8. CardBookControl.SaveFavoriteList (0x11C722C) -> ret
                try {
                    Memory.protect(baseAddr.add(0x11C722C), 4, "rwx");
                    baseAddr.add(0x11C722C).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on CardBookControl.SaveFavoriteList (0x11C722C): ret");
                } catch (eSfl) {
                    log("[-] Error patching SaveFavoriteList: " + eSfl.message);
                }

                // 9. CardBookControl.VerifyFavoriteGroupCode (0x11C6CEC) -> mov w0, #1; ret
                try {
                    Memory.protect(baseAddr.add(0x11C6CEC), 8, "rwx");
                    baseAddr.add(0x11C6CEC).writeByteArray([0x20, 0x00, 0x80, 0x52, 0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on CardBookControl.VerifyFavoriteGroupCode (0x11C6CEC): mov w0, #1; ret");
                } catch (eVfgc) {
                    log("[-] Error patching VerifyFavoriteGroupCode: " + eVfgc.message);
                }

                // Proxy CardControl.Data primary identity getters
                try {
                    var originalCardGetCode = new NativeFunction(baseAddr.add(0xE429E4), "int", ["pointer", "pointer"]);
                    Interceptor.replace(baseAddr.add(0xE429E4), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            var modelPtr = thisPtr.add(0x10).readPointer();
                            if (!modelPtr.isNull()) return originalCardGetCode(thisPtr, methodInfo);
                            for (var cid in loonaCardControlDataMap) {
                                if (loonaCardControlDataMap[cid].equals(thisPtr)) return parseInt(cid, 10);
                            }
                        } catch (e) {}
                        return 1001;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xE43284), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1001;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xE432A0), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (!thisPtr.isNull()) {
                                var modelPtr = thisPtr.add(0x10).readPointer();
                                if (!modelPtr.isNull()) {
                                    var art = modelPtr.add(0x74).readS32();
                                    if (art >= 1 && art <= 12) return art;
                                }
                                for (var cid in loonaCardControlDataMap) {
                                    if (loonaCardControlDataMap[cid] && loonaCardControlDataMap[cid].equals(thisPtr)) {
                                        var cNum = parseInt(cid, 10);
                                        return ((cNum - 1001) % 12) + 1;
                                    }
                                }
                            }
                        } catch (e) {}
                        return 1;
                    }, "int", ["pointer", "pointer"]));

                    Interceptor.replace(baseAddr.add(0xE432BC), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1001;
                    }, "int", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardControl.Data identity getters (clean non-recursive)!");
                } catch (eCcdg) {
                    log("[-] Error replacing CardControl.Data identity getters: " + eCcdg.message);
                }

                // Replace InventoryControl.SetCurrentGroup (0xF2B810) to safely guard against ArgumentOutOfRangeException
                try {
                    Interceptor.replace(baseAddr.add(0xF2B810), new NativeCallback(function (index, subIndex, methodInfo) {
                        log("[🃏 INVENTORY] SetCurrentGroup(index=" + index + ", subIndex=" + subIndex + ") called!");
                        try {
                            var setSelectedGroupCodeFn = new NativeFunction(baseAddr.add(0xF26FBC), "void", ["int", "pointer"]);
                            setSelectedGroupCodeFn(1001, NULL);
                            log("[🃏 INVENTORY] SetCurrentGroup: set SelectedGroupCode to 1001!");
                        } catch (eScgInner) {
                            log("[-] Error setting SelectedGroupCode: " + eScgInner.message);
                        }
                    }, "void", ["int", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.SetCurrentGroup (0xF2B810)!");
                } catch (eScg) {
                    log("[-] Error replacing InventoryControl.SetCurrentGroup: " + eScg.message);
                }

                // Proxy InventoryControl.FindToGroupItem (0xF29604)
                try {
                    Interceptor.replace(baseAddr.add(0xF29604), new NativeCallback(function (groupCode, methodInfo) {
                        if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                            return loonaGroupItemObj;
                        }
                        return NULL;
                    }, "pointer", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.FindToGroupItem (0xF29604)!");
                } catch (eFtgi) {
                    log("[-] Error replacing FindToGroupItem: " + eFtgi.message);
                }

                // Proxy InventoryControl.get_SelectedGroupCode (0xF26F64)
                try {
                    Interceptor.replace(baseAddr.add(0xF26F64), new NativeCallback(function (methodInfo) {
                        return 1001;
                    }, "int", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_SelectedGroupCode (0xF26F64)!");
                } catch (eSgc) {
                    log("[-] Error replacing get_SelectedGroupCode: " + eSgc.message);
                }

                // Proxy InventoryControl.get_selectedGroupCode (0xF26C40)
                try {
                    Interceptor.replace(baseAddr.add(0xF26C40), new NativeCallback(function (methodInfo) {
                        return 1001;
                    }, "int", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_selectedGroupCode (0xF26C40)!");
                } catch (eSgc2) {
                    log("[-] Error replacing get_selectedGroupCode: " + eSgc2.message);
                }

                // Proxy GroupControl.Data.get_EmblemPath (0xCA4F3C)
                try {
                    Interceptor.replace(baseAddr.add(0xCA4F3C), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupControl.Data.get_EmblemPath (0xCA4F3C)!");
                } catch (eGep) {
                    log("[-] Error replacing GroupControl.Data.get_EmblemPath: " + eGep.message);
                }

                // Proxy ThemeControl.Data.get_SmallNameImagePath (0xC89BCC)
                try {
                    Interceptor.replace(baseAddr.add(0xC89BCC), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_SmallNameImagePath (0xC89BCC)!");
                } catch (eTip) {
                    log("[-] Error replacing ThemeControl.Data.get_SmallNameImagePath: " + eTip.message);
                }

                // Proxy ThemeControl.Data.get_LargeNameImagePath (0xC89CA4)
                try {
                    Interceptor.replace(baseAddr.add(0xC89CA4), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_LargeNameImagePath (0xC89CA4)!");
                } catch (eLnip) {
                    log("[-] Error replacing ThemeControl.Data.get_LargeNameImagePath: " + eLnip.message);
                }

                // Proxy ThemeControl.Data.get_ZoomNameImagePath (0xC89D7C)
                try {
                    Interceptor.replace(baseAddr.add(0xC89D7C), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_ZoomNameImagePath (0xC89D7C)!");
                } catch (eZnip) {
                    log("[-] Error replacing ThemeControl.Data.get_ZoomNameImagePath: " + eZnip.message);
                }

                // Bypass InventoryControl.GroupItem.ExtractPath (0xB5950C)
                try {
                    Interceptor.replace(baseAddr.add(0xB5950C), new NativeCallback(function (thisPtr, pathListPtr, methodInfo) {
                        log("[🛡️ INVENTORY] Safely bypassed GroupItem.ExtractPath!");
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GroupItem.ExtractPath (0xB5950C)!");
                } catch (eGiep) {
                    log("[-] Error replacing GroupItem.ExtractPath: " + eGiep.message);
                }

                // Bypass InventoryControl.CardItem.ExtractSmallImagePath (0xB56598)
                try {
                    Interceptor.replace(baseAddr.add(0xB56598), new NativeCallback(function (thisPtr, pathListPtr, methodInfo) {
                        log("[🛡️ INVENTORY] Safely bypassed CardItem.ExtractSmallImagePath!");
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardItem.ExtractSmallImagePath (0xB56598)!");
                } catch (eEsip) {
                    log("[-] Error replacing CardItem.ExtractSmallImagePath: " + eEsip.message);
                }

                // Bypass InventoryControl.CardItem.ExtractLargeImagePath (0xB562F4)
                try {
                    Interceptor.replace(baseAddr.add(0xB562F4), new NativeCallback(function (thisPtr, pathListPtr, methodInfo) {
                        log("[🛡️ INVENTORY] Safely bypassed CardItem.ExtractLargeImagePath!");
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardItem.ExtractLargeImagePath (0xB562F4)!");
                } catch (eElip) {
                    log("[-] Error replacing CardItem.ExtractLargeImagePath: " + eElip.message);
                }

                // Safe InventoryControl.UpdateDisplayGroupList (0xF28CE8)
                try {
                    Interceptor.replace(baseAddr.add(0xF28CE8), new NativeCallback(function (isForceSortAlphabet, methodInfo) {
                        log("[🃏 INVENTORY] Safe UpdateDisplayGroupList called (isForce=" + isForceSortAlphabet + ")");
                        try {
                            var getDglFn = new NativeFunction(baseAddr.add(0xF2770C), "pointer", ["pointer"]);
                            var dgl = getDglFn(NULL);
                            if (!dgl.isNull()) {
                                var dglCount = dgl.add(0x18).readS32();
                                if (dglCount === 0 && loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                                    var mSlot = baseAddr.add(0x31390F8).readPointer();
                                    var addMethodInfo = !mSlot.isNull() ? mSlot.readPointer() : NULL;
                                    var listAddFn = new NativeFunction(baseAddr.add(0x23CE41C), "void", ["pointer", "pointer", "pointer"]);
                                    listAddFn(dgl, loonaGroupItemObj, addMethodInfo);
                                    log("[🃏 INVENTORY] Safe UpdateDisplayGroupList ensured loonaGroupItemObj in DisplayGroupList!");
                                }
                            }
                        } catch (eDgl) {}
                    }, "void", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.UpdateDisplayGroupList (0xF28CE8)!");
                } catch (eUdgl) {
                    log("[-] Error replacing InventoryControl.UpdateDisplayGroupList: " + eUdgl.message);
                }

                // Proxy ThemeControl.Data.get_EffectType (0xC89B28)
                try {
                    Interceptor.replace(baseAddr.add(0xC89B28), new NativeCallback(function (thisPtr, methodInfo) {
                        return 0;
                    }, "int16", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_EffectType (0xC89B28)!");
                } catch (eTet) {
                    log("[-] Error replacing ThemeControl.Data.get_EffectType: " + eTet.message);
                }

                // Proxy ArtistControl.Data.get_ArtistLargeImagePath (0xEBB874)
                try {
                    Interceptor.replace(baseAddr.add(0xEBB874), new NativeCallback(function (thisPtr, methodInfo) {
                        return createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes");
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ArtistControl.Data.get_ArtistLargeImagePath (0xEBB874)!");
                } catch (eAlip) {
                    log("[-] Error replacing ArtistControl.Data.get_ArtistLargeImagePath: " + eAlip.message);
                }

                // Hook CardControl.Data.get_ThemeType (0xE433B4)
                try {
                    Interceptor.replace(baseAddr.add(0xE433B4), new NativeCallback(function (thisPtr, methodInfo) {
                        ensureLoonaMocks();
                        return loonaThemeTypeData || NULL;
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardControl.Data.get_ThemeType (0xE433B4)!");
                } catch (eCcdTt) {
                    log("[-] Error replacing CardControl.Data.get_ThemeType: " + eCcdTt.message);
                }

                // Hook ThemeTypeControl.Data.get_Code (0xC8AC94)
                try {
                    Interceptor.replace(baseAddr.add(0xC8AC94), new NativeCallback(function (thisPtr, methodInfo) {
                        return 1;
                    }, "int16", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeTypeControl.Data.get_Code (0xC8AC94)!");
                } catch (eTtcCode) {
                    log("[-] Error replacing ThemeTypeControl.Data.get_Code: " + eTtcCode.message);
                }

                // Hook ThemeTypeControl.Data.GetGradeImagePath (0xC8ADD8)
                try {
                    Interceptor.replace(baseAddr.add(0xC8ADD8), new NativeCallback(function (thisPtr, grade, type, methodInfo) {
                        return getGradeFrameDownloadPath(grade, type);
                    }, "pointer", ["pointer", "int", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeTypeControl.Data.GetGradeImagePath (0xC8ADD8)!");
                } catch (eGgip) {
                    log("[-] Error replacing ThemeTypeControl.Data.GetGradeImagePath: " + eGgip.message);
                }

                // Hook ThemeTypeControl.Data.get_BackgroundImagePath (0xC8BD30)
                try {
                    Interceptor.replace(baseAddr.add(0xC8BD30), new NativeCallback(function (thisPtr, methodInfo) {
                        return NULL;
                    }, "pointer", ["pointer", "pointer"]));
                } catch (eBgp) {}

                // Hook ThemeTypeControl.Data.get_BackgroundAnimImagePath (0xC8BE14)
                try {
                    Interceptor.replace(baseAddr.add(0xC8BE14), new NativeCallback(function (thisPtr, methodInfo) {
                        return NULL;
                    }, "pointer", ["pointer", "pointer"]));
                } catch (eBgap) {}

                // Hook ThemeTypeControl.Data.get_AnimationTime (0xC8AD2C)
                try {
                    Interceptor.replace(baseAddr.add(0xC8AD2C), new NativeCallback(function (thisPtr, methodInfo) {
                        return 0.0;
                    }, "double", ["pointer", "pointer"]));
                } catch (eAnimTime) {}


                function dictSet(dictObj, keyVal, valObj, isKeyInt64) {
                    try {
                        if (!dictObj || dictObj.isNull()) {
                            log("[-] dictSet: dictObj is null!");
                            return false;
                        }
                        var dictKlass = dictObj.readPointer();
                        var addMethod = il2cpp_class_get_method_from_name(dictKlass, Memory.allocUtf8String("set_Item"), 2);
                        if (!addMethod || addMethod.isNull()) {
                            addMethod = il2cpp_class_get_method_from_name(dictKlass, Memory.allocUtf8String("Add"), 2);
                        }
                        if (!addMethod || addMethod.isNull()) {
                            log("[-] dictSet: could not find set_Item or Add on dictKlass: " + dictKlass);
                            return false;
                        }

                        var keyBox = Memory.alloc(8);
                        if (isKeyInt64) {
                            keyBox.writeS64(int64(keyVal));
                        } else {
                            keyBox.writeS32(parseInt(keyVal, 10));
                        }

                        var args = Memory.alloc(Process.pointerSize * 2);
                        args.writePointer(keyBox);
                        args.add(Process.pointerSize).writePointer(valObj);

                        var exc = Memory.alloc(Process.pointerSize);
                        exc.writePointer(NULL);

                        il2cpp_runtime_invoke(addMethod, dictObj, args, exc);
                        var excPtr = exc.readPointer();
                        if (!excPtr.isNull()) {
                            log("[-] dictSet exception: " + excPtr);
                            return false;
                        }
                        return true;
                    } catch (eDs) {
                        log("[-] Error in dictSet: " + eDs.message);
                        return false;
                    }
                }

                // Defensive safety guards on CardItem getters to avoid SIGSEGV or NullReferenceException
                try {
                    Interceptor.replace(baseAddr.add(0xB55308), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (thisPtr.isNull()) return int64(0);
                            var raw = thisPtr.add(0x10).readPointer();
                            if (raw.isNull()) return int64(0);
                            return raw.add(0x10).readS64();
                        } catch (eGoi) { return int64(0); }
                    }, "int64", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardItem.get_ObjectID (0xB55308)!");
                } catch (eGoiErr) {
                    log("[-] Error replacing CardItem.get_ObjectID: " + eGoiErr.message);
                }

                try {
                    Interceptor.replace(baseAddr.add(0xB55BFC), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (raw.isNull()) return 0;
                            return raw.add(0x20).readS32();
                        } catch (eGci) { return 0; }
                    }, "int", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardItem.get_CardID (0xB55BFC)!");
                } catch (eGciErr) {
                    log("[-] Error replacing CardItem.get_CardID: " + eGciErr.message);
                }

                try {
                    Interceptor.replace(baseAddr.add(0xB524B4), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (raw.isNull()) return 0;
                            return raw.add(0x1A).readS16();
                        } catch (eGs) { return 0; }
                    }, "int", ["pointer", "pointer"]));
                } catch (eGsErr) {}

                try {
                    Interceptor.replace(baseAddr.add(0xB55C6C), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (raw.isNull()) return 0;
                            return raw.add(0x24).readS32();
                        } catch (eGg) { return 0; }
                    }, "int", ["pointer", "pointer"]));
                } catch (eGgErr) {}

                try {
                    Interceptor.replace(baseAddr.add(0xB55CA4), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (thisPtr.isNull()) return 1;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (raw.isNull()) return 1;
                            return raw.add(0x1C).readS16();
                        } catch (eGl) { return 1; }
                    }, "int", ["pointer", "pointer"]));
                } catch (eGlErr) {}

                function populateOfflineInventoryCards() {
                    log("[🃏 INVENTORY] populateOfflineInventoryCards() starting...");
                    try {
                        ensureLoonaMocks();

                        var getCardMapFn = new NativeFunction(baseAddr.add(0xF2751C), "pointer", ["pointer"]);
                        var cardMap = getCardMapFn(NULL);
                        if (cardMap.isNull()) {
                            log("[-] CardMap is null! Allocating fresh Dictionary<long, CardItem>...");
                            try {
                                var dictSlot = baseAddr.add(0x30FF100).readPointer();
                                var dictKlass = !dictSlot.isNull() ? dictSlot.readPointer() : NULL;
                                if (!dictKlass || dictKlass.isNull()) {
                                    var dSlotOld = baseAddr.add(0x31E1020).readPointer();
                                    if (!dSlotOld.isNull()) dictKlass = dSlotOld;
                                }
                                if (!dictKlass || dictKlass.isNull()) {
                                    dictKlass = getClass("mscorlib", "System.Collections.Generic", "Dictionary`2");
                                }
                                if (dictKlass && !dictKlass.isNull()) {
                                    cardMap = il2cpp_object_new(dictKlass);
                                    var ctorSlot = baseAddr.add(0x310ACC0).readPointer();
                                    var dictCtorMethodInfo = !ctorSlot.isNull() ? ctorSlot.readPointer() : NULL;
                                    var dictCtorFn = new NativeFunction(baseAddr.add(0x234F4C8), "void", ["pointer", "int", "pointer"]);
                                    dictCtorFn(cardMap, 16, dictCtorMethodInfo);
                                    var setCardMapFn = new NativeFunction(baseAddr.add(0xF27580), "void", ["pointer", "pointer"]);
                                    setCardMapFn(cardMap, NULL);
                                    log("[🃏 INVENTORY] Created fresh Dictionary<long, CardItem> and assigned to CardMap: " + cardMap);
                                }
                            } catch (dErr) {
                                log("[-] Error allocating Dictionary: " + dErr.message);
                            }
                        }

                        if (cardMap.isNull()) {
                            log("[-] CardMap could not be initialized. Aborting card populator.");
                            return;
                        }

                        var profile = loadPlayerProfile();
                        if (!profile || !profile.inventoryCards || profile.inventoryCards.length === 0) {
                            log("[-] No inventoryCards found in player_profile.json");
                            return;
                        }

                        var cardKlass = NULL;
                        try {
                            var cardSlot = baseAddr.add(0x31E62B8).readPointer();
                            if (!cardSlot.isNull()) cardKlass = cardSlot;
                        } catch (e1) {}
                        if (!cardKlass || cardKlass.isNull()) {
                            cardKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.account", "Card");
                        }

                        var cardItemKlass = NULL;
                        try {
                            var itemSlot = baseAddr.add(0x31F3060).readPointer();
                            if (!itemSlot.isNull()) cardItemKlass = itemSlot;
                        } catch (e2) {}
                        if (!cardItemKlass || cardItemKlass.isNull()) {
                            cardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");
                        }

                        if (!cardKlass || cardKlass.isNull() || !cardItemKlass || cardItemKlass.isNull()) {
                            log("[-] Could not resolve Card or CardItem class! cardKlass: " + cardKlass + ", cardItemKlass: " + cardItemKlass);
                            return;
                        }

                        log("[🃏 INVENTORY] Populating " + profile.inventoryCards.length + " LOONA cards into CardMap (" + cardMap + ")...");
                        var addedCount = 0;
                        var loonaCardItems = [];

                        for (var i = 0; i < profile.inventoryCards.length; i++) {
                            var cData = profile.inventoryCards[i];
                            try {
                                // 1. Create Card managed instance
                                var cardObj = il2cpp_object_new(cardKlass);
                                var objId = int64(cData.objectID || (100000 + i + 1));
                                var cId = parseInt(cData.cardID || (1001 + i), 10);
                                var gr = parseInt(cData.grade !== undefined ? cData.grade : 4, 10);
                                var lvl = parseInt(cData.level || 50, 10);

                                cardObj.add(0x10).writeS64(objId);
                                cardObj.add(0x18).writeS16(cData.energy || 100);
                                cardObj.add(0x1A).writeS16(cData.score || 100);
                                cardObj.add(0x1C).writeS16(lvl);
                                cardObj.add(0x20).writeS32(cId);
                                cardObj.add(0x24).writeS32(gr);
                                cardObj.add(0x28).writeU8(cData.isEquip ? 1 : 0);
                                cardObj.add(0x29).writeU8(cData.isLock ? 1 : 0);
                                cardObj.add(0x2A).writeU8(cData.isPrism ? 1 : 0);

                                // 2. Directly construct CardItem managed instance
                                var cardItemObj = il2cpp_object_new(cardItemKlass);
                                cardItemObj.add(0x10).writePointer(cardObj); // <Raw>
                                var ccd = getOrCreateCardControlData(cId);
                                cardItemObj.add(0x18).writePointer(ccd || NULL); // <Card>
                                cardItemObj.add(0x20).writeS16(gr * 100 + lvl); // <IntensifyCode>
                                cardItemObj.add(0x24).writeU32(0x3F800000); // 1.0f
                                cardItemObj.add(0x28).writeS32(100); // <SellPrice>
                                cardItemObj.add(0x2C).writeU8(0); // isMaterial = false
                                var memberIdx = ((cId - 1001) % 12) + 1;
                                cardItemObj.add(0x30).writeS32(1001 * 10000 + 1 * 100 + memberIdx); // sortCardIndex
                                cardItemObj.add(0x34).writeU8(0); // isNew = false
                                cardItemObj.add(0x38).writeS32(1); // <ThemeLevel>
                                cardItemObj.add(0x3C).writeU8(0); // isEquipLiveTheme = false
                                cardItemObj.add(0x3E).writeS16(-1); // equipLiveThemeCode = -1
                                cardItemObj.add(0x40).writePointer(NULL); // <themeCardItem>

                                loonaCardItems.push(cardItemObj);

                                // 3. Add to CardMap Dictionary via dictSet
                                var added = dictSet(cardMap, objId, cardItemObj, true);
                                if (added) {
                                    addedCount++;
                                    log("[🃏 CARD " + (i + 1) + "] Added cardID=" + cId + " grade=" + gr + " lvl=" + lvl + " objID=" + objId);
                                } else {
                                    log("[-] Failed to add cardID=" + cId + " to cardMap!");
                                }
                            } catch (cErr) {
                                log("[-] Error creating card " + i + ": " + cErr.message);
                            }
                        }

                        log("[✅ INVENTORY] Successfully populated " + addedCount + " LOONA cards into CardMap!");

                        loonaCardListFastArray = createFastArray(loonaCardItems, 'card');
                        log("[🃏 INVENTORY] Created loonaCardListFastArray: " + loonaCardListFastArray);

                        try {
                            var dictTablePtr = baseAddr.add(0x30F77E8);
                            var dictKlassPtr = dictTablePtr.readPointer();
                            if (!dictKlassPtr.isNull()) {
                                var dictKlass = dictKlassPtr.readPointer();
                                if (!dictKlass.isNull()) {
                                    var dictObj = il2cpp_object_new(dictKlass);
                                    var dictCtor = new NativeFunction(baseAddr.add(0x2368A30), "void", ["pointer", "pointer"]);
                                    var ctorMi = baseAddr.add(0x314B0D0).readPointer().readPointer();
                                    dictCtor(dictObj, ctorMi);
                                    if (loonaCardListFastArray && !loonaCardListFastArray.isNull()) {
                                        var dictAdd = new NativeFunction(baseAddr.add(0x236948C), "void", ["pointer", "int", "pointer", "pointer"]);
                                        var addMi = baseAddr.add(0x31090B0).readPointer().readPointer();
                                        dictAdd(dictObj, 1001, loonaCardListFastArray, addMi);
                                    }
                                    loonaEachThemeBestCardMap = dictObj;
                                    log("[✅ INVENTORY] Genuine EachThemeBestCardMap created: " + loonaEachThemeBestCardMap);
                                }
                            }
                        } catch (eEd) {
                            log("[-] Error creating EachThemeBestCardMap: " + eEd.message);
                            loonaEachThemeBestCardMap = NULL;
                        }

                        // Ensure InventoryControl.IsOpened is true
                        try {
                            var setIsOpenedFn = new NativeFunction(baseAddr.add(0xF2744C), "void", ["int", "pointer"]);
                            setIsOpenedFn(1, NULL);
                            log("[🃏 INVENTORY] InventoryControl.set_IsOpened(true) called!");
                        } catch (ioe) {}

                        // Ensure GroupMap contains Group 1001 (LOONA)
                        try {
                            var getGroupMapFn = new NativeFunction(baseAddr.add(0xF27380), "pointer", ["pointer"]);
                            var groupMap = getGroupMapFn(NULL);
                            if (groupMap.isNull()) {
                                try {
                                    var grpDictKlass = getClass("mscorlib", "System.Collections.Generic", "Dictionary`2");
                                    if (grpDictKlass && !grpDictKlass.isNull()) {
                                        groupMap = il2cpp_object_new(grpDictKlass);
                                        var setGroupMapFn = new NativeFunction(baseAddr.add(0xF273E4), "void", ["pointer", "pointer"]);
                                        setGroupMapFn(groupMap, NULL);
                                    }
                                } catch (eGmd) {}
                            }

                            var groupItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/GroupItem");
                            if (groupItemKlass && !groupItemKlass.isNull() && !groupMap.isNull()) {
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

                                dictSet(groupMap, 1001, groupItemObj, false);
                                log("[🃏 INVENTORY] Added LOONA GroupItem(1001) to GroupMap! loonaGroupItemObj=" + loonaGroupItemObj);

                                var updateDisplayGroupListFn = new NativeFunction(baseAddr.add(0xF28CE8), "void", ["int", "pointer"]);
                                updateDisplayGroupListFn(0, NULL);
                                log("[🃏 INVENTORY] UpdateDisplayGroupList(false) executed!");

                                // Check DisplayGroupList
                                var getDglFn = new NativeFunction(baseAddr.add(0xF2770C), "pointer", ["pointer"]);
                                var dgl = getDglFn(NULL);
                                if (!dgl.isNull()) {
                                    var dglCount = dgl.add(0x18).readS32();
                                    log("[🃏 INVENTORY] DisplayGroupList count after update: " + dglCount);
                                    if (dglCount === 0) {
                                        log("[🃏 INVENTORY] DisplayGroupList count is 0, adding LOONA GroupItem manually...");
                                        try {
                                            var mSlot = baseAddr.add(0x31390F8).readPointer();
                                            var addMethodInfo = !mSlot.isNull() ? mSlot.readPointer() : NULL;
                                            var listAddFn = new NativeFunction(baseAddr.add(0x23CE41C), "void", ["pointer", "pointer", "pointer"]);
                                            listAddFn(dgl, groupItemObj, addMethodInfo);
                                            log("[🃏 INVENTORY] Manually added GroupItem to DisplayGroupList! New count: " + dgl.add(0x18).readS32());
                                        } catch (eLa) {
                                            log("[-] Error manually adding to DisplayGroupList: " + eLa.message);
                                        }
                                    }
                                }
                            }
                        } catch (eGme) {
                            log("[-] Error verifying GroupMap: " + eGme.message);
                        }

                        // Set SelectedGroupCode = 1001
                        try {
                            var setSelectedGroupCodeFn = new NativeFunction(baseAddr.add(0xF26FBC), "void", ["int", "pointer"]);
                            setSelectedGroupCodeFn(1001, NULL);
                            log("[🃏 INVENTORY] InventoryControl.SelectedGroupCode = 1001 set!");
                        } catch (sge) {}

                        // Synchronize with CardBookControl
                        try {
                            var cardBookRegistFn = new NativeFunction(baseAddr.add(0x11C9A9C), "void", ["pointer", "pointer", "int", "pointer"]);
                            cardBookRegistFn(cardMap, NULL, 0, NULL);
                            log("[📖 CARDBOOK] CardBookControl.RegistWithCardItemMap synchronized!");
                        } catch (cbErr) {
                            log("[-] Error synchronizing CardBook: " + cbErr.message);
                        }
                    } catch (eGen) {
                        log("[-] Error in populateOfflineInventoryCards: " + eGen.message);
                    }
                }

                // Intercept InventoryControl.OpenCard (0xF27DA8) so that native Open() calls our populator directly
                try {
                    Interceptor.replace(baseAddr.add(0xF27DA8), new NativeCallback(function (methodInfo) {
                        log("[🃏 INVENTORY] Native OpenCard intercepted! Running populateOfflineInventoryCards()...");
                        populateOfflineInventoryCards();
                    }, "void", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.OpenCard (0xF27DA8)!");
                } catch (eOcr) {
                    log("[-] Error replacing OpenCard: " + eOcr.message);
                }

                // Intercept InventoryControl.OpenGroup (0xF2827C) to bypass missing GroupData storage
                try {
                    Interceptor.replace(baseAddr.add(0xF2827C), new NativeCallback(function (methodInfo) {
                        log("[🃏 INVENTORY] Native OpenGroup intercepted! (LOONA GroupItem handled by offline populator)");
                    }, "void", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.OpenGroup (0xF2827C)!");
                } catch (eOgr) {
                    log("[-] Error replacing OpenGroup: " + eOgr.message);
                }

                // --- Hook LobbyView.OnRightMenu (0xCEE6FC) to keep Ranking hidden ---
                // (Para reactivar el botón de Ranking en el Lobby, comenta este hook)
                try {
                    Interceptor.attach(baseAddr.add(0xCEE6FC), {
                        onEnter: function (args) {
                            try {
                                var leagueGo = findGameObjectFn(createIl2CppString("LobbyScene/Buttons/RightMenu/-extraMenu/BtnMyLobby/-League"), NULL);
                                if (leagueGo.isNull()) leagueGo = findGameObjectFn(createIl2CppString("-League"), NULL);
                                if (!leagueGo.isNull()) {
                                    setActiveFn(leagueGo, 0); // 0 = Ocultar
                                }
                            } catch (e) {}
                        }
                    });
                } catch (eRm) {
                    log("[-] Error hooking LobbyView.OnRightMenu: " + eRm.message);
                }

                // --- Bypass HelpAssist / Tutorial popups (0xBA70C4) -> mov w0, #1; ret ---
                try {
                    Memory.protect(baseAddr.add(0xBA70C4), 8, "rwx");
                    baseAddr.add(0xBA70C4).writeByteArray([0x20, 0x00, 0x80, 0x52, 0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on HelpAssist.GetCompleted (0xBA70C4): mov w0, #1; ret");
                } catch (eHgc) {
                    log("[-] Error patching HelpAssist.GetCompleted: " + eHgc.message);
                }

                // --- Hook InventoryScene.OnOpen (0x1051604) ---
                try {
                    Interceptor.attach(baseAddr.add(0x1051604), {
                        onEnter: function (args) {
                            log("[🗃️ INVENTORY SCENE] InventoryScene.OnOpen entered! instance: " + args[0]);
                            try {
                                var getIsOpenedFn = new NativeFunction(baseAddr.add(0xF274B8), "int", ["pointer"]);
                                if (getIsOpenedFn(NULL) === 0) {
                                    log("[🗃️ INVENTORY SCENE] InventoryControl not opened yet! Calling Open(NULL)...");
                                    var invenOpenFn = new NativeFunction(baseAddr.add(0xF27AA0), "void", ["pointer"]);
                                    invenOpenFn(NULL);
                                }
                                populateOfflineInventoryCards();
                            } catch (ie) {
                                log("[-] Error checking/opening inventory in InventoryScene: " + ie.message);
                            }
                        },
                        onLeave: function (retval) {
                            log("[🗃️ INVENTORY SCENE] InventoryScene.OnOpen completed!");
                        }
                    });
                    log("[+] Hooked InventoryScene.OnOpen (0x1051604) successfully!");
                } catch (eIs) {
                    log("[-] Error hooking InventoryScene.OnOpen: " + eIs.message);
                }

                // --- Hook CardBookScene.OnOpen (0x11CDD64) ---
                try {
                    Interceptor.attach(baseAddr.add(0x11CDD64), {
                        onEnter: function (args) {
                            log("[📖 CARDBOOK SCENE] CardBookScene.OnOpen entered! instance: " + args[0]);
                            try {
                                var setCardBookOpenedFn = new NativeFunction(baseAddr.add(0x11C537C), "void", ["int", "pointer"]);
                                setCardBookOpenedFn(1, NULL);
                            } catch (e) {}
                        },
                        onLeave: function (retval) {
                            log("[📖 CARDBOOK SCENE] CardBookScene.OnOpen completed!");
                        }
                    });
                    log("[+] Hooked CardBookScene.OnOpen (0x11CDD64) successfully!");
                } catch (eCb) {
                    log("[-] Error hooking CardBookScene.OnOpen: " + eCb.message);
                }

                // Hook CardBookScene.OnBack (0x11CEDE8)
                try {
                    Interceptor.attach(baseAddr.add(0x11CEDE8), {
                        onEnter: function (args) {
                            log("[📖 CARDBOOK SCENE] CardBookScene.OnBack entered! Closing CardBook... instance: " + args[0]);
                        },
                        onLeave: function (retval) {
                            log("[📖 CARDBOOK SCENE] CardBookScene.OnBack completed!");
                        }
                    });
                    log("[+] Hooked CardBookScene.OnBack (0x11CEDE8) successfully!");
                } catch (eObh) {
                    log("[-] Error hooking CardBookScene.OnBack: " + eObh.message);
                }

                // Hook LobbyScene.OnOpen (0xB45508)
                var curLobbyInstance = NULL;
                Interceptor.attach(baseAddr.add(0xB45508), {
                    onEnter: function (args) {
                        curLobbyInstance = args[0];
                        log("[🎉 LOBBY SCENE] LobbyScene.OnOpen entered! Welcome to LOONA Lobby! this: " + args[0]);
                    },
                    onLeave: function (retval) {
                        log("[🎉 LOBBY SCENE] LobbyScene.OnOpen completed!");
                        try {
                            // Complete & Purge LoadingIndicator (0xB3E230, 0xB3E340, 0xB3DAE4)
                            try {
                                var indicatorComplete = new NativeFunction(baseAddr.add(0xB3E230), "void", []);
                                indicatorComplete();
                                var indicatorCompleteTwo = new NativeFunction(baseAddr.add(0xB3E340), "void", []);
                                indicatorCompleteTwo();
                                var indicatorPurge = new NativeFunction(baseAddr.add(0xB3DAE4), "void", []);
                                indicatorPurge();
                                log("[🎉 LOBBY SCENE] LoadingIndicator Complete, CompleteTwo & Purge called!");
                            } catch (ie) {}

                            // Deactivate LoadingIndicator GameObject completely
                            try {
                                var loadingClassSlot = baseAddr.add(0x3116308).readPointer();
                                if (!loadingClassSlot.isNull()) {
                                    var loadingClass = loadingClassSlot.readPointer();
                                    if (!loadingClass.isNull()) {
                                        var loadingStatic = loadingClass.add(0xB8).readPointer();
                                        if (!loadingStatic.isNull()) {
                                            var loadingInst = loadingStatic.readPointer();
                                            if (!loadingInst.isNull()) {
                                                var cacheBase = loadingInst.add(0x90).readPointer();
                                                if (!cacheBase.isNull()) {
                                                    var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int"]);
                                                    setActiveFn(cacheBase, 0);
                                                    log("[🛡️ LOBBY SCENE] Deactivated LoadingIndicator cacheBase GameObject!");
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (le2) {
                                log("[-] Error deactivating LoadingIndicator: " + le2.message);
                            }

                            // Activate Lobby UI and Video
                            if (!curLobbyInstance.isNull()) {
                                activateLobbyUIAndVideo(curLobbyInstance);
                            }

                            // Refresh and verify user profile in TopBar
                            try {
                                var currentProf = loadPlayerProfile();
                                if (currentProf) {
                                    setupUserControl(currentProf);
                                    log("[👤 LOBBY] TopBar profile data synchronized for '" + currentProf.nickname + "'!");
                                }
                            } catch (eProf) {
                                log("[-] Error refreshing profile in LobbyScene: " + eProf.message);
                            }
                        } catch (mainErr) {
                            log("[-] Error in LobbyScene onLeave: " + mainErr.message);
                        }
                    }
                });

                Interceptor.attach(baseAddr.add(0xD52B04), {
                    onEnter: function (args) {
                        log("[🎬 SCENE] Scene.Open called on instance: " + args[0] + " with MainView: " + args[1]);
                    }
                });

                // Periodic SceneControl State Monitor & LobbyScene Auto-Enlace
                var sceneUpdateCounter = 0;
                var cachedLobbyStr = NULL;
                var globalSceneId = 0;
                var globalIsChanging = 0;
                var isLobbyIntegrated = false;
                var lastWorkerTid = 0;
                var deadlockFrames = 0;

                var findGameObjectFn = new NativeFunction(baseAddr.add(0x1DBB16C), 'pointer', ['pointer', 'pointer']);
                var isDoneFn = new NativeFunction(baseAddr.add(0x1DB2C9C), 'int', ['pointer']);
                var getCompFn = new NativeFunction(baseAddr.add(0x10B4898), 'pointer', ['pointer', 'pointer']);
                var factoryLobbyFn = new NativeFunction(baseAddr.add(0xBEC788), 'pointer', ['pointer', 'pointer']);
                var openSceneFn = new NativeFunction(baseAddr.add(0xD52B04), 'void', ['pointer', 'pointer', 'pointer', 'pointer']);
                var completeLoadingFn = new NativeFunction(baseAddr.add(0xB3E230), 'void', ['pointer']);

                Interceptor.attach(baseAddr.add(0xD55EE8), {
                    onEnter: function (args) {
                        sceneUpdateCounter++;
                        try {
                            var klassPtr = baseAddr.add(0x3146538).readPointer();
                            if (klassPtr.isNull()) return;
                            var klass = klassPtr.readPointer();
                            if (klass.isNull()) return;
                            var staticFields = klass.add(0xB8).readPointer();
                            if (staticFields.isNull()) return;

                            var sceneId = staticFields.add(0x10).readS32();
                            var sceneObj = staticFields.add(0x18).readPointer();
                            var sceneInstance = staticFields.add(0x20).readPointer();
                            var asyncOp = staticFields.add(0x38).readPointer();
                            var isChanging = staticFields.add(0x48).readU8();

                            globalSceneId = sceneId;
                            globalIsChanging = isChanging;

                            var isDone = false;
                            var mPtr = NULL;
                            try {
                                if (!asyncOp.isNull()) {
                                    mPtr = asyncOp.add(0x10).readPointer();
                                    isDone = (isDoneFn(asyncOp) === 1);
                                }
                            } catch (me) {}

                            var progressVal = 0;
                            var doneVal = 0;
                            try {
                                if (!mPtr.isNull()) {
                                    doneVal = mPtr.add(0x48).readU32();
                                    progressVal = mPtr.add(0x6c).readFloat();
                                }
                            } catch (pe) {}

                            if (sceneUpdateCounter === 1) {
                                try {
                                    var pthread_self_fn = new NativeFunction(Module.findExportByName("libc.so", "pthread_self"), "pointer", []);
                                    log("[🧵 MAIN THREAD] pthread_self: " + pthread_self_fn() + " | tid: " + Process.getCurrentThreadId());
                                } catch (e) {}
                            }

                            // FastMutex Watchdog & Deadlock Breaker during scene load
                            if (isChanging === 1 || !asyncOp.isNull() || sceneId === 3) {
                                try {
                                    var pFutex = baseAddr.add(0x3392580);
                                    var pOwner = baseAddr.add(0x33925c0);
                                    var pRecur = baseAddr.add(0x33925c8);
                                    var futexVal = pFutex.readU32();

                                    if (futexVal !== 0 && progressVal < 0.99) {
                                        deadlockFrames = (deadlockFrames || 0) + 1;
                                        if (deadlockFrames >= 15) { // ~250ms stuck
                                            var owner = pOwner.readPointer();
                                            var recurCount = pRecur.readU32();

                                            log("🚨 [DEADLOCK WATCHDOG] Breaking stuck lock at prog=" + progressVal.toFixed(4) + "! futex=" + futexVal + " owner=" + owner + " recur=" + recurCount);

                                            // Reset lock state
                                            pOwner.writePointer(NULL);
                                            pRecur.writeU32(0);
                                            pFutex.writeU32(0);

                                            // Wake futex waiters
                                            var syscallPtr = Module.findExportByName("libc.so", "syscall");
                                            if (syscallPtr) {
                                                var syscallFn = new NativeFunction(syscallPtr, "int", ["int", "pointer", "int", "int"]);
                                                var w1 = syscallFn(98, pFutex, 129, 2147483647);
                                                var w2 = syscallFn(98, pFutex, 1, 2147483647);
                                                log("[🔓 DEADLOCK RESOLVED] Woke futex waiters: priv=" + w1 + ", shared=" + w2);
                                            }
                                            deadlockFrames = 0;
                                        }
                                    } else {
                                        deadlockFrames = 0;
                                    }
                                } catch (de) {
                                    log("[-] Error in watchdog: " + de.message);
                                }
                            }

                            if (sceneUpdateCounter % 60 === 0) {
                                log("[🔍 SCENE MONITOR] SceneId: " + sceneId +
                                    " | SceneObj: " + sceneObj +
                                    " | SceneInstance: " + sceneInstance +
                                    " | Async: " + asyncOp + " (done: " + isDone + ", mDone: " + doneVal + ", prog: " + progressVal.toFixed(4) + ")" +
                                    " | Changing: " + isChanging);

                                if (sceneId === 3 && sceneUpdateCounter % 180 === 0) {
                                    try {
                                        var futexVal = baseAddr.add(0x3392580).readU32();
                                        var owner = baseAddr.add(0x33925c0).readPointer();
                                        var recurCount = baseAddr.add(0x33925c8).readU32();
                                        log("[🔒 IL2CPP LOCK] futex: " + futexVal + " | owner: " + owner + " | recur: " + recurCount);
                                    } catch (te) {
                                        log("[-] Error inspecting lock: " + te.message);
                                    }
                                }
                            }

                            // Check scene navigation command file every 30 frames
                            if (sceneUpdateCounter % 30 === 0) {
                                try {
                                    var cmdPath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt";
                                    var existsMethod = findMethod("mscorlib", "System.IO", "File", "Exists", 1);
                                    var readAllTextMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllText", 1);
                                    var deleteMethod = findMethod("mscorlib", "System.IO", "File", "Delete", 1);
                                    var cmdPathStr = createIl2CppString(cmdPath);
                                    var aCheck = Memory.alloc(Process.pointerSize);
                                    aCheck.writePointer(cmdPathStr);
                                    var exc = Memory.alloc(Process.pointerSize);
                                    exc.writePointer(NULL);
                                    var cmdExists = il2cpp_runtime_invoke(existsMethod, NULL, aCheck, exc);
                                    if (cmdExists.toInt32() !== 0) {
                                        var aRead = Memory.alloc(Process.pointerSize);
                                        aRead.writePointer(cmdPathStr);
                                        var txtObj = il2cpp_runtime_invoke(readAllTextMethod, NULL, aRead, exc);
                                        var aDel = Memory.alloc(Process.pointerSize);
                                        aDel.writePointer(cmdPathStr);
                                        il2cpp_runtime_invoke(deleteMethod, NULL, aDel, exc);
                                        if (!txtObj.isNull()) {
                                            var targetScene = parseInt(readIl2CppString(txtObj).trim());
                                            if (!isNaN(targetScene) && targetScene >= 1 && targetScene <= 13) {
                                                log("[🚀 SCENE CMD] Received command to switch to SceneId: " + targetScene);
                                                var openSceneDirectFn = new NativeFunction(baseAddr.add(0xD534BC), 'void', ['int', 'pointer', 'pointer']);
                                                openSceneDirectFn(targetScene, NULL, NULL);
                                            }
                                        }
                                    }
                                } catch (eCmd) {}
                            }

                            // Auto-Enlace / Activador Seguro de LobbyScene ONLY when isDone or already unloaded
                            if (!isLobbyIntegrated && (isDone || (isChanging === 0 && sceneId === 3))) {
                                if (cachedLobbyStr.isNull()) {
                                    cachedLobbyStr = createIl2CppString("LobbyScene");
                                }
                                var foundGo = findGameObjectFn(cachedLobbyStr, NULL);
                                if (!foundGo.isNull()) {
                                    log("[🎉 LOBBY FOUND] GameObject.Find('LobbyScene') returned: " + foundGo);

                                    if (sceneInstance.isNull() || sceneObj.isNull()) {
                                        log("[🚀 AUTO-ENLACE] Linking and activating LobbyScene now!");

                                        // 1. Assign SceneObject
                                        staticFields.add(0x18).writePointer(foundGo);

                                        // 2. Resolve MainView & SceneView via GetComponentInChildren (0x10B4898)
                                        var p1 = baseAddr.add(0x314D5B8).readPointer();
                                        var p2 = baseAddr.add(0x3123670).readPointer();
                                        var minfoMain = p1.isNull() ? NULL : p1.readPointer();
                                        var minfoScene = p2.isNull() ? NULL : p2.readPointer();
                                        var mainView = minfoMain.isNull() ? NULL : getCompFn(foundGo, minfoMain);
                                        var sceneView = minfoScene.isNull() ? NULL : getCompFn(foundGo, minfoScene);
                                        log("[🚀 AUTO-ENLACE] Extracted MainView: " + mainView + " | SceneView: " + sceneView);

                                        // 3. Instantiate LobbyScene via factory b__100_2 (0xBEC788)
                                        var newLobbyScene = factoryLobbyFn(NULL, NULL);
                                        log("[🚀 AUTO-ENLACE] Created LobbyScene instance: " + newLobbyScene);

                                        // 4. Assign SceneInstance
                                        staticFields.add(0x20).writePointer(newLobbyScene);

                                        // 5. Open Scene (0xD52B04)
                                        openSceneFn(newLobbyScene, mainView, sceneView, NULL);
                                        log("[🚀 AUTO-ENLACE] Scene.Open successfully called!");

                                        // 6. Complete LoadingIndicator (0xB3E230)
                                        try {
                                            completeLoadingFn(NULL);
                                            log("[🚀 AUTO-ENLACE] LoadingIndicator.Complete() called!");
                                        } catch (le) {
                                            log("[-] Error calling LoadingIndicator.Complete(): " + le.message);
                                        }

                                        // 7. Clear AsyncManager & IsSceneChanging
                                        staticFields.add(0x38).writePointer(NULL);
                                        staticFields.add(0x48).writeU8(0);
                                        isLobbyIntegrated = true;
                                        log("[🎉 LOBBY READY] LobbyScene integration finished!");
                                    } else {
                                        isLobbyIntegrated = true;
                                        log("[🎉 LOBBY READY] LobbyScene was already integrated by native SceneControl!");
                                    }
                                }
                            }

                            // Periodic safety: if sceneId === 3 and LobbyScene is active, ensure UI and Video are activated
                            if (sceneId === 3 && !sceneInstance.isNull()) {
                                if (!lobbyUIActivated) {
                                    activateLobbyUIAndVideo(sceneInstance);
                                }
                            }
                        } catch (e) {
                            if (sceneUpdateCounter % 60 === 0) {
                                log("[-] SceneControl hook error: " + e.message);
                            }
                        }
                    }
                });

                // Standalone Thread-Independent FastMutex Watchdog
                var fastMutexHoldCount = 0;
                var globalSyscallPtr = Module.findExportByName("libc.so", "syscall");
                var globalSyscallFn = globalSyscallPtr ? new NativeFunction(globalSyscallPtr, "int", ["int", "pointer", "int", "int"]) : null;

                setInterval(function () {
                    try {
                        if (!baseAddr) return;
                        var pFutex = baseAddr.add(0x3392580);
                        var pOwner = baseAddr.add(0x33925c0);
                        var pRecur = baseAddr.add(0x33925c8);
                        var futexVal = pFutex.readU32();

                        if (futexVal !== 0) {
                            fastMutexHoldCount++;
                            if (fastMutexHoldCount >= 3) { // stuck for > 300ms
                                var owner = pOwner.readPointer();
                                var recurCount = pRecur.readU32();

                                log("🚨 [INDEPENDENT WATCHDOG] Breaking stuck lock! futex=" + futexVal + " owner=" + owner + " recur=" + recurCount);

                                pOwner.writePointer(NULL);
                                pRecur.writeU32(0);
                                pFutex.writeU32(0);

                                if (globalSyscallFn) {
                                    var w1 = globalSyscallFn(98, pFutex, 129, 2147483647);
                                    var w2 = globalSyscallFn(98, pFutex, 1, 2147483647);
                                    log("[🔓 INDEPENDENT WATCHDOG] Woke futex waiters: priv=" + w1 + ", shared=" + w2);
                                }
                                fastMutexHoldCount = 0;
                            }
                        } else {
                            fastMutexHoldCount = 0;
                        }
                    } catch (e) {
                        log("[-] Error in independent watchdog: " + e.message);
                    }
                }, 100);

                // Universal UnityTLS Certificate Verify Bypass in libunity.so (Curl error 60)
                try {
                    var unityMod = Process.findModuleByName("libunity.so");
                    if (unityMod) {
                        Interceptor.replace(unityMod.base.add(0x7EF054), new NativeCallback(function (a, b, c, d) {
                            return 0; // CURLE_OK
                        }, "int", ["pointer", "pointer", "pointer", "int"]));
                        log("[🔐 UNITYTLS] Installed universal SSL verify bypass in libunity.so (0x7EF054)");

                        // Neutralize 0xE4920 (bad container cleanup in 0x288374 epilogue) with RET (0xd65f03c0)
                        try {
                            Memory.protect(unityMod.base.add(0xE4920), 4, "rwx");
                            unityMod.base.add(0xE4920).writeU32(0xd65f03c0); // RET
                            log("[🛡️ UNITY PATCH] Patched 0xE4920 to RET (neutralized bad container cleanup)");
                        } catch (pe) {
                            log("[-] Error patching 0xE4920: " + pe.message);
                        }

                        // Neutralize __stack_chk_fail at 0x288CF4 with NOP (0xd503201f)
                        try {
                            Memory.protect(unityMod.base.add(0x288CF4), 4, "rwx");
                            unityMod.base.add(0x288CF4).writeU32(0xd503201f); // NOP
                            log("[🛡️ UNITY PATCH] Patched 0x288CF4 to NOP (neutralized __stack_chk_fail)");
                        } catch (spe) {
                            log("[-] Error patching 0x288CF4: " + spe.message);
                        }

                        // Neutralize crash at 0x288BC0 (invalid x25 dereference post-Loop2) with b #0x288c84 (0x1400004d)
                        try {
                            Memory.protect(unityMod.base.add(0x288B50), 4, "rwx");
                            unityMod.base.add(0x288B50).writeU32(0x1400004d); // b #0x288c84
                            log("[🛡️ UNITY PATCH] Patched 0x288B50 to b #0x288c84 (bypassed bad registration crash)");
                        } catch (bpe) {
                            log("[-] Error patching 0x288B50: " + bpe.message);
                        }

                        // Safeguard 0x28b3ac against NULL pointer dereference
                        Interceptor.attach(unityMod.base.add(0x28b3ac), {
                            onEnter: function (args) {
                                if (args[0].isNull()) {
                                    log("[🛡️ UNITY SAFEGUARD] 0x28b3ac called with NULL x0, redirecting to safe pointer");
                                    args[0] = unityMod.base.add(0x106b000);
                                }
                            }
                        });

                        Interceptor.attach(unityMod.base.add(0x288374), {
                            onEnter: function (args) {
                                lastWorkerTid = Process.getCurrentThreadId();
                                log("[⚙️ UNITY LOAD] 0x288374 (vtable[10]) ENTER on mPtr: " + args[0] + " tid: " + lastWorkerTid);
                            },
                            onLeave: function (retval) {
                                log("[⚙️ UNITY LOAD] 0x288374 LEAVE, retval: " + retval);
                            }
                        });

                        var workerTickLogged = false;
                        Interceptor.attach(unityMod.base.add(0x28A274), {
                            onEnter: function (args) {
                                if (!workerTickLogged) {
                                    workerTickLogged = true;
                                    log("[⚙️ UNITY WORKER] 0x28A274 worker loop active, tid: " + Process.getCurrentThreadId());
                                }
                            }
                        });

                        // Hook vtable[11] (0x288EBC): IsReadyToIntegrate - Natural integration on main thread
                        var lastLoggedIsReady = -1;
                        Interceptor.attach(unityMod.base.add(0x288EBC), {
                            onEnter: function (args) {
                                this.mPtr = args[0];
                            },
                            onLeave: function (retval) {
                                var ret = retval.toInt32();
                                if (ret !== lastLoggedIsReady) {
                                    lastLoggedIsReady = ret;
                                    log("[⚙️ VTABLE[11]] IsReadyToIntegrate (0x288EBC) state changed -> " + ret);
                                }
                                if (!this.mPtr.isNull()) {
                                    var doneVal = this.mPtr.add(0x48).readU32();
                                    if (doneVal >= 1) {
                                        retval.replace(1);
                                    }
                                }
                            }
                        });

                        Interceptor.attach(unityMod.base.add(0x288F00), {
                            onEnter: function (args) {
                                log("[⚙️ UNITY INTEGRATE] 0x288F00 (vtable[12]) called on mPtr: " + args[0]);
                            },
                            onLeave: function (retval) {
                                log("[⚙️ UNITY INTEGRATE] 0x288F00 (vtable[12]) COMPLETED! Retval: " + retval);
                            }
                        });
                    }
                } catch (e) {
                    log("[-] Error installing Unity hooks: " + e.message);
                }

                log("[+] Patched <SetStateMain>b__25_0 (TOUCH TO START) direct Lobby transition active");
                log("[+] AssetDownloader & TitleScene diagnostic hooks active");
            } catch (e) {
                log("[-] Could not attach diagnostic hooks: " + e.message);
            }
        } catch (e) {
            log("[-] Error installing RVA hooks: " + e.message);
        }
    }
    installNativeRvaHooks(il2cppBase);

    function getClass(assemblyName, namespaceName, className) {
        if (!className) return NULL;
        var nestedParts = null;
        if (className.indexOf('/') !== -1) {
            nestedParts = className.split('/');
            className = nestedParts[0];
        }
        var targetClass = NULL;
        var domain = il2cpp_domain_get ? il2cpp_domain_get() : NULL;
        if (!domain || domain.isNull()) return NULL;
        if (il2cpp_domain_get_assemblies) {
            var sizePtr = Memory.alloc(Process.pointerSize);
            var assemblies = il2cpp_domain_get_assemblies(domain, sizePtr);
            if (!assemblies.isNull()) {
                var count = sizePtr.readUInt();
                for (var i = 0; i < count; i++) {
                    var assem = assemblies.add(i * Process.pointerSize).readPointer();
                    if (!assem.isNull()) {
                        var img = il2cpp_assembly_get_image(assem);
                        if (img && !img.isNull()) {
                            var klass = il2cpp_class_from_name(img, Memory.allocUtf8String(namespaceName || ""), Memory.allocUtf8String(className));
                            if (klass && !klass.isNull()) {
                                targetClass = klass;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if ((!targetClass || targetClass.isNull()) && il2cpp_domain_assembly_open && il2cpp_assembly_get_image) {
            var assem = il2cpp_domain_assembly_open(domain, Memory.allocUtf8String(assemblyName));
            if (!assem.isNull()) {
                var img = il2cpp_assembly_get_image(assem);
                if (img && !img.isNull()) {
                    targetClass = il2cpp_class_from_name(img, Memory.allocUtf8String(namespaceName || ""), Memory.allocUtf8String(className));
                }
            }
        }
        if (targetClass && !targetClass.isNull() && nestedParts && nestedParts.length > 1) {
            for (var p = 1; p < nestedParts.length; p++) {
                targetClass = getNestedClass(targetClass, nestedParts[p]);
                if (!targetClass || targetClass.isNull()) break;
            }
        }
        return targetClass;
    }

    function findMethod(imgName, nsName, clsName, mName, pCount) {
        var cls = getClass(imgName, nsName, clsName);
        if (!cls || cls.isNull()) return null;
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var m;
        while (!(m = il2cpp_class_get_methods(cls, iter)).isNull()) {
            if (il2cpp_method_get_name(m).readCString() === mName) {
                if (pCount === undefined || il2cpp_method_get_param_count(m) === pCount) {
                    return m;
                }
            }
        }
        return null;
    }

    var hooksInstalled = false;
    function installCSharpHooks() {
        if (hooksInstalled) return true;
        var domain = il2cpp_domain_get ? il2cpp_domain_get() : NULL;
        if (!domain || domain.isNull()) {
            return false;
        }

        var appClass = getClass("UnityEngine.CoreModule", "UnityEngine", "Application");
        if (!appClass || appClass.isNull()) {
            appClass = getClass("UnityEngine", "UnityEngine", "Application");
        }
        if (!appClass || appClass.isNull()) {
            return false;
        }

        hooksInstalled = true;
        log("[🎉 INSTALLING C# IL2CPP HOOKS - DOMAIN FULLY READY] Domain: " + domain);
        try {
            var iter = Memory.alloc(Process.pointerSize);
            iter.writePointer(NULL);
            var method;
            while (!(method = il2cpp_class_get_methods(appClass, iter)).isNull()) {
                var mName = il2cpp_method_get_name(method).readCString();
                if (mName === "Quit") {
                    var fnPtr = method.readPointer();
                    if (!fnPtr.isNull()) {
                        Interceptor.attach(fnPtr, {
                            onEnter: function (args) {
                                log("[🚫 BLOCKED] UnityEngine.Application.Quit() called!");
                            }
                        });
                        log("[+] Hooked Application.Quit at: " + fnPtr);
                    }
                } else if (mName === "get_internetReachability") {
                    var fnPtr = method.readPointer();
                    if (!fnPtr.isNull()) {
                        Interceptor.attach(fnPtr, {
                            onLeave: function (retval) {
                                try { retval.replace(2); } catch (e) {}
                            }
                        });
                        log("[+] Hooked Application.get_internetReachability -> 2 (ReachableViaLocalAreaNetwork)");
                    }
                }
            }
        } catch (e) {
            log("[-] Error hooking Application: " + e.message);
        }

    // --- UNIVERSAL URL REDIRECT HELPER ---
    function hookStringMethods(targetClass, className) {
        if (!targetClass || targetClass.isNull()) return;
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(targetClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            (function (name, ptr) {
                Interceptor.attach(ptr, {
                    onEnter: function (args) {
                        for (var i = 0; i < 4; i++) {
                            try {
                                var str = readIl2CppString(args[i]);
                                if (str && (str.startsWith("http://") || str.startsWith("https://"))) {
                                    var newUrl = str.replace(/^https?:\/\/[^\/]+/, "http://10.0.2.2:8000");
                                    args[i] = createIl2CppString(newUrl);
                                    log("[🌐 URL REDIRECT] " + className + "." + name + " (arg " + i + "): " + str + " -> " + newUrl);
                                }
                            } catch (e) {}
                        }
                    }
                });
            })(mName, fnPtr);
        }
    }

    // --- 2. UNITYWEBREQUEST URL REDIRECT ---
    var uwrClass = getClass("UnityEngine.UnityWebRequestModule", "UnityEngine.Networking", "UnityWebRequest");
    if (!uwrClass || uwrClass.isNull()) {
        uwrClass = getClass("UnityEngine", "UnityEngine.Networking", "UnityWebRequest");
    }
    log("[+] UnityWebRequest Class: " + uwrClass);
    if (uwrClass && !uwrClass.isNull()) {
        hookStringMethods(uwrClass, "UnityWebRequest");
    }

    // --- 3. BYPASS NETWORKCONTROL & MAINTENANCE CHECKS ---
    var netClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control", "NetworkControl");
    if (!netClass || netClass.isNull()) {
        netClass = getClass("Assembly-CSharp", "", "NetworkControl");
    }
    log("[+] NetworkControl Class: " + netClass);

    if (netClass && !netClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(netClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "get_IsOpened" || mName === "get_IsMaintenanceChecked" || 
                mName === "get_ServerUrlChecked" || mName === "get_IsDone" || 
                mName === "get_IsValid" || mName === "get_CheckDownloadable" ||
                mName === "get_IsTermsAndPolicy" || mName === "get_IsTapjoyTutorialFinish") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked NetworkControl." + mName + " -> true (1)");
            }
            else if (mName === "get_ServerState") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(0); } catch (e) {} // 0 = Normal / Online
                    }
                });
                log("[+] Hooked NetworkControl.get_ServerState -> 0 (Normal)");
            }
            else if (mName === "CheckServerUrl" || mName === "CheckServerStatus" || 
                     mName === "CheckServerUrl_Step2" || mName === "CheckServerStatus_Step2") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        log("[+] NetworkControl." + mName + " bypassed.");
                    },
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked NetworkControl." + mName + " -> Success");
            }
            else if (mName === "GetManifestURL") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        var url = "http://10.0.2.2:8000/manifest.json";
                        var strPtr = createIl2CppString(url);
                        if (!strPtr.isNull()) {
                            retval.replace(strPtr);
                            log("[🌐 REDIRECT] NetworkControl.GetManifestURL -> " + url);
                        }
                    }
                });
                log("[+] Hooked NetworkControl.GetManifestURL -> Local Revival Server");
            }
            else if (mName === "OpenServerMaintenanceView" || mName === "CheckServerMaintenance") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        log("[🚫 BLOCKED] NetworkControl." + mName + " blocked from showing maintenance dialog!");
                    }
                });
                log("[+] Hooked NetworkControl." + mName + " -> No-Op");
            }
        }
    }

    // --- 4. NOTICE CONTROL BYPASS ---
    var noticeClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control", "NoticeControl");
    if (!noticeClass || noticeClass.isNull()) {
        noticeClass = getClass("Assembly-CSharp", "", "NoticeControl");
    }
    if (noticeClass && !noticeClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(noticeClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "OpenNoticeView" || mName === "ShowNotice" || mName === "CheckNotice") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        log("[🚫 BLOCKED] NoticeControl." + mName + " bypassed!");
                    }
                });
                log("[+] Hooked NoticeControl." + mName + " -> Bypassed");
            }
        }
    }

    // --- 5. HTTP REQUEST INTERCEPTOR & LOGGER (BestHTTP) ---
    var httpReqClass = getClass("BestHTTP", "BestHTTP", "HTTPRequest");
    if (!httpReqClass || httpReqClass.isNull()) {
        httpReqClass = getClass("Assembly-CSharp", "BestHTTP", "HTTPRequest");
    }
    log("[+] BestHTTP.HTTPRequest Class: " + httpReqClass);

    if (httpReqClass && !httpReqClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(httpReqClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "Send") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        try {
                            var req = args[0];
                            log("\n=======================================================");
                            log("📡 [BestHTTP HTTPRequest.Send] Intercepted Outgoing Request!");
                            log("   Request Object: " + req);
                            log("=======================================================");
                        } catch (err) {
                            log("[-] Error in HTTPRequest.Send logger: " + err.message);
                        }
                    }
                });
                log("[+] Hooked BestHTTP.HTTPRequest.Send for Traffic Logging!");
            }
        }
    }

    // --- 5b. DALCOM NETWORK HANDLER HOOKS ---
    var nhClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client", "NetworkHandler");
    if (!nhClass || nhClass.isNull()) nhClass = getClass("Assembly-CSharp", "", "NetworkHandler");
    log("[+] NetworkHandler Class: " + nhClass);
    if (nhClass && !nhClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(nhClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;
            log("   -> NetworkHandler method: " + mName + " at: " + fnPtr);
        }
    }

    // --- 6. MAINTENANCE VIEW & POPUP SUPPRESSION ---
    var maintClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.main", "MaintenanceView");
    if (!maintClass || maintClass.isNull()) maintClass = getClass("Assembly-CSharp", "", "MaintenanceView");
    if (maintClass && !maintClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(maintClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;
            Interceptor.attach(fnPtr, {
                onEnter: function (args) {
                    log("[🚫 SUPPRESSED] MaintenanceView." + mName + " prevented from execution!");
                }
            });
            log("[+] Hooked MaintenanceView." + mName + " -> Suppressed");
        }
    }

    var popupClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.popup", "NoticePopup");
    if (!popupClass || popupClass.isNull()) popupClass = getClass("Assembly-CSharp", "", "NoticePopup");
    if (popupClass && !popupClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(popupClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;
            Interceptor.attach(fnPtr, {
                onEnter: function (args) {
                    log("[🚫 SUPPRESSED] NoticePopup." + mName + " prevented from execution!");
                }
            });
            log("[+] Hooked NoticePopup." + mName + " -> Suppressed");
        }
    }

    // --- 7. VERSION CONTROL BYPASS ---
    var verClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control", "VersionControl");
    if (!verClass || verClass.isNull()) verClass = getClass("Assembly-CSharp", "", "VersionControl");
    log("[+] VersionControl Class: " + verClass);
    if (verClass && !verClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(verClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "get_IsDone" || mName === "get_IsValid" || mName === "get_IsVersionChecked") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked VersionControl." + mName + " -> true (1)");
            } else if (mName === "get_IsNeedUpdate" || mName === "get_IsNeedDownload") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(0); } catch (e) {}
                    }
                });
                log("[+] Hooked VersionControl." + mName + " -> false (0)");
            } else if (mName === "get_VersionString" || mName === "get_VersionBuiltIn" || 
                       mName === "get_VersionClientApi" || mName === "get_VersionClientAsset") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(createIl2CppString("3.12.4")); } catch (e) {}
                    }
                });
                log("[+] Hooked VersionControl." + mName + " -> 3.12.4");
            } else if (mName === "get_VersionCode" || mName === "get_LastVersionCode") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(31204); } catch (e) {}
                    }
                });
                log("[+] Hooked VersionControl." + mName + " -> 31204");
            } else if (mName === "CheckVersion" || mName === "OnCheckVersion" || mName === "StartCheck") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked VersionControl." + mName + " -> Success (1)");
            }
        }
    }

    // --- 8. WWWFILE SUPPRESSION & ERROR BYPASS ---
    var wwwClass = getClass("Assembly-CSharp", "Ext.Unity3D.Cdn", "WWWFile");
    if (wwwClass && !wwwClass.isNull()) {
        hookStringMethods(wwwClass, "WWWFile");
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(wwwClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "Error") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        log("[⚠️ SUPPRESSED] WWWFile.Error called -> suppressing failure signal!");
                    }
                });
                log("[+] Hooked WWWFile.Error -> Suppressed");
            } else if (mName === "get_IsError") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(0); } catch (e) {}
                    }
                });
                log("[+] Hooked WWWFile.get_IsError -> false (0)");
            } else if (mName === "get_IsDone" || mName === "VersionExists") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked WWWFile." + mName + " -> true (1)");
            } else if (mName === "ReadVersion") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(createIl2CppString("3.12.4")); } catch (e) {}
                    }
                });
                log("[+] Hooked WWWFile.ReadVersion -> 3.12.4");
            }
        }
    }

    // --- 9. CLIENT RPC LOGGER ---
    var clientClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client", "Client");
    if (clientClass && !clientClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(clientClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "request" || mName === "requestFake" || mName === "startRequest") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        log("\n=======================================================");
                        log("⚡ [DALCOM CLIENT RPC] Invoked: " + mName);
                        log("=======================================================");
                    }
                });
                log("[+] Hooked Client." + mName + " for RPC tracking");
            }
        }
    }

    // --- 10. ENTRY VIEW & ENTRY SCENE HOOKS ---
    var entryViewClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.main", "EntryView");
    if (entryViewClass && !entryViewClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(entryViewClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;
            log("   -> EntryView method: " + mName + " at: " + fnPtr);
        }
    }

    var entrySceneClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.scene", "EntryScene");
    if (entrySceneClass && !entrySceneClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(entrySceneClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;
            log("   -> EntryScene method: " + mName + " at: " + fnPtr);

            if (mName === "get_IsAllCompleted") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked EntryScene.get_IsAllCompleted -> true (1)");
            }
        }
    }

    // --- 11. NETWORK HANDLER & TITLE SCENE HOOKS ---
    var netHandlerClass = getClass("Assembly-CSharp", "", "NetworkHandler");
    if (netHandlerClass && !netHandlerClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(netHandlerClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "get_isSucceed") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        this.handle = args[0];
                    },
                    onLeave: function (retval) {
                        try {
                            if (this.handle && !this.handle.isNull()) {
                                var resp = this.handle.add(0x20).readPointer();
                                if (resp.isNull()) {
                                    retval.replace(0);
                                    return;
                                }
                            }
                            retval.replace(1);
                        } catch (e) {}
                    }
                });
                log("[+] Hooked NetworkHandler.get_isSucceed -> null-safe");
            } else if (mName === "get_isDone" || mName === "get_isDoneWWW") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked NetworkHandler." + mName + " -> true (1)");
            } else if (mName === "get_isFailed" || mName === "get_isCanceled") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(0); } catch (e) {}
                    }
                });
                log("[+] Hooked NetworkHandler." + mName + " -> false (0)");
            } else if (mName === "get_code") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1000); } catch (e) {}
                    }
                });
                log("[+] Hooked NetworkHandler.get_code -> 1000");
            } else if (mName === "get_httpErrorStatus") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(200); } catch (e) {}
                    }
                });
                log("[+] Hooked NetworkHandler.get_httpErrorStatus -> 200");
            }
        }
    }

    var clientNetHandlerClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client", "NetworkHandler");
    if (clientNetHandlerClass && !clientNetHandlerClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(clientNetHandlerClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "onTimeout" || mName === "onError") {
                try {
                    Interceptor.replace(fnPtr, new NativeCallback(function () {
                        log("[🛡️ SUPPRESSED] NetworkHandler." + mName + " blocked!");
                    }, "void", []));
                    log("[+] Hooked NetworkHandler." + mName + " -> Suppressed");
                } catch (e) {}
            }
        }
    }

    var apiExceptClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control", "ApiExceptControl");
    if (apiExceptClass && !apiExceptClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(apiExceptClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "Except" || mName === "Open") {
                try {
                    Interceptor.replace(fnPtr, new NativeCallback(function () {
                        log("[🛡️ SUPPRESSED] ApiExceptControl." + mName + " error dialog blocked!");
                    }, "void", []));
                    log("[+] Hooked ApiExceptControl." + mName + " -> Suppressed");
                } catch (e) {}
            }
        }
    }

    var tutClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "TutorialControl");
    if (!tutClass || tutClass.isNull()) tutClass = getClass("Assembly-CSharp", "", "TutorialControl");
    if (tutClass && !tutClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(tutClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "get_IsCompleted" || mName === "get_InGameTutorialDone") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(0); } catch (e) {}
                    }
                });
                log("[+] Hooked TutorialControl." + mName + " -> false (0) [SHOW TUTORIAL DIALOG]");
            }
        }
    }

    var platformCmdClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.command", "Platform");
    if (platformCmdClass && !platformCmdClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(platformCmdClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "getRegion") {
                Interceptor.attach(fnPtr, {
                    onEnter: function (args) {
                        log("[+] Platform.getRegion called with callback: " + args[0]);
                    }
                });
                log("[+] Hooked Platform.getRegion");
            }
        }
    }

    // Platform.getRegion handler bypass
    var baseAddr = Module.findBaseAddress("libil2cpp.so");
    if (baseAddr) {
        try {
            var getRegionCallbackHandlerPtr = baseAddr.add(0xEF87D0);
            Interceptor.replace(getRegionCallbackHandlerPtr, new NativeCallback(function (thiz, handle) {
                log("[🌍 PLATFORM] Platform.<getRegion>b__0 intercepted -> safely invoking callback('KR', false)");
                try {
                    var cb = thiz.add(0x10).readPointer();
                    if (!cb.isNull()) {
                        var invokePtr = baseAddr.add(0x18F3F30);
                        var invokeFn = new NativeFunction(invokePtr, "void", ["pointer", "pointer", "pointer", "bool", "pointer"]);
                        var methodInfo = baseAddr.add(0x30FB000).add(0xC70).readPointer();
                        invokeFn(cb, handle, createIl2CppString("KR"), 0, methodInfo);
                        log("[🌟 SUCCESS] Platform.<getRegion>b__0 safely invoked with KR!");
                    }
                } catch (e) {
                    log("[-] Error in getRegion callback bypass: " + e.message);
                }
            }, "void", ["pointer", "pointer"]));
            log("[+] Hooked Platform.<getRegion>b__0 at: " + getRegionCallbackHandlerPtr);
        } catch (e) {
            log("[-] Error hooking getRegionCallbackHandler: " + e.message);
        }
    }

    var assetDownloaderClass = getClass("Assembly-CSharp", "common.SuperStar.Application.Util", "AssetDownloader");
    if (!assetDownloaderClass || assetDownloaderClass.isNull()) assetDownloaderClass = getClass("Assembly-CSharp", "", "AssetDownloader");
    if (assetDownloaderClass && !assetDownloaderClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(assetDownloaderClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "get_FirstDownloadFileCount") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(0); } catch (e) {}
                    }
                });
                log("[+] Hooked AssetDownloader.get_FirstDownloadFileCount -> 0");
            }
        }
    }

    var reqClass = getClass("Assembly-CSharp", "BestHTTP", "HTTPRequest");
    if (!reqClass || reqClass.isNull()) reqClass = getClass("Assembly-CSharp-firstpass", "BestHTTP", "HTTPRequest");
    if (reqClass && !reqClass.isNull()) {
        var iter = Memory.alloc(Process.pointerSize);
        iter.writePointer(NULL);
        var method;
        while (!(method = il2cpp_class_get_methods(reqClass, iter)).isNull()) {
            var mName = il2cpp_method_get_name(method).readCString();
            var fnPtr = method.readPointer();
            if (fnPtr.isNull()) continue;

            if (mName === "CallCustomCertificationValidator") {
                Interceptor.attach(fnPtr, {
                    onLeave: function (retval) {
                        try { retval.replace(1); } catch (e) {}
                    }
                });
                log("[+] Hooked BestHTTP.HTTPRequest.CallCustomCertificationValidator -> true (1)");
            }
        }
    }

    // Proteger ImageMerger contra IndexOutOfRangeException durante la carga in-game
    if (baseAddr) {
        try {
            var imgMerger32Ptr = baseAddr.add(0xBAEC88);
            var imgMerger24Ptr = baseAddr.add(0xBAED3C);
            var imgMergerAlphaPtr = baseAddr.add(0xBAEDF0);

            Interceptor.replace(imgMerger32Ptr, new NativeCallback(function (colors, colorsWidth, x, y, w, h, colors_src, src_x, src_y, src_w) {
                log("[🎨 IMAGE MERGER] SetPixels32_src32 called, safely bypassed");
                return colors;
            }, "pointer", ["pointer", "int", "int", "int", "int", "int", "pointer", "int", "int", "int"]));

            Interceptor.replace(imgMerger24Ptr, new NativeCallback(function (colors, colorsWidth, x, y, w, h, colors_src, src_x, src_y, src_w) {
                log("[🎨 IMAGE MERGER] SetPixels32_src24 called, safely bypassed");
                return colors;
            }, "pointer", ["pointer", "int", "int", "int", "int", "int", "pointer", "int", "int", "int"]));

            Interceptor.replace(imgMergerAlphaPtr, new NativeCallback(function (colors, colorsWidth, x, y, w, h, colors_src, src_x, src_y, src_w) {
                log("[🎨 IMAGE MERGER] SetPixels32_AlphaBlending called, safely bypassed");
                return colors;
            }, "pointer", ["pointer", "int", "int", "int", "int", "int", "pointer", "int", "int", "int"]));
            log("[+] ImageMerger texture buffers protected against IndexOutOfRangeException!");

            // Hook RijndaelManaged CreateDecryptor & CreateEncryptor to capture AES Key & IV
            var createDecPtr = baseAddr.add(0x1ADD6C4);
            var createEncPtr = baseAddr.add(0x1ADD560);
            function logCryptoKeys(name, keyArr, ivArr) {
                try {
                    var keyHex = "", ivHex = "", keyStr = "", ivStr = "";
                    if (keyArr && !keyArr.isNull()) {
                        var kLen = keyArr.add(0x18).readInt();
                        if (kLen > 0 && kLen < 128) {
                            var kBuf = keyArr.add(0x20).readByteArray(kLen);
                            var u8K = new Uint8Array(kBuf);
                            for (var i = 0; i < u8K.length; i++) {
                                keyHex += ("0" + u8K[i].toString(16)).slice(-2);
                                keyStr += (u8K[i] >= 32 && u8K[i] < 127) ? String.fromCharCode(u8K[i]) : ".";
                            }
                        }
                    }
                    if (ivArr && !ivArr.isNull()) {
                        var ivLen = ivArr.add(0x18).readInt();
                        if (ivLen > 0 && ivLen < 128) {
                            var ivBuf = ivArr.add(0x20).readByteArray(ivLen);
                            var u8Iv = new Uint8Array(ivBuf);
                            for (var j = 0; j < u8Iv.length; j++) {
                                ivHex += ("0" + u8Iv[j].toString(16)).slice(-2);
                                ivStr += (u8Iv[j] >= 32 && u8Iv[j] < 127) ? String.fromCharCode(u8Iv[j]) : ".";
                            }
                        }
                    }
                    log("🔑 [" + name + "] KEY (" + (keyHex.length/2) + " bytes): " + keyHex + " | ASCII: " + keyStr);
                    log("🔑 [" + name + "] IV  (" + (ivHex.length/2) + " bytes): " + ivHex + " | ASCII: " + ivStr);
                } catch (e) {
                    log("[-] Error dumping crypto keys: " + e.message);
                }
            }

            try {
                Interceptor.attach(createDecPtr, {
                    onEnter: function (args) {
                        logCryptoKeys("Rijndael.CreateDecryptor", args[1], args[2]);
                    }
                });
                Interceptor.attach(createEncPtr, {
                    onEnter: function (args) {
                        logCryptoKeys("Rijndael.CreateEncryptor", args[1], args[2]);
                    }
                });
            } catch (eHooks) {
                log("[-] Warning setting crypto attach hooks: " + eHooks.message);
            }
        } catch (e) {
            log("[-] Error in crypto setup: " + e.message);
        }
    }

    // Desencriptación nativa y extracción de msd.bin a JSON ejecutada inmediatamente
    if (baseAddr) {
        try {
            var il2cpp_thread_attach = new NativeFunction(Module.findExportByName("libil2cpp.so", "il2cpp_thread_attach"), "pointer", ["pointer"]);
            var il2cpp_domain_get = new NativeFunction(Module.findExportByName("libil2cpp.so", "il2cpp_domain_get"), "pointer", []);
            var il2cpp_string_new = new NativeFunction(Module.findExportByName("libil2cpp.so", "il2cpp_string_new"), "pointer", ["pointer"]);

            var curDomain = il2cpp_domain_get();
            if (curDomain && !curDomain.isNull()) {
                il2cpp_thread_attach(curDomain);
            }

            function findMethod(imgName, nsName, clsName, mName, pCount) {
                var cls = getClass(imgName, nsName, clsName);
                if (!cls || cls.isNull()) return null;
                var iter = Memory.alloc(Process.pointerSize);
                iter.writePointer(NULL);
                var m;
                while (!(m = il2cpp_class_get_methods(cls, iter)).isNull()) {
                    if (il2cpp_method_get_name(m).readCString() === mName) {
                        if (pCount === undefined || il2cpp_method_get_param_count(m) === pCount) {
                            return m;
                        }
                    }
                }
                return null;
            }

            var readAllBytesMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllBytes", 1);
            var decompressMethod = findMethod("Assembly-CSharp", "Dalcomsoft", "GZipCompressor", "Decompress", 2);
            var decryptMethod = findMethod("Assembly-CSharp", "com.dalcomsoft.project.client", "CipherSimple", "decrypt", 2);
            var writeAllTextMethod = findMethod("mscorlib", "System.IO", "File", "WriteAllText", 2);

            log("[🔎 METHODS] ReadAllBytes: " + readAllBytesMethod + ", Decompress: " + decompressMethod + ", Decrypt: " + decryptMethod);

            if (readAllBytesMethod && decompressMethod && decryptMethod) {
                var pathStr = il2cpp_string_new(Memory.allocUtf8String("/sdcard/msd.bin"));
                var args1 = Memory.alloc(Process.pointerSize);
                args1.writePointer(pathStr);
                var exc = Memory.alloc(Process.pointerSize);
                exc.writePointer(NULL);
                var bytesObj = il2cpp_runtime_invoke(readAllBytesMethod, NULL, args1, exc);
                log("[📦 MSD.BIN] Read bytes object: " + bytesObj);

                if (bytesObj && !bytesObj.isNull()) {
                    var outStrPtr = Memory.alloc(Process.pointerSize);
                    outStrPtr.writePointer(NULL);
                    var args2 = Memory.alloc(Process.pointerSize * 2);
                    args2.writePointer(bytesObj);
                    args2.add(Process.pointerSize).writePointer(outStrPtr);

                    il2cpp_runtime_invoke(decompressMethod, NULL, args2, exc);
                    var b64Str = outStrPtr.readPointer();
                    log("[📦 MSD.BIN] Decompressed base64 str: " + b64Str);

                    if (b64Str && !b64Str.isNull()) {
                        var args3 = Memory.alloc(Process.pointerSize * 2);
                        args3.writePointer(b64Str);
                        args3.add(Process.pointerSize).writePointer(NULL); // transform = null (uses default)

                        var jsonStrObj = il2cpp_runtime_invoke(decryptMethod, NULL, args3, exc);
                        log("[📦 MSD.BIN] Decrypted JSON Object: " + jsonStrObj);

                        if (jsonStrObj && !jsonStrObj.isNull()) {
                            var strLen = jsonStrObj.add(0x10).readInt();
                            var strChars = jsonStrObj.add(0x14).readUtf16String(strLen);
                            log("🎉🎉🎉 [SUCCESSFUL DECRYPTION OF MSD.BIN -> JSON] Character count: " + strLen);
                            log("📄 [JSON PREVIEW]: " + strChars.substring(0, 400));

                            if (writeAllTextMethod) {
                                var outPathStr = il2cpp_string_new(Memory.allocUtf8String("/sdcard/msd.json"));
                                var args4 = Memory.alloc(Process.pointerSize * 2);
                                args4.writePointer(outPathStr);
                                args4.add(Process.pointerSize).writePointer(jsonStrObj);
                                il2cpp_runtime_invoke(writeAllTextMethod, NULL, args4, exc);
                                log("💾 [SAVED FILE] /sdcard/msd.json successfully written to disk!");
                            }
                        }
                    }
                }
            }
        } catch (e) {
            log("[-] Error in native msd.bin decryption pipeline: " + e.message);
        }
    }

    if (baseAddr) {
        try {
            var sceneControlClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control", "SceneControl");
            var openSceneMethod = null;
            if (sceneControlClass && !sceneControlClass.isNull()) {
                var iterSC = Memory.alloc(Process.pointerSize);
                iterSC.writePointer(NULL);
                var methodSC;
                while (!(methodSC = il2cpp_class_get_methods(sceneControlClass, iterSC)).isNull()) {
                    var mNameSC = il2cpp_method_get_name(methodSC).readCString();
                    if (mNameSC === "OpenScene") {
                        openSceneMethod = methodSC;
                        log("[+] Found SceneControl.OpenScene MethodInfo: " + openSceneMethod);
                        break;
                    }
                }
            }

            function triggerOpenScene(sceneType) {
                if (openSceneMethod && il2cpp_runtime_invoke) {
                    var args = Memory.alloc(Process.pointerSize * 3);
                    var pSceneType = Memory.alloc(4);
                    pSceneType.writeInt(sceneType);
                    args.writePointer(pSceneType);
                    args.add(Process.pointerSize).writePointer(NULL);
                    args.add(Process.pointerSize * 2).writePointer(NULL);
                    il2cpp_runtime_invoke(openSceneMethod, NULL, args, NULL);
                    log("[🌟 SUCCESS] SceneControl.OpenScene(" + sceneType + ") cleanly dispatched!");
                }
            }

            var entryOnOpenPtr = baseAddr.add(0xE20034);
            var entrySetStateWaitPtr = baseAddr.add(0xE20498);
            var entryIsAllCompletedPtr = baseAddr.add(0xE20628);

            // Permitir que EntryView reproduzca los logos de Dalcomsoft y BlockBerry Creative
            Interceptor.attach(entryIsAllCompletedPtr, {
                onLeave: function (retval) {
                    try { retval.replace(1); } catch (e) {}
                }
            });

            var hasAdvancedFromEntry = false;
            function autoAdvanceToTitle() {
                if (hasAdvancedFromEntry) return;
                hasAdvancedFromEntry = true;
                log("[🎬 ENTRY SCENE] Advancing to TitleScene (Scene 2)...");
                setTimeout(function () {
                    try {
                        triggerOpenScene(2);
                    } catch (e) {
                        log("[-] Error transitioning to TitleScene: " + e.message);
                    }
                }, 2000);
            }

            Interceptor.attach(entryOnOpenPtr, {
                onEnter: function (args) {
                    log("[🎬 ENTRY SCENE] EntryScene.OnOpen entered! Scheduling advance to TitleScene...");
                    autoAdvanceToTitle();
                }
            });

            Interceptor.attach(entrySetStateWaitPtr, {
                onEnter: function (args) {
                    log("[🎬 ENTRY SCENE] EntryScene.SetStateWait entered!");
                    autoAdvanceToTitle();
                }
            });

            var onOpenPtr = baseAddr.add(0xB21290);
            var setIntroPtr = baseAddr.add(0xB22034);

            Interceptor.attach(onOpenPtr, {
                onEnter: function (args) {
                    log("[🌟 TITLE SCENE ONOPEN] Captured Instance: " + args[0]);
                    globalTitleScene = args[0];

                    // Ejecutar desencriptación nativa de msd.bin
                    try {
                        var readAllBytesMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllBytes", 1);
                        var decompressMethod = findMethod("Assembly-CSharp", "Dalcomsoft", "GZipCompressor", "Decompress", 2);
                        var decryptMethod = findMethod("Assembly-CSharp", "com.dalcomsoft.project.client", "CipherSimple", "decrypt", 2);
                        var writeAllTextMethod = findMethod("mscorlib", "System.IO", "File", "WriteAllText", 2);

                        log("[🔎 TITLE METHODS] ReadAllBytes: " + readAllBytesMethod + ", Decompress: " + decompressMethod + ", Decrypt: " + decryptMethod);

                        if (readAllBytesMethod && decompressMethod && decryptMethod) {
                            var pathStr = il2cpp_string_new(Memory.allocUtf8String("/sdcard/msd.bin"));
                            var args1 = Memory.alloc(Process.pointerSize);
                            args1.writePointer(pathStr);
                            var exc = Memory.alloc(Process.pointerSize);
                            exc.writePointer(NULL);
                            var bytesObj = il2cpp_runtime_invoke(readAllBytesMethod, NULL, args1, exc);
                            log("[📦 MSD.BIN] Read bytes object: " + bytesObj);

                            if (bytesObj && !bytesObj.isNull()) {
                                var outStrPtr = Memory.alloc(Process.pointerSize);
                                outStrPtr.writePointer(NULL);
                                var args2 = Memory.alloc(Process.pointerSize * 2);
                                args2.writePointer(bytesObj);
                                args2.add(Process.pointerSize).writePointer(outStrPtr);

                                il2cpp_runtime_invoke(decompressMethod, NULL, args2, exc);
                                var b64Str = outStrPtr.readPointer();
                                log("[📦 MSD.BIN] Decompressed base64 str: " + b64Str);

                                if (b64Str && !b64Str.isNull()) {
                                    var args3 = Memory.alloc(Process.pointerSize * 2);
                                    args3.writePointer(b64Str);
                                    args3.add(Process.pointerSize).writePointer(NULL);

                                    var jsonStrObj = il2cpp_runtime_invoke(decryptMethod, NULL, args3, exc);
                                    log("[📦 MSD.BIN] Decrypted JSON Object: " + jsonStrObj);

                                    if (jsonStrObj && !jsonStrObj.isNull()) {
                                        var strLen = jsonStrObj.add(0x10).readInt();
                                        var strChars = jsonStrObj.add(0x14).readUtf16String(strLen);
                                        log("🎉🎉🎉 [SUCCESSFUL DECRYPTION OF MSD.BIN -> JSON] Character count: " + strLen);
                                        log("📄 [JSON PREVIEW]: " + strChars.substring(0, 400));

                                        if (writeAllTextMethod) {
                                            var outPathStr = il2cpp_string_new(Memory.allocUtf8String("/sdcard/msd.json"));
                                            var args4 = Memory.alloc(Process.pointerSize * 2);
                                            args4.writePointer(outPathStr);
                                            args4.add(Process.pointerSize).writePointer(jsonStrObj);
                                            il2cpp_runtime_invoke(writeAllTextMethod, NULL, args4, exc);
                                            log("💾 [SAVED FILE] /sdcard/msd.json successfully written to disk!");
                                        }
                                    }
                                }
                            }
                        }
                    } catch (eDec) {
                        log("[-] Error decrypting msd.bin in TitleScene: " + eDec.message);
                    }
                }
            });

            var titleSceneClass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.scene", "TitleScene");
            var setTutorialMethod = null;
            if (titleSceneClass && !titleSceneClass.isNull()) {
                var iter2 = Memory.alloc(Process.pointerSize);
                iter2.writePointer(NULL);
                var method2;
                while (!(method2 = il2cpp_class_get_methods(titleSceneClass, iter2)).isNull()) {
                    var mName2 = il2cpp_method_get_name(method2).readCString();
                    if (mName2 === "SetStateTutorial") setTutorialMethod = method2;
                }
            }

            var popupOpenPtr = baseAddr.add(0x114AD70);
            Interceptor.attach(popupOpenPtr, {
                onEnter: function (args) {
                    var popupInstance = args[0];
                    log("[💬 POPUP OPENED] Popup instance: " + popupInstance);
                }
            });

            Interceptor.attach(onOpenPtr, {
                onEnter: function (args) {
                    globalTitleScene = args[0];
                    log("[🌟 TITLE SCENE ONOPEN] Captured Instance: " + globalTitleScene);
                }
            });

            var setTermsPtr = baseAddr.add(0xB22514);
            var setTutPtr = baseAddr.add(0xB2271C);

            Interceptor.attach(setIntroPtr, {
                onEnter: function (args) {
                    log("[🎬 TITLE SCENE] SetStateIntro -> Intro title screen active.");
                }
            });

            Interceptor.attach(setTermsPtr, {
                onEnter: function (args) {
                    log("[🎬 TITLE SCENE] SetStateTermsAndPolicy -> Proceeding to Tutorial prompt...");
                }
            });

            Interceptor.attach(setTutPtr, {
                onEnter: function (args) {
                    log("[🎬 TITLE SCENE] SetStateTutorial -> TUTORIAL MODAL OPENING ON SCREEN!");
                }
            });

            // Bypass y auto-completado de TutorialStepComplete
            var tutStepCompletePtr = baseAddr.add(0x14E5370);
            Interceptor.replace(tutStepCompletePtr, new NativeCallback(function (step, callbackPtr) {
                log("[🎓 TUTORIAL] TutorialControl.TutorialStepComplete called for step: " + step);
                try {
                    if (!callbackPtr.isNull()) {
                        var invokePtr = callbackPtr.add(Process.pointerSize * 2).readPointer();
                        if (!invokePtr.isNull()) {
                            var invokeFn = new NativeFunction(invokePtr, "void", ["pointer", "int", "pointer"]);
                            invokeFn(callbackPtr, 0, NULL);
                            log("[🌟 SUCCESS] Invoked TutorialStepComplete callback -> SUCCESS!");
                        }
                    }
                } catch (e) {
                    log("[-] Error in TutorialStepComplete bypass: " + e.message);
                }
            }, "void", ["int", "pointer"]));

            // Supresión total de popups de error de red en ViewControl
            var viewPopups = [0xAC4DEC, 0xAA9E58, 0xAC52C8, 0xAC5404, 0xAC5690, 0xAC57CC, 0xAC5A5C, 0xAC5CD4];
            viewPopups.forEach(function (off) {
                try {
                    var p = baseAddr.add(off);
                    Interceptor.replace(p, new NativeCallback(function () {
                        log("[🛡️ SUPPRESSED] ViewControl network popup at " + off.toString(16) + " blocked!");
                        return NULL;
                    }, "pointer", ["pointer"]));
                } catch (e) {}
            });

            // Supresión de diálogos de error de ApiExceptControl
            var apiExceptOpenPtr = baseAddr.add(0x10EF674);
            var apiExceptHandlerPtr = baseAddr.add(0x10EF934);
            var apiExceptCodePtr = baseAddr.add(0x10F0798);

            Interceptor.replace(apiExceptOpenPtr, new NativeCallback(function () {
                log("[🛡️ SUPPRESSED] ApiExceptControl.Open blocked!");
            }, "void", []));

            Interceptor.replace(apiExceptHandlerPtr, new NativeCallback(function (h) {
                log("[🛡️ SUPPRESSED] ApiExceptControl.Except(handler) blocked!");
            }, "void", ["pointer"]));

            Interceptor.replace(apiExceptCodePtr, new NativeCallback(function (c, cb) {
                log("[🛡️ SUPPRESSED] ApiExceptControl.Except(code, callback) blocked! Executing callback...");
                try {
                    if (!cb.isNull()) {
                        var invokePtr = cb.add(Process.pointerSize * 2).readPointer();
                        if (!invokePtr.isNull()) {
                            var invokeFn = new NativeFunction(invokePtr, "void", ["pointer"]);
                            invokeFn(cb);
                            log("[🌟 SUCCESS] Executed customCallback directly!");
                        }
                    }
                } catch (e) {
                    log("[-] Error in customCallback: " + e.message);
                }
            }, "void", ["int", "pointer"]));
            // --- 13. ASSETCONTROL & ASSETDOWNLOADER BYPASS ---
            var assetControlReqTryDownloadPtr = baseAddr.add(0xAD792C);
            var assetControlResCompletePtr = baseAddr.add(0xAD7CC8);
            var assetControlDownloadedSizePtr = baseAddr.add(0xAD7B2C);
            var assetControlConfirmedDownloadPtr = baseAddr.add(0xAD7BF8);
            var assetControlOpenPtr = baseAddr.add(0xAD8000);
            var downloadDonePtr = baseAddr.add(0xADA150);
            var downloadDoneFn = null;
            try {
                downloadDoneFn = new NativeFunction(downloadDonePtr, "void", []);
            } catch (e) {}

            Interceptor.replace(assetControlReqTryDownloadPtr, new NativeCallback(function () {
                log("[📦 ASSET] get_IsRequireTryDownload -> false (bypass download popup)");
                return 0;
            }, "int", []));

            Interceptor.replace(assetControlResCompletePtr, new NativeCallback(function () {
                return 1;
            }, "int", []));

            Interceptor.replace(assetControlDownloadedSizePtr, new NativeCallback(function () {
                return ptr(0);
            }, "pointer", []));

            Interceptor.replace(assetControlConfirmedDownloadPtr, new NativeCallback(function () {
                return 1;
            }, "int", []));

            Interceptor.attach(assetControlOpenPtr, {
                onEnter: function (args) {
                    log("[📦 ASSET] AssetControl.Open called (isCheck=" + args[0] + ")");
                },
                onLeave: function (retval) {
                    log("[📦 ASSET] AssetControl.Open completed! Scheduling DownloadDone transition...");
                    setTimeout(function () {
                        try {
                            if (downloadDoneFn) {
                                downloadDoneFn();
                                log("[🌟 ASSET] AssetControl.DownloadDone executed -> State Done(8) set!");
                            }
                        } catch (e) {
                            log("[-] Error calling DownloadDone: " + e.message);
                        }
                    }, 500);
                }
            });
        } catch (e) {
            log("[-] Scene Hook Error: " + e.message);
        }
    }

        hooksInstalled = true;
        log("[✅] All SSLO Dynamic Revival & Logging Hooks Successfully Installed!");
    }

    var initPtr = Module.findExportByName("libil2cpp.so", "il2cpp_init");
    if (initPtr) {
        Interceptor.attach(initPtr, {
            onLeave: function (retval) {
                log("[🎉 IL2CPP RUNTIME INITIALIZED] il2cpp_init returned! Installing C# hooks...");
                installCSharpHooks();
            }
        });
    }

    var pollInterval = setInterval(function () {
        if (hooksInstalled) {
            clearInterval(pollInterval);
        } else {
            installCSharpHooks();
        }
    }, 100);
}
