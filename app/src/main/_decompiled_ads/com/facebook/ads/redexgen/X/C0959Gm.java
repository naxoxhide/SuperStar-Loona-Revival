package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0959Gm extends IOException {
    public final int A00;
    public final C0955Gg A01;

    public C0959Gm(IOException iOException, C0955Gg c0955Gg, int i) {
        super(iOException);
        this.A01 = c0955Gg;
        this.A00 = i;
    }

    public C0959Gm(String str, C0955Gg c0955Gg, int i) {
        super(str);
        this.A01 = c0955Gg;
        this.A00 = i;
    }

    public C0959Gm(String str, IOException iOException, C0955Gg c0955Gg, int i) {
        super(str, iOException);
        this.A01 = c0955Gg;
        this.A00 = i;
    }
}
