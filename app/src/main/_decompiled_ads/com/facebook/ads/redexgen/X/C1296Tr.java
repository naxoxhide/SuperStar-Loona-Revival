package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import com.facebook.ads.internal.util.image.thirdparty.JavaBlurProcess;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1296Tr implements InterfaceC1073Lb {
    public static String[] A00 = {"hdmHMjdsCvnnIiAm68nbzST5FT4P5mLb", "EH3LUmZxwOvThvXMHcswnn58jDASieiK", "ljU4lnctUqCxo644HWpRzVkau739AG18", "cf0wMMVzQ5eDMzw1G9WbfLTL5VaSUv", "l50byEuqIAJWTFcEqiPP3cq5SFvrKOhf", "BkuhnFfUhQO532vAuKLRONmm63PuLWNO", "lueSUxwI7577CW", "p49ZYnIXKwO4jtZLxoBrhqW2OVcn4ZYc"};
    public static final short[] A02 = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    public static final byte[] A01 = {9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    public static void A00(int[] iArr, int src_i, int y, int minX, int i, int i2, int i3) {
        int maxY = src_i - 1;
        int i4 = y - 1;
        int stack_start = (minX * 2) + 1;
        short s = A02[minX];
        byte b2 = A01[minX];
        int[] iArr2 = new int[stack_start];
        long j = 0;
        if (i3 == 1) {
            int i5 = (i2 * y) / i;
            int i6 = ((i2 + 1) * y) / i;
            while (i5 < i6) {
                long sum_out_b = j;
                long j2 = j;
                long j3 = j;
                long j4 = j;
                long j5 = j;
                long j6 = j;
                long j7 = j;
                long j8 = j;
                int wm = src_i * i5;
                for (int i7 = 0; i7 <= minX; i7++) {
                    iArr2[i7] = iArr[wm];
                    j8 += (long) (((iArr[wm] >>> 16) & 255) * (i7 + 1));
                    j7 += (long) (((iArr[wm] >>> 8) & 255) * (i7 + 1));
                    j6 += (long) ((iArr[wm] & 255) * (i7 + 1));
                    j2 += (long) ((iArr[wm] >>> 16) & 255);
                    sum_out_b += (long) ((iArr[wm] >>> 8) & 255);
                    j += (long) (iArr[wm] & 255);
                }
                for (int i8 = 1; i8 <= minX; i8++) {
                    if (i8 <= maxY) {
                        wm++;
                    }
                    iArr2[i8 + minX] = iArr[wm];
                    j8 += (long) (((iArr[wm] >>> 16) & 255) * ((minX + 1) - i8));
                    j7 += (long) (((iArr[wm] >>> 8) & 255) * ((minX + 1) - i8));
                    j6 += (long) ((iArr[wm] & 255) * ((minX + 1) - i8));
                    j5 += (long) ((iArr[wm] >>> 16) & 255);
                    j4 += (long) ((iArr[wm] >>> 8) & 255);
                    j3 += (long) (iArr[wm] & 255);
                }
                int i9 = minX;
                int i10 = minX;
                if (i10 > maxY) {
                    i10 = maxY;
                }
                int i11 = (i5 * src_i) + i10;
                int i12 = i5 * src_i;
                for (int i13 = 0; i13 < src_i; i13++) {
                    iArr[i12] = (int) (((long) (iArr[i12] & (-16777216))) | ((((((long) s) * j8) >>> b2) & 255) << 16) | ((((((long) s) * j7) >>> b2) & 255) << 8) | (((((long) s) * j6) >>> b2) & 255));
                    i12++;
                    long j9 = j8 - j2;
                    long j10 = j7 - sum_out_b;
                    long j11 = j6 - j;
                    int i14 = (i9 + stack_start) - minX;
                    if (i14 >= stack_start) {
                        i14 -= stack_start;
                    }
                    long j12 = j2 - ((long) ((iArr2[i14] >>> 16) & 255));
                    long sum_out_b2 = sum_out_b - ((long) ((iArr2[i14] >>> 8) & 255));
                    long j13 = j - ((long) (iArr2[i14] & 255));
                    int stack_i = i10;
                    if (stack_i < maxY) {
                        i11++;
                        i10++;
                    }
                    iArr2[i14] = iArr[i11];
                    long j14 = j5 + ((long) ((iArr[i11] >>> 16) & 255));
                    long j15 = j4 + ((long) ((iArr[i11] >>> 8) & 255));
                    long j16 = j3 + ((long) (iArr[i11] & 255));
                    j8 = j9 + j14;
                    j7 = j10 + j15;
                    j6 = j11 + j16;
                    int i15 = i9 + 1;
                    if (i15 >= stack_start) {
                        i15 = 0;
                    }
                    int stack_i2 = iArr2[i15];
                    i9 = i15;
                    j2 = j12 + ((long) ((stack_i2 >>> 16) & 255));
                    int stack_i3 = iArr2[i15];
                    sum_out_b = sum_out_b2 + ((long) ((stack_i3 >>> 8) & 255));
                    int stack_i4 = iArr2[i15];
                    j = j13 + ((long) (stack_i4 & 255));
                    int stack_i5 = iArr2[i15];
                    j5 = j14 - ((long) ((stack_i5 >>> 16) & 255));
                    int stack_i6 = iArr2[i15];
                    j4 = j15 - ((long) ((stack_i6 >>> 8) & 255));
                    int stack_i7 = iArr2[i15];
                    j3 = j16 - ((long) (stack_i7 & 255));
                }
                i5++;
                j = 0;
            }
            return;
        }
        if (i3 == 2) {
            int i16 = (i2 * src_i) / i;
            int i17 = ((i2 + 1) * src_i) / i;
            while (maxX < i17) {
                long j17 = 0;
                long j18 = 0;
                long j19 = 0;
                long j20 = 0;
                long j21 = 0;
                long j22 = 0;
                long j23 = 0;
                long j24 = 0;
                long j25 = 0;
                int wm2 = i16;
                for (int i18 = 0; i18 <= minX; i18++) {
                    iArr2[i18] = iArr[wm2];
                    int maxX = i18 + 1;
                    j25 += (long) (((iArr[wm2] >>> 16) & 255) * maxX);
                    j24 += (long) (((iArr[wm2] >>> 8) & 255) * (i18 + 1));
                    j23 += (long) ((iArr[wm2] & 255) * (i18 + 1));
                    j19 += (long) ((iArr[wm2] >>> 16) & 255);
                    j18 += (long) ((iArr[wm2] >>> 8) & 255);
                    j17 += (long) (iArr[wm2] & 255);
                }
                for (int i19 = 1; i19 <= minX; i19++) {
                    if (i19 <= i4) {
                        wm2 += src_i;
                    }
                    int stack_i8 = i19 + minX;
                    iArr2[stack_i8] = iArr[wm2];
                    int stack_i9 = minX + 1;
                    j25 += (long) (((iArr[wm2] >>> 16) & 255) * (stack_i9 - i19));
                    int stack_i10 = minX + 1;
                    j24 += (long) (((iArr[wm2] >>> 8) & 255) * (stack_i10 - i19));
                    int stack_i11 = minX + 1;
                    j23 += (long) ((iArr[wm2] & 255) * (stack_i11 - i19));
                    j22 += (long) ((iArr[wm2] >>> 16) & 255);
                    j21 += (long) ((iArr[wm2] >>> 8) & 255);
                    j20 += (long) (iArr[wm2] & 255);
                }
                int hm = minX;
                int sp = minX;
                if (sp > i4) {
                    sp = i4;
                }
                int i20 = (sp * src_i) + i16;
                int i21 = i16;
                for (int sp2 = 0; sp2 < y; sp2++) {
                    iArr[i21] = (int) (((long) (iArr[i21] & (-16777216))) | ((((((long) s) * j25) >>> b2) & 255) << 16) | ((((((long) s) * j24) >>> b2) & 255) << 8) | (((((long) s) * j23) >>> b2) & 255));
                    i21 += src_i;
                    long j26 = j25 - j19;
                    long j27 = j24 - j18;
                    long j28 = j23 - j17;
                    int stack_start2 = (hm + stack_start) - minX;
                    if (stack_start2 >= stack_start) {
                        stack_start2 -= stack_start;
                    }
                    long j29 = j19 - ((long) ((iArr2[stack_start2] >>> 16) & 255));
                    long j30 = j18 - ((long) ((iArr2[stack_start2] >>> 8) & 255));
                    long j31 = j17 - ((long) (iArr2[stack_start2] & 255));
                    if (sp < i4) {
                        i20 += src_i;
                        sp++;
                    }
                    iArr2[stack_start2] = iArr[i20];
                    long j32 = j22 + ((long) ((iArr[i20] >>> 16) & 255));
                    long j33 = j21 + ((long) ((iArr[i20] >>> 8) & 255));
                    long j34 = j20 + ((long) (iArr[i20] & 255));
                    j25 = j26 + j32;
                    j24 = j27 + j33;
                    j23 = j28 + j34;
                    hm++;
                    if (hm >= stack_start) {
                        hm = 0;
                    }
                    j19 = j29 + ((long) ((iArr2[hm] >>> 16) & 255));
                    j18 = j30 + ((long) ((iArr2[hm] >>> 8) & 255));
                    j17 = j31 + ((long) (iArr2[hm] & 255));
                    j22 = j32 - ((long) ((iArr2[hm] >>> 16) & 255));
                    j21 = j33 - ((long) ((iArr2[hm] >>> 8) & 255));
                    j20 = j34 - ((long) (iArr2[hm] & 255));
                }
                i16++;
                String[] strArr = A00;
                if (strArr[4].charAt(24) == strArr[0].charAt(24)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[4] = "dRrOf81uK3m7JlCVGnAp7HBN8Ud450kD";
                strArr2[0] = "ERfsWS88AUosonNdTmqfcWCTdCaDCKBU";
            }
        }
    }

    public final Bitmap A02(Bitmap bitmap, float f) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        try {
            int[] iArr = new int[w * h];
            bitmap.getPixels(iArr, 0, w, 0, 0, w, h);
            int i = C1078Lg.A00;
            ArrayList arrayList = new ArrayList(i);
            ArrayList<JavaBlurProcess.BlurTask> vertical = new ArrayList<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                int h2 = h;
                int cores = i2;
                arrayList.add(new CallableC1077Lf(iArr, w, h2, (int) f, i, cores, 1));
                h = h2;
                int cores2 = i2;
                vertical.add(new CallableC1077Lf(iArr, w, h, (int) f, i, cores2, 2));
            }
            try {
                C1078Lg.A01.invokeAll(arrayList);
                try {
                    C1078Lg.A01.invokeAll(vertical);
                    try {
                        return Bitmap.createBitmap(iArr, w, h, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        return null;
                    }
                } catch (InterruptedException unused2) {
                    return null;
                }
            } catch (InterruptedException unused3) {
                return null;
            }
        } catch (OutOfMemoryError unused4) {
            return null;
        }
    }
}
