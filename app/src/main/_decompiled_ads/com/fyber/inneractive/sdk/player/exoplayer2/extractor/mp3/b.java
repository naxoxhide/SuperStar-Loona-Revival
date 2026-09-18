package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements f {
    public static final int m = u.a("Xing");
    public static final int n = u.a("Info");
    public static final int o = u.a("VBRI");
    public final long a;
    public h e;
    public n f;
    public int g;
    public com.fyber.inneractive.sdk.player.exoplayer2.metadata.a h;
    public a i;
    public long k;
    public int l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f1090b = new k(10);
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.k c = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.k();
    public final j d = new j();
    public long j = -9223372036854775807L;

    public interface a extends m {
        long b(long j);
    }

    public b(int i, long j) {
        this.a = j;
    }

    public static boolean a(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(g gVar) throws InterruptedException, IOException {
        return a(gVar, true);
    }

    public final a b(g gVar) throws InterruptedException, IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.a(this.f1090b.a, 0, 4, false);
        this.f1090b.e(0);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(this.f1090b.c(), this.c);
        return new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.a(bVar.c, this.c.f, bVar.f1057b);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(h hVar) {
        this.e = hVar;
        this.f = hVar.a(0, 1);
        this.e.c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        this.g = 0;
        this.j = -9223372036854775807L;
        this.k = 0L;
        this.l = 0;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003f  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x006b  */
    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(g gVar, l lVar) throws InterruptedException, IOException {
        g gVar2;
        int i;
        int i2;
        int iC;
        int iC2;
        int i3;
        int iO;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
        int iL;
        if (this.g == 0) {
            try {
                a(gVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.i == null) {
            k kVar = new k(this.c.c);
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
            bVar2.a(kVar.a, 0, this.c.c, false);
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k kVar2 = this.c;
            if ((kVar2.a & 1) != 0) {
                if (kVar2.e != 1) {
                    i2 = 36;
                } else {
                    i2 = 21;
                }
            } else if (kVar2.e != 1) {
                i2 = 21;
            } else {
                i2 = 13;
            }
            if (kVar.c >= i2 + 4) {
                kVar.e(i2);
                iC = kVar.c();
                if (iC != m && iC != n) {
                    if (kVar.c >= 40) {
                        kVar.e(36);
                        iC2 = kVar.c();
                        i3 = o;
                        if (iC2 == i3) {
                            iC = i3;
                        } else {
                            iC = 0;
                        }
                    } else {
                        iC = 0;
                    }
                }
            } else if (kVar.c >= 40) {
                kVar.e(36);
                iC2 = kVar.c();
                i3 = o;
                if (iC2 == i3) {
                    iC = i3;
                } else {
                    iC = 0;
                }
            } else {
                iC = 0;
            }
            a aVarB = null;
            if (iC != m && iC != n) {
                if (iC == o) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.k kVar3 = this.c;
                    long j = bVar2.c;
                    long j2 = bVar2.f1057b;
                    kVar.f(10);
                    int iC3 = kVar.c();
                    if (iC3 > 0) {
                        int i4 = kVar3.d;
                        bVar = bVar2;
                        long jA = u.a(iC3, ((long) (i4 >= 32000 ? 1152 : 576)) * 1000000, i4);
                        int iQ = kVar.q();
                        int iQ2 = kVar.q();
                        int iQ3 = kVar.q();
                        kVar.f(2);
                        long j3 = j + ((long) kVar3.c);
                        int i5 = iQ + 1;
                        long[] jArr = new long[i5];
                        long[] jArr2 = new long[i5];
                        jArr[0] = 0;
                        jArr2[0] = j3;
                        int i6 = 1;
                        while (true) {
                            if (i6 < i5) {
                                int i7 = i5;
                                if (iQ3 == 1) {
                                    iL = kVar.l();
                                } else if (iQ3 == 2) {
                                    iL = kVar.q();
                                } else if (iQ3 != 3) {
                                    if (iQ3 != 4) {
                                        break;
                                    }
                                    iL = kVar.o();
                                } else {
                                    iL = kVar.n();
                                }
                                int i8 = iQ2;
                                j3 += (long) (iL * iQ2);
                                k kVar4 = kVar;
                                jArr[i6] = (((long) i6) * jA) / ((long) iQ);
                                jArr2[i6] = j2 == -1 ? j3 : Math.min(j2, j3);
                                i6++;
                                i5 = i7;
                                iQ2 = i8;
                                kVar = kVar4;
                            } else {
                                aVarB = new c(jArr, jArr2, jA);
                                break;
                            }
                        }
                    } else {
                        bVar = bVar2;
                    }
                    bVar.c(this.c.c);
                } else {
                    bVar2.e = 0;
                }
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.k kVar5 = this.c;
                long j4 = bVar2.c;
                long j5 = bVar2.f1057b;
                int i9 = kVar5.g;
                int i10 = kVar5.d;
                long j6 = j4 + ((long) kVar5.c);
                int iC4 = kVar.c();
                if ((iC4 & 1) == 1 && (iO = kVar.o()) != 0) {
                    long jA2 = u.a(iO, ((long) i9) * 1000000, i10);
                    if ((iC4 & 6) != 6) {
                        aVarB = new d(j6, jA2, j5, null, 0L, 0);
                    } else {
                        long jO = kVar.o();
                        kVar.f(1);
                        long[] jArr3 = new long[99];
                        for (int i11 = 0; i11 < 99; i11++) {
                            jArr3[i11] = kVar.l();
                        }
                        aVarB = new d(j6, jA2, j5, jArr3, jO, kVar5.c);
                    }
                }
                if (aVarB != null && !this.d.a()) {
                    bVar2.e = 0;
                    bVar2.a(i2 + 141, false);
                    bVar2.a(this.f1090b.a, 0, 3, false);
                    this.f1090b.e(0);
                    j jVar = this.d;
                    int iN = this.f1090b.n();
                    jVar.getClass();
                    int i12 = iN >> 12;
                    int i13 = iN & 4095;
                    if (i12 > 0 || i13 > 0) {
                        jVar.a = i12;
                        jVar.f1081b = i13;
                    }
                }
                bVar2.c(this.c.c);
                if (aVarB != null && !aVarB.a() && iC == n) {
                    aVarB = b(gVar);
                }
            }
            a aVar = aVarB;
            this.i = aVar;
            if (aVar != null) {
                aVar.a();
            } else {
                this.i = b(gVar);
            }
            this.e.a(this.i);
            n nVar = this.f;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k kVar6 = this.c;
            String str = kVar6.f1082b;
            int i14 = kVar6.e;
            int i15 = kVar6.d;
            j jVar2 = this.d;
            nVar.a(i.a((String) null, str, (String) null, -1, 4096, i14, i15, -1, jVar2.a, jVar2.f1081b, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null, this.h));
        }
        if (this.l == 0) {
            gVar2 = gVar;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2;
            bVar3.e = 0;
            if (bVar3.a(this.f1090b.a, 0, 4, true)) {
                this.f1090b.e(0);
                int iC5 = this.f1090b.c();
                if (a(iC5, this.g) && com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(iC5) != -1) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(iC5, this.c);
                    if (this.j == -9223372036854775807L) {
                        this.j = this.i.b(bVar3.c);
                        if (this.a != -9223372036854775807L) {
                            this.j += this.a - this.i.b(0L);
                        }
                    }
                    this.l = this.c.c;
                } else {
                    bVar3.c(1);
                    this.g = 0;
                }
                return 0;
            }
            i = -1;
            return i;
        }
        gVar2 = gVar;
        int iA = this.f.a(gVar2, this.l, true);
        i = -1;
        if (iA != -1) {
            int i16 = this.l - iA;
            this.l = i16;
            if (i16 <= 0) {
                long j7 = this.j;
                long j8 = this.k * 1000000;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.k kVar7 = this.c;
                this.f.a(j7 + (j8 / ((long) kVar7.d)), 1, kVar7.c, 0, null);
                this.k += (long) this.c.g;
                this.l = 0;
                return 0;
            }
            return 0;
        }
        return i;
    }

    public final boolean a(g gVar, boolean z) throws InterruptedException, IOException {
        int i;
        int i2;
        int iA;
        int i3 = z ? 16384 : 131072;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.e = 0;
        if (bVar.c == 0) {
            int i4 = 0;
            while (true) {
                bVar.a(this.f1090b.a, 0, 10, false);
                this.f1090b.e(0);
                if (this.f1090b.n() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.f1168b) {
                    break;
                }
                this.f1090b.f(3);
                int iK = this.f1090b.k();
                int i5 = iK + 10;
                if (this.h == null) {
                    byte[] bArr = new byte[i5];
                    System.arraycopy(this.f1090b.a, 0, bArr, 0, 10);
                    bVar.a(bArr, 10, iK, false);
                    com.fyber.inneractive.sdk.player.exoplayer2.metadata.a aVarA = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g(null).a(bArr, i5);
                    this.h = aVarA;
                    if (aVarA != null) {
                        this.d.a(aVarA);
                    }
                } else {
                    bVar.a(iK, false);
                }
                i4 += i5;
            }
            bVar.e = 0;
            bVar.a(i4, false);
            i = (int) (bVar.c + ((long) bVar.e));
            if (!z) {
                bVar.c(i);
            }
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i6 = i2;
        int i7 = i6;
        while (true) {
            if (!bVar.a(this.f1090b.a, 0, 4, i2 > 0)) {
                break;
            }
            this.f1090b.e(0);
            int iC = this.f1090b.c();
            if ((i6 == 0 || a(iC, i6)) && (iA = com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(iC)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(iC, this.c);
                    i6 = iC;
                }
                bVar.a(iA - 4, false);
            } else {
                int i8 = i7 + 1;
                if (i7 == i3) {
                    if (z) {
                        return false;
                    }
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Searched too many bytes.");
                }
                if (z) {
                    bVar.e = 0;
                    bVar.a(i + i8, false);
                } else {
                    bVar.c(1);
                }
                i6 = 0;
                i7 = i8;
                i2 = 0;
            }
        }
        if (z) {
            bVar.c(i + i7);
        } else {
            bVar.e = 0;
        }
        this.g = i6;
        return true;
    }
}
