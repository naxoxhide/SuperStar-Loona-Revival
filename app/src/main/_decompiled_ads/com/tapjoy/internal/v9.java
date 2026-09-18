package com.tapjoy.internal;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tapjoy.TJWebViewActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class v9 extends WebViewClient {
    public final /* synthetic */ TJWebViewActivity a;

    public v9(TJWebViewActivity tJWebViewActivity) {
        this.a = tJWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.h.flushMessageQueue();
        this.a.h.display();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (webView != null) {
            webView.loadUrl("about:blank");
        }
        this.a.showErrorDialog();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.a.a(str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return this.a.a(webResourceRequest.getUrl().toString());
    }
}
