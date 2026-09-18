package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1321Uq implements InterfaceC1556bj<IV, C0999Ia> {
    public C1318Un A00;

    public C1321Uq(C1318Un c1318Un) {
        this.A00 = c1318Un;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.bg != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1556bj
    public final void A5X(C1553bg<IV, C0999Ia> c1553bg, InterfaceC1542bV interfaceC1542bV) {
        switch (IT.A00[interfaceC1542bV.A8A(c1553bg).ordinal()]) {
            case 1:
            case 2:
                this.A00.A02(c1553bg, interfaceC1542bV);
                break;
        }
    }
}
