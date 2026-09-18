package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ro, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1242Ro extends AbstractC1202Qa {
    public final /* synthetic */ C7H A00;

    public C1242Ro(C7H c7h) {
        this.A00 = c7h;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1202Qa
    public final void A03() {
        if (!this.A00.A0E.A07()) {
            C7H c7h = this.A00;
            c7h.setImpressionRecordingFlag(c7h.A0E);
            if (!TextUtils.isEmpty(this.A00.A0A)) {
                ((AbstractC1283Td) ((AbstractC1283Td) this.A00)).A0C.A9S(this.A00.A0A, new NL().A03(this.A00.A09).A02(this.A00.A0E).A04(((AbstractC1283Td) ((AbstractC1283Td) this.A00)).A0A.A0N()).A05());
                C1R.A07(((AbstractC1283Td) ((AbstractC1283Td) this.A00)).A0A.A0x(), this.A00.A0D);
                this.A00.A0D.A0E().A2g();
                C2C.A00(this.A00.A03.A0M());
            }
        }
    }
}
