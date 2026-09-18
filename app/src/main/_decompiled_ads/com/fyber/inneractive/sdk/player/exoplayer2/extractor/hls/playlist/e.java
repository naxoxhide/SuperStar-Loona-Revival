package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.q;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.util.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements x.a<y<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c>> {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.d f1079b;
    public final int d;
    public final InterfaceC0288e g;
    public final f.a j;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a k;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a l;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b m;
    public boolean n;
    public final List<b> h = new ArrayList();
    public final x i = new x("HlsPlaylistTracker:MasterPlaylist");
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d c = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d();
    public final IdentityHashMap<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a, a> e = new IdentityHashMap<>();
    public final Handler f = new Handler();

    public interface b {
        void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a, long j);

        void c();
    }

    public static final class c extends IOException {
        public c(String str) {
        }
    }

    public static final class d extends IOException {
        public d(String str) {
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$e, reason: collision with other inner class name */
    public interface InterfaceC0288e {
    }

    public e(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.d dVar, f.a aVar, int i, InterfaceC0288e interfaceC0288e) {
        this.a = uri;
        this.f1079b = dVar;
        this.j = aVar;
        this.d = i;
        this.g = interfaceC0288e;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public void a(x.c cVar, long j, long j2, boolean z) {
        y yVar = (y) cVar;
        this.j.a(yVar.a, 4, j, j2, yVar.f);
    }

    public boolean b(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a) {
        int i;
        a aVar = this.e.get(c0287a);
        if (aVar.d != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, com.fyber.inneractive.sdk.player.exoplayer2.b.b(aVar.d.o));
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar = aVar.d;
            if (bVar.j || (i = bVar.f1075b) == 2 || i == 1 || aVar.e + jMax > jElapsedRealtime) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public void a(x.c cVar, long j, long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar;
        y yVar = (y) cVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c cVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c) yVar.d;
        boolean z = cVar2 instanceof com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b;
        if (z) {
            List listSingletonList = Collections.singletonList(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a(cVar2.a, new i("0", "application/x-mpegURL", null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null)));
            List listEmptyList = Collections.emptyList();
            aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a(null, listSingletonList, listEmptyList, listEmptyList, null, null);
        } else {
            aVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a) cVar2;
        }
        this.k = aVar;
        this.l = aVar.f1073b.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.f1073b);
        arrayList.addAll(aVar.c);
        arrayList.addAll(aVar.d);
        int size = arrayList.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a) arrayList.get(i);
            this.e.put(c0287a, new a(c0287a, jElapsedRealtime));
        }
        a aVar2 = this.e.get(this.l);
        if (z) {
            aVar2.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b) cVar2);
        } else {
            aVar2.b();
        }
        this.j.b(yVar.a, 4, j, j2, yVar.f);
    }

    public final class a implements x.a<y<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c>>, Runnable {
        public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x f1080b = new x("HlsPlaylistTracker:MediaPlaylist");
        public final y<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c> c;
        public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b d;
        public long e;
        public long f;
        public long g;
        public long h;
        public boolean i;
        public IOException j;

        public a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a, long j) {
            this.a = c0287a;
            this.g = j;
            this.c = new y<>(((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.b) e.this.f1079b).a(4), t.a(e.this.k.a, c0287a.a), 4, e.this.c);
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
        public void a(x.c cVar, long j, long j2, boolean z) {
            y yVar = (y) cVar;
            e.this.j.a(yVar.a, 4, j, j2, yVar.f);
        }

        public void b() {
            this.h = 0L;
            if (this.i || this.f1080b.b()) {
                return;
            }
            this.f1080b.a(this.c, this, e.this.d);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.i = false;
            b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
        public void a(x.c cVar, long j, long j2) {
            y yVar = (y) cVar;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c cVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c) yVar.d;
            if (cVar2 instanceof com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b) {
                a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b) cVar2);
                e.this.j.b(yVar.a, 4, j, j2, yVar.f);
            } else {
                this.j = new l("Loaded playlist has unexpected type.");
            }
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
        public int a(x.c cVar, long j, long j2, IOException iOException) {
            y yVar = (y) cVar;
            boolean z = iOException instanceof l;
            e.this.j.a(yVar.a, 4, j, j2, yVar.f, iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.b.a(iOException)) {
                a();
                e eVar = e.this;
                if (eVar.l != this.a || e.a(eVar)) {
                    z2 = false;
                }
            }
            return z2 ? 0 : 2;
        }

        /* JADX WARN: Code duplicated, block: B:72:0x0176  */
        public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar) {
            long j;
            long j2;
            long j3;
            int i;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a aVarA;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar2;
            long j4;
            int i2;
            int i3;
            int size;
            int size2;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar3 = this.d;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.e = jElapsedRealtime;
            e eVar = e.this;
            eVar.getClass();
            bVar.getClass();
            if (!(bVar3 == null || (i2 = bVar.g) > (i3 = bVar3.g) || (i2 >= i3 && ((size = bVar.m.size()) > (size2 = bVar3.m.size()) || (size == size2 && bVar.j && !bVar3.j))))) {
                bVar2 = (!bVar.j || bVar3.j) ? bVar3 : new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b(bVar3.f1075b, bVar3.a, bVar3.c, bVar3.d, bVar3.e, bVar3.f, bVar3.g, bVar3.h, bVar3.i, true, bVar3.k, bVar3.l, bVar3.m, bVar3.n);
            } else {
                if (bVar.k) {
                    j = bVar.d;
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar4 = eVar.m;
                    j = bVar4 != null ? bVar4.d : 0L;
                    if (bVar3 != null) {
                        int size3 = bVar3.m.size();
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a aVarA2 = e.a(bVar3, bVar);
                        if (aVarA2 != null) {
                            j2 = bVar3.d;
                            j3 = aVarA2.d;
                        } else if (size3 == bVar.g - bVar3.g) {
                            j2 = bVar3.d;
                            j3 = bVar3.o;
                        }
                        j = j2 + j3;
                    }
                }
                long j5 = j;
                if (bVar.e) {
                    i = bVar.f;
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar5 = eVar.m;
                    i = bVar5 != null ? bVar5.f : 0;
                    if (bVar3 != null && (aVarA = e.a(bVar3, bVar)) != null) {
                        i = (bVar3.f + aVarA.c) - bVar.m.get(0).c;
                    }
                }
                bVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b(bVar.f1075b, bVar.a, bVar.c, j5, true, i, bVar.g, bVar.h, bVar.i, bVar.j, bVar.k, bVar.l, bVar.m, bVar.n);
            }
            this.d = bVar2;
            if (bVar2 != bVar3) {
                this.j = null;
                this.f = jElapsedRealtime;
                if (e.a(e.this, this.a, bVar2)) {
                    j4 = this.d.i;
                } else {
                    j4 = -9223372036854775807L;
                }
            } else if (bVar2.j) {
                j4 = -9223372036854775807L;
            } else {
                if (jElapsedRealtime - this.f > com.fyber.inneractive.sdk.player.exoplayer2.b.b(bVar2.i) * 3.5d) {
                    this.j = new d(this.a.a);
                    a();
                } else if (bVar.g + bVar.m.size() < this.d.g) {
                    this.j = new c(this.a.a);
                }
                j4 = this.d.i / 2;
            }
            if (j4 != -9223372036854775807L) {
                this.i = e.this.f.postDelayed(this, com.fyber.inneractive.sdk.player.exoplayer2.b.b(j4));
            }
        }

        public final void a() {
            this.h = SystemClock.elapsedRealtime() + 60000;
            e eVar = e.this;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a = this.a;
            int size = eVar.h.size();
            for (int i = 0; i < size; i++) {
                eVar.h.get(i).a(c0287a, 60000L);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.a
    public int a(x.c cVar, long j, long j2, IOException iOException) {
        y yVar = (y) cVar;
        boolean z = iOException instanceof l;
        this.j.a(yVar.a, 4, j, j2, yVar.f, iOException, z);
        return z ? 3 : 0;
    }

    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar;
        a aVar = this.e.get(c0287a);
        aVar.getClass();
        aVar.g = SystemClock.elapsedRealtime();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar2 = aVar.d;
        if (bVar2 != null && this.k.f1073b.contains(c0287a) && (((bVar = this.m) == null || !bVar.j) && this.e.get(this.l).g - SystemClock.elapsedRealtime() > 15000)) {
            this.l = c0287a;
            this.e.get(c0287a).b();
        }
        return bVar2;
    }

    public static boolean a(e eVar) {
        List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a> list = eVar.k.f1073b;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = eVar.e.get(list.get(i));
            if (jElapsedRealtime > aVar.h) {
                eVar.l = aVar.a;
                aVar.b();
                return true;
            }
        }
        return false;
    }

    public static boolean a(e eVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar) {
        q qVar;
        long j;
        if (c0287a == eVar.l) {
            if (eVar.m == null) {
                eVar.n = !bVar.j;
            }
            eVar.m = bVar;
            h hVar = (h) eVar.g;
            hVar.getClass();
            long j2 = bVar.c;
            if (hVar.d.n) {
                long j3 = bVar.j ? bVar.d + bVar.o : -9223372036854775807L;
                List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a> list = bVar.m;
                if (j2 != -9223372036854775807L) {
                    j = j2;
                } else if (list.isEmpty()) {
                    j = 0;
                } else {
                    j2 = list.get(Math.max(0, list.size() - 3)).d;
                    j = j2;
                }
                qVar = new q(j3, bVar.o, bVar.d, j, true, !bVar.j);
            } else {
                long j4 = j2 == -9223372036854775807L ? 0L : j2;
                long j5 = bVar.d;
                long j6 = bVar.o;
                qVar = new q(j5 + j6, j6, j5, j4, true, false);
            }
            hVar.e.a(qVar, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.e(hVar.d.k, bVar));
        }
        int size = eVar.h.size();
        for (int i = 0; i < size; i++) {
            eVar.h.get(i).c();
        }
        return c0287a == eVar.l && !bVar.j;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar2) {
        int i = bVar2.g - bVar.g;
        List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a> list = bVar.m;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }
}
