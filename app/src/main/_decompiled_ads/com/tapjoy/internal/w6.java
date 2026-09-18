package com.tapjoy.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class w6 extends g0 {
    public final transient byte[][] f;
    public final transient int[] g;

    public w6(b0 b0Var, int i) {
        super(null);
        sa.a(b0Var.f2731b, 0L, i);
        u6 u6Var = b0Var.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = u6Var.c;
            int i6 = u6Var.f2820b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            u6Var = u6Var.f;
        }
        this.f = new byte[i4][];
        this.g = new int[i4 * 2];
        u6 u6Var2 = b0Var.a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f;
            bArr[i7] = u6Var2.a;
            int i8 = u6Var2.c;
            int i9 = u6Var2.f2820b;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.g;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            u6Var2.d = true;
            i7++;
            u6Var2 = u6Var2.f;
        }
    }

    @Override // com.tapjoy.internal.g0
    public final String a() {
        return e().a();
    }

    @Override // com.tapjoy.internal.g0
    public final int b() {
        return this.g[this.f.length - 1];
    }

    @Override // com.tapjoy.internal.g0
    public final g0 c() {
        return e().c();
    }

    @Override // com.tapjoy.internal.g0
    public final String d() {
        return e().d();
    }

    public final g0 e() {
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return new g0(bArr2);
    }

    @Override // com.tapjoy.internal.g0
    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            if (g0Var.b() == b()) {
                int iB = b();
                if (b() - iB < 0) {
                    z = false;
                    break;
                }
                int iBinarySearch = Arrays.binarySearch(this.g, 0, this.f.length, 1);
                if (iBinarySearch < 0) {
                    iBinarySearch = ~iBinarySearch;
                }
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (iB <= 0) {
                        z = true;
                        break;
                    }
                    int i3 = iBinarySearch == 0 ? 0 : this.g[iBinarySearch - 1];
                    int iMin = Math.min(iB, ((this.g[iBinarySearch] - i3) + i3) - i2);
                    int[] iArr = this.g;
                    byte[][] bArr = this.f;
                    if (!g0Var.a(i, bArr[iBinarySearch], (i2 - i3) + iArr[bArr.length + iBinarySearch], iMin)) {
                        z = false;
                        break;
                    }
                    i2 += iMin;
                    i += iMin;
                    iB -= iMin;
                    iBinarySearch++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tapjoy.internal.g0
    public final int hashCode() {
        int i = this.f2757b;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f2757b = i3;
        return i3;
    }

    @Override // com.tapjoy.internal.g0
    public final String toString() {
        return e().toString();
    }

    @Override // com.tapjoy.internal.g0
    public final byte a(int i) {
        sa.a(this.g[this.f.length - 1], i, 1L);
        int iBinarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        if (iBinarySearch < 0) {
            iBinarySearch = ~iBinarySearch;
        }
        int i2 = iBinarySearch != 0 ? this.g[iBinarySearch - 1] : 0;
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        return bArr[iBinarySearch][(i - i2) + iArr[bArr.length + iBinarySearch]];
    }

    @Override // com.tapjoy.internal.g0
    public final void a(b0 b0Var) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            u6 u6Var = new u6(this.f[i], i3, (i3 + i4) - i2);
            u6 u6Var2 = b0Var.a;
            if (u6Var2 == null) {
                u6Var.g = u6Var;
                u6Var.f = u6Var;
                b0Var.a = u6Var;
            } else {
                u6 u6Var3 = u6Var2.g;
                u6Var3.getClass();
                u6Var.g = u6Var3;
                u6Var.f = u6Var3.f;
                u6Var3.f.g = u6Var;
                u6Var3.f = u6Var;
            }
            i++;
            i2 = i4;
        }
        b0Var.f2731b += (long) i2;
    }

    @Override // com.tapjoy.internal.g0
    public final boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > b() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iBinarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        if (iBinarySearch < 0) {
            iBinarySearch = ~iBinarySearch;
        }
        while (true) {
            boolean z = true;
            if (i3 <= 0) {
                return true;
            }
            int i4 = iBinarySearch == 0 ? 0 : this.g[iBinarySearch - 1];
            int iMin = Math.min(i3, ((this.g[iBinarySearch] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f;
            int i5 = (i - i4) + iArr[bArr2.length + iBinarySearch];
            byte[] bArr3 = bArr2[iBinarySearch];
            Charset charset = sa.a;
            for (int i6 = 0; i6 < iMin; i6++) {
                if (bArr3[i6 + i5] != bArr[i6 + i2]) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iBinarySearch++;
        }
    }
}
