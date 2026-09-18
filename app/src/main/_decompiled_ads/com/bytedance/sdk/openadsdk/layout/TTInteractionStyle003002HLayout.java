package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTInteractionStyle003002HLayout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle003002HLayout(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected void h(Context context) {
        int iA = b0.a(context, 10.0f);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        pAGLinearLayout.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setPadding(iA, iA, iA, iA);
        addView(pAGLinearLayout);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 3.0f;
        pAGFrameLayout.setLayoutParams(layoutParams2);
        pAGLinearLayout.addView(pAGFrameLayout);
        PAGFrameLayout pAGFrameLayoutA = a(context);
        this.a = pAGFrameLayoutA;
        pAGFrameLayoutA.setId(h.A0);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(this.a);
        PAGImageView pAGImageViewG = g(context);
        this.f788b = pAGImageViewG;
        pAGImageViewG.setId(h.z0);
        this.f788b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(this.f788b);
        TTBackUpAdImageView tTBackUpAdImageViewB = b(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = iA;
        layoutParams3.topMargin = iA;
        layoutParams3.bottomMargin = iA;
        tTBackUpAdImageViewB.setLayoutParams(layoutParams3);
        pAGFrameLayout.addView(tTBackUpAdImageViewB);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        pAGRelativeLayout.setLayoutParams(layoutParams4);
        pAGLinearLayout.addView(pAGRelativeLayout);
        TTRoundRectImageView tTRoundRectImageViewF = f(context);
        this.c = tTRoundRectImageViewF;
        int i = h.s0;
        tTRoundRectImageViewF.setId(i);
        int iA2 = b0.a(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams5.addRule(15);
        this.c.setLayoutParams(layoutParams5);
        pAGRelativeLayout.addView(this.c);
        PAGTextView pAGTextViewC = c(context);
        this.d = pAGTextViewC;
        pAGTextViewC.setId(h.x0);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        layoutParams6.leftMargin = iA;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams6.setMarginStart(iA);
        }
        layoutParams6.addRule(1, i);
        layoutParams6.addRule(17, i);
        this.d.setLayoutParams(layoutParams6);
        pAGRelativeLayout.addView(this.d);
        PAGTextView pAGTextViewE = e(context);
        this.f = pAGTextViewE;
        pAGTextViewE.setId(h.t0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(b0.a(context, 100.0f), b0.a(context, 32.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(21);
        layoutParams7.addRule(15);
        this.f.setLayoutParams(layoutParams7);
        pAGRelativeLayout.addView(this.f);
    }

    public TTInteractionStyle003002HLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle003002HLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
