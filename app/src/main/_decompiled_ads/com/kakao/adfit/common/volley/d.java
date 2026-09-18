package com.kakao.adfit.common.volley;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: NetworkDispatcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends Thread {
    private final BlockingQueue<e<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.kakao.adfit.m.c f1721b;
    private final a c;
    private final com.kakao.adfit.m.e d;
    private volatile boolean e = false;

    public d(BlockingQueue<e<?>> blockingQueue, com.kakao.adfit.m.c cVar, a aVar, com.kakao.adfit.m.e eVar) {
        this.a = blockingQueue;
        this.f1721b = cVar;
        this.c = aVar;
        this.d = eVar;
    }

    private void a(e<?> eVar) {
        TrafficStats.setThreadStatsTag(eVar.p());
    }

    public void b() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                h.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void a() {
        b(this.a.take());
    }

    void b(e<?> eVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        eVar.a(3);
        try {
            try {
                eVar.a("network-queue-take");
                if (eVar.s()) {
                    eVar.c("network-discard-cancelled");
                    eVar.u();
                    return;
                }
                a(eVar);
                com.kakao.adfit.m.d dVarA = this.f1721b.a(eVar);
                eVar.a("network-http-complete");
                if (dVarA.e && eVar.r()) {
                    eVar.c("not-modified");
                    eVar.u();
                    return;
                }
                g<?> gVarA = eVar.a(dVarA);
                eVar.a("network-parse-complete");
                if (eVar.v() && gVarA.f1726b != null) {
                    this.c.a(eVar.e(), gVarA.f1726b);
                    eVar.a("network-cache-written");
                }
                eVar.t();
                this.d.a(eVar, gVarA);
                eVar.a(gVarA);
            } catch (VolleyError e) {
                e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                a(eVar, e);
                eVar.u();
            } catch (Exception e2) {
                h.a(e2, "Unhandled exception %s", e2.toString());
                VolleyError volleyError = new VolleyError(e2);
                volleyError.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.d.a(eVar, volleyError);
                eVar.u();
            }
        } finally {
            eVar.a(4);
        }
    }

    private void a(e<?> eVar, VolleyError volleyError) {
        this.d.a(eVar, eVar.b(volleyError));
    }
}
