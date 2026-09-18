package com.mbridge.msdk.e.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: CacheDispatcher.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends Thread {
    private final BlockingQueue<m<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<m<?>> f2021b;
    private final a c;
    private final q d;
    private volatile boolean e = false;
    private final w f;

    public b(BlockingQueue<m<?>> blockingQueue, BlockingQueue<m<?>> blockingQueue2, a aVar, q qVar) {
        this.a = blockingQueue;
        this.f2021b = blockingQueue2;
        this.c = aVar;
        this.d = qVar;
        this.f = new w(this, blockingQueue2, qVar);
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        this.c.a();
        while (true) {
            try {
                final m<?> mVarTake = this.a.take();
                mVarTake.a(1);
                try {
                    if (mVarTake.l()) {
                        mVarTake.a("cache-discard-canceled");
                    } else {
                        a.C0475a c0475aA = this.c.a(mVarTake.i());
                        if (c0475aA == null) {
                            if (!this.f.b(mVarTake)) {
                                this.f2021b.put(mVarTake);
                            }
                        } else {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (c0475aA.a(jCurrentTimeMillis)) {
                                mVarTake.a(c0475aA);
                                if (!this.f.b(mVarTake)) {
                                    this.f2021b.put(mVarTake);
                                }
                            } else {
                                o<?> oVarA = mVarTake.a(new k(200, c0475aA.a, false, 0L, c0475aA.h));
                                p pVarJ = mVarTake.j();
                                if (!(pVarJ == null || pVarJ.a(oVarA, mVarTake))) {
                                    this.c.a(mVarTake.i(), true);
                                    mVarTake.a((a.C0475a) null);
                                    if (!this.f.b(mVarTake)) {
                                        this.f2021b.put(mVarTake);
                                    }
                                } else if (oVarA.a()) {
                                    if (!(c0475aA.f < jCurrentTimeMillis)) {
                                        this.d.a(mVarTake, oVarA);
                                    } else {
                                        mVarTake.a(c0475aA);
                                        oVarA.d = true;
                                        if (!this.f.b(mVarTake)) {
                                            this.d.a(mVarTake, oVarA, new Runnable() { // from class: com.mbridge.msdk.e.a.b.1
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    try {
                                                        b.this.f2021b.put(mVarTake);
                                                    } catch (InterruptedException unused) {
                                                        Thread.currentThread().interrupt();
                                                    }
                                                }
                                            });
                                        } else {
                                            this.d.a(mVarTake, oVarA);
                                        }
                                    }
                                } else {
                                    this.c.a(mVarTake.i(), true);
                                    mVarTake.a((a.C0475a) null);
                                    if (!this.f.b(mVarTake)) {
                                        this.f2021b.put(mVarTake);
                                    }
                                }
                            }
                        }
                    }
                    mVarTake.a(2);
                } catch (Throwable th) {
                    mVarTake.a(2);
                    throw th;
                }
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
