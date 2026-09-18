package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ac, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1494ac implements InterfaceC07105p {
    public final /* synthetic */ FA A00;

    public C1494ac(FA fa) {
        this.A00 = fa;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAW() {
        this.A00.A0C.set(true);
        this.A00.A01.ACn(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAX() {
        this.A00.A01.ACq(this.A00, AdError.CACHE_ERROR);
    }
}
