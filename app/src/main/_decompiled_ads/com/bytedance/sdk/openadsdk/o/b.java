package com.bytedance.sdk.openadsdk.o;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CrashMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f812b;
    private InterfaceC0249b d;
    private ScheduledExecutorService a = null;
    private long c = 0;

    /* JADX INFO: compiled from: CrashMonitor.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - b.this.c > 2000) {
                b.this.a.shutdown();
                if (b.this.f812b != null) {
                    b.this.f812b.w();
                }
                if (b.this.d != null) {
                    b.this.d.a();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.o.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CrashMonitor.java */
    public interface InterfaceC0249b {
        void a();
    }

    public b(g gVar) {
        this.f812b = gVar;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(int i) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.a = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new a(), 0L, i, TimeUnit.MILLISECONDS);
    }

    public void a() {
        ScheduledExecutorService scheduledExecutorService = this.a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
