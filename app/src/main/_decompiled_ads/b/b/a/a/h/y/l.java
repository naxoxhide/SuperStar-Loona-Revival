package b.b.a.a.h.y;

/* JADX INFO: compiled from: RawCacheVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends a {
    @Override // b.b.a.a.h.y.i
    public String a() {
        return "raw_cache";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        byte[] bArr = cVar.h().f(cVar.f()).get(cVar.o());
        if (bArr == null) {
            cVar.a(new f());
        } else {
            cVar.a(new b(bArr, null));
        }
    }
}
