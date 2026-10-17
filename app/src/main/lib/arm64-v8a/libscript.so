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
var globalPlayerObj = null;
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

    try {
        var abortAddr = Module.findExportByName("libc.so", "abort");
        if (abortAddr) {
            Interceptor.attach(abortAddr, {
                onEnter: function() {
                    log("[🚨 LIBC ABORT TRIGGERED] Backtrace:\n" + Thread.backtrace(this.context, Backtracer.ACCURATE).map(function(addr) {
                        try {
                            var mod = Process.findModuleByAddress(addr);
                            if (mod) return "  " + mod.name + "!" + addr.sub(mod.base);
                        } catch (e) {}
                        return "  " + addr;
                    }).join("\n"));
                }
            });
            log("[+] Interceptor.attach installed on libc.so!abort");
        }
    } catch (eAbort) {
        log("[-] Error hooking libc.so!abort: " + eAbort.message);
    }

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
    var il2cpp_gchandle_new = getExport("il2cpp_gchandle_new", "uint32", ["pointer", "bool"]);
    var il2cpp_array_new = getExport("il2cpp_array_new", "pointer", ["pointer", "size_t"]);

    try {
        var raiseExAddr = Module.findExportByName("libil2cpp.so", "il2cpp_raise_exception");
        if (raiseExAddr) {
            Interceptor.attach(raiseExAddr, {
                onEnter: function(args) {
                    var ex = args[0];
                    var exClassName = "Unknown";
                    try {
                        var klass = ex.readPointer();
                        var namePtr = il2cpp_class_get_name(klass);
                        if (!namePtr.isNull()) exClassName = namePtr.readCString();
                    } catch (e) {}
                    var msg = "";
                    try {
                        var msgStrPtr = ex.add(0x10).readPointer();
                        if (!msgStrPtr.isNull()) {
                            var len = msgStrPtr.add(0x10).readS32();
                            msg = msgStrPtr.add(0x14).readUtf16String(len);
                        }
                    } catch (e2) {}
                    log("[🔥 IL2CPP EXCEPTION RAISED] Type: " + exClassName + ", Message: '" + msg + "' Caller LR=" + this.returnAddress.sub(il2cppBase));
                }
            });
            log("[+] Interceptor.attach installed on il2cpp_raise_exception!");
        }
    } catch (eRaise) {
        log("[-] Error hooking il2cpp_raise_exception: " + eRaise.message);
    }

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

        // 0. Exception tracer: capture __cxa_throw (0xA8A284) to pinpoint exact crash RVA and backtrace
        try {
            var cxaThrowPtr = baseAddr.add(0xA8A284);
            Interceptor.attach(cxaThrowPtr, {
                onEnter: function(args) {
                    var lr = this.returnAddress;
                    var rva = lr.sub(baseAddr);
                    log("[💥 __cxa_throw] Exception thrown from RVA: " + rva + " (LR=" + lr + ")");
                    try {
                        var thrownObj = args[0];
                        if (!thrownObj.isNull()) {
                            var innerPtr = thrownObj.readPointer();
                            if (!innerPtr.isNull()) {
                                var klass = innerPtr.readPointer();
                                if (!klass.isNull()) {
                                    var kNamePtr = klass.add(0x10).readPointer();
                                    if (!kNamePtr.isNull()) {
                                        log("[💥 __cxa_throw] Exception Type: " + kNamePtr.readCString());
                                    }
                                }
                            }
                        }
                    } catch(eEx) {}
                    try {
                        var bt = Thread.backtrace(this.context, Backtracer.ACCURATE).map(function(addr) {
                            try {
                                return "  " + addr + " (RVA " + addr.sub(baseAddr) + ")";
                            } catch(e) {
                                return "  " + addr;
                            }
                        }).join("\n");
                        log("[💥 __cxa_throw] Backtrace:\n" + bt);
                    } catch (eBt) {}
                }
            });
            log("[+] Exception monitor attached to __cxa_throw (0xA8A284)");
        } catch(eCxa) {
            log("[-] Error hooking __cxa_throw: " + eCxa.message);
        }

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

            // 2.2b AssetControl.<OpenAssetContents>b__108_76 bypass (RVA 0xECA7E8) -> Avoid NRE
            try {
                Interceptor.replace(baseAddr.add(0xECA7E8), new NativeCallback(function (thiz) {
                    log("[📦 ASSET] OpenAssetContents b__108_76 safely bypassed!");
                    return 1;
                }, "bool", ["pointer"]));
            } catch (eB76) {
                log("[-] Error bypassing b__108_76: " + eB76.message);
            }

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
            var fseekPtr = Module.findExportByName("libc.so", "fseek");
            var ftellPtr = Module.findExportByName("libc.so", "ftell");
            var accessPtr = Module.findExportByName("libc.so", "access");
            var strlenPtr = Module.findExportByName("libc.so", "strlen");
            var unlinkPtr = Module.findExportByName("libc.so", "unlink");

            var fopenFn = fopenPtr ? new NativeFunction(fopenPtr, "pointer", ["pointer", "pointer"]) : null;
            var freadFn = freadPtr ? new NativeFunction(freadPtr, "size_t", ["pointer", "size_t", "size_t", "pointer"]) : null;
            var fwriteFn = fwritePtr ? new NativeFunction(fwritePtr, "size_t", ["pointer", "size_t", "size_t", "pointer"]) : null;
            var fcloseFn = fclosePtr ? new NativeFunction(fclosePtr, "int", ["pointer"]) : null;
            var fseekFn = fseekPtr ? new NativeFunction(fseekPtr, "int", ["pointer", "long", "int"]) : null;
            var ftellFn = ftellPtr ? new NativeFunction(ftellPtr, "long", ["pointer"]) : null;
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
                        var fileSize = 65536;
                        if (fseekFn && ftellFn) {
                            fseekFn(fp, 0, 2); // SEEK_END
                            fileSize = Number(ftellFn(fp));
                            fseekFn(fp, 0, 0); // SEEK_SET
                        }
                        if (fileSize <= 0) {
                            fcloseFn(fp);
                            return "";
                        }
                        var buf = Memory.alloc(fileSize + 1);
                        var readRes = freadFn(buf, 1, fileSize, fp);
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
                var invCards = [];
                // 11 cards equipped for LOONA (Theme: Hi High, 1001-1011) at Grade R (4) Level 50
                for (var i = 0; i < 11; i++) {
                    invCards.push({
                        objectID: 100001 + i,
                        cardID: 1001 + i,
                        grade: 4, // Grade R
                        level: 50,
                        energy: 100,
                        score: 100,
                        isEquip: true,
                        isLock: false,
                        isPrism: false
                    });
                }
                // 1 Prism card (1012 - HeeJin Prism)
                invCards.push({
                    objectID: 100012,
                    cardID: 1012,
                    grade: 4,
                    level: 50,
                    energy: 100,
                    score: 100,
                    isEquip: false,
                    isLock: false,
                    isPrism: true
                });
                // 2 extra cards in inventory (unequipped) to verify selective checkmarking
                invCards.push({
                    objectID: 100013,
                    cardID: 1001, // HeeJin extra copy
                    grade: 2, // Grade A
                    level: 1,
                    energy: 50,
                    score: 50,
                    isEquip: false,
                    isLock: false,
                    isPrism: false
                });
                invCards.push({
                    objectID: 100014,
                    cardID: 1002, // HyunJin extra copy
                    grade: 3, // Grade S
                    level: 1,
                    energy: 70,
                    score: 70,
                    isEquip: false,
                    isLock: false,
                    isPrism: false
                });

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
                        cardID: 1001,
                        grade: 4,
                        level: 50
                    },
                    inventoryCards: invCards,
                    equipedCards: {
                        "1001": [100001, 100002, 100003, 100004, 100005, 100006, 100007, 100008, 100009, 100010, 100011]
                    }
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

                    // nicknameChanger: int at 0x64
                    playerObj.add(0x64).writeInt(0);

                    // dalcomCoin: int at 0x70, freeDalcomCoin: int at 0x74
                    playerObj.add(0x70).writeInt(profile.dalcomCoin !== undefined ? profile.dalcomCoin : 5000);
                    playerObj.add(0x74).writeInt(0);

                    // Pin playerObj so Unity GC never collects it
                    if (il2cpp_gchandle_new && !playerObj.isNull()) {
                        try { il2cpp_gchandle_new(playerObj, 0); } catch (eGc) {}
                    }
                    globalPlayerObj = playerObj;

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

            // Hook UserControl.get_Me (0xAAC818) & set_Me (0xAAC7B0) to ensure persistent valid Player
            try {
                Interceptor.replace(baseAddr.add(0xAAC818), new NativeCallback(function (methodInfo) {
                    if (!globalPlayerObj || globalPlayerObj.isNull()) {
                        var p = loadPlayerProfile() || createDefaultProfile("Orbit");
                        setupUserControl(p);
                    }
                    return (globalPlayerObj && !globalPlayerObj.isNull()) ? globalPlayerObj : NULL;
                }, "pointer", ["pointer"]));

                Interceptor.replace(baseAddr.add(0xAAC7B0), new NativeCallback(function (playerPtr, methodInfo) {
                    if (playerPtr && !playerPtr.isNull()) {
                        globalPlayerObj = playerPtr;
                    }
                }, "void", ["pointer", "pointer"]));
                log("[🛡️ USER GUARD] UserControl.get_Me & set_Me safely replaced!");
            } catch (eMeHook) {
                log("[-] Error replacing UserControl.get_Me: " + eMeHook.message);
            }

            // UserControl.Prefs.ConvertKey (0xD723E0) - Return key directly to prevent startup NullReferenceException
            try {
                Interceptor.replace(baseAddr.add(0xD723E0), new NativeCallback(function (keyPtr) {
                    return keyPtr;
                }, "pointer", ["pointer"]));
                log("[🛡️ PREFS GUARD] UserControl.Prefs.ConvertKey safely protected!");
            } catch (eKey) {}

            // Comprehensive UserControl null guards to prevent NullReferenceException when UserControl.Me is null or during background refresh
            try {
                Interceptor.replace(baseAddr.add(0xAAE33C), new NativeCallback(function () {
                    return ptr(10001);
                }, "pointer", []));
                Interceptor.replace(baseAddr.add(0xAAE40C), new NativeCallback(function () {
                    return ptr(0);
                }, "pointer", []));
                Interceptor.replace(baseAddr.add(0xAAC034), new NativeCallback(function (forced) {
                    return;
                }, "void", ["bool"]));

                // Nickname & Special User Type null guards
                try {
                    Interceptor.replace(baseAddr.add(0xAAE734), new NativeCallback(function (methodInfo) {
                        var p = loadPlayerProfile();
                        var nick = (p && p.nickname) ? p.nickname : "Orbit";
                        return createIl2CppString(nick);
                    }, "pointer", ["pointer"]));
                } catch (eNe) {}
                try {
                    Interceptor.replace(baseAddr.add(0xAAE61C), new NativeCallback(function (nickPtr, methodInfo) {
                        try {
                            var nick = readIl2CppString(nickPtr);
                            log("[👤 USER] set_Nickname safely intercepted: " + nick);
                            var p = loadPlayerProfile() || createDefaultProfile("Orbit");
                            p.nickname = nick;
                            savePlayerProfile(p);
                        } catch (eNick) {}
                    }, "void", ["pointer", "pointer"]));
                } catch (eNs) {}
                try {
                    Interceptor.replace(baseAddr.add(0xAAE54C), new NativeCallback(function (methodInfo) {
                        return 0; // SPECIAL_USER_TYPE
                    }, "int", ["pointer"]));
                } catch (eSut) {}
                try {
                    Interceptor.replace(baseAddr.add(0xAAE818), new NativeCallback(function (val, methodInfo) {
                        log("[👤 USER] set_NicknameChanger safely intercepted: " + val);
                    }, "void", ["int", "pointer"]));
                } catch (eNc) {}
                try {
                    Interceptor.replace(baseAddr.add(0xAAE930), new NativeCallback(function (methodInfo) {
                        return 0;
                    }, "int", ["pointer"]));
                } catch (eNcr) {}
                try {
                    Interceptor.replace(baseAddr.add(0xAAF414), new NativeCallback(function (methodInfo) {
                        var p = loadPlayerProfile();
                        return (p && p.profileCode) ? p.profileCode : 1001;
                    }, "int", ["pointer"]));
                } catch (ePcg) {}
                try {
                    Interceptor.replace(baseAddr.add(0xAAF588), new NativeCallback(function (profileCode, methodInfo) {
                        try {
                            log("[👤 USER] set_ProfileCode safely intercepted: " + profileCode);
                            var p = loadPlayerProfile() || createDefaultProfile("Orbit");
                            p.profileCode = profileCode;
                            savePlayerProfile(p);
                        } catch (ePrf) {}
                    }, "void", ["int", "pointer"]));
                } catch (ePcs) {}
                try {
                    // Diamonds
                    Interceptor.replace(baseAddr.add(0xAB1658), new NativeCallback(function (methodInfo) { return 100000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB1470), new NativeCallback(function (methodInfo) { return 100000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB1840), new NativeCallback(function (methodInfo) { return 200000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB1960), new NativeCallback(function (amount, methodInfo) { return 1; }, "int", ["int", "pointer"]));
                    // Rhythm Points (RP)
                    Interceptor.replace(baseAddr.add(0xAB1094), new NativeCallback(function (methodInfo) { return 500000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB0EAC), new NativeCallback(function (methodInfo) { return 500000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB127C), new NativeCallback(function (methodInfo) { return 1000000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB139C), new NativeCallback(function (amount, methodInfo) { return 1; }, "int", ["int", "pointer"]));
                    // Headphones
                    Interceptor.replace(baseAddr.add(0xAB0C5C), new NativeCallback(function (methodInfo) { return 20; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB0D7C), new NativeCallback(function (amount, methodInfo) { return 1; }, "int", ["int", "pointer"]));
                    // Inventory capacity
                    Interceptor.replace(baseAddr.add(0xAB1C1C), new NativeCallback(function (methodInfo) { return 200; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB1B4C), new NativeCallback(function (methodInfo) { return 0; }, "int", ["pointer"]));
                    // Dalcom Coins
                    Interceptor.replace(baseAddr.add(0xAB33FC), new NativeCallback(function (methodInfo) { return 50000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB35E4), new NativeCallback(function (methodInfo) { return 50000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB37CC), new NativeCallback(function (methodInfo) { return 100000; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB38EC), new NativeCallback(function (amount, methodInfo) { return 1; }, "int", ["int", "pointer"]));
                    // Theme changer & leader
                    Interceptor.replace(baseAddr.add(0xAB39C0), new NativeCallback(function (methodInfo) { return 10; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB42E0), new NativeCallback(function (methodInfo) { return 1; }, "int", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xAB4408), new NativeCallback(function (methodInfo) { return 1; }, "int", ["pointer"]));
                } catch (eDia) {}
                log("[🛡️ USER GUARD] UserControl null guards (Nickname, RP, Diamond, Headphones, DalcomCoin, Inven, ProfileCode) successfully installed!");
            } catch (eUserG) {
                log("[-] Error installing UserControl guards: " + eUserG.message);
            }

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

            // TitleLoginAssist.Close (0xB2030C) null guard
            try {
                Interceptor.replace(baseAddr.add(0xB2030C), new NativeCallback(function (methodInfo) {
                    log("[🛡️ LOGIN ASSIST] TitleLoginAssist.Close safely called");
                }, "void", ["pointer"]));
                log("[🛡️ LOGIN ASSIST] TitleLoginAssist.Close null guard installed!");
            } catch (eTla) {}

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
                    var methodInfoSlot = baseAddr.add(0x30F3000).add(0xC90).readPointer();
                    initMetadata(methodInfoSlot);
                    var methodInfo = methodInfoSlot.readPointer();
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

            // Safe replacement for AssetControl.OnOpenContents (0xAD948C) to prevent crashes on missing online asset configs
            try {
                Interceptor.replace(baseAddr.add(0xAD948C), new NativeCallback(function (methodInfo) {
                    try {
                        log("[📦 ASSET] Safe AssetControl.OnOpenContents running...");
                        var openContentsFn = new NativeFunction(baseAddr.add(0xADAA74), "pointer", ["pointer"]);
                        var list = openContentsFn(NULL);
                        if (!list.isNull()) {
                            var items = list.add(0x10).readPointer();
                            var count = list.add(0x18).readS32();
                            log("[📦 ASSET] Found " + count + " OpenAssetContents callbacks to execute safely");
                            var invokeFn = new NativeFunction(baseAddr.add(0xB86944), "bool", ["pointer", "pointer"]);
                            for (var i = 0; i < count; i++) {
                                try {
                                    var cb = items.add(0x20 + i * 8).readPointer();
                                    if (!cb.isNull()) {
                                        invokeFn(cb, NULL);
                                    }
                                } catch (eCb) {
                                    log("[-] Safe bypass of asset callback[" + i + "]: " + eCb.message);
                                }
                            }
                        }
                        log("[📦 ASSET] Safe AssetControl.OnOpenContents completed cleanly!");
                    } catch (eOoc) {
                        log("[-] Error in safe OnOpenContents: " + eOoc.message);
                    }
                }, "void", ["pointer"]));
                log("[+] Safe replacement installed for AssetControl.OnOpenContents (0xAD948C)!");
            } catch (eOocH) {
                log("[-] Error replacing AssetControl.OnOpenContents: " + eOocH.message);
            }

            var downloadDoneCalled = false;
            function ensureDownloadDone() {
                if (downloadDoneCalled) return;
                downloadDoneCalled = true;
                log("[📦 ASSET] ensureDownloadDone invoked -> calling AssetControl.DownloadDone (0xADA150)");
                try {
                    var downloadDoneFn = new NativeFunction(baseAddr.add(0xADA150), 'void', ['pointer']);
                    downloadDoneFn(NULL);
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

                // TitleScene.SetStateTermsAndPolicy (0xB22514) -> auto bypass to SetStateLoading (0xB22D64)
                try {
                    Interceptor.replace(baseAddr.add(0xB22514), new NativeCallback(function (thiz) {
                        log("[📜 TERMS] SetStateTermsAndPolicy intercepted -> directly advancing to SetStateLoading!");
                        var setStateLoadingFn = new NativeFunction(baseAddr.add(0xB22D64), "void", ["pointer"]);
                        setStateLoadingFn(thiz);
                    }, "void", ["pointer"]));
                    log("[+] Hooked TitleScene.SetStateTermsAndPolicy (0xB22514) to auto-advance!");
                } catch (eTerms) {}

                // TitleScene.SetStateSelectLogin (0xB245AC)
                try {
                    Interceptor.replace(baseAddr.add(0xB245AC), new NativeCallback(function (thiz, toggleIndex, methodInfo) {
                        log("[🚀 TITLE SCENE] TitleScene.SetStateSelectLogin intercepted! Redirecting directly to Lobby...");
                        globalTitleScene = thiz;
                        triggerLobbyTransition("SetStateSelectLogin");
                    }, "void", ["pointer", "int", "pointer"]));
                    log("[+] Hooked TitleScene.SetStateSelectLogin (0xB245AC)!");
                } catch (eSsl) {}

                // Input.GetMouseButtonDown (0x25A5624) para detectar toques en pantalla durante TitleScene
                Interceptor.attach(baseAddr.add(0x25A5624), {
                    onLeave: function (retval) {
                        if (retval.toInt32() === 1 && !hasTriggeredLobbyTransition && isAtTouchToStart && sceneId === 2) {
                            if (globalTitleScene && !globalTitleScene.isNull()) {
                                log("[👆 INPUT TAP] Touch/Click detected on screen during TitleScene TOUCH TO START!");
                                triggerLobbyTransition("Input.GetMouseButtonDown");
                            }
                        }
                    }
                });

                Interceptor.attach(baseAddr.add(0xD534BC), {
                    onEnter: function (args) {
                        var targetSid = args[0].toInt32();
                        log("[🎬 SCENE] SceneControl.OpenScene -> sceneId: " + targetSid);
                        if (targetSid !== 2) {
                            isAtTouchToStart = false;
                            hasTriggeredLobbyTransition = true;
                        }
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
                    { index: 10, name: "Go Won", krName: "고원" },
                    { index: 11, name: "Olivia Hye", krName: "올리비아 혜" }
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

                function getIl2CppClassFromSlot(slotRva) {
                    try {
                        var slot = baseAddr.add(slotRva);
                        var ptr1 = slot.readPointer();
                        if (!ptr1.isNull() && ptr1.compare(ptr(0x100000000)) > 0) {
                            return ptr1;
                        }
                    } catch (e) {}
                    return NULL;
                }

                function createDownloadPath(relPath) {
                    try {
                        var klass = getDownloadPathClass();
                        if (!klass || klass.isNull()) return NULL;
                        var dp = il2cpp_object_new(klass);
                        if (!dp || dp.isNull()) return NULL;
                        if (il2cpp_gchandle_new) il2cpp_gchandle_new(dp, 2);
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
                    1011: { grade: 4, level: 50 }
                };

                function syncAccountOwnedCards() {
                    try {
                        var prof = loadPlayerProfile();
                        if (prof && prof.inventoryCards && prof.inventoryCards.length > 0) {
                            for (var i = 0; i < prof.inventoryCards.length; i++) {
                                var ic = prof.inventoryCards[i];
                                if (!accountOwnedCards[ic.cardID] || ic.grade > accountOwnedCards[ic.cardID].grade) {
                                    accountOwnedCards[ic.cardID] = { grade: ic.grade, level: ic.level };
                                }
                            }
                            log("[🗃️ OWNED CARDS] Synced " + prof.inventoryCards.length + " cards to accountOwnedCards!");
                        }
                    } catch (eSc) {
                        log("[-] Error in syncAccountOwnedCards: " + eSc.message);
                    }
                }
                syncAccountOwnedCards();

                // grade: 0=C, 1=B, 2=A, 3=S, 4=R
                // type: 0=Large (_l), 1=Small (_s), 2=Collection (_c)
                function getGradeFrameDownloadPath(grade, type, isCollection, themeCode) {
                    var tc = (themeCode !== undefined && themeCode !== null) ? themeCode : 0;
                    var g = "c";
                    if (grade === 1) g = "b";
                    else if (grade === 2) g = "a";
                    else if (grade === 3) g = "s";
                    else if (grade === 4) g = "r";

                    var variant = "s";
                    if (isCollection || type === 2) variant = "c";
                    else if (type === 0) variant = "l";

                    var fname = "";
                    if (g === "b") {
                        fname = tc + "b_" + variant + ".i.bytes";
                    } else if (g === "c" && variant === "l") {
                        fname = tc + "c_l.i.bytes";
                    } else {
                        fname = tc + "_" + g + "_" + variant + ".i.bytes";
                    }

                    return createDownloadPath("asiudgasg/asodhsg/aoeiwhslc/uhex/" + fname);
                }

                // =========================================================================
                // 📊 CARD STATS (cbd.json) & METADATA (cdd.json, tmd.json) ENGINE
                // =========================================================================
                var cbdCache = null;
                var cidCache = null;
                var cgdCache = null;
                var csdCache = null;

                function loadOfflineCardDataTables() {
                    if (!cbdCache) {
                        try {
                            var rawCbd = readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/data/cbd.json") ||
                                         readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/sdisgkdc/cbd.json");
                            if (rawCbd) {
                                cbdCache = JSON.parse(rawCbd);
                                log("[📊 CBD] Loaded cbd.json: " + cbdCache.length + " card balance levels cached!");
                            }
                        } catch (eCbd) { log("[-] Error loading cbd.json: " + eCbd.message); }
                    }
                    if (!cidCache) {
                        try {
                            var rawCid = readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/data/cid.json") ||
                                         readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/sdisgkdc/cid.json");
                            if (rawCid) {
                                cidCache = JSON.parse(rawCid);
                                log("[📊 CID] Loaded cid.json: " + cidCache.length + " intensify matrix entries cached!");
                            }
                        } catch (eCid) { log("[-] Error loading cid.json: " + eCid.message); }
                    }
                    if (!cgdCache) {
                        try {
                            var rawCgd = readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/data/cgd.json") ||
                                         readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/sdisgkdc/cgd.json");
                            if (rawCgd) {
                                cgdCache = JSON.parse(rawCgd);
                                log("[📊 CGD] Loaded cgd.json: " + cgdCache.length + " card grade bonus entries cached!");
                            }
                        } catch (eCgd) {}
                    }
                    if (!csdCache) {
                        try {
                            var rawCsd = readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/data/csd.json") ||
                                         readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/sdisgkdc/csd.json");
                            if (rawCsd) {
                                csdCache = JSON.parse(rawCsd);
                                log("[📊 CSD] Loaded csd.json: " + csdCache.length + " card sell entries cached!");
                            }
                        } catch (eCsd) {}
                    }
                }

                function getCardBaseStats(grade, level, isPrism) {
                    loadOfflineCardDataTables();
                    level = Math.max(1, parseInt(level, 10) || 1);
                    grade = parseInt(grade, 10) || 0;
                    var code = (grade < 4) ? (grade * 5 + Math.min(4, level - 1)) : (20 + Math.min(98, level - 1));

                    var score = 100;
                    var energy = 100;
                    if (cbdCache && cbdCache[code]) {
                        var item = cbdCache[code];
                        score = item.minScore + (isPrism ? (item.prizmScore || 10) : 0);
                        energy = item.minEnergy || 100;
                    } else {
                        // Official Dalcomsoft fallback formulas
                        if (grade === 0) { score = 10 + (level - 1) * 3; energy = score; }
                        else if (grade === 1) { score = 25 + (level - 1) * 3; energy = score; }
                        else if (grade === 2) { score = 40 + (level - 1) * 5; energy = score; }
                        else if (grade === 3) { score = 65 + (level - 1) * 7; energy = score; }
                        else if (grade === 4) { score = Math.min(199, 101 + (level - 1) * 2); energy = 100; }
                        if (isPrism) score += 10;
                    }
                    return { score: score, energy: energy };
                }

                function getIntensifyPriceAndRate(targetGrade, targetLevel, matGrade, matLevel) {
                    loadOfflineCardDataTables();
                    targetLevel = Math.max(1, parseInt(targetLevel, 10) || 1);
                    targetGrade = parseInt(targetGrade, 10) || 0;
                    matLevel = Math.max(1, parseInt(matLevel, 10) || 1);
                    matGrade = parseInt(matGrade, 10) || 0;

                    var targetCode = (targetGrade < 4) ? (targetGrade * 5 + Math.min(4, targetLevel - 1)) : (20 + Math.min(98, targetLevel - 1));
                    var gradeLetters = ["C", "B", "A", "S", "R"];
                    var matKey = (gradeLetters[matGrade] || "C") + matLevel;
                    var priceKey = matKey + "Price";

                    var rate = 70.0;
                    var price = 100;

                    if (cidCache && cidCache[targetCode]) {
                        var row = cidCache[targetCode];
                        if (row[matKey] !== undefined && row[matKey] >= 0) rate = row[matKey];
                        if (row[priceKey] !== undefined && row[priceKey] > 0) price = row[priceKey];
                    } else {
                        // Fallback pricing and rate by grade comparison
                        var basePrices = [93, 110, 131, 154, 176];
                        price = (basePrices[targetGrade] || 100) + (targetLevel - 1) * 2;
                        if (matGrade > targetGrade) rate = 100.0;
                        else if (matGrade === targetGrade) rate = 70.0;
                        else rate = Math.max(10.0, 30.0 - (targetGrade - matGrade) * 10.0);
                    }
                    return { rate: rate, price: price };
                }

                function getCardSellPrice(grade) {
                    loadOfflineCardDataTables();
                    var gr = parseInt(grade, 10) || 0;
                    if (csdCache && csdCache[gr] && csdCache[gr].price) {
                        return csdCache[gr].price;
                    }
                    var defaultSellPrices = [200, 400, 600, 800, 1200];
                    return defaultSellPrices[gr] || 200;
                }

                var cddCache = null;
                var urlToCardMap = {};
                function getCardMetadata(cardId) {
                    if (!cddCache) {
                        try {
                            var raw = readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/asiudgasg/sdisgkdc/cdd.json");
                            if (raw) {
                                var arr = JSON.parse(raw);
                                cddCache = {};
                                urlToCardMap = {};
                                for (var i = 0; i < arr.length; i++) {
                                    var item = arr[i];
                                    cddCache[item.code] = item;
                                    if (item.cardImageSmall) {
                                        var sUrl = item.cardImageSmall.split("?")[0];
                                        urlToCardMap[sUrl] = { cId: item.code, type: "s" };
                                    }
                                    if (item.cardImageLarge) {
                                        var lUrl = item.cardImageLarge.split("?")[0];
                                        urlToCardMap[lUrl] = { cId: item.code, type: "l" };
                                    }
                                }
                                log("[📦 CDD] Loaded cdd.json: " + arr.length + " card metadata entries cached, " + Object.keys(urlToCardMap).length + " URLs mapped!");
                            } else {
                                log("[-] readTextFile returned null for cdd.json!");
                            }
                        } catch (e) {
                            log("[-] Error parsing cdd.json: " + e.message);
                        }
                    }
                    if (cddCache && cddCache[cardId]) {
                        return cddCache[cardId];
                    }
                    var mIdx = ((cardId - 1001) % 11) + 1;
                    return {
                        code: cardId,
                        artistID: 1000 + mIdx,
                        theme: 1001,
                        type: 0
                    };
                }

                var artistNamesMap = {
                    1001: "HeeJin",
                    1002: "HyunJin",
                    1003: "HaSeul",
                    1004: "YeoJin",
                    1005: "ViVi",
                    1006: "Kim Lip",
                    1007: "JinSoul",
                    1008: "Choerry",
                    1009: "Yves",
                    1010: "Go Won",
                    1011: "Olivia Hye"
                };

                var themeNamesMap = {
                    1001: "Hi High",
                    1002: "HEAT",
                    1003: "Stylish",
                    1004: "Take me High",
                    1005: "Perfect Love",
                    1006: "favOriTe",
                    1007: "You know you know",
                    1008: "Only you love",
                    1009: "Make you mine"
                };

                var loonaGroupData = NULL;
                var loonaThemeData = NULL;
                var loonaThemeTypeData = NULL;
                var loonaArtistDataMap = {};
                var loonaCardControlDataMap = {};
                var loonaGroupItemObj = NULL;
                var loonaArtistListFastArray = NULL;
                var loonaCardListFastArray = NULL;
                var loonaEachThemeBestCardMap = NULL;
                var loonaCardItems = [];
                var activeInventorySceneInstance = NULL;
                var cachedCardItemKlass = NULL;
                var cachedCardKlass = NULL;
                var cachedLoonaCbGroupItem = NULL;

                var sortLoonaCardItems = function() {
                    try {
                        if (!loonaCardItems || loonaCardItems.length === 0) return;
                        loonaCardItems.sort(function(itemA, itemB) {
                            var rawA = itemA.add(0x10).readPointer();
                            var rawB = itemB.add(0x10).readPointer();
                            var cIdA = rawA.add(0x20).readS32();
                            var cIdB = rawB.add(0x20).readS32();
                            var grA = rawA.add(0x24).readS32();
                            var grB = rawB.add(0x24).readS32();
                            var lvlA = rawA.add(0x1C).readS16();
                            var lvlB = rawB.add(0x1C).readS16();
                            var isPrismA = (rawA.add(0x2A).readU8() === 1);
                            var isPrismB = (rawB.add(0x2A).readU8() === 1);
                            var isEqA = (rawA.add(0x28).readU8() === 1);
                            var isEqB = (rawB.add(0x28).readU8() === 1);

                            // 1. Equipped cards (with checkmark) ALWAYS FIRST
                            if (isEqA !== isEqB) {
                                return isEqA ? -1 : 1;
                            }

                            // 2. Member order (1001..1011)
                            var mA = ((cIdA - 1001) % 11);
                            var mB = ((cIdB - 1001) % 11);
                            if (mA !== mB) return mA - mB;

                            // 3. Higher grade first
                            if (grA !== grB) return grB - grA;

                            // 4. Higher level first
                            if (lvlA !== lvlB) return lvlB - lvlA;

                            // 5. Prism first
                            if (isPrismA !== isPrismB) return isPrismA ? -1 : 1;

                            return cIdA - cIdB;
                        });
                    } catch (eSort) {
                        log("[-] Error sorting loonaCardItems: " + eSort.message);
                    }
                };

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
                }

                function ensureLoonaMocks() {
                    try {
                        syncAccountOwnedCards();
                        if (!loonaGroupData || loonaGroupData.isNull()) {
                            var grpKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "GroupControl/Data");
                            if (grpKlass && !grpKlass.isNull()) {
                                loonaGroupData = il2cpp_object_new(grpKlass);
                                if (il2cpp_gchandle_new && !loonaGroupData.isNull()) il2cpp_gchandle_new(loonaGroupData, 2);
                                loonaGroupData.add(0x18).writePointer(createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes"));
                                loonaGroupData.add(0x28).writePointer(createDownloadPath("asiudgasg/asodhsg/aweoijs/1001.i.bytes"));
                                try {
                                    var gdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "GroupData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "GroupData");
                                    if (gdKlass && !gdKlass.isNull()) {
                                        var gd = il2cpp_object_new(gdKlass);
                                        if (il2cpp_gchandle_new && !gd.isNull()) il2cpp_gchandle_new(gd, 2);
                                        gd.add(0x10).writeS32(1001); // code = 1001
                                        gd.add(0x14).writeS16(1001); // majorGroupCode = 1001
                                        gd.add(0x18).writeS16(11);   // memberCount = 11 (equipableSlot: 11)
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
                                if (il2cpp_gchandle_new && !loonaThemeData.isNull()) il2cpp_gchandle_new(loonaThemeData, 2);
                                loonaThemeData.add(0x30).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes"));
                                loonaThemeData.add(0x38).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                loonaThemeData.add(0x40).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                try {
                                    var tdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "ThemeData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "ThemeData");
                                    if (tdKlass && !tdKlass.isNull()) {
                                        var td = il2cpp_object_new(tdKlass);
                                        if (il2cpp_gchandle_new && !td.isNull()) il2cpp_gchandle_new(td, 2);
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
                                if (il2cpp_gchandle_new && !loonaThemeTypeData.isNull()) il2cpp_gchandle_new(loonaThemeTypeData, 2);
                                try {
                                    var ttdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "ThemeTypeData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "ThemeTypeData");
                                    if (ttdKlass && !ttdKlass.isNull()) {
                                        var ttd = il2cpp_object_new(ttdKlass);
                                        if (il2cpp_gchandle_new && !ttd.isNull()) il2cpp_gchandle_new(ttd, 2);
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
                                    if (il2cpp_gchandle_new && !aObj.isNull()) il2cpp_gchandle_new(aObj, 2);
                                    aObj.add(0x20).writePointer(createIl2CppString("LOONA"));
                                    aObj.add(0x38).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes"));
                                    aObj.add(0x40).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                                    try {
                                        if (adKlass && !adKlass.isNull()) {
                                            var ad = il2cpp_object_new(adKlass);
                                            if (il2cpp_gchandle_new && !ad.isNull()) il2cpp_gchandle_new(ad, 2);
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
                        }
                    } catch (eMocks) {
                        log("[-] Error ensuring LOONA mocks: " + eMocks.message);
                    }
                }

                var loonaThemeDataMap = {};
                function getOrCreateThemeData(themeId) {
                    themeId = parseInt(themeId, 10) || 1001;
                    if (loonaThemeDataMap[themeId]) return loonaThemeDataMap[themeId];
                    try {
                        var thmKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "ThemeControl/Data");
                        if (!thmKlass || thmKlass.isNull()) return loonaThemeData;
                        var tObj = il2cpp_object_new(thmKlass);
                        if (il2cpp_gchandle_new && !tObj.isNull()) il2cpp_gchandle_new(tObj, 2);
                        tObj.add(0x30).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes"));
                        tObj.add(0x38).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                        tObj.add(0x40).writePointer(createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                        var tdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "ThemeData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "ThemeData");
                        if (tdKlass && !tdKlass.isNull()) {
                            var td = il2cpp_object_new(tdKlass);
                            if (il2cpp_gchandle_new && !td.isNull()) il2cpp_gchandle_new(td, 2);
                            td.add(0x10).writeS32(themeId);
                            td.add(0x14).writeS32(10010100 + (themeId % 100)); // localeName
                            td.add(0x18).writePointer(createIl2CppString("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_s.i.bytes"));
                            td.add(0x20).writePointer(createIl2CppString("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                            td.add(0x48).writePointer(createIl2CppString("asiudgasg/asodhsg/sdhgauwehdnu/artistEmpty_l.i.bytes"));
                            tObj.add(0x10).writePointer(td);
                        }
                        loonaThemeDataMap[themeId] = tObj;
                        return tObj;
                    } catch (e) {
                        return loonaThemeData;
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
                        if (il2cpp_gchandle_new && !ccd.isNull()) il2cpp_gchandle_new(ccd, 2);
                        var meta = getCardMetadata(cardId);
                        var memberIdx = (meta.artistID >= 1000) ? (meta.artistID - 1000) : meta.artistID;
                        if (memberIdx < 1 || memberIdx > 11) memberIdx = ((cardId - 1001) % 11) + 1;
                        var themeId = meta.theme || 1001;
                        var isPrism = (meta.type === 1);

                        ccd.add(0x18).writePointer(createIl2CppString("LOONA"));
                        ccd.add(0x20).writeS32(1001);
                        ccd.add(0x28).writePointer(loonaGroupData || NULL);
                        ccd.add(0x30).writePointer(loonaArtistDataMap[memberIdx] || NULL);
                        ccd.add(0x38).writePointer(getOrCreateThemeData(themeId) || loonaThemeData || NULL);
                        ccd.add(0x40).writePointer(loonaThemeTypeData || NULL);
                        ccd.add(0x48).writePointer(NULL);
                        ccd.add(0x50).writeU8(1);
                        ccd.add(0x51).writeU8(1);
                        var cardFolder = "wadceg";
                        ccd.add(0x58).writePointer(createDownloadPath("asiudgasg/asodhsg/" + cardFolder + "/" + cardId + "_s.i.bytes"));
                        ccd.add(0x60).writePointer(createDownloadPath("asiudgasg/asodhsg/" + cardFolder + "/" + cardId + "_l.i.bytes"));
                        try {
                            var cdKlass = getClass("Assembly-CSharp-firstpass", "com.dalcomsoft.project.client.model.asset", "CardData") || getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.asset", "CardData");
                            if (cdKlass && !cdKlass.isNull()) {
                                var cd = il2cpp_object_new(cdKlass);
                                if (il2cpp_gchandle_new && !cd.isNull()) il2cpp_gchandle_new(cd, 2);
                                cd.add(0x10).writeS32(cardId);
                                cd.add(0x14).writeS32(isPrism ? 1 : 0); // type = 1 for prism
                                cd.add(0x20).writePointer(createIl2CppString("asiudgasg/asodhsg/" + cardFolder + "/" + cardId + "_s.i.bytes")); // cardImageSmall
                                cd.add(0x28).writePointer(createIl2CppString("asiudgasg/asodhsg/" + cardFolder + "/" + cardId + "_l.i.bytes")); // cardImageLarge
                                cd.add(0x30).writeS32(themeId); // theme = themeId
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
                            var isPrism = (accountPtr.add(0x2A).readU8() === 1);

                            // Update stats from cbd.json
                            var stats = getCardBaseStats(grade, level, isPrism);
                            accountPtr.add(0x18).writeS16(stats.energy);
                            accountPtr.add(0x1A).writeS16(stats.score);

                            thisPtr.add(0x10).writePointer(accountPtr); // <Raw>k__BackingField
                            var ccd = getOrCreateCardControlData(cardId);
                            thisPtr.add(0x18).writePointer(ccd || NULL); // <Card>k__BackingField
                            var fCode = (grade < 4) ? (grade * 5 + Math.min(4, level - 1)) : (20 + Math.min(98, level - 1));
                            thisPtr.add(0x20).writeS16(fCode); // <IntensifyCode>
                            thisPtr.add(0x24).writeU32(0x3F800000); // <CardGradeBonusValue> = 1.0f
                            thisPtr.add(0x28).writeS32(100); // <SellPrice>
                            thisPtr.add(0x2C).writeU8(0); // isMaterial = false
                            var meta = getCardMetadata(cardId);
                            var memberIdx = (meta.artistID >= 1000) ? (meta.artistID - 1000) : meta.artistID;
                            if (memberIdx < 1 || memberIdx > 11) memberIdx = ((cardId - 1001) % 11) + 1;
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
                        if (code >= 1001 && code <= 1022) {
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
                            var folder = "wadceg";
                            var dp = createDownloadPath("asiudgasg/asodhsg/" + folder + "/" + cId + "_s.i.bytes");
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
                            var folder = "wadceg";
                            var dp = createDownloadPath("asiudgasg/asodhsg/" + folder + "/" + cId + "_l.i.bytes");
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
                            var folder = "wadceg";
                            var dp = createDownloadPath("asiudgasg/asodhsg/" + folder + "/" + cId + "_l.i.bytes");
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

                // Direct byte patch on GoogleSignInControl.Awake (0xB9B304) -> ret
                try {
                    Memory.protect(baseAddr.add(0xB9B304), 4, "rwx");
                    baseAddr.add(0xB9B304).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    log("[+] Byte patch on GoogleSignInControl.Awake (0xB9B304): ret");
                } catch (eGsi) {}

                // Direct byte patches to disable Google Mobile Ads, Tapjoy, Stan's Assets, NotifyControl, and AdMob crashes
                [
                    0xB17894, // TapjoyUnityInit.Awake -> ret
                    0xC108B0, // NotifyControl.Start -> ret
                    0xD45478, // GoogleMobileAdsScript.AddAdUnit -> ret
                    0xD45574, // GoogleMobileAdsScript.SetAdUnitId -> ret
                    0xD45BAC, // GoogleMobileAdsScript.InitADX -> ret
                    0x12FE444, // SA.Android.Utilities.AN_Logger.Init -> ret
                    0x12FE4B0, // SA.Android.Utilities.AN_Logger.InitNativeLogger -> ret
                    0x1303434, // SA.Android.App.AN_PermissionsUtility.Init -> ret
                    0x11E7508, // SA.CrossPlatform.App.UM_Application.Init -> ret
                    0x11F4218  // SA.iOS.UIKit.ISN_UIApplication.Init -> ret
                ].forEach(function(rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 4, "rwx");
                        baseAddr.add(rva).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    } catch (eGma) {}
                });
                log("[+] Byte patches on Tapjoy, NotifyControl, AdMob & Stan's Assets applied: ret");

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

                function createMockSmallCardParams(cardId, grade, level, isEquip) {
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
                        p.add(0x30).writePointer(NULL);
                        p.add(0x38).writeU8(0);
                        p.add(0x3C).writeS32(grade);
                        p.add(0x40).writeU8(grade === 4 ? 1 : 0);
                        p.add(0x41).writeU8(0);
                        p.add(0x44).writeS32(maxLvl);
                        p.add(0x48).writeS32(safeLvl);
                        p.add(0x4C).writeU8(0);
                        p.add(0x4E).writeS16(0);
                        p.add(0x50).writeU8(isEquip ? 1 : 0); // isEquip dynamic (controls blue checkmark)
                        p.add(0x51).writeU8(0);
                        p.add(0x52).writeU8(0);
                        p.add(0x53).writeU8(0);
                        p.add(0x54).writeU8(0); // isLeader = 0
                        p.add(0x55).writeU8(0);
                        p.add(0x56).writeU8(0);
                        p.add(0x57).writeU8(0);
                        return p;
                    } catch (eMscp) {
                        log("[-] Error in createMockSmallCardParams: " + eMscp.message);
                        return NULL;
                    }
                }

                function createMockEmptySmallCardParams(cardId) {
                    try {
                        var baseItem = NULL;
                        if (loonaCardItems && loonaCardItems.length > 0) baseItem = loonaCardItems[0];
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

                        var photoDp = createDownloadPath("asiudgasg/asodhsg/sdhgauwehdnu/" + cardId + "_l.i.bytes");

                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(NULL); // tierPath = null
                        p.add(0x20).writeU8(0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(NULL);
                        p.add(0x38).writeU8(0);
                        p.add(0x3C).writeS32(5); // tier = 5 (None)
                        p.add(0x40).writeU8(0); // isRCard = false
                        p.add(0x41).writeU8(0);
                        p.add(0x44).writeS32(0); // maxLevel = 0
                        p.add(0x48).writeS32(0); // level = 0
                        p.add(0x4C).writeU8(0);
                        p.add(0x4E).writeS16(0);
                        p.add(0x50).writeU8(0); // isEquip = false
                        p.add(0x51).writeU8(0);
                        p.add(0x52).writeU8(0);
                        p.add(0x53).writeU8(0);
                        p.add(0x54).writeU8(0);
                        p.add(0x55).writeU8(0);
                        p.add(0x56).writeU8(0);
                        p.add(0x57).writeU8(0);
                        return p;
                    } catch (eMesp) {
                        log("[-] Error in createMockEmptySmallCardParams: " + eMesp.message);
                        return NULL;
                    }
                }

                function createMockLargeCardParams(cardId, grade, level, isPrism) {
                    try {
                        var clvParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "CardLargeView/Params");
                        if (!clvParamsKlass || clvParamsKlass.isNull()) {
                            clvParamsKlass = getClass("Assembly-CSharp", "", "CardLargeView.Params");
                        }
                        if (!clvParamsKlass || clvParamsKlass.isNull()) return NULL;
                        var p = il2cpp_object_new(clvParamsKlass);
                        if (!p || p.isNull()) return NULL;

                        try {
                            var ctorFn = new NativeFunction(baseAddr.add(0xE46AEC), "void", ["pointer", "pointer"]);
                            ctorFn(p, NULL);
                        } catch (eCt) {}

                        var cFolder = "wadceg";
                        var photoDp = createDownloadPath("asiudgasg/asodhsg/" + cFolder + "/" + cardId + "_l.i.bytes");
                        var tierDp = getGradeFrameDownloadPath(grade, 0);

                        p.add(0x10).writePointer(photoDp || NULL);
                        p.add(0x18).writePointer(tierDp || NULL);
                        p.add(0x20).writeU8(isPrism ? 1 : 0);
                        p.add(0x28).writePointer(NULL);
                        p.add(0x30).writePointer(NULL);
                        p.add(0x38).writeU8(0);
                        p.add(0x3C).writeS32(grade);
                        p.add(0x40).writeU8(grade === 4 ? 1 : 0);
                        p.add(0x41).writeU8(0);
                        p.add(0x44).writeS32(grade === 4 ? 50 : 5);
                        p.add(0x48).writeS32(level);
                        p.add(0x4C).writeU8(0);
                        p.add(0x4E).writeS16(0);
                        p.add(0x50).writePointer(NULL); // emblemPath
                        p.add(0x58).writePointer(NULL); // themePath
                        p.add(0x60).writePointer(NULL); // artistPath
                        p.add(0x68).writePointer(NULL); // backgroundPath
                        p.add(0x70).writePointer(NULL); // backgroundAnimPathList
                        p.add(0x78).writeDouble(0.0);   // backgroundAnimTime
                        p.add(0x80).writeFloat(0.0);    // emblemPosition.x
                        p.add(0x84).writeFloat(0.0);    // emblemPosition.y
                        p.add(0x88).writeFloat(0.0);    // namePosition.x
                        p.add(0x8C).writeFloat(0.0);    // namePosition.y
                        p.add(0x90).writeFloat(0.0);    // themePosition.x
                        p.add(0x94).writeFloat(0.0);    // themePosition.y
                        p.add(0x98).writeU8(0);         // isGray
                        return p;
                    } catch (eMlcp) {
                        log("[-] Error in createMockLargeCardParams: " + eMlcp.message);
                        return NULL;
                    }
                }

                function createMockCardStatInfoParams(grade, level, isPrism) {
                    try {
                        var statKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "CardStatInfoView/Params");
                        if (!statKlass || statKlass.isNull()) {
                            statKlass = getClass("Assembly-CSharp", "", "CardStatInfoView.Params");
                        }
                        if (!statKlass || statKlass.isNull()) return NULL;
                        var p = il2cpp_object_new(statKlass);
                        if (!p || p.isNull()) return NULL;
                        try {
                            var ctorFn = new NativeFunction(baseAddr.add(0xE4A080), "void", ["pointer", "pointer"]);
                            ctorFn(p, NULL);
                        } catch (eCt) {}

                        var stats = getCardBaseStats(grade, level, isPrism);
                        p.add(0x10).writeU8(grade === 4 ? 1 : 0);
                        p.add(0x14).writeS32(stats.score);
                        p.add(0x18).writeS32(stats.energy);
                        p.add(0x1C).writeS32(999);
                        p.add(0x20).writeS32(999);
                        p.add(0x24).writeFloat(stats.score / 999.0);
                        p.add(0x28).writeS32(0);
                        return p;
                    } catch (eSt) {
                        log("[-] Error creating CardStatInfoView.Params: " + eSt.message);
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
                            var isEq = false;
                            try {
                                if (cardItem && !cardItem.isNull()) {
                                    var raw = cardItem.add(0x10).readPointer();
                                    if (!raw.isNull()) {
                                        var objIdStr = raw.add(0x10).readU64().toString();
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
                            return createMockSmallCardParams(cId, gr, lvl, isEq);
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
                            var isPrism = false;
                            try {
                                if (cardItem && !cardItem.isNull()) {
                                    var raw = cardItem.add(0x10).readPointer();
                                    if (!raw.isNull()) {
                                        cId = raw.add(0x20).readS32();
                                        gr = raw.add(0x24).readS32();
                                        lvl = raw.add(0x1C).readS16();
                                        isPrism = (raw.add(0x2A).readU8() === 1);
                                    }
                                }
                            } catch (e) {}
                            return createMockLargeCardParams(cId, gr, lvl, isPrism);
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
                                var paramsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "InvenGroupItemView/Params");
                                if (paramsKlass && !paramsKlass.isNull()) {
                                    p = il2cpp_object_new(paramsKlass);
                                }
                            }
                            if (!p || p.isNull()) {
                                log("[-] Failed to get InvenGroupItemView.Params object!");
                                return NULL;
                            }

                            // Populate fields safely
                            p.add(0x10).writePointer(createIl2CppString("LOONA"));
                            p.add(0x18).writeS32(11); // memberCount = 11
                            p.add(0x1C).writeS32(0);  // summaryCount
                            p.add(0x20).writePointer(NULL); // exposeArtistIndexList
                            p.add(0x30).writePointer(NULL); // summary

                            // Build cardParams: List<CardSmallView.Params> with 11 cards (one per LOONA member)
                            // Uses profile equip state so the lower bar reflects who is equipped
                            try {
                                var profile = loadPlayerProfile();
                                var cardSmallParamsList = [];
                                for (var mi = 0; mi < 11; mi++) {
                                    // Find best equipped card for this member, fallback to best unequipped
                                    var memberCards = (profile && profile.inventoryCards) ?
                                        profile.inventoryCards.filter(function(c) { return ((c.cardID - 1001) % 11) === mi; }) : [];
                                    var eqCard = memberCards.find(function(c) { return c.isEquip; });
                                    var bestCard = eqCard || (memberCards.length > 0 ? memberCards[0] : null);
                                    var cIdMi = bestCard ? bestCard.cardID : (1001 + mi);
                                    var grMi = bestCard ? (bestCard.grade !== undefined ? bestCard.grade : 4) : 4;
                                    var lvlMi = bestCard ? (bestCard.level || 50) : 50;
                                    var isEqMi = bestCard ? !!bestCard.isEquip : false;
                                    var smallParam = createMockSmallCardParams(cIdMi, grMi, lvlMi, isEqMi);
                                    cardSmallParamsList.push(smallParam || NULL);
                                }
                                // Build native List<CardSmallView.Params>
                                var listKlass = getClass("Assembly-CSharp", "System.Collections.Generic", "List`1");
                                var listParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "CardSmallView/Params");
                                // Use il2cpp_runtime_invoke on List.ctor + Add
                                var cpListKlass = il2cpp_object_new ? getClass("mscorlib", "System.Collections.Generic", "List`1") : null;
                                // Simple approach: write as managed array pointer
                                // Build a List<T> by allocating it and calling Add via vtable
                                var smallCardParamListObj = NULL;
                                try {
                                    // Find List<CardSmallView.Params> TypeInfo via slot
                                    var listTypeInfo = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "InvenGroupItemView");
                                    if (listTypeInfo && !listTypeInfo.isNull()) {
                                        // Try direct il2cpp_object_new for a generic list klass via metadata
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
                                        log("[✅ GROUP_VIEW] Built cardParams List<CardSmallView.Params> with " + cardSmallParamsList.length + " items");
                                    }
                                } catch (eCpl) {
                                    log("[-] Error building cardParams list: " + eCpl.message);
                                }
                                p.add(0x28).writePointer(NULL); // Keep NULL to prevent Unity GC SIGSEGV at 0x9f8de0
                            } catch (eCpb) {
                                log("[-] Error in cardParams population: " + eCpb.message);
                                p.add(0x28).writePointer(NULL);
                            }

                            // Texts & values calculated dynamically from profile (reuse profile loaded above)

                            var eqCards = (profile && profile.inventoryCards) ? profile.inventoryCards.filter(function(c) { return c.isEquip; }) : [];
                            var eqCount = 0;
                            var minGrade = 4;
                            var isAllHiHigh = true;
                            var memberEquipped = {};
                            for (var ei = 0; ei < eqCards.length; ei++) {
                                var ec = eqCards[ei];
                                var em = ((ec.cardID - 1001) % 11);
                                if (!memberEquipped[em]) {
                                    memberEquipped[em] = true;
                                    eqCount++;
                                    if (ec.grade < minGrade) minGrade = ec.grade;
                                    if (ec.themeID && ec.themeID !== 1001) isAllHiHigh = false;
                                }
                            }

                            var gVal = (eqCount === 11) ? minGrade : -1;
                            var gScore = 0;
                            if (gVal === 4) gScore = 500000;
                            else if (gVal === 3) gScore = 400000;
                            else if (gVal === 2) gScore = 300000;
                            else if (gVal === 1) gScore = 200000;
                            else if (gVal === 0) gScore = 100000;

                            var tLevel = (eqCount === 11 && isAllHiHigh) ? 3 : 0;

                            p.add(0x38).writePointer(createIl2CppString("Group Grade"));
                            p.add(0x40).writePointer(createIl2CppString("Collect All Cards"));
                            p.add(0x48).writeS32(gVal);
                            p.add(0x4C).writeS32(gScore);
                            p.add(0x50).writePointer(createIl2CppString("Group Theme"));
                            p.add(0x58).writePointer(createIl2CppString("No Theme"));
                            p.add(0x60).writeS32(tLevel);
                            var themeDp = createDownloadPath("asiudgasg/asodhsg/aweoijs/2.i.bytes");
                            p.add(0x68).writePointer(themeDp || NULL);
                            p.add(0x70).writePointer(createIl2CppString("ULTRA RAVE"));
                            p.add(0x78).writePointer(createIl2CppString("Auto Equip"));
                            p.add(0x80).writePointer(NULL); // LOONA has no sub-groups!
                            p.add(0x88).writePointer(createIl2CppString("Unequip All"));
                            p.add(0x90).writePointer(createIl2CppString("Equip Theme"));
                            p.add(0x98).writePointer(createIl2CppString("Music"));

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

                // 9. InvenGroupItemView.Refresh (0xF23954) -> Native-integrated replacement
                try {
                    Interceptor.replace(baseAddr.add(0xF23954), new NativeCallback(function (view, p, methodInfo) {
                        try {
                            log("[🃏 GROUP_ITEM_VIEW] Native-integrated Refresh called! view: " + view + ", p: " + p);
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
                                    var setTierVis = new NativeFunction(baseAddr.add(0x1393AAC), "void", ["pointer", "int"]);
                                    var setStarVis = new NativeFunction(baseAddr.add(0x1388C58), "void", ["pointer", "int"]);
                                    var setNumVis = new NativeFunction(baseAddr.add(0x1393D68), "void", ["pointer", "int"]);
                                    var getGameObjectFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                    var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);
                                    var profile = loadPlayerProfile();
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
                                            var targetCard = eqCards.find(function(c) { return ((c.cardID - 1001) % 11) === mIdx; });
                                            if (targetCard) {
                                                // Slot IS EQUIPPED with active card
                                                var cId = targetCard.cardID;
                                                var gr = targetCard.grade;
                                                var lvl = targetCard.level;
                                                var cardParam = createMockSmallCardParams(cId, gr, lvl, false);
                                                if (cardParam && !cardParam.isNull()) {
                                                    cardRefreshFn(cardSmallView, cardParam, NULL);
                                                }
                                                try {
                                                    setTierVis(cardSmallView, 1);
                                                    if (gr === 4) {
                                                        setStarVis(cardSmallView, 0);
                                                        setNumVis(cardSmallView, 1);
                                                    } else {
                                                        setStarVis(cardSmallView, 1);
                                                        setNumVis(cardSmallView, 0);
                                                    }
                                                } catch (eVisEq) {}

                                                // Deactivate ImageEfftect (horizontal gray line artifact)
                                                try {
                                                    var imgEff = cardSmallView.add(0xC8).readPointer();
                                                    if (!imgEff.isNull()) {
                                                        var effGo = getGameObjectFn(imgEff, NULL);
                                                        if (!effGo.isNull()) setActiveFn(effGo, 0, NULL);
                                                    }
                                                } catch (eEff) {}

                                                // Direct texture injection strictly from wadceg (unity garage pinned)
                                                try {
                                                    var photoRawImg = cardSmallView.add(0x58).readPointer();
                                                    if (!photoRawImg.isNull()) {
                                                        var photoTex = loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_l.i.bytes") ||
                                                                       loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_s.i.bytes");
                                                        if (photoTex && !photoTex.isNull()) {
                                                            var setTextureFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                                            setTextureFn(photoRawImg, photoTex, NULL);
                                                            var setEnabledFn = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                                                            setEnabledFn(photoRawImg, 1, NULL);
                                                            var pGo = getGameObjectFn(photoRawImg, NULL);
                                                            if (!pGo.isNull()) setActiveFn(pGo, 1, NULL);

                                                            // Calibrate photo dimensions to BasicSize (92, 130)
                                                            try {
                                                                var getRectTrFn = new NativeFunction(baseAddr.add(0x1614EF0), "pointer", ["pointer", "pointer"]);
                                                                var setSizeDeltaFn = new NativeFunction(baseAddr.add(0x180DC18), "void", ["pointer", "float", "float", "pointer"]);
                                                                var photoRectTr = getRectTrFn(photoRawImg, NULL);
                                                                if (!photoRectTr.isNull()) {
                                                                    setSizeDeltaFn(photoRectTr, 92.0, 130.0, NULL);
                                                                }
                                                            } catch (ePsz) {}
                                                        }
                                                    }

                                                    var tierRawImg = cardSmallView.add(0x68).readPointer();
                                                    if (!tierRawImg.isNull()) {
                                                        var gLetter = (gr === 4) ? "r" : (gr === 3) ? "s" : (gr === 2) ? "a" : (gr === 1) ? "b" : "c";
                                                        var tierTex = loadLocalTexture2D("asiudgasg/asodhsg/aoeiwhslc/uhex/0_" + gLetter + "_s.i.bytes");
                                                        if (tierTex && !tierTex.isNull()) {
                                                            var setTextureFn2 = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                                            setTextureFn2(tierRawImg, tierTex, NULL);
                                                            var setEnabledFn2 = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                                                            setEnabledFn2(tierRawImg, 1, NULL);
                                                            var tGo = getGameObjectFn(tierRawImg, NULL);
                                                            if (!tGo.isNull()) setActiveFn(tGo, 1, NULL);

                                                            // RawImage.SetNativeSize (0x194C1C8) to ensure 116x156 native dimensions
                                                            try {
                                                                var setNativeSizeFn = new NativeFunction(baseAddr.add(0x194C1C8), "void", ["pointer", "pointer"]);
                                                                setNativeSizeFn(tierRawImg, NULL);
                                                            } catch (eSns) {}
                                                        }
                                                    }
                                                } catch (ePhotoInj) {}
                                            } else {
                                                // Slot IS UNEQUIPPED: show empty placeholder from sdhgauwehdnu
                                                var emptyCardId = 1001 + mIdx;
                                                var emptyParam = createMockEmptySmallCardParams(emptyCardId);
                                                if (emptyParam && !emptyParam.isNull()) {
                                                    cardRefreshFn(cardSmallView, emptyParam, NULL);
                                                }
                                                try {
                                                    setTierVis(cardSmallView, 0);
                                                    setStarVis(cardSmallView, 0);
                                                    setNumVis(cardSmallView, 0);
                                                } catch (eVisEmpty) {}
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

                            // 4. Update button texts
                            try {
                                var autoEqTxt = view.add(0xE0).readPointer();
                                if (!autoEqTxt.isNull() && !p.add(0x78).readPointer().isNull()) {
                                    var tVTable = autoEqTxt.readPointer();
                                    var setTxt = new NativeFunction(tVTable.add(0x5E8).readPointer(), "void", ["pointer", "pointer", "pointer"]);
                                    setTxt(autoEqTxt, p.add(0x78).readPointer(), tVTable.add(0x5F0).readPointer());
                                }
                                var allUneqTxt = view.add(0xF0).readPointer();
                                if (!allUneqTxt.isNull() && !p.add(0x88).readPointer().isNull()) {
                                    var tVTable = allUneqTxt.readPointer();
                                    var setTxt = new NativeFunction(tVTable.add(0x5E8).readPointer(), "void", ["pointer", "pointer", "pointer"]);
                                    setTxt(allUneqTxt, p.add(0x88).readPointer(), tVTable.add(0x5F0).readPointer());
                                }
                                var themeEqTxt = view.add(0xF8).readPointer();
                                if (!themeEqTxt.isNull() && !p.add(0x90).readPointer().isNull()) {
                                    var tVTable = themeEqTxt.readPointer();
                                    var setTxt = new NativeFunction(tVTable.add(0x5E8).readPointer(), "void", ["pointer", "pointer", "pointer"]);
                                    setTxt(themeEqTxt, p.add(0x90).readPointer(), tVTable.add(0x5F0).readPointer());
                                }
                            } catch (eBt) {}

                            // 5. Call native UpdateGrade(view, p) (0xF246B4)
                            try {
                                var gradeSprites = view.add(0x80).readPointer();
                                var gradeImg = view.add(0x88).readPointer();
                                if (!gradeSprites.isNull() && !gradeImg.isNull()) {
                                    var updateGradeFn = new NativeFunction(baseAddr.add(0xF246B4), "void", ["pointer", "pointer"]);
                                    updateGradeFn(view, p);
                                    log("[✅ GROUP_ITEM_VIEW] Native UpdateGrade executed successfully!");
                                } else {
                                    log("[-] Skipping UpdateGrade: gradeSprites/gradeImg not yet initialized");
                                }
                            } catch (eUg) {
                                log("[-] Error executing native UpdateGrade: " + eUg.message);
                            }

                            // 6. Call native UpdateTheme(view, p) (0xF248E8)
                            try {
                                var themeRaw = view.add(0xC0).readPointer();
                                if (!themeRaw.isNull()) {
                                    var updateThemeFn = new NativeFunction(baseAddr.add(0xF248E8), "void", ["pointer", "pointer"]);
                                    updateThemeFn(view, p);
                                    log("[✅ GROUP_ITEM_VIEW] Native UpdateTheme executed successfully!");
                                } else {
                                    log("[-] Skipping UpdateTheme: themeRaw not yet initialized");
                                }
                            } catch (eUt) {
                                log("[-] Error executing native UpdateTheme: " + eUt.message);
                            }

                            // 7. Clear & hide summary texts for LOONA OT12 (removes "Summary Summary Summary")
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

                            log("[✅ GROUP_ITEM_VIEW] Native-integrated Refresh completed successfully!");
                        } catch (eGiv) {
                            log("[-] Error in InvenGroupItemView.Refresh replacement: " + eGiv.message);
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InvenGroupItemView.Refresh (0xF23954)!");
                } catch (eSdh) {
                    log("[-] Error replacing Refresh: " + eSdh.message);
                }

                // 9a. ThemeControl.Data.get_Name (0xC89990) -> Returns authentic Theme Name
                try {
                    var themeGetNameAddr = baseAddr.add(0xC89990);
                    Interceptor.replace(themeGetNameAddr, new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (!thisPtr.isNull()) {
                                var tdPtr = thisPtr.add(0x10).readPointer();
                                if (!tdPtr.isNull()) {
                                    var tCode = tdPtr.add(0x10).readS32();
                                    if (themeNamesMap[tCode]) {
                                        return createIl2CppString(themeNamesMap[tCode]);
                                    }
                                }
                            }
                        } catch (eTn) {}
                        return createIl2CppString("Hi High");
                    }, "pointer", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ThemeControl.Data.get_Name (0xC89990)!");
                } catch (eTgn) {
                    log("[-] Error replacing ThemeControl.Data.get_Name: " + eTgn.message);
                }

                // 9b. InventoryScene.GetMainViewData (0x105751C) -> Bulletproof replacement
                try {
                    var getMainViewDataAddr = baseAddr.add(0x105751C);
                    var invenCardMainParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "InvenCardMainView/Params");
                    Interceptor.replace(getMainViewDataAddr, new NativeCallback(function (sceneThis, cardItem, isEvent, methodInfo) {
                        try {
                            if (!invenCardMainParamsKlass || invenCardMainParamsKlass.isNull()) return NULL;
                            var p = il2cpp_object_new(invenCardMainParamsKlass);
                            if (!p || p.isNull()) return NULL;

                            var isR = false;
                            var isMax = false;
                            var isEq = false;

                            if (cardItem && !cardItem.isNull()) {
                                var raw = cardItem.add(0x10).readPointer();
                                if (!raw.isNull()) {
                                    var gr = raw.add(0x24).readS32();
                                    var lvl = raw.add(0x1C).readS16();
                                    isR = (gr === 4);
                                    isMax = (isR && lvl >= 50) || (!isR && lvl >= 5);
                                    isEq = (raw.add(0x28).readU8() === 1);
                                }
                            }

                            p.add(0x10).writeU8(isR ? 1 : 0);
                            p.add(0x11).writeU8(isMax ? 1 : 0);
                            p.add(0x12).writeU8(isEq ? 1 : 0);
                            p.add(0x18).writePointer(createIl2CppString("MAX"));
                            p.add(0x20).writePointer(createIl2CppString("Level Up"));
                            p.add(0x28).writePointer(createIl2CppString("Level Up"));
                            p.add(0x30).writePointer(createIl2CppString("Power Up"));

                            // Read ratingupSprite / powerupSprite from sceneView.btnBoxSprites if available
                            try {
                                if (!sceneThis.isNull()) {
                                    var sv = sceneThis.add(0x48).readPointer();
                                    if (!sv.isNull()) {
                                        var bbs = sv.add(0xC0).readPointer();
                                        if (!bbs.isNull()) {
                                            var getSpriteFn = new NativeFunction(baseAddr.add(0xD0CAB8), "pointer", ["pointer", "int", "pointer"]);
                                            p.add(0x38).writePointer(getSpriteFn(bbs, 1, NULL)); // ratingupSprite
                                            p.add(0x40).writePointer(getSpriteFn(bbs, 0, NULL)); // powerupSprite
                                        }
                                    }
                                }
                            } catch (eBbs) {}

                            p.add(0x48).writePointer(createIl2CppString("Exchange"));
                            p.add(0x50).writePointer(createIl2CppString("Information"));
                            p.add(0x58).writePointer(createIl2CppString("Equip"));
                            p.add(0x60).writePointer(createIl2CppString("Unequip"));
                            p.add(0x68).writeS32(0); // exchangeCount
                            p.add(0x6C).writeU8(isEvent ? 1 : 0); // isEvent

                            return p;
                        } catch (eGmvR) {
                            log("[-] Error in safe GetMainViewData replacement: " + eGmvR.message);
                            return NULL;
                        }
                    }, "pointer", ["pointer", "pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.GetMainViewData (0x105751C)!");
                } catch (eRepGmv) {
                    log("[-] Error replacing GetMainViewData: " + eRepGmv.message);
                }

                // 9b2. InvenCardMainView.Refresh (0xF227B4) -> Bulletproof replacement to prevent any NullReferenceException
                function safeRefreshInvenCardMainView(viewThis, p) {
                    try {
                        if (viewThis.isNull()) return;

                        var btnExchange = viewThis.add(0x38).readPointer();
                        var btnInfo = viewThis.add(0x40).readPointer();
                        var btnChange = viewThis.add(0x48).readPointer();
                        var btnIntensify = viewThis.add(0x50).readPointer();
                        var btnIntensifyEvent = viewThis.add(0x58).readPointer();
                        var numberExchange = viewThis.add(0x60).readPointer();

                        var setBtnTextFn = new NativeFunction(baseAddr.add(0xE9B7B0), "void", ["pointer", "pointer", "pointer"]);

                        // 1. btnInfo (0x40) -> "Information"
                        if (!btnInfo.isNull()) {
                            try {
                                setBtnTextFn(btnInfo, createIl2CppString("Information"), NULL);
                            } catch (eBi) {}
                        }

                        // 2. btnChange (0x48) -> "Equip" or "Unequip"
                        var isEq = false;
                        try {
                            if (p && !p.isNull()) isEq = (p.add(0x12).readU8() === 1);
                        } catch (eIe) {}
                        if (!btnChange.isNull()) {
                            try {
                                setBtnTextFn(btnChange, createIl2CppString(isEq ? "Unequip" : "Equip"), NULL);
                            } catch (eBc) {}
                        }

                        // 3. btnIntensify (0x50) -> "Level Up" or "MAX"
                        var isMax = false;
                        try {
                            if (p && !p.isNull()) isMax = (p.add(0x11).readU8() === 1);
                        } catch (eIm) {}
                        var btnIntensifyStr = isMax ? "MAX" : "Level Up";
                        if (!btnIntensify.isNull()) {
                            try {
                                var biGo = btnIntensify.add(0x10).readPointer();
                                if (!biGo.isNull()) setActiveFn(biGo, 1, NULL);
                                setBtnTextFn(btnIntensify, createIl2CppString(btnIntensifyStr), NULL);
                            } catch (eBi) {}
                        }

                        // 4. btnIntensifyEvent (0x58) -> Deactivate if present
                        if (!btnIntensifyEvent.isNull()) {
                            try {
                                var bieGo = getGoFn(btnIntensifyEvent, NULL);
                                if (!bieGo.isNull()) setActiveFn(bieGo, 0, NULL);
                            } catch (eBie) {}
                        }

                        // 5. btnExchange (0x38) -> "Exchange"
                        if (!btnExchange.isNull()) {
                            try {
                                setBtnTextFn(btnExchange, createIl2CppString("Exchange"), NULL);
                            } catch (eBe) {}
                        }

                        log("[✅ MAIN_VIEW] InvenCardMainView.Refresh safely completed with English labels!");
                    } catch (eMvr) {
                        log("[-] Error in safe InvenCardMainView.Refresh: " + eMvr.message);
                    }
                }

                try {
                    var invenCardMainViewRefreshAddr = baseAddr.add(0xF227B4);
                    Interceptor.replace(invenCardMainViewRefreshAddr, new NativeCallback(function (viewThis, p, methodInfo) {
                        safeRefreshInvenCardMainView(viewThis, p);
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InvenCardMainView.Refresh (0xF227B4)!");
                } catch (eHicmr) {
                    log("[-] Error replacing InvenCardMainView.Refresh: " + eHicmr.message);
                }

                // 9c. InventoryScene.GetSelectViewData (0x10572AC) -> Bulletproof replacement with full ABI signature
                function safeGetSelectViewData(sceneThis, cardItem, artistData, otherCardItem, isSell) {
                    try {
                        log("[🔍 GSVD] safeGetSelectViewData entered");
                        var selectParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "InvenCardSelectView/Params");
                        if (!selectParamsKlass || selectParamsKlass.isNull()) {
                            selectParamsKlass = getClass("Assembly-CSharp", "", "InvenCardSelectView.Params");
                        }
                        log("[🔍 GSVD] Step 1: selectParamsKlass=" + selectParamsKlass);
                        var p = NULL;
                        if (selectParamsKlass && !selectParamsKlass.isNull()) {
                            try {
                                p = il2cpp_object_new(selectParamsKlass);
                            } catch (eNew) {
                                log("[-] Error in il2cpp_object_new(selectParamsKlass): " + eNew.message);
                            }
                        }
                        if (!p || p.isNull()) {
                            log("[🔍 GSVD] Fallback: allocating 0x60 native buffer for InvenCardSelectView.Params");
                            p = Memory.alloc(0x60);
                        }
                        log("[🔍 GSVD] Step 2: p=" + p);

                        try {
                            var ctorFn = new NativeFunction(baseAddr.add(0xB531B0), "void", ["pointer", "pointer"]);
                            ctorFn(p, NULL);
                        } catch (eCt) {}

                        var cId = 1001;
                        var gr = 4;
                        var lvl = 50;
                        var isPrism = false;
                        var isEq = false;
                        var isLk = false;

                        if (cardItem && !cardItem.isNull()) {
                            try {
                                var raw = cardItem.add(0x10).readPointer();
                                if (!raw.isNull()) {
                                    cId = raw.add(0x20).readS32();
                                    gr = raw.add(0x24).readS32();
                                    lvl = raw.add(0x1C).readS16();
                                    isEq = (raw.add(0x28).readU8() === 1);
                                    isLk = (raw.add(0x29).readU8() === 1);
                                    isPrism = (raw.add(0x2A).readU8() === 1);
                                }
                            } catch (eRci) {}
                        }

                        var meta = getCardMetadata(cId);
                        var aId = (meta && meta.artistID) ? meta.artistID : 1001;
                        var tId = (meta && meta.theme) ? meta.theme : 1001;

                        var aName = artistNamesMap[aId] || "HeeJin";
                        var tName = themeNamesMap[tId] || "Hi High";

                        // Large card params
                        log("[🔍 GSVD] Step 3: createMockLargeCardParams for cId=" + cId);
                        var cardParams = createMockLargeCardParams(cId, gr, lvl, isPrism);
                        log("[🔍 GSVD] Step 4: cardParams=" + cardParams);
                        p.add(0x10).writePointer(cardParams || NULL);
                        p.add(0x18).writePointer(createIl2CppString("LOONA"));
                        p.add(0x20).writePointer(createIl2CppString(aName));

                        // Stat params
                        log("[🔍 GSVD] Step 5: createMockCardStatInfoParams");
                        var statParams = createMockCardStatInfoParams(gr, lvl, isPrism);
                        log("[🔍 GSVD] Step 6: statParams=" + statParams);
                        p.add(0x28).writePointer(statParams || NULL);

                        p.add(0x30).writeS32(0); // deltaScore
                        p.add(0x34).writeS32(0); // deltaEnergy
                        p.add(0x38).writePointer(createIl2CppString("Theme"));
                        p.add(0x40).writePointer(createIl2CppString(tName));

                        // Theme params: write NULL safely
                        p.add(0x48).writePointer(NULL);

                        p.add(0x50).writeU8(isEq ? 1 : 0);
                        p.add(0x51).writeU8(isSell ? 1 : 0);
                        p.add(0x52).writeU8(0); // isLeader
                        p.add(0x53).writeU8(isLk ? 1 : 0);

                        log("[✅ GET_SELECT_DATA] Created InvenCardSelectView.Params: cId=" + cId + ", artist=" + aName + ", theme=" + tName);
                        return p;
                    } catch (eGsvR) {
                        log("[-] Error in safe GetSelectViewData replacement: " + eGsvR.message);
                        return NULL;
                    }
                }

                try {
                    var getSelectViewDataAddr = baseAddr.add(0x10572AC);
                    Interceptor.replace(getSelectViewDataAddr, new NativeCallback(function (sceneThis, cardItem, artistData, otherCardItem, isSell, methodInfo) {
                        return safeGetSelectViewData(sceneThis, cardItem, artistData, otherCardItem, isSell);
                    }, "pointer", ["pointer", "pointer", "pointer", "pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.GetSelectViewData (0x10572AC)!");
                } catch (eRepGsv) {
                    log("[-] Error replacing GetSelectViewData: " + eRepGsv.message);
                }

                // 9c2. InvenCardSelectView.Refresh (0xF22C34) -> Bulletproof replacement to prevent any NullReferenceException
                function safeRefreshInvenCardSelectView(viewThis, p) {
                    try {
                        if (viewThis.isNull()) return;

                        var cardParams = (p && !p.isNull()) ? p.add(0x10).readPointer() : NULL;
                        var groupNameStr = (p && !p.isNull()) ? p.add(0x18).readPointer() : NULL;
                        var artistNameStr = (p && !p.isNull()) ? p.add(0x20).readPointer() : NULL;
                        var statParams = (p && !p.isNull()) ? p.add(0x28).readPointer() : NULL;
                        var themeHeaderStr = (p && !p.isNull()) ? p.add(0x38).readPointer() : NULL;
                        var themeNameStr = (p && !p.isNull()) ? p.add(0x40).readPointer() : NULL;
                        var themeParams = (p && !p.isNull()) ? p.add(0x48).readPointer() : NULL;
                        var isEq = (p && !p.isNull()) ? (p.add(0x50).readU8() === 1) : false;
                        var isSell = (p && !p.isNull()) ? (p.add(0x51).readU8() === 1) : false;
                        var isLeader = (p && !p.isNull()) ? (p.add(0x52).readU8() === 1) : false;
                        var isLk = (p && !p.isNull()) ? (p.add(0x53).readU8() === 1) : false;

                        var cId = 1001;
                        var gr = 4;
                        var lvl = 50;
                        var isPrism = false;
                        if (!cardParams.isNull()) {
                            try {
                                var photoDp = cardParams.add(0x10).readPointer();
                                if (!photoDp.isNull()) {
                                    var fpPtr = photoDp.add(0x18).readPointer();
                                    if (!fpPtr.isNull()) {
                                        var pLen = fpPtr.add(0x10).readS32();
                                        if (pLen > 0) {
                                            var pStr = fpPtr.add(0x14).readUtf16String(pLen);
                                            var m = pStr.match(/(\d+)_l\.i\.bytes/);
                                            if (m) cId = parseInt(m[1], 10);
                                        }
                                    }
                                }
                            } catch (eCid) {}
                            gr = cardParams.add(0x3C).readS32();
                            lvl = cardParams.add(0x48).readS32();
                            isPrism = (cardParams.add(0x20).readU8() === 1);
                        }

                        var meta = getCardMetadata(cId);
                        var aId = (meta && meta.artistID) ? meta.artistID : 1001;
                        var tId = (meta && meta.theme) ? meta.theme : 1001;
                        var aName = artistNamesMap[aId] || "HeeJin";
                        var tName = themeNamesMap[tId] || "Hi High";

                        var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                        var setTextureFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);

                        // 1. card (0x38) -> CardLargeView
                        var card = viewThis.add(0x38).readPointer();
                        if (!card.isNull()) {
                            if (!cardParams.isNull()) {
                                try {
                                    var cardRefreshFn = new NativeFunction(baseAddr.add(0x137F570), "void", ["pointer", "pointer", "pointer"]);
                                    cardRefreshFn(card, cardParams, NULL);
                                } catch (eC) {}
                            }
                            // Direct texture loading on photo (0x58) and tier (0x68) to guarantee immediate high-res portrait
                            try {
                                var photo = card.add(0x58).readPointer();
                                if (!photo.isNull()) {
                                    var photoTex = loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_l.i.bytes");
                                    if (photoTex && !photoTex.isNull()) {
                                        setTextureFn(photo, photoTex, NULL);
                                        try {
                                            var setNativeSizeFn = new NativeFunction(baseAddr.add(0x194C1C8), "void", ["pointer", "pointer"]);
                                            setNativeSizeFn(photo, NULL);
                                        } catch (eSns) {}
                                        var photoGo = getGoFn(photo, NULL);
                                        if (!photoGo.isNull()) setActiveFn(photoGo, 1, NULL);
                                    }
                                }
                            } catch (ePh) {}
                        }

                        // 2. groupName (0x40)
                        var groupName = viewThis.add(0x40).readPointer();
                        if (!groupName.isNull()) {
                            try {
                                setTextFn(groupName, groupNameStr || createIl2CppString("LOONA"), NULL);
                            } catch (eG) {}
                        }

                        // 3. artistName (0x48)
                        var artistName = viewThis.add(0x48).readPointer();
                        if (!artistName.isNull()) {
                            try {
                                setTextFn(artistName, artistNameStr || createIl2CppString(aName), NULL);
                            } catch (eA) {}
                        }

                        // 4. stat (0x50)
                        var stat = viewThis.add(0x50).readPointer();
                        if (!stat.isNull()) {
                            try {
                                if (statParams.isNull()) {
                                    statParams = createMockCardStatInfoParams(gr, lvl, isPrism);
                                }
                                if (!statParams.isNull()) {
                                    var statRefreshFn = new NativeFunction(baseAddr.add(0x1390F48), "void", ["pointer", "pointer", "pointer"]);
                                    statRefreshFn(stat, statParams, NULL);
                                }
                            } catch (eS) {}
                        }

                        // 5. themeHeader (0x58)
                        var themeHeader = viewThis.add(0x58).readPointer();
                        if (!themeHeader.isNull()) {
                            try {
                                setTextFn(themeHeader, themeHeaderStr || createIl2CppString("Theme"), NULL);
                            } catch (eTh) {}
                        }

                        // 6. themeName (0x60)
                        var themeName = viewThis.add(0x60).readPointer();
                        if (!themeName.isNull()) {
                            try {
                                setTextFn(themeName, themeNameStr || createIl2CppString(tName), NULL);
                            } catch (eTn) {}
                        }

                        // 7. theme (0x68)
                        var theme = viewThis.add(0x68).readPointer();
                        if (!theme.isNull() && !themeParams.isNull()) {
                            try {
                                var themeRefreshFn = new NativeFunction(baseAddr.add(0x1393510), "void", ["pointer", "pointer", "pointer"]);
                                themeRefreshFn(theme, themeParams, NULL);
                            } catch (eThm) {}
                        }

                        // 8. equipIcon (0x70)
                        var equipIcon = viewThis.add(0x70).readPointer();
                        if (!equipIcon.isNull()) {
                            try {
                                var eqGo = getGoFn(equipIcon, NULL);
                                if (!eqGo.isNull()) setActiveFn(eqGo, isEq ? 1 : 0, NULL);
                            } catch (eEqGo) {}
                        }

                        // 9. btnSell (0x80)
                        var btnSell = viewThis.add(0x80).readPointer();
                        if (!btnSell.isNull()) {
                            try {
                                var bsGo = btnSell.add(0x10).readPointer();
                                if (!bsGo.isNull()) setActiveFn(bsGo, (!isEq && isSell) ? 1 : 0, NULL);
                            } catch (eBsGo) {}
                        }

                        // 10. leaderIcon (0x78)
                        var leaderIcon = viewThis.add(0x78).readPointer();
                        if (!leaderIcon.isNull()) {
                            try {
                                setActiveFn(leaderIcon, isLeader ? 1 : 0, NULL);
                            } catch (eLi) {}
                        }

                        // 11. leaderOnObj (0x90)
                        var leaderOnObj = viewThis.add(0x90).readPointer();
                        if (!leaderOnObj.isNull()) {
                            try {
                                setActiveFn(leaderOnObj, isLeader ? 1 : 0, NULL);
                            } catch (eLio) {}
                        }

                        // 12. lockOnObj (0xA0)
                        var lockOnObj = viewThis.add(0xA0).readPointer();
                        if (!lockOnObj.isNull()) {
                            try {
                                setActiveFn(lockOnObj, isLk ? 1 : 0, NULL);
                            } catch (eLko) {}
                        }

                        // 13. lockOffObj (0xA8)
                        var lockOffObj = viewThis.add(0xA8).readPointer();
                        if (!lockOffObj.isNull()) {
                            try {
                                setActiveFn(lockOffObj, isLk ? 0 : 1, NULL);
                            } catch (eLkoff) {}
                        }

                        log("[✅ SELECT_VIEW] InvenCardSelectView.Refresh safely completed! artist=" + aName + ", theme=" + tName);
                    } catch (eR) {
                        log("[-] Error in safe InvenCardSelectView.Refresh: " + eR.message);
                    }
                }

                try {
                    var invenCardSelectViewRefreshAddr = baseAddr.add(0xF22C34);
                    Interceptor.replace(invenCardSelectViewRefreshAddr, new NativeCallback(function (viewThis, p, methodInfo) {
                        safeRefreshInvenCardSelectView(viewThis, p);
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InvenCardSelectView.Refresh (0xF22C34)!");
                } catch (eHicsr) {
                    log("[-] Error replacing InvenCardSelectView.Refresh: " + eHicsr.message);
                }

                // 9d. ViewControl.GetCardStatInfoViewData (0xABFCD0) -> Ensures exact score & energy from cbd.json
                try {
                    var getCardStatInfoViewDataAddr = baseAddr.add(0xABFCD0);
                    Interceptor.attach(getCardStatInfoViewDataAddr, {
                        onEnter: function (args) {
                            this.cardItem = args[0];
                        },
                        onLeave: function (retval) {
                            if (!retval.isNull() && this.cardItem && !this.cardItem.isNull()) {
                                try {
                                    var raw = this.cardItem.add(0x10).readPointer();
                                    if (!raw.isNull()) {
                                        var gr = raw.add(0x24).readS32();
                                        var lvl = raw.add(0x1C).readS16();
                                        var isPrism = (raw.add(0x2A).readU8() === 1);
                                        var stats = getCardBaseStats(gr, lvl, isPrism);
                                        retval.add(0x14).writeS32(stats.score);
                                        retval.add(0x18).writeS32(stats.energy);
                                    }
                                } catch (eStat) {}
                            }
                        }
                    });
                    log("[+] Interceptor.attach installed on ViewControl.GetCardStatInfoViewData (0xABFCD0)!");
                } catch (eHgcs) {
                    log("[-] Error attaching GetCardStatInfoViewData: " + eHgcs.message);
                }

                // 9e. InventoryScene.OnCardItem (0x105CEE8) -> FULL OFFLINE REPLACE to prevent SetStateMain crash chain
                try {
                    var onCardItemAddr = baseAddr.add(0x105CEE8);
                    Interceptor.replace(onCardItemAddr, new NativeCallback(function (sceneThis, go, methodInfo) {
                        log("[🃏 ON_CARD_ITEM] OnCardItem REPLACE entered! scene=" + sceneThis + ", go=" + go);
                        try {
                            if (sceneThis.isNull() || go.isNull()) return;

                            // Step 1: Identify the clicked card from displayCardList (offset 0x58)
                            var clickedCardItem = NULL;
                            var clickedCardIndex = -1;
                            try {
                                var dclPtr = sceneThis.add(0x58).readPointer();
                                if (!dclPtr.isNull()) {
                                    var listSize = dclPtr.add(0x18).readS32();
                                    var listItems = dclPtr.add(0x10).readPointer(); // _items array

                                    // Get name of clicked GO to match by index (game names them "0", "1", ...)
                                    var getNameFn = new NativeFunction(baseAddr.add(0x1DC5A54), "pointer", ["pointer", "pointer"]);
                                    var namePtr = getNameFn(go, NULL);
                                    var clickedIndex = -1;
                                    if (!namePtr.isNull()) {
                                        var nLen = namePtr.add(0x10).readS32();
                                        if (nLen > 0) {
                                            var nStr = namePtr.add(0x14).readUtf16String(nLen);
                                            log("[🃏 ON_CARD_ITEM] Clicked GO name: '" + nStr + "' from list size " + listSize);
                                            clickedIndex = parseInt(nStr, 10);
                                        }
                                    }

                                    // Resolve card item from displayCardList
                                    if (!isNaN(clickedIndex) && clickedIndex >= 0 && clickedIndex < listSize && !listItems.isNull()) {
                                        var ci = listItems.add(0x20 + clickedIndex * 8).readPointer();
                                        if (!ci.isNull()) {
                                            clickedCardItem = ci;
                                            clickedCardIndex = clickedIndex;
                                            log("[🃏 ON_CARD_ITEM] Resolved CardItem[" + clickedIndex + "] = " + ci);
                                        }
                                    }

                                    // Fallback: if index-name failed, try index 0
                                    if (clickedCardItem.isNull() && listSize > 0 && !listItems.isNull()) {
                                        var ci0 = listItems.add(0x20).readPointer();
                                        if (!ci0.isNull()) {
                                            clickedCardItem = ci0;
                                            clickedCardIndex = 0;
                                            log("[🃏 ON_CARD_ITEM] Fallback: using CardItem[0] = " + ci0);
                                        }
                                    }
                                }
                            } catch (eDcl) {
                                log("[-] Error resolving CardItem from displayCardList: " + eDcl.message);
                            }

                            if (clickedCardItem.isNull()) {
                                // Last-resort fallback: use first loonaCardItem
                                if (loonaCardItems && loonaCardItems.length > 0) {
                                    clickedCardItem = loonaCardItems[0];
                                    log("[🃏 ON_CARD_ITEM] Last-resort fallback: loonaCardItems[0]");
                                } else {
                                    log("[-] ON_CARD_ITEM: No CardItem found, aborting.");
                                    return;
                                }
                            }

                            // Read card data for logging and resolving artist data
                            var cId = 1001; var gr = 4; var lvl = 50;
                            try {
                                var rawCard = clickedCardItem.add(0x10).readPointer();
                                if (!rawCard.isNull()) {
                                    cId = rawCard.add(0x20).readS32();
                                    gr = rawCard.add(0x24).readS32();
                                    lvl = rawCard.add(0x1C).readS16();
                                }
                            } catch (eRc) {}

                            var meta = getCardMetadata(cId);
                            var memberIdx = (meta.artistID >= 1000) ? (meta.artistID - 1000) : meta.artistID;
                            if (memberIdx < 1 || memberIdx > 11) memberIdx = ((cId - 1001) % 11) + 1;
                            var artistData = loonaArtistDataMap[memberIdx] || NULL;

                            var curState = sceneThis.add(0x24).readS32();
                            if (curState === 8) {
                                // STATE.Intensify -> Material Card toggle
                                log("[⚡ ON_CARD_ITEM_INTENSIFY] Material card clicked: " + clickedCardItem);
                                var isRegistered = false;
                                var matListPtr = sceneThis.add(0xA0).readPointer();
                                if (!matListPtr.isNull()) {
                                    var matCount = matListPtr.add(0x18).readS32();
                                    var matArr = matListPtr.add(0x10).readPointer();
                                    for (var mi = 0; mi < matCount; mi++) {
                                        var mItem = matArr.add(0x20 + mi * 8).readPointer();
                                        if (mItem.equals(clickedCardItem)) {
                                            isRegistered = true;
                                            break;
                                        }
                                    }
                                }
                                if (isRegistered) {
                                    log("[⚡ ON_CARD_ITEM_INTENSIFY] Unregistering material card: " + clickedCardItem);
                                    var unregFn = new NativeFunction(baseAddr.add(0x1058A04), "void", ["pointer", "pointer"]);
                                    unregFn(sceneThis, clickedCardItem);
                                } else {
                                    log("[⚡ ON_CARD_ITEM_INTENSIFY] Registering material card: " + clickedCardItem);
                                    var regFn = new NativeFunction(baseAddr.add(0x1056B5C), "void", ["pointer", "pointer"]);
                                    regFn(sceneThis, clickedCardItem);
                                }
                                var setStateIntensifyFn = new NativeFunction(baseAddr.add(0x1056BCC), "void", ["pointer", "bool", "bool"]);
                                setStateIntensifyFn(sceneThis, 0, 0);
                                return;
                            }

                            // Step 2: Store as selectedCardItem in scene (0x88) & preSelectedCardItem (0x98) & selectedArtistData (0x80)
                            sceneThis.add(0x88).writePointer(clickedCardItem);
                            sceneThis.add(0x98).writePointer(clickedCardItem);
                            sceneThis.add(0x80).writePointer(artistData);

                            log("[🃏 ON_CARD_ITEM] Selected: cardID=" + cId + ", grade=" + gr + ", level=" + lvl + ", theme=" + meta.theme + ", memberIdx=" + memberIdx + ", state=" + curState);

                            // Step 3: Call safeSetStateMain (isReload=1 if already in STATE.Main, else 0)
                            safeSetStateMain(sceneThis, (curState === 6) ? 1 : 0);
                        } catch (eOci) {
                            log("[-] Error in OnCardItem replace: " + eOci.message);
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.OnCardItem (0x105CEE8) - FULL OFFLINE MODE!");
                } catch (eHoci) {
                    log("[-] Error replacing OnCardItem: " + eHoci.message);
                }

                // 9e-bis. InventoryScene.OnGroupCard (0x105BDE0) -> Safe replacement for clicking equipped theme cards (OT11 grid)
                try {
                    var onGroupCardAddr = baseAddr.add(0x105BDE0);
                    Interceptor.replace(onGroupCardAddr, new NativeCallback(function (sceneThis, go, methodInfo) {
                        log("[👑 ON_GROUP_CARD] OnGroupCard REPLACE entered! scene=" + sceneThis + ", go=" + go);
                        try {
                            if (sceneThis.isNull() || go.isNull()) return;

                            // Get slot index from GameObject name (0 to 10)
                            var getNameFn = new NativeFunction(baseAddr.add(0x1DC5A54), "pointer", ["pointer", "pointer"]);
                            var namePtr = getNameFn(go, NULL);
                            var slotIndex = -1;
                            if (!namePtr.isNull()) {
                                var nLen = namePtr.add(0x10).readS32();
                                if (nLen > 0) {
                                    var nStr = namePtr.add(0x14).readUtf16String(nLen);
                                    log("[👑 ON_GROUP_CARD] Clicked equipped slot name: '" + nStr + "'");
                                    slotIndex = parseInt(nStr, 10);
                                }
                            }
                            if (isNaN(slotIndex) || slotIndex < 0 || slotIndex > 10) slotIndex = 0;
                            var targetArtistId = 1001 + slotIndex; // 1001 to 1011

                            // Find equipped card for this artist from loonaCardItems
                            var targetCardItem = NULL;
                            if (loonaCardItems && loonaCardItems.length > 0) {
                                for (var i = 0; i < loonaCardItems.length; i++) {
                                    var itm = loonaCardItems[i];
                                    if (itm.isNull()) continue;
                                    try {
                                        var raw = itm.add(0x10).readPointer();
                                        if (!raw.isNull()) {
                                            var cid = raw.add(0x20).readS32();
                                            var isEq = (raw.add(0x28).readU8() === 1);
                                            var cMeta = getCardMetadata(cid);
                                            if (cMeta.artistID === targetArtistId && isEq) {
                                                targetCardItem = itm;
                                                break;
                                            }
                                        }
                                    } catch (eItm) {}
                                }
                                if (targetCardItem.isNull()) {
                                    for (var j = 0; j < loonaCardItems.length; j++) {
                                        var itm2 = loonaCardItems[j];
                                        if (itm2.isNull()) continue;
                                        try {
                                            var raw2 = itm2.add(0x10).readPointer();
                                            if (!raw2.isNull()) {
                                                var cid2 = raw2.add(0x20).readS32();
                                                var cMeta2 = getCardMetadata(cid2);
                                                if (cMeta2.artistID === targetArtistId) {
                                                    targetCardItem = itm2;
                                                    break;
                                                }
                                            }
                                        } catch (eItm2) {}
                                    }
                                }
                                if (targetCardItem.isNull() && slotIndex < loonaCardItems.length) {
                                    targetCardItem = loonaCardItems[slotIndex];
                                }
                            }

                            if (targetCardItem.isNull()) {
                                log("[-] ON_GROUP_CARD: Could not find CardItem for slot " + slotIndex);
                                return;
                            }

                            var memberIdx = slotIndex + 1;
                            var artistData = loonaArtistDataMap[memberIdx] || NULL;

                            // Set scene state fields
                            sceneThis.add(0x88).writePointer(targetCardItem); // selectedCardItem
                            sceneThis.add(0x98).writePointer(targetCardItem); // preSelectedCardItem
                            sceneThis.add(0x80).writePointer(artistData);     // selectedArtistData
                            sceneThis.add(0x90).writePointer(targetCardItem); // equippedCardItem
                            sceneThis.add(0xBE).writeU8(0);                   // isChangeSelectedCardItem = false

                            log("[👑 ON_GROUP_CARD] Transitioning to SetStateMain for member " + memberIdx);
                            safeSetStateMain(sceneThis, 0);
                        } catch (eOgc) {
                            log("[-] Error in OnGroupCard replace: " + eOgc.message);
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.OnGroupCard (0x105BDE0)!");
                } catch (eHogc) {
                    log("[-] Error replacing OnGroupCard: " + eHogc.message);
                }

                // Authentic IL2CPP List<CardItem> operations using engine methods
                var clearCardItemList = function(listPtr) {
                    if (!listPtr || listPtr.isNull()) return;
                    try {
                        var listClearFn = new NativeFunction(baseAddr.add(0x23CE81C), "void", ["pointer"]);
                        listClearFn(listPtr);
                    } catch (eClr) {
                        try { listPtr.add(0x18).writeS32(0); } catch (eSz) {}
                    }
                };

                var addCardItemToList = function(listPtr, cardItem) {
                    if (!listPtr || listPtr.isNull() || !cardItem || cardItem.isNull()) return;
                    try {
                        var slotPtr = baseAddr.add(0x30E4000).add(0xEC0).readPointer();
                        if (!slotPtr.isNull()) {
                            var initMetaFn = new NativeFunction(baseAddr.add(0xA43BE8), "void", ["pointer"]);
                            initMetaFn(slotPtr);
                            var mi = slotPtr.readPointer();
                            var listAddFn = new NativeFunction(baseAddr.add(0x23CE41C), "void", ["pointer", "pointer", "pointer"]);
                            listAddFn(listPtr, cardItem, mi);
                        }
                    } catch (eAdd) {
                        log("[-] Error in addCardItemToList: " + eAdd.message);
                    }
                };

                // Dedicated renderer to inject local textures, stars/levels, and suppress disabled button artifacts on card cells
                var updateSingleCell = function(cell, cardItem, dataIdx, isInspected) {
                    try {
                        if (!cell || cell.isNull() || !cardItem || cardItem.isNull()) return;

                        var rawC = cardItem.add(0x10).readPointer();
                        if (rawC.isNull()) return;
                        var cId = rawC.add(0x20).readS32();
                        var gr = rawC.add(0x24).readS32();
                        var lvl = rawC.add(0x1C).readS16();

                        var getGoFnBase = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                        var setActFnBase = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                        var setEnabledFn = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                        var setTextureFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);

                        // 1. Ensure cell GameObject is active
                        var cellGo = getGoFnBase(cell, NULL);
                        if (!cellGo.isNull()) setActFnBase(cellGo, 1, NULL);

                        // 2. Hide ButtonCache artifacts: disabled ([-] bar) and box (gray slot) while keeping button interactable
                        var btnCache = cell.add(0x30).readPointer();
                        if (!btnCache.isNull()) {
                            var disImg = btnCache.add(0x58).readPointer();
                            if (!disImg.isNull()) {
                                setEnabledFn(disImg, 0, NULL);
                                var disGo = getGoFnBase(disImg, NULL);
                                if (!disGo.isNull()) setActFnBase(disGo, 0, NULL);
                                try { disImg.add(0x2C).writeFloat(0.0); } catch (e) {}
                            }

                            var boxImg = btnCache.add(0x50).readPointer();
                            if (!boxImg.isNull()) {
                                setEnabledFn(boxImg, 0, NULL);
                                var boxGo = getGoFnBase(boxImg, NULL);
                                if (!boxGo.isNull()) setActFnBase(boxGo, 0, NULL);
                                try { boxImg.add(0x2C).writeFloat(0.0); } catch (e) {}
                            }

                            var btnComp = btnCache.add(0x48).readPointer();
                            if (!btnComp.isNull()) {
                                var setTransFn = new NativeFunction(baseAddr.add(0x1954714), "void", ["pointer", "int", "pointer"]);
                                setTransFn(btnComp, 0, NULL); // Transition = None
                                var setInteractableFn = new NativeFunction(baseAddr.add(0x19549D4), "void", ["pointer", "bool", "pointer"]);
                                setInteractableFn(btnComp, 1, NULL); // Keep clickable!
                            }

                            var lbl = btnCache.add(0x60).readPointer();
                            if (!lbl.isNull()) { var g = getGoFnBase(lbl, NULL); if (!g.isNull()) setActFnBase(g, 0, NULL); }
                            var pBox = btnCache.add(0x68).readPointer();
                            if (!pBox.isNull()) { var g = getGoFnBase(pBox, NULL); if (!g.isNull()) setActFnBase(g, 0, NULL); }
                            var pLbl = btnCache.add(0x70).readPointer();
                            if (!pLbl.isNull()) { var g = getGoFnBase(pLbl, NULL); if (!g.isNull()) setActFnBase(g, 0, NULL); }
                        }

                        // 3. Render CardSmallView (item @ cell + 0x38)
                        var item = cell.add(0x38).readPointer();
                        if (!item.isNull()) {
                            var itemGo = getGoFnBase(item, NULL);
                            if (!itemGo.isNull()) setActFnBase(itemGo, 1, NULL);

                            // 3a. Portrait Photo (item + 0x58)
                            var photoRawImg = item.add(0x58).readPointer();
                            if (!photoRawImg.isNull()) {
                                var photoTex = loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_l.i.bytes") ||
                                               loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_s.i.bytes");
                                if (photoTex && !photoTex.isNull()) {
                                    setTextureFn(photoRawImg, photoTex, NULL);
                                    setEnabledFn(photoRawImg, 1, NULL);
                                    var pGo = getGoFnBase(photoRawImg, NULL);
                                    if (!pGo.isNull()) setActFnBase(pGo, 1, NULL);

                                    // Calibrate photo dimensions to BasicSize (92, 130)
                                    try {
                                        var getRectTrFn = new NativeFunction(baseAddr.add(0x1614EF0), "pointer", ["pointer", "pointer"]);
                                        var setSizeDeltaFn = new NativeFunction(baseAddr.add(0x180DC18), "void", ["pointer", "float", "float", "pointer"]);
                                        var photoRectTr = getRectTrFn(photoRawImg, NULL);
                                        if (!photoRectTr.isNull()) {
                                            setSizeDeltaFn(photoRectTr, 92.0, 130.0, NULL);
                                        }
                                    } catch (ePsz) {}
                                }
                            }

                            // 3b. Tier Frame (item + 0x68)
                            var tierRawImg = item.add(0x68).readPointer();
                            if (!tierRawImg.isNull()) {
                                var gLetter = (gr === 4) ? "r" : (gr === 3) ? "s" : (gr === 2) ? "a" : (gr === 1) ? "b" : "c";
                                var tierRelPath = (gr === 1) ? "0b_s.i.bytes" : ("0_" + gLetter + "_s.i.bytes");
                                var tierTex = loadLocalTexture2D("asiudgasg/asodhsg/aoeiwhslc/uhex/" + tierRelPath) ||
                                              loadLocalTexture2D("asiudgasg/asodhsg/aoeiwhslc/uhex/0_" + gLetter + "_s.i.bytes");
                                if (tierTex && !tierTex.isNull()) {
                                    setTextureFn(tierRawImg, tierTex, NULL);
                                    setEnabledFn(tierRawImg, 1, NULL);
                                    var tGo = getGoFnBase(tierRawImg, NULL);
                                    if (!tGo.isNull()) setActFnBase(tGo, 1, NULL);

                                    // Set native size (116x156) for tier frame
                                    try {
                                        var setNativeSizeFn = new NativeFunction(baseAddr.add(0x194C1C8), "void", ["pointer", "pointer"]);
                                        setNativeSizeFn(tierRawImg, NULL);
                                    } catch (eSns) {}
                                }
                            }

                            // 3c. Level Display: Stars vs Number
                            try {
                                var setStarVisFn = new NativeFunction(baseAddr.add(0x1388C58), "void", ["pointer", "int", "pointer"]);
                                var setNumVisFn = new NativeFunction(baseAddr.add(0x1393D68), "void", ["pointer", "int", "pointer"]);
                                if (gr === 4) {
                                    setStarVisFn(item, 0, NULL);
                                    setNumVisFn(item, 1, NULL);
                                    var numBox = item.add(0x80).readPointer();
                                    if (!numBox.isNull()) {
                                        var setValFn = new NativeFunction(baseAddr.add(0xC10448), "void", ["pointer", "uint32", "pointer"]);
                                        setValFn(numBox, lvl, NULL);
                                    }
                                } else {
                                    setStarVisFn(item, 1, NULL);
                                    setNumVisFn(item, 0, NULL);
                                }
                            } catch (eLvl) {}

                            // 3d. Hide ImageEfftect (item + 0xC8) and Effect (item + 0x88)
                            try {
                                var imgEff = item.add(0xC8).readPointer();
                                if (!imgEff.isNull()) {
                                    setEnabledFn(imgEff, 0, NULL);
                                    var effGo = getGoFnBase(imgEff, NULL);
                                    if (!effGo.isNull()) setActFnBase(effGo, 0, NULL);
                                }
                                var setEffectVisFn = new NativeFunction(baseAddr.add(0x1383F90), "void", ["pointer", "bool", "pointer"]);
                                setEffectVisFn(item, 0, NULL);
                            } catch (eEff) {}

                            // 3e. Ensure transform scale matches cell's itemScale
                            try {
                                var trFn = new NativeFunction(baseAddr.add(0x1DB6A94), "pointer", ["pointer", "pointer"]);
                                var itemTr = trFn(item, NULL);
                                if (!itemTr.isNull()) {
                                    var sX = cell.add(0x40).readFloat();
                                    var sY = cell.add(0x44).readFloat();
                                    var sZ = cell.add(0x48).readFloat();
                                    log("[📐 SCALE] cell itemScale: (" + sX + ", " + sY + ", " + sZ + ")");
                                    var setScaleFn = new NativeFunction(baseAddr.add(0x181E028), "void", ["pointer", "float", "float", "float", "pointer"]);
                                    if (sX > 0.001 && sY > 0.001) {
                                        setScaleFn(itemTr, sX, sY, sZ || 1.0, NULL);
                                    } else {
                                        setScaleFn(itemTr, 1.0, 1.0, 1.0, NULL);
                                    }
                                }
                            } catch (eSc) {}

                            // 3f. Equip Checkmark (mark @ item + 0xC0, markSprites @ item + 0xB8)
                            try {
                                var markImg = item.add(0xC0).readPointer();
                                var markSprites = item.add(0xB8).readPointer();
                                var isEquip = (rawC.add(0x28).readU8() === 1);
                                if (!markImg.isNull()) {
                                    if (isEquip && !markSprites.isNull()) {
                                        var getSpriteFn = new NativeFunction(baseAddr.add(0xD0CAB8), "pointer", ["pointer", "int", "pointer"]);
                                        var equipSprite = getSpriteFn(markSprites, 0, NULL); // MARK_INDEX.Equip = 0
                                        if (!equipSprite.isNull()) {
                                            var setSpriteFn = new NativeFunction(baseAddr.add(0x1ECB61C), "void", ["pointer", "pointer", "pointer"]);
                                            setSpriteFn(markImg, equipSprite, NULL);
                                        }
                                        setEnabledFn(markImg, 1, NULL);
                                        var mGo = getGoFnBase(markImg, NULL);
                                        if (!mGo.isNull()) setActFnBase(mGo, 1, NULL);
                                    } else {
                                        setEnabledFn(markImg, 0, NULL);
                                        var mGo = getGoFnBase(markImg, NULL);
                                        if (!mGo.isNull()) setActFnBase(mGo, 0, NULL);
                                    }
                                }
                            } catch (eMark) {}
                        }

                        // 4. Selection light: completely suppress white light overlay
                        try {
                            var setLightVisFn = new NativeFunction(baseAddr.add(0xF21424), "void", ["pointer", "bool", "pointer"]);
                            setLightVisFn(cell, 0, NULL);
                            var lightImg = cell.add(0x58).readPointer();
                            if (!lightImg.isNull()) {
                                setEnabledFn(lightImg, 0, NULL);
                                var lGo = getGoFnBase(lightImg, NULL);
                                if (!lGo.isNull()) setActFnBase(lGo, 0, NULL);
                                try { lightImg.add(0x2C).writeFloat(0.0); } catch (eAl3) {}
                            }
                        } catch (eLgt) {}

                        log("[✅ RENDER CELL] idx=" + dataIdx + " cId=" + cId + " gr=" + gr + " lvl=" + lvl + " isInspected=" + isInspected);
                    } catch (eRnd) {
                        log("[-] Error in updateSingleCell: " + eRnd.message);
                    }
                };

                // Helper to safely filter lower carousel (InvenCardView @ sceneView + 0x78) by member and theme
                var safeUpdateLowerCarousel = function(sceneThis, selectedCardItem) {
                    try {
                        if (sceneThis.isNull() || selectedCardItem.isNull()) return;

                        var rawSel = selectedCardItem.add(0x10).readPointer();
                        if (rawSel.isNull()) return;

                        var selObjIdStr = rawSel.add(0x10).readS64().toString();
                        var selCardId = rawSel.add(0x20).readS32();
                        var selMeta = getCardMetadata(selCardId);
                        var selArtist = selMeta.artistID;
                        var selTheme = selMeta.theme;

                        log("[🎠 CAROUSEL] Filtering lower cards for selCard=" + selCardId + " (artist=" + selArtist + ", theme=" + selTheme + ", obj=" + selObjIdStr + ")");

                        // Step 1: Collect matching cards: ALWAYS include the inspected card first!
                        var filteredItems = [selectedCardItem];
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var i = 0; i < loonaCardItems.length; i++) {
                                var cItem = loonaCardItems[i];
                                if (cItem.isNull()) continue;

                                var rawC = cItem.add(0x10).readPointer();
                                if (rawC.isNull()) continue;

                                var cObjIdStr = rawC.add(0x10).readS64().toString();
                                // Skip the inspected card (already placed at index 0)
                                if (cObjIdStr === selObjIdStr) continue;

                                var cCardId = rawC.add(0x20).readS32();
                                var cMeta = getCardMetadata(cCardId);

                                // Filter: all cards belonging to the same member (artistID)
                                if (cMeta.artistID === selArtist) {
                                    filteredItems.push(cItem);
                                    log("[🎠 CAROUSEL MATCH] Added candidate cardID=" + cCardId + " obj=" + cObjIdStr + " theme=" + cMeta.theme);
                                }
                            }
                        }
                        log("[🎠 CAROUSEL] Total matching filtered cards: " + filteredItems.length);

                        // Set extractType to 1 (Artist)
                        sceneThis.add(0x50).writeS32(1);

                        // Step 2: Update displayCardList (offset 0x58 in InventoryScene)
                        var dclPtr = sceneThis.add(0x58).readPointer();
                        if (dclPtr.isNull()) {
                            log("[-] CAROUSEL: displayCardList is null!");
                            return;
                        }

                        var listItems = ensureListBuffer(dclPtr, Math.max(filteredItems.length, 64));
                        if (!listItems || listItems.isNull()) {
                            log("[-] CAROUSEL: displayCardList._items is null and cannot be allocated!");
                            return;
                        }

                        for (var f = 0; f < filteredItems.length; f++) {
                            listItems.add(0x20 + f * 8).writePointer(filteredItems[f]);
                        }
                        dclPtr.add(0x18).writeS32(filteredItems.length);

                        // Step 3: Get sceneView (0x48) -> cardView (0x78)
                        var sceneView = sceneThis.add(0x48).readPointer();
                        if (sceneView.isNull()) {
                            log("[-] CAROUSEL: sceneView is null!");
                            return;
                        }
                        var cardView = sceneView.add(0x78).readPointer();
                        if (cardView.isNull()) {
                            log("[-] CAROUSEL: cardView is null!");
                            return;
                        }

                        activeInventorySceneInstance = sceneThis;
                        try {
                            var setGroupBtnAreaFn = new NativeFunction(baseAddr.add(0xF233E0), "void", ["pointer", "bool", "pointer"]);
                            setGroupBtnAreaFn(cardView, 1, NULL);
                        } catch (eGrp) {}

                        log("[🎠 CAROUSEL] sceneThis=" + sceneThis + " sceneView=" + sceneView + " cardView=" + cardView + " filteredCount=" + filteredItems.length);
                        // Read or create delegate
                        var eventListener = ensureCardViewEventListener(sceneThis, cardView);
                        log("[🎠 CAROUSEL] eventListener=" + eventListener);

                        // Ensure cardView GameObject is active
                        var getGoFnBase = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                        var setActFnBase = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                        var cvGo = getGoFnBase(cardView, NULL);
                        if (!cvGo.isNull()) setActFnBase(cvGo, 1, NULL);

                        // Directly write InvenCardView properties
                        cardView.add(0x98).writeS32(filteredItems.length); // maxCount
                        cardView.add(0x90).writePointer(eventListener);     // onEventListener
                        cardView.add(0x9C).writeU8(0);                      // isShowLight

                        // Step 4: Reload scroller cleanly without triggering Canvas.ForceUpdateCanvases
                        var scroller = cardView.add(0x40).readPointer();
                        if (!scroller.isNull()) {
                            var scGo = getGoFnBase(scroller, NULL);
                            if (!scGo.isNull()) setActFnBase(scGo, 1, NULL);

                            try {
                                var reloadKeepPosFn = new NativeFunction(baseAddr.add(0x125C750), "void", ["pointer", "bool", "pointer"]);
                                reloadKeepPosFn(scroller, 0, NULL);
                                log("[✅ CAROUSEL] ReloadDataKeepPosition(0) completed!");
                            } catch (eRk) {
                                log("[-] Error in ReloadDataKeepPosition: " + eRk.message);
                            }

                            try {
                                var resetCellsFn = new NativeFunction(baseAddr.add(0x125D768), "void", ["pointer", "pointer"]);
                                resetCellsFn(scroller, NULL);
                                log("[✅ CAROUSEL] _ResetVisibleCellViews called successfully!");
                            } catch (eRcv) {
                                log("[-] Error in _ResetVisibleCellViews: " + eRcv.message);
                            }

                            scroller.add(0xE1).writeU8(1); // ensure _refreshActive stays true for LateUpdate
                            sanitizeCardScroller(cardView);

                            // Directly update all active cells in scroller with local textures & suppressed artifacts
                            try {
                                var acv = scroller.add(0x120).readPointer();
                                if (!acv.isNull()) {
                                    var acvCount = acv.add(0x18).readS32();
                                    var acvData = acv.add(0x10).readPointer();
                                    log("[🎠 CAROUSEL] Directly applying textures & clean state on " + acvCount + " active carousel cells");
                                    for (var cIdx = 0; cIdx < acvCount; cIdx++) {
                                        var cCell = acvData.add(0x20 + cIdx * 8).readPointer();
                                        if (cCell.isNull()) continue;
                                        var dIdx = cCell.add(0x24).readS32();
                                        var cGo = getGoFnBase(cCell, NULL);
                                        if (dIdx >= 0 && dIdx < filteredItems.length && cIdx < filteredItems.length) {
                                            if (!cGo.isNull()) setActFnBase(cGo, 1, NULL);
                                            updateSingleCell(cCell, filteredItems[dIdx], dIdx, (dIdx === 0));
                                        } else {
                                            if (!cGo.isNull()) setActFnBase(cGo, 0, NULL);
                                        }
                                    }

                                    // Deactivate any duplicate or stray children in container (e.g. ghost cells at pos=3)
                                    var container = scroller.add(0xC8).readPointer();
                                    if (!container.isNull()) {
                                        var dGetChild = new NativeFunction(baseAddr.add(0x181F128), "pointer", ["pointer", "int", "pointer"]);
                                        var dChildCount = new NativeFunction(baseAddr.add(0x181ECF0), "int", ["pointer", "pointer"]);
                                        var padF = scroller.add(0xF0).readPointer();
                                        var padL = scroller.add(0xF8).readPointer();
                                        var trFn = new NativeFunction(baseAddr.add(0x1DB6A94), "pointer", ["pointer", "pointer"]);
                                        var padFT = (!padF.isNull()) ? trFn(padF, NULL) : NULL;
                                        var padLT = (!padL.isNull()) ? trFn(padL, NULL) : NULL;

                                        var wantedTrs = [];
                                        for (var w = 0; w < filteredItems.length && w < acvCount; w++) {
                                            var wCell = acvData.add(0x20 + w * 8).readPointer();
                                            if (!wCell.isNull()) {
                                                var wTr = trFn(wCell, NULL);
                                                if (!wTr.isNull()) wantedTrs.push(wTr.toString());
                                            }
                                        }

                                        var nChild = dChildCount(container, NULL);
                                        for (var ch = 0; ch < nChild; ch++) {
                                            var chT = dGetChild(container, ch, NULL);
                                            if (chT.isNull()) continue;
                                            if ((!padFT.isNull() && chT.equals(padFT)) || (!padLT.isNull() && chT.equals(padLT))) continue;
                                            var chGo = getGoFnBase(chT, NULL);
                                            if (chGo.isNull()) continue;
                                            if (wantedTrs.indexOf(chT.toString()) === -1) {
                                                setActFnBase(chGo, 0, NULL);
                                            }
                                        }
                                    }
                                }
                            } catch (eActUpdate) {
                                log("[-] Error applying textures to active carousel cells: " + eActUpdate.message);
                            }
                        }

                        // Step 5: Update cardCountText (cardView+0x38) to display "<count> / 200"
                        try {
                            var cardCountText = cardView.add(0x38).readPointer();
                            if (!cardCountText.isNull()) {
                                var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                setTextFn(cardCountText, createIl2CppString(filteredItems.length + " / 200"), NULL);
                                log("[✅ CAROUSEL] Updated cardCountText to: " + filteredItems.length + " / 200");
                            }
                        } catch (eCct) {
                            log("[-] Error updating cardCountText: " + eCct.message);
                        }
                    } catch (eCar) {
                        log("[-] Error in safeUpdateLowerCarousel: " + eCar.message);
                    }
                };

                // Helper to ensure an IL2CPP List<CardItem> has an allocated _items array with at least minCap elements
                var ensureListBuffer = function(listPtr, minCap) {
                    try {
                        if (!listPtr || listPtr.isNull() || listPtr.compare(ptr(0x10000)) <= 0) return NULL;
                        if (Process.arch === "arm64" && listPtr.compare(ptr("0x8000000000")) >= 0) return NULL;
                        var itemsPtr = listPtr.add(0x10).readPointer();
                        if (!itemsPtr.isNull() && (itemsPtr.compare(ptr(0x10000)) <= 0 || (Process.arch === "arm64" && itemsPtr.compare(ptr("0x8000000000")) >= 0))) {
                            itemsPtr = NULL;
                        }
                        var curCap = (!itemsPtr.isNull()) ? itemsPtr.add(0x18).readS32() : 0;
                        if (itemsPtr.isNull() || curCap < minCap) {
                            if (!cachedCardItemKlass || cachedCardItemKlass.isNull()) {
                                var itemSlot = baseAddr.add(0x31F3060).readPointer();
                                if (!itemSlot.isNull()) cachedCardItemKlass = itemSlot;
                                if (!cachedCardItemKlass || cachedCardItemKlass.isNull()) {
                                    cachedCardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "InventoryControl/CardItem");
                                }
                            }
                            if (il2cpp_array_new && cachedCardItemKlass && !cachedCardItemKlass.isNull()) {
                                var allocCap = Math.max(minCap, 64);
                                var newArr = il2cpp_array_new(cachedCardItemKlass, allocCap);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(newArr, 2);
                                listPtr.add(0x10).writePointer(newArr);
                                log("[🗃️ BUFFER] Expanded list buffer " + listPtr + " from cap " + curCap + " to " + allocCap);
                                return newArr;
                            }
                        }
                        return itemsPtr;
                    } catch (eBf) {
                        log("[-] Error in ensureListBuffer: " + eBf.message);
                        return NULL;
                    }
                };

                // Helper to ensure InvenCardView onEventListener delegate is valid
                var cachedMethodInfoBuf = NULL;
                var ensureCardViewEventListener = function(sceneThis, cardView) {
                    if (!cardView || cardView.isNull()) return NULL;
                    var eventListener = cardView.add(0x90).readPointer();
                    if (!eventListener.isNull()) {
                        if (!sceneThis.isNull() && eventListener.add(0x20).readPointer().isNull()) {
                            eventListener.add(0x20).writePointer(sceneThis);
                        }
                        return eventListener;
                    }

                    if (!sceneThis.isNull()) {
                        try {
                            var dKlassSlot = baseAddr.add(0x30FC000).add(0x690).readPointer();
                            var dKlass = (!dKlassSlot.isNull()) ? dKlassSlot.readPointer() : NULL;
                            if (!dKlass || dKlass.isNull()) {
                                dKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "InvenCardCellView/OnEventListener");
                            }
                            var methodSlot = baseAddr.add(0x3104000).add(0x918).readPointer();
                            var methodPtr = (!methodSlot.isNull()) ? methodSlot.readPointer() : NULL;
                            if (dKlass && !dKlass.isNull() && methodPtr && !methodPtr.isNull()) {
                                var newDel = il2cpp_object_new(dKlass);
                                var dCtorFn = new NativeFunction(baseAddr.add(0xB52D54), "void", ["pointer", "pointer", "pointer", "pointer"]);
                                dCtorFn(newDel, sceneThis, methodPtr, NULL);
                                if (il2cpp_gchandle_new) il2cpp_gchandle_new(newDel, 0);
                                eventListener = newDel;
                                cardView.add(0x90).writePointer(eventListener);
                                log("[🗃️ DELEGATE] Successfully created genuine delegate pointing to 0x105F448: " + eventListener);
                            }
                        } catch (eDel) {
                            log("[-] Error creating fallback delegate: " + eDel.message);
                        }
                    }
                    return eventListener;
                };

                // Helper to ensure all required card lists are initialized with valid buffer capacity (64)
                var cachedListCardItemKlass = NULL;
                var ensureInventoryLists = function(scene) {
                    try {
                        if (!scene || scene.isNull() || scene.compare(ptr(0x10000)) <= 0) return;
                        if (Process.arch === "arm64" && scene.compare(ptr("0x8000000000")) >= 0) return;

                        var klass = NULL;
                        var dcl = scene.add(0x58).readPointer();
                        if (!dcl.isNull()) {
                            klass = dcl.readPointer();
                            cachedListCardItemKlass = klass;
                        } else if (cachedListCardItemKlass && !cachedListCardItemKlass.isNull()) {
                            klass = cachedListCardItemKlass;
                        }
                        if (!klass || klass.isNull()) return;

                        var listOffsets = [0x58, 0x60, 0x68, 0x70, 0x78, 0xA0];
                        for (var i = 0; i < listOffsets.length; i++) {
                            var off = listOffsets[i];
                            var curPtr = scene.add(off).readPointer();
                            if (curPtr.isNull()) {
                                var newObj = il2cpp_object_new(klass);
                                if (!newObj.isNull()) {
                                    if (il2cpp_gchandle_new) il2cpp_gchandle_new(newObj, 2);
                                    scene.add(off).writePointer(newObj);
                                    curPtr = newObj;
                                    log("[🗃️ INVENTORY] ensureInventoryLists: initialized offset 0x" + off.toString(16) + " -> " + newObj);
                                }
                            }
                            if (!curPtr.isNull()) {
                                ensureListBuffer(curPtr, 64);
                            }
                        }
                    } catch (eLists) {
                        log("[-] Error in ensureInventoryLists: " + eLists.message);
                    }
                };
                var ensureMaterialCardItemList = ensureInventoryLists;

                // Helper: restore EnhancedScroller container invariant [FirstPadder, cells..., LastPadder].
                // EnhancedScroller inserts new cells at SetSiblingIndex(childCount - 2), assuming LastPadder is the last child.
                var sanitizeCardScroller = function(cardView) {
                    try {
                        if (!cardView || cardView.isNull()) return;
                        var scroller = cardView.add(0x40).readPointer();
                        if (scroller.isNull()) return;
                        var container = scroller.add(0xC8).readPointer();
                        var padF = scroller.add(0xF0).readPointer();
                        var padL = scroller.add(0xF8).readPointer();
                        if (container.isNull() || padF.isNull() || padL.isNull()) return;
                        var trFn = new NativeFunction(baseAddr.add(0x1DB6A94), "pointer", ["pointer", "pointer"]);
                        var firstSibFn = new NativeFunction(baseAddr.add(0x181ED30), "void", ["pointer", "pointer"]);
                        var lastSibFn = new NativeFunction(baseAddr.add(0x181ED70), "void", ["pointer", "pointer"]);

                        var padFT = (!padF.isNull()) ? trFn(padF, NULL) : NULL;
                        var padLT = (!padL.isNull()) ? trFn(padL, NULL) : NULL;
                        if (!padFT.isNull()) firstSibFn(padFT, NULL);
                        if (!padLT.isNull()) lastSibFn(padLT, NULL);
                    } catch (eSan) {
                        log("[-] Error in sanitizeCardScroller: " + eSan.message);
                    }
                };

                // Helper to restore all cards in displayCardList when returning to default state
                // skipSetData=true only fills the native list (used while the view is not ready yet; SetData there aborts mid-ReloadData)
                var restoreDefaultDisplayCardList = function(sceneThis, force, skipSetData) {
                    try {
                        if (sceneThis.isNull() || !loonaCardItems || loonaCardItems.length === 0) return;
                        activeInventorySceneInstance = sceneThis;
                        ensureMaterialCardItemList(sceneThis);
                        var dclPtr = sceneThis.add(0x58).readPointer();
                        if (dclPtr.isNull()) return;

                        var currentCount = dclPtr.add(0x18).readS32();
                        var currentExtract = sceneThis.add(0x50).readS32();
                        if (!force && currentCount >= loonaCardItems.length && currentExtract === 0) {
                            log("[ℹ️ RESTORE] displayCardList already contains " + currentCount + " cards and extractType=0, skipping duplicate restore!");
                            return;
                        }

                        sortLoonaCardItems();

                        var listItems = ensureListBuffer(dclPtr, Math.max(loonaCardItems.length, 64));
                        if (!listItems || listItems.isNull()) {
                            log("[-] restoreDefaultDisplayCardList: listItems is null and cannot be allocated!");
                            return;
                        }

                        for (var i = 0; i < loonaCardItems.length; i++) {
                            listItems.add(0x20 + i * 8).writePointer(loonaCardItems[i]);
                        }
                        dclPtr.add(0x18).writeS32(loonaCardItems.length);
                        sceneThis.add(0x50).writeS32(0); // EXTRACT_TYPE.All
                        if (skipSetData) {
                            log("[✅ RESTORE] displayCardList filled with " + loonaCardItems.length + " cards (SetData deferred)");
                            return;
                        }

                        var sceneView = sceneThis.add(0x48).readPointer();
                        if (!sceneView.isNull()) {
                            var cardView = sceneView.add(0x78).readPointer();
                            if (!cardView.isNull()) {
                                try {
                                    var setGroupBtnAreaFn = new NativeFunction(baseAddr.add(0xF233E0), "void", ["pointer", "bool", "pointer"]);
                                    setGroupBtnAreaFn(cardView, 1, NULL);
                                } catch (eGrp) {}

                                var scroller = cardView.add(0x40).readPointer();
                                var eventListener = ensureCardViewEventListener(sceneThis, cardView);
                                if (!scroller.isNull() && eventListener && !eventListener.isNull()) {
                                    var setDataFn = new NativeFunction(baseAddr.add(0xF23384), "void", ["pointer", "int", "bool", "pointer", "pointer"]);
                                    setDataFn(cardView, loonaCardItems.length, 0, eventListener, NULL);
                                    sanitizeCardScroller(cardView);
                                    log("[✅ RESTORE] SetData called on InvenCardView with count=" + loonaCardItems.length);

                                    // Restore cardCountText to loonaCardItems.length / 200
                                    try {
                                        var cardCountText = cardView.add(0x38).readPointer();
                                        if (!cardCountText.isNull()) {
                                            var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                            setTextFn(cardCountText, createIl2CppString(loonaCardItems.length + " / 200"), NULL);
                                            log("[✅ RESTORE] Restored cardCountText to: " + loonaCardItems.length + " / 200");
                                        }
                                    } catch (eCctR) {}
                                }
                            }
                        }
                        log("[✅ RESTORE] Restored displayCardList to all " + loonaCardItems.length + " cards!");
                    } catch (eR) {
                        log("[-] Error restoring displayCardList: " + eR.message);
                    }
                };

                // Populates displayCardList with eligible material cards when in Intensify view (extractType = 2)
                var populateMaterialDisplayCardList = function(sceneThis) {
                    try {
                        if (!sceneThis || sceneThis.isNull() || !loonaCardItems || loonaCardItems.length === 0) return;
                        var dclPtr = sceneThis.add(0x58).readPointer();
                        if (dclPtr.isNull()) return;

                        var selCard = sceneThis.add(0x88).readPointer();
                        if (selCard.isNull()) selCard = sceneThis.add(0x98).readPointer();
                        var targetObjId = 0;
                        var targetGrade = 0;
                        var targetLevel = 1;
                        var targetArtistCode = 0;
                        if (!selCard.isNull()) {
                            var raw = selCard.add(0x10).readPointer();
                            if (!raw.isNull()) {
                                targetObjId = raw.add(0x10).readS64();
                                targetGrade = raw.add(0x24).readS32();
                                targetLevel = raw.add(0x1C).readS16();
                                targetArtistCode = raw.add(0x18).readS32();
                            }
                        }

                        var isMaxLevel = (targetGrade === 4) ? (targetLevel >= 50) : (targetLevel >= 5);
                        log("[⚡ MATERIAL LIST] Populating materials for target ObjId=" + targetObjId + ", Grade=" + targetGrade + ", Lvl=" + targetLevel + ", isMaxLevel=" + isMaxLevel);

                        var eligible = [];
                        for (var i = 0; i < loonaCardItems.length; i++) {
                            var item = loonaCardItems[i];
                            if (!item || item.isNull() || item.equals(selCard)) continue;
                            var raw = item.add(0x10).readPointer();
                            if (!raw || raw.isNull()) continue;

                            var objId = raw.add(0x10).readS64();
                            if (objId === targetObjId) continue;

                            var isEquip = (raw.add(0x28).readU8() !== 0);
                            var isLock = (raw.add(0x29).readU8() !== 0);
                            if (isEquip || isLock) continue;

                            var grade = raw.add(0x24).readS32();
                            var level = raw.add(0x1C).readS16();
                            var artistCode = raw.add(0x18).readS32();

                            // Ensure valid IntensifyCode on cardItem
                            var fCode = (grade < 4) ? (grade * 5 + Math.min(4, level - 1)) : (20 + Math.min(98, level - 1));
                            item.add(0x20).writeS16(fCode);

                            if (isMaxLevel) {
                                var reqMax = (grade === 4) ? 50 : 5;
                                if (artistCode === targetArtistCode && grade === targetGrade && level >= reqMax) {
                                    eligible.push(item);
                                }
                            } else {
                                eligible.push(item);
                            }
                        }

                        // Sort eligible: Lowest grade first (C=0, B=1, A=2, S=3, R=4), then lowest level
                        eligible.sort(function(a, b) {
                            var rawA = a.add(0x10).readPointer();
                            var rawB = b.add(0x10).readPointer();
                            var gA = rawA.add(0x24).readS32();
                            var gB = rawB.add(0x24).readS32();
                            if (gA !== gB) return gA - gB;
                            var lA = rawA.add(0x1C).readS16();
                            var lB = rawB.add(0x1C).readS16();
                            return lA - lB;
                        });

                        log("[⚡ MATERIAL LIST] Found " + eligible.length + " eligible material cards (sorted LowGrade first)!");

                        var listItems = ensureListBuffer(dclPtr, Math.max(eligible.length, 64));
                        for (var j = 0; j < eligible.length; j++) {
                            listItems.add(0x20 + j * 8).writePointer(eligible[j]);
                        }
                        dclPtr.add(0x18).writeS32(eligible.length);
                        sceneThis.add(0x50).writeS32(2); // EXTRACT_TYPE.Material

                        // Refresh UI CardView
                        var sceneView = sceneThis.add(0x48).readPointer();
                        if (!sceneView.isNull()) {
                            var cardView = sceneView.add(0x78).readPointer();
                            if (!cardView.isNull()) {
                                var eventListener = ensureCardViewEventListener(sceneThis, cardView);
                                var setDataFn = new NativeFunction(baseAddr.add(0xF23384), "void", ["pointer", "int", "bool", "pointer", "pointer"]);
                                setDataFn(cardView, eligible.length, 0, eventListener, NULL);
                                sanitizeCardScroller(cardView);
                                var cardCountText = cardView.add(0x38).readPointer();
                                if (!cardCountText.isNull()) {
                                    var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                    setTextFn(cardCountText, createIl2CppString(eligible.length + " / 200"), NULL);
                                }
                            }
                        }
                        log("[✅ MATERIAL LIST] Material display list refreshed in UI with " + eligible.length + " cards!");
                    } catch (eMatList) {
                        log("[-] Error in populateMaterialDisplayCardList: " + eMatList.message);
                    }
                };

                // Smart recommend material selection: picks up to 5 lowest grade cards and calls RegistMaterialCardItem
                var executeRecommend = function(sceneThis) {
                    try {
                        log("[⚡ RECOMMEND EXEC] Starting smart recommend material selection...");
                        if (!sceneThis || sceneThis.isNull()) return;

                        // 1. Clear existing materials
                        var clearFn = new NativeFunction(baseAddr.add(0x1054118), "void", ["pointer"]);
                        clearFn(sceneThis);

                        // 2. Identify target card
                        var targetCard = sceneThis.add(0x88).readPointer();
                        if (targetCard.isNull()) targetCard = sceneThis.add(0x98).readPointer();
                        if (!targetCard.isNull()) {
                            sceneThis.add(0x88).writePointer(targetCard);
                            sceneThis.add(0x98).writePointer(targetCard);
                        }
                        var targetObjId = 0;
                        var targetGrade = 0;
                        var targetLevel = 1;
                        var targetArtistCode = 0;
                        if (!targetCard.isNull()) {
                            var rawT = targetCard.add(0x10).readPointer();
                            if (!rawT.isNull()) {
                                targetObjId = rawT.add(0x10).readS64();
                                targetGrade = rawT.add(0x24).readS32();
                                targetLevel = rawT.add(0x1C).readS16();
                                var tCardId = rawT.add(0x20).readS32();
                                var tMeta = getCardMetadata(tCardId);
                                targetArtistCode = tMeta ? tMeta.artistID : 0;
                            }
                        }
                        var isMaxLevel = (targetGrade === 4) ? (targetLevel >= 50) : (targetLevel >= 5);

                        // 3. Find candidates from loonaCardItems
                        var candidates = [];
                        for (var i = 0; i < loonaCardItems.length; i++) {
                            var item = loonaCardItems[i];
                            if (!item || item.isNull() || item.equals(targetCard)) continue;
                            var raw = item.add(0x10).readPointer();
                            if (!raw || raw.isNull()) continue;

                            var objId = raw.add(0x10).readS64();
                            if (objId === targetObjId) continue;
                            var isEq = (raw.add(0x28).readU8() !== 0);
                            var isLk = (raw.add(0x29).readU8() !== 0);
                            if (isEq || isLk) continue;

                            var gr = raw.add(0x24).readS32();
                            var lvl = raw.add(0x1C).readS16();
                            var cId = raw.add(0x20).readS32();
                            var cMeta = getCardMetadata(cId);
                            var art = cMeta ? cMeta.artistID : 0;

                            // Ensure valid IntensifyCode and Card backing field
                            var fCode = (gr < 4) ? (gr * 5 + Math.min(4, lvl - 1)) : (20 + Math.min(98, lvl - 1));
                            item.add(0x20).writeS16(fCode);
                            var ccd = getOrCreateCardControlData(cId);
                            item.add(0x18).writePointer(ccd || NULL);

                            if (isMaxLevel) {
                                var reqMax = (gr === 4) ? 50 : 5;
                                if (art === targetArtistCode && gr === targetGrade && lvl >= reqMax) {
                                    candidates.push(item);
                                }
                            } else {
                                candidates.push(item);
                            }
                        }

                        // 4. Sort lowest grade first (C -> B -> A -> S -> R)
                        candidates.sort(function(a, b) {
                            var rA = a.add(0x10).readPointer();
                            var rB = b.add(0x10).readPointer();
                            var gA = rA.add(0x24).readS32();
                            var gB = rB.add(0x24).readS32();
                            if (gA !== gB) return gA - gB;
                            var lA = rA.add(0x1C).readS16();
                            var lB = rB.add(0x1C).readS16();
                            return lA - lB;
                        });

                        // 5. Ensure targetCard has valid Card backing field, IntensifyCode, and scene.selectedArtistData
                        if (!targetCard.isNull()) {
                            sceneThis.add(0x88).writePointer(targetCard);
                            sceneThis.add(0x98).writePointer(targetCard);
                            var rawT2 = targetCard.add(0x10).readPointer();
                            if (!rawT2.isNull()) {
                                var tCardId2 = rawT2.add(0x20).readS32();
                                var tCcd2 = getOrCreateCardControlData(tCardId2);
                                targetCard.add(0x18).writePointer(tCcd2 || NULL);
                                var tCode2 = (targetGrade < 4) ? (targetGrade * 5 + Math.min(4, targetLevel - 1)) : (20 + Math.min(98, targetLevel - 1));
                                targetCard.add(0x20).writeS16(tCode2);
                            }
                        }
                        var curArt = sceneThis.add(0x80).readPointer();
                        if (curArt.isNull() && targetArtistCode > 0 && loonaArtistDataMap[targetArtistCode]) {
                            sceneThis.add(0x80).writePointer(loonaArtistDataMap[targetArtistCode]);
                            log("[⚡ RECOMMEND] Set scene.selectedArtistData to artist " + targetArtistCode);
                        }

                        // 6. Register up to 5 material cards
                        var pickCount = Math.min(5, candidates.length);
                        var regFn = new NativeFunction(baseAddr.add(0x1056B5C), "void", ["pointer", "pointer"]);
                        for (var p = 0; p < pickCount; p++) {
                            var cand = candidates[p];
                            var cRaw = cand.add(0x10).readPointer();
                            var candCId = cRaw.add(0x20).readS32();
                            var candCcd = getOrCreateCardControlData(candCId);
                            cand.add(0x18).writePointer(candCcd || NULL);
                            regFn(sceneThis, cand);
                            log("[⚡ RECOMMEND] Added material card #" + (p + 1) + ": ObjId=" + cRaw.add(0x10).readS64() + ", Grade=" + cRaw.add(0x24).readS32() + ", Level=" + cRaw.add(0x1C).readS16());
                        }

                        // 7. Verify all registered materials in materialCardItemList (scene + 0xA0) have valid Card and IntensifyCode
                        var matList = sceneThis.add(0xA0).readPointer();
                        if (!matList.isNull()) {
                            var mCount = matList.add(0x18).readS32();
                            var mItems = matList.add(0x10).readPointer();
                            for (var m = 0; m < mCount; m++) {
                                var mItem = mItems.add(0x20 + m * 8).readPointer();
                                if (mItem && !mItem.isNull()) {
                                    var mRaw = mItem.add(0x10).readPointer();
                                    if (!mRaw.isNull()) {
                                        var mcId = mRaw.add(0x20).readS32();
                                        var mccd = getOrCreateCardControlData(mcId);
                                        mItem.add(0x18).writePointer(mccd || NULL);
                                        var mgr = mRaw.add(0x24).readS32();
                                        var mlvl = mRaw.add(0x1C).readS16();
                                        var mfCode = (mgr < 4) ? (mgr * 5 + Math.min(4, mlvl - 1)) : (20 + Math.min(98, mlvl - 1));
                                        mItem.add(0x20).writeS16(mfCode);
                                    }
                                }
                            }
                        }

                        // 8. Refresh SetStateIntensify(false, false)
                        if (!targetCard.isNull()) {
                            sceneThis.add(0x88).writePointer(targetCard);
                            sceneThis.add(0x98).writePointer(targetCard);
                        }
                        if (sceneThis.add(0xA8).readDouble() === 0.0) {
                            sceneThis.add(0xA8).writeDouble(1.0);
                        }
                        if (sceneThis.add(0xB0).readDouble() === 0.0) {
                            sceneThis.add(0xB0).writeDouble(1.0);
                        }
                        var sv = sceneThis.add(0x48).readPointer();
                        var bbs = (!sv.isNull()) ? sv.add(0xC0).readPointer() : NULL;
                        log("[🔍 RECOMMEND BEFORE REFRESH] sceneView=" + sv + ", btnBoxSprites=" + bbs);
                        var setStateIntensifyFn = new NativeFunction(baseAddr.add(0x1056BCC), "void", ["pointer", "bool", "bool"]);
                        setStateIntensifyFn(sceneThis, 0, 0);
                        log("[🎉 RECOMMEND COMPLETE] Registered " + pickCount + " material cards and refreshed view successfully!");
                    } catch (eRecExec) {
                        log("[-] Error in executeRecommend: " + eRecExec.message);
                    }
                };

                // Diagnostic: dump real runtime state of InvenCardView (sceneView+0x78), its EnhancedScroller and active cells
                var diagCarousel = function(sceneThis) {
                    try {
                        var dGo = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                        var dTr = new NativeFunction(baseAddr.add(0x1DB6A94), "pointer", ["pointer", "pointer"]);
                        var dActSelf = new NativeFunction(baseAddr.add(0x1DBAE44), "bool", ["pointer", "pointer"]);
                        var dActHier = new NativeFunction(baseAddr.add(0x1DBAE84), "bool", ["pointer", "pointer"]);
                        var dEnabled = new NativeFunction(baseAddr.add(0x1DB3CBC), "bool", ["pointer", "pointer"]);
                        var dRect = new NativeFunction(baseAddr.add(0x180D6E0), ["float", "float", "float", "float"], ["pointer", "pointer"]);
                        var dSize = new NativeFunction(baseAddr.add(0x180DB70), ["float", "float"], ["pointer", "pointer"]);
                        var dScale = new NativeFunction(baseAddr.add(0x181DF78), ["float", "float", "float"], ["pointer", "pointer"]);
                        var dPos = new NativeFunction(baseAddr.add(0x180DE48), ["float", "float", "float"], ["pointer", "pointer"]);
                        var dChildCount = new NativeFunction(baseAddr.add(0x181ECF0), "int", ["pointer", "pointer"]);
                        var dColor = new NativeFunction(baseAddr.add(0x1614760), ["float", "float", "float", "float"], ["pointer", "pointer"]);
                        var dTex = new NativeFunction(baseAddr.add(0x194C06C), "pointer", ["pointer", "pointer"]);
                        var f2 = function(a) { return a.map(function(v) { return v.toFixed(1); }).join(","); };
                        var goInfo = function(comp) {
                            if (!comp || comp.isNull()) return "null";
                            var g = dGo(comp, NULL);
                            if (g.isNull()) return "noGO";
                            return "self=" + dActSelf(g, NULL) + " hier=" + dActHier(g, NULL);
                        };
                        var rtInfo = function(rt) {
                            if (!rt || rt.isNull()) return "null";
                            return "rect=[" + f2(dRect(rt, NULL)) + "] size=[" + f2(dSize(rt, NULL)) + "] pos=[" + f2(dPos(rt, NULL)) + "] scale=[" + f2(dScale(rt, NULL)) + "]";
                        };

                        var sceneView = sceneThis.add(0x48).readPointer();
                        var cardView = sceneView.add(0x78).readPointer();
                        log("[🩺 DIAG] cardView=" + cardView + " GO(" + goInfo(cardView) + ") RT " + rtInfo(dTr(cardView, NULL)));
                        log("[🩺 DIAG] baseSizes bg=[" + cardView.add(0x70).readFloat().toFixed(1) + "," + cardView.add(0x74).readFloat().toFixed(1) +
                            "] list=[" + cardView.add(0x78).readFloat().toFixed(1) + "," + cardView.add(0x7C).readFloat().toFixed(1) +
                            "] bgZero=[" + cardView.add(0x80).readFloat().toFixed(1) + "," + cardView.add(0x84).readFloat().toFixed(1) +
                            "] listZero=[" + cardView.add(0x88).readFloat().toFixed(1) + "," + cardView.add(0x8C).readFloat().toFixed(1) +
                            "] maxCount=" + cardView.add(0x98).readS32() + " showLight=" + cardView.add(0x9C).readU8());
                        var bgObj = cardView.add(0x58).readPointer();
                        var listObj = cardView.add(0x60).readPointer();
                        log("[🩺 DIAG] backgroundObj GO(" + goInfo(bgObj) + ") " + rtInfo(bgObj));
                        log("[🩺 DIAG] ListObj GO(" + goInfo(listObj) + ") " + rtInfo(listObj));

                        var scroller = cardView.add(0x40).readPointer();
                        if (scroller.isNull()) { log("[🩺 DIAG] scroller NULL"); return; }
                        log("[🩺 DIAG] scroller GO(" + goInfo(scroller) + ") enabled=" + dEnabled(scroller, NULL) +
                            " delegate=" + scroller.add(0xD8).readPointer() + " scrollRect=" + scroller.add(0xB0).readPointer() +
                            " reload=" + scroller.add(0xE0).readU8() + " scrollPos=" + scroller.add(0x118).readFloat().toFixed(1) +
                            " active[" + scroller.add(0x128).readS32() + ".." + scroller.add(0x12C).readS32() + "] lastRectSize=" + scroller.add(0x14C).readFloat().toFixed(1));
                        log("[🩺 DIAG] scrollRectTransform " + rtInfo(scroller.add(0xB8).readPointer()));
                        var container = scroller.add(0xC8).readPointer();
                        log("[🩺 DIAG] container GO(" + goInfo(container) + ") children=" + (container.isNull() ? -1 : dChildCount(container, NULL)) + " " + rtInfo(container));
                        if (!container.isNull()) {
                            var dGetChild = new NativeFunction(baseAddr.add(0x181F128), "pointer", ["pointer", "int", "pointer"]);
                            var dName = new NativeFunction(baseAddr.add(0x1DC5A54), "pointer", ["pointer", "pointer"]);
                            var nChild = dChildCount(container, NULL);
                            for (var ch = 0; ch < nChild; ch++) {
                                var cT = dGetChild(container, ch, NULL);
                                if (cT.isNull()) continue;
                                var cNm = "";
                                try { cNm = readIl2CppString(dName(cT, NULL)); } catch (eNm) {}
                                log("[🩺 DIAG]  child[" + ch + "] '" + cNm + "' " + cT + " GO(" + goInfo(cT) + ") " + rtInfo(cT));
                            }
                        }
                        var padF = scroller.add(0xF0).readPointer();
                        var padL = scroller.add(0xF8).readPointer();
                        log("[🩺 DIAG] firstPadder=" + padF + " lastPadder=" + padL + " recycledContainer=" + scroller.add(0x100).readPointer());

                        var acv = scroller.add(0x120).readPointer();
                        var acvCount = acv.isNull() ? 0 : acv.add(0x18).readS32();
                        var acvData = acv.isNull() ? NULL : acv.add(0x10).readPointer();
                        log("[🩺 DIAG] activeCellViews count=" + acvCount);
                        for (var i = 0; i < acvCount && i < 16; i++) {
                            var cell = acvData.add(0x20 + i * 8).readPointer();
                            if (cell.isNull()) continue;
                            var item = cell.add(0x38).readPointer();
                            var lsnr = cell.add(0x50).readPointer();
                            var lsnrTarget = (!lsnr.isNull()) ? lsnr.add(0x10).readPointer() : NULL;
                            var lsnrMethod = (!lsnr.isNull()) ? lsnr.add(0x18).readPointer() : NULL;
                            var lsnrRva = (!lsnrMethod.isNull()) ? " RVA 0x" + lsnrMethod.sub(baseAddr).toString(16) : "";
                            var line = "[🩺 DIAG] cell#" + i + " " + cell + " dataIdx=" + cell.add(0x24).readS32() + " GO(" + goInfo(cell) + ") RT " + rtInfo(dTr(cell, NULL)) +
                                " inst=" + cell.add(0x4C).readU8() + " listener=" + lsnr + "(" + lsnrTarget + "," + lsnrMethod + lsnrRva + ") item=" + item;
                            log(line);
                            if (!item.isNull()) {
                                var photo = item.add(0x58).readPointer();
                                var tier = item.add(0x68).readPointer();
                                var eff = item.add(0xC8).readPointer();
                                log("[🩺 DIAG]    item GO(" + goInfo(item) + ") RT " + rtInfo(dTr(item, NULL)) + " params=" + item.add(0x48).readPointer());
                                if (!photo.isNull()) {
                                    var pTex = dTex(photo, NULL);
                                    var pTexNm = (!pTex.isNull()) ? readIl2CppString(dName(pTex, NULL)) : "null";
                                    log("[🩺 DIAG]    photo GO(" + goInfo(photo) + ") en=" + dEnabled(photo, NULL) + " tex=" + pTex + "('" + pTexNm + "') color=[" + f2(dColor(photo, NULL)) + "] " + rtInfo(dTr(photo, NULL)));
                                }
                                if (!tier.isNull()) {
                                    var tTex = dTex(tier, NULL);
                                    var tTexNm = (!tTex.isNull()) ? readIl2CppString(dName(tTex, NULL)) : "null";
                                    log("[🩺 DIAG]    tier GO(" + goInfo(tier) + ") en=" + dEnabled(tier, NULL) + " tex=" + tTex + "('" + tTexNm + "') color=[" + f2(dColor(tier, NULL)) + "]");
                                }
                                if (!eff.isNull()) log("[🩺 DIAG]    ImageEfftect GO(" + goInfo(eff) + ") en=" + dEnabled(eff, NULL) + " " + rtInfo(dTr(eff, NULL)));
                                var itemTr = dTr(item, NULL);
                                if (!itemTr.isNull()) {
                                    var nItemCh = dChildCount(itemTr, NULL);
                                    for (var ic = 0; ic < nItemCh; ic++) {
                                        var icT = dGetChild(itemTr, ic, NULL);
                                        if (icT.isNull()) continue;
                                        var icNm = "";
                                        try { icNm = readIl2CppString(dName(icT, NULL)); } catch (eIn) {}
                                        log("[🩺 DIAG]      itemChild[" + ic + "] '" + icNm + "' " + icT + " GO(" + goInfo(icT) + ") " + rtInfo(icT));
                                    }
                                }
                            }
                        }
                    } catch (eDiag) {
                        log("[-] Error in diagCarousel: " + eDiag.message);
                    }
                };

                var diagMaterialView = function(sceneThis) {
                    try {
                        var dGo = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                        var dTr = new NativeFunction(baseAddr.add(0x1DB6A94), "pointer", ["pointer", "pointer"]);
                        var dActSelf = new NativeFunction(baseAddr.add(0x1DBAE44), "bool", ["pointer", "pointer"]);
                        var dEnabled = new NativeFunction(baseAddr.add(0x1DB3CBC), "bool", ["pointer", "pointer"]);
                        var dRect = new NativeFunction(baseAddr.add(0x180D6E0), ["float", "float", "float", "float"], ["pointer", "pointer"]);
                        var dPos = new NativeFunction(baseAddr.add(0x180DE48), ["float", "float", "float"], ["pointer", "pointer"]);
                        var dSize = new NativeFunction(baseAddr.add(0x180DB70), ["float", "float"], ["pointer", "pointer"]);
                        var dScale = new NativeFunction(baseAddr.add(0x181DF78), ["float", "float", "float"], ["pointer", "pointer"]);
                        var dChildCount = new NativeFunction(baseAddr.add(0x181ECF0), "int", ["pointer", "pointer"]);
                        var dGetChild = new NativeFunction(baseAddr.add(0x181F128), "pointer", ["pointer", "int", "pointer"]);
                        var dName = new NativeFunction(baseAddr.add(0x1DC5A54), "pointer", ["pointer", "pointer"]);
                        var f2 = function(a) { return a.map(function(v) { return v.toFixed(1); }).join(","); };

                        var sceneView = sceneThis.add(0x48).readPointer();
                        if (sceneView.isNull()) return;
                        var intensifyView = sceneView.add(0x68).readPointer();
                        log("[🧪 DIAG MAT] intensifyView=" + intensifyView);
                        if (intensifyView.isNull()) return;

                        var ivGo = dGo(intensifyView, NULL);
                        var ivTr = dTr(intensifyView, NULL);
                        log("[🧪 DIAG MAT] intensifyView: GOact=" + (!ivGo.isNull() ? dActSelf(ivGo, NULL) : false) + " RT pos=[" + f2(dPos(ivTr, NULL)) + "] size=[" + f2(dSize(ivTr, NULL)) + "]");

                        var matList = intensifyView.add(0x40).readPointer();
                        log("[🧪 DIAG MAT] materialList=" + matList);
                        if (matList.isNull()) return;

                        var count = matList.add(0x18).readS32();
                        var items = matList.add(0x10).readPointer();
                        log("[🧪 DIAG MAT] Material slot count=" + count);

                        var dumpTree = function(trNode, depth) {
                            if (trNode.isNull()) return;
                            var indent = "  ";
                            for (var d = 0; d < depth; d++) indent += "  ";
                            var numChildren = dChildCount(trNode, NULL);
                            for (var k = 0; k < numChildren; k++) {
                                var chTr = dGetChild(trNode, k, NULL);
                                var chNm = readIl2CppString(dName(chTr, NULL));
                                var chG = dGo(chTr, NULL);
                                var chAct = (!chG.isNull()) ? dActSelf(chG, NULL) : false;
                                log("[🧪 DIAG MAT]" + indent + "child[" + k + "] '" + chNm + "' act=" + chAct + " pos=[" + f2(dPos(chTr, NULL)) + "] size=[" + f2(dSize(chTr, NULL)) + "]");
                                if (depth < 3) dumpTree(chTr, depth + 1);
                            }
                        };

                        for (var i = 0; i < count; i++) {
                            var matView = items.add(0x20 + i * 8).readPointer();
                            if (matView.isNull()) continue;
                            var emptyImg = matView.add(0x38).readPointer();
                            var effectGo = matView.add(0x40).readPointer();
                            var enabledGo = matView.add(0x48).readPointer();
                            var flowName = matView.add(0x50).readPointer();
                            var cardSmall = matView.add(0x58).readPointer();
                            var mountGo = matView.add(0x60).readPointer();

                            var tr = dTr(matView, NULL);
                            log("[🧪 DIAG MAT] Slot[" + i + "]: matView=" + matView + " RT pos=[" + f2(dPos(tr, NULL)) + "] size=[" + f2(dSize(tr, NULL)) + "]");
                            if (!emptyImg.isNull()) {
                                var eGo = dGo(emptyImg, NULL);
                                var eTr = dTr(emptyImg, NULL);
                                var eSpr = emptyImg.add(0xD8).readPointer();
                                log("[🧪 DIAG MAT]   emptyImg: en=" + dEnabled(emptyImg, NULL) + " GOact=" + (!eGo.isNull() ? dActSelf(eGo, NULL) : false) +
                                    " sprite=" + eSpr + " size=[" + f2(dSize(eTr, NULL)) + "] pos=[" + f2(dPos(eTr, NULL)) + "]");
                            }
                            dumpTree(tr, 1);
                        }
                    } catch (eDm) {
                        log("[-] Error in diagMaterialView: " + eDm.message);
                    }
                };

                // 9e2. InventoryScene.SetStateMain (0x1053FB0) -> Safe replacement preventing null crash chain
                function safeSetStateMain(sceneThis, isReload) {
                    log("[🗃️ SET_STATE_MAIN] safeSetStateMain entered! isReload=" + isReload + ", scene=" + sceneThis);
                    try {
                        if (sceneThis.isNull()) return;
                        activeInventorySceneInstance = sceneThis;
                        sceneThis.add(0x24).writeS32(6); // InventoryScene.STATE.Main = 6
                        ensureMaterialCardItemList(sceneThis);

                        var selectedCardItem = sceneThis.add(0x88).readPointer();
                        if (selectedCardItem.isNull()) {
                            log("[-] SET_STATE_MAIN: selectedCardItem is null - aborting safe!");
                            return;
                        }

                        var rawCard = selectedCardItem.add(0x10).readPointer();
                        if (rawCard.isNull()) {
                            log("[-] SET_STATE_MAIN: raw card data is null - aborting safe!");
                            return;
                        }

                        var cId = rawCard.add(0x20).readS32();
                        var gr = rawCard.add(0x24).readS32();
                        var lvl = rawCard.add(0x1C).readS16();
                        var isEq = (rawCard.add(0x28).readU8() === 1);
                        var isLk = (rawCard.add(0x29).readU8() === 1);
                        var isPrism = (rawCard.add(0x2A).readU8() === 1);

                        var meta = getCardMetadata(cId);
                        var memberIdx = (meta.artistID >= 1000) ? (meta.artistID - 1000) : meta.artistID;
                        if (memberIdx < 1 || memberIdx > 11) memberIdx = ((cId - 1001) % 11) + 1;
                        var artistData = loonaArtistDataMap[memberIdx] || NULL;

                        // Ensure selectedArtistData (0x80) is populated
                        if (sceneThis.add(0x80).readPointer().isNull() && artistData && !artistData.isNull()) {
                            sceneThis.add(0x80).writePointer(artistData);
                        }

                        log("[🗃️ SET_STATE_MAIN] Card: id=" + cId + ", gr=" + gr + ", lvl=" + lvl + ", theme=" + meta.theme + ", eq=" + isEq);

                        // Find equippedCardItem for this member slot
                        var mSlot = memberIdx - 1;
                        var equippedCardItem = NULL;
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                try {
                                    var r = itm.add(0x10).readPointer();
                                    if (!r.isNull()) {
                                        var cid2 = r.add(0x20).readS32();
                                        var isE2 = (r.add(0x28).readU8() === 1);
                                        var cMeta2 = getCardMetadata(cid2);
                                        if (cMeta2.artistID === meta.artistID && isE2) {
                                            equippedCardItem = itm;
                                        }
                                    }
                                } catch (eEcl) {}
                            }
                        }
                        sceneThis.add(0x90).writePointer((equippedCardItem && !equippedCardItem.isNull()) ? equippedCardItem : NULL);

                        // Get scene view and drive refresh on the SelectView
                        try {
                            var sceneView = sceneThis.add(0x48).readPointer(); // InventoryScene.sceneView (InventoryView)
                            if (!sceneView.isNull()) {
                                // 1. Call ShowMainLayout(isSelectedItem=true) -> RVA 0x10571EC
                                try {
                                    var showMainLayoutFn = new NativeFunction(baseAddr.add(0x10571EC), "void", ["pointer", "int", "pointer"]);
                                    showMainLayoutFn(sceneView, 1, NULL);
                                    log("[✅ SET_STATE_MAIN] ShowMainLayout(true) called!");
                                } catch (eSml) { log("[-] Error calling ShowMainLayout: " + eSml.message); }

                                // 2. Correct InventoryView field offsets (from dump.cs):
                                //    selectView=0x48, noneView=0x50, mainView=0x58, equipView=0x60
                                var mainView = sceneView.add(0x58).readPointer();
                                var selectView = sceneView.add(0x48).readPointer();

                                // 3. Refresh InvenCardMainView (our replaced function handles it safely)
                                if (!mainView.isNull()) {
                                    try {
                                        var getMainDataFn = new NativeFunction(baseAddr.add(0x105751C), "pointer", ["pointer", "pointer", "int", "pointer"]);
                                        var mainParams = getMainDataFn(sceneThis, selectedCardItem, 0, NULL);
                                        if (!mainParams.isNull()) {
                                            safeRefreshInvenCardMainView(mainView, mainParams);
                                            log("[✅ SET_STATE_MAIN] InvenCardMainView refreshed!");
                                        }
                                    } catch (eMvr) { log("[-] Error refreshing mainView: " + eMvr.message); }
                                }

                                // 4. Refresh InvenCardSelectView (our replaced function handles it safely)
                                if (!selectView.isNull()) {
                                    try {
                                        var selectParams = safeGetSelectViewData(sceneThis, selectedCardItem, NULL, (equippedCardItem && !equippedCardItem.isNull()) ? equippedCardItem : NULL, 0);
                                        safeRefreshInvenCardSelectView(selectView, selectParams);
                                        log("[✅ SET_STATE_MAIN] InvenCardSelectView refreshed!");
                                    } catch (eSvr) { log("[-] Error refreshing selectView: " + eSvr.message); }
                                }

                                // 5. Update lower card carousel (InvenCardView @ sceneView + 0x78) with member + theme filtered cards
                                safeUpdateLowerCarousel(sceneThis, selectedCardItem);
                            }
                        } catch (eSvErr) {
                            log("[-] Error driving scene view refresh: " + eSvErr.message);
                        }

                        log("[✅ SET_STATE_MAIN] Safe SetStateMain completed for cardID=" + cId + ", theme=" + meta.theme);
                    } catch (eSetState) {
                        log("[-] Error in safeSetStateMain: " + eSetState.message);
                    }
                }

                try {
                    Interceptor.replace(baseAddr.add(0x1053FB0), new NativeCallback(function (sceneThis, isReload, methodInfo) {
                        safeSetStateMain(sceneThis, isReload);
                    }, "void", ["pointer", "bool", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.SetStateMain (0x1053FB0)!");
                } catch (eSsmHook) {
                    log("[-] Error replacing SetStateMain: " + eSsmHook.message);
                }

                // Hook InventoryScene.SetStateDefault (0x1053B88) to protect null pointer crash & restore cards
                try {
                    Interceptor.attach(baseAddr.add(0x1053B88), {
                        onEnter: function (args) {
                            this.scene = args[0];
                            if (!this.scene.isNull()) {
                                log("[🗃️ SET_STATE_DEFAULT] onEnter triggered, verifying materialCardItemList");
                                ensureMaterialCardItemList(this.scene);
                            }
                        },
                        onLeave: function (retval) {
                            if (this.scene && !this.scene.isNull()) {
                                log("[🗃️ SET_STATE_DEFAULT] onLeave triggered, restoring all 24 cards to displayCardList!");
                                restoreDefaultDisplayCardList(this.scene, true, true);
                            }
                        }
                    });
                    log("[+] Interceptor.attach installed on InventoryScene.SetStateDefault (0x1053B88)!");
                } catch (eSsdHook) {
                    log("[-] Error attaching to SetStateDefault: " + eSsdHook.message);
                }

                // Centralized and bulletproof handleInventoryBack
                var handleInventoryBack = function (sceneThis) {
                    try {
                        if (!sceneThis || sceneThis.isNull()) return;
                        var curState = sceneThis.add(0x24).readS32();
                        log("[🔙 ON_BACK] handleInventoryBack entered! state=" + curState);

                        if (curState === 6 || curState === 7) { // STATE.Main (6) or STATE.Equip (7)
                            log("[🔙 ON_BACK] Returning from detail/equip view to Default state, restoring 24 cards...");
                            sceneThis.add(0x24).writeS32(5); // STATE.Default = 5
                            sceneThis.add(0x88).writePointer(NULL); // selectedCardItem
                            sceneThis.add(0x98).writePointer(NULL); // preSelectedCardItem
                            sceneThis.add(0x80).writePointer(NULL); // selectedArtistData
                            sceneThis.add(0x90).writePointer(NULL); // equippedCardItem
                            sceneThis.add(0xBC).writeU8(0);
                            sceneThis.add(0xBE).writeU8(0);
                            sceneThis.add(0x50).writeS32(0); // extractType = All

                            var sceneView = sceneThis.add(0x48).readPointer();
                            if (!sceneView.isNull()) {
                                // 1. ShowDefaultLayout -> RVA 0x1055ED0
                                try {
                                    var showDefFn = new NativeFunction(baseAddr.add(0x1055ED0), "void", ["pointer", "pointer"]);
                                    showDefFn(sceneView, NULL);
                                    log("[✅ ON_BACK] ShowDefaultLayout executed!");
                                } catch (eSdl) {
                                    log("[-] Error in ShowDefaultLayout: " + eSdl.message);
                                }

                                // 2. Refresh & JumpToDataIndex on groupView (0x70)
                                try {
                                    var groupView = sceneView.add(0x70).readPointer();
                                    if (!groupView.isNull()) {
                                        var invenGroupRefreshFn = new NativeFunction(baseAddr.add(0xF25124), "void", ["pointer", "pointer"]);
                                        invenGroupRefreshFn(groupView, NULL);
                                        var invenGroupJumpFn = new NativeFunction(baseAddr.add(0xF25140), "void", ["pointer", "int", "bool", "pointer"]);
                                        invenGroupJumpFn(groupView, 0, 0, NULL);
                                        log("[✅ ON_BACK] InvenGroupView.Refresh and JumpToDataIndex executed!");
                                    }
                                } catch (eGv) {
                                    log("[-] Error in InvenGroupView refresh: " + eGv.message);
                                }

                                // 3. Restore displayCardList (sets 24 cards and calls InvenCardView.SetData in 0xF23384)
                                restoreDefaultDisplayCardList(sceneThis, true);
                            }
                        } else if (curState === 5) { // STATE.Default (5)
                            log("[🔙 ON_BACK] Leaving InventoryScene, navigating back to LobbyScene (SceneId: 3)...");
                            try {
                                var setStateOpenSceneFn = new NativeFunction(baseAddr.add(0xD5338C), 'void', ['pointer', 'int', 'pointer', 'pointer', 'pointer']);
                                setStateOpenSceneFn(sceneThis, 3, NULL, NULL, NULL);
                            } catch (eOpen) {
                                log("[-] Error returning to LobbyScene via SetStateOpenScene: " + eOpen.message);
                                try {
                                    var openSceneDirectFn = new NativeFunction(baseAddr.add(0xD534BC), "void", ["int", "pointer", "pointer"]);
                                    openSceneDirectFn(3, NULL, NULL);
                                } catch (eOsd) {}
                            }
                        }
                    } catch (eOb) {
                        log("[-] Error in handleInventoryBack: " + eOb.message);
                    }
                };

                // Replace InventoryScene.OnBack (0x10537F4) to ensure clean restoration and prevent null crash chain
                try {
                    Interceptor.replace(baseAddr.add(0x10537F4), new NativeCallback(function (sceneThis, methodInfo) {
                        handleInventoryBack(sceneThis);
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.OnBack (0x10537F4)!");
                } catch (eObHook) {
                    log("[-] Error replacing OnBack: " + eObHook.message);
                }

                // Direct transition to CardBookScene (SceneId: 5) avoiding crash in uninitialized SelectMyCollectionPopup
                try {
                    Interceptor.replace(baseAddr.add(0xACC8B8), new NativeCallback(function (callback, openCallBack, methodInfo) {
                        log("[📖 CARDBOOK] Intercepted ViewControl.OpenMyCollectionPopupOrCardBookScene -> Direct SceneControl.OpenScene(5)!");
                        var openSceneFn = new NativeFunction(baseAddr.add(0xD534BC), "void", ["int", "pointer", "pointer", "pointer"]);
                        openSceneFn(5, NULL, NULL, NULL);
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on ViewControl.OpenMyCollectionPopupOrCardBookScene (0xACC8B8)!");
                } catch (eCbDirect) {
                    log("[-] Error replacing OpenMyCollectionPopupOrCardBookScene: " + eCbDirect.message);
                }

                try {
                    Interceptor.replace(baseAddr.add(0x105DE08), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[📖 CARDBOOK] Intercepted InventoryScene.OnMyCollection -> Direct SceneControl.OpenScene(5)!");
                        var openSceneFn = new NativeFunction(baseAddr.add(0xD534BC), "void", ["int", "pointer", "pointer", "pointer"]);
                        openSceneFn(5, NULL, NULL, NULL);
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.OnMyCollection (0x105DE08)!");
                } catch (eInvenCol) {
                    log("[-] Error replacing InventoryScene.OnMyCollection: " + eInvenCol.message);
                }

                try {
                    Interceptor.replace(baseAddr.add(0xB4C628), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[📖 CARDBOOK] Intercepted LobbyScene.OnMyCollection -> Direct SceneControl.OpenScene(5)!");
                        var openSceneFn = new NativeFunction(baseAddr.add(0xD534BC), "void", ["int", "pointer", "pointer", "pointer"]);
                        openSceneFn(5, NULL, NULL, NULL);
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on LobbyScene.OnMyCollection (0xB4C628)!");
                } catch (eLobbyCol) {
                    log("[-] Error replacing LobbyScene.OnMyCollection: " + eLobbyCol.message);
                }

                // 9e3. InventoryScene.ExtractWithArtist (0x1058158) -> Strict filtering by member AND theme/song
                try {
                    var extractWithArtistAddr = baseAddr.add(0x1058158);
                    Interceptor.replace(extractWithArtistAddr, new NativeCallback(function (sceneThis, isGroup, cardItem, methodInfo) {
                        try {
                            if (sceneThis.isNull() || cardItem.isNull()) return;

                            var selectedCardItem = sceneThis.add(0x88).readPointer();
                            if (selectedCardItem.isNull()) return;

                            var selRaw = selectedCardItem.add(0x10).readPointer();
                            var cardRaw = cardItem.add(0x10).readPointer();
                            if (selRaw.isNull() || cardRaw.isNull()) return;

                            var selObjIdStr = selRaw.add(0x10).readS64().toString();
                            var cardObjIdStr = cardRaw.add(0x10).readS64().toString();

                            // Exclude the currently inspected card itself (Dalcom standard: compare ObjectID)
                            if (selObjIdStr === cardObjIdStr) return;

                            var selCardId = selRaw.add(0x20).readS32();
                            var cardId = cardRaw.add(0x20).readS32();

                            var selMeta = getCardMetadata(selCardId);
                            var cardMeta = getCardMetadata(cardId);

                            var selArtistID = selMeta.artistID;
                            var cardArtistID = cardMeta.artistID;
                            var selTheme = selMeta.theme;
                            var cardTheme = cardMeta.theme;

                            // Strict Filter:
                            // 1. Same Member (artistID)
                            // 2. Same Theme / Song (theme)
                            if (selArtistID !== cardArtistID) return;
                            if (selTheme !== cardTheme) return;

                            // Add card to displayCardList via native AddCardItem (0x1057FF0)
                            var addCardItemFn = new NativeFunction(baseAddr.add(0x1057FF0), "void", ["pointer", "int", "pointer", "pointer"]);
                            addCardItemFn(sceneThis, isGroup, cardItem, NULL);
                            log("[🃏 EXTRACT_ARTIST] Added card: id=" + cardId + ", obj=" + cardObjIdStr + ", theme=" + cardTheme + ", artist=" + cardArtistID);
                        } catch (eEwa) {
                            log("[-] Error in ExtractWithArtist: " + eEwa.message);
                        }
                    }, "void", ["pointer", "int", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.ExtractWithArtist (0x1058158) - STRICT MEMBER & THEME FILTER!");
                } catch (eHewa) {
                    log("[-] Error replacing ExtractWithArtist: " + eHewa.message);
                }



                // Native Texture2D loader with disk cache (available to cell views and SetCdnTexture)
                var loadedTextureCache = {};

                function loadLocalTexture2D(relPath) {
                    if (loadedTextureCache[relPath]) {
                        var cached = loadedTextureCache[relPath];
                        try {
                            if (!cached.isNull()) {
                                var m_CachedPtr = cached.add(0x10).readPointer();
                                if (!m_CachedPtr.isNull()) {
                                    return cached;
                                }
                            }
                            log("[⚠️ TEXTURE] Cached Texture2D native m_CachedPtr was null/destroyed! Evicting: " + relPath);
                        } catch (eCheck) {
                            log("[⚠️ TEXTURE] Error checking cached ptr: " + eCheck.message);
                        }
                        delete loadedTextureCache[relPath];
                    }
                    try {
                        var basePath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/";
                        var fullPath = basePath + relPath;

                        var fileExistsFn = new NativeFunction(baseAddr.add(0x1F01DF4), "bool", ["pointer", "pointer"]);
                        var fileReadAllBytesFn = new NativeFunction(baseAddr.add(0x1F0268C), "pointer", ["pointer", "pointer"]);

                        var pathStr = createIl2CppString(fullPath);
                        var exists = fileExistsFn(pathStr, NULL);

                        if (!exists) {
                            fullPath = fullPath + ".png";
                            pathStr = createIl2CppString(fullPath);
                            exists = fileExistsFn(pathStr, NULL);
                        }

                        if (!exists && relPath.indexOf(".i.bytes") !== -1) {
                            fullPath = basePath + relPath.replace(".i.bytes", ".png");
                            pathStr = createIl2CppString(fullPath);
                            exists = fileExistsFn(pathStr, NULL);
                        }

                        if (!exists && relPath.indexOf("wadceg/") !== -1) {
                            var altPath = relPath.replace("wadceg/", "weoihxd/");
                            fullPath = basePath + altPath;
                            pathStr = createIl2CppString(fullPath);
                            exists = fileExistsFn(pathStr, NULL);
                            if (!exists) {
                                fullPath = fullPath + ".png";
                                pathStr = createIl2CppString(fullPath);
                                exists = fileExistsFn(pathStr, NULL);
                            }
                        }

                        if (!exists && relPath.indexOf("weoihxd/") !== -1) {
                            var altPath = relPath.replace("weoihxd/", "wadceg/");
                            fullPath = basePath + altPath;
                            pathStr = createIl2CppString(fullPath);
                            exists = fileExistsFn(pathStr, NULL);
                            if (!exists) {
                                fullPath = fullPath + ".png";
                                pathStr = createIl2CppString(fullPath);
                                exists = fileExistsFn(pathStr, NULL);
                            }
                        }

                        if (!exists) {
                            log("[-] loadLocalTexture2D: file does not exist: " + relPath);
                            return NULL;
                        }

                        var bytesObj = fileReadAllBytesFn(pathStr, NULL);
                        if (!bytesObj || bytesObj.isNull()) {
                            log("[-] loadLocalTexture2D: ReadAllBytes returned null for: " + fullPath);
                            return NULL;
                        }

                        // Create Texture2D(2, 2)
                        var tex2dClass = getClass("UnityEngine.CoreModule", "UnityEngine", "Texture2D");
                        if (!tex2dClass || tex2dClass.isNull()) return NULL;
                        var texObj = il2cpp_object_new(tex2dClass);
                        if (!texObj || texObj.isNull()) return NULL;

                        var texCtorFn = new NativeFunction(baseAddr.add(0x181B6BC), "void", ["pointer", "int", "int", "pointer"]);
                        texCtorFn(texObj, 2, 2, NULL);

                        // ImageConversion.LoadImage(texObj, bytesObj, NULL) -> RVA 0x25B3E90
                        var loadImageFn = new NativeFunction(baseAddr.add(0x25B3E90), "bool", ["pointer", "pointer", "pointer"]);
                        var ok = loadImageFn(texObj, bytesObj, NULL);
                        if (ok) {
                            try {
                                var setFilterModeFn = new NativeFunction(baseAddr.add(0x181A580), "void", ["pointer", "int", "pointer"]);
                                setFilterModeFn(texObj, 2, NULL); // FilterMode.Trilinear = 2
                                var setAnisoFn = new NativeFunction(baseAddr.add(0x181A610), "void", ["pointer", "int", "pointer"]);
                                setAnisoFn(texObj, 8, NULL);
                            } catch (eFm) {}

                            // GC Pin and persist texture to avoid placeholder reversion
                            try {
                                if (il2cpp_gchandle_new) {
                                    il2cpp_gchandle_new(texObj, 2); // 2 = Pinned handle
                                }
                                var dontDestroyOnLoadFn = new NativeFunction(baseAddr.add(0x1DC7FB4), "void", ["pointer", "pointer"]);
                                dontDestroyOnLoadFn(texObj, NULL);
                                var setHideFlagsFn = new NativeFunction(baseAddr.add(0x1DC7FF4), "void", ["pointer", "int", "pointer"]);
                                setHideFlagsFn(texObj, 52, NULL); // 52 = DontSaveInEditor | DontSaveInBuild | DontUnloadUnusedAsset
                            } catch (ePin) {
                                log("[-] Error pinning texture " + relPath + ": " + ePin.message);
                            }

                            loadedTextureCache[relPath] = texObj;
                            log("[🖼️ TEXTURE] Loaded and cached (Pinned/DontDestroy): " + relPath);
                            return texObj;
                        } else {
                            log("[-] LoadImage returned false for " + relPath);
                        }
                    } catch (eLt) {
                        log("[-] Error in loadLocalTexture2D for " + relPath + ": " + eLt.message);
                    }
                    return NULL;
                }

                // 9e5. InventoryScene.<UpdateDisplayCardList>b__63_0 (0x105F448) -> Safe cell data provider preventing IndexOutOfRangeException
                try {
                    var getSmallCardViewDataFn = new NativeFunction(baseAddr.add(0xABEB30), "pointer", ["pointer", "pointer", "bool", "pointer"]);
                    Interceptor.replace(baseAddr.add(0x105F448), new NativeCallback(function (sceneThis, view, index, methodInfo) {
                        try {
                            if (sceneThis.isNull()) {
                                sceneThis = (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) ? activeInventorySceneInstance : NULL;
                            }
                            if (!sceneThis || sceneThis.isNull()) return NULL;
                            var dclPtr = sceneThis.add(0x58).readPointer();
                            if (dclPtr.isNull()) return NULL;
                            var size = dclPtr.add(0x18).readS32();
                            log("[🎠 B63] index=" + index + ", size=" + size + ", view=" + view + ", scene=" + sceneThis);
                            if (index < 0 || index >= size) return NULL; // Bounds protection against EnhancedScroller race/reclaim

                            var listItems = dclPtr.add(0x10).readPointer();
                            if (listItems.isNull()) return NULL;
                            var cardItem = listItems.add(0x20 + index * 8).readPointer();
                            if (cardItem.isNull()) return NULL;

                            var cardRaw = cardItem.add(0x10).readPointer();
                            var cId = (!cardRaw.isNull()) ? cardRaw.add(0x20).readS32() : 1001;
                            var gr = (!cardRaw.isNull()) ? cardRaw.add(0x24).readS32() : 4;
                            var lvl = (!cardRaw.isNull()) ? cardRaw.add(0x1C).readS16() : 50;

                            // Equipped check
                            var isCardEquipped = 0;
                            var eqItem = sceneThis.add(0x90).readPointer();
                            if (!eqItem.isNull()) {
                                var eqRaw = eqItem.add(0x10).readPointer();
                                if (!eqRaw.isNull() && !cardRaw.isNull()) {
                                    if (eqRaw.add(0x10).readS64().toString() === cardRaw.add(0x10).readS64().toString()) {
                                        isCardEquipped = 1;
                                    }
                                }
                            } else if (!cardRaw.isNull()) {
                                isCardEquipped = (cardRaw.add(0x28).readU8() === 1) ? 1 : 0;
                            }

                            // Clean CardSmallView.Params with isStencil=0, isGray=0
                            var viewData = createMockSmallCardParams(cId, gr, lvl, isCardEquipped);
                            if (!viewData || viewData.isNull()) {
                                viewData = getSmallCardViewDataFn(cardItem, NULL, 0, NULL);
                            }

                            // Deactivate visual artifacts & ensure active tier & photo visibility on cell view
                            if (!view.isNull()) {
                                try {
                                    // 1. Deactivate ImageEfftect (the horizontal gray line [-] artifact)
                                    var imgEff = view.add(0xC8).readPointer();
                                    if (!imgEff.isNull()) {
                                        var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                        var setActFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                                        var effGo = getGoFn(imgEff, NULL);
                                        if (!effGo.isNull()) setActFn(effGo, 0, NULL);
                                    }
                                } catch (eEff) {}

                                try {
                                    // 2. Ensure Photo and Tier frame visibility & textures
                                    var setPhotoVisFn = new NativeFunction(baseAddr.add(0x138F3A0), "void", ["pointer", "int", "pointer"]);
                                    setPhotoVisFn(view, 1, NULL);
                                    var setTierVisFn = new NativeFunction(baseAddr.add(0x1393AAC), "void", ["pointer", "int", "pointer"]);
                                    setTierVisFn(view, 1, NULL);

                                    var setTextureFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                    var setEnabledFn = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                                    var getGoFn2 = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                    var setActFn2 = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);

                                    var photoRawImg = view.add(0x58).readPointer();
                                    if (!photoRawImg.isNull()) {
                                        var photoTex = loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_l.i.bytes") ||
                                                       loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_s.i.bytes");
                                        if (photoTex && !photoTex.isNull()) {
                                            setTextureFn(photoRawImg, photoTex, NULL);
                                            setEnabledFn(photoRawImg, 1, NULL);
                                            var pGo = getGoFn2(photoRawImg, NULL);
                                            if (!pGo.isNull()) setActFn2(pGo, 1, NULL);

                                            // Calibrate photo dimensions to BasicSize (92, 130)
                                            try {
                                                var getRectTrFn = new NativeFunction(baseAddr.add(0x1614EF0), "pointer", ["pointer", "pointer"]);
                                                var setSizeDeltaFn = new NativeFunction(baseAddr.add(0x180DC18), "void", ["pointer", "float", "float", "pointer"]);
                                                var photoRectTr = getRectTrFn(photoRawImg, NULL);
                                                if (!photoRectTr.isNull()) {
                                                    setSizeDeltaFn(photoRectTr, 92.0, 130.0, NULL);
                                                }
                                            } catch (ePsz) {}
                                        }
                                    }

                                    var tierRawImg = view.add(0x68).readPointer();
                                    if (!tierRawImg.isNull()) {
                                        var gLetter = (gr === 4) ? "r" : (gr === 3) ? "s" : (gr === 2) ? "a" : (gr === 1) ? "b" : "c";
                                        var tierTex = loadLocalTexture2D("asiudgasg/asodhsg/aoeiwhslc/uhex/0_" + gLetter + "_s.i.bytes");
                                        if (tierTex && !tierTex.isNull()) {
                                            setTextureFn(tierRawImg, tierTex, NULL);
                                            setEnabledFn(tierRawImg, 1, NULL);
                                            var tGo = getGoFn2(tierRawImg, NULL);
                                            if (!tGo.isNull()) setActFn2(tGo, 1, NULL);

                                            // Set native size (116x156) for tier frame
                                            try {
                                                var setNativeSizeFn = new NativeFunction(baseAddr.add(0x194C1C8), "void", ["pointer", "pointer"]);
                                                setNativeSizeFn(tierRawImg, NULL);
                                            } catch (eSns) {}
                                        }
                                    }

                                    // 3. Set Star vs Number level display
                                    var setStarVisFn = new NativeFunction(baseAddr.add(0x1388C58), "void", ["pointer", "int", "pointer"]);
                                    var setNumVisFn = new NativeFunction(baseAddr.add(0x1393D68), "void", ["pointer", "int", "pointer"]);
                                    if (gr === 4) {
                                        setStarVisFn(view, 0, NULL);
                                        setNumVisFn(view, 1, NULL);
                                    } else {
                                        setStarVisFn(view, 1, NULL);
                                        setNumVisFn(view, 0, NULL);
                                    }
                                } catch (eVs) {}
                            }

                            return viewData;
                        } catch (eB63) {
                            log("[-] Error in b__63_0: " + eB63.message);
                            return NULL;
                        }
                    }, "pointer", ["pointer", "pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.<UpdateDisplayCardList>b__63_0 (0x105F448)!");
                } catch (eB63Hook) {
                    log("[-] Error replacing <UpdateDisplayCardList>b__63_0: " + eB63Hook.message);
                }

                // InvenCardCellView.SetData (0xF21510) -> Ensure listener at offset 0x50 is preserved across cell reuse
                try {
                    Interceptor.attach(baseAddr.add(0xF21510), {
                        onEnter: function (args) {
                            var cell = args[0];
                            var lsnr = args[1];
                            if (!cell.isNull() && !lsnr.isNull()) {
                                cell.add(0x50).writePointer(lsnr);
                            }
                        }
                    });
                    log("[+] Interceptor.attach installed on InvenCardCellView.SetData (0xF21510)!");
                } catch (eHsd) {
                    log("[-] Error attaching to InvenCardCellView.SetData: " + eHsd.message);
                }

                // InvenCardCellView.RefreshCellView (0xF2136C) -> Bulletproof cell renderer invoking updateSingleCell directly
                try {
                    Interceptor.replace(baseAddr.add(0xF2136C), new NativeCallback(function (cell, methodInfo) {
                        try {
                            if (cell.isNull()) return;

                            var dataIdx = cell.add(0x24).readS32();
                            var scene = (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) ? activeInventorySceneInstance : NULL;
                            var cardItem = NULL;
                            if (scene && !scene.isNull()) {
                                var dclPtr = scene.add(0x58).readPointer();
                                if (!dclPtr.isNull()) {
                                    var size = dclPtr.add(0x18).readS32();
                                    if (dataIdx >= 0 && dataIdx < size) {
                                        var listItems = dclPtr.add(0x10).readPointer();
                                        if (!listItems.isNull()) {
                                            cardItem = listItems.add(0x20 + dataIdx * 8).readPointer();
                                        }
                                    }
                                }
                            }
                            var curState = (scene && !scene.isNull()) ? scene.add(0x24).readS32() : 5;
                            var isInspected = (curState === 6 && dataIdx === 0);
                            if (cardItem && !cardItem.isNull()) {
                                var getGoFnBase = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                var setActFnBase = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                                var cGo = getGoFnBase(cell, NULL);
                                if (!cGo.isNull()) setActFnBase(cGo, 1, NULL);
                                updateSingleCell(cell, cardItem, dataIdx, isInspected);
                            } else {
                                var getGoFnBase = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                var setActFnBase = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                                var cGo = getGoFnBase(cell, NULL);
                                if (!cGo.isNull()) setActFnBase(cGo, 0, NULL);
                            }
                        } catch (eRcv) {
                            log("[-] Error in RefreshCellView replacement: " + eRcv.message);
                        }
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InvenCardCellView.RefreshCellView (0xF2136C)!");
                } catch (eHrcv) {
                    log("[-] Error replacing InvenCardCellView.RefreshCellView: " + eHrcv.message);
                }

                // InvenCardCellView.set_LightVisible (0xF21424) -> Suppress white light overlay permanently
                try {
                    Interceptor.replace(baseAddr.add(0xF21424), new NativeCallback(function (cell, val, methodInfo) {
                        if (cell.isNull()) return;
                        cell.add(0x60).writeU8(0);
                        try {
                            var lightImg = cell.add(0x58).readPointer();
                            if (!lightImg.isNull()) {
                                var getGoFnBase = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                var setActFnBase = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                                var setEnabledFn = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                                setEnabledFn(lightImg, 0, NULL);
                                var lGo = getGoFnBase(lightImg, NULL);
                                if (!lGo.isNull()) setActFnBase(lGo, 0, NULL);
                            }
                        } catch (e) {}
                    }, "void", ["pointer", "bool", "pointer"]));
                    log("[+] Interceptor.replace installed on InvenCardCellView.set_LightVisible (0xF21424)!");
                } catch (eSlvHook) {
                    log("[-] Error replacing set_LightVisible: " + eSlvHook.message);
                }

                // Trace: EnhancedScroller.ReloadData (0x125C640) -> correlate scroller reloads with cell generation
                try {
                    Interceptor.attach(baseAddr.add(0x125C640), {
                        onEnter: function (args) {
                            this.sc = args[0];
                        },
                        onLeave: function () {
                            try {
                                var sc = this.sc;
                                var acv = sc.add(0x120).readPointer();
                                log("[🔁 RELOAD] scroller=" + sc + " delegate=" + sc.add(0xD8).readPointer() + " active[" + sc.add(0x128).readS32() + ".." + sc.add(0x12C).readS32() + "] acv=" + (acv.isNull() ? -1 : acv.add(0x18).readS32()) + " lastRectSize=" + sc.add(0x14C).readFloat().toFixed(1));
                            } catch (eRl) {}
                        }
                    });
                } catch (eRlH) {
                    log("[-] Error tracing ReloadData: " + eRlH.message);
                }

                // 9e6. CardView.get_IsMaterialCard (0x13939A8) -> Safe null check protection
                try {
                    Interceptor.replace(baseAddr.add(0x13939A8), new NativeCallback(function (thisPtr, methodInfo) {
                        try {
                            if (thisPtr.isNull()) return 0;
                            var p = thisPtr.add(0x48).readPointer();
                            if (p.isNull()) return 0;
                            return p.add(0x4C).readU8();
                        } catch (eImc) {
                            return 0;
                        }
                    }, "int", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardView.get_IsMaterialCard (0x13939A8)!");
                } catch (eImcHook) {
                    log("[-] Error replacing CardView.get_IsMaterialCard: " + eImcHook.message);
                }

                // 9e7. Bulletproof CardItem getters against null references
                try {
                    // get_IsReflection (0xB55EC0)
                    Interceptor.replace(baseAddr.add(0xB55EC0), new NativeCallback(function(thisPtr) {
                        try {
                            if (!thisPtr || thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (!raw || raw.isNull()) return 0;
                            var gr = raw.add(0x24).readS32();
                            return (gr > 1) ? 1 : 0;
                        } catch (e) { return 0; }
                    }, "bool", ["pointer"]));

                    // get_IsPrism (0xB55EA4)
                    Interceptor.replace(baseAddr.add(0xB55EA4), new NativeCallback(function(thisPtr) {
                        try {
                            if (!thisPtr || thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (!raw || raw.isNull()) return 0;
                            return raw.add(0x2A).readU8();
                        } catch (e) { return 0; }
                    }, "bool", ["pointer"]));

                    // get_IsGlow (0xB55EE4)
                    Interceptor.replace(baseAddr.add(0xB55EE4), new NativeCallback(function(thisPtr) {
                        try {
                            if (!thisPtr || thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (!raw || raw.isNull()) return 0;
                            var gr = raw.add(0x24).readS32();
                            return (gr > 2) ? 1 : 0;
                        } catch (e) { return 0; }
                    }, "bool", ["pointer"]));

                    // get_IsMaterialCard (0xB55F08) -> false for regular idol cards
                    Interceptor.replace(baseAddr.add(0xB55F08), new NativeCallback(function(thisPtr) {
                        return 0;
                    }, "bool", ["pointer"]));

                    // get_IsRCard (0xB523E4)
                    Interceptor.replace(baseAddr.add(0xB523E4), new NativeCallback(function(thisPtr) {
                        try {
                            if (!thisPtr || thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (!raw || raw.isNull()) return 0;
                            return (raw.add(0x24).readS32() === 4) ? 1 : 0;
                        } catch (e) { return 0; }
                    }, "bool", ["pointer"]));

                    // get_IsMaxLevel (0xB52408)
                    Interceptor.replace(baseAddr.add(0xB52408), new NativeCallback(function(thisPtr) {
                        try {
                            if (!thisPtr || thisPtr.isNull()) return 0;
                            var raw = thisPtr.add(0x10).readPointer();
                            if (!raw || raw.isNull()) return 0;
                            var gr = raw.add(0x24).readS32();
                            var lvl = raw.add(0x1C).readS16();
                            var maxLvl = (gr === 4) ? 50 : 5;
                            return (lvl >= maxLvl) ? 1 : 0;
                        } catch (e) { return 0; }
                    }, "bool", ["pointer"]));

                    log("[+] Safe CardItem getters installed!");
                } catch (eSafeCi) {
                    log("[-] Error installing safe CardItem getters: " + eSafeCi.message);
                }

                // Exception monitors
                try {
                    Interceptor.attach(baseAddr.add(0xA43CC0), {
                        onEnter: function (args) {
                            log("🚨 [IL2CPP EXCEPTION 0xA43CC0 NullRef] from RVA: " + this.returnAddress.sub(baseAddr));
                        }
                    });
                    Interceptor.attach(baseAddr.add(0x1FF9000), {
                        onEnter: function (args) {
                            log("🚨 [IL2CPP EXCEPTION 0x1FF9000 OutOfRange] from RVA: " + this.returnAddress.sub(baseAddr));
                        }
                    });
                } catch (eExcM) {}

                // InventoryScene.UpdateDisplayCardList (0x10542F4) list protection & 0x1054A04 ARM64 patch
                try {
                    Interceptor.attach(baseAddr.add(0x10542F4), {
                        onEnter: function (args) {
                            this.scene = args[0];
                            this.isGroup = args[1].toInt32();
                            this.type = args[2].toInt32();
                            this.isReload = args[3].toInt32();
                            log("[🗃️ UPDATE_DISPLAY_CARD_LIST] Entered: scene=" + this.scene + ", isGroup=" + this.isGroup + ", type=" + this.type + ", isReload=" + this.isReload);
                            ensureInventoryLists(this.scene);
                        },
                        onLeave: function (retval) {
                            try {
                                if (!this.scene || this.scene.isNull()) return;
                                var dclPtr = this.scene.add(0x58).readPointer();
                                var count = (!dclPtr.isNull()) ? dclPtr.add(0x18).readS32() : 0;
                                var extractType = this.scene.add(0x50).readS32();
                                log("[🗃️ UPDATE_DISPLAY_CARD_LIST] onLeave: count=" + count + ", extractType=" + extractType);
                                if (extractType === 2) {
                                    log("[⚡ UPDATE_DISPLAY_CARD_LIST] extractType=2 (Material)! Populating material cards...");
                                    populateMaterialDisplayCardList(this.scene);
                                } else if (count === 0 && extractType === 0) {
                                    log("[🗃️ UPDATE_DISPLAY_CARD_LIST] displayCardList was left empty! Restoring all cards...");
                                    restoreDefaultDisplayCardList(this.scene, true, true);
                                }
                            } catch (eUdclLeave) {
                                log("[-] Error in UpdateDisplayCardList.onLeave: " + eUdclLeave.message);
                            }
                        }
                    });
                    log("[+] Interceptor.attach installed on InventoryScene.UpdateDisplayCardList (0x10542F4)!");

                    // ARM64 byte patch at 0x1054A04: replace 'bl #0xa43cc0' with 'b #0x1054a98' (safe epilogue exit)
                    Memory.protect(baseAddr.add(0x1054A04), 4, 'rwx');
                    baseAddr.add(0x1054A04).writeByteArray([0x25, 0x00, 0x00, 0x14]);
                    log("[🛡️ INVENTORY PATCH] Patched 0x1054A04 with 'b #0x1054a98' (safe ret epilogue)!");
                } catch (eUdclProtect) {
                    log("[-] Error protecting UpdateDisplayCardList / patching 0x1054A04: " + eUdclProtect.message);
                }

                // InventoryScene.SetStateWait (0x10556C0) -> Immediate offline transition to SetStateWaitDone
                try {
                    // Safety patch in SetStateWaitDone (0x1055ECC): if sceneView is null, branch to 0x1055EAC instead of throwing exception
                    try {
                        Memory.protect(baseAddr.add(0x1055ECC), 4, "rwx");
                        baseAddr.add(0x1055ECC).writeByteArray([0xFA, 0xFF, 0xFF, 0x17]); // b #0x1055eac
                        log("[🛡️ INVENTORY PATCH] Patched SetStateWaitDone 0x1055ECC with safe branch to 0x1055EAC!");
                    } catch (eSswdPatch) {
                        log("[-] Error patching SetStateWaitDone 0x1055ECC: " + eSswdPatch.message);
                    }

                    Interceptor.replace(baseAddr.add(0x10556C0), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[🗃️ INVENTORY] SetStateWait entered -> executing instant offline transition!");
                        try {
                            if (sceneThis.isNull()) return;

                            // Ensure lists
                            ensureInventoryLists(sceneThis);
                            ensureMaterialCardItemList(sceneThis);

                            // Complete fade immediately so screen does not remain white
                            try {
                                var fadeCompleteFn = new NativeFunction(baseAddr.add(0xB3E230), "void", ["pointer"]);
                                fadeCompleteFn(NULL);
                                log("[✅ INVENTORY] FadeControl.Complete invoked!");
                            } catch (eFd) {
                                log("[-] Error completing fade: " + eFd.message);
                            }

                            // Invoke SetStateWaitDone (0x1055E14)
                            try {
                                var setStateWaitDoneFn = new NativeFunction(baseAddr.add(0x1055E14), "void", ["pointer", "pointer"]);
                                setStateWaitDoneFn(sceneThis, NULL);
                                log("[✅ INVENTORY] SetStateWaitDone invoked successfully!");
                                // Restore all 24 cards after transition to Default state
                                restoreDefaultDisplayCardList(sceneThis, true);
                            } catch (eSwd) {
                                log("[-] Error invoking SetStateWaitDone: " + eSwd.message);
                                // Fallback: direct SetStateDefault
                                var setStateDefaultFn = new NativeFunction(baseAddr.add(0x1053B88), "void", ["pointer", "bool", "bool", "pointer"]);
                                setStateDefaultFn(sceneThis, 1, 1, NULL);
                                restoreDefaultDisplayCardList(sceneThis, true);
                            }
                        } catch (eWait) {
                            log("[-] Error in SetStateWait replacement: " + eWait.message);
                        }
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.SetStateWait (0x10556C0)!");
                } catch (eSswReplace) {
                    log("[-] Error replacing SetStateWait: " + eSswReplace.message);
                }

                // Global PreloadTexture (0xAD2A48) -> Immediate callback execution in offline mode
                try {
                    Interceptor.replace(baseAddr.add(0xAD2A48), new NativeCallback(function (enumerator, callback, methodInfo) {
                        log("[🖼️ PRELOAD] PreloadTexture intercepted offline! callback=" + callback);
                        if (!callback.isNull()) {
                            try {
                                var methodPtr = callback.add(0x10).readPointer();
                                var target = callback.add(0x20).readPointer();
                                if (!methodPtr.isNull()) {
                                    var cbFn = new NativeFunction(methodPtr, "void", ["pointer", "pointer"]);
                                    cbFn(target, NULL);
                                    log("[✅ PRELOAD] Callback executed directly and safely!");
                                } else {
                                    var invokeFn = new NativeFunction(baseAddr.add(0x1DEBE44), "void", ["pointer"]);
                                    invokeFn(callback);
                                    log("[✅ PRELOAD] Callback invoked via Action.Invoke!");
                                }
                            } catch (eInv) {
                                log("[-] Error invoking preload callback: " + eInv.message);
                            }
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on PreloadTexture (0xAD2A48)!");
                } catch (ePltReplace) {
                    log("[-] Error replacing PreloadTexture: " + ePltReplace.message);
                }

                // 9f. InventoryControl.CheckIntensifyEvent (0xF2C14C) -> Safe offline stub to prevent NullRef in SetStateMain
                try {
                    var checkIntensifyEventAddr = baseAddr.add(0xF2C14C);
                    Interceptor.replace(checkIntensifyEventAddr, new NativeCallback(function (cardData, probRatePtr, priceRatePtr, methodInfo) {
                        if (!probRatePtr.isNull()) probRatePtr.writeDouble(1.0);
                        if (!priceRatePtr.isNull()) priceRatePtr.writeDouble(1.0);
                    }, "void", ["pointer", "pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.CheckIntensifyEvent (0xF2C14C)!");
                } catch (eCie) {
                    log("[-] Error replacing CheckIntensifyEvent: " + eCie.message);
                }

                // 9g. CardThemeInfoView.Refresh (0x1393510) -> Patch null check at 0x1393598 to return safely
                try {
                    Memory.protect(baseAddr.add(0x1393598), 4, "rwx");
                    baseAddr.add(0x1393598).writeByteArray([0xf4, 0x14, 0x00, 0xb4]); // cbz x20, #0x1393834 (ret instead of null ref throw)
                    log("[+] Patched CardThemeInfoView.Refresh (0x1393598) null check to safe ret!");
                } catch (ePct) {
                    log("[-] Error patching CardThemeInfoView.Refresh: " + ePct.message);
                }

                // 9h. UnityEngine.UI.Image.TrackSprite (0x1ECB8F0) & TrackImage (0x1ECF6A8) -> Neutralize libunity hierarchy traversal crash
                try {
                    Interceptor.replace(baseAddr.add(0x1ECB8F0), new NativeCallback(function (thisPtr, methodInfo) {
                        // Safe no-op to bypass corrupted hierarchy crash in libunity.so
                    }, "void", ["pointer", "pointer"]));
                    Interceptor.replace(baseAddr.add(0x1ECF6A8), new NativeCallback(function (thisPtr, methodInfo) {
                        // Safe no-op
                    }, "void", ["pointer", "pointer"]));
                    log("[🛡️ UI PATCH] Neutralized Image.TrackSprite (0x1ECB8F0) and TrackImage (0x1ECF6A8)!");
                } catch (eTrk) {
                    log("[-] Error replacing TrackSprite: " + eTrk.message);
                }

                // 9g2. InventoryScene.GetMaterialViewData (0x105E33C) -> Patch at 0x105E3F0 to branch directly to return
                try {
                    Memory.protect(baseAddr.add(0x105E3F0), 4, "rwx");
                    baseAddr.add(0x105E3F0).writeByteArray([0x07, 0x00, 0x00, 0x14]); // b #0x105e40c (bypass materialCardInfo & name null refs)
                    log("[+] Patched InventoryScene.GetMaterialViewData (0x105E3F0) to safe b #0x105e40c!");
                } catch (eGmv) {
                    log("[-] Error patching GetMaterialViewData: " + eGmv.message);
                }

                // 9h. InventoryScene.GetEquipViewData (0x10577DC) -> Bulletproof replacement
                try {
                    var getEquipViewDataAddr = baseAddr.add(0x10577DC);
                    var equipParamsKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.view.sub", "InvenCardEquipView/Params");
                    Interceptor.replace(getEquipViewDataAddr, new NativeCallback(function (sceneThis, cardItem, artistData, otherCardItem, methodInfo) {
                        try {
                            if (!equipParamsKlass || equipParamsKlass.isNull()) return NULL;
                            var p = il2cpp_object_new(equipParamsKlass);
                            if (!p || p.isNull()) return NULL;

                            var cId = 1001;
                            var gr = 4;
                            var lvl = 50;
                            var isPrism = false;
                            var isEq = false;
                            var isLk = false;

                            if (cardItem && !cardItem.isNull()) {
                                var raw = cardItem.add(0x10).readPointer();
                                if (!raw.isNull()) {
                                    cId = raw.add(0x20).readS32();
                                    gr = raw.add(0x24).readS32();
                                    lvl = raw.add(0x1C).readS16();
                                    isEq = (raw.add(0x28).readU8() === 1);
                                    isLk = (raw.add(0x29).readU8() === 1);
                                    isPrism = (raw.add(0x2A).readU8() === 1);
                                }
                            }

                            var isR = (gr === 4);
                            var isMax = (isR && lvl >= 50) || (!isR && lvl >= 5);

                            var meta = getCardMetadata(cId);
                            var aId = (meta && meta.artistID) ? meta.artistID : 1001;
                            var tId = (meta && meta.theme) ? meta.theme : 1001;

                            var aName = artistNamesMap[aId] || "HeeJin";
                            var tName = themeNamesMap[tId] || "Hi High";

                            // Large card params
                            var cardParams = createMockLargeCardParams(cId, gr, lvl, isPrism);
                            p.add(0x10).writePointer(cardParams || NULL);
                            p.add(0x18).writePointer(createIl2CppString("LOONA"));
                            p.add(0x20).writePointer(createIl2CppString(aName));

                            // Stat params (0xABFCD0)
                            try {
                                if (cardItem && !cardItem.isNull()) {
                                    var getStatFn = new NativeFunction(baseAddr.add(0xABFCD0), "pointer", ["pointer", "pointer"]);
                                    var statParams = getStatFn(cardItem, NULL);
                                    p.add(0x28).writePointer(statParams || NULL);
                                }
                            } catch (eStp) {}

                            // Delta stats
                            var deltaScore = 0;
                            var deltaEnergy = 0;
                            var curStats = getCardBaseStats(gr, lvl, isPrism);
                            if (otherCardItem && !otherCardItem.isNull()) {
                                try {
                                    var oRaw = otherCardItem.add(0x10).readPointer();
                                    if (!oRaw.isNull()) {
                                        var oGr = oRaw.add(0x24).readS32();
                                        var oLvl = oRaw.add(0x1C).readS16();
                                        var oIsPrism = (oRaw.add(0x2A).readU8() === 1);
                                        var oStats = getCardBaseStats(oGr, oLvl, oIsPrism);
                                        deltaScore = curStats.score - oStats.score;
                                        deltaEnergy = curStats.energy - oStats.energy;
                                    }
                                } catch (eDelta) {}
                            } else {
                                deltaScore = curStats.score;
                                deltaEnergy = curStats.energy;
                            }

                            p.add(0x30).writeS32(deltaScore);
                            p.add(0x34).writeS32(deltaEnergy);
                            p.add(0x38).writePointer(createIl2CppString("Theme"));
                            p.add(0x40).writePointer(createIl2CppString(tName));

                            // Theme params: write NULL safely (native 0xABFF78 crashes with access violation 0x132 on mock cardItem)
                            p.add(0x48).writePointer(NULL);

                            p.add(0x50).writePointer(createIl2CppString("Equip"));
                            p.add(0x58).writePointer(createIl2CppString("Cancel"));
                            p.add(0x60).writeU8(0); // isLeader
                            p.add(0x61).writeU8(isLk ? 1 : 0);
                            p.add(0x62).writeU8(isR ? 1 : 0);
                            p.add(0x63).writeU8(isMax ? 1 : 0);
                            p.add(0x64).writeU8(isEq ? 1 : 0);
                            p.add(0x68).writePointer(createIl2CppString("MAX"));
                            p.add(0x70).writePointer(createIl2CppString("Level Up"));
                            p.add(0x78).writePointer(createIl2CppString("Level Up"));
                            p.add(0x80).writePointer(createIl2CppString("Power Up"));

                            // Read ratingupSprite / powerupSprite from sceneView.btnBoxSprites if available
                            try {
                                if (!sceneThis.isNull()) {
                                    var sv = sceneThis.add(0x48).readPointer();
                                    if (!sv.isNull()) {
                                        var bbs = sv.add(0xC0).readPointer();
                                        if (!bbs.isNull()) {
                                            var getSpriteFn = new NativeFunction(baseAddr.add(0xD0CAB8), "pointer", ["pointer", "int", "pointer"]);
                                            p.add(0x88).writePointer(getSpriteFn(bbs, 1, NULL)); // ratingupSprite
                                            p.add(0x90).writePointer(getSpriteFn(bbs, 0, NULL)); // powerupSprite
                                        }
                                    }
                                }
                            } catch (eBbs) {}

                            p.add(0x98).writePointer(createIl2CppString("Exchange"));
                            p.add(0xA0).writePointer(createIl2CppString("Information"));
                            p.add(0xA8).writePointer(createIl2CppString("Equip"));
                            p.add(0xB0).writePointer(createIl2CppString("Unequip"));
                            p.add(0xB8).writeU8(0); // isEvent

                            return p;
                        } catch (eGevR) {
                            log("[-] Error in safe GetEquipViewData replacement: " + eGevR.message);
                            return NULL;
                        }
                    }, "pointer", ["pointer", "pointer", "pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.GetEquipViewData (0x10577DC)!");
                } catch (eRepGev) {
                    log("[-] Error replacing GetEquipViewData: " + eRepGev.message);
                }

                // 9i. InvenCardEquipView.Refresh (0xF219B4) -> Bulletproof replacement to prevent any NullReferenceException
                try {
                    var invenCardEquipViewRefreshAddr = baseAddr.add(0xF219B4);
                    Interceptor.replace(invenCardEquipViewRefreshAddr, new NativeCallback(function (viewThis, p, methodInfo) {
                        try {
                            if (viewThis.isNull() || p.isNull()) return;


                            // 1. card (0x38)
                            var card = viewThis.add(0x38).readPointer();
                            var cardParams = p.add(0x10).readPointer();
                            if (!card.isNull() && !cardParams.isNull()) {
                                try {
                                    var cardRefreshFn = new NativeFunction(baseAddr.add(0x137F570), "void", ["pointer", "pointer", "pointer"]);
                                    cardRefreshFn(card, cardParams, NULL);
                                } catch (eC) {}
                            }

                            // 2. groupName (0x40)
                            var groupName = viewThis.add(0x40).readPointer();
                            var groupNameStr = p.add(0x18).readPointer();
                            if (!groupName.isNull() && !groupNameStr.isNull()) {
                                try {
                                    var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                    setTextFn(groupName, groupNameStr, NULL);
                                } catch (eG) {}
                            }

                            // 3. artistName (0x48)
                            var artistName = viewThis.add(0x48).readPointer();
                            var artistNameStr = p.add(0x20).readPointer();
                            if (!artistName.isNull() && !artistNameStr.isNull()) {
                                try {
                                    var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                    setTextFn(artistName, artistNameStr, NULL);
                                } catch (eA) {}
                            }

                            // 4. stat (0x50)
                            var stat = viewThis.add(0x50).readPointer();
                            var statParams = p.add(0x28).readPointer();
                            if (!stat.isNull() && !statParams.isNull()) {
                                try {
                                    var statRefreshFn = new NativeFunction(baseAddr.add(0x1390F48), "void", ["pointer", "pointer", "pointer"]);
                                    statRefreshFn(stat, statParams, NULL);
                                } catch (eS) {}
                            }

                            // 5. themeHeader (0x58)
                            var themeHeader = viewThis.add(0x58).readPointer();
                            if (!themeHeader.isNull()) {
                                try {
                                    var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                    setTextFn(themeHeader, createIl2CppString("Theme"), NULL);
                                } catch (eTh) {}
                            }

                            // 6. themeName (0x60)
                            var themeName = viewThis.add(0x60).readPointer();
                            var themeNameStr = p.add(0x40).readPointer();
                            if (!themeName.isNull() && !themeNameStr.isNull()) {
                                try {
                                    var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                    setTextFn(themeName, themeNameStr, NULL);
                                } catch (eTn) {}
                            }

                            // 7. theme (0x68)
                            var theme = viewThis.add(0x68).readPointer();
                            var themeParams = p.add(0x48).readPointer();
                            if (!theme.isNull() && !themeParams.isNull()) {
                                try {
                                    var themeRefreshFn = new NativeFunction(baseAddr.add(0x1393510), "void", ["pointer", "pointer", "pointer"]);
                                    themeRefreshFn(theme, themeParams, NULL);
                                } catch (eThm) {}
                            }

                            // 8. Buttons (btnEquip 0x78, btnCancel 0x80, btnIntensify 0xB0)
                            var btnEquip = viewThis.add(0x78).readPointer();
                            var btnCancel = viewThis.add(0x80).readPointer();
                            var btnIntensify = viewThis.add(0xB0).readPointer();
                            var setBtnTextFn = new NativeFunction(baseAddr.add(0xE9B7B0), "void", ["pointer", "pointer", "pointer"]);
                            if (!btnEquip.isNull()) setBtnTextFn(btnEquip, createIl2CppString("Equip"), NULL);
                            if (!btnCancel.isNull()) setBtnTextFn(btnCancel, createIl2CppString("Cancel"), NULL);
                            if (!btnIntensify.isNull()) setBtnTextFn(btnIntensify, createIl2CppString("Level Up"), NULL);

                            var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                            var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);

                            var isLeader = (p.add(0x60).readU8() === 1);
                            var isLk = (p.add(0x61).readU8() === 1);

                            // 9. leaderIcon (0x70)
                            var leaderIcon = viewThis.add(0x70).readPointer();
                            if (!leaderIcon.isNull()) {
                                try {
                                    setActiveFn(leaderIcon, isLeader ? 1 : 0, NULL);
                                } catch (eLi) {}
                            }

                            // 10. leaderOnObj (0x90)
                            var leaderOnObj = viewThis.add(0x90).readPointer();
                            if (!leaderOnObj.isNull()) {
                                try {
                                    setActiveFn(leaderOnObj, isLeader ? 1 : 0, NULL);
                                } catch (eLio) {}
                            }

                            // 11. lockOnObj (0xA0)
                            var lockOnObj = viewThis.add(0xA0).readPointer();
                            if (!lockOnObj.isNull()) {
                                try {
                                    setActiveFn(lockOnObj, isLk ? 1 : 0, NULL);
                                } catch (eLko) {}
                            }

                            // 12. lockOffObj (0xA8)
                            var lockOffObj = viewThis.add(0xA8).readPointer();
                            if (!lockOffObj.isNull()) {
                                try {
                                    setActiveFn(lockOffObj, isLk ? 0 : 1, NULL);
                                } catch (eLkoff) {}
                            }

                            log("[✅ EQUIP_VIEW] InvenCardEquipView.Refresh safely completed!");
                        } catch (eEr) {
                            log("[-] Error in safe InvenCardEquipView.Refresh: " + eEr.message);
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on InvenCardEquipView.Refresh (0xF219B4)!");
                } catch (eHicer) {
                    log("[-] Error replacing InvenCardEquipView.Refresh: " + eHicer.message);
                }

                // 10. URLsControl.SetCdnTexture (0x163A9E8) -> Native Texture2D loader with disk cache
                try {
                    var setCdnTextureAddr = baseAddr.add(0x163A9E8);
                    Interceptor.replace(setCdnTextureAddr, new NativeCallback(function (target, path, emptyTexture, handleResult, autoSize, autoEnabled, processing, methodInfo) {
                        try {
                            if (target.isNull()) return NULL;
                            if (path.isNull() || path.compare(ptr(0x1000)) <= 0) {
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
                                        if (idx !== -1) {
                                            relPath = fullUrl.substring(idx);
                                        } else {
                                            var cleanUrl = fullUrl.split("?")[0];
                                            if (urlToCardMap && urlToCardMap[cleanUrl]) {
                                                var uInfo = urlToCardMap[cleanUrl];
                                                var uFolder = "wadceg";
                                                relPath = "asiudgasg/asodhsg/" + uFolder + "/" + uInfo.cId + "_" + uInfo.type + ".i.bytes";
                                            }
                                        }
                                    }
                                }
                            }

                            if (!relPath || relPath.length === 0) return NULL;

                            // Ownership Check: wadceg vs sdhgauwehdnu
                            if (relPath.indexOf("wadceg/") !== -1 || relPath.indexOf("weoihxd/") !== -1 || relPath.indexOf("sdhgauwehdnu/") !== -1) {
                                var match = relPath.match(/(\d+)_([sl])\.i\.bytes/);
                                if (match) {
                                    var cId = parseInt(match[1]);
                                    var defaultFolder = "wadceg";
                                    var folder = defaultFolder;
                                    if (relPath.indexOf("sdhgauwehdnu/") !== -1) {
                                        folder = "sdhgauwehdnu";
                                    } else {
                                        var existsInOwned = loadLocalTexture2D("asiudgasg/asodhsg/" + defaultFolder + "/" + cId + "_l.i.bytes") !== null ||
                                                             loadLocalTexture2D("asiudgasg/asodhsg/" + defaultFolder + "/" + cId + "_s.i.bytes") !== null;
                                        folder = (accountOwnedCards[cId] || existsInOwned) ? defaultFolder : "sdhgauwehdnu";
                                    }
                                    // High-Definition Upgrade: prefer _l over _s for maximum visual sharpness
                                    var highResPath = "asiudgasg/asodhsg/" + folder + "/" + cId + "_l.i.bytes";
                                    var highResTex = loadLocalTexture2D(highResPath);
                                    if (highResTex && !highResTex.isNull()) {
                                        relPath = highResPath;
                                    } else {
                                        relPath = "asiudgasg/asodhsg/" + folder + "/" + cId + "_" + match[2] + ".i.bytes";
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

                                // Enable Behaviour component (0x1DB3CFC)
                                try {
                                    var setEnabledFn = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                                    setEnabledFn(target, 1, NULL);
                                } catch (eEn) {}

                                // Activate RawImage GameObject (0x1DBADF4)
                                try {
                                    var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                    var targetGo = getGoFn(target, NULL);
                                    if (!targetGo.isNull()) {
                                        var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);
                                        setActiveFn(targetGo, 1, NULL);
                                    }
                                } catch (eGo) {}

                                // If autoSize is true, resize target to texture native dimensions (RawImage.SetNativeSize 0x194C1C8)
                                if (autoSize !== 0) {
                                    try {
                                        var setNativeSizeFn = new NativeFunction(baseAddr.add(0x194C1C8), "void", ["pointer", "pointer"]);
                                        setNativeSizeFn(target, NULL);
                                    } catch (eSns) {
                                        log("[-] Error calling SetNativeSize on target: " + eSns.message);
                                    }
                                }

                                // Trigger handleResult delegate: method_ptr at 0x10, m_target at 0x20
                                if (!handleResult.isNull()) {
                                    try {
                                        var methodPtr = handleResult.add(0x10).readPointer();
                                        var targetObj = handleResult.add(0x20).readPointer();
                                        if (!methodPtr.isNull() && !targetObj.isNull()) {
                                            var cbFn = new NativeFunction(methodPtr, "void", ["pointer", "int", "pointer", "pointer"]);
                                            cbFn(targetObj, 1, tex, NULL);
                                            log("[✅ CDN_CALLBACK] Successfully called handleResult callback for targetObj: " + targetObj);
                                        }
                                        // Extra assurance: If targetObj is CardView/CardLargeView, explicitly call set_PhotoVisible and set_TierVisible
                                        if (!targetObj.isNull()) {
                                            try {
                                                var setPhotoVisFn = new NativeFunction(baseAddr.add(0x138F3A0), "void", ["pointer", "int", "pointer"]);
                                                setPhotoVisFn(targetObj, 1, NULL);
                                                var setTierVisFn = new NativeFunction(baseAddr.add(0x1393AAC), "void", ["pointer", "int", "pointer"]);
                                                setTierVisFn(targetObj, 1, NULL);
                                            } catch (eSpv) {}
                                        }
                                    } catch (eCb) {
                                        log("[-] Error invoking handleResult callback: " + eCb.message);
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

                // CardBook Stabilization Hooks
                // 1. CardBookView.SetTabView (0x11CF5BC) -> Safe view toggling
                try {
                    Interceptor.replace(baseAddr.add(0x11CF5BC), new NativeCallback(function (thisPtr, tabType, methodInfo) {
                        log("[📖 CARDBOOK] SetTabView called: tabType=" + tabType);
                        if (thisPtr.isNull()) return 1;
                        try {
                            var tabMain = thisPtr.add(0xD0).readPointer();
                            var tabGroup = thisPtr.add(0xD8).readPointer();
                            var mainView = thisPtr.add(0xE0).readPointer();
                            var groupView = thisPtr.add(0x100).readPointer();

                            var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                            var setActFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                            var tabSetActFn = new NativeFunction(baseAddr.add(0xE431A8), "void", ["pointer", "bool", "pointer"]);

                            if (tabType === 0) { // Main View
                                if (!tabMain.isNull()) tabSetActFn(tabMain, 1, NULL);
                                if (!tabGroup.isNull()) tabSetActFn(tabGroup, 0, NULL);
                                if (!mainView.isNull()) {
                                    var go = getGoFn(mainView, NULL);
                                    if (!go.isNull()) setActFn(go, 1, NULL);
                                }
                                if (!groupView.isNull()) {
                                    var go = getGoFn(groupView, NULL);
                                    if (!go.isNull()) setActFn(go, 0, NULL);
                                }
                            } else if (tabType === 1) { // Group View
                                if (!tabMain.isNull()) tabSetActFn(tabMain, 0, NULL);
                                if (!tabGroup.isNull()) tabSetActFn(tabGroup, 1, NULL);
                                if (!mainView.isNull()) {
                                    var go = getGoFn(mainView, NULL);
                                    if (!go.isNull()) setActFn(go, 0, NULL);
                                }
                                if (!groupView.isNull()) {
                                    var go = getGoFn(groupView, NULL);
                                    if (!go.isNull()) setActFn(go, 1, NULL);
                                }
                            }
                        } catch (eStv) {
                            log("[-] Error in SetTabView: " + eStv.message);
                        }
                        return 1;
                    }, "int", ["pointer", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookView.SetTabView (0x11CF5BC)!");
                } catch (eStv) {
                    log("[-] Error replacing SetTabView: " + eStv.message);
                }

                // 2. CardBookView.InitTabObjectSetting (0x11D431C) -> Initialize MainView active
                try {
                    Interceptor.replace(baseAddr.add(0x11D431C), new NativeCallback(function (thisPtr, methodInfo) {
                        log("[📖 CARDBOOK] InitTabObjectSetting called!");
                        if (thisPtr.isNull()) return;
                        try {
                            var tabMain = thisPtr.add(0xD0).readPointer();
                            var tabGroup = thisPtr.add(0xD8).readPointer();
                            var mainView = thisPtr.add(0xE0).readPointer();
                            var groupView = thisPtr.add(0x100).readPointer();

                            var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                            var setActFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                            var tabSetActFn = new NativeFunction(baseAddr.add(0xE431A8), "void", ["pointer", "bool", "pointer"]);

                            if (!tabMain.isNull()) tabSetActFn(tabMain, 1, NULL);
                            if (!tabGroup.isNull()) tabSetActFn(tabGroup, 0, NULL);
                            if (!mainView.isNull()) {
                                var go = getGoFn(mainView, NULL);
                                if (!go.isNull()) setActFn(go, 1, NULL);
                            }
                            if (!groupView.isNull()) {
                                var go = getGoFn(groupView, NULL);
                                if (!go.isNull()) setActFn(go, 0, NULL);
                            }
                        } catch (eItos) {
                            log("[-] Error in InitTabObjectSetting: " + eItos.message);
                        }
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookView.InitTabObjectSetting (0x11D431C)!");
                } catch (eItos) {
                    log("[-] Error replacing InitTabObjectSetting: " + eItos.message);
                }

                // 3. CardBookScene.SetStateWait (0x11CF378) -> Immediately populate CardBook, refresh MainView, and finish wait
                try {
                    Interceptor.replace(baseAddr.add(0x11CF378), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[📖 CARDBOOK] SetStateWait intercepted -> instantly populating CardBook and activating UI!");
                        try {
                            ensureCardBookControlData();
                        } catch (eEd) {
                            log("[-] Error in ensureCardBookControlData: " + eEd.message);
                        }
                        try {
                            var refreshMainFn = new NativeFunction(baseAddr.add(0x11CFDD8), "void", ["pointer", "bool", "pointer"]);
                            refreshMainFn(sceneThis, 1, NULL);
                            log("[📖 CARDBOOK] RefreshSetMainView(true) cleanly executed!");
                        } catch (eRm) {
                            log("[-] Error in RefreshSetMainView: " + eRm.message);
                        }
                        try {
                            var waitDoneFn = new NativeFunction(baseAddr.add(0x11CF1CC), "void", ["pointer", "pointer"]);
                            waitDoneFn(sceneThis, NULL);
                            log("[📖 CARDBOOK] SetStateWaitDone cleanly executed!");
                        } catch (eWd) {
                            log("[-] Error in SetStateWaitDone: " + eWd.message);
                        }
                        try {
                            var sceneView = sceneThis.add(0x48).readPointer();
                            if (!sceneView.isNull()) {
                                var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                var setActFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "bool", "pointer"]);
                                var svGo = getGoFn(sceneView, NULL);
                                if (!svGo.isNull()) setActFn(svGo, 1, NULL);
                                var mainView = sceneView.add(0xE0).readPointer();
                                if (!mainView.isNull()) {
                                    var mvGo = getGoFn(mainView, NULL);
                                    if (!mvGo.isNull()) setActFn(mvGo, 1, NULL);
                                }
                            }
                        } catch (eAct) {
                            log("[-] Error activating CardBook sceneView/mainView: " + eAct.message);
                        }
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookScene.SetStateWait (0x11CF378)!");
                } catch (eSsw) {
                    log("[-] Error replacing SetStateWait: " + eSsw.message);
                }

                // 3b. CardBookControl.Info.Sort (0xB98720) -> Safe no-op
                try {
                    Interceptor.replace(baseAddr.add(0xB98720), new NativeCallback(function (infoPtr, methodInfo) {
                        log("[📖 CARDBOOK] CardBookControl.Info.Sort (0xB98720) intercepted (safe no-op)!");
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookControl.Info.Sort (0xB98720)!");
                } catch (eSort) {
                    log("[-] Error replacing Info.Sort: " + eSort.message);
                }

                // 3c. CardBookControl.GetThemePoint (0x11C6994) & GetTotalThemePoint (0x11C6B40)
                try {
                    Interceptor.replace(baseAddr.add(0x11C6994), new NativeCallback(function () {
                        return 2400;
                    }, "int", []));
                    Interceptor.replace(baseAddr.add(0x11C6B40), new NativeCallback(function () {
                        return 2400;
                    }, "int", []));
                    log("[+] Interceptor.replace installed on CardBookControl.GetThemePoint & GetTotalThemePoint (2400 pts)!");
                } catch (eThmPt) {
                    log("[-] Error replacing GetThemePoint: " + eThmPt.message);
                }

                // 3d. CardBookControl.GroupItem.GetGrade (0xB96694) -> Always return Grade R (4)
                try {
                    Interceptor.replace(baseAddr.add(0xB96694), new NativeCallback(function (thisPtr, isMe, methodInfo) {
                        if (!thisPtr.isNull()) {
                            var g = thisPtr.add(0x38).readS32();
                            if (g >= 0) return g;
                        }
                        return 4; // CardGrade.R (4)
                    }, "int", ["pointer", "bool", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookControl.GroupItem.GetGrade (0xB96694)!");
                } catch (eGrd) {
                    log("[-] Error replacing GroupItem.GetGrade: " + eGrd.message);
                }

                // 3e. CardBookScene.RefreshFavoriteGroupFive (0x11D0048) -> Safe no-op
                try {
                    Interceptor.replace(baseAddr.add(0x11D0048), new NativeCallback(function (thisPtr, isReload, methodInfo) {
                        log("[📖 CARDBOOK] RefreshFavoriteGroupFive intercepted (safe no-op)!");
                    }, "void", ["pointer", "bool", "pointer"]));
                    log("[+] Interceptor.replace installed on CardBookScene.RefreshFavoriteGroupFive (0x11D0048)!");
                } catch (eRfgf) {
                    log("[-] Error replacing RefreshFavoriteGroupFive: " + eRfgf.message);
                }

                // 3f. CardBookControl.GetGroupItem (0x11C83DC) & GetMajorGroupItem (0x11C8528) -> Safe LOONA group return
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
                }

                // 4. CardBookScene UI Refresh Safety Patches (guard against NullReferenceException on decorative elements)
                var cardBookSafetyRetRVAs = [
                    0x11D0CD4, // CardBookScene.RefreshLiveBookBtn -> ret
                    0x11D0B64, // CardBookScene.RefreshAchieveNewMark -> ret
                    0x11D0C1C, // CardBookScene.RefreshGroupNewMark -> ret
                    0x11CFB80, // CardBookScene.RefreshOthers -> ret
                    0x11CD560, // CardBookMainView.SetRefreshCardCollection -> ret (prevent ArgumentOutOfRangeException on empty CardAchievementList)
                    0x11CD6F8, // CardBookMainView.SetRefreshThemeCollection -> ret (prevent ArgumentOutOfRangeException on empty ThemeAchievementList)
                    0x11D446C, // CardBookView.RafreshTabMainNewMark -> ret
                    0x11D0914, // CardBookView.RefreshGroupNewMark -> ret
                    0xB98210,  // CardBookControl.GroupItem.ExtractTexturePath -> ret
                    0xB3BBB4,  // IndicatorPopup.Active -> ret
                    0xB3E230,  // IndicatorPopup.Deactive -> ret
                    0xB3DEA4,  // IndicatorPopup.ActiveWithSmooth -> ret
                    0xB3E004,  // IndicatorPopup.ActiveTwo -> ret
                    0xE4173C,  // CardBookScene.<OpenDetailPopup>b__4 (Close result callback) -> ret
                    0xE415E4   // CardBookScene.<OpenDetailPopup>b__3 (Receipt callback) -> ret
                ];
                cardBookSafetyRetRVAs.forEach(function (rva) {
                    try {
                        Memory.protect(baseAddr.add(rva), 4, "rwx");
                        baseAddr.add(rva).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]);
                    } catch (eRva) {}
                });
                log("[+] Patched " + cardBookSafetyRetRVAs.length + " CardBookScene refresh methods to ret");

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

                // 10. CardBookScene.<OpenDetailPopup>b__0 (0xE40F08) -> mov w8, #1; strb w8, [x21, #0xf0]; b #0xe40f2c
                // Bypass null check on UserDataControl.CardFavoriteGroupList when opening CardBookDetailPopup
                try {
                    Memory.protect(baseAddr.add(0xE40F08), 12, "rwx");
                    baseAddr.add(0xE40F08).writeByteArray([
                        0x28, 0x00, 0x80, 0x52, // mov w8, #1
                        0xa8, 0xc2, 0x03, 0x39, // strb w8, [x21, #0xf0]
                        0x07, 0x00, 0x00, 0x14  // b 0xe40f2c (+0x1c = 7 instructions)
                    ]);
                    log("[+] Byte patch on CardBookScene.<OpenDetailPopup>b__0 (0xE40F08): bypass favorite group list check");
                } catch (eOdp) {
                    log("[-] Error patching OpenDetailPopup callback: " + eOdp.message);
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
                                        return ((cNum - 1001) % 11) + 1;
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

                // Proxy InventoryControl.get_selectedGroupCode (0xF26C40)
                try {
                    Interceptor.replace(baseAddr.add(0xF26C40), new NativeCallback(function (methodInfo) {
                        return 1001;
                    }, "int", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_selectedGroupCode (0xF26C40)!");
                } catch (eSgc2) {
                    log("[-] Error replacing get_selectedGroupCode: " + eSgc2.message);
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

                // Bypass InventoryControl.SetSubGroupCode (0xF271E8) & GetSubGroupCode (0xF272B8)
                try {
                    Interceptor.replace(baseAddr.add(0xF271E8), new NativeCallback(function (groupCode, subCode, methodInfo) {
                        log("[🛡️ INVENTORY] Safely bypassed SetSubGroupCode: " + groupCode + " -> " + subCode);
                    }, "void", ["int", "int", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xF272B8), new NativeCallback(function (groupCode, methodInfo) {
                        return 0;
                    }, "int", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on SetSubGroupCode (0xF271E8) & GetSubGroupCode (0xF272B8)!");
                } catch (eSsgc) {
                    log("[-] Error replacing SetSubGroupCode: " + eSsgc.message);
                }

                // InventoryControl.GetMajorGroupItem (0xF27090) & GetCurrentGroup (0xF2B51C)
                try {
                    Interceptor.replace(baseAddr.add(0xF27090), new NativeCallback(function (groupCode, methodInfo) {
                        if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                            return loonaGroupItemObj;
                        }
                        return NULL;
                    }, "pointer", ["int", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xF2B51C), new NativeCallback(function (pIndex, pSubIndex, methodInfo) {
                        if (pIndex && !pIndex.isNull()) pIndex.writeInt(0);
                        if (pSubIndex && !pSubIndex.isNull()) pSubIndex.writeInt(0);
                        return 1001; // LOONA group code
                    }, "int", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GetMajorGroupItem (0xF27090) & GetCurrentGroup (0xF2B51C)!");
                } catch (eGmg) {
                    log("[-] Error replacing GetMajorGroupItem / GetCurrentGroup: " + eGmg.message);
                }

                // Bulletproof DisplayGroupList initializer & updater (0xF28CE8)
                var cachedDglInstance = NULL;
                var ensureDisplayGroupList = function() {
                    try {
                        if (!cachedDglInstance.isNull() && cachedDglInstance.compare(ptr(0x10000)) > 0) {
                            return cachedDglInstance;
                        }
                        ensureLoonaMocks();
                        var listKlass = getClass("mscorlib", "System.Collections.Generic", "List`1");
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
                        }
                    } catch (eEdgl) {
                        log("[-] Error in ensureDisplayGroupList: " + eEdgl.message);
                    }
                    return cachedDglInstance;
                };

                // Hook InventoryControl.get_DisplayGroupList (0xF2770C) to never return null
                try {
                    Interceptor.replace(baseAddr.add(0xF2770C), new NativeCallback(function (methodInfo) {
                        return ensureDisplayGroupList();
                    }, "pointer", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_DisplayGroupList (0xF2770C)!");
                } catch (eGetDglHk) {
                    log("[-] Error replacing get_DisplayGroupList: " + eGetDglHk.message);
                }

                try {
                    Interceptor.replace(baseAddr.add(0xF28CE8), new NativeCallback(function (isForceSortAlphabet, methodInfo) {
                        log("[🃏 INVENTORY] Safe UpdateDisplayGroupList called (isForce=" + isForceSortAlphabet + ")");
                        ensureDisplayGroupList();
                    }, "void", ["int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.UpdateDisplayGroupList (0xF28CE8)!");
                } catch (eUdgl) {
                    log("[-] Error replacing InventoryControl.UpdateDisplayGroupList: " + eUdgl.message);
                }

                try {
                    Interceptor.attach(baseAddr.add(0x105E0FC), {
                        onEnter: function (args) {
                            log("[🗃️ INVENTORY SCENE] Refresh (0x105E0FC) entered, ensuring DisplayGroupList and lists...");
                            ensureDisplayGroupList();
                            ensureInventoryLists(args[0]);
                        }
                    });
                    log("[+] Interceptor.attach installed on InventoryScene.Refresh (0x105E0FC)!");
                } catch (eIsr) {
                    log("[-] Error attaching to InventoryScene.Refresh: " + eIsr.message);
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
                        if (!dictObj || dictObj.isNull() || dictObj.compare(ptr(0x10000)) < 0) {
                            log("[-] dictSet: dictObj is invalid or null: " + dictObj);
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

                var isInventoryPopulated = false;
                function populateOfflineInventoryCards() {
                    if (isInventoryPopulated) {
                        log("[🃏 INVENTORY] populateOfflineInventoryCards: already populated, skipping duplicate run!");
                        return;
                    }
                    log("[🃏 INVENTORY] populateOfflineInventoryCards() starting...");
                    try {
                        isInventoryPopulated = true;
                        ensureLoonaMocks();

                        try {
                            var openCardFn = new NativeFunction(baseAddr.add(0xF27DA8), "void", ["pointer"]);
                            openCardFn(NULL);
                            log("[🃏 INVENTORY] Native InventoryControl.OpenCard() executed!");
                        } catch (eOc) {
                            log("[-] Error in OpenCard: " + eOc.message);
                        }

                        var getCardMapFn = new NativeFunction(baseAddr.add(0xF2751C), "pointer", ["pointer"]);
                        var cardMap = getCardMapFn(NULL);

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
                        cachedCardKlass = cardKlass;
                        cachedCardItemKlass = cardItemKlass;

                        var validCards = profile.inventoryCards.filter(function(c) {
                            return c && c.cardID >= 1001 && c.cardID <= 1021;
                        });
                        log("[🃏 INVENTORY] Populating " + validCards.length + " LOONA cards into CardMap (" + cardMap + ")...");
                        var addedCount = 0;
                        loonaCardItems = [];

                        for (var i = 0; i < validCards.length; i++) {
                            var cData = validCards[i];
                            try {
                                // 1. Create Card managed instance
                                var cardObj = il2cpp_object_new(cardKlass);
                                if (il2cpp_gchandle_new && !cardObj.isNull()) {
                                    il2cpp_gchandle_new(cardObj, 2);
                                }
                                var objId = int64(cData.objectID || (100000 + i + 1));
                                var cId = parseInt(cData.cardID || (1001 + i), 10);
                                var gr = parseInt(cData.grade !== undefined ? cData.grade : 4, 10);
                                var lvl = parseInt(cData.level || 50, 10);

                                var stats = getCardBaseStats(gr, lvl, !!cData.isPrism);

                                cardObj.add(0x10).writeS64(objId);
                                cardObj.add(0x18).writeS16(stats.energy);
                                cardObj.add(0x1A).writeS16(stats.score);
                                cardObj.add(0x1C).writeS16(lvl);
                                cardObj.add(0x20).writeS32(cId);
                                cardObj.add(0x24).writeS32(gr);
                                cardObj.add(0x28).writeU8(cData.isEquip ? 1 : 0);
                                cardObj.add(0x29).writeU8(cData.isLock ? 1 : 0);
                                cardObj.add(0x2A).writeU8(cData.isPrism ? 1 : 0);

                                // 2. Directly construct CardItem managed instance
                                var cardItemObj = il2cpp_object_new(cardItemKlass);
                                if (il2cpp_gchandle_new && !cardItemObj.isNull()) {
                                    il2cpp_gchandle_new(cardItemObj, 2);
                                }
                                cardItemObj.add(0x10).writePointer(cardObj); // <Raw>
                                var ccd = getOrCreateCardControlData(cId);
                                cardItemObj.add(0x18).writePointer(ccd || NULL); // <Card>k__BackingField
                                var formulaCode = (gr < 4) ? (gr * 5 + Math.min(4, lvl - 1)) : (20 + Math.min(98, lvl - 1));
                                cardItemObj.add(0x20).writeS16(formulaCode); // <IntensifyCode>
                                cardItemObj.add(0x24).writeU32(0x3F800000); // 1.0f
                                cardItemObj.add(0x28).writeS32(100); // <SellPrice>
                                cardItemObj.add(0x2C).writeU8(0); // isMaterial = false
                                var meta = getCardMetadata(cId);
                                var memberIdx = (meta.artistID >= 1000) ? (meta.artistID - 1000) : meta.artistID;
                                if (memberIdx < 1 || memberIdx > 11) memberIdx = ((cId - 1001) % 11) + 1;
                                cardItemObj.add(0x30).writeS32(1001 * 10000 + 1 * 100 + memberIdx); // sortCardIndex
                                cardItemObj.add(0x34).writeU8(0); // isNew = false
                                cardItemObj.add(0x38).writeS32(1); // <ThemeLevel>
                                cardItemObj.add(0x3C).writeU8(0); // isEquipLiveTheme = false
                                cardItemObj.add(0x3E).writeS16(-1); // equipLiveThemeCode = -1
                                cardItemObj.add(0x40).writePointer(NULL); // <themeCardItem>

                                loonaCardItems.push(cardItemObj);

                                // 3. Add to CardMap Dictionary via Native AddCard (0xF2A210)
                                try {
                                    var addCardNativeFn = new NativeFunction(baseAddr.add(0xF2A210), "void", ["pointer"]);
                                    addCardNativeFn(cardItemObj);
                                    addedCount++;
                                    log("[🃏 CARD " + (i + 1) + "] Added cardID=" + cId + " grade=" + gr + " lvl=" + lvl + " objID=" + objId);
                                } catch (eAc) {
                                    log("[-] Failed to add cardID=" + cId + " via AddCard: " + eAc.message);
                                }
                            } catch (cErr) {
                                log("[-] Error creating card " + i + ": " + cErr.message);
                            }
                        }

                        log("[✅ INVENTORY] Successfully populated " + addedCount + " LOONA cards into CardMap!");

                        // Sort loonaCardItems: Equipped cards ALWAYS FIRST, then unequipped
                        sortLoonaCardItems();

                        var loonaEquippedCards = [];
                        var memberFilled = {};
                        for (var k = 0; k < loonaCardItems.length; k++) {
                            var itm = loonaCardItems[k];
                            var r = itm.add(0x10).readPointer();
                            var cid = r.add(0x20).readS32();
                            var mIdx = ((cid - 1001) % 11);
                            var isEq = (r.add(0x28).readU8() === 1);
                            if (isEq && !memberFilled[mIdx]) {
                                loonaEquippedCards.push(itm);
                                memberFilled[mIdx] = true;
                            }
                        }
                        for (var k = 0; k < loonaCardItems.length && loonaEquippedCards.length < 11; k++) {
                            var itm = loonaCardItems[k];
                            var r = itm.add(0x10).readPointer();
                            var cid = r.add(0x20).readS32();
                            var mIdx = ((cid - 1001) % 11);
                            if (!memberFilled[mIdx]) {
                                loonaEquippedCards.push(itm);
                                memberFilled[mIdx] = true;
                            }
                        }

                        loonaCardListFastArray = createFastArray(loonaEquippedCards, 'card');
                        log("[🃏 INVENTORY] Created loonaCardListFastArray (count=" + loonaEquippedCards.length + "): " + loonaCardListFastArray);
                        loonaEachThemeBestCardMap = NULL;

                        // Ensure InventoryControl.IsOpened is true
                        try {
                            var setIsOpenedFn = new NativeFunction(baseAddr.add(0xF2744C), "void", ["int", "pointer"]);
                            setIsOpenedFn(1, NULL);
                            log("[🃏 INVENTORY] InventoryControl.set_IsOpened(true) called!");
                        } catch (ioe) {}

                        // Ensure GroupItem and DisplayGroupList
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

                // --- Hook LanguageControl.GetString & GetStringWantlang with offline fallbacks ---
                try {
                    var offlineLocaleStrings = {
                        0x2FC86C1: "Shop",
                        0x30423FA: "Sell All",
                        0xAD02876: "Choose Group",
                        0x1D9405D: "Card Book",
                        0x1D94064: "Card Book",
                        0x3072969: "{0} / {1}",
                        0x3072D51: "{0} / {1}",
                        0x14B1DA9: "High",
                        0x2FE0979: "New",
                        0x2FE097D: "Low",
                        0x2FE097C: "Prism",
                        0x2FE097B: "Group",
                        0x2FE097A: "Material Card",
                        0x2FE097E: "Lock",
                        0x3029D59: "Material Card",
                        0x302A141: "RECOMMEND",
                        0x302A142: "TRY",
                        0x3029D5A: "Probability of Power Up: ",
                        0x3029D5B: "Low",
                        0x3029D5C: "Normal",
                        0x3029D5D: "High",
                        0x3029D5E: "Very High"
                    };

                    Interceptor.attach(baseAddr.add(0xCF1064), {
                        onEnter: function (args) {
                            this.code32 = args[0].toInt32() >>> 0;
                        },
                        onLeave: function (retval) {
                            if (offlineLocaleStrings[this.code32] !== undefined) {
                                retval.replace(createIl2CppString(offlineLocaleStrings[this.code32]));
                            }
                        }
                    });
                    log("[+] Hooked LanguageControl.GetString (0xCF1064) with offline fallbacks!");

                    // InvenMaterialView.Refresh (0xF22504) -> style empty slot box container
                    Interceptor.attach(baseAddr.add(0xF22504), {
                        onEnter: function (args) {
                            this.matView = args[0];
                            this.paramsPtr = args[1];
                        },
                        onLeave: function (retval) {
                            try {
                                if (!this.matView || this.matView.isNull()) return;
                                var emptyImg = this.matView.add(0x38).readPointer();
                                if (!emptyImg.isNull()) {
                                    // Set subtle card slot container tint: rgba(0.2, 0.25, 0.45, 0.15)
                                    emptyImg.add(0x20).writeFloat(0.25); // r
                                    emptyImg.add(0x24).writeFloat(0.30); // g
                                    emptyImg.add(0x28).writeFloat(0.50); // b
                                    emptyImg.add(0x2C).writeFloat(0.18); // a
                                    emptyImg.add(0x60).writeU8(1); // m_VertsDirty
                                    emptyImg.add(0x61).writeU8(1); // m_MaterialDirty
                                }
                            } catch (eMvr) {}
                        }
                    });
                    log("[+] Hooked InvenMaterialView.Refresh (0xF22504) for empty slot box styling!");
                } catch (eLg) {
                    log("[-] Error hooking LanguageControl.GetString / InvenMaterialView: " + eLg.message);
                }

                // --- Protect UserData.get_CardInvenMaxCount (0xAB1C1C) & InventoryControl.get_CardMapCount (0xF275E8) ---
                try {
                    Interceptor.replace(baseAddr.add(0xAB1C1C), new NativeCallback(function () {
                        var profile = loadPlayerProfile();
                        return (profile && profile.cardInvenMax) ? profile.cardInvenMax : 200;
                    }, "int", []));
                    log("[🛡️ USERDATA] UserData.get_CardInvenMaxCount safely protected!");
                } catch (eMax) {}

                try {
                    Interceptor.replace(baseAddr.add(0xF275E8), new NativeCallback(function () {
                        var profile = loadPlayerProfile();
                        return (profile && profile.inventoryCards) ? profile.inventoryCards.length : 0;
                    }, "int", []));
                    log("[🛡️ INVENTORY] InventoryControl.get_CardMapCount safely protected!");
                } catch (eCmc) {}

                // --- Hook InventoryView.ShowDefaultLayout (0x1055ED0) for safe post-layout UI updates ---
                try {
                    Interceptor.attach(baseAddr.add(0x1055ED0), {
                        onLeave: function (retval) {
                            log("[🗃️ INVENTORY VIEW] ShowDefaultLayout completed! Updating UI texts and card count...");
                            try {
                                if (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) {
                                        // 1. Sort text "High" on InvenSortView
                                        var sceneView = activeInventorySceneInstance.add(0x48).readPointer();
                                        if (!sceneView.isNull()) {
                                            var sortView = sceneView.add(0x80).readPointer();
                                            if (!sortView.isNull()) {
                                                var sortText = sortView.add(0x40).readPointer();
                                                if (!sortText.isNull()) {
                                                    var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                                    setTextFn(sortText, createIl2CppString("High"), NULL);
                                                }
                                            }

                                            // Inspect and ensure btnBack (sceneView + 0x88)
                                            try {
                                                var btnBack = sceneView.add(0x88).readPointer();
                                                if (!btnBack.isNull()) {
                                                    var bGo = btnBack.add(0x10).readPointer();
                                                    var bBtn = btnBack.add(0x48).readPointer();
                                                    var bBox = btnBack.add(0x50).readPointer();
                                                    var bDis = btnBack.add(0x58).readPointer();
                                                    var bLbl = btnBack.add(0x60).readPointer();
                                                    log("[🔍 BTN_BACK] ptr=" + btnBack + " go=" + bGo + " btn=" + bBtn + " box=" + bBox + " dis=" + bDis + " lbl=" + bLbl);
                                                    if (!bGo.isNull()) {
                                                        var setActFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);
                                                        setActFn(bGo, 1, NULL);
                                                    }
                                                    if (!bDis.isNull()) {
                                                        var disGo = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"])(bDis, NULL);
                                                        var disAct = new NativeFunction(baseAddr.add(0x1DB3D4C), "int", ["pointer"])(bDis);
                                                        log("[🔍 BTN_BACK DIS] disGo=" + disGo + " act=" + disAct);
                                                        new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"])(disGo, 0, NULL);
                                                        new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"])(bDis, 0, NULL);
                                                    }
                                                    if (!bBox.isNull()) {
                                                        var boxGo = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"])(bBox, NULL);
                                                        var boxAct = new NativeFunction(baseAddr.add(0x1DB3D4C), "int", ["pointer"])(bBox);
                                                        var boxSprite = bBox.add(0x48).readPointer();
                                                        log("[🔍 BTN_BACK BOX] boxGo=" + boxGo + " act=" + boxAct + " sprite=" + boxSprite + " col=" + bBox.add(0x20).readFloat() + "," + bBox.add(0x24).readFloat() + "," + bBox.add(0x28).readFloat() + "," + bBox.add(0x2C).readFloat());
                                                    }
                                                    var bTr = btnBack.add(0x18).readPointer();
                                                    if (!bTr.isNull()) {
                                                        var getChildCountFn = new NativeFunction(baseAddr.add(0x181ECF0), "int", ["pointer", "pointer"]);
                                                        var getChildFn = new NativeFunction(baseAddr.add(0x181ED28), "pointer", ["pointer", "int", "pointer"]);
                                                        var getNameFn = new NativeFunction(baseAddr.add(0x1DB64F0), "pointer", ["pointer", "pointer"]);
                                                        var getGoFromComp = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer", "pointer"]);
                                                        var cc = getChildCountFn(bTr, NULL);
                                                        log("[🔍 BTN_BACK TR] bTr=" + bTr + " childCount=" + cc);
                                                        for (var ci = 0; ci < cc; ci++) {
                                                            var cTr = getChildFn(bTr, ci, NULL);
                                                            var cGo = getGoFromComp(cTr, NULL);
                                                            var cName = readIl2CppString(getNameFn(cGo, NULL));
                                                            log("[🔍 BTN_BACK CHILD " + ci + "] name=" + cName);
                                                        }
                                                    }
                                                }
                                            } catch (eBtnB) {
                                                log("[-] Error inspecting btnBack: " + eBtnB.message);
                                            }

                                        // Inspect Card Count & Group Count Text GameObjects
                                        var getTextFn = new NativeFunction(baseAddr.add(0x21A5FBC), "pointer", ["pointer"]);
                                        var setTextFn = new NativeFunction(baseAddr.add(0x21A5FC4), "void", ["pointer", "pointer", "pointer"]);
                                        var getActiveAndEnabledFn = new NativeFunction(baseAddr.add(0x1DB3D4C), "int", ["pointer"]);
                                        var getFontSizeFn = new NativeFunction(baseAddr.add(0x21A6394), "int", ["pointer"]);
                                        var getGoFn = new NativeFunction(baseAddr.add(0x1DB6AD4), "pointer", ["pointer"]);
                                        var setActiveFn = new NativeFunction(baseAddr.add(0x1DBADF4), "void", ["pointer", "int", "pointer"]);

                                        var cardView = sceneView.add(0x78).readPointer();
                                        if (!cardView.isNull()) {
                                            var cardCountText = cardView.add(0x38).readPointer();
                                            if (!cardCountText.isNull()) {
                                                var cTxt = readIl2CppString(getTextFn(cardCountText));
                                                var isAE = getActiveAndEnabledFn(cardCountText);
                                                var fSize = getFontSizeFn(cardCountText);
                                                log("[📊 CARD COUNT INSPECT] cardCountText=" + cardCountText + " | text: '" + cTxt + "' | isActiveAndEnabled: " + isAE + " | fontSize: " + fSize);
                                                // Ensure the GameObject itself is active
                                                try {
                                                    var cGo = getGoFn(cardCountText);
                                                    if (!cGo.isNull()) {
                                                        setActiveFn(cGo, 1, NULL);
                                                    }
                                                } catch (eCgo) {}
                                                // If text is empty or not formatted, force update
                                                if (!cTxt || cTxt.length === 0) {
                                                    var prof = loadPlayerProfile();
                                                    var cardCount = (prof && prof.inventoryCards) ? prof.inventoryCards.length : 14;
                                                    var maxCount = 200;
                                                    setTextFn(cardCountText, createIl2CppString(cardCount + " / " + maxCount), NULL);
                                                    log("[📊 CARD COUNT] Force set text to: " + cardCount + " / " + maxCount);
                                                }
                                            }
                                        }

                                        var groupView = sceneView.add(0x70).readPointer();
                                        if (!groupView.isNull()) {
                                            var groupCountText = groupView.add(0x38).readPointer();
                                            if (!groupCountText.isNull()) {
                                                var gTxt = readIl2CppString(getTextFn(groupCountText));
                                                var gIsAE = getActiveAndEnabledFn(groupCountText);
                                                var gFSize = getFontSizeFn(groupCountText);
                                                log("[📊 GROUP COUNT INSPECT] groupCountText=" + groupCountText + " | text: '" + gTxt + "' | isActiveAndEnabled: " + gIsAE + " | fontSize: " + gFSize);
                                                try {
                                                    var gGo = getGoFn(groupCountText);
                                                    if (!gGo.isNull()) {
                                                        setActiveFn(gGo, 1, NULL);
                                                    }
                                                } catch (eGgo) {}
                                                if (!gTxt || gTxt.length === 0) {
                                                    setTextFn(groupCountText, createIl2CppString("1 / 1"), NULL);
                                                    log("[📊 GROUP COUNT] Force set text to: 1 / 1");
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (eSdl) {
                                log("[-] Error in ShowDefaultLayout post-update: " + eSdl.message);
                            }
                        }
                    });
                    log("[+] Hooked InventoryView.ShowDefaultLayout (0x1055ED0) successfully!");
                } catch (eSdlHook) {}

                // --- Hook InventoryScene.OnOpen (0x1051604) ---
                try {
                    Interceptor.attach(baseAddr.add(0x1051604), {
                        onEnter: function (args) {
                            activeInventorySceneInstance = args[0];
                            log("[🗃️ INVENTORY SCENE] InventoryScene.OnOpen entered! instance: " + args[0]);
                            try {
                                populateOfflineInventoryCards();
                                ensureInventoryLists(args[0]);
                            } catch (ie) {
                                log("[-] Error checking/opening inventory in InventoryScene: " + ie.message);
                            }
                        },
                        onLeave: function (retval) {
                            if (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) {
                                ensureInventoryLists(activeInventorySceneInstance);
                                try {
                                    var dclPtr = activeInventorySceneInstance.add(0x58).readPointer();
                                    var cnt = 0;
                                    log("[🗃️ INVENTORY SCENE] OnOpen.onLeave: displayCardList count=" + cnt);
                                    log("[🗃️ INVENTORY SCENE] Ensuring displayCardList and calling InvenCardView.SetData...");
                                    restoreDefaultDisplayCardList(activeInventorySceneInstance, true);
                                } catch (eOol) {
                                    log("[-] Error in InventoryScene.OnOpen.onLeave: " + eOol.message);
                                }
                            }
                            log("[🗃️ INVENTORY SCENE] InventoryScene.OnOpen completed!");
                        }
                    });
                    log("[+] Hooked InventoryScene.OnOpen (0x1051604) successfully!");
                } catch (eIs) {
                    log("[-] Error hooking InventoryScene.OnOpen: " + eIs.message);
                }

                // --- Hook InventoryScene.OnClose (0x1052FA0) ---
                try {
                    Interceptor.attach(baseAddr.add(0x1052FA0), {
                        onEnter: function (args) {
                            if (activeInventorySceneInstance && activeInventorySceneInstance.equals(args[0])) {
                                activeInventorySceneInstance = NULL;
                            }
                        }
                    });
                } catch (eIsc) {}




                // Offline Equip / Unequip Helpers and Hooks
                var refreshInventoryHeaderView = function() {
                    try {
                        if (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) {
                            var sceneView = activeInventorySceneInstance.add(0x48).readPointer();
                            if (!sceneView.isNull()) {
                                var groupView = sceneView.add(0x70).readPointer();
                                if (!groupView.isNull()) {
                                    var refreshGroupViewFn = new NativeFunction(baseAddr.add(0xF25124), "void", ["pointer"]);
                                    refreshGroupViewFn(groupView);
                                    log("[🔄 INVENTORY] InvenGroupView.Refresh() triggered successfully!");
                                }
                            }
                        }
                    } catch (eR) {
                        log("[-] Error refreshing Inventory header view: " + eR.message);
                    }
                };

                var refreshInventoryCardList = function() {
                    try {
                        if (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) {
                            var updateDisplayFn = new NativeFunction(baseAddr.add(0x10542F4), "void", ["pointer", "int", "int", "int", "pointer"]);
                            updateDisplayFn(activeInventorySceneInstance, 1, 0, 1, NULL);
                            log("[🔄 INVENTORY] UpdateDisplayCardList triggered successfully!");

                            var onUpdateCardCountFn = new NativeFunction(baseAddr.add(0x1054BB4), "void", ["pointer", "pointer"]);
                            onUpdateCardCountFn(activeInventorySceneInstance, NULL);
                        }
                    } catch (eUd) {
                        log("[-] Error refreshing display card list: " + eUd.message);
                    }
                };

                var handleCardEquipOffline = function(beforeCardItem, newCardItem) {
                    try {
                        if (!newCardItem || newCardItem.isNull()) return;
                        var raw = newCardItem.add(0x10).readPointer();
                        if (raw.isNull()) return;
                        var objId = raw.add(0x10).readU64();
                        var cardId = raw.add(0x20).readS32();
                        var memberIdx = ((cardId - 1001) % 11);
                        log("[🗃️ EQUIP] Equipping card: objID=" + objId + ", cardID=" + cardId + ", memberIdx=" + memberIdx);

                        var profile = loadPlayerProfile();
                        if (profile && profile.inventoryCards) {
                            for (var i = 0; i < profile.inventoryCards.length; i++) {
                                var c = profile.inventoryCards[i];
                                var cMember = ((c.cardID - 1001) % 11);
                                if (cMember === memberIdx) {
                                    if (c.objectID.toString() === objId.toString()) {
                                        c.isEquip = true;
                                    } else {
                                        c.isEquip = false;
                                    }
                                }
                            }
                            if (!profile.equipedCards) profile.equipedCards = {};
                            var newEqList = [];
                            for (var m = 0; m < 11; m++) {
                                var eqC = profile.inventoryCards.find(function(c) {
                                    return ((c.cardID - 1001) % 11) === m && c.isEquip;
                                });
                                if (eqC) {
                                    newEqList.push(eqC.objectID);
                                }
                            }
                            profile.equipedCards["1001"] = newEqList;
                            savePlayerProfile(profile);
                            log("[💾 PROFILE] Saved player_profile.json after equip! Member " + memberIdx + " updated.");
                        }

                        // Update in-memory loonaCardItems
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                var r = itm.add(0x10).readPointer();
                                var cid = r.add(0x20).readS32();
                                var mIdx = ((cid - 1001) % 11);
                                if (mIdx === memberIdx) {
                                    var oid = r.add(0x10).readU64().toString();
                                    if (itm.equals(newCardItem) || oid === objId.toString()) {
                                        r.add(0x28).writeU8(1);
                                    } else {
                                        r.add(0x28).writeU8(0);
                                    }
                                }
                            }
                            sortLoonaCardItems();
                        }

                        // Rebuild FastArray for group
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            var loonaEquippedCards = [];
                            var memberFilled = {};
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                var r = itm.add(0x10).readPointer();
                                var cid = r.add(0x20).readS32();
                                var mIdx = ((cid - 1001) % 11);
                                if (mIdx < 11) {
                                    var isEq = (r.add(0x28).readU8() === 1);
                                    if (isEq && !memberFilled[mIdx]) {
                                        loonaEquippedCards.push(itm);
                                        memberFilled[mIdx] = true;
                                    }
                                }
                            }
                            loonaCardListFastArray = createFastArray(loonaEquippedCards, 'card');
                            if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                                loonaGroupItemObj.add(0x28).writePointer(loonaCardListFastArray);
                            }
                        }

                        refreshInventoryHeaderView();
                        refreshInventoryCardList();
                    } catch (eHeq) {
                        log("[-] Error in handleCardEquipOffline: " + eHeq.message);
                    }
                };

                var handleCardUnequipOffline = function(cardItem) {
                    try {
                        if (!cardItem || cardItem.isNull()) return;
                        var raw = cardItem.add(0x10).readPointer();
                        if (raw.isNull()) return;
                        var objId = raw.add(0x10).readU64();
                        var cardId = raw.add(0x20).readS32();
                        var memberIdx = ((cardId - 1001) % 11);
                        log("[🗃️ UNEQUIP] Unequipping card: objID=" + objId + ", cardID=" + cardId);

                        raw.add(0x28).writeU8(0);

                        var profile = loadPlayerProfile();
                        if (profile && profile.inventoryCards) {
                            for (var i = 0; i < profile.inventoryCards.length; i++) {
                                var c = profile.inventoryCards[i];
                                if (c.objectID.toString() === objId.toString()) {
                                    c.isEquip = false;
                                }
                            }
                            if (profile.equipedCards && profile.equipedCards["1001"]) {
                                profile.equipedCards["1001"] = profile.equipedCards["1001"].filter(function(id) {
                                    return id.toString() !== objId.toString();
                                });
                            }
                            savePlayerProfile(profile);
                            log("[💾 PROFILE] Saved player_profile.json after unequip!");
                        }

                        // Sync in-memory native cards
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                var r = itm.add(0x10).readPointer();
                                var cid = r.add(0x20).readS32();
                                var oid = r.add(0x10).readU64().toString();
                                if (oid === objId.toString()) {
                                    r.add(0x28).writeU8(0);
                                }
                            }
                        }

                        // Rebuild FastArray
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            var loonaEquippedCards = [];
                            var memberFilled = {};
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                var r = itm.add(0x10).readPointer();
                                var cid = r.add(0x20).readS32();
                                var mIdx = ((cid - 1001) % 11);
                                if (mIdx < 11) {
                                    var isEq = (r.add(0x28).readU8() === 1);
                                    if (isEq && !memberFilled[mIdx]) {
                                        loonaEquippedCards.push(itm);
                                        memberFilled[mIdx] = true;
                                    }
                                }
                            }
                            loonaCardListFastArray = createFastArray(loonaEquippedCards, 'card');
                            if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                                loonaGroupItemObj.add(0x28).writePointer(loonaCardListFastArray);
                            }
                        }

                        refreshInventoryHeaderView();
                        refreshInventoryCardList();
                    } catch (eUneq) {
                        log("[-] Error in handleCardUnequipOffline: " + eUneq.message);
                    }
                };

                var handleAutoEquipOffline = function() {
                    try {
                        log("[🗃️ AUTO_EQUIP] Processing optimal cards for LOONA OT11...");
                        var profile = loadPlayerProfile();
                        if (!profile || !profile.inventoryCards) return;

                        var newEqList = [];
                        for (var m = 0; m < 11; m++) {
                            var memberCards = profile.inventoryCards.filter(function(c) {
                                return ((c.cardID - 1001) % 11) === m;
                            });
                            if (memberCards.length > 0) {
                                memberCards.sort(function(a, b) {
                                    var ga = a.grade !== undefined ? a.grade : 0;
                                    var gb = b.grade !== undefined ? b.grade : 0;
                                    if (ga !== gb) return gb - ga;
                                    var la = a.level || 0;
                                    var lb = b.level || 0;
                                    return lb - la;
                                });
                                memberCards[0].isEquip = true;
                                newEqList.push(memberCards[0].objectID);
                                for (var k = 1; k < memberCards.length; k++) {
                                    memberCards[k].isEquip = false;
                                }
                            }
                        }
                        if (!profile.equipedCards) profile.equipedCards = {};
                        profile.equipedCards["1001"] = newEqList;
                        savePlayerProfile(profile);
                        log("[💾 PROFILE] Auto Equip saved " + newEqList.length + " equipped cards to player_profile.json!");

                        // Sync in-memory native cards
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                var r = itm.add(0x10).readPointer();
                                var cid = r.add(0x20).readS32();
                                var oid = r.add(0x10).readU64().toString();
                                var isE = newEqList.some(function(id) { return id.toString() === oid; });
                                r.add(0x28).writeU8(isE ? 1 : 0);
                            }
                        }

                        // Rebuild FastArray
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            var loonaEquippedCards = [];
                            var memberFilled = {};
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                var r = itm.add(0x10).readPointer();
                                var cid = r.add(0x20).readS32();
                                var mIdx = ((cid - 1001) % 11);
                                if (mIdx < 11) {
                                    var isEq = (r.add(0x28).readU8() === 1);
                                    if (isEq && !memberFilled[mIdx]) {
                                        loonaEquippedCards.push(itm);
                                        memberFilled[mIdx] = true;
                                    }
                                }
                            }
                            loonaCardListFastArray = createFastArray(loonaEquippedCards, 'card');
                            if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                                loonaGroupItemObj.add(0x28).writePointer(loonaCardListFastArray);
                            }
                        }

                        refreshInventoryHeaderView();
                        refreshInventoryCardList();
                    } catch (eAe) {
                        log("[-] Error in handleAutoEquipOffline: " + eAe.message);
                    }
                };

                var handleAllUnequipOffline = function() {
                    try {
                        log("[🗃️ ALL_UNEQUIP] Unequipping all cards...");
                        var profile = loadPlayerProfile();
                        if (!profile || !profile.inventoryCards) return;

                        for (var i = 0; i < profile.inventoryCards.length; i++) {
                            profile.inventoryCards[i].isEquip = false;
                        }
                        if (!profile.equipedCards) profile.equipedCards = {};
                        profile.equipedCards["1001"] = [];
                        savePlayerProfile(profile);
                        log("[💾 PROFILE] All Unequip saved to player_profile.json!");

                        // Sync in-memory native cards
                        if (loonaCardItems && loonaCardItems.length > 0) {
                            for (var k = 0; k < loonaCardItems.length; k++) {
                                var itm = loonaCardItems[k];
                                var r = itm.add(0x10).readPointer();
                                r.add(0x28).writeU8(0);
                            }
                        }

                        // FastArray with empty list
                        loonaCardListFastArray = createFastArray([], 'card');
                        if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                            loonaGroupItemObj.add(0x28).writePointer(loonaCardListFastArray);
                        }

                        refreshInventoryHeaderView();
                        refreshInventoryCardList();
                    } catch (eAu) {
                        log("[-] Error in handleAllUnequipOffline: " + eAu.message);
                    }
                };

                // Replace InventoryControl.Equip (0xF2C374) with offline handler
                try {
                    Interceptor.replace(baseAddr.add(0xF2C374), new NativeCallback(function (isEnterImmediately, beforeCardItem, newCardItem, callback, methodInfo) {
                        log("[🗃️ INVENTORY_CONTROL] Offline Equip called! before=" + beforeCardItem + ", new=" + newCardItem);
                        handleCardEquipOffline(beforeCardItem, newCardItem);
                        if (callback && !callback.isNull()) {
                            try {
                                var invokePtr = callback.add(Process.pointerSize * 2).readPointer();
                                if (!invokePtr.isNull()) {
                                    var invokeFn = new NativeFunction(invokePtr, "void", ["pointer", "int", "pointer"]);
                                    invokeFn(callback, 0, NULL);
                                    log("[🗃️ INVENTORY_CONTROL] Invoked Equip callback(0) -> Success!");
                                }
                            } catch (eCb) {
                                log("[-] Error invoking Equip callback: " + eCb.message);
                            }
                        }
                    }, "void", ["int", "pointer", "pointer", "pointer", "pointer"]));
                    log("[+] Replaced InventoryControl.Equip (0xF2C374) successfully!");
                } catch (eEqHook) {
                    log("[-] Error replacing InventoryControl.Equip: " + eEqHook.message);
                }

                // Replace InventoryControl.Unequip (0xF2C5E4) with offline handler
                try {
                    Interceptor.replace(baseAddr.add(0xF2C5E4), new NativeCallback(function (cardItem, callback, methodInfo) {
                        log("[🗃️ INVENTORY_CONTROL] Offline Unequip called! card=" + cardItem);
                        handleCardUnequipOffline(cardItem);
                        if (callback && !callback.isNull()) {
                            try {
                                var invokePtr = callback.add(Process.pointerSize * 2).readPointer();
                                if (!invokePtr.isNull()) {
                                    var invokeFn = new NativeFunction(invokePtr, "void", ["pointer", "int", "pointer"]);
                                    invokeFn(callback, 0, NULL);
                                    log("[🗃️ INVENTORY_CONTROL] Invoked Unequip callback(0) -> Success!");
                                }
                            } catch (eCb) {
                                log("[-] Error invoking Unequip callback: " + eCb.message);
                            }
                        }
                    }, "void", ["pointer", "pointer", "pointer"]));
                    log("[+] Replaced InventoryControl.Unequip (0xF2C5E4) successfully!");
                } catch (eUneqHook) {
                    log("[-] Error replacing InventoryControl.Unequip: " + eUneqHook.message);
                }

                // Hook InventoryScene.OnAutoEquip (0x105C024)
                try {
                    Interceptor.replace(baseAddr.add(0x105C024), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[🗃️ AUTO_EQUIP] InventoryScene.OnAutoEquip clicked! Executing offline Auto Equip...");
                        handleAutoEquipOffline();
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Replaced InventoryScene.OnAutoEquip (0x105C024) successfully!");
                } catch (eOae) {
                    log("[-] Error replacing InventoryScene.OnAutoEquip: " + eOae.message);
                }

                // Hook InventoryScene.OnAllUnequip (0x105C158)
                try {
                    Interceptor.replace(baseAddr.add(0x105C158), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[🗃️ ALL_UNEQUIP] InventoryScene.OnAllUnequip clicked! Executing offline All Unequip...");
                        handleAllUnequipOffline();
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Replaced InventoryScene.OnAllUnequip (0x105C158) successfully!");
                } catch (eOau) {
                    log("[-] Error replacing InventoryScene.OnAllUnequip: " + eOau.message);
                }

                // Hook InvenCardEquipView.OnEquip (0xF21D7C) & InventoryScene.OnEquip (0x105AFC8)
                try {
                    Interceptor.attach(baseAddr.add(0xF21D7C), {
                        onEnter: function (args) {
                            log("[🔘 EQUIP_VIEW] InvenCardEquipView.OnEquip clicked! view=" + args[0]);
                        }
                    });
                    log("[+] Hooked InvenCardEquipView.OnEquip (0xF21D7C) successfully!");
                } catch (eEqv) {
                    log("[-] Error hooking InvenCardEquipView.OnEquip: " + eEqv.message);
                }

                try {
                    Interceptor.replace(baseAddr.add(0x105AFC8), new NativeCallback(function (sceneThis, methodInfo) {
                        log("[🗃️ EQUIP] InventoryScene.OnEquip entered! scene=" + sceneThis);
                        try {
                            var selectedCardItem = sceneThis.add(0x88).readPointer();
                            var equippedCardItem = sceneThis.add(0x90).readPointer();
                            log("[🗃️ EQUIP] [0x88]=" + selectedCardItem + ", [0x90]=" + equippedCardItem);
                            
                            // In OnChange, Dalcom stored:
                            // [0x90] = card selected to equip (newCardItem)
                            // [0x88] = card previously equipped (beforeCardItem, or null if empty)
                            var newCard = equippedCardItem;
                            var beforeCard = selectedCardItem;
                            
                            // If newCard is null, try fallback
                            if (newCard.isNull() && !beforeCard.isNull()) {
                                newCard = beforeCard;
                                beforeCard = NULL;
                            }
                            
                            handleCardEquipOffline(beforeCard, newCard);
                            
                            // Return to default inventory state
                            var setStateDefaultFn = new NativeFunction(baseAddr.add(0x1053B88), "void", ["pointer", "bool", "bool", "pointer"]);
                            setStateDefaultFn(sceneThis, 1, 0, NULL);
                            log("[🗃️ EQUIP] Returned to SetStateDefault successfully!");
                        } catch (eEq) {
                            log("[-] Error in InventoryScene.OnEquip: " + eEq.message);
                        }
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Replaced InventoryScene.OnEquip (0x105AFC8) successfully!");
                } catch (eOeq) {
                    log("[-] Error replacing InventoryScene.OnEquip: " + eOeq.message);
                }

                // =========================================================================
                // ⚡ CARD INTENSIFY CONTROL (0x137F644, 0x137F7E0, 0x13819A4, 0x1381780)
                // =========================================================================
                try {
                    // 1. CardIntensifyControl.get_IsOpened (0x137F644) -> return 1
                    Interceptor.replace(baseAddr.add(0x137F644), new NativeCallback(function() {
                        return 1;
                    }, "bool", []));

                    // 2. CardIntensifyControl.Open (0x137F7E0) -> safe no-op
                    Interceptor.replace(baseAddr.add(0x137F7E0), new NativeCallback(function() {
                        log("[⚡ INTENSIFY] CardIntensifyControl.Open() invoked safely offline!");
                    }, "void", []));

                    // 3. CardIntensifyControl.GetCode (0x13819A4) -> returns formula code (short)
                    Interceptor.replace(baseAddr.add(0x13819A4), new NativeCallback(function(grade, level) {
                        var gr = parseInt(grade, 10) || 0;
                        var lvl = Math.max(1, parseInt(level, 10) || 1);
                        var code = (gr < 4) ? (gr * 5 + Math.min(4, lvl - 1)) : (20 + Math.min(98, lvl - 1));
                        return code;
                    }, "int16", ["int", "int16"]));

                    // 4. CardIntensifyControl.Find(short code, short subCode) (0x1381780) -> returns Item*
                    var cachedCardIntensifyItemKlass = NULL;
                    Interceptor.replace(baseAddr.add(0x1381780), new NativeCallback(function(codeArg, subCodeArg) {
                        try {
                            var code = parseInt(codeArg, 10);
                            var subCode = parseInt(subCodeArg, 10);
                            if (!cachedCardIntensifyItemKlass || cachedCardIntensifyItemKlass.isNull()) {
                                try {
                                    var slotVal = baseAddr.add(0x30F1E38).readPointer();
                                    if (!slotVal.isNull() && slotVal.compare(ptr(0x100000000)) > 0) {
                                        cachedCardIntensifyItemKlass = slotVal;
                                    } else {
                                        var classInitFn = new NativeFunction(baseAddr.add(0xA43BE8), 'void', ['pointer']);
                                        classInitFn(baseAddr.add(0x30F1E38));
                                        cachedCardIntensifyItemKlass = baseAddr.add(0x30F1E38).readPointer();
                                    }
                                } catch (eSlot) {}
                                if (!cachedCardIntensifyItemKlass || cachedCardIntensifyItemKlass.isNull()) {
                                    try {
                                        var parentCic = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "CardIntensifyControl");
                                        if (parentCic && !parentCic.isNull()) {
                                            cachedCardIntensifyItemKlass = getNestedClass(parentCic, "Item");
                                        }
                                    } catch (eNest) {}
                                }
                                if (cachedCardIntensifyItemKlass && !cachedCardIntensifyItemKlass.isNull()) {
                                    log("[+] Resolved CardIntensifyControl.Item class: " + cachedCardIntensifyItemKlass);
                                }
                            }

                            var itemObj = NULL;
                            if (cachedCardIntensifyItemKlass && !cachedCardIntensifyItemKlass.isNull() && il2cpp_object_new) {
                                try {
                                    itemObj = il2cpp_object_new(cachedCardIntensifyItemKlass);
                                } catch (eNew) {
                                    log("[-] il2cpp_object_new failed: " + eNew.message);
                                }
                            }
                            if (!itemObj || itemObj.isNull()) {
                                itemObj = Memory.alloc(0x30);
                                if (cachedCardIntensifyItemKlass && !cachedCardIntensifyItemKlass.isNull()) {
                                    itemObj.writePointer(cachedCardIntensifyItemKlass);
                                }
                                log("[+] Fallback allocated Item buffer: " + itemObj);
                            } else {
                                if (il2cpp_gchandle_new) {
                                    try { il2cpp_gchandle_new(itemObj, 2); } catch (eGc) {}
                                }
                            }

                            var subGrade = 0;
                            var subLvl = 1;
                            if (subCode < 5) { subGrade = 0; subLvl = subCode + 1; }
                            else if (subCode < 10) { subGrade = 1; subLvl = subCode - 5 + 1; }
                            else if (subCode < 15) { subGrade = 2; subLvl = subCode - 10 + 1; }
                            else if (subCode < 20) { subGrade = 3; subLvl = subCode - 15 + 1; }
                            else { subGrade = 4; subLvl = subCode - 20 + 1; }

                            var gradeLetters = ["C", "B", "A", "S", "R"];
                            var matKey = (gradeLetters[subGrade] || "C") + subLvl;
                            var priceKey = matKey + "Price";

                            var rate = 70.0;
                            var price = 100;
                            loadOfflineCardDataTables();

                            if (cidCache && cidCache[code]) {
                                var row = cidCache[code];
                                if (row[matKey] !== undefined && row[matKey] >= 0) rate = row[matKey];
                                if (row[priceKey] !== undefined && row[priceKey] > 0) price = row[priceKey];
                            } else {
                                var basePrices = [93, 110, 131, 154, 176];
                                price = (basePrices[subGrade] || 100) + (subLvl - 1) * 2;
                                rate = (subGrade >= 4) ? 50.0 : 70.0;
                            }

                            itemObj.add(0x10).writeDouble(rate);
                            itemObj.add(0x18).writeS32(price);
                            itemObj.add(0x1C).writeU8(0); // isMaterial = false

                            log("[⚡ INTENSIFY FIND] code=" + code + ", subCode=" + subCode + " (" + matKey + ") -> Rate=" + rate.toFixed(1) + "%, Price=" + price + " RP");
                            return itemObj;
                        } catch (eFind) {
                            log("[-] Error in CardIntensifyControl.Find: " + eFind.message);
                            try {
                                var fallbackObj = Memory.alloc(0x30);
                                if (cachedCardIntensifyItemKlass && !cachedCardIntensifyItemKlass.isNull()) {
                                    fallbackObj.writePointer(cachedCardIntensifyItemKlass);
                                }
                                fallbackObj.add(0x10).writeDouble(50.0);
                                fallbackObj.add(0x18).writeS32(100);
                                fallbackObj.add(0x1C).writeU8(0);
                                return fallbackObj;
                            } catch (eFb) {
                                return NULL;
                            }
                        }
                    }, "pointer", ["int16", "int16"]));

                    // 5. CardIntensifyControl.Find(CardGrade, short, CardGrade, short) (0x1383BDC) -> returns Item*
                    Interceptor.replace(baseAddr.add(0x1383BDC), new NativeCallback(function(grade, level, subGrade, subLevel) {
                        try {
                            var gr = parseInt(grade, 10) || 0;
                            var lvl = Math.max(1, parseInt(level, 10) || 1);
                            var sGr = parseInt(subGrade, 10) || 0;
                            var sLvl = Math.max(1, parseInt(subLevel, 10) || 1);

                            var code = (gr < 4) ? (gr * 5 + Math.min(4, lvl - 1)) : (20 + Math.min(98, lvl - 1));
                            var subCode = (sGr < 4) ? (sGr * 5 + Math.min(4, sLvl - 1)) : (20 + Math.min(98, sLvl - 1));

                            var findFn = new NativeFunction(baseAddr.add(0x1381780), "pointer", ["int16", "int16"]);
                            return findFn(code, subCode);
                        } catch (eFind4) {
                            log("[-] Error in CardIntensifyControl.Find(4 args): " + eFind4.message);
                            return NULL;
                        }
                    }, "pointer", ["int", "int16", "int", "int16"]));

                    log("[+] CardIntensifyControl hooks installed successfully!");
                } catch (eCicHooks) {
                    log("[-] Error installing CardIntensifyControl hooks: " + eCicHooks.message);
                }

                // 6. Global IL2CPP exception monitor (0x9C4B08)
                try {
                    Interceptor.attach(baseAddr.add(0x9C4B08), {
                        onEnter: function(args) {
                            var exc = args[0];
                            var lr = this.returnAddress;
                            var off = lr.sub(baseAddr);
                            var msg = "";
                            try {
                                if (!exc.isNull()) {
                                    var msgStr = exc.add(0x10).readPointer();
                                    if (!msgStr.isNull()) {
                                        var len = msgStr.add(0x10).readS32();
                                        msg = msgStr.add(0x14).readUtf16String(Math.min(len, 200));
                                    }
                                }
                            } catch(e) {}
                            log("[💥 IL2CPP EXCEPTION 0x9C4B08] Raised from RVA: " + off + " (LR=" + lr + ") msg: " + msg);
                        }
                    });
                    log("[+] Global IL2CPP exception monitor installed (0x9C4B08)!");
                } catch (eExcMon) {
                    log("[-] Error installing exception monitor: " + eExcMon.message);
                }





                // InventoryScene.OnRecommend (0x105B4F4) -> Smart Recommend material selection
                try {
                    Interceptor.replace(baseAddr.add(0x105B4F4), new NativeCallback(function(sceneThis) {
                        log("[⚡ RECOMMEND UI BUTTON] Native OnRecommend clicked! Triggering executeRecommend...");
                        executeRecommend(sceneThis);
                    }, "void", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryScene.OnRecommend (0x105B4F4)!");
                } catch (eRecUi) {
                    log("[-] Error hooking InventoryScene.OnRecommend: " + eRecUi.message);
                }

                // Diagnostic: Monitor il2cpp_codegen_raise_null_reference_exception (0xA43CC0)
                try {
                    Interceptor.attach(baseAddr.add(0xA43CC0), {
                        onEnter: function(args) {
                            var lr = this.returnAddress;
                            var offset = lr.sub(baseAddr);
                            log("[💥 NULL REF EXCEPTION] Called from offset: " + offset + " (LR=" + lr + ")");
                        }
                    });
                } catch (eNre) {}

                // InventoryScene.OnIntensify (0x105A97C)
                try {
                    Interceptor.attach(baseAddr.add(0x105A97C), {
                        onEnter: function(args) {
                            var sceneThis = args[0];
                            log("[⚡ INVENTORY] InventoryScene.OnIntensify called! instance=" + sceneThis);
                            try {
                                var tCard = sceneThis.add(0x88).readPointer();
                                if (tCard.isNull()) tCard = sceneThis.add(0x98).readPointer();
                                if (!tCard.isNull()) {
                                    sceneThis.add(0x88).writePointer(tCard);
                                    sceneThis.add(0x98).writePointer(tCard);
                                    var tRaw = tCard.add(0x10).readPointer();
                                    if (!tRaw.isNull()) {
                                        var tcId = tRaw.add(0x20).readS32();
                                        var tCcd = getOrCreateCardControlData(tcId);
                                        tCard.add(0x18).writePointer(tCcd || NULL);
                                        var tGr = tRaw.add(0x24).readS32();
                                        var tLvl = tRaw.add(0x1C).readS16();
                                        var tCode = (tGr < 4) ? (tGr * 5 + Math.min(4, tLvl - 1)) : (20 + Math.min(98, tLvl - 1));
                                        tCard.add(0x20).writeS16(tCode);
                                        log("[⚡ INVENTORY OnIntensify] Prepared targetCard: cardID=" + tcId + ", code=" + tCode + ", ccd=" + tCcd);
                                    }
                                }
                            } catch (ePrep) {
                                log("[-] Error in OnIntensify targetCard prep: " + ePrep.message);
                            }
                        }
                    });
                } catch (eOi) {
                    log("[-] Error hooking InventoryScene.OnIntensify: " + eOi.message);
                }

                // InventoryScene.SetStateIntensify (0x1056BCC)
                try {
                    Interceptor.attach(baseAddr.add(0x1056BCC), {
                        onEnter: function(args) {
                            var sceneThis = args[0];
                            log("[⚡ INVENTORY] InventoryScene.SetStateIntensify called! isReload=" + args[1] + ", isUpdate=" + args[2]);
                            try {
                                var tCard = sceneThis.add(0x88).readPointer();
                                if (tCard.isNull()) tCard = sceneThis.add(0x98).readPointer();
                                if (!tCard.isNull()) {
                                    sceneThis.add(0x88).writePointer(tCard);
                                    sceneThis.add(0x98).writePointer(tCard);
                                    var tRaw = tCard.add(0x10).readPointer();
                                    if (!tRaw.isNull()) {
                                        var tcId = tRaw.add(0x20).readS32();
                                        var tCcd = getOrCreateCardControlData(tcId);
                                        tCard.add(0x18).writePointer(tCcd || NULL);
                                        var tGr = tRaw.add(0x24).readS32();
                                        var tLvl = tRaw.add(0x1C).readS16();
                                        var tCode = (tGr < 4) ? (tGr * 5 + Math.min(4, tLvl - 1)) : (20 + Math.min(98, tLvl - 1));
                                        tCard.add(0x20).writeS16(tCode);
                                    }
                                }
                                if (sceneThis.add(0xA8).readDouble() === 0.0) {
                                    sceneThis.add(0xA8).writeDouble(1.0);
                                }
                                if (sceneThis.add(0xB0).readDouble() === 0.0) {
                                    sceneThis.add(0xB0).writeDouble(1.0);
                                }
                            } catch (eSsi) {
                                log("[-] Error in SetStateIntensify onEnter: " + eSsi.message);
                            }
                        }
                    });
                } catch (eSsi) {
                    log("[-] Error hooking InventoryScene.SetStateIntensify: " + eSsi.message);
                }

                // =========================================================================
                // ⚡ PHASE 2: OFFLINE INTENSIFY (POWER UP) SYSTEM
                // =========================================================================
                function handleOfflineIntensify(cardItem, materialCardItemList, priceList, probabilityRate, priceRate, callback) {
                    log("[⚡ INTENSIFY EXEC] Starting offline intensify calculation...");
                    if (!cardItem || cardItem.isNull()) {
                        log("[-] cardItem is null!");
                        return;
                    }
                    var rawObj = cardItem.add(0x10).readPointer();
                    if (!rawObj || rawObj.isNull()) {
                        log("[-] cardItem.Raw is null!");
                        return;
                    }

                    var targetObjId = rawObj.add(0x10).readS64();
                    var cardId = rawObj.add(0x18).readS32();
                    var score = rawObj.add(0x1A).readS16();
                    var level = rawObj.add(0x1C).readS16();
                    var energy = rawObj.add(0x1E).readS16();
                    var grade = rawObj.add(0x24).readS32();
                    var isPrism = (rawObj.add(0x2A).readU8() !== 0);
                    var maxLevel = (grade === 4) ? 50 : 5;

                    log("[⚡ INTENSIFY] Target Card: ID=" + cardId + " (ObjectID=" + targetObjId + "), Grade=" + grade + ", Level=" + level + "/" + maxLevel + ", Score=" + score + ", Energy=" + energy);

                    var matCount = 0;
                    var matItemsArr = NULL;
                    if (materialCardItemList && !materialCardItemList.isNull()) {
                        matCount = materialCardItemList.add(0x18).readS32();
                        matItemsArr = materialCardItemList.add(0x10).readPointer();
                    }

                    var materials = [];
                    var totalCost = 0;
                    for (var i = 0; i < matCount; i++) {
                        var itemPtr = matItemsArr.add(0x20 + i * Process.pointerSize).readPointer();
                        if (!itemPtr.isNull()) {
                            var mRaw = itemPtr.add(0x10).readPointer();
                            var mObjId = mRaw.add(0x10).readS64();
                            var mGrade = mRaw.add(0x24).readS32();
                            var mLevel = mRaw.add(0x1C).readS16();
                            materials.push({ itemPtr: itemPtr, rawPtr: mRaw, objId: mObjId, grade: mGrade, level: mLevel });
                        }
                    }
                    log("[⚡ INTENSIFY] Material cards count: " + materials.length);

                    var results = []; // 0 = SUCCESS, 1 = FAILED
                    var successes = 0;
                    var currentLvl = level;

                    for (var mIdx = 0; mIdx < materials.length; mIdx++) {
                        var m = materials[mIdx];
                        var info = getIntensifyPriceAndRate(grade, currentLvl, m.grade, m.level);
                        totalCost += info.price;
                        var roll = Math.random() * 100.0;
                        var isSuccess = (roll < info.rate) && (currentLvl < maxLevel);
                        if (isSuccess) {
                            results.push(0); // CardIntensifyResult.SUCCESS = 0
                            currentLvl++;
                            successes++;
                            log("[🎲 ROLL] Material #" + (mIdx + 1) + " (Grade " + m.grade + " Lvl " + m.level + "): Rate=" + info.rate.toFixed(1) + "%, Roll=" + roll.toFixed(1) + " -> 🎉 SUCCESS! New level=" + currentLvl);
                        } else {
                            results.push(1); // CardIntensifyResult.FAILED = 1
                            log("[🎲 ROLL] Material #" + (mIdx + 1) + " (Grade " + m.grade + " Lvl " + m.level + "): Rate=" + info.rate.toFixed(1) + "%, Roll=" + roll.toFixed(1) + " -> ❌ FAILED.");
                        }
                    }

                    var newStats = getCardBaseStats(grade, currentLvl, isPrism);
                    log("[⚡ STATS] Result level: " + currentLvl + " (Successes: " + successes + "/" + materials.length + ") | Score=" + newStats.score + ", Energy=" + newStats.energy + " | Total Cost: " + totalCost + " RP");

                    // Update target card in memory
                    rawObj.add(0x1C).writeS16(currentLvl);
                    rawObj.add(0x1A).writeS16(newStats.score);
                    rawObj.add(0x1E).writeS16(newStats.energy);

                    // Update player_profile.json
                    try {
                        var profile = loadPlayerProfile();
                        if (profile) {
                            if (profile.rhythmPoint !== undefined) {
                                profile.rhythmPoint = Math.max(0, profile.rhythmPoint - totalCost);
                                log("[💰 RP] Deducted " + totalCost + " RP. Remaining: " + profile.rhythmPoint);
                            }
                            if (profile.inventoryCards && Array.isArray(profile.inventoryCards)) {
                                for (var c = 0; c < profile.inventoryCards.length; c++) {
                                    var cardEntry = profile.inventoryCards[c];
                                    if (cardEntry.objectID === targetObjId || cardEntry.cardID === cardId) {
                                        cardEntry.level = currentLvl;
                                        cardEntry.score = newStats.score;
                                        cardEntry.energy = newStats.energy;
                                    }
                                }
                                var consumedIds = {};
                                for (var k = 0; k < materials.length; k++) {
                                    consumedIds[materials[k].objId] = true;
                                }
                                profile.inventoryCards = profile.inventoryCards.filter(function(cardItemJson) {
                                    return !consumedIds[cardItemJson.objectID];
                                });
                                log("[💾 PROFILE] Consumed " + materials.length + " material cards from inventory. Remaining: " + profile.inventoryCards.length);
                            }
                            savePlayerProfile(profile);
                            setupUserControl(profile);
                        }
                    } catch (eProf) {
                        log("[-] Error updating player_profile.json: " + eProf.message);
                    }

                    // Remove consumed materials from in-memory CardMap
                    try {
                        var getCardMapFn = new NativeFunction(baseAddr.add(0xF2751C), "pointer", ["pointer"]);
                        var cardMap = getCardMapFn(NULL);
                        if (cardMap && !cardMap.isNull()) {
                            var dictRemoveFn = findMethod("mscorlib", "System.Collections.Generic", "Dictionary`2", "Remove", 1);
                            if (dictRemoveFn) {
                                for (var rmIdx = 0; rmIdx < materials.length; rmIdx++) {
                                    var mObjId = materials[rmIdx].objId;
                                    var remArgs = Memory.alloc(Process.pointerSize * 2);
                                    remArgs.writeS64(mObjId);
                                    remArgs.add(Process.pointerSize).writePointer(NULL);
                                    il2cpp_runtime_invoke(dictRemoveFn, cardMap, remArgs, NULL);
                                    log("[🗑️ CARDMAP] Removed material card " + mObjId + " from in-memory CardMap");
                                }
                            }
                        }
                    } catch (eMap) {
                        log("[-] Error removing from CardMap: " + eMap.message);
                    }

                    // Create Il2CppArray of System.Int32
                    var intKlass = getClass("mscorlib", "System", "Int32");
                    var resArr = il2cpp_array_new(intKlass, results.length);
                    for (var rIdx = 0; rIdx < results.length; rIdx++) {
                        resArr.add(0x20 + rIdx * 4).writeS32(results[rIdx]);
                    }

                    // Invoke IntensifyCallback (0xB54C74)
                    log("[🚀 CALLBACK] Invoking IntensifyCallback with 1000 (SUCCESS) and results array (len=" + results.length + ")...");
                    if (callback && !callback.isNull()) {
                        var invokeFn = new NativeFunction(baseAddr.add(0xB54C74), "void", ["pointer", "int32", "pointer", "pointer"]);
                        invokeFn(callback, 1000, resArr, NULL);
                        log("[🎉 CALLBACK COMPLETE] Intensify result dispatched successfully!");
                    } else {
                        log("[-] Warning: IntensifyCallback pointer is NULL!");
                    }
                }

                // 3. InventoryControl.Intensify (0xF1DCCC) -> offline intensify execution
                try {
                    Interceptor.replace(baseAddr.add(0xF1DCCC), new NativeCallback(function(cardItem, materialCardItemList, priceList, probabilityRate, priceRate, callback) {
                        log("[⚡ INTENSIFY NATIVE] InventoryControl.Intensify intercepted! cardItem: " + cardItem + ", materials: " + materialCardItemList + ", callback: " + callback);
                        try {
                            handleOfflineIntensify(cardItem, materialCardItemList, priceList, probabilityRate, priceRate, callback);
                        } catch (eIntExec) {
                            log("[-] Error in handleOfflineIntensify: " + eIntExec.message + " stack: " + eIntExec.stack);
                        }
                    }, "void", ["pointer", "pointer", "pointer", "double", "double", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.Intensify (0xF1DCCC)!");
                } catch (eIcInt) {
                    log("[-] Error replacing InventoryControl.Intensify: " + eIcInt.message);
                }

                var activeCardIntensifyPopup = NULL;
                // 4. Attach monitoring to CardIntensifyPopup
                try {
                    // CardIntensifyPopup.OnBuild (0x1383D5C)
                    Interceptor.attach(baseAddr.add(0x1383D5C), {
                        onEnter: function(args) {
                            log("[✨ INTENSIFY POPUP] CardIntensifyPopup.OnBuild called! popup=" + args[0]);
                            activeCardIntensifyPopup = args[0];
                        }
                    });
                    // CardIntensifyPopup.IntensifyResult (0x138467C)
                    Interceptor.attach(baseAddr.add(0x138467C), {
                        onEnter: function(args) {
                            log("[✨ INTENSIFY POPUP] CardIntensifyPopup.IntensifyResult called! isMaxLevel=" + args[1] + ", contextList=" + args[2]);
                        }
                    });
                    // IntensifyAssist.OnResultSucceed (0xF1D078)
                    Interceptor.attach(baseAddr.add(0xF1D078), {
                        onEnter: function(args) {
                            log("[✨ INTENSIFY RESULT] IntensifyAssist.OnResultSucceed called! popup=" + args[1] + ", isRCard=" + args[2]);
                        }
                    });
                    // IntensifyAssist.OnResultFailed (0xF1D894)
                    Interceptor.attach(baseAddr.add(0xF1D894), {
                        onEnter: function(args) {
                            log("[✨ INTENSIFY RESULT] IntensifyAssist.OnResultFailed called! popup=" + args[1]);
                        }
                    });
                } catch (ePopMon) {
                    log("[-] Error attaching CardIntensifyPopup monitoring: " + ePopMon.message);
                }


                // --- Helper to initialize CardBookControl.SharedInfo and MyInfo ---
                function ensureCardBookControlData() {
                    try {
                        ensureLoonaMocks();
                        populateOfflineInventoryCards();

                        // Initialize CollectionPointDataControl (BasicGradePoint dictionary)
                        try {
                            var cpOpenFn = new NativeFunction(baseAddr.add(0xDA5F44), "void", []);
                            cpOpenFn();
                            log("[📖 CARDBOOK] CollectionPointDataControl.Open() initialized!");
                        } catch (eCpo) {
                            log("[-] Error initializing CollectionPointDataControl: " + eCpo.message);
                        }

                        var infoKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "CardBookControl/Info");
                        var cbGroupItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "CardBookControl/GroupItem");
                        var cbGradeInfoKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "CardBookControl/CardbookGradeInfo");
                        var cbThemeItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "CardBookControl/ThemeItem");
                        var cbCardItemKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.app.control.contents", "CardBookControl/CardItem");
                        var cbCardDataKlass = getClass("Assembly-CSharp", "com.dalcomsoft.project.client.model.account", "CardBookCardData");

                        if (!infoKlass || infoKlass.isNull() || !cbGroupItemKlass || cbGroupItemKlass.isNull()) {
                            log("[-] Failed to resolve CardBookControl classes!");
                            return;
                        }

                        // 1. Instantiate CardBookControl.Info
                        var info = il2cpp_object_new(infoKlass);
                        if (il2cpp_gchandle_new) il2cpp_gchandle_new(info, 2);

                        // 2. Instantiate CardBookControl.CardbookGradeInfo (Grade R50)
                        var gradeInfo = NULL;
                        if (cbGradeInfoKlass && !cbGradeInfoKlass.isNull()) {
                            gradeInfo = il2cpp_object_new(cbGradeInfoKlass);
                            if (il2cpp_gchandle_new) il2cpp_gchandle_new(gradeInfo, 2);
                            gradeInfo.add(0x10).writeS32(4);     // grade = CardGrade.R (4)
                            gradeInfo.add(0x14).writeS32(50);    // currentLevel = 50
                            gradeInfo.add(0x18).writeS32(50);    // maxLevel = 50
                            gradeInfo.add(0x1C).writeS32(2400);  // currentPoint = 2400
                            gradeInfo.add(0x20).writeS32(2400);  // nextPoint = 2400
                            gradeInfo.add(0x24).writeS32(24);    // cardCount = 24
                            gradeInfo.add(0x28).writeU8(1);      // isMaxLevel = true
                        }

                        // 3. Build ThemeList for LOONA (Hi High 1001 to Make you mine 1009)
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
                        info.add(0x28).writePointer(NULL);               // Person = NULL (crucial for isMe = true)

                        // 7. Register info in CardBookControl
                        var setMyInfoFn = new NativeFunction(baseAddr.add(0x11C544C), "void", ["pointer", "pointer"]);
                        setMyInfoFn(info, NULL);

                        var setSharedInfoFn = new NativeFunction(baseAddr.add(0x11C55E4), "void", ["pointer", "pointer"]);
                        setSharedInfoFn(info, NULL);

                        var setIsOpenedFn = new NativeFunction(baseAddr.add(0x11C537C), "void", ["int", "pointer"]);
                        setIsOpenedFn(1, NULL);

                        log("[📖 CARDBOOK] Fully populated CardBookControl.Info, GroupItem, GradeInfo, ThemeList and registered MyInfo & SharedInfo!");
                    } catch (eCbData) {
                        log("[-] Error in ensureCardBookControlData: " + eCbData.message);
                    }
                }

                // --- Hook CardBookScene.OnOpen (0x11CDD64) ---
                try {
                    Interceptor.attach(baseAddr.add(0x11CDD64), {
                        onEnter: function (args) {
                            log("[📖 CARDBOOK SCENE] CardBookScene.OnOpen entered! instance: " + args[0]);
                            try {
                                ensureCardBookControlData();
                            } catch (ePop) {
                                log("[-] Error populating offline cards in CardBook: " + ePop.message);
                            }
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

                // Safe stubs for LobbyScene.OnUpdate (0xB47AB8) and LobbyScene.SetMyCollectionNewMark (0xB478DC)
                try {
                    Interceptor.replace(baseAddr.add(0xB47AB8), new NativeCallback(function (thisPtr, methodInfo) {
                        return;
                    }, "void", ["pointer", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xB478DC), new NativeCallback(function (thisPtr, methodInfo) {
                        return;
                    }, "void", ["pointer", "pointer"]));
                    log("[+] Safe stubs installed for LobbyScene.OnUpdate (0xB47AB8) & SetMyCollectionNewMark (0xB478DC)!");
                } catch (eLobbyStubs) {
                    log("[-] Error installing LobbyScene safe stubs: " + eLobbyStubs.message);
                }

                // Safe stubs for LobbyBgDataControl (Open: 0xB3EB60, Close: 0xB3EF68, get_IsOpened: 0xB3E9C4, Find: 0xB3F0A4)
                try {
                    Interceptor.replace(baseAddr.add(0xB3EB60), new NativeCallback(function (methodInfo) {
                        log("[🛡️ LOBBY BG] LobbyBgDataControl.Open safely bypassed!");
                    }, "void", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xB3EF68), new NativeCallback(function (methodInfo) {
                        log("[🛡️ LOBBY BG] LobbyBgDataControl.Close safely bypassed!");
                    }, "void", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xB3E9C4), new NativeCallback(function (methodInfo) {
                        return 1;
                    }, "bool", ["pointer"]));
                    Interceptor.replace(baseAddr.add(0xB3F0A4), new NativeCallback(function (code, methodInfo) {
                        return NULL;
                    }, "pointer", ["int16", "pointer"]));
                    log("[+] Safe stubs installed for LobbyBgDataControl (Open, Close, get_IsOpened, Find)!");
                } catch (eLbg) {
                    log("[-] Error installing LobbyBgDataControl stubs: " + eLbg.message);
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
                var cachedCmdPathStr = NULL;
                var cachedExistsMethod = null;
                var cachedReadAllTextMethod = null;
                var cachedDeleteMethod = null;
                var cmdReusableBuf = Memory.alloc(Process.pointerSize);
                var excReusableBuf = Memory.alloc(Process.pointerSize);

                var findGameObjectFn = new NativeFunction(baseAddr.add(0x1DBB16C), 'pointer', ['pointer', 'pointer']);
                var isDoneFn = new NativeFunction(baseAddr.add(0x1DB2C9C), 'int', ['pointer']);
                var getCompFn = new NativeFunction(baseAddr.add(0x10B4898), 'pointer', ['pointer', 'pointer']);
                var factoryLobbyFn = new NativeFunction(baseAddr.add(0xBEC788), 'pointer', ['pointer', 'pointer']);
                var openSceneFn = new NativeFunction(baseAddr.add(0xD52B04), 'void', ['pointer', 'pointer', 'pointer', 'pointer']);
                var completeLoadingFn = new NativeFunction(baseAddr.add(0xB3E230), 'void', ['pointer']);

                var executeSceneCommand = function(cmdRaw, sceneOverride) {
                    try {
                        if (!cmdRaw) return;
                        log("[🚀 SCENE CMD EXEC] Executing: '" + cmdRaw + "'");

                        var curScene = (sceneOverride && !sceneOverride.isNull()) ? sceneOverride : NULL;
                        var sceneId = globalSceneId;
                        if (!curScene || curScene.isNull()) {
                            if (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) {
                                curScene = activeInventorySceneInstance;
                                sceneId = 4;
                            } else {
                                try {
                                    var klassPtr = baseAddr.add(0x3146538).readPointer();
                                    if (!klassPtr.isNull() && !klassPtr.readPointer().isNull()) {
                                        var staticFields = klassPtr.readPointer().add(0xB8).readPointer();
                                        if (!staticFields.isNull()) {
                                            sceneId = staticFields.add(0x10).readS32();
                                            curScene = staticFields.add(0x20).readPointer();
                                        }
                                    }
                                } catch (eCs) {}
                            }
                        }

                        if (cmdRaw.indexOf("card:") === 0) {
                            var cardArg = cmdRaw.substring(5).trim();
                            log("[🃏 CARD CMD] Triggering card select for arg: '" + cardArg + "' on scene: " + curScene);
                            if (curScene && !curScene.isNull() && sceneId === 4) {
                                var targetCardItem = NULL;
                                try {
                                    var cardIdx = parseInt(cardArg, 10);
                                    var dclPtr = curScene.add(0x58).readPointer();
                                    if (!dclPtr.isNull()) {
                                        var listItems = dclPtr.add(0x10).readPointer();
                                        var listSize = dclPtr.add(0x18).readS32();
                                        if (isNaN(cardIdx) || cardIdx < 0 || cardIdx >= listSize) cardIdx = 0;
                                        if (!listItems.isNull() && listSize > 0) {
                                            targetCardItem = listItems.add(0x20 + cardIdx * 8).readPointer();
                                            log("[🃏 CARD CMD] Selected CardItem[" + cardIdx + "] = " + targetCardItem + " (out of " + listSize + ")");
                                        }
                                    }
                                } catch (eDclCmd) {
                                    log("[-] Error reading displayCardList in CARD CMD: " + eDclCmd.message);
                                }
                                if ((!targetCardItem || targetCardItem.isNull()) && loonaCardItems && loonaCardItems.length > 0) {
                                    targetCardItem = loonaCardItems[0];
                                }
                                if (targetCardItem && !targetCardItem.isNull()) {
                                    var rawCard = targetCardItem.add(0x10).readPointer();
                                    var cId = rawCard.add(0x20).readS32();
                                    var meta = getCardMetadata(cId);
                                    var memberIdx = (meta.artistID >= 1000) ? (meta.artistID - 1000) : meta.artistID;
                                    if (memberIdx < 1 || memberIdx > 11) memberIdx = ((cId - 1001) % 11) + 1;
                                    var artistData = loonaArtistDataMap[memberIdx] || NULL;

                                    curScene.add(0x88).writePointer(targetCardItem);
                                    curScene.add(0x98).writePointer(targetCardItem);
                                    curScene.add(0x80).writePointer(artistData);
                                    safeSetStateMain(curScene, 0);
                                    log("[🎉 CARD CMD SUCCESS] safeSetStateMain(0) invoked on InventoryScene for cardID=" + cId + ", theme=" + meta.theme);
                                }
                            } else {
                                log("[-] CARD CMD failed: curScene is null or sceneId != 4 (sceneId=" + sceneId + ", instance=" + curScene + ")");
                            }
                        } else if (cmdRaw === "diag") {
                            if (curScene && !curScene.isNull() && sceneId === 4) diagCarousel(curScene);
                        } else if (cmdRaw === "diag_mat") {
                            if (curScene && !curScene.isNull() && sceneId === 4) diagMaterialView(curScene);
                        } else if (cmdRaw === "change") {
                            if (curScene && !curScene.isNull() && sceneId === 4) {
                                log("[🗃️ CHANGE CMD] Triggering OnChange directly!");
                                var onChangeFn = new NativeFunction(baseAddr.add(0x105A61C), "void", ["pointer", "pointer"]);
                                onChangeFn(curScene, NULL);
                            }
                        } else if (cmdRaw === "intensify") {
                            if (curScene && !curScene.isNull() && sceneId === 4) {
                                log("[⚡ INTENSIFY CMD] Triggering OnIntensify directly!");
                                    var tCard = curScene.add(0x88).readPointer();
                                    if (tCard.isNull()) tCard = curScene.add(0x98).readPointer();
                                    if (!tCard.isNull()) {
                                        var tRaw = tCard.add(0x10).readPointer();
                                        if (!tRaw.isNull()) {
                                            var tcId = tRaw.add(0x20).readS32();
                                            var tCcd = getOrCreateCardControlData(tcId);
                                            tCard.add(0x18).writePointer(tCcd || NULL);
                                            var tGr = tRaw.add(0x24).readS32();
                                            var tLvl = tRaw.add(0x1C).readS16();
                                            var tCode = (tGr < 4) ? (tGr * 5 + Math.min(4, tLvl - 1)) : (20 + Math.min(98, tLvl - 1));
                                            tCard.add(0x20).writeS16(tCode);
                                        }
                                    }
                                    var onIntensifyFn = new NativeFunction(baseAddr.add(0x105A97C), "void", ["pointer"]);
                                    onIntensifyFn(curScene);
                                }
                        } else if (cmdRaw === "recommend") {
                            if (curScene && !curScene.isNull() && sceneId === 4) {
                                log("[⚡ RECOMMEND CMD] Triggering executeRecommend!");
                                executeRecommend(curScene);
                            }
                        } else if (cmdRaw === "try") {
                            if (curScene && !curScene.isNull() && sceneId === 4) {
                                log("[⚡ TRY CMD] Triggering InventoryScene.OnIntensifyTry directly!");
                                // Verify target card & materials before try
                                var tCard = curScene.add(0x88).readPointer();
                                if (!tCard.isNull()) {
                                    var tRaw = tCard.add(0x10).readPointer();
                                    if (!tRaw.isNull()) {
                                        var tcId = tRaw.add(0x20).readS32();
                                        var tCcd = getOrCreateCardControlData(tcId);
                                        tCard.add(0x18).writePointer(tCcd || NULL);
                                        var tGr = tRaw.add(0x24).readS32();
                                        var tLvl = tRaw.add(0x1C).readS16();
                                        var tCode = (tGr < 4) ? (tGr * 5 + Math.min(4, tLvl - 1)) : (20 + Math.min(98, tLvl - 1));
                                        tCard.add(0x20).writeS16(tCode);
                                    }
                                }
                                var matList = curScene.add(0xA0).readPointer();
                                if (!matList.isNull()) {
                                    var mCount = matList.add(0x18).readS32();
                                    var mItems = matList.add(0x10).readPointer();
                                    for (var m = 0; m < mCount; m++) {
                                        var mItem = mItems.add(0x20 + m * 8).readPointer();
                                        if (mItem && !mItem.isNull()) {
                                            var mRaw = mItem.add(0x10).readPointer();
                                            if (!mRaw.isNull()) {
                                                var mcId = mRaw.add(0x20).readS32();
                                                var mccd = getOrCreateCardControlData(mcId);
                                                mItem.add(0x18).writePointer(mccd || NULL);
                                                var mgr = mRaw.add(0x24).readS32();
                                                var mlvl = mRaw.add(0x1C).readS16();
                                                var mfCode = (mgr < 4) ? (mgr * 5 + Math.min(4, mlvl - 1)) : (20 + Math.min(98, mlvl - 1));
                                                mItem.add(0x20).writeS16(mfCode);
                                            }
                                        }
                                    }
                                }
                                var onTryFn = new NativeFunction(baseAddr.add(0x105BA9C), "void", ["pointer"]);
                                onTryFn(curScene);
                            }
                        } else if (cmdRaw === "try_popup") {
                            if (activeCardIntensifyPopup && !activeCardIntensifyPopup.isNull()) {
                                log("[⚡ TRY POPUP CMD] Triggering CardIntensifyPopup.OnTry on: " + activeCardIntensifyPopup);
                                var popupTryFn = new NativeFunction(baseAddr.add(0x13847D0), "void", ["pointer"]);
                                popupTryFn(activeCardIntensifyPopup);
                            } else {
                                log("[-] TRY POPUP CMD: activeCardIntensifyPopup is null!");
                            }
                        } else if (cmdRaw === "mat_diag") {
                            if (curScene && !curScene.isNull() && sceneId === 4) {
                                var target = curScene.add(0x88).readPointer();
                                var matListPtr = curScene.add(0xA0).readPointer();
                                var dcl = curScene.add(0x58).readPointer();
                                var sv = curScene.add(0x48).readPointer();
                                var bbs = (!sv.isNull()) ? sv.add(0xC0).readPointer() : NULL;
                                var matCount = (!matListPtr.isNull()) ? matListPtr.add(0x18).readS32() : 0;
                                var dclCount = (!dcl.isNull()) ? dcl.add(0x18).readS32() : 0;
                                var tCard = (!target.isNull()) ? target.add(0x18).readPointer() : NULL;
                                var tCode = (!target.isNull()) ? target.add(0x20).readS16() : -1;
                                log("[🔍 MAT_DIAG] target=" + target + " (Card=" + tCard + ", Code=" + tCode + "), matListCount=" + matCount + ", sv=" + sv + ", bbs=" + bbs + ", extractType=" + curScene.add(0x50).readS32());
                            }
                        } else if (cmdRaw === "reload_script") {
                            try {
                                var content = readTextFile("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/libscript.js");
                                if (content && content.length > 0) {
                                    writeTextFile("/data/data/com.dalcomsoft.sslo/files/libscript.js", content);
                                    log("[🔄 RELOAD] Copied external libscript.js (" + content.length + " bytes) to internal! Frida will hot-reload.");
                                } else {
                                    log("[-] reload_script: External file empty or unreadable!");
                                }
                            } catch (eRel) {
                                log("[-] Reload error: " + eRel.message);
                            }

                        } else if (cmdRaw === "equip") {
                            if (curScene && !curScene.isNull() && sceneId === 4) {
                                log("[🗃️ EQUIP CMD] Triggering OnEquip directly!");
                                var onEquipFn = new NativeFunction(baseAddr.add(0x105AFC8), "void", ["pointer", "pointer"]);
                                onEquipFn(curScene, NULL);
                            }
                        } else if (cmdRaw === "back" || cmdRaw === "close") {
                            if (curScene && !curScene.isNull()) {
                                if (sceneId === 4) {
                                    log("[🔙 BACK CMD] Closing detail via handleInventoryBack!");
                                    handleInventoryBack(curScene);
                                } else if (sceneId === 5) {
                                    log("[🔙 BACK CMD] Closing CardBook via CardBookScene.OnBack!");
                                    var cbBackFn = new NativeFunction(baseAddr.add(0x11CEDE8), "void", ["pointer", "pointer"]);
                                    cbBackFn(curScene, NULL);
                                }
                            }
                        } else {
                            var targetScene = parseInt(cmdRaw, 10);
                            if (!isNaN(targetScene) && targetScene >= 1 && targetScene <= 13) {
                                log("[🚀 SCENE CMD] Switching to SceneId: " + targetScene);
                                if (curScene && !curScene.isNull()) {
                                    if ((sceneId === 2 || sceneId === 3) && targetScene === 4) {
                                        log("[🚀 SCENE CMD] Invoking LobbyScene.OnInventory (0xB4C418) cleanly on LobbyScene: " + curScene);
                                        var onInvenFn = new NativeFunction(baseAddr.add(0xB4C418), 'void', ['pointer', 'pointer']);
                                        onInvenFn(curScene, NULL);
                                    } else {
                                        log("[🚀 SCENE CMD] Invoking Scene.SetStateOpenScene (0xD5338C) on curScene: " + curScene + " -> target: " + targetScene);
                                        var setStateOpenSceneFn = new NativeFunction(baseAddr.add(0xD5338C), 'void', ['pointer', 'int', 'pointer', 'pointer', 'pointer']);
                                        setStateOpenSceneFn(curScene, targetScene, NULL, NULL, NULL);
                                    }
                                } else {
                                    log("[🚀 SCENE CMD] curScene is null, invoking SceneControl.OpenScene direct (0xD534BC)");
                                    var openSceneDirectFn = new NativeFunction(baseAddr.add(0xD534BC), 'void', ['int', 'pointer', 'pointer']);
                                    openSceneDirectFn(targetScene, NULL, NULL);
                                }
                            }
                        }
                    } catch (eExecCmd) {
                        log("[-] Error in executeSceneCommand: " + eExecCmd.message);
                    }
                };

                // Standalone command watcher: uses POSIX access & unlink + File.readText, completely independent of SceneControl.Update
                var accessPtr = Module.findExportByName("libc.so", "access");
                var unlinkPtr = Module.findExportByName("libc.so", "unlink");
                var accessFn = accessPtr ? new NativeFunction(accessPtr, "int", ["pointer", "int"]) : null;
                var unlinkFn = unlinkPtr ? new NativeFunction(unlinkPtr, "int", ["pointer"]) : null;
                var cmdPathCStr = Memory.allocUtf8String("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt");

                var pendingSceneCommand = null;

                setInterval(function () {
                    try {
                        if (accessFn && accessFn(cmdPathCStr, 0) === 0) {
                            var content = null;
                            try {
                                var f = new File("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt", "r");
                                content = f.readText();
                                f.close();
                            } catch (eF) {}
                            if (unlinkFn) unlinkFn(cmdPathCStr);
                            if (content) {
                                var cmdTrim = content.replace(/['"]/g, '').trim();
                                if (cmdTrim.length > 0) {
                                    pendingSceneCommand = cmdTrim;
                                    log("[🚀 SCENE CMD QUEUED] Queued for Unity Main Thread: '" + cmdTrim + "'");
                                }
                            }
                        }
                    } catch (eW) {}
                }, 100);

                // Scene.Update (0xD5330C) -> runs every frame on the Unity Main Thread for whichever scene is active!
                try {
                    Interceptor.attach(baseAddr.add(0xD5330C), {
                        onEnter: function (args) {
                            if (pendingSceneCommand) {
                                var cmd = pendingSceneCommand;
                                pendingSceneCommand = null;
                                var activeScene = args[0];
                                log("[🚀 MAIN THREAD DISPATCH] Executing '" + cmd + "' on active Scene: " + activeScene);
                                executeSceneCommand(cmd, activeScene);
                            }
                        }
                    });
                    log("[+] Interceptor.attach installed on Scene.Update (0xD5330C) for main-thread command dispatch!");
                } catch (eScUp) {
                    log("[-] Error attaching to Scene.Update: " + eScUp.message);
                }



                // Startup & EntryScene boot lifecycle tracking hooks
                try {
                    Interceptor.attach(baseAddr.add(0xD202E4), {
                        onEnter: function (args) { log("[🎬 BOOT] Startup.Awake called! this: " + args[0]); }
                    });
                    Interceptor.attach(baseAddr.add(0xD20468), {
                        onEnter: function (args) { log("[🎬 BOOT] Startup.Start called! this: " + args[0]); }
                    });
                    Interceptor.attach(baseAddr.add(0xE20034), {
                        onEnter: function (args) { log("[🎬 BOOT] EntryScene.OnOpen called! this: " + args[0]); }
                    });
                    Interceptor.attach(baseAddr.add(0xE2055C), {
                        onEnter: function (args) { log("[🎬 BOOT] EntryScene.SetStateComplete called! this: " + args[0]); }
                    });
                    Interceptor.attach(baseAddr.add(0xE20C78), {
                        onEnter: function (args) { log("[🎬 BOOT] EntryScene.<SetStateComplete>b__12_0 called! Transitioning to TitleScene..."); }
                    });
                } catch (eBootDiag) {
                    log("[-] Error attaching boot diagnostics: " + eBootDiag.message);
                }

                Interceptor.attach(baseAddr.add(0xD55EE8), {
                    onEnter: function (args) {
                        sceneUpdateCounter++;
                        if (pendingSceneCommand) {
                            var cmd = pendingSceneCommand;
                            pendingSceneCommand = null;
                            log("[🚀 SCENE CONTROL DISPATCH] Executing '" + cmd + "' from SceneControl.Update!");
                            executeSceneCommand(cmd, NULL);
                        }
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

                            // Check scene navigation command file every 30 frames (fallback)
                            if (sceneUpdateCounter % 30 === 0) {
                                try {
                                    if (!cachedCmdPathStr || cachedCmdPathStr.isNull()) {
                                        cachedCmdPathStr = createIl2CppString("/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/scene_cmd.txt");
                                        if (il2cpp_gchandle_new) il2cpp_gchandle_new(cachedCmdPathStr, 0);
                                        cachedExistsMethod = findMethod("mscorlib", "System.IO", "File", "Exists", 1);
                                        cachedReadAllTextMethod = findMethod("mscorlib", "System.IO", "File", "ReadAllText", 1);
                                        cachedDeleteMethod = findMethod("mscorlib", "System.IO", "File", "Delete", 1);
                                    }
                                    if (cachedExistsMethod) {
                                        cmdReusableBuf.writePointer(cachedCmdPathStr);
                                        excReusableBuf.writePointer(NULL);
                                        var cmdExists = il2cpp_runtime_invoke(cachedExistsMethod, NULL, cmdReusableBuf, excReusableBuf);
                                        if (cmdExists && cmdExists.toInt32() !== 0) {
                                            var txtObj = il2cpp_runtime_invoke(cachedReadAllTextMethod, NULL, cmdReusableBuf, excReusableBuf);
                                            il2cpp_runtime_invoke(cachedDeleteMethod, NULL, cmdReusableBuf, excReusableBuf);
                                            if (!txtObj.isNull()) {
                                                var cmdRaw = readIl2CppString(txtObj).replace(/['"]/g, '').trim();
                                                executeSceneCommand(cmdRaw);
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

                        // Neutralize crash at 0x2DAEE8 (null sprite buffer dereference during Canvas/Scroller rebuild)
                        try {
                            Memory.protect(unityMod.base.add(0x2DAEC8), 4, "rwx");
                            unityMod.base.add(0x2DAEC8).writeU32(0xF9401B08); // ldr x8, [x24, #0x30] (checks buffer instead of count)
                            log("[🛡️ UNITY PATCH] Patched 0x2DAEC8 to 'ldr x8, [x24, #0x30]' (null sprite buffer guard)!");
                        } catch (uSpErr) {
                            log("[-] Error patching 0x2DAEC8: " + uSpErr.message);
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
    log("[DEBUG] installNativeRvaHooks returned successfully!");

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
    var csPollCount = 0;
    function installCSharpHooks() {
        if (hooksInstalled) return true;
        try {
            csPollCount++;
            var domain = il2cpp_domain_get ? il2cpp_domain_get() : NULL;
            if (csPollCount <= 3 || csPollCount % 50 === 0) {
                log("[🔍 CS POLL #" + csPollCount + "] il2cpp_domain_get() = " + domain);
            }
            if (!domain || domain.isNull()) {
                return false;
            }

            var appClass = getClass("UnityEngine.CoreModule", "UnityEngine", "Application");
            if (!appClass || appClass.isNull()) {
                appClass = getClass("UnityEngine", "UnityEngine", "Application");
            }
            if (!appClass || appClass.isNull()) {
                if (csPollCount <= 5 || csPollCount % 30 === 0) {
                    log("[🔍 CS POLL #" + csPollCount + "] appClass is NULL! Will retry...");
                }
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
        return true;
    } catch (eCs) {
        log("[-] installCSharpHooks error: " + eCs.message);
        return false;
    }
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

    log("[DEBUG] initIl2Cpp complete, starting installCSharpHooks polling...");
    installCSharpHooks();
    var pollInterval = setInterval(function () {
        if (hooksInstalled) {
            clearInterval(pollInterval);
        } else {
            installCSharpHooks();
        }
    }, 100);
}
