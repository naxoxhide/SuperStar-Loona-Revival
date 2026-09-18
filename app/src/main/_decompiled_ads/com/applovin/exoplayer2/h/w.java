package com.applovin.exoplayer2.h;

import android.os.Looper;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class w implements com.applovin.exoplayer2.e.x {
    private final com.applovin.exoplayer2.d.h LS;
    private final v MS;
    private c MV;
    private com.applovin.exoplayer2.v MW;
    private com.applovin.exoplayer2.d.f MX;
    private int Nb;
    private int Nc;
    private int Nd;
    private boolean Ng;
    private boolean Nj;
    private com.applovin.exoplayer2.v Nk;
    private com.applovin.exoplayer2.v Nl;
    private int Nm;
    private boolean Nn;
    private boolean No;
    private long Np;
    private boolean Nq;
    private final Looper co;
    private int fR;
    private final com.applovin.exoplayer2.d.g.a fY;
    private final a MT = new a();
    private int MY = 1000;
    private int[] MZ = new int[1000];
    private long[] tS = new long[1000];
    private long[] tU = new long[1000];
    private int[] zJ = new int[1000];
    private int[] tR = new int[1000];
    private com.applovin.exoplayer2.e.x.a[] Na = new com.applovin.exoplayer2.e.x.a[1000];
    private final ab<b> MU = new ab<>(new com.applovin.exoplayer2.l.h() { // from class: com.applovin.exoplayer2.h.-$$Lambda$w$OOsuOr7O-BuLRvcnBo2Qfo7yXvQ
        @Override // com.applovin.exoplayer2.l.h
        public final void accept(Object obj) {
            w.a((w.b) obj);
        }
    });
    private long Gi = Long.MIN_VALUE;
    private long Ne = Long.MIN_VALUE;
    private long Nf = Long.MIN_VALUE;
    private boolean Ni = true;
    private boolean Nh = true;

    public interface c {
        void t(com.applovin.exoplayer2.v vVar);
    }

    public static w a(com.applovin.exoplayer2.k.b bVar, Looper looper, com.applovin.exoplayer2.d.h hVar, com.applovin.exoplayer2.d.g.a aVar) {
        return new w(bVar, (Looper) com.applovin.exoplayer2.l.a.checkNotNull(looper), (com.applovin.exoplayer2.d.h) com.applovin.exoplayer2.l.a.checkNotNull(hVar), (com.applovin.exoplayer2.d.g.a) com.applovin.exoplayer2.l.a.checkNotNull(aVar));
    }

    protected w(com.applovin.exoplayer2.k.b bVar, Looper looper, com.applovin.exoplayer2.d.h hVar, com.applovin.exoplayer2.d.g.a aVar) {
        this.co = looper;
        this.LS = hVar;
        this.fY = aVar;
        this.MS = new v(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b bVar) {
        bVar.Nr.release();
    }

    public void release() {
        e(true);
        lE();
    }

    public final void Y() {
        e(false);
    }

    public void e(boolean z) {
        this.MS.Y();
        this.fR = 0;
        this.Nb = 0;
        this.Nc = 0;
        this.Nd = 0;
        this.Nh = true;
        this.Gi = Long.MIN_VALUE;
        this.Ne = Long.MIN_VALUE;
        this.Nf = Long.MIN_VALUE;
        this.Ng = false;
        this.MU.clear();
        if (z) {
            this.Nk = null;
            this.Nl = null;
            this.Ni = true;
        }
    }

    public final void ba(long j) {
        this.Gi = j;
    }

    public final int lw() {
        return this.Nb + this.fR;
    }

    public void lx() {
        lC();
        lE();
    }

    public void kR() throws IOException {
        com.applovin.exoplayer2.d.f fVar = this.MX;
        if (fVar != null && fVar.P() == 1) {
            throw ((com.applovin.exoplayer2.d.f.a) com.applovin.exoplayer2.l.a.checkNotNull(this.MX.ht()));
        }
    }

    public final int ly() {
        return this.Nb + this.Nd;
    }

    public final synchronized com.applovin.exoplayer2.v lz() {
        return this.Ni ? null : this.Nl;
    }

    public final synchronized long lj() {
        return this.Nf;
    }

    public final synchronized long lA() {
        return Math.max(this.Ne, dT(this.Nd));
    }

    public final synchronized boolean lB() {
        return this.Ng;
    }

    public synchronized boolean Q(boolean z) {
        com.applovin.exoplayer2.v vVar;
        boolean z2 = true;
        if (!lF()) {
            if (!z && !this.Ng && ((vVar = this.Nl) == null || vVar == this.MW)) {
                z2 = false;
            }
            return z2;
        }
        if (this.MU.get(ly()).dU != this.MW) {
            return true;
        }
        return dR(dU(this.Nd));
    }

    public int a(com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, int i, boolean z) {
        int iA = a(wVar, gVar, (i & 2) != 0, z, this.MT);
        if (iA == -4 && !gVar.gY()) {
            boolean z2 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z2) {
                    this.MS.b(gVar, this.MT);
                } else {
                    this.MS.a(gVar, this.MT);
                }
            }
            if (!z2) {
                this.Nd++;
            }
        }
        return iA;
    }

    public final synchronized boolean e(long j, boolean z) {
        lt();
        int iDU = dU(this.Nd);
        if (lF() && j >= this.tU[iDU] && (j <= this.Nf || z)) {
            int iA = a(iDU, this.fR - this.Nd, j, true);
            if (iA == -1) {
                return false;
            }
            this.Gi = j;
            this.Nd += iA;
            return true;
        }
        return false;
    }

    public final synchronized int f(long j, boolean z) {
        int iDU = dU(this.Nd);
        if (lF() && j >= this.tU[iDU]) {
            if (j > this.Nf && z) {
                return this.fR - this.Nd;
            }
            int iA = a(iDU, this.fR - this.Nd, j, true);
            if (iA == -1) {
                return 0;
            }
            return iA;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000e  */
    public final synchronized void dP(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.Nd + i <= this.fR) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkArgument(z);
        this.Nd += i;
    }

    public final void b(long j, boolean z, boolean z2) {
        this.MS.aY(c(j, z, z2));
    }

    public final void lC() {
        this.MS.aY(lD());
    }

    public final void a(c cVar) {
        this.MV = cVar;
    }

    @Override // com.applovin.exoplayer2.e.x
    public final void j(com.applovin.exoplayer2.v vVar) {
        com.applovin.exoplayer2.v vVarU = u(vVar);
        this.Nj = false;
        this.Nk = vVar;
        boolean zV = v(vVarU);
        c cVar = this.MV;
        if (cVar == null || !zV) {
            return;
        }
        cVar.t(vVarU);
    }

    @Override // com.applovin.exoplayer2.e.x
    public final int a(com.applovin.exoplayer2.k.g gVar, int i, boolean z, int i2) throws IOException {
        return this.MS.a(gVar, i, z);
    }

    @Override // com.applovin.exoplayer2.e.x
    public final void a(com.applovin.exoplayer2.l.y yVar, int i, int i2) {
        this.MS.c(yVar, i);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    @Override // com.applovin.exoplayer2.e.x
    public void a(long j, int i, int i2, int i3, com.applovin.exoplayer2.e.x.a aVar) {
        int i4;
        if (this.Nj) {
            j((com.applovin.exoplayer2.v) com.applovin.exoplayer2.l.a.N(this.Nk));
        }
        int i5 = i & 1;
        boolean z = i5 != 0;
        if (this.Nh) {
            if (!z) {
                return;
            } else {
                this.Nh = false;
            }
        }
        long j2 = this.Np + j;
        if (!this.Nn) {
            i4 = i;
        } else {
            if (j2 < this.Gi) {
                return;
            }
            if (i5 == 0) {
                if (!this.No) {
                    com.applovin.exoplayer2.l.q.h("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.Nl);
                    this.No = true;
                }
                i4 = i | 1;
            } else {
                i4 = i;
            }
        }
        if (this.Nq) {
            if (!z || !bb(j2)) {
                return;
            } else {
                this.Nq = false;
            }
        }
        a(j2, i4, (this.MS.lu() - ((long) i2)) - ((long) i3), i2, aVar);
    }

    protected com.applovin.exoplayer2.v u(com.applovin.exoplayer2.v vVar) {
        return (this.Np == 0 || vVar.dD == Long.MAX_VALUE) ? vVar : vVar.bR().p(vVar.dD + this.Np).bT();
    }

    private synchronized void lt() {
        this.Nd = 0;
        this.MS.lt();
    }

    private synchronized int a(com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, boolean z, boolean z2, a aVar) {
        gVar.rI = false;
        if (!lF()) {
            if (!z2 && !this.Ng) {
                com.applovin.exoplayer2.v vVar = this.Nl;
                if (vVar == null || (!z && vVar == this.MW)) {
                    return -3;
                }
                a((com.applovin.exoplayer2.v) com.applovin.exoplayer2.l.a.checkNotNull(vVar), wVar);
                return -5;
            }
            gVar.bs(4);
            return -4;
        }
        com.applovin.exoplayer2.v vVar2 = this.MU.get(ly()).dU;
        if (!z && vVar2 == this.MW) {
            int iDU = dU(this.Nd);
            if (!dR(iDU)) {
                gVar.rI = true;
                return -3;
            }
            gVar.bs(this.zJ[iDU]);
            gVar.rJ = this.tU[iDU];
            if (gVar.rJ < this.Gi) {
                gVar.bt(Integer.MIN_VALUE);
            }
            aVar.oW = this.tR[iDU];
            aVar.zr = this.tS[iDU];
            aVar.xZ = this.Na[iDU];
            return -4;
        }
        a(vVar2, wVar);
        return -5;
    }

    private synchronized boolean v(com.applovin.exoplayer2.v vVar) {
        this.Ni = false;
        if (ai.r(vVar, this.Nl)) {
            return false;
        }
        if (!this.MU.isEmpty() && this.MU.lK().dU.equals(vVar)) {
            this.Nl = this.MU.lK().dU;
        } else {
            this.Nl = vVar;
        }
        this.Nn = com.applovin.exoplayer2.l.u.j(this.Nl.dz, this.Nl.dw);
        this.No = false;
        return true;
    }

    private synchronized long c(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.fR;
        if (i2 != 0) {
            long[] jArr = this.tU;
            int i3 = this.Nc;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.Nd) != i2) {
                    i2 = i + 1;
                }
                int iA = a(i3, i2, j, z);
                if (iA == -1) {
                    return -1L;
                }
                return dS(iA);
            }
        }
        return -1L;
    }

    private synchronized long lD() {
        int i = this.fR;
        if (i == 0) {
            return -1L;
        }
        return dS(i);
    }

    private void lE() {
        com.applovin.exoplayer2.d.f fVar = this.MX;
        if (fVar != null) {
            fVar.b(this.fY);
            this.MX = null;
            this.MW = null;
        }
    }

    private synchronized void a(long j, int i, long j2, int i2, com.applovin.exoplayer2.e.x.a aVar) {
        com.applovin.exoplayer2.d.h.a aVarA;
        int i3 = this.fR;
        if (i3 > 0) {
            int iDU = dU(i3 - 1);
            com.applovin.exoplayer2.l.a.checkArgument(this.tS[iDU] + ((long) this.tR[iDU]) <= j2);
        }
        this.Ng = (536870912 & i) != 0;
        this.Nf = Math.max(this.Nf, j);
        int iDU2 = dU(this.fR);
        this.tU[iDU2] = j;
        this.tS[iDU2] = j2;
        this.tR[iDU2] = i2;
        this.zJ[iDU2] = i;
        this.Na[iDU2] = aVar;
        this.MZ[iDU2] = this.Nm;
        if (this.MU.isEmpty() || !this.MU.lK().dU.equals(this.Nl)) {
            com.applovin.exoplayer2.d.h hVar = this.LS;
            if (hVar != null) {
                aVarA = hVar.a((Looper) com.applovin.exoplayer2.l.a.checkNotNull(this.co), this.fY, this.Nl);
            } else {
                aVarA = com.applovin.exoplayer2.d.h.a.tk;
            }
            this.MU.b(lw(), new b((com.applovin.exoplayer2.v) com.applovin.exoplayer2.l.a.checkNotNull(this.Nl), aVarA));
        }
        int i4 = this.fR + 1;
        this.fR = i4;
        int i5 = this.MY;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            com.applovin.exoplayer2.e.x.a[] aVarArr = new com.applovin.exoplayer2.e.x.a[i6];
            int i7 = this.Nc;
            int i8 = i5 - i7;
            System.arraycopy(this.tS, i7, jArr, 0, i8);
            System.arraycopy(this.tU, this.Nc, jArr2, 0, i8);
            System.arraycopy(this.zJ, this.Nc, iArr2, 0, i8);
            System.arraycopy(this.tR, this.Nc, iArr3, 0, i8);
            System.arraycopy(this.Na, this.Nc, aVarArr, 0, i8);
            System.arraycopy(this.MZ, this.Nc, iArr, 0, i8);
            int i9 = this.Nc;
            System.arraycopy(this.tS, 0, jArr, i8, i9);
            System.arraycopy(this.tU, 0, jArr2, i8, i9);
            System.arraycopy(this.zJ, 0, iArr2, i8, i9);
            System.arraycopy(this.tR, 0, iArr3, i8, i9);
            System.arraycopy(this.Na, 0, aVarArr, i8, i9);
            System.arraycopy(this.MZ, 0, iArr, i8, i9);
            this.tS = jArr;
            this.tU = jArr2;
            this.zJ = iArr2;
            this.tR = iArr3;
            this.Na = aVarArr;
            this.MZ = iArr;
            this.Nc = 0;
            this.MY = i6;
        }
    }

    private synchronized boolean bb(long j) {
        if (this.fR == 0) {
            return j > this.Ne;
        }
        if (lA() >= j) {
            return false;
        }
        dQ(this.Nb + bc(j));
        return true;
    }

    private long dQ(int i) {
        int iLw = lw() - i;
        boolean z = false;
        com.applovin.exoplayer2.l.a.checkArgument(iLw >= 0 && iLw <= this.fR - this.Nd);
        int i2 = this.fR - iLw;
        this.fR = i2;
        this.Nf = Math.max(this.Ne, dT(i2));
        if (iLw == 0 && this.Ng) {
            z = true;
        }
        this.Ng = z;
        this.MU.dY(i);
        int i3 = this.fR;
        if (i3 == 0) {
            return 0L;
        }
        int iDU = dU(i3 - 1);
        return this.tS[iDU] + ((long) this.tR[iDU]);
    }

    private boolean lF() {
        return this.Nd != this.fR;
    }

    private void a(com.applovin.exoplayer2.v vVar, com.applovin.exoplayer2.w wVar) {
        com.applovin.exoplayer2.v vVar2 = this.MW;
        boolean z = vVar2 == null;
        com.applovin.exoplayer2.d.e eVar = z ? null : vVar2.dC;
        this.MW = vVar;
        com.applovin.exoplayer2.d.e eVar2 = vVar.dC;
        com.applovin.exoplayer2.d.h hVar = this.LS;
        wVar.dU = hVar != null ? vVar.B(hVar.g(vVar)) : vVar;
        wVar.dT = this.MX;
        if (this.LS == null) {
            return;
        }
        if (z || !ai.r(eVar, eVar2)) {
            com.applovin.exoplayer2.d.f fVar = this.MX;
            com.applovin.exoplayer2.d.f fVarB = this.LS.b((Looper) com.applovin.exoplayer2.l.a.checkNotNull(this.co), this.fY, vVar);
            this.MX = fVarB;
            wVar.dT = fVarB;
            if (fVar != null) {
                fVar.b(this.fY);
            }
        }
    }

    private boolean dR(int i) {
        com.applovin.exoplayer2.d.f fVar = this.MX;
        return fVar == null || fVar.P() == 4 || ((this.zJ[i] & 1073741824) == 0 && this.MX.hs());
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long[] jArr = this.tU;
            if (jArr[i] > j) {
                return i3;
            }
            if (!z || (this.zJ[i] & 1) != 0) {
                if (jArr[i] == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.MY) {
                i = 0;
            }
        }
        return i3;
    }

    private int bc(long j) {
        int i = this.fR;
        int iDU = dU(i - 1);
        while (i > this.Nd && this.tU[iDU] >= j) {
            i--;
            iDU--;
            if (iDU == -1) {
                iDU = this.MY - 1;
            }
        }
        return i;
    }

    private long dS(int i) {
        this.Ne = Math.max(this.Ne, dT(i));
        this.fR -= i;
        int i2 = this.Nb + i;
        this.Nb = i2;
        int i3 = this.Nc + i;
        this.Nc = i3;
        int i4 = this.MY;
        if (i3 >= i4) {
            this.Nc = i3 - i4;
        }
        int i5 = this.Nd - i;
        this.Nd = i5;
        if (i5 < 0) {
            this.Nd = 0;
        }
        this.MU.dX(i2);
        if (this.fR == 0) {
            int i6 = this.Nc;
            if (i6 == 0) {
                i6 = this.MY;
            }
            int i7 = i6 - 1;
            return this.tS[i7] + ((long) this.tR[i7]);
        }
        return this.tS[this.Nc];
    }

    private long dT(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iDU = dU(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.tU[iDU]);
            if ((this.zJ[iDU] & 1) != 0) {
                break;
            }
            iDU--;
            if (iDU == -1) {
                iDU = this.MY - 1;
            }
        }
        return jMax;
    }

    private int dU(int i) {
        int i2 = this.Nc + i;
        int i3 = this.MY;
        return i2 < i3 ? i2 : i2 - i3;
    }

    static final class a {
        public int oW;
        public com.applovin.exoplayer2.e.x.a xZ;
        public long zr;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {
        public final com.applovin.exoplayer2.d.h.a Nr;
        public final com.applovin.exoplayer2.v dU;

        private b(com.applovin.exoplayer2.v vVar, com.applovin.exoplayer2.d.h.a aVar) {
            this.dU = vVar;
            this.Nr = aVar;
        }
    }
}
