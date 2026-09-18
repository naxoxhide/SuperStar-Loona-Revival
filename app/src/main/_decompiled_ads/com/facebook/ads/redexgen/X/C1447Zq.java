package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1447Zq implements AnonymousClass20 {
    public static byte[] A0B;
    public static String[] A0C = {"Q9RghtL5kPMxXUG2hlpmHrVaJwYYGwGq", "TIO3FaU0Mikock0w3rckrPhiuYRMfGhJ", "k6SAISDvmHdOF1rkjeEeymm6HvDlJVR0", "eDRhFd25R2oFsFg27vb0d5UADzs1KoZv", "MaVPWgska1IH7XOKtPwNB8GdxIWUIxDt", "dS1g8OO0fBonmOwqVSSlXi39LbvMIXQb", "JdFW5Fpsu4G", "QGzwgj8zvaLwI8"};
    public static final String A0D;
    public InterstitialAd A01;
    public C1C A02;
    public C0919Ew A03;
    public C1427Yv A04;
    public boolean A06;
    public boolean A07;
    public final YA A08;
    public final InterstitialAdExtendedListener A09;
    public final AnonymousClass23 A0A;
    public long A00 = -1;
    public LN A05 = new LN();

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A0B = new byte[]{-59, -14, -92, -27, -24, -92, -16, -13, -27, -24, -92, -19, -9, -92, -27, -16, -10, -23, -27, -24, -3, -92, -19, -14, -92, -12, -10, -13, -21, -10, -23, -9, -9, -78, -92, -35, -13, -7, -92, -9, -20, -13, -7, -16, -24, -92, -5, -27, -19, -8, -92, -22, -13, -10, -92, -27, -24, -48, -13, -27, -24, -23, -24, -84, -83, -92, -8, -13, -92, -26, -23, -92, -25, -27, -16, -16, -23, -24, -4, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -45, 31, 34, 20, 23, -45, 22, 20, 31, 31, 24, 23, -45, 42, 27, 28, 31, 24, -45, 38, 27, 34, 42, 28, 33, 26, -45, 28, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -31, 13, 28, 21};
    }

    static {
        A0B();
        A0D = C1447Zq.class.getSimpleName();
    }

    public C1447Zq(AnonymousClass23 anonymousClass23, C2A c2a, String str) {
        this.A0A = anonymousClass23;
        this.A08 = anonymousClass23.A05();
        this.A09 = new C1439Zh(str, c2a, this);
    }

    public final long A0E() {
        C0919Ew c0919Ew = this.A03;
        if (c0919Ew != null) {
            return c0919Ew.A0D();
        }
        return -1L;
    }

    public final void A0F() {
        C0919Ew c0919Ew = this.A03;
        if (c0919Ew != null) {
            c0919Ew.A0O(new C1448Zr(this));
            this.A03.A0T(true);
            this.A03 = null;
            this.A07 = false;
            this.A06 = false;
        }
    }

    public final void A0G() {
        C1427Yv c1427Yv = this.A04;
        if (c1427Yv != null) {
            c1427Yv.A02();
        }
    }

    public final void A0H(AdCompanionView adCompanionView) {
        C1C c1c;
        C1427Yv c1427Yv = (C1427Yv) adCompanionView.getAdCompanionViewApi();
        this.A04 = c1427Yv;
        YA ya = this.A08;
        if (ya != null && (c1c = this.A02) != null && (c1c instanceof AbstractC1484aS)) {
            c1427Yv.A03(ya, (AbstractC1484aS) c1c);
        }
    }

    public final void A0I(EnumSet<CacheFlag> enumSet, String str) {
        String strA02;
        this.A00 = System.currentTimeMillis();
        if (!this.A07 && this.A03 != null) {
            Log.w(A0D, A0A(0, 78, 22));
        }
        this.A07 = false;
        if (this.A06 && !IP.A0h(this.A08)) {
            this.A08.A07().A9M(A0A(130, 3, 62), C07597x.A0L, new C07607y(A0A(78, 52, 69)));
            AdErrorType adErrorType = AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD;
            this.A08.A0E().A2i(LM.A01(this.A00), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            this.A09.onError(this.A0A.A01(), new AdError(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage()));
            return;
        }
        C0919Ew c0919Ew = this.A03;
        if (c0919Ew != null) {
            c0919Ew.A0O(new C1451Zv(this));
            this.A03.A0J();
            this.A03 = null;
        }
        C06111r c06111r = new C06111r(this.A0A.A09(), JN.A00(this.A08.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, JJ.A07, 1, enumSet);
        if (IP.A24(this.A08) && (strA02 = C1051Kd.A02(this.A08, this.A0A.A07())) != null) {
            AnonymousClass23 anonymousClass23 = this.A0A;
            if (A0C[6].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[3] = "6YCA3PHZSlLj0jmN2b2hvaW99ZyRMwjh";
            strArr[5] = "7PoIPIeUN8KAt8vfreK3c69iBAU82q7R";
            anonymousClass23.A0H(strA02);
        }
        c06111r.A06(this.A0A.A07());
        c06111r.A07(this.A0A.A08());
        c06111r.A04(this.A0A.A03());
        C0919Ew c0919Ew2 = new C0919Ew(this.A08, c06111r);
        this.A03 = c0919Ew2;
        c0919Ew2.A0O(new C1449Zs(this));
        this.A03.A0R(str);
    }

    public final boolean A0J() {
        C0919Ew c0919Ew = this.A03;
        return c0919Ew == null || c0919Ew.A0U();
    }

    public final boolean A0K() {
        return this.A07;
    }

    public final boolean A0L() {
        AdError adError = AdError.SHOW_CALLED_BEFORE_LOAD_ERROR;
        if (!this.A07) {
            this.A08.A0E().A2i(LM.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A09.onError(this.A0A.A01(), adError);
            return false;
        }
        C0919Ew c0919Ew = this.A03;
        if (c0919Ew == null) {
            this.A08.A07().A9M(A0A(130, 3, 62), C07597x.A0S, new C07607y(AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL.getDefaultErrorMessage()));
            this.A08.A0E().A2i(LM.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A09.onError(this.A0A.A01(), adError);
            return false;
        }
        c0919Ew.A0I();
        this.A06 = true;
        this.A07 = false;
        return true;
    }
}
