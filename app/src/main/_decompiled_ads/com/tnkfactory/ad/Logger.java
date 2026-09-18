package com.tnkfactory.ad;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class Logger {
    public static final String TNKAD_LOG = "TNK_AD";
    public static boolean a = false;

    public static void d(String str) {
        if (a) {
            Log.d(TNKAD_LOG, str);
        }
    }

    public static void e(String str) {
        Log.e(TNKAD_LOG, str);
    }

    public static void enableLogging(boolean z) {
        a = z;
    }

    public static void i(String str) {
        if (a) {
            Log.i(TNKAD_LOG, str);
        }
    }

    public static void v(String str) {
        if (a) {
            Log.v(TNKAD_LOG, str);
        }
    }

    public static void w(String str) {
        if (a) {
            Log.w(TNKAD_LOG, str);
        }
    }
}
