package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1229Rb extends K8 {
    public final /* synthetic */ RX A00;

    public C1229Rb(RX rx) {
        this.A00 = rx;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        if (!this.A00.A03) {
            C8Z c8z = this.A00.A0B;
            final int currentPositionInMillis = this.A00.getCurrentPositionInMillis();
            c8z.A02(new P7(currentPositionInMillis) { // from class: com.facebook.ads.redexgen.X.71
            });
            this.A00.A07.postDelayed(this, this.A00.A00);
        }
    }
}
