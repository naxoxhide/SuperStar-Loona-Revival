package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ul, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1316Ul extends K8 {
    public final /* synthetic */ C1315Uk A00;

    public C1316Ul(C1315Uk c1315Uk) {
        this.A00 = c1315Uk;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        this.A00.A0C = false;
        if (this.A00.A0B.getQueue().isEmpty()) {
            this.A00.A0B.execute(this.A00.A0A);
        }
    }
}
