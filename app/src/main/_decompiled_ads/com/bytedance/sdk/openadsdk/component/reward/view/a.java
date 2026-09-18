package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: compiled from: RFViewHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(h.w);
        pAGRelativeLayout.setBackgroundColor(Color.parseColor("#F8F8F8"));
        frameLayout.addView(pAGRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
        LandingPageLoadingLayout landingPageLoadingLayout = new LandingPageLoadingLayout(context);
        landingPageLoadingLayout.setId(h.x);
        pAGRelativeLayout.addView(landingPageLoadingLayout, new RelativeLayout.LayoutParams(-1, -1));
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(h.y);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setVisibility(8);
        pAGLinearLayout.setGravity(1);
        pAGLinearLayout.setId(h.G);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        pAGRelativeLayout.addView(pAGLinearLayout, layoutParams);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        tTRoundRectImageView.setId(h.z);
        pAGLinearLayout.addView(tTRoundRectImageView, new LinearLayout.LayoutParams(b0.a(context, 80.0f), b0.a(context, 80.0f)));
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(h.A);
        pAGTextView.setTextColor(Color.parseColor("#161823"));
        pAGTextView.setTextSize(2, 24.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = b0.a(context, 12.0f);
        pAGLinearLayout.addView(pAGTextView, layoutParams2);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        pAGTextView2.setId(h.B);
        pAGTextView2.setGravity(17);
        pAGTextView2.setTextColor(Color.parseColor("#80161823"));
        pAGTextView2.setTextSize(2, 16.0f);
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            pAGTextView2.setTextAlignment(4);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        int iA = b0.a(context, 60.0f);
        layoutParams3.leftMargin = iA;
        layoutParams3.rightMargin = iA;
        if (i >= 17) {
            layoutParams3.setMarginStart(iA);
            layoutParams3.setMarginEnd(layoutParams3.rightMargin);
        }
        layoutParams3.topMargin = b0.a(context, 8.0f);
        pAGLinearLayout.addView(pAGTextView2, layoutParams3);
        PAGTextView pAGTextView3 = new PAGTextView(context);
        pAGTextView3.setId(h.C);
        pAGTextView3.setGravity(17);
        pAGTextView3.setTextColor(-1);
        pAGTextView3.setText(t.j(context, "tt_video_mobile_go_detail"));
        pAGTextView3.setBackgroundResource(t.e(context, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(b0.a(context, 255.0f), b0.a(context, 44.0f));
        layoutParams4.topMargin = b0.a(context, 32.0f);
        pAGLinearLayout.addView(pAGTextView3, layoutParams4);
        PAGTextView pAGTextView4 = new PAGTextView(context);
        pAGTextView4.setId(h.D);
        pAGTextView4.setBackgroundResource(t.e(context, "tt_ad_logo_new"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(b0.a(context, 32.0f), b0.a(context, 14.0f));
        layoutParams5.addRule(12);
        int iA2 = b0.a(context, 16.0f);
        layoutParams5.leftMargin = iA2;
        if (i >= 17) {
            layoutParams5.setMarginStart(iA2);
        }
        layoutParams5.bottomMargin = b0.a(context, 20.0f);
        pAGRelativeLayout.addView(pAGTextView4, layoutParams5);
    }

    public static void b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setId(h.l);
        rFDownloadBarLayout.setVisibility(8);
        rFDownloadBarLayout.setPadding(b0.a(context, 15.0f), 0, 0, 0);
        rFDownloadBarLayout.setBackgroundColor(t.c(context, "tt_download_bar_background_new"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b0.a(context, 90.0f));
        layoutParams.gravity = 80;
        frameLayout.addView(rFDownloadBarLayout, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(h.m);
        pAGLinearLayout.setVisibility(8);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        sSWebView.setId(h.n);
        frameLayout.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setVisibility(8);
        sSWebView2.setId(h.o);
        frameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(new RFEndCardBackUpLayout(context), new FrameLayout.LayoutParams(-1, -1));
    }
}
