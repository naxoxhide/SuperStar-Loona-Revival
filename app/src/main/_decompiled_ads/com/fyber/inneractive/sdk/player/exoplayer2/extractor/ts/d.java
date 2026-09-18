package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements h {
    public static final byte[] r = {73, 68, 51};
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.j f1121b = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(new byte[7]);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k c = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(Arrays.copyOf(r, 10));
    public final String d;
    public String e;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n f;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n p;
    public long q;

    public d(boolean z, String str) {
        c();
        this.a = z;
        this.d = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void b() {
    }

    public final void c() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        dVar.a();
        this.e = dVar.b();
        this.f = hVar.a(dVar.c(), 1);
        if (!this.a) {
            this.g = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.e();
            return;
        }
        dVar.a();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVarA = hVar.a(dVar.c(), 4);
        this.g = nVarA;
        nVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(dVar.b(), "application/id3", null, -1, null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(long j, boolean z) {
        this.o = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        while (kVar.a() > 0) {
            int i = this.h;
            if (i == 0) {
                byte[] bArr = kVar.a;
                int i2 = kVar.f1236b;
                int i3 = kVar.c;
                while (true) {
                    if (i2 < i3) {
                        int i4 = i2 + 1;
                        int i5 = bArr[i2] & 255;
                        int i6 = this.j;
                        if (i6 == 512 && i5 >= 240 && i5 != 255) {
                            this.k = (i5 & 1) == 0;
                            this.h = 2;
                            this.i = 0;
                            kVar.e(i4);
                            break;
                        }
                        int i7 = i5 | i6;
                        if (i7 == 329) {
                            this.j = 768;
                        } else if (i7 == 511) {
                            this.j = 512;
                        } else if (i7 == 836) {
                            this.j = 1024;
                        } else {
                            if (i7 == 1075) {
                                this.h = 1;
                                this.i = r.length;
                                this.n = 0;
                                this.c.e(0);
                                kVar.e(i4);
                                break;
                            }
                            if (i6 != 256) {
                                this.j = 256;
                                i2 = i4 - 1;
                            }
                        }
                        i2 = i4;
                    } else {
                        kVar.e(i2);
                        break;
                    }
                }
            } else if (i != 1) {
                if (i == 2) {
                    if (a(kVar, this.f1121b.a, this.k ? 7 : 5)) {
                        this.f1121b.b(0);
                        if (!this.l) {
                            int iA = this.f1121b.a(2) + 1;
                            if (iA != 2) {
                                Log.w("AdtsReader", "Detected audio object type: " + iA + ", but assuming AAC LC.");
                                iA = 2;
                            }
                            int iA2 = this.f1121b.a(4);
                            this.f1121b.c(1);
                            byte[] bArr2 = {(byte) (((iA << 3) & 248) | ((iA2 >> 1) & 7)), (byte) (((iA2 << 7) & 128) | ((this.f1121b.a(3) << 3) & 120))};
                            Pair<Integer, Integer> pairA = com.fyber.inneractive.sdk.player.exoplayer2.util.c.a(bArr2);
                            com.fyber.inneractive.sdk.player.exoplayer2.i iVarA = com.fyber.inneractive.sdk.player.exoplayer2.i.a(this.e, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) pairA.second).intValue(), ((Integer) pairA.first).intValue(), -1, (List<byte[]>) Collections.singletonList(bArr2), (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, this.d);
                            this.m = 1024000000 / ((long) iVarA.s);
                            this.f.a(iVarA);
                            this.l = true;
                        } else {
                            this.f1121b.c(10);
                        }
                        this.f1121b.c(4);
                        int iA3 = (this.f1121b.a(13) - 2) - 5;
                        if (this.k) {
                            iA3 -= 2;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar = this.f;
                        long j = this.m;
                        this.h = 3;
                        this.i = 0;
                        this.p = nVar;
                        this.q = j;
                        this.n = iA3;
                    }
                } else if (i == 3) {
                    int iMin = Math.min(kVar.a(), this.n - this.i);
                    this.p.a(kVar, iMin);
                    int i8 = this.i + iMin;
                    this.i = i8;
                    int i9 = this.n;
                    if (i8 == i9) {
                        this.p.a(this.o, 1, i9, 0, null);
                        this.o += this.q;
                        c();
                    }
                }
            } else if (a(kVar, this.c.a, 10)) {
                this.g.a(this.c, 10);
                this.c.e(6);
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar2 = this.g;
                int iK = this.c.k() + 10;
                this.h = 3;
                this.i = 10;
                this.p = nVar2;
                this.q = 0L;
                this.n = iK;
            }
        }
    }

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, byte[] bArr, int i) {
        int iMin = Math.min(kVar.a(), i - this.i);
        System.arraycopy(kVar.a, kVar.f1236b, bArr, this.i, iMin);
        kVar.f1236b += iMin;
        int i2 = this.i + iMin;
        this.i = i2;
        return i2 == i;
    }
}
