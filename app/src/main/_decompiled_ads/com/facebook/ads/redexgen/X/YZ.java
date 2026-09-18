package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YZ extends AbstractRunnableC1043Jv {
    public final /* synthetic */ YY A00;

    public YZ(YY yy) {
        this.A00 = yy;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC1043Jv
    public final void A01() {
        if (this.A00.A01.A00.A00() != null) {
            this.A00.A01.A00.A00().onAdsLoaded();
        }
    }
}
