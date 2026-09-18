package com.mbridge.msdk.advanced.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.advanced.b.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.HashMap;

/* JADX INFO: compiled from: NativeAdvancedWebViewClient.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.advanced.b.a f1901b;
    private final String c = "NativeAdvancedWebViewClient";
    private final String d = u.b("YkRXhr5AWBPfNgzuH7JQ+2Ha");
    private final String e = u.b("Y+xgWkl2");
    private c f;

    public a(String str, com.mbridge.msdk.advanced.b.a aVar, c cVar) {
        this.a = str;
        this.f1901b = aVar;
        this.f = cVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder("javascript:");
            sb.append(com.mbridge.msdk.c.b.a.a().b());
            if (Build.VERSION.SDK_INT <= 19) {
                webView.loadUrl(sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.mbridge.msdk.advanced.view.a.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            aa.b("NativeAdvancedWebViewClient", "onPageStarted", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            try {
                WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
                if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.mbridge.msdk.click.b.a.c && com.mbridge.msdk.click.b.a.a(((com.mbridge.msdk.advanced.js.b) windVaneWebView.getObject()).a().get(0), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.f1931b)) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            aa.d("NativeAdvancedWebViewClient", "Use html to open url.");
            com.mbridge.msdk.advanced.b.a aVar = this.f1901b;
            if (aVar == null) {
                return true;
            }
            aVar.a(false, str);
            return true;
        } catch (Throwable th) {
            aa.b("NativeAdvancedWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return a(webView, Build.VERSION.SDK_INT >= 21 ? webResourceRequest.getUrl().toString() : "");
    }

    private WebResourceResponse a(WebView webView, String str) {
        Uri uri;
        String scheme;
        if (!TextUtils.isEmpty(str) && this.f != null) {
            try {
                String strD = "";
                if (str.startsWith(ShareInternalUtility.STAGING_PARAM) && str.contains(this.d)) {
                    strD = str.replace("file://", "");
                }
                boolean z = false;
                if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (scheme = uri.getScheme()) != null && !TextUtils.isEmpty(scheme) && (scheme.equals(this.e) || scheme.equals("mb-h5"))) {
                    z = true;
                }
                if (z) {
                    strD = this.f.d(URLDecoder.decode(Uri.parse(str).getQueryParameter(ShareConstants.MEDIA_URI)));
                }
                if (!TextUtils.isEmpty(strD)) {
                    aa.a("NativeAdvancedWebViewClient", "replace url : " + strD);
                    if (!strD.contains("127.0.0.1") && !strD.startsWith(ProxyConfig.MATCH_HTTP)) {
                        HashMap map = new HashMap();
                        map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ProxyConfig.MATCH_ALL_SCHEMES);
                        WebResourceResponse webResourceResponse = new WebResourceResponse("video/mp4", "utf-8", new FileInputStream(strD));
                        if (Build.VERSION.SDK_INT >= 21) {
                            webResourceResponse.setResponseHeaders(map);
                        }
                        return webResourceResponse;
                    }
                    return null;
                }
            } catch (Throwable th) {
                aa.d("NativeAdvancedWebViewClient", th.getMessage());
            }
        }
        return null;
    }

    public final void a() {
        if (this.f != null) {
            this.f = null;
        }
    }
}
