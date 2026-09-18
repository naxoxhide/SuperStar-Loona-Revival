package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements b.b.a.a.d.d.c {
    private int A;
    private int B;
    private int z;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        k();
    }

    private void k() {
        List<h> listE = this.k.e();
        if (listE == null || listE.size() <= 0) {
            return;
        }
        for (h hVar : listE) {
            if (hVar.n().c() == 21) {
                this.z = (int) (this.e - b.b.a.a.d.g.d.a(this.i, hVar.q()));
            }
            if (hVar.n().c() == 20) {
                this.A = (int) (this.e - b.b.a.a.d.g.d.a(this.i, hVar.q()));
            }
        }
    }

    @Override // b.b.a.a.d.d.c
    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.B = i;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(getBackgroundDrawable());
        }
        setPadding((int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.J()), (int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.L()), (int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.K()), (int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.I()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = this.g;
        layoutParams.leftMargin = i;
        layoutParams.topMargin = this.h;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(i);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.B == 0) {
            setMeasuredDimension(this.A, this.f);
        } else {
            setMeasuredDimension(this.z, this.f);
        }
    }
}
