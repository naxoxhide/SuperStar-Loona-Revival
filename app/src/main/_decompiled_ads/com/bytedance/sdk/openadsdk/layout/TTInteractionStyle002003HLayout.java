package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.adxcorp.util.ADXLogUtil;
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
public class TTInteractionStyle002003HLayout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle002003HLayout(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView c(Context context) {
        PAGTextView pAGTextViewC = super.c(context);
        pAGTextViewC.setTextColor(-1);
        pAGTextViewC.setTextSize(2, 13.0f);
        pAGTextViewC.setText(ADXLogUtil.PLATFORM_PANGLE);
        return pAGTextViewC;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView d(Context context) {
        PAGTextView pAGTextViewD = super.d(context);
        pAGTextViewD.setTextColor(-1);
        return pAGTextViewD;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected void h(Context context) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGLinearLayout.setOrientation(1);
        addView(pAGLinearLayout);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 2.0f;
        pAGFrameLayout.setLayoutParams(layoutParams);
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
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        int iA = b0.a(context, 10.0f);
        layoutParams2.leftMargin = iA;
        layoutParams2.topMargin = iA;
        layoutParams2.bottomMargin = iA;
        tTBackUpAdImageViewB.setLayoutParams(layoutParams2);
        pAGFrameLayout.addView(tTBackUpAdImageViewB);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        pAGLinearLayout2.setLayoutParams(layoutParams3);
        pAGLinearLayout2.setOrientation(1);
        pAGLinearLayout2.setGravity(81);
        int iA2 = b0.a(context, 16.0f);
        pAGLinearLayout2.setPadding(iA2, iA2, iA2, iA2);
        pAGLinearLayout.addView(pAGLinearLayout2);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(h.v0);
        pAGRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, b0.a(context, 40.0f)));
        pAGRelativeLayout.setGravity(17);
        pAGLinearLayout2.addView(pAGRelativeLayout);
        TTRoundRectImageView tTRoundRectImageViewF = f(context);
        this.c = tTRoundRectImageViewF;
        tTRoundRectImageViewF.setId(h.s0);
        int iA3 = b0.a(context, 35.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA3, iA3);
        layoutParams4.addRule(20);
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        this.c.setLayoutParams(layoutParams4);
        pAGRelativeLayout.addView(this.c);
        PAGTextView pAGTextViewC = c(context);
        this.d = pAGTextViewC;
        pAGTextViewC.setId(h.x0);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, iA * 2);
        int iA4 = b0.a(context, 6.0f);
        layoutParams5.leftMargin = iA4;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            layoutParams5.setMarginStart(iA4);
        }
        layoutParams5.addRule(1, this.c.getId());
        layoutParams5.addRule(17, this.c.getId());
        this.d.setLayoutParams(layoutParams5);
        pAGRelativeLayout.addView(this.d);
        PAGTextView pAGTextViewD = d(context);
        this.e = pAGTextViewD;
        pAGTextViewD.setId(h.y0);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, b0.a(context, 20.0f));
        layoutParams6.addRule(3, this.d.getId());
        layoutParams6.addRule(8, this.c.getId());
        layoutParams6.addRule(17, this.c.getId());
        layoutParams6.addRule(1, this.c.getId());
        layoutParams6.leftMargin = iA4;
        if (i >= 17) {
            layoutParams6.setMarginStart(iA4);
        }
        this.e.setLayoutParams(layoutParams6);
        pAGRelativeLayout.addView(this.e);
        PAGTextView pAGTextViewE = e(context);
        this.f = pAGTextViewE;
        pAGTextViewE.setId(h.t0);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, b0.a(context, 22.0f));
        layoutParams7.topMargin = iA2;
        this.f.setLayoutParams(layoutParams7);
        pAGLinearLayout2.addView(this.f);
    }

    public TTInteractionStyle002003HLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle002003HLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
