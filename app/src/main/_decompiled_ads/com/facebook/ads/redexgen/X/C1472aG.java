package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1472aG implements InterfaceC07105p {
    public final /* synthetic */ C05991f A00;

    public C1472aG(C05991f c05991f) {
        this.A00 = c05991f;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAW() {
        this.A00.A04.AAQ();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAX() {
        this.A00.A04.AAP(AdError.CACHE_ERROR);
    }
}
