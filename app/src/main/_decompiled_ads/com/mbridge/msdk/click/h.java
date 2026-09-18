package com.mbridge.msdk.click;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: WebViewSpider.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static long a = 0;
    private static final String d = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f1935b;
    boolean c;
    private int e;
    private int f;
    private com.mbridge.msdk.c.c h;
    private a i;
    private String j;
    private String k;
    private WebView l;
    private boolean m;
    private String n;
    private int o;
    private boolean q;
    private boolean p = false;
    private final Runnable r = new Runnable() { // from class: com.mbridge.msdk.click.h.4
        @Override // java.lang.Runnable
        public final void run() {
            h.this.p = true;
            h.this.o = 1;
            h.m(h.this);
        }
    };
    private final Runnable s = new Runnable() { // from class: com.mbridge.msdk.click.h.5
        @Override // java.lang.Runnable
        public final void run() {
            h.this.p = true;
            h.this.o = 2;
            h.m(h.this);
        }
    };
    private Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: WebViewSpider.java */
    interface a {
        void a(int i, String str, String str2, String str3);

        void a(String str, boolean z, String str2);

        boolean a(String str);

        boolean b(String str);

        boolean c(String str);
    }

    public h() {
        this.e = 15000;
        this.f = 3000;
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        this.h = cVarB;
        if (cVarB == null) {
            this.h = com.mbridge.msdk.c.d.a().b();
        }
        this.m = this.h.V();
        this.e = (int) this.h.aa();
        this.f = (int) this.h.aa();
    }

    public final void a(String str, String str2, Context context, String str3, String str4, a aVar) {
        Objects.requireNonNull(aVar, "OverrideUrlLoadingListener can not be null");
        this.k = str4;
        this.j = str3;
        this.i = aVar;
        a(str, str2, context);
    }

    public final void a(String str, String str2, Context context, String str3, a aVar) {
        Objects.requireNonNull(aVar, "OverrideUrlLoadingListener can not be null");
        this.j = str3;
        this.i = aVar;
        a(str, str2, context);
    }

    private void a(final String str, final String str2, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str, str2, context, this.j);
        } else {
            this.g.post(new Runnable() { // from class: com.mbridge.msdk.click.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    h hVar = h.this;
                    hVar.a(str, str2, context, hVar.j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.k)) {
                this.l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f = 2000;
                this.e = 2000;
                aa.b(d, this.k);
                this.l.loadDataWithBaseURL(str3, this.k, "*/*", "utf-8", str3);
                return;
            }
            if (this.m) {
                HashMap map = new HashMap();
                if (this.l.getUrl() != null) {
                    map.put(HttpHeaders.REFERER, this.l.getUrl());
                }
                this.l.loadUrl(str3, map);
                return;
            }
            this.l.loadUrl(str3);
        } catch (Throwable th) {
            try {
                a aVar = this.i;
                if (aVar != null) {
                    aVar.a(0, this.j, th.getMessage(), this.n);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(final Context context, final String str, final String str2) {
        WebView webView = new WebView(context);
        this.l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.l.getSettings().setCacheMode(2);
        this.l.getSettings().setLoadsImagesAutomatically(false);
        this.l.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.click.h.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str3, Bitmap bitmap) {
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                    if (h.this.q) {
                        h.this.o = 0;
                        h.c(h.this);
                        return;
                    }
                    h.this.c = false;
                    if (webView2.getTag() == null) {
                        webView2.setTag("has_first_started");
                    } else {
                        h.this.f1935b = true;
                    }
                    synchronized (h.d) {
                        h.this.j = str3;
                        if (h.this.i != null && h.this.i.a(str3)) {
                            h.this.q = true;
                            h.c(h.this);
                        } else {
                            h.e(h.this);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str3) {
                synchronized (h.d) {
                    h.this.c = true;
                    h.this.d();
                    if (h.this.q) {
                        h.this.c();
                        h.c(h.this);
                        return true;
                    }
                    h.this.j = str3;
                    if (h.this.i == null || !h.this.i.b(str3)) {
                        if (!h.this.m) {
                            h.this.l.loadUrl(str3);
                        } else {
                            HashMap map = new HashMap();
                            if (h.this.l.getUrl() != null) {
                                map.put(HttpHeaders.REFERER, h.this.l.getUrl());
                            }
                            h.this.l.loadUrl(str3, map);
                        }
                        return true;
                    }
                    h.this.q = true;
                    h.this.c();
                    h.c(h.this);
                    return true;
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i, String str3, String str4) {
                synchronized (h.d) {
                    h.this.q = true;
                    h.this.b();
                    h.c(h.this);
                }
                if (h.this.i != null) {
                    h.this.i.a(i, webView2.getUrl(), str3, h.this.n);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    new p(context).a(str, str2, webView2.getUrl());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str3) {
                super.onPageFinished(webView2, str3);
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.l.setWebChromeClient(new WebChromeClient() { // from class: com.mbridge.msdk.click.h.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str3, String str4, String str5, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i) {
                if (i == 100) {
                    try {
                        webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!h.this.q && !h.this.c) {
                            h.l(h.this);
                        }
                        if (h.this.i != null) {
                            h.this.i.c(webView2.getUrl());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.g.removeCallbacks(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.g.removeCallbacks(this.r);
    }

    static /* synthetic */ void c(h hVar) {
        synchronized (d) {
            try {
                hVar.b();
                a aVar = hVar.i;
                if (aVar != null) {
                    aVar.a(hVar.j, hVar.p, hVar.n);
                }
            } catch (Exception e) {
                aa.d(d, e.getMessage());
            } catch (Throwable th) {
                aa.d(d, th.getMessage());
            }
        }
    }

    static /* synthetic */ void e(h hVar) {
        hVar.c();
        hVar.g.postDelayed(hVar.s, hVar.e);
    }

    static /* synthetic */ void l(h hVar) {
        hVar.d();
        hVar.g.postDelayed(hVar.r, hVar.f);
    }

    static /* synthetic */ void m(h hVar) {
        synchronized (d) {
            try {
                try {
                    hVar.b();
                    hVar.l.destroy();
                    a aVar = hVar.i;
                    if (aVar != null) {
                        aVar.a(hVar.j, hVar.p, hVar.n);
                    }
                } catch (Exception e) {
                    aa.d(d, e.getMessage());
                }
            } catch (Throwable th) {
                aa.d(d, th.getMessage());
            }
        }
    }
}
