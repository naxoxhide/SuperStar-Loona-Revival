package com.tnkfactory.ad.pub.a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ com.tnkfactory.ad.pub.d a;

    public d1(com.tnkfactory.ad.pub.d dVar) {
        this.a = dVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        com.tnkfactory.ad.pub.d.a(this.a, l0.a((View) this.a, true));
    }
}
