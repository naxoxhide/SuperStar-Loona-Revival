package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* JADX INFO: compiled from: SameLogTool.java */
/* JADX INFO: loaded from: classes4.dex */
public final class aa {
    public static boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2196b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;

    static {
        if (MBridgeConstans.DEBUG) {
            return;
        }
        a = false;
        f2196b = false;
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
    }

    public static void a(String str, String str2) {
        if (!f2196b || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(a(str), str2);
    }

    public static void b(String str, String str2) {
        if (!c || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(a(str), str2);
    }

    public static void c(String str, String str2) {
        if (!d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2, th);
    }

    public static void a(String str, Throwable th) {
        if (!d || th == null) {
            return;
        }
        Log.w(a(str), th);
    }

    public static void d(String str, String str2) {
        if (!e || str2 == null) {
            return;
        }
        Log.e(a(str), str2);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!e || str2 == null || th == null) {
            return;
        }
        Log.e(a(str), str2, th);
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? "MBRIDGE_" + str : str;
    }
}
