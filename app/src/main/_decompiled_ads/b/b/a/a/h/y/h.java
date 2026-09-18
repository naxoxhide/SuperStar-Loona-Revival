package b.b.a.a.h.y;

import b.b.a.a.h.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FailVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    private Throwable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f191b;
    private String c;

    public h(int i, String str, Throwable th) {
        this.f191b = i;
        this.c = str;
        this.a = th;
    }

    private void b(b.b.a.a.h.x.c cVar) {
        o oVarL = cVar.l();
        if (oVarL != null) {
            oVarL.a(this.f191b, this.c, this.a);
        }
    }

    @Override // b.b.a.a.h.y.i
    public String a() {
        return "failed";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        cVar.a(new b.b.a.a.h.x.a(this.f191b, this.c, this.a));
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
}
