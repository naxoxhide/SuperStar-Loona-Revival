package com.tapjoy.internal;

import com.tapjoy.TJWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class e9 implements Runnable {
    public final /* synthetic */ float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tapjoy.w f2752b;

    public e9(com.tapjoy.w wVar, float f) {
        this.f2752b = wVar;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJWebView tJWebView = this.f2752b.a.a;
        if (tJWebView == null || tJWebView.getSettings() == null) {
            return;
        }
        this.f2752b.a.a.getSettings().setTextZoom((int) (this.a * 100.0f));
    }
}
