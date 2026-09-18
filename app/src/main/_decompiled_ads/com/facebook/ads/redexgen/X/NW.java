package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.util.Log;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NW {
    public static byte[] A0A;
    public NV A00;
    public boolean A01;
    public boolean A02;
    public final C1R A03;
    public final YA A04;
    public final InterfaceC1004If A05;
    public final LN A06;
    public final InterfaceC1091Lt A07;
    public final C1203Qb A08;
    public final String A09;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{31, 8, 29, 30, 41, 40, 40, 51, 50, 31, 48, 53, 63, 55, 16, 53, 47, 40, 57, 50, 57, 46, 114, 69, 69, 88, 69, 23, 82, 79, 82, 84, 66, 67, 94, 89, 80, 23, 86, 84, 67, 94, 88, 89, 73, 126, 126, 99, 126, 44, 123, 100, 101, 96, 105, 44, 99, 124, 105, 98, 101, 98, 107, 44};
    }

    public NW(YA ya, String str, C1203Qb c1203Qb, LN ln, InterfaceC1004If interfaceC1004If, C1R c1r) {
        this(ya, str, c1203Qb, ln, interfaceC1004If, c1r, new T4());
    }

    public NW(YA ya, String str, C1203Qb c1203Qb, LN ln, InterfaceC1004If interfaceC1004If, C1R c1r, InterfaceC1091Lt interfaceC1091Lt) {
        this.A01 = true;
        this.A04 = ya;
        this.A09 = str;
        this.A08 = c1203Qb;
        this.A06 = ln;
        this.A05 = interfaceC1004If;
        this.A03 = c1r;
        this.A07 = interfaceC1091Lt;
    }

    public static void A03(YA ya, C1203Qb c1203Qb, LN ln, InterfaceC1004If interfaceC1004If, C1N c1n, String str, C1R c1r) {
        AbstractC05750g abstractC05750gA01 = C05760h.A01(ya, interfaceC1004If, str, C1050Kc.A00(c1n.A05()), new NL().A03(c1203Qb).A02(ln).A05(), false, false, c1r);
        if (abstractC05750gA01 != null) {
            abstractC05750gA01.A0A();
        }
    }

    private void A05(String str, String str2, Map<String, String> extraData) {
        this.A05.A9o(str, extraData);
        C1064Ks.A00(new NT(this, extraData, str, str2), new NU(this, str, extraData), ActivityUtils.A00());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(String str, String str2, Map<String, String> map) {
        String strA01 = A01(0, 22, 52);
        try {
            AbstractC05750g abstractC05750gA01 = C05760h.A01(this.A04, this.A05, str, C1050Kc.A00(str2), new NL(map).A03(this.A08).A02(this.A06).A05(), this.A01, this.A02, this.A03);
            if (abstractC05750gA01 != null) {
                abstractC05750gA01.A0C();
            }
            NV nv = this.A00;
            if (nv != null) {
                nv.AAz();
            }
            this.A07.A3z(this.A09);
        } catch (ActivityNotFoundException e) {
            Log.e(strA01, A01(44, 20, 100) + str2, e);
        } catch (Exception e2) {
            Log.e(strA01, A01(22, 22, 95), e2);
        }
    }

    public final void A07(NV nv) {
        this.A00 = nv;
    }

    public final void A08(String str, String str2, Map<String, String> extraData) {
        new C1012In(str, this.A05).A04(EnumC1011Im.A0J, extraData);
        if (this.A06.A09(this.A04)) {
            this.A05.A9I(str, extraData);
        } else if (IP.A1I(this.A04)) {
            A05(str, str2, extraData);
        } else {
            A06(str, str2, extraData);
        }
    }

    public final void A09(boolean z) {
        this.A02 = z;
    }

    public final void A0A(boolean z) {
        this.A01 = z;
    }
}
