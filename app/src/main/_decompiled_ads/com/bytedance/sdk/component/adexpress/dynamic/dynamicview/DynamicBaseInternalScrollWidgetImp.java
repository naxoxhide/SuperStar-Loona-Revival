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
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements e {
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
            DynamicBaseInternalScrollWidgetImp.this.k();
        }
    }

    class b implements Animator.AnimatorListener {
        final /* synthetic */ View a;

        b(DynamicBaseInternalScrollWidgetImp dynamicBaseInternalScrollWidgetImp, View view) {
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

        c(DynamicBaseInternalScrollWidgetImp dynamicBaseInternalScrollWidgetImp, View view) {
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

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
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
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.B + 1)).getChildCount() <= 0) {
            this.C = true;
            childAt = getChildAt(this.B - 1);
            this.z = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.e + getChildAt(this.B).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.B + 1);
            this.z = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.e + getChildAt(this.B).getWidth())) / 2);
        }
        this.z.setInterpolator(new LinearInterpolator());
        this.z.addListener(new b(this, childAt2));
        if (this.C) {
            this.A = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.e + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.A = ObjectAnimator.ofFloat(childAt, "translationX", (this.e + childAt.getWidth()) / 2, 0.0f);
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
            this.B++;
        }
        postDelayed(this.D, 2000L);
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
