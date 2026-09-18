package com.applovin.exoplayer2.d;

import android.os.Looper;
import com.applovin.exoplayer2.v;

/* JADX INFO: loaded from: classes.dex */
public interface h {
    public static final h ti;

    @Deprecated
    public static final h tj;

    public interface a {
        public static final a tk = new a() { // from class: com.applovin.exoplayer2.d.-$$Lambda$h$a$ziJd6xmcAK9PKbCK_g0hrcgOTyU
            @Override // com.applovin.exoplayer2.d.h.a
            public final void release() {
                h.a.hK();
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void hK() {
        }

        void release();
    }

    default void aD() {
    }

    f b(Looper looper, g.a aVar, v vVar);

    int g(v vVar);

    default void release() {
    }

    static {
        h hVar = new h() { // from class: com.applovin.exoplayer2.d.h.1
            @Override // com.applovin.exoplayer2.d.h
            public f b(Looper looper, g.a aVar, v vVar) {
                if (vVar.dC == null) {
                    return null;
                }
                return new l(new f.a(new t(1), 6001));
            }

            @Override // com.applovin.exoplayer2.d.h
            public int g(v vVar) {
                return vVar.dC != null ? 1 : 0;
            }
        };
        ti = hVar;
        tj = hVar;
    }

    default a a(Looper looper, g.a aVar, v vVar) {
        return a.tk;
    }
}
