package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0872Cw {
    public final int A00;
    public final long A01;

    public C0872Cw(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public static C0872Cw A00(InterfaceC0839Bb interfaceC0839Bb, C0980Hh c0980Hh) throws InterruptedException, IOException {
        interfaceC0839Bb.ADl(c0980Hh.A00, 0, 8);
        c0980Hh.A0Y(0);
        int iA08 = c0980Hh.A08();
        long size = c0980Hh.A0K();
        return new C0872Cw(iA08, size);
    }
}
