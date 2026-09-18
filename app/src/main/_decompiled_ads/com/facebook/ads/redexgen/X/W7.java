package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class W7 implements InterfaceC0865Co {
    public static String[] A02 = {"KDcVXuz53RpoF9UEOZ96l2VZuhVX9ip0", "CKRJ1Pqx0SMvAzHTc14bPVY1Im6KLWKe", "CZRg2SIX1VWZgfyXTOdEl1", "FcRR7mDk42dnDG0ym1pZJ2", "QPo", "3iSkzhZlTwG2jcdx249ci8whKDsXKTKF", "nuc6nRuUqT3GqwIih", "HhkYvD09GQfRAuSaGWngxJEfFHmtitdD"};
    public final C0979Hg A00 = new C0979Hg(new byte[4]);
    public final /* synthetic */ W5 A01;

    public W7(W5 w5) {
        this.A01 = w5;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Co
    public final void A4O(C0980Hh c0980Hh) {
        int tableId = c0980Hh.A0E();
        if (tableId != 0) {
            return;
        }
        c0980Hh.A0Z(7);
        int iA04 = c0980Hh.A04() / 4;
        for (int programNumber = 0; programNumber < iA04; programNumber++) {
            c0980Hh.A0a(this.A00, 4);
            int iA05 = this.A00.A04(16);
            this.A00.A08(3);
            if (iA05 == 0) {
                this.A00.A08(13);
            } else {
                int i = this.A00.A04(13);
                this.A01.A06.put(i, new WA(new W6(this.A01, i)));
                W5.A01(this.A01);
            }
        }
        int i2 = this.A01.A05;
        int programCount = A02[4].length();
        if (programCount == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "4awIAPS5zJKVkKN48BLjJX";
        strArr[2] = "yyhTqQNSKamLuuIUjTGErW";
        if (i2 != 2) {
            this.A01.A06.remove(0);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Co
    public final void A8g(C0992Ht c0992Ht, InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
    }
}
