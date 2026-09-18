package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.d.c;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashSlideUp;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashSlideUp5;
import com.bytedance.sdk.component.utils.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: loaded from: classes2.dex */
public class SlideUpView extends RelativeLayout {
    private ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f320b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private AnimatorSet f;
    private AnimatorSet g;
    private AnimatorSet h;
    private AnimatorSet i;
    private String j;
    private int k;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.SlideUpView$a$a, reason: collision with other inner class name */
        class RunnableC0159a implements Runnable {
            RunnableC0159a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SlideUpView.this.f.start();
            }
        }

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            SlideUpView.this.postDelayed(new RunnableC0159a(), 200L);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.c.getLayoutParams();
            layoutParams.height = num.intValue();
            SlideUpView.this.c.setLayoutParams(layoutParams);
        }
    }

    public SlideUpView(Context context) {
        super(context);
        this.f = new AnimatorSet();
        this.g = new AnimatorSet();
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        this.k = 100;
        a(context);
    }

    public void c() {
        b();
        this.f.start();
        this.f.addListener(new a());
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void setGuideText(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.e != null) {
            if (TextUtils.isEmpty(str)) {
                this.e.setText("");
            } else {
                this.e.setText(str);
            }
        }
    }

    protected void a(Context context) {
        if (context == null) {
            context = c.a();
        }
        if (CampaignEx.CLICKMODE_ON.equals(this.j)) {
            addView(new TTDynamicSplashSlideUp5(context));
            this.k = (int) (((double) this.k) * 1.25d);
        } else {
            addView(new TTDynamicSplashSlideUp(context));
        }
        this.a = (ImageView) findViewById(b.b.a.a.d.d.a.o);
        this.f320b = (ImageView) findViewById(b.b.a.a.d.d.a.n);
        this.d = (TextView) findViewById(b.b.a.a.d.d.a.s);
        this.c = (ImageView) findViewById(b.b.a.a.d.d.a.p);
        this.e = (TextView) findViewById(b.b.a.a.d.d.a.r);
    }

    public void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.a, "translationY", 0.0f, d.a(getContext(), -this.k));
        objectAnimatorOfFloat3.setInterpolator(b.b.a.a.d.e.b.b.a(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) d.a(getContext(), this.k));
        valueAnimatorOfInt.addUpdateListener(new b());
        valueAnimatorOfInt.setInterpolator(b.b.a.a.d.e.b.b.a(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.c, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.f320b, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.f320b, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.f320b, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.f320b, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.f320b, "translationY", 0.0f, d.a(getContext(), -this.k));
        objectAnimatorOfFloat10.setInterpolator(b.b.a.a.d.e.b.b.a(0.2f, 0.0f, 0.3f, 1.0f));
        this.g.setDuration(50L);
        this.i.setDuration(1500L);
        this.h.setDuration(50L);
        this.g.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.h.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.i.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.f.playSequentially(this.h, this.i, this.g);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.f = new AnimatorSet();
        this.g = new AnimatorSet();
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        this.k = 100;
        setClipChildren(false);
        this.j = str;
        a(context);
    }

    public void a() {
        try {
            AnimatorSet animatorSet = this.f;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.h;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.g;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.i;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            m.b(e.getMessage());
        }
    }
}
