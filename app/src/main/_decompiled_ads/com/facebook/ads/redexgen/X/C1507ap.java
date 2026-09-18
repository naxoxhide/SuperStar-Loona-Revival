package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ap, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1507ap implements InterfaceC07105p {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1502ak A01;
    public final /* synthetic */ C1502ak A02;
    public final /* synthetic */ C8G A03;

    public C1507ap(C1502ak c1502ak, int i, C8G c8g, C1502ak c1502ak2) {
        this.A01 = c1502ak;
        this.A00 = i;
        this.A03 = c8g;
        this.A02 = c1502ak2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAW() {
        this.A01.A0B(this.A00, this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAX() {
        this.A01.A00.ABm(this.A02, JG.A00(AdErrorType.NO_FILL));
    }
}
