package com.tnkfactory.ad.pub.a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f2883b;

    public p0(n0 n0Var, View view) {
        this.f2883b = n0Var;
        this.a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (l0.a(this.a, true)) {
            this.f2883b.b(this.a);
            this.f2883b.m();
        }
    }
}
