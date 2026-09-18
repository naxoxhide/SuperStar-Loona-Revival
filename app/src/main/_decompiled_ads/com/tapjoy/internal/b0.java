package com.tapjoy.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 implements d0, c0, Cloneable {
    public u6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2731b;

    public final byte[] a(long j) throws EOFException {
        int iMin;
        sa.a(this.f2731b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i - i2;
            sa.a(i, i2, i3);
            u6 u6Var = this.a;
            if (u6Var == null) {
                iMin = -1;
            } else {
                iMin = Math.min(i3, u6Var.c - u6Var.f2820b);
                System.arraycopy(u6Var.a, u6Var.f2820b, bArr, i2, iMin);
                int i4 = u6Var.f2820b + iMin;
                u6Var.f2820b = i4;
                this.f2731b -= (long) iMin;
                if (i4 == u6Var.c) {
                    this.a = u6Var.a();
                    v6.a(u6Var);
                }
            }
            if (iMin == -1) {
                throw new EOFException();
            }
            i2 += iMin;
        }
        return bArr;
    }

    public final byte b() {
        long j = this.f2731b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        u6 u6Var = this.a;
        int i = u6Var.f2820b;
        int i2 = u6Var.c;
        int i3 = i + 1;
        byte b2 = u6Var.a[i];
        this.f2731b = j - 1;
        if (i3 == i2) {
            this.a = u6Var.a();
            v6.a(u6Var);
        } else {
            u6Var.f2820b = i3;
        }
        return b2;
    }

    public final byte[] c() {
        try {
            return a(this.f2731b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final int d() {
        long j = this.f2731b;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.f2731b);
        }
        u6 u6Var = this.a;
        int i = u6Var.f2820b;
        int i2 = u6Var.c;
        if (i2 - i < 4) {
            return ((b() & 255) << 24) | ((b() & 255) << 16) | ((b() & 255) << 8) | (b() & 255);
        }
        byte[] bArr = u6Var.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f2731b = j - 4;
        if (i8 == i2) {
            this.a = u6Var.a();
            v6.a(u6Var);
        } else {
            u6Var.f2820b = i8;
        }
        return i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        long j = this.f2731b;
        if (j != b0Var.f2731b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        u6 u6Var = this.a;
        u6 u6Var2 = b0Var.a;
        int i = u6Var.f2820b;
        int i2 = u6Var2.f2820b;
        while (j2 < this.f2731b) {
            long jMin = Math.min(u6Var.c - i, u6Var2.c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (u6Var.a[i] != u6Var2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == u6Var.c) {
                u6Var = u6Var.f;
                i = u6Var.f2820b;
            }
            if (i2 == u6Var2.c) {
                u6Var2 = u6Var2.f;
                i2 = u6Var2.f2820b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // java.io.Flushable
    public final void flush() {
    }

    public final int hashCode() {
        u6 u6Var = this.a;
        if (u6Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = u6Var.c;
            for (int i3 = u6Var.f2820b; i3 < i2; i3++) {
                i = (i * 31) + u6Var.a[i3];
            }
            u6Var = u6Var.f;
        } while (u6Var != this.a);
        return i;
    }

    public final String toString() {
        long j = this.f2731b;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f2731b);
        }
        int i = (int) j;
        return (i == 0 ? g0.e : new w6(this, i)).toString();
    }

    public final String b(long j) {
        Charset charset = sa.a;
        sa.a(this.f2731b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        u6 u6Var = this.a;
        int i = u6Var.f2820b;
        if (((long) i) + j > u6Var.c) {
            return new String(a(j), charset);
        }
        String str = new String(u6Var.a, i, (int) j, charset);
        int i2 = (int) (((long) u6Var.f2820b) + j);
        u6Var.f2820b = i2;
        this.f2731b -= j;
        if (i2 == u6Var.c) {
            this.a = u6Var.a();
            v6.a(u6Var);
        }
        return str;
    }

    public final b0 a(byte[] bArr, int i) {
        if (bArr != null) {
            int i2 = 0;
            long j = i;
            sa.a(bArr.length, 0, j);
            int i3 = i + 0;
            while (i2 < i3) {
                u6 u6VarA = a(1);
                int iMin = Math.min(i3 - i2, 8192 - u6VarA.c);
                System.arraycopy(bArr, i2, u6VarA.a, u6VarA.c, iMin);
                i2 += iMin;
                u6VarA.c += iMin;
            }
            this.f2731b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final u6 a(int i) {
        u6 u6Var;
        if (i >= 1 && i <= 8192) {
            u6 u6Var2 = this.a;
            if (u6Var2 == null) {
                synchronized (v6.class) {
                    u6Var = v6.a;
                    if (u6Var != null) {
                        v6.a = u6Var.f;
                        u6Var.f = null;
                        v6.f2826b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        u6Var = new u6();
                    }
                }
                this.a = u6Var;
                u6Var.g = u6Var;
                u6Var.f = u6Var;
                return u6Var;
            }
            u6 u6Var3 = u6Var2.g;
            if (u6Var3.c + i <= 8192 && u6Var3.e) {
                return u6Var3;
            }
            u6 u6VarA = v6.a();
            u6VarA.g = u6Var3;
            u6VarA.f = u6Var3.f;
            u6Var3.f.g = u6VarA;
            u6Var3.f = u6VarA;
            return u6VarA;
        }
        throw new IllegalArgumentException();
    }

    public final b0 b(int i) {
        u6 u6VarA = a(1);
        byte[] bArr = u6VarA.a;
        int i2 = u6VarA.c;
        u6VarA.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f2731b++;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final b0 clone() {
        b0 b0Var = new b0();
        if (this.f2731b == 0) {
            return b0Var;
        }
        u6 u6Var = new u6(this.a);
        b0Var.a = u6Var;
        u6Var.g = u6Var;
        u6Var.f = u6Var;
        for (u6 u6Var2 = this.a.f; u6Var2 != this.a; u6Var2 = u6Var2.f) {
            u6 u6Var3 = b0Var.a.g;
            u6 u6Var4 = new u6(u6Var2);
            u6Var3.getClass();
            u6Var4.g = u6Var3;
            u6Var4.f = u6Var3.f;
            u6Var3.f.g = u6Var4;
            u6Var3.f = u6Var4;
        }
        b0Var.f2731b = this.f2731b;
        return b0Var;
    }
}
