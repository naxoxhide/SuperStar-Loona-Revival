package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.u;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeAnimationView extends LinearLayout {
    private ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f316b;
    private TextView c;
    private LinearLayout d;
    private int e;
    private int f;
    private int g;

    class a implements Runnable {

        /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$a$a, reason: collision with other inner class name */
        class AnimationAnimationListenerC0157a implements Animation.AnimationListener {
            final /* synthetic */ RotateAnimation a;

            /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$a$a$a, reason: collision with other inner class name */
            class RunnableC0158a implements Runnable {
                RunnableC0158a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ShakeAnimationView.this.a.startAnimation(AnimationAnimationListenerC0157a.this.a);
                }
            }

            AnimationAnimationListenerC0157a(RotateAnimation rotateAnimation) {
                this.a = rotateAnimation;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ShakeAnimationView.this.postDelayed(new RunnableC0158a(), 250L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.a != null) {
                RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new d(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new AnimationAnimationListenerC0157a(rotateAnimation));
                ShakeAnimationView.this.a.startAnimation(rotateAnimation);
            }
        }
    }

    class b implements u.a {
        b(ShakeAnimationView shakeAnimationView) {
        }
    }

    public interface c {
    }

    private static class d implements Interpolator {
        private d() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            return f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public ShakeAnimationView(Context context, View view, int i, int i2, int i3) {
        super(context);
        this.e = i;
        this.f = i2;
        this.g = i3;
        a(context, view);
    }

    public LinearLayout getShakeLayout() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.f316b == null) {
                this.f316b = new u(getContext().getApplicationContext());
            }
            this.f316b.a(new b(this));
            this.f316b.b(this.e);
            this.f316b.a(this.f);
            this.f316b.a(this.g);
            this.f316b.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u uVar = this.f316b;
        if (uVar != null) {
            uVar.a();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        u uVar = this.f316b;
        if (uVar != null) {
            if (z) {
                uVar.b();
            } else {
                uVar.a();
            }
        }
    }

    public void setOnShakeViewListener(c cVar) {
    }

    public void setShakeText(String str) {
        this.c.setText(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void a(Context context, View view) {
        addView(view);
        if (view instanceof com.bytedance.sdk.component.adexpress.layout.a) {
            com.bytedance.sdk.component.adexpress.layout.a aVar = (com.bytedance.sdk.component.adexpress.layout.a) view;
            this.d = aVar.getHandContainer();
            this.a = aVar.getRockImg();
            aVar.getRockTopText();
            this.c = aVar.getRockText();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.d.setBackground(gradientDrawable);
    }

    public void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new a(), 500L);
    }
}
