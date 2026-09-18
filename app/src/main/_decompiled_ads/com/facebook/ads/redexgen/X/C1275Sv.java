package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1275Sv implements InterfaceC1060Km {
    public final /* synthetic */ C9D A00;

    public C1275Sv(C9D c9d) {
        this.A00 = c9d;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1060Km
    public final void AAv() {
        this.A00.A07 = false;
        if (this.A00.A04 != null) {
            this.A00.A04.setToolbarActionMode(this.A00.getCloseButtonStyle());
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1060Km
    public final void ACZ(float f) {
        if (this.A00.A04 != null) {
            this.A00.A04.setProgressImmediate(100.0f * (1.0f - (f / this.A00.getAdInfo().A0G().A00())));
        }
    }
}
