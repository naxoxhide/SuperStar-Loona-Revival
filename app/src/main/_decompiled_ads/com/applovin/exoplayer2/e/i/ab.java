package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class ab {
    private boolean EV;
    private final int Fq;
    private boolean Fr;
    private boolean Fs;
    private final ag Fo = new ag(0);
    private long Ft = -9223372036854775807L;
    private long Fu = -9223372036854775807L;
    private long fH = -9223372036854775807L;
    private final com.applovin.exoplayer2.l.y CB = new com.applovin.exoplayer2.l.y();

    ab(int i) {
        this.Fq = i;
    }

    public boolean jt() {
        return this.EV;
    }

    public int a(com.applovin.exoplayer2.e.i iVar, com.applovin.exoplayer2.e.u uVar, int i) throws IOException {
        if (i <= 0) {
            return Y(iVar);
        }
        if (!this.Fs) {
            return c(iVar, uVar, i);
        }
        if (this.Fu == -9223372036854775807L) {
            return Y(iVar);
        }
        if (!this.Fr) {
            return b(iVar, uVar, i);
        }
        long j = this.Ft;
        if (j == -9223372036854775807L) {
            return Y(iVar);
        }
        long jBr = this.Fo.br(this.Fu) - this.Fo.br(j);
        this.fH = jBr;
        if (jBr < 0) {
            com.applovin.exoplayer2.l.q.h("TsDurationReader", "Invalid duration: " + this.fH + ". Using TIME_UNSET instead.");
            this.fH = -9223372036854775807L;
        }
        return Y(iVar);
    }

    public long dd() {
        return this.fH;
    }

    public ag jv() {
        return this.Fo;
    }

    private int Y(com.applovin.exoplayer2.e.i iVar) {
        this.CB.I(ai.ada);
        this.EV = true;
        iVar.ic();
        return 0;
    }

    private int b(com.applovin.exoplayer2.e.i iVar, com.applovin.exoplayer2.e.u uVar, int i) throws IOException {
        int iMin = (int) Math.min(this.Fq, iVar.mo44if());
        long j = 0;
        if (iVar.ie() != j) {
            uVar.uc = j;
            return 1;
        }
        this.CB.U(iMin);
        iVar.ic();
        iVar.c(this.CB.hO(), 0, iMin);
        this.Ft = q(this.CB, i);
        this.Fr = true;
        return 0;
    }

    private long q(com.applovin.exoplayer2.l.y yVar, int i) {
        int iPk = yVar.pk();
        for (int iIl = yVar.il(); iIl < iPk; iIl++) {
            if (yVar.hO()[iIl] == 71) {
                long jF = ae.f(yVar, iIl, i);
                if (jF != -9223372036854775807L) {
                    return jF;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int c(com.applovin.exoplayer2.e.i iVar, com.applovin.exoplayer2.e.u uVar, int i) throws IOException {
        long jMo44if = iVar.mo44if();
        int iMin = (int) Math.min(this.Fq, jMo44if);
        long j = jMo44if - ((long) iMin);
        if (iVar.ie() != j) {
            uVar.uc = j;
            return 1;
        }
        this.CB.U(iMin);
        iVar.ic();
        iVar.c(this.CB.hO(), 0, iMin);
        this.Fu = r(this.CB, i);
        this.Fs = true;
        return 0;
    }

    private long r(com.applovin.exoplayer2.l.y yVar, int i) {
        int iIl = yVar.il();
        int iPk = yVar.pk();
        for (int i2 = iPk - 188; i2 >= iIl; i2--) {
            if (ae.a(yVar.hO(), iIl, iPk, i2)) {
                long jF = ae.f(yVar, i2, i);
                if (jF != -9223372036854775807L) {
                    return jF;
                }
            }
        }
        return -9223372036854775807L;
    }
}
