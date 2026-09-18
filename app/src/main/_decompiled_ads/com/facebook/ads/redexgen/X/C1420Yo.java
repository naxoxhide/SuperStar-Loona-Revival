package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1420Yo extends AbstractRunnableC1043Jv {
    public final /* synthetic */ C1419Yn A00;

    public C1420Yo(C1419Yn c1419Yn) {
        this.A00 = c1419Yn;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC1043Jv
    public final void A01() {
        if (this.A00.A01.A06() != null) {
            this.A00.A01.A06().onLoggingImpression(this.A00.A01.A07());
        }
    }
}
