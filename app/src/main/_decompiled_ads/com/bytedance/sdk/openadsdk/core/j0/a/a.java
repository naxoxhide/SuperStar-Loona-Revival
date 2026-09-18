package com.bytedance.sdk.openadsdk.core.j0.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i0.f;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.d.g;
import com.bytedance.sdk.openadsdk.d.r.b.o;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: BaseController.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements b.a.a.a.a.a.a.g.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.a, y.a {
    protected b.a.a.a.a.a.a.g.c.a A;
    protected f B;
    protected long C;
    protected SurfaceHolder c;
    protected SurfaceTexture d;
    protected com.bytedance.sdk.openadsdk.core.j0.c.d e;
    protected e f;
    protected final q g;
    protected final Context j;
    protected boolean o;
    private long s;
    protected boolean u;
    protected com.bytedance.sdk.openadsdk.core.j0.a.b w;
    protected boolean x;
    protected final ViewGroup y;
    protected WeakReference<b.a.a.a.a.a.a.g.c.b> z;
    protected String a = "TTAD.VideoController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final y f631b = new y(Looper.getMainLooper(), this);
    protected long h = 0;
    protected long i = 0;
    protected final List<Runnable> k = new ArrayList();
    protected boolean l = false;
    protected boolean m = false;
    protected boolean n = true;
    protected boolean p = false;
    protected boolean q = false;
    protected boolean r = false;
    protected AtomicBoolean t = new AtomicBoolean(false);
    protected boolean v = true;
    protected Runnable D = new RunnableC0205a();
    private boolean E = true;
    private int F = 1;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseController.java */
    class RunnableC0205a implements Runnable {
        RunnableC0205a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            m.c(aVar.a, "resumeVideo: run ", Boolean.valueOf(aVar.l));
            a.this.r();
        }
    }

    /* JADX INFO: compiled from: BaseController.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.e != null) {
                m.c(aVar.a, "resumeVideo: execResumePlay", Boolean.valueOf(aVar.l));
                a.this.e.y();
            }
        }
    }

    /* JADX INFO: compiled from: BaseController.java */
    class c implements Runnable {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B.a(this.a);
        }
    }

    /* JADX INFO: compiled from: BaseController.java */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.widget.e.b.values().length];
            a = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.widget.e.b.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.bytedance.sdk.openadsdk.core.widget.e.b.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.bytedance.sdk.openadsdk.core.widget.e.b.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(Context context, q qVar, ViewGroup viewGroup) {
        this.g = qVar;
        this.j = context;
        this.y = viewGroup;
        this.a += hashCode();
    }

    private void A() {
        e eVar = this.f;
        if (eVar != null) {
            eVar.f(0);
            this.f.a(false, false);
            this.f.c(false);
            this.f.v();
            this.f.w();
        }
    }

    private boolean x() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar.k() instanceof SSRenderTextureView;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B() {
        com.bytedance.sdk.openadsdk.d.p.d.a(com.bytedance.sdk.openadsdk.q.a.a(this.g.q0(), true, this.g));
    }

    protected final void C() {
        o.a aVar = new o.a();
        aVar.b(o());
        aVar.c(a() / ((long) t()));
        aVar.a(l());
        com.bytedance.sdk.openadsdk.d.r.a.a.c(this.f, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D() {
        com.bytedance.sdk.openadsdk.d.r.a.a.a(this.g, this.f, this.w);
    }

    protected final void E() {
        o.a aVar = new o.a();
        aVar.b(o());
        aVar.c(a() / ((long) t()));
        aVar.a(l());
        com.bytedance.sdk.openadsdk.d.r.a.a.b(g(), aVar);
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
    }

    @Override // b.a.a.a.a.a.a.g.a
    public void a(b.a.a.a.a.a.a.g.b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // b.a.a.a.a.a.a.g.a
    public void a(b.a.a.a.a.a.a.g.b bVar, View view) {
    }

    public void a(b.a.a.a.a.a.a.g.b bVar, View view, boolean z) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(b.a.a.a.a.a.a.g.c.d dVar) {
    }

    protected void a(Runnable runnable) {
        this.k.add(runnable);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final void a(Map<String, Object> map) {
    }

    public final void b(int i) {
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void b(long j) {
    }

    protected void b(Runnable runnable) {
        if (this.f.q() && this.l) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void c(long j) {
        this.h = j;
        this.i = Math.max(this.i, j);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void d(boolean z) {
        this.n = z;
        e eVar = this.f;
        if (eVar != null) {
            eVar.b(z);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final void e(boolean z) {
        this.o = z;
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            dVar.a(z);
        }
        if (this.B != null) {
            if (b.a.a.a.a.a.b.d.a.b()) {
                this.B.a(z);
            } else {
                this.f631b.post(new c(z));
            }
        }
    }

    protected void f(boolean z) {
        this.r = z;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public b.a.a.a.a.a.a.a h() {
        return this.e;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean i() {
        return this.o;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean isUseTextureView() {
        int i = Build.VERSION.SDK_INT;
        if (i < 14) {
            return false;
        }
        q qVar = this.g;
        if (qVar != null && qVar.u0() == 1 && i < 23) {
            return true;
        }
        if ((r.w() && i >= 30) || t.a(this.g) || h.t() || "Pixel 4".equals(Build.MODEL)) {
            return true;
        }
        return h.a().u();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final int j() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar == null) {
            return 0;
        }
        return dVar.m();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final long k() {
        return o() + l();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final long l() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar == null) {
            return 0L;
        }
        return dVar.q();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final int m() {
        return b.a.a.a.a.a.b.f.a.a(this.i, this.C);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean n() {
        return this.m;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public long o() {
        return this.h;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public boolean p() {
        return this.p;
    }

    protected void q() {
        m.d(this.a, "execPendingActions: before ");
        if (this.k.isEmpty()) {
            return;
        }
        m.d(this.a, "execPendingActions:  exec");
        Iterator it = new ArrayList(this.k).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.k.clear();
    }

    protected void r() {
        this.f631b.postAtFrontOfQueue(new b());
    }

    public boolean s() {
        return this.n;
    }

    public int t() {
        return this.F;
    }

    @Override // b.a.a.a.a.a.a.g.c
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final e g() {
        return this.f;
    }

    protected void v() {
        if (this.e == null) {
            return;
        }
        if (x()) {
            SurfaceTexture surfaceTexture = this.d;
            if (surfaceTexture == null || surfaceTexture == this.e.p()) {
                return;
            }
            this.e.a(this.d);
            return;
        }
        SurfaceHolder surfaceHolder = this.c;
        if (surfaceHolder == null || surfaceHolder == this.e.o()) {
            return;
        }
        this.e.a(this.c);
    }

    public boolean w() {
        return this.E;
    }

    public final boolean y() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        return dVar == null || dVar.d();
    }

    public final boolean z() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        return dVar != null && dVar.h();
    }

    @Override // b.a.a.a.a.a.a.g.a
    public void a(b.a.a.a.a.a.a.g.b bVar, SurfaceHolder surfaceHolder) {
        this.l = false;
        this.c = null;
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            dVar.b(false);
        }
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void f(b.a.a.a.a.a.a.g.b bVar, View view) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.t();
        }
        a(true, 3);
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void c(boolean z) {
        this.v = z;
    }

    public final void c(int i) {
        Context context = this.j;
        if (context == null) {
            return;
        }
        boolean z = i == 0 || i == 8;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            try {
                activity.setRequestedOrientation(i);
            } catch (Throwable unused) {
            }
            if (!z) {
                activity.getWindow().setFlags(1024, 1024);
            } else {
                activity.getWindow().clearFlags(1024);
            }
        }
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void d(b.a.a.a.a.a.a.g.b bVar, View view) {
        a(bVar, view, false);
    }

    @Override // b.a.a.a.a.a.a.g.a
    public void b(b.a.a.a.a.a.a.g.b bVar, SurfaceHolder surfaceHolder) {
        this.l = true;
        this.c = surfaceHolder;
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceHolder);
        m.d(this.a, "surfaceCreated: ");
        q();
    }

    public void d(int i) {
        this.F = i;
    }

    @Override // b.a.a.a.a.a.a.g.a
    public void a(b.a.a.a.a.a.a.g.b bVar, SurfaceTexture surfaceTexture) {
        this.l = false;
        m.d(this.a, "surfaceTextureDestroyed: ");
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            dVar.b(false);
        }
        this.d = null;
        q();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final void d() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            dVar.w();
        }
        if (this.u || !this.t.get()) {
            return;
        }
        C();
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void e(b.a.a.a.a.a.a.g.b bVar, View view) {
        b(bVar, view, false, false);
    }

    public final void d(long j) {
        this.h = j;
        this.i = Math.max(this.i, j);
        e eVar = this.f;
        if (eVar != null) {
            eVar.c();
        }
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            dVar.a(true, this.h, this.o);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void a(long j) {
        this.C = j;
    }

    @Override // b.a.a.a.a.a.a.g.a
    public void b(b.a.a.a.a.a.a.g.b bVar, SurfaceTexture surfaceTexture) {
        this.l = true;
        this.d = surfaceTexture;
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null) {
            dVar.a(surfaceTexture);
            this.e.b(this.l);
        }
        m.d(this.a, "surfaceTextureCreated: ");
        q();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final long a() {
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar == null) {
            return 0L;
        }
        return dVar.r();
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final void a(boolean z) {
        this.m = z;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final void a(b.a.a.a.a.a.a.g.c.b bVar) {
        this.z = new WeakReference<>(bVar);
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void a(b.a.a.a.a.a.a.g.b bVar, View view, boolean z, boolean z2) {
        if (this.n) {
            d();
        }
        if (z && !this.n && !y()) {
            this.f.b(!z(), false);
            this.f.a(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.j0.c.d dVar = this.e;
        if (dVar != null && dVar.h()) {
            this.f.u();
            this.f.v();
        } else {
            this.f.u();
        }
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final void b(boolean z) {
        this.E = z;
    }

    @Override // b.a.a.a.a.a.a.g.c
    public void b(b.a.a.a.a.a.a.f.c cVar) {
        com.bytedance.sdk.openadsdk.core.j0.a.b bVar = (com.bytedance.sdk.openadsdk.core.j0.a.b) cVar;
        this.w = bVar;
        this.o = bVar.v();
        cVar.d(String.valueOf(this.g.S()));
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final boolean b() {
        return this.x;
    }

    public final void b(b.a.a.a.a.a.a.g.b bVar, View view, boolean z, boolean z2) {
        f(!this.r);
        Context context = this.j;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            m.a(this.a, "context is not activity, not support this function.");
            return;
        }
        if (this.r) {
            c(z ? 8 : 0);
            e eVar = this.f;
            if (eVar != null) {
                eVar.a(this.y);
                this.f.c(false);
            }
        } else {
            c(1);
            e eVar2 = this.f;
            if (eVar2 != null) {
                eVar2.b(this.y);
                this.f.c(false);
            }
        }
        WeakReference<b.a.a.a.a.a.a.g.c.b> weakReference = this.z;
        b.a.a.a.a.a.a.g.c.b bVar2 = weakReference != null ? weakReference.get() : null;
        if (bVar2 != null) {
            bVar2.a(this.r);
        }
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void a(b.a.a.a.a.a.a.g.b bVar, int i, boolean z) {
        Context context = this.j;
        if (context == null) {
            return;
        }
        long jI = (long) (((((long) i) * this.C) * 1.0f) / com.bytedance.sdk.component.utils.t.i(context, "tt_video_progress_max"));
        if (this.C > 0) {
            this.s = (int) jI;
        } else {
            this.s = 0L;
        }
        e eVar = this.f;
        if (eVar != null) {
            eVar.a(this.s);
        }
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void a(b.a.a.a.a.a.a.g.b bVar, int i) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.u();
        }
    }

    private void a(long j, boolean z) {
        if (this.e == null) {
            return;
        }
        if (z) {
            A();
        }
        this.e.b(j);
    }

    private boolean a(int i) {
        return this.f.b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(g gVar) {
        o.a aVar = new o.a();
        aVar.b(o());
        aVar.c(a() / ((long) t()));
        aVar.a(l());
        aVar.b(j());
        com.bytedance.sdk.openadsdk.d.r.a.a.b(this.f, aVar, gVar);
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void b(b.a.a.a.a.a.a.g.b bVar, View view) {
        if (this.r) {
            f(false);
            e eVar = this.f;
            if (eVar != null) {
                eVar.b(this.y);
            }
            c(1);
            return;
        }
        a(true, 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(b.a.a.a.a.a.a.f.a aVar) {
        o.a aVar2 = new o.a();
        aVar2.a(l());
        aVar2.c(a() / ((long) t()));
        aVar2.b(o());
        aVar2.a(aVar);
        com.bytedance.sdk.openadsdk.d.r.a.a.e(g(), aVar2);
    }

    @Override // b.a.a.a.a.a.a.g.a
    public final void b(b.a.a.a.a.a.a.g.b bVar, int i) {
        if (this.e == null) {
            return;
        }
        a(this.s, a(i));
    }

    @Override // b.a.a.a.a.a.a.g.c
    public final void a(b.a.a.a.a.a.a.g.c.a aVar) {
        this.A = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public final void a(com.bytedance.sdk.openadsdk.core.widget.e.b bVar, String str) {
        int i = d.a[bVar.ordinal()];
        if (i == 1) {
            d();
            return;
        }
        if (i == 2) {
            e();
        } else {
            if (i != 3) {
                return;
            }
            f();
            this.p = false;
            this.q = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(g gVar) {
        if (this.t.compareAndSet(false, true)) {
            o.a aVar = new o.a();
            aVar.a(w());
            aVar.c(a());
            com.bytedance.sdk.openadsdk.d.r.a.a.a(com.bytedance.sdk.openadsdk.core.o.a(), this.f, aVar, gVar);
        }
    }
}
