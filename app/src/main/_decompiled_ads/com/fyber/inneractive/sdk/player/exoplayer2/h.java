package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.q;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Handler.Callback, com.fyber.inneractive.sdk.player.exoplayer2.source.m.a, com.fyber.inneractive.sdk.player.exoplayer2.source.n.a {
    public c A;
    public long B;
    public a C;
    public a D;
    public a E;
    public p F;
    public final n[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.a[] f1151b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.c d;
    public final q e;
    public final Handler f;
    public final HandlerThread g;
    public final Handler h;
    public final e i;
    public final p.c j;
    public final p.b k;
    public b l;
    public m m;
    public n n;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g o;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.n p;
    public n[] q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v = 1;
    public int w;
    public int x;
    public long y;
    public int z;

    public static final class a {
        public final com.fyber.inneractive.sdk.player.exoplayer2.source.m a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1152b;
        public final com.fyber.inneractive.sdk.player.exoplayer2.source.o[] c;
        public final boolean[] d;
        public final long e;
        public int f;
        public long g;
        public boolean h;
        public boolean i;
        public boolean j;
        public a k;
        public boolean l;
        public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h m;
        public final n[] n;
        public final com.fyber.inneractive.sdk.player.exoplayer2.a[] o;
        public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g p;
        public final com.fyber.inneractive.sdk.player.exoplayer2.c q;
        public final com.fyber.inneractive.sdk.player.exoplayer2.source.n r;
        public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h s;

        public a(n[] nVarArr, com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr, long j, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.c cVar, com.fyber.inneractive.sdk.player.exoplayer2.source.n nVar, Object obj, int i, boolean z, long j2) {
            this.n = nVarArr;
            this.o = aVarArr;
            this.e = j;
            this.p = gVar;
            this.q = cVar;
            this.r = nVar;
            this.f1152b = com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(obj);
            this.f = i;
            this.h = z;
            this.g = j2;
            this.c = new com.fyber.inneractive.sdk.player.exoplayer2.source.o[nVarArr.length];
            this.d = new boolean[nVarArr.length];
            this.a = nVar.a(i, cVar.a(), j2);
        }

        public long a(long j) {
            return Math.abs(j - a());
        }

        public boolean b() {
            return this.i && (!this.j || this.a.d() == Long.MIN_VALUE);
        }

        public void c() {
            try {
                this.r.a(this.a);
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        public boolean d() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
            boolean z;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVarA = this.p.a(this.o, this.a.b());
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVar = this.s;
            hVarA.getClass();
            if (hVar != null) {
                int i = 0;
                while (true) {
                    if (i >= hVarA.f1199b.a) {
                        z = true;
                        break;
                    }
                    if (!hVarA.a(hVar, i)) {
                        z = false;
                        break;
                    }
                    i++;
                }
            } else {
                z = false;
                break;
            }
            if (z) {
                return false;
            }
            this.m = hVarA;
            return true;
        }

        public long a() {
            return this.e - this.g;
        }

        public long a(long j, boolean z, boolean[] zArr) {
            int i;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f fVar = this.m.f1199b;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= fVar.a) {
                    break;
                }
                boolean[] zArr2 = this.d;
                if (z || !this.m.a(this.s, i2)) {
                    z2 = false;
                }
                zArr2[i2] = z2;
                i2++;
            }
            long jA = this.a.a((com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[]) fVar.f1198b.clone(), this.d, this.c, zArr, j);
            this.s = this.m;
            this.j = false;
            int i3 = 0;
            while (true) {
                com.fyber.inneractive.sdk.player.exoplayer2.source.o[] oVarArr = this.c;
                if (i3 >= oVarArr.length) {
                    break;
                }
                if (oVarArr[i3] != null) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(fVar.f1198b[i3] != null);
                    this.j = true;
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(fVar.f1198b[i3] == null);
                }
                i3++;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.c cVar = this.q;
            n[] nVarArr = this.n;
            s sVar = this.m.a;
            cVar.f = 0;
            for (int i4 = 0; i4 < nVarArr.length; i4++) {
                if (fVar.f1198b[i4] != null) {
                    int i5 = cVar.f;
                    int iK = nVarArr[i4].k();
                    int i6 = u.a;
                    if (iK == 0) {
                        i = 16777216;
                    } else if (iK == 1) {
                        i = 3538944;
                    } else if (iK == 2) {
                        i = 13107200;
                    } else {
                        if (iK != 3 && iK != 4) {
                            throw new IllegalStateException();
                        }
                        i = 131072;
                    }
                    cVar.f = i5 + i;
                }
            }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = cVar.a;
            int i7 = cVar.f;
            synchronized (kVar) {
                boolean z3 = i7 < kVar.e;
                kVar.e = i7;
                if (z3) {
                    kVar.b();
                }
            }
            return jA;
        }
    }

    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1153b;
        public volatile long c;
        public volatile long d;

        public b(int i, long j) {
            this.a = i;
            this.f1153b = j;
            this.c = j;
            this.d = j;
        }
    }

    public static final class c {
        public final p a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1154b;
        public final long c;

        public c(p pVar, int i, long j) {
            this.a = pVar;
            this.f1154b = i;
            this.c = j;
        }
    }

    public static final class d {
        public final p a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1155b;
        public final b c;
        public final int d;

        public d(p pVar, Object obj, b bVar, int i) {
            this.a = pVar;
            this.f1155b = obj;
            this.c = bVar;
            this.d = i;
        }
    }

    public h(n[] nVarArr, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.c cVar, boolean z, Handler handler, b bVar, e eVar) {
        this.a = nVarArr;
        this.c = gVar;
        this.d = cVar;
        this.s = z;
        this.h = handler;
        this.l = bVar;
        this.i = eVar;
        this.f1151b = new com.fyber.inneractive.sdk.player.exoplayer2.a[nVarArr.length];
        for (int i = 0; i < nVarArr.length; i++) {
            nVarArr[i].a(i);
            this.f1151b[i] = nVarArr[i].m();
        }
        this.e = new q();
        this.q = new n[0];
        this.j = new p.c();
        this.k = new p.b();
        this.m = m.d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.source.p pVar) {
        this.f.obtainMessage(9, (com.fyber.inneractive.sdk.player.exoplayer2.source.m) pVar).sendToTarget();
    }

    public final void b(c cVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (this.F == null) {
            this.z++;
            this.A = cVar;
            return;
        }
        Pair<Integer, Long> pairA = a(cVar);
        if (pairA == null) {
            b bVar = new b(0, 0L);
            this.l = bVar;
            this.h.obtainMessage(4, 1, 0, bVar).sendToTarget();
            this.l = new b(0, -9223372036854775807L);
            a(4);
            b(false);
            return;
        }
        int i = cVar.c == -9223372036854775807L ? 1 : 0;
        int iIntValue = ((Integer) pairA.first).intValue();
        long jLongValue = ((Long) pairA.second).longValue();
        try {
            b bVar2 = this.l;
            if (iIntValue == bVar2.a && jLongValue / 1000 == bVar2.c / 1000) {
                b bVar3 = new b(iIntValue, jLongValue);
                this.l = bVar3;
                this.h.obtainMessage(4, i, 0, bVar3).sendToTarget();
            } else {
                long jB = b(iIntValue, jLongValue);
                int i2 = i | (jLongValue == jB ? 0 : 1);
                b bVar4 = new b(iIntValue, jB);
                this.l = bVar4;
                this.h.obtainMessage(4, i2, 0, bVar4).sendToTarget();
            }
        } catch (Throwable th) {
            b bVar5 = new b(iIntValue, jLongValue);
            this.l = bVar5;
            this.h.obtainMessage(4, i, 0, bVar5).sendToTarget();
            throw th;
        }
    }

    public final void c(boolean z) {
        if (this.u != z) {
            this.u = z;
            this.h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void d(boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.t = false;
        this.s = z;
        if (!z) {
            h();
            i();
            b(false);
            return;
        }
        int i = this.v;
        if (i == 3) {
            f();
            this.f.sendEmptyMessage(2);
        } else if (i == 2) {
            this.f.sendEmptyMessage(2);
        }
    }

    public final void e() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        a aVar = this.E;
        if (aVar == null) {
            return;
        }
        boolean z = true;
        while (aVar != null && aVar.i) {
            if (aVar.d()) {
                if (z) {
                    a aVar2 = this.D;
                    a aVar3 = this.E;
                    boolean z2 = aVar2 != aVar3;
                    a(aVar3.k);
                    a aVar4 = this.E;
                    aVar4.k = null;
                    this.C = aVar4;
                    this.D = aVar4;
                    boolean[] zArr = new boolean[this.a.length];
                    long jA = aVar4.a(this.l.c, z2, zArr);
                    if (jA != this.l.c) {
                        this.l.c = jA;
                        b(jA);
                    }
                    boolean[] zArr2 = new boolean[this.a.length];
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        n[] nVarArr = this.a;
                        if (i >= nVarArr.length) {
                            break;
                        }
                        n nVar = nVarArr[i];
                        zArr2[i] = nVar.a() != 0;
                        com.fyber.inneractive.sdk.player.exoplayer2.source.o oVar = this.E.c[i];
                        if (oVar != null) {
                            i2++;
                        }
                        if (zArr2[i]) {
                            if (oVar != nVar.n()) {
                                if (nVar == this.n) {
                                    if (oVar == null) {
                                        this.e.a(this.o);
                                    }
                                    this.o = null;
                                    this.n = null;
                                }
                                a(nVar);
                                nVar.l();
                            } else if (zArr[i]) {
                                nVar.a(this.B);
                            }
                        }
                        i++;
                    }
                    this.h.obtainMessage(3, aVar.m).sendToTarget();
                    a(zArr2, i2);
                } else {
                    this.C = aVar;
                    for (a aVar5 = aVar.k; aVar5 != null; aVar5 = aVar5.k) {
                        aVar5.c();
                    }
                    a aVar6 = this.C;
                    aVar6.k = null;
                    if (aVar6.i) {
                        long jMax = Math.max(aVar6.g, aVar6.a(this.B));
                        a aVar7 = this.C;
                        aVar7.a(jMax, false, new boolean[aVar7.n.length]);
                    }
                }
                b();
                i();
                this.f.sendEmptyMessage(2);
                return;
            }
            if (aVar == this.D) {
                z = false;
            }
            aVar = aVar.k;
        }
    }

    public final void f() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.t = false;
        q qVar = this.e;
        if (!qVar.a) {
            qVar.c = SystemClock.elapsedRealtime();
            qVar.a = true;
        }
        for (n nVar : this.q) {
            nVar.f();
        }
    }

    public final void g() {
        b(true);
        this.d.a(true);
        a(1);
    }

    public final void h() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        q qVar = this.e;
        if (qVar.a) {
            qVar.a(qVar.o());
            qVar.a = false;
        }
        for (n nVar : this.q) {
            a(nVar);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.n) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    d(message.arg1 != 0);
                    return true;
                case 2:
                    a();
                    return true;
                case 3:
                    b((c) message.obj);
                    return true;
                case 4:
                    a((m) message.obj);
                    return true;
                case 5:
                    g();
                    return true;
                case 6:
                    d();
                    return true;
                case 7:
                    a((Pair<p, Object>) message.obj);
                    return true;
                case 8:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.m) message.obj);
                    return true;
                case 9:
                    com.fyber.inneractive.sdk.player.exoplayer2.source.m mVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.m) message.obj;
                    a aVar = this.C;
                    if (aVar != null && aVar.a == mVar) {
                        b();
                    }
                    return true;
                case 10:
                    e();
                    return true;
                case 11:
                    a((e.c[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (com.fyber.inneractive.sdk.player.exoplayer2.d e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.h.obtainMessage(8, e).sendToTarget();
            g();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.h.obtainMessage(8, new com.fyber.inneractive.sdk.player.exoplayer2.d(0, null, e2, -1)).sendToTarget();
            g();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.h.obtainMessage(8, new com.fyber.inneractive.sdk.player.exoplayer2.d(2, null, e3, -1)).sendToTarget();
            g();
            return true;
        }
    }

    public final void i() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        a aVar = this.E;
        if (aVar == null) {
            return;
        }
        long jF = aVar.a.f();
        if (jF != -9223372036854775807L) {
            b(jF);
        } else {
            n nVar = this.n;
            if (nVar == null || nVar.b()) {
                this.B = this.e.o();
            } else {
                long jO = this.o.o();
                this.B = jO;
                this.e.a(jO);
            }
            jF = this.E.a(this.B);
        }
        this.l.c = jF;
        this.y = SystemClock.elapsedRealtime() * 1000;
        long jD = this.q.length == 0 ? Long.MIN_VALUE : this.E.a.d();
        b bVar = this.l;
        if (jD == Long.MIN_VALUE) {
            jD = this.F.a(this.E.f, this.k, false).d;
        }
        bVar.d = jD;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.n.a
    public void a(p pVar, Object obj) {
        this.f.obtainMessage(7, Pair.create(pVar, obj)).sendToTarget();
    }

    public final void a(int i) {
        if (this.v != i) {
            this.v = i;
            this.h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    public final void c() throws IOException {
        a aVar = this.C;
        if (aVar == null || aVar.i) {
            return;
        }
        a aVar2 = this.D;
        if (aVar2 == null || aVar2.k == aVar) {
            for (n nVar : this.q) {
                if (!nVar.g()) {
                    return;
                }
            }
            this.C.a.e();
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.n nVar, boolean z) {
        this.h.sendEmptyMessage(0);
        b(true);
        this.d.a(false);
        if (z) {
            this.l = new b(0, -9223372036854775807L);
        }
        this.p = nVar;
        nVar.a(this.i, true, (com.fyber.inneractive.sdk.player.exoplayer2.source.n.a) this);
        a(2);
        this.f.sendEmptyMessage(2);
    }

    public final void d() {
        b(true);
        this.d.a(true);
        a(1);
        synchronized (this) {
            this.r = true;
            notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:105:0x0206 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0208  */
    /* JADX WARN: Code duplicated, block: B:107:0x020c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0212  */
    /* JADX WARN: Code duplicated, block: B:117:0x0248  */
    /* JADX WARN: Code duplicated, block: B:206:0x0253 A[EDGE_INSN: B:206:0x0253->B:119:0x0253 BREAK  A[LOOP:3: B:71:0x0196->B:80:0x01b4], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0253 A[EDGE_INSN: B:216:0x0253->B:119:0x0253 BREAK  A[LOOP:4: B:82:0x01b8->B:90:0x01d5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x024b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x024b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0151  */
    /* JADX WARN: Code duplicated, block: B:63:0x015a A[LOOP:2: B:63:0x015a->B:67:0x016a, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:70:0x0195  */
    /* JADX WARN: Code duplicated, block: B:73:0x019b  */
    /* JADX WARN: Code duplicated, block: B:81:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:84:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:97:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:98:0x01f4  */
    public final void a() throws com.fyber.inneractive.sdk.player.exoplayer2.d, IOException {
        a aVar;
        int i;
        a aVar2;
        a aVar3;
        a aVar4;
        int i2;
        n[] nVarArr;
        a aVar5;
        a aVar6;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVar;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVar2;
        boolean z;
        int i3;
        n[] nVarArr2;
        n nVar;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar;
        n nVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.source.o oVar;
        int i4;
        n[] nVarArr3;
        com.fyber.inneractive.sdk.player.exoplayer2.source.o oVar2;
        boolean zA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.F == null) {
            this.p.a();
        } else {
            a aVar7 = this.C;
            if (aVar7 == null) {
                i = this.l.a;
            } else {
                int i5 = aVar7.f;
                if (!aVar7.h && aVar7.b() && this.F.a(i5, this.k, false).d != -9223372036854775807L && ((aVar = this.E) == null || i5 - aVar.f != 100)) {
                    i = this.C.f + 1;
                } else {
                    aVar2 = this.C;
                    if (aVar2 == null && !aVar2.b()) {
                        a aVar8 = this.C;
                        if (aVar8 != null && aVar8.l) {
                            b();
                        }
                    } else {
                        c(false);
                    }
                    if (this.E != null) {
                        while (true) {
                            aVar3 = this.E;
                            aVar4 = this.D;
                            if (aVar3 == aVar4 || this.B < aVar3.k.e) {
                                break;
                            }
                            aVar3.c();
                            b(this.E.k);
                            a aVar9 = this.E;
                            this.l = new b(aVar9.f, aVar9.g);
                            i();
                            this.h.obtainMessage(5, this.l).sendToTarget();
                        }
                        if (!aVar4.h) {
                            i2 = 0;
                            while (true) {
                                nVarArr = this.a;
                                if (i2 < nVarArr.length) {
                                    nVar2 = nVarArr[i2];
                                    oVar = this.D.c[i2];
                                    if (nVar2.n() != oVar || (oVar != null && !nVar2.g())) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                } else {
                                    aVar5 = this.D;
                                    aVar6 = aVar5.k;
                                    if (aVar6 != null || !aVar6.i) {
                                        break;
                                        break;
                                    }
                                    hVar = aVar5.m;
                                    this.D = aVar6;
                                    hVar2 = aVar6.m;
                                    if (aVar6.a.f() != -9223372036854775807L) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    i3 = 0;
                                    while (true) {
                                        nVarArr2 = this.a;
                                        if (i3 < nVarArr2.length) {
                                            break;
                                        }
                                        nVar = nVarArr2[i3];
                                        if (hVar.f1199b.f1198b[i3] != null) {
                                            if (z) {
                                                nVar.c();
                                            } else if (!nVar.h()) {
                                                eVar = hVar2.f1199b.f1198b[i3];
                                                o oVar3 = hVar.d[i3];
                                                o oVar4 = hVar2.d[i3];
                                                if (eVar == null && oVar4.equals(oVar3)) {
                                                    int iF = eVar.f();
                                                    i[] iVarArr = new i[iF];
                                                    for (int i6 = 0; i6 < iF; i6++) {
                                                        iVarArr[i6] = eVar.a(i6);
                                                    }
                                                    a aVar10 = this.D;
                                                    nVar.a(iVarArr, aVar10.c[i3], aVar10.a());
                                                } else {
                                                    nVar.c();
                                                }
                                            }
                                        }
                                        i3++;
                                    }
                                }
                            }
                        } else {
                            i4 = 0;
                            while (true) {
                                nVarArr3 = this.a;
                                if (i4 < nVarArr3.length) {
                                    break;
                                }
                                n nVar3 = nVarArr3[i4];
                                oVar2 = this.D.c[i4];
                                if (oVar2 == null && nVar3.n() == oVar2 && nVar3.g()) {
                                    nVar3.c();
                                }
                                i4++;
                            }
                        }
                    }
                }
            }
            if (i >= this.F.a()) {
                this.p.a();
            } else {
                long jLongValue = 0;
                if (this.C == null) {
                    jLongValue = this.l.c;
                } else {
                    int i7 = this.F.a(i, this.k, false).c;
                    if (i == this.F.a(i7, this.j).c) {
                        Pair<Integer, Long> pairA = a(this.F, i7, -9223372036854775807L, Math.max(0L, (this.C.a() + this.F.a(this.C.f, this.k, false).d) - this.B));
                        if (pairA != null) {
                            int iIntValue = ((Integer) pairA.first).intValue();
                            jLongValue = ((Long) pairA.second).longValue();
                            i = iIntValue;
                        }
                    }
                }
                long j = jLongValue;
                a aVar11 = this.C;
                long jA = aVar11 == null ? j + 60000000 : aVar11.a() + this.F.a(this.C.f, this.k, false).d;
                this.F.a(i, this.k, true);
                a aVar12 = new a(this.a, this.f1151b, jA, this.c, this.d, this.p, this.k.f1174b, i, i == this.F.a() - 1 && !this.F.a(this.k.c, this.j).f1175b, j);
                a aVar13 = this.C;
                if (aVar13 != null) {
                    aVar13.k = aVar12;
                }
                this.C = aVar12;
                aVar12.a.a(this);
                c(true);
            }
            aVar2 = this.C;
            if (aVar2 == null) {
                c(false);
            } else {
                c(false);
            }
            if (this.E != null) {
                while (true) {
                    aVar3 = this.E;
                    aVar4 = this.D;
                    if (aVar3 == aVar4) {
                        break;
                    }
                    break;
                    break;
                    aVar3.c();
                    b(this.E.k);
                    a aVar14 = this.E;
                    this.l = new b(aVar14.f, aVar14.g);
                    i();
                    this.h.obtainMessage(5, this.l).sendToTarget();
                }
                if (!aVar4.h) {
                    i4 = 0;
                    while (true) {
                        nVarArr3 = this.a;
                        if (i4 < nVarArr3.length) {
                            break;
                            break;
                        }
                        n nVar4 = nVarArr3[i4];
                        oVar2 = this.D.c[i4];
                        if (oVar2 == null) {
                        }
                        i4++;
                    }
                } else {
                    i2 = 0;
                    while (true) {
                        nVarArr = this.a;
                        if (i2 < nVarArr.length) {
                            nVar2 = nVarArr[i2];
                            oVar = this.D.c[i2];
                            if (nVar2.n() != oVar) {
                                break;
                            }
                            break;
                            break;
                        }
                        aVar5 = this.D;
                        aVar6 = aVar5.k;
                        if (aVar6 != null) {
                            break;
                        }
                        hVar = aVar5.m;
                        this.D = aVar6;
                        hVar2 = aVar6.m;
                        if (aVar6.a.f() != -9223372036854775807L) {
                            z = true;
                        } else {
                            z = false;
                        }
                        i3 = 0;
                        while (true) {
                            nVarArr2 = this.a;
                            if (i3 < nVarArr2.length) {
                                break;
                                break;
                            }
                            nVar = nVarArr2[i3];
                            if (hVar.f1199b.f1198b[i3] != null) {
                                if (z) {
                                    nVar.c();
                                } else if (!nVar.h()) {
                                    eVar = hVar2.f1199b.f1198b[i3];
                                    o oVar5 = hVar.d[i3];
                                    o oVar6 = hVar2.d[i3];
                                    if (eVar == null) {
                                        nVar.c();
                                    } else {
                                        nVar.c();
                                    }
                                }
                            }
                            i3++;
                        }
                        i2++;
                    }
                }
            }
        }
        if (this.E == null) {
            c();
            a(jElapsedRealtime, 10L);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.s.a("doSomeWork");
        i();
        this.E.a.c(this.l.c);
        boolean zA2 = true;
        boolean z2 = true;
        for (n nVar5 : this.q) {
            nVar5.a(this.B, this.y);
            z2 = z2 && nVar5.b();
            boolean z3 = nVar5.isReady() || nVar5.b();
            if (!z3) {
                nVar5.e();
            }
            zA2 = zA2 && z3;
        }
        if (!zA2) {
            c();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar = this.o;
        if (gVar != null) {
            m mVarI = gVar.i();
            if (!mVarI.equals(this.m)) {
                this.m = mVarI;
                this.e.a(this.o);
                this.h.obtainMessage(7, mVarI).sendToTarget();
            }
        }
        long j2 = this.F.a(this.E.f, this.k, false).d;
        if (z2 && ((j2 == -9223372036854775807L || j2 <= this.l.c) && this.E.h)) {
            a(4);
            h();
        } else {
            int i8 = this.v;
            if (i8 == 2) {
                if (this.q.length > 0) {
                    zA = zA2 && a(this.t);
                } else {
                    zA = a(j2);
                }
                if (zA) {
                    a(3);
                    if (this.s) {
                        f();
                    }
                }
            } else if (i8 == 3) {
                if (this.q.length <= 0) {
                    zA2 = a(j2);
                }
                if (!zA2) {
                    this.t = this.s;
                    a(2);
                    h();
                }
            }
        }
        if (this.v == 2) {
            for (n nVar6 : this.q) {
                nVar6.e();
            }
        }
        if ((this.s && this.v == 3) || this.v == 2) {
            a(jElapsedRealtime, 10L);
        } else if (this.q.length != 0) {
            a(jElapsedRealtime, 1000L);
        } else {
            this.f.removeMessages(2);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.s.a();
    }

    public final long b(int i, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        a aVar;
        h();
        this.t = false;
        a(2);
        a aVar2 = this.E;
        if (aVar2 == null) {
            a aVar3 = this.C;
            if (aVar3 != null) {
                aVar3.c();
            }
            aVar = null;
        } else {
            aVar = null;
            while (aVar2 != null) {
                if (aVar2.f == i && aVar2.i) {
                    aVar = aVar2;
                } else {
                    aVar2.c();
                }
                aVar2 = aVar2.k;
            }
        }
        a aVar4 = this.E;
        if (aVar4 != aVar || aVar4 != this.D) {
            for (n nVar : this.q) {
                nVar.l();
            }
            this.q = new n[0];
            this.o = null;
            this.n = null;
            this.E = null;
        }
        if (aVar != null) {
            aVar.k = null;
            this.C = aVar;
            this.D = aVar;
            b(aVar);
            a aVar5 = this.E;
            if (aVar5.j) {
                j = aVar5.a.b(j);
            }
            b(j);
            b();
        } else {
            this.C = null;
            this.D = null;
            this.E = null;
            b(j);
        }
        this.f.sendEmptyMessage(2);
        return j;
    }

    public final void b(long j) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        a aVar = this.E;
        long jA = j + (aVar == null ? 60000000L : aVar.a());
        this.B = jA;
        this.e.a(jA);
        for (n nVar : this.q) {
            nVar.a(this.B);
        }
    }

    public final void b(boolean z) {
        this.f.removeMessages(2);
        this.t = false;
        q qVar = this.e;
        if (qVar.a) {
            qVar.a(qVar.o());
            qVar.a = false;
        }
        this.o = null;
        this.n = null;
        this.B = 60000000L;
        for (n nVar : this.q) {
            try {
                a(nVar);
                nVar.l();
            } catch (com.fyber.inneractive.sdk.player.exoplayer2.d | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.q = new n[0];
        a aVar = this.E;
        if (aVar == null) {
            aVar = this.C;
        }
        a(aVar);
        this.C = null;
        this.D = null;
        this.E = null;
        c(false);
        if (z) {
            com.fyber.inneractive.sdk.player.exoplayer2.source.n nVar2 = this.p;
            if (nVar2 != null) {
                nVar2.b();
                this.p = null;
            }
            this.F = null;
        }
    }

    public final void b(Object obj, int i) {
        this.h.obtainMessage(6, new d(this.F, obj, this.l, i)).sendToTarget();
    }

    public final void b() {
        a aVar = this.C;
        long jA = !aVar.i ? 0L : aVar.a.a();
        if (jA == Long.MIN_VALUE) {
            c(false);
            return;
        }
        long jA2 = this.C.a(this.B);
        boolean zA = this.d.a(jA - jA2);
        c(zA);
        if (zA) {
            a aVar2 = this.C;
            aVar2.l = false;
            aVar2.a.a(jA2);
            return;
        }
        this.C.l = true;
    }

    public final void b(a aVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (this.E == aVar) {
            return;
        }
        boolean[] zArr = new boolean[this.a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            n[] nVarArr = this.a;
            if (i < nVarArr.length) {
                n nVar = nVarArr[i];
                zArr[i] = nVar.a() != 0;
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = aVar.m.f1199b.f1198b[i];
                if (eVar != null) {
                    i2++;
                }
                if (zArr[i] && (eVar == null || (nVar.h() && nVar.n() == this.E.c[i]))) {
                    if (nVar == this.n) {
                        this.e.a(this.o);
                        this.o = null;
                        this.n = null;
                    }
                    a(nVar);
                    nVar.l();
                }
                i++;
            } else {
                this.E = aVar;
                this.h.obtainMessage(3, aVar.m).sendToTarget();
                a(zArr, i2);
                return;
            }
        }
    }

    public final void a(long j, long j2) {
        this.f.removeMessages(2);
        long jElapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= 0) {
            this.f.sendEmptyMessage(2);
        } else {
            this.f.sendEmptyMessageDelayed(2, jElapsedRealtime);
        }
    }

    public final void a(m mVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar = this.o;
        if (gVar != null) {
            mVar = gVar.a(mVar);
        } else {
            q qVar = this.e;
            if (qVar.a) {
                qVar.a(qVar.o());
            }
            qVar.d = mVar;
        }
        this.m = mVar;
        this.h.obtainMessage(7, mVar).sendToTarget();
    }

    public final void a(e.c[] cVarArr) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        try {
            for (e.c cVar : cVarArr) {
                cVar.a.a(cVar.f1055b, cVar.c);
            }
            if (this.p != null) {
                this.f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.x++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.x++;
                notifyAll();
                throw th;
            }
        }
    }

    public final void a(n nVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (nVar.a() == 2) {
            nVar.d();
        }
    }

    public final boolean a(long j) {
        a aVar;
        return j == -9223372036854775807L || this.l.c < j || ((aVar = this.E.k) != null && aVar.i);
    }

    public final boolean a(boolean z) {
        long jD;
        a aVar = this.C;
        if (!aVar.i) {
            jD = aVar.g;
        } else {
            jD = aVar.a.d();
        }
        if (jD == Long.MIN_VALUE) {
            a aVar2 = this.C;
            if (aVar2.h) {
                return true;
            }
            jD = this.F.a(aVar2.f, this.k, false).d;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.c cVar = this.d;
        long jA = jD - this.C.a(this.B);
        long j = z ? cVar.e : cVar.d;
        return j <= 0 || jA >= j;
    }

    public final void a(Pair<p, Object> pair) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int i;
        p pVar = this.F;
        p pVar2 = (p) pair.first;
        this.F = pVar2;
        Object obj = pair.second;
        if (pVar != null) {
            i = 0;
        } else if (this.z > 0) {
            Pair<Integer, Long> pairA = a(this.A);
            i = this.z;
            this.z = 0;
            this.A = null;
            if (pairA == null) {
                a(obj, i);
                return;
            }
            this.l = new b(((Integer) pairA.first).intValue(), ((Long) pairA.second).longValue());
        } else {
            if (this.l.f1153b == -9223372036854775807L) {
                if (pVar2.c()) {
                    a(obj, 0);
                    return;
                } else {
                    Pair<Integer, Long> pairA2 = a(0, -9223372036854775807L);
                    this.l = new b(((Integer) pairA2.first).intValue(), ((Long) pairA2.second).longValue());
                }
            }
            i = 0;
        }
        a aVar = this.E;
        if (aVar == null) {
            aVar = this.C;
        }
        if (aVar == null) {
            b(obj, i);
            return;
        }
        int iA = this.F.a(aVar.f1152b);
        if (iA == -1) {
            int iA2 = a(aVar.f, pVar, this.F);
            if (iA2 == -1) {
                a(obj, i);
                return;
            }
            Pair<Integer, Long> pairA3 = a(this.F.a(iA2, this.k, false).c, -9223372036854775807L);
            int iIntValue = ((Integer) pairA3.first).intValue();
            long jLongValue = ((Long) pairA3.second).longValue();
            this.F.a(iIntValue, this.k, true);
            Object obj2 = this.k.f1174b;
            aVar.f = -1;
            while (true) {
                aVar = aVar.k;
                if (aVar != null) {
                    aVar.f = aVar.f1152b.equals(obj2) ? iIntValue : -1;
                } else {
                    this.l = new b(iIntValue, b(iIntValue, jLongValue));
                    b(obj, i);
                    return;
                }
            }
        } else {
            this.F.a(iA, this.k, false);
            boolean z = iA == this.F.a() - 1 && !this.F.a(this.k.c, this.j).f1175b;
            aVar.f = iA;
            aVar.h = z;
            boolean z2 = aVar == this.D;
            b bVar = this.l;
            if (iA != bVar.a) {
                b bVar2 = new b(iA, bVar.f1153b);
                bVar2.c = bVar.c;
                bVar2.d = bVar.d;
                this.l = bVar2;
            }
            while (true) {
                a aVar2 = aVar.k;
                if (aVar2 == null) {
                    break;
                }
                iA++;
                this.F.a(iA, this.k, true);
                boolean z3 = iA == this.F.a() - 1 && !this.F.a(this.k.c, this.j).f1175b;
                if (!aVar2.f1152b.equals(this.k.f1174b)) {
                    if (!z2) {
                        int i2 = this.E.f;
                        this.l = new b(i2, b(i2, this.l.c));
                        break;
                    } else {
                        this.C = aVar;
                        aVar.k = null;
                        a(aVar2);
                        break;
                    }
                }
                aVar2.f = iA;
                aVar2.h = z3;
                z2 |= aVar2 == this.D;
                aVar = aVar2;
            }
            b(obj, i);
        }
    }

    public final void a(Object obj, int i) {
        this.l = new b(0, 0L);
        b(obj, i);
        this.l = new b(0, -9223372036854775807L);
        a(4);
        b(false);
    }

    public final int a(int i, p pVar, p pVar2) {
        int iA = -1;
        while (iA == -1 && i < pVar.a() - 1) {
            i++;
            iA = pVar2.a(pVar.a(i, this.k, true).f1174b);
        }
        return iA;
    }

    public final Pair<Integer, Long> a(c cVar) {
        p pVar = cVar.a;
        if (pVar.c()) {
            pVar = this.F;
        }
        try {
            Pair<Integer, Long> pairA = a(pVar, cVar.f1154b, cVar.c, 0L);
            p pVar2 = this.F;
            if (pVar2 == pVar) {
                return pairA;
            }
            int iA = pVar2.a(pVar.a(((Integer) pairA.first).intValue(), this.k, true).f1174b);
            if (iA != -1) {
                return Pair.create(Integer.valueOf(iA), pairA.second);
            }
            int iA2 = a(((Integer) pairA.first).intValue(), pVar, this.F);
            if (iA2 != -1) {
                return a(this.F.a(iA2, this.k, false).c, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new k(this.F, cVar.f1154b, cVar.c);
        }
    }

    public final Pair<Integer, Long> a(int i, long j) {
        return a(this.F, i, j, 0L);
    }

    public final Pair<Integer, Long> a(p pVar, int i, long j, long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i, 0, pVar.b());
        pVar.a(i, this.j, false, j2);
        if (j == -9223372036854775807L) {
            j = this.j.e;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        p.c cVar = this.j;
        int i2 = cVar.c;
        long j3 = cVar.g + j;
        long j4 = pVar.a(i2, this.k, false).d;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < this.j.d) {
            j3 -= j4;
            i2++;
            j4 = pVar.a(i2, this.k, false).d;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.m mVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        a aVar = this.C;
        if (aVar == null || aVar.a != mVar) {
            return;
        }
        aVar.i = true;
        aVar.d();
        aVar.g = aVar.a(aVar.g, false, new boolean[aVar.n.length]);
        if (this.E == null) {
            a aVar2 = this.C;
            this.D = aVar2;
            b(aVar2.g);
            b(this.D);
        }
        b();
    }

    public final void a(a aVar) {
        while (aVar != null) {
            aVar.c();
            aVar = aVar.k;
        }
    }

    public final void a(boolean[] zArr, int i) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.q = new n[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            n[] nVarArr = this.a;
            if (i2 >= nVarArr.length) {
                return;
            }
            n nVar = nVarArr[i2];
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = this.E.m.f1199b.f1198b[i2];
            if (eVar != null) {
                int i4 = i3 + 1;
                this.q[i3] = nVar;
                if (nVar.a() == 0) {
                    o oVar = this.E.m.d[i2];
                    boolean z = this.s && this.v == 3;
                    boolean z2 = !zArr[i2] && z;
                    int iF = eVar.f();
                    i[] iVarArr = new i[iF];
                    for (int i5 = 0; i5 < iF; i5++) {
                        iVarArr[i5] = eVar.a(i5);
                    }
                    a aVar = this.E;
                    nVar.a(oVar, iVarArr, aVar.c[i2], this.B, z2, aVar.a());
                    com.fyber.inneractive.sdk.player.exoplayer2.util.g gVarJ = nVar.j();
                    if (gVarJ != null) {
                        if (this.o == null) {
                            this.o = gVarJ;
                            this.n = nVar;
                            gVarJ.a(this.m);
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.d(2, null, new IllegalStateException("Multiple renderer media clocks enabled."), -1);
                        }
                    }
                    if (z) {
                        nVar.f();
                    }
                }
                i3 = i4;
            }
            i2++;
        }
    }
}
