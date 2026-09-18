package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1535bO {
    public final C1546bZ A00;
    public final C1544bX A01;

    public C1535bO(AbstractC1551be abstractC1551be, C1544bX c1544bX, C1546bZ c1546bZ) {
        this.A00 = c1546bZ;
        this.A01 = c1544bX;
        abstractC1551be.A02(new C0923Fa(c1544bX));
    }

    public static C1535bO A00(AbstractC1551be abstractC1551be, InterfaceC1555bi interfaceC1555bi, InterfaceC0945Fw interfaceC0945Fw) {
        C1546bZ c1546bZ = new C1546bZ();
        C1544bX viewpointScanner = new C1544bX(interfaceC1555bi, new G2(), interfaceC0945Fw, c1546bZ, new Handler(Looper.getMainLooper()));
        return new C1535bO(abstractC1551be, viewpointScanner, c1546bZ);
    }

    public final void A01(View view) {
        this.A00.A01(view);
    }

    public final void A02(View view, C1553bg c1553bg) {
        this.A00.A02(view, c1553bg);
    }

    public final void A03(InterfaceC1550bd interfaceC1550bd) {
        this.A01.A09(interfaceC1550bd);
    }

    public final void A04(InterfaceC1548bb interfaceC1548bb) {
        this.A01.A0A(interfaceC1548bb);
    }
}
