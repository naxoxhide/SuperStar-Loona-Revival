package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E3 {
    public final GZ A00;
    public final InterfaceC0950Gb A01;
    public final InterfaceC0950Gb A02;
    public final H2 A03;
    public final C0984Hl A04;

    public E3(H2 h2, InterfaceC0950Gb interfaceC0950Gb) {
        this(h2, interfaceC0950Gb, null, null, null);
    }

    public E3(H2 h2, InterfaceC0950Gb interfaceC0950Gb, InterfaceC0950Gb interfaceC0950Gb2, GZ gz, C0984Hl c0984Hl) {
        HI.A01(interfaceC0950Gb);
        this.A03 = h2;
        this.A02 = interfaceC0950Gb;
        this.A01 = interfaceC0950Gb2;
        this.A00 = gz;
        this.A04 = c0984Hl;
    }

    public final H2 A00() {
        return this.A03;
    }

    public final V0 A01(boolean z) {
        InterfaceC0951Gc vd;
        V1 v1;
        InterfaceC0950Gb interfaceC0950Gb = this.A01;
        if (interfaceC0950Gb != null) {
            vd = interfaceC0950Gb.A4U();
        } else {
            vd = new VD();
        }
        if (z) {
            return new V0(this.A03, VE.A02, vd, null, 1, null);
        }
        GZ gz = this.A00;
        if (gz != null) {
            v1 = gz.createDataSink();
        } else {
            v1 = new V1(this.A03, 2097152L);
        }
        InterfaceC0951Gc interfaceC0951GcA4U = this.A02.A4U();
        C0984Hl c0984Hl = this.A04;
        if (c0984Hl != null) {
            interfaceC0951GcA4U = new V5(interfaceC0951GcA4U, c0984Hl, -1000);
        }
        InterfaceC0951Gc upstream = vd;
        return new V0(this.A03, interfaceC0951GcA4U, upstream, v1, 1, null);
    }

    public final C0984Hl A02() {
        C0984Hl c0984Hl = this.A04;
        return c0984Hl != null ? c0984Hl : new C0984Hl();
    }
}
