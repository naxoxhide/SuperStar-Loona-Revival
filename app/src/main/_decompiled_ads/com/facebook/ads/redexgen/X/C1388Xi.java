package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1388Xi implements C7U {
    public static C1388Xi A07;
    public static byte[] A08;
    public static String[] A09 = {"kZNWMB05A80rolZkZr5gINRkemJedumA", "PGnlsDLswmZGHAGkHnqyou4j", "CQczeQcoxNMNqPeDO5UPH4delPie3CF6", "Ozs7AQnIuhnl4TF488yhCLnc3lqg3Tqv", "QUMQF15y8F49TOv2Mbtf3pi6YRJU7tsl", "iRM3Hx3PCEqf", "8yEJzjy1AvS4vnL", "zEXAgd0MZ6iopjt"};
    public C0V A00;
    public C6U A01;
    public C7T A02;
    public C7j A03;
    public C8N A04;
    public InterfaceC1016Ir A05;
    public InterfaceC0953Ge A06;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A09;
            if (strArr[6].length() != strArr[7].length()) {
                break;
            }
            String[] strArr2 = A09;
            strArr2[6] = "Hv2WK1fJh7GnXaP";
            strArr2[7] = "jwUFRNkRPBL5IaL";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            int i5 = bArrCopyOfRange[i4] - i3;
            String[] strArr3 = A09;
            if (strArr3[4].charAt(26) != strArr3[0].charAt(26)) {
                break;
            }
            String[] strArr4 = A09;
            strArr4[2] = "3jbuj6iR6sIerVLqEJ9xAsC0KuP7QrbG";
            strArr4[3] = "qsuffxm3RCjhy50iWQEl04Txy4tWGAPw";
            bArrCopyOfRange[i4] = (byte) (i5 - 98);
            i4++;
        }
        throw new RuntimeException();
    }

    public static void A07() {
        A08 = new byte[]{-61, -57, -14, -58, -56, -64, -60, -62, -16, 2, 16, 16, 6, 12, 11, -67, 1, -2, 17, -2, -67, 6, 11, 6, 17, 6, -2, 9, 6, 23, 2, 1, 33, 20, 31, 30, 33, 35, 2, 20, 34, 34, 24, 30, 29, -13, 16, 35, 16, -8, 29, 24, 35, 24, 16, 27, 24, 41, 20, 19};
        if (A09[1].length() == 32) {
            throw new RuntimeException();
        }
        String[] strArr = A09;
        strArr[2] = "XQj6tBQR93KUWcmqG7acynHpkyXbPHo4";
        strArr[3] = "0fPU7ngiro1m2vFzwgFa3cBnolZ3o5pA";
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0C(Y9 y9) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(y9);
        InterfaceC0953Ge interfaceC0953GeA05 = A05(y9, this.A03, A03(y9));
        this.A06 = interfaceC0953GeA05;
        A09(y9, A00(y9, interfaceC0953GeA05));
        A0A(y9, this.A06);
        A0B(y9, this.A06);
        InterfaceC0953Ge interfaceC0953Ge = this.A06;
        if (interfaceC0953Ge != null) {
            interfaceC0953Ge.A5i();
        }
    }

    static {
        A07();
    }

    public static InterfaceC07155u A00(Y9 y9, InterfaceC0953Ge interfaceC0953Ge) {
        if (!IP.A1Q(y9) || interfaceC0953Ge == null) {
            return null;
        }
        return AbstractC07165v.A00().A00(interfaceC0953Ge);
    }

    public static C7j A01(Y9 y9) {
        return AbstractC07477k.A00().A00(y9, new C1395Xp());
    }

    public static synchronized C1388Xi A02() {
        if (A07 == null) {
            A07 = new C1388Xi();
        }
        return A07;
    }

    public static InterfaceC1209Qh A03(Y9 y9) {
        if (!IP.A1M(y9)) {
            return null;
        }
        return C1227Qz.A01(y9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C7U
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized InterfaceC0953Ge A7y() {
        return this.A06;
    }

    public static InterfaceC0953Ge A05(Y9 y9, C7j c7j, InterfaceC1209Qh interfaceC1209Qh) {
        if (!IP.A2A(y9) || interfaceC1209Qh == null) {
            return null;
        }
        return RM.A00().A00(y9, c7j, interfaceC1209Qh, C1037Jo.A04(y9), new C1389Xj(new C1030Jg(y9, A06(0, 0, 122), null, JL.A07, AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, 0, AdSettings.isTestMode(y9), AdSettings.isMixedAudience(), new JQ(), LD.A01(IP.A0J(y9)), null, null), y9), RK.A00().A00());
    }

    public static void A08() {
        String strA06 = A06(8, 24, 59);
        if (A09[5].length() == 20) {
            throw new RuntimeException();
        }
        A09[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
        JU.A05(A06(32, 28, 77), strA06, A06(0, 8, 46));
    }

    public static void A09(Y9 y9, InterfaceC07155u interfaceC07155u) {
        if (!IP.A1Q(y9) || interfaceC07155u == null) {
            return;
        }
        AbstractC07135s.A00().A00(interfaceC07155u, y9);
    }

    public static void A0A(Y9 y9, InterfaceC0953Ge interfaceC0953Ge) {
        if (!IP.A0k(y9) || interfaceC0953Ge == null) {
            return;
        }
        new C6F(y9, interfaceC0953Ge, new C6G(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(Y9 y9, InterfaceC0953Ge interfaceC0953Ge) {
        if (interfaceC0953Ge == null) {
            return;
        }
        IS.A00(y9, interfaceC0953Ge);
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final InterfaceC1004If A5q(Y9 y9) {
        return C1312Uh.A01(y9);
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized C7T A65(C7S c7s) {
        if (this.A02 == null) {
            this.A02 = new C1390Xk(this);
        }
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized C6U A6G() {
        if (this.A01 == null) {
            this.A01 = new YB();
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized C7j A6d(C7S c7s) {
        if (this.A03 == null) {
            this.A03 = A01(c7s.A01());
        }
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized InterfaceC07587w A6e(C7S c7s) {
        return new C1404Xy(c7s);
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized C7V A6o(C7S c7s) {
        return new C0891Du(this, c7s);
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized C0V A70(C7S c7s) {
        if (!IP.A0w(c7s)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = C0W.A00().A00(new C1393Xn(c7s));
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized C7X A7i(C7S c7s) {
        return new C1391Xl(c7s);
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final Y9 A7j(Context context) {
        Y9 sdkContext = C7R.A00();
        if (sdkContext == null) {
            Y9 sdkContext2 = new Y9(context, this);
            C7R.A01(sdkContext2);
            return sdkContext2;
        }
        return sdkContext;
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized InterfaceC1016Ir A7k(Y9 y9) {
        if (this.A05 == null) {
            this.A05 = new C1319Uo(y9);
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.C7U
    public final synchronized C8N A7q() {
        if (this.A04 == null) {
            this.A04 = new C8N();
            A08();
        }
        return this.A04;
    }
}
