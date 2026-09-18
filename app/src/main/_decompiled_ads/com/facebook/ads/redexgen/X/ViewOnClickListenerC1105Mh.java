package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1105Mh implements View.OnClickListener {
    public final /* synthetic */ C1107Mj A00;

    public ViewOnClickListenerC1105Mh(C1107Mj c1107Mj) {
        this.A00 = c1107Mj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A02.A8F();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
