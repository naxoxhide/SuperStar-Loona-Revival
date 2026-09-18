package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJWebViewActivity.BridgeDelegate f2718b;

    public a0(TJWebViewActivity.BridgeDelegate bridgeDelegate, boolean z) {
        this.f2718b = bridgeDelegate;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJWebViewActivity.this.c.setClickable(this.a);
    }
}
