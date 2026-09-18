package com.applovin.exoplayer2.h;

import android.util.Pair;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.l.ai;

/* JADX INFO: loaded from: classes.dex */
public final class l extends e<Void> {
    private boolean LA;
    private boolean LB;
    private a Ly;
    private k Lz;
    private final ba.c U;
    private final ba.a bI;
    private final boolean bK;
    private boolean gb;
    private final p gf;

    @Override // com.applovin.exoplayer2.h.e, com.applovin.exoplayer2.h.p
    public void kS() {
    }

    public l(p pVar, boolean z) {
        this.gf = pVar;
        this.bK = z && pVar.lc();
        this.U = new ba.c();
        this.bI = new ba.a();
        ba baVarLb = pVar.lb();
        if (baVarLb != null) {
            this.Ly = a.a(baVarLb, (Object) null, (Object) null);
            this.LB = true;
        } else {
            this.Ly = a.b(pVar.kZ());
        }
    }

    public ba bf() {
        return this.Ly;
    }

    @Override // com.applovin.exoplayer2.h.e, com.applovin.exoplayer2.h.a
    public void b(com.applovin.exoplayer2.k.aa aaVar) {
        super.b(aaVar);
        if (this.bK) {
            return;
        }
        this.LA = true;
        a((Object) null, this.gf);
    }

    @Override // com.applovin.exoplayer2.h.p
    public com.applovin.exoplayer2.ab kZ() {
        return this.gf.kZ();
    }

    @Override // com.applovin.exoplayer2.h.p
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k a(p.a aVar, com.applovin.exoplayer2.k.b bVar, long j) {
        k kVar = new k(aVar, bVar, j);
        kVar.a(this.gf);
        if (this.gb) {
            kVar.g(aVar.G(E(aVar.gM)));
        } else {
            this.Lz = kVar;
            if (!this.LA) {
                this.LA = true;
                a((Object) null, this.gf);
            }
        }
        return kVar;
    }

    @Override // com.applovin.exoplayer2.h.p
    public void f(n nVar) {
        ((k) nVar).kY();
        if (nVar == this.Lz) {
            this.Lz = null;
        }
    }

    @Override // com.applovin.exoplayer2.h.e, com.applovin.exoplayer2.h.a
    public void kJ() {
        this.gb = false;
        this.LA = false;
        super.kJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.applovin.exoplayer2.h.e
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(Void r13, p pVar, ba baVar) {
        long j;
        a aVarA;
        p.a aVarG;
        a aVarA2;
        if (this.gb) {
            this.Ly = this.Ly.f(baVar);
            k kVar = this.Lz;
            if (kVar != null) {
                aV(kVar.kX());
            }
        } else if (baVar.isEmpty()) {
            if (this.LB) {
                aVarA2 = this.Ly.f(baVar);
            } else {
                aVarA2 = a.a(baVar, ba.c.iF, a.LC);
            }
            this.Ly = aVarA2;
        } else {
            baVar.a(0, this.U);
            long jDk = this.U.dk();
            Object obj = this.U.ch;
            k kVar2 = this.Lz;
            if (kVar2 != null) {
                long jKW = kVar2.kW();
                this.Ly.a(this.Lz.fE.gM, this.bI);
                long jDf = this.bI.df() + jKW;
                if (jDf != this.Ly.a(0, this.U).dk()) {
                    j = jDf;
                } else {
                    j = jDk;
                }
            } else {
                j = jDk;
            }
            Pair<Object, Long> pairA = baVar.a(this.U, this.bI, 0, j);
            Object obj2 = pairA.first;
            long jLongValue = ((Long) pairA.second).longValue();
            if (this.LB) {
                aVarA = this.Ly.f(baVar);
            } else {
                aVarA = a.a(baVar, obj, obj2);
            }
            this.Ly = aVarA;
            k kVar3 = this.Lz;
            if (kVar3 != null) {
                aV(jLongValue);
                aVarG = kVar3.fE.G(E(kVar3.fE.gM));
            }
            this.LB = true;
            this.gb = true;
            e(this.Ly);
            if (aVarG != null) {
                ((k) com.applovin.exoplayer2.l.a.checkNotNull(this.Lz)).g(aVarG);
            }
        }
        aVarG = null;
        this.LB = true;
        this.gb = true;
        e(this.Ly);
        if (aVarG != null) {
            ((k) com.applovin.exoplayer2.l.a.checkNotNull(this.Lz)).g(aVarG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.exoplayer2.h.e
    public p.a a(Void r1, p.a aVar) {
        return aVar.G(F(aVar.gM));
    }

    private Object E(Object obj) {
        return (this.Ly.LE == null || !obj.equals(a.LC)) ? obj : this.Ly.LE;
    }

    private Object F(Object obj) {
        return (this.Ly.LE == null || !this.Ly.LE.equals(obj)) ? obj : a.LC;
    }

    private void aV(long j) {
        k kVar = this.Lz;
        int iC = this.Ly.c(kVar.fE.gM);
        if (iC == -1) {
            return;
        }
        long j2 = this.Ly.a(iC, this.bI).fH;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        kVar.aT(j);
    }

    private static final class a extends h {
        public static final Object LC = new Object();
        private final Object LD;
        private final Object LE;

        public static a b(com.applovin.exoplayer2.ab abVar) {
            return new a(new b(abVar), ba.c.iF, LC);
        }

        public static a a(ba baVar, Object obj, Object obj2) {
            return new a(baVar, obj, obj2);
        }

        private a(ba baVar, Object obj, Object obj2) {
            super(baVar);
            this.LD = obj;
            this.LE = obj2;
        }

        public a f(ba baVar) {
            return new a(baVar, this.LD, this.LE);
        }

        @Override // com.applovin.exoplayer2.h.h, com.applovin.exoplayer2.ba
        public ba.c a(int i, ba.c cVar, long j) {
            this.ci.a(i, cVar, j);
            if (ai.r(cVar.ch, this.LD)) {
                cVar.ch = ba.c.iF;
            }
            return cVar;
        }

        @Override // com.applovin.exoplayer2.h.h, com.applovin.exoplayer2.ba
        public ba.a a(int i, ba.a aVar, boolean z) {
            this.ci.a(i, aVar, z);
            if (ai.r(aVar.ch, this.LE) && z) {
                aVar.ch = LC;
            }
            return aVar;
        }

        @Override // com.applovin.exoplayer2.h.h, com.applovin.exoplayer2.ba
        public int c(Object obj) {
            Object obj2;
            ba baVar = this.ci;
            if (LC.equals(obj) && (obj2 = this.LE) != null) {
                obj = obj2;
            }
            return baVar.c(obj);
        }

        @Override // com.applovin.exoplayer2.h.h, com.applovin.exoplayer2.ba
        public Object b(int i) {
            Object objB = this.ci.b(i);
            return ai.r(objB, this.LE) ? LC : objB;
        }
    }

    public static final class b extends ba {
        private final com.applovin.exoplayer2.ab gL;

        @Override // com.applovin.exoplayer2.ba
        public int cP() {
            return 1;
        }

        @Override // com.applovin.exoplayer2.ba
        public int cQ() {
            return 1;
        }

        public b(com.applovin.exoplayer2.ab abVar) {
            this.gL = abVar;
        }

        @Override // com.applovin.exoplayer2.ba
        public ba.c a(int i, ba.c cVar, long j) {
            cVar.a(ba.c.iF, this.gL, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.iz = true;
            return cVar;
        }

        @Override // com.applovin.exoplayer2.ba
        public ba.a a(int i, ba.a aVar, boolean z) {
            aVar.a(z ? 0 : null, z ? a.LC : null, 0, -9223372036854775807L, 0L, com.applovin.exoplayer2.h.a.a.NI, true);
            return aVar;
        }

        @Override // com.applovin.exoplayer2.ba
        public int c(Object obj) {
            return obj == a.LC ? 0 : -1;
        }

        @Override // com.applovin.exoplayer2.ba
        public Object b(int i) {
            return a.LC;
        }
    }
}
