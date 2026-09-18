package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TC extends K8 {
    public final WeakReference<C1203Qb> A00;

    public TC(C1203Qb c1203Qb) {
        this.A00 = new WeakReference<>(c1203Qb);
    }

    public TC(WeakReference<C1203Qb> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        C1203Qb viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}
