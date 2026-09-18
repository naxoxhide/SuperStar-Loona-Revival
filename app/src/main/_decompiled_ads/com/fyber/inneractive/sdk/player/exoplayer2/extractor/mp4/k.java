package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f1108b;
    public final int[] c;
    public final int d;
    public final long[] e;
    public final int[] f;

    public k(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iArr.length == jArr2.length);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(jArr.length == jArr2.length);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(iArr2.length == jArr2.length);
        this.f1108b = jArr;
        this.c = iArr;
        this.d = i;
        this.e = jArr2;
        this.f = iArr2;
        this.a = jArr.length;
    }

    public int a(long j) {
        for (int iB = u.b(this.e, j, true, false); iB >= 0; iB--) {
            if ((this.f[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int iA = u.a(this.e, j, true, false); iA < this.e.length; iA++) {
            if ((this.f[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
