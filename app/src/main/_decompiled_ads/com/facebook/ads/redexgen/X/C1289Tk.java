package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1289Tk extends AbstractC06774h {
    public static String[] A01 = {"8Yn2PgyedH1iX", "R67HljoZMbsPm0e6EtybvG", "", "R8Pp2uuVTku92bGxcvFWCvwfHASfPd1y", "2y5E80sPhAjkTDK", "Itturke", "abRBLy2wdT4xlnoMDCf2vtSzdY3x1mV2", "QG421Xj1ReSIzqeVHucrcoJTP843GzsJ"};
    public final /* synthetic */ C2O A00;

    public C1289Tk(C2O c2o) {
        this.A00 = c2o;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06774h
    public final void A0L(ED ed, int i) {
        int scrollPosition;
        super.A0L(ed, i);
        ZC linearLayoutManager = this.A00.getLayoutManager();
        if (linearLayoutManager == null || (scrollPosition = linearLayoutManager.A27()) < 0 || this.A00.getAdapter() == null || scrollPosition >= this.A00.getAdapter().A0D()) {
            return;
        }
        InterfaceC1094Lw interfaceC1094Lw = (InterfaceC1094Lw) ed.A1F(scrollPosition);
        if (A01[1].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "EBOsosi";
        strArr[2] = "";
        if (interfaceC1094Lw == null) {
            return;
        }
        interfaceC1094Lw.AF7();
    }
}
