package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0866Cp {
    public static byte[] A02;
    public final List<Format> A00;
    public final InterfaceC0848Bm[] A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-107, -70, -62, -83, -72, -75, -80, 108, -81, -72, -69, -65, -79, -80, 108, -81, -83, -68, -64, -75, -69, -70, 108, -71, -75, -71, -79, 108, -64, -59, -68, -79, 108, -68, -66, -69, -62, -75, -80, -79, -80, -122, 108, -17, -2, -2, -6, -9, -15, -17, 2, -9, -3, -4, -67, -15, -13, -17, -69, -60, -66, -58, -4, 11, 11, 7, 4, -2, -4, 15, 4, 10, 9, -54, -2, 0, -4, -56, -46, -53, -45};
    }

    public C0866Cp(List<Format> closedCaptionFormats) {
        this.A00 = closedCaptionFormats;
        this.A01 = new InterfaceC0848Bm[closedCaptionFormats.size()];
    }

    public final void A02(long j, C0980Hh c0980Hh) {
        C0929Fg.A03(j, c0980Hh, this.A01);
    }

    public final void A03(InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
        for (int i = 0; i < i; i++) {
            c0870Cu.A05();
            InterfaceC0848Bm output = interfaceC0840Bc.AFx(c0870Cu.A03(), 3);
            Format format = this.A00.get(i);
            String str = format.A0O;
            HI.A05(A00(43, 19, 86).equals(str) || A00(62, 19, 99).equals(str), A00(0, 43, 20) + str);
            output.A5j(Format.A08(format.A0M != null ? format.A0M : c0870Cu.A04(), str, null, -1, format.A0D, format.A0N, format.A03, null));
            this.A01[i] = output;
        }
    }
}
