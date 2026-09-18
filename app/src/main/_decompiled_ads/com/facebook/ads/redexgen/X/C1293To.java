package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.To, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1293To implements C5H {
    public final /* synthetic */ C1290Tl A00;

    public C1293To(C1290Tl c1290Tl) {
        this.A00 = c1290Tl;
    }

    @Override // com.facebook.ads.redexgen.X.C5H
    public final boolean A8k() {
        if (this.A00.A0B.canGoBack()) {
            this.A00.A0B.goBack();
            return true;
        }
        return false;
    }
}
