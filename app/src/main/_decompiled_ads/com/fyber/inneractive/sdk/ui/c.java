package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ AnimatorSet a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FyberAdIdentifier f1328b;

    public c(FyberAdIdentifier fyberAdIdentifier, AnimatorSet animatorSet) {
        this.f1328b = fyberAdIdentifier;
        this.a = animatorSet;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        FyberAdIdentifier fyberAdIdentifier = this.f1328b;
        if (fyberAdIdentifier.d) {
            fyberAdIdentifier.a.setImageResource(R.drawable.fyber_info_button);
        } else {
            Bitmap bitmap = fyberAdIdentifier.h;
            if (bitmap != null) {
                fyberAdIdentifier.a.setImageBitmap(bitmap);
            } else {
                fyberAdIdentifier.a.setImageResource(R.drawable.digital_turbine_logo);
            }
        }
        this.a.start();
        this.f1328b.e = this.a;
    }
}
