package com.applovin.exoplayer2.k;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    void a(Handler handler, a aVar);

    void a(a aVar);

    aa od();

    public interface a {
        void b(int i, long j, long j2);

        /* JADX INFO: renamed from: com.applovin.exoplayer2.k.d$a$a, reason: collision with other inner class name */
        public static final class C0107a {
            private final CopyOnWriteArrayList<C0108a> Zl = new CopyOnWriteArrayList<>();

            public void b(Handler handler, a aVar) {
                com.applovin.exoplayer2.l.a.checkNotNull(handler);
                com.applovin.exoplayer2.l.a.checkNotNull(aVar);
                b(aVar);
                this.Zl.add(new C0108a(handler, aVar));
            }

            public void b(a aVar) {
                for (C0108a c0108a : this.Zl) {
                    if (c0108a.Zm == aVar) {
                        c0108a.release();
                        this.Zl.remove(c0108a);
                    }
                }
            }

            public void g(final int i, final long j, final long j2) {
                for (final C0108a c0108a : this.Zl) {
                    if (!c0108a.cw) {
                        c0108a.jS.post(new Runnable() { // from class: com.applovin.exoplayer2.k.-$$Lambda$d$a$a$O92mDE_by3QqFgydQODUl_Vr7Ug
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.a.C0107a.a(c0108a, i, j, j2);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void a(C0108a c0108a, int i, long j, long j2) {
                c0108a.Zm.b(i, j, j2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: com.applovin.exoplayer2.k.d$a$a$a, reason: collision with other inner class name */
            static final class C0108a {
                private final a Zm;
                private boolean cw;
                private final Handler jS;

                public C0108a(Handler handler, a aVar) {
                    this.jS = handler;
                    this.Zm = aVar;
                }

                public void release() {
                    this.cw = true;
                }
            }
        }
    }
}
