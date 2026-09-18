package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1145Nv extends RelativeLayout {
    public static final int A07 = (int) (C1066Ku.A02 * 16.0f);
    public static final int A08 = (int) (C1066Ku.A02 * 28.0f);
    public C1M A00;
    public boolean A01;
    public final YA A02;
    public final InterfaceC1004If A03;
    public final T3 A04;
    public final C1138No A05;
    public final C1149Nz A06;

    public abstract boolean A10();

    public AbstractC1145Nv(C1149Nz c1149Nz, boolean z) {
        C1M c1mA00;
        super(c1149Nz.A05());
        this.A06 = c1149Nz;
        YA yaA05 = c1149Nz.A05();
        this.A02 = yaA05;
        this.A03 = c1149Nz.A06();
        if (c1149Nz.A00() == 1) {
            c1mA00 = c1149Nz.A04().A0u().A01();
        } else {
            c1mA00 = c1149Nz.A04().A0u().A00();
        }
        this.A00 = c1mA00;
        this.A01 = z;
        T3 t3 = new T3(c1149Nz.A05(), c1149Nz.A04().A0K(), this.A00, c1149Nz.A04().A0v().A0F().A06(), c1149Nz.A06(), c1149Nz.A09(), c1149Nz.A0B(), c1149Nz.A07(), c1149Nz.A04().A0x());
        this.A04 = t3;
        t3.setRoundedCornersEnabled(A00());
        t3.setViewShowsOverMedia(A0D());
        LV.A0G(1001, t3);
        C1138No c1138No = new C1138No(yaA05, this.A00, this.A01, A01(), A02());
        this.A05 = c1138No;
        LV.A0K(c1138No);
    }

    public boolean A00() {
        return true;
    }

    public boolean A01() {
        return true;
    }

    public boolean A02() {
        return true;
    }

    public void A0B(AnonymousClass75 anonymousClass75) {
    }

    public void A0C(AnonymousClass71 anonymousClass71) {
    }

    public boolean A0D() {
        return true;
    }

    public void A0u() {
    }

    public void A0v() {
    }

    public void A0w() {
    }

    public void A0x() {
    }

    public void A0y() {
    }

    public void A0z(C1D c1d, String str, double d, Bundle bundle) {
        this.A05.A03(c1d.A0E().A05(), c1d.A0E().A01(), null, false, !A10() && d > 0.0d && d < 1.0d);
        this.A04.setCta(c1d.A0F(), str, new HashMap());
    }

    public boolean A11(boolean z) {
        return false;
    }

    public YA getAdContextWrapper() {
        return this.A02;
    }

    public InterfaceC1004If getAdEventManager() {
        return this.A03;
    }

    public int getCloseButtonStyle() {
        return 0;
    }

    public C1M getColors() {
        return this.A00;
    }

    public T3 getCtaButton() {
        return this.A04;
    }

    public C1138No getTitleDescContainer() {
        return this.A05;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C1M c1mA00;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            c1mA00 = this.A06.A04().A0u().A01();
        } else {
            c1mA00 = this.A06.A04().A0u().A00();
        }
        this.A00 = c1mA00;
        this.A04.setViewShowsOverMedia(A0D());
        this.A04.setUpButtonColors(this.A00);
        this.A05.A02(this.A00, this.A01);
    }
}
