package com.mbridge.msdk.e;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Network.java */
/* JADX INFO: loaded from: classes4.dex */
final class n {
    private q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2047b;
    private final o c;
    private final v d;
    private final int e;
    private com.mbridge.msdk.e.a.n f;
    private final Executor g;

    public n(int i, o oVar, v vVar, int i2) {
        this.f2047b = i;
        this.c = oVar;
        this.d = vVar;
        this.e = i2;
        this.g = new ThreadPoolExecutor(1, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.e.n.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeReportResponseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(q qVar) {
        this.a = qVar;
    }

    public final void a(s sVar, Map<String, String> map, boolean z) {
        u uVar;
        if (y.a(map)) {
            q qVar = this.a;
            if (qVar != null) {
                try {
                    qVar.a(sVar, 0, "params is null");
                    return;
                } catch (Exception e) {
                    if (com.mbridge.msdk.e.a.a) {
                        Log.e("TrackManager", "send error", e);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        try {
            if (!y.b(this.f)) {
                com.mbridge.msdk.e.a.a.b bVar = new com.mbridge.msdk.e.a.a.b(this.c.c());
                com.mbridge.msdk.e.a.f fVar = new com.mbridge.msdk.e.a.f(this.g);
                int i = this.f2047b;
                if (i <= 0) {
                    i = 4;
                }
                com.mbridge.msdk.e.a.n nVar = new com.mbridge.msdk.e.a.n(bVar, fVar, i, new com.mbridge.msdk.e.a.a.i());
                this.f = nVar;
                nVar.a();
            }
            if (this.e == 1) {
                uVar = new u(this.c.b(), 1, this.c.a());
            } else {
                uVar = new u(this.c.b(), 1);
            }
            uVar.a(map);
            uVar.a(false);
            uVar.b(true);
            uVar.c(true);
            uVar.a(this.d);
            uVar.a(z ? com.mbridge.msdk.e.a.m.b.HIGH : com.mbridge.msdk.e.a.m.b.NORMAL);
            uVar.a((com.mbridge.msdk.e.a.o.b) new b(this.a, sVar));
            uVar.a((com.mbridge.msdk.e.a.o.a) new a(this.a, sVar));
            this.f.a(uVar);
        } catch (Exception e2) {
            if (com.mbridge.msdk.e.a.a) {
                Log.e("TrackManager", "send error", e2);
            }
            if (y.b(this.a)) {
                this.a.a(sVar, 0, e2.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: Network.java */
    private static final class b implements com.mbridge.msdk.e.a.o.b {
        private final q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s f2049b;

        public b(q qVar, s sVar) {
            this.a = qVar;
            this.f2049b = sVar;
        }

        @Override // com.mbridge.msdk.e.a.o.b
        public final void a(Object obj) {
            if (y.b(this.a)) {
                try {
                    this.a.a(this.f2049b);
                } catch (Exception e) {
                    if (com.mbridge.msdk.e.a.a) {
                        Log.e("TrackManager", "onResponse error", e);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: Network.java */
    private static final class a implements com.mbridge.msdk.e.a.o.a {
        private final q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s f2048b;

        public a(q qVar, s sVar) {
            this.a = qVar;
            this.f2048b = sVar;
        }

        @Override // com.mbridge.msdk.e.a.o.a
        public final void a(com.mbridge.msdk.e.a.u uVar) {
            if (y.b(this.a)) {
                try {
                    this.a.a(this.f2048b, 0, uVar.getMessage());
                } catch (Exception e) {
                    if (com.mbridge.msdk.e.a.a) {
                        Log.e("TrackManager", "onErrorResponse error", e);
                    }
                }
            }
        }
    }
}
