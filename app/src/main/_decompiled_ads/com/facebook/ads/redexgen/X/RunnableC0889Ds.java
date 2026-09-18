package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ds, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0889Ds implements Runnable {
    public final /* synthetic */ RunnableC0892Dv A00;

    public RunnableC0889Ds(RunnableC0892Dv runnableC0892Dv) {
        this.A00 = runnableC0892Dv;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A0F(5, 3);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
