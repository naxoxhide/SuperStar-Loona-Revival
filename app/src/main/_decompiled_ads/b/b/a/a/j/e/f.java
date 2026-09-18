package b.b.a.a.j.e;

import b.b.a.a.f.a.h;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import java.io.IOException;

/* JADX INFO: compiled from: TncHostInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements h {
    private int a;

    public void a(int i) {
        this.a = i;
    }

    @Override // b.b.a.a.f.a.h
    public n a(h.a aVar) throws IOException {
        n nVarA;
        l lVarA = aVar.a();
        if (g.a().a(this.a).a() != null) {
            g.a().a(this.a).a().h();
        }
        String string = lVarA.g().toString();
        String strB = g.a().a(this.a).b(string);
        if (!string.equals(strB)) {
            lVarA = lVarA.e().a(strB).a();
        }
        IOException iOException = null;
        try {
            nVarA = aVar.a(lVarA);
        } catch (Exception e) {
            IOException iOException2 = new IOException(e.getMessage());
            g.a().a(this.a).a(lVarA, e);
            nVarA = null;
            iOException = iOException2;
        }
        g.a().a(this.a).a(lVarA, nVarA);
        if (iOException == null) {
            return nVarA == null ? aVar.a(lVarA) : nVarA;
        }
        throw iOException;
    }
}
