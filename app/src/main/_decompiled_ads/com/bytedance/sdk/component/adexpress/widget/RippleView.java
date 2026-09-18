package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class RippleView extends View {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f314b;
    private ValueAnimator c;
    private ValueAnimator d;
    private Paint e;
    private long f;
    private float g;
    private float h;
    private Animator.AnimatorListener i;
    private int j;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RippleView.this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RippleView.this.invalidate();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RippleView.this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RippleView.this.invalidate();
        }
    }

    public RippleView(Context context, int i) {
        super(context);
        this.f = 300L;
        this.g = 0.0f;
        this.j = i;
        b();
    }

    public void b() {
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e.setColor(this.j);
    }

    public void c() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.h);
        this.c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addUpdateListener(new a());
        this.c.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.a, this.f314b, this.g, this.e);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i / 2.0f;
        this.f314b = i2 / 2.0f;
        this.h = (float) (Math.hypot(i, i2) / 2.0d);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.i = animatorListener;
    }

    public void a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.h, 0.0f);
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.addUpdateListener(new b());
        Animator.AnimatorListener animatorListener = this.i;
        if (animatorListener != null) {
            this.d.addListener(animatorListener);
        }
        this.d.start();
    }
}
