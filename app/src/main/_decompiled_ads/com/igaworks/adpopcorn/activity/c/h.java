package com.igaworks.adpopcorn.activity.c;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class h extends Drawable {
    private final RectF a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f1572b = new RectF();
    private final RectF c;
    private final Bitmap d;
    private final Paint e;
    private final int f;
    private final int g;
    private final RectF h;
    private final Paint i;
    private final Matrix j;
    private BitmapShader k;
    private Shader.TileMode l;
    private Shader.TileMode m;
    private boolean n;
    private float o;
    private boolean p;
    private float q;
    private ColorStateList r;
    private ImageView.ScaleType s;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public h(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.c = rectF;
        this.h = new RectF();
        this.j = new Matrix();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = false;
        this.q = 0.0f;
        this.r = ColorStateList.valueOf(-16777216);
        this.s = ImageView.ScaleType.FIT_CENTER;
        this.d = bitmap;
        int width = bitmap.getWidth();
        this.f = width;
        int height = bitmap.getHeight();
        this.g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.r.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.q);
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static h a(Bitmap bitmap) {
        if (bitmap != null) {
            return new h(bitmap);
        }
        return null;
    }

    private void a() {
        float fWidth;
        float fWidth2;
        Matrix matrix;
        RectF rectF;
        RectF rectF2;
        Matrix.ScaleToFit scaleToFit;
        int i = a.a[this.s.ordinal()];
        if (i == 1) {
            this.h.set(this.a);
            RectF rectF3 = this.h;
            float f = this.q / 2.0f;
            rectF3.inset(f, f);
            this.j.reset();
            this.j.setTranslate((int) (((this.h.width() - this.f) * 0.5f) + 0.5f), (int) (((this.h.height() - this.g) * 0.5f) + 0.5f));
        } else if (i != 2) {
            if (i != 3) {
                if (i == 5) {
                    this.h.set(this.c);
                    matrix = this.j;
                    rectF = this.c;
                    rectF2 = this.a;
                    scaleToFit = Matrix.ScaleToFit.END;
                } else if (i != 6) {
                    if (i != 7) {
                        this.h.set(this.c);
                        matrix = this.j;
                        rectF = this.c;
                        rectF2 = this.a;
                        scaleToFit = Matrix.ScaleToFit.CENTER;
                    } else {
                        this.h.set(this.a);
                        RectF rectF4 = this.h;
                        float f2 = this.q / 2.0f;
                        rectF4.inset(f2, f2);
                        this.j.reset();
                    }
                    this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
                } else {
                    this.h.set(this.c);
                    matrix = this.j;
                    rectF = this.c;
                    rectF2 = this.a;
                    scaleToFit = Matrix.ScaleToFit.START;
                }
                matrix.setRectToRect(rectF, rectF2, scaleToFit);
            } else {
                this.j.reset();
                float fMin = (((float) this.f) > this.a.width() || ((float) this.g) > this.a.height()) ? Math.min(this.a.width() / this.f, this.a.height() / this.g) : 1.0f;
                float fWidth3 = (int) (((this.a.width() - (this.f * fMin)) * 0.5f) + 0.5f);
                float fHeight = (int) (((this.a.height() - (this.g * fMin)) * 0.5f) + 0.5f);
                this.j.setScale(fMin, fMin);
                this.j.postTranslate(fWidth3, fHeight);
                this.h.set(this.c);
            }
            this.j.mapRect(this.h);
            RectF rectF5 = this.h;
            float f3 = this.q / 2.0f;
            rectF5.inset(f3, f3);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else {
            this.h.set(this.a);
            RectF rectF6 = this.h;
            float f4 = this.q / 2.0f;
            rectF6.inset(f4, f4);
            this.j.reset();
            float fHeight2 = 0.0f;
            if (this.f * this.h.height() > this.h.width() * this.g) {
                fWidth = this.h.height() / this.g;
                fWidth2 = (this.h.width() - (this.f * fWidth)) * 0.5f;
            } else {
                fWidth = this.h.width() / this.f;
                fWidth2 = 0.0f;
                fHeight2 = (this.h.height() - (this.g * fWidth)) * 0.5f;
            }
            this.j.setScale(fWidth, fWidth);
            Matrix matrix2 = this.j;
            float f5 = this.q;
            matrix2.postTranslate(((int) (fWidth2 + 0.5f)) + f5, ((int) (fHeight2 + 0.5f)) + f5);
        }
        this.f1572b.set(this.h);
    }

    public static Drawable b(Drawable drawable) {
        if (drawable == null || (drawable instanceof h)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapA = a(drawable);
            if (bitmapA != null) {
                return new h(bitmapA);
            }
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i = 0; i < numberOfLayers; i++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), b(layerDrawable.getDrawable(i)));
        }
        return layerDrawable;
    }

    public h a(float f) {
        this.q = f;
        this.i.setStrokeWidth(f);
        return this;
    }

    public h a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.r = colorStateList;
        this.i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public h a(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public h a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.s != scaleType) {
            this.s = scaleType;
            a();
        }
        return this;
    }

    public h a(boolean z) {
        this.p = z;
        return this;
    }

    public h b(float f) {
        this.o = f;
        return this;
    }

    public h b(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF;
        float f;
        Paint paint;
        RectF rectF2;
        Paint paint2;
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.d, this.l, this.m);
            this.k = bitmapShader;
            Shader.TileMode tileMode = this.l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.e.setShader(this.k);
            this.n = false;
        }
        if (this.p) {
            if (this.q > 0.0f) {
                canvas.drawOval(this.f1572b, this.e);
                rectF2 = this.h;
                paint2 = this.i;
            } else {
                rectF2 = this.f1572b;
                paint2 = this.e;
            }
            canvas.drawOval(rectF2, paint2);
            return;
        }
        if (this.q > 0.0f) {
            canvas.drawRoundRect(this.f1572b, Math.max(this.o, 0.0f), Math.max(this.o, 0.0f), this.e);
            rectF = this.h;
            f = this.o;
            paint = this.i;
        } else {
            rectF = this.f1572b;
            f = this.o;
            paint = this.e;
        }
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.r.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.r.getColorForState(iArr, 0);
        if (this.i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
        invalidateSelf();
    }
}
