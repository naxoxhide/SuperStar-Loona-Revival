package b.b.a.a.f.a.p.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: NetDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends b.b.a.a.f.a.d {
    private ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<b.b.a.a.f.a.b> f156b = new CopyOnWriteArrayList();
    private List<b.b.a.a.f.a.b> c = new CopyOnWriteArrayList();
    private AtomicInteger d = new AtomicInteger(64);

    /* JADX INFO: compiled from: NetDispatcher.java */
    class a implements ThreadFactory {
        a(d dVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "systemHttp Dispatcher");
            thread.setDaemon(false);
            thread.setPriority(10);
            return thread;
        }
    }

    public d() {
        if (this.a == null) {
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new a(this));
        }
    }

    @Override // b.b.a.a.f.a.d
    public void a(int i) {
        this.d.set(i);
    }

    @Override // b.b.a.a.f.a.d
    public ExecutorService b() {
        return this.a;
    }

    @Override // b.b.a.a.f.a.d
    public List<b.b.a.a.f.a.b> c() {
        return this.f156b;
    }

    @Override // b.b.a.a.f.a.d
    public List<b.b.a.a.f.a.b> d() {
        return this.c;
    }

    @Override // b.b.a.a.f.a.d
    public int a() {
        return this.d.get();
    }
}
