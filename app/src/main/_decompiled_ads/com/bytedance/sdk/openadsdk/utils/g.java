package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;

/* JADX INFO: compiled from: FileCacheUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = b.a.a.a.a.a.a.c.a().getCacheDir() + File.separator + "proxy_cache";
        }
        return a;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.e(th.getMessage());
            }
        }
    }
}
