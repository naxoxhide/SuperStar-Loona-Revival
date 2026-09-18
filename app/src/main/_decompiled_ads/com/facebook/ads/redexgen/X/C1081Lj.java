package com.facebook.ads.redexgen.X;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1081Lj {
    public static C1081Lj A02;
    public final C1294Tp A00;
    public final C1083Ll A01;

    public C1081Lj(YA ya, Executor executor, C8F c8f) {
        this.A01 = new C1083Ll(ya);
        this.A00 = new C1294Tp(executor, c8f, ya);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(YA ya, Executor executor, C8F c8f) {
        if (!IP.A1D(ya)) {
            return;
        }
        C1081Lj c1081Lj = A02;
        if (c1081Lj == null) {
            C1081Lj c1081Lj2 = new C1081Lj(ya, executor, c8f);
            A02 = c1081Lj2;
            c1081Lj2.A00();
            return;
        }
        c1081Lj.A02(c8f);
    }

    private void A02(C8F c8f) {
        this.A00.A07(c8f);
    }
}
