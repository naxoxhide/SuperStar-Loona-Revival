package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class LandingPageBrowserNewTitleBar extends RelativeLayout {
    public LandingPageBrowserNewTitleBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        setId(com.bytedance.sdk.openadsdk.utils.h.c0);
        setBackgroundColor(-1);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, b0.a(context, 44.0f)));
        PAGImageView pAGImageView = new PAGImageView(context);
        int i = com.bytedance.sdk.openadsdk.utils.h.d0;
        pAGImageView.setId(i);
        pAGImageView.setClickable(true);
        pAGImageView.setFocusable(true);
        pAGImageView.setPadding(b0.a(context, 12.0f), b0.a(context, 14.0f), b0.a(context, 12.0f), b0.a(context, 14.0f));
        pAGImageView.setImageResource(t.e(context, "tt_ad_xmark"));
        addView(pAGImageView, new RelativeLayout.LayoutParams(b0.a(context, 40.0f), b0.a(context, 44.0f)));
        PAGImageView pAGImageView2 = new PAGImageView(context);
        int i2 = com.bytedance.sdk.openadsdk.utils.h.f0;
        pAGImageView2.setId(i2);
        pAGImageView2.setPadding(b0.a(context, 8.0f), b0.a(context, 10.0f), b0.a(context, 8.0f), b0.a(context, 10.0f));
        pAGImageView2.setImageResource(t.e(context, "tt_ad_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b0.a(context, 40.0f), b0.a(context, 44.0f));
        layoutParams.addRule(11);
        addView(pAGImageView2, layoutParams);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(com.bytedance.sdk.openadsdk.utils.h.e0);
        pAGTextView.setSingleLine(true);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setGravity(17);
        pAGTextView.setTextColor(Color.parseColor("#222222"));
        pAGTextView.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b0.a(context, 191.0f), b0.a(context, 24.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, i2);
        layoutParams2.addRule(1, i);
        int iA = b0.a(context, 10.0f);
        layoutParams2.leftMargin = iA;
        layoutParams2.rightMargin = iA;
        addView(pAGTextView, layoutParams2);
        PAGProgressBar pAGProgressBar = new PAGProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        pAGProgressBar.setId(com.bytedance.sdk.openadsdk.utils.h.g0);
        pAGProgressBar.setProgress(1);
        pAGProgressBar.setProgressDrawable(t.f(context, "tt_privacy_progress_style"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, b0.a(context, 2.0f));
        layoutParams3.addRule(12);
        addView(pAGProgressBar, layoutParams3);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, b0.a(context, 0.5f));
        layoutParams4.addRule(12);
        addView(view, layoutParams4);
    }
}
