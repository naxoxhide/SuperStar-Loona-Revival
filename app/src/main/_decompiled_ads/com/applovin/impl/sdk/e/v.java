package com.applovin.impl.sdk.e;

import com.adxcorp.util.ADXLogUtil;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
class v extends d {
    private final AppLovinAdLoadListener aTB;
    private final com.applovin.impl.b.e aUS;

    v(com.applovin.impl.b.e eVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        super("TaskRenderVastAd", nVar);
        this.aTB = appLovinAdLoadListener;
        this.aUS = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Rendering VAST ad...");
        }
        int size = this.aUS.Mq().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String strA = "";
        com.applovin.impl.b.j jVarA = null;
        com.applovin.impl.b.n nVarA = null;
        com.applovin.impl.b.d dVarA = null;
        com.applovin.impl.b.c cVarA = null;
        String strA2 = "";
        for (com.applovin.impl.sdk.utils.y yVar : this.aUS.Mq()) {
            com.applovin.impl.sdk.utils.y yVarDP = yVar.dP(com.applovin.impl.b.m.d(yVar) ? "Wrapper" : "InLine");
            if (yVarDP != null) {
                com.applovin.impl.sdk.utils.y yVarDP2 = yVarDP.dP("AdSystem");
                if (yVarDP2 != null) {
                    jVarA = com.applovin.impl.b.j.a(yVarDP2, jVarA, this.sdk);
                }
                strA = com.applovin.impl.b.m.a(yVarDP, "AdTitle", strA);
                strA2 = com.applovin.impl.b.m.a(yVarDP, "Description", strA2);
                com.applovin.impl.b.m.a(yVarDP.dN(ADXLogUtil.EVENT_IMPRESSION), hashSet, this.aUS, this.sdk);
                com.applovin.impl.sdk.utils.y yVarDO = yVarDP.dO("ViewableImpression");
                if (yVarDO != null) {
                    com.applovin.impl.b.m.a(yVarDO.dN("Viewable"), hashSet, this.aUS, this.sdk);
                }
                com.applovin.impl.sdk.utils.y yVarDP3 = yVarDP.dP("AdVerifications");
                if (yVarDP3 != null) {
                    cVarA = com.applovin.impl.b.c.a(yVarDP3, cVarA, this.aUS, this.sdk);
                }
                com.applovin.impl.b.m.a(yVarDP.dN("Error"), hashSet2, this.aUS, this.sdk);
                com.applovin.impl.sdk.utils.y yVarDO2 = yVarDP.dO("Creatives");
                if (yVarDO2 != null) {
                    for (com.applovin.impl.sdk.utils.y yVar2 : yVarDO2.LJ()) {
                        com.applovin.impl.sdk.utils.y yVarDO3 = yVar2.dO("Linear");
                        if (yVarDO3 != null) {
                            nVarA = com.applovin.impl.b.n.a(yVarDO3, nVarA, this.aUS, this.sdk);
                        } else {
                            com.applovin.impl.sdk.utils.y yVarDP4 = yVar2.dP("CompanionAds");
                            if (yVarDP4 != null) {
                                com.applovin.impl.sdk.utils.y yVarDP5 = yVarDP4.dP("Companion");
                                if (yVarDP5 != null) {
                                    dVarA = com.applovin.impl.b.d.a(yVarDP5, dVarA, this.aUS, this.sdk);
                                }
                            } else {
                                com.applovin.impl.sdk.x xVar2 = this.logger;
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.logger.i(this.tag, "Received and will skip rendering for an unidentified creative: " + yVar2);
                                }
                            }
                        }
                    }
                }
            } else {
                com.applovin.impl.sdk.x xVar3 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i(this.tag, "Did not find wrapper or inline response for node: " + yVar);
                }
            }
        }
        com.applovin.impl.b.a aVarMg = new com.applovin.impl.b.a.C0114a().R(this.sdk).V(this.aUS.Mr()).W(this.aUS.FP()).a(this.aUS.getSource()).cc(this.aUS.getCreatedAtMillis()).dT(strA).dU(strA2).a(jVarA).a(nVarA).a(dVarA).a(cVarA).b(hashSet).a(cVarA).c(hashSet2).Mg();
        com.applovin.impl.b.f fVarA = com.applovin.impl.b.m.a(aVarMg);
        if (fVarA == null) {
            com.applovin.impl.sdk.x xVar4 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Finished rendering VAST ad: " + aVarMg);
            }
            aVarMg.getAdEventTracker().IH();
            h hVar = new h(aVarMg, this.sdk, this.aTB);
            q.b bVar = q.b.CACHING_OTHER;
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLC)).booleanValue()) {
                if (aVarMg.getType() == AppLovinAdType.REGULAR) {
                    bVar = q.b.CACHING_INTERSTITIAL;
                } else if (aVarMg.getType() == AppLovinAdType.INCENTIVIZED) {
                    bVar = q.b.CACHING_INCENTIVIZED;
                } else if (aVarMg.getType() == AppLovinAdType.NATIVE) {
                    bVar = q.b.CACHING_NATIVE;
                }
            }
            this.sdk.BM().a(hVar, bVar);
            return;
        }
        com.applovin.impl.b.m.a(this.aUS, this.aTB, fVarA, -6, this.sdk);
    }
}
