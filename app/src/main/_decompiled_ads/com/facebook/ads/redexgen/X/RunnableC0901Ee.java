package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0901Ee implements Runnable {
    public final /* synthetic */ C0906Ej A00;
    public final /* synthetic */ C0907Ek A01;
    public final /* synthetic */ C0908El A02;
    public final /* synthetic */ InterfaceC0909Em A03;
    public final /* synthetic */ IOException A04;
    public final /* synthetic */ boolean A05;

    public RunnableC0901Ee(C0906Ej c0906Ej, InterfaceC0909Em interfaceC0909Em, C0907Ek c0907Ek, C0908El c0908El, IOException iOException, boolean z) {
        this.A00 = c0906Ej;
        this.A03 = interfaceC0909Em;
        this.A01 = c0907Ek;
        this.A02 = c0908El;
        this.A04 = iOException;
        this.A05 = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A03.ABt(this.A00.A00, this.A00.A01, this.A01, this.A02, this.A04, this.A05);
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
