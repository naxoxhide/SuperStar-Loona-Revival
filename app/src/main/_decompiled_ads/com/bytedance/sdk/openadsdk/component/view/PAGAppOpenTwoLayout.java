package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.DSPAdChoice;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class PAGAppOpenTwoLayout extends PAGAppOpenBaseLayout {
    public PAGAppOpenTwoLayout(Context context) {
        super(context);
        setId(520093753);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(Color.parseColor("#000000"));
        int iA = b0.a(context, 8.0f);
        int iA2 = b0.a(context, 9.0f);
        int iA3 = b0.a(context, 10.0f);
        int iA4 = b0.a(context, 20.0f);
        int iA5 = b0.a(context, 40.0f);
        PAGImageView pAGImageView = new PAGImageView(context);
        this.a = pAGImageView;
        pAGImageView.setId(520093754);
        this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        this.f550b = pAGFrameLayout;
        pAGFrameLayout.setId(520093755);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f550b.setLayoutParams(layoutParams);
        PAGImageView pAGImageView2 = new PAGImageView(context);
        this.c = pAGImageView2;
        pAGImageView2.setId(520093756);
        this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        PAGTextView pAGTextView = new PAGTextView(context);
        this.d = pAGTextView;
        pAGTextView.setId(520093757);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b0.a(context, 31.0f), b0.a(context, 14.0f));
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            layoutParams2.setMarginStart(iA3);
        }
        layoutParams2.leftMargin = iA3;
        layoutParams2.bottomMargin = iA3;
        layoutParams2.addRule(12);
        this.d.setLayoutParams(layoutParams2);
        this.d.setBackground(t.f(context, "tt_ad_logo_new"));
        this.d.setGravity(17);
        DSPAdChoice dSPAdChoice = new DSPAdChoice(context);
        this.j = dSPAdChoice;
        dSPAdChoice.setPadding(iA2, 0, iA2, 0);
        this.j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b0.a(context, 32.0f), b0.a(context, 14.0f));
        layoutParams3.addRule(12);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(0, 0, iA3, iA3);
        this.j.setLayoutParams(layoutParams3);
        ButtonFlash buttonFlash = new ButtonFlash(context);
        this.e = buttonFlash;
        buttonFlash.setId(520093717);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(b0.a(context, 236.0f), b0.a(context, 48.0f));
        layoutParams4.addRule(2, 520093758);
        layoutParams4.addRule(14);
        layoutParams4.bottomMargin = b0.a(context, 24.0f);
        this.e.setLayoutParams(layoutParams4);
        this.e.setBackground(t.f(context, "tt_button_back"));
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setGravity(17);
        this.e.setLines(1);
        this.e.setText("DOWNLOAD");
        this.e.setTextColor(Color.parseColor("#FFFFFF"));
        this.e.setTextSize(1, 18.0f);
        this.e.setTag("open_ad_click_button_tag");
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        this.f = pAGLinearLayout;
        pAGLinearLayout.setId(520093758);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, b0.a(context, 60.0f));
        layoutParams5.addRule(12);
        layoutParams5.addRule(14);
        layoutParams5.leftMargin = iA4;
        layoutParams5.rightMargin = iA4;
        layoutParams5.bottomMargin = b0.a(context, 34.0f);
        if (i >= 17) {
            layoutParams5.setMarginStart(iA4);
            layoutParams5.setMarginEnd(iA4);
        }
        this.f.setLayoutParams(layoutParams5);
        this.f.setBackground(t.f(context, "tt_user_info"));
        this.f.setClickable(false);
        this.f.setGravity(17);
        this.f.setOrientation(0);
        this.f.setPadding(iA4, 0, iA4, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.g = tTRoundRectImageView;
        tTRoundRectImageView.setId(520093759);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(iA5, iA5);
        layoutParams6.rightMargin = iA;
        if (i >= 17) {
            layoutParams6.setMarginEnd(iA);
        }
        this.g.setLayoutParams(layoutParams6);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.h = pAGTextView2;
        pAGTextView2.setId(520093761);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setMaxLines(2);
        this.h.setTextColor(Color.parseColor("#161823"));
        this.h.setTextSize(1, 22.0f);
        this.f.addView(this.g);
        this.f.addView(this.h);
        addView(this.a);
        addView(this.f550b);
        addView(this.c);
        addView(this.d);
        addView(this.j);
        addView(this.e);
        addView(this.f);
        addView(this.i);
    }
}
