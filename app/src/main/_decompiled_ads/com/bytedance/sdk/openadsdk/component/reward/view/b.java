package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.b.m.p.l;
import com.bytedance.sdk.openadsdk.b.m.p.n;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: compiled from: RewardFullBackUpEndCard.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private final com.bytedance.sdk.openadsdk.b.m.p.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RFEndCardBackUpLayout f545b;
    private boolean c;
    private n d;

    /* JADX INFO: compiled from: RewardFullBackUpEndCard.java */
    class a implements View.OnClickListener {
        a(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public b(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.a = aVar;
    }

    public void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        RFEndCardBackUpLayout rFEndCardBackUpLayout = (RFEndCardBackUpLayout) this.a.U.findViewById(h.p0);
        this.f545b = rFEndCardBackUpLayout;
        rFEndCardBackUpLayout.a(this.a);
        if (this.a.a.k1()) {
            this.d = new n(this.a);
        }
    }

    public void b() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.a();
        }
    }

    public void c() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.c();
        }
    }

    public boolean d() {
        n nVar = this.d;
        if (nVar != null) {
            return nVar.d();
        }
        return false;
    }

    public void e() {
        m.a("TTAD.RFBackUpEndCard", "show: ");
        b0.a((View) this.f545b, 0);
    }

    public void a(com.bytedance.sdk.openadsdk.core.c0.e eVar) {
        b0.a(this.f545b, new a(this), "TTBaseVideoActivity#mFLEndCardBackupContainer");
        n nVar = this.d;
        if (nVar != null) {
            nVar.a(eVar);
        }
    }

    public boolean a(l lVar) {
        n nVar = this.d;
        if (nVar == null || !nVar.a(lVar)) {
            return false;
        }
        b0.a((View) this.f545b, 0);
        return true;
    }
}
