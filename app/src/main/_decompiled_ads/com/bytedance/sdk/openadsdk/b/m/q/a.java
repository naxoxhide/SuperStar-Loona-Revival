package com.bytedance.sdk.openadsdk.b.m.q;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.b.m.p.j;
import com.bytedance.sdk.openadsdk.b.m.p.l;
import com.bytedance.sdk.openadsdk.b.m.p.m;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: BaseRewardFullAdType.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    protected com.bytedance.sdk.openadsdk.b.m.p.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected q f514b;
    protected int c;
    protected int d;
    protected final l e;
    protected final com.bytedance.sdk.openadsdk.component.reward.view.e f;
    protected final j g;
    protected com.bytedance.sdk.openadsdk.core.j0.c.b h;
    protected y i;

    public a(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.a = aVar;
        this.f514b = aVar.a;
        this.c = aVar.l;
        this.d = aVar.m;
        l lVar = aVar.G;
        this.e = lVar;
        this.f = aVar.T;
        lVar.m();
        m mVar = aVar.Q;
        this.g = aVar.R;
    }

    public void a(com.bytedance.sdk.openadsdk.core.j0.c.b bVar, y yVar) {
        this.h = bVar;
        this.i = yVar;
    }

    protected void b() {
        if (t.i(this.a.a) && DeviceUtils.d() == 0) {
            this.a.d = true;
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        aVar.R.e(aVar.d);
    }

    public boolean c() {
        return this.a.a.k1() || this.a.a.c0() == 15 || this.a.a.c0() == 5 || this.a.a.c0() == 50;
    }

    public void a(boolean z) {
        if (this.a.u.get()) {
            return;
        }
        q qVar = this.f514b;
        if (qVar != null && qVar.X0()) {
            this.g.c(false);
            this.g.a(true);
            this.a.T.c(8);
            this.a.T.e(8);
            return;
        }
        if (!z) {
            this.g.c(false);
            this.g.a(false);
            this.g.b(false);
            this.a.T.b(8);
        } else {
            this.g.a(this.a.a.g1());
            if (t.h(this.a.a) || c()) {
                this.g.c(true);
            }
            if (!c() && (!(this instanceof g) || !this.a.V.l())) {
                this.g.d();
                this.a.T.b(0);
            } else {
                this.g.b(true);
            }
        }
        if (z) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
            if (!aVar.f && (aVar.k != FullRewardExpressView.c0 || !c())) {
                this.a.T.c(8);
                this.a.T.e(8);
                return;
            } else {
                this.a.T.c(0);
                this.a.T.e(0);
                return;
            }
        }
        this.a.T.c(4);
        this.a.T.e(8);
    }

    public boolean a() {
        if (!o.f(this.a.a) || !this.a.D.get()) {
            return (this.a.u.get() || this.a.v.get() || t.h(this.a.a)) ? false : true;
        }
        FrameLayout frameLayoutE = this.a.T.e();
        frameLayoutE.setVisibility(4);
        frameLayoutE.setVisibility(0);
        return false;
    }
}
