package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: FastBlurUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l {
    public static int a = 2048;

    public static Bitmap a(Bitmap bitmap, int i) {
        int i2 = i <= 0 ? 10 : i;
        int width = bitmap.getWidth() / i2;
        int height = bitmap.getHeight() / i2;
        int i3 = 0;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        int width2 = bitmapCreateScaledBitmap.getWidth();
        int height2 = bitmapCreateScaledBitmap.getHeight();
        int i4 = width2 * height2;
        int[] iArr = new int[i4];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
        int i5 = width2 - 1;
        int i6 = height2 - 1;
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[Math.max(width2, height2)];
        int[] iArr6 = new int[20736];
        for (int i7 = 0; i7 < 20736; i7++) {
            iArr6[i7] = i7 / 81;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) int.class, 17, 3);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i8 >= height2) {
                break;
            }
            int i11 = i3;
            int i12 = i11;
            int i13 = i12;
            int i14 = i13;
            int i15 = i14;
            int i16 = i15;
            int i17 = i16;
            int i18 = i17;
            int i19 = -8;
            int i20 = i18;
            for (int i21 = 8; i19 <= i21; i21 = 8) {
                int i22 = iArr[i9 + Math.min(i5, Math.max(i19, i3))];
                int[] iArr8 = iArr7[i19 + 8];
                iArr8[i3] = (i22 & 16711680) >> 16;
                iArr8[1] = (i22 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i22 & 255;
                int iAbs = 9 - Math.abs(i19);
                i20 += iArr8[i3] * iAbs;
                i11 += iArr8[1] * iAbs;
                i12 += iArr8[2] * iAbs;
                if (i19 > 0) {
                    i16 += iArr8[i3];
                    i17 += iArr8[1];
                    i18 += iArr8[2];
                } else {
                    i13 += iArr8[i3];
                    i14 += iArr8[1];
                    i15 += iArr8[2];
                }
                i19++;
            }
            int i23 = i3;
            int i24 = 8;
            while (i23 < width2) {
                iArr2[i9] = iArr6[i20];
                iArr3[i9] = iArr6[i11];
                iArr4[i9] = iArr6[i12];
                int i25 = i20 - i13;
                int i26 = i11 - i14;
                int i27 = i12 - i15;
                int[] iArr9 = iArr7[((i24 - 8) + 17) % 17];
                int i28 = i13 - iArr9[i3];
                int i29 = i14 - iArr9[1];
                int i30 = i15 - iArr9[2];
                if (i8 == 0) {
                    iArr5[i23] = Math.min(i23 + 8 + 1, i5);
                }
                int i31 = iArr[i10 + iArr5[i23]];
                iArr9[0] = (i31 & 16711680) >> 16;
                iArr9[1] = (i31 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i31 & 255;
                int i32 = i16 + iArr9[0];
                int i33 = i17 + iArr9[1];
                int i34 = i18 + iArr9[2];
                i20 = i25 + i32;
                i11 = i26 + i33;
                i12 = i27 + i34;
                i24 = (i24 + 1) % 17;
                int[] iArr10 = iArr7[i24 % 17];
                i13 = i28 + iArr10[0];
                i14 = i29 + iArr10[1];
                i15 = i30 + iArr10[2];
                i16 = i32 - iArr10[0];
                i17 = i33 - iArr10[1];
                i18 = i34 - iArr10[2];
                i9++;
                i23++;
                i3 = 0;
            }
            i10 += width2;
            i8++;
            i3 = 0;
        }
        int i35 = 0;
        while (i35 < width2) {
            int i36 = (-8) * width2;
            Bitmap bitmap2 = bitmapCreateScaledBitmap;
            int[] iArr11 = iArr5;
            int i37 = -8;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            for (int i47 = 8; i37 <= i47; i47 = 8) {
                int iMax = Math.max(0, i36) + i35;
                int[] iArr12 = iArr7[i37 + 8];
                iArr12[0] = iArr2[iMax];
                iArr12[1] = iArr3[iMax];
                iArr12[2] = iArr4[iMax];
                int iAbs2 = 9 - Math.abs(i37);
                i38 += iArr2[iMax] * iAbs2;
                i39 += iArr3[iMax] * iAbs2;
                i40 += iArr4[iMax] * iAbs2;
                if (i37 > 0) {
                    i44 += iArr12[0];
                    i45 += iArr12[1];
                    i46 += iArr12[2];
                } else {
                    i41 += iArr12[0];
                    i42 += iArr12[1];
                    i43 += iArr12[2];
                }
                if (i37 < i6) {
                    i36 += width2;
                }
                i37++;
            }
            int i48 = i35;
            int i49 = 0;
            int i50 = 8;
            while (i49 < height2) {
                iArr[i48] = (iArr[i48] & (-16777216)) | (iArr6[i38] << 16) | (iArr6[i39] << 8) | iArr6[i40];
                int i51 = i38 - i41;
                int i52 = i39 - i42;
                int i53 = i40 - i43;
                int[] iArr13 = iArr7[((i50 - 8) + 17) % 17];
                int i54 = i41 - iArr13[0];
                int i55 = i42 - iArr13[1];
                int i56 = i43 - iArr13[2];
                if (i35 == 0) {
                    iArr11[i49] = Math.min(i49 + 9, i6) * width2;
                }
                int i57 = iArr11[i49] + i35;
                iArr13[0] = iArr2[i57];
                iArr13[1] = iArr3[i57];
                iArr13[2] = iArr4[i57];
                int i58 = i44 + iArr13[0];
                int i59 = i45 + iArr13[1];
                int i60 = i46 + iArr13[2];
                i38 = i51 + i58;
                i39 = i52 + i59;
                i40 = i53 + i60;
                i50 = (i50 + 1) % 17;
                int[] iArr14 = iArr7[i50];
                i41 = i54 + iArr14[0];
                i42 = i55 + iArr14[1];
                i43 = i56 + iArr14[2];
                i44 = i58 - iArr14[0];
                i45 = i59 - iArr14[1];
                i46 = i60 - iArr14[2];
                i48 += width2;
                i49++;
                iArr6 = iArr6;
            }
            i35++;
            bitmapCreateScaledBitmap = bitmap2;
            iArr5 = iArr11;
        }
        Bitmap bitmap3 = bitmapCreateScaledBitmap;
        bitmap3.setPixels(iArr, 0, width2, 0, 0, width2, height2);
        return bitmap3;
    }
}
