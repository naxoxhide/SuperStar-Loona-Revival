package b.b.a.a.h.y;

/* JADX INFO: compiled from: CachePolicyVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    @Override // b.b.a.a.h.y.i
    public String a() {
        return "cache_policy";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        b.b.a.a.h.b bVarF = cVar.f();
        if (bVarF != null) {
            if (bVarF.a()) {
                cVar.a(new j());
                return;
            } else if (bVarF.e()) {
                cVar.a(new f());
                return;
            }
        }
        cVar.a(new k());
    }
}
