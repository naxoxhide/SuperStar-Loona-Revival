package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;

/* JADX INFO: loaded from: classes.dex */
public final class s implements x {
    private com.applovin.exoplayer2.v dU;
    private com.applovin.exoplayer2.e.x wl;
    private ag zS;

    public s(String str) {
        this.dU = new com.applovin.exoplayer2.v.a().m(str).bT();
    }

    @Override // com.applovin.exoplayer2.e.i.x
    public void a(ag agVar, com.applovin.exoplayer2.e.j jVar, ad.d dVar) {
        this.zS = agVar;
        dVar.jy();
        com.applovin.exoplayer2.e.x xVarY = jVar.y(dVar.jz(), 5);
        this.wl = xVarY;
        xVarY.j(this.dU);
    }

    @Override // com.applovin.exoplayer2.e.i.x
    public void K(com.applovin.exoplayer2.l.y yVar) {
        io();
        long jPT = this.zS.pT();
        long jPU = this.zS.pU();
        if (jPT == -9223372036854775807L || jPU == -9223372036854775807L) {
            return;
        }
        if (jPU != this.dU.dD) {
            com.applovin.exoplayer2.v vVarBT = this.dU.bR().p(jPU).bT();
            this.dU = vVarBT;
            this.wl.j(vVarBT);
        }
        int iPj = yVar.pj();
        this.wl.c(yVar, iPj);
        this.wl.a(jPT, 1, iPj, 0, null);
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.zS);
        ai.R(this.wl);
    }
}
