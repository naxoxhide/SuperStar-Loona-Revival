package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1127Nd implements View.OnClickListener {
    public final /* synthetic */ C1130Ng A00;

    public ViewOnClickListenerC1127Nd(C1130Ng c1130Ng) {
        this.A00 = c1130Ng;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A04.ABz();
            if (this.A00.A00 != null) {
                LV.A0L(this.A00.A00);
            }
            for (View view2 : this.A00.A06) {
                LV.A0N(view2, 0);
            }
            LV.A0J(this.A00);
            if (this.A00.A05 == null) {
                return;
            }
            LV.A0N(this.A00.A05, 0);
            this.A00.A05.A0b(EnumC1185Pj.A02, 14);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
