package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutorDelivery.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements c {
    private final String a = d.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f2130b;

    public d(final Handler handler) {
        this.f2130b = new Executor() { // from class: com.mbridge.msdk.foundation.same.net.d.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(i<?> iVar, k<?> kVar) {
        Executor executor = this.f2130b;
        if (executor != null) {
            executor.execute(new a(iVar, kVar));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(i<?> iVar, com.mbridge.msdk.foundation.same.net.a.a aVar) {
        if (this.f2130b != null) {
            this.f2130b.execute(new a(iVar, k.a(aVar)));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(final i<?> iVar) {
        Executor executor = this.f2130b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.p();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void b(final i<?> iVar) {
        Executor executor = this.f2130b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.n();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void c(final i<?> iVar) {
        Executor executor = this.f2130b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.o();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void d(final i<?> iVar) {
        Executor executor = this.f2130b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.5
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.r();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void e(final i<?> iVar) {
        Executor executor = this.f2130b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.6
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.q();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(final i<?> iVar, final long j, final long j2) {
        Executor executor = this.f2130b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.7
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.a(j, j2);
                }
            });
        }
    }

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f2138b;
        private final k c;

        public a(i iVar, k kVar) {
            this.f2138b = iVar;
            this.c = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f2138b.c()) {
                this.f2138b.a("canceled-at-delivery");
                this.f2138b.n();
                return;
            }
            if (this.c.f2154b == null) {
                this.f2138b.a(this.c);
            } else {
                this.f2138b.a(this.c.f2154b);
            }
            this.f2138b.a("done");
            this.f2138b.p();
        }
    }
}
