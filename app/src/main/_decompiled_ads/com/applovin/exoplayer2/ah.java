package com.applovin.exoplayer2;

import android.os.Handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class ah {
    private final d fW;
    private final com.applovin.exoplayer2.h.q.a fX;
    private final com.applovin.exoplayer2.d.g.a fY;
    private final HashMap<c, b> fZ;
    private final Set<c> ga;
    private boolean gb;
    private com.applovin.exoplayer2.k.aa gc;
    private com.applovin.exoplayer2.h.z C = new com.applovin.exoplayer2.h.z.a(0);
    private final IdentityHashMap<com.applovin.exoplayer2.h.n, c> fU = new IdentityHashMap<>();
    private final Map<Object, c> fV = new HashMap();
    private final List<c> cM = new ArrayList();

    public interface d {
        void bi();
    }

    public ah(d dVar, com.applovin.exoplayer2.a.a aVar, Handler handler) {
        this.fW = dVar;
        com.applovin.exoplayer2.h.q.a aVar2 = new com.applovin.exoplayer2.h.q.a();
        this.fX = aVar2;
        com.applovin.exoplayer2.d.g.a aVar3 = new com.applovin.exoplayer2.d.g.a();
        this.fY = aVar3;
        this.fZ = new HashMap<>();
        this.ga = new HashSet();
        if (aVar != null) {
            aVar2.a(handler, aVar);
            aVar3.a(handler, aVar);
        }
    }

    public ba a(List<c> list, com.applovin.exoplayer2.h.z zVar) {
        d(0, this.cM.size());
        return a(this.cM.size(), list, zVar);
    }

    public ba a(int i, List<c> list, com.applovin.exoplayer2.h.z zVar) {
        if (!list.isEmpty()) {
            this.C = zVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.cM.get(i2 - 1);
                    cVar.U(cVar2.gk + cVar2.gi.bf().cP());
                } else {
                    cVar.U(0);
                }
                e(i2, cVar.gi.bf().cP());
                this.cM.add(i2, cVar);
                this.fV.put(cVar.ch, cVar);
                if (this.gb) {
                    c(cVar);
                    if (this.fU.isEmpty()) {
                        this.ga.add(cVar);
                    } else {
                        b(cVar);
                    }
                }
            }
        }
        return cy();
    }

    public ba c(int i, int i2, com.applovin.exoplayer2.h.z zVar) {
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0 && i <= i2 && i2 <= cx());
        this.C = zVar;
        d(i, i2);
        return cy();
    }

    public ba a(int i, int i2, int i3, com.applovin.exoplayer2.h.z zVar) {
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0 && i <= i2 && i2 <= cx() && i3 >= 0);
        this.C = zVar;
        if (i == i2 || i == i3) {
            return cy();
        }
        int iMin = Math.min(i, i3);
        int iMax = Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int iCP = this.cM.get(iMin).gk;
        com.applovin.exoplayer2.l.ai.a(this.cM, i, i2, i3);
        while (iMin <= iMax) {
            c cVar = this.cM.get(iMin);
            cVar.gk = iCP;
            iCP += cVar.gi.bf().cP();
            iMin++;
        }
        return cy();
    }

    public boolean cw() {
        return this.gb;
    }

    public int cx() {
        return this.cM.size();
    }

    public ba b(com.applovin.exoplayer2.h.z zVar) {
        int iCx = cx();
        if (zVar.lG() != iCx) {
            zVar = zVar.lJ().E(0, iCx);
        }
        this.C = zVar;
        return cy();
    }

    public void a(com.applovin.exoplayer2.k.aa aaVar) {
        com.applovin.exoplayer2.l.a.checkState(!this.gb);
        this.gc = aaVar;
        for (int i = 0; i < this.cM.size(); i++) {
            c cVar = this.cM.get(i);
            c(cVar);
            this.ga.add(cVar);
        }
        this.gb = true;
    }

    public com.applovin.exoplayer2.h.n a(com.applovin.exoplayer2.h.p.a aVar, com.applovin.exoplayer2.k.b bVar, long j) {
        Object objF = f(aVar.gM);
        com.applovin.exoplayer2.h.p.a aVarG = aVar.G(g(aVar.gM));
        c cVar = (c) com.applovin.exoplayer2.l.a.checkNotNull(this.fV.get(objF));
        a(cVar);
        cVar.gj.add(aVarG);
        com.applovin.exoplayer2.h.k kVarA = cVar.gi.a(aVarG, bVar, j);
        this.fU.put(kVarA, cVar);
        cz();
        return kVarA;
    }

    public void f(com.applovin.exoplayer2.h.n nVar) {
        c cVar = (c) com.applovin.exoplayer2.l.a.checkNotNull(this.fU.remove(nVar));
        cVar.gi.f(nVar);
        cVar.gj.remove(((com.applovin.exoplayer2.h.k) nVar).fE);
        if (!this.fU.isEmpty()) {
            cz();
        }
        d(cVar);
    }

    public void release() {
        for (b bVar : this.fZ.values()) {
            try {
                bVar.gf.c(bVar.gg);
            } catch (RuntimeException e) {
                com.applovin.exoplayer2.l.q.c("MediaSourceList", "Failed to release child source.", e);
            }
            bVar.gf.a(bVar.gh);
            bVar.gf.f(bVar.gh);
        }
        this.fZ.clear();
        this.ga.clear();
        this.gb = false;
    }

    public ba cy() {
        if (this.cM.isEmpty()) {
            return ba.iw;
        }
        int iCP = 0;
        for (int i = 0; i < this.cM.size(); i++) {
            c cVar = this.cM.get(i);
            cVar.gk = iCP;
            iCP += cVar.gi.bf().cP();
        }
        return new ap(this.cM, this.C);
    }

    private void a(c cVar) {
        this.ga.add(cVar);
        b bVar = this.fZ.get(cVar);
        if (bVar != null) {
            bVar.gf.a(bVar.gg);
        }
    }

    private void cz() {
        Iterator<c> it = this.ga.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.gj.isEmpty()) {
                b(next);
                it.remove();
            }
        }
    }

    private void b(c cVar) {
        b bVar = this.fZ.get(cVar);
        if (bVar != null) {
            bVar.gf.b(bVar.gg);
        }
    }

    private void d(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVarRemove = this.cM.remove(i3);
            this.fV.remove(cVarRemove.ch);
            e(i3, -cVarRemove.gi.bf().cP());
            cVarRemove.gl = true;
            if (this.gb) {
                d(cVarRemove);
            }
        }
    }

    private void e(int i, int i2) {
        while (i < this.cM.size()) {
            this.cM.get(i).gk += i2;
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.applovin.exoplayer2.h.p.a a(c cVar, com.applovin.exoplayer2.h.p.a aVar) {
        for (int i = 0; i < cVar.gj.size(); i++) {
            if (cVar.gj.get(i).LL == aVar.LL) {
                return aVar.G(a(cVar, aVar.gM));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(c cVar, int i) {
        return i + cVar.gk;
    }

    private void c(c cVar) {
        com.applovin.exoplayer2.h.l lVar = cVar.gi;
        com.applovin.exoplayer2.h.p.b bVar = new com.applovin.exoplayer2.h.p.b() { // from class: com.applovin.exoplayer2.-$$Lambda$ah$iQAtDil7aD0Qm2VgXDjE_sQ3Fjw
            @Override // com.applovin.exoplayer2.h.p.b
            public final void onSourceInfoRefreshed(com.applovin.exoplayer2.h.p pVar, ba baVar) {
                this.f$0.a(pVar, baVar);
            }
        };
        a aVar = new a(cVar);
        this.fZ.put(cVar, new b(lVar, bVar, aVar));
        lVar.a(com.applovin.exoplayer2.l.ai.pY(), aVar);
        lVar.b(com.applovin.exoplayer2.l.ai.pY(), aVar);
        lVar.a(bVar, this.gc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.exoplayer2.h.p pVar, ba baVar) {
        this.fW.bi();
    }

    private void d(c cVar) {
        if (cVar.gl && cVar.gj.isEmpty()) {
            b bVar = (b) com.applovin.exoplayer2.l.a.checkNotNull(this.fZ.remove(cVar));
            bVar.gf.c(bVar.gg);
            bVar.gf.a(bVar.gh);
            bVar.gf.f(bVar.gh);
            this.ga.remove(cVar);
        }
    }

    private static Object f(Object obj) {
        return ap.a(obj);
    }

    private static Object g(Object obj) {
        return ap.b(obj);
    }

    private static Object a(c cVar, Object obj) {
        return ap.a(cVar.ch, obj);
    }

    static final class c implements ag {
        public final com.applovin.exoplayer2.h.l gi;
        public int gk;
        public boolean gl;
        public final List<com.applovin.exoplayer2.h.p.a> gj = new ArrayList();
        public final Object ch = new Object();

        public c(com.applovin.exoplayer2.h.p pVar, boolean z) {
            this.gi = new com.applovin.exoplayer2.h.l(pVar, z);
        }

        public void U(int i) {
            this.gk = i;
            this.gl = false;
            this.gj.clear();
        }

        @Override // com.applovin.exoplayer2.ag
        public Object be() {
            return this.ch;
        }

        @Override // com.applovin.exoplayer2.ag
        public ba bf() {
            return this.gi.bf();
        }
    }

    private static final class b {
        public final com.applovin.exoplayer2.h.p gf;
        public final com.applovin.exoplayer2.h.p.b gg;
        public final a gh;

        public b(com.applovin.exoplayer2.h.p pVar, com.applovin.exoplayer2.h.p.b bVar, a aVar) {
            this.gf = pVar;
            this.gg = bVar;
            this.gh = aVar;
        }
    }

    private final class a implements com.applovin.exoplayer2.d.g, com.applovin.exoplayer2.h.q {
        private com.applovin.exoplayer2.h.q.a fX;
        private com.applovin.exoplayer2.d.g.a fY;
        private final c gd;

        public a(c cVar) {
            this.fX = ah.this.fX;
            this.fY = ah.this.fY;
            this.gd = cVar;
        }

        @Override // com.applovin.exoplayer2.h.q
        public void a(int i, com.applovin.exoplayer2.h.p.a aVar, com.applovin.exoplayer2.h.j jVar, com.applovin.exoplayer2.h.m mVar) {
            if (e(i, aVar)) {
                this.fX.a(jVar, mVar);
            }
        }

        @Override // com.applovin.exoplayer2.h.q
        public void b(int i, com.applovin.exoplayer2.h.p.a aVar, com.applovin.exoplayer2.h.j jVar, com.applovin.exoplayer2.h.m mVar) {
            if (e(i, aVar)) {
                this.fX.b(jVar, mVar);
            }
        }

        @Override // com.applovin.exoplayer2.h.q
        public void c(int i, com.applovin.exoplayer2.h.p.a aVar, com.applovin.exoplayer2.h.j jVar, com.applovin.exoplayer2.h.m mVar) {
            if (e(i, aVar)) {
                this.fX.c(jVar, mVar);
            }
        }

        @Override // com.applovin.exoplayer2.h.q
        public void a(int i, com.applovin.exoplayer2.h.p.a aVar, com.applovin.exoplayer2.h.j jVar, com.applovin.exoplayer2.h.m mVar, IOException iOException, boolean z) {
            if (e(i, aVar)) {
                this.fX.a(jVar, mVar, iOException, z);
            }
        }

        @Override // com.applovin.exoplayer2.h.q
        public void a(int i, com.applovin.exoplayer2.h.p.a aVar, com.applovin.exoplayer2.h.m mVar) {
            if (e(i, aVar)) {
                this.fX.b(mVar);
            }
        }

        @Override // com.applovin.exoplayer2.d.g
        public void a(int i, com.applovin.exoplayer2.h.p.a aVar, int i2) {
            if (e(i, aVar)) {
                this.fY.bF(i2);
            }
        }

        @Override // com.applovin.exoplayer2.d.g
        public void a(int i, com.applovin.exoplayer2.h.p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hG();
            }
        }

        @Override // com.applovin.exoplayer2.d.g
        public void a(int i, com.applovin.exoplayer2.h.p.a aVar, Exception exc) {
            if (e(i, aVar)) {
                this.fY.j(exc);
            }
        }

        @Override // com.applovin.exoplayer2.d.g
        public void b(int i, com.applovin.exoplayer2.h.p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hH();
            }
        }

        @Override // com.applovin.exoplayer2.d.g
        public void c(int i, com.applovin.exoplayer2.h.p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hI();
            }
        }

        @Override // com.applovin.exoplayer2.d.g
        public void d(int i, com.applovin.exoplayer2.h.p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hJ();
            }
        }

        private boolean e(int i, com.applovin.exoplayer2.h.p.a aVar) {
            com.applovin.exoplayer2.h.p.a aVarA;
            if (aVar != null) {
                aVarA = ah.a(this.gd, aVar);
                if (aVarA == null) {
                    return false;
                }
            } else {
                aVarA = null;
            }
            int iA = ah.a(this.gd, i);
            if (this.fX.cN != iA || !com.applovin.exoplayer2.l.ai.r(this.fX.jj, aVarA)) {
                this.fX = ah.this.fX.b(iA, aVarA, 0L);
            }
            if (this.fY.cN == iA && com.applovin.exoplayer2.l.ai.r(this.fY.jj, aVarA)) {
                return true;
            }
            this.fY = ah.this.fY.h(iA, aVarA);
            return true;
        }
    }
}
