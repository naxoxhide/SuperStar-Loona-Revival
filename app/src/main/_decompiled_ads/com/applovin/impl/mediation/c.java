package com.applovin.impl.mediation;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final a akU;
    private com.applovin.impl.sdk.utils.f akV;
    private final x logger;
    private final n sdk;

    public interface a {
        void c(com.applovin.impl.mediation.b.c cVar);
    }

    c(n nVar, a aVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.akU = aVar;
    }

    public void a(final com.applovin.impl.mediation.b.c cVar, long j) {
        if (x.Fk()) {
            this.logger.f("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        }
        this.akV = com.applovin.impl.sdk.utils.f.a(j, this.sdk, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$c$pkHxsR-wFEn6Zh1lJ8-fnzHaZN0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(com.applovin.impl.mediation.b.c cVar) {
        if (x.Fk()) {
            this.logger.f("AdHiddenCallbackTimeoutManager", "Timing out...");
        }
        this.akU.c(cVar);
    }

    public void tT() {
        if (x.Fk()) {
            this.logger.f("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        com.applovin.impl.sdk.utils.f fVar = this.akV;
        if (fVar != null) {
            fVar.tT();
            this.akV = null;
        }
    }
}
