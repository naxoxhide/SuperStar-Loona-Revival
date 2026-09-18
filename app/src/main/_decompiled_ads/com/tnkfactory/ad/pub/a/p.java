package com.tnkfactory.ad.pub.a;

import android.view.animation.Animation;
import android.widget.TextView;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements Animation.AnimationListener {
    public final /* synthetic */ TextView a;

    public p(TextView textView) {
        this.a = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.a.clearAnimation();
        this.a.setSelected(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
