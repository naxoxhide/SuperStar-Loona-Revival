package b.b.a.a.h.y;

/* JADX INFO: compiled from: DiskCacheVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    @Override // b.b.a.a.h.y.i
    public String a() {
        return "disk_cache";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        String strO = cVar.o();
        b.b.a.a.h.c cVarD = cVar.h().d(cVar.f());
        if (cVarD == null) {
            cVar.a(new k());
            return;
        }
        byte[] bArr = cVarD.get(strO);
        if (bArr == null) {
            cVar.a(new k());
        } else {
            cVar.a(new b(bArr, null));
            cVar.h().f(cVar.f()).a(strO, bArr);
        }
    }
}
