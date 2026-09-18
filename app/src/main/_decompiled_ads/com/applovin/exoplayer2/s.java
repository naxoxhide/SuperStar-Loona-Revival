package com.applovin.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.common.base.Supplier;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class s implements Handler.Callback, ah.d, ao.a, com.applovin.exoplayer2.h.n.a, com.applovin.exoplayer2.j.j.a, m.a {
    private final ba.c U;
    private final long aT;
    private final boolean aU;
    private final ar[] bB;
    private final com.applovin.exoplayer2.j.j bC;
    private final e bE;
    private final ba.a bI;
    private final com.applovin.exoplayer2.k.d bO;
    private final com.applovin.exoplayer2.l.d bR;
    private int bS;
    private boolean bT;
    private av bY;
    private final com.applovin.exoplayer2.j.k bz;
    private boolean cA;
    private boolean cB;
    private boolean cC;
    private boolean cD;
    private int cE;
    private g cF;
    private long cG;
    private int cH;
    private boolean cI;
    private p cJ;
    private long cK;
    private al cd;
    private final Set<ar> cj;
    private final as[] ck;
    private final aa cl;
    private final com.applovin.exoplayer2.l.o cm;
    private final HandlerThread cn;
    private final Looper co;
    private final m cp;
    private final ArrayList<c> cq;
    private final af cr;
    private final ah cs;
    private final z ct;
    private final long cu;
    private d cv;
    private boolean cw;
    private boolean cx;
    private boolean cy;
    private boolean cz;

    private static class b {
        public final com.applovin.exoplayer2.h.z C;
        public final int cP;
        public final int cQ;
        public final int cR;
    }

    public interface e {
        void onPlaybackInfoUpdate(d dVar);
    }

    public static final class d {
        private boolean cW;
        public int cX;
        public boolean cY;
        public int cZ;
        public al cd;
        public boolean da;
        public int db;

        public d(al alVar) {
            this.cd = alVar;
        }

        public void x(int i) {
            this.cW |= i > 0;
            this.cX += i;
        }

        public void d(al alVar) {
            this.cW |= this.cd != alVar;
            this.cd = alVar;
        }

        public void y(int i) {
            if (this.cY && this.cZ != 5) {
                com.applovin.exoplayer2.l.a.checkArgument(i == 5);
                return;
            }
            this.cW = true;
            this.cY = true;
            this.cZ = i;
        }

        public void z(int i) {
            this.cW = true;
            this.da = true;
            this.db = i;
        }
    }

    public s(ar[] arVarArr, com.applovin.exoplayer2.j.j jVar, com.applovin.exoplayer2.j.k kVar, aa aaVar, com.applovin.exoplayer2.k.d dVar, int i, boolean z, com.applovin.exoplayer2.a.a aVar, av avVar, z zVar, long j, boolean z2, Looper looper, com.applovin.exoplayer2.l.d dVar2, e eVar) {
        this.bE = eVar;
        this.bB = arVarArr;
        this.bC = jVar;
        this.bz = kVar;
        this.cl = aaVar;
        this.bO = dVar;
        this.bS = i;
        this.bT = z;
        this.bY = avVar;
        this.ct = zVar;
        this.cu = j;
        this.cK = j;
        this.cx = z2;
        this.bR = dVar2;
        this.aT = aaVar.as();
        this.aU = aaVar.at();
        this.cd = al.a(kVar);
        this.cv = new d(this.cd);
        this.ck = new as[arVarArr.length];
        for (int i2 = 0; i2 < arVarArr.length; i2++) {
            arVarArr[i2].p(i2);
            this.ck[i2] = arVarArr[i2].N();
        }
        this.cp = new m(this, dVar2);
        this.cq = new ArrayList<>();
        this.cj = com.applovin.exoplayer2.common.a.aq.gT();
        this.U = new ba.c();
        this.bI = new ba.a();
        jVar.a(this, dVar);
        this.cI = true;
        Handler handler = new Handler(looper);
        this.cr = new af(aVar, handler);
        this.cs = new ah(this, aVar, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.cn = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.co = looper2;
        this.cm = dVar2.a(looper2, this);
    }

    public void j(long j) {
        this.cK = j;
    }

    public void aD() {
        this.cm.fr(0).oY();
    }

    public void b(boolean z, int i) {
        this.cm.j(1, z ? 1 : 0, i).oY();
    }

    public void u(int i) {
        this.cm.j(11, i, 0).oY();
    }

    public void l(boolean z) {
        this.cm.j(12, z ? 1 : 0, 0).oY();
    }

    public void b(ba baVar, int i, long j) {
        this.cm.c(3, new g(baVar, i, j)).oY();
    }

    public void W() {
        this.cm.fr(6).oY();
    }

    public void a(List<ah.c> list, int i, long j, com.applovin.exoplayer2.h.z zVar) {
        this.cm.c(17, new a(list, zVar, i, j)).oY();
    }

    public void a(int i, int i2, com.applovin.exoplayer2.h.z zVar) {
        this.cm.a(20, i, i2, zVar).oY();
    }

    @Override // com.applovin.exoplayer2.ao.a
    public synchronized void a(ao aoVar) {
        if (!this.cw && this.cn.isAlive()) {
            this.cm.c(14, aoVar).oY();
            return;
        }
        com.applovin.exoplayer2.l.q.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        aoVar.B(false);
    }

    public synchronized boolean bg() {
        if (!this.cw && this.cn.isAlive()) {
            this.cm.fs(7);
            a(new Supplier() { // from class: com.applovin.exoplayer2.-$$Lambda$s$pRoViGLPNOQvJiuf5sLvfjvIY-A
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return this.f$0.bO();
                }
            }, this.cu);
            return this.cw;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean bO() {
        return Boolean.valueOf(this.cw);
    }

    public Looper bh() {
        return this.co;
    }

    @Override // com.applovin.exoplayer2.ah.d
    public void bi() {
        this.cm.fs(22);
    }

    @Override // com.applovin.exoplayer2.h.n.a
    public void a(com.applovin.exoplayer2.h.n nVar) {
        this.cm.c(8, nVar).oY();
    }

    @Override // com.applovin.exoplayer2.h.y.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.applovin.exoplayer2.h.n nVar) {
        this.cm.c(9, nVar).oY();
    }

    @Override // com.applovin.exoplayer2.m.a
    public void b(am amVar) {
        this.cm.c(16, amVar).oY();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        ad adVarCs;
        int i;
        int i2 = 1000;
        try {
            switch (message.what) {
                case 0:
                    bk();
                    break;
                case 1:
                    a(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    br();
                    break;
                case 3:
                    a((g) message.obj);
                    break;
                case 4:
                    c((am) message.obj);
                    break;
                case 5:
                    a((av) message.obj);
                    break;
                case 6:
                    b(false, true);
                    break;
                case 7:
                    bt();
                    return true;
                case 8:
                    c((com.applovin.exoplayer2.h.n) message.obj);
                    break;
                case 9:
                    d((com.applovin.exoplayer2.h.n) message.obj);
                    break;
                case 10:
                    bu();
                    break;
                case 11:
                    w(message.arg1);
                    break;
                case 12:
                    p(message.arg1 != 0);
                    break;
                case 13:
                    a(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    b((ao) message.obj);
                    break;
                case 15:
                    d((ao) message.obj);
                    break;
                case 16:
                    a((am) message.obj, false);
                    break;
                case 17:
                    a((a) message.obj);
                    break;
                case 18:
                    a((a) message.obj, message.arg1);
                    break;
                case 19:
                    a((b) message.obj);
                    break;
                case 20:
                    b(message.arg1, message.arg2, (com.applovin.exoplayer2.h.z) message.obj);
                    break;
                case 21:
                    a((com.applovin.exoplayer2.h.z) message.obj);
                    break;
                case 22:
                    bl();
                    break;
                case 23:
                    n(message.arg1 != 0);
                    break;
                case 24:
                    o(message.arg1 == 1);
                    break;
                case 25:
                    bo();
                    break;
                default:
                    return false;
            }
        } catch (ai e2) {
            if (e2.gn == 1) {
                i = e2.gm ? 3001 : AuthApiStatusCodes.AUTH_API_SERVER_ERROR;
            } else {
                if (e2.gn == 4) {
                    i = e2.gm ? AuthApiStatusCodes.AUTH_API_CLIENT_ERROR : AuthApiStatusCodes.AUTH_TOKEN_ERROR;
                }
                b(e2, i2);
            }
            i2 = i;
            b(e2, i2);
        } catch (com.applovin.exoplayer2.d.f.a e3) {
            b(e3, e3.errorCode);
        } catch (com.applovin.exoplayer2.h.b e4) {
            b(e4, 1002);
        } catch (com.applovin.exoplayer2.k.j e5) {
            b(e5, e5.tA);
        } catch (p e6) {
            e = e6;
            if (e.bs == 1 && (adVarCs = this.cr.cs()) != null) {
                e = e.a(adVarCs.fx.fE);
            }
            if (e.by && this.cJ == null) {
                com.applovin.exoplayer2.l.q.b("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.cJ = e;
                com.applovin.exoplayer2.l.o oVar = this.cm;
                oVar.a(oVar.c(25, e));
            } else {
                p pVar = this.cJ;
                if (pVar != null) {
                    pVar.addSuppressed(e);
                    e = this.cJ;
                }
                com.applovin.exoplayer2.l.q.c("ExoPlayerImplInternal", "Playback error", e);
                b(true, false);
                this.cd = this.cd.a(e);
            }
        } catch (IOException e7) {
            b(e7, 2000);
        } catch (RuntimeException e8) {
            p pVarA = p.a(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? PointerIconCompat.TYPE_WAIT : 1000);
            com.applovin.exoplayer2.l.q.c("ExoPlayerImplInternal", "Playback error", pVarA);
            b(true, false);
            this.cd = this.cd.a(pVarA);
        }
        bj();
        return true;
    }

    private void b(IOException iOException, int i) {
        p pVarA = p.a(iOException, i);
        ad adVarCr = this.cr.cr();
        if (adVarCr != null) {
            pVarA = pVarA.a(adVarCr.fx.fE);
        }
        com.applovin.exoplayer2.l.q.c("ExoPlayerImplInternal", "Playback error", pVarA);
        b(false, false);
        this.cd = this.cd.a(pVarA);
    }

    private synchronized void a(Supplier<Boolean> supplier, long j) {
        long jOK = this.bR.oK() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                this.bR.oM();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jOK - this.bR.oK();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void v(int i) {
        if (this.cd.gs != i) {
            this.cd = this.cd.W(i);
        }
    }

    private void bj() {
        this.cv.d(this.cd);
        if (this.cv.cW) {
            this.bE.onPlaybackInfoUpdate(this.cv);
            this.cv = new d(this.cd);
        }
    }

    private void bk() {
        this.cv.x(1);
        a(false, false, false, true);
        this.cl.ap();
        v(this.cd.ci.isEmpty() ? 4 : 2);
        this.cs.a(this.bO.od());
        this.cm.fs(2);
    }

    private void a(a aVar) throws Throwable {
        this.cv.x(1);
        if (aVar.cN != -1) {
            this.cF = new g(new ap(aVar.cM, aVar.C), aVar.cN, aVar.cO);
        }
        a(this.cs.a(aVar.cM, aVar.C), false);
    }

    private void a(a aVar, int i) throws Throwable {
        this.cv.x(1);
        ah ahVar = this.cs;
        if (i == -1) {
            i = ahVar.cx();
        }
        a(ahVar.a(i, aVar.cM, aVar.C), false);
    }

    private void a(b bVar) throws Throwable {
        this.cv.x(1);
        a(this.cs.a(bVar.cP, bVar.cQ, bVar.cR, bVar.C), false);
    }

    private void b(int i, int i2, com.applovin.exoplayer2.h.z zVar) throws Throwable {
        this.cv.x(1);
        a(this.cs.c(i, i2, zVar), false);
    }

    private void bl() throws Throwable {
        a(this.cs.cy(), true);
    }

    private void a(com.applovin.exoplayer2.h.z zVar) throws Throwable {
        this.cv.x(1);
        a(this.cs.b(zVar), false);
    }

    private void m(boolean z) {
        for (ad adVarCr = this.cr.cr(); adVarCr != null; adVarCr = adVarCr.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : adVarCr.ck().VE) {
                if (dVar != null) {
                    dVar.am(z);
                }
            }
        }
    }

    private void a(boolean z, int i, boolean z2, int i2) throws p {
        this.cv.x(z2 ? 1 : 0);
        this.cv.z(i2);
        this.cd = this.cd.c(z, i);
        this.cz = false;
        m(z);
        if (!bN()) {
            bn();
            bp();
        } else if (this.cd.gs == 3) {
            bm();
            this.cm.fs(2);
        } else if (this.cd.gs == 2) {
            this.cm.fs(2);
        }
    }

    private void n(boolean z) throws p {
        this.cx = z;
        bE();
        if (!this.cy || this.cr.cs() == this.cr.cr()) {
            return;
        }
        q(true);
        s(false);
    }

    private void o(boolean z) {
        if (z == this.cD) {
            return;
        }
        this.cD = z;
        int i = this.cd.gs;
        if (z || i == 4 || i == 1) {
            this.cd = this.cd.u(z);
        } else {
            this.cm.fs(2);
        }
    }

    private void w(int i) throws p {
        this.bS = i;
        if (!this.cr.a(this.cd.ci, i)) {
            q(true);
        }
        s(false);
    }

    private void p(boolean z) throws p {
        this.bT = z;
        if (!this.cr.b(this.cd.ci, z)) {
            q(true);
        }
        s(false);
    }

    private void q(boolean z) throws p {
        com.applovin.exoplayer2.h.p.a aVar = this.cr.cr().fx.fE;
        long jA = a(aVar, this.cd.cO, true, false);
        if (jA != this.cd.cO) {
            this.cd = a(aVar, jA, this.cd.de, this.cd.gr, z, 5);
        }
    }

    private void bm() throws p {
        this.cz = false;
        this.cp.start();
        for (ar arVar : this.bB) {
            if (e(arVar)) {
                arVar.start();
            }
        }
    }

    private void bn() throws p {
        this.cp.W();
        for (ar arVar : this.bB) {
            if (e(arVar)) {
                c(arVar);
            }
        }
    }

    private void bo() throws p {
        q(true);
    }

    private void bp() throws p {
        ad adVarCr = this.cr.cr();
        if (adVarCr == null) {
            return;
        }
        long jKN = adVarCr.fv ? adVarCr.ft.kN() : -9223372036854775807L;
        if (jKN != -9223372036854775807L) {
            l(jKN);
            if (jKN != this.cd.cO) {
                this.cd = a(this.cd.dc, jKN, this.cd.de, jKN, true, 5);
            }
        } else {
            long jF = this.cp.f(adVarCr != this.cr.cs());
            this.cG = jF;
            long jR = adVarCr.r(jF);
            e(this.cd.cO, jR);
            this.cd.cO = jR;
        }
        this.cd.gA = this.cr.cq().cg();
        this.cd.gB = bM();
        if (this.cd.gw && this.cd.gs == 3 && a(this.cd.ci, this.cd.dc) && this.cd.gy.gD == 1.0f) {
            float fA = this.ct.a(bs(), bM());
            if (this.cp.av().gD != fA) {
                this.cp.a(this.cd.gy.f(fA));
                a(this.cd.gy, this.cp.av().gD, false, false);
            }
        }
    }

    private void bq() {
        for (ad adVarCr = this.cr.cr(); adVarCr != null; adVarCr = adVarCr.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : adVarCr.ck().VE) {
                if (dVar != null) {
                    dVar.no();
                }
            }
        }
    }

    private void br() throws IOException, p {
        boolean z;
        boolean z2;
        boolean z3;
        long jOL = this.bR.oL();
        by();
        if (this.cd.gs == 1 || this.cd.gs == 4) {
            this.cm.ft(2);
            return;
        }
        ad adVarCr = this.cr.cr();
        if (adVarCr == null) {
            c(jOL, 10L);
            return;
        }
        com.applovin.exoplayer2.l.ah.bg("doSomeWork");
        bp();
        if (adVarCr.fv) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            adVarCr.ft.d(this.cd.cO - this.aT, this.aU);
            z = true;
            z2 = true;
            int i = 0;
            while (true) {
                ar[] arVarArr = this.bB;
                if (i >= arVarArr.length) {
                    break;
                }
                ar arVar = arVarArr[i];
                if (e(arVar)) {
                    arVar.g(this.cG, jElapsedRealtime);
                    z = z && arVar.cR();
                    boolean z4 = adVarCr.fu[i] != arVar.Q();
                    boolean z5 = z4 || (!z4 && arVar.R()) || arVar.isReady() || arVar.cR();
                    z2 = z2 && z5;
                    if (!z5) {
                        arVar.V();
                    }
                }
                i++;
            }
        } else {
            adVarCr.ft.kM();
            z = true;
            z2 = true;
        }
        long j = adVarCr.fx.fH;
        boolean z6 = z && adVarCr.fv && (j == -9223372036854775807L || j <= this.cd.cO);
        if (z6 && this.cy) {
            this.cy = false;
            a(false, this.cd.gx, false, 5);
        }
        if (z6 && adVarCr.fx.fL) {
            v(4);
            bn();
        } else if (this.cd.gs == 2 && r(z2)) {
            v(3);
            this.cJ = null;
            if (bN()) {
                bm();
            }
        } else if (this.cd.gs == 3 && (this.cE != 0 ? !z2 : !bw())) {
            this.cz = bN();
            v(2);
            if (this.cz) {
                bq();
                this.ct.al();
            }
            bn();
        }
        if (this.cd.gs == 2) {
            int i2 = 0;
            while (true) {
                ar[] arVarArr2 = this.bB;
                if (i2 >= arVarArr2.length) {
                    break;
                }
                if (e(arVarArr2[i2]) && this.bB[i2].Q() == adVarCr.fu[i2]) {
                    this.bB[i2].V();
                }
                i2++;
            }
            if (!this.cd.aW && this.cd.gB < 500000 && bJ()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        if (this.cD != this.cd.cD) {
            this.cd = this.cd.u(this.cD);
        }
        if ((bN() && this.cd.gs == 3) || this.cd.gs == 2) {
            z3 = !d(jOL, 10L);
        } else {
            if (this.cE != 0 && this.cd.gs != 4) {
                c(jOL, 1000L);
            } else {
                this.cm.ft(2);
            }
            z3 = false;
        }
        if (this.cd.gz != z3) {
            this.cd = this.cd.v(z3);
        }
        this.cC = false;
        com.applovin.exoplayer2.l.ah.pV();
    }

    private long bs() {
        return a(this.cd.ci, this.cd.dc.gM, this.cd.cO);
    }

    private long a(ba baVar, Object obj, long j) {
        baVar.a(baVar.a(obj, this.bI).cN, this.U);
        if (this.U.iK != -9223372036854775807L && this.U.dn() && this.U.iN) {
            return h.g(this.U.dm() - this.U.iK) - (j + this.bI.df());
        }
        return -9223372036854775807L;
    }

    private boolean a(ba baVar, com.applovin.exoplayer2.h.p.a aVar) {
        if (aVar.la() || baVar.isEmpty()) {
            return false;
        }
        baVar.a(baVar.a(aVar.gM, this.bI).cN, this.U);
        return this.U.dn() && this.U.iN && this.U.iK != -9223372036854775807L;
    }

    private void c(long j, long j2) {
        this.cm.ft(2);
        this.cm.k(2, j + j2);
    }

    private boolean d(long j, long j2) {
        if (this.cD && this.cC) {
            return false;
        }
        c(j, j2);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ac A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:46:0x00fc, B:48:0x0103, B:52:0x0117, B:56:0x0120), top: B:72:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00af  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2 A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:46:0x00fc, B:48:0x0103, B:52:0x0117, B:56:0x0120), top: B:72:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b8 A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:46:0x00fc, B:48:0x0103, B:52:0x0117, B:56:0x0120), top: B:72:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c1 A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:46:0x00fc, B:48:0x0103, B:52:0x0117, B:56:0x0120), top: B:72:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:22:0x00a2, B:24:0x00ac, B:27:0x00b2, B:29:0x00b8, B:30:0x00bb, B:32:0x00c1, B:34:0x00cb, B:36:0x00d3, B:40:0x00db, B:42:0x00e5, B:44:0x00f5, B:46:0x00fc, B:48:0x0103, B:52:0x0117, B:56:0x0120), top: B:72:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:51:0x0116  */
    /* JADX WARN: Code duplicated, block: B:54:0x011d  */
    /* JADX WARN: Code duplicated, block: B:55:0x011f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0129  */
    private void a(g gVar) throws Throwable {
        long jLongValue;
        long j;
        boolean z;
        com.applovin.exoplayer2.h.p.a aVar;
        long jDi;
        long j2;
        long j3;
        long jA;
        boolean z2;
        long jA2;
        boolean z3;
        long j4;
        ad adVarCr;
        this.cv.x(1);
        Pair<Object, Long> pairA = a(this.cd.ci, gVar, true, this.bS, this.bT, this.U, this.bI);
        try {
            if (pairA == null) {
                Pair<com.applovin.exoplayer2.h.p.a, Long> pairA2 = a(this.cd.ci);
                aVar = (com.applovin.exoplayer2.h.p.a) pairA2.first;
                jLongValue = ((Long) pairA2.second).longValue();
                z = !this.cd.ci.isEmpty();
                j = -9223372036854775807L;
            } else {
                Object obj = pairA.first;
                jLongValue = ((Long) pairA.second).longValue();
                long j5 = gVar.di == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                com.applovin.exoplayer2.h.p.a aVarB = this.cr.b(this.cd.ci, obj, jLongValue);
                if (aVarB.la()) {
                    this.cd.ci.a(aVarB.gM, this.bI);
                    jDi = this.bI.am(aVarB.gP) == aVarB.gQ ? this.bI.di() : 0L;
                    j2 = j5;
                    aVar = aVarB;
                    z = true;
                } else {
                    j = j5;
                    z = gVar.di == -9223372036854775807L;
                    aVar = aVarB;
                }
                if (this.cd.ci.isEmpty()) {
                    this.cF = gVar;
                } else {
                    if (pairA == null) {
                        if (this.cd.gs != 1) {
                            v(4);
                        }
                        a(false, true, false, true);
                    } else {
                        if (aVar.equals(this.cd.dc)) {
                            adVarCr = this.cr.cr();
                            if (adVarCr == null && adVarCr.fv && jDi != 0) {
                                jA = adVarCr.ft.a(jDi, this.bY);
                            } else {
                                jA = jDi;
                            }
                            if (h.f(jA) == h.f(this.cd.cO) && (this.cd.gs == 2 || this.cd.gs == 3)) {
                                long j6 = this.cd.cO;
                                this.cd = a(aVar, j6, j2, j6, z, 2);
                                return;
                            }
                        } else {
                            jA = jDi;
                        }
                        if (this.cd.gs == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        jA2 = a(aVar, jA, z2);
                        z3 = (jDi != jA2) | z;
                        try {
                            a(this.cd.ci, aVar, this.cd.ci, this.cd.dc, j2);
                            z = z3;
                            j4 = jA2;
                        } catch (Throwable th) {
                            th = th;
                            z = z3;
                            j3 = jA2;
                            this.cd = a(aVar, j3, j2, j3, z, 2);
                            throw th;
                        }
                    }
                    this.cd = a(aVar, j4, j2, j4, z, 2);
                    return;
                }
                j4 = jDi;
                this.cd = a(aVar, j4, j2, j4, z, 2);
                return;
            }
            if (this.cd.ci.isEmpty()) {
                this.cF = gVar;
            } else {
                if (pairA == null) {
                    if (this.cd.gs != 1) {
                        v(4);
                    }
                    a(false, true, false, true);
                } else {
                    if (aVar.equals(this.cd.dc)) {
                        adVarCr = this.cr.cr();
                        if (adVarCr == null) {
                            jA = jDi;
                        } else {
                            jA = jDi;
                        }
                        if (h.f(jA) == h.f(this.cd.cO)) {
                            long j7 = this.cd.cO;
                            this.cd = a(aVar, j7, j2, j7, z, 2);
                            return;
                        }
                    } else {
                        jA = jDi;
                    }
                    if (this.cd.gs == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    jA2 = a(aVar, jA, z2);
                    z3 = (jDi != jA2) | z;
                    a(this.cd.ci, aVar, this.cd.ci, this.cd.dc, j2);
                    z = z3;
                    j4 = jA2;
                }
                this.cd = a(aVar, j4, j2, j4, z, 2);
                return;
            }
            j4 = jDi;
            this.cd = a(aVar, j4, j2, j4, z, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j3 = jDi;
        }
        jDi = jLongValue;
        j2 = j;
    }

    private long a(com.applovin.exoplayer2.h.p.a aVar, long j, boolean z) throws p {
        return a(aVar, j, this.cr.cr() != this.cr.cs(), z);
    }

    private long a(com.applovin.exoplayer2.h.p.a aVar, long j, boolean z, boolean z2) throws p {
        bn();
        this.cz = false;
        if (z2 || this.cd.gs == 3) {
            v(2);
        }
        ad adVarCr = this.cr.cr();
        ad adVarCi = adVarCr;
        while (adVarCi != null && !aVar.equals(adVarCi.fx.fE)) {
            adVarCi = adVarCi.ci();
        }
        if (z || adVarCr != adVarCi || (adVarCi != null && adVarCi.q(j) < 0)) {
            for (ar arVar : this.bB) {
                d(arVar);
            }
            if (adVarCi != null) {
                while (this.cr.cr() != adVarCi) {
                    this.cr.cu();
                }
                this.cr.b(adVarCi);
                adVarCi.s(0L);
                bL();
            }
        }
        if (adVarCi != null) {
            this.cr.b(adVarCi);
            if (!adVarCi.fv) {
                adVarCi.fx = adVarCi.fx.v(j);
            } else if (adVarCi.fw) {
                long jAQ = adVarCi.ft.aQ(j);
                adVarCi.ft.d(jAQ - this.aT, this.aU);
                j = jAQ;
            }
            l(j);
            bH();
        } else {
            this.cr.clear();
            l(j);
        }
        s(false);
        this.cm.fs(2);
        return j;
    }

    private void l(long j) throws p {
        ad adVarCr = this.cr.cr();
        if (adVarCr != null) {
            j = adVarCr.q(j);
        }
        this.cG = j;
        this.cp.d(j);
        for (ar arVar : this.bB) {
            if (e(arVar)) {
                arVar.d(this.cG);
            }
        }
        bv();
    }

    private void c(am amVar) throws p {
        this.cp.a(amVar);
        a(this.cp.av(), true);
    }

    private void a(av avVar) {
        this.bY = avVar;
    }

    private void a(boolean z, AtomicBoolean atomicBoolean) {
        if (this.cB != z) {
            this.cB = z;
            if (!z) {
                for (ar arVar : this.bB) {
                    if (!e(arVar) && this.cj.remove(arVar)) {
                        arVar.Y();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void b(boolean z, boolean z2) {
        a(z || !this.cB, false, true, false);
        this.cv.x(z2 ? 1 : 0);
        this.cl.ab();
        v(1);
    }

    private void bt() {
        a(true, false, true, false);
        this.cl.aq();
        v(1);
        this.cn.quit();
        synchronized (this) {
            this.cw = true;
            notifyAll();
        }
    }

    private void a(boolean z, boolean z2, boolean z3, boolean z4) {
        long j;
        com.applovin.exoplayer2.h.p.a aVar;
        boolean z5;
        long j2;
        long j3;
        this.cm.ft(2);
        this.cJ = null;
        this.cz = false;
        this.cp.W();
        this.cG = 0L;
        for (ar arVar : this.bB) {
            try {
                d(arVar);
            } catch (p | RuntimeException e2) {
                com.applovin.exoplayer2.l.q.c("ExoPlayerImplInternal", "Disable failed.", e2);
            }
        }
        if (z) {
            for (ar arVar2 : this.bB) {
                if (this.cj.remove(arVar2)) {
                    try {
                        arVar2.Y();
                    } catch (RuntimeException e3) {
                        com.applovin.exoplayer2.l.q.c("ExoPlayerImplInternal", "Reset failed.", e3);
                    }
                }
            }
        }
        this.cE = 0;
        com.applovin.exoplayer2.h.p.a aVar2 = this.cd.dc;
        long j4 = this.cd.cO;
        if (this.cd.dc.la() || a(this.cd, this.bI)) {
            j = this.cd.de;
        } else {
            j = this.cd.cO;
        }
        if (z2) {
            this.cF = null;
            Pair<com.applovin.exoplayer2.h.p.a, Long> pairA = a(this.cd.ci);
            com.applovin.exoplayer2.h.p.a aVar3 = (com.applovin.exoplayer2.h.p.a) pairA.first;
            long jLongValue = ((Long) pairA.second).longValue();
            z5 = !aVar3.equals(this.cd.dc);
            aVar = aVar3;
            j2 = jLongValue;
            j3 = -9223372036854775807L;
        } else {
            aVar = aVar2;
            z5 = false;
            j2 = j4;
            j3 = j;
        }
        this.cr.clear();
        this.cA = false;
        this.cd = new al(this.cd.ci, aVar, j3, j2, this.cd.gs, z4 ? null : this.cd.gt, false, z5 ? com.applovin.exoplayer2.h.ad.NG : this.cd.fB, z5 ? this.bz : this.cd.fC, z5 ? com.applovin.exoplayer2.common.a.s.ga() : this.cd.gu, aVar, this.cd.gw, this.cd.gx, this.cd.gy, j2, 0L, j2, this.cD, false);
        if (z3) {
            this.cs.release();
        }
    }

    private Pair<com.applovin.exoplayer2.h.p.a, Long> a(ba baVar) {
        if (baVar.isEmpty()) {
            return Pair.create(al.cB(), 0L);
        }
        Pair<Object, Long> pairA = baVar.a(this.U, this.bI, baVar.d(this.bT), -9223372036854775807L);
        com.applovin.exoplayer2.h.p.a aVarB = this.cr.b(baVar, pairA.first, 0L);
        long jLongValue = ((Long) pairA.second).longValue();
        if (aVarB.la()) {
            baVar.a(aVarB.gM, this.bI);
            jLongValue = aVarB.gQ == this.bI.am(aVarB.gP) ? this.bI.di() : 0L;
        }
        return Pair.create(aVarB, Long.valueOf(jLongValue));
    }

    private void b(ao aoVar) throws p {
        if (aoVar.cJ() == -9223372036854775807L) {
            c(aoVar);
            return;
        }
        if (this.cd.ci.isEmpty()) {
            this.cq.add(new c(aoVar));
            return;
        }
        c cVar = new c(aoVar);
        if (a(cVar, this.cd.ci, this.cd.ci, this.bS, this.bT, this.U, this.bI)) {
            this.cq.add(cVar);
            Collections.sort(this.cq);
        } else {
            aoVar.B(false);
        }
    }

    private void c(ao aoVar) throws p {
        if (aoVar.cI() == this.co) {
            e(aoVar);
            if (this.cd.gs == 3 || this.cd.gs == 2) {
                this.cm.fs(2);
                return;
            }
            return;
        }
        this.cm.c(15, aoVar).oY();
    }

    private void d(final ao aoVar) {
        Looper looperCI = aoVar.cI();
        if (!looperCI.getThread().isAlive()) {
            com.applovin.exoplayer2.l.q.h("TAG", "Trying to send message on a dead thread.");
            aoVar.B(false);
        } else {
            this.bR.a(looperCI, null).e(new Runnable() { // from class: com.applovin.exoplayer2.-$$Lambda$s$UVu6ogh3PiEYsDvWTB6P-eGQNC8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f(aoVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(ao aoVar) {
        try {
            e(aoVar);
        } catch (p e2) {
            com.applovin.exoplayer2.l.q.c("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void e(ao aoVar) throws p {
        if (aoVar.cN()) {
            return;
        }
        try {
            aoVar.cF().a(aoVar.cG(), aoVar.cH());
        } finally {
            aoVar.B(true);
        }
    }

    private void b(ba baVar, ba baVar2) {
        if (baVar.isEmpty() && baVar2.isEmpty()) {
            return;
        }
        for (int size = this.cq.size() - 1; size >= 0; size--) {
            if (!a(this.cq.get(size), baVar, baVar2, this.bS, this.bT, this.U, this.bI)) {
                this.cq.get(size).cS.B(false);
                this.cq.remove(size);
            }
        }
        Collections.sort(this.cq);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0047, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0078, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(long r7, long r9) throws com.applovin.exoplayer2.p {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.s.e(long, long):void");
    }

    private void c(ar arVar) throws p {
        if (arVar.P() == 2) {
            arVar.W();
        }
    }

    private void d(ar arVar) throws p {
        if (e(arVar)) {
            this.cp.b(arVar);
            c(arVar);
            arVar.X();
            this.cE--;
        }
    }

    private void bu() throws p {
        float f2 = this.cp.av().gD;
        ad adVarCs = this.cr.cs();
        boolean z = true;
        for (ad adVarCr = this.cr.cr(); adVarCr != null && adVarCr.fv; adVarCr = adVarCr.ci()) {
            com.applovin.exoplayer2.j.k kVarB = adVarCr.b(f2, this.cd.ci);
            if (kVarB.b(adVarCr.ck())) {
                if (adVarCr == adVarCs) {
                    z = false;
                }
            } else {
                if (z) {
                    ad adVarCr2 = this.cr.cr();
                    boolean zB = this.cr.b(adVarCr2);
                    boolean[] zArr = new boolean[this.bB.length];
                    long jA = adVarCr2.a(kVarB, this.cd.cO, zB, zArr);
                    boolean z2 = (this.cd.gs == 4 || jA == this.cd.cO) ? false : true;
                    this.cd = a(this.cd.dc, jA, this.cd.de, this.cd.gr, z2, 5);
                    if (z2) {
                        l(jA);
                    }
                    boolean[] zArr2 = new boolean[this.bB.length];
                    int i = 0;
                    while (true) {
                        ar[] arVarArr = this.bB;
                        if (i >= arVarArr.length) {
                            break;
                        }
                        ar arVar = arVarArr[i];
                        zArr2[i] = e(arVar);
                        com.applovin.exoplayer2.h.x xVar = adVarCr2.fu[i];
                        if (zArr2[i]) {
                            if (xVar != arVar.Q()) {
                                d(arVar);
                            } else if (zArr[i]) {
                                arVar.d(this.cG);
                            }
                        }
                        i++;
                    }
                    a(zArr2);
                } else {
                    this.cr.b(adVarCr);
                    if (adVarCr.fv) {
                        adVarCr.a(kVarB, Math.max(adVarCr.fx.fF, adVarCr.r(this.cG)), false);
                    }
                }
                s(true);
                if (this.cd.gs != 4) {
                    bH();
                    bp();
                    this.cm.fs(2);
                    return;
                }
                return;
            }
        }
    }

    private void c(float f2) {
        for (ad adVarCr = this.cr.cr(); adVarCr != null; adVarCr = adVarCr.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : adVarCr.ck().VE) {
                if (dVar != null) {
                    dVar.v(f2);
                }
            }
        }
    }

    private void bv() {
        for (ad adVarCr = this.cr.cr(); adVarCr != null; adVarCr = adVarCr.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : adVarCr.ck().VE) {
                if (dVar != null) {
                    dVar.nn();
                }
            }
        }
    }

    private boolean r(boolean z) {
        if (this.cE == 0) {
            return bw();
        }
        if (!z) {
            return false;
        }
        if (!this.cd.aW) {
            return true;
        }
        long jAm = a(this.cd.ci, this.cr.cr().fx.fE) ? this.ct.am() : -9223372036854775807L;
        ad adVarCq = this.cr.cq();
        return (adVarCq.cf() && adVarCq.fx.fL) || (adVarCq.fx.fE.la() && !adVarCq.fv) || this.cl.a(bM(), this.cp.av().gD, this.cz, jAm);
    }

    private boolean bw() {
        ad adVarCr = this.cr.cr();
        long j = adVarCr.fx.fH;
        return adVarCr.fv && (j == -9223372036854775807L || this.cd.cO < j || !bN());
    }

    private void a(ba baVar, boolean z) throws Throwable {
        int i;
        int i2;
        boolean z2;
        f fVarA = a(baVar, this.cd, this.cF, this.cr, this.bS, this.bT, this.U, this.bI);
        com.applovin.exoplayer2.h.p.a aVar = fVarA.dc;
        long j = fVarA.de;
        boolean z3 = fVarA.df;
        long jA = fVarA.dd;
        boolean z4 = (this.cd.dc.equals(aVar) && jA == this.cd.cO) ? false : true;
        g gVar = null;
        try {
            if (fVarA.dg) {
                if (this.cd.gs != 1) {
                    v(4);
                }
                a(false, false, false, true);
            }
            try {
                if (z4) {
                    i2 = 4;
                    z2 = false;
                    if (!baVar.isEmpty()) {
                        for (ad adVarCr = this.cr.cr(); adVarCr != null; adVarCr = adVarCr.ci()) {
                            if (adVarCr.fx.fE.equals(aVar)) {
                                adVarCr.fx = this.cr.a(baVar, adVarCr.fx);
                                adVarCr.cl();
                            }
                        }
                        jA = a(aVar, jA, z3);
                    }
                } else {
                    try {
                        i2 = 4;
                        z2 = false;
                        if (!this.cr.a(baVar, this.cG, bx())) {
                            q(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        i = 4;
                        g gVar2 = gVar;
                        a(baVar, aVar, this.cd.ci, this.cd.dc, fVarA.dh ? jA : -9223372036854775807L);
                        if (z4 || j != this.cd.de) {
                            Object obj = this.cd.dc.gM;
                            ba baVar2 = this.cd.ci;
                            this.cd = a(aVar, jA, j, this.cd.gr, z4 && z && !baVar2.isEmpty() && !baVar2.a(obj, this.bI).iz, baVar.c(obj) == -1 ? i : 3);
                        }
                        bE();
                        b(baVar, this.cd.ci);
                        this.cd = this.cd.c(baVar);
                        if (!baVar.isEmpty()) {
                            this.cF = gVar2;
                        }
                        s(false);
                        throw th;
                    }
                }
                a(baVar, aVar, this.cd.ci, this.cd.dc, fVarA.dh ? jA : -9223372036854775807L);
                if (z4 || j != this.cd.de) {
                    Object obj2 = this.cd.dc.gM;
                    ba baVar3 = this.cd.ci;
                    this.cd = a(aVar, jA, j, this.cd.gr, (!z4 || !z || baVar3.isEmpty() || baVar3.a(obj2, this.bI).iz) ? z2 : true, baVar.c(obj2) == -1 ? i2 : 3);
                }
                bE();
                b(baVar, this.cd.ci);
                this.cd = this.cd.c(baVar);
                if (!baVar.isEmpty()) {
                    this.cF = null;
                }
                s(z2);
            } catch (Throwable th2) {
                th = th2;
                gVar = null;
            }
        } catch (Throwable th3) {
            th = th3;
            i = 4;
        }
    }

    private void a(ba baVar, com.applovin.exoplayer2.h.p.a aVar, ba baVar2, com.applovin.exoplayer2.h.p.a aVar2, long j) {
        if (baVar.isEmpty() || !a(baVar, aVar)) {
            if (this.cp.av().gD != this.cd.gy.gD) {
                this.cp.a(this.cd.gy);
                return;
            }
            return;
        }
        baVar.a(baVar.a(aVar.gM, this.bI).cN, this.U);
        this.ct.a((ab.e) com.applovin.exoplayer2.l.ai.R(this.U.eb));
        if (j != -9223372036854775807L) {
            this.ct.h(a(baVar, aVar.gM, j));
            return;
        }
        if (com.applovin.exoplayer2.l.ai.r(baVar2.isEmpty() ? null : baVar2.a(baVar2.a(aVar2.gM, this.bI).cN, this.U).ch, this.U.ch)) {
            return;
        }
        this.ct.h(-9223372036854775807L);
    }

    private long bx() {
        ad adVarCs = this.cr.cs();
        if (adVarCs == null) {
            return 0L;
        }
        long jCd = adVarCs.cd();
        if (!adVarCs.fv) {
            return jCd;
        }
        int i = 0;
        while (true) {
            ar[] arVarArr = this.bB;
            if (i >= arVarArr.length) {
                return jCd;
            }
            if (e(arVarArr[i]) && this.bB[i].Q() == adVarCs.fu[i]) {
                long jS = this.bB[i].S();
                if (jS == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jCd = Math.max(jS, jCd);
            }
            i++;
        }
    }

    private void by() throws IOException, p {
        if (this.cd.ci.isEmpty() || !this.cs.cw()) {
            return;
        }
        bz();
        bA();
        bB();
        bD();
    }

    private void bz() throws p {
        ae aeVarA;
        this.cr.t(this.cG);
        if (this.cr.cp() && (aeVarA = this.cr.a(this.cG, this.cd)) != null) {
            ad adVarA = this.cr.a(this.ck, this.bC, this.cl.ar(), this.cs, aeVarA, this.bz);
            adVarA.ft.a(this, aeVarA.fF);
            if (this.cr.cr() == adVarA) {
                l(adVarA.ce());
            }
            s(false);
        }
        if (this.cA) {
            this.cA = bJ();
            bK();
        } else {
            bH();
        }
    }

    private void bA() {
        ad adVarCs = this.cr.cs();
        if (adVarCs == null) {
            return;
        }
        int i = 0;
        if (adVarCs.ci() == null || this.cy) {
            if (!adVarCs.fx.fL && !this.cy) {
                return;
            }
            while (true) {
                ar[] arVarArr = this.bB;
                if (i >= arVarArr.length) {
                    return;
                }
                ar arVar = arVarArr[i];
                com.applovin.exoplayer2.h.x xVar = adVarCs.fu[i];
                if (xVar != null && arVar.Q() == xVar && arVar.R()) {
                    a(arVar, (adVarCs.fx.fH == -9223372036854775807L || adVarCs.fx.fH == Long.MIN_VALUE) ? -9223372036854775807L : adVarCs.cd() + adVarCs.fx.fH);
                }
                i++;
            }
        } else if (bG()) {
            if (adVarCs.ci().fv || this.cG >= adVarCs.ci().ce()) {
                com.applovin.exoplayer2.j.k kVarCk = adVarCs.ck();
                ad adVarCt = this.cr.ct();
                com.applovin.exoplayer2.j.k kVarCk2 = adVarCt.ck();
                if (adVarCt.fv && adVarCt.ft.kN() != -9223372036854775807L) {
                    m(adVarCt.ce());
                    return;
                }
                for (int i2 = 0; i2 < this.bB.length; i2++) {
                    boolean zEW = kVarCk.eW(i2);
                    boolean zEW2 = kVarCk2.eW(i2);
                    if (zEW && !this.bB[i2].U()) {
                        boolean z = this.ck[i2].M() == -2;
                        at atVar = kVarCk.VD[i2];
                        at atVar2 = kVarCk2.VD[i2];
                        if (!zEW2 || !atVar2.equals(atVar) || z) {
                            a(this.bB[i2], adVarCt.ce());
                        }
                    }
                }
            }
        }
    }

    private void bB() throws p {
        ad adVarCs = this.cr.cs();
        if (adVarCs == null || this.cr.cr() == adVarCs || adVarCs.fy || !bC()) {
            return;
        }
        bL();
    }

    private boolean bC() throws p {
        ad adVarCs = this.cr.cs();
        com.applovin.exoplayer2.j.k kVarCk = adVarCs.ck();
        int i = 0;
        boolean z = false;
        while (true) {
            ar[] arVarArr = this.bB;
            if (i >= arVarArr.length) {
                return !z;
            }
            ar arVar = arVarArr[i];
            if (e(arVar)) {
                boolean z2 = arVar.Q() != adVarCs.fu[i];
                if (!kVarCk.eW(i) || z2) {
                    if (!arVar.U()) {
                        arVar.a(a(kVarCk.VE[i]), adVarCs.fu[i], adVarCs.ce(), adVarCs.cd());
                    } else if (arVar.cR()) {
                        d(arVar);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void bD() throws p {
        boolean z = false;
        while (bF()) {
            if (z) {
                bj();
            }
            ad adVarCr = this.cr.cr();
            ad adVarCu = this.cr.cu();
            al alVarA = a(adVarCu.fx.fE, adVarCu.fx.fF, adVarCu.fx.de, adVarCu.fx.fF, true, 0);
            this.cd = alVarA;
            a(alVarA.ci, adVarCu.fx.fE, this.cd.ci, adVarCr.fx.fE, -9223372036854775807L);
            bE();
            bp();
            z = true;
        }
    }

    private void bE() {
        ad adVarCr = this.cr.cr();
        this.cy = adVarCr != null && adVarCr.fx.fK && this.cx;
    }

    private boolean bF() {
        ad adVarCr;
        ad adVarCi;
        return bN() && !this.cy && (adVarCr = this.cr.cr()) != null && (adVarCi = adVarCr.ci()) != null && this.cG >= adVarCi.ce() && adVarCi.fy;
    }

    private boolean bG() {
        ad adVarCs = this.cr.cs();
        if (!adVarCs.fv) {
            return false;
        }
        int i = 0;
        while (true) {
            ar[] arVarArr = this.bB;
            if (i >= arVarArr.length) {
                return true;
            }
            ar arVar = arVarArr[i];
            com.applovin.exoplayer2.h.x xVar = adVarCs.fu[i];
            if (arVar.Q() != xVar || (xVar != null && !arVar.R() && !a(arVar, adVarCs))) {
                return false;
            }
            i++;
        }
    }

    private boolean a(ar arVar, ad adVar) {
        ad adVarCi = adVar.ci();
        return adVar.fx.fI && adVarCi.fv && ((arVar instanceof com.applovin.exoplayer2.i.m) || arVar.S() >= adVarCi.ce());
    }

    private void m(long j) {
        for (ar arVar : this.bB) {
            if (arVar.Q() != null) {
                a(arVar, j);
            }
        }
    }

    private void a(ar arVar, long j) {
        arVar.T();
        if (arVar instanceof com.applovin.exoplayer2.i.m) {
            ((com.applovin.exoplayer2.i.m) arVar).bg(j);
        }
    }

    private void c(com.applovin.exoplayer2.h.n nVar) throws p {
        if (this.cr.e(nVar)) {
            ad adVarCq = this.cr.cq();
            adVarCq.a(this.cp.av().gD, this.cd.ci);
            a(adVarCq.cj(), adVarCq.ck());
            if (adVarCq == this.cr.cr()) {
                l(adVarCq.fx.fF);
                bL();
                this.cd = a(this.cd.dc, adVarCq.fx.fF, this.cd.de, adVarCq.fx.fF, false, 5);
            }
            bH();
        }
    }

    private void d(com.applovin.exoplayer2.h.n nVar) {
        if (this.cr.e(nVar)) {
            this.cr.t(this.cG);
            bH();
        }
    }

    private void a(am amVar, boolean z) throws p {
        a(amVar, amVar.gD, true, z);
    }

    private void a(am amVar, float f2, boolean z, boolean z2) throws p {
        if (z) {
            if (z2) {
                this.cv.x(1);
            }
            this.cd = this.cd.d(amVar);
        }
        c(amVar.gD);
        for (ar arVar : this.bB) {
            if (arVar != null) {
                arVar.a(f2, amVar.gD);
            }
        }
    }

    private void bH() {
        boolean zBI = bI();
        this.cA = zBI;
        if (zBI) {
            this.cr.cq().u(this.cG);
        }
        bK();
    }

    private boolean bI() {
        long jR;
        if (!bJ()) {
            return false;
        }
        ad adVarCq = this.cr.cq();
        long jN = n(adVarCq.ch());
        if (adVarCq == this.cr.cr()) {
            jR = adVarCq.r(this.cG);
        } else {
            jR = adVarCq.r(this.cG) - adVarCq.fx.fF;
        }
        return this.cl.b(jR, jN, this.cp.av().gD);
    }

    private boolean bJ() {
        ad adVarCq = this.cr.cq();
        return (adVarCq == null || adVarCq.ch() == Long.MIN_VALUE) ? false : true;
    }

    private void bK() {
        ad adVarCq = this.cr.cq();
        boolean z = this.cA || (adVarCq != null && adVarCq.ft.kO());
        if (z != this.cd.aW) {
            this.cd = this.cd.t(z);
        }
    }

    private al a(com.applovin.exoplayer2.h.p.a aVar, long j, long j2, long j3, boolean z, int i) {
        com.applovin.exoplayer2.h.ad adVar;
        com.applovin.exoplayer2.j.k kVar;
        List<com.applovin.exoplayer2.g.a> list;
        com.applovin.exoplayer2.h.ad adVarCj;
        com.applovin.exoplayer2.j.k kVarCk;
        this.cI = (!this.cI && j == this.cd.cO && aVar.equals(this.cd.dc)) ? false : true;
        bE();
        com.applovin.exoplayer2.h.ad adVar2 = this.cd.fB;
        com.applovin.exoplayer2.j.k kVar2 = this.cd.fC;
        List<com.applovin.exoplayer2.g.a> listGa = this.cd.gu;
        if (this.cs.cw()) {
            ad adVarCr = this.cr.cr();
            if (adVarCr == null) {
                adVarCj = com.applovin.exoplayer2.h.ad.NG;
            } else {
                adVarCj = adVarCr.cj();
            }
            if (adVarCr == null) {
                kVarCk = this.bz;
            } else {
                kVarCk = adVarCr.ck();
            }
            com.applovin.exoplayer2.common.a.s<com.applovin.exoplayer2.g.a> sVarA = a(kVarCk.VE);
            if (adVarCr != null && adVarCr.fx.de != j2) {
                adVarCr.fx = adVarCr.fx.w(j2);
            }
            adVar = adVarCj;
            kVar = kVarCk;
            list = sVarA;
        } else {
            if (!aVar.equals(this.cd.dc)) {
                adVar2 = com.applovin.exoplayer2.h.ad.NG;
                kVar2 = this.bz;
                listGa = com.applovin.exoplayer2.common.a.s.ga();
            }
            adVar = adVar2;
            kVar = kVar2;
            list = listGa;
        }
        if (z) {
            this.cv.y(i);
        }
        return this.cd.a(aVar, j, j2, j3, bM(), adVar, kVar, list);
    }

    private com.applovin.exoplayer2.common.a.s<com.applovin.exoplayer2.g.a> a(com.applovin.exoplayer2.j.d[] dVarArr) {
        com.applovin.exoplayer2.common.a.s.a aVar = new com.applovin.exoplayer2.common.a.s.a();
        boolean z = false;
        for (com.applovin.exoplayer2.j.d dVar : dVarArr) {
            if (dVar != null) {
                v vVarDZ = dVar.dZ(0);
                if (vVarDZ.dx == null) {
                    aVar.t(new com.applovin.exoplayer2.g.a(new com.applovin.exoplayer2.g.a.InterfaceC0095a[0]));
                } else {
                    aVar.t(vVarDZ.dx);
                    z = true;
                }
            }
        }
        return z ? aVar.gd() : com.applovin.exoplayer2.common.a.s.ga();
    }

    private void bL() throws p {
        a(new boolean[this.bB.length]);
    }

    private void a(boolean[] zArr) throws p {
        ad adVarCs = this.cr.cs();
        com.applovin.exoplayer2.j.k kVarCk = adVarCs.ck();
        for (int i = 0; i < this.bB.length; i++) {
            if (!kVarCk.eW(i) && this.cj.remove(this.bB[i])) {
                this.bB[i].Y();
            }
        }
        for (int i2 = 0; i2 < this.bB.length; i2++) {
            if (kVarCk.eW(i2)) {
                c(i2, zArr[i2]);
            }
        }
        adVarCs.fy = true;
    }

    private void c(int i, boolean z) throws p {
        ar arVar = this.bB[i];
        if (e(arVar)) {
            return;
        }
        ad adVarCs = this.cr.cs();
        boolean z2 = adVarCs == this.cr.cr();
        com.applovin.exoplayer2.j.k kVarCk = adVarCs.ck();
        at atVar = kVarCk.VD[i];
        v[] vVarArrA = a(kVarCk.VE[i]);
        boolean z3 = bN() && this.cd.gs == 3;
        boolean z4 = !z && z3;
        this.cE++;
        this.cj.add(arVar);
        arVar.a(atVar, vVarArrA, adVarCs.fu[i], this.cG, z4, z2, adVarCs.ce(), adVarCs.cd());
        arVar.a(11, new ar.a() { // from class: com.applovin.exoplayer2.s.1
            @Override // com.applovin.exoplayer2.ar.a
            public void o(long j) {
                if (j >= 2000) {
                    s.this.cC = true;
                }
            }

            @Override // com.applovin.exoplayer2.ar.a
            public void bP() {
                s.this.cm.fs(2);
            }
        });
        this.cp.a(arVar);
        if (z3) {
            arVar.start();
        }
    }

    private void s(boolean z) {
        long jCg;
        ad adVarCq = this.cr.cq();
        com.applovin.exoplayer2.h.p.a aVar = adVarCq == null ? this.cd.dc : adVarCq.fx.fE;
        boolean z2 = !this.cd.gv.equals(aVar);
        if (z2) {
            this.cd = this.cd.b(aVar);
        }
        al alVar = this.cd;
        if (adVarCq == null) {
            jCg = alVar.cO;
        } else {
            jCg = adVarCq.cg();
        }
        alVar.gA = jCg;
        this.cd.gB = bM();
        if ((z2 || z) && adVarCq != null && adVarCq.fv) {
            a(adVarCq.cj(), adVarCq.ck());
        }
    }

    private long bM() {
        return n(this.cd.gA);
    }

    private long n(long j) {
        ad adVarCq = this.cr.cq();
        if (adVarCq == null) {
            return 0L;
        }
        return Math.max(0L, j - adVarCq.r(this.cG));
    }

    private void a(com.applovin.exoplayer2.h.ad adVar, com.applovin.exoplayer2.j.k kVar) {
        this.cl.a(this.bB, adVar, kVar.VE);
    }

    private boolean bN() {
        return this.cd.gw && this.cd.gx == 0;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0157  */
    /* JADX WARN: Code duplicated, block: B:51:0x0175  */
    /* JADX WARN: Code duplicated, block: B:60:0x018f  */
    /* JADX WARN: Code duplicated, block: B:69:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:92:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:95:0x01fd  */
    private static f a(ba baVar, al alVar, g gVar, af afVar, int i, boolean z, ba.c cVar, ba.a aVar) {
        long j;
        com.applovin.exoplayer2.h.p.a aVar2;
        int i2;
        com.applovin.exoplayer2.h.p.a aVar3;
        int i3;
        long jLongValue;
        boolean z2;
        boolean z3;
        boolean z4;
        int iD;
        int iD2;
        boolean z5;
        long j2;
        com.applovin.exoplayer2.h.p.a aVarB;
        boolean z6;
        boolean zEquals;
        boolean z7;
        int iD3;
        boolean z8;
        boolean z9;
        boolean z10;
        if (baVar.isEmpty()) {
            return new f(al.cB(), 0L, -9223372036854775807L, false, true, false);
        }
        com.applovin.exoplayer2.h.p.a aVar4 = alVar.dc;
        Object obj = aVar4.gM;
        boolean zA = a(alVar, aVar);
        if (alVar.dc.la() || zA) {
            j = alVar.de;
        } else {
            j = alVar.cO;
        }
        long j3 = j;
        boolean z11 = false;
        if (gVar != null) {
            aVar2 = aVar4;
            i2 = -1;
            Pair<Object, Long> pairA = a(baVar, gVar, true, i, z, cVar, aVar);
            if (pairA == null) {
                iD3 = baVar.d(z);
                jLongValue = j3;
                z8 = false;
                z9 = false;
                z10 = true;
            } else {
                if (gVar.di == -9223372036854775807L) {
                    iD3 = baVar.a(pairA.first, aVar).cN;
                    jLongValue = j3;
                    z8 = false;
                } else {
                    obj = pairA.first;
                    jLongValue = ((Long) pairA.second).longValue();
                    iD3 = -1;
                    z8 = true;
                }
                z9 = alVar.gs == 4;
                z10 = false;
            }
            z4 = z8;
            z2 = z9;
            z3 = z10;
            i3 = iD3;
        } else {
            aVar2 = aVar4;
            i2 = -1;
            if (alVar.ci.isEmpty()) {
                iD = baVar.d(z);
            } else {
                if (baVar.c(obj) == -1) {
                    Object objA = a(cVar, aVar, i, z, obj, alVar.ci, baVar);
                    if (objA == null) {
                        iD2 = baVar.d(z);
                        z5 = true;
                    } else {
                        iD2 = baVar.a(objA, aVar).cN;
                        z5 = false;
                    }
                    i3 = iD2;
                    z3 = z5;
                    jLongValue = j3;
                    z2 = false;
                    z4 = false;
                } else if (j3 == -9223372036854775807L) {
                    iD = baVar.a(obj, aVar).cN;
                } else if (zA) {
                    aVar3 = aVar2;
                    alVar.ci.a(aVar3.gM, aVar);
                    if (alVar.ci.a(aVar.cN, cVar).iQ == alVar.ci.c(aVar3.gM)) {
                        Pair<Object, Long> pairA2 = baVar.a(cVar, aVar, baVar.a(obj, aVar).cN, j3 + aVar.df());
                        obj = pairA2.first;
                        jLongValue = ((Long) pairA2.second).longValue();
                    } else {
                        jLongValue = j3;
                    }
                    i3 = -1;
                    z2 = false;
                    z3 = false;
                    z4 = true;
                } else {
                    aVar3 = aVar2;
                    i3 = -1;
                    jLongValue = j3;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                }
                if (i3 != i2) {
                    Pair<Object, Long> pairA3 = baVar.a(cVar, aVar, i3, -9223372036854775807L);
                    obj = pairA3.first;
                    jLongValue = ((Long) pairA3.second).longValue();
                    j2 = -9223372036854775807L;
                } else {
                    j2 = jLongValue;
                }
                aVarB = afVar.b(baVar, obj, jLongValue);
                if (aVarB.LM != i2 || (aVar3.LM != i2 && aVarB.gP >= aVar3.LM)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zEquals = aVar3.gM.equals(obj);
                if (zEquals || aVar3.la() || aVarB.la() || !z6) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                baVar.a(obj, aVar);
                if (zEquals && !zA && j3 == j2 && ((aVarB.la() && aVar.ap(aVarB.gP)) || (aVar3.la() && aVar.ap(aVar3.gP)))) {
                    z11 = true;
                }
                if (z7 || z11) {
                    aVarB = aVar3;
                }
                if (aVarB.la()) {
                    if (aVarB.equals(aVar3)) {
                        jLongValue = alVar.cO;
                    } else {
                        baVar.a(aVarB.gM, aVar);
                        if (aVarB.gQ == aVar.am(aVarB.gP)) {
                            jLongValue = aVar.di();
                        } else {
                            jLongValue = 0;
                        }
                    }
                }
                return new f(aVarB, jLongValue, j2, z2, z3, z4);
            }
            i3 = iD;
            jLongValue = j3;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        aVar3 = aVar2;
        if (i3 != i2) {
            Pair<Object, Long> pairA4 = baVar.a(cVar, aVar, i3, -9223372036854775807L);
            obj = pairA4.first;
            jLongValue = ((Long) pairA4.second).longValue();
            j2 = -9223372036854775807L;
        } else {
            j2 = jLongValue;
        }
        aVarB = afVar.b(baVar, obj, jLongValue);
        if (aVarB.LM != i2) {
            z6 = true;
        } else {
            z6 = true;
        }
        zEquals = aVar3.gM.equals(obj);
        if (zEquals) {
            z7 = false;
        } else {
            z7 = false;
        }
        baVar.a(obj, aVar);
        if (zEquals) {
            z11 = true;
        }
        if (z7) {
            aVarB = aVar3;
        } else {
            aVarB = aVar3;
        }
        if (aVarB.la()) {
            if (aVarB.equals(aVar3)) {
                jLongValue = alVar.cO;
            } else {
                baVar.a(aVarB.gM, aVar);
                if (aVarB.gQ == aVar.am(aVarB.gP)) {
                    jLongValue = aVar.di();
                } else {
                    jLongValue = 0;
                }
            }
        }
        return new f(aVarB, jLongValue, j2, z2, z3, z4);
    }

    private static boolean a(al alVar, ba.a aVar) {
        com.applovin.exoplayer2.h.p.a aVar2 = alVar.dc;
        ba baVar = alVar.ci;
        return baVar.isEmpty() || baVar.a(aVar2.gM, aVar).iz;
    }

    private static boolean a(c cVar, ba baVar, ba baVar2, int i, boolean z, ba.c cVar2, ba.a aVar) {
        if (cVar.cV == null) {
            Pair<Object, Long> pairA = a(baVar, new g(cVar.cS.bf(), cVar.cS.cK(), cVar.cS.cJ() == Long.MIN_VALUE ? -9223372036854775807L : h.g(cVar.cS.cJ())), false, i, z, cVar2, aVar);
            if (pairA == null) {
                return false;
            }
            cVar.a(baVar.c(pairA.first), ((Long) pairA.second).longValue(), pairA.first);
            if (cVar.cS.cJ() == Long.MIN_VALUE) {
                a(baVar, cVar, cVar2, aVar);
            }
            return true;
        }
        int iC = baVar.c(cVar.cV);
        if (iC == -1) {
            return false;
        }
        if (cVar.cS.cJ() == Long.MIN_VALUE) {
            a(baVar, cVar, cVar2, aVar);
            return true;
        }
        cVar.cT = iC;
        baVar2.a(cVar.cV, aVar);
        if (aVar.iz && baVar2.a(aVar.cN, cVar2).iQ == baVar2.c(cVar.cV)) {
            Pair<Object, Long> pairA2 = baVar.a(cVar2, aVar, baVar.a(cVar.cV, aVar).cN, cVar.cU + aVar.df());
            cVar.a(baVar.c(pairA2.first), ((Long) pairA2.second).longValue(), pairA2.first);
        }
        return true;
    }

    private static void a(ba baVar, c cVar, ba.c cVar2, ba.a aVar) {
        int i = baVar.a(baVar.a(cVar.cV, aVar).cN, cVar2).iR;
        cVar.a(i, aVar.fH != -9223372036854775807L ? aVar.fH - 1 : Long.MAX_VALUE, baVar.a(i, aVar, true).ch);
    }

    private static Pair<Object, Long> a(ba baVar, g gVar, boolean z, int i, boolean z2, ba.c cVar, ba.a aVar) {
        Object objA;
        ba baVar2 = gVar.ci;
        if (baVar.isEmpty()) {
            return null;
        }
        ba baVar3 = baVar2.isEmpty() ? baVar : baVar2;
        try {
            Pair<Object, Long> pairA = baVar3.a(cVar, aVar, gVar.cN, gVar.di);
            if (baVar.equals(baVar3)) {
                return pairA;
            }
            if (baVar.c(pairA.first) != -1) {
                return (baVar3.a(pairA.first, aVar).iz && baVar3.a(aVar.cN, cVar).iQ == baVar3.c(pairA.first)) ? baVar.a(cVar, aVar, baVar.a(pairA.first, aVar).cN, gVar.di) : pairA;
            }
            if (z && (objA = a(cVar, aVar, i, z2, pairA.first, baVar3, baVar)) != null) {
                return baVar.a(cVar, aVar, baVar.a(objA, aVar).cN, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    static Object a(ba.c cVar, ba.a aVar, int i, boolean z, Object obj, ba baVar, ba baVar2) {
        int iC = baVar.c(obj);
        int iCQ = baVar.cQ();
        int iA = iC;
        int iC2 = -1;
        for (int i2 = 0; i2 < iCQ && iC2 == -1; i2++) {
            iA = baVar.a(iA, aVar, cVar, i, z);
            if (iA == -1) {
                break;
            }
            iC2 = baVar2.c(baVar.b(iA));
        }
        if (iC2 == -1) {
            return null;
        }
        return baVar2.b(iC2);
    }

    private static v[] a(com.applovin.exoplayer2.j.d dVar) {
        int iKD = dVar != null ? dVar.kD() : 0;
        v[] vVarArr = new v[iKD];
        for (int i = 0; i < iKD; i++) {
            vVarArr[i] = dVar.dZ(i);
        }
        return vVarArr;
    }

    private static boolean e(ar arVar) {
        return arVar.P() != 0;
    }

    private static final class g {
        public final int cN;
        public final ba ci;
        public final long di;

        public g(ba baVar, int i, long j) {
            this.ci = baVar;
            this.cN = i;
            this.di = j;
        }
    }

    private static final class f {
        public final com.applovin.exoplayer2.h.p.a dc;
        public final long dd;
        public final long de;
        public final boolean df;
        public final boolean dg;
        public final boolean dh;

        public f(com.applovin.exoplayer2.h.p.a aVar, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.dc = aVar;
            this.dd = j;
            this.de = j2;
            this.df = z;
            this.dg = z2;
            this.dh = z3;
        }
    }

    private static final class c implements Comparable<c> {
        public final ao cS;
        public int cT;
        public long cU;
        public Object cV;

        public c(ao aoVar) {
            this.cS = aoVar;
        }

        public void a(int i, long j, Object obj) {
            this.cT = i;
            this.cU = j;
            this.cV = obj;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            Object obj = this.cV;
            if ((obj == null) != (cVar.cV == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.cT - cVar.cT;
            return i != 0 ? i : com.applovin.exoplayer2.l.ai.B(this.cU, cVar.cU);
        }
    }

    private static final class a {
        private final com.applovin.exoplayer2.h.z C;
        private final List<ah.c> cM;
        private final int cN;
        private final long cO;

        private a(List<ah.c> list, com.applovin.exoplayer2.h.z zVar, int i, long j) {
            this.cM = list;
            this.C = zVar;
            this.cN = i;
            this.cO = j;
        }
    }
}
