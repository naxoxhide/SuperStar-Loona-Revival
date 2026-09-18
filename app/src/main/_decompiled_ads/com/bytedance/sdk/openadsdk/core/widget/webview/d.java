package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.f0.i;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.d.j;
import com.bytedance.sdk.openadsdk.utils.k;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTWebViewClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends SSWebView.r0 {
    private static final HashSet<String> l;
    protected final x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f708b;
    protected j c;
    private final boolean d;
    protected boolean e = true;
    private String f;
    private i g;
    private Map<String, Object> h;
    private boolean i;
    private JSONObject j;
    private q k;

    static {
        HashSet<String> hashSet = new HashSet<>();
        l = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    public d(Context context, x xVar, String str, j jVar, boolean z) {
        this.f708b = context;
        this.a = xVar;
        this.c = jVar;
        this.d = z;
    }

    private boolean c(String str) {
        q qVar = this.k;
        if (qVar == null || !o.a(qVar)) {
            return false;
        }
        return TextUtils.equals(this.k.A(), str);
    }

    public void a(i iVar) {
        this.g = iVar;
    }

    public boolean b(String str) {
        String strD;
        if (this.f708b == null) {
            return false;
        }
        q qVar = this.k;
        String strE = "";
        if (qVar == null || qVar.h() == null) {
            strD = "";
        } else {
            strE = this.k.h().e();
            strD = this.k.h().d();
        }
        return b.c.a.a.a.a.a.a(str, this.f708b, this.f, this.k, (Map<String, Object>) null) || b.c.a.a.a.a.a.a(this.k, strE, this.f708b, this.f, (Map<String, Object>) null) || b.c.a.a.a.a.b.a(this.f708b, strD, strE, this.f, this.k);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if ("play.google.com".equals(uri.getHost())) {
                if (o.a(this.k) && this.j == null && this.g == null) {
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.f708b instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(uri);
                intent.setPackage("com.android.vending");
                this.f708b.startActivity(intent);
                a();
                this.j = null;
                this.g = null;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void e(String str) {
        this.f = str;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (m.b()) {
            m.e("WebChromeClient", "onPageFinished " + str);
        }
        j jVar = this.c;
        if (jVar != null) {
            jVar.a(webView, str, this.d);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        j jVar = this.c;
        if (jVar != null) {
            jVar.a(webView, str, bitmap);
        }
        if (this.e) {
            b.a(this.f708b).a(Build.VERSION.SDK_INT >= 19).b(webView.getSettings().getBuiltInZoomControls()).a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT < 23 && this.c != null) {
            this.c.a(webView, i, str, str2, a(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.c == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        this.c.a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, requestHeaders.containsKey("accept") ? requestHeaders.get("accept") : "", webResourceRequest != null && webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.c != null) {
            int primaryError = 0;
            String str = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            String str2 = url;
            this.c.a(webView, primaryError, str, str2, a(str2), true);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        j jVar = this.c;
        if (jVar != null) {
            jVar.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m.a("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                k.a(uri, this.a);
                return true;
            }
            if (d(str)) {
                return true;
            }
            if (!p.a(str)) {
                if (o.a(this.k)) {
                    a(lowerCase, str);
                    return true;
                }
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(uri);
                    intent.addFlags(268435456);
                    this.f708b.startActivity(intent);
                } catch (Throwable unused) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Throwable th) {
            m.c("WebChromeClient", "shouldOverrideUrlLoading", th);
            x xVar = this.a;
            if (xVar != null && xVar.n()) {
                return true;
            }
        }
    }

    public void a(Map<String, Object> map) {
        this.h = map;
    }

    public void a(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public void a(q qVar) {
        this.k = qVar;
    }

    private void a(String str, String str2) {
        if ((c(str) || "market".equals(str)) && ((this.g != null || this.j != null) && b(str2))) {
            a();
        }
        this.g = null;
        this.j = null;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT < 23 || this.c == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        this.c.a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, requestHeaders.containsKey("accept") ? requestHeaders.get("accept") : "", webResourceRequest != null && webResourceRequest.isForMainFrame());
    }

    public void a() {
        if (this.k == null || TextUtils.isEmpty(this.f) || !o.e(this.k) || this.i) {
            return;
        }
        i iVar = this.g;
        if (iVar != null) {
            com.bytedance.sdk.openadsdk.d.c.a("click", this.k, iVar, this.f, true, this.h, 1);
            this.i = true;
            return;
        }
        JSONObject jSONObject = this.j;
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.d.c.a(this.k, this.f, "click", jSONObject);
            this.i = true;
        }
    }

    protected static String a(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !l.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + strSubstring;
    }
}
