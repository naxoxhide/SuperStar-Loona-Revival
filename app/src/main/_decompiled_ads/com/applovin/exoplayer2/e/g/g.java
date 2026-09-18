package com.applovin.exoplayer2.e.g;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.e.r;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g implements com.applovin.exoplayer2.e.h, v {
    public static final com.applovin.exoplayer2.e.l vq = new com.applovin.exoplayer2.e.l() { // from class: com.applovin.exoplayer2.e.g.-$$Lambda$g$RiA04yC44p9PzsVpGvdq0T_W_5k
        @Override // com.applovin.exoplayer2.e.l
        public final com.applovin.exoplayer2.e.h[] createExtractors() {
            return g.ih();
        }
    };
    private final List<com.applovin.exoplayer2.g.a.InterfaceC0095a> AA;
    private int AB;
    private a[] AC;
    private long[][] AD;
    private int AE;
    private int AF;
    private long Aa;
    private int Ab;
    private y Ac;
    private final i Az;
    private long fH;
    private final int jF;
    private final y uO;
    private com.applovin.exoplayer2.e.j vG;
    private final y wm;
    private final y wn;
    private com.applovin.exoplayer2.g.f.b wu;
    private int xI;
    private int xJ;
    private int xK;
    private final y zU;
    private final ArrayDeque<com.applovin.exoplayer2.e.g.a.C0089a> zV;
    private int zY;
    private int zZ;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k b(k kVar) {
        return kVar;
    }

    private static boolean cm(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    private static boolean cn(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    private static int co(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    @Override // com.applovin.exoplayer2.e.v
    public boolean hU() {
        return true;
    }

    @Override // com.applovin.exoplayer2.e.h
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.applovin.exoplayer2.e.h[] ih() {
        return new com.applovin.exoplayer2.e.h[]{new g()};
    }

    public g() {
        this(0);
    }

    public g(int i) {
        this.jF = i;
        this.zY = (i & 4) != 0 ? 3 : 0;
        this.Az = new i();
        this.AA = new ArrayList();
        this.zU = new y(16);
        this.zV = new ArrayDeque<>();
        this.wm = new y(com.applovin.exoplayer2.l.v.abK);
        this.wn = new y(4);
        this.uO = new y();
        this.AB = -1;
    }

    @Override // com.applovin.exoplayer2.e.h
    public boolean a(com.applovin.exoplayer2.e.i iVar) throws IOException {
        return j.e(iVar, (this.jF & 2) != 0);
    }

    @Override // com.applovin.exoplayer2.e.h
    public void a(com.applovin.exoplayer2.e.j jVar) {
        this.vG = jVar;
    }

    @Override // com.applovin.exoplayer2.e.h
    public void o(long j, long j2) {
        this.zV.clear();
        this.Ab = 0;
        this.AB = -1;
        this.xI = 0;
        this.xJ = 0;
        this.xK = 0;
        if (j == 0) {
            if (this.zY != 3) {
                iL();
                return;
            } else {
                this.Az.Y();
                this.AA.clear();
                return;
            }
        }
        if (this.AC != null) {
            ay(j2);
        }
    }

    @Override // com.applovin.exoplayer2.e.h
    public int b(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        while (true) {
            int i = this.zY;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return f(iVar, uVar);
                    }
                    if (i == 3) {
                        return e(iVar, uVar);
                    }
                    throw new IllegalStateException();
                }
                if (d(iVar, uVar)) {
                    return 1;
                }
            } else if (!G(iVar)) {
                return -1;
            }
        }
    }

    @Override // com.applovin.exoplayer2.e.v
    public long dd() {
        return this.fH;
    }

    @Override // com.applovin.exoplayer2.e.v
    public v.a ai(long j) {
        long j2;
        long jA;
        long j3;
        long j4;
        int iAB;
        if (((a[]) com.applovin.exoplayer2.l.a.checkNotNull(this.AC)).length == 0) {
            return new v.a(w.uT);
        }
        int i = this.AE;
        if (i != -1) {
            n nVar = this.AC[i].AH;
            int iA = a(nVar, j);
            if (iA == -1) {
                return new v.a(w.uT);
            }
            long j5 = nVar.Bq[iA];
            j2 = nVar.tS[iA];
            if (j5 >= j || iA >= nVar.jA - 1 || (iAB = nVar.aB(j)) == -1 || iAB == iA) {
                j4 = -1;
                j3 = -9223372036854775807L;
            } else {
                j3 = nVar.Bq[iAB];
                j4 = nVar.tS[iAB];
            }
            jA = j4;
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            jA = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.AC;
            if (i2 >= aVarArr.length) {
                break;
            }
            if (i2 != this.AE) {
                n nVar2 = aVarArr[i2].AH;
                long jA2 = a(nVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    jA = a(nVar2, j3, jA);
                }
                j2 = jA2;
            }
            i2++;
        }
        w wVar = new w(j, j2);
        if (j3 == -9223372036854775807L) {
            return new v.a(wVar);
        }
        return new v.a(wVar, new w(j3, jA));
    }

    private void iL() {
        this.zY = 0;
        this.Ab = 0;
    }

    private boolean G(com.applovin.exoplayer2.e.i iVar) throws IOException {
        com.applovin.exoplayer2.e.g.a.C0089a c0089aPeek;
        if (this.Ab == 0) {
            if (!iVar.a(this.zU.hO(), 0, 8, true)) {
                iV();
                return false;
            }
            this.Ab = 8;
            this.zU.fx(0);
            this.Aa = this.zU.pv();
            this.zZ = this.zU.px();
        }
        long j = this.Aa;
        if (j == 1) {
            iVar.a(this.zU.hO(), 8, 8);
            this.Ab += 8;
            this.Aa = this.zU.pF();
        } else if (j == 0) {
            long jMo44if = iVar.mo44if();
            if (jMo44if == -1 && (c0089aPeek = this.zV.peek()) != null) {
                jMo44if = c0089aPeek.zl;
            }
            if (jMo44if != -1) {
                this.Aa = (jMo44if - iVar.ie()) + ((long) this.Ab);
            }
        }
        if (this.Aa < this.Ab) {
            throw ai.p("Atom size less than header length (unsupported).");
        }
        if (cn(this.zZ)) {
            long jIe = iVar.ie();
            long j2 = this.Aa;
            int i = this.Ab;
            long j3 = (jIe + j2) - ((long) i);
            if (j2 != i && this.zZ == 1835365473) {
                K(iVar);
            }
            this.zV.push(new com.applovin.exoplayer2.e.g.a.C0089a(this.zZ, j3));
            if (this.Aa == this.Ab) {
                au(j3);
            } else {
                iL();
            }
        } else if (cm(this.zZ)) {
            com.applovin.exoplayer2.l.a.checkState(this.Ab == 8);
            com.applovin.exoplayer2.l.a.checkState(this.Aa <= 2147483647L);
            y yVar = new y((int) this.Aa);
            System.arraycopy(this.zU.hO(), 0, yVar.hO(), 0, 8);
            this.Ac = yVar;
            this.zY = 1;
        } else {
            az(iVar.ie() - ((long) this.Ab));
            this.Ac = null;
            this.zY = 1;
        }
        return true;
    }

    private boolean d(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        boolean z;
        long j = this.Aa - ((long) this.Ab);
        long jIe = iVar.ie() + j;
        y yVar = this.Ac;
        if (yVar != null) {
            iVar.a(yVar.hO(), this.Ab, (int) j);
            if (this.zZ == 1718909296) {
                this.AF = D(yVar);
            } else if (!this.zV.isEmpty()) {
                this.zV.peek().a(new com.applovin.exoplayer2.e.g.a.b(this.zZ, yVar));
            }
        } else {
            if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                iVar.bH((int) j);
            } else {
                uVar.uc = iVar.ie() + j;
                z = true;
            }
            au(jIe);
            return (z || this.zY == 2) ? false : true;
        }
        z = false;
        au(jIe);
        if (z) {
        }
    }

    private int e(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        int iA = this.Az.a(iVar, uVar, this.AA);
        if (iA == 1 && uVar.uc == 0) {
            iL();
        }
        return iA;
    }

    private void au(long j) throws ai {
        while (!this.zV.isEmpty() && this.zV.peek().zl == j) {
            com.applovin.exoplayer2.e.g.a.C0089a c0089aPop = this.zV.pop();
            if (c0089aPop.bs == 1836019574) {
                g(c0089aPop);
                this.zV.clear();
                this.zY = 2;
            } else if (!this.zV.isEmpty()) {
                this.zV.peek().a(c0089aPop);
            }
        }
        if (this.zY != 2) {
            iL();
        }
    }

    private void g(com.applovin.exoplayer2.e.g.a.C0089a c0089a) throws ai {
        com.applovin.exoplayer2.g.a aVar;
        com.applovin.exoplayer2.g.a aVar2;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        boolean z = this.AF == 1;
        r rVar = new r();
        com.applovin.exoplayer2.e.g.a.b bVarCi = c0089a.ci(1969517665);
        if (bVarCi != null) {
            Pair<com.applovin.exoplayer2.g.a, com.applovin.exoplayer2.g.a> pairB = b.b(bVarCi);
            com.applovin.exoplayer2.g.a aVar3 = (com.applovin.exoplayer2.g.a) pairB.first;
            com.applovin.exoplayer2.g.a aVar4 = (com.applovin.exoplayer2.g.a) pairB.second;
            if (aVar3 != null) {
                rVar.e(aVar3);
            }
            aVar = aVar4;
            aVar2 = aVar3;
        } else {
            aVar = null;
            aVar2 = null;
        }
        com.applovin.exoplayer2.e.g.a.C0089a c0089aCj = c0089a.cj(1835365473);
        com.applovin.exoplayer2.g.a aVarB = c0089aCj != null ? b.b(c0089aCj) : null;
        List<n> listA = b.a(c0089a, rVar, -9223372036854775807L, (com.applovin.exoplayer2.d.e) null, (this.jF & 1) != 0, z, new Function() { // from class: com.applovin.exoplayer2.e.g.-$$Lambda$g$Zd0EUj5Euub6YZFLvSIeIwdRUCQ
            @Override // com.applovin.exoplayer2.common.base.Function
            public final Object apply(Object obj) {
                return g.b((k) obj);
            }
        });
        com.applovin.exoplayer2.e.j jVar = (com.applovin.exoplayer2.e.j) com.applovin.exoplayer2.l.a.checkNotNull(this.vG);
        int i = 0;
        int size = -1;
        long j = -9223372036854775807L;
        for (int size2 = listA.size(); i < size2; size2 = size2) {
            n nVar = listA.get(i);
            if (nVar.jA == 0) {
                arrayList = arrayList2;
            } else {
                k kVar = nVar.AG;
                int i2 = size;
                arrayList = arrayList2;
                long j2 = kVar.fH != -9223372036854775807L ? kVar.fH : nVar.fH;
                long jMax = Math.max(j, j2);
                a aVar5 = new a(kVar, nVar, jVar.y(i, kVar.bs));
                int i3 = nVar.zH + 30;
                com.applovin.exoplayer2.v.a aVarBR = kVar.dU.bR();
                aVarBR.I(i3);
                if (kVar.bs == 2 && j2 > 0 && nVar.jA > 1) {
                    aVarBR.d(nVar.jA / (j2 / 1000000.0f));
                }
                f.a(kVar.bs, rVar, aVarBR);
                int i4 = kVar.bs;
                com.applovin.exoplayer2.g.a[] aVarArr = new com.applovin.exoplayer2.g.a[2];
                aVarArr[0] = aVar;
                aVarArr[1] = this.AA.isEmpty() ? null : new com.applovin.exoplayer2.g.a(this.AA);
                f.a(i4, aVar2, aVarB, aVarBR, aVarArr);
                aVar5.vH.j(aVarBR.bT());
                size = (kVar.bs == 2 && i2 == -1) ? arrayList.size() : i2;
                arrayList.add(aVar5);
                j = jMax;
            }
            i++;
            arrayList2 = arrayList;
            listA = listA;
        }
        this.AE = size;
        this.fH = j;
        a[] aVarArr2 = (a[]) arrayList2.toArray(new a[0]);
        this.AC = aVarArr2;
        this.AD = a(aVarArr2);
        jVar.ig();
        jVar.a(this);
    }

    private int f(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        long jIe = iVar.ie();
        if (this.AB == -1) {
            int iAx = ax(jIe);
            this.AB = iAx;
            if (iAx == -1) {
                return -1;
            }
        }
        a aVar = ((a[]) com.applovin.exoplayer2.l.ai.R(this.AC))[this.AB];
        x xVar = aVar.vH;
        int i = aVar.zB;
        long j = aVar.AH.tS[i];
        int i2 = aVar.AH.tR[i];
        long j2 = (j - jIe) + ((long) this.xI);
        if (j2 < 0 || j2 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            uVar.uc = j;
            return 1;
        }
        if (aVar.AG.AR == 1) {
            j2 += 8;
            i2 -= 8;
        }
        iVar.bH((int) j2);
        if (aVar.AG.wo != 0) {
            byte[] bArrHO = this.wn.hO();
            bArrHO[0] = 0;
            bArrHO[1] = 0;
            bArrHO[2] = 0;
            int i3 = aVar.AG.wo;
            int i4 = 4 - aVar.AG.wo;
            while (this.xJ < i2) {
                int i5 = this.xK;
                if (i5 == 0) {
                    iVar.a(bArrHO, i4, i3);
                    this.xI += i3;
                    this.wn.fx(0);
                    int iPx = this.wn.px();
                    if (iPx < 0) {
                        throw ai.c("Invalid NAL length", null);
                    }
                    this.xK = iPx;
                    this.wm.fx(0);
                    xVar.c(this.wm, 4);
                    this.xJ += 4;
                    i2 += i4;
                } else {
                    int iA = xVar.a((com.applovin.exoplayer2.k.g) iVar, i5, false);
                    this.xI += iA;
                    this.xJ += iA;
                    this.xK -= iA;
                }
            }
        } else {
            if ("audio/ac4".equals(aVar.AG.dU.dz)) {
                if (this.xJ == 0) {
                    com.applovin.exoplayer2.b.c.a(i2, this.uO);
                    xVar.c(this.uO, 7);
                    this.xJ += 7;
                }
                i2 += 7;
            }
            while (true) {
                int i6 = this.xJ;
                if (i6 >= i2) {
                    break;
                }
                int iA2 = xVar.a((com.applovin.exoplayer2.k.g) iVar, i2 - i6, false);
                this.xI += iA2;
                this.xJ += iA2;
                this.xK -= iA2;
            }
        }
        xVar.a(aVar.AH.Bq[i], aVar.AH.zJ[i], i2, 0, null);
        aVar.zB++;
        this.AB = -1;
        this.xI = 0;
        this.xJ = 0;
        this.xK = 0;
        return 0;
    }

    private int ax(long j) {
        int i = -1;
        int i2 = -1;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < ((a[]) com.applovin.exoplayer2.l.ai.R(this.AC)).length; i3++) {
            a aVar = this.AC[i3];
            int i4 = aVar.zB;
            if (i4 != aVar.AH.jA) {
                long j5 = aVar.AH.tS[i4];
                long j6 = ((long[][]) com.applovin.exoplayer2.l.ai.R(this.AD))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    private void ay(long j) {
        for (a aVar : this.AC) {
            n nVar = aVar.AH;
            int iAA = nVar.aA(j);
            if (iAA == -1) {
                iAA = nVar.aB(j);
            }
            aVar.zB = iAA;
        }
    }

    private void iV() {
        if (this.AF != 2 || (this.jF & 2) == 0) {
            return;
        }
        com.applovin.exoplayer2.e.j jVar = (com.applovin.exoplayer2.e.j) com.applovin.exoplayer2.l.a.checkNotNull(this.vG);
        jVar.y(0, 4).j(new com.applovin.exoplayer2.v.a().b(this.wu == null ? null : new com.applovin.exoplayer2.g.a(this.wu)).bT());
        jVar.ig();
        jVar.a(new v.b(-9223372036854775807L));
    }

    private void K(com.applovin.exoplayer2.e.i iVar) throws IOException {
        this.uO.U(8);
        iVar.c(this.uO.hO(), 0, 8);
        b.p(this.uO);
        iVar.bH(this.uO.il());
        iVar.ic();
    }

    private void az(long j) {
        if (this.zZ == 1836086884) {
            int i = this.Ab;
            this.wu = new com.applovin.exoplayer2.g.f.b(0L, j, -9223372036854775807L, j + ((long) i), this.Aa - ((long) i));
        }
    }

    private static long[][] a(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].AH.jA];
            jArr2[i] = aVarArr[i].AH.Bq[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (!zArr[i4] && jArr2[i4] <= j2) {
                    j2 = jArr2[i4];
                    i3 = i4;
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = j;
            j += (long) aVarArr[i3].AH.tR[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = aVarArr[i3].AH.Bq[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static long a(n nVar, long j, long j2) {
        int iA = a(nVar, j);
        return iA == -1 ? j2 : Math.min(nVar.tS[iA], j2);
    }

    private static int a(n nVar, long j) {
        int iAA = nVar.aA(j);
        return iAA == -1 ? nVar.aB(j) : iAA;
    }

    private static int D(y yVar) {
        yVar.fx(8);
        int iCo = co(yVar.px());
        if (iCo != 0) {
            return iCo;
        }
        yVar.fz(4);
        while (yVar.pj() > 0) {
            int iCo2 = co(yVar.px());
            if (iCo2 != 0) {
                return iCo2;
            }
        }
        return 0;
    }

    private static final class a {
        public final k AG;
        public final n AH;
        public final x vH;
        public int zB;

        public a(k kVar, n nVar, x xVar) {
            this.AG = kVar;
            this.AH = nVar;
            this.vH = xVar;
        }
    }
}
