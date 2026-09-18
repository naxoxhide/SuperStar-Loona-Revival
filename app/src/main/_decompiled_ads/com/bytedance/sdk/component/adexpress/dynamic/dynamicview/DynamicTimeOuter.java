package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import b.b.a.a.d.d.i.j;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuter extends DynamicButton implements b.b.a.a.d.d.c {
    private boolean A;
    private boolean z;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(hVar.n().f())) {
            dynamicRootView.setTimedown(this.f);
        }
    }

    @Override // b.b.a.a.d.d.c
    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.A) {
            ((TextView) this.m).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.l.getRenderRequest().b() && b.b.a.a.d.g.c.a(this.l.getRenderRequest().a())) {
            ((TextView) this.m).setText(String.format(t.k(b.b.a.a.d.c.a(), "tt_reward_full_skip"), Integer.valueOf(i)));
            this.z = true;
            return;
        }
        if (b.b.a.a.d.c.c() && !"open_ad".equals(this.l.getRenderRequest().a()) && this.l.getRenderRequest().b()) {
            this.A = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.k.n().f())) {
            ((TextView) this.m).setText(charSequence);
            return;
        }
        ((TextView) this.m).setText(((Object) charSequence) + "s");
        if (this.z) {
            CharSequence text = ((TextView) this.m).getText();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (j.a(text != null ? text.toString() : "", this.j.s(), true)[0] + b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.J() + this.j.K())), this.f);
            layoutParams.gravity = 8388629;
            this.m.setLayoutParams(layoutParams);
            this.z = false;
            requestLayout();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if (b.b.a.a.d.g.c.a(this.l.getRenderRequest().a())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.k.n().f())) {
            ((TextView) this.m).setText(String.valueOf((int) Double.parseDouble(this.j.o())));
            return true;
        }
        ((TextView) this.m).setText(((int) Double.parseDouble(this.j.o())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void h() {
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.k.n().f()) && !TextUtils.equals("skip-with-time-countdown", this.k.n().f())) {
            super.h();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
        layoutParams.gravity = 8388627;
        if (b.b.a.a.d.c.c()) {
            layoutParams.leftMargin = this.g;
        }
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
        }
    }
}
