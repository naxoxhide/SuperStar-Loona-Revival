package com.tnkfactory.ad.pub.a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tnkfactory.ad.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 {

    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2875b;
        public int c;

        public a(int i, int i2) {
            this.a = i;
            this.f2875b = i2;
            this.c = i > i2 ? 0 : 1;
        }

        public final int a() {
            return this.c == 0 ? this.a : this.f2875b;
        }

        public final int b() {
            return this.c == 0 ? this.f2875b : this.a;
        }

        public final int c() {
            return this.f2875b;
        }

        public final int d() {
            return this.c;
        }

        public final int e() {
            return this.a;
        }
    }

    public static float a(Context context) {
        return TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public static float a(Context context, int i, String str) {
        try {
            String strTrim = str.trim();
            if (strTrim.length() == 0) {
                return 0.0f;
            }
            if (strTrim.endsWith("dp")) {
                return TypedValue.applyDimension(1, Float.parseFloat(strTrim.substring(0, strTrim.length() - 2)), context.getResources().getDisplayMetrics());
            }
            if (strTrim.endsWith("px")) {
                return Float.parseFloat(strTrim.substring(0, strTrim.length() - 2));
            }
            float f = Float.parseFloat(strTrim);
            return f < 0.0f ? f : (i * f) / 100.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int a(Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i != 0) {
            if (i == 1) {
                i5 = height - 1;
                i2 = width;
                i3 = 1;
                i4 = 0;
            } else if (i != 2) {
                i4 = width - 1;
                i3 = height;
                i2 = 1;
                i5 = 0;
            } else {
                i3 = height;
                i2 = 1;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i4, i5, i2, i3);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, 1, 1, true);
            int pixel = bitmapCreateScaledBitmap.getPixel(0, 0);
            bitmapCreateScaledBitmap.recycle();
            bitmapCreateBitmap.recycle();
            return pixel;
        }
        i2 = width;
        i3 = 1;
        i4 = 0;
        i5 = 0;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, i4, i5, i2, i3);
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateBitmap2, 1, 1, true);
        int pixel2 = bitmapCreateScaledBitmap2.getPixel(0, 0);
        bitmapCreateScaledBitmap2.recycle();
        bitmapCreateBitmap2.recycle();
        return pixel2;
    }

    public static long a(String str) {
        if (str == null) {
            return 0L;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return 0L;
        }
        return strTrim.startsWith("0x") ? Long.parseLong(strTrim.substring(2), 16) : Long.parseLong(strTrim);
    }

    public static ColorStateList a(String str, String str2) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{(int) a(str2), (int) a(str)});
    }

    public static <T> List<T> a(ViewGroup viewGroup, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                arrayList.add(childAt);
            } else if (childAt instanceof ViewGroup) {
                arrayList.addAll(a((ViewGroup) childAt, cls));
            }
        }
        return arrayList;
    }

    public static boolean a(View view, boolean z) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || view.getWindowVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        if (z) {
            return ((double) (rect.height() * rect.width())) / ((double) (view.getHeight() * view.getWidth())) > 0.5d;
        }
        return true;
    }

    public static int[] a(Context context, int i, int i2, String str) {
        int[] iArr = {0, 0, 0, 0};
        int i3 = 0;
        for (String str2 : str.split(",")) {
            if (i3 == 0 || i3 == 2) {
                iArr[i3] = (int) a(context, i, str2);
            } else {
                iArr[i3] = (int) a(context, i2, str2);
            }
            i3++;
            if (i3 >= 4) {
                break;
            }
        }
        return iArr;
    }

    public static a b(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            return new a(point.x, point.y);
        } catch (Exception e) {
            Logger.e(com.tnkfactory.ad.pub.a.a.a("error #f004 : ").append(e.toString()).toString());
            return new a(0, 0);
        }
    }
}
