package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8B extends SH {
    public AbstractC1145Nv A00;
    public final ImageView A01;
    public final C5H A02;
    public final AtomicBoolean A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;

    public C8B(YA ya, MM mm, InterfaceC1004If interfaceC1004If, AbstractC1484aS abstractC1484aS, C6Q c6q, InterfaceC1091Lt interfaceC1091Lt) {
        super(ya, mm, interfaceC1004If, abstractC1484aS, c6q, interfaceC1091Lt);
        this.A02 = new SC(this);
        this.A04 = new AtomicBoolean(false);
        this.A03 = new AtomicBoolean(false);
        this.A05 = new AtomicBoolean(false);
        ImageView imageView = new ImageView(getContext());
        this.A01 = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new T8(imageView, super.A03).A05(super.A01.A0v().A0D().A00(), super.A01.A0v().A0D().A01()).A06(new SB(this)).A07(super.A01.A0v().A0D().A07());
    }

    private AbstractC1145Nv A01(int i) {
        if (this.A01.getParent() != null) {
            LV.A0J(this.A01);
        }
        return C1146Nw.A00(new C1148Ny(super.A03, super.A04, this.A08, super.A01, this.A01, this.A0A, this.A06).A0E(this.A07.getToolbarHeight()).A0H(this.A07).A0D(i).A0K(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A04.get() && this.A03.get()) {
            A0P();
        }
    }

    private void A06(int i) {
        LV.A0J(this.A00);
        AbstractC1145Nv abstractC1145NvA01 = A01(i);
        this.A00 = abstractC1145NvA01;
        C1M colors = abstractC1145NvA01.getColors();
        AbstractC1145Nv abstractC1145Nv = this.A00;
        LV.A0M(this, colors.A07(abstractC1145Nv != null && (abstractC1145Nv.A10() || (this.A00 instanceof AbstractC1278Sy))));
        this.A07.setFullscreen(this.A00.A10());
        this.A07.A06(colors, T3.A08(super.A01));
        addView(this.A00, 0, SH.A0E);
        AbstractC1145Nv abstractC1145Nv2 = this.A00;
        setUpFullscreenMode(abstractC1145Nv2 != null && abstractC1145Nv2.A10());
    }

    @Override // com.facebook.ads.redexgen.X.SH
    public final void A0Q() {
        LV.A0L(this.A00);
        LV.A0L(this.A07);
        this.A03.set(true);
        A05();
        int iA03 = super.A01.A0v().A0D().A03();
        if (iA03 > 0) {
            AbstractC1145Nv abstractC1145Nv = this.A00;
            if (abstractC1145Nv != null) {
                abstractC1145Nv.A0y();
            }
            A0R(iA03, new SA(this));
            return;
        }
        this.A05.set(true);
        AbstractC1090Ls abstractC1090Ls = this.A07;
        int unskippableSeconds = getCloseButtonStyle();
        abstractC1090Ls.setToolbarActionMode(unskippableSeconds);
    }

    @Override // com.facebook.ads.redexgen.X.SH
    public final void A0S(C5J c5j) {
        c5j.A0N(this.A02);
        int orientation = c5j.A0J().getResources().getConfiguration().orientation;
        A06(orientation);
        addView(this.A07, new FrameLayout.LayoutParams(-1, this.A07.getToolbarHeight()));
        LV.A0H(this.A00);
        LV.A0H(this.A07);
    }

    @Override // com.facebook.ads.redexgen.X.SH
    public final boolean A0T() {
        AbstractC1145Nv abstractC1145Nv = this.A00;
        return abstractC1145Nv != null && abstractC1145Nv.A11(false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void ACJ(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void ACj(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        AbstractC1145Nv abstractC1145Nv = this.A00;
        if (abstractC1145Nv != null) {
            return abstractC1145Nv.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.SH, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A01.A0v().A0N()) {
            A06(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.X.SH, com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void onDestroy() {
        if (IP.A1X(super.A03)) {
            super.A03.A0A().AFz(this.A01);
        }
        AbstractC1145Nv abstractC1145Nv = this.A00;
        if (abstractC1145Nv != null) {
            abstractC1145Nv.A0u();
        }
        super.onDestroy();
    }
}
