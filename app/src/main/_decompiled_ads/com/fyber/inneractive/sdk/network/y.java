package com.fyber.inneractive.sdk.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Comparator;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class y {
    public static final ThreadFactory g = new a();
    public BlockingQueue<c0<?>> a = new PriorityBlockingQueue(100, new d(null));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f999b = false;
    public final Handler c = new Handler(Looper.getMainLooper());
    public final ThreadPoolExecutor d = new ThreadPoolExecutor(6, 6, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100), g);
    public final Runnable e = new b();
    public r0 f = new r0();

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(100);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format(Locale.ENGLISH, "FyberMarketplace-Network-%02d", Integer.valueOf(this.a.getAndIncrement())));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            c0<?> c0VarTake;
            com.fyber.inneractive.sdk.network.a<?> aVarK;
            b0 b0VarA;
            Throwable th;
            y yVar = y.this;
            yVar.getClass();
            Process.setThreadPriority(10);
            while (yVar.f999b) {
                b0 b0Var = null;
                try {
                    c0VarTake = yVar.a.take();
                } catch (InterruptedException unused) {
                    if (!yVar.f999b) {
                        Thread.currentThread().interrupt();
                    }
                    c0VarTake = null;
                }
                if (c0VarTake != null && !c0VarTake.g()) {
                    c0VarTake.a(q0.RUNNING);
                    if (yVar.e(c0VarTake)) {
                        r0 r0Var = yVar.f;
                        Thread threadCurrentThread = Thread.currentThread();
                        r0Var.getClass();
                        IAlog.a("%s : NetworkRequestWatchdog : register request: %s", IAlog.a(r0Var), c0VarTake.f());
                        int iH = c0VarTake.h();
                        t0 t0VarN = c0VarTake.n();
                        u0 u0Var = new u0(c0VarTake, threadCurrentThread, t0VarN.a + t0VarN.f994b + iH);
                        r0Var.a.putIfAbsent(c0VarTake.f(), u0Var);
                        com.fyber.inneractive.sdk.util.m.f1343b.postDelayed(u0Var.d, u0Var.c);
                    }
                    try {
                        aVarK = (c0VarTake.g() || c0VarTake.c() == null) ? null : c0VarTake.k();
                    } catch (Exception e) {
                        IAlog.a("failed fetching cache data", e, new Object[0]);
                        if (!c0VarTake.g()) {
                            c0VarTake.a((Object) null, e, true);
                        }
                    }
                    if (aVarK != null && aVarK.f979b != 0 && !c0VarTake.g()) {
                        c0VarTake.a(aVarK.f979b, (Exception) null, true);
                    }
                    try {
                        j jVarA = yVar.a(c0VarTake, aVarK);
                        b0VarA = yVar.a(c0VarTake, jVarA);
                        try {
                            try {
                                yVar.a(c0VarTake, jVarA, b0VarA);
                                yVar.a(c0VarTake, b0VarA);
                                yVar.a(c0VarTake);
                                yVar.c(c0VarTake);
                            } catch (z0 unused2) {
                                b0Var = b0VarA;
                                b0VarA = b0Var;
                                yVar.a(c0VarTake, b0VarA);
                                yVar.a(c0VarTake);
                                yVar.c(c0VarTake);
                            } catch (Exception e2) {
                                e = e2;
                                if (!c0VarTake.g()) {
                                    c0VarTake.a((Object) null, e, false);
                                }
                                yVar.a(c0VarTake, b0VarA);
                                yVar.a(c0VarTake);
                                yVar.c(c0VarTake);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            yVar.a(c0VarTake, b0VarA);
                            yVar.a(c0VarTake);
                            yVar.c(c0VarTake);
                            throw th;
                        }
                    } catch (z0 unused3) {
                    } catch (Exception e3) {
                        e = e3;
                        b0VarA = null;
                    } catch (Throwable th3) {
                        b0VarA = null;
                        th = th3;
                    }
                }
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ c0 a;

        public c(c0 c0Var) {
            this.a = c0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            IAlog.d("retryNetworkRequest pre-execute - %s", this.a.getClass().getName());
            y.this.b(this.a);
        }
    }

    public static class d implements Comparator<c0> {
        public d() {
        }

        @Override // java.util.Comparator
        public int compare(c0 c0Var, c0 c0Var2) {
            return c0Var.i().ordinal() - c0Var2.i().ordinal();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public final void a(c0<?> c0Var) {
        try {
            c0Var.b();
        } catch (Exception unused) {
        }
        c0Var.a(q0.DONE);
    }

    public void b(c0<?> c0Var) {
        this.a.offer(c0Var);
        c0Var.a(q0.QUEUED);
    }

    public final <T> void c(c0<T> c0Var) {
        r0 r0Var = this.f;
        r0Var.getClass();
        String strF = c0Var.f();
        IAlog.a("%s : NetworkRequestWatchdog : finalize request: %s", IAlog.a(r0Var), strF);
        u0 u0Var = r0Var.a.get(strF);
        if (u0Var != null) {
            com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(u0Var.d);
        }
        r0Var.a.remove(strF);
    }

    public boolean d(c0<?> c0Var) {
        if (!c0Var.o()) {
            return false;
        }
        c0Var.a(q0.QUEUED_FOR_RETRY);
        long jV = c0Var.v();
        IAlog.d("retryNetworkRequest queue up in main thread - %s with delay of %d", c0Var.getClass().getName(), Long.valueOf(jV));
        this.c.postDelayed(new c(c0Var), jV);
        return true;
    }

    public final <T> boolean e(c0<T> c0Var) {
        boolean z = c0Var.s() || c0Var.j();
        IAlog.a("%s : NetworkExecutorImpl : should enabled watchdog : %s", IAlog.a(this), Boolean.valueOf(z));
        return z;
    }

    public final <T> void a(c0<T> c0Var, b0 b0Var) {
        try {
            if (c0Var.g() || b0Var == null) {
                return;
            }
            c0Var.a((Object) b0Var.a, (Exception) null, false);
        } catch (Exception e) {
            IAlog.a("failed notifying the listener request complete", e, new Object[0]);
            if (c0Var.g()) {
                return;
            }
            c0Var.a((Object) null, e, false);
        }
    }

    public final <T> void a(c0<T> c0Var, j jVar, b0 b0Var) {
        try {
            if (c0Var.g() || c0Var.c() == null || b0Var == null || jVar == null || jVar.a != 200) {
                return;
            }
            c0Var.a(b0Var, c0Var.c(), jVar.e);
        } catch (Exception e) {
            IAlog.a("Failed cache network response data", e, new Object[0]);
        }
    }

    public final <T> b0 a(c0<T> c0Var, j jVar) throws Exception {
        b0 b0VarA = null;
        if (jVar != null) {
            try {
                if (!c0Var.g()) {
                    int i = jVar.a;
                    if (i == 200 || (i >= 300 && i < 304)) {
                        b0VarA = c0Var.a(jVar, jVar.d, i);
                    } else if (i == 304) {
                        c0Var.a((Object) null, (Exception) new f(), false);
                    } else {
                        c0Var.a((Object) null, (Exception) new s0(jVar.a, jVar.f987b), false);
                    }
                }
            } catch (z0 e) {
                IAlog.a("failed parsing network request but will retry", e, new Object[0]);
                if (d(c0Var)) {
                    throw e;
                }
                throw new y0(e);
            } catch (Exception e2) {
                IAlog.a("failed parsing network request", e2, new Object[0]);
                throw e2;
            }
        }
        return b0VarA;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0031  */
    /* JADX WARN: Code duplicated, block: B:24:0x0037  */
    public final j a(c0<?> c0Var, com.fyber.inneractive.sdk.network.a<?> aVar) throws Exception {
        try {
            if (c0Var.g()) {
                return null;
            }
            String str = aVar != null ? aVar.a : "";
            a();
            return c0Var.a(str);
        } catch (com.fyber.inneractive.sdk.network.b e) {
            e = e;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(c0Var)) {
                throw new z0(e);
            }
            throw new y0(e);
        } catch (z0 e2) {
            IAlog.a("failed sending network request but will retry", e2, new Object[0]);
            if (d(c0Var)) {
                throw e2;
            }
            throw new y0(e2);
        } catch (SocketTimeoutException e3) {
            e = e3;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(c0Var)) {
                throw new z0(e);
            }
            throw new y0(e);
        } catch (UnknownHostException e4) {
            e = e4;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(c0Var)) {
                throw new z0(e);
            }
            throw new y0(e);
        } catch (Exception e5) {
            IAlog.a("failed sending network request", e5, new Object[0]);
            throw e5;
        }
    }

    public final void a() throws com.fyber.inneractive.sdk.network.b {
        boolean z = false;
        if (((com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.M.L.a(com.fyber.inneractive.sdk.config.global.features.k.class)).a("should_use_is_network_connected", false)) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) com.fyber.inneractive.sdk.util.l.a.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (com.fyber.inneractive.sdk.util.l.b("android.permission.ACCESS_NETWORK_STATE") && activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    z = true;
                }
            } catch (Throwable unused) {
                IAlog.b("Error retrieved when trying to get the network state - Perhaps you forgot to declare android.permission.ACCESS_NETWORK_STATE in your Android manifest file.", new Object[0]);
            }
            if (!z) {
                throw new com.fyber.inneractive.sdk.network.b("No network connection");
            }
        }
    }
}
