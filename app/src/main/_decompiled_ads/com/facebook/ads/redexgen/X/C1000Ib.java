package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1000Ib {
    public double A00;
    public EnumC1006Ih A01;
    public EnumC1007Ii A02;
    public String A03;
    public String A04;
    public Map<String, String> A05;
    public boolean A06;

    public final C1000Ib A00(double d) {
        this.A00 = d;
        return this;
    }

    public final C1000Ib A01(EnumC1006Ih enumC1006Ih) {
        this.A01 = enumC1006Ih;
        return this;
    }

    public final C1000Ib A02(EnumC1007Ii enumC1007Ii) {
        this.A02 = enumC1007Ii;
        return this;
    }

    public final C1000Ib A03(String str) {
        this.A03 = str;
        return this;
    }

    public final C1000Ib A04(String str) {
        this.A04 = str;
        return this;
    }

    public final C1000Ib A05(Map<String, String> mData) {
        this.A05 = mData;
        return this;
    }

    public final C1000Ib A06(boolean z) {
        this.A06 = z;
        return this;
    }

    public final C1001Ic A07(C7S c7s) {
        return new C1001Ic(c7s, this.A04, this.A00, this.A03, this.A05, this.A01, this.A02, this.A06);
    }
}
