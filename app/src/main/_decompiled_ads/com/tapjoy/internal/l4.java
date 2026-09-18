package com.tapjoy.internal;

import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l4 {
    public static void a(u0 u0Var) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null && mainLooper.getThread() == Thread.currentThread()) {
            u0Var.a.c();
        } else {
            w2.b().post(u0Var);
        }
    }
}
