package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.v;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements m, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h, x.a<c>, com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.InterfaceC0285d {
    public boolean A;
    public long C;
    public int E;
    public boolean F;
    public boolean G;
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g f1183b;
    public final int c;
    public final Handler d;
    public final l.a e;
    public final n.a f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b g;
    public final String h;
    public final d j;
    public m.a p;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.m q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public s w;
    public long x;
    public boolean[] y;
    public boolean[] z;
    public final x i = new x("Loader:ExtractorMediaPeriod");
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.d k = new com.fyber.inneractive.sdk.player.exoplayer2.util.d();
    public final Runnable l = new a();
    public final Runnable m = new b();
    public final Handler n = new Handler();
    public long D = -9223372036854775807L;
    public final SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> o = new SparseArray<>();
    public long B = -1;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            if (iVar.G || iVar.s || iVar.q == null || !iVar.r) {
                return;
            }
            int size = iVar.o.size();
            for (int i = 0; i < size; i++) {
                if (iVar.o.valueAt(i).e() == null) {
                    return;
                }
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar = iVar.k;
            synchronized (dVar) {
                dVar.a = false;
            }
            r[] rVarArr = new r[size];
            iVar.z = new boolean[size];
            iVar.y = new boolean[size];
            iVar.x = iVar.q.c();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= size) {
                    iVar.w = new s(rVarArr);
                    iVar.s = true;
                    iVar.f.a(new q(iVar.x, iVar.q.a()), null);
                    ((com.fyber.inneractive.sdk.player.exoplayer2.h) iVar.p).f.obtainMessage(8, iVar).sendToTarget();
                    return;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.i iVarE = iVar.o.valueAt(i2).e();
                rVarArr[i2] = new r(iVarE);
                String str = iVarE.f;
                if (!com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str) && !com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                    z = false;
                }
                iVar.z[i2] = z;
                iVar.A = z | iVar.A;
                i2++;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            if (iVar.G) {
                return;
            }
            ((com.fyber.inneractive.sdk.player.exoplayer2.h) iVar.p).a((p) iVar);
        }
    }

    public final class c implements x.c {
        public final Uri a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g f1184b;
        public final d c;
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.d d;
        public volatile boolean f;
        public long h;
        public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.l e = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.l();
        public boolean g = true;
        public long i = -1;

        public c(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, d dVar, com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar2) {
            this.a = (Uri) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(uri);
            this.f1184b = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.g) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(gVar);
            this.c = (d) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(dVar);
            this.d = dVar2;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
        public boolean a() {
            return this.f;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
        public void b() {
            this.f = true;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
        public void load() throws Throwable {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
            int iA = 0;
            while (iA == 0 && !this.f) {
                try {
                    long j = this.e.a;
                    long j2 = j;
                    long jA = this.f1184b.a(new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(this.a, null, j, j, -1L, i.this.h, 0));
                    this.i = jA;
                    if (jA != -1) {
                        this.i = jA + j2;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar = this.f1184b;
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(gVar, j2, this.i);
                    try {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.f fVarA = this.c.a(bVar2, gVar.a());
                        if (this.g) {
                            fVarA.a(j2, this.h);
                            this.g = false;
                        }
                        while (true) {
                            long j3 = j2;
                            while (true) {
                                if (iA != 0 || this.f) {
                                    break;
                                }
                                com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar = this.d;
                                synchronized (dVar) {
                                    while (!dVar.a) {
                                        dVar.wait();
                                    }
                                }
                                iA = fVarA.a(bVar2, this.e);
                                j2 = bVar2.c;
                                if (j2 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED + j3) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar2 = this.d;
                                    synchronized (dVar2) {
                                        dVar2.a = false;
                                    }
                                    i iVar = i.this;
                                    iVar.n.post(iVar.m);
                                }
                            }
                        }
                        if (iA == 1) {
                            iA = 0;
                        } else {
                            this.e.a = bVar2.c;
                        }
                        u.a(this.f1184b);
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        if (iA != 1 && bVar != null) {
                            this.e.a = bVar.c;
                        }
                        u.a(this.f1184b);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                }
            }
        }
    }

    public static final class d {
        public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.f[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.h f1185b;
        public com.fyber.inneractive.sdk.player.exoplayer2.extractor.f c;

        public d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.f[] fVarArr, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar) {
            this.a = fVarArr;
            this.f1185b = hVar;
        }

        public com.fyber.inneractive.sdk.player.exoplayer2.extractor.f a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, Uri uri) throws InterruptedException, IOException {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f fVar = this.c;
            if (fVar != null) {
                return fVar;
            }
            for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.f fVar2 : this.a) {
                try {
                    if (fVar2.a(gVar)) {
                        this.c = fVar2;
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).e = 0;
                        break;
                    }
                    continue;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).e = 0;
                    throw th;
                }
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).e = 0;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f fVar3 = this.c;
            if (fVar3 != null) {
                fVar3.a(this.f1185b);
                return this.c;
            }
            StringBuilder sbAppend = new StringBuilder().append("None of the available extractors (");
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f[] fVarArr = this.a;
            int i = u.a;
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < fVarArr.length; i2++) {
                sb.append(fVarArr[i2].getClass().getSimpleName());
                if (i2 < fVarArr.length - 1) {
                    sb.append(", ");
                }
            }
            throw new t(sbAppend.append(sb.toString()).append(") could read the stream.").toString(), uri);
        }
    }

    public i(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.f[] fVarArr, int i, Handler handler, l.a aVar, n.a aVar2, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar, String str) {
        this.a = uri;
        this.f1183b = gVar;
        this.c = i;
        this.d = handler;
        this.e = aVar;
        this.f = aVar2;
        this.g = bVar;
        this.h = str;
        this.j = new d(fVarArr, this);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public void a(x.c cVar, long j, long j2, boolean z) {
        c cVar2 = (c) cVar;
        if (this.B == -1) {
            this.B = cVar2.i;
        }
        if (z || this.v <= 0) {
            return;
        }
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            this.o.valueAt(i).a(this.y[i]);
        }
        ((com.fyber.inneractive.sdk.player.exoplayer2.h) this.p).a((p) this);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public s b() {
        return this.w;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.h
    public void c() {
        this.r = true;
        this.n.post(this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public void c(long j) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public long d() {
        long jH;
        if (this.F) {
            return Long.MIN_VALUE;
        }
        if (i()) {
            return this.D;
        }
        if (this.A) {
            jH = Long.MAX_VALUE;
            int size = this.o.size();
            for (int i = 0; i < size; i++) {
                if (this.z[i]) {
                    jH = Math.min(jH, this.o.valueAt(i).d());
                }
            }
        } else {
            jH = h();
        }
        return jH == Long.MIN_VALUE ? this.C : jH;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public void e() throws IOException {
        this.i.c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public long f() {
        if (!this.u) {
            return -9223372036854775807L;
        }
        this.u = false;
        return this.C;
    }

    public final int g() {
        int size = this.o.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.c cVar = this.o.valueAt(i2).c;
            i += cVar.j + cVar.i;
        }
        return i;
    }

    public final long h() {
        int size = this.o.size();
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, this.o.valueAt(i).d());
        }
        return jMax;
    }

    public final boolean i() {
        return this.D != -9223372036854775807L;
    }

    public final void j() {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar;
        c cVar = new c(this.a, this.f1183b, this.j, this.k);
        if (this.s) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(i());
            long j = this.x;
            if (j != -9223372036854775807L && this.D >= j) {
                this.F = true;
                this.D = -9223372036854775807L;
                return;
            }
            long jA = this.q.a(this.D);
            long j2 = this.D;
            cVar.e.a = jA;
            cVar.h = j2;
            cVar.g = true;
            this.D = -9223372036854775807L;
        }
        this.E = g();
        int i = this.c;
        if (i == -1) {
            i = (this.s && this.B == -1 && ((mVar = this.q) == null || mVar.c() == -9223372036854775807L)) ? 6 : 3;
        }
        this.i.a(cVar, this, i);
    }

    public final class e implements o {
        public final int a;

        public e(int i) {
            this.a = i;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
        public void a() throws IOException {
            i.this.i.c();
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
        public boolean isReady() {
            i iVar = i.this;
            return iVar.F || !(iVar.i() || iVar.o.valueAt(this.a).f());
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
        public int a(com.fyber.inneractive.sdk.player.exoplayer2.j jVar, com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar, boolean z) {
            i iVar = i.this;
            int i = this.a;
            if (iVar.u || iVar.i()) {
                return -3;
            }
            return iVar.o.valueAt(i).a(jVar, bVar, z, iVar.F, iVar.C);
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
        public void a(long j) {
            i iVar = i.this;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d dVarValueAt = iVar.o.valueAt(this.a);
            if (iVar.F && j > dVarValueAt.d()) {
                dVarValueAt.g();
            } else {
                dVarValueAt.a(j, true);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public long b(long j) {
        if (!this.q.a()) {
            j = 0;
        }
        this.C = j;
        int size = this.o.size();
        boolean zA = !i();
        for (int i = 0; zA && i < size; i++) {
            if (this.y[i]) {
                zA = this.o.valueAt(i).a(j, false);
            }
        }
        if (!zA) {
            this.D = j;
            this.F = false;
            if (this.i.b()) {
                this.i.a();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.o.valueAt(i2).a(this.y[i2]);
                }
            }
        }
        this.u = false;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public void a(x.c cVar, long j, long j2) {
        c cVar2 = (c) cVar;
        if (this.B == -1) {
            this.B = cVar2.i;
        }
        this.F = true;
        if (this.x == -9223372036854775807L) {
            long jH = h();
            this.x = jH == Long.MIN_VALUE ? 0L : jH + 10000;
            this.f.a(new q(this.x, this.q.a()), null);
        }
        ((com.fyber.inneractive.sdk.player.exoplayer2.h) this.p).a((p) this);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public int a(x.c cVar, long j, long j2, IOException iOException) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar;
        c cVar2 = (c) cVar;
        if (this.B == -1) {
            this.B = cVar2.i;
        }
        Handler handler = this.d;
        if (handler != null && this.e != null) {
            handler.post(new k(this, iOException));
        }
        if ((iOException instanceof t) || (iOException instanceof v) || ((iOException instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.t) && iOException.getCause() != null && ((iOException.getCause() instanceof MalformedURLException) || (iOException.getCause() instanceof UnknownHostException)))) {
            return 3;
        }
        int i = g() > this.E ? 1 : 0;
        if (this.B == -1 && ((mVar = this.q) == null || mVar.c() == -9223372036854775807L)) {
            this.C = 0L;
            this.u = this.s;
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.o.valueAt(i2).a(!this.s || this.y[i2]);
            }
            cVar2.e.a = 0L;
            cVar2.h = 0L;
            cVar2.g = true;
        }
        this.E = g();
        return i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public void a(m.a aVar) {
        this.p = aVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar = this.k;
        synchronized (dVar) {
            if (!dVar.a) {
                dVar.a = true;
                dVar.notifyAll();
            }
        }
        j();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m
    public long a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.s);
        for (int i = 0; i < eVarArr.length; i++) {
            if (oVarArr[i] != null && (eVarArr[i] == null || !zArr[i])) {
                int i2 = ((e) oVarArr[i]).a;
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.y[i2]);
                this.v--;
                this.y[i2] = false;
                this.o.valueAt(i2).b();
                oVarArr[i] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < eVarArr.length; i3++) {
            if (oVarArr[i3] == null && eVarArr[i3] != null) {
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = eVarArr[i3];
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(eVar.f() == 1);
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(eVar.b(0) == 0);
                int iA = this.w.a(eVar.b());
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!this.y[iA]);
                this.v++;
                this.y[iA] = true;
                oVarArr[i3] = new e(iA);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.t) {
            int size = this.o.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.y[i4]) {
                    this.o.valueAt(i4).b();
                }
            }
        }
        if (this.v == 0) {
            this.u = false;
            if (this.i.b()) {
                this.i.a();
            }
        } else if (!this.t ? j != 0 : z) {
            j = b(j);
            for (int i5 = 0; i5 < oVarArr.length; i5++) {
                if (oVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.t = true;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m, com.fyber.inneractive.sdk.player.exoplayer2.source.p
    public boolean a(long j) {
        boolean z = false;
        if (this.F || (this.s && this.v == 0)) {
            return false;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar = this.k;
        synchronized (dVar) {
            if (!dVar.a) {
                dVar.a = true;
                dVar.notifyAll();
                z = true;
            }
        }
        if (this.i.b()) {
            return z;
        }
        j();
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.m, com.fyber.inneractive.sdk.player.exoplayer2.source.p
    public long a() {
        if (this.v == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.h
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n a(int i, int i2) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.d dVar = this.o.get(i);
        if (dVar != null) {
            return dVar;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.d dVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.d(this.g);
        dVar2.n = this;
        this.o.put(i, dVar2);
        return dVar2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar) {
        this.q = mVar;
        this.n.post(this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.InterfaceC0285d
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.i iVar) {
        this.n.post(this.l);
    }
}
