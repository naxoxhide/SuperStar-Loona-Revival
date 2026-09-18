package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2P extends AbstractC0825An {
    public final int A00;
    public final int A01;
    public final InterfaceC0971Gy<? super InterfaceC0951Gc> A02;
    public final String A03;
    public final boolean A04;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public C2P(String str, InterfaceC0971Gy<? super InterfaceC0951Gc> interfaceC0971Gy) {
        this(str, interfaceC0971Gy, 8000, 8000, false);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public C2P(String str, InterfaceC0971Gy<? super InterfaceC0951Gc> interfaceC0971Gy, int i, int i2, boolean z) {
        this.A03 = str;
        this.A02 = interfaceC0971Gy;
        this.A00 = i;
        this.A01 = i2;
        this.A04 = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC0825An
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C0833Av A01(C0960Gn c0960Gn) {
        return new C0833Av(this.A03, null, this.A02, this.A00, this.A01, this.A04, c0960Gn);
    }
}
