package b.b.a.a.f.a.q;

import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Buffer.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable, ReadableByteChannel, Flushable, WritableByteChannel, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f159b;

    public String a(long j, Charset charset) throws EOFException {
        f.a(this.f159b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        c cVar = this.a;
        if (((long) cVar.f161b) + j > cVar.c) {
            return new String(a(j), charset);
        }
        String str = new String(cVar.a, cVar.f161b, (int) j, charset);
        int i = (int) (((long) cVar.f161b) + j);
        cVar.f161b = i;
        this.f159b -= j;
        if (i == cVar.c) {
            this.a = cVar.a();
            d.a(cVar);
        }
        return str;
    }

    public a b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        f.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            c cVarB = b(1);
            int iMin = Math.min(i3 - i, 8192 - cVarB.c);
            System.arraycopy(bArr, i, cVarB.a, cVarB.c, iMin);
            i += iMin;
            cVarB.c += iMin;
        }
        this.f159b += j;
        return this;
    }

    public boolean c() {
        return this.f159b == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public byte d() {
        long j = this.f159b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        c cVar = this.a;
        int i = cVar.f161b;
        int i2 = cVar.c;
        int i3 = i + 1;
        byte b2 = cVar.a[i];
        this.f159b = j - 1;
        if (i3 == i2) {
            this.a = cVar.a();
            d.a(cVar);
        } else {
            cVar.f161b = i3;
        }
        return b2;
    }

    public String e() {
        try {
            return a(this.f159b, f.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        long j = this.f159b;
        if (j != aVar.f159b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        c cVar = this.a;
        c cVar2 = aVar.a;
        int i = cVar.f161b;
        int i2 = cVar2.f161b;
        while (j2 < this.f159b) {
            long jMin = Math.min(cVar.c - i, cVar2.c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (cVar.a[i] != cVar2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == cVar.c) {
                cVar = cVar.f;
                i = cVar.f161b;
            }
            if (i2 == cVar2.c) {
                cVar2 = cVar2.f;
                i2 = cVar2.f161b;
            }
            j2 += jMin;
        }
        return true;
    }

    public final b f() {
        long j = this.f159b;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f159b);
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        c cVar = this.a;
        if (cVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = cVar.c;
            for (int i3 = cVar.f161b; i3 < i2; i3++) {
                i = (i * 31) + cVar.a[i3];
            }
            cVar = cVar.f;
        } while (cVar != this.a);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.a;
        if (cVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), cVar.c - cVar.f161b);
        byteBuffer.put(cVar.a, cVar.f161b, iMin);
        int i = cVar.f161b + iMin;
        cVar.f161b = i;
        this.f159b -= (long) iMin;
        if (i == cVar.c) {
            this.a = cVar.a();
            d.a(cVar);
        }
        return iMin;
    }

    public String toString() {
        return f().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            c cVarB = b(1);
            int iMin = Math.min(i, 8192 - cVarB.c);
            byteBuffer.get(cVarB.a, cVarB.c, iMin);
            i -= iMin;
            cVarB.c += iMin;
        }
        this.f159b += (long) iRemaining;
        return iRemaining;
    }

    public a c(int i) {
        c cVarB = b(1);
        byte[] bArr = cVarB.a;
        int i2 = cVarB.c;
        cVarB.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f159b++;
        return this;
    }

    public a b(long j) {
        if (j == 0) {
            return c(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        c cVarB = b(iNumberOfTrailingZeros);
        byte[] bArr = cVarB.a;
        int i = cVarB.c;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        cVarB.c += iNumberOfTrailingZeros;
        this.f159b += (long) iNumberOfTrailingZeros;
        return this;
    }

    public a d(int i) {
        if (i < 128) {
            c(i);
        } else if (i < 2048) {
            c((i >> 6) | 192);
            c((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                c(63);
            } else {
                c((i >> 12) | 224);
                c(((i >> 6) & 63) | 128);
                c((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            c((i >> 18) | 240);
            c(((i >> 12) & 63) | 128);
            c(((i >> 6) & 63) | 128);
            c((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public byte[] a(long j) throws EOFException {
        f.a(this.f159b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    c b(int i) {
        if (i >= 1 && i <= 8192) {
            c cVar = this.a;
            if (cVar == null) {
                c cVarA = d.a();
                this.a = cVarA;
                cVarA.g = cVarA;
                cVarA.f = cVarA;
                return cVarA;
            }
            c cVar2 = cVar.g;
            return (cVar2.c + i > 8192 || !cVar2.e) ? cVar2.a(d.a()) : cVar2;
        }
        throw new IllegalArgumentException();
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        f.a(bArr.length, i, i2);
        c cVar = this.a;
        if (cVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, cVar.c - cVar.f161b);
        System.arraycopy(cVar.a, cVar.f161b, bArr, i, iMin);
        int i3 = cVar.f161b + iMin;
        cVar.f161b = i3;
        this.f159b -= (long) iMin;
        if (i3 == cVar.c) {
            this.a = cVar.a();
            d.a(cVar);
        }
        return iMin;
    }

    public a a(String str) {
        return a(str, 0, str.length());
    }

    public a a(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 128) {
                    c cVarB = b(1);
                    byte[] bArr = cVarB.a;
                    int i3 = cVarB.c - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt2;
                    while (true) {
                        i = i4;
                        if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) cCharAt;
                    }
                    int i5 = cVarB.c;
                    int i6 = (i3 + i) - i5;
                    cVarB.c = i5 + i6;
                    this.f159b += (long) i6;
                } else {
                    if (cCharAt2 < 2048) {
                        c((cCharAt2 >> 6) | 192);
                        c((cCharAt2 & '?') | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            c((i8 >> 18) | 240);
                            c(((i8 >> 12) & 63) | 128);
                            c(((i8 >> 6) & 63) | 128);
                            c((i8 & 63) | 128);
                            i += 2;
                        } else {
                            c(63);
                            i = i7;
                        }
                    } else {
                        c((cCharAt2 >> '\f') | 224);
                        c(((cCharAt2 >> 6) & 63) | 128);
                        c((cCharAt2 & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public a a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(f.a)) {
                    return a(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return b(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        if (this.f159b == 0) {
            return aVar;
        }
        c cVarB = this.a.b();
        aVar.a = cVarB;
        cVarB.g = cVarB;
        cVarB.f = cVarB;
        for (c cVar = this.a.f; cVar != this.a; cVar = cVar.f) {
            aVar.a.g.a(cVar.b());
        }
        aVar.f159b = this.f159b;
        return aVar;
    }

    public final b a(int i) {
        if (i == 0) {
            return b.f;
        }
        return new e(this, i);
    }
}
