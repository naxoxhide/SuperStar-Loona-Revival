package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements TJTaskHandler {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJAdUnitJSBridge f2845b;

    public k(TJAdUnitJSBridge tJAdUnitJSBridge, String str) {
        this.f2845b = tJAdUnitJSBridge;
        this.a = str;
    }

    @Override // com.tapjoy.TJTaskHandler
    public final void onComplete(Object obj) {
        this.f2845b.invokeJSCallback(this.a, (Boolean) obj);
    }
}
