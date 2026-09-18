package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class RewardFullBaseLayout extends PAGFrameLayout {
    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    public void a(com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
        bVar.a(this);
        RFEndCardBackUpLayout rFEndCardBackUpLayoutG = bVar.g();
        if (rFEndCardBackUpLayoutG != null) {
            addView(rFEndCardBackUpLayoutG, new FrameLayout.LayoutParams(-1, -1));
        }
        a(bVar.k(), this);
        a(bVar.h(), this);
    }

    private void a(View view, ViewGroup viewGroup) {
        if (view != null) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
