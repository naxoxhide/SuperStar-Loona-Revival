package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ms, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1116Ms implements View.OnClickListener {
    public final /* synthetic */ C1120Mw A00;

    public ViewOnClickListenerC1116Ms(C1120Mw c1120Mw) {
        this.A00 = c1120Mw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A08.canGoBack()) {
                return;
            }
            this.A00.A08.goBack();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
