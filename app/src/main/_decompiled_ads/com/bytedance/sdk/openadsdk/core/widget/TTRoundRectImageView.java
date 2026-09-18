package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;

/* JADX INFO: loaded from: classes2.dex */
public class TTRoundRectImageView extends PAGImageView {
    private final Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f697b;
    private int c;
    private final Matrix d;
    private final RectF e;
    private BitmapShader f;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapA;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.f == null && (bitmapA = a(drawable)) != null) {
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f = new BitmapShader(bitmapA, tileMode, tileMode);
            float fMax = (bitmapA.getWidth() == getWidth() && bitmapA.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
            this.d.setScale(fMax, fMax);
            this.f.setLocalMatrix(this.d);
        }
        BitmapShader bitmapShader = this.f;
        if (bitmapShader == null) {
            super.onDraw(canvas);
        } else {
            this.a.setShader(bitmapShader);
            canvas.drawRoundRect(this.e, this.f697b, this.c, this.a);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e.set(0.0f, 0.0f, i, i2);
    }

    public void setXRound(int i) {
        this.f697b = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.c = i;
        postInvalidate();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        this.f = null;
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f697b = 25;
        this.c = 25;
        this.e = new RectF();
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        this.d = new Matrix();
    }
}
