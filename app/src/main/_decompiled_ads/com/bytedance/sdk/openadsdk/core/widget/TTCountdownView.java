package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class TTCountdownView extends View {
    public static final String u = t.k(o.a(), "tt_count_down_view");
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f695b;
    private int c;
    private boolean d;
    private float e;
    private float f;
    private String g;
    private boolean h;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;
    private float m;
    private float n;
    private RectF o;
    private c p;
    private AnimatorSet q;
    private ValueAnimator r;
    private ValueAnimator s;
    private ValueAnimator t;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TTCountdownView.this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TTCountdownView.this.postInvalidate();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TTCountdownView.this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TTCountdownView.this.postInvalidate();
        }
    }

    public interface c {
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.s = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.m, 0.0f);
        this.s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.s.setDuration((long) (a(this.m, this.e) * 1000.0f));
        this.s.addUpdateListener(new b());
        return this.s;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.r = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.n, 0.0f);
        this.r = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.r.setDuration((long) (a(this.n, this.f) * 1000.0f));
        this.r.addUpdateListener(new a());
        return this.r;
    }

    public float a(float f, float f2) {
        return f * f2;
    }

    public float a(float f, int i) {
        return i * f;
    }

    public c getCountdownListener() {
        return this.p;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = a();
        }
        if (mode2 != 1073741824) {
            size2 = a();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCountDownTime(int i) {
        float f = i;
        this.f = f;
        this.e = f;
        b();
    }

    public void setCountdownListener(c cVar) {
        this.p = cVar;
    }

    private int a() {
        return (int) ((((this.a / 2.0f) + this.f695b) * 2.0f) + b0.a(getContext(), 4.0f));
    }

    private void b(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
        String str = u;
        String str2 = this.h ? "" + ((int) Math.ceil(a(this.n, this.f))) : this.g;
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.l);
        canvas.restore();
    }

    private void a(Canvas canvas) {
        float f;
        canvas.save();
        float fA = a(this.m, 360);
        if (this.d) {
            f = this.c - fA;
        } else {
            f = this.c;
        }
        canvas.drawCircle(0.0f, 0.0f, this.f695b, this.j);
        canvas.drawCircle(0.0f, 0.0f, this.f695b, this.k);
        canvas.drawArc(this.o, f, fA, false, this.i);
        canvas.restore();
    }

    public void b() {
        AnimatorSet animatorSet = this.q;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.q = null;
        }
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.t = null;
        }
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.r = null;
        }
        ValueAnimator valueAnimator3 = this.s;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.s = null;
        }
        this.m = 1.0f;
        this.n = 1.0f;
        invalidate();
    }
}
