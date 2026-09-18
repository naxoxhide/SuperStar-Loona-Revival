package com.applovin.exoplayer2.e.f;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.r;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.s;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements h {
    public static final l vq = new l() { // from class: com.applovin.exoplayer2.e.f.-$$Lambda$d$ITR_K-I-yQuC7jp02JptONF0Vlw
        @Override // com.applovin.exoplayer2.e.l
        public final h[] createExtractors() {
            return d.ih();
        }
    };
    private static final com.applovin.exoplayer2.g.e.g.a yT = new com.applovin.exoplayer2.g.e.g.a() { // from class: com.applovin.exoplayer2.e.f.-$$Lambda$d$m0UxwZjCgx1Uc--Acj9qDmrDy_0
        @Override // com.applovin.exoplayer2.g.e.g.a
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return d.a(i, i2, i3, i4, i5);
        }
    };
    private com.applovin.exoplayer2.g.a dx;
    private final int jF;
    private long tL;
    private final y uO;
    private long vC;
    private j vG;
    private final long yU;
    private final r.a yV;
    private final com.applovin.exoplayer2.e.r yW;
    private final s yX;
    private final x yY;
    private x yZ;
    private x za;
    private int zb;
    private long zc;
    private long zd;
    private int ze;
    private e zf;
    private boolean zg;
    private boolean zh;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    private static boolean f(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    @Override // com.applovin.exoplayer2.e.h
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new d()};
    }

    public d() {
        this(0);
    }

    public d(int i) {
        this(i, -9223372036854775807L);
    }

    public d(int i, long j) {
        this.jF = (i & 2) != 0 ? i | 1 : i;
        this.yU = j;
        this.uO = new y(10);
        this.yV = new r.a();
        this.yW = new com.applovin.exoplayer2.e.r();
        this.zc = -9223372036854775807L;
        this.yX = new s();
        com.applovin.exoplayer2.e.g gVar = new com.applovin.exoplayer2.e.g();
        this.yY = gVar;
        this.za = gVar;
    }

    @Override // com.applovin.exoplayer2.e.h
    public boolean a(i iVar) throws IOException {
        return c(iVar, true);
    }

    @Override // com.applovin.exoplayer2.e.h
    public void a(j jVar) {
        this.vG = jVar;
        x xVarY = jVar.y(0, 1);
        this.yZ = xVarY;
        this.za = xVarY;
        this.vG.ig();
    }

    @Override // com.applovin.exoplayer2.e.h
    public void o(long j, long j2) {
        this.zb = 0;
        this.zc = -9223372036854775807L;
        this.zd = 0L;
        this.ze = 0;
        this.tL = j2;
        e eVar = this.zf;
        if (!(eVar instanceof b) || ((b) eVar).ar(j2)) {
            return;
        }
        this.zh = true;
        this.za = this.yY;
    }

    @Override // com.applovin.exoplayer2.e.h
    public int b(i iVar, u uVar) throws IOException {
        io();
        int iC = C(iVar);
        if (iC == -1 && (this.zf instanceof b)) {
            long jAt = at(this.zd);
            if (this.zf.dd() != jAt) {
                ((b) this.zf).as(jAt);
                this.vG.a(this.zf);
            }
        }
        return iC;
    }

    public void iG() {
        this.zg = true;
    }

    private int C(i iVar) throws IOException {
        if (this.zb == 0) {
            try {
                c(iVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zf == null) {
            e eVarE = E(iVar);
            this.zf = eVarE;
            this.vG.a(eVarE);
            this.za.j(new v.a().m(this.yV.eg).I(4096).N(this.yV.mI).O(this.yV.dM).Q(this.yW.dO).R(this.yW.dP).b((this.jF & 8) != 0 ? null : this.dx).bT());
            this.vC = iVar.ie();
        } else if (this.vC != 0) {
            long jIe = iVar.ie();
            long j = this.vC;
            if (jIe < j) {
                iVar.bH((int) (j - jIe));
            }
        }
        return g(iVar);
    }

    private int g(i iVar) throws IOException {
        if (this.ze == 0) {
            iVar.ic();
            if (D(iVar)) {
                return -1;
            }
            this.uO.fx(0);
            int iPx = this.uO.px();
            if (!f(iPx, this.zb) || r.aG(iPx) == -1) {
                iVar.bH(1);
                this.zb = 0;
                return 0;
            }
            this.yV.aK(iPx);
            if (this.zc == -9223372036854775807L) {
                this.zc = this.zf.aq(iVar.ie());
                if (this.yU != -9223372036854775807L) {
                    this.zc += this.yU - this.zf.aq(0L);
                }
            }
            this.ze = this.yV.jz;
            e eVar = this.zf;
            if (eVar instanceof b) {
                b bVar = (b) eVar;
                bVar.s(at(this.zd + ((long) this.yV.mJ)), iVar.ie() + ((long) this.yV.jz));
                if (this.zh && bVar.ar(this.tL)) {
                    this.zh = false;
                    this.za = this.yZ;
                }
            }
        }
        int iA = this.za.a((com.applovin.exoplayer2.k.g) iVar, this.ze, true);
        if (iA == -1) {
            return -1;
        }
        int i = this.ze - iA;
        this.ze = i;
        if (i > 0) {
            return 0;
        }
        this.za.a(at(this.zd), 1, this.yV.jz, 0, null);
        this.zd += (long) this.yV.mJ;
        this.ze = 0;
        return 0;
    }

    private long at(long j) {
        return this.zc + ((j * 1000000) / ((long) this.yV.dM));
    }

    private boolean c(i iVar, boolean z) throws IOException {
        int iId;
        int i;
        int iAG;
        int i2 = z ? 32768 : 131072;
        iVar.ic();
        if (iVar.ie() == 0) {
            com.applovin.exoplayer2.g.a aVarA = this.yX.a(iVar, (this.jF & 8) == 0 ? null : yT);
            this.dx = aVarA;
            if (aVarA != null) {
                this.yW.e(aVarA);
            }
            iId = (int) iVar.id();
            if (!z) {
                iVar.bH(iId);
            }
            i = 0;
        } else {
            iId = 0;
            i = 0;
        }
        int i3 = i;
        int i4 = i3;
        while (true) {
            if (D(iVar)) {
                if (i3 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.uO.fx(0);
            int iPx = this.uO.px();
            if ((i == 0 || f(iPx, i)) && (iAG = r.aG(iPx)) != -1) {
                i3++;
                if (i3 != 1) {
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    this.yV.aK(iPx);
                    i = iPx;
                }
                iVar.bI(iAG - 4);
            } else {
                int i5 = i4 + 1;
                if (i4 == i2) {
                    if (z) {
                        return false;
                    }
                    throw ai.c("Searched too many bytes.", null);
                }
                if (z) {
                    iVar.ic();
                    iVar.bI(iId + i5);
                } else {
                    iVar.bH(1);
                }
                i3 = 0;
                i4 = i5;
                i = 0;
            }
        }
        if (z) {
            iVar.bH(iId + i4);
        } else {
            iVar.ic();
        }
        this.zb = i;
        return true;
    }

    private boolean D(i iVar) throws IOException {
        e eVar = this.zf;
        if (eVar != null) {
            long jIF = eVar.iF();
            if (jIF != -1 && iVar.id() > jIF - 4) {
                return true;
            }
        }
        try {
            return !iVar.b(this.uO.hO(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private e E(i iVar) throws IOException {
        long jF;
        long j;
        long jDd;
        long jIF;
        e eVarF = F(iVar);
        c cVarA = a(this.dx, iVar.ie());
        if (this.zg) {
            return new e.a();
        }
        if ((this.jF & 4) != 0) {
            if (cVarA != null) {
                jDd = cVarA.dd();
                jIF = cVarA.iF();
            } else {
                if (eVarF != null) {
                    jDd = eVarF.dd();
                    jIF = eVarF.iF();
                } else {
                    jF = f(this.dx);
                    j = -1;
                }
                eVarF = new b(jF, iVar.ie(), j);
            }
            j = jIF;
            jF = jDd;
            eVarF = new b(jF, iVar.ie(), j);
        } else if (cVarA != null) {
            eVarF = cVarA;
        } else if (eVarF == null) {
            eVarF = null;
        }
        if (eVarF == null || !(eVarF.hU() || (this.jF & 1) == 0)) {
            return d(iVar, (this.jF & 2) != 0);
        }
        return eVarF;
    }

    private e F(i iVar) throws IOException {
        y yVar = new y(this.yV.jz);
        iVar.c(yVar.hO(), 0, this.yV.jz);
        int i = 21;
        if ((this.yV.mH & 1) != 0) {
            if (this.yV.mI != 1) {
                i = 36;
            }
        } else if (this.yV.mI == 1) {
            i = 13;
        }
        int i2 = i;
        int iF = f(yVar, i2);
        if (iF != 1483304551 && iF != 1231971951) {
            if (iF == 1447187017) {
                f fVarA = f.a(iVar.mo44if(), iVar.ie(), this.yV, yVar);
                iVar.bH(this.yV.jz);
                return fVarA;
            }
            iVar.ic();
            return null;
        }
        g gVarB = g.b(iVar.mo44if(), iVar.ie(), this.yV, yVar);
        if (gVarB != null && !this.yW.ij()) {
            iVar.ic();
            iVar.bI(i2 + 141);
            iVar.c(this.uO.hO(), 0, 3);
            this.uO.fx(0);
            this.yW.bP(this.uO.pt());
        }
        iVar.bH(this.yV.jz);
        return (gVarB == null || gVarB.hU() || iF != 1231971951) ? gVarB : d(iVar, false);
    }

    private e d(i iVar, boolean z) throws IOException {
        iVar.c(this.uO.hO(), 0, 4);
        this.uO.fx(0);
        this.yV.aK(this.uO.px());
        return new a(iVar.mo44if(), iVar.ie(), this.yV, z);
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.yZ);
        com.applovin.exoplayer2.l.ai.R(this.vG);
    }

    private static int f(y yVar, int i) {
        if (yVar.pk() >= i + 4) {
            yVar.fx(i);
            int iPx = yVar.px();
            if (iPx == 1483304551 || iPx == 1231971951) {
                return iPx;
            }
        }
        if (yVar.pk() < 40) {
            return 0;
        }
        yVar.fx(36);
        return yVar.px() == 1447187017 ? 1447187017 : 0;
    }

    private static c a(com.applovin.exoplayer2.g.a aVar, long j) {
        if (aVar == null) {
            return null;
        }
        int iKD = aVar.kD();
        for (int i = 0; i < iKD; i++) {
            com.applovin.exoplayer2.g.a.InterfaceC0095a interfaceC0095aDe = aVar.de(i);
            if (interfaceC0095aDe instanceof com.applovin.exoplayer2.g.e.j) {
                return c.a(j, (com.applovin.exoplayer2.g.e.j) interfaceC0095aDe, f(aVar));
            }
        }
        return null;
    }

    private static long f(com.applovin.exoplayer2.g.a aVar) {
        if (aVar == null) {
            return -9223372036854775807L;
        }
        int iKD = aVar.kD();
        for (int i = 0; i < iKD; i++) {
            com.applovin.exoplayer2.g.a.InterfaceC0095a interfaceC0095aDe = aVar.de(i);
            if (interfaceC0095aDe instanceof com.applovin.exoplayer2.g.e.l) {
                com.applovin.exoplayer2.g.e.l lVar = (com.applovin.exoplayer2.g.e.l) interfaceC0095aDe;
                if (lVar.f1do.equals("TLEN")) {
                    return com.applovin.exoplayer2.h.g(Long.parseLong(lVar.Jn));
                }
            }
        }
        return -9223372036854775807L;
    }
}
