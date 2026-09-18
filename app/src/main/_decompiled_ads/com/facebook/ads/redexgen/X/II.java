package com.facebook.ads.redexgen.X;

import android.view.Surface;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class II implements Runnable {
    public final /* synthetic */ Surface A00;
    public final /* synthetic */ IK A01;

    public II(IK ik, Surface surface) {
        this.A01 = ik;
        this.A00 = surface;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A01.A01.ACi(this.A00);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
