package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements b {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1215b;
    public final byte[] c;
    public final a[] d;
    public int e;
    public int f;
    public int g;
    public a[] h;

    public k(boolean z, int i, int i2) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i > 0);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i2 >= 0);
        this.a = z;
        this.f1215b = i;
        this.g = i2;
        this.h = new a[i2 + 100];
        if (i2 > 0) {
            this.c = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.h[i3] = new a(this.c, i3 * i);
            }
        } else {
            this.c = null;
        }
        this.d = new a[1];
    }

    public synchronized void a(a[] aVarArr) {
        int i = this.g;
        int length = aVarArr.length + i;
        a[] aVarArr2 = this.h;
        if (length >= aVarArr2.length) {
            this.h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            byte[] bArr = aVar.a;
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(bArr == this.c || bArr.length == this.f1215b);
            a[] aVarArr3 = this.h;
            int i2 = this.g;
            this.g = i2 + 1;
            aVarArr3[i2] = aVar;
        }
        this.f -= aVarArr.length;
        notifyAll();
    }

    public synchronized void b() {
        int i = 0;
        int iMax = Math.max(0, com.fyber.inneractive.sdk.player.exoplayer2.util.u.a(this.e, this.f1215b) - this.f);
        int i2 = this.g;
        if (iMax >= i2) {
            return;
        }
        if (this.c != null) {
            int i3 = i2 - 1;
            while (i <= i3) {
                a[] aVarArr = this.h;
                a aVar = aVarArr[i];
                byte[] bArr = aVar.a;
                byte[] bArr2 = this.c;
                if (bArr == bArr2) {
                    i++;
                } else {
                    a aVar2 = aVarArr[i3];
                    if (aVar2.a != bArr2) {
                        i3--;
                    } else {
                        aVarArr[i] = aVar2;
                        aVarArr[i3] = aVar;
                        i3--;
                        i++;
                    }
                }
            }
            iMax = Math.max(iMax, i);
            if (iMax >= this.g) {
                return;
            }
        }
        Arrays.fill(this.h, iMax, this.g, (Object) null);
        this.g = iMax;
    }

    public int a() {
        return this.f1215b;
    }
}
