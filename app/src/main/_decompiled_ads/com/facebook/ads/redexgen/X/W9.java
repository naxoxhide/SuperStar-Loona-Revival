package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W9 implements InterfaceC0865Co {
    public static byte[] A03;
    public InterfaceC0848Bm A00;
    public C0992Ht A01;
    public boolean A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{90, 75, 75, 87, 82, 88, 90, 79, 82, 84, 85, 20, 67, 22, 72, 88, 79, 94, 8, 14};
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Co
    public final void A4O(C0980Hh c0980Hh) {
        if (!this.A02) {
            if (this.A01.A05() == -9223372036854775807L) {
                return;
            }
            this.A00.A5j(Format.A02(null, A00(0, 20, 99), this.A01.A05()));
            this.A02 = true;
        }
        int iA04 = c0980Hh.A04();
        this.A00.AEr(c0980Hh, iA04);
        this.A00.AEs(this.A01.A04(), 1, iA04, 0, null);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Co
    public final void A8g(C0992Ht c0992Ht, InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
        this.A01 = c0992Ht;
        c0870Cu.A05();
        InterfaceC0848Bm interfaceC0848BmAFx = interfaceC0840Bc.AFx(c0870Cu.A03(), 4);
        this.A00 = interfaceC0848BmAFx;
        interfaceC0848BmAFx.A5j(Format.A0B(c0870Cu.A04(), A00(0, 20, 99), null, -1, null));
    }
}
