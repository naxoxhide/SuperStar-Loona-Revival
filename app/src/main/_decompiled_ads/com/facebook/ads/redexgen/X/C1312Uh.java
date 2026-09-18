package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1312Uh implements InterfaceC1004If {
    public static InterfaceC1004If A03;
    public static byte[] A04;
    public static final String A05;
    public static volatile boolean A06;
    public final Y9 A00;
    public final InterfaceC07668e A01;
    public final InterfaceC1003Ie A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{-90, -21, -4, -21, -12, -6, -76, -88, -37, -37, -52, -44, -41, -37, -48, -43, -50, -121, -37, -42, -121, -45, -42, -50, -121, -56, -43, -121, -48, -43, -35, -56, -45, -48, -53, -121, -43, -13, -30, -28, -26, -24, -26, -17, -26, -13, -22, -28, 46, 51, 42, 31};
    }

    static {
        A03();
        A05 = C1312Uh.class.getSimpleName();
        A06 = false;
    }

    public C1312Uh(Y9 y9) {
        InterfaceC1002Id dispatchCallback;
        this.A00 = y9;
        if (IR.A0T(y9)) {
            InterfaceC07668e interfaceC07668eA00 = C07648c.A00(y9);
            this.A01 = interfaceC07668eA00;
            dispatchCallback = C1009Ik.A00(y9, interfaceC07668eA00);
        } else {
            C0883Dm c0883DmA01 = C07648c.A01(y9);
            dispatchCallback = C1009Ik.A01(y9, c0883DmA01);
            this.A01 = c0883DmA01;
        }
        this.A02 = new C1315Uk(y9, dispatchCallback);
        ExecutorC1072La.A08.execute(new C1314Uj(this));
        A04(y9);
    }

    public static synchronized InterfaceC1004If A01(Y9 y9) {
        if (A03 == null) {
            A03 = new C1312Uh(y9);
        }
        return A03;
    }

    public static synchronized void A04(Y9 y9) {
        if (A06) {
            return;
        }
        y9.A03().AAO();
        A06 = true;
    }

    private void A05(C1001Ic c1001Ic) {
        if (!c1001Ic.A0A()) {
            Log.e(A05, A02(7, 29, 24) + c1001Ic.A06() + A02(0, 7, 55));
        } else {
            A06(c1001Ic);
            this.A01.AGT(c1001Ic, new C1313Ui(this, c1001Ic));
        }
    }

    private void A06(C1001Ic c1001Ic) {
        switch (C1005Ig.A00[c1001Ic.A06().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                C07607y c07607y = new C07607y(new Exception(A02(36, 5, 50)));
                c07607y.A03(1);
                try {
                    c07607y.A05(new JSONObject().put(A02(48, 4, 107), c1001Ic.A06().toString()));
                    break;
                } catch (JSONException unused) {
                }
                this.A00.A07().A9N(A02(41, 7, 50), C07597x.A1H, c07607y);
                break;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9F(String str, Map<String, String> data) {
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A04).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9H(String str, Map<String, String> data) {
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A06).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9I(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A07).A06(C1014Ip.A0A(str, EnumC1011Im.A0I)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9J(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A08).A06(C1014Ip.A0A(str, EnumC1011Im.A06)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9L(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0B).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9P(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0C).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9S(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0D).A06(C1014Ip.A0A(str, EnumC1011Im.A0T)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9T(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0E).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9U(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0F).A06(C1014Ip.A0A(str, EnumC1011Im.A0V)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9V(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0K).A06(C1014Ip.A0A(str, EnumC1011Im.A0W)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9W(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0H).A06(C1014Ip.A0A(str, EnumC1011Im.A0X)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9Y(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0J).A06(C1014Ip.A0A(str, EnumC1011Im.A0Y)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9Z(String str, Map<String, String> data, String str2, EnumC1006Ih enumC1006Ih) {
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(enumC1006Ih).A02(EnumC1007Ii.A00(str2)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9a(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C1001Ic adEvent = new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0L).A07(this.A00);
        A05(adEvent);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9e(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0N).A06(C1014Ip.A0A(str, EnumC1011Im.A0a)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9f(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0O).A06(C1014Ip.A0A(str, EnumC1011Im.A0b)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0P).A06(C1014Ip.A0A(str, EnumC1011Im.A0c)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9i(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0G).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9m(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0Q).A06(C1014Ip.A0A(str, EnumC1011Im.A0g)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9n(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0U).A06(C1014Ip.A0A(str, EnumC1011Im.A0i)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9o(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A04).A02(EnumC1007Ii.A0T).A06(C1014Ip.A0A(str, EnumC1011Im.A0j)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9p(String str, Map<String, String> data) {
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0V).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void A9r(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1000Ib().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(data).A01(EnumC1006Ih.A05).A02(EnumC1007Ii.A0W).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1004If
    public final void ADr(String str) {
        new R1(this.A00).execute(str);
    }
}
