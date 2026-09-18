package com.facebook.ads.redexgen.X;

import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ql, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1213Ql {
    public C1217Qp A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04 = true;

    public final C1213Ql A00(C1217Qp c1217Qp) {
        this.A00 = c1217Qp;
        return this;
    }

    public final C1213Ql A01(Set<String> pinnedCertificates) {
        this.A01 = pinnedCertificates;
        return this;
    }

    public final C1213Ql A02(Set<String> pinnedPublicKeys) {
        this.A02 = pinnedPublicKeys;
        return this;
    }

    public final C1213Ql A03(boolean z) {
        this.A04 = z;
        return this;
    }

    public final C1213Ql A04(boolean z) {
        this.A03 = z;
        return this;
    }

    public final C1214Qm A05() {
        return new C1214Qm(this.A00, this.A04, this.A02, this.A01, this.A03);
    }
}
