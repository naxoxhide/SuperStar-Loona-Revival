package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class SlideRightView extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f318b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private AnimatorSet f;
    private AnimatorSet g;
    private AnimatorSet h;
    private AnimatorSet i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.f318b.getLayoutParams();
            layoutParams.topMargin = (int) ((SlideRightView.this.c.getMeasuredHeight() / 2.0f) - d.a(SlideRightView.this.getContext(), 7.0f));
            int i = -SlideRightView.this.c.getMeasuredWidth();
            layoutParams.leftMargin = i;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                layoutParams.setMarginStart(i);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            SlideRightView.this.f318b.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SlideRightView.this.d.getLayoutParams();
            layoutParams2.topMargin = (int) ((SlideRightView.this.c.getMeasuredHeight() / 2.0f) - d.a(SlideRightView.this.getContext(), 5.0f));
            layoutParams2.leftMargin = (int) (SlideRightView.this.c.getMeasuredWidth() / 2.0f);
            if (i2 >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            SlideRightView.this.d.setLayoutParams(layoutParams2);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.d.getLayoutParams();
            layoutParams.width = num.intValue();
            SlideRightView.this.d.setLayoutParams(layoutParams);
        }
    }

    class c extends AnimatorListenerAdapter {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SlideRightView.this.f.start();
            }
        }

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            SlideRightView.this.postDelayed(new a(), 200L);
        }
    }

    public SlideRightView(Context context) {
        super(context);
        this.f = new AnimatorSet();
        this.g = new AnimatorSet();
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        this.a = context;
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setGuideText(String str) {
        this.e.setText(str);
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f318b, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f);
        this.h.setDuration(300L);
        this.h.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f318b, "translationX", 0.0f, d.a(getContext(), 80.0f));
        objectAnimatorOfFloat5.setInterpolator(b.b.a.a.d.e.b.b.a(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) d.a(getContext(), 80.0f));
        valueAnimatorOfInt.addUpdateListener(new b());
        valueAnimatorOfInt.setInterpolator(b.b.a.a.d.e.b.b.a(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.c, "translationX", 0.0f, d.a(getContext(), 80.0f));
        objectAnimatorOfFloat6.setInterpolator(b.b.a.a.d.e.b.b.a(0.2f, 0.0f, 0.3f, 1.0f));
        this.i.setDuration(1500L);
        this.i.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.f318b, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.d, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.0f);
        this.g.setDuration(50L);
        this.g.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.f.playSequentially(this.h, this.i, this.g);
    }

    private void b() {
        ImageView imageView = new ImageView(this.a);
        this.d = imageView;
        imageView.setBackgroundResource(t.e(this.a, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        addView(this.d, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.a);
        this.c = imageView2;
        imageView2.setImageResource(t.e(this.a, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) d.a(this.a, 50.0f), (int) d.a(this.a, 50.0f));
        layoutParams2.gravity = 48;
        addView(this.c, layoutParams2);
        ImageView imageView3 = new ImageView(this.a);
        this.f318b = imageView3;
        imageView3.setImageResource(t.e(this.a, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) d.a(this.a, 80.0f), (int) d.a(this.a, 80.0f));
        layoutParams3.gravity = 48;
        addView(this.f318b, layoutParams3);
        TextView textView = new TextView(this.a);
        this.e = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.e, layoutParams4);
        post(new a());
    }

    public void c() {
        a();
        this.f.start();
        this.f.addListener(new c());
    }
}
