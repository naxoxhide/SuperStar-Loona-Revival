package com.bytedance.sdk.openadsdk.core.f0;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: LandingPageModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {
    private boolean A;
    ObjectAnimator B;
    ValueAnimator C;
    ObjectAnimator D;
    ObjectAnimator E;
    b.a.a.a.a.a.a.g.c.a F;
    com.bytedance.sdk.openadsdk.core.c0.a G;
    com.bytedance.sdk.openadsdk.core.c0.b H;
    private boolean J;
    private com.bytedance.sdk.openadsdk.core.widget.webview.d K;
    private String L;
    private ILoader M;
    private int Q;
    private int R;
    ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    FrameLayout f585b;
    TextView c;
    FrameLayout d;
    TextView e;
    RelativeLayout f;
    private View g;
    private TextView h;
    private TextView i;
    private TTRoundRectImageView j;
    private TextView k;
    private x l;
    private SSWebView m;
    private FrameLayout n;
    private LandingPageLoadingLayout o;
    private View p;
    private ImageView q;
    private View r;
    private long s;
    private final Activity u;
    final q v;
    FrameLayout w;
    private String x;
    private b.c.a.a.a.a.c y;
    private com.bytedance.sdk.openadsdk.d.j z;
    private final AtomicBoolean t = new AtomicBoolean(false);
    private final AtomicBoolean I = new AtomicBoolean(false);
    private volatile int N = 0;
    private volatile int O = 0;
    private volatile int P = 0;

    /* JADX INFO: compiled from: LandingPageModel.java */
    class a implements com.bytedance.sdk.openadsdk.core.widget.b {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.b
        public void a() {
            if (o.this.K != null) {
                o.this.K.a();
            }
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o.this.n.getLayoutParams();
            layoutParams.weight = (float) (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.25d);
            o.this.a((float) (1.0d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.2d)));
            o.this.n.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class c implements View.OnTouchListener {

        /* JADX INFO: compiled from: LandingPageModel.java */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o.this.n.getLayoutParams();
                layoutParams.weight = (float) (((double) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 2.07f)) + 0.25d);
                o.this.a((float) (0.800000011920929d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.5d)));
                o.this.n.setLayoutParams(layoutParams);
            }
        }

        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!o.this.J) {
                o.this.H.onTouch(view, motionEvent);
            }
            if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                return false;
            }
            o.this.D = ObjectAnimator.ofFloat(this, "timeSlide", 0.0f, 1.0f);
            o.this.D.setDuration(200L);
            o.this.D.addUpdateListener(new a());
            if (o.this.H.a()) {
                o.this.p.performClick();
                o.this.J = true;
            }
            o.this.D.start();
            o.this.p.setVisibility(8);
            return true;
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o oVar = o.this;
            com.bytedance.sdk.openadsdk.d.c.b(oVar.v, oVar.x);
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class e implements b.b.a.a.h.o<Bitmap> {
        e() {
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
        }

        @Override // b.b.a.a.h.o
        public void a(b.b.a.a.h.k<Bitmap> kVar) {
            try {
                Bitmap bitmapC = kVar.c();
                if (bitmapC != null && kVar.e() != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.o.a().getResources(), bitmapC);
                    if (!o.this.j()) {
                        o.this.f585b.setBackground(bitmapDrawable);
                        return;
                    }
                    o.this.d.setBackground(bitmapDrawable);
                    View viewC = o.this.u instanceof com.bytedance.sdk.openadsdk.core.j0.c.c ? ((com.bytedance.sdk.openadsdk.core.j0.c.c) o.this.u).c() : null;
                    if (viewC == null || !(viewC.getParent() instanceof View)) {
                        return;
                    }
                    ((View) viewC.getParent()).setBackground(bitmapDrawable);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class f implements b.b.a.a.h.h {
        f(o oVar) {
        }

        @Override // b.b.a.a.h.h
        public Bitmap a(Bitmap bitmap) {
            if (Build.VERSION.SDK_INT >= 17) {
                return b.b.a.a.d.g.a.a(com.bytedance.sdk.openadsdk.core.o.a(), bitmap, 25);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class g extends com.bytedance.sdk.openadsdk.core.c0.b {
        final /* synthetic */ q M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Context context, q qVar, String str, int i, boolean z, q qVar2) {
            super(context, qVar, str, i, z);
            this.M = qVar2;
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b
        public boolean a(com.bytedance.sdk.openadsdk.core.f0.i iVar, Map<String, Object> map) {
            if (o.a(this.M) && o.this.K != null) {
                o.this.K.a(iVar);
                o.this.K.a(map);
                if (o.e(o.this.v) || o.this.J) {
                    return true;
                }
            }
            return super.a(iVar, map);
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.a.a.a.a.a.a.g.c.a aVar = o.this.F;
            if (aVar != null) {
                aVar.a(((Integer) valueAnimator.getAnimatedValue()).longValue(), o.this.v.h0().c() * 1000);
            }
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            o oVar = o.this;
            b.a.a.a.a.a.a.g.c.a aVar = oVar.F;
            if (aVar != null) {
                aVar.b(oVar.v.h0().c() * 1000, 100);
            }
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o.this.t.get()) {
                return;
            }
            o oVar = o.this;
            com.bytedance.sdk.openadsdk.d.c.a(oVar.v, oVar.x, System.currentTimeMillis() - o.this.s, false);
            o.this.p();
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class k implements com.bytedance.sdk.openadsdk.d.i {
        k() {
        }

        @Override // com.bytedance.sdk.openadsdk.d.i
        public void a(int i) {
            int i2 = o.this.Q;
            int i3 = o.this.P;
            int i4 = o.this.O;
            int i5 = o.this.N - o.this.O;
            o oVar = o.this;
            com.bytedance.sdk.openadsdk.d.c.o.a(i2, i3, i4, i5, oVar.v, oVar.x, i);
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class l extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        l(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            o.this.l();
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (o.this.u instanceof com.bytedance.sdk.openadsdk.core.j0.c.c) {
                ((com.bytedance.sdk.openadsdk.core.j0.c.c) o.this.u).a();
            }
            o.this.s = System.currentTimeMillis();
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            String strA = com.bytedance.sdk.openadsdk.core.widget.webview.d.a(str2);
            if (this.c != null) {
                this.c.a(webView, i, str, str2, com.bytedance.sdk.openadsdk.core.widget.webview.d.a(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
            }
            boolean z = strA != null && strA.startsWith("image");
            boolean z2 = strA != null && strA.startsWith("mp4");
            if (z || z2 || o.this.t.get()) {
                return;
            }
            o.this.p();
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                o.this.p();
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                if (TextUtils.isEmpty(o.this.L)) {
                    return super.shouldInterceptRequest(webView, str);
                }
                o.x(o.this);
                WebResourceResponseModel webResourceResponseModelA = com.bytedance.sdk.openadsdk.f.b.c().a(o.this.M, o.this.L, str);
                if (webResourceResponseModelA != null && webResourceResponseModelA.getWebResourceResponse() != null) {
                    o.v(o.this);
                    com.bytedance.sdk.component.utils.m.a("LandingPageModel", "GeckoLog: hit++");
                    return webResourceResponseModelA.getWebResourceResponse();
                }
                if (webResourceResponseModelA != null && webResourceResponseModelA.getMsg() == 2) {
                    o.t(o.this);
                }
                return super.shouldInterceptRequest(webView, str);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("LandingPageModel", "shouldInterceptRequest url error", th);
                return super.shouldInterceptRequest(webView, str);
            }
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class m extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
        m(x xVar, com.bytedance.sdk.openadsdk.d.j jVar) {
            super(xVar, jVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (o.this.u != null && !o.this.u.isFinishing() && i == 100) {
                o.this.l();
            }
            if (o.this.o != null) {
                o.this.o.e(i);
            }
        }
    }

    /* JADX INFO: compiled from: LandingPageModel.java */
    class n implements DownloadListener {
        n() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (o.this.y != null) {
                o.this.y.b();
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.f0.o$o, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LandingPageModel.java */
    class ViewOnTouchListenerC0197o implements View.OnTouchListener {
        ViewOnTouchListenerC0197o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!o.this.J || o.a(o.this.v)) {
                o.this.H.onTouch(view, motionEvent);
            }
            if ((!o.this.J || o.a(o.this.v)) && motionEvent.getAction() == 1 && o.this.H.a()) {
                o.this.m.getWebView().performClick();
                o.this.J = true;
            }
            if (o.this.z == null) {
                return false;
            }
            o.this.z.a(motionEvent.getActionMasked());
            return false;
        }
    }

    public o(Activity activity, q qVar, String str, FrameLayout frameLayout) {
        this.u = activity;
        this.v = qVar;
        this.x = str;
        if (qVar != null) {
            this.L = qVar.X();
        }
        if (!TextUtils.isEmpty(this.L)) {
            this.M = com.bytedance.sdk.openadsdk.f.b.c().a();
            int iA = com.bytedance.sdk.openadsdk.f.b.c().a(this.M, this.L);
            this.Q = iA;
            this.R = iA > 0 ? 2 : 0;
        }
        boolean zB = b(qVar);
        if (f(qVar)) {
            this.x = "landingpage_split_screen";
        } else if (zB) {
            this.x = "landingpage_direct";
        }
        this.G = new com.bytedance.sdk.openadsdk.core.c0.a(com.bytedance.sdk.openadsdk.core.o.a(), qVar, this.x, a0.f(str));
        View viewFindViewById = activity.findViewById(R.id.content);
        this.G.b(viewFindViewById);
        g gVar = new g(com.bytedance.sdk.openadsdk.core.o.a(), qVar, this.x, a0.f(str), true, qVar);
        this.H = gVar;
        gVar.b(viewFindViewById);
        this.w = frameLayout;
        if (zB) {
            try {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) (qVar.h0().c() * 1000));
                this.C = valueAnimatorOfInt;
                valueAnimatorOfInt.setDuration((long) ((qVar.h0().c() / com.bytedance.sdk.openadsdk.core.l.f) * 1000.0f));
                this.C.setInterpolator(new LinearInterpolator());
                this.C.addUpdateListener(new h());
                this.C.addListener(new i());
                this.C.start();
            } catch (Exception e2) {
                Log.e("LandingPageModel", "LandingPageModel: ", e2);
            }
        }
    }

    static /* synthetic */ int t(o oVar) {
        int i2 = oVar.P;
        oVar.P = i2 + 1;
        return i2;
    }

    static /* synthetic */ int v(o oVar) {
        int i2 = oVar.O;
        oVar.O = i2 + 1;
        return i2;
    }

    static /* synthetic */ int x(o oVar) {
        int i2 = oVar.N;
        oVar.N = i2 + 1;
        return i2;
    }

    private void b() {
        if (b(this.v)) {
            ComponentCallbacks2 componentCallbacks2 = this.u;
            if (componentCallbacks2 instanceof com.bytedance.sdk.openadsdk.core.j0.c.c) {
                ((com.bytedance.sdk.openadsdk.core.j0.c.c) componentCallbacks2).a();
                ((com.bytedance.sdk.openadsdk.core.j0.c.c) this.u).f();
            }
        }
    }

    public static boolean d(q qVar) {
        return b(qVar) && !c(qVar);
    }

    private void e() {
        LandingPageLoadingLayout landingPageLoadingLayout;
        SSWebView sSWebView = this.m;
        if (sSWebView != null && sSWebView.getWebView() != null) {
            com.bytedance.sdk.openadsdk.core.widget.webview.b.a(com.bytedance.sdk.openadsdk.core.o.a()).a(false).b(false).a(this.m.getWebView());
            SSWebView sSWebView2 = this.m;
            if (sSWebView2 != null && sSWebView2.getWebView() != null) {
                com.bytedance.sdk.openadsdk.d.j jVarA = new com.bytedance.sdk.openadsdk.d.j(this.v, this.m.getWebView(), new k(), this.R).a(true);
                this.z = jVarA;
                jVarA.b(this.x);
            }
            g();
            this.m.setLandingPage(true);
            this.m.setTag(this.x);
            this.m.setMaterialMeta(this.v.L());
            l lVar = new l(com.bytedance.sdk.openadsdk.core.o.a(), this.l, this.v.e(), this.z, true);
            this.K = lVar;
            this.m.setWebViewClient(lVar);
            this.K.a(this.v);
            this.K.e(this.x);
            this.m.setWebChromeClient(new m(this.l, this.z));
            if (this.y == null) {
                this.y = b.c.a.a.a.a.d.a(com.bytedance.sdk.openadsdk.core.o.a(), this.v, this.x);
            }
            this.m.setDownloadListener(new n());
            SSWebView sSWebView3 = this.m;
            sSWebView3.setUserAgentString(com.bytedance.sdk.openadsdk.utils.k.a(sSWebView3.getWebView(), BuildConfig.VERSION_CODE));
            if (Build.VERSION.SDK_INT >= 21) {
                this.m.setMixedContentMode(0);
            }
            this.m.getWebView().setOnTouchListener(new ViewOnTouchListenerC0197o());
            this.m.getWebView().setOnClickListener(this.H);
            com.bytedance.sdk.openadsdk.d.c.a(this.v, this.x, this.R);
            com.bytedance.sdk.openadsdk.utils.n.a(this.m, this.v.H0());
            this.A = true;
        }
        if (this.m == null || (landingPageLoadingLayout = this.o) == null) {
            return;
        }
        landingPageLoadingLayout.o();
    }

    private void f() {
        if (i()) {
            this.p.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.q, "translationY", 16.0f, 0.0f).setDuration(500L);
            this.B = duration;
            duration.setRepeatMode(2);
            this.B.setRepeatCount(-1);
            this.B.start();
            this.p.setClickable(true);
            this.p.setOnTouchListener(new c());
            this.p.setOnClickListener(this.H);
        }
        if (!j()) {
            this.w.setVisibility(8);
            this.f585b.setVisibility(0);
            this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.a.setOnClickListener(new d());
            q qVar = this.v;
            if (qVar != null && qVar.d0() != null && this.v.d0().size() > 0 && this.v.d0().get(0) != null && !TextUtils.isEmpty(this.v.d0().get(0).d())) {
                com.bytedance.sdk.openadsdk.n.c.b().a(this.v.d0().get(0), this.a, this.v);
            }
        }
        try {
            String strD = this.v.d0().get(0).d();
            com.bytedance.sdk.openadsdk.h.d.a().a(strD).b(this.v.d0().get(0).e()).a(this.v.d0().get(0).b()).d(b0.g(com.bytedance.sdk.openadsdk.core.o.a())).c(b0.i(com.bytedance.sdk.openadsdk.core.o.a())).a(b.b.a.a.h.u.BITMAP).a(new f(this)).a(new com.bytedance.sdk.openadsdk.h.b(this.v, strD, new e()));
        } catch (Exception unused) {
        }
    }

    private void g() {
        x xVar = new x(this.u);
        this.l = xVar;
        xVar.a(this.m).g(this.v.e()).j(this.v.N()).a(this.v).b(-1).c(this.v.L0()).i(this.x).h(this.v.D()).b(this.m).a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        return q.c(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.t.get() || this.I.get()) {
            return;
        }
        this.t.set(true);
        com.bytedance.sdk.openadsdk.d.c.a(this.v, this.x, System.currentTimeMillis() - this.s, true);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.t.get()) {
            return;
        }
        b();
        this.I.set(true);
        ComponentCallbacks2 componentCallbacks2 = this.u;
        if (componentCallbacks2 instanceof com.bytedance.sdk.openadsdk.core.j0.c.c) {
            ((com.bytedance.sdk.openadsdk.core.j0.c.c) componentCallbacks2).g();
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.o;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.n();
        }
        this.g.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.addRule(13);
        layoutParams.addRule(10, 0);
        this.g.setLayoutParams(layoutParams);
        if (this.v.b0() != null && !TextUtils.isEmpty(this.v.b0().d())) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.v.b0().d(), this.v.b0().e(), this.v.b0().b(), this.j, this.v);
        }
        this.h.setText(this.v.F0());
        this.i.setText(this.v.B());
        if (this.k != null) {
            c();
            this.k.setClickable(true);
            this.k.setOnClickListener(this.G);
            this.k.setOnTouchListener(this.G);
        }
    }

    protected void c() {
        q qVar = this.v;
        if (qVar == null || TextUtils.isEmpty(qVar.r())) {
            return;
        }
        this.k.setText(this.v.r());
    }

    public void h() {
        View view;
        Long lValueOf = Long.valueOf(SystemClock.elapsedRealtime());
        SSWebView sSWebView = (SSWebView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.t);
        this.m = sSWebView;
        if (sSWebView == null || q.b(this.v)) {
            b0.a((View) this.m, 8);
        } else {
            this.m.l();
        }
        this.n = (FrameLayout) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.s);
        this.o = (LandingPageLoadingLayout) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.x);
        this.p = this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.u);
        this.q = (ImageView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.v);
        this.r = this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.E);
        this.f585b = (FrameLayout) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.q);
        this.a = (ImageView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.r);
        this.f = (RelativeLayout) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.w);
        this.c = (TextView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.s1);
        this.d = (FrameLayout) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.j);
        View viewFindViewById = this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.y);
        this.g = viewFindViewById;
        if (viewFindViewById == null) {
            this.g = this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.G);
        }
        this.h = (TextView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.A);
        this.i = (TextView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.B);
        this.j = (TTRoundRectImageView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.z);
        this.k = (TextView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.C);
        if (this.c != null && this.v.h0() != null) {
            this.c.setText(this.v.h0().a());
        }
        this.e = (TextView) this.u.findViewById(com.bytedance.sdk.openadsdk.utils.h.D);
        if ((b(this.v) || f(this.v)) && this.v.h0() != null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.l.c().postDelayed(new j(), this.v.h0().b() * 1000);
        }
        e();
        if (f(this.v)) {
            f();
            if (!i()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams.weight = 2.33f;
                this.n.setLayoutParams(layoutParams);
            }
        }
        if (b(this.v) && (view = this.r) != null) {
            view.setVisibility(8);
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.o;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.v, this.x);
        }
        com.bytedance.sdk.openadsdk.d.c.o.a(SystemClock.elapsedRealtime() - lValueOf.longValue(), this.v, this.x, this.M, this.L);
    }

    public boolean i() {
        return this.v.c0() == 15 || this.v.c0() == 16;
    }

    public void k() {
        SSWebView sSWebView;
        com.bytedance.sdk.openadsdk.d.j jVar = this.z;
        if (jVar != null && (sSWebView = this.m) != null) {
            jVar.a(sSWebView);
        }
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.C.removeAllListeners();
            this.C.cancel();
        }
        ObjectAnimator objectAnimator = this.D;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.D.cancel();
        }
        ObjectAnimator objectAnimator2 = this.E;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.E.cancel();
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.o;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.n();
        }
        ObjectAnimator objectAnimator3 = this.B;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        SSWebView sSWebView2 = this.m;
        if (sSWebView2 != null) {
            com.bytedance.sdk.openadsdk.core.a0.a(sSWebView2.getWebView());
        }
        this.m = null;
        x xVar = this.l;
        if (xVar != null) {
            xVar.o();
        }
        com.bytedance.sdk.openadsdk.d.j jVar2 = this.z;
        if (jVar2 != null) {
            jVar2.d();
        }
        if (!TextUtils.isEmpty(this.L) && this.A) {
            com.bytedance.sdk.openadsdk.d.c.o.a(this.O, this.N, this.v);
        }
        com.bytedance.sdk.openadsdk.f.b.c().a(this.M);
    }

    public void m() {
        x xVar = this.l;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void n() {
        x xVar = this.l;
        if (xVar != null) {
            xVar.q();
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.z;
        if (jVar != null) {
            jVar.e();
        }
    }

    public void o() {
        com.bytedance.sdk.openadsdk.d.j jVar = this.z;
        if (jVar != null) {
            jVar.f();
        }
    }

    public void d() {
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            View view = this.r;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public static boolean c(q qVar) {
        return qVar != null && qVar.v() == 19;
    }

    public void a(b.a.a.a.a.a.a.g.c.a aVar) {
        this.F = aVar;
    }

    private void a() {
        this.f.setVisibility(8);
        if (b(this.v) || !i()) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "timeVisible", 0.0f, 1.0f);
        this.E = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(100L);
        this.E.addUpdateListener(new b());
        this.E.start();
    }

    public static boolean b(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (c(qVar)) {
            return true;
        }
        if (qVar.e0() == 3 && qVar.v() == 5 && !t.i(qVar)) {
            return qVar.o() == 0.0f || qVar.o() == 100.0f;
        }
        return false;
    }

    public static boolean g(q qVar) {
        return (qVar == null || !com.bytedance.sdk.openadsdk.core.o.d().Y() || !qVar.S0() || f(qVar) || b(qVar)) ? false : true;
    }

    public void a(float f2) {
        try {
            ((com.bytedance.sdk.openadsdk.core.j0.c.c) this.u).e();
        } catch (Throwable unused) {
        }
    }

    public static boolean a(q qVar) {
        return qVar != null && (qVar.v() == 19 || qVar.v() == 20);
    }

    public static boolean f(q qVar) {
        if (qVar != null && qVar.e0() == 3 && qVar.v() == 6 && !t.i(qVar) && qVar.j0() == 1) {
            return qVar.o() == 0.0f || qVar.o() == 100.0f;
        }
        return false;
    }

    public static boolean h(q qVar) {
        if (qVar == null || c(qVar)) {
            return false;
        }
        return b(qVar) || f(qVar);
    }

    public static boolean e(q qVar) {
        return (qVar == null || qVar.f0() == 1 || !a(qVar)) ? false : true;
    }
}
