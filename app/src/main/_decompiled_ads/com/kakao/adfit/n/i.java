package com.kakao.adfit.n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.kakao.adfit.common.volley.ParseError;

/* JADX INFO: compiled from: ImageRequest.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends com.kakao.adfit.common.volley.e<Bitmap> {
    private static final Object w = new Object();
    private final Object q;
    private com.kakao.adfit.common.volley.g.b<Bitmap> r;
    private final Bitmap.Config s;
    private final int t;
    private final int u;
    private final ImageView.ScaleType v;

    public i(String str, com.kakao.adfit.common.volley.g.b<Bitmap> bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, com.kakao.adfit.common.volley.g.a aVar) {
        super(0, str, aVar);
        this.q = new Object();
        a((com.kakao.adfit.m.f) new com.kakao.adfit.m.a(1000, 2, 2.0f));
        this.r = bVar;
        this.s = config;
        this.t = i;
        this.u = i2;
        this.v = scaleType;
    }

    private com.kakao.adfit.common.volley.g<Bitmap> b(com.kakao.adfit.m.d dVar) {
        Bitmap bitmapDecodeByteArray;
        byte[] bArr = dVar.f1851b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.t == 0 && this.u == 0) {
            options.inPreferredConfig = this.s;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iA = a(this.t, this.u, i, i2, this.v);
            int iA2 = a(this.u, this.t, i2, i, this.v);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, iA, iA2);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iA || bitmapDecodeByteArray.getHeight() > iA2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iA, iA2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        return bitmapDecodeByteArray == null ? com.kakao.adfit.common.volley.g.a(new ParseError(dVar)) : com.kakao.adfit.common.volley.g.a(bitmapDecodeByteArray, e.a(dVar));
    }

    @Override // com.kakao.adfit.common.volley.e
    public com.kakao.adfit.common.volley.e.c m() {
        return com.kakao.adfit.common.volley.e.c.HIGH;
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

    @Override // com.kakao.adfit.common.volley.e
    protected com.kakao.adfit.common.volley.g<Bitmap> a(com.kakao.adfit.m.d dVar) {
        com.kakao.adfit.common.volley.g<Bitmap> gVarB;
        synchronized (w) {
            try {
                try {
                    gVarB = b(dVar);
                } catch (OutOfMemoryError e) {
                    com.kakao.adfit.common.volley.h.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(dVar.f1851b.length), q());
                    return com.kakao.adfit.common.volley.g.a(new ParseError(e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVarB;
    }

    @Override // com.kakao.adfit.common.volley.e
    public void a() {
        super.a();
        synchronized (this.q) {
            this.r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kakao.adfit.common.volley.e
    public void a(Bitmap bitmap) {
        com.kakao.adfit.common.volley.g.b<Bitmap> bVar;
        synchronized (this.q) {
            bVar = this.r;
        }
        if (bVar != null) {
            bVar.a(bitmap);
        }
    }

    static int a(int i, int i2, int i3, int i4) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }
}
