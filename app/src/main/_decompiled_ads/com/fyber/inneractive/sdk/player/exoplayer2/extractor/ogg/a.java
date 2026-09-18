package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {
    public final e a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1109b;
    public final long c;
    public final h d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.a$a, reason: collision with other inner class name */
    public class C0292a implements m {
        public C0292a() {
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
        public long a(long j) {
            if (j == 0) {
                return a.this.f1109b;
            }
            a aVar = a.this;
            long j2 = (((long) aVar.d.i) * j) / 1000000;
            long j3 = aVar.f1109b;
            long j4 = aVar.c;
            long j5 = (((j2 * (j4 - j3)) / aVar.f) - 30000) + j3;
            if (j5 >= j3) {
                j3 = j5;
            }
            return j3 >= j4 ? j4 - 1 : j3;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
        public boolean a() {
            return true;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.m
        public long c() {
            a aVar = a.this;
            return (aVar.f * 1000000) / ((long) aVar.d.i);
        }
    }

    public a(long j, long j2, h hVar, int i, long j3) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(j >= 0 && j2 > j);
        this.d = hVar;
        this.f1109b = j;
        this.c = j2;
        if (i != j2 - j) {
            this.e = 0;
        } else {
            this.f = j3;
            this.e = 3;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.f
    public long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        e eVar;
        long j;
        long jMin;
        int i;
        int i2 = this.e;
        if (i2 == 0) {
            long j2 = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c;
            this.g = j2;
            this.e = 1;
            long j3 = this.c - 65307;
            if (j3 > j2) {
                return j3;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j4 = this.h;
            long j5 = 0;
            if (j4 == 0) {
                i = 3;
            } else {
                long j6 = this.i;
                long j7 = this.j;
                if (j6 == j7) {
                    jMin = -(this.k + 2);
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                    long j8 = bVar.c;
                    if (a(gVar, j7)) {
                        this.a.a(gVar, false);
                        bVar.e = 0;
                        e eVar2 = this.a;
                        long j9 = eVar2.f1112b;
                        long j10 = j4 - j9;
                        int i3 = eVar2.d + eVar2.e;
                        if (j10 < 0 || j10 > 72000) {
                            if (j10 < 0) {
                                this.j = j8;
                                this.l = j9;
                            } else {
                                long j11 = i3;
                                long j12 = bVar.c + j11;
                                this.i = j12;
                                this.k = j9;
                                if ((this.j - j12) + j11 < 100000) {
                                    bVar.c(i3);
                                    j = this.k;
                                }
                            }
                            long j13 = this.j;
                            long j14 = this.i;
                            long j15 = j13 - j14;
                            if (j15 < 100000) {
                                this.j = j14;
                                jMin = j14;
                            } else {
                                jMin = Math.min(Math.max((bVar.c - ((long) (i3 * (j10 <= 0 ? 2 : 1)))) + ((j10 * j15) / (this.l - this.k)), j14), this.j - 1);
                            }
                        } else {
                            bVar.c(i3);
                            j = this.a.f1112b;
                        }
                        jMin = -(j + 2);
                    } else {
                        jMin = this.i;
                        if (jMin == j8) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (jMin >= 0) {
                    return jMin;
                }
                long j16 = this.h;
                this.a.a(gVar, false);
                j5 = -(jMin + 2);
                while (true) {
                    e eVar3 = this.a;
                    if (eVar3.f1112b >= j16) {
                        break;
                    }
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c(eVar3.d + eVar3.e);
                    e eVar4 = this.a;
                    j5 = eVar4.f1112b;
                    eVar4.a(gVar, false);
                }
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).e = 0;
                i = 3;
            }
            this.e = i;
            return -(j5 + 2);
        }
        if (!a(gVar, this.c)) {
            throw new EOFException();
        }
        this.a.a();
        while (true) {
            eVar = this.a;
            if ((eVar.a & 4) == 4) {
                break;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
            if (bVar2.c >= this.c) {
                break;
            }
            eVar.a(gVar, false);
            e eVar5 = this.a;
            bVar2.c(eVar5.d + eVar5.e);
        }
        this.f = eVar.f1112b;
        this.e = 3;
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.f
    public m b() {
        if (this.f != 0) {
            return new C0292a();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.f
    public long c(long j) {
        int i = this.e;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i == 3 || i == 2);
        long j2 = j == 0 ? 0L : (((long) this.d.i) * j) / 1000000;
        this.h = j2;
        this.e = 2;
        this.i = this.f1109b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
        return j2;
    }

    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, long j) throws InterruptedException, IOException {
        int i;
        long jMin = Math.min(j + 3, this.c);
        int i2 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
            int i3 = 0;
            if (bVar.c + ((long) i2) > jMin && (i2 = (int) (jMin - bVar.c)) < 4) {
                return false;
            }
            bVar.a(bArr, 0, i2, false);
            while (true) {
                i = i2 - 3;
                if (i3 < i) {
                    if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        bVar.c(i3);
                        return true;
                    }
                    i3++;
                }
            }
            bVar.c(i);
        }
    }
}
