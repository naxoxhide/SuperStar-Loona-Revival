package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoPlayLayoutForLiveLayout extends PAGRelativeLayout {
    public TTVideoPlayLayoutForLiveLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setBackgroundColor(Color.parseColor("#000000"));
        setId(520093726);
        int iA = b0.a(context, 60.0f);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(h.G0);
        pAGFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        pAGFrameLayout.setBackgroundColor(0);
        addView(pAGFrameLayout);
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setId(h.H0);
        pAGImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        pAGImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        pAGFrameLayout.addView(pAGImageView);
        PAGProgressBar pAGProgressBar = new PAGProgressBar(context);
        pAGProgressBar.setId(h.I0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 17;
        pAGProgressBar.setLayoutParams(layoutParams);
        pAGProgressBar.setIndeterminateDrawable(t.f(context, "tt_video_loading_progress_bar"));
        pAGFrameLayout.addView(pAGProgressBar);
        PAGImageView pAGImageView2 = new PAGImageView(context);
        pAGImageView2.setId(h.J0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        pAGImageView2.setLayoutParams(layoutParams2);
        pAGImageView2.setScaleType(ImageView.ScaleType.CENTER);
        pAGImageView2.setImageDrawable(t.f(context, "tt_play_movebar_textpage"));
        pAGImageView2.setVisibility(8);
        addView(pAGImageView2);
        TTVideoAdCoverLayout tTVideoAdCoverLayout = new TTVideoAdCoverLayout(context);
        tTVideoAdCoverLayout.setId(h.D0);
        tTVideoAdCoverLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(tTVideoAdCoverLayout);
    }

    public TTVideoPlayLayoutForLiveLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTVideoPlayLayoutForLiveLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
