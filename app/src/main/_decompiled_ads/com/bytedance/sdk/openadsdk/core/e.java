package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: compiled from: DBAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends f {
    private static volatile e d;

    private e(Context context) {
        super(context);
    }

    public static e a(Context context) {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new e(context);
                }
            }
        }
        return d;
    }
}
