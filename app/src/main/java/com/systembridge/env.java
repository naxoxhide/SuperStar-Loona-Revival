package com.systembridge;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class env {
    private static Context NO_GC = null;
    public static final boolean mDebug = false;

    private static native void onCloseNative();

    private static native void onOpenNative(Context context);

    protected void finalize() throws Throwable {
    }

    public static void open(Context context) {
        NO_GC = context;
        onOpenNative(context);
    }

    public static void close() {
        onCloseNative();
        NO_GC = null;
    }

    public static Context getContext() {
        return NO_GC;
    }

    static {
        System.loadLibrary("systembridge");
    }
}
