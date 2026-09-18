package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ea, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0897Ea implements Runnable {
    public final /* synthetic */ C0906Ej A00;
    public final /* synthetic */ InterfaceC0909Em A01;

    public RunnableC0897Ea(C0906Ej c0906Ej, InterfaceC0909Em interfaceC0909Em) {
        this.A00 = c0906Ej;
        this.A01 = interfaceC0909Em;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A01.AC5(this.A00.A00, this.A00.A01);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
