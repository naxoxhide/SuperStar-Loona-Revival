package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1117Mt implements View.OnClickListener {
    public final /* synthetic */ C1120Mw A00;

    public ViewOnClickListenerC1117Mt(C1120Mw c1120Mw) {
        this.A00 = c1120Mw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A08.canGoForward()) {
                return;
            }
            this.A00.A08.goForward();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
