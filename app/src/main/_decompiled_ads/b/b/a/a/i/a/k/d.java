package b.b.a.a.i.a.k;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import b.b.a.a.i.a.f;
import b.b.a.a.i.a.i;
import b.b.a.a.i.a.n.e;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: LogThreadCenter.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final d g = new d();
    public static final b.b.a.a.i.a.k.e.a h = new b.b.a.a.i.a.k.e.a();
    public static final long i;
    public static long j;
    private volatile b.b.a.a.i.a.k.g.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f212b = false;
    public volatile boolean c = false;
    private volatile Handler d;
    private final Comparator<b.b.a.a.i.a.m.a> e;
    private final PriorityBlockingQueue<b.b.a.a.i.a.m.a> f;

    /* JADX INFO: compiled from: LogThreadCenter.java */
    class a implements Comparator<b.b.a.a.i.a.m.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b.b.a.a.i.a.m.a aVar, b.b.a.a.i.a.m.a aVar2) {
            return d.this.a(aVar, aVar2);
        }
    }

    /* JADX INFO: compiled from: LogThreadCenter.java */
    class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f213b;
        final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, f fVar, long j) {
            super(str);
            this.f213b = fVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f213b, this.c);
        }
    }

    /* JADX INFO: compiled from: LogThreadCenter.java */
    class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.b.a.a.i.a.k.g.c f214b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d dVar, String str, b.b.a.a.i.a.k.g.c cVar) {
            super(str);
            this.f214b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.i.a.k.g.c cVar = this.f214b;
            if (cVar != null) {
                cVar.c(2);
            }
        }
    }

    static {
        new AtomicLong(0L);
        new AtomicLong(0L);
        i = System.currentTimeMillis();
        j = 0L;
    }

    private d() {
        a aVar = new a();
        this.e = aVar;
        this.f = new PriorityBlockingQueue<>(8, aVar);
    }

    public void b() {
        b.b.a.a.i.a.l.b.a(h.C(), 1);
        b.b.a.a.i.a.l.c.d("flushMemoryAndDB()");
        b.b.a.a.i.a.k.g.c cVar = this.a;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (cVar != null) {
                cVar.c(2);
                return;
            }
            return;
        }
        f fVarA = i.f().a();
        if (fVarA == null) {
            b.b.a.a.i.a.l.c.d("discard flush");
            return;
        }
        Executor executorA = fVarA.a();
        if (executorA == null) {
            executorA = fVarA.b();
        }
        if (executorA != null) {
            executorA.execute(new c(this, "flush", cVar));
        }
    }

    public PriorityBlockingQueue<b.b.a.a.i.a.m.a> c() {
        return this.f;
    }

    public void d() {
        a();
        b();
    }

    public synchronized void e() {
        if (this.a != null && this.a.isAlive()) {
            if (this.d != null) {
                this.d.removeCallbacksAndMessages(null);
            }
            this.a.a(false);
            if (Build.VERSION.SDK_INT >= 18) {
                this.a.quitSafely();
            } else {
                this.a.quit();
            }
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(b.b.a.a.i.a.m.a aVar, b.b.a.a.i.a.m.a aVar2) {
        long jA;
        long jB;
        long jB2;
        long jA2;
        if (aVar == null) {
            return aVar2 == null ? 0 : -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        if (aVar.c() == aVar2.c()) {
            if (aVar.d() != null) {
                jA = aVar.d().a();
                jB = aVar.d().b();
            } else {
                jA = 0;
                jB = 0;
            }
            if (aVar2.d() != null) {
                jA2 = aVar2.d().a();
                jB2 = aVar2.d().b();
            } else {
                jB2 = 0;
                jA2 = 0;
            }
            if (jA == 0 || jA2 == 0) {
                return 0;
            }
            long j2 = jA - jA2;
            if (Math.abs(j2) > 2147483647L) {
                return 0;
            }
            if (j2 != 0) {
                return (int) j2;
            }
            if (jB == 0 || jB2 == 0) {
                return 0;
            }
            return (int) (jB - jB2);
        }
        return aVar.c() - aVar2.c();
    }

    public void a(Handler handler) {
        this.d = handler;
    }

    public synchronized boolean a() {
        try {
            if (this.a != null && this.a.isAlive()) {
                b.b.a.a.i.a.l.c.a("LogThread state:" + this.a.getState());
            } else if (!b.b.a.a.i.a.b.b()) {
                b.b.a.a.i.a.l.c.a("--start LogThread--");
                this.a = new b.b.a.a.i.a.k.g.c(this.f);
                this.a.start();
                return true;
            }
            return false;
        } catch (Throwable th) {
            b.b.a.a.i.a.l.c.b(th.getMessage());
            return false;
        }
    }

    public void a(b.b.a.a.i.a.m.a aVar, int i2) {
        a();
        f fVarA = i.f().a();
        b.b.a.a.i.a.k.g.c cVar = this.a;
        if (cVar != null) {
            a(fVarA, aVar);
            cVar.a(aVar, aVar.c() == 4);
        }
    }

    private void a(f fVar, b.b.a.a.i.a.m.a aVar) {
        if (fVar != null) {
            try {
                if (fVar.e()) {
                    long jB = 0;
                    if (aVar != null && aVar.d() != null) {
                        jB = aVar.d().b();
                    }
                    long j2 = jB;
                    if (j2 == 1) {
                        j = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongF0 = h.f0();
                    b.b.a.a.i.a.l.b.a(atomicLongF0, 1);
                    if (atomicLongF0.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor executorA = fVar.a();
                            if (executorA == null) {
                                executorA = fVar.b();
                            }
                            if (executorA != null) {
                                executorA.execute(new b("report", fVar, j2));
                                return;
                            }
                            return;
                        }
                        b.b.a.a.i.a.l.c.a("==> monitor upload index1:" + j2);
                        a(fVar, j2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, long j2) {
        b.b.a.a.i.a.k.g.c cVar = this.a;
        if (fVar == null || cVar == null) {
            return;
        }
        b.b.a.a.i.a.k.e.a aVar = h;
        cVar.a(fVar.a(aVar.a(j2)), true);
        aVar.h0();
    }
}
