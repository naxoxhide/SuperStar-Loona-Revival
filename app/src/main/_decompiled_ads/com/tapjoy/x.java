package com.tapjoy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.webkit.ProxyConfig;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public final class x extends WebViewClient {
    public final /* synthetic */ TJSplitWebView a;

    public x(TJSplitWebView tJSplitWebView) {
        this.a = tJSplitWebView;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.a.l.booleanValue()) {
            ProgressBar progressBar = this.a.p;
            if (progressBar != null) {
                progressBar.setProgress(0);
                this.a.p.setVisibility(8);
            }
            this.a.isFirstOrLastPage();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.a.l.booleanValue()) {
            this.a.q.setText(TapjoyUrlFormatter.getDomain(str));
            this.a.p.setVisibility(0);
        }
        TapjoyLog.d("TJSplitWebView", "onPageStarted: " + str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        TapjoyLog.d("TJSplitWebView", "onReceivedError: " + str2 + " firstUrl:" + this.a.d);
        TJSplitWebView tJSplitWebView = this.a;
        if (tJSplitWebView.u) {
            tJSplitWebView.showErrorDialog();
        } else if (str2.equals(tJSplitWebView.d)) {
            this.a.j.dismissSplitView(null, null);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        TJWebView tJWebView = this.a.a;
        if (tJWebView != null) {
            ViewGroup viewGroup = (ViewGroup) tJWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a.a);
                viewGroup.removeAllViews();
            }
            this.a.a.destroy();
            this.a.a = null;
        }
        TJAdUnitJSBridge tJAdUnitJSBridge = this.a.j;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.cleanUpJSBridge();
            this.a.j = null;
        }
        TapjoyLog.e("TJSplitWebView", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "WebView rendering process exited while instantiating a WebViewClient unexpectedly"));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        TJSplitWebView tJSplitWebView = this.a;
        String str2 = tJSplitWebView.f;
        Uri uri = tJSplitWebView.g;
        if (str2 != null && uri != null && str != null && str.startsWith(str2)) {
            this.a.k.startActivity(new Intent("android.intent.action.VIEW", uri));
            this.a.j.dismissSplitView(null, null);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        HashSet hashSet;
        TapjoyLog.d("TJSplitWebView", "shouldOverrideUrlLoading: " + str);
        Uri uri = Uri.parse(str);
        if (uri != null) {
            String host = uri.getHost();
            String scheme = uri.getScheme();
            if (scheme != null && host != null && ((scheme.equals(ProxyConfig.MATCH_HTTP) || scheme.equals("https")) && ((hashSet = this.a.h) == null || !hashSet.contains(host)))) {
                this.a.e = str;
                return false;
            }
        }
        try {
            this.a.k.startActivity(new Intent("android.intent.action.VIEW", uri));
            if (this.a.l.booleanValue()) {
                return true;
            }
            this.a.j.dismissSplitView(null, null);
            return true;
        } catch (Exception e) {
            TapjoyLog.e("TJSplitWebView", e.getMessage());
            return true;
        }
    }
}
