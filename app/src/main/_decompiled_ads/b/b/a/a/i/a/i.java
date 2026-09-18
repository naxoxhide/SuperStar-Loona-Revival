package b.b.a.a.i.a;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: LogInternalManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private static volatile b.b.a.a.i.a.n.a j;
    private static i k;
    private volatile Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile b.b.a.a.i.a.m.d.a f202b;
    private volatile b.b.a.a.i.a.m.d.a c;
    private volatile b.b.a.a.i.a.m.d.a d;
    private volatile b.b.a.a.i.a.m.d.a e;
    private volatile b.b.a.a.i.a.j.e f;
    private volatile boolean g;
    private volatile f h;
    private volatile b.b.a.a.i.a.k.c i;

    private i() {
    }

    public static synchronized i f() {
        if (k == null) {
            k = new i();
        }
        return k;
    }

    public static b.b.a.a.i.a.n.a g() {
        if (j == null) {
            synchronized (i.class) {
                if (j == null) {
                    j = new b.b.a.a.i.a.n.b();
                }
            }
        }
        return j;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void b(b.b.a.a.i.a.m.d.a aVar) {
        this.f202b = aVar;
    }

    public Context c() {
        return this.a;
    }

    public b.b.a.a.i.a.j.e d() {
        return this.f;
    }

    public b.b.a.a.i.a.m.d.a e() {
        return this.f202b;
    }

    public b.b.a.a.i.a.m.d.a h() {
        return this.c;
    }

    public b.b.a.a.i.a.m.d.a i() {
        return this.e;
    }

    public b.b.a.a.i.a.k.c j() {
        return this.i;
    }

    public boolean k() {
        return this.g;
    }

    public void l() {
        b.b.a.a.i.a.k.d.g.d();
    }

    public void m() {
        b.b.a.a.i.a.k.d.g.e();
    }

    public void a(b.b.a.a.i.a.j.e eVar) {
        this.f = eVar;
    }

    public b.b.a.a.i.a.m.d.a b() {
        return this.d;
    }

    public void c(b.b.a.a.i.a.m.d.a aVar) {
        this.c = aVar;
    }

    public void d(b.b.a.a.i.a.m.d.a aVar) {
        this.e = aVar;
    }

    public void a(Context context) {
        this.a = context;
    }

    public void a(b.b.a.a.i.a.k.c cVar) {
        this.i = cVar;
    }

    public void a(b.b.a.a.i.a.m.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.c(System.currentTimeMillis());
        b.b.a.a.i.a.k.d.g.a(aVar, aVar.f());
    }

    public void a(String str) {
        b.b.a.a.i.a.o.a.a().a(str);
    }

    public void a(String str, List<String> list, boolean z) {
        b.b.a.a.i.a.o.a.a().a(str, list, z);
    }

    public void a(b.b.a.a.i.a.m.d.a aVar) {
        this.d = aVar;
    }

    public void a(f fVar) {
        this.h = fVar;
    }

    public f a() {
        return this.h;
    }
}
