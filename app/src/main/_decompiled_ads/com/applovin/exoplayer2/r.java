package com.applovin.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
final class r extends d {
    private com.applovin.exoplayer2.h.z C;
    final an.a bA;
    private final ar[] bB;
    private final com.applovin.exoplayer2.j.j bC;
    private final com.applovin.exoplayer2.l.o bD;
    private final s.e bE;
    private final s bF;
    private final com.applovin.exoplayer2.l.p<an.b> bG;
    private final CopyOnWriteArraySet<q.a> bH;
    private final ba.a bI;
    private final List<a> bJ;
    private final boolean bK;
    private final com.applovin.exoplayer2.h.r bL;
    private final com.applovin.exoplayer2.a.a bM;
    private final Looper bN;
    private final com.applovin.exoplayer2.k.d bO;
    private final long bP;
    private final long bQ;
    private final com.applovin.exoplayer2.l.d bR;
    private int bS;
    private boolean bT;
    private int bU;
    private int bV;
    private boolean bW;
    private int bX;
    private av bY;
    private boolean bZ;
    final com.applovin.exoplayer2.j.k bz;
    private an.a ca;
    private ac cb;
    private ac cc;
    private al cd;
    private int ce;
    private int cf;
    private long cg;

    @Override // com.applovin.exoplayer2.an
    public void a(SurfaceView surfaceView) {
    }

    @Override // com.applovin.exoplayer2.an
    public void a(TextureView textureView) {
    }

    @Override // com.applovin.exoplayer2.an
    public long aJ() {
        return 3000L;
    }

    @Override // com.applovin.exoplayer2.an
    public void b(SurfaceView surfaceView) {
    }

    @Override // com.applovin.exoplayer2.an
    public void b(TextureView textureView) {
    }

    public r(ar[] arVarArr, com.applovin.exoplayer2.j.j jVar, com.applovin.exoplayer2.h.r rVar, aa aaVar, com.applovin.exoplayer2.k.d dVar, com.applovin.exoplayer2.a.a aVar, boolean z, av avVar, long j, long j2, z zVar, long j3, boolean z2, com.applovin.exoplayer2.l.d dVar2, Looper looper, an anVar, an.a aVar2) {
        com.applovin.exoplayer2.l.q.g("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.15.1] [" + com.applovin.exoplayer2.l.ai.acZ + "]");
        com.applovin.exoplayer2.l.a.checkState(arVarArr.length > 0);
        this.bB = (ar[]) com.applovin.exoplayer2.l.a.checkNotNull(arVarArr);
        this.bC = (com.applovin.exoplayer2.j.j) com.applovin.exoplayer2.l.a.checkNotNull(jVar);
        this.bL = rVar;
        this.bO = dVar;
        this.bM = aVar;
        this.bK = z;
        this.bY = avVar;
        this.bP = j;
        this.bQ = j2;
        this.bZ = z2;
        this.bN = looper;
        this.bR = dVar2;
        this.bS = 0;
        final an anVar2 = anVar != null ? anVar : this;
        this.bG = new com.applovin.exoplayer2.l.p<>(looper, dVar2, new com.applovin.exoplayer2.l.p.b() { // from class: com.applovin.exoplayer2.-$$Lambda$r$ZpaM36UtYXd_VZS8rjS21l4c69I
            @Override // com.applovin.exoplayer2.l.p.b
            public final void invoke(Object obj, com.applovin.exoplayer2.l.m mVar) {
                r.a(anVar2, (an.b) obj, mVar);
            }
        });
        this.bH = new CopyOnWriteArraySet<>();
        this.bJ = new ArrayList();
        this.C = new com.applovin.exoplayer2.h.z.a(0);
        com.applovin.exoplayer2.j.k kVar = new com.applovin.exoplayer2.j.k(new at[arVarArr.length], new com.applovin.exoplayer2.j.d[arVarArr.length], null);
        this.bz = kVar;
        this.bI = new ba.a();
        an.a aVarCC = new an.a.C0074a().a(1, 2, 12, 13, 14, 15, 16, 17, 18, 19).d(28, jVar.nh()).c(aVar2).cC();
        this.bA = aVarCC;
        this.ca = new an.a.C0074a().c(aVarCC).Y(3).Y(9).cC();
        this.cb = ac.eM;
        this.cc = ac.eM;
        this.ce = -1;
        this.bD = dVar2.a(looper, null);
        s.e eVar = new s.e() { // from class: com.applovin.exoplayer2.-$$Lambda$r$oi7qhUSswBmhWhBaffuReW1IkuI
            @Override // com.applovin.exoplayer2.s.e
            public final void onPlaybackInfoUpdate(s.d dVar3) {
                this.f$0.b(dVar3);
            }
        };
        this.bE = eVar;
        this.cd = al.a(kVar);
        if (aVar != null) {
            aVar.a(anVar2, looper);
            a((an.d) aVar);
            dVar.a(new Handler(looper), aVar);
        }
        this.bF = new s(arVarArr, jVar, kVar, aaVar, dVar, this.bS, this.bT, aVar, avVar, zVar, j3, z2, looper, dVar2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(an anVar, an.b bVar, com.applovin.exoplayer2.l.m mVar) {
        bVar.a(anVar, new an.c(mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final s.d dVar) {
        this.bD.e(new Runnable() { // from class: com.applovin.exoplayer2.-$$Lambda$r$Bk6Crx_Ve_BhVyTLS-b3QfKHFTk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(dVar);
            }
        });
    }

    public void j(long j) {
        this.bF.j(j);
    }

    public boolean ay() {
        return this.cd.gz;
    }

    @Override // com.applovin.exoplayer2.an
    public Looper az() {
        return this.bN;
    }

    @Override // com.applovin.exoplayer2.an
    public void a(an.d dVar) {
        a((an.b) dVar);
    }

    @Override // com.applovin.exoplayer2.an
    public void b(an.d dVar) {
        b((an.b) dVar);
    }

    public void a(an.b bVar) {
        this.bG.add(bVar);
    }

    public void b(an.b bVar) {
        this.bG.O(bVar);
    }

    public void a(q.a aVar) {
        this.bH.add(aVar);
    }

    @Override // com.applovin.exoplayer2.an
    public an.a aA() {
        return this.ca;
    }

    @Override // com.applovin.exoplayer2.an
    public int aB() {
        return this.cd.gs;
    }

    @Override // com.applovin.exoplayer2.an
    public int aC() {
        return this.cd.gx;
    }

    @Override // com.applovin.exoplayer2.an, com.applovin.exoplayer2.q
    /* JADX INFO: renamed from: aw, reason: merged with bridge method [inline-methods] */
    public p ax() {
        return this.cd.gt;
    }

    @Override // com.applovin.exoplayer2.an
    public void aD() {
        if (this.cd.gs != 1) {
            return;
        }
        al alVarA = this.cd.a((p) null);
        al alVarW = alVarA.W(alVarA.ci.isEmpty() ? 4 : 2);
        this.bU++;
        this.bF.aD();
        a(alVarW, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public void a(com.applovin.exoplayer2.h.p pVar) {
        b(Collections.singletonList(pVar));
    }

    public void b(List<com.applovin.exoplayer2.h.p> list) {
        a(list, true);
    }

    public void a(List<com.applovin.exoplayer2.h.p> list, boolean z) {
        a(list, -1, -9223372036854775807L, z);
    }

    @Override // com.applovin.exoplayer2.an
    public void k(boolean z) {
        a(z, 0, 1);
    }

    public void a(boolean z, int i, int i2) {
        if (this.cd.gw == z && this.cd.gx == i) {
            return;
        }
        this.bU++;
        al alVarC = this.cd.c(z, i);
        this.bF.b(z, i);
        a(alVarC, 0, i2, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.applovin.exoplayer2.an
    public boolean aE() {
        return this.cd.gw;
    }

    @Override // com.applovin.exoplayer2.an
    public void u(final int i) {
        if (this.bS != i) {
            this.bS = i;
            this.bF.u(i);
            this.bG.a(8, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$FOXmqUgjdeVxggYwI4sb-CG79zo
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    ((an.b) obj).ab(i);
                }
            });
            bb();
            this.bG.oZ();
        }
    }

    @Override // com.applovin.exoplayer2.an
    public int aF() {
        return this.bS;
    }

    @Override // com.applovin.exoplayer2.an
    public void l(final boolean z) {
        if (this.bT != z) {
            this.bT = z;
            this.bF.l(z);
            this.bG.a(9, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$H1Tqpdv69znGgQtU7ReBCNSYpQE
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    ((an.b) obj).z(z);
                }
            });
            bb();
            this.bG.oZ();
        }
    }

    @Override // com.applovin.exoplayer2.an
    public boolean aG() {
        return this.bT;
    }

    @Override // com.applovin.exoplayer2.an
    public void a(int i, long j) {
        ba baVar = this.cd.ci;
        if (i < 0 || (!baVar.isEmpty() && i >= baVar.cP())) {
            throw new y(baVar, i, j);
        }
        this.bU++;
        if (aP()) {
            com.applovin.exoplayer2.l.q.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            s.d dVar = new s.d(this.cd);
            dVar.x(1);
            this.bE.onPlaybackInfoUpdate(dVar);
            return;
        }
        int i2 = aB() != 1 ? 2 : 1;
        int iAL = aL();
        al alVarA = a(this.cd.W(i2), baVar, a(baVar, i, j));
        this.bF.b(baVar, i, h.g(j));
        a(alVarA, 0, 1, true, true, 1, a(alVarA), iAL);
    }

    @Override // com.applovin.exoplayer2.an
    public long aH() {
        return this.bP;
    }

    @Override // com.applovin.exoplayer2.an
    public long aI() {
        return this.bQ;
    }

    @Override // com.applovin.exoplayer2.an
    public am av() {
        return this.cd.gy;
    }

    public void a(boolean z, p pVar) {
        al alVarB;
        if (z) {
            alVarB = b(0, this.bJ.size()).a((p) null);
        } else {
            al alVar = this.cd;
            alVarB = alVar.b(alVar.dc);
            alVarB.gA = alVarB.cO;
            alVarB.gB = 0L;
        }
        al alVarW = alVarB.W(1);
        if (pVar != null) {
            alVarW = alVarW.a(pVar);
        }
        al alVar2 = alVarW;
        this.bU++;
        this.bF.W();
        a(alVar2, 0, 1, false, alVar2.ci.isEmpty() && !this.cd.ci.isEmpty(), 4, a(alVar2), -1);
    }

    public void release() {
        com.applovin.exoplayer2.l.q.g("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.15.1] [" + com.applovin.exoplayer2.l.ai.acZ + "] [" + t.bQ() + "]");
        if (!this.bF.bg()) {
            this.bG.b(10, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$pzyGE_qRZmy3LGTAO15KVm4hnA0
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.e((an.b) obj);
                }
            });
        }
        this.bG.release();
        this.bD.Q(null);
        com.applovin.exoplayer2.a.a aVar = this.bM;
        if (aVar != null) {
            this.bO.a(aVar);
        }
        al alVarW = this.cd.W(1);
        this.cd = alVarW;
        al alVarB = alVarW.b(alVarW.dc);
        this.cd = alVarB;
        alVarB.gA = alVarB.cO;
        this.cd.gB = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(an.b bVar) {
        bVar.a(p.a(new u(1), PointerIconCompat.TYPE_HELP));
    }

    public ao a(ao.b bVar) {
        return new ao(this.bF, bVar, this.cd.ci, aL(), this.bR, this.bF.bh());
    }

    @Override // com.applovin.exoplayer2.an
    public int aK() {
        if (this.cd.ci.isEmpty()) {
            return this.cf;
        }
        return this.cd.ci.c(this.cd.dc.gM);
    }

    @Override // com.applovin.exoplayer2.an
    public int aL() {
        int iBa = ba();
        if (iBa == -1) {
            return 0;
        }
        return iBa;
    }

    @Override // com.applovin.exoplayer2.an
    public long aM() {
        if (aP()) {
            com.applovin.exoplayer2.h.p.a aVar = this.cd.dc;
            this.cd.ci.a(aVar.gM, this.bI);
            return h.f(this.bI.i(aVar.gP, aVar.gQ));
        }
        return K();
    }

    @Override // com.applovin.exoplayer2.an
    public long aN() {
        return h.f(a(this.cd));
    }

    @Override // com.applovin.exoplayer2.an
    public long aO() {
        return h.f(this.cd.gB);
    }

    @Override // com.applovin.exoplayer2.an
    public boolean aP() {
        return this.cd.dc.la();
    }

    @Override // com.applovin.exoplayer2.an
    public int aQ() {
        if (aP()) {
            return this.cd.dc.gP;
        }
        return -1;
    }

    @Override // com.applovin.exoplayer2.an
    public int aR() {
        if (aP()) {
            return this.cd.dc.gQ;
        }
        return -1;
    }

    @Override // com.applovin.exoplayer2.an
    public long aS() {
        if (aP()) {
            this.cd.ci.a(this.cd.dc.gM, this.bI);
            if (this.cd.de == -9223372036854775807L) {
                return this.cd.ci.a(aL(), this.U).dj();
            }
            return this.bI.de() + h.f(this.cd.de);
        }
        return aN();
    }

    @Override // com.applovin.exoplayer2.an
    public long aT() {
        if (this.cd.ci.isEmpty()) {
            return this.cg;
        }
        if (this.cd.gv.LL != this.cd.dc.LL) {
            return this.cd.ci.a(aL(), this.U).dl();
        }
        long j = this.cd.gA;
        if (this.cd.gv.la()) {
            ba.a aVarA = this.cd.ci.a(this.cd.gv.gM, this.bI);
            long jAl = aVarA.al(this.cd.gv.gP);
            j = jAl == Long.MIN_VALUE ? aVarA.fH : jAl;
        }
        return h.f(a(this.cd.ci, this.cd.gv, j));
    }

    @Override // com.applovin.exoplayer2.an
    public com.applovin.exoplayer2.h.ad aU() {
        return this.cd.fB;
    }

    @Override // com.applovin.exoplayer2.an
    public com.applovin.exoplayer2.j.h aV() {
        return new com.applovin.exoplayer2.j.h(this.cd.fC.VE);
    }

    @Override // com.applovin.exoplayer2.an
    public ac aW() {
        return this.cb;
    }

    public void a(com.applovin.exoplayer2.g.a aVar) {
        ac acVarCc = this.cb.cb().c(aVar).cc();
        if (acVarCc.equals(this.cb)) {
            return;
        }
        this.cb = acVarCc;
        this.bG.b(14, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$ra3KCOndL3ZLL5sMfHBvrJiwrlA
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                this.f$0.d((an.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(an.b bVar) {
        bVar.a(this.cb);
    }

    @Override // com.applovin.exoplayer2.an
    public ba aX() {
        return this.cd.ci;
    }

    @Override // com.applovin.exoplayer2.an
    public com.applovin.exoplayer2.m.o aY() {
        return com.applovin.exoplayer2.m.o.afk;
    }

    @Override // com.applovin.exoplayer2.an
    /* JADX INFO: renamed from: aZ, reason: merged with bridge method [inline-methods] */
    public com.applovin.exoplayer2.common.a.s<com.applovin.exoplayer2.i.a> bd() {
        return com.applovin.exoplayer2.common.a.s.ga();
    }

    private int ba() {
        if (this.cd.ci.isEmpty()) {
            return this.ce;
        }
        return this.cd.ci.a(this.cd.dc.gM, this.bI).cN;
    }

    private long a(al alVar) {
        if (alVar.ci.isEmpty()) {
            return h.g(this.cg);
        }
        if (alVar.dc.la()) {
            return alVar.cO;
        }
        return a(alVar.ci, alVar.dc, alVar.cO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(s.d dVar) {
        long j;
        boolean z;
        this.bU -= dVar.cX;
        boolean z2 = true;
        if (dVar.cY) {
            this.bV = dVar.cZ;
            this.bW = true;
        }
        if (dVar.da) {
            this.bX = dVar.db;
        }
        if (this.bU == 0) {
            ba baVar = dVar.cd.ci;
            if (!this.cd.ci.isEmpty() && baVar.isEmpty()) {
                this.ce = -1;
                this.cg = 0L;
                this.cf = 0;
            }
            if (!baVar.isEmpty()) {
                List<ba> listCO = ((ap) baVar).cO();
                com.applovin.exoplayer2.l.a.checkState(listCO.size() == this.bJ.size());
                for (int i = 0; i < listCO.size(); i++) {
                    this.bJ.get(i).ci = listCO.get(i);
                }
            }
            long jA = -9223372036854775807L;
            if (this.bW) {
                if (dVar.cd.dc.equals(this.cd.dc) && dVar.cd.gr == this.cd.cO) {
                    z2 = false;
                }
                if (z2) {
                    if (baVar.isEmpty() || dVar.cd.dc.la()) {
                        jA = dVar.cd.gr;
                    } else {
                        jA = a(baVar, dVar.cd.dc, dVar.cd.gr);
                    }
                }
                j = jA;
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.bW = false;
            a(dVar.cd, 1, this.bX, false, z, this.bV, j, -1);
        }
    }

    private void a(final al alVar, final int i, final int i2, boolean z, boolean z2, final int i3, long j, int i4) {
        al alVar2 = this.cd;
        this.cd = alVar;
        Pair<Boolean, Integer> pairA = a(alVar, alVar2, z2, i3, !alVar2.ci.equals(alVar.ci));
        boolean zBooleanValue = ((Boolean) pairA.first).booleanValue();
        final int iIntValue = ((Integer) pairA.second).intValue();
        ac acVarCc = this.cb;
        final ab abVar = null;
        if (zBooleanValue) {
            if (!alVar.ci.isEmpty()) {
                abVar = alVar.ci.a(alVar.ci.a(alVar.dc.gM, this.bI).cN, this.U).gL;
            }
            acVarCc = abVar != null ? abVar.cb : ac.eM;
        }
        if (!alVar2.gu.equals(alVar.gu)) {
            acVarCc = acVarCc.cb().d(alVar.gu).cc();
        }
        boolean z3 = !acVarCc.equals(this.cb);
        this.cb = acVarCc;
        if (!alVar2.ci.equals(alVar.ci)) {
            this.bG.a(0, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$DCbHEgMjHalWleGqJ9FZfdZe9eQ
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.b(alVar, i, (an.b) obj);
                }
            });
        }
        if (z2) {
            final an.e eVarA = a(i3, alVar2, i4);
            final an.e eVarK = k(j);
            this.bG.a(11, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$9Jiqxvb38IwYbyVh29CEul9UONk
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.a(i3, eVarA, eVarK, (an.b) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.bG.a(1, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$n8-t204z7eV3XoDpz7vOwqcdMgg
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    ((an.b) obj).a(abVar, iIntValue);
                }
            });
        }
        if (alVar2.gt != alVar.gt) {
            this.bG.a(10, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$oUZgmoVpFlmisYeZL-tVfXKalfw
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.h(alVar, (an.b) obj);
                }
            });
            if (alVar.gt != null) {
                this.bG.a(10, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$SWAtaITTObwPaQN2WIcX8c2YT3M
                    @Override // com.applovin.exoplayer2.l.p.a
                    public final void invoke(Object obj) {
                        r.g(alVar, (an.b) obj);
                    }
                });
            }
        }
        if (alVar2.fC != alVar.fC) {
            this.bC.J(alVar.fC.VF);
            final com.applovin.exoplayer2.j.h hVar = new com.applovin.exoplayer2.j.h(alVar.fC.VE);
            this.bG.a(2, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$yq8-jcyIWaInIfQuDuh-J-D7RJo
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.a(alVar, hVar, (an.b) obj);
                }
            });
        }
        if (z3) {
            final ac acVar = this.cb;
            this.bG.a(14, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$ScTkirKEi_o8n4Oh13kZ5zr2A-k
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    ((an.b) obj).a(acVar);
                }
            });
        }
        if (alVar2.aW != alVar.aW) {
            this.bG.a(3, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$haXu3EKQKxPPJvGSEEIB_8p0IO4
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.f(alVar, (an.b) obj);
                }
            });
        }
        if (alVar2.gs != alVar.gs || alVar2.gw != alVar.gw) {
            this.bG.a(-1, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$PiSLG_8FeIQPSRS9rkPfhQK6jsA
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.e(alVar, (an.b) obj);
                }
            });
        }
        if (alVar2.gs != alVar.gs) {
            this.bG.a(4, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$DwXlICNEyQ2z2R_Vl_Aa1Zra6ak
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.d(alVar, (an.b) obj);
                }
            });
        }
        if (alVar2.gw != alVar.gw) {
            this.bG.a(5, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$pa86gNqIFlq3CRHe8eL_HnXdcZk
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.a(alVar, i2, (an.b) obj);
                }
            });
        }
        if (alVar2.gx != alVar.gx) {
            this.bG.a(6, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$g64VUC6b1hg0JTUkhrDlw92Bq4Y
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.c(alVar, (an.b) obj);
                }
            });
        }
        if (c(alVar2) != c(alVar)) {
            this.bG.a(7, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$JDflWdBDH7ef4urTUhf23PJuIAg
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.b(alVar, (an.b) obj);
                }
            });
        }
        if (!alVar2.gy.equals(alVar.gy)) {
            this.bG.a(12, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$h7QVLAUIywtxGMpFVCpPxxuyPxc
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    r.a(alVar, (an.b) obj);
                }
            });
        }
        if (z) {
            this.bG.a(-1, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$GlZXFMBgM8-8s-OtkeklTlj6TzA
                @Override // com.applovin.exoplayer2.l.p.a
                public final void invoke(Object obj) {
                    ((an.b) obj).cD();
                }
            });
        }
        bb();
        this.bG.oZ();
        if (alVar2.cD != alVar.cD) {
            Iterator<q.a> it = this.bH.iterator();
            while (it.hasNext()) {
                it.next().i(alVar.cD);
            }
        }
        if (alVar2.gz != alVar.gz) {
            Iterator<q.a> it2 = this.bH.iterator();
            while (it2.hasNext()) {
                it2.next().j(alVar.gz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(al alVar, int i, an.b bVar) {
        bVar.b(alVar.ci, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, an.e eVar, an.e eVar2, an.b bVar) {
        bVar.ac(i);
        bVar.a(eVar, eVar2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(al alVar, an.b bVar) {
        bVar.b(alVar.gt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(al alVar, an.b bVar) {
        bVar.a(alVar.gt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(al alVar, com.applovin.exoplayer2.j.h hVar, an.b bVar) {
        bVar.a(alVar.fB, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(al alVar, an.b bVar) {
        bVar.x(alVar.aW);
        bVar.w(alVar.aW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(al alVar, an.b bVar) {
        bVar.d(alVar.gw, alVar.gs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(al alVar, an.b bVar) {
        bVar.Z(alVar.gs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(al alVar, int i, an.b bVar) {
        bVar.e(alVar.gw, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(al alVar, an.b bVar) {
        bVar.aa(alVar.gx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(al alVar, an.b bVar) {
        bVar.y(c(alVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(al alVar, an.b bVar) {
        bVar.b(alVar.gy);
    }

    private an.e a(int i, al alVar, int i2) {
        int i3;
        int iC;
        Object obj;
        ab abVar;
        Object obj2;
        long jB;
        long jB2;
        ba.a aVar = new ba.a();
        if (alVar.ci.isEmpty()) {
            i3 = i2;
            iC = -1;
            obj = null;
            abVar = null;
            obj2 = null;
        } else {
            Object obj3 = alVar.dc.gM;
            alVar.ci.a(obj3, aVar);
            int i4 = aVar.cN;
            i3 = i4;
            obj2 = obj3;
            iC = alVar.ci.c(obj3);
            obj = alVar.ci.a(i4, this.U).ch;
            abVar = this.U.gL;
        }
        if (i == 0) {
            jB = aVar.iy + aVar.fH;
            if (alVar.dc.la()) {
                jB = aVar.i(alVar.dc.gP, alVar.dc.gQ);
                jB2 = b(alVar);
            } else {
                if (alVar.dc.LM != -1 && this.cd.dc.la()) {
                    jB = b(this.cd);
                }
                jB2 = jB;
            }
        } else if (alVar.dc.la()) {
            jB = alVar.cO;
            jB2 = b(alVar);
        } else {
            jB = aVar.iy + alVar.cO;
            jB2 = jB;
        }
        return new an.e(obj, i3, abVar, obj2, iC, h.f(jB), h.f(jB2), alVar.dc.gP, alVar.dc.gQ);
    }

    private an.e k(long j) {
        int iC;
        ab abVar;
        Object obj;
        int iAL = aL();
        Object obj2 = null;
        if (this.cd.ci.isEmpty()) {
            iC = -1;
            abVar = null;
            obj = null;
        } else {
            Object obj3 = this.cd.dc.gM;
            this.cd.ci.a(obj3, this.bI);
            iC = this.cd.ci.c(obj3);
            obj2 = this.cd.ci.a(iAL, this.U).ch;
            abVar = this.U.gL;
            obj = obj3;
        }
        long jF = h.f(j);
        return new an.e(obj2, iAL, abVar, obj, iC, jF, this.cd.dc.la() ? h.f(b(this.cd)) : jF, this.cd.dc.gP, this.cd.dc.gQ);
    }

    private static long b(al alVar) {
        ba.c cVar = new ba.c();
        ba.a aVar = new ba.a();
        alVar.ci.a(alVar.dc.gM, aVar);
        if (alVar.de == -9223372036854775807L) {
            return alVar.ci.a(aVar.cN, cVar).dk();
        }
        return aVar.df() + alVar.de;
    }

    private Pair<Boolean, Integer> a(al alVar, al alVar2, boolean z, int i, boolean z2) {
        ba baVar = alVar2.ci;
        ba baVar2 = alVar.ci;
        if (baVar2.isEmpty() && baVar.isEmpty()) {
            return new Pair<>(false, -1);
        }
        int i2 = 3;
        if (baVar2.isEmpty() != baVar.isEmpty()) {
            return new Pair<>(true, 3);
        }
        if (baVar.a(baVar.a(alVar2.dc.gM, this.bI).cN, this.U).ch.equals(baVar2.a(baVar2.a(alVar.dc.gM, this.bI).cN, this.U).ch)) {
            if (z && i == 0 && alVar2.dc.LL < alVar.dc.LL) {
                return new Pair<>(true, 0);
            }
            return new Pair<>(false, -1);
        }
        if (z && i == 0) {
            i2 = 1;
        } else if (z && i == 1) {
            i2 = 2;
        } else if (!z2) {
            throw new IllegalStateException();
        }
        return new Pair<>(true, Integer.valueOf(i2));
    }

    private void bb() {
        an.a aVar = this.ca;
        an.a aVarA = a(this.bA);
        this.ca = aVarA;
        if (aVarA.equals(aVar)) {
            return;
        }
        this.bG.a(13, new com.applovin.exoplayer2.l.p.a() { // from class: com.applovin.exoplayer2.-$$Lambda$r$C0v7-KhDfMwxO5eSDXzx3yVEFJ4
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                this.f$0.c((an.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(an.b bVar) {
        bVar.d(this.ca);
    }

    private void a(List<com.applovin.exoplayer2.h.p> list, int i, long j, boolean z) {
        int iD;
        long j2;
        int iBa = ba();
        long jAN = aN();
        this.bU++;
        if (!this.bJ.isEmpty()) {
            c(0, this.bJ.size());
        }
        List<ah.c> listA = a(0, list);
        ba baVarBc = bc();
        if (!baVarBc.isEmpty() && i >= baVarBc.cP()) {
            throw new y(baVarBc, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            iD = baVarBc.d(this.bT);
        } else if (i == -1) {
            iD = iBa;
            j2 = jAN;
        } else {
            iD = i;
            j2 = j;
        }
        al alVarA = a(this.cd, baVarBc, a(baVarBc, iD, j2));
        int i2 = alVarA.gs;
        if (iD != -1 && alVarA.gs != 1) {
            i2 = (baVarBc.isEmpty() || iD >= baVarBc.cP()) ? 4 : 2;
        }
        al alVarW = alVarA.W(i2);
        this.bF.a(listA, iD, h.g(j2), this.C);
        a(alVarW, 0, 1, false, (this.cd.dc.gM.equals(alVarW.dc.gM) || this.cd.ci.isEmpty()) ? false : true, 4, a(alVarW), -1);
    }

    private List<ah.c> a(int i, List<com.applovin.exoplayer2.h.p> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ah.c cVar = new ah.c(list.get(i2), this.bK);
            arrayList.add(cVar);
            this.bJ.add(i2 + i, new a(cVar.ch, cVar.gi.bf()));
        }
        this.C = this.C.E(i, arrayList.size());
        return arrayList;
    }

    private al b(int i, int i2) {
        boolean z = false;
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0 && i2 >= i && i2 <= this.bJ.size());
        int iAL = aL();
        ba baVarAX = aX();
        int size = this.bJ.size();
        this.bU++;
        c(i, i2);
        ba baVarBc = bc();
        al alVarA = a(this.cd, baVarBc, a(baVarAX, baVarBc));
        if (alVarA.gs != 1 && alVarA.gs != 4 && i < i2 && i2 == size && iAL >= alVarA.ci.cP()) {
            z = true;
        }
        if (z) {
            alVarA = alVarA.W(4);
        }
        this.bF.a(i, i2, this.C);
        return alVarA;
    }

    private void c(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.bJ.remove(i3);
        }
        this.C = this.C.F(i, i2);
    }

    private ba bc() {
        return new ap(this.bJ, this.C);
    }

    private al a(al alVar, ba baVar, Pair<Object, Long> pair) {
        long jI;
        com.applovin.exoplayer2.l.a.checkArgument(baVar.isEmpty() || pair != null);
        ba baVar2 = alVar.ci;
        al alVarC = alVar.c(baVar);
        if (baVar.isEmpty()) {
            com.applovin.exoplayer2.h.p.a aVarCB = al.cB();
            long jG = h.g(this.cg);
            al alVarB = alVarC.a(aVarCB, jG, jG, jG, 0L, com.applovin.exoplayer2.h.ad.NG, this.bz, com.applovin.exoplayer2.common.a.s.ga()).b(aVarCB);
            alVarB.gA = alVarB.cO;
            return alVarB;
        }
        Object obj = alVarC.dc.gM;
        boolean z = !obj.equals(((Pair) com.applovin.exoplayer2.l.ai.R(pair)).first);
        com.applovin.exoplayer2.h.p.a aVar = z ? new com.applovin.exoplayer2.h.p.a(pair.first) : alVarC.dc;
        long jLongValue = ((Long) pair.second).longValue();
        long jG2 = h.g(aS());
        if (!baVar2.isEmpty()) {
            jG2 -= baVar2.a(obj, this.bI).df();
        }
        if (z || jLongValue < jG2) {
            com.applovin.exoplayer2.l.a.checkState(!aVar.la());
            al alVarB2 = alVarC.a(aVar, jLongValue, jLongValue, jLongValue, 0L, z ? com.applovin.exoplayer2.h.ad.NG : alVarC.fB, z ? this.bz : alVarC.fC, z ? com.applovin.exoplayer2.common.a.s.ga() : alVarC.gu).b(aVar);
            alVarB2.gA = jLongValue;
            return alVarB2;
        }
        if (jLongValue == jG2) {
            int iC = baVar.c(alVarC.gv.gM);
            if (iC == -1 || baVar.a(iC, this.bI).cN != baVar.a(aVar.gM, this.bI).cN) {
                baVar.a(aVar.gM, this.bI);
                if (aVar.la()) {
                    jI = this.bI.i(aVar.gP, aVar.gQ);
                } else {
                    jI = this.bI.fH;
                }
                alVarC = alVarC.a(aVar, alVarC.cO, alVarC.cO, alVarC.gr, jI - alVarC.cO, alVarC.fB, alVarC.fC, alVarC.gu).b(aVar);
                alVarC.gA = jI;
            }
        } else {
            com.applovin.exoplayer2.l.a.checkState(!aVar.la());
            long jMax = Math.max(0L, alVarC.gB - (jLongValue - jG2));
            long j = alVarC.gA;
            if (alVarC.gv.equals(alVarC.dc)) {
                j = jLongValue + jMax;
            }
            alVarC = alVarC.a(aVar, jLongValue, jLongValue, jLongValue, jMax, alVarC.fB, alVarC.fC, alVarC.gu);
            alVarC.gA = j;
        }
        return alVarC;
    }

    private Pair<Object, Long> a(ba baVar, ba baVar2) {
        long jAS = aS();
        if (baVar.isEmpty() || baVar2.isEmpty()) {
            boolean z = !baVar.isEmpty() && baVar2.isEmpty();
            int iBa = z ? -1 : ba();
            if (z) {
                jAS = -9223372036854775807L;
            }
            return a(baVar2, iBa, jAS);
        }
        Pair<Object, Long> pairA = baVar.a(this.U, this.bI, aL(), h.g(jAS));
        Object obj = ((Pair) com.applovin.exoplayer2.l.ai.R(pairA)).first;
        if (baVar2.c(obj) != -1) {
            return pairA;
        }
        Object objA = s.a(this.U, this.bI, this.bS, this.bT, obj, baVar, baVar2);
        if (objA != null) {
            baVar2.a(objA, this.bI);
            return a(baVar2, this.bI.cN, baVar2.a(this.bI.cN, this.U).dj());
        }
        return a(baVar2, -1, -9223372036854775807L);
    }

    private Pair<Object, Long> a(ba baVar, int i, long j) {
        if (baVar.isEmpty()) {
            this.ce = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.cg = j;
            this.cf = 0;
            return null;
        }
        if (i == -1 || i >= baVar.cP()) {
            i = baVar.d(this.bT);
            j = baVar.a(i, this.U).dj();
        }
        return baVar.a(this.U, this.bI, i, h.g(j));
    }

    private long a(ba baVar, com.applovin.exoplayer2.h.p.a aVar, long j) {
        baVar.a(aVar.gM, this.bI);
        return j + this.bI.df();
    }

    private static boolean c(al alVar) {
        return alVar.gs == 3 && alVar.gw && alVar.gx == 0;
    }

    private static final class a implements ag {
        private final Object ch;
        private ba ci;

        public a(Object obj, ba baVar) {
            this.ch = obj;
            this.ci = baVar;
        }

        @Override // com.applovin.exoplayer2.ag
        public Object be() {
            return this.ch;
        }

        @Override // com.applovin.exoplayer2.ag
        public ba bf() {
            return this.ci;
        }
    }
}
