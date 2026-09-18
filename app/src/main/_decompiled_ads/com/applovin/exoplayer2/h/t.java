package com.applovin.exoplayer2.h;

import android.net.Uri;
import android.os.Handler;
import com.applovin.exoplayer2.av;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class t implements com.applovin.exoplayer2.e.j, n, w.c, com.applovin.exoplayer2.k.w.a<a>, com.applovin.exoplayer2.k.w.e {
    private static final Map<String, String> LP = lm();
    private static final com.applovin.exoplayer2.v LQ = new com.applovin.exoplayer2.v.a().g("icy").m("application/x-icy").bT();
    private n.a KS;
    private final com.applovin.exoplayer2.k.i LR;
    private final com.applovin.exoplayer2.d.h LS;
    private final b LT;
    private final long LU;
    private final s LW;
    private final com.applovin.exoplayer2.k.b Lu;
    private com.applovin.exoplayer2.g.d.b Ma;
    private boolean Md;
    private boolean Me;
    private e Mf;
    private boolean Mg;
    private boolean Mh;
    private int Mi;
    private long Mj;
    private boolean Ml;
    private int Mm;
    private boolean Mn;
    private boolean cw;
    private final Uri ef;
    private final String eo;
    private final q.a fX;
    private final com.applovin.exoplayer2.d.g.a fY;
    private boolean fv;
    private boolean iO;
    private final com.applovin.exoplayer2.k.v sm;
    private com.applovin.exoplayer2.e.v vI;
    private final com.applovin.exoplayer2.k.w LV = new com.applovin.exoplayer2.k.w("ProgressiveMediaPeriod");
    private final com.applovin.exoplayer2.l.g LX = new com.applovin.exoplayer2.l.g();
    private final Runnable LY = new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$t$53z5nCg-sQn9ZudvwrazM0Orrvo
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lg();
        }
    };
    private final Runnable LZ = new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$t$sHqf767osbHcYNK5Ms6poogEqfY
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.ln();
        }
    };
    private final Handler jS = ai.pX();
    private d[] Mc = new d[0];
    private w[] Mb = new w[0];
    private long Mk = -9223372036854775807L;
    private long wC = -1;
    private long fH = -9223372036854775807L;
    private int gn = 1;

    interface b {
        void a(long j, boolean z, boolean z2);
    }

    @Override // com.applovin.exoplayer2.h.n
    public void t(long j) {
    }

    public t(Uri uri, com.applovin.exoplayer2.k.i iVar, s sVar, com.applovin.exoplayer2.d.h hVar, com.applovin.exoplayer2.d.g.a aVar, com.applovin.exoplayer2.k.v vVar, q.a aVar2, b bVar, com.applovin.exoplayer2.k.b bVar2, String str, int i) {
        this.ef = uri;
        this.LR = iVar;
        this.LS = hVar;
        this.fY = aVar;
        this.sm = vVar;
        this.fX = aVar2;
        this.LT = bVar;
        this.Lu = bVar2;
        this.eo = str;
        this.LU = i;
        this.LW = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ln() {
        if (this.cw) {
            return;
        }
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
    }

    public void release() {
        if (this.fv) {
            for (w wVar : this.Mb) {
                wVar.lx();
            }
        }
        this.LV.a(this);
        this.jS.removeCallbacksAndMessages(null);
        this.KS = null;
        this.cw = true;
    }

    @Override // com.applovin.exoplayer2.k.w.e
    public void ld() {
        for (w wVar : this.Mb) {
            wVar.release();
        }
        this.LW.release();
    }

    @Override // com.applovin.exoplayer2.h.n
    public void a(n.a aVar, long j) {
        this.KS = aVar;
        this.LX.oN();
        lh();
    }

    @Override // com.applovin.exoplayer2.h.n
    public void kM() throws IOException {
        kR();
        if (this.Mn && !this.fv) {
            throw com.applovin.exoplayer2.ai.c("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.applovin.exoplayer2.h.n
    public ad cj() {
        ll();
        return this.Mf.Mw;
    }

    @Override // com.applovin.exoplayer2.h.n
    public long a(com.applovin.exoplayer2.j.d[] dVarArr, boolean[] zArr, x[] xVarArr, boolean[] zArr2, long j) {
        ll();
        ad adVar = this.Mf.Mw;
        boolean[] zArr3 = this.Mf.My;
        int i = this.Mi;
        int i2 = 0;
        for (int i3 = 0; i3 < dVarArr.length; i3++) {
            if (xVarArr[i3] != null && (dVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((c) xVarArr[i3]).track;
                com.applovin.exoplayer2.l.a.checkState(zArr3[i4]);
                this.Mi--;
                zArr3[i4] = false;
                xVarArr[i3] = null;
            }
        }
        boolean z = !this.Mg ? j == 0 : i != 0;
        for (int i5 = 0; i5 < dVarArr.length; i5++) {
            if (xVarArr[i5] == null && dVarArr[i5] != null) {
                com.applovin.exoplayer2.j.d dVar = dVarArr[i5];
                com.applovin.exoplayer2.l.a.checkState(dVar.kD() == 1);
                com.applovin.exoplayer2.l.a.checkState(dVar.eP(0) == 0);
                int iA = adVar.a(dVar.nf());
                com.applovin.exoplayer2.l.a.checkState(!zArr3[iA]);
                this.Mi++;
                zArr3[iA] = true;
                xVarArr[i5] = new c(iA);
                zArr2[i5] = true;
                if (!z) {
                    w wVar = this.Mb[iA];
                    z = (wVar.e(j, true) || wVar.ly() == 0) ? false : true;
                }
            }
        }
        if (this.Mi == 0) {
            this.Ml = false;
            this.Mh = false;
            if (this.LV.kO()) {
                w[] wVarArr = this.Mb;
                int length = wVarArr.length;
                while (i2 < length) {
                    wVarArr[i2].lC();
                    i2++;
                }
                this.LV.oB();
            } else {
                w[] wVarArr2 = this.Mb;
                int length2 = wVarArr2.length;
                while (i2 < length2) {
                    wVarArr2[i2].Y();
                    i2++;
                }
            }
        } else if (z) {
            j = aQ(j);
            while (i2 < xVarArr.length) {
                if (xVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.Mg = true;
        return j;
    }

    @Override // com.applovin.exoplayer2.h.n
    public void d(long j, boolean z) {
        ll();
        if (lk()) {
            return;
        }
        boolean[] zArr = this.Mf.My;
        int length = this.Mb.length;
        for (int i = 0; i < length; i++) {
            this.Mb[i].b(j, z, zArr[i]);
        }
    }

    @Override // com.applovin.exoplayer2.h.n
    public boolean aR(long j) {
        if (this.Mn || this.LV.oz() || this.Ml) {
            return false;
        }
        if (this.fv && this.Mi == 0) {
            return false;
        }
        boolean zON = this.LX.oN();
        if (this.LV.kO()) {
            return zON;
        }
        lh();
        return true;
    }

    @Override // com.applovin.exoplayer2.h.n
    public boolean kO() {
        return this.LV.kO() && this.LX.hB();
    }

    @Override // com.applovin.exoplayer2.h.n
    public long ch() {
        if (this.Mi == 0) {
            return Long.MIN_VALUE;
        }
        return cg();
    }

    @Override // com.applovin.exoplayer2.h.n
    public long kN() {
        if (!this.Mh) {
            return -9223372036854775807L;
        }
        if (!this.Mn && li() <= this.Mm) {
            return -9223372036854775807L;
        }
        this.Mh = false;
        return this.Mj;
    }

    @Override // com.applovin.exoplayer2.h.n
    public long cg() {
        long jLj;
        ll();
        boolean[] zArr = this.Mf.Mx;
        if (this.Mn) {
            return Long.MIN_VALUE;
        }
        if (lk()) {
            return this.Mk;
        }
        if (this.Me) {
            int length = this.Mb.length;
            jLj = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.Mb[i].lB()) {
                    jLj = Math.min(jLj, this.Mb[i].lj());
                }
            }
        } else {
            jLj = Long.MAX_VALUE;
        }
        if (jLj == Long.MAX_VALUE) {
            jLj = lj();
        }
        return jLj == Long.MIN_VALUE ? this.Mj : jLj;
    }

    @Override // com.applovin.exoplayer2.h.n
    public long aQ(long j) {
        ll();
        boolean[] zArr = this.Mf.Mx;
        if (!this.vI.hU()) {
            j = 0;
        }
        int i = 0;
        this.Mh = false;
        this.Mj = j;
        if (lk()) {
            this.Mk = j;
            return j;
        }
        if (this.gn != 7 && a(zArr, j)) {
            return j;
        }
        this.Ml = false;
        this.Mk = j;
        this.Mn = false;
        if (this.LV.kO()) {
            w[] wVarArr = this.Mb;
            int length = wVarArr.length;
            while (i < length) {
                wVarArr[i].lC();
                i++;
            }
            this.LV.oB();
        } else {
            this.LV.oA();
            w[] wVarArr2 = this.Mb;
            int length2 = wVarArr2.length;
            while (i < length2) {
                wVarArr2[i].Y();
                i++;
            }
        }
        return j;
    }

    @Override // com.applovin.exoplayer2.h.n
    public long a(long j, av avVar) {
        ll();
        if (!this.vI.hU()) {
            return 0L;
        }
        com.applovin.exoplayer2.e.v.a aVarAi = this.vI.ai(j);
        return avVar.a(j, aVarAi.uQ.rJ, aVarAi.uR.rJ);
    }

    boolean dJ(int i) {
        return !le() && this.Mb[i].Q(this.Mn);
    }

    void dK(int i) throws IOException {
        this.Mb[i].kR();
        kR();
    }

    void kR() throws IOException {
        this.LV.dK(this.sm.fl(this.gn));
    }

    int a(int i, com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, int i2) {
        if (le()) {
            return -3;
        }
        dL(i);
        int iA = this.Mb[i].a(wVar, gVar, i2, this.Mn);
        if (iA == -3) {
            dM(i);
        }
        return iA;
    }

    int j(int i, long j) {
        if (le()) {
            return 0;
        }
        dL(i);
        w wVar = this.Mb[i];
        int iF = wVar.f(j, this.Mn);
        wVar.dP(iF);
        if (iF == 0) {
            dM(i);
        }
        return iF;
    }

    private void dL(int i) {
        ll();
        boolean[] zArr = this.Mf.Mz;
        if (zArr[i]) {
            return;
        }
        com.applovin.exoplayer2.v vVarDZ = this.Mf.Mw.eb(i).dZ(0);
        this.fX.a(com.applovin.exoplayer2.l.u.ba(vVarDZ.dz), vVarDZ, 0, (Object) null, this.Mj);
        zArr[i] = true;
    }

    private void dM(int i) {
        ll();
        boolean[] zArr = this.Mf.Mx;
        if (this.Ml && zArr[i]) {
            if (this.Mb[i].Q(false)) {
                return;
            }
            this.Mk = 0L;
            this.Ml = false;
            this.Mh = true;
            this.Mj = 0L;
            this.Mm = 0;
            for (w wVar : this.Mb) {
                wVar.Y();
            }
            ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
        }
    }

    private boolean le() {
        return this.Mh || lk();
    }

    @Override // com.applovin.exoplayer2.k.w.a
    public void a(a aVar, long j, long j2) {
        com.applovin.exoplayer2.e.v vVar;
        if (this.fH == -9223372036854775807L && (vVar = this.vI) != null) {
            boolean zHU = vVar.hU();
            long jLj = lj();
            long j3 = jLj == Long.MIN_VALUE ? 0L : jLj + 10000;
            this.fH = j3;
            this.LT.a(j3, zHU, this.iO);
        }
        com.applovin.exoplayer2.k.z zVar = aVar.Mo;
        j jVar = new j(aVar.Lq, aVar.tw, zVar.oI(), zVar.oJ(), j, j2, zVar.oH());
        this.sm.bm(aVar.Lq);
        this.fX.b(jVar, 1, -1, null, 0, null, aVar.tL, this.fH);
        a(aVar);
        this.Mn = true;
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
    }

    @Override // com.applovin.exoplayer2.k.w.a
    public void a(a aVar, long j, long j2, boolean z) {
        com.applovin.exoplayer2.k.z zVar = aVar.Mo;
        j jVar = new j(aVar.Lq, aVar.tw, zVar.oI(), zVar.oJ(), j, j2, zVar.oH());
        this.sm.bm(aVar.Lq);
        this.fX.c(jVar, 1, -1, null, 0, null, aVar.tL, this.fH);
        if (z) {
            return;
        }
        a(aVar);
        for (w wVar : this.Mb) {
            wVar.Y();
        }
        if (this.Mi > 0) {
            ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
        }
    }

    @Override // com.applovin.exoplayer2.k.w.a
    public com.applovin.exoplayer2.k.w.b a(a aVar, long j, long j2, IOException iOException, int i) {
        com.applovin.exoplayer2.k.w.b bVarC;
        a(aVar);
        com.applovin.exoplayer2.k.z zVar = aVar.Mo;
        j jVar = new j(aVar.Lq, aVar.tw, zVar.oI(), zVar.oJ(), j, j2, zVar.oH());
        long jA = this.sm.a(new com.applovin.exoplayer2.k.v.a(jVar, new m(1, -1, null, 0, null, com.applovin.exoplayer2.h.f(aVar.tL), com.applovin.exoplayer2.h.f(this.fH)), iOException, i));
        if (jA == -9223372036854775807L) {
            bVarC = com.applovin.exoplayer2.k.w.aaY;
        } else {
            int iLi = li();
            boolean z = iLi > this.Mm;
            if (a(aVar, iLi)) {
                bVarC = com.applovin.exoplayer2.k.w.c(z, jA);
            } else {
                bVarC = com.applovin.exoplayer2.k.w.aaX;
            }
        }
        boolean z2 = !bVarC.oC();
        this.fX.a(jVar, 1, -1, null, 0, null, aVar.tL, this.fH, iOException, z2);
        if (z2) {
            this.sm.bm(aVar.Lq);
        }
        return bVarC;
    }

    @Override // com.applovin.exoplayer2.e.j
    public com.applovin.exoplayer2.e.x y(int i, int i2) {
        return a(new d(i, false));
    }

    @Override // com.applovin.exoplayer2.e.j
    public void ig() {
        this.Md = true;
        this.jS.post(this.LY);
    }

    @Override // com.applovin.exoplayer2.e.j
    public void a(final com.applovin.exoplayer2.e.v vVar) {
        this.jS.post(new Runnable() { // from class: com.applovin.exoplayer2.h.-$$Lambda$t$c7NGpmdss2e8z9khP2UK4XZx5AY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(vVar);
            }
        });
    }

    com.applovin.exoplayer2.e.x lf() {
        return a(new d(0, true));
    }

    @Override // com.applovin.exoplayer2.h.w.c
    public void t(com.applovin.exoplayer2.v vVar) {
        this.jS.post(this.LY);
    }

    private com.applovin.exoplayer2.e.x a(d dVar) {
        int length = this.Mb.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.Mc[i])) {
                return this.Mb[i];
            }
        }
        w wVarA = w.a(this.Lu, this.jS.getLooper(), this.LS, this.fY);
        wVarA.a(this);
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.Mc, i2);
        dVarArr[length] = dVar;
        this.Mc = (d[]) ai.g(dVarArr);
        w[] wVarArr = (w[]) Arrays.copyOf(this.Mb, i2);
        wVarArr[length] = wVarA;
        this.Mb = (w[]) ai.g(wVarArr);
        return wVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void c(com.applovin.exoplayer2.e.v vVar) {
        this.vI = this.Ma == null ? vVar : new com.applovin.exoplayer2.e.v.b(-9223372036854775807L);
        this.fH = vVar.dd();
        boolean z = this.wC == -1 && vVar.dd() == -9223372036854775807L;
        this.iO = z;
        this.gn = z ? 7 : 1;
        this.LT.a(this.fH, vVar.hU(), this.iO);
        if (this.fv) {
            return;
        }
        lg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg() {
        com.applovin.exoplayer2.g.a aVarB;
        if (this.cw || this.fv || !this.Md || this.vI == null) {
            return;
        }
        for (w wVar : this.Mb) {
            if (wVar.lz() == null) {
                return;
            }
        }
        this.LX.oO();
        int length = this.Mb.length;
        ac[] acVarArr = new ac[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            com.applovin.exoplayer2.v vVarBT = (com.applovin.exoplayer2.v) com.applovin.exoplayer2.l.a.checkNotNull(this.Mb[i].lz());
            String str = vVarBT.dz;
            boolean zAW = com.applovin.exoplayer2.l.u.aW(str);
            boolean z = zAW || com.applovin.exoplayer2.l.u.aX(str);
            zArr[i] = z;
            this.Me = z | this.Me;
            com.applovin.exoplayer2.g.d.b bVar = this.Ma;
            if (bVar != null) {
                if (zAW || this.Mc[i].Mv) {
                    com.applovin.exoplayer2.g.a aVar = vVarBT.dx;
                    if (aVar == null) {
                        aVarB = new com.applovin.exoplayer2.g.a(bVar);
                    } else {
                        aVarB = aVar.b(bVar);
                    }
                    vVarBT = vVarBT.bR().b(aVarB).bT();
                }
                if (zAW && vVarBT.dt == -1 && vVarBT.du == -1 && bVar.dv != -1) {
                    vVarBT = vVarBT.bR().G(bVar.dv).bT();
                }
            }
            acVarArr[i] = new ac(vVarBT.B(this.LS.g(vVarBT)));
        }
        this.Mf = new e(new ad(acVarArr), zArr);
        this.fv = true;
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a((n) this);
    }

    private void a(a aVar) {
        if (this.wC == -1) {
            this.wC = aVar.wC;
        }
    }

    private void lh() {
        a aVar = new a(this.ef, this.LR, this.LW, this, this.LX);
        if (this.fv) {
            com.applovin.exoplayer2.l.a.checkState(lk());
            long j = this.fH;
            if (j != -9223372036854775807L && this.Mk > j) {
                this.Mn = true;
                this.Mk = -9223372036854775807L;
                return;
            }
            aVar.w(((com.applovin.exoplayer2.e.v) com.applovin.exoplayer2.l.a.checkNotNull(this.vI)).ai(this.Mk).uQ.uc, this.Mk);
            for (w wVar : this.Mb) {
                wVar.ba(this.Mk);
            }
            this.Mk = -9223372036854775807L;
        }
        this.Mm = li();
        this.fX.a(new j(aVar.Lq, aVar.tw, this.LV.a(aVar, this, this.sm.fl(this.gn))), 1, -1, null, 0, null, aVar.tL, this.fH);
    }

    private boolean a(a aVar, int i) {
        com.applovin.exoplayer2.e.v vVar;
        if (this.wC != -1 || ((vVar = this.vI) != null && vVar.dd() != -9223372036854775807L)) {
            this.Mm = i;
            return true;
        }
        if (this.fv && !le()) {
            this.Ml = true;
            return false;
        }
        this.Mh = this.fv;
        this.Mj = 0L;
        this.Mm = 0;
        for (w wVar : this.Mb) {
            wVar.Y();
        }
        aVar.w(0L, 0L);
        return true;
    }

    private boolean a(boolean[] zArr, long j) {
        int length = this.Mb.length;
        for (int i = 0; i < length; i++) {
            if (!this.Mb[i].e(j, false) && (zArr[i] || !this.Me)) {
                return false;
            }
        }
        return true;
    }

    private int li() {
        int iLw = 0;
        for (w wVar : this.Mb) {
            iLw += wVar.lw();
        }
        return iLw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long lj() {
        long jMax = Long.MIN_VALUE;
        for (w wVar : this.Mb) {
            jMax = Math.max(jMax, wVar.lj());
        }
        return jMax;
    }

    private boolean lk() {
        return this.Mk != -9223372036854775807L;
    }

    private void ll() {
        com.applovin.exoplayer2.l.a.checkState(this.fv);
        com.applovin.exoplayer2.l.a.checkNotNull(this.Mf);
        com.applovin.exoplayer2.l.a.checkNotNull(this.vI);
    }

    private final class c implements x {
        private final int track;

        public c(int i) {
            this.track = i;
        }

        @Override // com.applovin.exoplayer2.h.x
        public boolean isReady() {
            return t.this.dJ(this.track);
        }

        @Override // com.applovin.exoplayer2.h.x
        public void kR() throws IOException {
            t.this.dK(this.track);
        }

        @Override // com.applovin.exoplayer2.h.x
        public int b(com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, int i) {
            return t.this.a(this.track, wVar, gVar, i);
        }

        @Override // com.applovin.exoplayer2.h.x
        public int aS(long j) {
            return t.this.j(this.track, j);
        }
    }

    final class a implements i.a, com.applovin.exoplayer2.k.w.d {
        private final s LW;
        private final com.applovin.exoplayer2.l.g LX;
        private final com.applovin.exoplayer2.k.z Mo;
        private volatile boolean Mq;
        private com.applovin.exoplayer2.e.x Ms;
        private boolean Mt;
        private final Uri ef;
        private long tL;
        private final com.applovin.exoplayer2.e.j vG;
        private final com.applovin.exoplayer2.e.u Mp = new com.applovin.exoplayer2.e.u();
        private boolean Mr = true;
        private long wC = -1;
        private final long Lq = j.kV();
        private com.applovin.exoplayer2.k.l tw = aX(0);

        public a(Uri uri, com.applovin.exoplayer2.k.i iVar, s sVar, com.applovin.exoplayer2.e.j jVar, com.applovin.exoplayer2.l.g gVar) {
            this.ef = uri;
            this.Mo = new com.applovin.exoplayer2.k.z(iVar);
            this.LW = sVar;
            this.vG = jVar;
            this.LX = gVar;
        }

        @Override // com.applovin.exoplayer2.k.w.d
        public void lq() {
            this.Mq = true;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x00fb */
        @Override // com.applovin.exoplayer2.k.w.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void lr() throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.t.a.lr():void");
        }

        @Override // com.applovin.exoplayer2.h.i.a
        public void ab(com.applovin.exoplayer2.l.y yVar) {
            long jMax = !this.Mt ? this.tL : Math.max(t.this.lj(), this.tL);
            int iPj = yVar.pj();
            com.applovin.exoplayer2.e.x xVar = (com.applovin.exoplayer2.e.x) com.applovin.exoplayer2.l.a.checkNotNull(this.Ms);
            xVar.c(yVar, iPj);
            xVar.a(jMax, 1, iPj, 0, null);
            this.Mt = true;
        }

        private com.applovin.exoplayer2.k.l aX(long j) {
            return new com.applovin.exoplayer2.k.l.a().e(this.ef).bl(j).aL(t.this.eo).fi(6).d(t.LP).oj();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(long j, long j2) {
            this.Mp.uc = j;
            this.tL = j2;
            this.Mr = true;
            this.Mt = false;
        }
    }

    private static final class e {
        public final ad Mw;
        public final boolean[] Mx;
        public final boolean[] My;
        public final boolean[] Mz;

        public e(ad adVar, boolean[] zArr) {
            this.Mw = adVar;
            this.Mx = zArr;
            this.My = new boolean[adVar.fR];
            this.Mz = new boolean[adVar.fR];
        }
    }

    private static final class d {
        public final boolean Mv;
        public final int zD;

        public d(int i, boolean z) {
            this.zD = i;
            this.Mv = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.zD == dVar.zD && this.Mv == dVar.Mv;
        }

        public int hashCode() {
            return (this.zD * 31) + (this.Mv ? 1 : 0);
        }
    }

    private static Map<String, String> lm() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }
}
