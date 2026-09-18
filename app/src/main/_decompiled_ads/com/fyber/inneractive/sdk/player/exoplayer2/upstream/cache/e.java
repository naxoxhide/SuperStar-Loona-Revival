package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a f1205b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.f.a d;

    public e(a aVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a aVar2, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a aVar3, com.fyber.inneractive.sdk.player.exoplayer2.upstream.f.a aVar4, int i, d.a aVar5) {
        this.a = aVar;
        this.f1205b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.g a() {
        b bVar;
        a aVar = this.a;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVarA = this.f1205b.a();
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVarA2 = this.c.a();
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.f.a aVar2 = this.d;
        if (aVar2 != null) {
            c cVar = (c) aVar2;
            bVar = new b(cVar.a, cVar.f1203b, 20480);
        } else {
            bVar = null;
        }
        return new d(aVar, gVarA, gVarA2, bVar, 2, null);
    }
}
