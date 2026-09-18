package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0904Eh implements Runnable {
    public final /* synthetic */ C0906Ej A00;
    public final /* synthetic */ C0908El A01;
    public final /* synthetic */ InterfaceC0909Em A02;

    public RunnableC0904Eh(C0906Ej c0906Ej, InterfaceC0909Em interfaceC0909Em, C0908El c0908El) {
        this.A00 = c0906Ej;
        this.A02 = interfaceC0909Em;
        this.A01 = c0908El;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A02.AB8(this.A00.A00, this.A00.A01, this.A01);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
