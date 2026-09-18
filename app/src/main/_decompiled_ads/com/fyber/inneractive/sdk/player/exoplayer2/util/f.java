package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f1231b;

    public f(int i) {
        this.f1231b = new long[i];
    }

    public void a(long j) {
        int i = this.a;
        long[] jArr = this.f1231b;
        if (i == jArr.length) {
            this.f1231b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f1231b;
        int i2 = this.a;
        this.a = i2 + 1;
        jArr2[i2] = j;
    }

    public long a(int i) {
        if (i >= 0 && i < this.a) {
            return this.f1231b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.a);
    }
}
