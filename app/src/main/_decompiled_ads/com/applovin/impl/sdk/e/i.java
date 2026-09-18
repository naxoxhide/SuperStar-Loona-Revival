package com.applovin.impl.sdk.e;

/* JADX INFO: loaded from: classes.dex */
public class i extends d {
    private a aTT;

    public interface a {
        void b(com.applovin.impl.sdk.utils.d.a aVar);
    }

    public i(com.applovin.impl.sdk.n nVar, a aVar) {
        super("TaskCollectAdvertisingId", nVar, true);
        this.aTT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aTT.b(this.sdk.BQ().Df());
    }
}
