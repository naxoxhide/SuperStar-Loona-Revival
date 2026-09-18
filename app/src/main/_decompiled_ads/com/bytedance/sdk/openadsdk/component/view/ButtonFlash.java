package com.bytedance.sdk.openadsdk.component.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class ButtonFlash extends TextView {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f548b;
    private Paint c;
    private LinearGradient d;
    private RectF e;
    private Matrix f;
    private ValueAnimator g;
    private boolean h;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((ButtonFlash.this.a * 2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()) - ButtonFlash.this.a;
            if (ButtonFlash.this.f != null) {
                ButtonFlash.this.f.setTranslate(fFloatValue, ButtonFlash.this.f548b);
            }
            if (ButtonFlash.this.d != null) {
                ButtonFlash.this.d.setLocalMatrix(ButtonFlash.this.f);
            }
            ButtonFlash.this.invalidate();
        }
    }

    public ButtonFlash(Context context) {
        super(context);
        this.h = true;
        a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f != null) {
            canvas.drawRoundRect(this.e, 100.0f, 100.0f, this.c);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i;
        this.f548b = i2;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.a / 2.0f, this.f548b, new int[]{ViewCompat.MEASURED_SIZE_MASK, 1358954495, ViewCompat.MEASURED_SIZE_MASK}, new float[]{0.1f, 0.3f, 0.5f}, Shader.TileMode.CLAMP);
        this.d = linearGradient;
        this.c.setShader(linearGradient);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        Matrix matrix = new Matrix();
        this.f = matrix;
        matrix.setTranslate(-this.a, this.f548b);
        this.d.setLocalMatrix(this.f);
        this.e.set(0.0f, 0.0f, this.a, this.f548b);
    }

    public void setAutoRun(boolean z) {
        this.h = z;
    }

    private void a() {
        this.e = new RectF();
        this.c = new Paint();
        b();
    }

    private void b() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(3000L);
        this.g.addUpdateListener(new a());
        if (this.h) {
            this.g.setRepeatCount(-1);
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public void c() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.g.cancel();
            invalidate();
        }
    }
}
