package b.b.a.a.k;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ADThreadPoolExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class a extends ThreadPoolExecutor {
    private String a;

    /* JADX INFO: renamed from: b.b.a.a.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ADThreadPoolExecutor.java */
    class C0047a extends g {
        final /* synthetic */ Runnable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0047a(a aVar, String str, Runnable runnable) {
            super(str);
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }
    }

    /* JADX INFO: compiled from: ADThreadPoolExecutor.java */
    public static class b {
        private RejectedExecutionHandler h;
        private String a = "io";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f246b = 1;
        private long c = 30;
        private TimeUnit d = TimeUnit.SECONDS;
        private int e = Integer.MAX_VALUE;
        private BlockingQueue<Runnable> f = null;
        private ThreadFactory g = null;
        private int i = 5;

        public b a(String str) {
            this.a = str;
            return this;
        }

        public b b(int i) {
            this.i = i;
            return this;
        }

        public b a(int i) {
            this.f246b = i;
            return this;
        }

        public b a(long j) {
            this.c = j;
            return this;
        }

        public b a(TimeUnit timeUnit) {
            this.d = timeUnit;
            return this;
        }

        public b a(BlockingQueue<Runnable> blockingQueue) {
            this.f = blockingQueue;
            return this;
        }

        public b a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.g == null) {
                this.g = new h(this.i, this.a);
            }
            if (this.h == null) {
                this.h = e.b();
            }
            if (this.f == null) {
                this.f = new LinkedBlockingQueue();
            }
            return new a(this.a, this.f246b, this.e, this.c, this.d, this.f, this.g, this.h);
        }
    }

    public a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.a = str;
    }

    private void a(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            a(runnable, e);
        } catch (Throwable th) {
            a(runnable, th);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!e.i() || TextUtils.isEmpty(this.a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.a;
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "io":
                a(queue, 2);
                break;
            case "log":
                a(queue, 4);
                break;
            case "aidl":
                a(queue, 2);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof g) {
            a(new b.b.a.a.k.b((g) runnable, this));
        } else {
            a(new b.b.a.a.k.b(new C0047a(this, "unknown", runnable), this));
        }
        if (!e.i() || TextUtils.isEmpty(this.a) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.a;
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "io":
                a(queue, e.a + 2, getCorePoolSize() * 2);
                break;
            case "log":
                a(queue, 8, 8);
                break;
            case "aidl":
                a(queue, 5, 5);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.a) || "aidl".equals(this.a)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return ("io".equals(this.a) || "aidl".equals(this.a)) ? Collections.emptyList() : super.shutdownNow();
    }

    private void a(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        a(runnable, (Throwable) outOfMemoryError);
    }

    private void a(Runnable runnable, Throwable th) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th2) {
            m.b("", "try exc failed", th2);
        }
    }

    private void a(BlockingQueue<Runnable> blockingQueue, int i) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() > 0) {
            return;
        }
        try {
            setCorePoolSize(i);
            m.c("ADThreadPoolExecutor", "reduceCoreThreadSize: reduce poolType =  ", this.a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
        } catch (Exception e) {
            m.d("ADThreadPoolExecutor", e.getMessage());
        }
    }

    private void a(BlockingQueue<Runnable> blockingQueue, int i, int i2) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() < i2) {
            return;
        }
        try {
            setCorePoolSize(i);
            m.c("ADThreadPoolExecutor", "increaseCoreThreadSize: increase poolType =  ", this.a, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
        } catch (Exception e) {
            m.d("ADThreadPoolExecutor", e.getMessage());
        }
    }

    public String a() {
        return this.a;
    }
}
