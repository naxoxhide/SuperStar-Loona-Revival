package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ry, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1252Ry extends AbstractC1202Qa {
    public final /* synthetic */ C7I A00;

    public C1252Ry(C7I c7i) {
        this.A00 = c7i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1202Qa
    public final void A03() {
        if (!this.A00.A0H.A07()) {
            C7I c7i = this.A00;
            c7i.setImpressionRecordingFlag(c7i.A0H);
            if (!TextUtils.isEmpty(this.A00.A0C)) {
                ((AbstractC1283Td) ((AbstractC1283Td) this.A00)).A0C.A9S(this.A00.A0C, new NL().A03(this.A00.A0B).A02(this.A00.A0H).A04(((AbstractC1283Td) ((AbstractC1283Td) this.A00)).A0A.A0N()).A05());
                C1R.A07(((AbstractC1283Td) ((AbstractC1283Td) this.A00)).A0A.A0x(), this.A00.A0G);
                this.A00.A0G.A0E().A2g();
                C2C.A00(this.A00.A04.A0M());
            }
        }
    }
}
