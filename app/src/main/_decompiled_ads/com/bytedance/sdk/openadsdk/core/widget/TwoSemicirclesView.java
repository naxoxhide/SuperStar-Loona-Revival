package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class TwoSemicirclesView extends View {
    private final RectF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f698b;
    private int c;
    private Paint d;
    private Paint e;
    private float f;
    private float g;
    private int h;
    private int i;

    public TwoSemicirclesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = -90.0f;
        this.g = 220.0f;
        this.h = Color.parseColor("#FFFFFF");
        this.i = Color.parseColor("#C4C4C4");
        a();
        float f = this.g;
        float f2 = -f;
        this.a = new RectF(f2, f2, f, f);
    }

    private void a() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(this.h);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(4.0f);
        this.d.setAlpha(20);
        Paint paint2 = new Paint(this.d);
        this.e = paint2;
        paint2.setColor(this.i);
        this.e.setAlpha(255);
    }

    public Paint getPaintOne() {
        return this.d;
    }

    public Paint getPaintTwo() {
        return this.e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.a;
        float f = this.g;
        float f2 = -f;
        rectF.set(f2, f2, f, f);
        canvas.translate(this.f698b / 2, this.c / 2);
        canvas.drawArc(this.a, this.f, 180.0f, false, this.d);
        canvas.drawArc(this.a, this.f + 180.0f, 180.0f, false, this.e);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f698b = i;
        this.c = i2;
    }

    public void setCurrentStartAngle(float f) {
        this.f = f;
        postInvalidate();
    }

    public void setPaintOne(Paint paint) {
        this.d = paint;
        postInvalidate();
    }

    public void setPaintTwo(Paint paint) {
        this.e = paint;
        postInvalidate();
    }

    public void setRadius(float f) {
        this.g = f;
        postInvalidate();
    }
}
