package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class z implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJWebViewActivity.BridgeDelegate f2854b;

    public z(TJWebViewActivity.BridgeDelegate bridgeDelegate, boolean z) {
        this.f2854b = bridgeDelegate;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a) {
            TJWebViewActivity.this.c.setVisibility(0);
        } else {
            TJWebViewActivity.this.c.setVisibility(4);
        }
    }
}
