package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.layout.TTVideoDetailLayout;
import com.bytedance.sdk.openadsdk.layout.TTVideoPlayLayoutForLiveLayout;
import com.bytedance.sdk.openadsdk.utils.y;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: NativeVideoController.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.sdk.openadsdk.core.j0.a.a {
    private long G;
    private long H;
    private final boolean I;
    private final String J;
    private final boolean K;
    private final boolean L;
    private boolean M;
    private WeakReference<b.a.a.a.a.a.a.g.c.d> N;
    private WeakReference<g> O;
    private com.bytedance.sdk.openadsdk.d.g P;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.b Q;
    private final b.a.a.a.a.a.a.a.InterfaceC0007a R;
    private int S;
    private final Runnable T;
    private final w.b U;
    private int V;
    private boolean W;

    /* JADX INFO: compiled from: NativeVideoController.java */
    class b implements NativeVideoTsView.h {
        final /* synthetic */ NativeVideoTsView.h a;

        b(c cVar, NativeVideoTsView.h hVar) {
            this.a = hVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.h
        public void a(View view, int i) {
            NativeVideoTsView.h hVar = this.a;
            if (hVar != null) {
                hVar.a(view, i);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeVideoController.java */
    class RunnableC0217c implements Runnable {
        RunnableC0217c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).e == null) {
                return;
            }
            c.this.G = System.currentTimeMillis();
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.f(0);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).e.a(true, ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).h, ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).o);
        }
    }

    /* JADX INFO: compiled from: NativeVideoController.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, (WeakReference<Context>) null, false);
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.e();
                c.this.a(true);
                m.b(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).a, "Show result page after error.......showAdCard");
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoController.java */
    class e implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f683b;

        e(int i, int i2) {
            this.a = i;
            this.f683b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a, this.f683b);
                layoutParams.addRule(13);
                if (c.this.G() instanceof TextureView) {
                    ((TextureView) c.this.G()).setLayoutParams(layoutParams);
                    m.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).a, "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                } else if (c.this.G() instanceof SurfaceView) {
                    ((SurfaceView) c.this.G()).setLayoutParams(layoutParams);
                    m.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).a, "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                }
            } catch (Throwable unused) {
                m.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).a, "[step-9] setLayoutParams exception");
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoController.java */
    class f implements w.b {

        /* JADX INFO: compiled from: NativeVideoController.java */
        class a implements Runnable {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f(this.a);
            }
        }

        f() {
        }

        @Override // com.bytedance.sdk.component.utils.w.b
        public void a(Context context, Intent intent, boolean z, int i) {
            y.a(new a(i));
        }
    }

    /* JADX INFO: compiled from: NativeVideoController.java */
    public interface g {
        void c(int i);

        void d();
    }

    public c(Context context, ViewGroup viewGroup, q qVar, String str, boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.d.g gVar) {
        super(context, qVar, viewGroup);
        this.G = 0L;
        this.H = 0L;
        this.M = true;
        this.R = new a();
        this.S = 0;
        this.T = new d();
        this.U = new f();
        this.W = false;
        this.V = p.b(context);
        d(z);
        this.J = str;
        try {
            viewGroup.getWidth();
            viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        a(context);
        this.I = Build.VERSION.SDK_INT >= 17;
        this.K = z2;
        this.L = z3;
        if (gVar != null) {
            this.P = gVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar;
        int i;
        int i2;
        m.a(this.a, "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            if (G() != null && (dVar = this.e) != null && this.y != null) {
                int iB = dVar.b();
                int iC = this.e.c();
                int width = this.y.getWidth();
                int height = this.y.getHeight();
                if (width > 0 && height > 0 && iC > 0 && iB > 0) {
                    if (iB == iC) {
                        i2 = width > height ? height : width;
                        i = i2;
                    } else if (iB > iC) {
                        i2 = (int) ((((double) width) * 1.0d) / ((double) ((iB * 1.0f) / iC)));
                        i = width;
                    } else {
                        i = (int) ((((double) height) * 1.0d) / ((double) ((iC * 1.0f) / iB)));
                        i2 = height;
                    }
                    if (i2 <= height && i2 > 0) {
                        height = i2;
                    }
                    if (i <= width && i > 0) {
                        width = i;
                    }
                    this.f631b.post(new e(width, height));
                    return;
                }
                m.a(this.a, " container or video exist size <= 0");
                return;
            }
            m.a(this.a, "[step-1] >>>>> mContextRef=" + this.j + ",getIRenderView() =" + G());
            String str = this.a;
            boolean z = true;
            StringBuilder sbAppend = new StringBuilder().append("[step-1] >>>>> mMediaPlayerProxy == null:").append(this.e == null).append(",mMediaPlayerProxy.getMediaPlayer() == null:");
            if (this.e == null) {
                z = false;
            }
            m.a(str, sbAppend.append(z).toString());
        } catch (Throwable th) {
            m.a(this.a, "[step-11] >>>>> changeVideoSize error !!!!! ：" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bykv.vk.openvk.component.video.api.renderview.b G() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar;
        if (this.j.getResources().getConfiguration().orientation != 1 || (eVar = this.f) == null) {
            return null;
        }
        return eVar.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.S++;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
        if (eVar == null) {
            return;
        }
        eVar.e();
        b.a.a.a.a.a.a.g.c.a aVar = this.A;
        if (aVar != null) {
            aVar.b(this.H, b.a.a.a.a.a.b.f.a.a(this.h, this.C));
        }
        this.H = System.currentTimeMillis() - this.G;
        if (this.M) {
            this.f.a(this.g, (WeakReference<Context>) null, true);
        }
        if (!this.u) {
            this.u = true;
            long j = this.C;
            a(j, j);
            long j2 = this.C;
            this.h = j2;
            this.i = j2;
            a(this.P);
        }
        if (!this.n && this.r) {
            d(this.f, null);
        }
        this.m = true;
    }

    private void J() {
        m.c(this.a, "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.l));
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            if (dVar.i()) {
                if (this.l) {
                    r();
                } else {
                    a(this.D);
                }
                m.c(this.a, "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.l));
            } else {
                this.e.a(false, this.h, this.o);
            }
        }
        if (this.t.get()) {
            E();
        }
    }

    public void I() {
        if (this.W || !this.v) {
            return;
        }
        Context applicationContext = o.a().getApplicationContext();
        this.W = true;
        w.a(this.U, applicationContext);
    }

    public void K() {
        com.bytedance.sdk.openadsdk.core.i0.f fVar = this.B;
        if (fVar != null) {
            fVar.a(13);
        }
    }

    public void L() {
        if (this.W && this.v) {
            this.W = false;
            w.a(this.U);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void e() {
        a(true, 3);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void f() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
        if (eVar != null) {
            eVar.c();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar2 = this.f;
        if (eVar2 != null) {
            eVar2.r();
        }
        J();
    }

    public void g(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
        if (eVar != null) {
            eVar.c();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar2 = this.f;
        if (eVar2 != null && z) {
            eVar2.r();
        }
        J();
    }

    public void h(boolean z) {
        this.M = z;
    }

    private void e(int i) {
        if (this.V == i) {
            return;
        }
        this.V = i;
        if (i != 4 && i != 0) {
            this.q = false;
        }
        if (!this.q && !n() && this.K) {
            c(2, i);
        }
        WeakReference<g> weakReference = this.O;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.O.get().c(this.V);
    }

    private void c(b.a.a.a.a.a.a.f.c cVar) {
        m.a(this.a, "[video] playVideo has invoke !");
        cVar.d(0);
        this.e.b(cVar);
        this.G = System.currentTimeMillis();
        this.f.e(8);
        this.f.e(0);
        b(new RunnableC0217c());
        if (this.n) {
            I();
        }
    }

    public void b(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        m.a(this.a, "width=" + i + "height=" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        e(i);
        if (i == 4) {
            this.p = false;
        }
    }

    public void a(NativeVideoTsView.h hVar) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar;
        if (!this.n || (eVar = this.f) == null) {
            return;
        }
        eVar.a(new b(this, hVar));
    }

    public void g(int i) {
        e(i);
        if (i == 4) {
            this.p = false;
            f();
        }
    }

    public void a(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar;
        if (!this.n || (eVar = this.f) == null) {
            return;
        }
        eVar.a(pAGNativeAd);
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar) {
        this.Q = bVar;
    }

    private void a(Context context) {
        ViewGroup tTVideoDetailLayout;
        if (this.n) {
            tTVideoDetailLayout = new TTVideoPlayLayoutForLiveLayout(context);
        } else {
            tTVideoDetailLayout = new TTVideoDetailLayout(context);
        }
        ViewGroup viewGroup = tTVideoDetailLayout;
        if (this.n) {
            this.f = new com.bytedance.sdk.openadsdk.core.video.nativevideo.e(context, viewGroup, true, 17, this.g, this, s());
        } else {
            this.f = new com.bytedance.sdk.openadsdk.core.video.nativevideo.d(context, viewGroup, true, 17, this.g, this, false);
        }
        this.f.a(this);
    }

    /* JADX INFO: compiled from: NativeVideoController.java */
    class a implements b.a.a.a.a.a.a.a.InterfaceC0007a {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeVideoController.java */
        class RunnableC0215a implements Runnable {
            RunnableC0215a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.H();
                com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, 5);
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.a(9);
                }
            }
        }

        /* JADX INFO: compiled from: NativeVideoController.java */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.e();
                }
                if (!((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).n || c.this.O == null || c.this.O.get() == null) {
                    return;
                }
                ((g) c.this.O.get()).d();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.c$a$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeVideoController.java */
        class RunnableC0216c implements Runnable {
            RunnableC0216c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.N != null && c.this.N.get() != null) {
                    ((b.a.a.a.a.a.a.g.c.d) c.this.N.get()).l();
                }
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.e();
                }
            }
        }

        /* JADX INFO: compiled from: NativeVideoController.java */
        class d implements Runnable {
            final /* synthetic */ b.a.a.a.a.a.a.f.a a;

            d(b.a.a.a.a.a.a.f.a aVar) {
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int iA = this.a.a();
                int iB = this.a.b();
                if (!c.this.z() || iB == -1004) {
                    if (c.this.a(iA, iB)) {
                        m.b(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).a, "Play video error，show result page、、、、、、、");
                        ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, (WeakReference<Context>) null, false);
                        c.this.a(true);
                        c.this.c();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f != null) {
                        ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.e();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).A != null) {
                        ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).A.a(c.this.H, b.a.a.a.a.a.b.f.a.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).h, ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).C));
                    }
                    if (c.this.N == null || c.this.N.get() == null || c.this.z()) {
                        return;
                    }
                    ((b.a.a.a.a.a.a.g.c.d) c.this.N.get()).a(iA, iB);
                }
            }
        }

        /* JADX INFO: compiled from: NativeVideoController.java */
        class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.e();
                }
            }
        }

        /* JADX INFO: compiled from: NativeVideoController.java */
        class f implements Runnable {
            f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.F();
            }
        }

        /* JADX INFO: compiled from: NativeVideoController.java */
        class g implements Runnable {
            g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f != null) {
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.x();
                    ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.postDelayed(c.this.T, 8000L);
                }
            }
        }

        /* JADX INFO: compiled from: NativeVideoController.java */
        class h implements Runnable {
            h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f.e();
            }
        }

        /* JADX INFO: compiled from: NativeVideoController.java */
        class i implements Runnable {
            final /* synthetic */ long a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f682b;

            i(long j, long j2) {
                this.a = j;
                this.f682b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.a, this.f682b);
            }
        }

        a() {
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, long j) {
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).x = false;
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.removeCallbacks(c.this.T);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new b());
            c.this.B();
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, 0);
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.g();
            }
            c cVar = c.this;
            cVar.b(cVar.P);
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void b(b.a.a.a.a.a.a.a aVar) {
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void b(b.a.a.a.a.a.a.a aVar, int i2) {
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void c(b.a.a.a.a.a.a.a aVar) {
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.removeCallbacks(c.this.T);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new RunnableC0216c());
            if (!c.this.I) {
                c cVar = c.this;
                cVar.b(cVar.P);
            }
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.a(c.this.a(), c.this.i());
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void d(b.a.a.a.a.a.a.a aVar) {
            com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g.M0();
            if (aVarM0 != null && aVarM0.m() != null) {
                aVarM0.m().f(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).h);
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, 3);
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.a(0);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void e(b.a.a.a.a.a.a.a aVar) {
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new RunnableC0215a());
            c.this.b(4);
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g.M0() == null || ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g.M0().m() == null) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g.M0().m().c(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).h);
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, b.a.a.a.a.a.a.f.a aVar2) {
            m.b(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).a, "onError: " + aVar2.a() + ", " + aVar2.b() + ", " + aVar2.c());
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new d(aVar2));
            c.this.a(aVar2);
            com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g.M0();
            if (aVarM0 != null && aVarM0.m() != null) {
                aVarM0.m().a(com.bytedance.sdk.openadsdk.core.i0.k.a.GENERAL_LINEAR_AD_ERROR);
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, 6);
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.a(14);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, boolean z) {
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new e());
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i2, int i3) {
            com.bytedance.sdk.component.utils.i.a().post(new f());
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i2, int i3, int i4) {
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).x = true;
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new g());
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, 2);
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.a(4);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, int i2) {
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).x = false;
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.removeCallbacks(c.this.T);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new h());
            com.bytedance.sdk.openadsdk.q.c.e.a(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g, 0);
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.a(5);
            }
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar, long j, long j2) {
            if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).h) < 50) {
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.P);
            ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).f631b.post(new i(j, j2));
        }

        @Override // b.a.a.a.a.a.a.a.InterfaceC0007a
        public void a(b.a.a.a.a.a.a.a aVar) {
            com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).g.M0();
            if (aVarM0 != null && aVarM0.m() != null) {
                aVarM0.m().g(((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).h);
            }
            if (((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B != null) {
                ((com.bytedance.sdk.openadsdk.core.j0.a.a) c.this).B.a(1);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.i0.f a(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.g.k1()) {
            return null;
        }
        if (this.B == null) {
            this.B = com.bytedance.sdk.openadsdk.core.i0.f.a();
        }
        this.B.a(view, this.g.M0().i());
        if (list != null && list.size() > 0) {
            for (Pair<View, FriendlyObstructionPurpose> pair : list) {
                if (pair != null) {
                    Object obj = pair.second;
                    this.B.a((View) pair.first, obj == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) obj);
                }
            }
        }
        return this.B;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void c() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            dVar.A();
            this.e = null;
        }
        if (this.M) {
            if (!"embeded_ad".equals(this.J)) {
                this.f.a(this.g, (WeakReference<Context>) null, true);
            } else {
                this.f.s();
            }
            this.f631b.removeCallbacksAndMessages(null);
            this.k.clear();
            if (this.n) {
                L();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.a.a, b.a.a.a.a.a.a.g.c
    public void a(b.a.a.a.a.a.a.g.c.d dVar) {
        this.N = new WeakReference<>(dVar);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean a(b.a.a.a.a.a.a.f.c cVar) {
        if (this.e != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        }
        if (TextUtils.isEmpty(cVar.m())) {
            m.b(this.a, "[video] play video stop , because no video info");
            return false;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar = this.Q;
        if (bVar != null) {
            bVar.a();
        }
        a(false);
        m.a(this.a, "url is " + cVar.m());
        b(cVar);
        D();
        com.bytedance.sdk.openadsdk.core.i0.f fVar = this.B;
        if (fVar != null) {
            fVar.a(false, 0.0f);
        }
        if (!com.bytedance.sdk.openadsdk.core.nativeexpress.p.b(this.J) || this.h <= 0) {
            this.h = cVar.d();
        }
        if (cVar.d() <= 0) {
            this.u = false;
            this.t.set(false);
        } else {
            long jD = cVar.d();
            this.h = jD;
            this.i = Math.max(this.i, jD);
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
        if (eVar != null) {
            eVar.c();
            if (this.S == 0) {
                this.f.w();
            }
            this.f.c(cVar.q(), cVar.f());
            this.f.c(this.y);
            this.f.b(cVar.q(), cVar.f());
        }
        if (this.e == null) {
            com.bytedance.sdk.openadsdk.core.j0.c.d dVar = new com.bytedance.sdk.openadsdk.core.j0.c.d();
            this.e = dVar;
            dVar.a(this.R);
        }
        v();
        this.H = 0L;
        try {
            c(cVar);
            return true;
        } catch (Exception e2) {
            m.b(this.a, "[video] invoke NativeVideoController#playVideo cause exception :" + e2);
            return false;
        }
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
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
            if (eVar != null) {
                eVar.c(this.y);
            }
            d(this.h);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar2 = this.f;
            if (eVar2 != null) {
                eVar2.b(false, false);
                return;
            }
            return;
        }
        g(false);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar3 = this.f;
        if (eVar3 != null) {
            eVar3.b(false, false);
        }
    }

    private boolean c(int i, int i2) {
        if (i2 == 0) {
            d();
            this.p = true;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
            if (eVar != null) {
                eVar.a(this.g, (WeakReference<Context>) null, false);
            }
        }
        if (i2 != 4 && i2 != 0) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar2 = this.f;
            if (eVar2 != null) {
                eVar2.c();
            }
            d();
            this.p = true;
            this.q = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar3 = this.f;
            if (eVar3 != null) {
                return eVar3.a(i, this.g.N0(), this.L);
            }
        } else if (i2 == 4) {
            this.p = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar4 = this.f;
            if (eVar4 != null) {
                eVar4.j();
            }
        }
        return true;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(boolean z, int i) {
        if (this.n) {
            b(1);
        }
        if (!this.u && this.t.get()) {
            if (z) {
                com.bytedance.sdk.openadsdk.d.r.b.o.a aVar = new com.bytedance.sdk.openadsdk.d.r.b.o.a();
                aVar.b(o());
                aVar.c(a());
                aVar.a(l());
                aVar.a(i);
                aVar.b(j());
                com.bytedance.sdk.openadsdk.d.r.a.a.a(this.f, aVar, this.P);
                this.u = false;
            } else {
                C();
            }
        }
        c();
        com.bytedance.sdk.openadsdk.core.i0.f fVar = this.B;
        if (fVar != null) {
            fVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        this.g.b(j);
        this.h = j;
        this.C = j2;
        this.f.a(j, j2);
        this.f.d(b.a.a.a.a.a.b.f.a.a(j, j2));
        try {
            b.a.a.a.a.a.a.g.c.a aVar = this.A;
            if (aVar != null) {
                aVar.a(j, j2);
            }
        } catch (Throwable th) {
            m.b(this.a, "onProgressUpdate error: ", th);
        }
        com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = this.g.M0();
        if (aVarM0 == null || aVarM0.m() == null) {
            return;
        }
        aVarM0.m().a(j, j2, this.B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.a.a
    public void a(b.a.a.a.a.a.a.g.b bVar, View view, boolean z) {
        f(!this.r);
        if (!(this.j instanceof Activity)) {
            m.a(this.a, "context is not activity, not support this function.");
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = this.f;
        if (eVar != null) {
            eVar.b(this.y);
            this.f.c(false);
        }
        c(1);
        WeakReference<b.a.a.a.a.a.a.g.c.b> weakReference = this.z;
        b.a.a.a.a.a.a.g.c.b bVar2 = weakReference != null ? weakReference.get() : null;
        if (bVar2 != null) {
            bVar2.a(this.r);
        }
    }

    public void a(g gVar) {
        this.O = new WeakReference<>(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int i2) {
        m.a(this.a, "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }
}
