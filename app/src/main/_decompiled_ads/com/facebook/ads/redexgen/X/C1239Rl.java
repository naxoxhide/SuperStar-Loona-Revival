package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1239Rl extends AbstractC1202Qa {
    public final /* synthetic */ InterfaceC1004If A00;
    public final /* synthetic */ LN A01;
    public final /* synthetic */ PC A02;
    public final /* synthetic */ C1237Rj A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public C1239Rl(C1237Rj c1237Rj, String str, PC pc, InterfaceC1004If interfaceC1004If, Map map, LN ln) {
        this.A03 = c1237Rj;
        this.A04 = str;
        this.A02 = pc;
        this.A00 = interfaceC1004If;
        this.A05 = map;
        this.A01 = ln;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1202Qa
    public final void A03() {
        if (!this.A03.A02.A0Z() && !TextUtils.isEmpty(this.A04) && !this.A03.A08.get(this.A02.A02())) {
            this.A00.A9S(this.A04, new NL(this.A05).A03(this.A03.A03).A02(this.A01).A05());
            C1R.A07(this.A03.A00, this.A03.A09);
            this.A03.A08.put(this.A02.A02(), true);
        }
    }
}
