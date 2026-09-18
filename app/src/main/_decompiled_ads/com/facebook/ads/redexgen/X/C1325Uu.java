package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1325Uu implements HY {
    public long A00;
    public long A01;
    public C07929f A02 = C07929f.A04;
    public boolean A03;
    public final HL A04;

    public C1325Uu(HL hl) {
        this.A04 = hl;
    }

    public final void A00() {
        if (!this.A03) {
            this.A00 = this.A04.A5O();
            this.A03 = true;
        }
    }

    public final void A01() {
        if (this.A03) {
            A02(A7c());
            this.A03 = false;
        }
    }

    public final void A02(long j) {
        this.A01 = j;
        if (this.A03) {
            this.A00 = this.A04.A5O();
        }
    }

    @Override // com.facebook.ads.redexgen.X.HY
    public final C07929f A7Z() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.HY
    public final long A7c() {
        long elapsedSinceBaseMs = this.A01;
        if (this.A03) {
            long jA5O = this.A04.A5O();
            long positionUs = this.A00;
            long j = jA5O - positionUs;
            if (this.A02.A01 == 1.0f) {
                long positionUs2 = C9E.A00(j);
                return elapsedSinceBaseMs + positionUs2;
            }
            long positionUs3 = this.A02.A00(j);
            return elapsedSinceBaseMs + positionUs3;
        }
        return elapsedSinceBaseMs;
    }

    @Override // com.facebook.ads.redexgen.X.HY
    public final C07929f AFP(C07929f c07929f) {
        if (this.A03) {
            A02(A7c());
        }
        this.A02 = c07929f;
        return c07929f;
    }
}
