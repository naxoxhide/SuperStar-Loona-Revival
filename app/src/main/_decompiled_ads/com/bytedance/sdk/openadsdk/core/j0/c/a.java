package com.bytedance.sdk.openadsdk.core.j0.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i0.f;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.d.g;
import com.bytedance.sdk.openadsdk.layout.TTVideoPlayLayoutForLiveLayout;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: BaseVideoController.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.core.j0.a.a {
    private final g G;
    private long H;
    private long I;
    private boolean J;
    private final int K;
    protected long L;
    f M;
    final com.bytedance.sdk.openadsdk.core.j0.c.d.c N;
    private final Runnable O;

    /* JADX INFO: compiled from: BaseVideoController.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).e == null) {
                return;
            }
            a.this.H = System.currentTimeMillis();
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.f(0);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).e.a(true, ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).h, ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).o);
        }
    }

    /* JADX INFO: compiled from: BaseVideoController.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).A != null) {
                a.this.P();
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).A.h();
            }
        }
    }

    /* JADX INFO: compiled from: BaseVideoController.java */
    class d implements Runnable {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f638b;
        final /* synthetic */ int c;

        d(long j, long j2, int i) {
            this.a = j;
            this.f638b = j2;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.a(this.a, this.f638b);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.d(this.c);
            try {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).A != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).A.a(this.a, this.f638b);
                }
            } catch (Throwable th) {
                m.b(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "onProgressUpdate error: ", th);
            }
        }
    }

    public a(Context context, ViewGroup viewGroup, q qVar, g gVar) {
        super(context, qVar, viewGroup);
        this.H = 0L;
        this.I = 0L;
        this.J = false;
        this.N = new C0208a();
        this.O = new c();
        this.G = gVar;
        this.K = qVar.S();
        if (qVar.k1() && qVar.M0() != null && this.y != null) {
            if (this.M == null) {
                this.M = f.a();
            }
            this.M.a(this.y, qVar.M0().i());
        }
        e eVar = new e(context.getApplicationContext(), new TTVideoPlayLayoutForLiveLayout(context), true, 17, this.g, this);
        this.f = eVar;
        eVar.a(this);
    }

    protected void P() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.a.a
    public boolean w() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        ViewGroup viewGroup;
        try {
            if (H() != null && this.e != null && (viewGroup = this.y) != null) {
                int width = viewGroup.getWidth();
                int height = this.y.getHeight();
                float fB = this.e.b();
                float fC = this.e.c();
                float f = width;
                float f2 = height;
                if (fB / (f * 1.0f) <= fC / (1.0f * f2)) {
                    f = (f2 / fC) * fB;
                } else {
                    f2 = (f / fB) * fC;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (H() instanceof TextureView) {
                    ((TextureView) H()).setLayoutParams(layoutParams);
                } else if (H() instanceof SurfaceView) {
                    ((SurfaceView) H()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            m.b(this.a, "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean G() {
        return H() == null || this.e == null || this.g.I0() != null || this.g.p0() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.f == null) {
            return;
        }
        this.f631b.removeCallbacks(this.O);
        this.f.e();
        this.I = System.currentTimeMillis() - this.H;
        if (!this.J) {
            this.J = true;
            long j = this.C;
            a(j, j);
            long j2 = this.C;
            this.h = j2;
            this.i = j2;
            a(this.G);
        }
        b.a.a.a.a.a.a.g.c.a aVar = this.A;
        if (aVar != null) {
            aVar.b(this.I, b.a.a.a.a.a.b.f.a.a(this.h, this.C));
        }
        this.m = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        return this.g.o() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        try {
            m.d(this.a, "changeVideoSize start.......slot=" + this.g.f());
            if (G()) {
                return;
            }
            m.d(this.a, "changeVideoSize start check condition complete ... go ..");
            int[] iArrH = b0.h(o.a());
            boolean z = false;
            boolean z2 = this.g.j0() == 1;
            float f = iArrH[0];
            float f2 = iArrH[1];
            float fB = this.e.b();
            float fC = this.e.c();
            if (z2) {
                if (fB > fC) {
                    m.a(this.a, "Separate adaptation for landscape to portrait .....");
                    a(f, f2, fB, fC, true);
                    return;
                }
            } else if (fB < fC) {
                m.a(this.a, "Separate adaptation for portrait to landscape.....");
                a(f, f2, fB, fC, false);
                return;
            }
            float f3 = fB / fC;
            float f4 = f / f2;
            m.a(this.a, "screenHeight=" + f2 + ",screenWidth=" + f);
            m.a(this.a, "videoHeight=" + fC + ",videoWidth=" + fB);
            m.a(this.a, "video w/h,videoScale=" + f3 + ",screen  w/h .screenScale=" + f4 + ",VERTICAL_SCALE(9:16)=0.5625,HORIZONTAL_SCALE(16:9) =1.7777778");
            if (z2) {
                if (f4 < 0.5625f && f3 == 0.5625f) {
                    fB = (9.0f * f2) / 16.0f;
                    z = true;
                    fC = f2;
                }
            } else if (f4 > 1.7777778f && f3 == 1.7777778f) {
                fC = (9.0f * f) / 16.0f;
                z = true;
                fB = f;
            }
            m.d(this.a, "Width and height after adaptation：videoHeight=" + fC + ",videoWidth=" + fB);
            if (z) {
                f = fB;
                f2 = fC;
            } else {
                m.d(this.a, " Screen w/h == Video w/h and in other cases，use screen width and height，videoHeight=" + f2 + "，videoWidth=" + f);
            }
            int i = (int) f;
            int i2 = (int) f2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(13);
            if (H() != null) {
                if (H() instanceof TextureView) {
                    ((TextureView) H()).setLayoutParams(layoutParams);
                } else if (H() instanceof SurfaceView) {
                    ((SurfaceView) H()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i2;
                    layoutParams2.width = i;
                    this.y.setLayoutParams(layoutParams2);
                }
            }
            m.a(this.a, "changeVideoSize .... complete ... end !!!");
        } catch (Throwable th) {
            m.b(this.a, "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        try {
            if (H() != null && this.e != null) {
                boolean z = this.g.j0() == 1;
                int[] iArrH = b0.h(o.a());
                a(iArrH[0], iArrH[1], this.e.b(), this.e.c(), z);
                m.a(this.a, "changeSize=end");
            }
        } catch (Throwable th) {
            m.a(this.a, "changeSize error", th);
        }
    }

    private void O() {
        this.e.c(t());
        this.e.b(this.w);
        this.H = System.currentTimeMillis();
        this.f.e(8);
        this.f.e(0);
        b(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        int I;
        int i = this.w.s;
        if (i == 2 || i == 1) {
            I = o.d().I() * 1000;
        } else {
            I = i == 4 ? o.d().b(String.valueOf(this.K)) : 5000;
        }
        this.f631b.removeCallbacks(this.O);
        this.f631b.postDelayed(this.O, I);
    }

    public com.bykv.vk.openvk.component.video.api.renderview.b H() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar.k();
        }
        return null;
    }

    public void M() {
        this.N.a((b.a.a.a.a.a.a.a) null, 0, 0);
    }

    public void N() {
        f fVar = this.M;
        if (fVar != null) {
            fVar.a(2);
        }
    }

    public void Q() {
        if (this.J || !this.t.get()) {
            return;
        }
        E();
        com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = this.g.M0();
        if (aVarM0 == null || aVarM0.m() == null) {
            return;
        }
        aVarM0.m().g(o());
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void e() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar == null) {
            return;
        }
        dVar.A();
        this.e = null;
        e eVar = this.f;
        if (eVar != null) {
            eVar.t();
        }
        this.f631b.removeCallbacks(this.O);
        this.f631b.removeCallbacksAndMessages(null);
        f fVar = this.M;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void f() {
        e eVar = this.f;
        if (eVar != null) {
            eVar.c();
            this.f.j();
            this.f.r();
        }
        m.c(this.a, "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.l));
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            if (dVar.i()) {
                if (!this.l) {
                    a(this.D);
                } else if (h.t()) {
                    this.e.a(3);
                    com.bytedance.sdk.openadsdk.core.j0.c.d dVar2 = this.e;
                    dVar2.a(false, dVar2.n(), this.o);
                } else {
                    r();
                }
                m.c(this.a, "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.l));
            } else {
                this.e.a(false, this.h, this.o);
            }
        }
        if (this.J || !this.t.get()) {
            return;
        }
        E();
        com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = this.g.M0();
        if (aVarM0 == null || aVarM0.m() == null) {
            return;
        }
        aVarM0.m().g(o());
    }

    protected void g(boolean z) {
        try {
            m.d(this.a, "landingPageChangeVideoSize start......." + this.g.f());
            if (!G() || z) {
                m.d(this.a, "landingPageChangeVideoSize start check condition complete ... go ..");
                float fB = this.e.b();
                float fC = this.e.c();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) fB, (int) fC);
                layoutParams.addRule(13);
                if (H() != null) {
                    if (H() instanceof TextureView) {
                        ((TextureView) H()).setLayoutParams(layoutParams);
                    } else if (H() instanceof SurfaceView) {
                        ((SurfaceView) H()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
                    if (this.y.getHeight() > 0) {
                        float fMin = Math.min(this.y.getWidth() / fB, this.y.getHeight() / fC);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (fB * fMin);
                            layoutParams.height = (int) (fC * fMin);
                            if (H() instanceof TextureView) {
                                ((TextureView) H()).setLayoutParams(layoutParams);
                            } else if (H() instanceof SurfaceView) {
                                ((SurfaceView) H()).setLayoutParams(layoutParams);
                            }
                            if (this.w.s == 4) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.y.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
                m.a(this.a, "changeVideoSize .... complete ... end !!!");
            }
        } catch (Throwable th) {
            m.b(this.a, "changeSize error", th);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void c() {
        e();
    }

    @Override // b.a.a.a.a.a.a.g.a
    public void c(b.a.a.a.a.a.a.g.b bVar, View view) {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar == null) {
            return;
        }
        if (dVar.h()) {
            d();
            this.f.b(true, false);
            this.f.u();
            return;
        }
        if (!this.e.i()) {
            e eVar = this.f;
            if (eVar != null) {
                eVar.c(this.y);
            }
            d(this.h);
            e eVar2 = this.f;
            if (eVar2 != null) {
                eVar2.b(false, false);
                return;
            }
            return;
        }
        f();
        e eVar3 = this.f;
        if (eVar3 != null) {
            eVar3.b(false, false);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean a(b.a.a.a.a.a.a.f.c cVar) {
        int iR;
        View view;
        if (this.e != null) {
            m.b(this.a, "playVideoUrl: already invoked");
            return false;
        }
        m.a(this.a, "video local url " + cVar.m());
        if (TextUtils.isEmpty(cVar.m())) {
            m.b(this.a, "No video info");
            return false;
        }
        b(cVar);
        cVar.d(1);
        cVar.m().startsWith(ProxyConfig.MATCH_HTTP);
        if (this.M != null) {
            if (this.w.s == 1) {
                iR = o.d().a(String.valueOf(this.K));
            } else {
                iR = o.d().r(String.valueOf(this.K));
            }
            ViewGroup viewGroup = this.y;
            if (viewGroup != null && (view = (View) viewGroup.getParent()) != null) {
                try {
                    View viewFindViewById = view.findViewById(com.bytedance.sdk.openadsdk.utils.h.l);
                    View viewFindViewById2 = view.findViewById(520093757);
                    View viewFindViewById3 = view.findViewById(com.bytedance.sdk.openadsdk.utils.h.r1);
                    f fVar = this.M;
                    FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                    fVar.a(viewFindViewById, friendlyObstructionPurpose);
                    this.M.a(viewFindViewById3, friendlyObstructionPurpose);
                    this.M.a(viewFindViewById2, friendlyObstructionPurpose);
                } catch (Throwable unused) {
                }
            }
            this.M.a(iR > 0, iR / 1000.0f);
        }
        D();
        if (cVar.d() > 0) {
            long jD = cVar.d();
            this.h = jD;
            this.i = Math.max(this.i, jD);
        }
        e eVar = this.f;
        if (eVar != null) {
            eVar.c();
            this.f.w();
            this.f.c(cVar.q(), cVar.f());
            this.f.c(this.y);
        }
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = new com.bytedance.sdk.openadsdk.core.j0.c.d();
        this.e = dVar;
        dVar.a(this.N);
        v();
        this.I = 0L;
        O();
        return true;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseVideoController.java */
    class C0208a implements com.bytedance.sdk.openadsdk.core.j0.c.d.c {
        private boolean a = true;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class RunnableC0209a implements Runnable {
            RunnableC0209a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.I();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$b */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.e();
                }
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$c */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.e();
                }
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$d */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.e();
                }
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).A != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).A.a(a.this.I, b.a.a.a.a.a.b.f.a.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).h, ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).C));
                }
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$e */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.e();
                }
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$f */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class f implements Runnable {
            f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.J()) {
                    a.this.F();
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.f0.o.f(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g) || ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).w.s == 4) {
                    a.this.g(true);
                    return;
                }
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g.O0() == 3) {
                    a.this.g(true);
                } else if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g.O0() == 0) {
                    a.this.L();
                } else {
                    a.this.K();
                }
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$g */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class g implements Runnable {
            g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.x();
                }
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.c.a$a$h */
        /* JADX INFO: compiled from: BaseVideoController.java */
        class h implements Runnable {
            h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f.e();
                }
            }
        }

        C0208a() {
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, long j) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "onRenderStart: ");
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).x = false;
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.removeCallbacks(a.this.O);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new b());
            if (!((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).t.get()) {
                a aVar2 = a.this;
                aVar2.L = j;
                aVar2.b(aVar2.G);
                a.this.B();
            }
            com.bytedance.sdk.openadsdk.core.i0.f fVar = a.this.M;
            if (fVar != null) {
                fVar.g();
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g, 0);
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void b(b.a.a.a.a.a.a.a aVar) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "IVideoPlayerCallback onRelease: ");
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void b(b.a.a.a.a.a.a.a aVar, int i) {
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void c(b.a.a.a.a.a.a.a aVar) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "onPrepared: ");
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.removeCallbacks(a.this.O);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new c());
            a aVar2 = a.this;
            com.bytedance.sdk.openadsdk.core.i0.f fVar = aVar2.M;
            if (fVar != null) {
                fVar.a(aVar2.a(), a.this.i());
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void d(b.a.a.a.a.a.a.a aVar) {
            com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g.M0();
            if (aVarM0 != null && aVarM0.m() != null) {
                aVarM0.m().f(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).h);
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g, 3);
            com.bytedance.sdk.openadsdk.core.i0.f fVar = a.this.M;
            if (fVar != null) {
                fVar.a(0);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void e(b.a.a.a.a.a.a.a aVar) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "onCompletion: ");
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new RunnableC0209a());
            com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g.M0();
            if (aVarM0 != null && aVarM0.m() != null) {
                long jO = a.this.o();
                aVarM0.m().c(jO);
                aVarM0.m().b(jO);
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g, 5);
            com.bytedance.sdk.openadsdk.core.i0.f fVar = a.this.M;
            if (fVar != null) {
                fVar.a(9);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, b.a.a.a.a.a.a.f.a aVar2) {
            m.b(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "onError: " + aVar2.a() + "," + aVar2.b() + "," + aVar2.c());
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.removeCallbacks(a.this.O);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new d());
            a.this.a(aVar2);
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g, 6);
            com.bytedance.sdk.openadsdk.core.i0.f fVar = a.this.M;
            if (fVar != null) {
                fVar.a(14);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, boolean z) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "onSeekCompletion: " + z);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.removeCallbacks(a.this.O);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new e());
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i, int i2) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "IVideoPlayerCallback onVideoSizeChanged: " + i + "x" + i2);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new f());
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i, int i2, int i3) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "IVideoPlayerCallback onBufferStart: " + i + ", " + i2 + ", " + i3);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).x = true;
            a.this.R();
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new g());
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g, 3);
            com.bytedance.sdk.openadsdk.core.i0.f fVar = a.this.M;
            if (fVar != null) {
                fVar.a(4);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i) {
            m.d(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).a, "IVideoPlayerCallback onBufferEnd: " + i);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).x = false;
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.removeCallbacks(a.this.O);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).f631b.post(new h());
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g, 0);
            com.bytedance.sdk.openadsdk.core.i0.f fVar = a.this.M;
            if (fVar != null) {
                fVar.a(5);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, long j, long j2) {
            if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).h) < 50) {
                return;
            }
            a aVar2 = a.this;
            aVar2.b(aVar2.G);
            a.this.a(j, j2);
            com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g.M0();
            if (aVarM0 != null && aVarM0.m() != null) {
                aVarM0.m().a(j, j2, a.this.M);
            }
            if (!this.a || j2 - j >= 500) {
                return;
            }
            this.a = false;
            e(aVar);
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar) {
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).g, 0);
            com.bytedance.sdk.openadsdk.core.i0.f fVar = a.this.M;
            if (fVar != null) {
                fVar.a(1);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.j0.c.d.c
        public void a(int i, int i2) {
            a aVar = a.this;
            aVar.a(aVar.G);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).w.q = ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).e.E();
            a.this.D();
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) a.this).t.set(false);
            a aVar2 = a.this;
            aVar2.b(aVar2.G);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(boolean z, int i) {
        e();
    }

    private void a(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        ViewGroup viewGroup;
        try {
            m.a(this.a, "sWh=" + f + "x" + f2 + ", vWH=" + f3 + "x" + f4 + ", " + z);
            if (f3 <= 0.0f || f4 <= 0.0f) {
                f3 = this.g.N0().c();
                f4 = this.g.N0().a();
            }
            if (f4 > 0.0f && f3 > 0.0f) {
                if (z) {
                    if (f3 < f4) {
                        return;
                    }
                    m.a(this.a, "Vertical screen mode use video width compute scale value");
                    layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
                } else {
                    if (f3 > f4) {
                        return;
                    }
                    m.a(this.a, "Landscape screen mode use video height compute scale value");
                    layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
                }
                layoutParams.addRule(13);
                if (H() != null) {
                    if (H() instanceof TextureView) {
                        ((TextureView) H()).setLayoutParams(layoutParams);
                    } else if (H() instanceof SurfaceView) {
                        ((SurfaceView) H()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
                    if (!b.b.a.a.d.g.b.a(o.a()) || (viewGroup = this.y) == null || viewGroup.getHeight() <= 0 || layoutParams2 == null) {
                        return;
                    }
                    layoutParams2.width = layoutParams.width;
                    layoutParams2.height = layoutParams.height;
                    this.y.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            m.a(this.a, "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        this.g.b(j);
        this.h = j;
        this.C = j2;
        this.f631b.post(new d(j, j2, b.a.a.a.a.a.b.f.a.a(j, j2)));
    }
}
