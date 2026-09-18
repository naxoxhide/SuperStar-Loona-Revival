package com.applovin.exoplayer2.e.i;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class c implements com.applovin.exoplayer2.e.h {
    public static final com.applovin.exoplayer2.e.l vq = new com.applovin.exoplayer2.e.l() { // from class: com.applovin.exoplayer2.e.i.-$$Lambda$c$zj5upTI2CEPAzqcQatNkmNq3eD4
        @Override // com.applovin.exoplayer2.e.l
        public final com.applovin.exoplayer2.e.h[] createExtractors() {
            return c.ih();
        }
    };
    private boolean Cq;
    private final d Cx = new d();
    private final com.applovin.exoplayer2.l.y Cp = new com.applovin.exoplayer2.l.y(16384);

    @Override // com.applovin.exoplayer2.e.h
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.applovin.exoplayer2.e.h[] ih() {
        return new com.applovin.exoplayer2.e.h[]{new c()};
    }

    @Override // com.applovin.exoplayer2.e.h
    public boolean a(com.applovin.exoplayer2.e.i iVar) throws IOException {
        com.applovin.exoplayer2.l.y yVar = new com.applovin.exoplayer2.l.y(10);
        int i = 0;
        while (true) {
            iVar.c(yVar.hO(), 0, 10);
            yVar.fx(0);
            if (yVar.pt() != 4801587) {
                break;
            }
            yVar.fz(3);
            int iPC = yVar.pC();
            i += iPC + 10;
            iVar.bI(iPC);
        }
        iVar.ic();
        iVar.bI(i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            iVar.c(yVar.hO(), 0, 7);
            yVar.fx(0);
            int iPp = yVar.pp();
            if (iPp == 44096 || iPp == 44097) {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iB = com.applovin.exoplayer2.b.c.b(yVar.hO(), iPp);
                if (iB == -1) {
                    return false;
                }
                iVar.bI(iB - 7);
            } else {
                iVar.ic();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                iVar.bI(i3);
                i2 = 0;
            }
        }
    }

    @Override // com.applovin.exoplayer2.e.h
    public void a(com.applovin.exoplayer2.e.j jVar) {
        this.Cx.a(jVar, new ad.d(0, 1));
        jVar.ig();
        jVar.a(new com.applovin.exoplayer2.e.v.b(-9223372036854775807L));
    }

    @Override // com.applovin.exoplayer2.e.h
    public void o(long j, long j2) {
        this.Cq = false;
        this.Cx.jb();
    }

    @Override // com.applovin.exoplayer2.e.h
    public int b(com.applovin.exoplayer2.e.i iVar, com.applovin.exoplayer2.e.u uVar) throws IOException {
        int i = iVar.read(this.Cp.hO(), 0, 16384);
        if (i == -1) {
            return -1;
        }
        this.Cp.fx(0);
        this.Cp.fA(i);
        if (!this.Cq) {
            this.Cx.e(0L, 4);
            this.Cq = true;
        }
        this.Cx.K(this.Cp);
        return 0;
    }
}
