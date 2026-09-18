package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTInteractionStyle003002Layout extends TTInteractionStyleBaseFrameLayout {
    private PAGImageView g;
    private PAGTextView h;

    public TTInteractionStyle003002Layout(Context context) {
        this(context, null);
    }

    public PAGTextView getTtBuDescTV() {
        return this.h;
    }

    public PAGImageView getTtBuImg() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.layout.TTInteractionStyleBaseFrameLayout
    protected void h(Context context) {
        int iA = b0.a(context, 6.0f);
        setPadding(iA, iA, iA, iA);
        PAGFrameLayout pAGFrameLayoutA = a(context);
        this.a = pAGFrameLayoutA;
        pAGFrameLayoutA.setId(h.A0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int iA2 = b0.a(context, 26.0f);
        layoutParams.topMargin = iA2;
        this.a.setLayoutParams(layoutParams);
        addView(this.a);
        PAGImageView pAGImageView = new PAGImageView(context);
        this.g = pAGImageView;
        pAGImageView.setId(h.B0);
        this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = iA2;
        this.g.setLayoutParams(layoutParams2);
        addView(this.g);
        TTBackUpAdImageView tTBackUpAdImageViewB = b(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        int iA3 = b0.a(context, 10.0f);
        layoutParams3.leftMargin = iA3;
        layoutParams3.topMargin = iA3;
        layoutParams3.bottomMargin = iA3;
        tTBackUpAdImageViewB.setLayoutParams(layoutParams3);
        addView(tTBackUpAdImageViewB);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        pAGLinearLayout.setOrientation(0);
        pAGLinearLayout.setGravity(17);
        addView(pAGLinearLayout);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.h = pAGTextView;
        pAGTextView.setId(h.C0);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setMaxLines(1);
        this.h.setTextColor(-1);
        this.h.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.h.setLayoutParams(layoutParams4);
        pAGLinearLayout.addView(this.h);
    }

    public TTInteractionStyle003002Layout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTInteractionStyle003002Layout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
