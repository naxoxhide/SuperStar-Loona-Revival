package com.kakao.adfit.common.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: CacheDispatcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends Thread {
    private static final boolean g = h.f1727b;
    private final BlockingQueue<e<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<e<?>> f1717b;
    private final com.kakao.adfit.common.volley.a c;
    private final com.kakao.adfit.m.e d;
    private volatile boolean e = false;
    private final i f;

    /* JADX INFO: compiled from: CacheDispatcher.java */
    class a implements Runnable {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.f1717b.put(this.a);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public b(BlockingQueue<e<?>> blockingQueue, BlockingQueue<e<?>> blockingQueue2, com.kakao.adfit.common.volley.a aVar, com.kakao.adfit.m.e eVar) {
        this.a = blockingQueue;
        this.f1717b = blockingQueue2;
        this.c = aVar;
        this.d = eVar;
        this.f = new i(this, blockingQueue2, eVar);
    }

    public void b() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (g) {
            h.d("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.c.a();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                h.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void a() {
        a(this.a.take());
    }

    void a(e<?> eVar) {
        eVar.a("cache-queue-take");
        eVar.a(1);
        try {
            if (eVar.s()) {
                eVar.c("cache-discard-canceled");
                return;
            }
            com.kakao.adfit.common.volley.a.C0448a c0448aA = this.c.a(eVar.e());
            if (c0448aA == null) {
                eVar.a("cache-miss");
                if (!this.f.b(eVar)) {
                    this.f1717b.put(eVar);
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (c0448aA.a(jCurrentTimeMillis)) {
                eVar.a("cache-hit-expired");
                eVar.a(c0448aA);
                if (!this.f.b(eVar)) {
                    this.f1717b.put(eVar);
                }
                return;
            }
            eVar.a("cache-hit");
            g<?> gVarA = eVar.a(new com.kakao.adfit.m.d(c0448aA.a, c0448aA.g));
            eVar.a("cache-hit-parsed");
            if (!gVarA.a()) {
                eVar.a("cache-parsing-failed");
                this.c.a(eVar.e(), true);
                eVar.a((com.kakao.adfit.common.volley.a.C0448a) null);
                if (!this.f.b(eVar)) {
                    this.f1717b.put(eVar);
                }
                return;
            }
            if (!c0448aA.b(jCurrentTimeMillis)) {
                this.d.a(eVar, gVarA);
            } else {
                eVar.a("cache-hit-refresh-needed");
                eVar.a(c0448aA);
                gVarA.d = true;
                if (!this.f.b(eVar)) {
                    this.d.a(eVar, gVarA, new a(eVar));
                } else {
                    this.d.a(eVar, gVarA);
                }
            }
        } finally {
            eVar.a(2);
        }
    }
}
