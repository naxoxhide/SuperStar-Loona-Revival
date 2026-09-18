package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements q {
    public com.fyber.inneractive.sdk.player.exoplayer2.util.r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n f1140b;
    public boolean c;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.q
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        this.a = rVar;
        dVar.a();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVarA = hVar.a(dVar.c(), 4);
        this.f1140b = nVarA;
        nVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(dVar.b(), "application/x-scte35", null, -1, null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.q
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        long j;
        long j2 = -9223372036854775807L;
        if (!this.c) {
            if (this.a.a() == -9223372036854775807L) {
                return;
            }
            this.f1140b.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "application/x-scte35", this.a.a()));
            this.c = true;
        }
        int iA = kVar.a();
        this.f1140b.a(kVar, iA);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar = this.f1140b;
        com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar = this.a;
        if (rVar.c == -9223372036854775807L) {
            j = rVar.a;
            if (j == Long.MAX_VALUE) {
            }
            nVar.a(j, 1, iA, 0, null);
        }
        j2 = rVar.c;
        j = j2;
        nVar.a(j, 1, iA, 0, null);
    }
}
