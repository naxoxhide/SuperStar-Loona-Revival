package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.UUID;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1501aj implements InterfaceC05820o, InterfaceC05981e {
    public static byte[] A0B;
    public static String[] A0C = {"PgLDGrk3t3a26fQCrT3IpIrRB5PMNBKm", "uls9HIPpriPjzjIXJVTR7HWmS4IMGzWu", "f2YRmtND2fanruA3kJYGXgN9aGwgjawI", "EZdssni07U2TMPMup9RmA63S0tAhTBNo", "xilKUxawUAlWzUTJOedtCKHAHwNBDRxA", "SxIuirRfQS0L7ik0LzQXw", "dF8CYh", "NQmOIXzIEfwTEqDrM9Z7TuMEUTKSiMNX"};
    public long A00;
    public RewardData A01;
    public InterfaceC05920y A02;
    public C05930z A03;
    public C05991f A04;
    public YA A05;
    public String A06;
    public String A07;
    public String A08;
    public boolean A09;
    public final String A0A = UUID.randomUUID().toString();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        byte[] bArr = {78, 108, 99, 42, 121, 45, 126, 121, 108, 127, 121, 45, 76, 120, 105, 100, 104, 99, 110, 104, 67, 104, 121, 122, 98, 127, 102, 76, 110, 121, 100, 123, 100, 121, 116, 35, 45, SignedBytes.MAX_POWER_OF_TWO, 108, 102, 104, 45, 126, 120, 127, 104, 45, 121, 101, 108, 121, 45, 100, 121, 42, 126, 45, 100, 99, 45, 116, 98, 120, 127, 45, 76, 99, 105, 127, 98, 100, 105, SignedBytes.MAX_POWER_OF_TWO, 108, 99, 100, 107, 104, 126, 121, 35, 117, 96, 97, 45, 107, 100, 97, 104, 35, 73, 77, 78, 122, 107, 102, 106, 97, 108, 106, 65, 106, 123, 120, 96, 125, 100, 68, 37, 42, 27, 37, 39, 48, 45, 50, 45, 48, Base64.padSymbol, 83, 91, 90, 87, 95, 74, 87, 81, 80, 122, 95, 74, 95, 12, 16, 29, 31, 25, 17, 25, 18, 8, 53, 24, 52, 54, 33, 32, 33, 34, 45, 42, 33, 32, 11, 54, 45, 33, 42, 48, 37, 48, 45, 43, 42, 15, 33, Base64.padSymbol, 6, 17, 5, 1, 17, 7, 0, 32, 29, 25, 17, 114, 105, 110, 118, 114, 98, 78, 99, 30, 1, 13, 31, 60, 17, 24, 13, 39, 57, 62, 52, 63, 39};
        if (A0C[1].charAt(29) == 'g') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "6qgGoSyjmuhDFT94hunOHzgd3UUS7LMQ";
        strArr[0] = "q1PjRK7gg6WFD8n4pAFO870HLaNMi7ir";
        A0B = bArr;
    }

    static {
        A05();
    }

    private int A00() {
        WindowManager windowManager = (WindowManager) this.A05.getSystemService(A03(194, 6, 88));
        int rotation = windowManager.getDefaultDisplay().getRotation();
        NP npA02 = A02();
        if (npA02 == NP.A06) {
            return -1;
        }
        if (npA02 == NP.A04) {
            switch (rotation) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        }
        switch (rotation) {
            case 2:
                return 9;
            default:
                String[] strArr = A0C;
                String str = strArr[3];
                String str2 = strArr[7];
                int rotation2 = str.charAt(11);
                if (rotation2 != str2.charAt(11)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0C;
                strArr2[3] = "CZdwi0h9oyeTk4ywD5LtkOxTOpQ29Yc4";
                strArr2[7] = "yy96Y2PoNFwTE84mLwUlYETryPZgGhEq";
                return 1;
        }
    }

    private final EnumC1039Jq A01() {
        return this.A04.A0E();
    }

    private NP A02() {
        return this.A04.A0F();
    }

    private void A04() {
        this.A09 = true;
    }

    private void A06(Intent intent) {
        C05991f c05991f = this.A04;
        RewardData rewardData = this.A01;
        c05991f.A0I(intent, rewardData, PU.A03(rewardData, this.A0A, this.A06));
    }

    private final void A07(YA ya, InterfaceC05920y interfaceC05920y, C06121s c06121s, EnumSet<CacheFlag> enumSet, String str) {
        C05991f c05991f = new C05991f(ya, c06121s, this, str);
        C1C c1cA0D = c05991f.A0D();
        if (IP.A0r(ya)) {
            boolean z = c1cA0D instanceof AbstractC1484aS;
            String[] strArr = A0C;
            if (strArr[3].charAt(11) == strArr[7].charAt(11)) {
                A0C[2] = "TkuXboGIr4gI6uBXxoSPLVsF8oObr4N9";
                if (z && C05790k.A06(this.A05, C05790k.A01(ya, c06121s.A03(), ((AbstractC1484aS) c1cA0D).A11()), ya.A09())) {
                    this.A05.A0E().A4H();
                    this.A02.ABf(this, AdError.NO_FILL);
                    String[] strArr2 = A0C;
                    if (strArr2[3].charAt(11) == strArr2[7].charAt(11)) {
                        A0C[1] = "78EqxHXjdVB4uq4fqkQnSqdXUgUnX7wU";
                        return;
                    }
                }
            }
            throw new RuntimeException();
        }
        this.A04 = c05991f;
        A08(c05991f.A0E());
        c05991f.A0J(ya, enumSet);
    }

    private void A08(EnumC1039Jq enumC1039Jq) {
        if (enumC1039Jq.equals(EnumC1039Jq.A03)) {
            this.A05.A0E().AFV(EnumC05720d.A04);
            return;
        }
        if (enumC1039Jq.equals(EnumC1039Jq.A09)) {
            this.A05.A0E().AFV(EnumC05720d.A03);
            return;
        }
        if (enumC1039Jq.equals(EnumC1039Jq.A0A)) {
            this.A05.A0E().AFV(EnumC05720d.A0A);
            return;
        }
        if (enumC1039Jq.equals(EnumC1039Jq.A0C)) {
            this.A05.A0E().AFV(EnumC05720d.A0C);
            return;
        }
        if (enumC1039Jq.equals(EnumC1039Jq.A0B)) {
            this.A05.A0E().AFV(EnumC05720d.A0B);
            return;
        }
        boolean zEquals = enumC1039Jq.equals(EnumC1039Jq.A05);
        String[] strArr = A0C;
        if (strArr[5].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A0C[2] = "SZ1DhKHJxqFOmux8c4F7iNiG5ZFRRvjL";
        if (!zEquals) {
            return;
        }
        if (this.A04.A0K()) {
            this.A05.A0E().AFV(EnumC05720d.A07);
        } else if ((A09() instanceof AbstractC1484aS) && this.A04.A0L((AbstractC1484aS) A09())) {
            this.A05.A0E().AFV(EnumC05720d.A09);
        } else {
            this.A05.A0E().AFV(EnumC05720d.A08);
        }
    }

    public final C1C A09() {
        return this.A04.A0D();
    }

    public final void A0A(YA ya, InterfaceC05920y interfaceC05920y, C06121s c06121s, EnumSet<CacheFlag> enumSet, String str, String str2, RewardData rewardData) {
        this.A05 = ya;
        this.A02 = interfaceC05920y;
        String strA02 = c06121s.A02();
        this.A08 = strA02;
        this.A06 = strA02 != null ? strA02.split(A03(107, 1, 19))[0] : A03(0, 0, 5);
        this.A00 = c06121s.A00();
        this.A07 = str2;
        this.A01 = rewardData;
        A07(ya, interfaceC05920y, c06121s, enumSet, str);
    }

    public final boolean A0B() {
        if (!this.A09) {
            InterfaceC05920y interfaceC05920y = this.A02;
            if (interfaceC05920y != null) {
                interfaceC05920y.ABf(this, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            }
            return false;
        }
        AdActivityIntent adActivityIntentA04 = KN.A04(this.A05);
        adActivityIntentA04.putExtra(A03(143, 24, 76), A00());
        adActivityIntentA04.putExtra(A03(178, 8, 15), this.A0A);
        adActivityIntentA04.putExtra(A03(132, 11, 116), this.A08);
        adActivityIntentA04.putExtra(A03(167, 11, 124), this.A00);
        EnumC1039Jq enumC1039JqA01 = A01();
        A08(enumC1039JqA01);
        adActivityIntentA04.putExtra(A03(186, 8, 96), enumC1039JqA01);
        String str = this.A07;
        if (str != null) {
            adActivityIntentA04.putExtra(A03(119, 13, 54), str);
        }
        A06(adActivityIntentA04);
        adActivityIntentA04.addFlags(268435456);
        try {
            ActivityUtils.A03(this.A05);
            KN.A09(this.A05, adActivityIntentA04);
            return true;
        } catch (KL e) {
            Throwable cause = e.getCause();
            KL cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            this.A05.A07().A9M(A03(108, 11, 76), C07597x.A0D, new C07607y(cause2));
            Log.e(A03(90, 17, 7), A03(0, 90, 5), cause2);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final String A6N() {
        return this.A04.A0G();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final AdPlacementType A7W() {
        return AdPlacementType.INTERSTITIAL;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05981e
    public final void AAP(AdError adError) {
        InterfaceC05920y interfaceC05920y = this.A02;
        if (interfaceC05920y != null) {
            interfaceC05920y.ABf(this, adError);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05981e
    public final void AAQ() {
        A04();
        this.A02.ABe(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05981e
    public final void AEL() {
        C05930z c05930z = new C05930z(this.A05, this.A0A, this, this.A02);
        this.A03 = c05930z;
        c05930z.A02();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final boolean AFs() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05981e
    public final void AG1() {
        C05930z c05930z = this.A03;
        if (c05930z != null) {
            c05930z.A03();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final void onDestroy() {
        C05991f c05991f = this.A04;
        if (c05991f != null) {
            c05991f.A0H();
        }
    }
}
