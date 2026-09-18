package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJAdUnitJSBridge f2727b;

    public i(TJAdUnitJSBridge tJAdUnitJSBridge, String str) {
        this.f2727b = tJAdUnitJSBridge;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2727b.f2684b.getTextZoom(new h(this));
        } catch (Exception unused) {
            this.f2727b.invokeJSCallback(this.a, Float.valueOf(1.0f));
        }
    }
}
