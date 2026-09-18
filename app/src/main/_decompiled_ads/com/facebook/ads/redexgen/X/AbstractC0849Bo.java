package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0849Bo {
    public final InterfaceC0848Bm A00;

    public abstract void A0B(C0980Hh c0980Hh, long j) throws C07909d;

    public abstract boolean A0C(C0980Hh c0980Hh) throws C07909d;

    public AbstractC0849Bo(InterfaceC0848Bm interfaceC0848Bm) {
        this.A00 = interfaceC0848Bm;
    }

    public final void A00(C0980Hh c0980Hh, long j) throws C07909d {
        if (A0C(c0980Hh)) {
            A0B(c0980Hh, j);
        }
    }
}
