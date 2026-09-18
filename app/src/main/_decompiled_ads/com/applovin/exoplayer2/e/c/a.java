package com.applovin.exoplayer2.e.c;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
final class a extends d {
    private static final int[] vT = {5512, 11025, 22050, 44100};
    private boolean vJ;
    private boolean vU;
    private int vV;

    public a(x xVar) {
        super(xVar);
    }

    @Override // com.applovin.exoplayer2.e.c.d
    protected boolean e(y yVar) throws d.a {
        if (!this.vU) {
            int iPo = yVar.po();
            int i = (iPo >> 4) & 15;
            this.vV = i;
            if (i == 2) {
                this.wl.j(new v.a().m("audio/mpeg").N(1).O(vT[(iPo >> 2) & 3]).bT());
                this.vJ = true;
            } else if (i == 7 || i == 8) {
                this.wl.j(new v.a().m(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").N(1).O(8000).bT());
                this.vJ = true;
            } else if (i != 10) {
                throw new d.a("Audio format not supported: " + this.vV);
            }
            this.vU = true;
        } else {
            yVar.fz(1);
        }
        return true;
    }

    @Override // com.applovin.exoplayer2.e.c.d
    protected boolean a(y yVar, long j) throws ai {
        if (this.vV == 2) {
            int iPj = yVar.pj();
            this.wl.c(yVar, iPj);
            this.wl.a(j, 1, iPj, 0, null);
            return true;
        }
        int iPo = yVar.po();
        if (iPo == 0 && !this.vJ) {
            int iPj2 = yVar.pj();
            byte[] bArr = new byte[iPj2];
            yVar.r(bArr, 0, iPj2);
            com.applovin.exoplayer2.b.a.C0076a c0076aB = com.applovin.exoplayer2.b.a.b(bArr);
            this.wl.j(new v.a().m("audio/mp4a-latm").k(c0076aB.dw).N(c0076aB.dL).O(c0076aB.js).c(Collections.singletonList(bArr)).bT());
            this.vJ = true;
            return false;
        }
        if (this.vV == 10 && iPo != 1) {
            return false;
        }
        int iPj3 = yVar.pj();
        this.wl.c(yVar, iPj3);
        this.wl.a(j, 1, iPj3, 0, null);
        return true;
    }
}
