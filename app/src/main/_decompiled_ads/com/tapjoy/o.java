package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJAdUnitJSBridge f2849b;

    public o(TJAdUnitJSBridge tJAdUnitJSBridge, String str) {
        this.f2849b = tJAdUnitJSBridge;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f2849b;
        if (tJAdUnitJSBridge.c != null) {
            tJAdUnitJSBridge.invokeJSCallback(this.a, Boolean.TRUE);
        } else {
            tJAdUnitJSBridge.invokeJSCallback(this.a, Boolean.FALSE);
        }
    }
}
