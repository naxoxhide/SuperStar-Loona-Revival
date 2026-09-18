package b.b.a.a.h.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import b.b.a.a.h.l;
import b.b.a.a.h.m;
import b.b.a.a.h.p;
import b.b.a.a.h.q;
import b.b.a.a.h.r;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: LoadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f178b;
    private b.b.a.a.h.d f;
    private l g;
    private ExecutorService h;
    private p i;
    private Map<String, List<c>> a = new ConcurrentHashMap();
    private Map<String, q> c = new HashMap();
    private Map<String, r> d = new HashMap();
    private Map<String, b.b.a.a.h.c> e = new HashMap();

    public f(Context context, m mVar) {
        this.f178b = (m) h.a(mVar);
        b.b.a.a.h.x.i.a.a(context, mVar.c());
    }

    private q b(b.b.a.a.h.b bVar) {
        q qVarD = this.f178b.d();
        return qVarD != null ? b.b.a.a.h.x.i.e.a.a(qVarD) : b.b.a.a.h.x.i.e.a.a(bVar.f());
    }

    private r c(b.b.a.a.h.b bVar) {
        r rVarG = this.f178b.g();
        return rVarG != null ? rVarG : b.b.a.a.h.x.i.e.e.a(bVar.f());
    }

    public b.b.a.a.h.c a(String str) {
        return d(b.b.a.a.h.x.i.a.a(new File(str)));
    }

    public b.b.a.a.h.c d(b.b.a.a.h.b bVar) {
        if (bVar == null) {
            bVar = b.b.a.a.h.x.i.a.h();
        }
        String string = bVar.c().toString();
        b.b.a.a.h.c cVar = this.e.get(string);
        if (cVar != null) {
            return cVar;
        }
        b.b.a.a.h.c cVarA = a(bVar);
        this.e.put(string, cVarA);
        return cVarA;
    }

    public Collection<b.b.a.a.h.c> e() {
        return this.e.values();
    }

    public Collection<r> f() {
        return this.d.values();
    }

    public Map<String, List<c>> g() {
        return this.a;
    }

    public b.b.a.a.h.d h() {
        if (this.f == null) {
            this.f = a();
        }
        return this.f;
    }

    public l i() {
        if (this.g == null) {
            this.g = b();
        }
        return this.g;
    }

    public p j() {
        if (this.i == null) {
            this.i = c();
        }
        return this.i;
    }

    public ExecutorService k() {
        if (this.h == null) {
            this.h = d();
        }
        return this.h;
    }

    public q e(b.b.a.a.h.b bVar) {
        if (bVar == null) {
            bVar = b.b.a.a.h.x.i.a.h();
        }
        String string = bVar.c().toString();
        q qVar = this.c.get(string);
        if (qVar != null) {
            return qVar;
        }
        q qVarB = b(bVar);
        this.c.put(string, qVarB);
        return qVarB;
    }

    public r f(b.b.a.a.h.b bVar) {
        if (bVar == null) {
            bVar = b.b.a.a.h.x.i.a.h();
        }
        String string = bVar.c().toString();
        r rVar = this.d.get(string);
        if (rVar != null) {
            return rVar;
        }
        r rVarC = c(bVar);
        this.d.put(string, rVarC);
        return rVarC;
    }

    private b.b.a.a.h.c a(b.b.a.a.h.b bVar) {
        b.b.a.a.h.c cVarA = this.f178b.a();
        return cVarA != null ? cVarA : new b.b.a.a.h.x.i.d.b(bVar.c(), bVar.d(), k());
    }

    private l b() {
        l lVarB = this.f178b.b();
        return lVarB != null ? lVarB : b.b.a.a.h.v.b.a();
    }

    private p c() {
        p pVarE = this.f178b.e();
        return pVarE == null ? new g() : pVarE;
    }

    private b.b.a.a.h.d a() {
        b.b.a.a.h.d dVarF = this.f178b.f();
        return dVarF == null ? b.b.a.a.h.w.b.a() : dVarF;
    }

    private ExecutorService d() {
        ExecutorService executorServiceH = this.f178b.h();
        return executorServiceH != null ? executorServiceH : b.b.a.a.h.v.c.a();
    }

    public b.b.a.a.h.x.j.a a(c cVar) {
        ImageView.ScaleType scaleTypeD = cVar.d();
        if (scaleTypeD == null) {
            scaleTypeD = b.b.a.a.h.x.j.a.g;
        }
        ImageView.ScaleType scaleType = scaleTypeD;
        Bitmap.Config configG = cVar.g();
        if (configG == null) {
            configG = b.b.a.a.h.x.j.a.h;
        }
        return new b.b.a.a.h.x.j.a(cVar.b(), cVar.c(), scaleType, configG, cVar.n(), cVar.m());
    }
}
