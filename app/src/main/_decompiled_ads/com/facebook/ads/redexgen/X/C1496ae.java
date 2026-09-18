package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ae, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1496ae implements InterfaceC07105p {
    public final /* synthetic */ FA A00;
    public final /* synthetic */ boolean A01;

    public C1496ae(FA fa, boolean z) {
        this.A00 = fa;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAW() {
        if (!IP.A1S(this.A00.A04) || !this.A01) {
            this.A00.A0C.set(true);
            this.A00.A01.ACn(this.A00);
        } else {
            FA fa = this.A00;
            fa.A06 = C1158Oi.A01(fa.A04, (C0921Ey) this.A00.A03, 0, new C1497af(this));
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAX() {
        this.A00.A01.ACq(this.A00, AdError.CACHE_ERROR);
    }
}
