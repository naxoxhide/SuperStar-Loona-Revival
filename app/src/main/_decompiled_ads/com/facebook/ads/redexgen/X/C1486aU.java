package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1486aU implements NK {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractC1485aT A01;
    public final /* synthetic */ UJ A02;

    public C1486aU(AbstractC1485aT abstractC1485aT, int i, UJ uj) {
        this.A01 = abstractC1485aT;
        this.A00 = i;
        this.A02 = uj;
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final void ABX(boolean z) {
        if (this.A00 == 0) {
            this.A02.A1Z(this.A01.A04);
        }
        this.A02.A1c(z, true);
    }
}
