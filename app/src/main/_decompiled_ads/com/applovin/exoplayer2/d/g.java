package com.applovin.exoplayer2.d;

import android.os.Handler;
import com.applovin.exoplayer2.l.ai;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface g {
    default void a(int i, com.applovin.exoplayer2.h.p.a aVar) {
    }

    default void a(int i, com.applovin.exoplayer2.h.p.a aVar, int i2) {
    }

    default void a(int i, com.applovin.exoplayer2.h.p.a aVar, Exception exc) {
    }

    default void b(int i, com.applovin.exoplayer2.h.p.a aVar) {
    }

    default void c(int i, com.applovin.exoplayer2.h.p.a aVar) {
    }

    default void d(int i, com.applovin.exoplayer2.h.p.a aVar) {
    }

    @Deprecated
    default void g(int i, com.applovin.exoplayer2.h.p.a aVar) {
    }

    public static class a {
        public final int cN;
        public final com.applovin.exoplayer2.h.p.a jj;
        private final CopyOnWriteArrayList<C0085a> tg;

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList<C0085a> copyOnWriteArrayList, int i, com.applovin.exoplayer2.h.p.a aVar) {
            this.tg = copyOnWriteArrayList;
            this.cN = i;
            this.jj = aVar;
        }

        public a h(int i, com.applovin.exoplayer2.h.p.a aVar) {
            return new a(this.tg, i, aVar);
        }

        public void a(Handler handler, g gVar) {
            com.applovin.exoplayer2.l.a.checkNotNull(handler);
            com.applovin.exoplayer2.l.a.checkNotNull(gVar);
            this.tg.add(new C0085a(handler, gVar));
        }

        public void a(g gVar) {
            for (C0085a c0085a : this.tg) {
                if (c0085a.th == gVar) {
                    this.tg.remove(c0085a);
                }
            }
        }

        public void bF(final int i) {
            for (C0085a c0085a : this.tg) {
                final g gVar = c0085a.th;
                ai.a(c0085a.jS, new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$g$a$NOXs6kDRz5DOTRaRjpMgrTy1AAg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(gVar, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(g gVar, int i) {
            gVar.g(this.cN, this.jj);
            gVar.a(this.cN, this.jj, i);
        }

        public void hG() {
            for (C0085a c0085a : this.tg) {
                final g gVar = c0085a.th;
                ai.a(c0085a.jS, new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$g$a$gBZ25-zVkgxGJQDdbRmgAZIUzg4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.e(gVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(g gVar) {
            gVar.a(this.cN, this.jj);
        }

        public void j(final Exception exc) {
            for (C0085a c0085a : this.tg) {
                final g gVar = c0085a.th;
                ai.a(c0085a.jS, new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$g$a$LZWb8gVCI2BXIsKthkvHGXWOQ5U
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(gVar, exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(g gVar, Exception exc) {
            gVar.a(this.cN, this.jj, exc);
        }

        public void hH() {
            for (C0085a c0085a : this.tg) {
                final g gVar = c0085a.th;
                ai.a(c0085a.jS, new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$g$a$uA2wnEaUMF6EMiLPhISyolYzc8E
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(gVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(g gVar) {
            gVar.b(this.cN, this.jj);
        }

        public void hI() {
            for (C0085a c0085a : this.tg) {
                final g gVar = c0085a.th;
                ai.a(c0085a.jS, new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$g$a$pRrwV8d8W91ZzygRNx-64jtfenw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(gVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(g gVar) {
            gVar.c(this.cN, this.jj);
        }

        public void hJ() {
            for (C0085a c0085a : this.tg) {
                final g gVar = c0085a.th;
                ai.a(c0085a.jS, new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$g$a$_ZPrPf1ql4qo7e28gkHsv8V3STI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(gVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(g gVar) {
            gVar.d(this.cN, this.jj);
        }

        /* JADX INFO: renamed from: com.applovin.exoplayer2.d.g$a$a, reason: collision with other inner class name */
        private static final class C0085a {
            public Handler jS;
            public g th;

            public C0085a(Handler handler, g gVar) {
                this.jS = handler;
                this.th = gVar;
            }
        }
    }
}
