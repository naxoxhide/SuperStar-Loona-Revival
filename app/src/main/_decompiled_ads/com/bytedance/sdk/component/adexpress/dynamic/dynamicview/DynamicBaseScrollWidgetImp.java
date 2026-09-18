package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.h;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements e {
    ObjectAnimator A;
    private int B;
    private Runnable C;
    ObjectAnimator z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicBaseScrollWidgetImp.this.k();
        }
    }

    class b implements Animator.AnimatorListener {
        final /* synthetic */ View a;

        b(DynamicBaseScrollWidgetImp dynamicBaseScrollWidgetImp, View view) {
            this.a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class c implements Animator.AnimatorListener {
        final /* synthetic */ View a;

        c(DynamicBaseScrollWidgetImp dynamicBaseScrollWidgetImp, View view) {
            this.a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setVisibility(0);
        }
    }

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.B = 0;
        this.C = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View childAt = getChildAt(this.B);
        View childAt2 = getChildAt((this.B + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.f + getChildAt(this.B).getHeight())) / 2);
        this.z = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.z.addListener(new b(this, childAt));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.f + childAt2.getHeight()) / 2, 0.0f);
        this.A = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.A.addListener(new c(this, childAt2));
        this.z.setDuration(500L);
        this.A.setDuration(500L);
        this.z.start();
        this.A.start();
        int i = this.B + 1;
        this.B = i;
        this.B = i % getChildCount();
        postDelayed(this.C, 2000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e
    public void b() {
        removeCallbacks(this.C);
        ObjectAnimator objectAnimator = this.z;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.z.cancel();
        }
        ObjectAnimator objectAnimator2 = this.A;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.A.cancel();
        }
        super.b();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.f - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.C, 2500L);
    }
}
