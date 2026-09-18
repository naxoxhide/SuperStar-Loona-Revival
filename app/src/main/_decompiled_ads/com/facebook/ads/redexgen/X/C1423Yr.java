package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1423Yr extends AbstractRunnableC1043Jv {
    public final /* synthetic */ C1419Yn A00;
    public final /* synthetic */ JG A01;

    public C1423Yr(C1419Yn c1419Yn, JG jg) {
        this.A00 = c1419Yn;
        this.A01 = jg;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC1043Jv
    public final void A01() {
        if (this.A00.A01.A06() != null) {
            this.A00.A01.A06().onError(this.A00.A01.A07(), C1053Kf.A00(this.A01));
        }
    }
}
