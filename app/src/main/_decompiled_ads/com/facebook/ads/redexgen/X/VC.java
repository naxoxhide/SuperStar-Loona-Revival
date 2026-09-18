package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VC implements InterfaceC0950Gb {
    public final InterfaceC0971Gy<? super VD> A00;

    public VC() {
        this(null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.FileDataSource> */
    public VC(InterfaceC0971Gy<? super VD> interfaceC0971Gy) {
        this.A00 = interfaceC0971Gy;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0950Gb
    public final InterfaceC0951Gc A4U() {
        return new VD(this.A00);
    }
}
