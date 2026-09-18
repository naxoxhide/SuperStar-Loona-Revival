package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements v {
    public final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k f1138b = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(32);
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public r(q qVar) {
        this.a = qVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        this.a.a(rVar, hVar, dVar);
        this.f = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public void a() {
        this.f = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, boolean z) {
        int iL = z ? kVar.f1236b + kVar.l() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            kVar.e(iL);
            this.d = 0;
        }
        while (kVar.a() > 0) {
            int i = this.d;
            if (i < 3) {
                if (i == 0) {
                    int iL2 = kVar.l();
                    kVar.e(kVar.f1236b - 1);
                    if (iL2 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(kVar.a(), 3 - this.d);
                kVar.a(this.f1138b.a, this.d, iMin);
                int i2 = this.d + iMin;
                this.d = i2;
                if (i2 == 3) {
                    this.f1138b.c(3);
                    this.f1138b.f(1);
                    int iL3 = this.f1138b.l();
                    int iL4 = this.f1138b.l();
                    this.e = (iL3 & 128) != 0;
                    this.c = (((iL3 & 15) << 8) | iL4) + 3;
                    int iB = this.f1138b.b();
                    int i3 = this.c;
                    if (iB < i3) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = this.f1138b;
                        byte[] bArr = kVar2.a;
                        kVar2.c(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i3, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f1138b.a, 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(kVar.a(), this.c - this.d);
                kVar.a(this.f1138b.a, this.d, iMin2);
                int i4 = this.d + iMin2;
                this.d = i4;
                int i5 = this.c;
                if (i4 != i5) {
                    continue;
                } else {
                    if (this.e) {
                        byte[] bArr2 = this.f1138b.a;
                        int i6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a;
                        int i7 = -1;
                        for (int i8 = 0; i8 < i5; i8++) {
                            i7 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.h[((i7 >>> 24) ^ (bArr2[i8] & 255)) & 255] ^ (i7 << 8);
                        }
                        if (i7 != 0) {
                            this.f = true;
                            return;
                        }
                        this.f1138b.c(this.c - 4);
                    } else {
                        this.f1138b.c(i5);
                    }
                    this.a.a(this.f1138b);
                    this.d = 0;
                }
            }
        }
    }
}
