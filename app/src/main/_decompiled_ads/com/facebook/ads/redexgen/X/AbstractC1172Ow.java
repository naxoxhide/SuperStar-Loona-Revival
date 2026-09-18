package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ow, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1172Ow extends RelativeLayout {
    public boolean A00;
    public final int A01;
    public final AbstractC1202Qa A02;
    public final boolean A03;
    public final boolean A04;
    public final AbstractC1484aS A05;
    public final YA A06;
    public final InterfaceC1004If A07;
    public final LN A08;
    public final InterfaceC1091Lt A09;
    public final MM A0A;
    public final C1203Qb A0B;

    public abstract void A0K();

    public abstract void A0L();

    public abstract void A0M();

    public abstract void A0N(boolean z);

    public abstract void A0O(boolean z);

    public abstract boolean A0P();

    public abstract boolean A0Q();

    public abstract C1175Oz getFullScreenAdStyle();

    public AbstractC1172Ow(YA ya, MM mm, InterfaceC1004If interfaceC1004If, AbstractC1484aS abstractC1484aS, int i, boolean z, boolean z2, InterfaceC1091Lt interfaceC1091Lt) {
        super(ya);
        this.A08 = new LN();
        this.A00 = false;
        ST st = new ST(this);
        this.A02 = st;
        this.A01 = i;
        this.A06 = ya;
        this.A04 = z;
        this.A03 = z2;
        this.A09 = interfaceC1091Lt;
        this.A0A = mm;
        this.A05 = abstractC1484aS;
        this.A07 = interfaceC1004If;
        C1203Qb c1203Qb = new C1203Qb(this, 1, new WeakReference(st), ya);
        this.A0B = c1203Qb;
        c1203Qb.A0W(abstractC1484aS.A0C());
        c1203Qb.A0X(abstractC1484aS.A0D());
    }

    public final void A03() {
        if (!this.A00) {
            this.A0B.A0U();
            this.A00 = true;
        }
    }

    public AbstractC1484aS getAdDataBundle() {
        return this.A05;
    }

    public C1203Qb getAdViewabilityChecker() {
        return this.A0B;
    }

    public LN getTouchDataRecorder() {
        return this.A08;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
