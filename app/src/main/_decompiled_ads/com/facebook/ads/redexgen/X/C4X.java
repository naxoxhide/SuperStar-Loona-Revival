package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4X {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final C4X A00(AbstractC06894u abstractC06894u, int i) {
        View view = abstractC06894u.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final C4X A01(AbstractC06894u abstractC06894u) {
        return A00(abstractC06894u, 0);
    }
}
