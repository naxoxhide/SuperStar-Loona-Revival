package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class T2 extends K8 {
    public final /* synthetic */ C1124Na A00;

    public T2(C1124Na c1124Na) {
        this.A00 = c1124Na;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        if (this.A00.isPressed()) {
            C1124Na c1124Na = this.A00;
            c1124Na.postDelayed(this, c1124Na.A07);
        } else {
            this.A00.setPressed(true);
            C1124Na c1124Na2 = this.A00;
            c1124Na2.postOnAnimationDelayed(c1124Na2.A09, 250L);
        }
    }
}
