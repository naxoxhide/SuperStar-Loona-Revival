package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.a0;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowTextView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTPlayableLandingPageActivity extends TTBaseActivity implements y.a, com.bytedance.sdk.openadsdk.core.c0.d, com.bytedance.sdk.openadsdk.k.g {
    private static final com.bytedance.sdk.openadsdk.o.f.a N = new g();
    private String B;
    private int F;
    private int G;
    private com.bytedance.sdk.openadsdk.o.g H;
    private ILoader I;
    private com.bytedance.sdk.openadsdk.d.o K;
    private com.bytedance.sdk.openadsdk.d.j L;
    private SSWebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSWebView f409b;
    private RelativeLayout e;
    private ShadowTextView f;
    private ShadowImageView g;
    t h;
    TTAdDislikeToast i;
    private Context k;
    private int l;
    private PAGProgressBar m;
    private PlayableLoadingView n;
    private String o;
    private String p;
    private x q;
    private x r;
    private int s;
    private String t;
    private String u;
    private q v;
    private boolean x;
    private boolean y;
    private b.c.a.a.a.a.c z;
    private boolean c = true;
    private boolean d = true;
    final AtomicBoolean j = new AtomicBoolean(false);
    private y w = new y(Looper.getMainLooper(), this);
    private AtomicBoolean A = new AtomicBoolean(false);
    private volatile int C = 0;
    private volatile int D = 0;
    private volatile int E = 0;
    private boolean J = false;
    protected com.bytedance.sdk.openadsdk.k.d M = new h();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TTPlayableLandingPageActivity.this.K != null) {
                TTPlayableLandingPageActivity.this.K.b();
            }
            TTPlayableLandingPageActivity.this.a("playable_close");
            TTPlayableLandingPageActivity.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTPlayableLandingPageActivity.this.r();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
            tTPlayableLandingPageActivity.J = !tTPlayableLandingPageActivity.J;
            TTPlayableLandingPageActivity tTPlayableLandingPageActivity2 = TTPlayableLandingPageActivity.this;
            tTPlayableLandingPageActivity2.b(tTPlayableLandingPageActivity2.J);
            if (TTPlayableLandingPageActivity.this.H != null) {
                TTPlayableLandingPageActivity.this.H.a(TTPlayableLandingPageActivity.this.J);
            }
        }
    }

    class d extends com.bytedance.sdk.openadsdk.core.c0.a {
        d(Context context, q qVar, String str, int i) {
            super(context, qVar, str, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.a, com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, boolean z) {
            q qVar = this.v;
            if (qVar == null || qVar.y() != 1 || z) {
                super.a(view, f, f2, f3, f4, sparseArray, z);
                TTPlayableLandingPageActivity.this.x = true;
                TTPlayableLandingPageActivity.this.y = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.t);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.m.b("TTPWPActivity", "onClick JSON ERROR", e);
                }
                com.bytedance.sdk.openadsdk.d.c.b(TTPlayableLandingPageActivity.this.v, this.w, "click_playable_download_button_loading", jSONObject);
            }
        }
    }

    class f implements t.a {
        f() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.t.a
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.t.a
        public void a(int i, String str) {
            if (TTPlayableLandingPageActivity.this.j.get() || TextUtils.isEmpty(str)) {
                return;
            }
            TTPlayableLandingPageActivity.this.j.set(true);
            TTPlayableLandingPageActivity.this.u();
        }
    }

    static class g implements com.bytedance.sdk.openadsdk.o.f.a {
        g() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.f.a
        public void a(String str, String str2) {
            com.bytedance.sdk.component.utils.m.a(str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.o.f.a
        public void a(String str, String str2, Throwable th) {
            com.bytedance.sdk.component.utils.m.b(str, str2, th);
        }
    }

    class i extends com.bytedance.sdk.openadsdk.o.a {
        i() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public com.bytedance.sdk.openadsdk.o.d a() {
            String strE = com.bytedance.sdk.openadsdk.common.a.e();
            strE.hashCode();
            strE.hashCode();
            switch (strE) {
                case "2g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_2G;
                case "3g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_3G;
                case "4g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_4G;
                case "5g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_5G;
                case "wifi":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_WIFI;
                default:
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_UNKNOWN;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void a(JSONObject jSONObject) {
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void b(JSONObject jSONObject) {
            com.bytedance.sdk.openadsdk.d.c.b(TTPlayableLandingPageActivity.this.v, "embeded_ad", "playable_track", jSONObject);
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void c(JSONObject jSONObject) {
        }
    }

    class j implements com.bytedance.sdk.openadsdk.o.c {
        j() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.c
        public void a(String str, JSONObject jSONObject) {
            TTPlayableLandingPageActivity.this.q.a(str, jSONObject);
        }
    }

    class k extends b.b.a.a.e.e<JSONObject, JSONObject> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference f410b;

        k(TTPlayableLandingPageActivity tTPlayableLandingPageActivity, WeakReference weakReference) {
            this.f410b = weakReference;
        }

        @Override // b.b.a.a.e.e
        public JSONObject a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
            try {
                com.bytedance.sdk.openadsdk.o.g gVar = (com.bytedance.sdk.openadsdk.o.g) this.f410b.get();
                if (gVar == null) {
                    return null;
                }
                return gVar.a(a(), jSONObject);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    class l implements com.bytedance.sdk.openadsdk.d.i {
        l() {
        }

        @Override // com.bytedance.sdk.openadsdk.d.i
        public void a(int i) {
            com.bytedance.sdk.openadsdk.d.c.o.a(TTPlayableLandingPageActivity.this.F, TTPlayableLandingPageActivity.this.E, TTPlayableLandingPageActivity.this.D, TTPlayableLandingPageActivity.this.C - TTPlayableLandingPageActivity.this.D, TTPlayableLandingPageActivity.this.v, "embeded_ad", i);
        }
    }

    class n extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
        n(x xVar, com.bytedance.sdk.openadsdk.d.j jVar) {
            super(xVar, jVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (TTPlayableLandingPageActivity.this.isFinishing()) {
                return;
            }
            try {
                TTPlayableLandingPageActivity.this.M.a(i);
            } catch (Throwable unused) {
            }
            if (TTPlayableLandingPageActivity.this.m != null) {
                if (i != 100 || !TTPlayableLandingPageActivity.this.m.isShown()) {
                    TTPlayableLandingPageActivity.this.m.setProgress(i);
                } else {
                    TTPlayableLandingPageActivity.this.m.setVisibility(8);
                    TTPlayableLandingPageActivity.this.t();
                }
            }
        }
    }

    class o implements View.OnTouchListener {
        o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (TTPlayableLandingPageActivity.this.L == null) {
                return false;
            }
            TTPlayableLandingPageActivity.this.L.a(motionEvent.getActionMasked());
            return false;
        }
    }

    static /* synthetic */ int r(TTPlayableLandingPageActivity tTPlayableLandingPageActivity) {
        int i2 = tTPlayableLandingPageActivity.E;
        tTPlayableLandingPageActivity.E = i2 + 1;
        return i2;
    }

    static /* synthetic */ int t(TTPlayableLandingPageActivity tTPlayableLandingPageActivity) {
        int i2 = tTPlayableLandingPageActivity.D;
        tTPlayableLandingPageActivity.D = i2 + 1;
        return i2;
    }

    static /* synthetic */ int v(TTPlayableLandingPageActivity tTPlayableLandingPageActivity) {
        int i2 = tTPlayableLandingPageActivity.C;
        tTPlayableLandingPageActivity.C = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.bytedance.sdk.openadsdk.d.o oVar = this.K;
        if (oVar != null) {
            oVar.b();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.l.e()) {
            finish();
            return;
        }
        Long lValueOf = Long.valueOf(SystemClock.elapsedRealtime());
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            com.bytedance.sdk.openadsdk.core.o.a(this);
        } catch (Throwable unused) {
        }
        b(bundle);
        q qVar = this.v;
        if (qVar == null) {
            return;
        }
        int iC = com.bytedance.sdk.openadsdk.core.f0.t.c(qVar);
        if (iC != 0) {
            if (iC == 1) {
                setRequestedOrientation(1);
            } else if (iC == 2) {
                setRequestedOrientation(0);
            }
        } else if (Build.VERSION.SDK_INT >= 18) {
            setRequestedOrientation(14);
        } else {
            setRequestedOrientation(1);
        }
        this.k = this;
        try {
            setContentView(h());
            p();
            l();
            m();
            o();
            j();
            if (!TextUtils.isEmpty(this.B)) {
                this.I = com.bytedance.sdk.openadsdk.f.b.c().a();
                int iA = com.bytedance.sdk.openadsdk.f.b.c().a(this.I, this.B);
                this.F = iA;
                this.G = iA > 0 ? 2 : 0;
            }
            q();
            com.bytedance.sdk.openadsdk.d.o oVar = this.K;
            if (oVar != null) {
                oVar.c();
            }
            com.bytedance.sdk.openadsdk.d.c.o.a(SystemClock.elapsedRealtime() - lValueOf.longValue(), this.v, "embeded_ad", this.I, this.B);
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        com.bytedance.sdk.openadsdk.d.o oVar = this.K;
        if (oVar != null) {
            oVar.a(true);
            this.K.q();
        }
        y yVar = this.w;
        if (yVar != null) {
            yVar.removeCallbacksAndMessages(null);
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.B)) {
            com.bytedance.sdk.openadsdk.d.c.o.a(this.D, this.C, this.v);
        }
        com.bytedance.sdk.openadsdk.f.b.c().a(this.I);
        SSWebView sSWebView = this.a;
        if (sSWebView != null) {
            a0.a(sSWebView.getWebView());
            this.a.g();
        }
        this.a = null;
        x xVar = this.q;
        if (xVar != null) {
            xVar.o();
        }
        x xVar2 = this.r;
        if (xVar2 != null) {
            xVar2.o();
        }
        com.bytedance.sdk.openadsdk.o.g gVar = this.H;
        if (gVar != null) {
            gVar.a();
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.L;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        x xVar = this.q;
        if (xVar != null) {
            xVar.p();
            this.q.b(false);
        }
        x xVar2 = this.r;
        if (xVar2 != null) {
            xVar2.p();
        }
        com.bytedance.sdk.openadsdk.o.g gVar = this.H;
        if (gVar != null) {
            gVar.a(true);
            this.H.u();
            this.H.c(false);
        }
        DeviceUtils.AudioInfoReceiver.b((com.bytedance.sdk.openadsdk.k.g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        x xVar = this.q;
        if (xVar != null) {
            xVar.q();
            SSWebView sSWebView = this.a;
            if (sSWebView != null) {
                this.q.b(sSWebView.getVisibility() == 0);
            }
        }
        x xVar2 = this.r;
        if (xVar2 != null) {
            xVar2.q();
        }
        com.bytedance.sdk.openadsdk.o.g gVar = this.H;
        if (gVar != null) {
            gVar.v();
            this.H.c(true);
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.L;
        if (jVar != null) {
            jVar.e();
        }
        DeviceUtils.AudioInfoReceiver.a((com.bytedance.sdk.openadsdk.k.g) this);
        if (DeviceUtils.d() == 0) {
            this.J = true;
        }
        b(this.J);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            q qVar = this.v;
            bundle.putString("material_meta", qVar != null ? qVar.n1().toString() : null);
            bundle.putInt("sdk_version", this.l);
            bundle.putString("adid", this.o);
            bundle.putString("log_extra", this.p);
            bundle.putInt("source", this.s);
            bundle.putBoolean("ad_pending_download", this.x);
            bundle.putString("url", this.t);
            bundle.putString("web_title", this.u);
            bundle.putString("event_tag", "embeded_ad");
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.d.o oVar = this.K;
        if (oVar != null) {
            oVar.e();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.d.o oVar = this.K;
        if (oVar != null) {
            oVar.d();
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.L;
        if (jVar != null) {
            jVar.f();
        }
    }

    class e extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        e(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TTPlayableLandingPageActivity.this.d) {
                TTPlayableLandingPageActivity.this.a("loading_h5_success");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            TTPlayableLandingPageActivity.this.d = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            TTPlayableLandingPageActivity.this.d = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TTPlayableLandingPageActivity.this.d = false;
        }
    }

    class m extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        m(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TTPlayableLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (TTPlayableLandingPageActivity.this.H != null) {
                TTPlayableLandingPageActivity.this.H.c(str);
            }
            try {
                TTPlayableLandingPageActivity.this.M.b();
            } catch (Throwable unused) {
            }
            try {
                if (TTPlayableLandingPageActivity.this.m != null) {
                    TTPlayableLandingPageActivity.this.m.setVisibility(8);
                }
                if (TTPlayableLandingPageActivity.this.c) {
                    TTPlayableLandingPageActivity.this.t();
                    TTPlayableLandingPageActivity.this.a("py_loading_success");
                    x xVar = this.a;
                    if (xVar != null) {
                        xVar.b(true);
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (TTPlayableLandingPageActivity.this.H != null) {
                TTPlayableLandingPageActivity.this.H.d(str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            TTPlayableLandingPageActivity.this.c = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (TTPlayableLandingPageActivity.this.t != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableLandingPageActivity.this.t.equals(webResourceRequest.getUrl().toString())) {
                TTPlayableLandingPageActivity.this.c = false;
            }
            if (TTPlayableLandingPageActivity.this.H != null && webResourceRequest != null) {
                try {
                    TTPlayableLandingPageActivity.this.H.a(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                } catch (Throwable unused) {
                }
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                if (TTPlayableLandingPageActivity.this.H != null) {
                    TTPlayableLandingPageActivity.this.H.a(str);
                }
                if (!TextUtils.isEmpty(TTPlayableLandingPageActivity.this.B)) {
                    TTPlayableLandingPageActivity.v(TTPlayableLandingPageActivity.this);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                WebResourceResponseModel webResourceResponseModelA = com.bytedance.sdk.openadsdk.f.b.c().a(TTPlayableLandingPageActivity.this.I, TTPlayableLandingPageActivity.this.B, str);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (TTPlayableLandingPageActivity.this.K != null) {
                    b.b.a.a.d.g.e.a aVarA = b.b.a.a.d.g.e.a(str);
                    int i = (webResourceResponseModelA == null || webResourceResponseModelA.getWebResourceResponse() == null) ? 2 : 1;
                    if (aVarA == b.b.a.a.d.g.e.a.HTML) {
                        TTPlayableLandingPageActivity.this.K.a(str, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                    } else if (aVarA == b.b.a.a.d.g.e.a.JS) {
                        TTPlayableLandingPageActivity.this.K.b(str, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                    }
                }
                if (webResourceResponseModelA == null || webResourceResponseModelA.getWebResourceResponse() == null) {
                    if (webResourceResponseModelA != null && webResourceResponseModelA.getMsg() == 2) {
                        TTPlayableLandingPageActivity.r(TTPlayableLandingPageActivity.this);
                    }
                    return super.shouldInterceptRequest(webView, str);
                }
                TTPlayableLandingPageActivity.t(TTPlayableLandingPageActivity.this);
                com.bytedance.sdk.component.utils.m.a("TTPWPActivity", "GeckoLog: hit++");
                if (TTPlayableLandingPageActivity.this.H != null) {
                    TTPlayableLandingPageActivity.this.H.b(str);
                }
                return webResourceResponseModelA.getWebResourceResponse();
            } catch (Exception unused) {
                return super.shouldInterceptRequest(webView, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TTPlayableLandingPageActivity.this.c = false;
            if (TTPlayableLandingPageActivity.this.H != null) {
                TTPlayableLandingPageActivity.this.H.a(i, str, str2);
            }
        }
    }

    private View h() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this);
        pAGFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.a = new SSWebView(this);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setVisibility(4);
        this.m = new PAGProgressBar(this, null, R.style.Widget.ProgressBar.Horizontal);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b0.a(this, 3.0f));
        layoutParams.gravity = 49;
        this.m.setLayoutParams(layoutParams);
        this.m.setProgress(1);
        this.m.setProgressDrawable(com.bytedance.sdk.component.utils.t.f(this, "tt_browser_progress_style"));
        this.f409b = new SSWebView(this);
        this.f409b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.n = new PlayableLoadingView(this);
        this.n.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.n.setClickable(true);
        this.n.setFocusable(true);
        this.g = new ShadowImageView(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b0.a(this, 28.0f), b0.a(this, 28.0f));
        layoutParams2.leftMargin = b0.a(this, 12.0f);
        layoutParams2.topMargin = b0.a(this, 20.0f);
        this.g.setLayoutParams(layoutParams2);
        this.g.setScaleType(ImageView.ScaleType.CENTER);
        this.g.setImageResource(com.bytedance.sdk.component.utils.t.e(this, "tt_unmute_wrapper"));
        this.f = new ShadowTextView(this);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, b0.a(this, 28.0f));
        layoutParams3.gravity = 8388661;
        layoutParams3.leftMargin = b0.a(this, 16.0f);
        layoutParams3.rightMargin = b0.a(this, 80.0f);
        layoutParams3.topMargin = b0.a(this, 20.0f);
        this.f.setLayoutParams(layoutParams3);
        this.f.setGravity(17);
        this.f.setText(com.bytedance.sdk.component.utils.t.k(this, "tt_reward_feedback"));
        this.f.setTextColor(Color.parseColor("#ffffff"));
        this.f.setTextSize(14.0f);
        this.e = new PAGRelativeLayout(this);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(b0.a(this, 28.0f), b0.a(this, 28.0f));
        layoutParams4.gravity = 8388661;
        layoutParams4.topMargin = b0.a(this, 20.0f);
        layoutParams4.rightMargin = b0.a(this, 24.0f);
        this.e.setLayoutParams(layoutParams4);
        this.e.setBackground(com.bytedance.sdk.component.utils.t.f(this, "tt_mute_btn_bg"));
        this.e.setGravity(17);
        this.e.setVisibility(8);
        PAGImageView pAGImageView = new PAGImageView(this);
        pAGImageView.setLayoutParams(new RelativeLayout.LayoutParams(b0.a(this, 12.0f), b0.a(this, 12.0f)));
        pAGImageView.setImageDrawable(com.bytedance.sdk.component.utils.t.f(this, "tt_video_close_drawable"));
        pAGImageView.setVisibility(0);
        this.e.addView(pAGImageView);
        pAGFrameLayout.addView(this.a);
        pAGFrameLayout.addView(this.m);
        pAGFrameLayout.addView(this.f409b);
        pAGFrameLayout.addView(this.n);
        pAGFrameLayout.addView(this.g);
        pAGFrameLayout.addView(this.f);
        pAGFrameLayout.addView(this.e);
        return pAGFrameLayout;
    }

    private String i() {
        q qVar;
        String strK = com.bytedance.sdk.openadsdk.core.o.d().k();
        if (TextUtils.isEmpty(strK) || (qVar = this.v) == null || qVar.h() == null) {
            return strK;
        }
        String strA = this.v.h().a();
        double dF = this.v.h().f();
        int iC = this.v.h().c();
        String strD = (this.v.b0() == null || TextUtils.isEmpty(this.v.b0().d())) ? "" : this.v.b0().d();
        String strE = this.v.e();
        String strE2 = this.v.h().e();
        String strD2 = this.v.h().d();
        String strA2 = this.v.h().a();
        StringBuffer stringBuffer = new StringBuffer(strK);
        stringBuffer.append("?appname=").append(strA).append("&stars=").append(dF).append("&comments=").append(iC).append("&icon=").append(strD).append("&downloading=").append(false).append("&id=").append(strE).append("&pkg_name=").append(strE2).append("&download_url=").append(strD2).append("&name=").append(strA2);
        return stringBuffer.toString();
    }

    private void j() {
        int i2 = com.bytedance.sdk.openadsdk.core.o.d().l(String.valueOf(this.v.S())).p;
        if (i2 >= 0) {
            this.w.sendEmptyMessageDelayed(1, i2 * 1000);
        } else {
            b0.a((View) this.e, 0);
        }
    }

    private void l() {
        if (this.v.e0() == 4) {
            this.z = b.c.a.a.a.a.d.a(this.k, this.v, "interaction");
        }
    }

    private void n() {
        if (this.H != null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.h.a().p()) {
            com.bytedance.sdk.openadsdk.o.f.a(N);
        }
        i iVar = new i();
        j jVar = new j();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BidResponsedEx.KEY_CID, this.o);
            jSONObject.put("log_extra", this.p);
            this.H = com.bytedance.sdk.openadsdk.o.g.a(getApplicationContext(), this.a.getWebView(), jVar, iVar).j(this.t).g(com.bytedance.sdk.openadsdk.common.a.a(com.bytedance.sdk.openadsdk.core.o.a())).e(com.bytedance.sdk.openadsdk.common.a.b()).e(jSONObject).h(com.bytedance.sdk.openadsdk.common.a.d()).a("sdkEdition", com.bytedance.sdk.openadsdk.common.a.f()).f(com.bytedance.sdk.openadsdk.common.a.c()).b(false).a(this.J).c(true);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.f0.t.d(this.v))) {
            this.H.i(com.bytedance.sdk.openadsdk.core.f0.t.d(this.v));
        }
        Set<String> setJ = this.H.j();
        WeakReference weakReference = new WeakReference(this.H);
        for (String str : setJ) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                this.q.b().a(str, new k(this, weakReference));
            }
        }
    }

    private void o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.v);
        this.K = new com.bytedance.sdk.openadsdk.d.o(3, "embeded_ad", this.v);
        this.q = new x(this);
        String strD = this.v.D();
        this.q.a(this.a).a(this.v).b(arrayList).g(this.o).j(this.p).i("embeded_ad").b(this.s).a(this).a(this.K).a(this.M).b(this.a).h(strD);
        x xVar = new x(this);
        this.r = xVar;
        xVar.a(this.f409b).a(this.v).g(this.o).j(this.p).a(this).b(this.s).c(false).a(this.K).b(this.f409b).h(strD);
        n();
    }

    private void p() {
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new a());
        }
        ShadowTextView shadowTextView = this.f;
        if (shadowTextView != null) {
            shadowTextView.setOnClickListener(new b());
        }
        ShadowImageView shadowImageView = this.g;
        if (shadowImageView != null) {
            shadowImageView.setOnClickListener(new c());
        }
        this.a.setBackgroundColor(-16777216);
        this.f409b.setBackgroundColor(-16777216);
        b0.a((View) this.a, 4);
        b0.a((View) this.f409b, 0);
    }

    private void q() {
        SSWebView sSWebView = this.a;
        if (sSWebView == null) {
            return;
        }
        sSWebView.setLandingPage(true);
        this.a.setTag("landingpage");
        this.a.setMaterialMeta(this.v.L());
        com.bytedance.sdk.openadsdk.d.j jVarA = new com.bytedance.sdk.openadsdk.d.j(this.v, this.a.getWebView(), new l(), this.G).a(true);
        this.L = jVarA;
        jVarA.b("embeded_ad");
        this.L.a(this.K);
        this.a.setWebViewClient(new m(this.k, this.q, this.o, this.L, true));
        a(this.a);
        a(this.f409b);
        v();
        com.bytedance.sdk.openadsdk.utils.n.a(this.a, this.t);
        this.a.setWebChromeClient(new n(this.q, this.L));
        this.a.setOnTouchListener(new o());
    }

    private void s() {
        TTAdDislikeToast tTAdDislikeToast = this.i;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(TTAdDislikeToast.getDislikeTip());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        SSWebView sSWebView;
        if (this.A.getAndSet(true) || (sSWebView = this.a) == null || this.f409b == null) {
            return;
        }
        b0.a((View) sSWebView, 0);
        b0.a((View) this.f409b, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        TTAdDislikeToast tTAdDislikeToast = this.i;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    private void v() {
        if (this.f409b == null) {
            return;
        }
        String strI = i();
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        this.f409b.setWebViewClient(new e(this.k, this.r, this.o, null, false));
        this.f409b.c(strI);
    }

    void k() {
        q qVar = this.v;
        if (qVar != null) {
            this.h = new com.bytedance.sdk.openadsdk.dislike.b(this, qVar.N(), this.v.W());
        }
        if (this.i == null) {
            this.i = new TTAdDislikeToast(this);
            ((FrameLayout) findViewById(R.id.content)).addView(this.i);
        }
    }

    protected void m() {
        if (this.n == null) {
            return;
        }
        q qVar = this.v;
        if (qVar != null && !com.bytedance.sdk.openadsdk.core.f0.t.l(qVar)) {
            this.n.n();
            return;
        }
        this.n.p();
        if (this.n.getPlayView() != null) {
            d dVar = new d(this, this.v, "embeded_ad", this.s);
            dVar.a(this.z);
            this.n.getPlayView().setOnClickListener(dVar);
        }
        if (com.bytedance.sdk.openadsdk.core.f0.t.j(this.v)) {
            this.w.sendMessageDelayed(c(2), 10000L);
        }
    }

    protected void r() {
        if (this.v == null || isFinishing()) {
            return;
        }
        if (this.j.get()) {
            s();
            return;
        }
        if (this.h == null) {
            k();
        }
        this.h.a(new f());
        t tVar = this.h;
        if (tVar != null) {
            tVar.a();
        }
    }

    private void b(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getIntExtra("sdk_version", 1);
            this.o = intent.getStringExtra("adid");
            this.p = intent.getStringExtra("log_extra");
            this.s = intent.getIntExtra("source", -1);
            this.x = intent.getBooleanExtra("ad_pending_download", false);
            this.t = intent.getStringExtra("url");
            this.B = intent.getStringExtra("gecko_id");
            this.u = intent.getStringExtra("web_title");
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.v = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        com.bytedance.sdk.component.utils.m.b("TTPWPActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                    }
                }
            } else {
                this.v = s.g().e();
                s.g().a();
            }
        }
        if (bundle != null) {
            try {
                this.l = bundle.getInt("sdk_version", 1);
                this.o = bundle.getString("adid");
                this.p = bundle.getString("log_extra");
                this.s = bundle.getInt("source", -1);
                this.x = bundle.getBoolean("ad_pending_download", false);
                this.t = bundle.getString("url");
                this.u = bundle.getString("web_title");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.v = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.v == null) {
            com.bytedance.sdk.component.utils.m.b("TTPWPActivity", "material is null, no data to display");
            finish();
        } else {
            try {
                this.J = com.bytedance.sdk.openadsdk.core.o.d().z(this.v.f().getCodeId());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTPWPActivity", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message c(int i2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i2;
        return messageObtain;
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.b.a(this.k).a(false).b(false).a(sSWebView.getWebView());
        sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.k.a(sSWebView.getWebView(), this.l));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.setMixedContentMode(0);
        }
    }

    class h implements com.bytedance.sdk.openadsdk.k.d {
        h() {
        }

        @Override // com.bytedance.sdk.openadsdk.k.d
        public void a() {
            if (!TTPlayableLandingPageActivity.this.isFinishing() && com.bytedance.sdk.openadsdk.core.f0.t.l(TTPlayableLandingPageActivity.this.v) && com.bytedance.sdk.openadsdk.core.f0.t.j(TTPlayableLandingPageActivity.this.v)) {
                TTPlayableLandingPageActivity.this.w.removeMessages(2);
                TTPlayableLandingPageActivity.this.w.sendMessage(TTPlayableLandingPageActivity.this.c(1));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.k.d
        public void b() {
            if (com.bytedance.sdk.openadsdk.core.f0.t.l(TTPlayableLandingPageActivity.this.v) && com.bytedance.sdk.openadsdk.core.f0.t.k(TTPlayableLandingPageActivity.this.v)) {
                TTPlayableLandingPageActivity.this.w.sendMessageDelayed(TTPlayableLandingPageActivity.this.c(0), 1000L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.k.d
        public void a(int i) {
            if (!com.bytedance.sdk.openadsdk.core.f0.t.l(TTPlayableLandingPageActivity.this.v) || TTPlayableLandingPageActivity.this.n == null) {
                return;
            }
            TTPlayableLandingPageActivity.this.n.setProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.d.c.c(this.v, "embeded_ad", str, null);
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            b0.a((View) this.e, 0);
            return;
        }
        if (i2 != 2) {
            return;
        }
        com.bytedance.sdk.component.utils.m.a("playable hidden loading , type:" + message.arg1);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remove_loading_page_type", message.arg1);
            jSONObject.put("playable_url", this.t);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.m.b("TTPWPActivity", "handleMsg json error", e2);
        }
        com.bytedance.sdk.openadsdk.d.c.b(this.v, "embeded_ad", "remove_loading_page", jSONObject);
        this.w.removeMessages(2);
        PlayableLoadingView playableLoadingView = this.n;
        if (playableLoadingView != null) {
            playableLoadingView.n();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.d
    public void a(boolean z) {
        b.c.a.a.a.a.c cVar;
        this.x = true;
        this.y = z;
        if (!z) {
            try {
                Toast.makeText(this.k, com.bytedance.sdk.component.utils.t.k(com.bytedance.sdk.openadsdk.core.o.a(), "tt_toast_later_download"), 0).show();
            } catch (Throwable unused) {
            }
        }
        if (!this.y || (cVar = this.z) == null) {
            return;
        }
        cVar.b();
    }

    @Override // com.bytedance.sdk.openadsdk.k.g
    public void a(int i2) {
        b(i2 <= 0);
    }

    protected void b(boolean z) {
        int iE;
        try {
            this.J = z;
            if (z) {
                iE = com.bytedance.sdk.component.utils.t.e(this.k, "tt_mute_wrapper");
            } else {
                iE = com.bytedance.sdk.component.utils.t.e(this.k, "tt_unmute_wrapper");
            }
            this.g.setImageResource(iE);
            com.bytedance.sdk.openadsdk.o.g gVar = this.H;
            if (gVar != null) {
                gVar.a(z);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTPWPActivity", e2.getMessage());
        }
    }
}
