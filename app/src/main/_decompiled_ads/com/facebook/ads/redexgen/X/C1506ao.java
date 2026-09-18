package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1506ao extends K8 {
    public final /* synthetic */ C1505an A00;
    public final /* synthetic */ AnonymousClass95 A01;

    public C1506ao(C1505an c1505an, AnonymousClass95 anonymousClass95) {
        this.A00 = c1505an;
        this.A01 = anonymousClass95;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        this.A00.A00.A09();
        if (this.A00.A00.A0A != null) {
            this.A01.setAdViewabilityChecker(this.A00.A00.A0A);
            this.A00.A00.A0A.A0U();
        }
    }
}
