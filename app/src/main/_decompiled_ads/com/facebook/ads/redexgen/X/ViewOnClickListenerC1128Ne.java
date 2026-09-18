package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ne, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1128Ne implements View.OnClickListener {
    public final /* synthetic */ C1130Ng A00;

    public ViewOnClickListenerC1128Ne(C1130Ng c1130Ng) {
        this.A00 = c1130Ng;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A04();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
