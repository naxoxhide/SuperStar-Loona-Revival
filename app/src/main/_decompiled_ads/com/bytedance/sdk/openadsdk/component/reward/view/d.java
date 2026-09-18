package com.bytedance.sdk.openadsdk.component.reward.view;

import android.graphics.Color;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: compiled from: RewardFullNativeVideoLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends e {
    public d(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        super(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.e
    public void a(int i, int i2) {
        super.a(i, i2);
        if (q.c(this.d) && this.d.O0() == 3 && this.d.p0() == 0) {
            try {
                FrameLayout frameLayout = (FrameLayout) this.f547b.findViewById(h.j);
                frameLayout.setBackgroundColor(Color.parseColor("#000000"));
                if (this.d.j0() == 1) {
                    int iA = b0.a(o.a(), 90.0f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams.bottomMargin = iA;
                    frameLayout.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.e
    protected boolean i() {
        return false;
    }
}
