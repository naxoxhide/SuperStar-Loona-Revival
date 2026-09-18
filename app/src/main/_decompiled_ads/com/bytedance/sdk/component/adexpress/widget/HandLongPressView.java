package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class HandLongPressView extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f310b;
    private CircleRippleView c;
    private AnimatorSet d;
    private boolean e;
    private TextView f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.f310b.getLayoutParams();
            layoutParams.topMargin = ((int) ((HandLongPressView.this.c.getMeasuredHeight() / 2.0f) - d.a(HandLongPressView.this.getContext(), 5.0f))) + ((int) d.a(HandLongPressView.this.a, 20.0f));
            layoutParams.leftMargin = ((int) ((HandLongPressView.this.c.getMeasuredWidth() / 2.0f) - d.a(HandLongPressView.this.getContext(), 5.0f))) + ((int) d.a(HandLongPressView.this.a, 20.0f));
            layoutParams.bottomMargin = (int) (((-HandLongPressView.this.c.getMeasuredHeight()) / 2.0f) + d.a(HandLongPressView.this.getContext(), 5.0f));
            layoutParams.rightMargin = (int) (((-HandLongPressView.this.c.getMeasuredWidth()) / 2.0f) + d.a(HandLongPressView.this.getContext(), 5.0f));
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            HandLongPressView.this.f310b.setLayoutParams(layoutParams);
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
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (HandLongPressView.this.e) {
                HandLongPressView.this.c.b();
                HandLongPressView.this.c.setAlpha(1.0f);
            } else {
                HandLongPressView.this.c.c();
                HandLongPressView.this.c.setAlpha(0.0f);
            }
            HandLongPressView handLongPressView = HandLongPressView.this;
            handLongPressView.e = !handLongPressView.e;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(HandLongPressView.this.f310b, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            objectAnimatorOfFloat.start();
            HandLongPressView.this.f310b.setVisibility(0);
        }
    }

    public HandLongPressView(Context context) {
        super(context);
        this.e = true;
        this.a = context;
        this.d = new AnimatorSet();
        c();
        b();
        post(new a());
    }

    public void setGuideText(String str) {
        this.f.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.f.setTextColor(i);
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f310b, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new b());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f310b, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void c() {
        this.c = new CircleRippleView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) d.a(this.a, 80.0f), (int) d.a(this.a, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) d.a(this.a, 20.0f);
        int iA = (int) d.a(this.a, 20.0f);
        layoutParams.leftMargin = iA;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(iA);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        addView(this.c, layoutParams);
        this.c.b();
        this.f310b = new ImageView(this.a);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) d.a(this.a, 80.0f), (int) d.a(this.a, 80.0f));
        this.f310b.setImageResource(t.e(this.a, "tt_splash_hand"));
        addView(this.f310b, layoutParams2);
        TextView textView = new TextView(this.a);
        this.f = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) d.a(this.a, 10.0f);
        addView(this.f, layoutParams3);
    }

    public void d() {
        this.d.start();
    }

    public void a() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.c;
        if (circleRippleView != null) {
            circleRippleView.c();
        }
    }
}
