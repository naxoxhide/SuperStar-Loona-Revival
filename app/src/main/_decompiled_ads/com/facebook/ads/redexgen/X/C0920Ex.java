package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0920Ex extends AbstractC1465a9 {
    public View A00;
    public C0896Dz A01;

    public C0920Ex(C0896Dz c0896Dz, C06111r c06111r) {
        super(c0896Dz, c06111r);
        this.A01 = c0896Dz;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0L() {
        if (this.A00 != null) {
            this.A01.A0E().A3u();
            this.A06.A0E(this.A00);
        } else {
            this.A01.A0E().A3v();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0N(InterfaceC05820o interfaceC05820o, C8F c8f, C8D c8d, C06121s c06121s) {
        this.A01.A0E().A3o();
        C1502ak c1502ak = (C1502ak) interfaceC05820o;
        C1468aC c1468aC = new C1468aC(this, c06121s, c1502ak);
        A0E().postDelayed(c1468aC, c8f.A05().A05());
        c1502ak.A0I(this.A01, this.A08, this.A07.A07, new C1467aB(this, c1468aC), c06121s);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0Q(String str) {
        this.A01.A0E().A3t(str != null);
        super.A0Q(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0T(boolean z) {
        super.A0T(z);
        this.A00 = null;
    }
}
