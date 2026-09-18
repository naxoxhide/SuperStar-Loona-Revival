package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ TJTaskHandler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJWebViewActivity.BridgeDelegate f2719b;

    public b0(TJWebViewActivity.BridgeDelegate bridgeDelegate, TJTaskHandler tJTaskHandler) {
        this.f2719b = bridgeDelegate;
        this.a = tJTaskHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f2719b.getWebView() == null || this.f2719b.getWebView().getSettings() == null) {
                this.a.onComplete(Float.valueOf(1.0f));
            } else {
                this.a.onComplete(Float.valueOf(this.f2719b.getWebView().getSettings().getTextZoom() / 100.0f));
            }
        } catch (Exception e) {
            TapjoyLog.d("TJWebViewActivity", "Error getting text zoom: " + e.getMessage());
            this.a.onComplete(Float.valueOf(1.0f));
        }
    }
}
