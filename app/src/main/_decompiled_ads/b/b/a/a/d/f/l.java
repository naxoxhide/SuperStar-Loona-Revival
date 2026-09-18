package b.b.a.a.d.f;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: RenderRealChain.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements j.a {
    private List<j> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    o f116b;
    private i c;
    private AtomicBoolean d = new AtomicBoolean(false);

    public l(List<j> list, i iVar) {
        this.a = list;
        this.c = iVar;
    }

    @Override // b.b.a.a.d.f.j.a
    public boolean a(j jVar) {
        int iIndexOf = this.a.indexOf(jVar);
        return iIndexOf < this.a.size() - 1 && iIndexOf >= 0;
    }

    @Override // b.b.a.a.d.f.j.a
    public void b() {
        this.c.f();
        Iterator<j> it = this.a.iterator();
        while (it.hasNext() && !it.next().a(this)) {
        }
    }

    @Override // b.b.a.a.d.f.j.a
    public boolean c() {
        return this.d.get();
    }

    @Override // b.b.a.a.d.f.j.a
    public o a() {
        return this.f116b;
    }

    @Override // b.b.a.a.d.f.j.a
    public void a(o oVar) {
        this.f116b = oVar;
    }

    @Override // b.b.a.a.d.f.j.a
    public void b(j jVar) {
        int iIndexOf = this.a.indexOf(jVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.a.size()) {
                return;
            }
        } while (!this.a.get(iIndexOf).a(this));
    }

    @Override // b.b.a.a.d.f.j.a
    public void a(boolean z) {
        this.d.getAndSet(z);
    }
}
