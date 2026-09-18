package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1545bY implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1544bX A01;

    public RunnableC1545bY(C1544bX c1544bX, int i) {
        this.A01 = c1544bX;
        this.A00 = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            if (this.A01.A01) {
                C1544bX c1544bX = this.A01;
                c1544bX.A04(c1544bX.A05.AAE());
                this.A01.A04.postDelayed(this.A01.A09, this.A00);
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
