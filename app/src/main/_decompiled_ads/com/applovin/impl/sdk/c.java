package com.applovin.impl.sdk;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final WeakReference<com.applovin.impl.sdk.ad.g> ayP;
    private final WeakReference<b.a> ayQ;
    private com.applovin.impl.sdk.utils.r ayR;
    private final n sdk;

    public static c a(com.applovin.impl.sdk.ad.g gVar, b.a aVar, n nVar) {
        c cVar = new c(gVar, aVar, nVar);
        cVar.bJ(gVar.getTimeToLiveMillis());
        return cVar;
    }

    private c(com.applovin.impl.sdk.ad.g gVar, b.a aVar, n nVar) {
        this.ayP = new WeakReference<>(gVar);
        this.ayQ = new WeakReference<>(aVar);
        this.sdk = nVar;
    }

    public com.applovin.impl.sdk.ad.g AB() {
        return this.ayP.get();
    }

    public void bJ(long j) {
        tT();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLX)).booleanValue() || !this.sdk.Cc().isApplicationPaused()) {
            this.ayR = com.applovin.impl.sdk.utils.r.b(j, this.sdk, new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$c$ZFCXXtmfur3AyZ0vtVSJjx8-ch4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.AD();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AD() {
        AC();
        this.sdk.BZ().a(this);
    }

    public void tT() {
        com.applovin.impl.sdk.utils.r rVar = this.ayR;
        if (rVar != null) {
            rVar.tT();
            this.ayR = null;
        }
    }

    public void AC() {
        tT();
        com.applovin.impl.sdk.ad.g gVarAB = AB();
        if (gVarAB == null) {
            return;
        }
        gVarAB.setExpired();
        b.a aVar = this.ayQ.get();
        if (aVar == null) {
            return;
        }
        aVar.onAdExpired(gVarAB);
    }
}
