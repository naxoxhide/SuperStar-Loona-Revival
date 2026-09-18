package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements b.a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1092b;
    public final long c;
    public final long[] d;
    public final long e;
    public final int f;

    public d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.a = j;
        this.f1092b = j2;
        this.c = j3;
        this.d = jArr;
        this.e = j4;
        this.f = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public boolean a() {
        return this.d != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b.a
    public long b(long j) {
        if (a()) {
            long j2 = this.a;
            if (j >= j2) {
                double d = ((j - j2) * 256.0d) / this.e;
                int iB = u.b(this.d, (long) d, true, false) + 1;
                long j3 = this.f1092b;
                long j4 = (((long) iB) * j3) / 100;
                long j5 = iB == 0 ? 0L : this.d[iB - 1];
                long j6 = iB == 99 ? 256L : this.d[iB];
                return j4 + (j6 != j5 ? (long) (((((j3 * ((long) (iB + 1))) / 100) - j4) * (d - j5)) / (j6 - j5)) : 0L);
            }
        }
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public long c() {
        return this.f1092b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
    public long a(long j) {
        if (!a()) {
            return this.a;
        }
        float f = (j * 100.0f) / this.f1092b;
        float f2 = 0.0f;
        if (f > 0.0f) {
            if (f >= 100.0f) {
                f2 = 256.0f;
            } else {
                int i = (int) f;
                f2 = i != 0 ? this.d[i - 1] : 0.0f;
                f2 += ((i < 99 ? this.d[i] : 256.0f) - f2) * (f - i);
            }
        }
        long jRound = Math.round(((double) f2) * 0.00390625d * this.e);
        long j2 = this.a;
        long j3 = jRound + j2;
        long j4 = this.c;
        return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - ((long) this.f)) + this.e) - 1);
    }
}
