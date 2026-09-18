package com.fyber.inneractive.sdk.player.exoplayer2.util;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1237b;
    public int c;
    public int d;

    public l(byte[] bArr, int i, int i2) {
        a(bArr, i, i2);
    }

    public void a(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.f1237b = i2;
        this.d = 0;
        a();
    }

    public int b(int i) {
        int i2;
        this.d += i;
        int i3 = 0;
        while (true) {
            i2 = this.d;
            int i4 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.d = i5;
            byte[] bArr = this.a;
            int i6 = this.c;
            i3 |= (bArr[i6] & 255) << i5;
            if (!c(i6 + 1)) {
                i4 = 1;
            }
            this.c = i6 + i4;
        }
        byte[] bArr2 = this.a;
        int i7 = this.c;
        int i8 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i7] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.d = 0;
            this.c = i7 + (c(i7 + 1) ? 2 : 1);
        }
        a();
        return i8;
    }

    public boolean c() {
        boolean z = (this.a[this.c] & (128 >> this.d)) != 0;
        f();
        return z;
    }

    public void d(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.c = i4;
        int i5 = this.d + (i - (i3 * 8));
        this.d = i5;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.c) {
                a();
                return;
            } else if (c(i2)) {
                this.c++;
                i2 += 2;
            }
        }
    }

    public int e() {
        int iD = d();
        return (iD % 2 == 0 ? -1 : 1) * ((iD + 1) / 2);
    }

    public void f() {
        int i = this.d + 1;
        this.d = i;
        if (i == 8) {
            this.d = 0;
            int i2 = this.c;
            this.c = i2 + (c(i2 + 1) ? 2 : 1);
        }
        a();
    }

    public final boolean c(int i) {
        if (2 <= i && i < this.f1237b) {
            byte[] bArr = this.a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f1237b) {
                break;
            }
            if (c(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.f1237b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public boolean b() {
        int i = this.c;
        int i2 = this.d;
        int i3 = 0;
        while (this.c < this.f1237b && !c()) {
            i3++;
        }
        boolean z = this.c == this.f1237b;
        this.c = i;
        this.d = i2;
        return !z && a((i3 * 2) + 1);
    }

    public final int d() {
        int i = 0;
        while (!c()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? b(i) : 0);
    }

    public final void a() {
        int i;
        int i2 = this.c;
        a.b(i2 >= 0 && (i2 < (i = this.f1237b) || (i2 == i && this.d == 0)));
    }
}
