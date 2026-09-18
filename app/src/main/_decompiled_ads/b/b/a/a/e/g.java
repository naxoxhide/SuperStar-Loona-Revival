package b.b.a.a.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: compiled from: CallHandler.java */
/* JADX INFO: loaded from: classes.dex */
class g implements w.a {
    private final h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f132b;
    private final Map<String, b.b.a.a.e.b> c = new HashMap();
    private final Map<String, d.b> d = new HashMap();
    private final List<q> e = new ArrayList();
    private final Set<d> f = new HashSet();
    private final m g;
    private final boolean h;
    private final boolean i;
    private final b.b.a.a.e.a j;

    /* JADX INFO: compiled from: CallHandler.java */
    class a implements d.a {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f133b;

        a(q qVar, d dVar) {
            this.a = qVar;
            this.f133b = dVar;
        }

        @Override // b.b.a.a.e.d.a
        public void a(Throwable th) {
            if (g.this.j == null) {
                return;
            }
            g.this.j.a(y.a(th), this.a);
            g.this.f.remove(this.f133b);
        }
    }

    /* JADX INFO: compiled from: CallHandler.java */
    class b implements t.a {
        b(g gVar, q qVar) {
        }
    }

    /* JADX INFO: compiled from: CallHandler.java */
    static final class c {
        boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f134b;

        /* synthetic */ c(boolean z, String str, a aVar) {
            this(z, str);
        }

        private c(boolean z, String str) {
            this.a = z;
            this.f134b = str;
        }
    }

    g(j jVar, b.b.a.a.e.a aVar, v vVar) {
        this.j = aVar;
        this.a = jVar.d;
        u uVar = new u(vVar, jVar.l, jVar.m);
        this.f132b = uVar;
        uVar.a(this);
        uVar.a(jVar.p);
        this.g = jVar.i;
        this.h = jVar.h;
        this.i = jVar.o;
    }

    private Object b(String str, b.b.a.a.e.b bVar) throws JSONException {
        return this.a.a(str, a(bVar)[0]);
    }

    c a(q qVar, f fVar) throws Exception {
        b.b.a.a.e.b bVar = this.c.get(qVar.d);
        a aVar = null;
        if (bVar != null) {
            try {
                x xVarA = a(fVar.f131b, bVar);
                fVar.c = xVarA;
                if (xVarA == null) {
                    m mVar = this.g;
                    if (mVar != null) {
                        mVar.a(fVar.f131b, qVar.d, 1);
                    }
                    i.a("Permission denied, call: " + qVar);
                    throw new s(-1);
                }
                if (bVar instanceof e) {
                    i.a("Processing stateless call: " + qVar);
                    return a(qVar, (e) bVar, fVar);
                }
                if (bVar instanceof b.b.a.a.e.c) {
                    i.a("Processing raw call: " + qVar);
                    return a(qVar, (b.b.a.a.e.c) bVar, xVarA);
                }
            } catch (v.a e) {
                i.b("No remote permission config fetched, call pending: " + qVar, e);
                this.e.add(qVar);
                return new c(false, y.a(), aVar);
            }
        }
        d.b bVar2 = this.d.get(qVar.d);
        if (bVar2 == null) {
            m mVar2 = this.g;
            if (mVar2 != null) {
                mVar2.a(fVar.f131b, qVar.d, 2);
            }
            i.b("Received call: " + qVar + ", but not registered.");
            return null;
        }
        d dVarA = bVar2.a();
        dVarA.a(qVar.d);
        x xVarA2 = a(fVar.f131b, dVarA);
        fVar.c = xVarA2;
        if (xVarA2 != null) {
            i.a("Processing stateful call: " + qVar);
            return a(qVar, dVarA, fVar);
        }
        i.a("Permission denied, call: " + qVar);
        dVarA.e();
        throw new s(-1);
    }

    void a(String str, e<?, ?> eVar) {
        eVar.a(str);
        this.c.put(str, eVar);
        i.a("JsBridge stateless method registered: " + str);
    }

    void a(String str, d.b bVar) {
        this.d.put(str, bVar);
        i.a("JsBridge stateful method registered: " + str);
    }

    void a() {
        Iterator<d> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
        this.f.clear();
        this.c.clear();
        this.d.clear();
        this.f132b.b(this);
    }

    private c a(q qVar, e eVar, f fVar) throws Exception {
        return new c(true, y.a(this.a.a(eVar.a(b(qVar.e, eVar), fVar))), null);
    }

    private c a(q qVar, d dVar, f fVar) throws Exception {
        this.f.add(dVar);
        dVar.a(b(qVar.e, dVar), fVar, new a(qVar, dVar));
        return new c(false, y.a(), null);
    }

    private c a(q qVar, b.b.a.a.e.c cVar, x xVar) throws Exception {
        cVar.a(qVar, new t(qVar.d, xVar, new b(this, qVar)));
        return new c(false, y.a(), null);
    }

    private x a(String str, b.b.a.a.e.b bVar) {
        if (this.i) {
            return x.PRIVATE;
        }
        return this.f132b.a(this.h, str, bVar);
    }

    private static Type[] a(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
