package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class i extends ImageView {
    public static final Shader.TileMode l = Shader.TileMode.CLAMP;
    static final /* synthetic */ boolean m = true;
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f1573b;
    private ColorStateList c;
    private boolean d;
    private boolean e;
    private Shader.TileMode f;
    private Shader.TileMode g;
    private int h;
    private Drawable i;
    private Drawable j;
    private ImageView.ScaleType k;

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
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.FIT_XY;
        ImageView.ScaleType scaleType3 = ImageView.ScaleType.FIT_START;
        ImageView.ScaleType scaleType4 = ImageView.ScaleType.FIT_CENTER;
        ImageView.ScaleType scaleType5 = ImageView.ScaleType.FIT_END;
        ImageView.ScaleType scaleType6 = ImageView.ScaleType.CENTER;
        ImageView.ScaleType scaleType7 = ImageView.ScaleType.CENTER_CROP;
        ImageView.ScaleType scaleType8 = ImageView.ScaleType.CENTER_INSIDE;
    }

    public i(Context context, float f) {
        super(context);
        this.a = 0.0f;
        this.f1573b = 0.0f;
        this.c = ColorStateList.valueOf(-16777216);
        this.d = false;
        this.e = false;
        Shader.TileMode tileMode = l;
        this.f = tileMode;
        this.g = tileMode;
        this.a = f;
    }

    private Drawable a() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.h;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.h, e);
                this.h = 0;
            }
        }
        return h.b(drawable);
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof h) {
            ((h) drawable).a(this.k).b(this.a).a(this.f1573b).a(this.c).a(this.d).a(this.f).b(this.g);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                a(layerDrawable.getDrawable(i));
            }
        }
    }

    private void a(boolean z) {
        if (this.e) {
            if (z) {
                this.j = h.b(this.j);
            }
            a(this.j);
        }
    }

    private void b() {
        a(this.i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.c.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.c;
    }

    public float getBorderWidth() {
        return this.f1573b;
    }

    public float getCornerRadius() {
        return this.a;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.k;
    }

    public Shader.TileMode getTileModeX() {
        return this.f;
    }

    public Shader.TileMode getTileModeY() {
        return this.g;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.j = drawable;
        a(true);
        super.setBackgroundDrawable(this.j);
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.c.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.c = colorStateList;
        b();
        a(false);
        if (this.f1573b > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.f1573b == f) {
            return;
        }
        this.f1573b = f;
        b();
        a(false);
        invalidate();
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setCornerRadius(float f) {
        if (this.a == f) {
            return;
        }
        this.a = f;
        b();
        a(false);
    }

    public void setCornerRadius(int i) {
        setCornerRadius(getResources().getDimension(i));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.h = 0;
        this.i = h.a(bitmap);
        b();
        super.setImageDrawable(this.i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.h = 0;
        this.i = h.b(drawable);
        b();
        super.setImageDrawable(this.i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.h != i) {
            this.h = i;
            this.i = a();
            b();
            super.setImageDrawable(this.i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.d = z;
        b();
        a(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!m && scaleType == null) {
            throw new AssertionError();
        }
        if (this.k != scaleType) {
            this.k = scaleType;
            switch (a.a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    scaleType = ImageView.ScaleType.FIT_XY;
                    break;
            }
            super.setScaleType(scaleType);
            b();
            a(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.f == tileMode) {
            return;
        }
        this.f = tileMode;
        b();
        a(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.g == tileMode) {
            return;
        }
        this.g = tileMode;
        b();
        a(false);
        invalidate();
    }
}
