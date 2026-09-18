package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1330Uz implements InterfaceC0950Gb {
    public final int A00;
    public final GZ A01;
    public final InterfaceC0950Gb A02;
    public final InterfaceC0950Gb A03;
    public final H2 A04;
    public final H4 A05;

    public C1330Uz(H2 h2, InterfaceC0950Gb interfaceC0950Gb, InterfaceC0950Gb interfaceC0950Gb2, GZ gz, int i, H4 h4) {
        this.A04 = h2;
        this.A03 = interfaceC0950Gb;
        this.A02 = interfaceC0950Gb2;
        this.A01 = gz;
        this.A00 = i;
        this.A05 = h4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0950Gb
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final V0 A4U() {
        H2 h2 = this.A04;
        InterfaceC0951Gc interfaceC0951GcA4U = this.A03.A4U();
        InterfaceC0951Gc interfaceC0951GcA4U2 = this.A02.A4U();
        GZ gz = this.A01;
        return new V0(h2, interfaceC0951GcA4U, interfaceC0951GcA4U2, gz != null ? gz.createDataSink() : null, this.A00, this.A05);
    }
}
