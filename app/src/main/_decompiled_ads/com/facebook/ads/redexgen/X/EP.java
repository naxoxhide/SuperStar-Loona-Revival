package com.facebook.ads.redexgen.X;

import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import java.util.EnumSet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EP extends AbstractC1452Zw {
    public static String[] A02 = {"Wdifh5HSN4RyvogFUrIVqQJQULlKdEei", "S34yOHPbjBOZXrhEKXqsFwPvtnd1qciy", "vu9eRI", "x0OqZ", "VYF0eZRg0jpnLcLhIoRoBnoO3djZf6SI", "33GTCt01Ki3rQT8tpwoWMPFpMqFvVQrj", "pa13jV0ykdfTm6Oo414mEZE7qu5xzGka", "tj8XsVszyFe6dIsjKXzcwTwgC3z6jHVp"};
    public static final AnonymousClass24 A03 = new C1443Zl();
    public C1447Zq A00;
    public final AnonymousClass23 A01;

    public EP(AnonymousClass23 anonymousClass23) {
        super(anonymousClass23.A05(), A03.A4d(anonymousClass23));
        this.A01 = anonymousClass23;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1452Zw
    public final void A05() {
        C1447Zq c1447Zq = this.A00;
        if (c1447Zq != null) {
            c1447Zq.A0F();
        }
        InterfaceC06181y interfaceC06181y = super.A00;
        EnumC06171x enumC06171x = EnumC06171x.A04;
        if (A02[1].charAt(8) == 'f') {
            throw new RuntimeException();
        }
        A02[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
        interfaceC06181y.AFC(enumC06171x);
    }

    public final C1447Zq A07() {
        return this.A00;
    }

    public final void A08() {
        C1447Zq c1447Zq = new C1447Zq(this.A01, this, this.A02);
        this.A00 = c1447Zq;
        c1447Zq.A0I(this.A01.A0A(), this.A01.A06());
    }

    public final void A09(InterstitialAd interstitialAd, EnumSet<CacheFlag> cacheFlags, String str) {
        if (super.A00.A5Y()) {
            return;
        }
        this.A01.A0C(interstitialAd);
        C1447Zq c1447Zq = this.A00;
        if (c1447Zq != null) {
            c1447Zq.A0I(cacheFlags, str);
            return;
        }
        this.A01.A0J(cacheFlags);
        this.A01.A0G(str);
        A08();
    }

    public final boolean A0A() {
        C1447Zq c1447Zq = this.A00;
        if (c1447Zq != null) {
            return c1447Zq.A0J();
        }
        if (this.A01.A00() > 0) {
            long jA00 = LM.A00();
            long jA01 = this.A01.A00();
            if (A02[0].charAt(6) == 'y') {
                throw new RuntimeException();
            }
            A02[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
            if (jA00 > jA01) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0B() {
        C1447Zq c1447Zq = this.A00;
        if (c1447Zq != null) {
            return c1447Zq.A0K();
        }
        return super.A00.A5r() == EnumC06171x.A06;
    }

    public final boolean A0C(InterstitialAd interstitialAd, InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        if (super.A00.A5Z()) {
            return false;
        }
        this.A01.A0C(interstitialAd);
        C1447Zq c1447Zq = this.A00;
        if (c1447Zq != null) {
            return c1447Zq.A0L();
        }
        C1447Zq c1447Zq2 = new C1447Zq(this.A01, this, this.A02);
        this.A00 = c1447Zq2;
        c1447Zq2.A0L();
        return false;
    }
}
