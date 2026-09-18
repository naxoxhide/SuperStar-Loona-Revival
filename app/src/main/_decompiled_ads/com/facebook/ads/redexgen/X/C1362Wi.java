package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1362Wi implements C3 {
    public final int A00;
    public final int A01;
    public final C0980Hh A02;

    public C1362Wi(C1363Wj c1363Wj) {
        C0980Hh c0980Hh = c1363Wj.A00;
        this.A02 = c0980Hh;
        c0980Hh.A0Y(12);
        this.A00 = c0980Hh.A0H();
        this.A01 = c0980Hh.A0H();
    }

    @Override // com.facebook.ads.redexgen.X.C3
    public final int A7g() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.C3
    public final boolean A8s() {
        return this.A00 != 0;
    }

    @Override // com.facebook.ads.redexgen.X.C3
    public final int AEF() {
        int i = this.A00;
        return i == 0 ? this.A02.A0H() : i;
    }
}
