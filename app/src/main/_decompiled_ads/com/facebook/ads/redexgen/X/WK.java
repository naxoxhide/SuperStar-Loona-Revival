package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WK implements InterfaceC0859Cg {
    public static byte[] A06;
    public static String[] A07 = {"c0KpkRjZorNQD76", "v", "0d4inMg3wDkuo1aYYl0ssqqGC", "DDXERfdvXnPt4luj6e7N9DVUtx6ZaQcR", "MB0SdpAzdDPGS5LRihVQgeZ9YJgSZ4OW", "1ftUnjVA0zWQWzcI2VyXZGsvfHTse3XE", "DWX3euW52jSmR8J8g1ui9PfHl", "CNcDYli8yhj93EfpNTcuq0KbKbZRyRug"};
    public int A00;
    public int A01;
    public long A02;
    public boolean A03;
    public final List<C0867Cr> A04;
    public final InterfaceC0848Bm[] A05;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{52, 67, 67, 63, 60, 54, 52, 71, 60, 66, 65, 2, 55, 73, 53, 70, 72, 53, 70};
    }

    static {
        A01();
    }

    public WK(List<C0867Cr> list) {
        this.A04 = list;
        this.A05 = new InterfaceC0848Bm[list.size()];
    }

    private boolean A02(C0980Hh c0980Hh, int i) {
        if (c0980Hh.A04() == 0) {
            return false;
        }
        if (c0980Hh.A0E() != i) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void A4O(C0980Hh c0980Hh) {
        if (this.A03) {
            if (this.A00 == 2 && !A02(c0980Hh, 32)) {
                return;
            }
            if (this.A00 == 1 && !A02(c0980Hh, 0)) {
                return;
            }
            int iA06 = c0980Hh.A06();
            if (A07[5].charAt(6) != 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[2] = "JHIe8W9CfwFDjJjaFpf1hCiFr";
            strArr[6] = "vBjglJY7hKXluELD1o7ad0wQv";
            int iA04 = c0980Hh.A04();
            for (InterfaceC0848Bm interfaceC0848Bm : this.A05) {
                c0980Hh.A0Y(iA06);
                interfaceC0848Bm.AEr(c0980Hh, iA04);
            }
            int dataPosition = this.A01;
            this.A01 = dataPosition + iA04;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void A4l(InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
        for (int i = 0; i < i; i++) {
            C0867Cr c0867Cr = this.A04.get(i);
            c0870Cu.A05();
            InterfaceC0848Bm interfaceC0848BmAFx = interfaceC0840Bc.AFx(c0870Cu.A03(), 3);
            interfaceC0848BmAFx.A5j(Format.A0A(c0870Cu.A04(), A00(0, 19, 126), null, -1, 0, Collections.singletonList(c0867Cr.A02), c0867Cr.A01, null));
            this.A05[i] = interfaceC0848BmAFx;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void ADi() {
        if (this.A03) {
            for (InterfaceC0848Bm interfaceC0848Bm : this.A05) {
                interfaceC0848Bm.AEs(this.A02, 1, this.A01, 0, null);
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void ADj(long j, boolean z) {
        if (!z) {
            return;
        }
        this.A03 = true;
        this.A02 = j;
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void AEv() {
        this.A03 = false;
    }
}
