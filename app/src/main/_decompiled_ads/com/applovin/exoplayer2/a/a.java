package com.applovin.exoplayer2.a;

import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.b.g;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.c.e;
import com.applovin.exoplayer2.c.h;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.a.u;
import com.applovin.exoplayer2.common.a.x;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.j;
import com.applovin.exoplayer2.h.q;
import com.applovin.exoplayer2.k.d;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.m;
import com.applovin.exoplayer2.l.o;
import com.applovin.exoplayer2.l.p;
import com.applovin.exoplayer2.m.n;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements an.d, g, com.applovin.exoplayer2.d.g, q, d.a, n {
    private final ba.c U;
    private p<b> bG;
    private final ba.a bI;
    private final com.applovin.exoplayer2.l.d bR;
    private o cm;
    private final C0072a iZ;
    private final SparseArray<b.a> ja;
    private an jb;
    private boolean jc;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b bVar, m mVar) {
    }

    public a(com.applovin.exoplayer2.l.d dVar) {
        this.bR = (com.applovin.exoplayer2.l.d) com.applovin.exoplayer2.l.a.checkNotNull(dVar);
        this.bG = new p<>(ai.pZ(), dVar, new p.b() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$zJwy5r2WcGQiItEUfwbbg2AfX7I
            @Override // com.applovin.exoplayer2.l.p.b
            public final void invoke(Object obj, m mVar) {
                a.a((b) obj, mVar);
            }
        });
        ba.a aVar = new ba.a();
        this.bI = aVar;
        this.U = new ba.c();
        this.iZ = new C0072a(aVar);
        this.ja = new SparseArray<>();
    }

    public void a(final an anVar, Looper looper) {
        com.applovin.exoplayer2.l.a.checkState(this.jb == null || this.iZ.jd.isEmpty());
        this.jb = (an) com.applovin.exoplayer2.l.a.checkNotNull(anVar);
        this.cm = this.bR.a(looper, null);
        this.bG = this.bG.a(looper, new p.b() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$UmdMPF35Bh9G4lVRmjZ_d-S3SNk
            @Override // com.applovin.exoplayer2.l.p.b
            public final void invoke(Object obj, m mVar) {
                this.f$0.a(anVar, (b) obj, mVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(an anVar, b bVar, m mVar) {
        bVar.a(anVar, new b.C0073b(mVar, this.ja));
    }

    public void release() {
        final b.a aVarDr = dr();
        this.ja.put(1036, aVarDr);
        a(aVarDr, 1036, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$CHoHODo7b_22ronuvuJRPz6HmmM
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).h(aVarDr);
            }
        });
        ((o) com.applovin.exoplayer2.l.a.N(this.cm)).e(new Runnable() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$BHaVOAGMbUKMz07ETQNW0J2kjbI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.dv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dv() {
        this.bG.release();
    }

    public final void a(List<com.applovin.exoplayer2.h.p.a> list, com.applovin.exoplayer2.h.p.a aVar) {
        this.iZ.a(list, aVar, (an) com.applovin.exoplayer2.l.a.checkNotNull(this.jb));
    }

    public final void dq() {
        if (this.jc) {
            return;
        }
        final b.a aVarDr = dr();
        this.jc = true;
        a(aVarDr, -1, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$usqfZ-H0cB9mDleoop75CH_aY1w
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr);
            }
        });
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void c(final e eVar) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_TEXT, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$E3odAXTXsFPvYAM2g9dgLo4Wr0E
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.d(aVarDt, eVar, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(b.a aVar, e eVar, b bVar) {
        bVar.a(aVar, eVar);
        bVar.a(aVar, 1, eVar);
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void b(final String str, final long j, final long j2) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_VERTICAL_TEXT, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$EV16J3T_thJQd_E_yFydZrenRzU
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.b(aVarDt, str, j2, j, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(b.a aVar, String str, long j, long j2, b bVar) {
        bVar.a(aVar, str, j);
        bVar.a(aVar, str, j2, j);
        bVar.a(aVar, 1, str, j);
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void b(final v vVar, final h hVar) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_ALIAS, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$PU0Y9EEgS_m1iTADSC6LtJ1gkto
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.b(aVarDt, vVar, hVar, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(b.a aVar, v vVar, h hVar, b bVar) {
        bVar.a(aVar, vVar);
        bVar.a(aVar, vVar, hVar);
        bVar.a(aVar, 1, vVar);
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void z(final long j) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_COPY, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$6lPc-uxMF9qMSokzlfA1slajb8E
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDt, j);
            }
        });
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void a(final int i, final long j, final long j2) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_NO_DROP, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$MqWWtAqG_IDnxFIsrdrK8CUkMpU
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarDt, i, j, j2);
            }
        });
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void s(final String str) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_ALL_SCROLL, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$0P2oxnUav07O62vDi5yW7I4911I
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDt, str);
            }
        });
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void d(final e eVar) {
        final b.a aVarDs = ds();
        a(aVarDs, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$zeNs1pa9CCAFp2pgbDaQgsPwNsM
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.c(aVarDs, eVar, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(b.a aVar, e eVar, b bVar) {
        bVar.b(aVar, eVar);
        bVar.b(aVar, 1, eVar);
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.b.g
    public final void A(final boolean z) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$KpE4HX7dzMBs-IoPQH-jCWa_vuQ
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).e(aVarDt, z);
            }
        });
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void b(final Exception exc) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_ZOOM_IN, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$HuiGXFX69bRfJui-dODzUtREIeY
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDt, exc);
            }
        });
    }

    @Override // com.applovin.exoplayer2.b.g
    public final void c(final Exception exc) {
        final b.a aVarDt = dt();
        a(aVarDt, 1037, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$BnicUlr9Yi7qfE2SaCVH9oMi5kc
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarDt, exc);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d
    public final void g(final float f) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_ZOOM_OUT, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$XbABpBJvc4sThuNlMo7Y-WI2BGM
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDt, f);
            }
        });
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void a(final e eVar) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_GRAB, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$_4uD87X_lFu9xw88ihjxvVuaWdQ
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.b(aVarDt, eVar, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(b.a aVar, e eVar, b bVar) {
        bVar.c(aVar, eVar);
        bVar.a(aVar, 2, eVar);
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void a(final String str, final long j, final long j2) {
        final b.a aVarDt = dt();
        a(aVarDt, PointerIconCompat.TYPE_GRABBING, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$Q-u5EmMPG0eygi6YcmReqIxKFNI
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.a(aVarDt, str, j2, j, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, String str, long j, long j2, b bVar) {
        bVar.b(aVar, str, j);
        bVar.b(aVar, str, j2, j);
        bVar.a(aVar, 2, str, j);
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void a(final v vVar, final h hVar) {
        final b.a aVarDt = dt();
        a(aVarDt, 1022, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$96nbvf9anVf5FcJB1QketdsTQqg
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.a(aVarDt, vVar, hVar, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, v vVar, h hVar, b bVar) {
        bVar.b(aVar, vVar);
        bVar.b(aVar, vVar, hVar);
        bVar.a(aVar, 2, vVar);
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void b(final int i, final long j) {
        final b.a aVarDs = ds();
        a(aVarDs, 1023, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$emtjcy5IYqzRGd_MIUFFMpm-vuo
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDs, i, j);
            }
        });
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void r(final String str) {
        final b.a aVarDt = dt();
        a(aVarDt, 1024, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$Mym0CS6VD-q-ajb3ycQ2dXKkPEg
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarDt, str);
            }
        });
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void b(final e eVar) {
        final b.a aVarDs = ds();
        a(aVarDs, InputDeviceCompat.SOURCE_GAMEPAD, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$Q-57kPLjZOdwZs_fMr6yLESb_5o
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.a(aVarDs, eVar, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, e eVar, b bVar) {
        bVar.d(aVar, eVar);
        bVar.b(aVar, 2, eVar);
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.m.n
    public final void a(final com.applovin.exoplayer2.m.o oVar) {
        final b.a aVarDt = dt();
        a(aVarDt, 1028, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$G_tqYUDjat_UmVQ6cxMRi68_8_A
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.a(aVarDt, oVar, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, com.applovin.exoplayer2.m.o oVar, b bVar) {
        bVar.a(aVar, oVar);
        bVar.a(aVar, oVar.dE, oVar.height, oVar.afl, oVar.dH);
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void a(final Object obj, final long j) {
        final b.a aVarDt = dt();
        a(aVarDt, 1027, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$Kl941Vm5iqOVj49GsWBfNQbwEVI
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj2) {
                ((b) obj2).a(aVarDt, obj, j);
            }
        });
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void a(final long j, final int i) {
        final b.a aVarDs = ds();
        a(aVarDs, 1026, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$Mee6eQPMz8m7Qtt0gw-OFPY2Zjo
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDs, j, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.m.n
    public final void a(final Exception exc) {
        final b.a aVarDt = dt();
        a(aVarDt, 1038, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$SPo-O6vBe9HHIM3b2K8KCiXIXzo
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).c(aVarDt, exc);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d
    public void f(final int i, final int i2) {
        final b.a aVarDt = dt();
        a(aVarDt, 1029, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$IHmpP30l0YmPK3gAyA5nVycpikA
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDt, i, i2);
            }
        });
    }

    @Override // com.applovin.exoplayer2.h.q
    public final void a(int i, com.applovin.exoplayer2.h.p.a aVar, final j jVar, final com.applovin.exoplayer2.h.m mVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1000, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$Qos4Zqh5hVx7aWBrnUtevjMjPEA
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarF, jVar, mVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.h.q
    public final void b(int i, com.applovin.exoplayer2.h.p.a aVar, final j jVar, final com.applovin.exoplayer2.h.m mVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1001, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$T8ufz3drfaxP-w9EtmST47phyv4
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarF, jVar, mVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.h.q
    public final void c(int i, com.applovin.exoplayer2.h.p.a aVar, final j jVar, final com.applovin.exoplayer2.h.m mVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1002, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$CMkCoX0PrLGjgHk2g7ipR7pU988
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).c(aVarF, jVar, mVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.h.q
    public final void a(int i, com.applovin.exoplayer2.h.p.a aVar, final j jVar, final com.applovin.exoplayer2.h.m mVar, final IOException iOException, final boolean z) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, PointerIconCompat.TYPE_HELP, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$L15cx62wWbQHuYc7bB6p3SnrPDE
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarF, jVar, mVar, iOException, z);
            }
        });
    }

    @Override // com.applovin.exoplayer2.h.q
    public final void a(int i, com.applovin.exoplayer2.h.p.a aVar, final com.applovin.exoplayer2.h.m mVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, PointerIconCompat.TYPE_WAIT, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$yXqaFSZOjHO-RCWtry_EwdwjLBk
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarF, mVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void b(ba baVar, final int i) {
        this.iZ.g((an) com.applovin.exoplayer2.l.a.checkNotNull(this.jb));
        final b.a aVarDr = dr();
        a(aVarDr, 0, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$eG5YRK9xDxgl6JelFrBePCczIqI
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).c(aVarDr, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void a(final ab abVar, final int i) {
        final b.a aVarDr = dr();
        a(aVarDr, 1, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$vxRRUuhCrh6lqIgxJrsKoyrF-XI
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, abVar, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void a(final ad adVar, final com.applovin.exoplayer2.j.h hVar) {
        final b.a aVarDr = dr();
        a(aVarDr, 2, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$V1GiThYU2k4uXqPeF0QTedSEkeE
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, adVar, hVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void w(final boolean z) {
        final b.a aVarDr = dr();
        a(aVarDr, 3, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$kW3ozrhpfzq3ypTqyaF6VZjpgK4
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.c(aVarDr, z, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(b.a aVar, boolean z, b bVar) {
        bVar.d(aVar, z);
        bVar.c(aVar, z);
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public void d(final an.a aVar) {
        final b.a aVarDr = dr();
        a(aVarDr, 13, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$EzR9MphbG4vDK9iKthfIggkgZcg
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, aVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.b
    public final void d(final boolean z, final int i) {
        final b.a aVarDr = dr();
        a(aVarDr, -1, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$0kapzDD6HdDJSDW_CxobtvSlNGc
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, z, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void Z(final int i) {
        final b.a aVarDr = dr();
        a(aVarDr, 4, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$HDOLEPJb9j3um5Z3oN7mgKE5EJI
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void e(final boolean z, final int i) {
        final b.a aVarDr = dr();
        a(aVarDr, 5, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$gxCC0Gd8HP52PXwFp-xkfwJWO64
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarDr, z, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void aa(final int i) {
        final b.a aVarDr = dr();
        a(aVarDr, 6, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$9ZSKcQM2qDU2uOr3tT2H9vUBOow
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarDr, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public void y(final boolean z) {
        final b.a aVarDr = dr();
        a(aVarDr, 7, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$2cbv3XWCiPRLAvwzwClzu7HaNzE
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, z);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void ab(final int i) {
        final b.a aVarDr = dr();
        a(aVarDr, 8, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$kDRFPIX_FDEIPmsIHfcFk2xqXik
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).e(aVarDr, i);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void z(final boolean z) {
        final b.a aVarDr = dr();
        a(aVarDr, 9, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$WezGu5tx16FZR9fJWOT48hP8bWc
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarDr, z);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void a(final ak akVar) {
        final b.a aVarDr;
        if (akVar instanceof com.applovin.exoplayer2.p) {
            com.applovin.exoplayer2.p pVar = (com.applovin.exoplayer2.p) akVar;
            if (pVar.bx != null) {
                aVarDr = c(new com.applovin.exoplayer2.h.p.a(pVar.bx));
            } else {
                aVarDr = null;
            }
        } else {
            aVarDr = null;
        }
        if (aVarDr == null) {
            aVarDr = dr();
        }
        a(aVarDr, 10, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$wlcoD2bCu5hgIu6Syl2tBseAOrw
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, akVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void a(final an.e eVar, final an.e eVar2, final int i) {
        if (i == 1) {
            this.jc = false;
        }
        this.iZ.f((an) com.applovin.exoplayer2.l.a.checkNotNull(this.jb));
        final b.a aVarDr = dr();
        a(aVarDr, 11, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$wfEBJyhtDaSSrdak3fwHyyM6VXY
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.a(aVarDr, i, eVar, eVar2, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, int i, an.e eVar, an.e eVar2, b bVar) {
        bVar.d(aVar, i);
        bVar.a(aVar, eVar, eVar2, i);
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public final void b(final am amVar) {
        final b.a aVarDr = dr();
        a(aVarDr, 12, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$8xu0Pb7d2mKJSrVV-jonJU2tLTU
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, amVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
    public void a(final ac acVar) {
        final b.a aVarDr = dr();
        a(aVarDr, 14, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$fIYk8JMpgT0l6KIRw4qzjd7C9wU
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, acVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.d
    public final void a(final com.applovin.exoplayer2.g.a aVar) {
        final b.a aVarDr = dr();
        a(aVarDr, PointerIconCompat.TYPE_CROSSHAIR, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$vJjhqyO_hN38NiR81pAVXoKy_J4
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDr, aVar);
            }
        });
    }

    @Override // com.applovin.exoplayer2.an.b
    public final void cD() {
        final b.a aVarDr = dr();
        a(aVarDr, -1, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$Q9DgFUWwhqQhkKdvhOcZantVUBI
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).b(aVarDr);
            }
        });
    }

    @Override // com.applovin.exoplayer2.k.d.a
    public final void b(final int i, final long j, final long j2) {
        final b.a aVarDu = du();
        a(aVarDu, PointerIconCompat.TYPE_CELL, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$qyrOo0A51crlEOC8rw0DdNGC4Mc
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).a(aVarDu, i, j, j2);
            }
        });
    }

    @Override // com.applovin.exoplayer2.d.g
    public final void a(int i, com.applovin.exoplayer2.h.p.a aVar, final int i2) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1030, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$mWRxNpFFYCUOfpTI0c8RYpgHF1U
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                a.a(aVarF, i2, (b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, int i, b bVar) {
        bVar.c(aVar);
        bVar.f(aVar, i);
    }

    @Override // com.applovin.exoplayer2.d.g
    public final void a(int i, com.applovin.exoplayer2.h.p.a aVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1031, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$9G3LHq0uif9mXM1I8O1P8uj8dkw
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).d(aVarF);
            }
        });
    }

    @Override // com.applovin.exoplayer2.d.g
    public final void a(int i, com.applovin.exoplayer2.h.p.a aVar, final Exception exc) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1032, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$eb25rHEyhz5HJDbsKHwTn2n__0c
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).d(aVarF, exc);
            }
        });
    }

    @Override // com.applovin.exoplayer2.d.g
    public final void b(int i, com.applovin.exoplayer2.h.p.a aVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1033, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$1EfLurJkMAsI33y3CxpRiN0DenE
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).e(aVarF);
            }
        });
    }

    @Override // com.applovin.exoplayer2.d.g
    public final void c(int i, com.applovin.exoplayer2.h.p.a aVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1034, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$CBJMvl1uaywRm0ckoCt6HfvNZCM
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).f(aVarF);
            }
        });
    }

    @Override // com.applovin.exoplayer2.d.g
    public final void d(int i, com.applovin.exoplayer2.h.p.a aVar) {
        final b.a aVarF = f(i, aVar);
        a(aVarF, 1035, new p.a() { // from class: com.applovin.exoplayer2.a.-$$Lambda$a$XV5kcqZ8tU4GDZrtPzi6GN2lVEs
            @Override // com.applovin.exoplayer2.l.p.a
            public final void invoke(Object obj) {
                ((b) obj).g(aVarF);
            }
        });
    }

    protected final void a(b.a aVar, int i, p.a<b> aVar2) {
        this.ja.put(i, aVar);
        this.bG.b(i, aVar2);
    }

    protected final b.a dr() {
        return c(this.iZ.dw());
    }

    protected final b.a a(ba baVar, int i, com.applovin.exoplayer2.h.p.a aVar) {
        long jAS;
        com.applovin.exoplayer2.h.p.a aVar2 = baVar.isEmpty() ? null : aVar;
        long jOK = this.bR.oK();
        boolean z = baVar.equals(this.jb.aX()) && i == this.jb.aL();
        long jDj = 0;
        if (aVar2 != null && aVar2.la()) {
            if (z && this.jb.aQ() == aVar2.gP && this.jb.aR() == aVar2.gQ) {
                jDj = this.jb.aN();
            }
        } else {
            if (z) {
                jAS = this.jb.aS();
            } else if (!baVar.isEmpty()) {
                jDj = baVar.a(i, this.U).dj();
            }
            return new b.a(jOK, baVar, i, aVar2, jAS, this.jb.aX(), this.jb.aL(), this.iZ.dw(), this.jb.aN(), this.jb.aO());
        }
        jAS = jDj;
        return new b.a(jOK, baVar, i, aVar2, jAS, this.jb.aX(), this.jb.aL(), this.iZ.dw(), this.jb.aN(), this.jb.aO());
    }

    private b.a c(com.applovin.exoplayer2.h.p.a aVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(this.jb);
        ba baVarD = aVar == null ? null : this.iZ.d(aVar);
        if (aVar == null || baVarD == null) {
            int iAL = this.jb.aL();
            ba baVarAX = this.jb.aX();
            if (!(iAL < baVarAX.cP())) {
                baVarAX = ba.iw;
            }
            return a(baVarAX, iAL, (com.applovin.exoplayer2.h.p.a) null);
        }
        return a(baVarD, baVarD.a(aVar.gM, this.bI).cN, aVar);
    }

    private b.a ds() {
        return c(this.iZ.dx());
    }

    private b.a dt() {
        return c(this.iZ.dy());
    }

    private b.a du() {
        return c(this.iZ.dz());
    }

    private b.a f(int i, com.applovin.exoplayer2.h.p.a aVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(this.jb);
        if (aVar != null) {
            if (this.iZ.d(aVar) != null) {
                return c(aVar);
            }
            return a(ba.iw, i, aVar);
        }
        ba baVarAX = this.jb.aX();
        if (!(i < baVarAX.cP())) {
            baVarAX = ba.iw;
        }
        return a(baVarAX, i, (com.applovin.exoplayer2.h.p.a) null);
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.a.a$a, reason: collision with other inner class name */
    private static final class C0072a {
        private final ba.a bI;
        private s<com.applovin.exoplayer2.h.p.a> jd = s.ga();
        private u<com.applovin.exoplayer2.h.p.a, ba> je = u.gi();
        private com.applovin.exoplayer2.h.p.a jf;
        private com.applovin.exoplayer2.h.p.a jg;
        private com.applovin.exoplayer2.h.p.a jh;

        public C0072a(ba.a aVar) {
            this.bI = aVar;
        }

        public com.applovin.exoplayer2.h.p.a dw() {
            return this.jf;
        }

        public com.applovin.exoplayer2.h.p.a dx() {
            return this.jg;
        }

        public com.applovin.exoplayer2.h.p.a dy() {
            return this.jh;
        }

        public com.applovin.exoplayer2.h.p.a dz() {
            if (this.jd.isEmpty()) {
                return null;
            }
            return (com.applovin.exoplayer2.h.p.a) x.f((Iterable) this.jd);
        }

        public ba d(com.applovin.exoplayer2.h.p.a aVar) {
            return this.je.get(aVar);
        }

        public void f(an anVar) {
            this.jf = a(anVar, this.jd, this.jg, this.bI);
        }

        public void g(an anVar) {
            this.jf = a(anVar, this.jd, this.jg, this.bI);
            d(anVar.aX());
        }

        public void a(List<com.applovin.exoplayer2.h.p.a> list, com.applovin.exoplayer2.h.p.a aVar, an anVar) {
            this.jd = s.d(list);
            if (!list.isEmpty()) {
                this.jg = list.get(0);
                this.jh = (com.applovin.exoplayer2.h.p.a) com.applovin.exoplayer2.l.a.checkNotNull(aVar);
            }
            if (this.jf == null) {
                this.jf = a(anVar, this.jd, this.jg, this.bI);
            }
            d(anVar.aX());
        }

        private void d(ba baVar) {
            u.a<com.applovin.exoplayer2.h.p.a, ba> aVarGj = u.gj();
            if (this.jd.isEmpty()) {
                a(aVarGj, this.jg, baVar);
                if (!Objects.equal(this.jh, this.jg)) {
                    a(aVarGj, this.jh, baVar);
                }
                if (!Objects.equal(this.jf, this.jg) && !Objects.equal(this.jf, this.jh)) {
                    a(aVarGj, this.jf, baVar);
                }
            } else {
                for (int i = 0; i < this.jd.size(); i++) {
                    a(aVarGj, this.jd.get(i), baVar);
                }
                if (!this.jd.contains(this.jf)) {
                    a(aVarGj, this.jf, baVar);
                }
            }
            this.je = aVarGj.gq();
        }

        private void a(u.a<com.applovin.exoplayer2.h.p.a, ba> aVar, com.applovin.exoplayer2.h.p.a aVar2, ba baVar) {
            if (aVar2 == null) {
                return;
            }
            if (baVar.c(aVar2.gM) != -1) {
                aVar.l(aVar2, baVar);
                return;
            }
            ba baVar2 = this.je.get(aVar2);
            if (baVar2 != null) {
                aVar.l(aVar2, baVar2);
            }
        }

        private static com.applovin.exoplayer2.h.p.a a(an anVar, s<com.applovin.exoplayer2.h.p.a> sVar, com.applovin.exoplayer2.h.p.a aVar, ba.a aVar2) {
            ba baVarAX = anVar.aX();
            int iAK = anVar.aK();
            Object objB = baVarAX.isEmpty() ? null : baVarAX.b(iAK);
            int iB = (anVar.aP() || baVarAX.isEmpty()) ? -1 : baVarAX.a(iAK, aVar2).B(com.applovin.exoplayer2.h.g(anVar.aN()) - aVar2.df());
            for (int i = 0; i < sVar.size(); i++) {
                com.applovin.exoplayer2.h.p.a aVar3 = sVar.get(i);
                if (a(aVar3, objB, anVar.aP(), anVar.aQ(), anVar.aR(), iB)) {
                    return aVar3;
                }
            }
            if (sVar.isEmpty() && aVar != null) {
                if (a(aVar, objB, anVar.aP(), anVar.aQ(), anVar.aR(), iB)) {
                    return aVar;
                }
            }
            return null;
        }

        private static boolean a(com.applovin.exoplayer2.h.p.a aVar, Object obj, boolean z, int i, int i2, int i3) {
            if (aVar.gM.equals(obj)) {
                return (z && aVar.gP == i && aVar.gQ == i2) || (!z && aVar.gP == -1 && aVar.LM == i3);
            }
            return false;
        }
    }
}
