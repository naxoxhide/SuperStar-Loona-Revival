package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class PressButtonInteractView extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f311b;
    private SplashDiffuseView c;
    private AnimatorSet d;
    private boolean e;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.f311b.getLayoutParams();
            layoutParams.topMargin = (int) ((PressButtonInteractView.this.c.getMeasuredHeight() / 2.0f) - d.a(PressButtonInteractView.this.getContext(), 5.0f));
            layoutParams.leftMargin = (int) ((PressButtonInteractView.this.c.getMeasuredWidth() / 2.0f) - d.a(PressButtonInteractView.this.getContext(), 5.0f));
            layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.c.getMeasuredHeight()) / 2.0f) + d.a(PressButtonInteractView.this.getContext(), 5.0f));
            layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.c.getMeasuredWidth()) / 2.0f) + d.a(PressButtonInteractView.this.getContext(), 5.0f));
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            PressButtonInteractView.this.f311b.setLayoutParams(layoutParams);
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
            if (PressButtonInteractView.this.e) {
                PressButtonInteractView.this.c.b();
            }
            PressButtonInteractView pressButtonInteractView = PressButtonInteractView.this;
            pressButtonInteractView.e = !pressButtonInteractView.e;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(PressButtonInteractView.this.f311b, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.start();
            PressButtonInteractView.this.f311b.setVisibility(0);
        }
    }

    public PressButtonInteractView(Context context) {
        super(context);
        this.e = true;
        this.a = context;
        this.d = new AnimatorSet();
        c();
        b();
        post(new a());
    }

    public void d() {
        this.d.start();
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f311b, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new b());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f311b, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void c() {
        this.c = new SplashDiffuseView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) d.a(this.a, 40.0f), (int) d.a(this.a, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.c, layoutParams);
        this.f311b = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) d.a(this.a, 62.0f), (int) d.a(this.a, 62.0f));
        layoutParams2.gravity = 16;
        this.f311b.setImageResource(t.e(this.a, "tt_splash_hand"));
        addView(this.f311b, layoutParams2);
    }

    public void a() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
