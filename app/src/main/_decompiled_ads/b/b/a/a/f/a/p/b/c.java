package b.b.a.a.f.a.p.b;

import android.text.TextUtils;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;

/* JADX INFO: compiled from: NetClient.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends j {
    public d h;

    public c(j.a aVar) {
        super(aVar);
        this.h = new d();
    }

    @Override // b.b.a.a.f.a.j
    public b.b.a.a.f.a.d a() {
        return this.h;
    }

    @Override // b.b.a.a.f.a.j
    public b.b.a.a.f.a.b a(l lVar) {
        lVar.a(this);
        if (lVar == null || lVar.g() == null || lVar.g().e() == null || TextUtils.isEmpty(lVar.g().e().toString())) {
            return null;
        }
        a aVar = new a(lVar, this.h);
        this.h.c().add(aVar);
        return aVar;
    }
}
