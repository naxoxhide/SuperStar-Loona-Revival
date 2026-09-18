package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public class j implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1365b;

    public j(i iVar, Context context) {
        this.f1365b = iVar;
        this.a = context;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        g gVar = this.f1365b.f1358b;
        if (gVar == null) {
            return false;
        }
        gVar.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f1365b.a(this.a, true);
        return false;
    }
}
