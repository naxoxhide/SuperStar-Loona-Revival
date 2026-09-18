package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V5 implements InterfaceC0951Gc {
    public final int A00;
    public final InterfaceC0951Gc A01;
    public final C0984Hl A02;

    public V5(InterfaceC0951Gc interfaceC0951Gc, C0984Hl c0984Hl, int i) {
        this.A01 = (InterfaceC0951Gc) HI.A01(interfaceC0951Gc);
        this.A02 = (C0984Hl) HI.A01(c0984Hl);
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final Uri A85() {
        return this.A01.A85();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final long ADb(C0955Gg c0955Gg) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.ADb(c0955Gg);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.read(bArr, i, i2);
    }
}
