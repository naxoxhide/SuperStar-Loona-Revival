package com.bytedance.sdk.openadsdk.b.m.p;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullWebViewManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements com.bytedance.sdk.openadsdk.k.g {
    private long A;
    private com.bytedance.sdk.openadsdk.common.f F;
    private boolean G;
    private final com.bytedance.sdk.openadsdk.b.m.p.a H;
    private com.bytedance.sdk.openadsdk.core.widget.webview.d J;
    private com.bytedance.sdk.openadsdk.core.widget.webview.d K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private long Q;
    private String R;
    private final com.bytedance.sdk.openadsdk.core.f0.q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f508b;
    private int c;
    private final boolean d;
    private int e;
    private int f;
    private SSWebView g;
    private SSWebView h;
    x i;
    x j;
    protected String l;
    com.bytedance.sdk.openadsdk.d.j m;
    private boolean p;
    private boolean q;
    protected com.bytedance.sdk.openadsdk.d.o t;
    private boolean v;
    private View w;
    private View x;
    private float y;
    private float z;
    protected boolean k = true;
    private boolean n = false;
    private final AtomicBoolean o = new AtomicBoolean(true);
    int r = 0;
    String s = "";
    boolean u = false;
    private SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> B = new SparseArray<>();
    private boolean C = true;
    private float D = -1.0f;
    private float E = -1.0f;
    private boolean I = false;
    private long P = -1;
    private int S = -1;

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class b extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
        b(x xVar, com.bytedance.sdk.openadsdk.d.j jVar) {
            super(xVar, jVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (!m.this.H.s || m.this.H.P == null) {
                return;
            }
            m.this.H.P.a(webView, i);
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class d implements View.OnTouchListener {
        private final int a = com.bytedance.sdk.openadsdk.core.o.e();

        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i;
            com.bytedance.sdk.openadsdk.d.j jVar = m.this.m;
            if (jVar != null) {
                jVar.a(motionEvent.getActionMasked());
            }
            int i2 = -1;
            try {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    m.this.C = true;
                    m.this.B = new SparseArray();
                    m.this.y = motionEvent.getRawX();
                    m.this.z = motionEvent.getRawY();
                    m.this.A = System.currentTimeMillis();
                    try {
                        long landingPageClickBegin = m.this.g.getLandingPageClickBegin();
                        if (landingPageClickBegin > 0 && landingPageClickBegin < m.this.A) {
                            m.this.A = landingPageClickBegin;
                            m.this.g.setLandingPageClickBegin(-1L);
                        }
                    } catch (Exception unused) {
                    }
                    m.this.D = -1.0f;
                    m.this.E = -1.0f;
                    i = 0;
                } else if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        if (Math.abs(rawX - m.this.y) >= this.a || Math.abs(rawY - m.this.z) >= this.a) {
                            m.this.C = false;
                        }
                        m.this.D += Math.abs(motionEvent.getX() - m.this.y);
                        m.this.E += Math.abs(motionEvent.getY() - m.this.z);
                        i2 = (System.currentTimeMillis() - m.this.A <= 200 || (m.this.D <= 8.0f && m.this.E <= 8.0f)) ? 2 : 1;
                        if (m.this.G) {
                            if (rawY - m.this.z > 8.0f) {
                                m.this.F.f();
                            }
                            if (rawY - m.this.z < -8.0f) {
                                m.this.F.d();
                            }
                        }
                    } else if (actionMasked == 3) {
                        i2 = 4;
                    }
                    i = i2;
                } else {
                    i = 3;
                }
                m.this.B.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.c0.c.a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
                if (motionEvent.getAction() == 1 && view.getVisibility() == 0 && Float.valueOf(view.getAlpha()).intValue() == 1 && ((!m.this.n || com.bytedance.sdk.openadsdk.core.f0.o.a(m.this.a)) && m.this.C)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("down_x", m.this.y);
                    jSONObject.put("down_y", m.this.z);
                    jSONObject.put("down_time", m.this.A);
                    jSONObject.put("up_x", motionEvent.getRawX());
                    jSONObject.put("up_y", motionEvent.getRawY());
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        long landingPageClickEnd = m.this.g.getLandingPageClickEnd();
                        if (landingPageClickEnd > 0 && landingPageClickEnd < jCurrentTimeMillis) {
                            try {
                                m.this.g.setLandingPageClickEnd(-1L);
                            } catch (Exception unused2) {
                            }
                            jCurrentTimeMillis = landingPageClickEnd;
                        }
                    } catch (Exception unused3) {
                    }
                    jSONObject.put("up_time", jCurrentTimeMillis);
                    int[] iArr = new int[2];
                    if (m.this.G) {
                        m mVar = m.this;
                        mVar.x = mVar.H.V.findViewById(com.bytedance.sdk.openadsdk.utils.h.f0);
                    } else {
                        m mVar2 = m.this;
                        mVar2.x = mVar2.H.V.findViewById(520093713);
                    }
                    if (m.this.x != null) {
                        m.this.x.getLocationOnScreen(iArr);
                        jSONObject.put("button_x", iArr[0]);
                        jSONObject.put("button_y", iArr[1]);
                        jSONObject.put("button_width", m.this.x.getWidth());
                        jSONObject.put("button_height", m.this.x.getHeight());
                    }
                    if (m.this.w != null) {
                        int[] iArr2 = new int[2];
                        m.this.w.getLocationOnScreen(iArr2);
                        jSONObject.put("ad_x", iArr2[0]);
                        jSONObject.put("ad_y", iArr2[1]);
                        jSONObject.put("width", m.this.w.getWidth());
                        jSONObject.put("height", m.this.w.getHeight());
                    }
                    jSONObject.put("toolType", motionEvent.getToolType(0));
                    jSONObject.put("deviceId", motionEvent.getDeviceId());
                    jSONObject.put("source", motionEvent.getSource());
                    jSONObject.put("ft", com.bytedance.sdk.openadsdk.core.f0.i.a(m.this.B, com.bytedance.sdk.openadsdk.core.h.a().s() ? 1 : 2));
                    jSONObject.put("user_behavior_type", m.this.C ? 1 : 2);
                    jSONObject.put("click_scence", 2);
                    if (m.this.J != null) {
                        m.this.J.a(jSONObject);
                    }
                    if (!m.this.n && !com.bytedance.sdk.openadsdk.core.f0.o.e(m.this.a)) {
                        if (m.this.d) {
                            com.bytedance.sdk.openadsdk.d.c.a(m.this.a, "rewarded_video", "click", jSONObject);
                        } else {
                            com.bytedance.sdk.openadsdk.d.c.a(m.this.a, "fullscreen_interstitial_ad", "click", jSONObject);
                        }
                        m.this.n = true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                Log.e("TTAD.RFWVM", "TouchRecordTool onTouch error", th);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class e extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
        final /* synthetic */ r c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(m mVar, x xVar, com.bytedance.sdk.openadsdk.d.j jVar, r rVar) {
            super(xVar, jVar);
            this.c = rVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            r rVar = this.c;
            if (rVar != null) {
                rVar.a(webView, i);
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class f implements ViewTreeObserver.OnGlobalLayoutListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (m.this.g == null || m.this.g.getViewTreeObserver() == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                m.this.g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                m.this.g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            int measuredWidth = m.this.g.getMeasuredWidth();
            int measuredHeight = m.this.g.getMeasuredHeight();
            if (m.this.g.getVisibility() == 0) {
                m.this.a(measuredWidth, measuredHeight);
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class h implements DownloadListener {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.j0.c.b a;

        h(com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
            this.a = bVar;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            m.this.H.H.d();
            com.bytedance.sdk.openadsdk.core.j0.c.b bVar = this.a;
            if (bVar != null) {
                bVar.d();
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class i implements DownloadListener {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.j0.c.b a;

        i(com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
            this.a = bVar;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            m.this.H.H.d();
            com.bytedance.sdk.openadsdk.core.j0.c.b bVar = this.a;
            if (bVar != null) {
                bVar.d();
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class j implements com.bytedance.sdk.openadsdk.core.widget.b {
        j() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.b
        public void a() {
            if (m.this.J != null) {
                m.this.J.a();
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class k implements x.j {
        k() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.x.j
        public void a() {
            m.this.L = true;
            m.this.H.X.removeMessages(600);
            m.this.H.R.b(false);
            m.this.H.D.set(true);
            m.this.H.Y.A();
            com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "onOverlayRendFinish: hasClicked=" + m.this.a.Q0());
            if (m.this.a.Q0() || !a0.e(t.n(m.this.a))) {
                return;
            }
            View viewB = m.this.H.T.b();
            View.OnClickListener onClickListener = (View.OnClickListener) viewB.getTag(viewB.getId());
            if (onClickListener != null) {
                o oVar = new o(m.this.H, viewB, onClickListener);
                viewB.setOnClickListener(oVar);
                viewB.setOnTouchListener(oVar);
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class l implements com.bytedance.sdk.openadsdk.core.widget.b {
        l() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.b
        public void a() {
            if (m.this.J != null) {
                m.this.J.a();
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class n implements com.bytedance.sdk.openadsdk.k.b {
        n() {
        }

        @Override // com.bytedance.sdk.openadsdk.k.b
        public void a() {
            m.this.O = true;
            m.this.H.T.b().performClick();
        }

        @Override // com.bytedance.sdk.openadsdk.k.b
        public void a(boolean z, int i, String str) {
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    private static class p implements com.bytedance.sdk.openadsdk.k.a {
        private final View a;

        public p(View view) {
            this.a = view;
        }

        @Override // com.bytedance.sdk.openadsdk.k.a
        public int a() {
            View view = this.a;
            int measuredWidth = view != null ? view.getMeasuredWidth() : -1;
            com.bytedance.sdk.component.utils.m.d("TTAndroidObject", "mWebView width is " + measuredWidth);
            return measuredWidth <= 0 ? b0.i(com.bytedance.sdk.openadsdk.core.o.a()) : measuredWidth;
        }

        @Override // com.bytedance.sdk.openadsdk.k.a
        public int b() {
            View view = this.a;
            int measuredHeight = view != null ? view.getMeasuredHeight() : -1;
            com.bytedance.sdk.component.utils.m.d("TTAndroidObject", "mWebView height is " + measuredHeight);
            return measuredHeight <= 0 ? b0.g(com.bytedance.sdk.openadsdk.core.o.a()) : measuredHeight;
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    private static class q implements com.bytedance.sdk.openadsdk.k.i {
        private final SSWebView a;

        /* synthetic */ q(SSWebView sSWebView, f fVar) {
            this(sSWebView);
        }

        @Override // com.bytedance.sdk.openadsdk.k.i
        public void a() {
            SSWebView sSWebView = this.a;
            if (sSWebView == null) {
                com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "webView has destroy when onPauseWebView");
            } else {
                sSWebView.o();
                com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "js make webView onPause OK");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.k.i
        public void b() {
            SSWebView sSWebView = this.a;
            if (sSWebView == null) {
                com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "webView has destroy when onPauseWebViewTimers");
            } else {
                sSWebView.q();
                com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "js make webView pauseTimers OK");
            }
        }

        private q(SSWebView sSWebView) {
            this.a = sSWebView;
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    public interface r {
        void a(WebView webView, int i);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);
    }

    public m(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.H = aVar;
        this.a = aVar.a;
        this.f508b = aVar.g;
        this.d = aVar.f;
    }

    private void J() {
        this.j.a("showPlayableEndCardOverlay", (JSONObject) null);
        this.H.X.sendEmptyMessageDelayed(600, 1000L);
    }

    public void A() {
        com.bytedance.sdk.openadsdk.d.o oVar = this.t;
        if (oVar != null) {
            oVar.h();
            this.t.f();
        }
    }

    public void B() {
        SSWebView sSWebView = this.g;
        if (sSWebView != null) {
            sSWebView.o();
        }
        SSWebView sSWebView2 = this.h;
        if (sSWebView2 != null) {
            sSWebView2.o();
        }
        if (this.P > 0) {
            this.Q += SystemClock.elapsedRealtime() - this.P;
            this.P = 0L;
        }
        x xVar = this.i;
        if (xVar != null) {
            xVar.p();
            this.i.b(false);
            a(this.i, false);
            a(this.i, true, false);
        }
        if (this.j == null || !t.g(this.a)) {
            return;
        }
        this.j.p();
        this.j.b(false);
        a(this.j, false);
        a(this.j, true, false);
    }

    public void C() {
        SSWebView sSWebView = this.g;
        if (sSWebView != null) {
            sSWebView.p();
        }
        SSWebView sSWebView2 = this.h;
        if (sSWebView2 != null) {
            sSWebView2.p();
        }
        if (this.P == 0) {
            this.P = SystemClock.elapsedRealtime();
        }
        x xVar = this.i;
        if (xVar != null) {
            xVar.q();
            SSWebView sSWebView3 = this.g;
            if (sSWebView3 != null) {
                if (sSWebView3.getVisibility() == 0) {
                    this.i.b(true);
                    a(this.i, true);
                    a(this.i, false, true);
                } else {
                    this.i.b(false);
                    a(this.i, false);
                    a(this.i, true, false);
                }
            }
        }
        if (this.j != null && t.g(this.a)) {
            this.j.q();
            SSWebView sSWebView4 = this.h;
            if (sSWebView4 != null) {
                if (sSWebView4.getVisibility() == 0) {
                    this.j.b(true);
                    a(this.j, true);
                    a(this.j, false, true);
                    if (!this.L && this.H.a.Q0()) {
                        J();
                    }
                } else {
                    this.j.b(false);
                    a(this.j, false);
                    a(this.j, true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.m;
        if (jVar != null) {
            jVar.e();
        }
    }

    public void D() {
        com.bytedance.sdk.openadsdk.d.o oVar = this.t;
        if (oVar != null) {
            oVar.d();
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.m;
        if (jVar != null) {
            jVar.f();
        }
    }

    public void E() {
        if ((!TextUtils.isEmpty(this.l) && this.l.contains("play.google.com/store")) || com.bytedance.sdk.openadsdk.core.f0.o.d(this.a)) {
            this.u = true;
            return;
        }
        if (this.g == null || !this.k || TextUtils.isEmpty(this.l) || com.bytedance.sdk.openadsdk.core.f0.q.b(this.a)) {
            return;
        }
        String str = this.l + "&is_pre_render=1";
        com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "preLoadEndCard: " + str);
        com.bytedance.sdk.openadsdk.utils.n.a(this.g, str);
    }

    public void F() {
        b.a.a.a.a.a.a.f.b bVarN0 = this.a.N0();
        if (bVarN0 == null) {
            return;
        }
        String strD = bVarN0.d();
        this.R = strD;
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        this.R = a(this.R, this.a, this.c, this.f, this.e);
        a aVar = new a(com.bytedance.sdk.openadsdk.core.o.a(), this.j, this.a.e(), this.m, this.a.S0() || t.i(this.a));
        this.K = aVar;
        this.h.setWebViewClient(aVar);
        this.h.setWebChromeClient(new b(this.j, this.m));
        com.bytedance.sdk.openadsdk.utils.n.a(this.h, this.R);
        this.q = true;
    }

    public void G() {
        com.bytedance.sdk.openadsdk.d.j jVar = this.m;
        if (jVar != null) {
            jVar.a(System.currentTimeMillis());
        }
    }

    public void H() {
        this.o.set(this.q);
        if (this.h.getVisibility() == 0 && this.q) {
            J();
            return;
        }
        this.H.R.c(false);
        this.H.I.k();
        a(this.i, true, false);
        a(this.i, false);
        b(this.i, false);
        this.g.g();
        if (!this.q) {
            this.H.S.g();
            return;
        }
        this.h.setVisibility(0);
        a(this.j, this.H.d, true);
        a(this.j, true);
        b(this.j, true);
        this.H.X.removeMessages(600);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.H;
        if (aVar.S.a(aVar.Y)) {
            return;
        }
        this.H.Y.C();
    }

    public void I() {
        b0.a((View) this.g, 0);
        b0.a((View) this.h, 8);
    }

    public void a() {
    }

    public boolean u() {
        return this.o.get();
    }

    public void v() {
        com.bytedance.sdk.openadsdk.d.c.b(this.a, this.f508b, "use_second_endcard", (JSONObject) null);
        this.N = true;
        this.P = SystemClock.elapsedRealtime();
        try {
            this.i.a("click_endcard_close", (JSONObject) null);
        } catch (Exception unused) {
        }
    }

    public void w() {
        SSWebView sSWebView = this.g;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.a0.a(sSWebView.getWebView());
        }
        SSWebView sSWebView2 = this.h;
        if (sSWebView2 != null) {
            com.bytedance.sdk.openadsdk.core.a0.a(sSWebView2.getWebView());
        }
        long j2 = this.Q;
        if (j2 > 0) {
            if (this.P > 0) {
                this.Q = j2 + (SystemClock.elapsedRealtime() - this.P);
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.H.a, this.f508b, "second_endcard_duration", (JSONObject) null, this.Q);
        }
        this.g = null;
        if (this.t != null && !com.bytedance.sdk.openadsdk.core.f0.o.b(this.a)) {
            this.t.a(true);
            this.t.q();
        }
        x xVar = this.i;
        if (xVar != null) {
            xVar.o();
        }
        x xVar2 = this.j;
        if (xVar2 != null) {
            xVar2.o();
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.m;
        if (jVar != null) {
            jVar.d();
        }
        DeviceUtils.AudioInfoReceiver.b(this);
    }

    public void x() {
        com.bytedance.sdk.openadsdk.d.o oVar = this.t;
        if (oVar != null) {
            oVar.b();
        }
    }

    public void y() {
        com.bytedance.sdk.openadsdk.d.o oVar = this.t;
        if (oVar != null) {
            oVar.c();
        }
    }

    public void z() {
        com.bytedance.sdk.openadsdk.d.o oVar = this.t;
        if (oVar != null) {
            oVar.e();
        }
    }

    private com.bytedance.sdk.openadsdk.d.o m() {
        return new com.bytedance.sdk.openadsdk.d.o(t.i(this.a) ? 3 : 2, this.d ? "rewarded_video" : "fullscreen_interstitial_ad", this.a);
    }

    public SSWebView h() {
        return this.h;
    }

    public String i() {
        return this.s;
    }

    public void j() {
        if (this.v) {
            return;
        }
        this.v = true;
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.H;
        this.c = aVar.j;
        this.e = aVar.l;
        this.f = aVar.m;
        l();
    }

    public void k() {
        String strF = t.f(this.a);
        this.l = strF;
        String strA = a(strF, this.a, this.c, this.f, this.e);
        this.l = strA;
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.M = this.l.contains("use_second_endcard=1");
    }

    void l() {
        com.bytedance.sdk.openadsdk.common.f fVar;
        this.w = this.H.V.findViewById(R.id.content);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.H;
        boolean z = aVar.s;
        this.G = z;
        if (!z || (fVar = this.F) == null) {
            SSWebView sSWebView = (SSWebView) aVar.V.findViewById(com.bytedance.sdk.openadsdk.utils.h.n);
            this.g = sSWebView;
            if (sSWebView == null || com.bytedance.sdk.openadsdk.core.f0.q.b(this.a)) {
                b0.a((View) this.g, 8);
            } else {
                this.g.l();
            }
        } else {
            this.g = fVar.c();
        }
        SSWebView sSWebView2 = (SSWebView) this.H.V.findViewById(com.bytedance.sdk.openadsdk.utils.h.o);
        this.h = sSWebView2;
        if (sSWebView2 == null || !t.i(this.a)) {
            b0.a((View) this.h, 8);
        } else {
            this.h.l();
            this.h.setDisplayZoomControls(false);
        }
        SSWebView sSWebView3 = this.g;
        if (sSWebView3 != null) {
            sSWebView3.getViewTreeObserver().addOnGlobalLayoutListener(new f());
        }
        SSWebView sSWebView4 = this.h;
        if (sSWebView4 != null) {
            sSWebView4.setLandingPage(true);
            this.h.setTag(t.i(this.a) ? this.f508b : "landingpage_endcard");
            this.h.setWebViewClient(new SSWebView.r0());
            this.h.setMaterialMeta(this.a.L());
        }
    }

    public boolean n() {
        String str = this.l;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean o() {
        return this.u;
    }

    public boolean p() {
        return this.N;
    }

    public boolean q() {
        x xVar = this.i;
        if (xVar == null) {
            return false;
        }
        return xVar.m();
    }

    public boolean r() {
        return this.O;
    }

    public boolean s() {
        SSWebView sSWebView = this.g;
        return sSWebView == null || sSWebView.getWebView() == null;
    }

    public boolean t() {
        return this.M && !this.N && this.o.get() && this.p;
    }

    public x e() {
        return this.j;
    }

    public com.bytedance.sdk.openadsdk.d.j f() {
        return this.m;
    }

    public int g() {
        return this.r;
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class g implements r {
        g() {
        }

        @Override // com.bytedance.sdk.openadsdk.b.m.p.m.r
        public void a(WebView webView, String str) {
            if (m.this.H.V.isFinishing()) {
                return;
            }
            m.this.H.I.c(m.this.u());
        }

        @Override // com.bytedance.sdk.openadsdk.b.m.p.m.r
        public void a(WebView webView, String str, Bitmap bitmap) {
            if (m.this.I || !t.h(m.this.H.a)) {
                return;
            }
            m.this.I = true;
            m.this.H.I.a(m.this.H.o, m.this.H.a, m.this.H.V.m());
            if (!t.g(m.this.a)) {
                m.this.H.X.sendEmptyMessageDelayed(600, m.this.H.I.a() * 1000);
            }
            m.this.H.I.r();
            m.this.H.V.a();
        }

        @Override // com.bytedance.sdk.openadsdk.b.m.p.m.r
        public void a(WebView webView, int i) {
            try {
                if (!t.h(m.this.H.a) || !m.this.H.a.h1() || m.this.H.V.isFinishing()) {
                    if (!m.this.H.s || m.this.H.P == null) {
                        return;
                    }
                    m.this.H.P.a(webView, i);
                    return;
                }
                m.this.H.I.f(i);
            } catch (Exception unused) {
            }
        }
    }

    public void b(int i2) {
        b0.a((View) this.g, i2);
        SSWebView sSWebView = this.g;
        if (sSWebView != null) {
            b0.a((View) sSWebView.getWebView(), i2);
        }
        if (this.g != null && (this.a.S0() || t.i(this.a))) {
            this.g.setLandingPage(true);
            this.g.setTag(t.i(this.a) ? this.f508b : "landingpage_endcard");
            this.g.setMaterialMeta(this.a.L());
        }
        if (i2 == 0 && t.g(this.a)) {
            F();
        }
    }

    public SSWebView c() {
        return this.g;
    }

    public void d(boolean z) {
        this.k = z;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.p.m$m, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class C0187m implements com.bytedance.sdk.openadsdk.k.b {
        C0187m() {
        }

        @Override // com.bytedance.sdk.openadsdk.k.b
        public void a(boolean z, int i, String str) {
            if (z) {
                m.this.H.I.p();
            }
            if (!com.bytedance.sdk.openadsdk.core.f0.q.a(m.this.H.a) || t.i(m.this.H.a)) {
                return;
            }
            com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "TimeTrackLog report from js " + z);
            m.this.a(z, i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.k.b
        public void a() {
            m.this.O = true;
            m.this.H.T.b().performClick();
        }
    }

    public void c(boolean z) {
        b(this.i, z);
    }

    public x d() {
        return this.i;
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    private static class o extends com.bytedance.sdk.openadsdk.core.c0.a implements com.bytedance.sdk.openadsdk.core.c0.b.a {
        private com.bytedance.sdk.openadsdk.b.m.p.a R;
        private final View S;
        private final View.OnClickListener T;

        public o(com.bytedance.sdk.openadsdk.b.m.p.a aVar, View view, View.OnClickListener onClickListener) {
            super(aVar.V, aVar.a, aVar.g, aVar.f ? 7 : 5);
            this.R = aVar;
            this.S = view;
            this.T = onClickListener;
            HashMap map = new HashMap();
            map.put("close_auto_click", Boolean.TRUE);
            map.put("click_scence", 2);
            a(map);
            a(aVar.H.a());
            a(this);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.a, com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, boolean z) {
            if (!this.v.Q0()) {
                super.a(view, f, f2, f3, f4, sparseArray, z);
                this.R.V.onRewardBarClick(view);
            } else {
                this.T.onClick(view);
                this.S.setOnTouchListener(null);
                this.S.setOnClickListener(this.T);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b.a
        public void a(View view, int i) {
            this.S.setOnTouchListener(null);
            this.S.setOnClickListener(this.T);
        }
    }

    public void a(String str, com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
        a(str, new g());
        if (t.h(this.H.a)) {
            a(this.h);
            this.H.I.a(new h(bVar));
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.H;
        aVar.I.d(aVar.q);
        a(new i(bVar));
    }

    public void b(x xVar, boolean z) {
        if (this.i == null || this.H.V.isFinishing()) {
            return;
        }
        xVar.b(z);
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class c extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        final /* synthetic */ r m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z, r rVar) {
            super(context, xVar, str, jVar, z);
            this.m = rVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            m.this.p = true;
            DeviceUtils.AudioInfoReceiver.a(m.this);
            m.this.S = DeviceUtils.d();
            com.bytedance.sdk.openadsdk.d.o oVar = m.this.t;
            if (oVar != null) {
                oVar.o();
            }
            m.this.H.I.a(str);
            r rVar = this.m;
            if (rVar != null) {
                rVar.a(webView, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.bytedance.sdk.openadsdk.d.o oVar = m.this.t;
            if (oVar != null) {
                oVar.n();
            }
            m.this.H.I.b(str);
            r rVar = this.m;
            if (rVar != null) {
                rVar.a(webView, str, bitmap);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Log.i("TTAD.RFWVM", "onReceivedError: description=" + str + "  url =" + str2);
            if (m.this.a(str2)) {
                return;
            }
            m.this.o.set(false);
            m mVar = m.this;
            mVar.r = i;
            mVar.s = str;
            mVar.H.I.a(i, str, str2);
            if (m.this.t != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject.put("code", i);
                        jSONObject.put("msg", str);
                    }
                    m.this.t.b(jSONObject);
                } catch (JSONException unused) {
                }
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            m.this.H.I.a(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
            if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
                Log.i("TTAD.RFWVM", "onReceivedHttpError:url =" + webResourceRequest.getUrl().toString());
            }
            if (webResourceRequest != null && !TextUtils.isEmpty(m.this.l) && m.this.l.equals(String.valueOf(webResourceRequest.getUrl()))) {
                m.this.o.set(false);
                if (webResourceResponse != null) {
                    m.this.r = webResourceResponse.getStatusCode();
                    m.this.s = "onReceivedHttpError";
                }
            }
            if (m.this.t != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (Build.VERSION.SDK_INT >= 21 && webResourceResponse != null) {
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                    }
                    m.this.t.b(jSONObject);
                } catch (JSONException unused) {
                }
            }
            if (webResourceRequest != null) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (!t.i(m.this.a)) {
                return super.shouldInterceptRequest(webView, str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            WebResourceResponse webResourceResponseA = com.bytedance.sdk.openadsdk.core.j0.b.a.b().a(m.this.a.N0().l(), m.this.a.N0().d(), str);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (m.this.t != null) {
                b.b.a.a.d.g.e.a aVarA = b.b.a.a.d.g.e.a(str);
                int i = webResourceResponseA != null ? 1 : 2;
                if (aVarA == b.b.a.a.d.g.e.a.HTML) {
                    m.this.t.a(str, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                } else if (aVarA == b.b.a.a.d.g.e.a.JS) {
                    m.this.t.b(str, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                }
            }
            return webResourceResponseA;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFWVM", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceError != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                Log.i("TTAD.RFWVM", "onReceivedError WebResourceError : description=" + ((Object) webResourceError.getDescription()) + "  url =" + webResourceRequest.getUrl().toString());
            }
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || !m.this.a(webResourceRequest.getUrl().toString())) {
                m.this.o.set(false);
                if (m.this.t != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                            jSONObject.put("code", webResourceError.getErrorCode());
                            jSONObject.put("msg", webResourceError.getDescription());
                        }
                        m.this.t.b(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceError != null) {
                    m.this.r = webResourceError.getErrorCode();
                    m.this.s = String.valueOf(webResourceError.getDescription());
                }
                if (webResourceRequest == null) {
                    return;
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }
    }

    public void b(boolean z) {
        if (this.i == null || this.H.V.isFinishing()) {
            return;
        }
        this.H.I.a(z);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.i.a("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: RewardFullWebViewManager.java */
    class a extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        a(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.bytedance.sdk.openadsdk.d.o oVar = m.this.t;
            if (oVar != null) {
                oVar.o();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.bytedance.sdk.openadsdk.d.o oVar = m.this.t;
            if (oVar != null) {
                oVar.n();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (m.this.a(str2)) {
                return;
            }
            m.this.q = false;
            m mVar = m.this;
            mVar.r = i;
            mVar.s = str;
            if (mVar.t != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject.put("code", i);
                        jSONObject.put("msg", str);
                    }
                    m.this.t.b(jSONObject);
                } catch (JSONException unused) {
                }
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceRequest != null && !TextUtils.isEmpty(m.this.R) && m.this.R.equals(String.valueOf(webResourceRequest.getUrl()))) {
                m.this.q = false;
                if (webResourceResponse != null) {
                    m.this.r = webResourceResponse.getStatusCode();
                    m.this.s = "onReceivedHttpError";
                }
            }
            if (m.this.t != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (Build.VERSION.SDK_INT >= 21 && webResourceResponse != null) {
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                    }
                    m.this.t.b(jSONObject);
                } catch (JSONException unused) {
                }
            }
            if (webResourceRequest != null) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || !m.this.a(webResourceRequest.getUrl().toString())) {
                m.this.q = false;
                if (m.this.t != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                            jSONObject.put("code", webResourceError.getErrorCode());
                            jSONObject.put("msg", webResourceError.getDescription());
                        }
                        m.this.t.b(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceError != null) {
                    m.this.r = webResourceError.getErrorCode();
                    m.this.s = String.valueOf(webResourceError.getDescription());
                }
                if (webResourceRequest == null) {
                    return;
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }
    }

    public String b() {
        return this.l;
    }

    public void a(Boolean bool, com.bytedance.sdk.openadsdk.k.e eVar, String str) {
        HashMap map = new HashMap();
        if (t.i(this.a)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 2);
        }
        this.t = m();
        this.i = new x(this.H.V);
        String strD = this.a.D();
        this.i.a(this.g).a(this.a).g(this.a.e()).j(this.a.N()).b(bool.booleanValue() ? 7 : 5).a(new p(this.g)).h(strD).b(this.g).i(n() ? "landingpage_endcard" : str).a(map).a(this.t).a(new j());
        HashMap map2 = new HashMap();
        if (t.g(this.a)) {
            map2.put("click_scence", 2);
        }
        x xVar = new x(this.H.V);
        this.j = xVar;
        x xVarH = xVar.a(this.h).a(this.a).g(this.a.e()).j(this.a.N()).b(bool.booleanValue() ? 7 : 5).a(new p(this.h)).b(this.h).h(strD);
        if (n()) {
            str = "landingpage_endcard";
        }
        xVarH.i(str).a(map2).a(this.t).a(new l()).a(new k());
        f fVar = null;
        this.i.a(new q(this.g, fVar));
        this.j.a(new q(this.h, fVar));
        this.i.a(this.H.T.b()).a(this.H.q).a(eVar).a(this.H.I.b()).a(new C0187m());
        this.i.e(this.M);
        this.j.a(this.H.T.b()).a(new n());
    }

    public void a(int i2, int i3) {
        if (this.i == null || this.H.V.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            this.i.a("resize", jSONObject);
        } catch (Exception e2) {
            Log.e("TTAD.RFWVM", "", e2);
        }
    }

    private static String a(String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i2, int i3, int i4) {
        String str2;
        String str3;
        float fO = qVar.o();
        if (!TextUtils.isEmpty(str)) {
            if (i2 == 1) {
                if (str.contains("?")) {
                    str3 = str + "&";
                } else {
                    str3 = str + "?";
                }
                str = str3 + "orientation=portrait";
            }
            if (str.contains("?")) {
                str2 = str + "&";
            } else {
                str2 = str + "?";
            }
            str = str2 + "height=" + i3 + "&width=" + i4 + "&aspect_ratio=" + fO;
        }
        return !t.i(qVar) ? com.bytedance.sdk.openadsdk.utils.c.a(str) : str;
    }

    public void a(com.bytedance.sdk.openadsdk.common.f fVar) {
        this.F = fVar;
    }

    public void a(float f2) {
        b0.a(this.g, f2);
    }

    private void a(String str, r rVar) {
        SSWebView sSWebView;
        SSWebView sSWebView2 = this.g;
        if (sSWebView2 != null && sSWebView2.getWebView() != null) {
            com.bytedance.sdk.openadsdk.d.j jVarA = new com.bytedance.sdk.openadsdk.d.j(this.a, this.g.getWebView()).a(true);
            this.m = jVarA;
            if (n()) {
                str = "landingpage_endcard";
            }
            jVarA.b(str);
            c cVar = new c(com.bytedance.sdk.openadsdk.core.o.a(), this.i, this.a.e(), this.m, this.a.S0() || t.i(this.a), rVar);
            this.J = cVar;
            this.g.setWebViewClient(cVar);
            this.J.a(this.a);
            this.J.e(this.d ? "rewarded_video" : "fullscreen_interstitial_ad");
            if (this.a.S0() && (sSWebView = this.g) != null && sSWebView.getWebView() != null) {
                this.g.getWebView().setOnTouchListener(new d());
            }
            this.g.setWebChromeClient(new e(this, this.i, this.m, rVar));
            a(this.g);
            if (Build.VERSION.SDK_INT >= 24) {
                this.g.setLayerType(1, null);
            }
            this.g.setBackgroundColor(-1);
            this.g.setDisplayZoomControls(false);
        }
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return this.a.S0() && str.endsWith(".mp4");
    }

    public void a(DownloadListener downloadListener) {
        SSWebView sSWebView = this.g;
        if (sSWebView == null || downloadListener == null) {
            return;
        }
        sSWebView.setDownloadListener(downloadListener);
    }

    public void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.b.a(this.H.V).a(false).b(false).a(sSWebView.getWebView());
        sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.k.a(sSWebView.getWebView(), BuildConfig.VERSION_CODE));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.setMixedContentMode(0);
        }
    }

    public void a(boolean z) {
        a(this.i, z);
    }

    public void a(x xVar, boolean z) {
        try {
            this.H.I.b(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            xVar.a("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void a(boolean z, boolean z2) {
        a(this.i, z, z2);
    }

    public void a(x xVar, boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z2);
            xVar.a("endcard_control_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void a(boolean z, int i2, String str) {
        com.bytedance.sdk.openadsdk.d.o oVar = this.t;
        if (oVar == null) {
            return;
        }
        if (z) {
            oVar.l();
        } else {
            oVar.b(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.g
    public void a(int i2) {
        int i3 = this.S;
        if (i3 <= 0 && i2 > 0) {
            com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "onVolumeChanged >>>> become unmuted, notify h5");
            b(false);
        } else if (i3 > 0 && i2 == 0) {
            com.bytedance.sdk.component.utils.m.a("TTAD.RFWVM", "onVolumeChanged >>>> become mute notification h5");
            b(true);
        }
        this.S = i2;
    }
}
