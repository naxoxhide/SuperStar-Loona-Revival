package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.Handler;
import com.fyber.inneractive.sdk.player.exoplayer2.source.m;
import com.fyber.inneractive.sdk.player.exoplayer2.source.n;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements n, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.InterfaceC0288e {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1069b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f.a c;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e d;
    public n.a e;

    public h(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a aVar, int i, Handler handler, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar) {
        this(uri, new b(aVar), i, handler, fVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.n
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.e eVar, boolean z, n.a aVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.d == null);
        Uri uri = this.a;
        d dVar = this.f1069b;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e eVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e(uri, dVar, this.c, 3, this);
        this.d = eVar2;
        this.e = aVar;
        eVar2.i.a(new y(((b) dVar).a.a(), uri, 4, eVar2.c), eVar2, 3);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.n
    public void b() {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e eVar = this.d;
        if (eVar != null) {
            eVar.i.d();
            Iterator<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a> it = eVar.e.values().iterator();
            while (it.hasNext()) {
                it.next().f1080b.d();
            }
            eVar.f.removeCallbacksAndMessages(null);
            eVar.e.clear();
            this.d = null;
        }
        this.e = null;
    }

    public h(Uri uri, d dVar, int i, Handler handler, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar) {
        this.a = uri;
        this.f1069b = dVar;
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.source.f.a(handler, fVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.n
    public void a() throws IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e eVar = this.d;
        eVar.i.c();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0287a c0287a = eVar.l;
        if (c0287a != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a aVar = eVar.e.get(c0287a);
            aVar.f1080b.c();
            IOException iOException = aVar.j;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.n
    public m a(int i, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar, long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i == 0);
        return new g(this.d, this.f1069b, 3, this.c, bVar, j);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.n
    public void a(m mVar) {
        g gVar = (g) mVar;
        gVar.a.h.remove(gVar);
        gVar.h.removeCallbacksAndMessages(null);
        j[] jVarArr = gVar.n;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                int size = jVar.j.size();
                for (int i = 0; i < size; i++) {
                    jVar.j.valueAt(i).b();
                }
                jVar.g.d();
                jVar.m.removeCallbacksAndMessages(null);
                jVar.s = true;
            }
        }
    }
}
