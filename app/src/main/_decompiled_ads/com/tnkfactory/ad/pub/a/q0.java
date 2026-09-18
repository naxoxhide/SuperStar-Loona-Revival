package com.tnkfactory.ad.pub.a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class q0 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f2885b;

    public q0(n0 n0Var, View view) {
        this.f2885b = n0Var;
        this.a = view;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        if (l0.a(this.a, true)) {
            this.f2885b.b(this.a);
            this.f2885b.m();
        }
    }
}
