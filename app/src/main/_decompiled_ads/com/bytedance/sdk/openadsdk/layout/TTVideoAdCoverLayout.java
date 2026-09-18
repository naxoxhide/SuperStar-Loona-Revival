package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoAdCoverLayout extends PAGRelativeLayout {
    private ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CornerIV f789b;
    private TextView c;
    private TextView d;
    private PAGTextView e;

    public TTVideoAdCoverLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setId(h.D0);
        setVisibility(8);
        setBackgroundColor(Color.parseColor("#7f000000"));
        PAGImageView pAGImageView = new PAGImageView(getContext());
        this.a = pAGImageView;
        pAGImageView.setId(h.F0);
        this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setImageTintMode(PorterDuff.Mode.SRC_OVER);
            this.a.setImageTintList(ColorStateList.valueOf(Color.parseColor("#7f000000")));
        }
        this.a.setBackgroundColor(Color.parseColor("#7f000000"));
        this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.a);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(h.E0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        pAGRelativeLayout.setLayoutParams(layoutParams);
        addView(pAGRelativeLayout);
        int iA = b0.a(context, 44.0f);
        CornerIV cornerIV = new CornerIV(context);
        this.f789b = cornerIV;
        int i = h.K;
        cornerIV.setId(i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.addRule(14);
        this.f789b.setLayoutParams(layoutParams2);
        this.f789b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        pAGRelativeLayout.addView(this.f789b);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.c = pAGTextView;
        pAGTextView.setId(h.L);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams3.addRule(8, i);
        layoutParams3.addRule(19, i);
        layoutParams3.addRule(5, i);
        layoutParams3.addRule(7, i);
        layoutParams3.addRule(18, i);
        layoutParams3.addRule(6, i);
        layoutParams3.addRule(14);
        this.c.setLayoutParams(layoutParams3);
        this.c.setBackgroundResource(t.e(context, "tt_circle_solid_mian"));
        this.c.setGravity(17);
        this.c.setTextColor(-1);
        this.c.setTextSize(2, 19.0f);
        this.c.setTypeface(Typeface.defaultFromStyle(1));
        this.c.setVisibility(8);
        pAGRelativeLayout.addView(this.c);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        this.d = pAGTextView2;
        int i2 = h.M;
        pAGTextView2.setId(i2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, i);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = b0.a(context, 6.0f);
        this.d.setLayoutParams(layoutParams4);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setMaxLines(1);
        this.d.setTextColor(-1);
        this.d.setTextSize(2, 12.0f);
        pAGRelativeLayout.addView(this.d);
        PAGTextView pAGTextView3 = new PAGTextView(context);
        this.e = pAGTextView3;
        pAGTextView3.setId(h.N);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(b0.a(context, 100.0f), b0.a(context, 28.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, i2);
        layoutParams5.topMargin = b0.a(context, 20.0f);
        this.e.setLayoutParams(layoutParams5);
        this.e.setMinWidth(b0.a(context, 72.0f));
        this.e.setMaxLines(1);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setTextColor(-1);
        this.e.setTextSize(2, 14.0f);
        this.e.setBackgroundResource(t.e(context, "tt_ad_cover_btn_begin_bg"));
        this.e.setGravity(17);
        int iA2 = b0.a(context, 10.0f);
        int iA3 = b0.a(context, 2.0f);
        this.e.setPadding(iA2, iA3, iA2, iA3);
        this.e.setVisibility(8);
        pAGRelativeLayout.addView(this.e);
    }

    public TTVideoAdCoverLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTVideoAdCoverLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
