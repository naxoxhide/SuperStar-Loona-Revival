package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements h {
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.k f1133b;
    public final String c;
    public String d;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n e;
    public int f = 0;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public m(String str) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(4);
        this.a = kVar;
        kVar.a[0] = -1;
        this.f1133b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.k();
        this.c = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        this.f = 0;
        this.g = 0;
        this.i = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = hVar.a(dVar.c(), 1);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(long j, boolean z) {
        this.l = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        while (kVar.a() > 0) {
            int i = this.f;
            if (i == 0) {
                byte[] bArr = kVar.a;
                int i2 = kVar.f1236b;
                int i3 = kVar.c;
                while (true) {
                    if (i2 < i3) {
                        boolean z = (bArr[i2] & 255) == 255;
                        boolean z2 = this.i && (bArr[i2] & 224) == 224;
                        this.i = z;
                        if (z2) {
                            kVar.e(i2 + 1);
                            this.i = false;
                            this.a.a[1] = bArr[i2];
                            this.g = 2;
                            this.f = 1;
                            break;
                        }
                        i2++;
                    } else {
                        kVar.e(i3);
                        break;
                    }
                }
            } else if (i == 1) {
                int iMin = Math.min(kVar.a(), 4 - this.g);
                kVar.a(this.a.a, this.g, iMin);
                int i4 = this.g + iMin;
                this.g = i4;
                if (i4 >= 4) {
                    this.a.e(0);
                    if (!com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(this.a.c(), this.f1133b)) {
                        this.g = 0;
                        this.f = 1;
                    } else {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.k kVar2 = this.f1133b;
                        this.k = kVar2.c;
                        if (!this.h) {
                            long j = ((long) kVar2.g) * 1000000;
                            int i5 = kVar2.d;
                            this.j = j / ((long) i5);
                            this.e.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(this.d, kVar2.f1082b, (String) null, -1, 4096, kVar2.e, i5, -1, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, this.c));
                            this.h = true;
                        }
                        this.a.e(0);
                        this.e.a(this.a, 4);
                        this.f = 2;
                    }
                }
            } else if (i == 2) {
                int iMin2 = Math.min(kVar.a(), this.k - this.g);
                this.e.a(kVar, iMin2);
                int i6 = this.g + iMin2;
                this.g = i6;
                int i7 = this.k;
                if (i6 >= i7) {
                    this.e.a(this.l, 1, i7, 0, null);
                    this.l += this.j;
                    this.g = 0;
                    this.f = 0;
                }
            }
        }
    }
}
