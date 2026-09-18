package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class U0 extends K8 {
    public final /* synthetic */ C1061Kn A00;

    public U0(C1061Kn c1061Kn) {
        this.A00 = c1061Kn;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        if (this.A00.A06()) {
            this.A00.A02();
            this.A00.A05.postDelayed(this, this.A00.A02);
        }
    }
}
