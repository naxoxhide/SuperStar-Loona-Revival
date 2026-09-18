package com.applovin.exoplayer2.e.c;

import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.t;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements h {
    public static final l vq = new l() { // from class: com.applovin.exoplayer2.e.c.-$$Lambda$b$jPY_KzI_TgSwJG53iXhp1oXJT0Y
        @Override // com.applovin.exoplayer2.e.l
        public final h[] createExtractors() {
            return b.ih();
        }
    };
    private j vG;
    private boolean wa;
    private long wb;
    private int wc;
    private int wd;
    private int we;
    private long wf;
    private boolean wg;
    private a wh;
    private e wi;
    private final y uO = new y(4);
    private final y vW = new y(9);
    private final y vX = new y(11);
    private final y vY = new y();
    private final c vZ = new c();
    private int Z = 1;

    @Override // com.applovin.exoplayer2.e.h
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new b()};
    }

    @Override // com.applovin.exoplayer2.e.h
    public boolean a(i iVar) throws IOException {
        iVar.c(this.uO.hO(), 0, 3);
        this.uO.fx(0);
        if (this.uO.pt() != 4607062) {
            return false;
        }
        iVar.c(this.uO.hO(), 0, 2);
        this.uO.fx(0);
        if ((this.uO.pp() & 250) != 0) {
            return false;
        }
        iVar.c(this.uO.hO(), 0, 4);
        this.uO.fx(0);
        int iPx = this.uO.px();
        iVar.ic();
        iVar.bI(iPx);
        iVar.c(this.uO.hO(), 0, 4);
        this.uO.fx(0);
        return this.uO.px() == 0;
    }

    @Override // com.applovin.exoplayer2.e.h
    public void a(j jVar) {
        this.vG = jVar;
    }

    @Override // com.applovin.exoplayer2.e.h
    public void o(long j, long j2) {
        if (j == 0) {
            this.Z = 1;
            this.wa = false;
        } else {
            this.Z = 3;
        }
        this.wc = 0;
    }

    @Override // com.applovin.exoplayer2.e.h
    public int b(i iVar, u uVar) throws IOException {
        com.applovin.exoplayer2.l.a.N(this.vG);
        while (true) {
            int i = this.Z;
            if (i != 1) {
                if (i == 2) {
                    o(iVar);
                } else if (i != 3) {
                    if (i == 4) {
                        if (q(iVar)) {
                            return 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (!p(iVar)) {
                    return -1;
                }
            } else if (!n(iVar)) {
                return -1;
            }
        }
    }

    private boolean n(i iVar) throws IOException {
        if (!iVar.a(this.vW.hO(), 0, 9, true)) {
            return false;
        }
        this.vW.fx(0);
        this.vW.fz(4);
        int iPo = this.vW.po();
        boolean z = (iPo & 4) != 0;
        boolean z2 = (iPo & 1) != 0;
        if (z && this.wh == null) {
            this.wh = new a(this.vG.y(8, 1));
        }
        if (z2 && this.wi == null) {
            this.wi = new e(this.vG.y(9, 2));
        }
        this.vG.ig();
        this.wc = (this.vW.px() - 9) + 4;
        this.Z = 2;
        return true;
    }

    private void o(i iVar) throws IOException {
        iVar.bH(this.wc);
        this.wc = 0;
        this.Z = 3;
    }

    private boolean p(i iVar) throws IOException {
        if (!iVar.a(this.vX.hO(), 0, 11, true)) {
            return false;
        }
        this.vX.fx(0);
        this.wd = this.vX.po();
        this.we = this.vX.pt();
        this.wf = this.vX.pt();
        this.wf = (((long) (this.vX.po() << 24)) | this.wf) * 1000;
        this.vX.fz(3);
        this.Z = 4;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x008b  */
    private boolean q(i iVar) throws IOException {
        boolean z;
        long j;
        long jIr = ir();
        int i = this.wd;
        boolean zB = false;
        if (i == 8 && this.wh != null) {
            iq();
            zB = this.wh.b(r(iVar), jIr);
        } else if (i == 9 && this.wi != null) {
            iq();
            zB = this.wi.b(r(iVar), jIr);
        } else {
            if (i == 18 && !this.wg) {
                zB = this.vZ.b(r(iVar), jIr);
                long jDd = this.vZ.dd();
                if (jDd != -9223372036854775807L) {
                    this.vG.a(new t(this.vZ.it(), this.vZ.is(), jDd));
                    this.wg = true;
                }
            } else {
                iVar.bH(this.we);
                z = false;
            }
            if (!this.wa && zB) {
                this.wa = true;
                if (this.vZ.dd() == -9223372036854775807L) {
                    j = -this.wf;
                } else {
                    j = 0;
                }
                this.wb = j;
            }
            this.wc = 4;
            this.Z = 2;
            return z;
        }
        z = true;
        if (!this.wa) {
            this.wa = true;
            if (this.vZ.dd() == -9223372036854775807L) {
                j = -this.wf;
            } else {
                j = 0;
            }
            this.wb = j;
        }
        this.wc = 4;
        this.Z = 2;
        return z;
    }

    private y r(i iVar) throws IOException {
        if (this.we > this.vY.pl()) {
            y yVar = this.vY;
            yVar.l(new byte[Math.max(yVar.pl() * 2, this.we)], 0);
        } else {
            this.vY.fx(0);
        }
        this.vY.fA(this.we);
        iVar.a(this.vY.hO(), 0, this.we);
        return this.vY;
    }

    private void iq() {
        if (this.wg) {
            return;
        }
        this.vG.a(new v.b(-9223372036854775807L));
        this.wg = true;
    }

    private long ir() {
        if (this.wa) {
            return this.wb + this.wf;
        }
        if (this.vZ.dd() == -9223372036854775807L) {
            return 0L;
        }
        return this.wf;
    }
}
