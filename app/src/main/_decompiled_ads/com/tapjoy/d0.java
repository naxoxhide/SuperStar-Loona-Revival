package com.tapjoy;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 implements Runnable {
    public final WebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2722b;

    public d0(WebView webView, String str) {
        this.a = webView;
        this.f2722b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != null) {
            if (!this.f2722b.startsWith("javascript:")) {
                try {
                    this.a.loadUrl(this.f2722b);
                    return;
                } catch (Exception e) {
                    TapjoyLog.e("TJWebViewJSInterface", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTERNAL_ERROR, "Exception in loadUrl. Device not supported. " + e.toString()));
                    return;
                }
            }
            try {
                String strReplaceFirst = this.f2722b.replaceFirst("javascript:", "");
                this.f2722b = strReplaceFirst;
                WebView webView = this.a;
                if (webView == null) {
                    return;
                }
                webView.evaluateJavascript(strReplaceFirst, null);
            } catch (Exception e2) {
                TapjoyLog.e("TJWebViewJSInterface", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTERNAL_ERROR, "Exception in evaluateJavascript. Device not supported. " + e2.toString()));
            }
        }
    }
}
