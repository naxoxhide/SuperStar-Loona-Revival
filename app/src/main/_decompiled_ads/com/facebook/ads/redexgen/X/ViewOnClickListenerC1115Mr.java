package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1115Mr implements View.OnClickListener {
    public final /* synthetic */ C1120Mw A00;

    public ViewOnClickListenerC1115Mr(C1120Mw c1120Mw) {
        this.A00 = c1120Mw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            if (this.A00.A04 == null) {
                return;
            }
            this.A00.A04.AAr();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
