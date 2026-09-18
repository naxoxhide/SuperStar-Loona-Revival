package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.x;
import java.io.InputStream;

/* JADX INFO: compiled from: ExpressClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
    private q m;

    public h(Context context, x xVar, q qVar, com.bytedance.sdk.openadsdk.d.j jVar) {
        super(context, xVar, qVar.e(), jVar, false);
        this.m = qVar;
    }

    private WebResourceResponse a(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.f0.n nVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b.b.a.a.d.g.e.a aVarA = b.b.a.a.d.g.e.a(str);
        if (aVarA != b.b.a.a.d.g.e.a.IMAGE) {
            for (com.bytedance.sdk.openadsdk.core.f0.n nVar2 : this.m.d0()) {
                if (!TextUtils.isEmpty(nVar2.d()) && !TextUtils.isEmpty(str)) {
                    String strD = nVar2.d();
                    if (strD.startsWith("https")) {
                        strD = strD.replaceFirst("https", ProxyConfig.MATCH_HTTP);
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", ProxyConfig.MATCH_HTTP) : str).equals(strD)) {
                        nVar = nVar2;
                        break;
                    }
                }
            }
        }
        return (aVarA == b.b.a.a.d.g.e.a.IMAGE || nVar != null) ? b(str, com.bytedance.sdk.openadsdk.core.nativeexpress.q.b.a(this.m, str)) : b.b.a.a.d.e.b.a.a(str, aVarA, "");
    }

    private WebResourceResponse b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamA = com.bytedance.sdk.openadsdk.h.d.a(str, str2);
            if (inputStreamA != null) {
                return new WebResourceResponse(b.b.a.a.d.g.e.a.IMAGE.b(), "utf-8", inputStreamA);
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("ExpressClient", "get image WebResourceResponse error", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            WebResourceResponse webResourceResponseA = a(webView, str);
            a(jCurrentTimeMillis, System.currentTimeMillis(), str, webResourceResponseA != null ? 1 : 2);
            if (webResourceResponseA != null) {
                return webResourceResponseA;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    private void a(long j, long j2, String str, int i) {
        com.bytedance.sdk.openadsdk.d.j jVar = this.c;
        if (jVar == null || jVar.a() == null) {
            return;
        }
        b.b.a.a.d.g.e.a aVarA = b.b.a.a.d.g.e.a(str);
        if (aVarA == b.b.a.a.d.g.e.a.HTML) {
            this.c.a().a(str, j, j2, i);
        } else if (aVarA == b.b.a.a.d.g.e.a.JS) {
            this.c.a().b(str, j, j2, i);
        }
    }
}
