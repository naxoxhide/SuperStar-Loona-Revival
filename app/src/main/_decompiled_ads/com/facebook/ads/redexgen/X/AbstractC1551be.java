package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.be, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1551be {
    public InterfaceC1552bf A00;

    public final void A00() {
        InterfaceC1552bf interfaceC1552bf = this.A00;
        if (interfaceC1552bf != null) {
            interfaceC1552bf.onStart();
        }
    }

    public final void A01() {
        InterfaceC1552bf interfaceC1552bf = this.A00;
        if (interfaceC1552bf != null) {
            interfaceC1552bf.onStop();
        }
    }

    public final void A02(InterfaceC1552bf interfaceC1552bf) {
        this.A00 = interfaceC1552bf;
    }
}
