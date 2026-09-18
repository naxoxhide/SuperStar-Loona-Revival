package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.config.global.s;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a {
    public final d.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.b f1009b;
    public final int c;
    public final s d;

    public e(d.b bVar, d.c cVar, int i, s sVar) {
        this.f1009b = bVar;
        this.c = i;
        this.a = cVar;
        this.d = sVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.g a() {
        d dVar = new d();
        dVar.h = this.f1009b;
        dVar.j = this.c;
        dVar.k = this.d;
        dVar.i = this.a;
        return dVar;
    }
}
