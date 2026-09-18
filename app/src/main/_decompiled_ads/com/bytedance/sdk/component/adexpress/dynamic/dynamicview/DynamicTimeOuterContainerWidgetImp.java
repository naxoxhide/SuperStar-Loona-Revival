package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements b.b.a.a.d.d.c {
    boolean A;
    private int B;
    private int C;
    private boolean D;
    int z;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.C = 0;
        setTag(Integer.valueOf(getClickArea()));
        k();
        dynamicRootView.setTimeOutListener(this);
    }

    private void k() {
        List<h> listE = this.k.e();
        if (listE == null || listE.size() <= 0) {
            return;
        }
        for (h hVar : listE) {
            if (TextUtils.equals("skip-with-time-skip-btn", hVar.n().f())) {
                int iA = (int) b.b.a.a.d.g.d.a(this.i, hVar.q() + (b.b.a.a.d.c.c() ? hVar.j() : 0));
                this.B = iA;
                this.z = this.e - iA;
                break;
            }
        }
        this.C = this.e - this.z;
    }

    @Override // b.b.a.a.d.d.c
    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.D != z2) {
            this.D = z2;
            h();
            return;
        }
        if (z && this.A != z) {
            this.A = z;
            h();
        }
        this.A = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        if (b.b.a.a.d.g.c.a(this.l.getRenderRequest().a())) {
            return true;
        }
        super.c();
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
        if (this.A) {
            layoutParams.leftMargin = this.g;
        } else {
            layoutParams.leftMargin = this.g + this.C;
        }
        if (this.D && this.j != null) {
            layoutParams.leftMargin = ((this.g + this.C) - ((int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.J()))) - ((int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.K()));
        }
        if (b.b.a.a.d.c.c()) {
            layoutParams.topMargin = this.h - ((int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.L()));
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
        if (this.D && this.j != null) {
            setMeasuredDimension(this.B + ((int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.J())) + ((int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.K())), this.f);
        } else if (this.A) {
            setMeasuredDimension(this.e, this.f);
        } else {
            setMeasuredDimension(this.z, this.f);
        }
    }
}
