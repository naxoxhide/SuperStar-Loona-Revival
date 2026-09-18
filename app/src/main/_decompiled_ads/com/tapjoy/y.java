package com.tapjoy;

import android.graphics.Color;

/* JADX INFO: loaded from: classes4.dex */
public final class y implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJTaskHandler f2853b;
    public final /* synthetic */ TJWebViewActivity.BridgeDelegate c;

    public y(TJWebViewActivity.BridgeDelegate bridgeDelegate, String str, TJTaskHandler tJTaskHandler) {
        this.c = bridgeDelegate;
        this.a = str;
        this.f2853b = tJTaskHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJWebViewActivity.this.f.setBackgroundColor(Color.parseColor(this.a));
        this.f2853b.onComplete(Boolean.TRUE);
    }
}
