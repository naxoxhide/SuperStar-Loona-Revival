package b.b.a.a.f.a.p.b;

import b.b.a.a.f.a.h;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: NetChain.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements h.a {
    List<h> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    l f155b;
    int c = 0;

    b(List<h> list, l lVar) {
        this.a = list;
        this.f155b = lVar;
    }

    @Override // b.b.a.a.f.a.h.a
    public l a() {
        return this.f155b;
    }

    @Override // b.b.a.a.f.a.h.a
    public n a(l lVar) throws IOException {
        this.f155b = lVar;
        int i = this.c + 1;
        this.c = i;
        if (i >= this.a.size()) {
            return null;
        }
        return this.a.get(this.c).a(this);
    }
}
