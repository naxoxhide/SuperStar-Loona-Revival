package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Th, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1287Th implements InterfaceC1089Lr {
    public static String[] A02 = {"9zQQ", "ignw1BD", "Iwiu", "Rj9759ruFeEHfZFHtC0tN77N", "Yw9WW67qBp7nurOongm62UMTZpj72Daq", "XdprQx2", "zMrI2nkZvee1EVY6Hu3DKwgaLEX6aHI5", "7LD9TnQa5MzlVBDCJJS9JW3wW2x"};
    public final /* synthetic */ C5J A00;
    public final /* synthetic */ AbstractC1283Td A01;

    public C1287Th(AbstractC1283Td abstractC1283Td, C5J c5j) {
        this.A01 = abstractC1283Td;
        this.A00 = c5j;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1089Lr
    public final void AAr() {
        this.A01.A0D.A04(EnumC1011Im.A07, null);
        if (this.A01.A0c()) {
            return;
        }
        if (this.A01.A0Z()) {
            this.A01.A0Y(this.A00);
            return;
        }
        C5J c5j = this.A00;
        if (A02[7].length() != 27) {
            throw new RuntimeException();
        }
        A02[4] = "TQLH18Rv5MEOVOxcIrRMtSKcbgUrlpIS";
        c5j.finish(1);
    }
}
