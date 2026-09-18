package com.tnkfactory.ad.pub.a;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ n0 a;

    public o0(n0 n0Var) {
        this.a = n0Var;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (l0.a(view, false)) {
            this.a.m();
        }
    }
}
