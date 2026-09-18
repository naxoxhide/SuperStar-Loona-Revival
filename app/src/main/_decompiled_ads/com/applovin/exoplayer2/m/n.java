package com.applovin.exoplayer2.m;

import android.os.Handler;
import android.os.SystemClock;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;

/* JADX INFO: loaded from: classes.dex */
public interface n {
    default void a(long j, int i) {
    }

    default void a(com.applovin.exoplayer2.c.e eVar) {
    }

    default void a(o oVar) {
    }

    default void a(v vVar, com.applovin.exoplayer2.c.h hVar) {
    }

    default void a(Exception exc) {
    }

    default void a(Object obj, long j) {
    }

    default void a(String str, long j, long j2) {
    }

    default void b(int i, long j) {
    }

    default void b(com.applovin.exoplayer2.c.e eVar) {
    }

    default void r(String str) {
    }

    @Deprecated
    default void y(v vVar) {
    }

    public static final class a {
        private final n afj;
        private final Handler jS;

        public a(Handler handler, n nVar) {
            this.jS = nVar != null ? (Handler) com.applovin.exoplayer2.l.a.checkNotNull(handler) : null;
            this.afj = nVar;
        }

        public void e(final com.applovin.exoplayer2.c.e eVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$LTaYp_NrbnX30dhvt-SN2IQajbY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.h(eVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(com.applovin.exoplayer2.c.e eVar) {
            ((n) ai.R(this.afj)).a(eVar);
        }

        public void c(final String str, final long j, final long j2) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$IpJ0JOGRu26SL4_hpDiPGCkeDcw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(str, j, j2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, long j, long j2) {
            ((n) ai.R(this.afj)).a(str, j, j2);
        }

        public void c(final v vVar, final com.applovin.exoplayer2.c.h hVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$_K7nfz0_vTQas6maV4HGop0Dhzw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(vVar, hVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(v vVar, com.applovin.exoplayer2.c.h hVar) {
            ((n) ai.R(this.afj)).y(vVar);
            ((n) ai.R(this.afj)).a(vVar, hVar);
        }

        public void l(final int i, final long j) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$8k_h5eBkvtqMSwDYQhTxGPJoZaE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m(i, j);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(int i, long j) {
            ((n) ai.R(this.afj)).b(i, j);
        }

        public void f(final long j, final int i) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$KbEgC_lzrZCL5V-2WbLBa36Ljbg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.g(j, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(long j, int i) {
            ((n) ai.R(this.afj)).a(j, i);
        }

        public void b(final o oVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$kgapDDuNkUvk3rlKjwKS6fmWQBo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(oVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(o oVar) {
            ((n) ai.R(this.afj)).a(oVar);
        }

        public void T(final Object obj) {
            if (this.jS != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.jS.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$PcRiw37HYxSkuo8X_geVvVZUAKU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(obj, jElapsedRealtime);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Object obj, long j) {
            ((n) ai.R(this.afj)).a(obj, j);
        }

        public void t(final String str) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$9s35KTfbpT8svthiP6B4deatlJ8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.bp(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void bp(String str) {
            ((n) ai.R(this.afj)).r(str);
        }

        public void f(final com.applovin.exoplayer2.c.e eVar) {
            eVar.he();
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$C77vcpuiZUEMNhspzIZymHgttW4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.i(eVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(com.applovin.exoplayer2.c.e eVar) {
            eVar.he();
            ((n) ai.R(this.afj)).b(eVar);
        }

        public void k(final Exception exc) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.m.-$$Lambda$n$a$D5D07Xi5wVrNxJ5zZf6uAVqC9r8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.l(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(Exception exc) {
            ((n) ai.R(this.afj)).a(exc);
        }
    }
}
