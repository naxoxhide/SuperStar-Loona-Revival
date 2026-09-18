package com.bytedance.sdk.openadsdk.b.m.q;

import android.widget.FrameLayout;
import b.b.a.a.d.f.n;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.r;
import com.bytedance.sdk.openadsdk.utils.y;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullTypeDoubleAds.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends b implements com.bytedance.sdk.openadsdk.k.f {
    private final r o;
    private boolean p;

    /* JADX INFO: compiled from: RewardFullTypeDoubleAds.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d();
            e.this.m();
            e.this.a.S.d();
        }
    }

    public e(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        super(aVar);
        this.o = (r) aVar.a;
    }

    public static void a(q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_id", qVar.U());
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.l.b.a().a("choose_ad_start_show", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void a(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void d() {
        if (!this.a.J.g() && !this.p) {
            this.a.J.d().getJsObject().a(this);
            return;
        }
        super.d();
        if (this.a.J.g()) {
            m();
            this.a.S.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    protected boolean f() {
        return false;
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
    public void a(RewardFullBaseLayout rewardFullBaseLayout) {
        if (c.a(this.o)) {
            c.a(this.o, rewardFullBaseLayout);
        } else {
            super.a(rewardFullBaseLayout);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.a
    public boolean a() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.k.f
    public void a(int i, long j) {
        this.p = true;
        int i2 = i - 1;
        this.o.K(i2);
        com.bytedance.sdk.openadsdk.d.c.a(this.o, this.a.g, i, j);
        com.bytedance.sdk.openadsdk.b.m.a.a(this.o.p1(), i2);
        y.a(new a());
    }

    @Override // com.bytedance.sdk.openadsdk.k.f
    public void a(n nVar) {
        this.a.J.d().c(nVar);
    }
}
