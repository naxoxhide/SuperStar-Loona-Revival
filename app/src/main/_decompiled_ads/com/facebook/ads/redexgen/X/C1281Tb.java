package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1281Tb implements InterfaceC1129Nf {
    public final /* synthetic */ TU A00;

    public C1281Tb(TU tu) {
        this.A00 = tu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1129Nf
    public final void AAS() {
        if (this.A00.A0Y()) {
            this.A00.A0M();
            this.A00.A0Y.setToolbarActionMessage("");
            this.A00.A0Y.setToolbarActionMode(0);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1129Nf
    public final void ABz() {
        this.A00.A0D = false;
        this.A00.A0M.A08();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1129Nf
    public final void AC0() {
        this.A00.A0D = true;
        this.A00.A0M.A07();
    }
}
