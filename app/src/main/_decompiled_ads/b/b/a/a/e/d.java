package b.b.a.a.e;

/* JADX INFO: compiled from: BaseStatefulMethod.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<P, R> extends b.b.a.a.e.b<P, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f130b = true;
    private a c;

    /* JADX INFO: compiled from: BaseStatefulMethod.java */
    interface a {
        void a(Throwable th);
    }

    /* JADX INFO: compiled from: BaseStatefulMethod.java */
    public interface b {
        d a();
    }

    private boolean c() {
        if (this.f130b) {
            return true;
        }
        i.a(new IllegalStateException("Jsb async call already finished: " + a() + ", hashcode: " + hashCode()));
        return false;
    }

    protected abstract void a(P p, f fVar) throws Exception;

    protected final void d() {
        a((Throwable) null);
    }

    protected void e() {
        this.f130b = false;
    }

    protected abstract void f();

    void g() {
        f();
        e();
    }

    protected final void a(Throwable th) {
        if (c()) {
            this.c.a(th);
            e();
        }
    }

    void a(P p, f fVar, a aVar) throws Exception {
        this.c = aVar;
        a(p, fVar);
    }
}
