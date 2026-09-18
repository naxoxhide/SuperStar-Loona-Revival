package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1103Mf implements View.OnClickListener {
    public final /* synthetic */ C2K A00;
    public final /* synthetic */ MV A01;
    public final /* synthetic */ TN A02;

    public ViewOnClickListenerC1103Mf(TN tn, MV mv, C2K c2k) {
        this.A02 = tn;
        this.A01 = mv;
        this.A00 = c2k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0B.ACF(this.A00);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
