package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicSkipCountDown extends DynamicButton implements b.b.a.a.d.d.c {
    public DynamicSkipCountDown(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // b.b.a.a.d.d.c
    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i != 0) {
            ((TextView) this.m).setText(" | " + String.format(t.k(b.b.a.a.d.c.a(), "tt_reward_full_skip_count_down"), Integer.valueOf(i)));
        } else if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        requestLayout();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
        int i = this.g;
        layoutParams.leftMargin = i;
        layoutParams.gravity = 16;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(i);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.m).getText())) {
            setMeasuredDimension(0, this.f);
        }
    }
}
