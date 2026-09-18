package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashLayoutBrushMaskView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBrushMaskView extends FrameLayout {
    private RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BrushMaskView f304b;
    private TextView c;
    private Context d;
    private ObjectAnimator e;
    private ImageView f;
    private ImageView g;
    private FrameLayout h;
    private volatile boolean i;
    private volatile boolean j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (DynamicBrushMaskView.this.e == null || !DynamicBrushMaskView.this.e.isStarted()) {
                    DynamicBrushMaskView.this.b();
                }
            } catch (Exception e) {
                m.a("DynamicBrushMaskView", e.getMessage());
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FrameLayout.LayoutParams a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f305b;

        b(FrameLayout.LayoutParams layoutParams, float f) {
            this.a = layoutParams;
            this.f305b = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (DynamicBrushMaskView.this.f != null) {
                this.a.width = (int) (this.f305b * animatedFraction);
                DynamicBrushMaskView.this.f.setLayoutParams(this.a);
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ FrameLayout.LayoutParams a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DynamicBrushMaskView.this.j = false;
                if (DynamicBrushMaskView.this.i) {
                    return;
                }
                DynamicBrushMaskView.this.e.start();
            }
        }

        c(FrameLayout.LayoutParams layoutParams) {
            this.a = layoutParams;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (DynamicBrushMaskView.this.f304b != null) {
                if (DynamicBrushMaskView.this.f != null) {
                    this.a.width = 0;
                    DynamicBrushMaskView.this.f.setLayoutParams(this.a);
                }
                if (DynamicBrushMaskView.this.i) {
                    return;
                }
                DynamicBrushMaskView.this.j = true;
                DynamicBrushMaskView.this.f304b.postDelayed(new a(), 100L);
            }
        }
    }

    public DynamicBrushMaskView(Context context) {
        super(context);
        this.j = false;
        this.d = context;
        TTDynamicSplashLayoutBrushMaskView tTDynamicSplashLayoutBrushMaskView = new TTDynamicSplashLayoutBrushMaskView(context);
        addView(tTDynamicSplashLayoutBrushMaskView);
        a(tTDynamicSplashLayoutBrushMaskView);
    }

    public void c() {
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            try {
                ObjectAnimator objectAnimator = this.e;
                if (objectAnimator == null || !(objectAnimator.isStarted() || this.e.isRunning() || this.j)) {
                    BrushMaskView brushMaskView = this.f304b;
                    if (brushMaskView != null) {
                        brushMaskView.c();
                    }
                    RelativeLayout relativeLayout = this.a;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    b();
                }
            } catch (Exception e) {
                m.b("DynamicBrushMaskView", e.getMessage());
            }
        }
    }

    public void setBrushText(String str) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f304b != null) {
            this.i = false;
            int iD = d.d(this.d);
            int i = (iD * 336) / 375;
            int i2 = (i * 80) / 336;
            this.h.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            float height = (this.f304b.getHeight() * 3) / 5.0f;
            float width = this.f304b.getWidth() / 6.0f;
            float height2 = this.f304b.getHeight() / 2.0f;
            float f = i;
            float f2 = f - (f / 3.0f);
            this.f304b.setEraserSize(height);
            float fA = d.a(getContext(), 15.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f2, i2 / 2);
            int i3 = i2 / 4;
            layoutParams.topMargin = i3;
            float f3 = f / 6.0f;
            int i4 = (int) f3;
            layoutParams.leftMargin = i4;
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 17) {
                layoutParams.setMarginStart(i4);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            this.f.setLayoutParams(layoutParams);
            int i6 = (iD * 58) / 375;
            this.g.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i6, (i6 * 76) / 58);
            layoutParams2.topMargin = (int) (i3 + fA);
            int i7 = (int) (f3 - (fA * 1.5f));
            layoutParams2.leftMargin = i7;
            if (i5 >= 17) {
                layoutParams2.setMarginStart(i7);
                layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            }
            this.a.setLayoutParams(layoutParams2);
            this.f304b.b(width, height2);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "translationX", 0.0f, f2);
            this.e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1000L);
            this.e.setRepeatMode(1);
            this.e.addUpdateListener(new b(layoutParams, f2));
            this.e.addListener(new c(layoutParams));
            ObjectAnimator objectAnimator = this.e;
            if (objectAnimator == null || objectAnimator.isStarted() || this.e.isRunning() || this.j) {
                return;
            }
            this.e.start();
        }
    }

    public void d() {
        if (this.i) {
            return;
        }
        this.i = true;
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            RelativeLayout relativeLayout = this.a;
            if (relativeLayout != null) {
                relativeLayout.clearAnimation();
                this.a.setVisibility(4);
            }
            this.f304b.c();
        }
        BrushMaskView brushMaskView = this.f304b;
        if (brushMaskView != null) {
            brushMaskView.setEraserSize(brushMaskView.getHeight());
            BrushMaskView brushMaskView2 = this.f304b;
            brushMaskView2.b(0.0f, brushMaskView2.getHeight() / 2.0f);
            this.f304b.a();
        }
    }

    private void a(TTDynamicSplashLayoutBrushMaskView tTDynamicSplashLayoutBrushMaskView) {
        this.f304b = tTDynamicSplashLayoutBrushMaskView.getBrushMaskView();
        this.a = tTDynamicSplashLayoutBrushMaskView.getBrushHandRelativeLayout();
        this.f = tTDynamicSplashLayoutBrushMaskView.getFirstStepImage();
        this.h = tTDynamicSplashLayoutBrushMaskView.getSplashBrushFl();
        this.g = tTDynamicSplashLayoutBrushMaskView.getImageHand();
        this.h.setClipChildren(false);
        this.c = tTDynamicSplashLayoutBrushMaskView.getBrushView();
        BrushMaskView brushMaskView = this.f304b;
        if (brushMaskView != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                brushMaskView.setWatermark(t.e(this.d, "tt_splash_brush_bg"));
            }
            this.f304b.post(new a());
        }
    }

    public void a() {
        clearAnimation();
    }
}
