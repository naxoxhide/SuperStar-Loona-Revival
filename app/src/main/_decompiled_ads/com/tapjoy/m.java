package com.tapjoy;

import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements Runnable {
    public final /* synthetic */ JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2847b;
    public final /* synthetic */ TJAdUnitJSBridge c;

    public m(TJAdUnitJSBridge tJAdUnitJSBridge, JSONObject jSONObject, String str) {
        this.c = tJAdUnitJSBridge;
        this.a = jSONObject;
        this.f2847b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            WebView webView = this.c.f2684b.getWebView();
            if (webView != null) {
                webView.evaluateJavascript(this.a.getString(TJAdUnitConstants.String.COMMAND), null);
            }
            this.c.invokeJSCallback(this.f2847b, Boolean.TRUE);
        } catch (Exception unused) {
            this.c.invokeJSCallback(this.f2847b, Boolean.FALSE);
        }
    }
}
