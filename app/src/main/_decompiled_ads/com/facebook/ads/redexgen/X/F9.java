package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F9 extends AbstractC1485aT {
    public final YA A00;
    public final J6 A01;

    public F9(YA ya, C05910x c05910x, List<UJ> list, J6 j6) {
        super(c05910x, list, ya);
        this.A00 = ya;
        this.A01 = j6 == null ? new J6() : j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C1288Tj A0C(ViewGroup viewGroup, int i) {
        return new C1288Tj(new C1093Lv(this.A00, this.A01));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1485aT, com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A0H */
    public final void A0E(C1288Tj c1288Tj, int i) {
        super.A0E(c1288Tj, i);
        C1093Lv c1093Lv = (C1093Lv) c1288Tj.A0l();
        A0F(c1093Lv.getImageCardView(), i);
        if (((AbstractC1485aT) this).A01.get(i) != null) {
            c1093Lv.setTitle(((AbstractC1485aT) this).A01.get(i).getAdHeadline());
            c1093Lv.setSubtitle(((AbstractC1485aT) this).A01.get(i).getAdLinkDescription());
            c1093Lv.setButtonText(((AbstractC1485aT) this).A01.get(i).getAdCallToAction());
        }
        UJ uj = ((AbstractC1485aT) this).A01.get(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c1093Lv);
        uj.A1O(c1093Lv, c1093Lv, arrayList);
    }
}
