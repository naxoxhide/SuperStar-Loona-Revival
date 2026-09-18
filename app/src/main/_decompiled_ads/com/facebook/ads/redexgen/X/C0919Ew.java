package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0919Ew extends AbstractC1465a9 {
    public C0919Ew(YA ya, C06111r c06111r) {
        super(ya, c06111r);
    }

    private C1462a6 A00(Runnable runnable) {
        return new C1462a6(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final C1C A0F() {
        C1501aj successfullyLoadedAdapter = (C1501aj) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0L() {
        C1501aj interstitialAdapter = (C1501aj) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0N(InterfaceC05820o interfaceC05820o, C8F c8f, C8D c8d, C06121s c06121s) {
        C1501aj c1501aj = (C1501aj) interfaceC05820o;
        C1463a7 c1463a7 = new C1463a7(this, c06121s, c1501aj);
        A0E().postDelayed(c1463a7, c8f.A05().A05());
        c1501aj.A0A(this.A0B, A00(c1463a7), c06121s, this.A07.A0A, this.A07.A04, this.A07.A05, this.A07.A02);
    }
}
