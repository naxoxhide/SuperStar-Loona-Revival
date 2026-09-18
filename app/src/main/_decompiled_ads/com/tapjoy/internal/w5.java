package com.tapjoy.internal;

import java.nio.charset.Charset;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes4.dex */
public final class w5 {
    public final c0 a;

    public w5(b0 b0Var) {
        this.a = b0Var;
    }

    public static int a(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public final void b(int i) {
        b0 b0Var = (b0) this.a;
        b0Var.getClass();
        Charset charset = sa.a;
        int i2 = ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
        u6 u6VarA = b0Var.a(4);
        byte[] bArr = u6VarA.a;
        int i3 = u6VarA.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        u6VarA.c = i6 + 1;
        b0Var.f2731b += 4;
    }

    public final void c(int i) {
        while ((i & (-128)) != 0) {
            ((b0) this.a).b((i & WorkQueueKt.MASK) | 128);
            i >>>= 7;
        }
        ((b0) this.a).b(i);
    }

    public final void a(g0 g0Var) {
        b0 b0Var = (b0) this.a;
        b0Var.getClass();
        if (g0Var != null) {
            g0Var.a(b0Var);
            return;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public final void c(long j) {
        while (((-128) & j) != 0) {
            ((b0) this.a).b((((int) j) & WorkQueueKt.MASK) | 128);
            j >>>= 7;
        }
        ((b0) this.a).b((int) j);
    }

    public final void b(long j) {
        b0 b0Var = (b0) this.a;
        b0Var.getClass();
        long jA = sa.a(j);
        u6 u6VarA = b0Var.a(8);
        byte[] bArr = u6VarA.a;
        int i = u6VarA.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((jA >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((jA >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((jA >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((jA >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((jA >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((jA >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((jA >>> 8) & 255);
        bArr[i8] = (byte) (jA & 255);
        u6VarA.c = i8 + 1;
        b0Var.f2731b += 8;
    }
}
