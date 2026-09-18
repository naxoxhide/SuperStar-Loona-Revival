package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.PangleWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebViewRender.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends b.b.a.a.d.h.a {
    private Context n;
    private String o;
    private q p;
    private JSONObject q;
    private com.bytedance.sdk.openadsdk.d.o r;
    private String s;
    private com.bytedance.sdk.openadsdk.d.j t;
    private final Map<String, b.c.a.a.a.a.c> u;
    private x v;
    private b.b.a.a.d.f.g w;
    private volatile int x;
    private final b.b.a.a.k.g y;
    private final Runnable z;

    /* JADX INFO: compiled from: WebViewRender.java */
    class a extends b.b.a.a.k.g {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((b.b.a.a.d.h.a) p.this).m.get()) {
                return;
            }
            p pVar = p.this;
            pVar.q = pVar.g().q();
            p pVar2 = p.this;
            pVar2.a(pVar2.q);
            if (p.this.p != null && p.this.p.I0() != null) {
                p pVar3 = p.this;
                ((b.b.a.a.d.h.a) pVar3).l = b.b.a.a.d.e.b.a.c(pVar3.p.I0().d());
            }
            if (p.this.x == 0) {
                p.this.n();
            }
            com.bytedance.sdk.openadsdk.core.l.c().post(p.this.z);
        }
    }

    /* JADX INFO: compiled from: WebViewRender.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((b.b.a.a.d.h.a) p.this).m.get() || p.this.w == null) {
                return;
            }
            p.this.l();
            p pVar = p.this;
            p.super.a(pVar.w);
        }
    }

    /* JADX INFO: compiled from: WebViewRender.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.q();
        }
    }

    /* JADX INFO: compiled from: WebViewRender.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.utils.m.a("TTAD.WebViewRender", "resumeTimers..........");
            WebView webView = ((b.b.a.a.d.h.a) p.this).i.getWebView();
            if (webView != null) {
                webView.resumeTimers();
            }
        }
    }

    public p(Context context, b.b.a.a.d.f.m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.d.o oVar, q qVar) {
        super(context, mVar, themeStatusBroadcastReceiver);
        this.u = Collections.synchronizedMap(new HashMap());
        this.x = 0;
        this.y = new a("webviewrender_template");
        this.z = new b();
        if (this.i == null) {
            return;
        }
        this.n = context;
        this.o = mVar.a();
        this.p = qVar;
        this.r = oVar;
        themeStatusBroadcastReceiver.a(this);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.i.getWebView() != null && y.g()) {
            q();
        } else {
            this.x = 1;
            y.a(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        SSWebView sSWebView = this.i;
        if (sSWebView == null || sSWebView.getWebView() == null || this.x == 2) {
            return;
        }
        this.s = b.b.a.a.d.e.b.a.b();
        this.i.setDisplayZoomControls(false);
        a(com.bytedance.sdk.openadsdk.utils.x.a(this.s));
        o();
        x xVar = new x(this.n);
        this.v = xVar;
        xVar.f(true);
        p();
        this.x = 2;
    }

    @Override // b.b.a.a.d.h.a
    public void k() {
        if (this.m.get()) {
            return;
        }
        x xVar = this.v;
        if (xVar != null) {
            xVar.u();
            this.v.o();
            this.v = null;
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.t;
        if (jVar != null) {
            jVar.d();
        }
        super.k();
        com.bytedance.sdk.openadsdk.core.l.c().removeCallbacks(this.z);
        this.u.clear();
        SSWebView sSWebViewA = b.b.a.a.d.h.e.e().a();
        if (sSWebViewA == null || (sSWebViewA.getWebView() instanceof PangleWebView)) {
            return;
        }
        b.b.a.a.d.h.e.e().b(sSWebViewA);
    }

    public void l() {
        x xVar;
        SSWebView sSWebView = this.i;
        if (sSWebView == null || sSWebView.getWebView() == null || (xVar = this.v) == null) {
            return;
        }
        xVar.a(this.i).a(this.p).g(this.p.e()).j(this.p.N()).b(a0.f(this.o)).h(this.p.D()).a(this).r(this.q).b(this.i).a(this.r);
    }

    public x m() {
        return this.v;
    }

    public void o() {
        q qVar = this.p;
        if (qVar == null || qVar.I0() == null) {
            return;
        }
        this.p.I0();
    }

    public void p() {
        SSWebView sSWebView = this.i;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        this.i.setBackgroundColor(0);
        this.i.setBackgroundResource(R.color.transparent);
        a(this.i);
        if (f() != null) {
            this.t = new com.bytedance.sdk.openadsdk.d.j(this.p, f().getWebView()).a(false);
        }
        this.t.a(this.r);
        this.i.setWebViewClient(new h(this.n, this.v, this.p, this.t));
        this.i.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.v, this.t));
        if (Build.VERSION.SDK_INT >= 17) {
            b.b.a.a.d.h.e.e().a(this.i, this.v);
        }
    }

    public void r() {
        if (f() == null) {
            return;
        }
        try {
            f().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.d.h.a
    public void b(int i) {
        if (i == this.k) {
            return;
        }
        this.k = i;
        b(i == 0);
    }

    @Override // b.b.a.a.d.h.a
    public SSWebView f() {
        return this.i;
    }

    @Override // b.b.a.a.d.h.a
    public void h() {
        super.h();
        if (this.v == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.v.a("expressShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.d.h.a
    public void i() {
        x xVar = this.v;
        if (xVar == null) {
            return;
        }
        xVar.a("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // b.b.a.a.d.h.a, b.b.a.a.d.f.d
    public void a(b.b.a.a.d.f.g gVar) {
        this.w = gVar;
        y.c(this.y);
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.b.a(this.n).a(false).a(sSWebView.getWebView());
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.a(true);
            sSWebView.e();
            sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.k.a(sSWebView.getWebView(), BuildConfig.VERSION_CODE));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.m.b("TTAD.WebViewRender", e.toString());
        }
    }

    private void b(boolean z) {
        if (this.v == null || this.i == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.v.a("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public static boolean b(String str) {
        return "banner_call".equals(str) || "banner_ad".equals(str) || "slide_banner_ad".equals(str) || "banner_ad_landingpage".equals(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.a
    public void a(int i) {
        if (this.v == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException unused) {
        }
        this.v.a("themeChange", jSONObject);
    }

    @Override // b.b.a.a.d.h.a, b.b.a.a.d.f.k
    public void a(b.b.a.a.d.f.n nVar) {
        super.a(nVar);
        if (this.f) {
            com.bytedance.sdk.component.utils.i.b().postDelayed(new d(), 2000L);
        }
    }
}
