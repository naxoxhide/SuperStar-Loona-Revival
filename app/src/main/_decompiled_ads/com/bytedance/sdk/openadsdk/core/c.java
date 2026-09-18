package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: compiled from: AdPreference.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static volatile c a;

    private c() {
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public void b(String str, String str2) {
        com.bytedance.sdk.openadsdk.m.i.d.b("ttopenadsdk", str, str2);
    }

    public void b(String str, int i) {
        com.bytedance.sdk.openadsdk.m.i.d.a("ttopenadsdk", str, Integer.valueOf(i));
    }

    public void b(String str, long j) {
        com.bytedance.sdk.openadsdk.m.i.d.a("ttopenadsdk", str, Long.valueOf(j));
    }

    public String a(String str, String str2) {
        return com.bytedance.sdk.openadsdk.m.i.d.a("ttopenadsdk", str, str2);
    }

    public int a(String str, int i) {
        return com.bytedance.sdk.openadsdk.m.i.d.a("ttopenadsdk", str, i);
    }

    public Long a(String str, long j) {
        return Long.valueOf(com.bytedance.sdk.openadsdk.m.i.d.a("ttopenadsdk", str, j));
    }
}
