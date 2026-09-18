package b.b.a.a.f.a.q;

import java.util.Arrays;

/* JADX INFO: compiled from: SegmentedByteString.java */
/* JADX INFO: loaded from: classes.dex */
final class e extends b {
    final transient byte[][] g;
    final transient int[] h;

    e(a aVar, int i) {
        super(null);
        f.a(aVar.f159b, 0L, i);
        c cVar = aVar.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = cVar.c;
            int i6 = cVar.f161b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            cVar = cVar.f;
        }
        this.g = new byte[i4][];
        this.h = new int[i4 * 2];
        c cVar2 = aVar.a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.g;
            bArr[i7] = cVar2.a;
            int i8 = cVar2.c;
            int i9 = cVar2.f161b;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.h;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            cVar2.d = true;
            i7++;
            cVar2 = cVar2.f;
        }
    }

    private b f() {
        return new b(e());
    }

    @Override // b.b.a.a.f.a.q.b
    public b a(int i, int i2) {
        return f().a(i, i2);
    }

    @Override // b.b.a.a.f.a.q.b
    public String b() {
        return f().b();
    }

    @Override // b.b.a.a.f.a.q.b
    public int c() {
        return this.h[this.g.length - 1];
    }

    @Override // b.b.a.a.f.a.q.b
    public String d() {
        return f().d();
    }

    public byte[] e() {
        int[] iArr = this.h;
        byte[][] bArr = this.g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.h;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.g[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // b.b.a.a.f.a.q.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.c() == c() && a(0, bVar, 0, c())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.b.a.a.f.a.q.b
    public int hashCode() {
        int i = this.f160b;
        if (i != 0) {
            return i;
        }
        int length = this.g.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.g[i2];
            int[] iArr = this.h;
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
        this.f160b = i3;
        return i3;
    }

    @Override // b.b.a.a.f.a.q.b
    public String toString() {
        return f().toString();
    }

    private int b(int i) {
        int iBinarySearch = Arrays.binarySearch(this.h, 0, this.g.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // b.b.a.a.f.a.q.b
    public byte a(int i) {
        f.a(this.h[this.g.length - 1], i, 1L);
        int iB = b(i);
        int i2 = iB == 0 ? 0 : this.h[iB - 1];
        int[] iArr = this.h;
        byte[][] bArr = this.g;
        return bArr[iB][(i - i2) + iArr[bArr.length + iB]];
    }

    public boolean a(int i, b bVar, int i2, int i3) {
        if (i < 0 || i > c() - i3) {
            return false;
        }
        int iB = b(i);
        while (i3 > 0) {
            int i4 = iB == 0 ? 0 : this.h[iB - 1];
            int iMin = Math.min(i3, ((this.h[iB] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr = this.g;
            if (!bVar.a(i2, bArr[iB], (i - i4) + iArr[bArr.length + iB], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iB++;
        }
        return true;
    }

    @Override // b.b.a.a.f.a.q.b
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iB = b(i);
        while (i3 > 0) {
            int i4 = iB == 0 ? 0 : this.h[iB - 1];
            int iMin = Math.min(i3, ((this.h[iB] - i4) + i4) - i);
            int[] iArr = this.h;
            byte[][] bArr2 = this.g;
            if (!f.a(bArr2[iB], (i - i4) + iArr[bArr2.length + iB], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iB++;
        }
        return true;
    }
}
