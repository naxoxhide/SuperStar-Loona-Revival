package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: loaded from: classes.dex */
class z extends d {
    private final AppLovinAdLoadListener aTB;
    private final com.applovin.impl.b.e aUS;

    z(com.applovin.impl.b.e eVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        super("TaskResolveVastWrapper", nVar);
        this.aTB = appLovinAdLoadListener;
        this.aUS = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA = com.applovin.impl.b.m.a(this.aUS);
        if (StringUtils.isValidString(strA)) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Resolving VAST ad with depth " + this.aUS.Mp() + " at " + strA);
            }
            try {
                this.sdk.BM().b(new w<com.applovin.impl.sdk.utils.y>(com.applovin.impl.sdk.network.c.D(this.sdk).da(strA).db("GET").ad(com.applovin.impl.sdk.utils.y.aWu).gC(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPs)).intValue()).gD(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPt)).intValue()).aS(false).Ie(), this.sdk) { // from class: com.applovin.impl.sdk.e.z.1
                    @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void d(com.applovin.impl.sdk.utils.y yVar, int i) {
                        this.sdk.BM().b(t.a(yVar, z.this.aUS, z.this.aTB, z.this.sdk));
                    }

                    @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
                    public void a(int i, String str, com.applovin.impl.sdk.utils.y yVar) {
                        com.applovin.impl.sdk.x xVar2 = this.logger;
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.i(this.tag, "Unable to resolve VAST wrapper. Server returned " + i);
                        }
                        z.this.gN(i);
                    }
                });
                return;
            } catch (Throwable th) {
                com.applovin.impl.sdk.x xVar2 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.c(this.tag, "Unable to resolve VAST wrapper", th);
                }
                gN(-1);
                return;
            }
        }
        com.applovin.impl.sdk.x xVar3 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Resolving VAST failed. Could not find resolution URL");
        }
        gN(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN(int i) {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Failed to resolve VAST wrapper due to error code " + i);
        }
        if (i == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.aTB;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
                return;
            }
            return;
        }
        com.applovin.impl.b.m.a(this.aUS, this.aTB, i == -1001 ? com.applovin.impl.b.f.TIMED_OUT : com.applovin.impl.b.f.GENERAL_WRAPPER_ERROR, i, this.sdk);
    }
}
