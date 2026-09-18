package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.ai;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class f implements j {
    private static final byte[] CH = {73, 68, 51};
    private int Ai;
    private final boolean CI;
    private final com.applovin.exoplayer2.l.x CJ;
    private final com.applovin.exoplayer2.l.y CK;
    private com.applovin.exoplayer2.e.x CL;
    private int CM;
    private boolean CN;
    private boolean CO;
    private int CP;
    private int CQ;
    private int CS;
    private com.applovin.exoplayer2.e.x CT;
    private long CU;
    private String Ct;
    private int Cu;
    private long Cw;
    private int Z;
    private final String dq;
    private long rJ;
    private boolean vJ;
    private com.applovin.exoplayer2.e.x wl;

    public static boolean cu(int i) {
        return (i & 65526) == 65520;
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void jc() {
    }

    public f(boolean z) {
        this(z, null);
    }

    public f(boolean z, String str) {
        this.CJ = new com.applovin.exoplayer2.l.x(new byte[7]);
        this.CK = new com.applovin.exoplayer2.l.y(Arrays.copyOf(CH, 10));
        jg();
        this.CP = -1;
        this.CQ = -1;
        this.Cw = -9223372036854775807L;
        this.rJ = -9223372036854775807L;
        this.CI = z;
        this.dq = str;
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void jb() {
        this.rJ = -9223372036854775807L;
        jf();
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void a(com.applovin.exoplayer2.e.j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        com.applovin.exoplayer2.e.x xVarY = jVar.y(dVar.jz(), 1);
        this.wl = xVarY;
        this.CT = xVarY;
        if (this.CI) {
            dVar.jy();
            com.applovin.exoplayer2.e.x xVarY2 = jVar.y(dVar.jz(), 5);
            this.CL = xVarY2;
            xVarY2.j(new com.applovin.exoplayer2.v.a().g(dVar.jA()).m("application/id3").bT());
            return;
        }
        this.CL = new com.applovin.exoplayer2.e.g();
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.rJ = j;
        }
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void K(com.applovin.exoplayer2.l.y yVar) throws ai {
        jm();
        while (yVar.pj() > 0) {
            int i = this.Z;
            if (i == 0) {
                M(yVar);
            } else if (i == 1) {
                N(yVar);
            } else if (i != 2) {
                if (i == 3) {
                    if (a(yVar, this.CJ.tf, this.CN ? 7 : 5)) {
                        jl();
                    }
                } else if (i == 4) {
                    O(yVar);
                } else {
                    throw new IllegalStateException();
                }
            } else if (a(yVar, this.CK.hO(), 10)) {
                jk();
            }
        }
    }

    public long je() {
        return this.Cw;
    }

    private void jf() {
        this.CO = false;
        jg();
    }

    private boolean a(com.applovin.exoplayer2.l.y yVar, byte[] bArr, int i) {
        int iMin = Math.min(yVar.pj(), i - this.Cu);
        yVar.r(bArr, this.Cu, iMin);
        int i2 = this.Cu + iMin;
        this.Cu = i2;
        return i2 == i;
    }

    private void jg() {
        this.Z = 0;
        this.Cu = 0;
        this.CM = 256;
    }

    private void jh() {
        this.Z = 2;
        this.Cu = CH.length;
        this.Ai = 0;
        this.CK.fx(0);
    }

    private void a(com.applovin.exoplayer2.e.x xVar, long j, int i, int i2) {
        this.Z = 4;
        this.Cu = i;
        this.CT = xVar;
        this.CU = j;
        this.Ai = i2;
    }

    private void ji() {
        this.Z = 3;
        this.Cu = 0;
    }

    private void jj() {
        this.Z = 1;
        this.Cu = 0;
    }

    private void M(com.applovin.exoplayer2.l.y yVar) {
        byte[] bArrHO = yVar.hO();
        int iIl = yVar.il();
        int iPk = yVar.pk();
        while (iIl < iPk) {
            int i = iIl + 1;
            int i2 = bArrHO[iIl] & 255;
            if (this.CM == 512 && a((byte) -1, (byte) i2) && (this.CO || n(yVar, i - 2))) {
                this.CS = (i2 & 8) >> 3;
                this.CN = (i2 & 1) == 0;
                if (!this.CO) {
                    jj();
                } else {
                    ji();
                }
                yVar.fx(i);
                return;
            }
            int i3 = this.CM;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.CM = 768;
            } else if (i4 == 511) {
                this.CM = 512;
            } else if (i4 == 836) {
                this.CM = 1024;
            } else if (i4 == 1075) {
                jh();
                yVar.fx(i);
                return;
            } else if (i3 != 256) {
                this.CM = 256;
                i--;
            }
            iIl = i;
        }
        yVar.fx(iIl);
    }

    private void N(com.applovin.exoplayer2.l.y yVar) {
        if (yVar.pj() == 0) {
            return;
        }
        this.CJ.tf[0] = yVar.hO()[yVar.il()];
        this.CJ.fx(2);
        int iBQ = this.CJ.bQ(4);
        int i = this.CQ;
        if (i != -1 && iBQ != i) {
            jf();
            return;
        }
        if (!this.CO) {
            this.CO = true;
            this.CP = this.CS;
            this.CQ = iBQ;
        }
        ji();
    }

    private boolean n(com.applovin.exoplayer2.l.y yVar, int i) {
        yVar.fx(i + 1);
        if (!b(yVar, this.CJ.tf, 1)) {
            return false;
        }
        this.CJ.fx(4);
        int iBQ = this.CJ.bQ(1);
        int i2 = this.CP;
        if (i2 != -1 && iBQ != i2) {
            return false;
        }
        if (this.CQ != -1) {
            if (!b(yVar, this.CJ.tf, 1)) {
                return true;
            }
            this.CJ.fx(2);
            if (this.CJ.bQ(4) != this.CQ) {
                return false;
            }
            yVar.fx(i + 2);
        }
        if (!b(yVar, this.CJ.tf, 4)) {
            return true;
        }
        this.CJ.fx(14);
        int iBQ2 = this.CJ.bQ(13);
        if (iBQ2 < 7) {
            return false;
        }
        byte[] bArrHO = yVar.hO();
        int iPk = yVar.pk();
        int i3 = i + iBQ2;
        if (i3 >= iPk) {
            return true;
        }
        if (bArrHO[i3] == -1) {
            int i4 = i3 + 1;
            if (i4 == iPk) {
                return true;
            }
            return a((byte) -1, bArrHO[i4]) && ((bArrHO[i4] & 8) >> 3) == iBQ;
        }
        if (bArrHO[i3] != 73) {
            return false;
        }
        int i5 = i3 + 1;
        if (i5 == iPk) {
            return true;
        }
        if (bArrHO[i5] != 68) {
            return false;
        }
        int i6 = i3 + 2;
        return i6 == iPk || bArrHO[i6] == 51;
    }

    private boolean a(byte b2, byte b3) {
        return cu(((b2 & 255) << 8) | (b3 & 255));
    }

    private boolean b(com.applovin.exoplayer2.l.y yVar, byte[] bArr, int i) {
        if (yVar.pj() < i) {
            return false;
        }
        yVar.r(bArr, 0, i);
        return true;
    }

    private void jk() {
        this.CL.c(this.CK, 10);
        this.CK.fx(6);
        a(this.CL, 0L, 10, this.CK.pC() + 10);
    }

    private void jl() throws ai {
        this.CJ.fx(0);
        if (!this.vJ) {
            int iBQ = this.CJ.bQ(2) + 1;
            if (iBQ != 2) {
                com.applovin.exoplayer2.l.q.h("AdtsReader", "Detected audio object type: " + iBQ + ", but assuming AAC LC.");
                iBQ = 2;
            }
            this.CJ.bR(5);
            byte[] bArrB = com.applovin.exoplayer2.b.a.b(iBQ, this.CQ, this.CJ.bQ(3));
            com.applovin.exoplayer2.b.a.C0076a c0076aB = com.applovin.exoplayer2.b.a.b(bArrB);
            com.applovin.exoplayer2.v vVarBT = new com.applovin.exoplayer2.v.a().g(this.Ct).m("audio/mp4a-latm").k(c0076aB.dw).N(c0076aB.dL).O(c0076aB.js).c(Collections.singletonList(bArrB)).j(this.dq).bT();
            this.Cw = 1024000000 / ((long) vVarBT.dM);
            this.wl.j(vVarBT);
            this.vJ = true;
        } else {
            this.CJ.bR(10);
        }
        this.CJ.bR(4);
        int iBQ2 = (this.CJ.bQ(13) - 2) - 5;
        if (this.CN) {
            iBQ2 -= 2;
        }
        a(this.wl, this.Cw, 0, iBQ2);
    }

    private void O(com.applovin.exoplayer2.l.y yVar) {
        int iMin = Math.min(yVar.pj(), this.Ai - this.Cu);
        this.CT.c(yVar, iMin);
        int i = this.Cu + iMin;
        this.Cu = i;
        int i2 = this.Ai;
        if (i == i2) {
            long j = this.rJ;
            if (j != -9223372036854775807L) {
                this.CT.a(j, 1, i2, 0, null);
                this.rJ += this.CU;
            }
            jg();
        }
    }

    private void jm() {
        com.applovin.exoplayer2.l.a.checkNotNull(this.wl);
        com.applovin.exoplayer2.l.ai.R(this.CT);
        com.applovin.exoplayer2.l.ai.R(this.CL);
    }
}
