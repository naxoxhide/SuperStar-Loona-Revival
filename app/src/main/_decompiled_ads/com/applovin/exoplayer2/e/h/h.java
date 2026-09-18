package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class h {
    private f BZ;
    private long Bs;
    private long Bx;
    private long Ca;
    private long Cc;
    private boolean Cd;
    private boolean Ce;
    private int Z;
    private int dM;
    private j vG;
    private x vH;
    private final d BY = new d();
    private a Cb = new a();

    protected abstract long G(y yVar);

    protected abstract boolean a(y yVar, long j, a aVar) throws IOException;

    static class a {
        f BZ;
        v dU;

        a() {
        }
    }

    void a(j jVar, x xVar) {
        this.vG = jVar;
        this.vH = xVar;
        e(true);
    }

    protected void e(boolean z) {
        if (z) {
            this.Cb = new a();
            this.Bs = 0L;
            this.Z = 0;
        } else {
            this.Z = 1;
        }
        this.Bx = -1L;
        this.Ca = 0L;
    }

    final void o(long j, long j2) {
        this.BY.Y();
        if (j == 0) {
            e(!this.Cd);
        } else if (this.Z != 0) {
            this.Bx = aF(j2);
            ((f) ai.R(this.BZ)).aC(this.Bx);
            this.Z = 2;
        }
    }

    final int b(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        io();
        int i = this.Z;
        if (i == 0) {
            return V(iVar);
        }
        if (i == 1) {
            iVar.bH((int) this.Bs);
            this.Z = 2;
            return 0;
        }
        if (i == 2) {
            ai.R(this.BZ);
            return i(iVar, uVar);
        }
        if (i == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.vH);
        ai.R(this.vG);
    }

    private boolean U(com.applovin.exoplayer2.e.i iVar) throws IOException {
        while (this.BY.S(iVar)) {
            this.Cc = iVar.ie() - this.Bs;
            if (!a(this.BY.iZ(), this.Bs, this.Cb)) {
                return true;
            }
            this.Bs = iVar.ie();
        }
        this.Z = 3;
        return false;
    }

    private int V(com.applovin.exoplayer2.e.i iVar) throws IOException {
        if (!U(iVar)) {
            return -1;
        }
        this.dM = this.Cb.dU.dM;
        if (!this.Ce) {
            this.vH.j(this.Cb.dU);
            this.Ce = true;
        }
        if (this.Cb.BZ != null) {
            this.BZ = this.Cb.BZ;
        } else if (iVar.mo44if() == -1) {
            this.BZ = new b();
        } else {
            e eVarIY = this.BY.iY();
            this.BZ = new com.applovin.exoplayer2.e.h.a(this, this.Bs, iVar.mo44if(), eVarIY.BT + eVarIY.BU, eVarIY.BN, (eVarIY.bs & 4) != 0);
        }
        this.Z = 2;
        this.BY.ja();
        return 0;
    }

    private int i(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        long jN = this.BZ.N(iVar);
        if (jN >= 0) {
            uVar.uc = jN;
            return 1;
        }
        if (jN < -1) {
            aG(-(jN + 2));
        }
        if (!this.Cd) {
            this.vG.a((com.applovin.exoplayer2.e.v) com.applovin.exoplayer2.l.a.N(this.BZ.iX()));
            this.Cd = true;
        }
        if (this.Cc > 0 || this.BY.S(iVar)) {
            this.Cc = 0L;
            y yVarIZ = this.BY.iZ();
            long jG = G(yVarIZ);
            if (jG >= 0) {
                long j = this.Ca;
                if (j + jG >= this.Bx) {
                    long jAE = aE(j);
                    this.vH.c(yVarIZ, yVarIZ.pk());
                    this.vH.a(jAE, 1, yVarIZ.pk(), 0, null);
                    this.Bx = -1L;
                }
            }
            this.Ca += jG;
            return 0;
        }
        this.Z = 3;
        return -1;
    }

    protected long aE(long j) {
        return (j * 1000000) / ((long) this.dM);
    }

    protected long aF(long j) {
        return (((long) this.dM) * j) / 1000000;
    }

    protected void aG(long j) {
        this.Ca = j;
    }

    private static final class b implements f {
        @Override // com.applovin.exoplayer2.e.h.f
        public long N(com.applovin.exoplayer2.e.i iVar) {
            return -1L;
        }

        @Override // com.applovin.exoplayer2.e.h.f
        public void aC(long j) {
        }

        private b() {
        }

        @Override // com.applovin.exoplayer2.e.h.f
        public com.applovin.exoplayer2.e.v iX() {
            return new com.applovin.exoplayer2.e.v.b(-9223372036854775807L);
        }
    }
}
