package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MF implements View.OnClickListener {
    public final /* synthetic */ TS A00;

    public MF(TS ts) {
        this.A00 = ts;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A07.ABN();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
