package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1406Ya extends AbstractRunnableC1043Jv {
    public final /* synthetic */ YX A00;
    public final /* synthetic */ JG A01;

    public C1406Ya(YX yx, JG jg) {
        this.A00 = yx;
        this.A01 = jg;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC1043Jv
    public final void A01() {
        if (this.A00.A00.A00() != null) {
            this.A00.A00.A00().onAdError(C1053Kf.A00(this.A01));
        }
    }
}
