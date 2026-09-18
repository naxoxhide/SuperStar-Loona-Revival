package com.facebook.ads.redexgen.X;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GI implements InterfaceC1210Qi {
    public final /* synthetic */ C06593p A00;
    public final /* synthetic */ CountDownLatch A01;
    public final /* synthetic */ AtomicReference A02;
    public final /* synthetic */ AtomicReference A03;

    public GI(C06593p c06593p, AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.A00 = c06593p;
        this.A03 = atomicReference;
        this.A02 = atomicReference2;
        this.A01 = countDownLatch;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1210Qi
    public final void AAu(InterfaceC1208Qg interfaceC1208Qg) {
        C06593p.A06(interfaceC1208Qg.A64(), this.A03, this.A02);
        this.A01.countDown();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1210Qi
    public final void ABI(Exception exc) {
        this.A02.set(exc);
        this.A01.countDown();
    }
}
