package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.TwoSemicirclesView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class PAGLoadingBaseLayout extends PAGRelativeLayout {
    TTRoundRectImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    PAGTextView f540b;
    ProgressBar c;
    PAGTextView d;
    PAGTextView e;
    PAGLinearLayout f;
    TwoSemicirclesView g;
    TwoSemicirclesView h;

    public PAGLoadingBaseLayout(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(Color.parseColor("#161823"));
    }

    public void a(Context context) {
        this.e = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b0.a(context, 32.0f), b0.a(context, 14.0f));
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(b0.a(context, 20.0f));
        }
        layoutParams.leftMargin = b0.a(context, 20.0f);
        layoutParams.bottomMargin = b0.a(context, 20.0f);
        layoutParams.addRule(12);
        this.e.setLayoutParams(layoutParams);
        this.e.setBackground(t.f(context, "tt_ad_logo_new"));
    }

    public TwoSemicirclesView getInnerCircle() {
        return this.g;
    }

    public PAGTextView getLoadingAppName() {
        return this.f540b;
    }

    public TTRoundRectImageView getLoadingIcon() {
        return this.a;
    }

    public PAGTextView getLoadingLogo() {
        return this.e;
    }

    public ProgressBar getLoadingProgressBar() {
        return this.c;
    }

    public PAGTextView getLoadingProgressNumber() {
        return this.d;
    }

    public TwoSemicirclesView getOuterCircle() {
        return this.h;
    }

    public PAGLinearLayout getWaveContainer() {
        return this.f;
    }
}
