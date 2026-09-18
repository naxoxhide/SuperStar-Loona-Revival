package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1340Vj implements InterfaceC0916Et {
    public final int A00;
    public final /* synthetic */ BT A01;

    public C1340Vj(BT bt, int i) {
        this.A01 = bt;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final boolean A90() {
        return this.A01.A0S(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final void AA2() throws IOException {
        this.A01.A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final int AEC(C9X c9x, XE xe, boolean z) {
        return this.A01.A0P(this.A00, c9x, xe, z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final int AFd(long j) {
        return this.A01.A0O(this.A00, j);
    }
}
