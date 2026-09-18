package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0903Eg extends AbstractC1297Ts<C1458a2> {
    public static String[] A00 = {"ByMq6MLqhjUJsdWB3RBIp", "zuOr3", "msyHKBX3wHVeYE5obxbctQprcgEzI02t", "I3sOgeRwcNYGF4oixOV5Q17", "dcB", "ibtCqc8qysdz0E5AMIDmPhuL1XZA", "mNtKCg4kzaH6sXUtb2oDuqx2", "ObFvkEusatMYzjWaq72f4FkWXHrQjerH"};

    public C0903Eg(C1458a2 c1458a2) {
        super(c1458a2);
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        C1458a2 c1458a2A07 = A07();
        if (c1458a2A07 == null) {
            return;
        }
        YA ya = c1458a2A07.A08;
        String[] strArr = A00;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A00[5] = "SiVLKh";
        if (C1084Lm.A02(ya)) {
            c1458a2A07.A07();
        } else {
            c1458a2A07.A05.postDelayed(c1458a2A07.A0C, 5000L);
        }
    }
}
