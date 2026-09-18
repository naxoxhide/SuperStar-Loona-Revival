package b.b.a.a.h.y;

import b.b.a.a.h.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SuccessVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class m<T> extends a {
    private T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.h.f f193b;
    private boolean c;

    public m(T t, b.b.a.a.h.f fVar, boolean z) {
        this.a = t;
        this.f193b = fVar;
        this.c = z;
    }

    private Map<String, String> b() {
        b.b.a.a.h.f fVar = this.f193b;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // b.b.a.a.h.y.i
    public String a() {
        return "success";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        String strP = cVar.p();
        Map<String, List<b.b.a.a.h.x.c>> mapG = cVar.h().g();
        List<b.b.a.a.h.x.c> list = mapG.get(strP);
        if (list == null) {
            b(cVar);
            return;
        }
        synchronized (list) {
            Iterator<b.b.a.a.h.x.c> it = list.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            list.clear();
            mapG.remove(strP);
        }
    }

    private void b(b.b.a.a.h.x.c cVar) {
        o oVarL = cVar.l();
        if (oVarL != null) {
            oVarL.a(new b.b.a.a.h.x.d().a(cVar, this.a, b(), this.c));
        }
    }
}
