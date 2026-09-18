package com.applovin.exoplayer2.b;

import android.os.Handler;
import com.applovin.exoplayer2.l.ai;

/* JADX INFO: loaded from: classes.dex */
public interface g {
    default void A(boolean z) {
    }

    default void a(int i, long j, long j2) {
    }

    default void b(com.applovin.exoplayer2.v vVar, com.applovin.exoplayer2.c.h hVar) {
    }

    default void b(Exception exc) {
    }

    default void b(String str, long j, long j2) {
    }

    default void c(com.applovin.exoplayer2.c.e eVar) {
    }

    @Deprecated
    default void c(com.applovin.exoplayer2.v vVar) {
    }

    default void c(Exception exc) {
    }

    default void d(com.applovin.exoplayer2.c.e eVar) {
    }

    default void s(String str) {
    }

    default void z(long j) {
    }

    public static final class a {
        private final Handler jS;
        private final g jT;

        public a(Handler handler, g gVar) {
            this.jS = gVar != null ? (Handler) com.applovin.exoplayer2.l.a.checkNotNull(handler) : null;
            this.jT = gVar;
        }

        public void e(final com.applovin.exoplayer2.c.e eVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$o79qqe2gw02oNNk5LkAM5CciTbM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.h(eVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(com.applovin.exoplayer2.c.e eVar) {
            ((g) ai.R(this.jT)).c(eVar);
        }

        public void c(final String str, final long j, final long j2) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$uaCOnoG-UwfhY20_5ucA2xDaT50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(str, j, j2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, long j, long j2) {
            ((g) ai.R(this.jT)).b(str, j, j2);
        }

        public void c(final com.applovin.exoplayer2.v vVar, final com.applovin.exoplayer2.c.h hVar) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$fX3R95nO7Q-TOJqW1sNzNfz63oQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(vVar, hVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(com.applovin.exoplayer2.v vVar, com.applovin.exoplayer2.c.h hVar) {
            ((g) ai.R(this.jT)).c(vVar);
            ((g) ai.R(this.jT)).b(vVar, hVar);
        }

        public void C(final long j) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$_Wx3ocLEsmCB7CDYK1x0TS-FxOM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.D(j);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(long j) {
            ((g) ai.R(this.jT)).z(j);
        }

        public void c(final int i, final long j, final long j2) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$f8A7SaN7mHWy1RwdnC4yrhek_4k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(i, j, j2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i, long j, long j2) {
            ((g) ai.R(this.jT)).a(i, j, j2);
        }

        public void t(final String str) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$LgoAvxrP-TR9Yl8QCEsa3kKNxa0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.u(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((g) ai.R(this.jT)).s(str);
        }

        public void f(final com.applovin.exoplayer2.c.e eVar) {
            eVar.he();
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$aDRciYDWM9R5Sg5kIWKcaC_qQ2M
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.g(eVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(com.applovin.exoplayer2.c.e eVar) {
            eVar.he();
            ((g) ai.R(this.jT)).d(eVar);
        }

        public void D(final boolean z) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$RQbZCznWhdbxmnK7LFqUU6kzXb8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.E(z);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E(boolean z) {
            ((g) ai.R(this.jT)).A(z);
        }

        public void d(final Exception exc) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$USTvEuwbnnyMQpOj7by3t91PDyY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.g(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Exception exc) {
            ((g) ai.R(this.jT)).b(exc);
        }

        public void e(final Exception exc) {
            Handler handler = this.jS;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.exoplayer2.b.-$$Lambda$g$a$AMxkRGlc_LkAYA2Wg145iU_kHwc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.f(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Exception exc) {
            ((g) ai.R(this.jT)).c(exc);
        }
    }
}
