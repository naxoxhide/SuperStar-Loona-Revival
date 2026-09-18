package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class WZ implements CT, InterfaceC0845Bj {
    public static String[] A05 = {"RxrevBHwZunvWtoC5v6V", "BM7NoIYIDKALVkWYBFUm4mgKfD4surZT", "wT545zonAETVeqcNIpSLQKDSBA4psZtT", "O6YerNOVuBIV8g4cn8DH", "f7xxxnJira03VIlY2bxNtwSQeXyrwxct", "8kRv9b0m26r6Uh6XKMOB9WasCMU5o07v", "0W8GSaK37PxtOyOV4bIEUVoiYe2UqjRN", "TYUMHNguvpgJeUJ5Wme9D9z4"};
    public long A00 = -1;
    public long A01 = -1;
    public long[] A02;
    public long[] A03;
    public final /* synthetic */ WY A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final C0844Bi A7l(long j) {
        int iA0B = C0996Hx.A0B(this.A02, this.A04.A04(j), true, true);
        long jA03 = this.A04.A03(this.A02[iA0B]);
        C0846Bk c0846Bk = new C0846Bk(jA03, this.A00 + this.A03[iA0B]);
        if (jA03 < j) {
            long[] jArr = this.A02;
            if (iA0B != jArr.length - 1) {
                return new C0844Bi(c0846Bk, new C0846Bk(this.A04.A03(jArr[iA0B + 1]), this.A00 + this.A03[iA0B + 1]));
            }
        }
        return new C0844Bi(c0846Bk);
    }

    public WZ(WY wy) {
        this.A04 = wy;
    }

    public final void A00(long j) {
        this.A00 = j;
    }

    public final void A01(C0980Hh c0980Hh) {
        c0980Hh.A0Z(1);
        int length = c0980Hh.A0G();
        int i = length / 18;
        this.A02 = new long[i];
        this.A03 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.A02[i2] = c0980Hh.A0L();
            this.A03[i2] = c0980Hh.A0L();
            c0980Hh.A0Z(2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final InterfaceC0845Bj A4i() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final long A6k() {
        return this.A04.A01.A01();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final boolean A95() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final long AEA(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        long j = this.A01;
        if (j < 0) {
            return -1L;
        }
        long j2 = -(j + 2);
        this.A01 = -1L;
        if (A05[5].charAt(9) != '6') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[0] = "MeEp95NFLxRX8bxkfA2m";
        strArr[3] = "RwTpOb1Sie1PnKrI5U9E";
        return j2;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final long AFm(long j) {
        long jA04 = this.A04.A04(j);
        long granule = this.A02[C0996Hx.A0B(this.A02, jA04, true, true)];
        this.A01 = granule;
        return jA04;
    }
}
