package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1134b;
    public boolean c;
    public byte[] d;
    public int e;

    public n(int i, int i2) {
        this.a = i;
        byte[] bArr = new byte[i2 + 3];
        this.d = bArr;
        bArr[2] = 1;
    }

    public void a() {
        this.f1134b = false;
        this.c = false;
    }

    public void b(int i) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!this.f1134b);
        boolean z = i == this.a;
        this.f1134b = z;
        if (z) {
            this.e = 3;
            this.c = false;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f1134b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i4 = this.e + i3;
            if (length < i4) {
                this.d = Arrays.copyOf(bArr2, i4 * 2);
            }
            System.arraycopy(bArr, i, this.d, this.e, i3);
            this.e += i3;
        }
    }

    public boolean a(int i) {
        if (!this.f1134b) {
            return false;
        }
        this.e -= i;
        this.f1134b = false;
        this.c = true;
        return true;
    }
}
