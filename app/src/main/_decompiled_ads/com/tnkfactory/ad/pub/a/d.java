package com.tnkfactory.ad.pub.a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        if (l0.a((View) this.a, true)) {
            this.a.c();
            this.a.d();
        }
    }
}
