package com.applovin.exoplayer2.h;

import com.applovin.exoplayer2.av;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements n, n.a {
    private n.a KS;
    private a[] KT = new a[0];
    private long KU;
    long KV;
    long KW;
    public final n ft;

    public d(n nVar, boolean z, long j, long j2) {
        this.ft = nVar;
        this.KU = z ? j : -9223372036854775807L;
        this.KV = j;
        this.KW = j2;
    }

    public void v(long j, long j2) {
        this.KV = j;
        this.KW = j2;
    }

    @Override // com.applovin.exoplayer2.h.n
    public void a(n.a aVar, long j) {
        this.KS = aVar;
        this.ft.a(this, j);
    }

    @Override // com.applovin.exoplayer2.h.n
    public void kM() throws IOException {
        this.ft.kM();
    }

    @Override // com.applovin.exoplayer2.h.n
    public ad cj() {
        return this.ft.cj();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x0067  */
    @Override // com.applovin.exoplayer2.h.n
    public long a(com.applovin.exoplayer2.j.d[] dVarArr, boolean[] zArr, x[] xVarArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        this.KT = new a[xVarArr.length];
        x[] xVarArr2 = new x[xVarArr.length];
        int i = 0;
        while (true) {
            x xVar = null;
            if (i >= xVarArr.length) {
                break;
            }
            a[] aVarArr = this.KT;
            aVarArr[i] = (a) xVarArr[i];
            if (aVarArr[i] != null) {
                xVar = aVarArr[i].KX;
            }
            xVarArr2[i] = xVar;
            i++;
        }
        long jA = this.ft.a(dVarArr, zArr, xVarArr2, zArr2, j);
        if (kP()) {
            long j3 = this.KV;
            if (j == j3 && a(j3, dVarArr)) {
                j2 = jA;
            } else {
                j2 = -9223372036854775807L;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        this.KU = j2;
        if (jA != j) {
            if (jA >= this.KV) {
                long j4 = this.KW;
                z = j4 == Long.MIN_VALUE || jA <= j4;
            }
        }
        com.applovin.exoplayer2.l.a.checkState(z);
        for (int i2 = 0; i2 < xVarArr.length; i2++) {
            if (xVarArr2[i2] == null) {
                this.KT[i2] = null;
            } else {
                a[] aVarArr2 = this.KT;
                if (aVarArr2[i2] == null || aVarArr2[i2].KX != xVarArr2[i2]) {
                    this.KT[i2] = new a(xVarArr2[i2]);
                }
            }
            xVarArr[i2] = this.KT[i2];
        }
        return jA;
    }

    @Override // com.applovin.exoplayer2.h.n
    public void d(long j, boolean z) {
        this.ft.d(j, z);
    }

    @Override // com.applovin.exoplayer2.h.n
    public void t(long j) {
        this.ft.t(j);
    }

    @Override // com.applovin.exoplayer2.h.n
    public long kN() {
        if (kP()) {
            long j = this.KU;
            this.KU = -9223372036854775807L;
            long jKN = kN();
            return jKN != -9223372036854775807L ? jKN : j;
        }
        long jKN2 = this.ft.kN();
        if (jKN2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkState(jKN2 >= this.KV);
        long j2 = this.KW;
        if (j2 != Long.MIN_VALUE && jKN2 > j2) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkState(z);
        return jKN2;
    }

    @Override // com.applovin.exoplayer2.h.n
    public long cg() {
        long jCg = this.ft.cg();
        if (jCg != Long.MIN_VALUE) {
            long j = this.KW;
            if (j == Long.MIN_VALUE || jCg < j) {
                return jCg;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    @Override // com.applovin.exoplayer2.h.n
    public long aQ(long j) {
        this.KU = -9223372036854775807L;
        boolean z = false;
        for (a aVar : this.KT) {
            if (aVar != null) {
                aVar.kQ();
            }
        }
        long jAQ = this.ft.aQ(j);
        if (jAQ == j) {
            z = true;
        } else if (jAQ >= this.KV) {
            long j2 = this.KW;
            if (j2 == Long.MIN_VALUE || jAQ <= j2) {
                z = true;
            }
        }
        com.applovin.exoplayer2.l.a.checkState(z);
        return jAQ;
    }

    @Override // com.applovin.exoplayer2.h.n
    public long a(long j, av avVar) {
        long j2 = this.KV;
        if (j == j2) {
            return j2;
        }
        return this.ft.a(j, b(j, avVar));
    }

    @Override // com.applovin.exoplayer2.h.n
    public long ch() {
        long jCh = this.ft.ch();
        if (jCh != Long.MIN_VALUE) {
            long j = this.KW;
            if (j == Long.MIN_VALUE || jCh < j) {
                return jCh;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.applovin.exoplayer2.h.n
    public boolean aR(long j) {
        return this.ft.aR(j);
    }

    @Override // com.applovin.exoplayer2.h.n
    public boolean kO() {
        return this.ft.kO();
    }

    @Override // com.applovin.exoplayer2.h.n.a
    public void a(n nVar) {
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a((n) this);
    }

    @Override // com.applovin.exoplayer2.h.y.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(n nVar) {
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
    }

    boolean kP() {
        return this.KU != -9223372036854775807L;
    }

    private av b(long j, av avVar) {
        long jB = ai.b(avVar.ho, 0L, j - this.KV);
        long j2 = avVar.hp;
        long j3 = this.KW;
        long jB2 = ai.b(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (jB == avVar.ho && jB2 == avVar.hp) ? avVar : new av(jB, jB2);
    }

    private static boolean a(long j, com.applovin.exoplayer2.j.d[] dVarArr) {
        if (j != 0) {
            for (com.applovin.exoplayer2.j.d dVar : dVarArr) {
                if (dVar != null) {
                    com.applovin.exoplayer2.v vVarNg = dVar.ng();
                    if (!com.applovin.exoplayer2.l.u.j(vVarNg.dz, vVarNg.dw)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final class a implements x {
        public final x KX;
        private boolean KY;

        public a(x xVar) {
            this.KX = xVar;
        }

        public void kQ() {
            this.KY = false;
        }

        @Override // com.applovin.exoplayer2.h.x
        public boolean isReady() {
            return !d.this.kP() && this.KX.isReady();
        }

        @Override // com.applovin.exoplayer2.h.x
        public void kR() throws IOException {
            this.KX.kR();
        }

        @Override // com.applovin.exoplayer2.h.x
        public int b(com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, int i) {
            if (d.this.kP()) {
                return -3;
            }
            if (this.KY) {
                gVar.bs(4);
                return -4;
            }
            int iB = this.KX.b(wVar, gVar, i);
            if (iB == -5) {
                com.applovin.exoplayer2.v vVar = (com.applovin.exoplayer2.v) com.applovin.exoplayer2.l.a.checkNotNull(wVar.dU);
                if (vVar.dO != 0 || vVar.dP != 0) {
                    wVar.dU = vVar.bR().Q(d.this.KV != 0 ? 0 : vVar.dO).R(d.this.KW == Long.MIN_VALUE ? vVar.dP : 0).bT();
                }
                return -5;
            }
            if (d.this.KW == Long.MIN_VALUE || ((iB != -4 || gVar.rJ < d.this.KW) && !(iB == -3 && d.this.cg() == Long.MIN_VALUE && !gVar.rI))) {
                return iB;
            }
            gVar.clear();
            gVar.bs(4);
            this.KY = true;
            return -4;
        }

        @Override // com.applovin.exoplayer2.h.x
        public int aS(long j) {
            if (d.this.kP()) {
                return -3;
            }
            return this.KX.aS(j);
        }
    }
}
