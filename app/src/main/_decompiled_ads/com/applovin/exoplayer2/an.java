package com.applovin.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.applovin.exoplayer2.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface an {

    @Deprecated
    public interface b {
        default void Z(int i) {
        }

        default void a(ab abVar, int i) {
        }

        default void a(ac acVar) {
        }

        default void a(ak akVar) {
        }

        default void a(e eVar, e eVar2, int i) {
        }

        default void a(an anVar, c cVar) {
        }

        default void a(com.applovin.exoplayer2.h.ad adVar, com.applovin.exoplayer2.j.h hVar) {
        }

        default void aa(int i) {
        }

        default void ab(int i) {
        }

        @Deprecated
        default void ac(int i) {
        }

        default void b(ak akVar) {
        }

        default void b(am amVar) {
        }

        default void b(ba baVar, int i) {
        }

        @Deprecated
        default void cD() {
        }

        default void d(a aVar) {
        }

        @Deprecated
        default void d(boolean z, int i) {
        }

        default void e(boolean z, int i) {
        }

        default void w(boolean z) {
        }

        @Deprecated
        default void x(boolean z) {
        }

        default void y(boolean z) {
        }

        default void z(boolean z) {
        }
    }

    public interface d extends b {
        default void A(boolean z) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void Z(int i) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void a(ab abVar, int i) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void a(ac acVar) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void a(ak akVar) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void a(e eVar, e eVar2, int i) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void a(an anVar, c cVar) {
        }

        default void a(com.applovin.exoplayer2.g.a aVar) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void a(com.applovin.exoplayer2.h.ad adVar, com.applovin.exoplayer2.j.h hVar) {
        }

        default void a(com.applovin.exoplayer2.m.o oVar) {
        }

        default void a(o oVar) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void aa(int i) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void ab(int i) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void b(ak akVar) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void b(am amVar) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void b(ba baVar, int i) {
        }

        default void cE() {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void d(a aVar) {
        }

        default void e(int i, boolean z) {
        }

        default void e(List<com.applovin.exoplayer2.i.a> list) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void e(boolean z, int i) {
        }

        default void f(int i, int i2) {
        }

        default void g(float f) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void w(boolean z) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void y(boolean z) {
        }

        @Override // com.applovin.exoplayer2.an.b
        default void z(boolean z) {
        }
    }

    void B();

    void E();

    boolean J();

    void a(int i, long j);

    void a(SurfaceView surfaceView);

    void a(TextureView textureView);

    void a(d dVar);

    a aA();

    int aB();

    int aC();

    void aD();

    boolean aE();

    int aF();

    boolean aG();

    long aH();

    long aI();

    long aJ();

    int aK();

    int aL();

    long aM();

    long aN();

    long aO();

    boolean aP();

    int aQ();

    int aR();

    long aS();

    long aT();

    com.applovin.exoplayer2.h.ad aU();

    com.applovin.exoplayer2.j.h aV();

    ac aW();

    ba aX();

    com.applovin.exoplayer2.m.o aY();

    am av();

    ak ax();

    Looper az();

    void b(long j);

    void b(SurfaceView surfaceView);

    void b(TextureView textureView);

    void b(d dVar);

    List<com.applovin.exoplayer2.i.a> bd();

    void k(boolean z);

    void l(boolean z);

    boolean n(int i);

    void u(int i);

    boolean v();

    void x();

    void y();

    public static final class c {
        private final com.applovin.exoplayer2.l.m gH;

        public c(com.applovin.exoplayer2.l.m mVar) {
            this.gH = mVar;
        }

        public boolean X(int i) {
            return this.gH.X(i);
        }

        public boolean b(int... iArr) {
            return this.gH.b(iArr);
        }

        public int hashCode() {
            return this.gH.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.gH.equals(((c) obj).gH);
            }
            return false;
        }
    }

    public static final class e implements g {
        public static final g.a<e> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$an$e$s6vWWqCBoC8wgCOTuYtI4NLvgMc
            @Override // com.applovin.exoplayer2.g.a
            public final g fromBundle(Bundle bundle) {
                return an.e.m(bundle);
            }
        };
        public final int cN;
        public final long dX;
        public final Object gK;
        public final ab gL;
        public final Object gM;
        public final int gN;
        public final long gO;
        public final int gP;
        public final int gQ;

        public e(Object obj, int i, ab abVar, Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.gK = obj;
            this.cN = i;
            this.gL = abVar;
            this.gM = obj2;
            this.gN = i2;
            this.dX = j;
            this.gO = j2;
            this.gP = i3;
            this.gQ = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.cN == eVar.cN && this.gN == eVar.gN && this.dX == eVar.dX && this.gO == eVar.gO && this.gP == eVar.gP && this.gQ == eVar.gQ && Objects.equal(this.gK, eVar.gK) && Objects.equal(this.gM, eVar.gM) && Objects.equal(this.gL, eVar.gL);
        }

        public int hashCode() {
            return Objects.hashCode(this.gK, Integer.valueOf(this.cN), this.gL, this.gM, Integer.valueOf(this.gN), Integer.valueOf(this.cN), Long.valueOf(this.dX), Long.valueOf(this.gO), Integer.valueOf(this.gP), Integer.valueOf(this.gQ));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e m(Bundle bundle) {
            return new e(null, bundle.getInt(t(0), -1), (ab) com.applovin.exoplayer2.l.c.a(ab.br, bundle.getBundle(t(1))), null, bundle.getInt(t(2), -1), bundle.getLong(t(3), -9223372036854775807L), bundle.getLong(t(4), -9223372036854775807L), bundle.getInt(t(5), -1), bundle.getInt(t(6), -1));
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    public static final class a implements g {
        private final com.applovin.exoplayer2.l.m gH;
        public static final a gG = new C0074a().cC();
        public static final g.a<a> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$an$a$y31FjimwcdSXzrX5vh6sNNL7B_w
            @Override // com.applovin.exoplayer2.g.a
            public final g fromBundle(Bundle bundle) {
                return an.a.l(bundle);
            }
        };

        /* JADX INFO: renamed from: com.applovin.exoplayer2.an$a$a, reason: collision with other inner class name */
        public static final class C0074a {
            private static final int[] gI = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
            private final com.applovin.exoplayer2.l.m.a gJ = new com.applovin.exoplayer2.l.m.a();

            public C0074a Y(int i) {
                this.gJ.fo(i);
                return this;
            }

            public C0074a d(int i, boolean z) {
                this.gJ.o(i, z);
                return this;
            }

            public C0074a a(int... iArr) {
                this.gJ.h(iArr);
                return this;
            }

            public C0074a c(a aVar) {
                this.gJ.a(aVar.gH);
                return this;
            }

            public a cC() {
                return new a(this.gJ.oV());
            }
        }

        private a(com.applovin.exoplayer2.l.m mVar) {
            this.gH = mVar;
        }

        public boolean X(int i) {
            return this.gH.X(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.gH.equals(((a) obj).gH);
            }
            return false;
        }

        public int hashCode() {
            return this.gH.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a l(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(t(0));
            if (integerArrayList == null) {
                return gG;
            }
            C0074a c0074a = new C0074a();
            for (int i = 0; i < integerArrayList.size(); i++) {
                c0074a.Y(integerArrayList.get(i).intValue());
            }
            return c0074a.cC();
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }
}
