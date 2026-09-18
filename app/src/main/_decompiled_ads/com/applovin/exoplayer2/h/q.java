package com.applovin.exoplayer2.h;

import android.os.Handler;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface q {
    default void a(int i, p.a aVar, j jVar, m mVar) {
    }

    default void a(int i, p.a aVar, j jVar, m mVar, IOException iOException, boolean z) {
    }

    default void a(int i, p.a aVar, m mVar) {
    }

    default void b(int i, p.a aVar, j jVar, m mVar) {
    }

    default void c(int i, p.a aVar, j jVar, m mVar) {
    }

    public static class a {
        private final long LN;
        public final int cN;
        public final p.a jj;
        private final CopyOnWriteArrayList<C0097a> tg;

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private a(CopyOnWriteArrayList<C0097a> copyOnWriteArrayList, int i, p.a aVar, long j) {
            this.tg = copyOnWriteArrayList;
            this.cN = i;
            this.jj = aVar;
            this.LN = j;
        }

        public a b(int i, p.a aVar, long j) {
            return new a(this.tg, i, aVar, j);
        }

        public void a(Handler handler, q qVar) {
            com.applovin.exoplayer2.l.a.checkNotNull(handler);
            com.applovin.exoplayer2.l.a.checkNotNull(qVar);
            this.tg.add(new C0097a(handler, qVar));
        }

        public void a(q qVar) {
            for (C0097a c0097a : this.tg) {
                if (c0097a.LO == qVar) {
                    this.tg.remove(c0097a);
                }
            }
        }

        public void a(j jVar, int i, int i2, com.applovin.exoplayer2.v vVar, int i3, Object obj, long j, long j2) {
            a(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)));
        }

        public void a(final j jVar, final m mVar) {
            for (C0097a c0097a : this.tg) {
                final q qVar = c0097a.LO;
                ai.a(c0097a.jS, new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$q$a$BT8fnZmInhJnthnZdwSEfEAuW0Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(qVar, jVar, mVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(q qVar, j jVar, m mVar) {
            qVar.a(this.cN, this.jj, jVar, mVar);
        }

        public void b(j jVar, int i, int i2, com.applovin.exoplayer2.v vVar, int i3, Object obj, long j, long j2) {
            b(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)));
        }

        public void b(final j jVar, final m mVar) {
            for (C0097a c0097a : this.tg) {
                final q qVar = c0097a.LO;
                ai.a(c0097a.jS, new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$q$a$z2AJHxiwslSUb8go-c8LXuBtTh4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(qVar, jVar, mVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(q qVar, j jVar, m mVar) {
            qVar.b(this.cN, this.jj, jVar, mVar);
        }

        public void c(j jVar, int i, int i2, com.applovin.exoplayer2.v vVar, int i3, Object obj, long j, long j2) {
            c(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)));
        }

        public void c(final j jVar, final m mVar) {
            for (C0097a c0097a : this.tg) {
                final q qVar = c0097a.LO;
                ai.a(c0097a.jS, new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$q$a$BVDxWAVEJWEgC_hJOHRr-nb4QT4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(qVar, jVar, mVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(q qVar, j jVar, m mVar) {
            qVar.c(this.cN, this.jj, jVar, mVar);
        }

        public void a(j jVar, int i, int i2, com.applovin.exoplayer2.v vVar, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
            a(jVar, new m(i, i2, vVar, i3, obj, aW(j), aW(j2)), iOException, z);
        }

        public void a(final j jVar, final m mVar, final IOException iOException, final boolean z) {
            for (C0097a c0097a : this.tg) {
                final q qVar = c0097a.LO;
                ai.a(c0097a.jS, new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$q$a$qqIPc1nnVzIyoZItoZxi1zNhy_k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(qVar, jVar, mVar, iOException, z);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(q qVar, j jVar, m mVar, IOException iOException, boolean z) {
            qVar.a(this.cN, this.jj, jVar, mVar, iOException, z);
        }

        public void a(int i, com.applovin.exoplayer2.v vVar, int i2, Object obj, long j) {
            b(new m(1, i, vVar, i2, obj, aW(j), -9223372036854775807L));
        }

        public void b(final m mVar) {
            for (C0097a c0097a : this.tg) {
                final q qVar = c0097a.LO;
                ai.a(c0097a.jS, new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$q$a$ITsJWI0-hLUuGLjUTR_i35ykUYA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(qVar, mVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(q qVar, m mVar) {
            qVar.a(this.cN, this.jj, mVar);
        }

        private long aW(long j) {
            long jF = com.applovin.exoplayer2.h.f(j);
            if (jF == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.LN + jF;
        }

        /* JADX INFO: renamed from: com.applovin.exoplayer2.h.q$a$a, reason: collision with other inner class name */
        private static final class C0097a {
            public q LO;
            public Handler jS;

            public C0097a(Handler handler, q qVar) {
                this.jS = handler;
                this.LO = qVar;
            }
        }
    }
}
