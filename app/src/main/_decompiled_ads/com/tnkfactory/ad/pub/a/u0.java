package com.tnkfactory.ad.pub.a;

import com.tnkfactory.ad.AdListener;

/* JADX INFO: loaded from: classes4.dex */
public final class u0 implements Runnable {
    public final /* synthetic */ t0 a;

    public u0(t0 t0Var) {
        this.a = t0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(AdListener.CLOSE_AUTO, false);
    }
}
