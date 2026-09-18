package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F8 extends AbstractC1485aT {
    public final YA A00;

    public F8(C05910x c05910x, List<UJ> list, YA ya) {
        super(c05910x, list, ya);
        this.A00 = ya;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C1288Tj A0C(ViewGroup viewGroup, int i) {
        return new C1288Tj(new M0(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1485aT, com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A0H */
    public final void A0E(C1288Tj c1288Tj, int i) {
        super.A0E(c1288Tj, i);
        M0 m0 = (M0) c1288Tj.A0l();
        MC imageView = (MC) m0.getImageCardView();
        imageView.setImageDrawable(null);
        A0F(imageView, i);
        UJ childAd = ((AbstractC1485aT) this).A01.get(i);
        childAd.A11().A0G(this.A00);
        childAd.A1N(m0, m0);
    }
}
