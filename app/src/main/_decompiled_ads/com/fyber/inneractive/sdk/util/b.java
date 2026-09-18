package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static Bitmap a(Context context, Bitmap bitmap, c cVar) throws Throwable {
        boolean z;
        Bitmap bitmapA;
        int i = cVar.a;
        int i2 = cVar.d;
        int i3 = i / i2;
        int i4 = cVar.f1333b / i2;
        int[] iArr = {i3, i4};
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                z = false;
                break;
            }
            if (iArr[i5] == 0) {
                z = true;
                break;
            }
            i5++;
        }
        if (z) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = 1.0f / cVar.d;
        canvas.scale(f, f);
        Paint paint = new Paint();
        paint.setFlags(3);
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                bitmapA = a(context, bitmapCreateBitmap, cVar.c);
            } catch (RSRuntimeException unused) {
                bitmapA = a(bitmapCreateBitmap, cVar.c, true);
            }
        } else {
            bitmapA = a(bitmapCreateBitmap, cVar.c, true);
        }
        if (cVar.d == 1) {
            return bitmapA;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA, cVar.a, cVar.f1333b, true);
        bitmapA.recycle();
        return bitmapCreateScaledBitmap;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:21:0x0057  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0061  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap a(Context context, Bitmap bitmap, int i) throws Throwable {
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocationCreateFromBitmap;
        Allocation allocationCreateTyped;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = null;
        try {
            RenderScript renderScriptCreate = RenderScript.create(context);
            try {
                renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
                allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                try {
                    allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
                    try {
                        scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                        scriptIntrinsicBlurCreate.setRadius(i);
                        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                        allocationCreateTyped.copyTo(bitmap);
                        renderScriptCreate.destroy();
                        allocationCreateFromBitmap.destroy();
                        allocationCreateTyped.destroy();
                        scriptIntrinsicBlurCreate.destroy();
                        return bitmap;
                    } catch (Throwable th) {
                        th = th;
                        ScriptIntrinsicBlur scriptIntrinsicBlur2 = scriptIntrinsicBlurCreate;
                        renderScript = renderScriptCreate;
                        scriptIntrinsicBlur = scriptIntrinsicBlur2;
                        if (renderScript != null) {
                            renderScript.destroy();
                        }
                        if (allocationCreateFromBitmap != null) {
                            allocationCreateFromBitmap.destroy();
                        }
                        if (allocationCreateTyped != null) {
                            allocationCreateTyped.destroy();
                        }
                        if (scriptIntrinsicBlur != 0) {
                            scriptIntrinsicBlur.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    allocationCreateTyped = null;
                    renderScript = renderScriptCreate;
                    scriptIntrinsicBlur = allocationCreateTyped;
                    if (renderScript != null) {
                        renderScript.destroy();
                    }
                    if (allocationCreateFromBitmap != null) {
                        allocationCreateFromBitmap.destroy();
                    }
                    if (allocationCreateTyped != null) {
                        allocationCreateTyped.destroy();
                    }
                    if (scriptIntrinsicBlur != 0) {
                        scriptIntrinsicBlur.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                allocationCreateFromBitmap = null;
                allocationCreateTyped = null;
            }
        } catch (Throwable th4) {
            th = th4;
            scriptIntrinsicBlur = 0;
            allocationCreateFromBitmap = null;
            allocationCreateTyped = null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, boolean z) {
        int i2 = i;
        Bitmap bitmapCopy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i3 = width * height;
        int[] iArr = new int[i3];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr6 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr6[i10] = i10 / i8;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) int.class, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr8 = iArr5;
                int i27 = iArr[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr9 = iArr7[i24 + i2];
                iArr9[0] = (i27 & 16711680) >> 16;
                iArr9[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i27 & 255;
                int iAbs = i11 - Math.abs(i24);
                i17 += iArr9[0] * iAbs;
                i16 += iArr9[1] * iAbs;
                i25 += iArr9[2] * iAbs;
                if (i24 > 0) {
                    i23 += iArr9[0];
                    i22 += iArr9[1];
                    i21 += iArr9[2];
                } else {
                    i20 += iArr9[0];
                    i19 += iArr9[1];
                    i18 += iArr9[2];
                }
                i24++;
                i5 = i26;
                iArr5 = iArr8;
            }
            int i28 = i5;
            int[] iArr10 = iArr5;
            int i29 = i2;
            int i30 = i25;
            int i31 = 0;
            while (i31 < width) {
                iArr2[i13] = iArr6[i17];
                iArr3[i13] = iArr6[i16];
                iArr4[i13] = iArr6[i30];
                int i32 = i17 - i20;
                int i33 = i16 - i19;
                int i34 = i30 - i18;
                int[] iArr11 = iArr7[((i29 - i2) + i6) % i6];
                int i35 = i20 - iArr11[0];
                int i36 = i19 - iArr11[1];
                int i37 = i18 - iArr11[2];
                if (i12 == 0) {
                    iArr10[i31] = Math.min(i31 + i2 + 1, i4);
                }
                int i38 = iArr[i14 + iArr10[i31]];
                iArr11[0] = (i38 & 16711680) >> 16;
                iArr11[1] = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i38 & 255;
                int i39 = i23 + iArr11[0];
                int i40 = i22 + iArr11[1];
                int i41 = i21 + iArr11[2];
                i17 = i32 + i39;
                i16 = i33 + i40;
                i30 = i34 + i41;
                i29 = (i29 + 1) % i6;
                int[] iArr12 = iArr7[i29 % i6];
                i20 = i35 + iArr12[0];
                i19 = i36 + iArr12[1];
                i18 = i37 + iArr12[2];
                i23 = i39 - iArr12[0];
                i22 = i40 - iArr12[1];
                i21 = i41 - iArr12[2];
                i13++;
                i31++;
                iArr6 = iArr6;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap2;
            height = i15;
            i5 = i28;
            iArr5 = iArr10;
        }
        Bitmap bitmap3 = bitmapCopy;
        int i42 = i5;
        int[] iArr13 = iArr5;
        int i43 = height;
        int[] iArr14 = iArr6;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i2;
            int i46 = i6;
            int[] iArr15 = iArr;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = i45;
            int i55 = i45 * width;
            int i56 = 0;
            int i57 = 0;
            while (i54 <= i2) {
                int i58 = width;
                int iMax = Math.max(0, i55) + i44;
                int[] iArr16 = iArr7[i54 + i2];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr4[iMax];
                int iAbs2 = i11 - Math.abs(i54);
                i47 += iArr2[iMax] * iAbs2;
                i57 += iArr3[iMax] * iAbs2;
                i56 += iArr4[iMax] * iAbs2;
                if (i54 > 0) {
                    i51 += iArr16[0];
                    i52 += iArr16[1];
                    i53 += iArr16[2];
                } else {
                    i50 += iArr16[0];
                    i49 += iArr16[1];
                    i48 += iArr16[2];
                }
                int i59 = i42;
                if (i54 < i59) {
                    i55 += i58;
                }
                i54++;
                i42 = i59;
                width = i58;
            }
            int i60 = width;
            int i61 = i42;
            int i62 = i2;
            int i63 = i44;
            int i64 = i57;
            int i65 = i43;
            int i66 = i56;
            int i67 = 0;
            while (i67 < i65) {
                iArr15[i63] = (iArr15[i63] & (-16777216)) | (iArr14[i47] << 16) | (iArr14[i64] << 8) | iArr14[i66];
                int i68 = i47 - i50;
                int i69 = i64 - i49;
                int i70 = i66 - i48;
                int[] iArr17 = iArr7[((i62 - i2) + i46) % i46];
                int i71 = i50 - iArr17[0];
                int i72 = i49 - iArr17[1];
                int i73 = i48 - iArr17[2];
                if (i44 == 0) {
                    iArr13[i67] = Math.min(i67 + i11, i61) * i60;
                }
                int i74 = iArr13[i67] + i44;
                iArr17[0] = iArr2[i74];
                iArr17[1] = iArr3[i74];
                iArr17[2] = iArr4[i74];
                int i75 = i51 + iArr17[0];
                int i76 = i52 + iArr17[1];
                int i77 = i53 + iArr17[2];
                i47 = i68 + i75;
                i64 = i69 + i76;
                i66 = i70 + i77;
                i62 = (i62 + 1) % i46;
                int[] iArr18 = iArr7[i62];
                i50 = i71 + iArr18[0];
                i49 = i72 + iArr18[1];
                i48 = i73 + iArr18[2];
                i51 = i75 - iArr18[0];
                i52 = i76 - iArr18[1];
                i53 = i77 - iArr18[2];
                i63 += i60;
                i67++;
                i2 = i;
            }
            i44++;
            i2 = i;
            i42 = i61;
            i43 = i65;
            i6 = i46;
            iArr = iArr15;
            width = i60;
        }
        int i78 = width;
        bitmap3.setPixels(iArr, 0, i78, 0, 0, i78, i43);
        return bitmap3;
    }
}
