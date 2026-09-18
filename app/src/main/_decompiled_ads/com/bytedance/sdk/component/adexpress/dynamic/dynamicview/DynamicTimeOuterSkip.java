package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements b.b.a.a.d.d.c {
    private boolean z;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.z = dynamicRootView.getRenderRequest().n();
        }
    }

    private String a(boolean z) {
        String strK = t.k(b.b.a.a.d.c.a(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.k.n().f())) {
            return strK;
        }
        if (b.b.a.a.d.c.c() && this.z) {
            strK = "X";
        }
        return z ? strK : "| " + strK;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if (!TextUtils.equals(this.k.n().f(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.m).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void h() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.k.n().f())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 17) {
                this.m.setTextAlignment(1);
            }
            ((TextView) this.m).setGravity(17);
        } else {
            super.h();
        }
        if (!"skip-with-time-skip-btn".equals(this.k.n().f()) && Build.VERSION.SDK_INT >= 17) {
            this.m.setTextAlignment(1);
            ((TextView) this.m).setGravity(17);
        }
        setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.m).getText())) {
            setMeasuredDimension(0, this.f);
        }
    }

    @Override // b.b.a.a.d.d.c
    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z) {
            ((TextView) this.m).setText(a(z2));
            setVisibility(0);
        } else {
            if (z2) {
                ((TextView) this.m).setText(a(z2));
            }
            setVisibility(z2 ? 0 : 8);
        }
    }
}
