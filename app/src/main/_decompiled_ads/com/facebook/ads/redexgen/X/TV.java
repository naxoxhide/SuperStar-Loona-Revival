package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TV implements PL {
    public static byte[] A01;
    public final /* synthetic */ TU A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{29, 27, 13, 26, 11, 4, 1, 11, 3};
    }

    public TV(TU tu) {
        this.A00 = tu;
    }

    public /* synthetic */ TV(TU tu, C1282Tc c1282Tc) {
        this(tu);
    }

    @Override // com.facebook.ads.redexgen.X.PL
    public final void AAy() {
        this.A00.A0X(true, A00(0, 9, 55));
    }

    @Override // com.facebook.ads.redexgen.X.PL
    public final void ABZ() {
        if (!TextUtils.isEmpty(this.A00.A0G.A11())) {
            this.A00.A0K.A9S(this.A00.A0G.A11(), new NL().A03(this.A00.A07.getViewabilityChecker()).A02(this.A00.A07.getTouchDataRecorder()).A05());
            C1R.A07(this.A00.A0G.A0x(), this.A00.A0J);
            C2C.A00(this.A00.A0G.A0M());
            this.A00.A0J.A0E().A2g();
        }
        this.A00.A0O.A3z(this.A00.A0P.A74());
    }

    @Override // com.facebook.ads.redexgen.X.PL
    public final void ABu() {
        this.A00.A0O.A3z(this.A00.A0P.A6r());
    }

    @Override // com.facebook.ads.redexgen.X.PL
    public final void ADZ() {
        this.A00.A0O.AAl(15);
    }
}
