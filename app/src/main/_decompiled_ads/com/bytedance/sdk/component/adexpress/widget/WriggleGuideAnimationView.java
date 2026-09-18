package com.bytedance.sdk.component.adexpress.widget;

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
import com.bytedance.sdk.component.adexpress.layout.TTHandWriggleGuide;
import com.bytedance.sdk.component.utils.u;

/* JADX INFO: loaded from: classes2.dex */
public class WriggleGuideAnimationView extends LinearLayout {
    private TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f324b;
    private u c;
    private TextView d;
    private LinearLayout e;
    private WriggleGuideView f;
    private int g;

    class a implements Runnable {

        /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView$a$a, reason: collision with other inner class name */
        class AnimationAnimationListenerC0160a implements Animation.AnimationListener {
            final /* synthetic */ RotateAnimation a;

            /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView$a$a$a, reason: collision with other inner class name */
            class RunnableC0161a implements Runnable {
                RunnableC0161a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    WriggleGuideAnimationView.this.f324b.startAnimation(AnimationAnimationListenerC0160a.this.a);
                }
            }

            AnimationAnimationListenerC0160a(RotateAnimation rotateAnimation) {
                this.a = rotateAnimation;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                WriggleGuideAnimationView.this.postDelayed(new RunnableC0161a(), 300L);
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
            if (WriggleGuideAnimationView.this.f324b != null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -35.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setInterpolator(new d(null));
                rotateAnimation.setDuration(1500L);
                rotateAnimation.setAnimationListener(new AnimationAnimationListenerC0160a(rotateAnimation));
                WriggleGuideAnimationView.this.f324b.startAnimation(rotateAnimation);
            }
        }
    }

    class b implements u.a {
        b(WriggleGuideAnimationView wriggleGuideAnimationView) {
        }
    }

    public interface c {
    }

    private static class d implements Interpolator {
        private d() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.4f) {
                return f * 2.5f;
            }
            return f <= 0.8f ? (f * (-2.2f)) + 1.86f : (f * (-0.7f)) + 0.7f;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public WriggleGuideAnimationView(Context context, View view, int i) {
        super(context);
        this.g = i;
        a(context, view);
    }

    public TextView getTopTextView() {
        return this.a;
    }

    public LinearLayout getWriggleLayout() {
        return this.e;
    }

    public WriggleGuideView getWriggleProgressIv() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.c == null) {
                this.c = new u(getContext().getApplicationContext());
            }
            this.c.a(new b(this));
            this.c.c(this.g);
            this.c.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u uVar = this.c;
        if (uVar != null) {
            uVar.a();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        u uVar = this.c;
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
        this.d.setText(str);
    }

    private void a(Context context, View view) {
        setClipChildren(false);
        addView(view);
        if (view instanceof TTHandWriggleGuide) {
            TTHandWriggleGuide tTHandWriggleGuide = (TTHandWriggleGuide) view;
            this.e = tTHandWriggleGuide.getWriggleLayout();
            this.f324b = tTHandWriggleGuide.getTopImage();
            this.f = tTHandWriggleGuide.getProgressImg();
            this.a = tTHandWriggleGuide.getTopText();
            this.d = tTHandWriggleGuide.getBarText();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.e.setBackground(gradientDrawable);
    }

    public void a() {
        postDelayed(new a(), 500L);
    }
}
