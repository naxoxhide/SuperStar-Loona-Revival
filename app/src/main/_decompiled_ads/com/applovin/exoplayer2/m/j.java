package com.applovin.exoplayer2.m;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class j extends com.applovin.exoplayer2.c.i {
    private final com.applovin.exoplayer2.c.i.a<j> Os;
    public ByteBuffer[] aeK;
    public int[] aeL;
    public int aeM;
    public int dE;
    public int height;

    @Override // com.applovin.exoplayer2.c.i
    public void release() {
        this.Os.releaseOutputBuffer(this);
    }
}
