package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: DynamicShadowDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends Drawable {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f275b;
    private int c;
    private RectF d;

    public c(int i, int i2) {
        this.c = i;
        this.f275b = i2;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(0);
        this.a.setAntiAlias(true);
        this.a.setShadowLayer(i2, 0.0f, 0.0f, -16777216);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.d;
        float f = this.c;
        canvas.drawRoundRect(rectF, f, f, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.f275b;
        this.d = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
