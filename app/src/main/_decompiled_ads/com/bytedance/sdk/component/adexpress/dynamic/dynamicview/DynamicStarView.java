package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {
    private int z;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.z = 0;
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context, null);
        this.m = tTRatingBar2;
        tTRatingBar2.setTag(Integer.valueOf(getClickArea()));
        addView(this.m, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        DynamicRootView dynamicRootView;
        super.c();
        double dN = this.j.N();
        if (b.b.a.a.d.c.c() && (dN < 0.0d || dN > 5.0d || ((dynamicRootView = this.l) != null && dynamicRootView.getRenderRequest() != null && this.l.getRenderRequest().l() != 4))) {
            this.m.setVisibility(8);
            return true;
        }
        double d = (dN < 0.0d || dN > 5.0d) ? 5.0d : dN;
        this.m.setVisibility(0);
        ((TTRatingBar2) this.m).a(d, this.j.S(), (int) this.j.s(), ((int) b.b.a.a.d.g.d.a(this.i, this.j.L())) + ((int) b.b.a.a.d.g.d.a(this.i, this.j.I())) + ((int) b.b.a.a.d.g.d.a(this.i, this.j.s())));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iA = (int) ((b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.s()) * 5.0f) + b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.J() + b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.K())));
        if (this.e > iA && 4 == this.j.P()) {
            this.z = (this.e - iA) / 2;
        }
        this.e = iA;
        return new FrameLayout.LayoutParams(this.e, this.f);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
        layoutParams.topMargin = this.h;
        int i = this.g + this.z;
        layoutParams.leftMargin = i;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(i);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }
}
