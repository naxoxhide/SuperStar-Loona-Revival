package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class PAGPAGLoadingTwoLayout extends PAGLoadingBaseLayout {
    public PAGPAGLoadingTwoLayout(Context context) {
        super(context);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        int iA = b0.a(context, 80.0f);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.a = tTRoundRectImageView;
        tTRoundRectImageView.setId(520093745);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.topMargin = b0.a(context, 15.0f);
        layoutParams2.bottomMargin = b0.a(context, 40.0f);
        this.a.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        pAGTextView.setTextColor(Color.parseColor("#FFFFFF"));
        pAGTextView.setTextSize(1, 30.0f);
        pAGTextView.setText("Loading ");
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.d = pAGTextView2;
        pAGTextView2.setId(520093749);
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.d.setTextColor(Color.parseColor("#FFFFFF"));
        this.d.setTextSize(1, 30.0f);
        PAGTextView pAGTextView3 = new PAGTextView(context);
        pAGTextView3.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        pAGTextView3.setTextColor(Color.parseColor("#FFFFFF"));
        pAGTextView3.setTextSize(1, 30.0f);
        pAGTextView3.setText("%");
        linearLayout2.addView(pAGTextView);
        linearLayout2.addView(this.d);
        linearLayout2.addView(pAGTextView3);
        linearLayout.addView(this.a);
        linearLayout.addView(linearLayout2);
        a(context);
        addView(this.e);
        addView(linearLayout);
    }
}
