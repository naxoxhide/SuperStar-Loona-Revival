package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0898Eb implements Runnable {
    public final /* synthetic */ C0906Ej A00;
    public final /* synthetic */ C0907Ek A01;
    public final /* synthetic */ C0908El A02;
    public final /* synthetic */ InterfaceC0909Em A03;

    public RunnableC0898Eb(C0906Ej c0906Ej, InterfaceC0909Em interfaceC0909Em, C0907Ek c0907Ek, C0908El c0908El) {
        this.A00 = c0906Ej;
        this.A03 = interfaceC0909Em;
        this.A01 = c0907Ek;
        this.A02 = c0908El;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A03.ABv(this.A00.A00, this.A00.A01, this.A01, this.A02);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
