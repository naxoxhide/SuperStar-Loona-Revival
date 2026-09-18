package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1106Mi implements View.OnClickListener {
    public final /* synthetic */ C2K A00;
    public final /* synthetic */ MV A01;
    public final /* synthetic */ C1107Mj A02;

    public ViewOnClickListenerC1106Mi(C1107Mj c1107Mj, MV mv, C2K c2k) {
        this.A02 = c1107Mj;
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
            this.A02.A02.ACF(this.A00);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
