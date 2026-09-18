package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTInteractionStyle009016HLayout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle009016HLayout(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView c(Context context) {
        PAGTextView pAGTextViewC = super.c(context);
        pAGTextViewC.setGravity(16);
        pAGTextViewC.setMaxWidth(b0.a(context, 53.0f));
        pAGTextViewC.setTextColor(-1);
        pAGTextViewC.setTextSize(2, 10.0f);
        return pAGTextViewC;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView d(Context context) {
        PAGTextView pAGTextViewD = super.d(context);
        pAGTextViewD.setGravity(16);
        pAGTextViewD.setMaxWidth(b0.a(context, 53.0f));
        pAGTextViewD.setTextColor(-1);
        pAGTextViewD.setTextSize(2, 8.0f);
        return pAGTextViewD;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView e(Context context) {
        PAGTextView pAGTextViewE = super.e(context);
        pAGTextViewE.setBackgroundResource(t.e(context, "tt_download_corner_bg"));
        pAGTextViewE.setTextSize(2, 8.0f);
        return pAGTextViewE;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected void h(Context context) {
        int iA = b0.a(context, 10.0f);
        int iA2 = b0.a(context, 5.0f);
        int iA3 = b0.a(context, 6.0f);
        int iA4 = b0.a(context, 16.0f);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGRelativeLayout.setLayoutParams(layoutParams);
        addView(pAGRelativeLayout);
        PAGFrameLayout pAGFrameLayoutA = a(context);
        this.a = pAGFrameLayoutA;
        pAGFrameLayoutA.setId(h.A0);
        this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        pAGRelativeLayout.addView(this.a);
        PAGImageView pAGImageViewG = g(context);
        this.f788b = pAGImageViewG;
        pAGImageViewG.setId(h.z0);
        this.f788b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        pAGRelativeLayout.addView(this.f788b);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(context);
        int i = h.r0;
        pAGRelativeLayout2.setId(i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, b0.a(context, 48.0f));
        layoutParams2.setMargins(iA2, iA2, iA2, iA2);
        layoutParams2.addRule(12);
        pAGRelativeLayout2.setBackgroundResource(t.e(context, "center_vertical"));
        pAGRelativeLayout2.setGravity(16);
        pAGRelativeLayout2.setLayoutParams(layoutParams2);
        pAGRelativeLayout.addView(pAGRelativeLayout2);
        TTRoundRectImageView tTRoundRectImageViewF = f(context);
        this.c = tTRoundRectImageViewF;
        int i2 = h.s0;
        tTRoundRectImageViewF.setId(i2);
        int iA5 = b0.a(context, 25.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA5, iA5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.c.setLayoutParams(layoutParams3);
        pAGRelativeLayout2.addView(this.c);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, i2);
        layoutParams4.addRule(1, i2);
        pAGLinearLayout.setLayoutParams(layoutParams4);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setOrientation(1);
        pAGRelativeLayout2.addView(pAGLinearLayout);
        PAGTextView pAGTextViewC = c(context);
        this.d = pAGTextViewC;
        pAGTextViewC.setId(h.x0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = iA3;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 17) {
            layoutParams5.setMarginStart(iA3);
        }
        this.d.setLayoutParams(layoutParams5);
        pAGLinearLayout.addView(this.d);
        PAGTextView pAGTextViewD = d(context);
        this.e = pAGTextViewD;
        pAGTextViewD.setId(h.y0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = iA3;
        if (i3 >= 17) {
            layoutParams6.setMarginStart(iA3);
        }
        this.e.setLayoutParams(layoutParams6);
        pAGLinearLayout.addView(this.e);
        PAGTextView pAGTextViewE = e(context);
        this.f = pAGTextViewE;
        pAGTextViewE.setId(h.t0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        this.f.setLayoutParams(layoutParams7);
        int iA6 = b0.a(context, 4.0f);
        this.f.setPadding(iA6, iA6, iA6, iA6);
        pAGRelativeLayout2.addView(this.f);
        View viewB = b(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, i);
        layoutParams8.leftMargin = iA4;
        layoutParams8.bottomMargin = iA;
        viewB.setLayoutParams(layoutParams8);
        pAGRelativeLayout.addView(viewB);
    }

    public TTInteractionStyle009016HLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle009016HLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
