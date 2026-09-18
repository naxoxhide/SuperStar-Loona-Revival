package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class y<T> implements x.c {
    public final j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1225b;
    public final a<? extends T> c;
    public volatile T d;
    public volatile boolean e;
    public volatile long f;

    public interface a<T> {
    }

    public y(g gVar, Uri uri, int i, a<? extends T> aVar) {
        this.f1225b = gVar;
        this.a = new j(uri, 1);
        this.c = aVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
    public final boolean a() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
    public final void b() {
        this.e = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c
    public final void load() throws InterruptedException, IOException {
        i iVar = new i(this.f1225b, this.a);
        try {
            if (!iVar.d) {
                iVar.a.a(iVar.f1213b);
                iVar.d = true;
            }
            this.d = (T) ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d) this.c).a(this.f1225b.a(), iVar);
        } finally {
            this.f = iVar.f;
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(iVar);
        }
    }
}
