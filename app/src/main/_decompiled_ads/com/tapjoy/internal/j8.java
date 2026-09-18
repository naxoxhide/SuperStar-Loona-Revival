package com.tapjoy.internal;

import android.animation.Animator;
import com.tapjoy.TJCloseButton;

/* JADX INFO: loaded from: classes4.dex */
public final class j8 implements Animator.AnimatorListener {
    public final /* synthetic */ k8 a;

    public j8(k8 k8Var) {
        this.a = k8Var;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        TJCloseButton tJCloseButton = this.a.a;
        tJCloseButton.setClickable(tJCloseButton.a);
        this.a.a.f2685b = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        TJCloseButton tJCloseButton = this.a.a;
        tJCloseButton.setClickable(tJCloseButton.a);
        this.a.a.f2685b = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
