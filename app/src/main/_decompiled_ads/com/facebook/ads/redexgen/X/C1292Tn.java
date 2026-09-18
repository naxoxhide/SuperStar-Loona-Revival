package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1292Tn implements N5 {
    public final /* synthetic */ InterfaceC1091Lt A00;
    public final /* synthetic */ C1290Tl A01;

    public C1292Tn(C1290Tl c1290Tl, InterfaceC1091Lt interfaceC1091Lt) {
        this.A01 = c1290Tl;
        this.A00 = interfaceC1091Lt;
    }

    @Override // com.facebook.ads.redexgen.X.N5
    public final void ACG(String str) {
        this.A01.A0A.setProgress(100);
        this.A01.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.N5
    public final void ACI(String str) {
        this.A01.A05 = true;
        this.A01.A09.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.N5
    public final void ACa(int i) {
        if (this.A01.A05) {
            this.A01.A0A.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.N5
    public final void ACf(String str) {
        this.A01.A09.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.X.N5
    public final void ACh() {
        this.A00.AAl(14);
    }
}
