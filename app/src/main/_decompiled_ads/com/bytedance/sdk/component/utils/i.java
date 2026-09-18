package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: HandlerUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static volatile Handler a;

    public static Handler a() {
        return b.b.a.a.k.i.a.a().b();
    }

    public static Handler b() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return a;
    }
}
