package com.bytedance.sdk.openadsdk.m;

import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: TTPathConst.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static String a = "com.bytedance.openadsdk";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f791b = "content://" + a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (o.a() != null) {
            a = o.a().getPackageName();
            f791b = "content://" + a + ".TTMultiProvider";
        }
    }
}
