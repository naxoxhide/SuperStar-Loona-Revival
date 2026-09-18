package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1098Ma implements View.OnClickListener {
    public final /* synthetic */ TN A00;

    public ViewOnClickListenerC1098Ma(TN tn) {
        this.A00 = tn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.A8F();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
