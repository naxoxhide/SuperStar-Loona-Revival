package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TY implements InterfaceC1089Lr {
    public final /* synthetic */ TU A00;

    public TY(TU tu) {
        this.A00 = tu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1089Lr
    public final void AAr() {
        if (this.A00.A0Z() && !this.A00.A0T.get()) {
            this.A00.A0R.A07(this.A00);
            return;
        }
        if (!this.A00.A0V || this.A00.A0T.get() || !this.A00.A0Y()) {
            this.A00.A0L.A04(EnumC1011Im.A07, null);
            this.A00.A0O.A3z(this.A00.A0P.A6n());
        } else {
            this.A00.A0Y.setToolbarActionMode(0);
            this.A00.A0M();
        }
    }
}
