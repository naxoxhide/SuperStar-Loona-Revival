package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1463a7 extends K8 {
    public final /* synthetic */ C1501aj A00;
    public final /* synthetic */ C06121s A01;
    public final /* synthetic */ C0919Ew A02;

    public C1463a7(C0919Ew c0919Ew, C06121s c06121s, C1501aj c1501aj) {
        this.A02 = c0919Ew;
        this.A01 = c06121s;
        this.A00 = c1501aj;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        this.A02.A0P(this.A01);
        this.A02.A0M(this.A00);
        this.A02.A00 = null;
        JG jgA00 = JG.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0E().A4p(jgA00.A03().getErrorCode(), jgA00.A04());
        this.A02.A06.A0G(jgA00);
    }
}
