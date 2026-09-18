package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class SplashDiffuseView extends View {
    private static int d = 50;
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f321b;
    private ObjectAnimator c;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SplashDiffuseView.this.f321b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SplashDiffuseView.this.requestLayout();
        }
    }

    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SplashDiffuseView.this.c.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SplashDiffuseView.this.setVisibility(0);
            SplashDiffuseView.this.setAlpha(1.0f);
        }
    }

    public SplashDiffuseView(Context context) {
        this(context, null);
    }

    public void b() {
        int iMin = (int) Math.min(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        d = iMin;
        int i = iMin - 18;
        d = i;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(10, i);
        valueAnimatorOfInt.setInterpolator(b.b.a.a.d.e.b.b.a(0.2f, 0.0f, 0.3f, 1.0f));
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.addUpdateListener(new a());
        valueAnimatorOfInt.addListener(new b());
        valueAnimatorOfInt.start();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.a.setShader(new LinearGradient(getMeasuredWidth() / 2, 0.0f, getMeasuredWidth() / 2, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.f321b, this.a);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f321b = 10;
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setColor(Color.parseColor("#FFFFFFFF"));
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(18.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.c = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
    }
}
