with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    js = f.read()

# 1. Update loadLocalTexture2D with correct loadImageFn signature and step tracking
old_load_tex = '''                function loadLocalTexture2D(relPath) {
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
                }'''

new_load_tex = '''                function loadLocalTexture2D(relPath) {
                    if (loadedTextureCache[relPath]) {
                        var cached = loadedTextureCache[relPath];
                        try {
                            if (!cached.isNull()) {
                                var m_CachedPtr = cached.add(0x10).readPointer();
                                if (!m_CachedPtr.isNull()) {
                                    return cached;
                                }
                            }
                        } catch (eCheck) {}
                        delete loadedTextureCache[relPath];
                    }
                    var step = "init";
                    try {
                        var basePath = "/storage/emulated/0/Android/data/com.dalcomsoft.sslo/files/";
                        var fullPath = basePath + relPath;

                        step = "resolveFunctions";
                        var fileExistsFn = new NativeFunction(baseAddr.add(0x1F01DF4), "bool", ["pointer", "pointer"]);
                        var fileReadAllBytesFn = new NativeFunction(baseAddr.add(0x1F0268C), "pointer", ["pointer", "pointer"]);

                        step = "pathStr";
                        var pathStr = createIl2CppString(fullPath);
                        step = "fileExists";
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

                        if (!exists) {
                            return NULL;
                        }

                        step = "readBytes";
                        var bytesObj = fileReadAllBytesFn(pathStr, NULL);
                        if (!bytesObj || bytesObj.isNull()) {
                            return NULL;
                        }

                        step = "createTexObj";
                        var tex2dClass = getClass("UnityEngine.CoreModule", "UnityEngine", "Texture2D");
                        if (!tex2dClass || tex2dClass.isNull()) return NULL;
                        var texObj = il2cpp_object_new(tex2dClass);
                        if (!texObj || texObj.isNull()) return NULL;

                        step = "ctor";
                        var texCtorFn = new NativeFunction(baseAddr.add(0x181B6BC), "void", ["pointer", "int", "int", "pointer"]);
                        texCtorFn(texObj, 2, 2, NULL);

                        step = "loadImage";
                        var loadImageFn = new NativeFunction(baseAddr.add(0x25B3E90), "bool", ["pointer", "pointer"]);
                        var ok = loadImageFn(texObj, bytesObj);
                        if (ok) {
                            step = "filterMode";
                            try {
                                var setFilterModeFn = new NativeFunction(baseAddr.add(0x181A580), "void", ["pointer", "int", "pointer"]);
                                setFilterModeFn(texObj, 2, NULL);
                                var setAnisoFn = new NativeFunction(baseAddr.add(0x181A610), "void", ["pointer", "int", "pointer"]);
                                setAnisoFn(texObj, 8, NULL);
                            } catch (eFm) {}

                            step = "pin";
                            try {
                                if (il2cpp_gchandle_new) {
                                    il2cpp_gchandle_new(texObj, 2);
                                }
                                var dontDestroyOnLoadFn = new NativeFunction(baseAddr.add(0x1DC7FB4), "void", ["pointer", "pointer"]);
                                dontDestroyOnLoadFn(texObj, NULL);
                                var setHideFlagsFn = new NativeFunction(baseAddr.add(0x1DC7FF4), "void", ["pointer", "int", "pointer"]);
                                setHideFlagsFn(texObj, 52, NULL);
                            } catch (ePin) {}

                            loadedTextureCache[relPath] = texObj;
                            log("[🖼️ TEXTURE] Loaded and cached: " + relPath);
                            return texObj;
                        }
                    } catch (eLt) {
                        log("[-] Error in loadLocalTexture2D (" + step + ") for " + relPath + ": " + eLt.message);
                    }
                    return NULL;
                }'''

if old_load_tex in js:
    js = js.replace(old_load_tex, new_load_tex, 1)
    print("1. Successfully updated loadLocalTexture2D!")
else:
    print("FAIL 1: old_load_tex not found")

# 2. Optimize SetCdnTexture to eliminate redundant texture loads and always call handleResult callback
old_sct = '''                            // Ownership Check: wadceg vs sdhgauwehdnu
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
                            }'''

new_sct = '''                            // Ownership Check: wadceg vs sdhgauwehdnu
                            if (relPath.indexOf("wadceg/") !== -1 || relPath.indexOf("weoihxd/") !== -1 || relPath.indexOf("sdhgauwehdnu/") !== -1) {
                                var match = relPath.match(/(\\d+)_([sl])\\.i\\.bytes/);
                                if (match) {
                                    var cId = parseInt(match[1]);
                                    var folder = (accountOwnedCards[cId] || relPath.indexOf("sdhgauwehdnu/") === -1) ? "wadceg" : "sdhgauwehdnu";
                                    relPath = "asiudgasg/asodhsg/" + folder + "/" + cId + "_" + match[2] + ".i.bytes";
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

                                // If autoSize is true, resize target to texture native dimensions
                                if (autoSize !== 0) {
                                    try {
                                        var setNativeSizeFn = new NativeFunction(baseAddr.add(0x194C1C8), "void", ["pointer", "pointer"]);
                                        setNativeSizeFn(target, NULL);
                                    } catch (eSns) {}
                                }
                            }

                            // ALWAYS Trigger handleResult delegate (so Dalcomsoft scene never hangs waiting)
                            if (!handleResult.isNull()) {
                                try {
                                    var methodPtr = handleResult.add(0x10).readPointer();
                                    var targetObj = handleResult.add(0x20).readPointer();
                                    if (!methodPtr.isNull() && !targetObj.isNull()) {
                                        var cbFn = new NativeFunction(methodPtr, "void", ["pointer", "int", "pointer", "pointer"]);
                                        var hasTex = (tex && !tex.isNull());
                                        cbFn(targetObj, hasTex ? 1 : 0, hasTex ? tex : NULL, NULL);
                                        log("[✅ CDN_CALLBACK] Called handleResult for targetObj: " + targetObj + " (success=" + (hasTex ? 1 : 0) + ")");
                                    }
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
                            }'''

if old_sct in js:
    js = js.replace(old_sct, new_sct, 1)
    print("2. Successfully updated SetCdnTexture!")
else:
    print("FAIL 2: old_sct not found")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(js)
