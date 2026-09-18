package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.h;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements e {
    ObjectAnimator A;
    private int B;
    private boolean C;
    private Runnable D;
    ObjectAnimator z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicVerticalScrollWidgetImp.this.k();
        }
    }

    class b implements Animator.AnimatorListener {
        final /* synthetic */ View a;

        b(DynamicVerticalScrollWidgetImp dynamicVerticalScrollWidgetImp, View view) {
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

        c(DynamicVerticalScrollWidgetImp dynamicVerticalScrollWidgetImp, View view) {
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

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.B = 0;
        this.C = false;
        this.D = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View childAt;
        View childAt2 = getChildAt(this.B);
        int i = this.B;
        if (i == 0) {
            this.C = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.B + 1)).getChildCount() <= 0;
        if (this.k.n().g().x0() || !z) {
            View childAt3 = z ? getChildAt((this.B + 2) % getChildCount()) : getChildAt((this.B + 1) % getChildCount());
            this.z = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (-(this.f + getChildAt(this.B).getHeight())) / 2);
            if (z) {
                this.B++;
            }
            childAt = childAt3;
        } else {
            this.C = true;
            childAt = getChildAt(this.B - 1);
            this.z = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (this.f + getChildAt(this.B).getHeight()) / 2);
        }
        this.z.setInterpolator(new LinearInterpolator());
        this.z.addListener(new b(this, childAt2));
        if (this.C) {
            this.A = ObjectAnimator.ofFloat(childAt, "translationY", (-(this.f + childAt.getHeight())) / 2, 0.0f);
        } else {
            this.A = ObjectAnimator.ofFloat(childAt, "translationY", (this.f + childAt.getHeight()) / 2, 0.0f);
        }
        this.A.setInterpolator(new LinearInterpolator());
        this.A.addListener(new c(this, childAt));
        this.z.setDuration(500L);
        this.A.setDuration(500L);
        this.z.start();
        this.A.start();
        if (this.C) {
            this.B--;
        } else {
            int i2 = this.B + 1;
            this.B = i2;
            this.B = i2 % getChildCount();
        }
        postDelayed(this.D, 3000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e
    public void b() {
        removeCallbacks(this.D);
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
        postDelayed(this.D, 2500L);
    }
}
