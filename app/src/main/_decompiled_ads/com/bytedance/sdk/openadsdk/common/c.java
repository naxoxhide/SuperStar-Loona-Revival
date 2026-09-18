package com.bytedance.sdk.openadsdk.common;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.p;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: LandingPageLoadingDefaultStyle.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends e {
    private AnimatorSet g;
    ObjectAnimator h;
    private LinearLayout i;

    public c(Context context, String str, String[] strArr, n nVar, p pVar) {
        super(context, str, strArr, nVar, pVar);
    }

    private View f() {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this.e);
        pAGLinearLayout.setGravity(17);
        pAGLinearLayout.setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(this.e);
        this.i = linearLayout;
        if (Build.VERSION.SDK_INT >= 17) {
            linearLayout.setLayoutDirection(0);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b0.a(this.e, 60.0f));
        this.i.setGravity(17);
        this.i.setOrientation(0);
        pAGLinearLayout.addView(this.i, layoutParams);
        int iA = b0.a(this.e, 17.0f);
        int iA2 = b0.a(this.e, 35.0f);
        int iA3 = b0.a(this.e, 1.5f);
        View view = new View(this.e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, iA2);
        int i = -iA3;
        layoutParams2.rightMargin = i;
        view.setBackgroundResource(t.e(this.e, "tt_ad_landing_loading_three_left"));
        this.i.addView(view, layoutParams2);
        View view2 = new View(this.e);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams3.rightMargin = i;
        view2.setBackgroundResource(t.e(this.e, "tt_ad_landing_loading_three_mid"));
        this.i.addView(view2, layoutParams3);
        View view3 = new View(this.e);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iA, iA2);
        view3.setBackgroundResource(t.e(this.e, "tt_ad_landing_loading_three_mid"));
        this.i.addView(view3, layoutParams4);
        View view4 = new View(this.e);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams5.leftMargin = i;
        view4.setBackgroundResource(t.e(this.e, "tt_ad_landing_loading_three_mid"));
        this.i.addView(view4, layoutParams5);
        View view5 = new View(this.e);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams6.leftMargin = i;
        view5.setBackgroundResource(t.e(this.e, "tt_ad_landing_loading_three_right"));
        this.i.addView(view5, layoutParams6);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(this.e);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = b0.a(this.e, 10.0f);
        pAGLinearLayout2.setGravity(17);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams7);
        PAGTextView pAGTextView = new PAGTextView(this.e);
        pAGTextView.setId(com.bytedance.sdk.openadsdk.utils.h.s1);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 17;
        pAGTextView.setGravity(17);
        pAGTextView.setPadding(b0.a(this.e, 10.0f), 0, 0, 0);
        pAGTextView.setText(t.k(this.e, "tt_loading_language"));
        pAGTextView.setTextColor(Color.parseColor("#80161823"));
        pAGTextView.setTextSize(14.0f);
        pAGLinearLayout2.addView(pAGTextView, layoutParams8);
        p pVar = this.f;
        if (pVar != null) {
            pAGTextView.setText(pVar.a());
        }
        return pAGLinearLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void a() {
        super.a();
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void a(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    protected void c() {
        this.d = f();
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void d() {
        this.g = new AnimatorSet();
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout.getChildAt(0), "translationY", -9.0f, 9.0f).setDuration(300L);
            this.h = duration;
            duration.setRepeatMode(2);
            this.h.setRepeatCount(-1);
            AnimatorSet.Builder builderPlay = this.g.play(this.h);
            for (int i = 1; i < this.i.getChildCount(); i++) {
                float f = -9.0f;
                if (i % 2 == 0) {
                    f = 9.0f;
                }
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.i.getChildAt(i), "translationY", -f, f).setDuration(300L);
                duration2.setRepeatMode(2);
                duration2.setRepeatCount(-1);
                builderPlay = builderPlay.with(duration2);
            }
            this.g.start();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void e() {
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
