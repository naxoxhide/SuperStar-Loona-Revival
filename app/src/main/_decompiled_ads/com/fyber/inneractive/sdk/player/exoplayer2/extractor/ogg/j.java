package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends h {
    public a n;
    public int o;
    public boolean p;
    public k.c q;
    public k.a r;

    public static final class a {
        public final k.c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f1116b;
        public final k.b[] c;
        public final int d;

        public a(k.c cVar, k.a aVar, byte[] bArr, k.b[] bVarArr, int i) {
            this.a = cVar;
            this.f1116b = bArr;
            this.c = bVarArr;
            this.d = i;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public void b(long j) {
        this.g = j;
        this.p = j != 0;
        k.c cVar = this.q;
        this.o = cVar != null ? cVar.d : 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public long a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        int i;
        byte[] bArr = kVar.a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        a aVar = this.n;
        if (!aVar.c[(b2 >> 1) & (255 >>> (8 - aVar.d))].a) {
            i = aVar.a.d;
        } else {
            i = aVar.a.e;
        }
        long j = this.p ? (this.o + i) / 4 : 0;
        kVar.d(kVar.c + 4);
        byte[] bArr2 = kVar.a;
        int i2 = kVar.c;
        bArr2[i2 - 4] = (byte) (j & 255);
        bArr2[i2 - 3] = (byte) ((j >>> 8) & 255);
        bArr2[i2 - 2] = (byte) ((j >>> 16) & 255);
        bArr2[i2 - 1] = (byte) ((j >>> 24) & 255);
        this.p = true;
        this.o = i;
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:163:0x042a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:165:0x042c  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, long j, h.a aVar) throws InterruptedException, IOException {
        a aVar2;
        int i;
        long jFloor;
        if (this.n != null) {
            return false;
        }
        if (this.q == null) {
            k.a(1, kVar, false);
            long jF = kVar.f();
            int iL = kVar.l();
            long jF2 = kVar.f();
            int iE = kVar.e();
            int iE2 = kVar.e();
            int iE3 = kVar.e();
            int iL2 = kVar.l();
            this.q = new k.c(jF, iL, jF2, iE, iE2, iE3, (int) Math.pow(2.0d, iL2 & 15), (int) Math.pow(2.0d, (iL2 & 240) >> 4), (kVar.l() & 1) > 0, Arrays.copyOf(kVar.a, kVar.c));
        } else {
            if (this.r == null) {
                k.a(3, kVar, false);
                String strB = kVar.b((int) kVar.f());
                int length = strB.length() + 11;
                long jF3 = kVar.f();
                String[] strArr = new String[(int) jF3];
                int length2 = length + 4;
                for (int i2 = 0; i2 < jF3; i2++) {
                    strArr[i2] = kVar.b((int) kVar.f());
                    length2 = length2 + 4 + strArr[i2].length();
                }
                if ((kVar.l() & 1) != 0) {
                    this.r = new k.a(strB, strArr, length2 + 1);
                } else {
                    throw new l("framing bit expected to be set");
                }
            } else {
                int i3 = kVar.c;
                byte[] bArr = new byte[i3];
                int i4 = 0;
                System.arraycopy(kVar.a, 0, bArr, 0, i3);
                int i5 = this.q.a;
                int i6 = 5;
                k.a(5, kVar, false);
                int iL3 = kVar.l() + 1;
                i iVar = new i(kVar.a);
                iVar.b(kVar.f1236b * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 16;
                    if (i7 < iL3) {
                        if (iVar.a(24) == 5653314) {
                            int iA = iVar.a(16);
                            int iA2 = iVar.a(24);
                            long[] jArr = new long[iA2];
                            long j2 = 0;
                            if (!iVar.a()) {
                                boolean zA = iVar.a();
                                while (i4 < iA2) {
                                    if (zA) {
                                        if (iVar.a()) {
                                            jArr[i4] = iVar.a(5) + 1;
                                        } else {
                                            jArr[i4] = 0;
                                        }
                                    } else {
                                        jArr[i4] = iVar.a(5) + 1;
                                    }
                                    i4++;
                                    iA = iA;
                                }
                                i = iA;
                            } else {
                                i = iA;
                                int iA3 = iVar.a(5) + 1;
                                int i9 = 0;
                                while (i9 < iA2) {
                                    int iA4 = iVar.a(k.a(iA2 - i9));
                                    int i10 = i9;
                                    int i11 = 0;
                                    while (i11 < iA4 && i10 < iA2) {
                                        jArr[i10] = iA3;
                                        i10++;
                                        i11++;
                                        iA2 = iA2;
                                    }
                                    iA3++;
                                    i9 = i10;
                                    iA2 = iA2;
                                }
                            }
                            int i12 = iA2;
                            int iA5 = iVar.a(4);
                            if (iA5 > 2) {
                                throw new l("lookup type greater than 2 not decodable: " + iA5);
                            }
                            if (iA5 == 1 || iA5 == 2) {
                                iVar.b(32);
                                iVar.b(32);
                                int iA6 = iVar.a(4) + 1;
                                iVar.b(1);
                                if (iA5 == 1) {
                                    if (i != 0) {
                                        jFloor = (long) Math.floor(Math.pow(i12, 1.0d / ((double) i)));
                                    }
                                    iVar.b((int) (((long) iA6) * j2));
                                } else {
                                    jFloor = i12 * i;
                                }
                                j2 = jFloor;
                                iVar.b((int) (((long) iA6) * j2));
                            }
                            i7++;
                            i4 = 0;
                        } else {
                            throw new l("expected code book to start with [0x56, 0x43, 0x42] at " + ((iVar.c * 8) + iVar.d));
                        }
                    } else {
                        int i13 = 6;
                        int iA7 = iVar.a(6) + 1;
                        for (int i14 = 0; i14 < iA7; i14++) {
                            if (iVar.a(16) != 0) {
                                throw new l("placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int i15 = 1;
                        int iA8 = iVar.a(6) + 1;
                        int i16 = 0;
                        while (i16 < iA8) {
                            int iA9 = iVar.a(i8);
                            if (iA9 == 0) {
                                int i17 = 8;
                                iVar.b(8);
                                iVar.b(16);
                                iVar.b(16);
                                iVar.b(6);
                                iVar.b(8);
                                int iA10 = iVar.a(4) + 1;
                                int i18 = 0;
                                while (i18 < iA10) {
                                    iVar.b(i17);
                                    i18++;
                                    i17 = 8;
                                }
                            } else if (iA9 == i15) {
                                int iA11 = iVar.a(i6);
                                int[] iArr = new int[iA11];
                                int i19 = -1;
                                for (int i20 = 0; i20 < iA11; i20++) {
                                    iArr[i20] = iVar.a(4);
                                    if (iArr[i20] > i19) {
                                        i19 = iArr[i20];
                                    }
                                }
                                int i21 = i19 + 1;
                                int[] iArr2 = new int[i21];
                                for (int i22 = 0; i22 < i21; i22++) {
                                    int i23 = 1;
                                    iArr2[i22] = iVar.a(3) + 1;
                                    int iA12 = iVar.a(2);
                                    int i24 = 8;
                                    if (iA12 > 0) {
                                        iVar.b(8);
                                    }
                                    int i25 = 0;
                                    while (i25 < (i23 << iA12)) {
                                        iVar.b(i24);
                                        i25++;
                                        i23 = 1;
                                        i24 = 8;
                                    }
                                }
                                iVar.b(2);
                                int iA13 = iVar.a(4);
                                int i26 = 0;
                                int i27 = 0;
                                for (int i28 = 0; i28 < iA11; i28++) {
                                    i26 += iArr2[iArr[i28]];
                                    while (i27 < i26) {
                                        iVar.b(iA13);
                                        i27++;
                                    }
                                }
                            } else {
                                throw new l("floor type greater than 1 not decodable: " + iA9);
                            }
                            i16++;
                            i13 = 6;
                            i6 = 5;
                            i15 = 1;
                            i8 = 16;
                        }
                        int i29 = 1;
                        int iA14 = iVar.a(i13) + 1;
                        int i30 = 0;
                        while (i30 < iA14) {
                            if (iVar.a(16) <= 2) {
                                iVar.b(24);
                                iVar.b(24);
                                iVar.b(24);
                                int iA15 = iVar.a(i13) + i29;
                                int i31 = 8;
                                iVar.b(8);
                                int[] iArr3 = new int[iA15];
                                for (int i32 = 0; i32 < iA15; i32++) {
                                    iArr3[i32] = ((iVar.a() ? iVar.a(5) : 0) * 8) + iVar.a(3);
                                }
                                int i33 = 0;
                                while (i33 < iA15) {
                                    int i34 = 0;
                                    while (i34 < i31) {
                                        if ((iArr3[i33] & (1 << i34)) != 0) {
                                            iVar.b(i31);
                                        }
                                        i34++;
                                        i31 = 8;
                                    }
                                    i33++;
                                    i31 = 8;
                                }
                                i30++;
                                i13 = 6;
                                i29 = 1;
                            } else {
                                throw new l("residueType greater than 2 is not decodable");
                            }
                        }
                        int iA16 = iVar.a(i13) + 1;
                        for (int i35 = 0; i35 < iA16; i35++) {
                            int iA17 = iVar.a(16);
                            if (iA17 != 0) {
                                Log.e("VorbisUtil", "mapping type other than 0 not supported: " + iA17);
                            } else {
                                int iA18 = iVar.a() ? iVar.a(4) + 1 : 1;
                                if (iVar.a()) {
                                    int iA19 = iVar.a(8) + 1;
                                    for (int i36 = 0; i36 < iA19; i36++) {
                                        int i37 = i5 - 1;
                                        iVar.b(k.a(i37));
                                        iVar.b(k.a(i37));
                                    }
                                }
                                if (iVar.a(2) != 0) {
                                    throw new l("to reserved bits must be zero after mapping coupling steps");
                                }
                                if (iA18 > 1) {
                                    for (int i38 = 0; i38 < i5; i38++) {
                                        iVar.b(4);
                                    }
                                }
                                for (int i39 = 0; i39 < iA18; i39++) {
                                    iVar.b(8);
                                    iVar.b(8);
                                    iVar.b(8);
                                }
                            }
                        }
                        int iA20 = iVar.a(6) + 1;
                        k.b[] bVarArr = new k.b[iA20];
                        for (int i40 = 0; i40 < iA20; i40++) {
                            bVarArr[i40] = new k.b(iVar.a(), iVar.a(16), iVar.a(16), iVar.a(8));
                        }
                        if (iVar.a()) {
                            aVar2 = new a(this.q, this.r, bArr, bVarArr, k.a(iA20 - 1));
                            break;
                        }
                        throw new l("framing bit after modes not set as expected");
                    }
                }
            }
            this.n = aVar2;
            if (aVar2 == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.n.a.f);
            arrayList.add(this.n.f1116b);
            k.c cVar = this.n.a;
            aVar.a = com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "audio/vorbis", (String) null, cVar.c, -1, cVar.a, (int) cVar.f1117b, -1, arrayList, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null);
            return true;
        }
        aVar2 = null;
        this.n = aVar2;
        if (aVar2 == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.n.a.f);
        arrayList2.add(this.n.f1116b);
        k.c cVar2 = this.n.a;
        aVar.a = com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "audio/vorbis", (String) null, cVar2.c, -1, cVar2.a, (int) cVar2.f1117b, -1, arrayList2, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null);
        return true;
    }
}
