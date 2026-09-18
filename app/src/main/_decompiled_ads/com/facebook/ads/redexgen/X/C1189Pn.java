package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1189Pn implements InterfaceC1183Ph {
    public final View A00;
    public final YA A01;

    public C1189Pn(YA ya, View view) {
        this.A01 = ya;
        this.A00 = view;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1183Ph
    public final double A8B() {
        C1204Qc result = C1203Qb.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
