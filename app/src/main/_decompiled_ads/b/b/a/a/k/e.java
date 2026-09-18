package b.b.a.a.k;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TTExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f250b;
    private static volatile ThreadPoolExecutor d;
    private static volatile ThreadPoolExecutor e;
    private static volatile ThreadPoolExecutor f;
    private static volatile ThreadPoolExecutor g;
    private static volatile ThreadPoolExecutor h;
    private static volatile ThreadPoolExecutor i;
    private static volatile ScheduledExecutorService j;
    public static final int a = Runtime.getRuntime().availableProcessors();
    public static int c = 120;
    public static boolean k = true;

    /* JADX INFO: compiled from: TTExecutor.java */
    static class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    public static void a(g gVar, int i2, int i3) {
        if (e == null) {
            b(i3);
        }
        if (gVar == null || e == null) {
            return;
        }
        gVar.setPriority(i2);
        e.execute(gVar);
    }

    public static ExecutorService b(int i2) {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new b.b.a.a.k.a.b().a("io").a(2).b(i2).a(20L).a(TimeUnit.SECONDS).a(new LinkedBlockingQueue()).a(b()).a();
                    e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return e;
    }

    public static void c(g gVar) {
        if (e == null) {
            d();
        }
        if (e != null) {
            e.execute(gVar);
        }
    }

    public static void d(g gVar) {
        if (d == null) {
            e();
        }
        if (gVar == null || d == null) {
            return;
        }
        d.execute(gVar);
    }

    public static ExecutorService e() {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new b.b.a.a.k.a.b().a("init").a(0).b(10).a(5L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(b()).a();
                }
            }
        }
        return d;
    }

    public static ExecutorService f() {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new b.b.a.a.k.a.b().a("log").b(10).a(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(b()).a();
                    g.allowCoreThreadTimeOut(true);
                }
            }
        }
        return g;
    }

    public static c g() {
        return f250b;
    }

    public static ScheduledExecutorService h() {
        if (j == null) {
            synchronized (e.class) {
                if (j == null) {
                    j = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return j;
    }

    public static boolean i() {
        return k;
    }

    public static void c(g gVar, int i2) {
        if (gVar != null) {
            gVar.setPriority(i2);
        }
        e(gVar);
    }

    public static ExecutorService d() {
        return b(10);
    }

    public static ExecutorService a() {
        if (i == null) {
            synchronized (e.class) {
                if (i == null) {
                    i = new b.b.a.a.k.a.b().a("aidl").b(10).a(2).a(30L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(b()).a();
                    i.allowCoreThreadTimeOut(true);
                }
            }
        }
        return i;
    }

    public static ExecutorService c() {
        if (h == null) {
            synchronized (e.class) {
                if (h == null) {
                    h = new b.b.a.a.k.a.b().a("computation").a(3).b(10).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(b()).a();
                    h.allowCoreThreadTimeOut(true);
                }
            }
        }
        return h;
    }

    public static void e(g gVar) {
        if (g == null) {
            f();
        }
        if (gVar == null || g == null) {
            return;
        }
        g.execute(gVar);
    }

    public static void b(g gVar, int i2) {
        c(gVar);
    }

    public static void b(g gVar) {
        if (i == null) {
            a();
        }
        if (gVar == null || i == null) {
            return;
        }
        i.execute(gVar);
    }

    public static void a(g gVar, int i2) {
        if (gVar != null) {
            gVar.setPriority(i2);
        }
        b(gVar);
    }

    public static RejectedExecutionHandler b() {
        return new a();
    }

    public static void c(int i2) {
        c = i2;
    }

    public static void a(boolean z) {
        k = z;
    }

    public static void a(c cVar) {
        f250b = cVar;
    }

    public static ExecutorService a(int i2) {
        if (f == null) {
            synchronized (e.class) {
                if (f == null) {
                    f = new b.b.a.a.k.a.b().a("ad").a(2).b(i2).a(20L).a(TimeUnit.SECONDS).a(new LinkedBlockingQueue()).a(b()).a();
                    f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f;
    }

    public static void a(g gVar) {
        if (f == null) {
            a(5);
        }
        if (gVar == null || f == null) {
            return;
        }
        f.execute(gVar);
    }
}
