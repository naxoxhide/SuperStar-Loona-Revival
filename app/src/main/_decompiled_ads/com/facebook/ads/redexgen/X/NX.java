package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NX {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.29] */
    public static AnonymousClass29 A00(final C1149Nz c1149Nz, final UJ uj, final String str, final C07969j c07969j) {
        final boolean z = true;
        return new C9G(c1149Nz, uj, z, str, c07969j) { // from class: com.facebook.ads.redexgen.X.29
            public T3 A00;
            public PC A01;
            public final InterfaceC1004If A02 = this.A0I.A05().A01().A09();
            public final UJ A03;
            public final C07969j A04;
            public final String A05;
            public static final int A07 = (int) (C1066Ku.A02 * (-4.0f));
            public static final int A06 = (int) (C1066Ku.A02 * 6.0f);

            {
                this.A03 = uj;
                this.A05 = str;
                this.A04 = c07969j;
                uj.A1K(this);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1264Sk
            public void setupNativeCtaExtension(PC pc) {
                C1R c1rA0x;
                this.A01 = pc;
                int iA0M = IP.A0M(this.A0I.A05());
                C1M c1mA01 = this.A03.A0z().A0u().A01();
                YA yaA05 = this.A0I.A05();
                String strA0K = this.A03.A0z().A0K();
                InterfaceC1004If interfaceC1004If = this.A02;
                InterfaceC1091Lt dummyListener = N9.getDummyListener();
                C1203Qb c1203QbA0c = this.A04.A0c();
                LN lnA19 = this.A03.A19();
                if (this.A03.A0z() == null) {
                    c1rA0x = null;
                } else {
                    c1rA0x = this.A03.A0z().A0x();
                }
                T3 t3 = new T3(yaA05, strA0K, c1mA01, interfaceC1004If, dummyListener, c1203QbA0c, lnA19, c1rA0x);
                this.A00 = t3;
                t3.setCta(pc.A03().A0F(), this.A05, new HashMap());
                this.A03.A1K(this.A00);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (iA0M == 1) {
                    layoutParams.addRule(12);
                    LV.A0P(this.A00, A06, 5, c1mA01.A09(false));
                    ((C9G) this).A06.addView(this.A00, layoutParams);
                } else {
                    if (iA0M != 2) {
                        return;
                    }
                    layoutParams.addRule(3, ((C9G) this).A06.getId());
                    int extensionVariant = A07;
                    layoutParams.setMargins(0, extensionVariant, 0, 0);
                    addView(this.A00, 0, layoutParams);
                    ((C9G) this).A06.bringToFront();
                }
            }
        };
    }

    public static C9G A01(C1149Nz c1149Nz, String str, S0 s0) {
        return new C9G(c1149Nz, true, str, s0);
    }
}
