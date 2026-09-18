package com.tapjoy.internal;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public final class q2 implements Runnable {
    public final /* synthetic */ u2 a;

    public q2(u2 u2Var) {
        this.a = u2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap = this.a.f2818b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        u2 u2Var = this.a;
        u2Var.setImageBitmap(u2Var.f2818b);
    }
}
