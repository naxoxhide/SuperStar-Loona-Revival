package com.bytedance.sdk.component.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.facebook.share.internal.ShareInternalUtility;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SSWebView extends FrameLayout {
    private static t0 A;
    private com.bytedance.sdk.component.widget.b.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f332b;
    private JSONObject c;
    private boolean d;
    private float e;
    private float f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private volatile WebView k;
    private float l;
    private float m;
    private float n;
    private int o;
    private com.bytedance.sdk.component.utils.u p;
    private AttributeSet q;
    private Context r;
    private AtomicBoolean s;
    private AtomicBoolean t;
    private AtomicBoolean u;
    private AtomicBoolean v;
    private volatile Queue<Runnable> w;
    private u0 x;
    private long y;
    private long z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.goBack();
        }
    }

    class a0 implements Runnable {
        final /* synthetic */ String a;

        a0(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setUserAgentString(this.a);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.goForward();
        }
    }

    class b0 implements Runnable {
        final /* synthetic */ String a;

        b0(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setDefaultTextEncodingName(this.a);
        }
    }

    class c implements Runnable {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.clearCache(this.a);
        }
    }

    class c0 implements Runnable {
        final /* synthetic */ int a;

        c0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setDefaultFontSize(this.a);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.clearHistory();
        }
    }

    class d0 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f337b;

        d0(String str, Map map) {
            this.a = str;
            this.f337b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.setJavaScriptEnabled(this.a);
            SSWebView.this.k.loadUrl(this.a, this.f337b);
        }
    }

    class e implements Runnable {
        final /* synthetic */ WebViewClient a;

        e(WebViewClient webViewClient) {
            this.a = webViewClient;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.setWebViewClient(this.a);
        }
    }

    class e0 implements Runnable {
        final /* synthetic */ int a;

        e0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setMixedContentMode(this.a);
        }
    }

    class f implements Runnable {
        final /* synthetic */ DownloadListener a;

        f(DownloadListener downloadListener) {
            this.a = downloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.setDownloadListener(this.a);
        }
    }

    class f0 implements Runnable {
        final /* synthetic */ boolean a;

        f0(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setDatabaseEnabled(this.a);
        }
    }

    class g implements Runnable {
        final /* synthetic */ WebChromeClient a;

        g(WebChromeClient webChromeClient) {
            this.a = webChromeClient;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.setWebChromeClient(this.a);
        }
    }

    class g0 implements Runnable {
        final /* synthetic */ int a;

        g0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SSWebView.this.k != null) {
                SSWebView.this.k.setVisibility(this.a);
            }
        }
    }

    class h implements Runnable {
        final /* synthetic */ int a;

        h(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.setBackgroundColor(this.a);
        }
    }

    class h0 implements Runnable {
        final /* synthetic */ float a;

        h0(float f) {
            this.a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.setAlpha(this.a);
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SSWebView.this.k == null) {
                SSWebView.this.l();
                SSWebView.this.m();
            }
        }
    }

    class i0 implements Runnable {
        final /* synthetic */ boolean a;

        i0(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setAllowFileAccess(this.a);
        }
    }

    class j implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Paint f347b;

        j(int i, Paint paint) {
            this.a = i;
            this.f347b = paint;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SSWebView.this.k.setLayerType(this.a, this.f347b);
            } catch (Throwable unused) {
            }
        }
    }

    class j0 implements Runnable {
        j0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.clearView();
        }
    }

    class k implements Runnable {
        final /* synthetic */ int a;

        k(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.setOverScrollMode(this.a);
        }
    }

    class k0 implements Runnable {
        k0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.pauseTimers();
        }
    }

    class l implements Runnable {
        final /* synthetic */ Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f349b;

        l(Object obj, String str) {
            this.a = obj;
            this.f349b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.addJavascriptInterface(this.a, this.f349b);
        }
    }

    class l0 implements Runnable {
        l0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.removeAllViews();
        }
    }

    class m implements Runnable {
        final /* synthetic */ boolean a;

        m(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setJavaScriptEnabled(this.a);
        }
    }

    class m0 implements com.bytedance.sdk.component.utils.u.a {
        m0(SSWebView sSWebView) {
        }
    }

    class n implements Runnable {
        final /* synthetic */ boolean a;

        n(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setDisplayZoomControls(this.a);
        }
    }

    class n0 implements Runnable {
        final /* synthetic */ String a;

        n0(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.setJavaScriptEnabled(this.a);
            SSWebView.this.k.loadUrl(this.a);
        }
    }

    class o implements Runnable {
        final /* synthetic */ int a;

        o(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setCacheMode(this.a);
        }
    }

    class o0 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f354b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        o0(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.f354b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.setJavaScriptEnabled(this.a);
            SSWebView.this.k.loadDataWithBaseURL(this.a, this.f354b, this.c, this.d, this.e);
        }
    }

    class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebSettings settings = SSWebView.this.k.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        }
    }

    class p0 implements Runnable {
        p0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.stopLoading();
        }
    }

    class q implements Runnable {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.removeJavascriptInterface(this.a);
        }
    }

    class q0 implements Runnable {
        q0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.reload();
        }
    }

    class r implements Runnable {
        final /* synthetic */ boolean a;

        r(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setAppCacheEnabled(this.a);
        }
    }

    public static class r0 extends WebViewClient {

        class a implements Runnable {
            final /* synthetic */ WebView a;

            a(r0 r0Var, WebView webView) {
                this.a = webView;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ViewGroup viewGroup = (ViewGroup) this.a.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.a);
                    }
                    this.a.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            webView.post(new a(this, webView));
            return true;
        }
    }

    class s implements Runnable {
        final /* synthetic */ boolean a;

        s(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.setNetworkAvailable(this.a);
        }
    }

    public interface s0 {
    }

    class t implements Runnable {
        final /* synthetic */ boolean a;

        t(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setSupportZoom(this.a);
        }
    }

    public interface t0 {
        WebView createWebView(Context context, AttributeSet attributeSet, int i);
    }

    class u implements Runnable {
        final /* synthetic */ boolean a;

        u(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setUseWideViewPort(this.a);
        }
    }

    public interface u0 {
        void a(boolean z);
    }

    class v implements Runnable {
        final /* synthetic */ boolean a;

        v(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setJavaScriptCanOpenWindowsAutomatically(this.a);
        }
    }

    class w implements Runnable {
        final /* synthetic */ boolean a;

        w(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setDomStorageEnabled(this.a);
        }
    }

    class x implements Runnable {
        final /* synthetic */ boolean a;

        x(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setBuiltInZoomControls(this.a);
        }
    }

    class y implements Runnable {
        final /* synthetic */ WebSettings.LayoutAlgorithm a;

        y(WebSettings.LayoutAlgorithm layoutAlgorithm) {
            this.a = layoutAlgorithm;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setLayoutAlgorithm(this.a);
        }
    }

    class z implements Runnable {
        final /* synthetic */ boolean a;

        z(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSWebView.this.k.getSettings().setLoadWithOverviewMode(this.a);
        }
    }

    public SSWebView(Context context) {
        this(b(context), false);
    }

    private void c(Context context) {
        a(context);
        t();
        s();
    }

    private void j() {
        com.bytedance.sdk.component.utils.i.b().post(new i());
    }

    private void k() {
        if (this.p == null) {
            this.u.set(false);
            this.p = new com.bytedance.sdk.component.utils.u(getContext());
        }
        this.p.b(this.l);
        this.p.a(this.m);
        this.p.c(this.n);
        this.p.a(this.o);
        this.p.a(new m0(this));
        this.u.set(true);
        this.p.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.w == null) {
            return;
        }
        while (!this.w.isEmpty()) {
            Runnable runnablePoll = this.w.poll();
            if (runnablePoll != null && this.k != null) {
                try {
                    runnablePoll.run();
                } catch (Exception e2) {
                    com.bytedance.sdk.component.utils.m.b("SSWebView", e2.getMessage());
                }
            }
        }
    }

    private static boolean n() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void s() {
        if (this.k == null) {
            return;
        }
        try {
            this.k.removeJavascriptInterface("searchBoxJavaBridge_");
            this.k.removeJavascriptInterface("accessibility");
            this.k.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    public static void setWebViewProvider(t0 t0Var) {
        A = t0Var;
    }

    private void t() {
        a(new p());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.k == null || !n()) {
            return;
        }
        try {
            this.k.computeScroll();
        } catch (Throwable unused) {
        }
    }

    public boolean d() {
        if (this.k != null && n()) {
            try {
                return this.k.canGoForward();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        u0 u0Var = this.x;
        if (u0Var != null) {
            u0Var.a(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        a(new d());
    }

    public void f() {
        a(new j0());
    }

    public void g() {
        if (this.k == null || !n()) {
            return;
        }
        try {
            this.k.destroy();
        } catch (Throwable unused) {
        }
    }

    public int getContentHeight() {
        if (this.k == null || !n()) {
            return 0;
        }
        try {
            return this.k.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public long getLandingPageClickBegin() {
        return this.y;
    }

    public long getLandingPageClickEnd() {
        return this.z;
    }

    public com.bytedance.sdk.component.widget.b.a getMaterialMeta() {
        return this.a;
    }

    public String getOriginalUrl() {
        String url;
        if (this.k != null && n()) {
            try {
                String originalUrl = this.k.getOriginalUrl();
                return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = this.k.getUrl()) == null || !url.startsWith("file://")) ? originalUrl : url;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public int getProgress() {
        if (this.k == null || !n()) {
            return 0;
        }
        try {
            return this.k.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public String getUrl() {
        if (this.k != null && n()) {
            try {
                return this.k.getUrl();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String getUserAgentString() {
        if (this.k == null || !n()) {
            return null;
        }
        try {
            return this.k.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.k;
    }

    public void h() {
        a(new a());
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void i() {
        a(new b());
    }

    public void l() {
        if (this.v.compareAndSet(false, true)) {
            try {
                this.k = a(this.q, 0);
                b();
                c(b(this.r));
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("SSWebView.TAG", "initWebview: " + th.getMessage());
            }
        }
    }

    public void o() {
        if (this.k == null || !n()) {
            return;
        }
        try {
            this.k.onPause();
            u0 u0Var = this.x;
            if (u0Var != null) {
                u0Var.a(false);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s.set(true);
        if (!this.t.get() || this.u.get()) {
            return;
        }
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.set(false);
        com.bytedance.sdk.component.utils.u uVar = this.p;
        if (uVar != null) {
            uVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentA;
        try {
            a(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.j && (viewParentA = a((View) this)) != null) {
                viewParentA.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        com.bytedance.sdk.component.utils.u uVar = this.p;
        if (uVar != null) {
            if (z2) {
                uVar.b();
            } else {
                uVar.a();
            }
        }
    }

    public void p() {
        if (this.k == null || !n()) {
            return;
        }
        this.k.onResume();
    }

    public void q() {
        a(new k0());
    }

    public void r() {
        a(new q0());
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        a(new l0());
    }

    public void setAllowFileAccess(boolean z2) {
        a(new i0(z2));
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        try {
            super.setAlpha(f2);
            a(new h0(f2));
        } catch (Throwable unused) {
        }
    }

    public void setAppCacheEnabled(boolean z2) {
        a(new r(z2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        a(new h(i2));
    }

    public void setBuiltInZoomControls(boolean z2) {
        a(new x(z2));
    }

    public void setCacheMode(int i2) {
        a(new o(i2));
    }

    public void setCalculationMethod(int i2) {
        this.o = i2;
    }

    public void setDatabaseEnabled(boolean z2) {
        a(new f0(z2));
    }

    public void setDeepShakeValue(float f2) {
        this.m = f2;
    }

    public void setDefaultFontSize(int i2) {
        a(new c0(i2));
    }

    public void setDefaultTextEncodingName(String str) {
        a(new b0(str));
    }

    public void setDisplayZoomControls(boolean z2) {
        a(new n(z2));
    }

    public void setDomStorageEnabled(boolean z2) {
        a(new w(z2));
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        a(new f(downloadListener));
    }

    public void setIsPreventTouchEvent(boolean z2) {
        this.j = z2;
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z2) {
        a(new v(z2));
    }

    public void setJavaScriptEnabled(boolean z2) {
        a(new m(z2));
    }

    public void setLandingPage(boolean z2) {
        this.d = z2;
    }

    public void setLandingPageClickBegin(long j2) {
        this.y = j2;
    }

    public void setLandingPageClickEnd(long j2) {
        this.z = j2;
    }

    @Override // android.view.View
    public void setLayerType(int i2, Paint paint) {
        a(new j(i2, paint));
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        a(new y(layoutAlgorithm));
    }

    public void setLoadWithOverviewMode(boolean z2) {
        a(new z(z2));
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.b.a aVar) {
        this.a = aVar;
    }

    public void setMixedContentMode(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(new e0(i2));
        }
    }

    public void setNetworkAvailable(boolean z2) {
        a(new s(z2));
    }

    public void setOnShakeListener(s0 s0Var) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        try {
            a(new k(i2));
            super.setOverScrollMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setShakeValue(float f2) {
        this.l = f2;
    }

    public void setSupportZoom(boolean z2) {
        a(new t(z2));
    }

    public void setTag(String str) {
        this.f332b = str;
    }

    public void setTouchStateListener(u0 u0Var) {
        this.x = u0Var;
    }

    public void setUseWideViewPort(boolean z2) {
        a(new u(z2));
    }

    public void setUserAgentString(String str) {
        a(new a0(str));
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        try {
            super.setVisibility(i2);
            a(new g0(i2));
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        a(new g(webChromeClient));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof u0) {
                setTouchStateListener((u0) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == 0) {
                webViewClient = new r0();
            }
            a(new e(webViewClient));
        } catch (Throwable unused) {
        }
    }

    public void setWriggleValue(float f2) {
        this.n = f2;
    }

    public void u() {
        a(new p0());
    }

    public SSWebView(Context context, boolean z2) {
        super(b(context));
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = false;
        this.l = 20.0f;
        this.n = 50.0f;
        this.s = new AtomicBoolean();
        this.t = new AtomicBoolean();
        this.u = new AtomicBoolean();
        this.v = new AtomicBoolean(false);
        this.r = context;
        if (z2) {
            return;
        }
        if (!n()) {
            j();
            return;
        }
        try {
            this.k = a((AttributeSet) null, 0);
            b();
        } catch (Throwable unused) {
        }
        c(b(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = this.k.getSettings()) == null) {
                return;
            }
            if (Uri.parse(str).getScheme().equals(ShareInternalUtility.STAGING_PARAM)) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        if (this.k != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.k.setId(520093704);
            } catch (Throwable unused) {
            }
            addView(this.k, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.view.View
    public String getTag() {
        return this.f332b;
    }

    private WebView a(AttributeSet attributeSet, int i2) {
        t0 t0Var = A;
        if (t0Var != null) {
            return t0Var.createWebView(getContext(), attributeSet, i2);
        }
        if (attributeSet == null) {
            return new WebView(b(this.r));
        }
        return new WebView(b(this.r), attributeSet);
    }

    public void c(String str) {
        a(new n0(str));
    }

    public boolean c() {
        if (this.k != null && n()) {
            try {
                return this.k.canGoBack();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void d(String str) {
        a(new q(str));
    }

    public void a(String str, Map<String, String> map) {
        a(new d0(str, map));
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        a(new o0(str, str2, str3, str4, str5));
    }

    private static boolean c(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ViewPager");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public void a(boolean z2) {
        a(new c(z2));
    }

    private static Context b(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent a(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (c(view2) || b(view2)) ? parent : a(view2);
    }

    private static boolean b(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ScrollingView");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private static void a(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Object obj, String str) {
        a(new l(obj, str));
    }

    private void a(MotionEvent motionEvent) {
        if (!this.d || this.a == null) {
            return;
        }
        if ((this.f332b == null && this.c == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.e = motionEvent.getRawX();
                this.f = motionEvent.getRawY();
                this.g = System.currentTimeMillis();
                this.c = new JSONObject();
                if (this.k != null) {
                    this.y = this.g;
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.c.put("start_x", String.valueOf(this.e));
                this.c.put("start_y", String.valueOf(this.f));
                this.c.put("offset_x", String.valueOf(motionEvent.getRawX() - this.e));
                this.c.put("offset_y", String.valueOf(motionEvent.getRawY() - this.f));
                this.c.put("url", String.valueOf(getUrl()));
                this.c.put("tag", "");
                this.h = System.currentTimeMillis();
                if (this.k != null) {
                    this.z = this.h;
                }
                this.c.put("down_time", this.g);
                this.c.put("up_time", this.h);
                if (com.bytedance.sdk.component.widget.a.a.a().b() != null) {
                    long j2 = this.i;
                    long j3 = this.g;
                    if (j2 != j3) {
                        this.i = j3;
                        com.bytedance.sdk.component.widget.a.a.a().b().a(this.a, this.f332b, "in_web_click", this.c, this.h - this.g);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Runnable runnable) {
        if (this.k != null && n()) {
            m();
            if (runnable == null || this.k == null) {
                return;
            }
            try {
                runnable.run();
                return;
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.m.b("SSWebView", e2.getMessage());
                return;
            }
        }
        if (this.w == null) {
            synchronized (this) {
                if (this.w == null) {
                    this.w = new ConcurrentLinkedQueue();
                }
            }
        }
        this.w.offer(runnable);
    }
}
