package com.tapjoy;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJAdUnitJSBridge f2723b;

    public e(TJAdUnitJSBridge tJAdUnitJSBridge, String str) {
        this.f2723b = tJAdUnitJSBridge;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f2723b;
        TJSplitWebView tJSplitWebView = tJAdUnitJSBridge.c;
        if (tJSplitWebView != null) {
            tJAdUnitJSBridge.invokeJSCallback(this.a, tJSplitWebView.getLastUrl());
        } else {
            tJAdUnitJSBridge.invokeJSCallback(this.a, JSONObject.NULL);
        }
    }
}
