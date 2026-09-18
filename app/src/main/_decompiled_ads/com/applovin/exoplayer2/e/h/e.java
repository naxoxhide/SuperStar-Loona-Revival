package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.k;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class e {
    public int BM;
    public long BN;
    public long BO;
    public long BP;
    public long BQ;
    public int BR;
    public int BT;
    public int BU;
    public int bs;
    public final int[] BV = new int[255];
    private final y uO = new y(255);

    e() {
    }

    public void Y() {
        this.BM = 0;
        this.bs = 0;
        this.BN = 0L;
        this.BO = 0L;
        this.BP = 0L;
        this.BQ = 0L;
        this.BR = 0;
        this.BT = 0;
        this.BU = 0;
    }

    public boolean T(com.applovin.exoplayer2.e.i iVar) throws IOException {
        return c(iVar, -1L);
    }

    public boolean c(com.applovin.exoplayer2.e.i iVar, long j) throws IOException {
        com.applovin.exoplayer2.l.a.checkArgument(iVar.ie() == iVar.id());
        this.uO.U(4);
        while (true) {
            if ((j != -1 && iVar.ie() + 4 >= j) || !k.a(iVar, this.uO.hO(), 0, 4, true)) {
                break;
            }
            this.uO.fx(0);
            if (this.uO.pv() == 1332176723) {
                iVar.ic();
                return true;
            }
            iVar.bH(1);
        }
        do {
            if (j != -1 && iVar.ie() >= j) {
                break;
            }
        } while (iVar.bG(1) != -1);
        return false;
    }

    public boolean f(com.applovin.exoplayer2.e.i iVar, boolean z) throws IOException {
        Y();
        this.uO.U(27);
        if (!k.a(iVar, this.uO.hO(), 0, 27, z) || this.uO.pv() != 1332176723) {
            return false;
        }
        int iPo = this.uO.po();
        this.BM = iPo;
        if (iPo != 0) {
            if (z) {
                return false;
            }
            throw ai.p("unsupported bit stream revision");
        }
        this.bs = this.uO.po();
        this.BN = this.uO.pA();
        this.BO = this.uO.pw();
        this.BP = this.uO.pw();
        this.BQ = this.uO.pw();
        int iPo2 = this.uO.po();
        this.BR = iPo2;
        this.BT = iPo2 + 27;
        this.uO.U(iPo2);
        if (!k.a(iVar, this.uO.hO(), 0, this.BR, z)) {
            return false;
        }
        for (int i = 0; i < this.BR; i++) {
            this.BV[i] = this.uO.po();
            this.BU += this.BV[i];
        }
        return true;
    }
}
