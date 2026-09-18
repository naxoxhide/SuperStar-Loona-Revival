package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SN implements InterfaceC1060Km {
    public final /* synthetic */ SM A00;

    public SN(SM sm) {
        this.A00 = sm;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1060Km
    public final void AAv() {
        this.A00.A0F.AB2(this.A00.A0A);
        this.A00.A0F.AAf();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1060Km
    public final void ACZ(float f) {
        int i;
        float totalForce = (this.A00.A0A - f) + (this.A00.A0V ? 0 : this.A00.A0I.getDuration());
        if (this.A00.A0V) {
            i = this.A00.A0A;
        } else {
            i = this.A00.A09;
        }
        float seenTime = i;
        this.A00.A0F.AG6(totalForce / seenTime);
    }
}
