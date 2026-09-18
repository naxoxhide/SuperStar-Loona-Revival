package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b.a {
    public final long[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f1091b;
    public final long c;

    public c(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.f1091b = jArr2;
        this.c = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public long a(long j) {
        return this.f1091b[u.b(this.a, j, true, true)];
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b.a
    public long b(long j) {
        return this.a[u.b(this.f1091b, j, true, true)];
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public long c() {
        return this.c;
    }
}
