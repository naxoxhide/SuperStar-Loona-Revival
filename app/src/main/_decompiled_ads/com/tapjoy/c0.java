package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJWebViewActivity.BridgeDelegate f2720b;

    public c0(TJWebViewActivity.BridgeDelegate bridgeDelegate, float f) {
        this.f2720b = bridgeDelegate;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2720b.getWebView() == null || this.f2720b.getWebView().getSettings() == null) {
            return;
        }
        this.f2720b.getWebView().getSettings().setTextZoom((int) (this.a * 100.0f));
    }
}
