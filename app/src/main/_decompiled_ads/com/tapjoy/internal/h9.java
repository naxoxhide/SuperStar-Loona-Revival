package com.tapjoy.internal;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tapjoy.TJSplitWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class h9 extends WebChromeClient {
    public final /* synthetic */ TJSplitWebView a;

    public h9(TJSplitWebView tJSplitWebView) {
        this.a = tJSplitWebView;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.a.p.setProgress(i);
        this.a.isFirstOrLastPage();
    }
}
