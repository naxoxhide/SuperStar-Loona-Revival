package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1493ab implements InterfaceC06071n {
    public final /* synthetic */ FA A00;

    public C1493ab(FA fa) {
        this.A00 = fa;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06071n
    public final void ACM(AdError adError) {
        this.A00.A01.ACq(this.A00, adError);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06071n
    public final void ACN() {
        this.A00.A0C.set(true);
        this.A00.A01.ACn(this.A00);
    }
}
