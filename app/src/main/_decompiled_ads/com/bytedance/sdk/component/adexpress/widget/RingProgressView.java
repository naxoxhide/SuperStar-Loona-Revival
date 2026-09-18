package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class RingProgressView extends View {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f313b;
    private RectF c;
    private float d;
    private ValueAnimator e;
    private int f;
    private boolean g;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RingProgressView.this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RingProgressView.this.requestLayout();
        }
    }

    public RingProgressView(Context context) {
        super(context);
        this.f = 1500;
        this.a = context;
        Paint paint = new Paint();
        this.f313b = paint;
        paint.setAntiAlias(true);
        this.f313b.setStyle(Paint.Style.STROKE);
        this.f313b.setStrokeWidth(10.0f);
        this.f313b.setColor(Color.parseColor("#80FFFFFF"));
        this.c = new RectF();
    }

    public void b() {
        this.g = true;
        invalidate();
    }

    public void c() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f);
        this.e.addUpdateListener(new a());
        this.e.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.g) {
            return;
        }
        canvas.drawArc(this.c, 270.0f, this.d, false, this.f313b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    public void setDuration(int i) {
        this.f = i;
    }

    public void a() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
