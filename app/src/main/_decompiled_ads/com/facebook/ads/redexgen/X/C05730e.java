package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05730e extends C2O implements J2 {
    public C07969j A00;
    public List<PC> A01;

    public C05730e(YA ya) {
        super(ya);
        this.A00 = new C07969j(this, 1, null, null, null);
    }

    public final void A23(C1203Qb c1203Qb) {
        C07969j c07969j = this.A00;
        if (c07969j != null) {
            c07969j.A0d(c1203Qb);
        }
    }

    public C07969j getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0e(arrayList);
    }
}
