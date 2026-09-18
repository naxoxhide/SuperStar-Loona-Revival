package com.tnkfactory.ad.pub.a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.tnkfactory.ad.pub.d a;

    public c1(com.tnkfactory.ad.pub.d dVar) {
        this.a = dVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        com.tnkfactory.ad.pub.d.a(this.a, l0.a((View) this.a, true));
    }
}
