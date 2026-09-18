package com.tapjoy;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJAdUnitJSBridge f2721b;

    public d(TJAdUnitJSBridge tJAdUnitJSBridge, String str) {
        this.f2721b = tJAdUnitJSBridge;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f2721b;
        if (tJAdUnitJSBridge.c == null) {
            String str = this.a;
            if (str != null) {
                tJAdUnitJSBridge.invokeJSCallback(str, Boolean.FALSE);
                return;
            }
            return;
        }
        String str2 = this.a;
        if (str2 != null) {
            tJAdUnitJSBridge.invokeJSCallback(str2, Boolean.TRUE);
        }
        TJAdUnitJSBridge tJAdUnitJSBridge2 = this.f2721b;
        String str3 = tJAdUnitJSBridge2.splitWebViewCallbackID;
        if (str3 != null) {
            tJAdUnitJSBridge2.invokeJSCallback(str3, Boolean.TRUE);
            this.f2721b.splitWebViewCallbackID = null;
        }
        ((ViewGroup) this.f2721b.c.getParent()).removeView(this.f2721b.c);
        this.f2721b.c = null;
    }
}
