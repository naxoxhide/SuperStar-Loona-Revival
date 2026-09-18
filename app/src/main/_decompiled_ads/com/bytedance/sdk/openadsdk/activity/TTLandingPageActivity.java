package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserDownloadButton;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserNewBottomBar;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserNewTitleBar;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserTitleBar;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserTitleBarForDark;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.common.PangleViewStub;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.a0;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTLandingPageActivity extends TTBaseActivity implements com.bytedance.sdk.openadsdk.i.d {
    private int A;
    private boolean C;
    private com.bytedance.sdk.openadsdk.common.i D;
    private com.bytedance.sdk.openadsdk.common.g E;
    TTAdDislikeDialog F;
    TTAdDislikeToast G;
    private LandingPageLoadingLayout J;
    private boolean K;
    private SSWebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f405b;
    private ImageView c;
    private TextView d;
    private Context e;
    private int f;
    private PangleViewStub g;
    private PangleViewStub h;
    private PangleViewStub i;
    private Button j;
    private ProgressBar k;
    private String l;
    private String m;
    private x n;
    private int o;
    private String p;
    private com.bytedance.sdk.openadsdk.core.f0.q q;
    com.bytedance.sdk.openadsdk.d.j r;
    private b.c.a.a.a.a.c s;
    private String t;
    private String v;
    private ILoader w;
    private int z;
    private AtomicBoolean u = new AtomicBoolean(true);
    private volatile int x = 0;
    private volatile int y = 0;
    private volatile int B = 0;
    final AtomicBoolean H = new AtomicBoolean(false);
    final AtomicBoolean I = new AtomicBoolean(false);
    private String L = "ダウンロード";

    class a implements PangleViewStub.a {
        a(TTLandingPageActivity tTLandingPageActivity) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.PangleViewStub.a
        public View a(Context context) {
            return new LandingPageBrowserDownloadButton(context);
        }
    }

    class b implements PangleViewStub.a {
        b(TTLandingPageActivity tTLandingPageActivity) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.PangleViewStub.a
        public View a(Context context) {
            return new LandingPageBrowserNewBottomBar(context);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTLandingPageActivity.this.j == null || TTLandingPageActivity.this.isFinishing()) {
                return;
            }
            TTLandingPageActivity.this.j.setText(this.a);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTLandingPageActivity.this.finish();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TTLandingPageActivity.this.a != null) {
                if (TTLandingPageActivity.this.a.c()) {
                    TTLandingPageActivity.this.a.h();
                } else if (TTLandingPageActivity.this.n()) {
                    TTLandingPageActivity.this.onBackPressed();
                } else {
                    TTLandingPageActivity.this.finish();
                }
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTLandingPageActivity.this.finish();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTLandingPageActivity.this.o();
        }
    }

    class h implements Runnable {
        final /* synthetic */ int a;

        h(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.a((View) TTLandingPageActivity.this.c, this.a);
        }
    }

    class i implements TTAdDislikeDialog.e {
        i() {
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(View view) {
            TTLandingPageActivity.this.H.set(true);
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void b(View view) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void c(View view) {
            TTLandingPageActivity.this.H.set(false);
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(int i, FilterWord filterWord) {
            if (TTLandingPageActivity.this.I.get() || filterWord == null || filterWord.hasSecondOptions()) {
                return;
            }
            TTLandingPageActivity.this.I.set(true);
            TTLandingPageActivity.this.q();
        }
    }

    class j implements com.bytedance.sdk.openadsdk.d.i {
        j() {
        }

        @Override // com.bytedance.sdk.openadsdk.d.i
        public void a(int i) {
            com.bytedance.sdk.openadsdk.d.c.o.a(TTLandingPageActivity.this.z, TTLandingPageActivity.this.y, TTLandingPageActivity.this.B, TTLandingPageActivity.this.x - TTLandingPageActivity.this.B, TTLandingPageActivity.this.q, "landingpage", i);
        }
    }

    class k extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        k(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                if (TTLandingPageActivity.this.k != null && !TTLandingPageActivity.this.isFinishing()) {
                    TTLandingPageActivity.this.k.setVisibility(8);
                }
            } catch (Throwable unused) {
            }
            if (TTLandingPageActivity.this.J != null) {
                TTLandingPageActivity.this.J.n();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                if (TextUtils.isEmpty(TTLandingPageActivity.this.v)) {
                    return super.shouldInterceptRequest(webView, str);
                }
                TTLandingPageActivity.o(TTLandingPageActivity.this);
                WebResourceResponseModel webResourceResponseModelA = com.bytedance.sdk.openadsdk.f.b.c().a(TTLandingPageActivity.this.w, TTLandingPageActivity.this.v, str);
                if (webResourceResponseModelA != null && webResourceResponseModelA.getWebResourceResponse() != null) {
                    TTLandingPageActivity.m(TTLandingPageActivity.this);
                    com.bytedance.sdk.component.utils.m.a("TTAD.LandingPageAct", "GeckoLog: hit++");
                    return webResourceResponseModelA.getWebResourceResponse();
                }
                if (webResourceResponseModelA != null && webResourceResponseModelA.getMsg() == 2) {
                    TTLandingPageActivity.d(TTLandingPageActivity.this);
                }
                return super.shouldInterceptRequest(webView, str);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.LandingPageAct", "shouldInterceptRequest url error", th);
                return super.shouldInterceptRequest(webView, str);
            }
        }
    }

    class l extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
        l(x xVar, com.bytedance.sdk.openadsdk.d.j jVar) {
            super(xVar, jVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (TTLandingPageActivity.this.J != null) {
                TTLandingPageActivity.this.J.e(i);
            }
            if (TTLandingPageActivity.this.C) {
                if (TTLandingPageActivity.this.D != null) {
                    TTLandingPageActivity.this.D.a(webView, i);
                }
                if (TTLandingPageActivity.this.E == null || i != 100) {
                    return;
                }
                TTLandingPageActivity.this.E.a(webView);
                return;
            }
            if (TTLandingPageActivity.this.k == null || TTLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (i == 100 && TTLandingPageActivity.this.k.isShown()) {
                TTLandingPageActivity.this.k.setVisibility(8);
            } else {
                TTLandingPageActivity.this.k.setProgress(i);
            }
        }
    }

    class m implements View.OnTouchListener {
        float a = 0.0f;

        m() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.openadsdk.d.j jVar = TTLandingPageActivity.this.r;
            if (jVar != null) {
                jVar.a(motionEvent.getActionMasked());
            }
            if (motionEvent.getAction() == 0) {
                this.a = motionEvent.getY();
            }
            if (motionEvent.getAction() == 2) {
                float y = motionEvent.getY() - this.a;
                if (y > 8.0f) {
                    if (TTLandingPageActivity.this.D != null) {
                        TTLandingPageActivity.this.D.g();
                    }
                    if (TTLandingPageActivity.this.E != null) {
                        TTLandingPageActivity.this.E.c();
                    }
                    return false;
                }
                if (y < -8.0f) {
                    if (TTLandingPageActivity.this.D != null) {
                        TTLandingPageActivity.this.D.b();
                    }
                    if (TTLandingPageActivity.this.E != null) {
                        TTLandingPageActivity.this.E.a();
                    }
                }
            }
            return false;
        }
    }

    class n implements View.OnTouchListener {
        n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.openadsdk.d.j jVar = TTLandingPageActivity.this.r;
            if (jVar == null) {
                return false;
            }
            jVar.a(motionEvent.getActionMasked());
            return false;
        }
    }

    class o implements DownloadListener {
        o() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (TTLandingPageActivity.this.s != null) {
                TTLandingPageActivity.this.s.b();
            }
        }
    }

    class p implements PangleViewStub.a {
        p(TTLandingPageActivity tTLandingPageActivity) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.PangleViewStub.a
        public View a(Context context) {
            return new LandingPageBrowserTitleBar(context);
        }
    }

    class q implements PangleViewStub.a {
        q(TTLandingPageActivity tTLandingPageActivity) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.PangleViewStub.a
        public View a(Context context) {
            return new LandingPageBrowserTitleBarForDark(context);
        }
    }

    class r implements PangleViewStub.a {
        r(TTLandingPageActivity tTLandingPageActivity) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.PangleViewStub.a
        public View a(Context context) {
            return new LandingPageBrowserNewTitleBar(context);
        }
    }

    static /* synthetic */ int d(TTLandingPageActivity tTLandingPageActivity) {
        int i2 = tTLandingPageActivity.y;
        tTLandingPageActivity.y = i2 + 1;
        return i2;
    }

    static /* synthetic */ int m(TTLandingPageActivity tTLandingPageActivity) {
        int i2 = tTLandingPageActivity.B;
        tTLandingPageActivity.B = i2 + 1;
        return i2;
    }

    static /* synthetic */ int o(TTLandingPageActivity tTLandingPageActivity) {
        int i2 = tTLandingPageActivity.x;
        tTLandingPageActivity.x = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (n() && !this.u.getAndSet(true)) {
            b(true);
            c(0);
        } else {
            try {
                super.onBackPressed();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.LandingPageAct", "onBackPressed: ", th.getMessage());
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        d(3);
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.l.e()) {
            finish();
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.o.a(this);
        } catch (Throwable unused) {
        }
        Long lValueOf = Long.valueOf(SystemClock.elapsedRealtime());
        try {
            setContentView(h());
            Intent intent = getIntent();
            this.f = intent.getIntExtra("sdk_version", 1);
            this.l = intent.getStringExtra("adid");
            this.m = intent.getStringExtra("log_extra");
            this.o = intent.getIntExtra("source", -1);
            String stringExtra = intent.getStringExtra("url");
            this.t = stringExtra;
            c(4);
            String stringExtra2 = intent.getStringExtra("web_title");
            this.p = intent.getStringExtra("event_tag");
            this.v = intent.getStringExtra("gecko_id");
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.q = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(stringExtra3));
                    } catch (Exception e2) {
                        com.bytedance.sdk.component.utils.m.b("TTAD.LandingPageAct", "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                    }
                }
            } else {
                this.q = s.g().e();
                s.g().a();
            }
            if (this.q == null) {
                finish();
                return;
            }
            this.C = com.bytedance.sdk.openadsdk.core.o.d().Y();
            m();
            if (!TextUtils.isEmpty(this.v)) {
                this.w = com.bytedance.sdk.openadsdk.f.b.c().a();
                int iA = com.bytedance.sdk.openadsdk.f.b.c().a(this.w, this.v);
                this.z = iA;
                this.A = iA > 0 ? 2 : 0;
            }
            this.e = this;
            if (this.a != null) {
                com.bytedance.sdk.openadsdk.core.widget.webview.b.a(this).a(false).b(false).a(this.a.getWebView());
            }
            SSWebView sSWebView = this.a;
            if (sSWebView != null && sSWebView.getWebView() != null) {
                this.r = new com.bytedance.sdk.openadsdk.d.j(this.q, this.a.getWebView(), new j(), this.A).a(true);
            }
            l();
            this.a.setLandingPage(true);
            this.a.setTag("landingpage");
            this.a.setMaterialMeta(this.q.L());
            this.a.setWebViewClient(new k(this.e, this.n, this.l, this.r, true));
            SSWebView sSWebView2 = this.a;
            if (sSWebView2 != null) {
                sSWebView2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.k.a(sSWebView2.getWebView(), this.f));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.a.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.d.c.a(this.q, "landingpage", this.A);
            com.bytedance.sdk.openadsdk.utils.n.a(this.a, stringExtra);
            this.a.setWebChromeClient(new l(this.n, this.r));
            if (this.a.getWebView() != null) {
                if (this.C) {
                    this.a.getWebView().setOnTouchListener(new m());
                } else {
                    this.a.getWebView().setOnTouchListener(new n());
                }
            }
            this.a.setDownloadListener(new o());
            TextView textView = this.d;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = t.k(this, "tt_web_title_default");
                }
                textView.setText(stringExtra2);
            }
            k();
            com.bytedance.sdk.openadsdk.d.c.o.a(SystemClock.elapsedRealtime() - lValueOf.longValue(), this.q, "landingpage", this.w, this.v);
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        SSWebView sSWebView;
        super.onDestroy();
        com.bytedance.sdk.openadsdk.d.j jVar = this.r;
        if (jVar != null && (sSWebView = this.a) != null) {
            jVar.a(sSWebView);
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView2 = this.a;
        if (sSWebView2 != null) {
            a0.a(sSWebView2.getWebView());
        }
        this.a = null;
        x xVar = this.n;
        if (xVar != null) {
            xVar.o();
        }
        com.bytedance.sdk.openadsdk.d.j jVar2 = this.r;
        if (jVar2 != null) {
            jVar2.d();
        }
        if (!TextUtils.isEmpty(this.v)) {
            com.bytedance.sdk.openadsdk.d.c.o.a(this.B, this.x, this.q);
        }
        com.bytedance.sdk.openadsdk.f.b.c().a(this.w);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        x xVar = this.n;
        if (xVar != null) {
            xVar.p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        x xVar = this.n;
        if (xVar != null) {
            xVar.q();
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.r;
        if (jVar != null) {
            jVar.e();
        }
        if (this.K) {
            return;
        }
        this.K = true;
        d(4);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.d.j jVar = this.r;
        if (jVar != null) {
            jVar.f();
        }
    }

    private void a(String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.j) == null) {
            return;
        }
        button.post(new c(str));
    }

    private void b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z);
            this.n.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    private void c(int i2) {
        if (this.c == null || !n()) {
            return;
        }
        y.a(new h(i2));
    }

    private void d(int i2) {
        int i3;
        if (i2 == 1 || (i3 = Build.VERSION.SDK_INT) == 26) {
            return;
        }
        if (i3 != 27) {
            setRequestedOrientation(i2);
        } else {
            try {
                setRequestedOrientation(i2);
            } catch (Throwable unused) {
            }
        }
    }

    private View h() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this);
        pAGLinearLayout.setOrientation(1);
        pAGFrameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        View pangleViewStub = new PangleViewStub(this, new p(this));
        pangleViewStub.setId(com.bytedance.sdk.openadsdk.utils.h.Y);
        pAGLinearLayout.addView(pangleViewStub, new LinearLayout.LayoutParams(-1, b0.a(this, 44.0f)));
        View pangleViewStub2 = new PangleViewStub(this, new q(this));
        pangleViewStub2.setId(com.bytedance.sdk.openadsdk.utils.h.Z);
        pAGLinearLayout.addView(pangleViewStub2, new LinearLayout.LayoutParams(-1, b0.a(this, 44.0f)));
        View pangleViewStub3 = new PangleViewStub(this, new r(this));
        pangleViewStub3.setId(com.bytedance.sdk.openadsdk.utils.h.a0);
        pAGLinearLayout.addView(pangleViewStub3, new LinearLayout.LayoutParams(-1, b0.a(this, 44.0f)));
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout.addView(pAGFrameLayout2, layoutParams);
        SSWebView sSWebView = new SSWebView(this);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.O);
        pAGFrameLayout2.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        PangleViewStub pangleViewStub4 = new PangleViewStub(this, new a(this));
        pangleViewStub4.setId(com.bytedance.sdk.openadsdk.utils.h.W);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        pAGFrameLayout2.addView(pangleViewStub4, layoutParams2);
        PAGProgressBar pAGProgressBar = new PAGProgressBar(this, null, R.style.Widget.ProgressBar.Horizontal);
        pAGProgressBar.setId(com.bytedance.sdk.openadsdk.utils.h.b0);
        pAGProgressBar.setProgress(1);
        pAGProgressBar.setVisibility(8);
        pAGProgressBar.setProgressDrawable(t.f(this, "tt_browser_progress_style"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, b0.a(this, 3.0f));
        layoutParams3.gravity = 49;
        pAGFrameLayout2.addView(pAGProgressBar, layoutParams3);
        PangleViewStub pangleViewStub5 = new PangleViewStub(this, new b(this));
        pangleViewStub5.setId(com.bytedance.sdk.openadsdk.utils.h.X);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, b0.a(this, 44.0f));
        layoutParams4.gravity = 80;
        pAGFrameLayout2.addView(pangleViewStub5, layoutParams4);
        LandingPageLoadingLayout landingPageLoadingLayout = new LandingPageLoadingLayout(this);
        landingPageLoadingLayout.setId(520093721);
        pAGFrameLayout.addView(landingPageLoadingLayout, new FrameLayout.LayoutParams(-1, -1));
        return pAGFrameLayout;
    }

    private String i() {
        com.bytedance.sdk.openadsdk.core.f0.q qVar = this.q;
        if (qVar != null && !TextUtils.isEmpty(qVar.r())) {
            this.L = this.q.r();
        }
        return this.L;
    }

    private void j() {
        try {
            if (this.F == null) {
                TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog(this.e, this.q);
                this.F = tTAdDislikeDialog;
                tTAdDislikeDialog.setCallback(new i());
            }
            ((FrameLayout) findViewById(R.id.content)).addView(this.F);
            if (this.G == null) {
                this.G = new TTAdDislikeToast(this.e);
                ((FrameLayout) findViewById(R.id.content)).addView(this.G);
            }
        } catch (Throwable unused) {
        }
    }

    private void k() {
        com.bytedance.sdk.openadsdk.core.f0.q qVar = this.q;
        if (qVar == null || qVar.e0() != 4) {
            return;
        }
        PangleViewStub pangleViewStub = this.i;
        if (pangleViewStub != null) {
            pangleViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(com.bytedance.sdk.openadsdk.utils.h.m0);
        this.j = button;
        if (button != null) {
            a(i());
            if (this.s == null) {
                this.s = b.c.a.a.a.a.d.a(this, this.q, TextUtils.isEmpty(this.p) ? com.bytedance.sdk.openadsdk.utils.a0.c(this.o) : this.p);
            }
            com.bytedance.sdk.openadsdk.core.c0.a aVar = new com.bytedance.sdk.openadsdk.core.c0.a(this, this.q, this.p, this.o);
            aVar.b(false);
            this.j.setOnClickListener(aVar);
            this.j.setOnTouchListener(aVar);
            aVar.d(true);
            aVar.a(this.s);
        }
    }

    private void l() {
        x xVar = new x(this);
        this.n = xVar;
        xVar.a(this.a).g(this.l).j(this.m).a(this.q).b(this.o).c(this.q.L0()).h(this.q.D()).b(this.a).i("landingpage").a(this);
    }

    private void m() {
        PangleViewStub pangleViewStub;
        this.a = (SSWebView) findViewById(com.bytedance.sdk.openadsdk.utils.h.O);
        this.i = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.h.W);
        this.g = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.h.Y);
        this.h = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.h.Z);
        LandingPageLoadingLayout landingPageLoadingLayout = (LandingPageLoadingLayout) findViewById(520093721);
        this.J = landingPageLoadingLayout;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.q, this.p, true);
            this.J.o();
        }
        if (this.C) {
            PangleViewStub pangleViewStub2 = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.h.a0);
            PangleViewStub pangleViewStub3 = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.h.X);
            pangleViewStub2.setVisibility(0);
            pangleViewStub3.setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(com.bytedance.sdk.openadsdk.utils.h.c0);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.h.h0);
            com.bytedance.sdk.openadsdk.common.i iVar = new com.bytedance.sdk.openadsdk.common.i(this, relativeLayout, this.q);
            this.D = iVar;
            ImageView imageViewA = iVar.a();
            this.c = imageViewA;
            imageViewA.setOnClickListener(new d());
            this.E = new com.bytedance.sdk.openadsdk.common.g(this, linearLayout, this.a, this.q, "landingpage");
            return;
        }
        int iN = com.bytedance.sdk.openadsdk.core.h.a().n();
        if (iN == 0) {
            PangleViewStub pangleViewStub4 = this.g;
            if (pangleViewStub4 != null) {
                pangleViewStub4.setVisibility(0);
            }
        } else if (iN == 1 && (pangleViewStub = this.h) != null) {
            pangleViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(520093720);
        this.f405b = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new e());
        }
        ImageView imageView2 = (ImageView) findViewById(520093716);
        this.c = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new f());
        }
        this.d = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.o0);
        ProgressBar progressBar = (ProgressBar) findViewById(com.bytedance.sdk.openadsdk.utils.h.b0);
        this.k = progressBar;
        progressBar.setVisibility(0);
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.n0);
        textView.setText(t.k(com.bytedance.sdk.openadsdk.core.o.a(), "tt_reward_feedback"));
        textView.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return !TextUtils.isEmpty(this.t) && this.t.contains("__luban_sdk");
    }

    private void p() {
        TTAdDislikeToast tTAdDislikeToast = this.G;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.a(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.G) == null) {
            return;
        }
        tTAdDislikeToast.a(TTAdDislikeToast.getDislikeSendTip());
    }

    protected void o() {
        if (isFinishing()) {
            return;
        }
        if (this.I.get()) {
            p();
            return;
        }
        if (this.F == null) {
            j();
        }
        this.F.q();
    }

    @Override // com.bytedance.sdk.openadsdk.i.d
    public void a(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null) {
            return;
        }
        jSONArray.length();
    }
}
