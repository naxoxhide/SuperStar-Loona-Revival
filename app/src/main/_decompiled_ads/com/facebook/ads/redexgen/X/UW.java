package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class UW implements InterfaceC1022Ix {
    public WeakReference<UJ> A00;

    public UW(UJ uj) {
        this.A00 = new WeakReference<>(uj);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1022Ix
    public final void ACK(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1c(z, false);
        }
    }
}
