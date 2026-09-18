package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements h {
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k f1119b;
    public final String c;
    public String d;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n e;
    public int f = 0;
    public int g;
    public boolean h;
    public long i;
    public com.fyber.inneractive.sdk.player.exoplayer2.i j;
    public int k;
    public long l;

    public b(String str) {
        byte[] bArr = new byte[8];
        this.a = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(bArr);
        this.f1119b = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(bArr);
        this.c = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        int iA;
        int i;
        String str;
        int i2;
        int iA2;
        ?? r2;
        while (kVar.a() > 0) {
            int i3 = this.f;
            if (i3 == 0) {
                while (true) {
                    if (kVar.a() <= 0) {
                        r2 = false;
                        break;
                    }
                    if (!this.h) {
                        this.h = kVar.l() == 11;
                    } else {
                        int iL = kVar.l();
                        if (iL == 119) {
                            this.h = false;
                            r2 = true;
                            break;
                        }
                        this.h = iL == 11;
                    }
                }
                if (r2 != false) {
                    this.f = 1;
                    byte[] bArr = this.f1119b.a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.g = 2;
                }
            } else if (i3 == 1) {
                byte[] bArr2 = this.f1119b.a;
                int iMin = Math.min(kVar.a(), 8 - this.g);
                System.arraycopy(kVar.a, kVar.f1236b, bArr2, this.g, iMin);
                kVar.f1236b += iMin;
                int i4 = this.g + iMin;
                this.g = i4;
                if ((i4 == 8) != false) {
                    this.a.b(0);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.j jVar = this.a;
                    int i5 = (jVar.f1235b * 8) + jVar.c;
                    jVar.c(40);
                    ?? r8 = jVar.a(5) == 16;
                    jVar.b(i5);
                    int i6 = 6;
                    if (r8 != false) {
                        jVar.c(21);
                        iA2 = (jVar.a(11) + 1) * 2;
                        int iA3 = jVar.a(2);
                        if (iA3 == 3) {
                            i = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.c[jVar.a(2)];
                        } else {
                            i6 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a[jVar.a(2)];
                            i = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.f1038b[iA3];
                        }
                        i2 = i6 * 256;
                        iA = jVar.a(3);
                        str = "audio/eac3";
                    } else {
                        jVar.c(32);
                        int iA4 = jVar.a(2);
                        int iA5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a(iA4, jVar.a(6));
                        jVar.c(8);
                        iA = jVar.a(3);
                        if ((iA & 1) != 0 && iA != 1) {
                            jVar.c(2);
                        }
                        if ((iA & 4) != 0) {
                            jVar.c(2);
                        }
                        if (iA == 2) {
                            jVar.c(2);
                        }
                        i = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.f1038b[iA4];
                        str = "audio/ac3";
                        i2 = 1536;
                        iA2 = iA5;
                    }
                    int i7 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[iA] + (jVar.b() ? 1 : 0);
                    com.fyber.inneractive.sdk.player.exoplayer2.i iVar = this.j;
                    if (iVar == null || i7 != iVar.r || i != iVar.s || str != iVar.f) {
                        com.fyber.inneractive.sdk.player.exoplayer2.i iVarA = com.fyber.inneractive.sdk.player.exoplayer2.i.a(this.d, str, (String) null, -1, -1, i7, i, -1, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, this.c);
                        this.j = iVarA;
                        this.e.a(iVarA);
                    }
                    this.k = iA2;
                    this.i = (((long) i2) * 1000000) / ((long) this.j.s);
                    this.f1119b.e(0);
                    this.e.a(this.f1119b, 8);
                    this.f = 2;
                }
            } else if (i3 == 2) {
                int iMin2 = Math.min(kVar.a(), this.k - this.g);
                this.e.a(kVar, iMin2);
                int i8 = this.g + iMin2;
                this.g = i8;
                int i9 = this.k;
                if (i8 == i9) {
                    this.e.a(this.l, 1, i9, 0, null);
                    this.l += this.i;
                    this.f = 0;
                }
            }
        }
    }
}
