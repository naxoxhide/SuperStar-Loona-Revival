package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XV implements HY {
    public static byte[] A04;
    public static String[] A05 = {"Xobc5aSRFsnlTfq950Hm2L3uP2yqTx5R", "l", "qpzLH3olNTSgnmEJfqgMoILAygrv9Gvu", "rA2kHVtwjUdxF3LXQtoL786BdYvsVYLD", "0rBDFyThd5IBv1Jp4I3rS", "drj1vvUtkoX3RGiyI02l8il3i3aSfPCy", "cZlTLMFk7RrLemAAhuy1ARzIYrj9DMLk", "NSM"};
    public XS A00;
    public HY A01;
    public final C9H A02;
    public final C1325Uu A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-84, -44, -53, -45, -56, -49, -53, -60, 127, -47, -60, -51, -61, -60, -47, -60, -47, 127, -52, -60, -61, -56, -64, 127, -62, -53, -50, -62, -54, -46, 127, -60, -51, -64, -63, -53, -60, -61, -115};
    }

    static {
        A02();
    }

    public XV(C9H c9h, HL hl) {
        this.A02 = c9h;
        this.A03 = new C1325Uu(hl);
    }

    private void A01() {
        this.A03.A02(this.A01.A7c());
        C07929f c07929fA7Z = this.A01.A7Z();
        if (!c07929fA7Z.equals(this.A03.A7Z())) {
            this.A03.AFP(c07929fA7Z);
            this.A02.ACO(c07929fA7Z);
        }
    }

    private boolean A03() {
        XS xs = this.A00;
        if (xs != null && !xs.A8q()) {
            boolean zA90 = this.A00.A90();
            if (A05[1].length() == 23) {
                throw new RuntimeException();
            }
            A05[1] = "Da4vHoBMew1xMnwVwhw0NxQudcM";
            if (zA90 || !this.A00.A8Q()) {
                return true;
            }
        }
        return false;
    }

    public final long A04() {
        if (A03()) {
            A01();
            long jA7c = this.A01.A7c();
            if (A05[7].length() == 18) {
                throw new RuntimeException();
            }
            A05[7] = "L098bBK7xK";
            return jA7c;
        }
        return this.A03.A7c();
    }

    public final void A05() {
        this.A03.A00();
    }

    public final void A06() {
        this.A03.A01();
    }

    public final void A07(long j) {
        this.A03.A02(j);
    }

    public final void A08(XS xs) {
        if (xs == this.A00) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    public final void A09(XS xs) throws C9K {
        HY hyA7F = xs.A7F();
        if (hyA7F != null) {
            HY hy = this.A01;
            if (A05[0].charAt(12) != 'T') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[6] = "G6KpX7Ur5Z0x6RCw4xSrHpY3l6NonZ5O";
            strArr[3] = "DkiI2Rz4cuYvxyrSRslfvXTI6PdAzLXl";
            if (hyA7F != hy) {
                if (hy == null) {
                    this.A01 = hyA7F;
                    this.A00 = xs;
                    HY rendererMediaClock = this.A03;
                    hyA7F.AFP(rendererMediaClock.A7Z());
                    A01();
                    return;
                }
                throw C9K.A02(new IllegalStateException(A00(0, 39, 31)));
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HY
    public final C07929f A7Z() {
        HY hy = this.A01;
        if (hy != null) {
            return hy.A7Z();
        }
        return this.A03.A7Z();
    }

    @Override // com.facebook.ads.redexgen.X.HY
    public final long A7c() {
        if (A03()) {
            return this.A01.A7c();
        }
        return this.A03.A7c();
    }

    @Override // com.facebook.ads.redexgen.X.HY
    public final C07929f AFP(C07929f c07929f) {
        HY hy = this.A01;
        if (hy != null) {
            c07929f = hy.AFP(c07929f);
        }
        this.A03.AFP(c07929f);
        this.A02.ACO(c07929f);
        return c07929f;
    }
}
