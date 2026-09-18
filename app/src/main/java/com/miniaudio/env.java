package com.miniaudio;

import android.content.res.AssetManager;

/* JADX INFO: loaded from: classes4.dex */
public class env {
    private static AssetManager NO_GC = null;
    public static final boolean mDebug = false;

    private static native void onLoadAssetManager(AssetManager assetManager);

    private static native void onUnloadAssetManager();

    protected void finalize() throws Throwable {
    }

    public static void loadAssetManager(AssetManager assetManager) {
        NO_GC = assetManager;
        onLoadAssetManager(assetManager);
    }

    public static void unloadAssetManager() {
        onUnloadAssetManager();
        NO_GC = null;
    }

    public static AssetManager getAssetManager() {
        return NO_GC;
    }

    static {
        System.loadLibrary("openal");
        System.loadLibrary("miniaudio");
    }
}
