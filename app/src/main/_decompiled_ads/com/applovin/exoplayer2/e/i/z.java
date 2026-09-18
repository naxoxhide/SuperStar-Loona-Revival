package com.applovin.exoplayer2.e.i;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z {
    private final com.applovin.exoplayer2.e.x[] CX;
    private final List<com.applovin.exoplayer2.v> zN;

    public z(List<com.applovin.exoplayer2.v> list) {
        this.zN = list;
        this.CX = new com.applovin.exoplayer2.e.x[list.size()];
    }

    public void a(com.applovin.exoplayer2.e.j jVar, ad.d dVar) {
        for (int i = 0; i < this.CX.length; i++) {
            dVar.jy();
            com.applovin.exoplayer2.e.x xVarY = jVar.y(dVar.jz(), 3);
            com.applovin.exoplayer2.v vVar = this.zN.get(i);
            String str = vVar.dz;
            com.applovin.exoplayer2.l.a.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            xVarY.j(new com.applovin.exoplayer2.v.a().g(vVar.f4do != null ? vVar.f4do : dVar.jA()).m(str).E(vVar.dr).j(vVar.dq).S(vVar.dQ).c(vVar.dB).bT());
            this.CX[i] = xVarY;
        }
    }

    public void a(long j, com.applovin.exoplayer2.l.y yVar) {
        com.applovin.exoplayer2.e.b.a(j, yVar, this.CX);
    }
}
