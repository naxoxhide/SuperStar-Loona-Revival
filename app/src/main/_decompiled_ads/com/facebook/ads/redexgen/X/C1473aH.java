package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1473aH implements InterfaceC06071n {
    public final /* synthetic */ C05991f A00;

    public C1473aH(C05991f c05991f) {
        this.A00 = c05991f;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06071n
    public final void ACM(AdError adError) {
        this.A00.A04.AAP(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06071n
    public final void ACN() {
        this.A00.A04.AAQ();
    }
}
