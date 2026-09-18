package com.applovin.impl.sdk;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private static boolean aFd;

    public static void w(final n nVar) {
        Long l = (Long) nVar.a(com.applovin.impl.sdk.c.a.aKa);
        if (l.longValue() <= 0) {
            return;
        }
        nVar.BM().a(new com.applovin.impl.sdk.e.ab(nVar, true, "submitIntegrationErrorReport", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$v$g4CATfy7Nca3b49giOGiX4nsEuE
            @Override // java.lang.Runnable
            public final void run() {
                v.x(nVar);
            }
        }), com.applovin.impl.sdk.e.q.b.MAIN, TimeUnit.SECONDS.toMillis(l.longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(n nVar) {
        if (aFd) {
            return;
        }
        nVar.Cq().a(r.a.INTEGRATION_ERROR, "no_ads_loaded", (String) null);
    }

    public static void Fd() {
        aFd = true;
    }
}
