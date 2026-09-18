package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1449Zs extends AbstractC05830p {
    public static byte[] A01;
    public static String[] A02 = {"", "lR4UvBki6PSdVcLREjEHAbqRd1OmLUQf", "DjKPGQUWmMf7x", "ODfaPUPPzX7KhktdCz15RADFZIjUcUTH", "SOtQhTlfKwNvvZXzwoqU2I3z2iEV30z7", "BHtVd6ktyCMEATMZK8J5wjGrCvXYI9tG", "P8UTzFKpwpJ94", "IxNcf87J3g"};
    public final /* synthetic */ C1447Zq A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{99, 114, 107, 29, 17, 16, 10, 12, 17, 18, 18, 27, 12, 94, 23, 13, 94, 16, 11, 18, 18};
    }

    static {
        A01();
    }

    public C1449Zs(C1447Zq c1447Zq) {
        this.A00 = c1447Zq;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A02() {
        if (this.A00.A01 == null) {
            this.A00.A06 = false;
            this.A00.A09.onInterstitialActivityDestroyed();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A04() {
        if (this.A00.A01 != null) {
            this.A00.A01.show();
            return;
        }
        this.A00.A06 = false;
        if (this.A00.A03 != null) {
            this.A00.A03.A0O(new Zt(this));
            this.A00.A03.A0J();
            this.A00.A03 = null;
        }
        this.A00.A09.onInterstitialDismissed(this.A00.A0A.A01());
        this.A00.A05.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A05() {
        this.A00.A09.onInterstitialDisplayed(this.A00.A0A.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A06() {
        this.A00.A09.onRewardedAdServerFailed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A07() {
        this.A00.A09.onRewardedAdServerSucceeded();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A08() {
        this.A00.A09.onRewardedAdCompleted();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A0C() {
        this.A00.A08.A0E().A2f();
        this.A00.A09.onAdClicked(this.A00.A0A.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A0D() {
        this.A00.A09.onLoggingImpression(this.A00.A0A.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A0E(View view) {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0098  */
    /* JADX WARN: Code duplicated, block: B:18:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:24:0x0137  */
    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A0F(InterfaceC05820o interfaceC05820o) {
        C1051Kd c1051Kd;
        if (this.A00.A03 != null) {
            this.A00.A07 = true;
            C1447Zq c1447Zq = this.A00;
            c1447Zq.A02 = c1447Zq.A03.A0F();
            boolean z = this.A00.A02 instanceof AbstractC1484aS;
            String[] strArr = A02;
            if (strArr[6].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "VeASnUkJuhfeOmGjJqk9CbDFf3FFhRFx";
            strArr2[5] = "TZLIDWk0RuIbUDThQePy8NEYvQ7OtG1H";
            if (z) {
                final AbstractC1484aS abstractC1484aS = (AbstractC1484aS) this.A00.A02;
                int iA0t = abstractC1484aS.A0t();
                String[] strArr3 = A02;
                if (strArr3[0].length() != strArr3[3].length()) {
                    String[] strArr4 = A02;
                    strArr4[6] = "g2LThTD3HDKTh";
                    strArr4[2] = "DwNNkt8z8VoEk";
                    if (iA0t > 0) {
                        c1051Kd = new C1051Kd();
                        if (c1051Kd.A09(this.A00.A08, this.A00.A0A.A07(), abstractC1484aS.A0t())) {
                            c1051Kd.A08(this.A00.A08, true);
                            C1447Zq c1447Zq2 = this.A00;
                            c1447Zq2.A01 = c1051Kd.A06(c1447Zq2.A08, this.A00.A0A.A09(), this.A00.A0A.A07());
                        } else {
                            c1051Kd.A08(this.A00.A08, false);
                        }
                    }
                } else if (iA0t > 0) {
                    c1051Kd = new C1051Kd();
                    if (c1051Kd.A09(this.A00.A08, this.A00.A0A.A07(), abstractC1484aS.A0t())) {
                        c1051Kd.A08(this.A00.A08, true);
                        C1447Zq c1447Zq3 = this.A00;
                        c1447Zq3.A01 = c1051Kd.A06(c1447Zq3.A08, this.A00.A0A.A09(), this.A00.A0A.A07());
                    } else {
                        c1051Kd.A08(this.A00.A08, false);
                    }
                }
                if (this.A00.A01 == null) {
                    this.A00.A09.onAdLoaded(this.A00.A0A.A01());
                    return;
                }
                abstractC1484aS.A16(true);
                InterstitialAd.InterstitialLoadAdConfig loadAdConfig = this.A00.A01.buildLoadAdConfig().withAdListener(new InterstitialAdListener() { // from class: com.facebook.ads.redexgen.X.21
                    @Override // com.facebook.ads.AdListener
                    public final void onAdClicked(com.facebook.ads.Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public final void onAdLoaded(com.facebook.ads.Ad ad) {
                        this.A01.A00.A09.onAdLoaded(this.A01.A00.A0A.A01());
                    }

                    @Override // com.facebook.ads.AdListener
                    public final void onError(com.facebook.ads.Ad ad, AdError adError) {
                        this.A01.A00.A01 = null;
                        abstractC1484aS.A16(false);
                        this.A01.A00.A09.onAdLoaded(this.A01.A00.A0A.A01());
                    }

                    @Override // com.facebook.ads.InterstitialAdListener
                    public final void onInterstitialDismissed(com.facebook.ads.Ad ad) {
                        this.A01.A00.A06 = false;
                        if (this.A01.A00.A03 != null) {
                            this.A01.A00.A03.A0O(new C1450Zu(this));
                            this.A01.A00.A03.A0J();
                            this.A01.A00.A03 = null;
                        }
                        this.A01.A00.A09.onInterstitialDismissed(this.A01.A00.A0A.A01());
                        this.A01.A00.A05.A05();
                    }

                    @Override // com.facebook.ads.InterstitialAdListener
                    public final void onInterstitialDisplayed(com.facebook.ads.Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public final void onLoggingImpression(com.facebook.ads.Ad ad) {
                    }
                }).withCacheFlags(this.A00.A0A.A0A()).withRewardData(this.A00.A0A.A03()).build();
                this.A00.A01.loadAd(loadAdConfig);
                return;
            }
            this.A00.A09.onAdLoaded(this.A00.A0A.A01());
            return;
        }
        this.A00.A08.A07().A9M(A00(0, 3, 124), C07597x.A0N, new C07607y(A00(3, 18, 0)));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05830p
    public final void A0G(JG jg) {
        this.A00.A08.A0E().A2i(LM.A01(this.A00.A00), jg.A03().getErrorCode(), jg.A04());
        this.A00.A09.onError(this.A00.A0A.A01(), C1053Kf.A00(jg));
    }
}
