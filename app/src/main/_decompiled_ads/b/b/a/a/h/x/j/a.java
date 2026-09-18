package b.b.a.a.h.x.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: compiled from: DefaultDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final ImageView.ScaleType g = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config h = Bitmap.Config.ARGB_4444;
    private final Bitmap.Config a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f188b;
    private int c;
    private final int d;
    private final int e;
    private final ImageView.ScaleType f;

    public a(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.a = config;
        this.f188b = i;
        this.c = i2;
        this.f = scaleType;
        this.d = i3;
        this.e = i4;
        a(i, i2);
    }

    static int a(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public Bitmap a(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f188b == 0 && this.c == 0) {
            options.inPreferredConfig = this.a;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iA = a(this.f188b, this.c, i, i2, this.f);
            int iA2 = a(this.c, this.f188b, i2, i, this.f);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, iA, iA2, this.d, this.e);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iA || bitmapDecodeByteArray.getHeight() > iA2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iA, iA2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (Build.VERSION.SDK_INT >= 12 && bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void a(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.f188b = 3840;
                this.c = (i2 * 3840) / i;
                return;
            } else {
                this.f188b = (i * 3840) / i2;
                this.c = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.f188b = 3840;
            this.c = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.f188b = (i * 3840) / i2;
            this.c = 3840;
        }
    }
}
