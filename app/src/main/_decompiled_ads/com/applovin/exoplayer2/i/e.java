package com.applovin.exoplayer2.i;

/* JADX INFO: loaded from: classes.dex */
final class e extends k {
    private final com.applovin.exoplayer2.c.i.a<k> Os;

    public e(com.applovin.exoplayer2.c.i.a<k> aVar) {
        this.Os = aVar;
    }

    @Override // com.applovin.exoplayer2.c.i
    public final void release() {
        this.Os.releaseOutputBuffer(this);
    }
}
