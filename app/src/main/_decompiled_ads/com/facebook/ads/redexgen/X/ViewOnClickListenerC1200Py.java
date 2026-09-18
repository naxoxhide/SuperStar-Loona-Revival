package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Py, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1200Py implements View.OnClickListener {
    public final /* synthetic */ C1040Jr A00;

    public ViewOnClickListenerC1200Py(C1040Jr c1040Jr) {
        this.A00 = c1040Jr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A03.A04(EnumC1011Im.A0d, null);
            this.A00.A02.A0E().A37();
            if (this.A00.A00 != null) {
                if (this.A00.A07()) {
                    this.A00.A00.setVolume(1.0f);
                } else {
                    this.A00.A00.setVolume(0.0f);
                }
                this.A00.A09();
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
