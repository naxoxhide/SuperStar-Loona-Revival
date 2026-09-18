package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final byte[] a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f1232b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1233b;
        public final boolean c;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.f1233b = i2;
            this.c = z;
        }
    }

    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1234b;
        public final int c;
        public final float d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.a = i;
            this.f1234b = i2;
            this.c = i3;
            this.d = f;
            this.e = z;
            this.f = z2;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = z3;
        }
    }

    public static int a(byte[] bArr, int i) {
        int i2;
        synchronized (c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = d;
                    if (iArr.length <= i4) {
                        d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:91:0x0173  */
    public static b b(byte[] bArr, int i, int i2) {
        int iD;
        boolean z;
        int iD2;
        boolean z2;
        float f;
        l lVar = new l(bArr, i, i2);
        lVar.d(8);
        int iB = lVar.b(8);
        lVar.d(16);
        int iD3 = lVar.d();
        int i3 = 1;
        if (iB == 100 || iB == 110 || iB == 122 || iB == 244 || iB == 44 || iB == 83 || iB == 86 || iB == 118 || iB == 128 || iB == 138) {
            iD = lVar.d();
            boolean zC = iD == 3 ? lVar.c() : false;
            lVar.d();
            lVar.d();
            lVar.f();
            if (lVar.c()) {
                int i4 = iD != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i4) {
                    if (lVar.c()) {
                        int i6 = i5 < 6 ? 16 : 64;
                        int iE = 8;
                        int i7 = 8;
                        for (int i8 = 0; i8 < i6; i8++) {
                            if (iE != 0) {
                                iE = ((lVar.e() + i7) + 256) % 256;
                            }
                            if (iE != 0) {
                                i7 = iE;
                            }
                        }
                    }
                    i5++;
                }
            }
            z = zC;
        } else {
            z = false;
            iD = 1;
        }
        int iD4 = lVar.d() + 4;
        int iD5 = lVar.d();
        if (iD5 == 0) {
            z2 = false;
            iD2 = lVar.d() + 4;
        } else if (iD5 == 1) {
            boolean zC2 = lVar.c();
            lVar.e();
            lVar.e();
            long jD = lVar.d();
            for (int i9 = 0; i9 < jD; i9++) {
                lVar.d();
            }
            iD2 = 0;
            z2 = zC2;
        } else {
            iD2 = 0;
            z2 = false;
        }
        lVar.d();
        lVar.f();
        int iD6 = lVar.d() + 1;
        int iD7 = lVar.d() + 1;
        boolean zC3 = lVar.c();
        int i10 = 2 - (zC3 ? 1 : 0);
        int i11 = iD7 * i10;
        if (!zC3) {
            lVar.f();
        }
        lVar.f();
        int i12 = iD6 * 16;
        int i13 = i11 * 16;
        if (lVar.c()) {
            int iD8 = lVar.d();
            int iD9 = lVar.d();
            int iD10 = lVar.d();
            int iD11 = lVar.d();
            if (iD != 0) {
                int i14 = iD == 3 ? 1 : 2;
                i10 *= iD == 1 ? 2 : 1;
                i3 = i14;
            }
            i12 -= (iD8 + iD9) * i3;
            i13 -= (iD10 + iD11) * i10;
        }
        int i15 = i12;
        int i16 = i13;
        if (lVar.c() && lVar.c()) {
            int iB2 = lVar.b(8);
            if (iB2 == 255) {
                int iB3 = lVar.b(16);
                int iB4 = lVar.b(16);
                if (iB3 == 0 || iB4 == 0) {
                    f = 1.0f;
                } else {
                    f = iB3 / iB4;
                }
            } else {
                float[] fArr = f1232b;
                if (iB2 < fArr.length) {
                    f = fArr[iB2];
                } else {
                    Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iB2);
                    f = 1.0f;
                }
            }
        } else {
            f = 1.0f;
        }
        return new b(iD3, i15, i16, f, z, zC3, iD4, iD5, iD2, z2);
    }

    public static a a(byte[] bArr, int i, int i2) {
        l lVar = new l(bArr, i, i2);
        lVar.d(8);
        int iD = lVar.d();
        int iD2 = lVar.d();
        lVar.f();
        return new a(iD, iD2, lVar.c());
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0095, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            int r0 = r9 - r8
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L8
            r3 = r2
            goto L9
        L8:
            r3 = r1
        L9:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r3)
            if (r0 != 0) goto Lf
            return r9
        Lf:
            r3 = 2
            if (r10 == 0) goto L40
            boolean r4 = r10[r1]
            if (r4 == 0) goto L1c
            a(r10)
            int r8 = r8 + (-3)
            return r8
        L1c:
            if (r0 <= r2) goto L2b
            boolean r4 = r10[r2]
            if (r4 == 0) goto L2b
            r4 = r7[r8]
            if (r4 != r2) goto L2b
            a(r10)
            int r8 = r8 - r3
            return r8
        L2b:
            if (r0 <= r3) goto L40
            boolean r4 = r10[r3]
            if (r4 == 0) goto L40
            r4 = r7[r8]
            if (r4 != 0) goto L40
            int r4 = r8 + 1
            r4 = r7[r4]
            if (r4 != r2) goto L40
            a(r10)
            int r8 = r8 - r2
            return r8
        L40:
            int r4 = r9 + (-1)
            int r8 = r8 + r3
        L43:
            if (r8 >= r4) goto L67
            r5 = r7[r8]
            r5 = r5 & 254(0xfe, float:3.56E-43)
            if (r5 == 0) goto L4c
            goto L64
        L4c:
            int r5 = r8 + (-2)
            r6 = r7[r5]
            if (r6 != 0) goto L62
            int r6 = r8 + (-1)
            r6 = r7[r6]
            if (r6 != 0) goto L62
            r6 = r7[r8]
            if (r6 != r2) goto L62
            if (r10 == 0) goto L61
            a(r10)
        L61:
            return r5
        L62:
            int r8 = r8 + (-2)
        L64:
            int r8 = r8 + 3
            goto L43
        L67:
            if (r10 == 0) goto Lbb
            if (r0 <= r3) goto L7c
            int r8 = r9 + (-3)
            r8 = r7[r8]
            if (r8 != 0) goto L97
            int r8 = r9 + (-2)
            r8 = r7[r8]
            if (r8 != 0) goto L97
            r8 = r7[r4]
            if (r8 != r2) goto L97
            goto L95
        L7c:
            if (r0 != r3) goto L8d
            boolean r8 = r10[r3]
            if (r8 == 0) goto L97
            int r8 = r9 + (-2)
            r8 = r7[r8]
            if (r8 != 0) goto L97
            r8 = r7[r4]
            if (r8 != r2) goto L97
            goto L95
        L8d:
            boolean r8 = r10[r2]
            if (r8 == 0) goto L97
            r8 = r7[r4]
            if (r8 != r2) goto L97
        L95:
            r8 = r2
            goto L98
        L97:
            r8 = r1
        L98:
            r10[r1] = r8
            if (r0 <= r2) goto La7
            int r8 = r9 + (-2)
            r8 = r7[r8]
            if (r8 != 0) goto Lb1
            r8 = r7[r4]
            if (r8 != 0) goto Lb1
            goto Laf
        La7:
            boolean r8 = r10[r3]
            if (r8 == 0) goto Lb1
            r8 = r7[r4]
            if (r8 != 0) goto Lb1
        Laf:
            r8 = r2
            goto Lb2
        Lb1:
            r8 = r1
        Lb2:
            r10[r2] = r8
            r7 = r7[r4]
            if (r7 != 0) goto Lb9
            r1 = r2
        Lb9:
            r10[r3] = r1
        Lbb:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(byte[], int, int, boolean[]):int");
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
