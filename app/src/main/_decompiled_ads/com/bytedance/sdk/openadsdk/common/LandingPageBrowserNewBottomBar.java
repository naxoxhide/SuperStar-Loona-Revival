package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class LandingPageBrowserNewBottomBar extends LinearLayout {
    public LandingPageBrowserNewBottomBar(Context context) {
        super(context);
        a();
    }

    private static ImageView a(Context context, float f, float f2, float f3, float f4) {
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setClickable(true);
        pAGImageView.setFocusable(true);
        pAGImageView.setPadding(b0.a(context, f3), b0.a(context, f4), b0.a(context, f3), b0.a(context, f4));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b0.a(context, 40.0f), b0.a(context, 44.0f));
        if (f > 0.0f) {
            layoutParams.leftMargin = b0.a(context, f);
        }
        if (f2 > 0.0f) {
            layoutParams.rightMargin = b0.a(context, f2);
        }
        pAGImageView.setLayoutParams(layoutParams);
        return pAGImageView;
    }

    private void a() {
        Context context = getContext();
        setId(com.bytedance.sdk.openadsdk.utils.h.h0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, b0.a(context, 44.5f)));
        setBackgroundColor(-1);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        addView(view, new LinearLayout.LayoutParams(-1, b0.a(context, 0.5f)));
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setOrientation(0);
        addView(pAGLinearLayout, new LinearLayout.LayoutParams(-1, b0.a(context, 44.0f)));
        ImageView imageViewA = a(context, 16.0f, 0.0f, 14.75f, 12.5f);
        imageViewA.setId(com.bytedance.sdk.openadsdk.utils.h.i0);
        imageViewA.setImageResource(t.e(context, "tt_ad_arrow_backward_wrapper"));
        pAGLinearLayout.addView(imageViewA);
        View view2 = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout.addView(view2, layoutParams);
        ImageView imageViewA2 = a(context, 8.0f, 0.0f, 14.75f, 12.5f);
        imageViewA2.setId(com.bytedance.sdk.openadsdk.utils.h.j0);
        imageViewA2.setImageResource(t.e(context, "tt_ad_arrow_forward_wrapper"));
        pAGLinearLayout.addView(imageViewA2);
        View view3 = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
        layoutParams2.weight = 1.0f;
        pAGLinearLayout.addView(view3, layoutParams2);
        ImageView imageViewA3 = a(context, 8.0f, 0.0f, 10.0f, 12.0f);
        imageViewA3.setId(com.bytedance.sdk.openadsdk.utils.h.k0);
        imageViewA3.setImageResource(t.e(context, "tt_ad_refresh"));
        pAGLinearLayout.addView(imageViewA3);
        View view4 = new View(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        pAGLinearLayout.addView(view4, layoutParams3);
        ImageView imageViewA4 = a(context, 0.0f, 16.0f, 9.0f, 11.0f);
        imageViewA4.setId(com.bytedance.sdk.openadsdk.utils.h.l0);
        imageViewA4.setImageResource(t.e(context, "tt_ad_link"));
        pAGLinearLayout.addView(imageViewA4);
    }
}
