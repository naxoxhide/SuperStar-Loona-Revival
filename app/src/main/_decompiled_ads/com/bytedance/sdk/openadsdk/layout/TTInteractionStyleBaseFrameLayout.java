package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTInteractionStyleBaseFrameLayout extends PAGFrameLayout {
    protected PAGFrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PAGImageView f788b;
    protected TTRoundRectImageView c;
    protected PAGTextView d;
    protected PAGTextView e;
    protected PAGTextView f;

    public TTInteractionStyleBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h(context);
    }

    protected PAGFrameLayout a(Context context) {
        return new PAGFrameLayout(context);
    }

    protected TTBackUpAdImageView b(Context context) {
        return new TTBackUpAdImageView(context);
    }

    protected PAGTextView c(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setMaxLines(1);
        pAGTextView.setTextColor(Color.parseColor("#FF999999"));
        pAGTextView.setTextSize(2, 16.0f);
        return pAGTextView;
    }

    protected PAGTextView d(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setMaxLines(1);
        pAGTextView.setSingleLine();
        pAGTextView.setTextColor(Color.parseColor("#FF999999"));
        pAGTextView.setTextSize(2, 12.0f);
        return pAGTextView;
    }

    protected PAGTextView e(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setBackgroundResource(t.e(context, "tt_backup_btn_1"));
        pAGTextView.setGravity(17);
        pAGTextView.setText(t.j(context, "tt_video_download_apk"));
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 14.0f);
        return pAGTextView;
    }

    protected TTRoundRectImageView f(Context context) {
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        tTRoundRectImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tTRoundRectImageView.setBackgroundColor(0);
        return tTRoundRectImageView;
    }

    protected PAGImageView g(Context context) {
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return pAGImageView;
    }

    public FrameLayout getTtAdContainer() {
        return this.a;
    }

    public TextView getTtFullAdAppName() {
        return this.d;
    }

    public TextView getTtFullAdDesc() {
        return this.e;
    }

    public TextView getTtFullAdDownload() {
        return this.f;
    }

    public TTRoundRectImageView getTtFullAdIcon() {
        return this.c;
    }

    public ImageView getTtFullImg() {
        return this.f788b;
    }

    protected abstract void h(Context context);
}
