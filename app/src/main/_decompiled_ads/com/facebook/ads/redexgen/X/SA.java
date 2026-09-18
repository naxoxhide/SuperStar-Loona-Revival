package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SA extends K8 {
    public final /* synthetic */ C8B A00;

    public SA(C8B c8b) {
        this.A00 = c8b;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        if (this.A00.A00 != null) {
            this.A00.A00.A0x();
        }
        this.A00.A07.setToolbarActionMode(this.A00.getCloseButtonStyle());
        this.A00.A07.A04();
        this.A00.A05.set(true);
    }
}
