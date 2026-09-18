package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class PAGPAGLoadingThreeLayout extends PAGLoadingBaseLayout {
    public PAGPAGLoadingThreeLayout(Context context) {
        super(context);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        this.f = pAGLinearLayout;
        pAGLinearLayout.setId(520093750);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, b0.a(context, 60.0f)));
        this.f.setOrientation(0);
        this.f.setGravity(17);
        int iA = b0.a(context, 17.0f);
        int iA2 = b0.a(context, 35.0f);
        int iA3 = b0.a(context, -1.5f);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams2.rightMargin = iA3;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            layoutParams2.setMarginEnd(iA3);
        }
        view.setLayoutParams(layoutParams2);
        view.setBackground(t.f(context, "tt_ad_loading_three_left"));
        View view2 = new View(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams3.rightMargin = iA3;
        if (i >= 17) {
            layoutParams3.setMarginEnd(iA3);
        }
        view2.setLayoutParams(layoutParams3);
        view2.setBackground(t.f(context, "tt_ad_loading_three_mid"));
        View view3 = new View(context);
        view3.setLayoutParams(new LinearLayout.LayoutParams(iA, iA2));
        view3.setBackground(t.f(context, "tt_ad_loading_three_mid"));
        View view4 = new View(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams4.leftMargin = iA3;
        if (i >= 17) {
            layoutParams4.setMarginStart(iA3);
        }
        view4.setLayoutParams(layoutParams4);
        view4.setBackground(t.f(context, "tt_ad_loading_three_mid"));
        View view5 = new View(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iA, iA2);
        layoutParams5.leftMargin = iA3;
        if (i >= 17) {
            layoutParams5.setMarginStart(iA3);
        }
        view5.setLayoutParams(layoutParams5);
        view5.setBackground(t.f(context, "tt_ad_loading_three_right"));
        this.f.addView(view);
        this.f.addView(view2);
        this.f.addView(view3);
        this.f.addView(view4);
        this.f.addView(view5);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = b0.a(context, 10.0f);
        linearLayout2.setLayoutParams(layoutParams6);
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
        linearLayout.addView(this.f);
        linearLayout.addView(linearLayout2);
        a(context);
        addView(linearLayout);
        addView(this.e);
    }
}
