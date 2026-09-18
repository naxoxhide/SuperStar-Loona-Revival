package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class OB implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C1265Sl A00;

    public OB(C1265Sl c1265Sl) {
        this.A00 = c1265Sl;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        this.A00.A0A.getLayoutParams().height = num.intValue();
        this.A00.A0A.requestLayout();
    }
}
