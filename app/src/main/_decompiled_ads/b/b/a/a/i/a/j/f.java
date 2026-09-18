package b.b.a.a.i.a.j;

import b.b.a.a.i.a.i;
import b.b.a.a.i.a.j.h.g;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: RealTimeMemoryCacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {
    private b.b.a.a.i.a.j.h.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.i.a.j.h.a f205b;
    private b.b.a.a.i.a.j.h.b c;
    private g d;
    private b.b.a.a.i.a.j.h.c e;
    private b.b.a.a.i.a.j.h.f f;
    private b.b.a.a.i.a.m.d.a g;
    private b.b.a.a.i.a.m.d.a h;
    private b.b.a.a.i.a.m.d.a i;
    private b.b.a.a.i.a.m.d.a j;
    private b.b.a.a.i.a.m.d.a k;
    private b.b.a.a.i.a.m.d.a l;

    public f(Queue<String> queue) {
        i.f().d();
        if (b.b.a.a.i.a.k.a.d()) {
            b.b.a.a.i.a.m.d.a aVarE = i.f().e();
            this.g = aVarE;
            this.a = new b.b.a.a.i.a.j.h.e(aVarE, queue);
        }
        if (b.b.a.a.i.a.k.a.b()) {
            b.b.a.a.i.a.m.d.a aVarH = i.f().h();
            this.i = aVarH;
            this.c = new b.b.a.a.i.a.j.h.b(aVarH, queue);
        }
        if (b.b.a.a.i.a.k.a.a()) {
            b.b.a.a.i.a.m.d.a aVarH2 = i.f().h();
            this.h = aVarH2;
            this.f205b = new b.b.a.a.i.a.j.h.a(aVarH2, queue);
        }
        if (b.b.a.a.i.a.k.a.f()) {
            b.b.a.a.i.a.m.d.a aVarH3 = i.f().h();
            this.j = aVarH3;
            this.d = new g(aVarH3, queue);
        }
        if (b.b.a.a.i.a.k.a.c()) {
            b.b.a.a.i.a.m.d.a aVarB = i.f().b();
            this.k = aVarB;
            this.e = new b.b.a.a.i.a.j.h.c(aVarB, queue);
        }
        if (b.b.a.a.i.a.k.a.e()) {
            b.b.a.a.i.a.m.d.a aVarI = i.f().i();
            this.l = aVarI;
            this.f = new b.b.a.a.i.a.j.h.f(aVarI, queue);
        }
    }

    @Override // b.b.a.a.i.a.j.d
    public void a(b.b.a.a.i.a.m.a aVar, int i) {
        try {
            byte bF = aVar.f();
            byte bC = aVar.c();
            if (bF == 0 && bC == 1 && b.b.a.a.i.a.k.a.d()) {
                this.a.a(aVar);
            } else if (bF == 3 && bC == 2 && b.b.a.a.i.a.k.a.b()) {
                this.c.a(aVar);
            } else if (bF == 0 && bC == 2 && b.b.a.a.i.a.k.a.a()) {
                this.f205b.a(aVar);
            } else if (bF == 1 && bC == 2 && b.b.a.a.i.a.k.a.f()) {
                this.d.a(aVar);
            } else if (bF == 1 && bC == 3 && b.b.a.a.i.a.k.a.c()) {
                this.e.a(aVar);
            } else if (bF == 2 && bC == 3 && b.b.a.a.i.a.k.a.e()) {
                this.f.a(aVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // b.b.a.a.i.a.j.d
    public void a(int i, List<b.b.a.a.i.a.m.a> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        b.b.a.a.i.a.m.a aVar = list.get(0);
        byte bC = aVar.c();
        byte bF = aVar.f();
        if (bF == 0 && bC == 1 && b.b.a.a.i.a.k.a.d()) {
            this.a.a(i, list);
            return;
        }
        if (bF == 3 && bC == 2 && b.b.a.a.i.a.k.a.b()) {
            this.c.a(i, list);
            return;
        }
        if (bF == 0 && bC == 2 && b.b.a.a.i.a.k.a.a()) {
            this.f205b.a(i, list);
            return;
        }
        if (bF == 1 && bC == 2 && b.b.a.a.i.a.k.a.f()) {
            this.d.a(i, list);
            return;
        }
        if (bF == 1 && bC == 3 && b.b.a.a.i.a.k.a.c()) {
            this.e.a(i, list);
        } else if (bF == 2 && bC == 3 && b.b.a.a.i.a.k.a.e()) {
            this.f.a(i, list);
        }
    }

    @Override // b.b.a.a.i.a.j.d
    public List<b.b.a.a.i.a.m.a> a(int i, int i2, List<String> list) {
        List<b.b.a.a.i.a.m.a> listB;
        List<b.b.a.a.i.a.m.a> listB2;
        List<b.b.a.a.i.a.m.a> listB3;
        List<b.b.a.a.i.a.m.a> listB4;
        List<b.b.a.a.i.a.m.a> listB5;
        List<b.b.a.a.i.a.m.a> listB6;
        if (b.b.a.a.i.a.k.a.d() && this.a.a(i, i2) && (listB6 = this.a.b(i, i2)) != null && listB6.size() != 0) {
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.A(), 1);
            return listB6;
        }
        if (b.b.a.a.i.a.k.a.b() && this.c.a(i, i2) && (listB5 = this.c.b(i, i2)) != null && listB5.size() != 0) {
            return listB5;
        }
        if (b.b.a.a.i.a.k.a.a() && this.f205b.a(i, i2) && (listB4 = this.f205b.b(i, i2)) != null && listB4.size() != 0) {
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.c(), 1);
            return listB4;
        }
        if (b.b.a.a.i.a.k.a.f() && this.d.a(i, i2) && (listB3 = this.d.b(i, i2)) != null && listB3.size() != 0) {
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.X(), 1);
            return listB3;
        }
        if (b.b.a.a.i.a.k.a.c() && this.e.a(i, i2) && (listB2 = this.e.b(i, i2)) != null && listB2.size() != 0) {
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.l(), 1);
            return listB2;
        }
        if (!b.b.a.a.i.a.k.a.e() || !this.f.a(i, i2) || (listB = this.f.b(i, i2)) == null || listB.size() == 0) {
            return null;
        }
        return listB;
    }

    @Override // b.b.a.a.i.a.j.d
    public boolean a(int i, boolean z) {
        b.b.a.a.i.a.j.h.f fVar;
        b.b.a.a.i.a.m.d.a aVar;
        b.b.a.a.i.a.j.h.c cVar;
        b.b.a.a.i.a.m.d.a aVar2;
        g gVar;
        b.b.a.a.i.a.m.d.a aVar3;
        b.b.a.a.i.a.j.h.a aVar4;
        b.b.a.a.i.a.m.d.a aVar5;
        b.b.a.a.i.a.j.h.b bVar;
        b.b.a.a.i.a.m.d.a aVar6;
        b.b.a.a.i.a.j.h.e eVar;
        b.b.a.a.i.a.m.d.a aVar7;
        return (b.b.a.a.i.a.k.a.d() && (eVar = this.a) != null && (aVar7 = this.g) != null && eVar.a(i, aVar7.e())) || (b.b.a.a.i.a.k.a.b() && (bVar = this.c) != null && (aVar6 = this.i) != null && bVar.a(i, aVar6.e())) || ((b.b.a.a.i.a.k.a.a() && (aVar4 = this.f205b) != null && (aVar5 = this.h) != null && aVar4.a(i, aVar5.e())) || ((b.b.a.a.i.a.k.a.f() && (gVar = this.d) != null && (aVar3 = this.j) != null && gVar.a(i, aVar3.e())) || ((b.b.a.a.i.a.k.a.c() && (cVar = this.e) != null && (aVar2 = this.k) != null && cVar.a(i, aVar2.e())) || (b.b.a.a.i.a.k.a.e() && (fVar = this.f) != null && (aVar = this.l) != null && fVar.a(i, aVar.e())))));
    }
}
