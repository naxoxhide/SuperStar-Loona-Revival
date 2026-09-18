package com.mbridge.msdk.e.a;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: NetworkDispatcher.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends Thread {
    private final BlockingQueue<m<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f2027b;
    private final a c;
    private final q d;
    private volatile boolean e = false;

    public i(BlockingQueue<m<?>> blockingQueue, h hVar, a aVar, q qVar) {
        this.a = blockingQueue;
        this.f2027b = hVar;
        this.c = aVar;
        this.d = qVar;
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m<?> mVarTake = this.a.take();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                mVarTake.a(3);
                try {
                    try {
                        if (mVarTake.l()) {
                            mVarTake.a("network-discard-cancelled");
                            mVarTake.u();
                        } else {
                            TrafficStats.setThreadStatsTag(mVarTake.g());
                            k kVarA = this.f2027b.a(mVarTake);
                            if (kVarA.e && mVarTake.t()) {
                                mVarTake.a("not-modified");
                                mVarTake.u();
                            } else {
                                o<?> oVarA = mVarTake.a(kVarA);
                                if (mVarTake.o() && oVarA.f2032b != null) {
                                    this.c.a(mVarTake.i(), oVarA.f2032b);
                                }
                                mVarTake.s();
                                this.d.a(mVarTake, oVarA);
                                mVarTake.a(oVarA);
                            }
                        }
                    } catch (u e) {
                        e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                        this.d.a(mVarTake, e);
                        mVarTake.u();
                    } catch (Exception e2) {
                        v.a(e2, "Unhandled exception %s", e2.toString());
                        u uVar = new u(e2);
                        uVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                        this.d.a(mVarTake, uVar);
                        mVarTake.u();
                    }
                    mVarTake.a(4);
                } catch (Throwable th) {
                    mVarTake.a(4);
                    throw th;
                }
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
