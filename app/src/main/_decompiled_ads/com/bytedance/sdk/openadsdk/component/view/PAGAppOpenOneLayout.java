package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

/* JADX INFO: loaded from: classes2.dex */
public class PAGAppOpenOneLayout extends PAGAppOpenBaseLayout {
    public PAGAppOpenOneLayout(Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(Color.parseColor("#000000"));
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        pAGLinearLayout.setOrientation(1);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(520093753);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 84.0f;
        pAGRelativeLayout.setLayoutParams(layoutParams);
        PAGImageView pAGImageView = new PAGImageView(context);
        this.a = pAGImageView;
        pAGImageView.setId(520093754);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        this.f550b = pAGFrameLayout;
        pAGFrameLayout.setId(520093755);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        this.f550b.setLayoutParams(layoutParams2);
        PAGImageView pAGImageView2 = new PAGImageView(context);
        this.c = pAGImageView2;
        pAGImageView2.setId(520093756);
        this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        PAGTextView pAGTextView = new PAGTextView(context);
        this.d = pAGTextView;
        pAGTextView.setId(520093757);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b0.a(context, 31.0f), b0.a(context, 14.0f));
        layoutParams3.addRule(12);
        this.d.setLayoutParams(layoutParams3);
        this.d.setBackground(t.f(context, "tt_ad_logo_new"));
        this.d.setGravity(17);
        View viewA = a(context);
        pAGRelativeLayout.addView(this.a);
        pAGRelativeLayout.addView(this.f550b);
        pAGRelativeLayout.addView(this.c);
        pAGRelativeLayout.addView(this.d);
        pAGRelativeLayout.addView(viewA);
        pAGRelativeLayout.addView(this.i);
        int iA = b0.a(context, 2.0f);
        int iA2 = b0.a(context, 20.0f);
        int iA3 = b0.a(context, 22.0f);
        int iA4 = b0.a(context, 40.0f);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        this.f = pAGLinearLayout2;
        pAGLinearLayout2.setId(520093758);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 16.0f;
        this.f.setLayoutParams(layoutParams4);
        this.f.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.f.setClickable(false);
        this.f.setGravity(17);
        this.f.setOrientation(0);
        this.f.setPadding(iA2, 0, iA2, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.g = tTRoundRectImageView;
        tTRoundRectImageView.setId(520093759);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iA4, iA4);
        layoutParams5.leftMargin = iA;
        layoutParams5.rightMargin = iA3;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams5.setMarginStart(iA);
            layoutParams5.setMarginEnd(iA3);
        }
        this.g.setLayoutParams(layoutParams5);
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
        pAGLinearLayout.addView(pAGRelativeLayout);
        pAGLinearLayout.addView(this.f);
        addView(pAGLinearLayout);
    }

    public View a(Context context) {
        ButtonFlash buttonFlash = new ButtonFlash(context);
        this.e = buttonFlash;
        buttonFlash.setId(520093717);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b0.a(context, 180.0f), b0.a(context, 43.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b0.a(context, 24.0f);
        this.e.setLayoutParams(layoutParams);
        this.e.setBackground(t.f(context, "tt_button_back"));
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setGravity(17);
        this.e.setLines(1);
        this.e.setText(t.j(context, "tt_video_download_apk"));
        this.e.setTextColor(Color.parseColor("#FFFFFF"));
        this.e.setTextSize(1, 16.0f);
        this.e.setTag("open_ad_click_button_tag");
        return this.e;
    }
}
