package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1355Wb implements InterfaceC0845Bj {
    public final /* synthetic */ C1354Wa A00;

    public C1355Wb(C1354Wa c1354Wa) {
        this.A00 = c1354Wa;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final long A6k() {
        return this.A00.A0B.A03(this.A00.A07);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final C0844Bi A7l(long granule) {
        if (granule != 0) {
            long jA04 = this.A00.A0B.A04(granule);
            C1354Wa c1354Wa = this.A00;
            return new C0844Bi(new C0846Bk(granule, c1354Wa.A00(c1354Wa.A09, jA04, 30000L)));
        }
        return new C0844Bi(new C0846Bk(0L, this.A00.A09));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final boolean A95() {
        return true;
    }
}
