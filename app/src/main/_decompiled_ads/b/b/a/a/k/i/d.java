package b.b.a.a.k.i;

import b.b.a.a.k.i.c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: RecyclePool.java */
/* JADX INFO: loaded from: classes.dex */
public class d<T extends c> {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BlockingQueue<T> f255b = new LinkedBlockingQueue();

    private d(int i) {
        this.a = i;
    }

    public static d a(int i) {
        return new d(i);
    }

    public T a() {
        return this.f255b.poll();
    }

    public boolean a(T t) {
        if (t == null) {
            return false;
        }
        t.a();
        if (this.f255b.size() >= this.a) {
            return false;
        }
        return this.f255b.offer(t);
    }
}
