package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class OC extends AnimatorListenerAdapter {
    public final /* synthetic */ C1265Sl A00;
    public final /* synthetic */ boolean A01;

    public OC(C1265Sl c1265Sl, boolean z) {
        this.A00 = c1265Sl;
        this.A01 = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.A00.A0M.setTranslationY(0.0f);
        this.A00.A0T();
        if (!this.A01 && this.A00.A0J != null) {
            this.A00.A0J.destroy();
        }
        if (this.A00.A0h == null) {
            return;
        }
        this.A00.A0h.setVisibility(this.A01 ? 8 : 0);
    }
}
