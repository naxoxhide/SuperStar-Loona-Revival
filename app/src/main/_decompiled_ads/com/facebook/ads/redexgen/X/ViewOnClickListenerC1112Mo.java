package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1112Mo implements View.OnClickListener {
    public final /* synthetic */ TM A00;

    public ViewOnClickListenerC1112Mo(TM tm) {
        this.A00 = tm;
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
