package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: compiled from: TTDislikeLayoutUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public View a(Context context) {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        pAGLinearLayout.setOrientation(1);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setId(h.j1);
        pAGRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, b0.a(context, 44.0f)));
        pAGRelativeLayout.setBackgroundResource(t.e(context, "tt_dislike_top_bg"));
        pAGRelativeLayout.setVisibility(8);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setId(h.k1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        pAGTextView.setLayoutParams(layoutParams);
        pAGTextView.setCompoundDrawablesWithIntrinsicBounds(t.f(context, "tt_lefterbackicon_titlebar_press_wrapper"), (Drawable) null, (Drawable) null, (Drawable) null);
        pAGTextView.setGravity(17);
        pAGTextView.setTextColor(Color.parseColor("#FF9B9B9B"));
        pAGTextView.setTextSize(14.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            pAGTextView.setTextDirection(5);
        }
        pAGRelativeLayout.addView(pAGTextView);
        PAGTextView pAGTextView2 = new PAGTextView(context);
        pAGTextView2.setId(h.l1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        pAGTextView2.setLayoutParams(layoutParams2);
        pAGTextView2.setGravity(17);
        pAGTextView2.setTextColor(Color.parseColor("#FF9B9B9B"));
        pAGTextView2.setTextSize(15.0f);
        pAGRelativeLayout.addView(pAGTextView2);
        View view = new View(context);
        view.setId(h.m1);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, b0.a(context, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#DCDCDC"));
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TTDislikeListView tTDislikeListView = new TTDislikeListView(context);
        tTDislikeListView.setId(h.n1);
        tTDislikeListView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        tTDislikeListView.setDivider(new ColorDrawable(Color.parseColor("#DCDCDC")));
        tTDislikeListView.setDividerHeight(b0.a(context, 1.0f));
        tTDislikeListView.setSelector(new ColorDrawable(Color.parseColor("#00000000")));
        tTDislikeListView.setVerticalScrollBarEnabled(true);
        pAGFrameLayout.addView(tTDislikeListView);
        TTDislikeListView tTDislikeListView2 = new TTDislikeListView(context);
        tTDislikeListView2.setId(h.o1);
        tTDislikeListView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        tTDislikeListView2.setDivider(new ColorDrawable(Color.parseColor("#DCDCDC")));
        tTDislikeListView2.setDividerHeight(b0.a(context, 1.0f));
        tTDislikeListView2.setSelector(new ColorDrawable(Color.parseColor("#00000000")));
        tTDislikeListView2.setVerticalScrollBarEnabled(true);
        tTDislikeListView2.setVisibility(8);
        pAGFrameLayout.addView(tTDislikeListView2);
        pAGLinearLayout.addView(pAGRelativeLayout);
        pAGLinearLayout.addView(view);
        pAGLinearLayout.addView(pAGFrameLayout);
        return pAGLinearLayout;
    }
}
