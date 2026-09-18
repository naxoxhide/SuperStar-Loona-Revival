package com.bytedance.sdk.openadsdk.b.m.q;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: RewardFullTypePlayable.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends b {
    public i(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        super(aVar);
    }

    public static boolean a(q qVar) {
        return t.i(qVar) || t.h(qVar);
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void a(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void o() {
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean q() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean r() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void u() {
        super.u();
        if (t.h(this.a.a)) {
            this.i.removeMessages(600);
            this.a.I.c("go_background");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void v() {
        if (this.a.I.j() && t.h(this.a.a)) {
            this.a.I.c("return_foreground");
            com.bytedance.sdk.openadsdk.core.widget.a aVar = this.l;
            if ((aVar == null || !aVar.isShowing()) && this.a.I.d() >= 0) {
                this.a.I.a(0L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void w() {
        if (t.i(this.a.a)) {
            if (DeviceUtils.d() == 0) {
                this.a.d = true;
            }
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
            if (aVar.d) {
                aVar.R.e(true);
                this.a.O.a(true);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void x() {
        super.x();
        if (t.h(this.a.a)) {
            this.i.removeMessages(600);
            this.a.I.c("go_background");
        }
    }
}
