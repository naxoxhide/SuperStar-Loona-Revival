package b.a.a.a.a.a.b.e;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.component.utils.y;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements y.a, b.a.a.a.a.a.b.e.c.e, b.a.a.a.a.a.b.e.c.b, b.a.a.a.a.a.b.e.c.InterfaceC0019c, b.a.a.a.a.a.b.e.c.g, b.a.a.a.a.a.b.e.c.a, b.a.a.a.a.a.b.e.c.f, b.a.a.a.a.a.b.e.c.d, b.a.a.a.a.a.a.a {
    private static final SparseIntArray J = new SparseIntArray();
    private volatile boolean F;
    private boolean I;
    private SurfaceTexture a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SurfaceHolder f60b;
    private int d;
    private boolean h;
    private boolean i;
    private boolean s;
    private ArrayList<Runnable> t;
    private int u;
    private String v;
    private boolean w;
    private int c = 0;
    private boolean e = false;
    private volatile b.a.a.a.a.a.b.e.c f = null;
    private boolean g = false;
    private volatile int j = 201;
    private long k = -1;
    private boolean m = false;
    private long n = 0;
    private long o = Long.MIN_VALUE;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private final List<WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a>> x = new CopyOnWriteArrayList();
    private b.a.a.a.a.a.a.f.c y = null;
    private boolean z = false;
    private volatile int A = 200;
    private AtomicBoolean B = new AtomicBoolean(false);
    private Surface C = null;
    private final Runnable D = new h();
    private final o E = new o();
    private long G = 0;
    private long H = 0;
    private y l = b.b.a.a.k.i.a.a().b(this, "csj_SSMediaPlayerWrapper");

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class a implements Runnable {
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.l != null) {
                d.this.l.obtainMessage(106, Long.valueOf(this.a)).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class b implements Runnable {
        final /* synthetic */ SurfaceTexture a;

        b(SurfaceTexture surfaceTexture) {
            this.a = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setSurface() runnable exec");
            d.this.t();
            if (d.this.l != null) {
                d.this.l.obtainMessage(111, this.a).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class c implements Runnable {
        final /* synthetic */ SurfaceHolder a;

        c(SurfaceHolder surfaceHolder) {
            this.a = surfaceHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setDisplay() runnable exec");
            d.this.t();
            if (d.this.l != null) {
                d.this.l.obtainMessage(110, this.a).sendToTarget();
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.a.a.b.e.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class RunnableC0020d implements Runnable {
        final /* synthetic */ b.a.a.a.a.a.a.f.c a;

        RunnableC0020d(b.a.a.a.a.a.a.f.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setDataSource() runnable exec ");
            d.this.t();
            if (d.this.l != null) {
                d.this.l.obtainMessage(107, this.a).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.l == null || d.this.l.getLooper() == null) {
                return;
            }
            try {
                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "onDestory............");
                b.b.a.a.k.i.a.a().a(d.this.l);
                d.this.l = null;
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "onDestroy error: ", th);
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.f.d();
                d.this.j = 207;
                d.this.F = false;
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "pauseBeforePlayIfNeed error: ", th);
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class g implements Runnable {
        final /* synthetic */ boolean a;

        g(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.g() || d.this.f == null) {
                return;
            }
            try {
                d.this.z = this.a;
                d.this.f.c(this.a);
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setQuietPlay error: ", th);
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f == null) {
                return;
            }
            long jN = d.this.n();
            if (jN > 0 && Build.VERSION.SDK_INT >= 23 && d.this.h() && d.this.o != Long.MIN_VALUE) {
                try {
                    if (d.this.o == jN) {
                        if (!d.this.m && d.this.p >= 400) {
                            d.this.a(701, 800);
                            d.this.m = true;
                        }
                        d.this.p += (long) d.this.A;
                    } else {
                        if (d.this.m) {
                            d.this.n += d.this.p;
                            d.this.a(702, 800);
                            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(d.this.n), "  bufferCount =", Integer.valueOf(d.this.c));
                        }
                        d.this.p = 0L;
                        d.this.m = false;
                    }
                } catch (Throwable th) {
                    b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (d.this.r() > 0) {
                if (d.this.o != jN) {
                    if (b.a.a.a.a.a.a.c.e()) {
                        b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(d.this.o), "  curPosition = ", Long.valueOf(jN));
                    }
                    d dVar = d.this;
                    dVar.a(jN, dVar.r());
                }
                d.this.o = jN;
            }
            if (d.this.d()) {
                d dVar2 = d.this;
                dVar2.a(dVar2.r(), d.this.r());
            } else if (d.this.l != null) {
                d.this.l.postDelayed(this, d.this.A);
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class i implements Runnable {
        final /* synthetic */ boolean a;

        i(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f != null) {
                d.this.f.d(this.a);
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f == null) {
                try {
                    d.this.f = new b.a.a.a.a.a.b.e.b();
                } catch (Throwable th) {
                    b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", th.getMessage());
                }
                if (d.this.f == null) {
                    return;
                }
                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "initMediaPlayer mMediaPlayer is null :" + (d.this.f == null));
                d.this.v = "0";
                d.this.f.a((b.a.a.a.a.a.b.e.c.e) d.this);
                d.this.f.a((b.a.a.a.a.a.b.e.c.b) d.this);
                d.this.f.a((b.a.a.a.a.a.b.e.c.InterfaceC0019c) d.this);
                d.this.f.a((b.a.a.a.a.a.b.e.c.a) d.this);
                d.this.f.a((b.a.a.a.a.a.b.e.c.f) d.this);
                d.this.f.a((b.a.a.a.a.a.b.e.c.d) d.this);
                d.this.f.a((b.a.a.a.a.a.b.e.c.g) d.this);
                try {
                    d.this.f.b(false);
                } catch (Throwable th2) {
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setLooping error: ", th2);
                }
                d.this.g = false;
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.i() || d.this.f == null) {
                return;
            }
            try {
                d.this.f.f();
                b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_MEDIA", "resume play exec start ");
                for (WeakReference weakReference : d.this.x) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((b.a.a.a.a.a.a.a.InterfaceC0007a) weakReference.get()).a(d.this);
                    }
                }
                d.this.j = 206;
            } catch (Throwable th) {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.l != null) {
                d.this.l.sendEmptyMessage(101);
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.l != null) {
                d.this.l.sendEmptyMessage(101);
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.l != null) {
                d.this.l.sendEmptyMessage(104);
                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
            }
        }
    }

    /* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
    class o implements Runnable {
        private long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f67b;

        o() {
        }

        public void a(boolean z) {
            this.f67b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f != null) {
                try {
                    if (!this.f67b) {
                        d.this.k = Math.max(this.a, d.this.f.h());
                    }
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start, OpStartTask:" + d.this.k);
                } catch (Throwable th) {
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th);
                }
            }
            if (d.this.l != null) {
                d.this.l.sendEmptyMessageDelayed(100, 0L);
            }
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
        }

        public void a(long j) {
            this.a = j;
        }
    }

    public d() {
        this.u = 0;
        this.I = false;
        this.u = 0;
        this.I = Build.VERSION.SDK_INT >= 17;
        t();
    }

    private void B() {
        b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.f == null) {
            return;
        }
        try {
            this.f.i();
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "releaseMediaplayer error1: ", th);
        }
        this.f.a((b.a.a.a.a.a.b.e.c.b) null);
        this.f.a((b.a.a.a.a.a.b.e.c.g) null);
        this.f.a((b.a.a.a.a.a.b.e.c.a) null);
        this.f.a((b.a.a.a.a.a.b.e.c.d) null);
        this.f.a((b.a.a.a.a.a.b.e.c.InterfaceC0019c) null);
        this.f.a((b.a.a.a.a.a.b.e.c.e) null);
        this.f.a((b.a.a.a.a.a.b.e.c.f) null);
        try {
            this.f.release();
        } catch (Throwable th2) {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "releaseMediaplayer error2: ", th2);
        }
    }

    private void C() {
        this.n = 0L;
        this.c = 0;
        this.p = 0L;
        this.m = false;
        this.o = Long.MIN_VALUE;
    }

    private void l() {
        if (this.h) {
            return;
        }
        this.h = true;
        Iterator it = new ArrayList(this.t).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.t.clear();
        this.h = false;
    }

    private void s() {
        SparseIntArray sparseIntArray = J;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.u));
        if (numValueOf == null) {
            sparseIntArray.put(this.u, 1);
        } else {
            sparseIntArray.put(this.u, Integer.valueOf(numValueOf.intValue() + 1).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "initMediaPlayer: " + (this.l != null));
        y yVar = this.l;
        if (yVar != null) {
            yVar.post(new j());
        }
    }

    private void v() {
        y yVar = this.l;
        if (yVar == null || yVar.getLooper() == null) {
            return;
        }
        this.l.post(new e());
    }

    private void x() {
        y yVar = this.l;
        if (yVar != null) {
            yVar.post(new f());
        }
    }

    private void z() {
        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b(new n());
    }

    public void A() {
        if (g()) {
            return;
        }
        this.i = true;
        a();
        y yVar = this.l;
        if (yVar != null) {
            try {
                yVar.removeCallbacksAndMessages(null);
                if (this.f != null) {
                    this.l.sendEmptyMessage(103);
                }
                v();
            } catch (Throwable th) {
                try {
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "release error: ", th);
                } finally {
                    v();
                }
            }
        }
    }

    public void D() {
        if (g()) {
            return;
        }
        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#restart:" + this.j);
        if (this.f == null) {
            return;
        }
        this.B.set(true);
        if (this.j == 206) {
            return;
        }
        C();
        this.F = false;
        this.E.a(true);
        a(0L);
        y yVar = this.l;
        if (yVar != null) {
            yVar.removeCallbacks(this.D);
            this.l.postDelayed(this.D, this.A);
        }
    }

    public int m() {
        return this.c;
    }

    public long n() {
        if (g()) {
            return 0L;
        }
        if (this.j == 206 || this.j == 207) {
            try {
                return this.f.h();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public SurfaceHolder o() {
        return this.f60b;
    }

    public SurfaceTexture p() {
        return this.a;
    }

    public long q() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.H;
        }
        if (this.m) {
            long j2 = this.p;
            if (j2 > 0) {
                return this.n + j2;
            }
        }
        return this.n;
    }

    public long r() {
        long j2 = this.q;
        if (j2 != 0) {
            return j2;
        }
        if (this.j == 206 || this.j == 207) {
            try {
                this.q = this.f.a();
            } catch (Throwable unused) {
            }
        }
        return this.q;
    }

    public boolean u() {
        return this.j == 205;
    }

    public void w() {
        y yVar;
        b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (g() || (yVar = this.l) == null) {
            return;
        }
        yVar.removeMessages(100);
        this.F = true;
        if (this.I) {
            if (!this.e && !a(this.y)) {
                a(new m());
                return;
            }
            y yVar2 = this.l;
            if (yVar2 != null) {
                yVar2.sendEmptyMessage(101);
                return;
            }
            return;
        }
        if (!this.s && !a(this.y)) {
            a(new l());
            return;
        }
        y yVar3 = this.l;
        if (yVar3 != null) {
            yVar3.sendEmptyMessage(101);
        }
    }

    public void y() {
        if (g() || this.l == null) {
            return;
        }
        this.B.set(true);
        this.l.post(new k());
    }

    private void j() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.r;
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a(this, jElapsedRealtime);
            }
        }
        this.e = true;
    }

    private void k() {
        ArrayList<Runnable> arrayList = this.t;
        boolean z = arrayList == null || arrayList.isEmpty();
        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "isPendingAction:" + z);
        if (z) {
            return;
        }
        l();
    }

    @Override // b.a.a.a.a.a.a.a
    public boolean e() {
        return this.e;
    }

    @Override // b.a.a.a.a.a.a.a
    public boolean f() {
        return u() || h() || i();
    }

    @Override // b.a.a.a.a.a.a.a
    public boolean g() {
        return this.i;
    }

    @Override // b.a.a.a.a.a.a.a
    public boolean h() {
        y yVar;
        return (this.j == 206 || ((yVar = this.l) != null && yVar.hasMessages(100))) && !this.F;
    }

    @Override // b.a.a.a.a.a.a.a
    public boolean i() {
        y yVar;
        return ((this.j != 207 && !this.F) || (yVar = this.l) == null || yVar.hasMessages(100)) ? false : true;
    }

    public void b(boolean z) {
        if (g()) {
            return;
        }
        this.w = z;
        if (this.f != null) {
            this.f.d(z);
            return;
        }
        y yVar = this.l;
        if (yVar != null) {
            yVar.post(new i(z));
        }
    }

    @Override // b.a.a.a.a.a.b.e.c.b
    public void c(b.a.a.a.a.a.b.e.c cVar) {
        this.j = 209;
        J.delete(this.u);
        y yVar = this.l;
        if (yVar != null) {
            yVar.removeCallbacks(this.D);
        }
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().e(this);
            }
        }
    }

    @Override // b.a.a.a.a.a.a.a
    public boolean d() {
        return this.j == 209;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3) {
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a(this, j2, j3);
            }
        }
    }

    @Override // b.a.a.a.a.a.a.a
    public int c() {
        if (this.f == null || g()) {
            return 0;
        }
        return this.f.c();
    }

    public void a(boolean z, long j2, boolean z2) {
        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j2 + ",isFirst :" + z + ",isPauseOtherMusicVolume=" + z2 + " " + this.j + " " + (this.f == null));
        if (g()) {
            return;
        }
        t();
        this.z = z2;
        this.B.set(true);
        this.F = false;
        a(z2);
        if (z) {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] first start , SSMediaPlayer  start method !");
            this.k = j2;
            z();
        } else {
            a(j2);
        }
        y yVar = this.l;
        if (yVar != null) {
            yVar.removeCallbacks(this.D);
            this.l.postDelayed(this.D, this.A);
        }
    }

    public void b(long j2) {
        if (g()) {
            return;
        }
        if (this.j == 207 || this.j == 206 || this.j == 209) {
            b(new a(j2));
        }
    }

    public void b(b.a.a.a.a.a.a.f.c cVar) {
        if (g()) {
            return;
        }
        this.y = cVar;
        if (cVar != null) {
            this.I = this.I && !cVar.s();
        }
        b(new RunnableC0020d(cVar));
    }

    @Override // b.a.a.a.a.a.b.e.c.InterfaceC0019c
    public boolean b(b.a.a.a.a.a.b.e.c cVar, int i2, int i3) {
        b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "what=" + i2 + "extra=" + i3);
        s();
        this.j = 200;
        y yVar = this.l;
        if (yVar != null) {
            yVar.removeCallbacks(this.D);
        }
        if (b(i2, i3)) {
            v();
        }
        if (!this.B.get()) {
            return true;
        }
        this.B.set(false);
        b.a.a.a.a.a.a.f.a aVar = new b.a.a.a.a.a.a.f.a(i2, i3);
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a(this, aVar);
            }
        }
        return true;
    }

    private void a(long j2) {
        this.E.a(j2);
        if (this.w) {
            b(this.E);
        } else if (a(this.y)) {
            b(this.E);
        } else {
            a(this.E);
        }
    }

    private boolean a(b.a.a.a.a.a.a.f.c cVar) {
        return cVar != null && cVar.s();
    }

    public void a(SurfaceTexture surfaceTexture) {
        if (g()) {
            return;
        }
        this.a = surfaceTexture;
        b(true);
        b(new b(surfaceTexture));
    }

    private boolean b(int i2, int i3) {
        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z;
    }

    @Override // b.a.a.a.a.a.b.e.c.f
    public void b(b.a.a.a.a.a.b.e.c cVar) {
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a((b.a.a.a.a.a.a.a) this, true);
            }
        }
    }

    private void b(Runnable runnable) {
        if (runnable == null || g()) {
            return;
        }
        if (!this.i) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (g()) {
            return;
        }
        this.f60b = surfaceHolder;
        b(true);
        b(new c(surfaceHolder));
    }

    /* JADX WARN: Code duplicated, block: B:131:0x02ee  */
    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        int i2 = this.j;
        int i3 = message.what;
        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video]  execute , mCurrentState = " + this.j + " handlerMsg=" + i3);
        boolean z = false;
        if (this.f != null) {
            switch (message.what) {
                case 100:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_START");
                    if (this.j == 205 || this.j == 207 || this.j == 209) {
                        try {
                            this.f.f();
                            this.r = SystemClock.elapsedRealtime();
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] OP_START execute , mMediaPlayer real start !");
                            this.j = 206;
                            if (this.k > 0) {
                                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] OP_START, seekTo:" + this.k);
                                this.f.a(this.k, this.d);
                                this.k = -1L;
                            }
                            if (this.y != null) {
                                a(this.z);
                            }
                        } catch (Throwable th) {
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_START error: ", th);
                        }
                    } else {
                        z = true;
                    }
                    break;
                case 101:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_PAUSE");
                    if (this.m) {
                        this.n += this.p;
                    }
                    this.m = false;
                    this.p = 0L;
                    this.o = Long.MIN_VALUE;
                    if (this.j == 206 || this.j == 207 || this.j == 209) {
                        try {
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.f.d();
                            this.j = 207;
                            this.F = false;
                            for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get().d(this);
                                }
                            }
                        } catch (Throwable th2) {
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_PAUSE error: ", th2);
                        }
                    } else {
                        z = true;
                    }
                    break;
                case 102:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_RESET");
                    try {
                        this.f.i();
                        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] OP_RESET execute!");
                        this.j = 201;
                    } catch (Throwable th3) {
                        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_RESET error: ", th3);
                    }
                    break;
                case 103:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_RELEASE");
                    try {
                        B();
                        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] OP_RELEASE execute , releaseMediaplayer !");
                    } catch (Throwable th4) {
                        b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th4);
                    }
                    for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference2 : this.x) {
                        if (weakReference2 != null && weakReference2.get() != null) {
                            weakReference2.get().b(this);
                        }
                    }
                    this.j = 203;
                    break;
                case 104:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC");
                    if (this.j == 202 || this.j == 208) {
                        try {
                            this.f.g();
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                        } catch (Throwable th5) {
                            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th5);
                        }
                    } else {
                        z = true;
                    }
                    break;
                case 105:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_STOP");
                    if (this.j == 205 || this.j == 206 || this.j == 208 || this.j == 207 || this.j == 209) {
                        try {
                            this.f.e();
                            this.j = 208;
                        } catch (Throwable th6) {
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_STOP error: ", th6);
                        }
                    } else {
                        z = true;
                    }
                    break;
                case 106:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SEEKTO");
                    if (this.j == 206 || this.j == 207 || this.j == 209) {
                        try {
                            this.f.a(((Long) message.obj).longValue(), this.d);
                        } catch (Throwable th7) {
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SEEKTO error: ", th7);
                        }
                    } else {
                        z = true;
                    }
                    break;
                case 107:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SET_DATASOURCE");
                    C();
                    if (this.j == 201 || this.j == 203) {
                        try {
                            b.a.a.a.a.a.a.f.c cVar = (b.a.a.a.a.a.a.f.c) message.obj;
                            if (TextUtils.isEmpty(cVar.b())) {
                                cVar.c(b.a.a.a.a.a.a.c.d());
                            }
                            File file = new File(cVar.b(), cVar.e());
                            if (file.exists()) {
                                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setDataSource： try paly local:" + file.getAbsolutePath());
                                if (b.a.a.a.a.a.a.c.f()) {
                                    a(file.getAbsolutePath());
                                } else {
                                    this.f.a(file.getAbsolutePath());
                                }
                            } else {
                                b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setDataSource： paly net:" + cVar.m());
                                if (cVar.i == 1 && Build.VERSION.SDK_INT < 23) {
                                    this.f.a(cVar.m());
                                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setDataSource：  url" + cVar.m());
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.f.a(cVar);
                                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setDataSource： MediaDataSource url" + cVar.m());
                                } else {
                                    String strB = b.a.a.a.a.a.b.c.q.a.b().b(cVar);
                                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "setDataSource：  local url = ", strB);
                                    if (strB != null && b.a.a.a.a.a.a.c.f() && strB.startsWith(ShareInternalUtility.STAGING_PARAM)) {
                                        a(Uri.parse(strB).getPath());
                                    } else {
                                        this.f.a(strB);
                                    }
                                }
                            }
                            this.j = 202;
                        } catch (Throwable th8) {
                            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SET_DATASOURCE error: ", th8);
                        }
                    } else {
                        z = true;
                    }
                    break;
                case 110:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SET_DISPLAY");
                    try {
                        this.f.a((SurfaceHolder) message.obj);
                        this.f.a(true);
                        k();
                    } catch (Throwable th9) {
                        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SET_DISPLAY error: ", th9);
                    }
                    break;
                case 111:
                    b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SET_SURFACE");
                    try {
                        if (Build.VERSION.SDK_INT >= 14) {
                            this.C = new Surface((SurfaceTexture) message.obj);
                            this.f.a(this.C);
                        }
                        this.f.a(true);
                        k();
                    } catch (Throwable th10) {
                        b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "OP_SET_SURFACE error: ", th10);
                    }
                    break;
            }
        }
        if (z) {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "wrongState");
            this.j = 200;
            if (this.g) {
                return;
            }
            b.a.a.a.a.a.a.f.a aVar = new b.a.a.a.a.a.a.f.a(308, i3);
            aVar.a(i2 + "," + i3);
            for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference3 : this.x) {
                if (weakReference3 != null && weakReference3.get() != null) {
                    weakReference3.get().a(this, aVar);
                }
            }
            this.g = true;
        }
    }

    @Override // b.a.a.a.a.a.a.a
    public int b() {
        if (this.f == null || g()) {
            return 0;
        }
        return this.f.b();
    }

    public void b(int i2) {
        if (g()) {
            return;
        }
        this.A = i2;
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.f.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    @Override // b.a.a.a.a.a.b.e.c.a
    public void a(b.a.a.a.a.a.b.e.c cVar, int i2) {
        if (this.f != cVar) {
            return;
        }
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().b(this, i2);
            }
        }
    }

    @Override // b.a.a.a.a.a.b.e.c.d
    public boolean a(b.a.a.a.a.a.b.e.c cVar, int i2, int i3) {
        b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "what,extra:" + i2 + "," + i3);
        if (this.f != cVar) {
            return false;
        }
        if (i3 == -1004) {
            b.a.a.a.a.a.a.f.a aVar = new b.a.a.a.a.a.a.f.a(i2, i3);
            for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().a(this, aVar);
                }
            }
        }
        a(i2, i3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        if (i2 == 701) {
            this.G = SystemClock.elapsedRealtime();
            this.c++;
            for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().a(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.c));
            return;
        }
        if (i2 == 702) {
            if (this.G > 0) {
                this.H += SystemClock.elapsedRealtime() - this.G;
                this.G = 0L;
            }
            for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference2 : this.x) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().a((b.a.a.a.a.a.a.a) this, Integer.MAX_VALUE);
                }
            }
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.c), " mBufferTotalTime = ", Long.valueOf(this.H));
            return;
        }
        if (this.I && i2 == 3) {
            b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.F);
            k();
            j();
            a(this.z);
            b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    @Override // b.a.a.a.a.a.b.e.c.e
    public void a(b.a.a.a.a.a.b.e.c cVar) {
        if (g()) {
            return;
        }
        this.j = 205;
        try {
            b.a.a.a.a.a.a.f.c cVar2 = this.y;
            if (cVar2 != null) {
                float fH = cVar2.h();
                if (fH > 0.0f) {
                    b.a.a.a.a.a.a.b bVar = new b.a.a.a.a.a.a.b();
                    bVar.a(fH);
                    this.f.a(bVar);
                }
            }
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "speed error: ", th);
        }
        if (this.l != null) {
            if (this.F) {
                x();
            } else {
                b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                y yVar = this.l;
                yVar.sendMessage(yVar.obtainMessage(100, -1, -1));
            }
        }
        J.delete(this.u);
        b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", "onPrepared:" + this.I + " " + this.s);
        if (!this.I && !this.s) {
            j();
            this.s = true;
        }
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c(this);
            }
        }
    }

    private void a(Runnable runnable) {
        try {
            b.a.a.a.a.a.a.i.c.a("CSJ_VIDEO_MEDIA", "enqueueAction()");
            if (this.t == null) {
                this.t = new ArrayList<>();
            }
            this.t.add(runnable);
        } catch (Throwable th) {
            b.a.a.a.a.a.a.i.c.b("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void a() {
        ArrayList<Runnable> arrayList = this.t;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.t.clear();
    }

    public void a(boolean z) {
        if (g()) {
            return;
        }
        y yVar = this.l;
        if (yVar == null) {
            b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            yVar.post(new g(z));
        }
    }

    @Override // b.a.a.a.a.a.b.e.c.g
    public void a(b.a.a.a.a.a.b.e.c cVar, int i2, int i3, int i4, int i5) {
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().a((b.a.a.a.a.a.a.a) this, i2, i3);
            }
        }
    }

    public void a(b.a.a.a.a.a.a.a.InterfaceC0007a interfaceC0007a) {
        if (interfaceC0007a == null) {
            return;
        }
        for (WeakReference<b.a.a.a.a.a.a.a.InterfaceC0007a> weakReference : this.x) {
            if (weakReference != null && weakReference.get() == interfaceC0007a) {
                return;
            }
        }
        this.x.add(new WeakReference<>(interfaceC0007a));
    }

    public void a(int i2) {
        this.d = i2;
    }
}
