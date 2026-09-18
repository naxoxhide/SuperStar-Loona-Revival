package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class LandingPageBrowserTitleBar extends RelativeLayout {
    public LandingPageBrowserTitleBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, b0.a(context, 44.0f)));
        setBackgroundColor(Color.parseColor("#e0e0e0"));
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(520093720);
        pAGImageView.setClickable(true);
        pAGImageView.setFocusable(true);
        pAGImageView.setImageResource(t.e(context, "tt_leftbackicon_selector"));
        pAGImageView.setPadding(b0.a(context, 12.0f), b0.a(context, 5.0f), b0.a(context, 10.0f), b0.a(context, 5.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        addView(pAGImageView, layoutParams);
        PAGImageView pAGImageView2 = new PAGImageView(context);
        pAGImageView2.setId(520093716);
        pAGImageView2.setClickable(true);
        pAGImageView2.setFocusable(true);
        pAGImageView2.setPadding(b0.a(context, 12.0f), b0.a(context, 5.0f), b0.a(context, 10.0f), b0.a(context, 5.0f));
        pAGImageView2.setImageResource(t.e(context, "tt_titlebar_close_seletor"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 520093720);
        addView(pAGImageView2, layoutParams2);
        PAGTextView pAGTextView = new PAGTextView(context);
        int i = com.bytedance.sdk.openadsdk.utils.h.n0;
        pAGTextView.setId(i);
        pAGTextView.setPadding(b0.a(context, 12.0f), b0.a(context, 5.0f), b0.a(context, 10.0f), b0.a(context, 5.0f));
        pAGTextView.setTextColor(-16777216);
        pAGTextView.setText(t.j(context, "tt_reward_feedback"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        addView(pAGTextView, layoutParams3);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        pAGTextView2.setId(com.bytedance.sdk.openadsdk.utils.h.o0);
        pAGTextView2.setSingleLine(true);
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        pAGTextView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(b0.a(context, 240.0f), -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, 520093716);
        layoutParams4.addRule(0, i);
        int iA = b0.a(context, 25.0f);
        layoutParams4.rightMargin = iA;
        layoutParams4.leftMargin = iA;
        addView(pAGTextView2, layoutParams4);
    }
}
