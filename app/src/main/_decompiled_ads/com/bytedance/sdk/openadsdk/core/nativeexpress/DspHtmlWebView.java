package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DspHtmlWebView extends SSWebView implements com.bytedance.sdk.openadsdk.core.nativeexpress.b.d {
    private o B;
    private f C;
    protected boolean D;
    protected boolean E;
    AtomicBoolean F;
    AtomicBoolean G;
    private q H;
    private String I;
    private List<String> J;
    private e K;
    private int L;
    private long M;

    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            DspHtmlWebView.this.L = i;
            super.onProgressChanged(webView, i);
            if (i >= 100) {
                DspHtmlWebView.this.a();
            }
        }
    }

    class b implements Runnable {

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                DspHtmlWebView.this.B.onTouchEvent(motionEvent);
                return false;
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = DspHtmlWebView.this.getWebView();
            if (webView != null) {
                webView.setOnTouchListener(new a());
            }
        }
    }

    class c extends b.b.a.a.k.g {
        c(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (DspHtmlWebView.this.J != null && DspHtmlWebView.this.G.compareAndSet(false, true)) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = DspHtmlWebView.this.J.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put("url", jSONArray);
                    com.bytedance.sdk.openadsdk.d.c.b(DspHtmlWebView.this.H, DspHtmlWebView.this.I, "dsp_html_error_url", jSONObject);
                    DspHtmlWebView.this.J = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public interface e {
        void a();

        void a(int i, int i2);

        void a(View view, int i);

        View c();

        View d();
    }

    public DspHtmlWebView(Context context) {
        super(context);
        this.D = false;
        this.E = false;
        this.F = new AtomicBoolean(false);
        this.G = new AtomicBoolean(false);
    }

    private void x() {
        if (this.J == null) {
            com.bytedance.sdk.openadsdk.d.c.b(this.H, this.I, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.d.c.a(new c("dsp_html_error_url"));
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView
    public void g() {
        super.g();
        this.C.a();
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.D) {
            this.C.a(getWebView());
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", this.L / 100.0f);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.d.c.b(this.H, this.I, "load_rate", jSONObject);
        this.C.b();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        this.E = z;
        this.C.a(z);
    }

    public void v() {
        this.F.set(false);
        String strH = this.H.H();
        if (TextUtils.isEmpty(strH)) {
            return;
        }
        String strA = com.bytedance.sdk.openadsdk.core.i0.e.a(strH);
        a(null, TextUtils.isEmpty(strA) ? strH : strA, "text/html", "UTF-8", null);
        this.M = SystemClock.elapsedRealtime();
    }

    public void w() {
        e eVar = this.K;
        if (eVar != null) {
            eVar.a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.M);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.d.c.b(this.H, this.I, "render_html_success", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.d
    public void b(String str) {
        String str2;
        String str3;
        View view;
        if (TextUtils.isEmpty(str) || this.H == null || !this.B.a()) {
            return;
        }
        int iF = a0.f(this.I);
        View view2 = null;
        if (com.bytedance.sdk.component.utils.p.a(str) || !(this.H.z() == null || TextUtils.isEmpty(this.H.z().a()))) {
            str2 = str;
        } else {
            com.bytedance.sdk.openadsdk.core.f0.j jVar = new com.bytedance.sdk.openadsdk.core.f0.j();
            jVar.a(str);
            this.H.a(jVar);
            str2 = null;
        }
        this.H.e(true);
        boolean zA = false;
        q qVar = this.H;
        if (qVar == null || qVar.z() == null || TextUtils.isEmpty(this.H.z().a()) || (zA = z.a(getContext(), this.H, iF, this.I, true, (Map<String, Object>) null)) || TextUtils.isEmpty(this.H.z().b())) {
            str3 = str2;
        } else {
            String strB = this.H.z().b();
            com.bytedance.sdk.openadsdk.d.c.a(this.H, this.I, "open_fallback_url", (Map<String, Object>) null);
            str3 = strB;
        }
        if (!zA) {
            if (TextUtils.isEmpty(str3)) {
                return;
            } else {
                z.a(getContext(), this.H, iF, (PAGNativeAd) null, (PangleAd) null, this.I, true, str3);
            }
        }
        if (this.B != null) {
            e eVar = this.K;
            if (eVar != null) {
                View viewD = eVar.d();
                View viewC = this.K.c();
                this.K.a(this, 2);
                view2 = viewC;
                view = viewD;
            } else {
                view = null;
            }
            com.bytedance.sdk.openadsdk.core.f0.i iVarA = this.B.a(getContext(), view2, view);
            HashMap map = new HashMap();
            map.put("click_scence", 1);
            com.bytedance.sdk.openadsdk.d.c.a("click", this.H, iVarA, this.I, true, (Map<String, Object>) map, this.B.a() ? 1 : 2);
        }
        o oVar = this.B;
        if (oVar != null) {
            oVar.b();
        }
    }

    static class d extends SSWebView.r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Set<String> f647b = new a();
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.d a;

        static class a extends HashSet<String> {
            a() {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        }

        public d(com.bytedance.sdk.openadsdk.core.nativeexpress.b.d dVar) {
            this.a = dVar;
        }

        private void a(String str) {
            int iLastIndexOf;
            com.bytedance.sdk.openadsdk.core.nativeexpress.b.d dVar;
            if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(".")) > 0) {
                if (!f647b.contains(str.substring(iLastIndexOf).toLowerCase()) || (dVar = this.a) == null) {
                    return;
                }
                dVar.a(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.bytedance.sdk.openadsdk.core.nativeexpress.b.d dVar = this.a;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (Build.VERSION.SDK_INT < 21) {
                a(str2, i, str);
                a(str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest == null || webResourceResponse == null || Build.VERSION.SDK_INT < 21 || webResourceRequest.getUrl() == null) {
                return;
            }
            if (webResourceRequest.isForMainFrame()) {
                a(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
            }
            a(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.a.b(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT < 21 || webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return;
            }
            a(webResourceRequest.getUrl().toString());
        }

        private void a(String str, int i, String str2) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.b.d dVar = this.a;
            if (dVar != null) {
                dVar.a(106, i);
            }
        }
    }

    public void a(q qVar, e eVar, String str) {
        this.K = eVar;
        this.H = qVar;
        this.I = str;
        this.C = new f();
        this.B = new o(getContext());
        setWebViewClient(new d(this));
        setWebChromeClient(new a());
        com.bytedance.sdk.component.utils.i.b().post(new b());
    }

    public static class f {
        protected int a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.core.i0.f f648b = com.bytedance.sdk.openadsdk.core.i0.f.a();

        f() {
        }

        public void a(WebView webView) {
            if (webView != null && this.a == 0) {
                if (this.f648b == null) {
                    this.f648b = com.bytedance.sdk.openadsdk.core.i0.f.a();
                }
                this.f648b.a(webView);
                this.f648b.e();
                this.a = 1;
            }
        }

        public void b() {
            com.bytedance.sdk.openadsdk.core.i0.f fVar;
            int i = this.a;
            if (i != 0 && i != 4 && (fVar = this.f648b) != null) {
                fVar.b();
            }
            this.a = 4;
            this.f648b = null;
        }

        public void a(boolean z) {
            com.bytedance.sdk.openadsdk.core.i0.f fVar;
            if (this.a == 1 && z && (fVar = this.f648b) != null) {
                fVar.g();
                this.a = 3;
            }
        }

        public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
            com.bytedance.sdk.openadsdk.core.i0.f fVar = this.f648b;
            if (fVar != null) {
                fVar.a(view, friendlyObstructionPurpose);
            }
        }

        public void a() {
            b();
        }
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.C.a(view, friendlyObstructionPurpose);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.d
    public void a(int i, int i2) {
        e eVar = this.K;
        if (eVar != null) {
            eVar.a(i, i2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", i2);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.M);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.d.c.b(this.H, this.I, "render_html_fail", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.d
    public void a(String str) {
        if (this.J == null) {
            this.J = new ArrayList();
        }
        this.J.add(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.d
    public void a() {
        if (this.F.compareAndSet(false, true)) {
            this.D = true;
            this.C.a(getWebView());
            this.C.a(this.E);
            w();
            x();
        }
    }
}
