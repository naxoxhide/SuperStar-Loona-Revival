package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTInteractionStyle016009HLayout extends TTInteractionStyleBaseFrameLayout {
    public TTInteractionStyle016009HLayout(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView c(Context context) {
        PAGTextView pAGTextViewC = super.c(context);
        pAGTextViewC.setGravity(16);
        pAGTextViewC.setMaxWidth(b0.a(context, 250.0f));
        pAGTextViewC.setTextColor(-1);
        pAGTextViewC.setTextSize(2, 17.0f);
        pAGTextViewC.setText("APP NAME");
        return pAGTextViewC;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected PAGTextView e(Context context) {
        PAGTextView pAGTextViewE = super.e(context);
        pAGTextViewE.setBackgroundResource(t.e(context, "tt_download_corner_bg"));
        pAGTextViewE.setTextSize(2, 15.0f);
        return pAGTextViewE;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected void h(Context context) {
        int iA = b0.a(context, 10.0f);
        b0.a(context, 5.0f);
        b0.a(context, 6.0f);
        int iA2 = b0.a(context, 16.0f);
        int iA3 = b0.a(context, 15.0f);
        int iA4 = b0.a(context, 20.0f);
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
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, b0.a(context, 60.0f));
        layoutParams2.addRule(12);
        layoutParams2.rightMargin = iA3;
        layoutParams2.leftMargin = iA3;
        layoutParams2.bottomMargin = iA3;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            layoutParams2.setMarginEnd(iA3);
            layoutParams2.setMarginStart(iA3);
        }
        pAGRelativeLayout2.setBackgroundColor(Color.parseColor("#26000000"));
        pAGRelativeLayout2.setLayoutParams(layoutParams2);
        pAGRelativeLayout.addView(pAGRelativeLayout2);
        TTRoundRectImageView tTRoundRectImageViewF = f(context);
        this.c = tTRoundRectImageViewF;
        int i3 = h.s0;
        tTRoundRectImageViewF.setId(i3);
        int iA5 = b0.a(context, 50.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA5, iA5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.c.setLayoutParams(layoutParams3);
        pAGRelativeLayout2.addView(this.c);
        PAGTextView pAGTextViewC = c(context);
        this.d = pAGTextViewC;
        pAGTextViewC.setId(h.x0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = iA4;
        if (i2 >= 17) {
            layoutParams4.setMarginStart(iA4);
        }
        layoutParams4.addRule(1, i3);
        layoutParams4.addRule(17, i3);
        this.d.setLayoutParams(layoutParams4);
        pAGRelativeLayout2.addView(this.d);
        PAGTextView pAGTextViewE = e(context);
        this.f = pAGTextViewE;
        pAGTextViewE.setId(h.t0);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(b0.a(context, 100.0f), b0.a(context, 30.0f));
        layoutParams5.addRule(21);
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        layoutParams5.rightMargin = iA;
        if (i2 >= 17) {
            layoutParams5.setMarginEnd(iA);
        }
        this.f.setLayoutParams(layoutParams5);
        pAGRelativeLayout2.addView(this.f);
        View viewB = b(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(2, i);
        layoutParams6.leftMargin = iA2;
        layoutParams6.bottomMargin = iA;
        viewB.setLayoutParams(layoutParams6);
        pAGRelativeLayout.addView(viewB);
    }

    public TTInteractionStyle016009HLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle016009HLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
