package com.applovin.exoplayer2;

import android.os.Handler;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
final class af {
    private final com.applovin.exoplayer2.a.a bM;
    private int bS;
    private boolean bT;
    private final Handler fM;
    private long fN;
    private ad fO;
    private ad fP;
    private ad fQ;
    private int fR;
    private Object fS;
    private long fT;
    private final ba.a bI = new ba.a();
    private final ba.c U = new ba.c();

    private boolean f(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public af(com.applovin.exoplayer2.a.a aVar, Handler handler) {
        this.bM = aVar;
        this.fM = handler;
    }

    public boolean a(ba baVar, int i) {
        this.bS = i;
        return b(baVar);
    }

    public boolean b(ba baVar, boolean z) {
        this.bT = z;
        return b(baVar);
    }

    public boolean e(com.applovin.exoplayer2.h.n nVar) {
        ad adVar = this.fQ;
        return adVar != null && adVar.ft == nVar;
    }

    public void t(long j) {
        ad adVar = this.fQ;
        if (adVar != null) {
            adVar.t(j);
        }
    }

    public boolean cp() {
        ad adVar = this.fQ;
        return adVar == null || (!adVar.fx.fL && this.fQ.cf() && this.fQ.fx.fH != -9223372036854775807L && this.fR < 100);
    }

    public ae a(long j, al alVar) {
        if (this.fQ == null) {
            return e(alVar);
        }
        return a(alVar.ci, this.fQ, j);
    }

    public ad a(as[] asVarArr, com.applovin.exoplayer2.j.j jVar, com.applovin.exoplayer2.k.b bVar, ah ahVar, ae aeVar, com.applovin.exoplayer2.j.k kVar) {
        long jCd;
        ad adVar = this.fQ;
        if (adVar == null) {
            jCd = (!aeVar.fE.la() || aeVar.de == -9223372036854775807L) ? 0L : aeVar.de;
        } else {
            jCd = (adVar.cd() + this.fQ.fx.fH) - aeVar.fF;
        }
        ad adVar2 = new ad(asVarArr, jCd, jVar, bVar, ahVar, aeVar, kVar);
        ad adVar3 = this.fQ;
        if (adVar3 != null) {
            adVar3.a(adVar2);
        } else {
            this.fO = adVar2;
            this.fP = adVar2;
        }
        this.fS = null;
        this.fQ = adVar2;
        this.fR++;
        cv();
        return adVar2;
    }

    public ad cq() {
        return this.fQ;
    }

    public ad cr() {
        return this.fO;
    }

    public ad cs() {
        return this.fP;
    }

    public ad ct() {
        ad adVar = this.fP;
        com.applovin.exoplayer2.l.a.checkState((adVar == null || adVar.ci() == null) ? false : true);
        this.fP = this.fP.ci();
        cv();
        return this.fP;
    }

    public ad cu() {
        ad adVar = this.fO;
        if (adVar == null) {
            return null;
        }
        if (adVar == this.fP) {
            this.fP = adVar.ci();
        }
        this.fO.release();
        int i = this.fR - 1;
        this.fR = i;
        if (i == 0) {
            this.fQ = null;
            this.fS = this.fO.ch;
            this.fT = this.fO.fx.fE.LL;
        }
        this.fO = this.fO.ci();
        cv();
        return this.fO;
    }

    public boolean b(ad adVar) {
        boolean z = false;
        com.applovin.exoplayer2.l.a.checkState(adVar != null);
        if (adVar.equals(this.fQ)) {
            return false;
        }
        this.fQ = adVar;
        while (adVar.ci() != null) {
            adVar = adVar.ci();
            if (adVar == this.fP) {
                this.fP = this.fO;
                z = true;
            }
            adVar.release();
            this.fR--;
        }
        this.fQ.a((ad) null);
        cv();
        return z;
    }

    public void clear() {
        if (this.fR == 0) {
            return;
        }
        ad adVarCi = (ad) com.applovin.exoplayer2.l.a.N(this.fO);
        this.fS = adVarCi.ch;
        this.fT = adVarCi.fx.fE.LL;
        while (adVarCi != null) {
            adVarCi.release();
            adVarCi = adVarCi.ci();
        }
        this.fO = null;
        this.fQ = null;
        this.fP = null;
        this.fR = 0;
        cv();
    }

    public boolean a(ba baVar, long j, long j2) {
        ae aeVarA;
        ad adVarCi = this.fO;
        ad adVar = null;
        while (adVarCi != null) {
            ae aeVar = adVarCi.fx;
            if (adVar == null) {
                aeVarA = a(baVar, aeVar);
            } else {
                ae aeVarA2 = a(baVar, adVar, j);
                if (aeVarA2 == null) {
                    return !b(adVar);
                }
                if (!a(aeVar, aeVarA2)) {
                    return !b(adVar);
                }
                aeVarA = aeVarA2;
            }
            adVarCi.fx = aeVarA.w(aeVar.de);
            if (!f(aeVar.fH, aeVarA.fH)) {
                adVarCi.cl();
                return (b(adVarCi) || (adVarCi == this.fP && !adVarCi.fx.fI && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((aeVarA.fH > (-9223372036854775807L) ? 1 : (aeVarA.fH == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : adVarCi.q(aeVarA.fH)) ? 1 : (j2 == ((aeVarA.fH > (-9223372036854775807L) ? 1 : (aeVarA.fH == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : adVarCi.q(aeVarA.fH)) ? 0 : -1)) >= 0))) ? false : true;
            }
            adVar = adVarCi;
            adVarCi = adVarCi.ci();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    /* JADX WARN: Code duplicated, block: B:24:0x006e  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    public ae a(ba baVar, ae aeVar) {
        long jDd;
        long j;
        boolean zAp;
        com.applovin.exoplayer2.h.p.a aVar = aeVar.fE;
        boolean zA = a(aVar);
        boolean zB = b(baVar, aVar);
        boolean zA2 = a(baVar, aVar, zA);
        baVar.a(aeVar.fE.gM, this.bI);
        long jAl = (aVar.la() || aVar.LM == -1) ? -9223372036854775807L : this.bI.al(aVar.LM);
        if (aVar.la()) {
            jDd = this.bI.i(aVar.gP, aVar.gQ);
        } else {
            if (jAl == -9223372036854775807L || jAl == Long.MIN_VALUE) {
                jDd = this.bI.dd();
            } else {
                j = jAl;
            }
            if (aVar.la()) {
                zAp = this.bI.ap(aVar.gP);
            } else if (aVar.LM == -1 && this.bI.ap(aVar.LM)) {
                zAp = true;
            } else {
                zAp = false;
            }
            return new ae(aVar, aeVar.fF, aeVar.de, jAl, j, zAp, zA, zB, zA2);
        }
        j = jDd;
        if (aVar.la()) {
            zAp = this.bI.ap(aVar.gP);
        } else if (aVar.LM == -1) {
            zAp = false;
        } else {
            zAp = false;
        }
        return new ae(aVar, aeVar.fF, aeVar.de, jAl, j, zAp, zA, zB, zA2);
    }

    public com.applovin.exoplayer2.h.p.a b(ba baVar, Object obj, long j) {
        return a(baVar, obj, j, a(baVar, obj), this.bI);
    }

    private void cv() {
        if (this.bM != null) {
            final com.applovin.exoplayer2.common.a.s.a aVarGc = com.applovin.exoplayer2.common.a.s.gc();
            for (ad adVarCi = this.fO; adVarCi != null; adVarCi = adVarCi.ci()) {
                aVarGc.t(adVarCi.fx.fE);
            }
            ad adVar = this.fP;
            final com.applovin.exoplayer2.h.p.a aVar = adVar == null ? null : adVar.fx.fE;
            this.fM.post(new Runnable() { // from class: com.applovin.exoplayer2.-$$Lambda$af$sF_656vlar8EiN7CZhZOBYGmxPA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(aVarGc, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.exoplayer2.common.a.s.a aVar, com.applovin.exoplayer2.h.p.a aVar2) {
        this.bM.a(aVar.gd(), aVar2);
    }

    private static com.applovin.exoplayer2.h.p.a a(ba baVar, Object obj, long j, long j2, ba.a aVar) {
        baVar.a(obj, aVar);
        int iA = aVar.A(j);
        if (iA == -1) {
            return new com.applovin.exoplayer2.h.p.a(obj, j2, aVar.B(j));
        }
        return new com.applovin.exoplayer2.h.p.a(obj, iA, aVar.am(iA), j2);
    }

    private long a(ba baVar, Object obj) {
        int iC;
        int i = baVar.a(obj, this.bI).cN;
        Object obj2 = this.fS;
        if (obj2 != null && (iC = baVar.c(obj2)) != -1 && baVar.a(iC, this.bI).cN == i) {
            return this.fT;
        }
        for (ad adVarCi = this.fO; adVarCi != null; adVarCi = adVarCi.ci()) {
            if (adVarCi.ch.equals(obj)) {
                return adVarCi.fx.fE.LL;
            }
        }
        for (ad adVarCi2 = this.fO; adVarCi2 != null; adVarCi2 = adVarCi2.ci()) {
            int iC2 = baVar.c(adVarCi2.ch);
            if (iC2 != -1 && baVar.a(iC2, this.bI).cN == i) {
                return adVarCi2.fx.fE.LL;
            }
        }
        long j = this.fN;
        this.fN = 1 + j;
        if (this.fO == null) {
            this.fS = obj;
            this.fT = j;
        }
        return j;
    }

    private boolean a(ae aeVar, ae aeVar2) {
        return aeVar.fF == aeVar2.fF && aeVar.fE.equals(aeVar2.fE);
    }

    private boolean b(ba baVar) {
        ad adVarCi = this.fO;
        if (adVarCi == null) {
            return true;
        }
        int iC = baVar.c(adVarCi.ch);
        while (true) {
            iC = baVar.a(iC, this.bI, this.U, this.bS, this.bT);
            while (adVarCi.ci() != null && !adVarCi.fx.fJ) {
                adVarCi = adVarCi.ci();
            }
            ad adVarCi2 = adVarCi.ci();
            if (iC == -1 || adVarCi2 == null || baVar.c(adVarCi2.ch) != iC) {
                break;
            }
            adVarCi = adVarCi2;
        }
        boolean zB = b(adVarCi);
        adVarCi.fx = a(baVar, adVarCi.fx);
        return !zB;
    }

    private ae e(al alVar) {
        return a(alVar.ci, alVar.dc, alVar.de, alVar.cO);
    }

    private ae a(ba baVar, ad adVar, long j) {
        long j2;
        ae aeVar = adVar.fx;
        long jCd = (adVar.cd() + aeVar.fH) - j;
        if (aeVar.fJ) {
            long j3 = 0;
            int iA = baVar.a(baVar.c(aeVar.fE.gM), this.bI, this.U, this.bS, this.bT);
            if (iA == -1) {
                return null;
            }
            int i = baVar.a(iA, this.bI, true).cN;
            Object obj = this.bI.ch;
            long j4 = aeVar.fE.LL;
            if (baVar.a(i, this.U).iQ == iA) {
                Pair<Object, Long> pairA = baVar.a(this.U, this.bI, i, -9223372036854775807L, Math.max(0L, jCd));
                if (pairA == null) {
                    return null;
                }
                obj = pairA.first;
                long jLongValue = ((Long) pairA.second).longValue();
                ad adVarCi = adVar.ci();
                if (adVarCi != null && adVarCi.ch.equals(obj)) {
                    j4 = adVarCi.fx.fE.LL;
                } else {
                    j4 = this.fN;
                    this.fN = 1 + j4;
                }
                j2 = jLongValue;
                j3 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return a(baVar, a(baVar, obj, j2, j4, this.bI), j3, j2);
        }
        com.applovin.exoplayer2.h.p.a aVar = aeVar.fE;
        baVar.a(aVar.gM, this.bI);
        if (aVar.la()) {
            int i2 = aVar.gP;
            int iAo = this.bI.ao(i2);
            if (iAo == -1) {
                return null;
            }
            int iH = this.bI.h(i2, aVar.gQ);
            if (iH < iAo) {
                return a(baVar, aVar.gM, i2, iH, aeVar.de, aVar.LL);
            }
            long jLongValue2 = aeVar.de;
            if (jLongValue2 == -9223372036854775807L) {
                ba.c cVar = this.U;
                ba.a aVar2 = this.bI;
                Pair<Object, Long> pairA2 = baVar.a(cVar, aVar2, aVar2.cN, -9223372036854775807L, Math.max(0L, jCd));
                if (pairA2 == null) {
                    return null;
                }
                jLongValue2 = ((Long) pairA2.second).longValue();
            }
            return a(baVar, aVar.gM, Math.max(a(baVar, aVar.gM, aVar.gP), jLongValue2), aeVar.de, aVar.LL);
        }
        int iAm = this.bI.am(aVar.LM);
        if (iAm == this.bI.ao(aVar.LM)) {
            return a(baVar, aVar.gM, a(baVar, aVar.gM, aVar.LM), aeVar.fH, aVar.LL);
        }
        return a(baVar, aVar.gM, aVar.LM, iAm, aeVar.fH, aVar.LL);
    }

    private ae a(ba baVar, com.applovin.exoplayer2.h.p.a aVar, long j, long j2) {
        baVar.a(aVar.gM, this.bI);
        if (aVar.la()) {
            return a(baVar, aVar.gM, aVar.gP, aVar.gQ, j, aVar.LL);
        }
        return a(baVar, aVar.gM, j2, j, aVar.LL);
    }

    private ae a(ba baVar, Object obj, int i, int i2, long j, long j2) {
        com.applovin.exoplayer2.h.p.a aVar = new com.applovin.exoplayer2.h.p.a(obj, i, i2, j2);
        long jI = baVar.a(aVar.gM, this.bI).i(aVar.gP, aVar.gQ);
        long jDi = i2 == this.bI.am(i) ? this.bI.di() : 0L;
        return new ae(aVar, (jI == -9223372036854775807L || jDi < jI) ? jDi : Math.max(0L, jI - 1), j, -9223372036854775807L, jI, this.bI.ap(aVar.gP), false, false, false);
    }

    private ae a(ba baVar, Object obj, long j, long j2, long j3) {
        long jMax = j;
        baVar.a(obj, this.bI);
        int iB = this.bI.B(jMax);
        com.applovin.exoplayer2.h.p.a aVar = new com.applovin.exoplayer2.h.p.a(obj, j3, iB);
        boolean zA = a(aVar);
        boolean zB = b(baVar, aVar);
        boolean zA2 = a(baVar, aVar, zA);
        boolean z = iB != -1 && this.bI.ap(iB);
        long jAl = iB != -1 ? this.bI.al(iB) : -9223372036854775807L;
        long j4 = (jAl == -9223372036854775807L || jAl == Long.MIN_VALUE) ? this.bI.fH : jAl;
        if (j4 != -9223372036854775807L && jMax >= j4) {
            jMax = Math.max(0L, j4 - 1);
        }
        return new ae(aVar, jMax, j2, jAl, j4, z, zA, zB, zA2);
    }

    private boolean a(com.applovin.exoplayer2.h.p.a aVar) {
        return !aVar.la() && aVar.LM == -1;
    }

    private boolean b(ba baVar, com.applovin.exoplayer2.h.p.a aVar) {
        if (a(aVar)) {
            return baVar.a(baVar.a(aVar.gM, this.bI).cN, this.U).iR == baVar.c(aVar.gM);
        }
        return false;
    }

    private boolean a(ba baVar, com.applovin.exoplayer2.h.p.a aVar, boolean z) {
        int iC = baVar.c(aVar.gM);
        return !baVar.a(baVar.a(iC, this.bI).cN, this.U).iN && baVar.b(iC, this.bI, this.U, this.bS, this.bT) && z;
    }

    private long a(ba baVar, Object obj, int i) {
        baVar.a(obj, this.bI);
        long jAl = this.bI.al(i);
        if (jAl == Long.MIN_VALUE) {
            return this.bI.fH;
        }
        return jAl + this.bI.aq(i);
    }
}
