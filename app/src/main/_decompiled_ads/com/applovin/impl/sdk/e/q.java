package com.applovin.impl.sdk.e;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class q {
    private static final ExecutorService aTo = Executors.newFixedThreadPool(4);
    private final ScheduledThreadPoolExecutor aUg;
    private final ScheduledThreadPoolExecutor aUh;
    private final List<d> aUi = new ArrayList(5);
    private final Object aUj = new Object();
    private boolean aUk;
    private final com.applovin.impl.sdk.x logger;
    private final com.applovin.impl.sdk.n sdk;

    public enum b {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_NATIVE,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_APP_OPEN,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARDED_INTERSTITIAL,
        MEDIATION_REWARD
    }

    public q(com.applovin.impl.sdk.n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.aUg = g("auxiliary_operations", ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aMI)).intValue());
        this.aUh = g("shared_thread_pool", ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aKv)).intValue());
    }

    public boolean isInitialized() {
        return this.aUk;
    }

    public void a(com.applovin.impl.sdk.e.d dVar, b bVar) {
        a(dVar, bVar, 0L);
    }

    public void a(com.applovin.impl.sdk.e.d dVar, b bVar, long j) {
        a(dVar, bVar, j, false);
    }

    public void a(com.applovin.impl.sdk.e.d dVar, b bVar, long j, boolean z) {
        if (dVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        if (j < 0) {
            throw new IllegalArgumentException("Invalid delay (millis) specified: " + j);
        }
        d dVar2 = new d(this.sdk, dVar, bVar);
        if (!a(dVar2)) {
            a(dVar2, j, z);
        } else if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.g(dVar.Ke(), "Task execution delayed until after init");
        }
    }

    public void h(Runnable runnable) {
        this.aUg.submit(runnable);
    }

    public Executor KG() {
        return this.aUh;
    }

    public ExecutorService KH() {
        return aTo;
    }

    public ExecutorService KI() {
        return this.aUg;
    }

    public void b(com.applovin.impl.sdk.e.d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        try {
            if (com.applovin.impl.sdk.utils.u.Lv()) {
                this.aUh.submit(new d(this.sdk, dVar, b.MAIN));
            } else {
                dVar.run();
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.c(dVar.Ke(), "Task failed execution", th);
            }
            dVar.q(th);
        }
    }

    private void a(final Runnable runnable, long j, boolean z) {
        if (j <= 0) {
            this.aUh.submit(runnable);
        } else if (z) {
            com.applovin.impl.sdk.utils.f.a(j, this.sdk, new Runnable() { // from class: com.applovin.impl.sdk.e.-$$Lambda$q$23iN7dmz0hrb7dxRTOFVqzn5-Do
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i(runnable);
                }
            });
        } else {
            this.aUh.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Runnable runnable) {
        this.aUh.execute(runnable);
    }

    public ExecutorService f(String str, int i) {
        return Executors.newFixedThreadPool(i, new a(str));
    }

    public List<Future<Boolean>> a(List<com.applovin.impl.sdk.e.a> list, ExecutorService executorService) {
        try {
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("TaskManager", "Awaiting " + list.size() + " tasks...");
            }
            return executorService.invokeAll(list);
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.x.Fk()) {
                return null;
            }
            this.logger.c("TaskManager", "Awaiting tasks were interrupted", th);
            return null;
        }
    }

    public void KJ() {
        synchronized (this.aUj) {
            this.aUk = false;
        }
    }

    public void KK() {
        synchronized (this.aUj) {
            this.aUk = true;
            for (d dVar : this.aUi) {
                a(dVar.aUK, dVar.aUL);
            }
            this.aUi.clear();
        }
    }

    private boolean a(d dVar) {
        if (dVar.aUK.Kf()) {
            return false;
        }
        synchronized (this.aUj) {
            if (this.aUk) {
                return false;
            }
            this.aUi.add(dVar);
            return true;
        }
    }

    private ScheduledThreadPoolExecutor g(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new c(str));
    }

    private static class d implements Runnable {
        private final com.applovin.impl.sdk.e.d aUK;
        private final b aUL;
        private final com.applovin.impl.sdk.x logger;
        private final com.applovin.impl.sdk.n sdk;
        private final String tag;

        public d(com.applovin.impl.sdk.n nVar, com.applovin.impl.sdk.e.d dVar, b bVar) {
            this.sdk = nVar;
            this.logger = nVar.BL();
            this.tag = dVar.Ke();
            this.aUK = dVar;
            this.aUL = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.applovin.impl.sdk.x xVar;
            String str;
            StringBuilder sb;
            try {
                com.applovin.impl.sdk.utils.h.KS();
                if (!this.sdk.Bn() || this.aUK.Kf()) {
                    this.aUK.run();
                } else {
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.g(this.tag, "Task re-scheduled...");
                    }
                    this.sdk.BM().a(this.aUK, this.aUL, 2000L);
                }
                if (com.applovin.impl.sdk.x.Fk()) {
                    xVar = this.logger;
                    str = this.tag;
                    sb = new StringBuilder();
                    xVar.g(str, sb.append(this.aUL).append(" queue finished task ").append(this.aUK.Ke()).toString());
                }
            } catch (Throwable th) {
                try {
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.c(this.tag, "Task failed execution", th);
                    }
                    this.aUK.q(th);
                    if (!com.applovin.impl.sdk.x.Fk()) {
                        return;
                    }
                    xVar = this.logger;
                    str = this.tag;
                    sb = new StringBuilder();
                } catch (Throwable th2) {
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.g(this.tag, this.aUL + " queue finished task " + this.aUK.Ke());
                    }
                    throw th2;
                }
            }
        }
    }

    private class c implements ThreadFactory {
        private final String name;

        c(String str) {
            this.name = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.name);
            thread.setDaemon(true);
            thread.setPriority(((Integer) q.this.sdk.a(com.applovin.impl.sdk.c.b.aQE)).intValue());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.applovin.impl.sdk.e.q.c.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    com.applovin.impl.sdk.x unused = q.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        q.this.logger.c("TaskManager", "Caught unhandled exception", th);
                    }
                }
            });
            return thread;
        }
    }

    private class a implements ThreadFactory {
        private final AtomicInteger aUl = new AtomicInteger(1);
        private final String name;

        a(String str) {
            this.name = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.name + "-" + this.aUl.getAndIncrement());
            thread.setDaemon(true);
            thread.setPriority(((Integer) q.this.sdk.a(com.applovin.impl.sdk.c.b.aQE)).intValue());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.applovin.impl.sdk.e.q.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    q.this.sdk.BL();
                    if (com.applovin.impl.sdk.x.Fk()) {
                        q.this.sdk.BL().c("TaskManager", "Caught unhandled exception", th);
                    }
                }
            });
            return thread;
        }
    }
}
