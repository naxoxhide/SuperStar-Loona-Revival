package com.applovin.exoplayer2.m.a;

/* JADX INFO: loaded from: classes.dex */
final class e {
    public final a afx;
    public final a afy;
    public final boolean afz;
    public final int dJ;

    public static e fT(int i) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public static e a(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        int i5;
        int i6;
        float[] fArr;
        int i7;
        int i8 = i;
        int i9 = i2;
        com.applovin.exoplayer2.l.a.checkArgument(f > 0.0f);
        com.applovin.exoplayer2.l.a.checkArgument(i8 >= 1);
        com.applovin.exoplayer2.l.a.checkArgument(i9 >= 1);
        com.applovin.exoplayer2.l.a.checkArgument(f2 > 0.0f && f2 <= 180.0f);
        com.applovin.exoplayer2.l.a.checkArgument(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f3);
        float f4 = radians / i8;
        float f5 = radians2 / i9;
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[i11 * 3];
        float[] fArr3 = new float[i11 * 2];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f6 = radians / 2.0f;
            float f7 = (i12 * f4) - f6;
            int i15 = i12 + 1;
            float f8 = (i15 * f4) - f6;
            int i16 = 0;
            while (i16 < i10) {
                float f9 = f7;
                int i17 = i15;
                int i18 = 0;
                int i19 = 2;
                while (i18 < i19) {
                    float f10 = i16 * f5;
                    float f11 = f5;
                    int i20 = i13 + 1;
                    int i21 = i16;
                    double d = f;
                    float f12 = f4;
                    double d2 = (f10 + 3.1415927f) - (radians2 / 2.0f);
                    int i22 = i18;
                    double d3 = i18 == 0 ? f9 : f8;
                    float[] fArr4 = fArr3;
                    float f13 = f8;
                    fArr2[i13] = -((float) (Math.sin(d2) * d * Math.cos(d3)));
                    int i23 = i20 + 1;
                    int i24 = i12;
                    fArr2[i20] = (float) (d * Math.sin(d3));
                    int i25 = i23 + 1;
                    fArr2[i23] = (float) (d * Math.cos(d2) * Math.cos(d3));
                    int i26 = i14 + 1;
                    fArr4[i14] = f10 / radians2;
                    int i27 = i26 + 1;
                    fArr4[i26] = ((i24 + i22) * f12) / radians;
                    if (i21 == 0 && i22 == 0) {
                        i4 = i2;
                        i5 = i21;
                        i6 = i22;
                    } else {
                        i4 = i2;
                        i5 = i21;
                        i6 = i22;
                        if (i5 != i4 || i6 != 1) {
                            fArr = fArr4;
                            i7 = 2;
                        }
                        i14 = i27;
                        i13 = i25;
                        i18 = i6 + 1;
                        i9 = i4;
                        i16 = i5;
                        fArr3 = fArr;
                        i19 = i7;
                        i12 = i24;
                        i10 = i10;
                        f5 = f11;
                        f4 = f12;
                        f8 = f13;
                    }
                    System.arraycopy(fArr2, i25 - 3, fArr2, i25, 3);
                    i25 += 3;
                    fArr = fArr4;
                    i7 = 2;
                    System.arraycopy(fArr, i27 - 2, fArr, i27, 2);
                    i27 += 2;
                    i14 = i27;
                    i13 = i25;
                    i18 = i6 + 1;
                    i9 = i4;
                    i16 = i5;
                    fArr3 = fArr;
                    i19 = i7;
                    i12 = i24;
                    i10 = i10;
                    f5 = f11;
                    f4 = f12;
                    f8 = f13;
                }
                float f14 = f4;
                int i28 = i16;
                int i29 = i9;
                int i30 = i28 + 1;
                f7 = f9;
                i15 = i17;
                i10 = i10;
                f4 = f14;
                f8 = f8;
                i9 = i29;
                i16 = i30;
            }
            i8 = i;
            i12 = i15;
        }
        return new e(new a(new b(0, fArr2, fArr3, 1)), i3);
    }

    public e(a aVar, int i) {
        this(aVar, aVar, i);
    }

    public e(a aVar, a aVar2, int i) {
        this.afx = aVar;
        this.afy = aVar2;
        this.dJ = i;
        this.afz = aVar == aVar2;
    }

    public static final class b {
        public final int afB;
        public final float[] afC;
        public final float[] afD;
        public final int rm;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.afB = i;
            com.applovin.exoplayer2.l.a.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.afC = fArr;
            this.afD = fArr2;
            this.rm = i2;
        }
    }

    public static final class a {
        private final b[] afA;

        public a(b... bVarArr) {
            this.afA = bVarArr;
        }

        public int qK() {
            return this.afA.length;
        }

        public b fU(int i) {
            return this.afA[i];
        }
    }
}
