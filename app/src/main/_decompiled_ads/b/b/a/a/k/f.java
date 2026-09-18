package b.b.a.a.k;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: TTFutureTask.java */
/* JADX INFO: loaded from: classes.dex */
public class f<V> extends FutureTask<V> implements Comparable<f<V>> {
    private int a;

    public f(Callable<V> callable, int i, int i2) {
        super(callable);
        this.a = i == -1 ? 5 : i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        if (a() < fVar.a()) {
            return 1;
        }
        return a() > fVar.a() ? -1 : 0;
    }

    public f(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.a = i == -1 ? 5 : i;
    }

    public int a() {
        return this.a;
    }
}
