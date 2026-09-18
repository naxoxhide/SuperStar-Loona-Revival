package com.tapjoy.internal;

import com.tapjoy.TJWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class y7 implements Runnable {
    public final /* synthetic */ float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tapjoy.c f2835b;

    public y7(com.tapjoy.c cVar, float f) {
        this.f2835b = cVar;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJWebView tJWebView = this.f2835b.a.h;
        if (tJWebView == null || tJWebView.getSettings() == null) {
            return;
        }
        this.f2835b.a.h.getSettings().setTextZoom((int) (this.a * 100.0f));
    }
}
