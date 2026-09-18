package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WW implements InterfaceC0838Ba {
    public static byte[] A03;
    public static final InterfaceC0841Bd A04;
    public InterfaceC0840Bc A00;
    public CW A01;
    public boolean A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{108, -121, -113, -110, -117, -118, 70, -102, -107, 70, -118, -117, -102, -117, -104, -109, -113, -108, -117, 70, -120, -113, -102, -103, -102, -104, -117, -121, -109, 70, -102, -97, -106, -117};
    }

    static {
        A02();
        A04 = new WX();
    }

    public static C0980Hh A00(C0980Hh c0980Hh) {
        c0980Hh.A0Y(0);
        return c0980Hh;
    }

    private boolean A03(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        CS cs = new CS();
        if (!cs.A03(interfaceC0839Bb, true) || (cs.A04 & 2) != 2) {
            return false;
        }
        int length = Math.min(cs.A00, 8);
        C0980Hh c0980Hh = new C0980Hh(length);
        interfaceC0839Bb.ADl(c0980Hh.A00, 0, length);
        if (WY.A04(A00(c0980Hh))) {
            this.A01 = new WY();
        } else if (WT.A06(A00(c0980Hh))) {
            this.A01 = new WT();
        } else {
            if (!WV.A04(A00(c0980Hh))) {
                return false;
            }
            this.A01 = new WV();
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void A8e(InterfaceC0840Bc interfaceC0840Bc) {
        this.A00 = interfaceC0840Bc;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final int AE9(InterfaceC0839Bb interfaceC0839Bb, C0843Bh c0843Bh) throws InterruptedException, IOException {
        if (this.A01 == null) {
            if (A03(interfaceC0839Bb)) {
                interfaceC0839Bb.AEm();
            } else {
                throw new C07909d(A01(0, 34, 1));
            }
        }
        if (!this.A02) {
            InterfaceC0848Bm interfaceC0848BmAFx = this.A00.AFx(0, 1);
            this.A00.A5T();
            this.A01.A06(this.A00, interfaceC0848BmAFx);
            this.A02 = true;
        }
        return this.A01.A02(interfaceC0839Bb, c0843Bh);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void AEw(long j, long j2) {
        CW cw = this.A01;
        if (cw != null) {
            cw.A05(j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final boolean AFg(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        try {
            return A03(interfaceC0839Bb);
        } catch (C07909d unused) {
            return false;
        }
    }
}
