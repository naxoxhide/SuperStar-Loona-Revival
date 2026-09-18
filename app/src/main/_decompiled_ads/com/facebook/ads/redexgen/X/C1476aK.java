package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1476aK implements InterfaceC07105p {
    public static String[] A05 = {"SGxBKOT0PnlxeQ2jGccieZy3bFeI", "1PQaT", "uVEahNbfwTxCxKVGO7p", "rVPhbhRBlKfAg8fviAhE", "2ov", "KrP87Bn8e271VzBAE5Wi", "4No2VIB7eIWgh7ub8hExBeYUcY", "mEjh"};
    public final /* synthetic */ AbstractC1484aS A00;
    public final /* synthetic */ InterfaceC05981e A01;
    public final /* synthetic */ C05991f A02;
    public final /* synthetic */ YA A03;
    public final /* synthetic */ boolean A04;

    public C1476aK(C05991f c05991f, YA ya, boolean z, AbstractC1484aS abstractC1484aS, InterfaceC05981e interfaceC05981e) {
        this.A02 = c05991f;
        this.A03 = ya;
        this.A04 = z;
        this.A00 = abstractC1484aS;
        this.A01 = interfaceC05981e;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAW() {
        if (IP.A1P(this.A03) && this.A04) {
            this.A02.A02.add(C1158Oi.A01(this.A03, this.A00, 1, new C1477aL(this)));
            return;
        }
        InterfaceC05981e interfaceC05981e = this.A01;
        if (A05[2].length() != 19) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[5] = "X6BBoGIR5wPjpoFUlFYz";
        strArr[3] = "SlUPa0nBeexeGnx3tyWk";
        interfaceC05981e.AAQ();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC07105p
    public final void AAX() {
        this.A01.AAP(AdError.CACHE_ERROR);
    }
}
