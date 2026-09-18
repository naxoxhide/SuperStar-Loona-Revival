package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;

/* JADX INFO: compiled from: ExternalSpUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static void a(String str) {
        b("any_door_id", str);
    }

    private static void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.m.i.d.b(null, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        return a("any_door_id", null);
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.bytedance.sdk.openadsdk.m.i.d.a((String) null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
