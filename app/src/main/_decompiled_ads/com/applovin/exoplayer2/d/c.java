package com.applovin.exoplayer2.d;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.applovin.exoplayer2.common.a.aq;
import com.applovin.exoplayer2.common.a.ax;
import com.applovin.exoplayer2.common.a.w;
import com.applovin.exoplayer2.k.v;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class c implements h {
    private Looper co;
    private final boolean eB;
    private final UUID ey;
    private int rm;
    private final m.c sF;
    private final int[] sG;
    private final f sH;
    private final g sI;
    private final long sJ;
    private final List<com.applovin.exoplayer2.d.b> sK;
    private final Set<e> sL;
    private final Set<com.applovin.exoplayer2.d.b> sM;
    private int sN;
    private m sO;
    private com.applovin.exoplayer2.d.b sP;
    private com.applovin.exoplayer2.d.b sQ;
    private Handler sR;
    volatile HandlerC0084c sS;
    private final boolean si;
    private final HashMap<String, String> sk;
    private final v sm;
    private final r sn;
    private byte[] sv;

    public static final class a {
        private boolean eB;
        private boolean si;
        private final HashMap<String, String> sk = new HashMap<>();
        private UUID ey = com.applovin.exoplayer2.h.am;
        private m.c sF = o.tq;
        private v sm = new com.applovin.exoplayer2.k.r();
        private int[] sG = new int[0];
        private long sJ = 300000;

        public a a(UUID uuid, m.c cVar) {
            this.ey = (UUID) com.applovin.exoplayer2.l.a.checkNotNull(uuid);
            this.sF = (m.c) com.applovin.exoplayer2.l.a.checkNotNull(cVar);
            return this;
        }

        public a K(boolean z) {
            this.eB = z;
            return this;
        }

        public a e(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                com.applovin.exoplayer2.l.a.checkArgument(z);
            }
            this.sG = (int[]) iArr.clone();
            return this;
        }

        public a L(boolean z) {
            this.si = z;
            return this;
        }

        public c a(r rVar) {
            return new c(this.ey, this.sF, rVar, this.sk, this.eB, this.sG, this.si, this.sm, this.sJ);
        }
    }

    public static final class d extends Exception {
        private d(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    private c(UUID uuid, m.c cVar, r rVar, HashMap<String, String> map, boolean z, int[] iArr, boolean z2, v vVar, long j) {
        com.applovin.exoplayer2.l.a.checkNotNull(uuid);
        com.applovin.exoplayer2.l.a.checkArgument(!com.applovin.exoplayer2.h.ak.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.ey = uuid;
        this.sF = cVar;
        this.sn = rVar;
        this.sk = map;
        this.eB = z;
        this.sG = iArr;
        this.si = z2;
        this.sm = vVar;
        this.sH = new f();
        this.sI = new g();
        this.rm = 0;
        this.sK = new ArrayList();
        this.sL = aq.gT();
        this.sM = aq.gT();
        this.sJ = j;
    }

    public void a(int i, byte[] bArr) {
        com.applovin.exoplayer2.l.a.checkState(this.sK.isEmpty());
        if (i == 1 || i == 3) {
            com.applovin.exoplayer2.l.a.checkNotNull(bArr);
        }
        this.rm = i;
        this.sv = bArr;
    }

    @Override // com.applovin.exoplayer2.d.h
    public final void aD() {
        int i = this.sN;
        this.sN = i + 1;
        if (i != 0) {
            return;
        }
        if (this.sO == null) {
            m mVarAcquireExoMediaDrm = this.sF.acquireExoMediaDrm(this.ey);
            this.sO = mVarAcquireExoMediaDrm;
            mVarAcquireExoMediaDrm.a(new b());
        } else if (this.sJ != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.sK.size(); i2++) {
                this.sK.get(i2).a((com.applovin.exoplayer2.d.g.a) null);
            }
        }
    }

    @Override // com.applovin.exoplayer2.d.h
    public final void release() {
        int i = this.sN - 1;
        this.sN = i;
        if (i != 0) {
            return;
        }
        if (this.sJ != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.sK);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((com.applovin.exoplayer2.d.b) arrayList.get(i2)).b(null);
            }
        }
        hD();
        hE();
    }

    @Override // com.applovin.exoplayer2.d.h
    public h.a a(Looper looper, com.applovin.exoplayer2.d.g.a aVar, com.applovin.exoplayer2.v vVar) {
        com.applovin.exoplayer2.l.a.checkState(this.sN > 0);
        a(looper);
        e eVar = new e(aVar);
        eVar.h(vVar);
        return eVar;
    }

    @Override // com.applovin.exoplayer2.d.h
    public com.applovin.exoplayer2.d.f b(Looper looper, com.applovin.exoplayer2.d.g.a aVar, com.applovin.exoplayer2.v vVar) {
        com.applovin.exoplayer2.l.a.checkState(this.sN > 0);
        a(looper);
        return a(looper, aVar, vVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public com.applovin.exoplayer2.d.f a(Looper looper, com.applovin.exoplayer2.d.g.a aVar, com.applovin.exoplayer2.v vVar, boolean z) {
        List<com.applovin.exoplayer2.d.e.a> listA;
        b(looper);
        if (vVar.dC == null) {
            return h(com.applovin.exoplayer2.l.u.ba(vVar.dz), z);
        }
        com.applovin.exoplayer2.d.b bVarA = null;
        byte b2 = 0;
        if (this.sv == null) {
            listA = a((com.applovin.exoplayer2.d.e) com.applovin.exoplayer2.l.a.checkNotNull(vVar.dC), this.ey, false);
            if (listA.isEmpty()) {
                d dVar = new d(this.ey);
                com.applovin.exoplayer2.l.q.c("DefaultDrmSessionMgr", "DRM error", dVar);
                if (aVar != null) {
                    aVar.j(dVar);
                }
                return new l(new com.applovin.exoplayer2.d.f.a(dVar, AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE));
            }
        } else {
            listA = null;
        }
        if (!this.eB) {
            bVarA = this.sQ;
        } else {
            for (com.applovin.exoplayer2.d.b bVar : this.sK) {
                if (ai.r(bVar.se, listA)) {
                    bVarA = bVar;
                    break;
                }
            }
        }
        if (bVarA == null) {
            bVarA = a(listA, false, aVar, z);
            if (!this.eB) {
                this.sQ = bVarA;
            }
            this.sK.add(bVarA);
        } else {
            bVarA.a(aVar);
        }
        return bVarA;
    }

    @Override // com.applovin.exoplayer2.d.h
    public int g(com.applovin.exoplayer2.v vVar) {
        int iHN = ((m) com.applovin.exoplayer2.l.a.checkNotNull(this.sO)).hN();
        if (vVar.dC == null) {
            if (ai.c(this.sG, com.applovin.exoplayer2.l.u.ba(vVar.dz)) != -1) {
                return iHN;
            }
            return 0;
        }
        if (b(vVar.dC)) {
            return iHN;
        }
        return 1;
    }

    private com.applovin.exoplayer2.d.f h(int i, boolean z) {
        m mVar = (m) com.applovin.exoplayer2.l.a.checkNotNull(this.sO);
        if ((mVar.hN() == 2 && n.to) || ai.c(this.sG, i) == -1 || mVar.hN() == 1) {
            return null;
        }
        com.applovin.exoplayer2.d.b bVar = this.sP;
        if (bVar == null) {
            com.applovin.exoplayer2.d.b bVarA = a((List<com.applovin.exoplayer2.d.e.a>) com.applovin.exoplayer2.common.a.s.ga(), true, (com.applovin.exoplayer2.d.g.a) null, z);
            this.sK.add(bVarA);
            this.sP = bVarA;
        } else {
            bVar.a((com.applovin.exoplayer2.d.g.a) null);
        }
        return this.sP;
    }

    private boolean b(com.applovin.exoplayer2.d.e eVar) {
        if (this.sv != null) {
            return true;
        }
        if (a(eVar, this.ey, true).isEmpty()) {
            if (eVar.td != 1 || !eVar.bC(0).a(com.applovin.exoplayer2.h.ak)) {
                return false;
            }
            com.applovin.exoplayer2.l.q.h("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.ey);
        }
        String str = eVar.tc;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ("cbcs".equals(str)) {
            return ai.acV >= 25;
        }
        return ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    private synchronized void a(Looper looper) {
        Looper looper2 = this.co;
        if (looper2 == null) {
            this.co = looper;
            this.sR = new Handler(looper);
        } else {
            com.applovin.exoplayer2.l.a.checkState(looper2 == looper);
            com.applovin.exoplayer2.l.a.checkNotNull(this.sR);
        }
    }

    private void b(Looper looper) {
        if (this.sS == null) {
            this.sS = new HandlerC0084c(looper);
        }
    }

    private com.applovin.exoplayer2.d.b a(List<com.applovin.exoplayer2.d.e.a> list, boolean z, com.applovin.exoplayer2.d.g.a aVar, boolean z2) {
        com.applovin.exoplayer2.d.b bVarA = a(list, z, aVar);
        if (a(bVarA) && !this.sM.isEmpty()) {
            hC();
            a(bVarA, aVar);
            bVarA = a(list, z, aVar);
        }
        if (!a(bVarA) || !z2 || this.sL.isEmpty()) {
            return bVarA;
        }
        hD();
        if (!this.sM.isEmpty()) {
            hC();
        }
        a(bVarA, aVar);
        return a(list, z, aVar);
    }

    private static boolean a(com.applovin.exoplayer2.d.f fVar) {
        return fVar.P() == 1 && (ai.acV < 19 || (((com.applovin.exoplayer2.d.f.a) com.applovin.exoplayer2.l.a.checkNotNull(fVar.ht())).getCause() instanceof ResourceBusyException));
    }

    private void a(com.applovin.exoplayer2.d.f fVar, com.applovin.exoplayer2.d.g.a aVar) {
        fVar.b(aVar);
        if (this.sJ != -9223372036854775807L) {
            fVar.b(null);
        }
    }

    private void hC() {
        ax it = w.e(this.sM).iterator();
        while (it.hasNext()) {
            ((com.applovin.exoplayer2.d.f) it.next()).b(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void hD() {
        ax it = w.e(this.sL).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    private com.applovin.exoplayer2.d.b a(List<com.applovin.exoplayer2.d.e.a> list, boolean z, com.applovin.exoplayer2.d.g.a aVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(this.sO);
        com.applovin.exoplayer2.d.b bVar = new com.applovin.exoplayer2.d.b(this.ey, this.sO, this.sH, this.sI, list, this.rm, this.si | z, z, this.sv, this.sk, this.sn, (Looper) com.applovin.exoplayer2.l.a.checkNotNull(this.co), this.sm);
        bVar.a(aVar);
        if (this.sJ != -9223372036854775807L) {
            bVar.a((com.applovin.exoplayer2.d.g.a) null);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE() {
        if (this.sO != null && this.sN == 0 && this.sK.isEmpty() && this.sL.isEmpty()) {
            ((m) com.applovin.exoplayer2.l.a.checkNotNull(this.sO)).release();
            this.sO = null;
        }
    }

    private static List<com.applovin.exoplayer2.d.e.a> a(com.applovin.exoplayer2.d.e eVar, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(eVar.td);
        for (int i = 0; i < eVar.td; i++) {
            com.applovin.exoplayer2.d.e.a aVarBC = eVar.bC(i);
            if ((aVarBC.a(uuid) || (com.applovin.exoplayer2.h.al.equals(uuid) && aVarBC.a(com.applovin.exoplayer2.h.ak))) && (aVarBC.tf != null || z)) {
                arrayList.add(aVarBC);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.d.c$c, reason: collision with other inner class name */
    private class HandlerC0084c extends Handler {
        public HandlerC0084c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (com.applovin.exoplayer2.d.b bVar : c.this.sK) {
                if (bVar.n(bArr)) {
                    bVar.bB(message.what);
                    return;
                }
            }
        }
    }

    private class f implements com.applovin.exoplayer2.d.b.a {
        private final Set<com.applovin.exoplayer2.d.b> sW = new HashSet();
        private com.applovin.exoplayer2.d.b sX;

        public f() {
        }

        @Override // com.applovin.exoplayer2.d.b.a
        public void b(com.applovin.exoplayer2.d.b bVar) {
            this.sW.add(bVar);
            if (this.sX != null) {
                return;
            }
            this.sX = bVar;
            bVar.hq();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.d.b.a
        public void hr() {
            this.sX = null;
            com.applovin.exoplayer2.common.a.s sVarD = com.applovin.exoplayer2.common.a.s.d(this.sW);
            this.sW.clear();
            ax it = sVarD.iterator();
            while (it.hasNext()) {
                ((com.applovin.exoplayer2.d.b) it.next()).hr();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.d.b.a
        public void a(Exception exc, boolean z) {
            this.sX = null;
            com.applovin.exoplayer2.common.a.s sVarD = com.applovin.exoplayer2.common.a.s.d(this.sW);
            this.sW.clear();
            ax it = sVarD.iterator();
            while (it.hasNext()) {
                ((com.applovin.exoplayer2.d.b) it.next()).a(exc, z);
            }
        }

        public void c(com.applovin.exoplayer2.d.b bVar) {
            this.sW.remove(bVar);
            if (this.sX == bVar) {
                this.sX = null;
                if (this.sW.isEmpty()) {
                    return;
                }
                com.applovin.exoplayer2.d.b next = this.sW.iterator().next();
                this.sX = next;
                next.hq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class g implements com.applovin.exoplayer2.d.b.InterfaceC0083b {
        private g() {
        }

        @Override // com.applovin.exoplayer2.d.b.InterfaceC0083b
        public void a(com.applovin.exoplayer2.d.b bVar, int i) {
            if (c.this.sJ != -9223372036854775807L) {
                c.this.sM.remove(bVar);
                ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).removeCallbacksAndMessages(bVar);
            }
        }

        @Override // com.applovin.exoplayer2.d.b.InterfaceC0083b
        public void b(final com.applovin.exoplayer2.d.b bVar, int i) {
            if (i == 1 && c.this.sN > 0 && c.this.sJ != -9223372036854775807L) {
                c.this.sM.add(bVar);
                ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).postAtTime(new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$c$g$iCRUk2vnZn4Tqu_SjjGVpCaVB5M
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.b(null);
                    }
                }, bVar, SystemClock.uptimeMillis() + c.this.sJ);
            } else if (i == 0) {
                c.this.sK.remove(bVar);
                if (c.this.sP == bVar) {
                    c.this.sP = null;
                }
                if (c.this.sQ == bVar) {
                    c.this.sQ = null;
                }
                c.this.sH.c(bVar);
                if (c.this.sJ != -9223372036854775807L) {
                    ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).removeCallbacksAndMessages(bVar);
                    c.this.sM.remove(bVar);
                }
            }
            c.this.hE();
        }
    }

    private class b implements m.b {
        private b() {
        }

        @Override // com.applovin.exoplayer2.d.m.b
        public void a(m mVar, byte[] bArr, int i, int i2, byte[] bArr2) {
            ((HandlerC0084c) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sS)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e implements h.a {
        private final com.applovin.exoplayer2.d.g.a sU;
        private com.applovin.exoplayer2.d.f sV;
        private boolean sy;

        public e(com.applovin.exoplayer2.d.g.a aVar) {
            this.sU = aVar;
        }

        public void h(final com.applovin.exoplayer2.v vVar) {
            ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).post(new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$c$e$4v6_70flOe-F0IeqIgiH2hx5L3U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i(vVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(com.applovin.exoplayer2.v vVar) {
            if (c.this.sN == 0 || this.sy) {
                return;
            }
            c cVar = c.this;
            this.sV = cVar.a((Looper) com.applovin.exoplayer2.l.a.checkNotNull(cVar.co), this.sU, vVar, false);
            c.this.sL.add(this);
        }

        @Override // com.applovin.exoplayer2.d.h.a
        public void release() {
            ai.a((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR), new Runnable() { // from class: com.applovin.exoplayer2.d.-$$Lambda$c$e$3sXXd8BFo-s4L7Cz11jhnn2YnFU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hF();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hF() {
            if (this.sy) {
                return;
            }
            com.applovin.exoplayer2.d.f fVar = this.sV;
            if (fVar != null) {
                fVar.b(this.sU);
            }
            c.this.sL.remove(this);
            this.sy = true;
        }
    }
}
