package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1221Qt {
    public static byte[] A05;
    public C1217Qp A00;
    public EnumC1220Qs A01;
    public String A02;
    public String A03;
    public byte[] A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{119};
    }

    public AbstractC1221Qt(String str, C1223Qv c1223Qv, C1217Qp c1217Qp) {
        this.A03 = A00(0, 0, 77);
        if (str != null) {
            this.A03 = str;
        }
        if (c1223Qv != null && !c1223Qv.A06().isEmpty()) {
            this.A03 += A00(0, 1, 35) + c1223Qv.A06();
        }
        this.A00 = c1217Qp;
    }

    public final C1217Qp A02() {
        return this.A00;
    }

    public final EnumC1220Qs A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final byte[] A06() {
        return this.A04;
    }
}
