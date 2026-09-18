package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X2 implements InterfaceC0848Bm {
    @Override // com.facebook.ads.redexgen.X.InterfaceC0848Bm
    public final void A5j(Format format) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0848Bm
    public final int AEq(InterfaceC0839Bb interfaceC0839Bb, int i, boolean z) throws InterruptedException, IOException {
        int iAFb = interfaceC0839Bb.AFb(i);
        if (iAFb == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return iAFb;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0848Bm
    public final void AEr(C0980Hh c0980Hh, int i) {
        c0980Hh.A0Z(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0848Bm
    public final void AEs(long j, int i, int i2, int i3, C0847Bl c0847Bl) {
    }
}
