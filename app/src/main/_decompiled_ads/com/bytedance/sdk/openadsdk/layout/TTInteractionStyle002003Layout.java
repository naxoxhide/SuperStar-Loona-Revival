package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTInteractionStyle002003Layout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle002003Layout(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView c(Context context) {
        PAGTextView pAGTextViewC = super.c(context);
        pAGTextViewC.setTextColor(-1);
        return pAGTextViewC;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected void h(Context context) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGLinearLayout.setOrientation(1);
        addView(pAGLinearLayout);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 337.0f;
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
        layoutParams3.weight = 263.0f;
        pAGLinearLayout2.setLayoutParams(layoutParams3);
        pAGLinearLayout2.setOrientation(1);
        pAGLinearLayout2.setGravity(81);
        int iA2 = b0.a(context, 16.0f);
        pAGLinearLayout2.setPadding(iA2, iA2, iA2, iA2);
        pAGLinearLayout.addView(pAGLinearLayout2);
        TTRoundRectImageView tTRoundRectImageViewF = f(context);
        this.c = tTRoundRectImageViewF;
        tTRoundRectImageViewF.setId(h.s0);
        int iA3 = b0.a(context, 45.0f);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(iA3, iA3));
        pAGLinearLayout2.addView(this.c);
        PAGTextView pAGTextViewC = c(context);
        this.d = pAGTextViewC;
        pAGTextViewC.setId(h.x0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = b0.a(context, 4.0f);
        this.d.setLayoutParams(layoutParams4);
        pAGLinearLayout2.addView(this.d);
        PAGTextView pAGTextViewD = d(context);
        this.e = pAGTextViewD;
        pAGTextViewD.setId(h.y0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = iA;
        layoutParams5.bottomMargin = b0.a(context, 25.0f);
        this.e.setLayoutParams(layoutParams5);
        pAGLinearLayout2.addView(this.e);
        PAGTextView pAGTextViewE = e(context);
        this.f = pAGTextViewE;
        pAGTextViewE.setId(h.t0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, b0.a(context, 32.0f));
        layoutParams6.topMargin = iA2;
        this.f.setLayoutParams(layoutParams6);
        pAGLinearLayout2.addView(this.f);
    }

    public TTInteractionStyle002003Layout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle002003Layout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
