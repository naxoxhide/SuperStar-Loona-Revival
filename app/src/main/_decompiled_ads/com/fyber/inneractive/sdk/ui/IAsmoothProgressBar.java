package com.fyber.inneractive.sdk.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class IAsmoothProgressBar extends ProgressBar {
    public static final Interpolator c = new AccelerateDecelerateInterpolator();
    public ValueAnimator a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f1327b;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IAsmoothProgressBar.super.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IAsmoothProgressBar.super.setSecondaryProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public IAsmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f1327b;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (!(Build.VERSION.SDK_INT >= 11)) {
            super.setProgress(i);
            return;
        }
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.a;
        if (valueAnimator2 == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getProgress(), i);
            this.a = valueAnimatorOfInt;
            valueAnimatorOfInt.setInterpolator(c);
            this.a.addUpdateListener(new a());
        } else {
            valueAnimator2.setIntValues(getProgress(), i);
        }
        this.a.start();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setSecondaryProgress(int i) {
        if (!(Build.VERSION.SDK_INT >= 11)) {
            super.setSecondaryProgress(i);
            return;
        }
        ValueAnimator valueAnimator = this.f1327b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f1327b;
        if (valueAnimator2 == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getProgress(), i);
            this.f1327b = valueAnimatorOfInt;
            valueAnimatorOfInt.setInterpolator(c);
            this.f1327b.addUpdateListener(new b());
        } else {
            valueAnimator2.setIntValues(getProgress(), i);
        }
        this.f1327b.start();
    }

    public IAsmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
