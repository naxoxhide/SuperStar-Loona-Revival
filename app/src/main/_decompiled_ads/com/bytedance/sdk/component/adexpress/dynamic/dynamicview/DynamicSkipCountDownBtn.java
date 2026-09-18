package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements b.b.a.a.d.d.c {
    private int A;
    private int B;
    private int[] z;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        dynamicRootView.setTimeOutListener(this);
    }

    private void k() {
        int iA = (int) b.b.a.a.d.g.d.a(this.i, this.j.s());
        this.A = ((this.f - iA) / 2) - this.j.I();
        this.B = 0;
    }

    @Override // b.b.a.a.d.d.c
    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        String strK = t.k(b.b.a.a.d.c.a(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.m.setVisibility(0);
            ((TextView) this.m).setText("| " + strK);
            this.m.measure(-2, -2);
            this.z = new int[]{this.m.getMeasuredWidth() + 1, this.m.getMeasuredHeight()};
            View view = this.m;
            int[] iArr = this.z;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.m).setGravity(17);
            ((TextView) this.m).setIncludeFontPadding(false);
            k();
            this.m.setPadding(this.j.J(), this.A, this.j.K(), this.B);
        }
        requestLayout();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        ((TextView) this.m).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
        layoutParams.gravity = 8388629;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.m).getText())) {
            setMeasuredDimension(0, this.f);
        } else {
            setMeasuredDimension(this.e, this.f);
        }
    }
}
