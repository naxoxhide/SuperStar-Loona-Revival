package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Su, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1274Su extends AbstractC1145Nv {
    public static final int A02 = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final OJ A00;
    public final PB A01;

    public C1274Su(C1149Nz c1149Nz, boolean z) {
        int id;
        int iA01;
        super(c1149Nz, z);
        OJ oj = new OJ(c1149Nz.A05(), c1149Nz.A02());
        this.A00 = oj;
        oj.A01(getTitleDescContainer(), z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC1145Nv.A07, AbstractC1145Nv.A07, AbstractC1145Nv.A07, AbstractC1145Nv.A07);
        getCtaButton().setLayoutParams(layoutParams);
        if (c1149Nz.A0C()) {
            PB pb = new PB(c1149Nz.A05());
            this.A01 = pb;
            pb.setPageDetails(c1149Nz.A04().A0z());
            LV.A0G(PointerIconCompat.TYPE_CROSSHAIR, pb);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(2, getCtaButton().getId());
            layoutParams2.setMargins(AbstractC1145Nv.A07, AbstractC1145Nv.A07 - (AbstractC1145Nv.A07 / 2), AbstractC1145Nv.A07, 0);
            pb.setLayoutParams(layoutParams2);
            id = pb.getId();
            iA01 = c1149Nz.A01() - (AbstractC1145Nv.A07 / 2);
        } else {
            id = getCtaButton().getId();
            iA01 = c1149Nz.A01();
            this.A01 = null;
        }
        FrameLayout frameLayout = new FrameLayout(c1149Nz.A05());
        RelativeLayout.LayoutParams ctaButtonParams = new RelativeLayout.LayoutParams(-1, -1);
        ctaButtonParams.addRule(10);
        ctaButtonParams.addRule(2, id);
        ctaButtonParams.setMargins(0, iA01, 0, 0);
        frameLayout.setLayoutParams(ctaButtonParams);
        FrameLayout.LayoutParams mediaViewContainerParams = new FrameLayout.LayoutParams(-1, -2);
        mediaViewContainerParams.gravity = 17;
        mediaViewContainerParams.setMargins(AbstractC1145Nv.A07, 0, AbstractC1145Nv.A07, 0);
        frameLayout.addView(oj, mediaViewContainerParams);
        addView(frameLayout);
        View view = this.A01;
        if (view != null) {
            addView(view);
        }
        addView(getCtaButton());
        getCtaButton().A0A(c1149Nz.A04(), c1149Nz.A08());
        View viewA02 = c1149Nz.A02();
        if (viewA02 != null && IP.A17(getAdContextWrapper())) {
            NO.A00(viewA02, IP.A18(getAdContextWrapper()), new O3(this));
        }
        if (IP.A0z(c1149Nz.A05())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            View mMediaView = c1149Nz.A08();
            if (mMediaView != null) {
                c1149Nz.A08().setCTAClickListener(getCtaButton());
            }
        }
        View mMediaView2 = this.A01;
        if (mMediaView2 != null && IP.A10(c1149Nz.A05())) {
            this.A01.setOnClickListener(getCtaButton());
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final boolean A02() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final boolean A0D() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final void A0z(C1D c1d, String str, double d, Bundle bundle) {
        super.A0z(c1d, str, d, bundle);
        if (d > 0.0d) {
            int mediaHeight = (int) (((double) (A02 - (AbstractC1145Nv.A07 * 2))) / d);
            this.A00.A00(mediaHeight);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final boolean A10() {
        return false;
    }
}
