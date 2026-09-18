package b.a.a.a.a.a.b.c;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: AbsTask.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a implements Runnable {
    private static final AtomicLong n = new AtomicLong();
    protected volatile b.a.a.a.a.a.b.c.l.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b.a.a.a.a.a.b.c.m.c f33b;
    protected b.a.a.a.a.a.b.c.o.a e;
    protected volatile List<i.b> f;
    protected volatile String g;
    protected volatile String h;
    protected volatile i i;
    protected volatile k j;
    private final AtomicInteger l;
    private int m;
    protected final AtomicInteger c = new AtomicInteger();
    protected final AtomicLong d = new AtomicLong();
    protected volatile boolean k = false;

    /* JADX INFO: renamed from: b.a.a.a.a.a.b.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsTask.java */
    class RunnableC0011a implements Runnable {
        RunnableC0011a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            b.a.a.a.a.a.b.c.o.a aVar2 = aVar.e;
            if (aVar2 != null) {
                aVar2.a(aVar.j, a.this.m);
            }
        }
    }

    public a(b.a.a.a.a.a.b.c.l.a aVar, b.a.a.a.a.a.b.c.m.c cVar) {
        n.incrementAndGet();
        this.l = new AtomicInteger(0);
        this.m = -1;
        this.a = aVar;
        this.f33b = cVar;
    }

    protected void a(Boolean bool, String str, Throwable th) {
    }

    public void b() {
        this.l.compareAndSet(0, 1);
    }

    protected void c() {
        this.l.compareAndSet(0, 2);
    }

    protected int d() {
        if (this.i != null) {
            return this.i.c.a;
        }
        return 0;
    }

    public boolean e() {
        return this.l.get() == 1;
    }

    public boolean f() {
        return this.l.get() == 2;
    }

    protected boolean g() {
        return d() == 1;
    }

    protected void a() throws b.a.a.a.a.a.b.c.n.a {
        if (e()) {
            throw new b.a.a.a.a.a.b.c.n.a();
        }
    }

    protected b.a.a.a.a.a.b.c.p.a a(k.a aVar, int i, int i2, String str) throws IOException {
        b.a.a.a.a.a.b.c.p.b bVarB = b.a.a.a.a.a.b.c.p.c.a().b();
        b.a.a.a.a.a.b.c.p.e eVar = new b.a.a.a.a.a.b.c.p.e();
        HashMap map = new HashMap();
        eVar.a = aVar.a;
        "HEAD".equalsIgnoreCase(str);
        List<i.b> list = this.f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!"Range".equalsIgnoreCase(bVar.a) && !HttpHeaders.CONNECTION.equalsIgnoreCase(bVar.a) && !"Proxy-Connection".equalsIgnoreCase(bVar.a) && !HttpHeaders.HOST.equalsIgnoreCase(bVar.a)) {
                    map.put(bVar.a, bVar.f44b);
                }
            }
        }
        String strA = b.a.a.a.a.a.b.d.a.a(i, i2);
        if (strA != null) {
            map.put("Range", strA);
        }
        if (e.h) {
            map.put(HttpHeaders.CACHE_CONTROL, "no-cache");
        }
        d dVarD = d.d();
        f fVarF = f.f();
        boolean z = this.i == null;
        c cVarB = z ? dVarD.b() : fVarF.d();
        c cVarC = z ? dVarD.c() : fVarF.e();
        if (cVarB != null || cVarC != null) {
            if (cVarB != null) {
                cVarB.a(aVar.f48b);
                throw null;
            }
            if (cVarC != null) {
                cVarC.a(aVar.f48b);
                throw null;
            }
        }
        eVar.f55b = map;
        if (this.k) {
            this.k = false;
            return null;
        }
        return bVarB.a(eVar);
    }

    protected void a(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = e.i;
        int iD = d();
        if (i3 == 1 || (i3 == 2 && iD == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.m) {
                    return;
                }
                this.m = i4;
                b.a.a.a.a.a.b.d.a.a(new RunnableC0011a());
            }
        }
    }
}
