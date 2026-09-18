package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1277Sx extends AbstractC1145Nv {
    public C1277Sx(C1149Nz c1149Nz, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        super(c1149Nz, true);
        RelativeLayout relativeLayout = new RelativeLayout(c1149Nz.A05());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        LV.A0R(relativeLayout, getAdContextWrapper());
        LinearLayout linearLayout = new LinearLayout(c1149Nz.A05());
        linearLayout.setOrientation(!z ? 1 : 0);
        linearLayout.setGravity(80);
        LV.A0K(linearLayout);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(AbstractC1145Nv.A07, 0, AbstractC1145Nv.A07, AbstractC1145Nv.A07);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z ? -2 : -1, -2);
        layoutParams4.setMargins(z ? AbstractC1145Nv.A07 : 0, z ? 0 : AbstractC1145Nv.A07, 0, 0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(z ? 0 : -1, -2);
        layoutParams5.setMargins(0, 0, 0, 0);
        layoutParams5.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams5);
        if (c1149Nz.A0C() && !z) {
            PB pb = new PB(c1149Nz.A05());
            pb.setPageDetails(c1149Nz.A04().A0z());
            int iA04 = this.A06.A04().A0u().A00().A04(true);
            pb.A02(iA04, iA04);
            LV.A0G(PointerIconCompat.TYPE_CROSSHAIR, pb);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams6.setMargins(0, AbstractC1145Nv.A07, 0, 0);
            linearLayout.addView(pb, layoutParams6);
            if (IP.A10(c1149Nz.A05())) {
                pb.setOnClickListener(getCtaButton());
            }
        }
        linearLayout.addView(getCtaButton(), layoutParams4);
        relativeLayout.addView(linearLayout, layoutParams3);
        getCtaButton().A0A(c1149Nz.A04(), c1149Nz.A08());
        View viewA02 = c1149Nz.A02();
        if (viewA02 != null && IP.A17(getAdContextWrapper())) {
            if (z) {
                layoutParams = new FrameLayout.LayoutParams(-2, -1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -2);
            }
            layoutParams.gravity = 17;
            FrameLayout frameLayout = new FrameLayout(c1149Nz.A05());
            frameLayout.addView(viewA02, layoutParams);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            NO.A00(viewA02, IP.A18(getAdContextWrapper()), new ViewOnClickListenerC1144Nu(this));
        } else if (viewA02 != null) {
            addView(viewA02, new RelativeLayout.LayoutParams(-1, -1));
        }
        addView(relativeLayout, layoutParams2);
        if (IP.A0z(c1149Nz.A05())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (c1149Nz.A08() != null) {
                c1149Nz.A08().setCTAClickListener(getCtaButton());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final void A0z(C1D c1d, String str, double d, Bundle bundle) {
        super.A0z(c1d, str, d, bundle);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final boolean A10() {
        return true;
    }
}
