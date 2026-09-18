package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TL implements N6 {
    public final /* synthetic */ C1120Mw A00;

    public TL(C1120Mw c1120Mw) {
        this.A00 = c1120Mw;
    }

    @Override // com.facebook.ads.redexgen.X.N6
    public final void AAg(boolean z) {
        if (this.A00.A07 && this.A00.A00 != null) {
            this.A00.A00.setEnabled(z);
            this.A00.A00.setAlpha(z ? 1.0f : 0.3f);
        }
    }

    @Override // com.facebook.ads.redexgen.X.N6
    public final void ABP(boolean z) {
        if (this.A00.A07 && this.A00.A02 != null) {
            this.A00.A02.setEnabled(z);
            this.A00.A02.setAlpha(z ? 1.0f : 0.3f);
        }
    }
}
