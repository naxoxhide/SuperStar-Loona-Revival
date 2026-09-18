package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoDetailLayout extends PAGRelativeLayout {
    public TTVideoDetailLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setId(520093726);
        setBackgroundColor(-1);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(h.G0);
        pAGRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        pAGRelativeLayout.setBackgroundColor(0);
        pAGRelativeLayout.setGravity(17);
        addView(pAGRelativeLayout);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(h.H0);
        pAGImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        pAGRelativeLayout.addView(pAGImageView);
        PAGProgressBar pAGProgressBar = new PAGProgressBar(context);
        pAGProgressBar.setId(h.I0);
        int iA = b0.a(context, 60.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(13);
        pAGProgressBar.setLayoutParams(layoutParams);
        pAGProgressBar.setIndeterminateDrawable(t.f(context, "tt_video_loading_progress_bar"));
        pAGRelativeLayout.addView(pAGProgressBar);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(h.K0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        pAGLinearLayout.setLayoutParams(layoutParams2);
        pAGLinearLayout.setGravity(1);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setVisibility(8);
        pAGRelativeLayout.addView(pAGLinearLayout);
        PAGImageView pAGImageView2 = new PAGImageView(context);
        pAGImageView2.setId(h.L0);
        pAGImageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        pAGImageView2.setImageDrawable(t.f(context, "tt_refreshing_video_textpage"));
        pAGImageView2.setScaleType(ImageView.ScaleType.CENTER);
        pAGLinearLayout.addView(pAGImageView2);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(h.M0);
        pAGTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        pAGTextView.setText(t.j(context, "tt_video_retry_des_txt"));
        pAGTextView.setTextColor(Color.parseColor("#999999"));
        pAGLinearLayout.addView(pAGTextView);
        PAGImageView pAGImageView3 = new PAGImageView(context);
        pAGImageView3.setId(h.J0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        pAGImageView3.setLayoutParams(layoutParams3);
        pAGImageView3.setScaleType(ImageView.ScaleType.CENTER);
        pAGImageView3.setImageDrawable(t.f(context, "tt_play_movebar_textpage"));
        pAGImageView3.setVisibility(8);
        addView(pAGImageView3);
        PAGImageView pAGImageView4 = new PAGImageView(context);
        pAGImageView4.setId(h.N0);
        int iA2 = b0.a(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams4.addRule(21);
        layoutParams4.addRule(11);
        int iA3 = b0.a(context, 7.0f);
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            layoutParams4.setMarginEnd(iA3);
        }
        layoutParams4.rightMargin = iA3;
        layoutParams4.topMargin = iA3;
        pAGImageView4.setLayoutParams(layoutParams4);
        pAGImageView4.setBackground(t.f(context, "tt_detail_video_btn_bg"));
        pAGImageView4.setScaleType(ImageView.ScaleType.CENTER);
        pAGImageView4.setImageDrawable(t.f(context, "tt_close_move_detail"));
        addView(pAGImageView4);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        pAGTextView2.setId(h.O0);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(9);
        layoutParams5.addRule(20);
        layoutParams5.addRule(10);
        pAGTextView2.setLayoutParams(layoutParams5);
        pAGTextView2.setBackground(t.f(context, "tt_video_black_desc_gradient"));
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView2.setMaxLines(2);
        int iA4 = b0.a(context, 15.0f);
        pAGTextView2.setPadding(iA4, b0.a(context, 14.0f), iA4, 0);
        pAGTextView2.setSingleLine(false);
        pAGTextView2.setTextColor(-1);
        pAGTextView2.setTextSize(2, 17.0f);
        pAGTextView2.setVisibility(8);
        addView(pAGTextView2);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(context);
        pAGRelativeLayout2.setId(h.P0);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(10);
        pAGRelativeLayout2.setLayoutParams(layoutParams6);
        pAGRelativeLayout2.setBackground(t.f(context, "tt_video_black_desc_gradient"));
        pAGRelativeLayout2.setGravity(16);
        pAGRelativeLayout2.setVisibility(8);
        addView(pAGRelativeLayout2);
        PAGImageView pAGImageView5 = new PAGImageView(context);
        int i2 = h.Q0;
        pAGImageView5.setId(i2);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams7.addRule(15);
        int iA5 = b0.a(context, 12.0f);
        layoutParams7.leftMargin = iA5;
        if (i >= 17) {
            layoutParams7.setMarginStart(iA5);
        }
        pAGImageView5.setLayoutParams(layoutParams7);
        pAGImageView5.setScaleType(ImageView.ScaleType.CENTER);
        pAGImageView5.setImageDrawable(t.f(context, "tt_leftbackbutton_titlebar_photo_preview"));
        pAGRelativeLayout2.addView(pAGImageView5);
        PAGTextView pAGTextView3 = new PAGTextView(context);
        pAGTextView3.setId(h.R0);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams8.addRule(15);
        int iA6 = b0.a(context, 16.0f);
        layoutParams8.leftMargin = iA6;
        layoutParams8.rightMargin = iA;
        if (i >= 17) {
            layoutParams8.setMarginStart(iA6);
            layoutParams8.setMarginEnd(iA);
        }
        layoutParams8.addRule(17, i2);
        int i3 = h.S0;
        layoutParams8.addRule(0, i3);
        layoutParams8.addRule(1, i2);
        layoutParams8.addRule(16, i3);
        pAGTextView3.setLayoutParams(layoutParams8);
        pAGTextView3.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView3.setGravity(16);
        pAGTextView3.setMaxLines(1);
        pAGTextView3.setSingleLine(true);
        pAGTextView3.setTextColor(-1);
        pAGTextView3.setTextSize(2, 17.0f);
        pAGRelativeLayout2.addView(pAGTextView3);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        pAGLinearLayout2.setId(i3);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(21);
        layoutParams9.addRule(11);
        int iA7 = b0.a(context, 14.0f);
        layoutParams9.rightMargin = iA7;
        if (i >= 17) {
            layoutParams9.setMarginEnd(iA7);
        }
        pAGLinearLayout2.setLayoutParams(layoutParams9);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(1);
        pAGRelativeLayout2.addView(pAGLinearLayout2);
        PAGTextView pAGTextView4 = new PAGTextView(context);
        pAGTextView4.setId(h.T0);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.gravity = 1;
        pAGTextView4.setLayoutParams(layoutParams10);
        pAGTextView4.setGravity(16);
        pAGTextView4.setMaxLines(1);
        pAGTextView4.setSingleLine(true);
        pAGTextView4.setTextColor(-1);
        pAGTextView4.setTextSize(2, 12.0f);
        pAGLinearLayout2.addView(pAGTextView4);
        PAGLinearLayout pAGLinearLayout3 = new PAGLinearLayout(context);
        pAGLinearLayout3.setId(h.U0);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, b0.a(context, 40.0f));
        layoutParams11.addRule(12);
        layoutParams11.addRule(21);
        layoutParams11.addRule(11);
        pAGLinearLayout3.setLayoutParams(layoutParams11);
        pAGLinearLayout3.setGravity(16);
        pAGLinearLayout3.setOrientation(0);
        pAGLinearLayout3.setVisibility(8);
        addView(pAGLinearLayout3);
        PAGTextView pAGTextView5 = new PAGTextView(context);
        pAGTextView5.setId(h.V0);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.leftMargin = iA6;
        layoutParams12.rightMargin = iA5;
        if (i >= 17) {
            layoutParams12.setMarginEnd(iA5);
            layoutParams12.setMarginStart(iA6);
        }
        pAGTextView5.setLayoutParams(layoutParams12);
        pAGTextView5.setText(t.j(context, "tt_00_00"));
        pAGTextView5.setTextColor(-1);
        pAGTextView5.setTextSize(2, 10.0f);
        pAGLinearLayout3.addView(pAGTextView5);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(h.W0);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, b0.a(context, 5.0f));
        layoutParams13.gravity = 16;
        seekBar.setLayoutParams(layoutParams13);
        seekBar.setMax(100);
        seekBar.setPadding(0, 0, 0, 0);
        seekBar.setProgressDrawable(t.f(context, "tt_seek_progress"));
        seekBar.setThumb(t.f(context, "tt_seek_thumb"));
        seekBar.setThumbOffset(0);
        pAGLinearLayout3.addView(seekBar);
        PAGTextView pAGTextView6 = new PAGTextView(context);
        pAGTextView6.setId(h.X0);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams14.leftMargin = iA5;
        layoutParams14.rightMargin = iA6;
        if (i >= 17) {
            layoutParams14.setMarginEnd(iA6);
            layoutParams14.setMarginStart(iA5);
        }
        pAGTextView6.setLayoutParams(layoutParams14);
        pAGTextView6.setText(t.j(context, "tt_00_00"));
        pAGTextView6.setTextColor(-1);
        pAGTextView6.setTextSize(2, 10.0f);
        pAGLinearLayout3.addView(pAGTextView6);
        PAGImageView pAGImageView6 = new PAGImageView(context);
        pAGImageView6.setId(h.Y0);
        pAGImageView6.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        pAGImageView6.setPadding(iA6, 0, iA6, 0);
        pAGImageView6.setScaleType(ImageView.ScaleType.CENTER);
        pAGImageView6.setVisibility(8);
        pAGImageView6.setImageDrawable(t.f(context, "tt_enlarge_video"));
        pAGLinearLayout3.addView(pAGImageView6);
        TTVideoAdCoverLayout tTVideoAdCoverLayout = new TTVideoAdCoverLayout(context);
        tTVideoAdCoverLayout.setId(h.D0);
        tTVideoAdCoverLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(tTVideoAdCoverLayout);
        PAGTextView pAGTextView7 = new PAGTextView(context);
        pAGTextView7.setId(h.Z0);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = iA5;
        layoutParams15.addRule(9);
        layoutParams15.addRule(20);
        pAGTextView7.setLayoutParams(layoutParams15);
        pAGTextView7.setBackgroundColor(Color.parseColor("#00000000"));
        pAGTextView7.setText("close");
        pAGTextView7.setMinHeight(b0.a(context, 44.0f));
        pAGTextView7.setCompoundDrawablesWithIntrinsicBounds(t.f(context, "tt_shadow_btn_back"), (Drawable) null, (Drawable) null, (Drawable) null);
        addView(pAGTextView7);
    }

    public TTVideoDetailLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTVideoDetailLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
