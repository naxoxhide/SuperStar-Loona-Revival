package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.bannerexpress.VastBannerBackupView;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressView extends PAGFrameLayout implements b.b.a.a.d.f.h, b.b.a.a.d.f.o, l, b.b.a.a.d.d.d, com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.b A;
    private final ViewTreeObserver.OnScrollChangedListener B;
    private final Runnable C;
    private final Runnable D;
    private final Runnable E;
    private ThemeStatusBroadcastReceiver F;
    private p G;
    private b.b.a.a.d.f.j.a H;
    private List<b.b.a.a.d.f.j> I;
    private b.b.a.a.d.f.p J;
    private b.b.a.a.d.f.f K;
    protected b.b.a.a.d.f.b L;
    private b.b.a.a.d.f.i M;
    public b.b.a.a.d.f.d<? extends View> N;
    private b.b.a.a.d.f.m O;
    private int P;
    private SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private long V;
    private VastBannerBackupView W;
    protected final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f650b;
    private int c;
    private com.bytedance.sdk.openadsdk.dislike.b d;
    private TTDislikeDialogAbstract e;
    protected String f;
    protected AdSlot g;
    protected q h;
    private PAGBannerAdWrapperListener i;
    private f j;
    private g k;
    protected FrameLayout l;
    private String m;
    protected boolean n;
    protected boolean o;
    private float p;
    private float q;
    private com.bytedance.sdk.openadsdk.d.o r;
    private String s;
    private com.bytedance.sdk.openadsdk.core.bannerexpress.a.h t;
    public boolean u;
    int v;
    boolean w;
    public com.bytedance.sdk.openadsdk.d.g x;
    long y;
    private final AtomicBoolean z;

    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            NativeExpressView.this.E();
            NativeExpressView nativeExpressView = NativeExpressView.this;
            nativeExpressView.removeCallbacks(nativeExpressView.C);
            NativeExpressView nativeExpressView2 = NativeExpressView.this;
            nativeExpressView2.postDelayed(nativeExpressView2.C, 500L);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!y.b(NativeExpressView.this, 0, 5)) {
                NativeExpressView.this.e(8);
            } else {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.e(nativeExpressView.getVisibility());
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeExpressView.this.e(0);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeExpressView.this.e(8);
        }
    }

    class e implements b.b.a.a.d.f.e {
        e() {
        }

        @Override // b.b.a.a.d.f.e
        public JSONObject a() {
            float f = NativeExpressView.this.p;
            float f2 = NativeExpressView.this.q;
            NativeExpressView nativeExpressView = NativeExpressView.this;
            JSONObject jSONObjectA = com.bytedance.sdk.openadsdk.core.nativeexpress.q.b.a(f, f2, nativeExpressView.o, nativeExpressView.h);
            NativeExpressView.this.a(jSONObjectA);
            return jSONObjectA;
        }
    }

    public NativeExpressView(Context context, q qVar, AdSlot adSlot, String str) {
        super(context);
        this.f650b = true;
        this.c = 0;
        this.f = "embeded_ad";
        this.m = null;
        this.o = false;
        this.u = false;
        this.v = -1;
        this.x = new com.bytedance.sdk.openadsdk.d.g();
        this.y = 0L;
        this.z = new AtomicBoolean(false);
        this.B = new a();
        this.C = new b();
        this.D = new c();
        this.E = new d();
        this.P = 8;
        this.Q = new SparseArray<>();
        this.R = -1.0f;
        this.S = -1.0f;
        this.T = -1.0f;
        this.U = -1.0f;
        this.V = 0L;
        this.f = str;
        this.a = context;
        this.h = qVar;
        this.g = adSlot;
        this.u = false;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.z.get()) {
            this.x.a(System.currentTimeMillis(), y.a(this));
        }
    }

    private int getAdSlotType() {
        String str = this.f;
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }

    private void n() {
        List<b.b.a.a.d.f.j> list = this.I;
        if (list == null) {
            return;
        }
        for (b.b.a.a.d.f.j jVar : list) {
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    private boolean p() {
        return q.c(this.h);
    }

    private void r() {
        List<b.b.a.a.d.f.j> list = this.I;
        if (list == null) {
            return;
        }
        for (b.b.a.a.d.f.j jVar : list) {
            if (jVar != null) {
                jVar.b();
            }
        }
    }

    private void s() {
        if (com.bytedance.sdk.openadsdk.core.l.e()) {
            return;
        }
        j.a();
    }

    private boolean t() {
        return TextUtils.equals(this.f, "fullscreen_interstitial_ad") || TextUtils.equals(this.f, "rewarded_video") || TextUtils.equals("open_ad", this.f) || p.b(this.f);
    }

    private void u() {
        com.bytedance.sdk.openadsdk.core.d0.a.a aVar = new com.bytedance.sdk.openadsdk.core.d0.a.a();
        if (this.c != 3) {
            p pVar = new p(this.a, this.O, this.F, this.r, this.h);
            this.G = pVar;
            b.b.a.a.d.f.p pVar2 = new b.b.a.a.d.f.p(this.a, this.O, pVar, this);
            this.J = pVar2;
            this.I.add(pVar2);
            return;
        }
        b.b.a.a.d.d.i.f fVar = new b.b.a.a.d.d.i.f();
        Context applicationContext = this.a.getApplicationContext();
        b.b.a.a.d.f.m mVar = this.O;
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = this.F;
        boolean z = this.u;
        b.b.a.a.d.f.b bVar = new b.b.a.a.d.f.b(applicationContext, mVar, themeStatusBroadcastReceiver, z, fVar, this, aVar, new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.a, themeStatusBroadcastReceiver, z, fVar, mVar, aVar));
        this.L = bVar;
        this.I.add(bVar);
    }

    private void v() {
        this.c = this.h.y0();
        try {
            s();
            u();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("NativeExpressView", "NativeExpressView dynamicRender fail", e2);
        }
        boolean z = this.h.q() == 1;
        this.f650b = z;
        if (z) {
            b.b.a.a.d.f.f fVar = new b.b.a.a.d.f.f(this.a, this.O, new n(this, this.F, this.O));
            this.K = fVar;
            this.I.add(fVar);
        }
        com.bytedance.sdk.component.utils.m.a("NativeExpressView", "initRender: mRenderSequenceType is " + this.c + ", mInterceptors is " + this.I);
        this.H = new b.b.a.a.d.f.l(this.I, this.M);
    }

    private void w() {
        if (this.h.R() == 1 && this.h.k1()) {
            b.b.a.a.d.f.f fVar = new b.b.a.a.d.f.f(this.a, this.O, new n(this, this.F, this.O));
            this.K = fVar;
            this.I.add(fVar);
            this.H = new b.b.a.a.d.f.l(this.I, this.M);
            return;
        }
        if (t()) {
            v();
            return;
        }
        try {
            s();
            p pVar = new p(this.a, this.O, this.F, this.r, this.h);
            this.G = pVar;
            b.b.a.a.d.f.p pVar2 = new b.b.a.a.d.f.p(this.a, this.O, pVar, this);
            this.J = pVar2;
            this.I.add(pVar2);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("NativeExpressView", "NativeExpressView dynamicRender fail", e2);
        }
        b.b.a.a.d.f.f fVar2 = new b.b.a.a.d.f.f(this.a, this.O, new n(this, this.F, this.O));
        this.K = fVar2;
        this.I.add(fVar2);
        this.H = new b.b.a.a.d.f.l(this.I, this.M);
    }

    private void x() {
        long jOptLong;
        boolean z;
        com.bytedance.sdk.openadsdk.d.o oVar = new com.bytedance.sdk.openadsdk.d.o(1, this.f, this.h);
        this.r = oVar;
        this.M = new k(oVar, this.f, this.h, this.m);
        try {
            jOptLong = new JSONObject(this.h.I0().c()).optLong("render_delay_time");
            try {
                z = !q.c(this.h) && com.bytedance.sdk.openadsdk.core.o.d().j(this.m) == 1;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            jOptLong = 0;
        }
        long jMin = Math.min(Math.max(jOptLong, 0L), 10000L);
        int renderTimeout = getRenderTimeout();
        com.bytedance.sdk.component.utils.m.a("NativeExpressView", "initRenderRequest: renderTimeout=" + renderTimeout);
        double dS = this.h.N0() != null ? this.h.N0().s() * ((double) this.h.N0().m()) : 0.0d;
        int i = this.v;
        this.w = i != -1 && i < ((int) dS);
        b.b.a.a.d.f.m.a aVarA = new b.b.a.a.d.f.m.a().b(this.f).a(this.h.e()).c(this.h.D()).d(this.h.N()).a(this.M).b(this.h.z0()).d(renderTimeout).c(this.h.g1()).e(this.h.O0()).a(jMin).a(this.h.e0()).a(com.bytedance.sdk.openadsdk.core.nativeexpress.q.b.a(this.h)).b(z).c(this.v).a(this.w).a(dS).a(new e());
        a(aVarA);
        this.O = aVarA.a();
    }

    public void A() {
        q qVar = this.h;
        if (qVar == null || qVar.M0() == null || this.h.M0().m() == null) {
            return;
        }
        this.h.M0().m().b(getVideoProgress());
    }

    public void B() {
        p pVar = this.G;
        if (pVar == null || pVar.e() == null) {
            return;
        }
        this.G.r();
    }

    public void C() {
        this.y = SystemClock.elapsedRealtime();
        if (this.h.V0()) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.b bVar = this.A;
            if (bVar == null) {
                b(106);
                return;
            } else {
                bVar.a((b.b.a.a.d.f.o) this);
                this.A.c();
                return;
            }
        }
        this.r.k();
        b.b.a.a.d.f.j.a aVar = this.H;
        if (aVar != null) {
            aVar.a(this);
        }
        try {
            this.H.b();
        } catch (Throwable unused) {
        }
    }

    public boolean D() {
        return this.z.get();
    }

    @Override // b.b.a.a.d.d.d
    public void a() {
    }

    public void a(int i) {
    }

    protected void a(b.b.a.a.d.f.m.a aVar) {
    }

    protected void a(JSONObject jSONObject) {
    }

    public void a(boolean z) {
    }

    protected boolean a(b.b.a.a.d.f.n nVar) {
        return true;
    }

    public void d(int i) {
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00b2  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray;
        f fVar = this.j;
        int i2 = 0;
        if (fVar != null) {
            fVar.b(motionEvent.getDeviceId());
            this.j.c(motionEvent.getSource());
            this.j.d(motionEvent.getToolType(0));
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.b(motionEvent.getDeviceId());
            this.k.c(motionEvent.getSource());
            this.k.d(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i = 3;
            } else if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                this.T += Math.abs(motionEvent.getX() - this.R);
                this.U += Math.abs(motionEvent.getY() - this.S);
                this.R = motionEvent.getX();
                this.S = motionEvent.getY();
                i = (System.currentTimeMillis() - this.V <= 200 || (this.T <= 8.0f && this.U <= 8.0f)) ? 2 : 1;
            }
            sparseArray = this.Q;
            if (sparseArray != null) {
                sparseArray.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.c0.c.a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.R = motionEvent.getRawX();
        this.S = motionEvent.getRawY();
        this.V = System.currentTimeMillis();
        i = i2;
        sparseArray = this.Q;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.c0.c.a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
    }

    public void e(int i) {
        b.b.a.a.d.f.d<? extends View> dVar = this.N;
        if (dVar == null || !(dVar instanceof p)) {
            return;
        }
        ((p) dVar).b(i);
        this.P = i;
    }

    public void f() {
    }

    public com.bytedance.sdk.openadsdk.d.g getAdShowTime() {
        return this.x;
    }

    public f getClickCreativeListener() {
        return this.j;
    }

    public g getClickListener() {
        return this.k;
    }

    public String getClosedListenerKey() {
        return this.s;
    }

    public int getDynamicShowType() {
        b.b.a.a.d.f.d<? extends View> dVar = this.N;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.q).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.p).intValue();
    }

    public x getJsObject() {
        p pVar = this.G;
        if (pVar != null) {
            return pVar.m();
        }
        return null;
    }

    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.o.d().e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a
    public long getVideoProgress() {
        VastBannerBackupView vastBannerBackupView = this.W;
        if (vastBannerBackupView != null) {
            return vastBannerBackupView.getVideoProgress();
        }
        return 0L;
    }

    public SSWebView getWebView() {
        p pVar = this.G;
        if (pVar == null) {
            return null;
        }
        return pVar.f();
    }

    public int i() {
        return 0;
    }

    public void j() {
    }

    public long k() {
        return 0L;
    }

    protected void m() {
        this.F = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.g;
        if (adSlot != null) {
            this.p = adSlot.getExpressViewAcceptedWidth();
            this.q = this.g.getExpressViewAcceptedHeight();
            this.m = this.g.getCodeId();
            if (TextUtils.equals(this.f, "fullscreen_interstitial_ad")) {
                this.v = com.bytedance.sdk.openadsdk.core.o.d().r(this.m);
            } else if (TextUtils.equals(this.f, "rewarded_video")) {
                this.v = com.bytedance.sdk.openadsdk.core.o.d().a(this.m);
            } else if (TextUtils.equals(this.f, "open_ad")) {
                int iS = com.bytedance.sdk.openadsdk.core.o.d().s(this.m);
                this.v = iS;
                if (iS < 0) {
                    this.v = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.h.V0()) {
            this.A = new com.bytedance.sdk.openadsdk.core.nativeexpress.b(this.a, this, this.h, this.f);
            return;
        }
        x();
        this.I = new ArrayList();
        w();
        b.b.a.a.d.f.p pVar = this.J;
        if (pVar != null) {
            this.G = (p) pVar.d();
        }
        x jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.k(this.f);
        }
    }

    public void o() {
        try {
            FrameLayout frameLayout = this.l;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.l);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.a("NativeExpressView", "backupDestroy remove video container error", th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        E();
        n();
        com.bytedance.sdk.component.utils.m.b("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.B);
        com.bytedance.sdk.openadsdk.core.h.a().a(this.s, this.t);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.B);
        com.bytedance.sdk.openadsdk.core.h.a().f(this.s);
        r();
        com.bytedance.sdk.component.utils.m.b("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.m.b("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        E();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.m.b("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
        E();
        if (z) {
            com.bytedance.sdk.openadsdk.q.c.e.a(this.h, 4);
        } else {
            com.bytedance.sdk.openadsdk.q.c.e.a(this.h, 8);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.E);
        removeCallbacks(this.D);
        if (i == 0) {
            postDelayed(this.D, 50L);
        } else {
            postDelayed(this.E, 50L);
        }
    }

    public void q() {
        try {
            com.bytedance.sdk.openadsdk.core.nativeexpress.b bVar = this.A;
            if (bVar != null) {
                bVar.b();
            }
            A();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<b.b.a.a.d.f.j> list = this.I;
            if (list != null) {
                Iterator<b.b.a.a.d.f.j> it = list.iterator();
                while (it.hasNext()) {
                    it.next().release();
                }
            }
            com.bytedance.sdk.openadsdk.q.c.e.c(this.h);
            this.d = null;
            this.e = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("NativeExpressView", "detach error", th);
        }
    }

    public void setBackupListener(b.b.a.a.d.f.c cVar) {
        b.b.a.a.d.f.f fVar = this.K;
        if (fVar != null) {
            fVar.a(cVar);
        }
    }

    public void setBannerClickClosedListener(com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVar) {
        this.t = hVar;
    }

    public void setClickCreativeListener(f fVar) {
        this.j = fVar;
        if (fVar != null) {
            fVar.a((com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a) this);
        }
    }

    public void setClickListener(g gVar) {
        this.k = gVar;
    }

    public void setClosedListenerKey(String str) {
        this.s = str;
        com.bytedance.sdk.openadsdk.core.nativeexpress.b bVar = this.A;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        BackupView backupView;
        b.b.a.a.d.f.d<? extends View> dVar = this.N;
        if (dVar != null && (dVar instanceof n) && (backupView = (BackupView) dVar.e()) != null) {
            backupView.setDislikeInner(bVar);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.b bVar2 = this.A;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
        this.d = bVar;
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.i = pAGBannerAdWrapperListener;
        com.bytedance.sdk.openadsdk.core.nativeexpress.b bVar = this.A;
        if (bVar != null) {
            bVar.a(pAGBannerAdWrapperListener);
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView;
        b.b.a.a.d.f.d<? extends View> dVar = this.N;
        if (dVar != null && (dVar instanceof n) && (backupView = (BackupView) dVar.e()) != null) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.b bVar = this.A;
        if (bVar != null) {
            bVar.a(tTDislikeDialogAbstract);
        }
        this.e = tTDislikeDialogAbstract;
    }

    @Override // b.b.a.a.d.d.d
    public void setSoundMute(boolean z) {
        this.u = z;
        b.b.a.a.d.f.b bVar = this.L;
        if (bVar == null || bVar.c() == null) {
            return;
        }
        this.L.c().setSoundMute(z);
    }

    @Override // b.b.a.a.d.d.d
    public void setTimeUpdate(int i) {
    }

    public void setVastVideoHelper(VastBannerBackupView vastBannerBackupView) {
        this.W = vastBannerBackupView;
    }

    public boolean y() {
        b.b.a.a.d.f.d<? extends View> dVar = this.N;
        return dVar != null && dVar.b() == 1;
    }

    public void z() {
        b.b.a.a.d.f.d<? extends View> dVar = this.N;
        if (dVar instanceof p) {
            if (dVar == null) {
                return;
            } else {
                ((p) dVar).h();
            }
        }
        q qVar = this.h;
        if (qVar == null || qVar.M0() == null || this.h.M0().m() == null) {
            return;
        }
        this.h.M0().m().d(0L);
    }

    public void a(View view, int i, b.b.a.a.d.b bVar) {
        View view2;
        if (i == -1 || bVar == null) {
            return;
        }
        HashMap map = new HashMap();
        if (t.h(this.h)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        com.bytedance.sdk.openadsdk.core.f0.m mVar = (com.bytedance.sdk.openadsdk.core.f0.m) bVar;
        f fVar = this.j;
        if (fVar != null) {
            fVar.a(getDynamicShowType());
            this.j.a(map);
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.a(getDynamicShowType());
            this.k.a(map);
        }
        float f = mVar.a;
        float f2 = mVar.f582b;
        float f3 = mVar.c;
        float f4 = mVar.d;
        boolean z = mVar.o;
        SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray = mVar.n;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.Q;
        }
        SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray2 = sparseArray;
        String str = mVar.k;
        JSONObject jSONObjectA = null;
        if (view == null) {
            view2 = this;
        } else {
            jSONObjectA = view != this ? a(view) : null;
            view2 = view;
        }
        if (mVar != null) {
            mVar.l = i;
            if (jSONObjectA != null && mVar.m == null) {
                mVar.m = jSONObjectA;
            }
        }
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.l;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                q qVar = this.h;
                if (qVar == null || qVar.l0() != 1 || z) {
                    g gVar2 = this.k;
                    if (gVar2 != null) {
                        gVar2.a(mVar);
                        this.k.a(str);
                        this.k.a(view2, f, f2, f3, f4, sparseArray2, z);
                    }
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.i;
                    if (pAGBannerAdWrapperListener != null) {
                        pAGBannerAdWrapperListener.onAdClicked(this, this.h.e0());
                    }
                }
                break;
            case 2:
                if (mVar.p > 0) {
                    z.a(true);
                }
                f fVar2 = this.j;
                if (fVar2 != null) {
                    fVar2.a(mVar);
                    this.j.a(str);
                    this.j.a(view2, f, f2, f3, f4, sparseArray2, z);
                }
                PAGBannerAdWrapperListener pAGBannerAdWrapperListener2 = this.i;
                if (pAGBannerAdWrapperListener2 != null) {
                    pAGBannerAdWrapperListener2.onAdClicked(this, this.h.e0());
                }
                z.a(false);
                com.bytedance.sdk.openadsdk.q.c.e.a(this.h, 9);
                break;
            case 3:
                TTDislikeDialogAbstract tTDislikeDialogAbstract = this.e;
                if (tTDislikeDialogAbstract == null) {
                    com.bytedance.sdk.openadsdk.dislike.b bVar2 = this.d;
                    if (bVar2 == null) {
                        TTDelegateActivity.a(this.h, this.s);
                    } else {
                        bVar2.a();
                    }
                } else {
                    tTDislikeDialogAbstract.show();
                }
                break;
            case 4:
                FrameLayout frameLayout2 = this.l;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                q qVar2 = this.h;
                if (qVar2 == null || qVar2.l0() != 1 || z) {
                    com.bytedance.sdk.component.utils.m.a("ClickCreativeListener", "Creativity....mAdType=" + this.f + ",!mVideoPause=" + (!this.n) + "，isAutoPlay=" + a0.b(this.h));
                    if ("embeded_ad".equals(this.f) && p() && !this.n && a0.b(this.h)) {
                        com.bytedance.sdk.component.utils.m.a("ClickCreativeListener", "Creative....");
                        f fVar3 = this.j;
                        if (fVar3 != null) {
                            fVar3.a(mVar);
                            this.j.a(str);
                            this.j.a(view2, f, f2, f3, f4, sparseArray2, z);
                        }
                    } else {
                        com.bytedance.sdk.component.utils.m.a("ClickCreativeListener", "normal....");
                        g gVar3 = this.k;
                        if (gVar3 != null) {
                            gVar3.a(mVar);
                            this.k.a(str);
                            this.k.a(view2, f, f2, f3, f4, sparseArray2, z);
                        }
                    }
                    PAGBannerAdWrapperListener pAGBannerAdWrapperListener3 = this.i;
                    if (pAGBannerAdWrapperListener3 != null) {
                        pAGBannerAdWrapperListener3.onAdClicked(this, this.h.e0());
                    }
                }
                break;
            case 5:
                a(!this.u);
                break;
            case 6:
                j();
                break;
            case 7:
                TTWebsiteActivity.a(this.a, this.h, this.f);
                break;
        }
    }

    @Override // b.b.a.a.d.f.o
    public void b(int i) {
        b.b.a.a.d.f.i iVar = this.M;
        if (iVar != null) {
            if (!this.f650b) {
                iVar.b();
            }
            this.M.a();
            ((k) this.M).i();
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.i;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.g.a(i), i);
        }
    }

    protected void b(int i, int i2) {
        int iMin;
        if (TextUtils.equals(this.f, "banner_ad")) {
            return;
        }
        int i3 = this.v;
        int i4 = ((i2 < i3 || i3 < 0 || !(this.w || TextUtils.equals(this.f, "open_ad"))) && i() != 5) ? 0 : 1;
        if (i2 > this.v) {
            iMin = 0;
        } else if (this.h.N0() != null) {
            iMin = (int) (Math.min(this.v, this.h.N0().s() * ((double) this.h.N0().m())) - ((double) i2));
        } else {
            iMin = this.v - i2;
        }
        b.b.a.a.d.f.b bVar = this.L;
        if (bVar == null || bVar.c() == null) {
            return;
        }
        this.L.c().a(String.valueOf(i), i4, iMin, false);
    }

    public static JSONObject a(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("left", iArr[0]);
            jSONObject.put("top", iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(b.b.a.a.d.f.d<? extends View> dVar, b.b.a.a.d.f.n nVar) {
        this.z.set(true);
        this.N = dVar;
        if (this.P != getWindowVisibility()) {
            e(getWindowVisibility());
        }
        if (dVar.b() == 3 && this.h.v() == 1) {
            this.h.J(0);
        }
        if (dVar.b() == 2 || dVar.b() == 0 || dVar.b() == 3) {
            View viewE = dVar.e();
            if (viewE.getParent() != null) {
                ((ViewGroup) viewE.getParent()).removeView(viewE);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                arrayList.add(getChildAt(i));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) instanceof SSWebView) {
                    removeView((View) arrayList.get(i2));
                }
            }
            addView(dVar.e());
        }
        q qVar = this.h;
        if (qVar != null) {
            com.bytedance.sdk.openadsdk.l.b.a(qVar.G0(), this.y, this.f, dVar.b());
        }
        b.b.a.a.d.f.i iVar = this.M;
        if (iVar != null) {
            ((k) iVar).i();
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.i;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onRenderSuccess(this, (float) nVar.b(), (float) nVar.a());
        }
        if (a(nVar)) {
            com.bytedance.sdk.openadsdk.q.c.e.a(this, this.h, getDynamicShowType());
        }
    }

    @Override // b.b.a.a.d.d.d
    public void a(CharSequence charSequence, int i, int i2, boolean z) {
        b(Integer.parseInt(String.valueOf(charSequence)), i);
    }

    public NativeExpressView(Context context, q qVar, AdSlot adSlot, String str, boolean z) {
        super(context);
        this.f650b = true;
        this.c = 0;
        this.f = "embeded_ad";
        this.m = null;
        this.o = false;
        this.u = false;
        this.v = -1;
        this.x = new com.bytedance.sdk.openadsdk.d.g();
        this.y = 0L;
        this.z = new AtomicBoolean(false);
        this.B = new a();
        this.C = new b();
        this.D = new c();
        this.E = new d();
        this.P = 8;
        this.Q = new SparseArray<>();
        this.R = -1.0f;
        this.S = -1.0f;
        this.T = -1.0f;
        this.U = -1.0f;
        this.V = 0L;
        this.f = str;
        this.a = context;
        this.h = qVar;
        this.g = adSlot;
        this.u = z;
        m();
    }
}
