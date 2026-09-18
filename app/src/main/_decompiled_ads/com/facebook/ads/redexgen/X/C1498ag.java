package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1498ag implements C6I {
    public final /* synthetic */ FA A00;

    public C1498ag(FA fa) {
        this.A00 = fa;
    }

    private void A00(boolean z) {
        if (!z) {
            this.A00.A01.ACq(this.A00, AdError.CACHE_ERROR);
        } else {
            this.A00.A0C.set(true);
            this.A00.A01.ACn(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C6I
    public final void AAn() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.X.C6I
    public final void AAw() {
        A00(true);
    }
}
