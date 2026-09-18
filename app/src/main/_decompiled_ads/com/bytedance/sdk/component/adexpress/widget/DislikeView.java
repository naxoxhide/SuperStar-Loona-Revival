package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class DislikeView extends View {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f303b;
    private RectF c;
    private Paint d;
    private Paint e;
    private int f;
    private Paint g;
    private int h;

    public DislikeView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.e = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.c;
        float f = this.f;
        canvas.drawRoundRect(rectF, f, f, this.e);
        RectF rectF2 = this.c;
        float f2 = this.f;
        canvas.drawRoundRect(rectF2, f2, f2, this.d);
        float f3 = this.a;
        float f4 = this.f303b;
        canvas.drawLine(f3 * 0.3f, f4 * 0.3f, f3 * 0.7f, f4 * 0.7f, this.g);
        float f5 = this.a;
        float f6 = this.f303b;
        canvas.drawLine(f5 * 0.7f, f6 * 0.3f, f5 * 0.3f, f6 * 0.7f, this.g);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i;
        this.f303b = i2;
        int i5 = this.h;
        float f = i5;
        this.c = new RectF(f, f, this.a - i5, this.f303b - i5);
    }

    public void setBgColor(int i) {
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.g.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.g.setStrokeWidth(i);
    }

    public void setRadius(int i) {
        this.f = i;
    }

    public void setStrokeColor(int i) {
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.d.setStrokeWidth(i);
        this.h = i;
    }
}
