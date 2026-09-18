package com.bytedance.sdk.openadsdk.b.m.q;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.FullInteractionStyleView;
import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: RewardFullTypeInteraction.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends b {
    private FullInteractionStyleView o;

    /* JADX INFO: compiled from: RewardFullTypeInteraction.java */
    class a implements b.c {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.b.m.q.b.c
        public void a(boolean z) {
            if (h.this.o != null) {
                h.this.o.setIsMute(z);
            }
        }
    }

    public h(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        super(aVar);
    }

    private boolean E() {
        return q.c(this.f514b);
    }

    public FrameLayout D() {
        FullInteractionStyleView fullInteractionStyleView = this.o;
        if (fullInteractionStyleView != null) {
            return fullInteractionStyleView.getVideoContainer();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public b.c j() {
        return new a();
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void o() {
        this.f.e(8);
        this.f.c(8);
        if (this.f514b.w0() == 2) {
            this.g.a(false);
            this.g.c(false);
            this.g.b(false);
            this.f.b(8);
            return;
        }
        this.g.a(this.f514b.g1());
        this.g.c(E());
        this.g.b(E());
        if (E()) {
            this.f.b(8);
        } else {
            this.g.d();
            this.f.b(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean q() {
        return E();
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public boolean r() {
        return E();
    }

    @Override // com.bytedance.sdk.openadsdk.b.m.q.b
    public void a(FrameLayout frameLayout) {
        FullInteractionStyleView fullInteractionStyleView = new FullInteractionStyleView(this.a.V, this.j);
        this.o = fullInteractionStyleView;
        fullInteractionStyleView.setDownloadListener(this.k);
        FullInteractionStyleView fullInteractionStyleView2 = this.o;
        q qVar = this.f514b;
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        fullInteractionStyleView2.a(qVar, aVar.k, aVar.j, this.c, this.d);
        frameLayout.addView(this.o.getInteractionStyleRootView());
    }

    public static boolean a(q qVar) {
        return (qVar.f1() || qVar.o() == 100.0f) ? false : true;
    }
}
