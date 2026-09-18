package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.source.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.util.t;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements x.a<com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a>, p, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h, com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.InterfaceC0285d {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1071b;
    public final c c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.i e;
    public final int f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f.a h;
    public boolean n;
    public boolean o;
    public int p;
    public com.fyber.inneractive.sdk.player.exoplayer2.i q;
    public int r;
    public boolean s;
    public s t;
    public int u;
    public boolean[] v;
    public long w;
    public long x;
    public boolean y;
    public final x g = new x("Loader:HlsSampleStreamWrapper");
    public final c.b i = new c.b();
    public final SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> j = new SparseArray<>();
    public final LinkedList<f> k = new LinkedList<>();
    public final Runnable l = new a();
    public final Handler m = new Handler();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.i();
        }
    }

    public interface b {
    }

    public j(int i, b bVar, c cVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar2, long j, com.fyber.inneractive.sdk.player.exoplayer2.i iVar, int i2, com.fyber.inneractive.sdk.player.exoplayer2.source.f.a aVar) {
        this.a = i;
        this.f1071b = bVar;
        this.c = cVar;
        this.d = bVar2;
        this.e = iVar;
        this.f = i2;
        this.h = aVar;
        this.w = j;
        this.x = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.h
    public void a(m mVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public void a(x.c cVar, long j, long j2, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) cVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f.a aVar2 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar = aVar.a;
        int i = aVar.f1179b;
        int i2 = this.a;
        com.fyber.inneractive.sdk.player.exoplayer2.i iVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long jC = aVar.c();
        if (aVar2.f1182b != null) {
            aVar2.a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(aVar2, jVar, i, i2, iVar, i3, obj, j3, j4, j, j2, jC));
        }
        if (z) {
            return;
        }
        int size = this.j.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.j.valueAt(i4).a(this.v[i4]);
        }
        ((g) this.f1071b).a(this);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.h
    public void c() {
        this.n = true;
        this.m.post(this.l);
    }

    public void d(long j) {
        this.w = j;
        this.x = j;
        this.y = false;
        this.k.clear();
        if (this.g.b()) {
            this.g.a();
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.valueAt(i).a(this.v[i]);
        }
    }

    public void g() {
        if (this.o) {
            return;
        }
        a(this.w);
    }

    public final boolean h() {
        return this.x != -9223372036854775807L;
    }

    public final void i() {
        if (this.s || this.o || !this.n) {
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (this.j.valueAt(i).e() == null) {
                return;
            }
        }
        int size2 = this.j.size();
        int i2 = 0;
        char c = 0;
        int i3 = -1;
        while (true) {
            char c2 = 3;
            if (i2 >= size2) {
                break;
            }
            String str = this.j.valueAt(i2).e().f;
            if (!com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                c2 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str) ? (char) 2 : "text".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.h.b(str)) ? (char) 1 : (char) 0;
            }
            if (c2 > c) {
                i3 = i2;
                c = c2;
            } else if (c2 == c && i3 != -1) {
                i3 = -1;
            }
            i2++;
        }
        r rVar = this.c.f;
        int i4 = rVar.a;
        this.u = -1;
        this.v = new boolean[size2];
        r[] rVarArr = new r[size2];
        for (int i5 = 0; i5 < size2; i5++) {
            com.fyber.inneractive.sdk.player.exoplayer2.i iVarE = this.j.valueAt(i5).e();
            if (i5 == i3) {
                com.fyber.inneractive.sdk.player.exoplayer2.i[] iVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.i[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    iVarArr[i6] = a(rVar.f1191b[i6], iVarE);
                }
                rVarArr[i5] = new r(iVarArr);
                this.u = i5;
            } else {
                rVarArr[i5] = new r(a((c == 3 && com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(iVarE.f)) ? this.e : null, iVarE));
            }
        }
        this.t = new s(rVarArr);
        this.o = true;
        g gVar = (g) this.f1071b;
        int i7 = gVar.k - 1;
        gVar.k = i7;
        if (i7 > 0) {
            return;
        }
        int i8 = 0;
        for (j jVar : gVar.n) {
            i8 += jVar.t.a;
        }
        r[] rVarArr2 = new r[i8];
        int i9 = 0;
        for (j jVar2 : gVar.n) {
            int i10 = jVar2.t.a;
            int i11 = 0;
            while (i11 < i10) {
                rVarArr2[i9] = jVar2.t.f1192b[i11];
                i11++;
                i9++;
            }
        }
        gVar.m = new s(rVarArr2);
        ((com.fyber.inneractive.sdk.player.exoplayer2.h) gVar.j).f.obtainMessage(8, gVar).sendToTarget();
    }

    public void j() throws IOException {
        this.g.c();
        c cVar = this.c;
        IOException iOException = cVar.j;
        if (iOException != null) {
            throw iOException;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a = cVar.k;
        if (c0287a != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a aVar = cVar.e.e.get(c0287a);
            aVar.f1080b.c();
            IOException iOException2 = aVar.j;
            if (iOException2 != null) {
                throw iOException2;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public void a(x.c cVar, long j, long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) cVar;
        c cVar2 = this.c;
        cVar2.getClass();
        if (aVar instanceof c.a) {
            c.a aVar2 = (c.a) aVar;
            cVar2.i = aVar2.i;
            cVar2.a(aVar2.a.a, aVar2.l, aVar2.m);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.f.a aVar3 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar = aVar.a;
        int i = aVar.f1179b;
        int i2 = this.a;
        com.fyber.inneractive.sdk.player.exoplayer2.i iVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long jC = aVar.c();
        if (aVar3.f1182b != null) {
            aVar3.a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(aVar3, jVar, i, i2, iVar, i3, obj, j3, j4, j, j2, jC));
        }
        if (!this.o) {
            a(this.w);
        } else {
            ((g) this.f1071b).a(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:20:0x004c  */
    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0096  */
    /* JADX WARN: Code duplicated, block: B:32:0x009a  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9 A[ORIG_RETURN, RETURN] */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public int a(x.c cVar, long j, long j2, IOException iOException) {
        boolean z;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f.a aVar;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar;
        int i;
        int i2;
        com.fyber.inneractive.sdk.player.exoplayer2.i iVar;
        int i3;
        Object obj;
        long j3;
        long j4;
        long jC;
        boolean z2;
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) cVar;
        boolean z3 = aVar2 instanceof f;
        boolean z4 = true;
        boolean z5 = !z3 || aVar2.c() == 0;
        c cVar2 = this.c;
        cVar2.getClass();
        if (z5) {
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = cVar2.p;
            z = com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.b.a(eVar, eVar.c(cVar2.f.a(aVar2.c)), iOException, 60000L);
            if (z) {
                z4 = false;
            } else if (z3) {
                if (this.k.removeLast() == aVar2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z2);
                if (this.k.isEmpty()) {
                    this.x = this.w;
                }
            }
            aVar = this.h;
            jVar = aVar2.a;
            i = aVar2.f1179b;
            i2 = this.a;
            iVar = aVar2.c;
            i3 = aVar2.d;
            obj = aVar2.e;
            j3 = aVar2.f;
            j4 = aVar2.g;
            jC = aVar2.c();
            if (aVar.f1182b != null) {
                aVar.a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(aVar, jVar, i, i2, iVar, i3, obj, j3, j4, j, j2, jC, iOException, z4));
            }
            if (z4) {
                return 0;
            }
            if (!this.o) {
                a(this.w);
            } else {
                ((g) this.f1071b).a(this);
            }
            return 2;
        }
        if (z) {
            z4 = false;
        } else if (z3) {
            if (this.k.removeLast() == aVar2) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(z2);
            if (this.k.isEmpty()) {
                this.x = this.w;
            }
        }
        aVar = this.h;
        jVar = aVar2.a;
        i = aVar2.f1179b;
        i2 = this.a;
        iVar = aVar2.c;
        i3 = aVar2.d;
        obj = aVar2.e;
        j3 = aVar2.f;
        j4 = aVar2.g;
        jC = aVar2.c();
        if (aVar.f1182b != null) {
            aVar.a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(aVar, jVar, i, i2, iVar, i3, obj, j3, j4, j, j2, jC, iOException, z4));
        }
        if (z4) {
            return 0;
        }
        if (!this.o) {
            a(this.w);
        } else {
            ((g) this.f1071b).a(this);
        }
        return 2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.h
    public /* bridge */ /* synthetic */ n a(int i, int i2) {
        return a(i);
    }

    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.o);
        for (int i = 0; i < eVarArr.length; i++) {
            if (oVarArr[i] != null && (eVarArr[i] == null || !zArr[i])) {
                int i2 = ((i) oVarArr[i]).a;
                a(i2, false);
                this.j.valueAt(i2).b();
                oVarArr[i] = null;
            }
        }
        boolean z2 = false;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = null;
        for (int i3 = 0; i3 < eVarArr.length; i3++) {
            if (oVarArr[i3] == null && eVarArr[i3] != null) {
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar2 = eVarArr[i3];
                int iA = this.t.a(eVar2.b());
                a(iA, true);
                if (iA == this.u) {
                    this.c.p = eVar2;
                    eVar = eVar2;
                }
                oVarArr[i3] = new i(this, iA);
                zArr2[i3] = true;
                z2 = true;
            }
        }
        if (z) {
            int size = this.j.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.v[i4]) {
                    this.j.valueAt(i4).b();
                }
            }
            if (eVar != null && !this.k.isEmpty()) {
                eVar.a(0L);
                if (eVar.a() != this.c.f.a(this.k.getLast().c)) {
                    d(this.w);
                }
            }
        }
        if (this.p == 0) {
            this.c.j = null;
            this.q = null;
            this.k.clear();
            if (this.g.b()) {
                this.g.a();
            }
        }
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0109  */
    /* JADX WARN: Code duplicated, block: B:71:0x0112  */
    /* JADX WARN: Code duplicated, block: B:73:0x011c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0120  */
    /* JADX WARN: Code duplicated, block: B:76:0x0124  */
    /* JADX WARN: Code duplicated, block: B:77:0x012a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0137  */
    /* JADX WARN: Code duplicated, block: B:81:0x0147  */
    /* JADX WARN: Code duplicated, block: B:82:0x018d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0197  */
    /* JADX WARN: Code duplicated, block: B:85:0x019f  */
    /* JADX WARN: Code duplicated, block: B:88:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:89:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:92:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:93:0x01f6  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.p
    public boolean a(long j) {
        f fVar;
        int iMax;
        int size;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a;
        int i;
        int i2;
        int i3;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a aVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a aVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar;
        int i4;
        k kVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar;
        Uri uriA;
        if (this.y || this.g.b()) {
            return false;
        }
        c cVar = this.c;
        f last = this.k.isEmpty() ? null : this.k.getLast();
        long j2 = this.x;
        if (j2 == -9223372036854775807L) {
            j2 = j;
        }
        c.b bVar = this.i;
        int iA = last == null ? -1 : cVar.f.a(last.c);
        cVar.k = null;
        cVar.p.a(last != null ? Math.max(0L, last.f - j2) : 0L);
        int iA2 = cVar.p.a();
        boolean z = iA != iA2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a2 = cVar.d[iA2];
        if (!cVar.e.b(c0287a2)) {
            bVar.c = c0287a2;
            cVar.k = c0287a2;
        } else {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVarA = cVar.e.a(c0287a2);
            if (last != null && !z) {
                size = last.i + 1;
            } else {
                if (last != null) {
                    j2 = last.f;
                }
                if (bVarA.j) {
                    fVar = last;
                } else {
                    fVar = last;
                    if (j2 > bVarA.d + bVarA.o) {
                        size = bVarA.g + bVarA.m.size();
                        i = iA2;
                        c0287a = c0287a2;
                        last = fVar;
                    }
                    i2 = bVarA.g;
                    if (size < i2) {
                        cVar.j = new com.fyber.inneractive.sdk.player.exoplayer2.source.g();
                    } else {
                        i3 = size - i2;
                        if (i3 >= bVarA.m.size()) {
                            if (bVarA.j) {
                                bVar.f1067b = true;
                            } else {
                                bVar.c = c0287a;
                                cVar.k = c0287a;
                            }
                        } else {
                            aVar = bVarA.m.get(i3);
                            if (aVar.e) {
                                uriA = t.a(bVarA.a, aVar.f);
                                if (!uriA.equals(cVar.l)) {
                                    bVar.a = new c.a(cVar.f1066b, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA, null, 0L, 0L, -1L, null, 1), cVar.d[i].f1074b, cVar.p.d(), cVar.p.g(), cVar.i, aVar.g);
                                } else if (!u.a(aVar.g, cVar.n)) {
                                    cVar.a(uriA, aVar.g, cVar.m);
                                }
                            } else {
                                cVar.l = null;
                                cVar.m = null;
                                cVar.n = null;
                                cVar.o = null;
                            }
                            aVar2 = bVarA.l;
                            if (aVar2 != null) {
                                Uri uriA2 = t.a(bVarA.a, aVar2.a);
                                long j3 = aVar2.h;
                                jVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA2, null, j3, j3, aVar2.i, null, 0);
                            } else {
                                jVar = null;
                            }
                            long j4 = bVarA.d + aVar.d;
                            i4 = bVarA.f + aVar.c;
                            kVar = cVar.c;
                            rVar = kVar.a.get(i4);
                            if (rVar == null) {
                                rVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.r(Long.MAX_VALUE);
                                kVar.a.put(i4, rVar);
                            }
                            Uri uriA3 = t.a(bVarA.a, aVar.a);
                            long j5 = aVar.h;
                            bVar.a = new f(cVar.a, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA3, null, j5, j5, aVar.i, null, 0), jVar, c0287a, cVar.g, cVar.p.d(), cVar.p.g(), j4, j4 + aVar.f1076b, size, i4, cVar.h, rVar, last, cVar.m, cVar.o);
                        }
                    }
                }
                List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a> list = bVarA.m;
                Long lValueOf = Long.valueOf(j2 - bVarA.d);
                boolean z2 = !cVar.e.n || fVar == null;
                int i5 = u.a;
                int iBinarySearch = Collections.binarySearch(list, lValueOf);
                if (iBinarySearch < 0) {
                    iMax = -(iBinarySearch + 2);
                } else {
                    do {
                        iBinarySearch--;
                        if (iBinarySearch < 0) {
                            break;
                        }
                    } while (list.get(iBinarySearch).compareTo(lValueOf) == 0);
                    iMax = iBinarySearch + 1;
                }
                if (z2) {
                    iMax = Math.max(0, iMax);
                }
                int i6 = bVarA.g;
                int i7 = iMax + i6;
                if (i7 >= i6 || fVar == null) {
                    last = fVar;
                    size = i7;
                } else {
                    c0287a = cVar.d[iA];
                    bVarA = cVar.e.a(c0287a);
                    last = fVar;
                    size = last.i + 1;
                    i = iA;
                }
                i2 = bVarA.g;
                if (size < i2) {
                    cVar.j = new com.fyber.inneractive.sdk.player.exoplayer2.source.g();
                } else {
                    i3 = size - i2;
                    if (i3 >= bVarA.m.size()) {
                        if (bVarA.j) {
                            bVar.f1067b = true;
                        } else {
                            bVar.c = c0287a;
                            cVar.k = c0287a;
                        }
                    } else {
                        aVar = bVarA.m.get(i3);
                        if (aVar.e) {
                            uriA = t.a(bVarA.a, aVar.f);
                            if (!uriA.equals(cVar.l)) {
                                bVar.a = new c.a(cVar.f1066b, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA, null, 0L, 0L, -1L, null, 1), cVar.d[i].f1074b, cVar.p.d(), cVar.p.g(), cVar.i, aVar.g);
                            } else if (!u.a(aVar.g, cVar.n)) {
                                cVar.a(uriA, aVar.g, cVar.m);
                            }
                        } else {
                            cVar.l = null;
                            cVar.m = null;
                            cVar.n = null;
                            cVar.o = null;
                        }
                        aVar2 = bVarA.l;
                        if (aVar2 != null) {
                            Uri uriA4 = t.a(bVarA.a, aVar2.a);
                            long j6 = aVar2.h;
                            jVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA4, null, j6, j6, aVar2.i, null, 0);
                        } else {
                            jVar = null;
                        }
                        long j7 = bVarA.d + aVar.d;
                        i4 = bVarA.f + aVar.c;
                        kVar = cVar.c;
                        rVar = kVar.a.get(i4);
                        if (rVar == null) {
                            rVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.r(Long.MAX_VALUE);
                            kVar.a.put(i4, rVar);
                        }
                        Uri uriA5 = t.a(bVarA.a, aVar.a);
                        long j8 = aVar.h;
                        bVar.a = new f(cVar.a, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA5, null, j8, j8, aVar.i, null, 0), jVar, c0287a, cVar.g, cVar.p.d(), cVar.p.g(), j7, j7 + aVar.f1076b, size, i4, cVar.h, rVar, last, cVar.m, cVar.o);
                    }
                }
            }
            i = iA2;
            c0287a = c0287a2;
            i2 = bVarA.g;
            if (size < i2) {
                cVar.j = new com.fyber.inneractive.sdk.player.exoplayer2.source.g();
            } else {
                i3 = size - i2;
                if (i3 >= bVarA.m.size()) {
                    if (bVarA.j) {
                        bVar.f1067b = true;
                    } else {
                        bVar.c = c0287a;
                        cVar.k = c0287a;
                    }
                } else {
                    aVar = bVarA.m.get(i3);
                    if (aVar.e) {
                        uriA = t.a(bVarA.a, aVar.f);
                        if (!uriA.equals(cVar.l)) {
                            bVar.a = new c.a(cVar.f1066b, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA, null, 0L, 0L, -1L, null, 1), cVar.d[i].f1074b, cVar.p.d(), cVar.p.g(), cVar.i, aVar.g);
                        } else if (!u.a(aVar.g, cVar.n)) {
                            cVar.a(uriA, aVar.g, cVar.m);
                        }
                    } else {
                        cVar.l = null;
                        cVar.m = null;
                        cVar.n = null;
                        cVar.o = null;
                    }
                    aVar2 = bVarA.l;
                    if (aVar2 != null) {
                        Uri uriA6 = t.a(bVarA.a, aVar2.a);
                        long j9 = aVar2.h;
                        jVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA6, null, j9, j9, aVar2.i, null, 0);
                    } else {
                        jVar = null;
                    }
                    long j10 = bVarA.d + aVar.d;
                    i4 = bVarA.f + aVar.c;
                    kVar = cVar.c;
                    rVar = kVar.a.get(i4);
                    if (rVar == null) {
                        rVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.r(Long.MAX_VALUE);
                        kVar.a.put(i4, rVar);
                    }
                    Uri uriA7 = t.a(bVarA.a, aVar.a);
                    long j11 = aVar.h;
                    bVar.a = new f(cVar.a, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriA7, null, j11, j11, aVar.i, null, 0), jVar, c0287a, cVar.g, cVar.p.d(), cVar.p.g(), j10, j10 + aVar.f1076b, size, i4, cVar.h, rVar, last, cVar.m, cVar.o);
                }
            }
        }
        c.b bVar2 = this.i;
        boolean z3 = bVar2.f1067b;
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar3 = bVar2.a;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a3 = bVar2.c;
        bVar2.a = null;
        bVar2.f1067b = false;
        bVar2.c = null;
        if (z3) {
            this.y = true;
            return true;
        }
        if (aVar3 == null) {
            if (c0287a3 == null) {
                return false;
            }
            ((g) this.f1071b).a.e.get(c0287a3).b();
            return false;
        }
        if (aVar3 instanceof f) {
            this.x = -9223372036854775807L;
            f fVar2 = (f) aVar3;
            fVar2.D = this;
            int i8 = fVar2.j;
            boolean z4 = fVar2.t;
            this.r = i8;
            for (int i9 = 0; i9 < this.j.size(); i9++) {
                this.j.valueAt(i9).c.r = i8;
            }
            if (z4) {
                for (int i10 = 0; i10 < this.j.size(); i10++) {
                    this.j.valueAt(i10).m = true;
                }
            }
            this.k.add(fVar2);
        }
        long jA = this.g.a(aVar3, this, this.f);
        com.fyber.inneractive.sdk.player.exoplayer2.source.f.a aVar4 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar2 = aVar3.a;
        int i11 = aVar3.f1179b;
        int i12 = this.a;
        com.fyber.inneractive.sdk.player.exoplayer2.i iVar = aVar3.c;
        int i13 = aVar3.d;
        Object obj = aVar3.e;
        long j12 = aVar3.f;
        long j13 = aVar3.g;
        if (aVar4.f1182b == null) {
            return true;
        }
        aVar4.a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.a(aVar4, jVar2, i11, i12, iVar, i13, obj, j12, j13, jA));
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.p
    public long a() {
        if (h()) {
            return this.x;
        }
        if (this.y) {
            return Long.MIN_VALUE;
        }
        return this.k.getLast().g;
    }

    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.d a(int i) {
        if (this.j.indexOfKey(i) >= 0) {
            return this.j.get(i);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.d dVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.d(this.d);
        dVar.n = this;
        dVar.c.r = this.r;
        this.j.put(i, dVar);
        return dVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.InterfaceC0285d
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.i iVar) {
        this.m.post(this.l);
    }

    public final void a(int i, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.v[i] != z);
        this.v[i] = z;
        this.p += z ? 1 : -1;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.i a(com.fyber.inneractive.sdk.player.exoplayer2.i iVar, com.fyber.inneractive.sdk.player.exoplayer2.i iVar2) {
        if (iVar == null) {
            return iVar2;
        }
        String strA = null;
        int iC = com.fyber.inneractive.sdk.player.exoplayer2.util.h.c(iVar2.f);
        if (iC == 1) {
            strA = a(iVar.c, 1);
        } else if (iC == 2) {
            strA = a(iVar.c, 2);
        }
        String str = strA;
        return new com.fyber.inneractive.sdk.player.exoplayer2.i(iVar.a, iVar2.e, iVar2.f, str, iVar.f1156b, iVar2.g, iVar.j, iVar.k, iVar2.l, iVar2.m, iVar2.n, iVar2.p, iVar2.o, iVar2.q, iVar2.r, iVar2.s, iVar2.t, iVar2.u, iVar2.v, iVar.x, iVar.y, iVar2.z, iVar2.w, iVar2.h, iVar2.i, iVar2.d);
    }

    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (i == com.fyber.inneractive.sdk.player.exoplayer2.util.h.c(com.fyber.inneractive.sdk.player.exoplayer2.util.h.a(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
