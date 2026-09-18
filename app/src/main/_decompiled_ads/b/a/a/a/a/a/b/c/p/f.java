package b.a.a.a.a.a.b.c.p;

import b.a.a.a.a.a.b.c.i;
import b.b.a.a.f.a.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: VolleyResponseWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    private n c;

    public f(n nVar, e eVar) {
        b.b.a.a.f.a.f fVarC;
        this.c = nVar;
        this.a = new ArrayList();
        if (nVar != null && (fVarC = nVar.c()) != null) {
            for (int i = 0; i < fVarC.a(); i++) {
                this.a.add(new i.b(fVarC.a(i), fVarC.b(i)));
            }
        }
        this.f54b = eVar;
    }

    @Override // b.a.a.a.a.a.b.c.p.a
    public int a() {
        return this.c.b();
    }

    @Override // b.a.a.a.a.a.b.c.p.a
    public InputStream b() {
        return this.c.a().a();
    }

    @Override // b.a.a.a.a.a.b.c.p.a
    public List<i.b> d() {
        return this.a;
    }

    @Override // b.a.a.a.a.a.b.c.p.a
    public boolean e() {
        return this.c.b() >= 200 && this.c.b() < 300;
    }

    @Override // b.a.a.a.a.a.b.c.p.a
    public String f() {
        return a(this.c.b());
    }

    @Override // b.a.a.a.a.a.b.c.p.a
    public String g() {
        n nVar = this.c;
        return (nVar == null || nVar.f() == null) ? "http/1.1" : this.c.f().toString();
    }

    @Override // b.a.a.a.a.a.b.c.p.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).f44b : str2;
    }
}
