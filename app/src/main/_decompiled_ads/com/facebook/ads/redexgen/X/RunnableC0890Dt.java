package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0890Dt implements Runnable {
    public final /* synthetic */ RunnableC0892Dv A00;
    public final /* synthetic */ Throwable A01;

    public RunnableC0890Dt(RunnableC0892Dv runnableC0892Dv, Throwable th) {
        this.A00 = runnableC0892Dv;
        this.A01 = th;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            RunnableC0892Dv runnableC0892Dv = this.A00;
            Throwable th = this.A01;
            if (!runnableC0892Dv.A0G(1, th != null ? 4 : 2, th) && !this.A00.A0F(6, 3) && !this.A00.A0F(7, 0)) {
                throw new IllegalStateException();
            }
        } catch (Throwable th2) {
            K0.A00(th2, this);
        }
    }
}
