package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class PAGAppOpenTopBarView extends PAGRelativeLayout {
    private PAGTextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PAGTextView f551b;

    public PAGAppOpenTopBarView(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int iA = b0.a(context, 12.0f);
        int iA2 = b0.a(context, 16.0f);
        int iA3 = b0.a(context, 20.0f);
        int iA4 = b0.a(context, 24.0f);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.a = pAGTextView;
        pAGTextView.setId(520093713);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA4);
        layoutParams.topMargin = iA3;
        layoutParams.leftMargin = iA2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            layoutParams.setMarginStart(iA2);
        }
        this.a.setLayoutParams(layoutParams);
        this.a.setBackground(t.f(context, "tt_app_open_top_bg"));
        this.a.setGravity(17);
        this.a.setPadding(iA, 0, iA, 0);
        this.a.setText(t.k(context, "tt_reward_feedback"));
        this.a.setTextColor(Color.parseColor("#ffffff"));
        this.a.setTextSize(1, 14.0f);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.f551b = pAGTextView2;
        pAGTextView2.setId(520093714);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, iA4);
        layoutParams2.topMargin = iA3;
        layoutParams2.rightMargin = iA2;
        if (i >= 17) {
            layoutParams2.setMarginEnd(iA2);
        }
        layoutParams2.addRule(11);
        if (i >= 17) {
            layoutParams2.addRule(21);
        }
        this.f551b.setLayoutParams(layoutParams2);
        this.f551b.setBackground(t.f(context, "tt_app_open_top_bg"));
        this.f551b.setGravity(17);
        this.f551b.setPadding(iA, 0, iA, 0);
        this.f551b.setText(t.j(context, "tt_txt_skip"));
        this.f551b.setTextColor(Color.parseColor("#ffffff"));
        this.f551b.setTextSize(1, 14.0f);
        addView(this.a);
        addView(this.f551b);
    }

    public PAGTextView getTopDislike() {
        return this.a;
    }

    public PAGTextView getTopSkip() {
        return this.f551b;
    }
}
