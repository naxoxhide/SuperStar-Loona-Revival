package com.applovin.impl.sdk.utils;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class r {
    private Timer aWa;
    private long aWb;
    private long aWc;
    private final Object amW = new Object();
    private final com.applovin.impl.sdk.n sdk;
    private long startTimeMillis;
    private final Runnable v;

    public static r b(long j, com.applovin.impl.sdk.n nVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
        r rVar = new r(nVar, runnable);
        rVar.startTimeMillis = System.currentTimeMillis();
        rVar.aWb = j;
        try {
            Timer timer = new Timer();
            rVar.aWa = timer;
            timer.schedule(rVar.Lr(), j);
        } catch (OutOfMemoryError e) {
            nVar.BL();
            if (com.applovin.impl.sdk.x.Fk()) {
                nVar.BL().c("Timer", "Failed to create timer due to OOM error", e);
            }
        }
        return rVar;
    }

    private r(com.applovin.impl.sdk.n nVar, Runnable runnable) {
        this.sdk = nVar;
        this.v = runnable;
    }

    public long AF() {
        if (this.aWa != null) {
            return this.aWb - (System.currentTimeMillis() - this.startTimeMillis);
        }
        return this.aWb - this.aWc;
    }

    public void pause() {
        synchronized (this.amW) {
            Timer timer = this.aWa;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.aWc = Math.max(1L, System.currentTimeMillis() - this.startTimeMillis);
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.n nVar = this.sdk;
                        if (nVar != null) {
                            nVar.BL();
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.sdk.BL();
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.sdk.BL().c("Timer", "Encountered error while pausing timer", th);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        this.aWa = null;
                        throw th2;
                    }
                }
                this.aWa = null;
            }
        }
    }

    public void resume() {
        synchronized (this.amW) {
            long j = this.aWc;
            if (j > 0) {
                try {
                    long j2 = this.aWb - j;
                    this.aWb = j2;
                    if (j2 < 0) {
                        this.aWb = 0L;
                    }
                    Timer timer = new Timer();
                    this.aWa = timer;
                    timer.schedule(Lr(), this.aWb);
                    this.startTimeMillis = System.currentTimeMillis();
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.n nVar = this.sdk;
                        if (nVar != null) {
                            nVar.BL();
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.sdk.BL();
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.sdk.BL().c("Timer", "Encountered error while resuming timer", th);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        this.aWc = 0L;
                        throw th2;
                    }
                }
                this.aWc = 0L;
            }
        }
    }

    public void tT() {
        synchronized (this.amW) {
            Timer timer = this.aWa;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.aWa = null;
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.n nVar = this.sdk;
                        if (nVar != null) {
                            nVar.BL();
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.sdk.BL();
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.sdk.BL().c("Timer", "Encountered error while cancelling timer", th);
                                }
                            }
                        }
                        this.aWa = null;
                    } catch (Throwable th2) {
                        this.aWa = null;
                        this.aWc = 0L;
                        throw th2;
                    }
                }
                this.aWc = 0L;
            }
        }
    }

    private TimerTask Lr() {
        return new TimerTask() { // from class: com.applovin.impl.sdk.utils.r.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    r.this.v.run();
                    synchronized (r.this.amW) {
                        r.this.aWa = null;
                    }
                } catch (Throwable th) {
                    try {
                        if (r.this.sdk != null) {
                            r.this.sdk.BL();
                            if (com.applovin.impl.sdk.x.Fk()) {
                                r.this.sdk.BL();
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    r.this.sdk.BL().c("Timer", "Encountered error while executing timed task", th);
                                }
                            }
                        }
                    } finally {
                        synchronized (r.this.amW) {
                            r.this.aWa = null;
                        }
                    }
                }
            }
        };
    }
}
