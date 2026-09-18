package com.bytedance.sdk.openadsdk.utils;

/* JADX INFO: compiled from: LastShowAdSP.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static void a(String str, String str2) {
        try {
            com.bytedance.sdk.openadsdk.m.i.d.a(c(), "show_time", Long.valueOf(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.m.i.d.b(c(), "material_data", str);
            com.bytedance.sdk.openadsdk.m.i.d.b(c(), "show_ad_tag", str2);
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        try {
            return com.bytedance.sdk.openadsdk.m.i.d.a(c(), "material_data", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c() {
        return "sp_last_ad_show_cache_show_ad";
    }

    public static String d() {
        try {
            return com.bytedance.sdk.openadsdk.m.i.d.a(c(), "show_ad_tag", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long e() {
        try {
            return com.bytedance.sdk.openadsdk.m.i.d.a(c(), "show_time", 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void a() {
        try {
            com.bytedance.sdk.openadsdk.m.i.d.a(c());
        } catch (Throwable unused) {
        }
    }
}
