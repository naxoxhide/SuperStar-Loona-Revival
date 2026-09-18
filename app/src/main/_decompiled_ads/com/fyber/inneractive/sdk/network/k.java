package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f989b = false;
    public com.fyber.inneractive.sdk.config.global.s c;
    public final String d;

    public interface a {
    }

    public k(com.fyber.inneractive.sdk.config.global.s sVar, String str, a aVar) {
        this.a = aVar;
        this.c = sVar;
        this.d = str;
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        a aVar;
        if (this.a == null) {
            return;
        }
        if (this.f989b) {
            IAlog.d("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.config.a0 a0VarB = com.fyber.inneractive.sdk.config.a.b(eVar.m);
        if (inneractiveAdRequest != null) {
            inneractiveAdRequest.setSelectedUnitConfig(a0VarB);
        }
        com.fyber.inneractive.sdk.config.global.e eVar2 = new com.fyber.inneractive.sdk.config.global.e();
        ImpressionData impressionData = eVar.r;
        eVar2.a = impressionData != null ? impressionData.getDemandId() : null;
        try {
            eVar2.f876b = Long.valueOf(IAConfigManager.M.d);
        } catch (NumberFormatException unused) {
            IAlog.a("invalid publisherId", new Object[0]);
        }
        this.c.a(eVar2);
        InneractiveErrorCode inneractiveErrorCodeA = a0VarB == null ? InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH : eVar.a(inneractiveAdRequest, this.c);
        if (inneractiveErrorCodeA == null) {
            com.fyber.inneractive.sdk.flow.k kVar = (com.fyber.inneractive.sdk.flow.k) this.a;
            if (kVar.f) {
                IAlog.d("IAAdSourceBase: load cancelled: ignoring response. Previous load request was cancelled", new Object[0]);
                return;
            }
            com.fyber.inneractive.sdk.config.global.s sVar = kVar.c;
            IAlog.d("%sonAdDataAvailable: got response data: %s", kVar.d(), eVar);
            IAConfigManager iAConfigManager = IAConfigManager.M;
            if (iAConfigManager.E != null && eVar.b()) {
                iAConfigManager.E.a((com.fyber.inneractive.sdk.ignite.h) null);
            }
            com.fyber.inneractive.sdk.response.a aVarA = com.fyber.inneractive.sdk.response.a.a(eVar.g);
            com.fyber.inneractive.sdk.factories.b.InterfaceC0266b interfaceC0266b = com.fyber.inneractive.sdk.factories.b.a.a.a.get(aVarA);
            com.fyber.inneractive.sdk.interfaces.a aVarA2 = interfaceC0266b != null ? interfaceC0266b.a() : null;
            kVar.a = aVarA2;
            if (aVarA2 == null) {
                IAlog.e("%sonAdDataAvailable: Cannot find content handler for ad type: %s", kVar.d(), aVarA);
                com.fyber.inneractive.sdk.flow.k.a aVar2 = kVar.f923b;
                if (aVar2 != null) {
                    ((com.fyber.inneractive.sdk.flow.u) aVar2).a(inneractiveAdRequest, eVar, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.NO_CONTENT_LOADER_AVAILABLE));
                }
            } else {
                IAlog.d("%sonAdDataAvailable: found response loader: %s", kVar.d(), kVar.a);
            }
            ((com.fyber.inneractive.sdk.flow.h) kVar.a).a(inneractiveAdRequest, eVar, sVar, kVar, kVar);
            return;
        }
        com.fyber.inneractive.sdk.flow.g gVar = com.fyber.inneractive.sdk.flow.g.CONTENT_ERROR_UNSPECIFIED;
        if (a0VarB == null || inneractiveErrorCodeA == InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH) {
            gVar = com.fyber.inneractive.sdk.flow.g.NO_APP_CONFIG_AVAILABLE;
            IAlog.b("%sGot configuration mismatch!", IAlog.a(this));
            IAConfigManager.a();
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCodeA, gVar);
        Exception exc = eVar.x;
        if (exc != null) {
            inneractiveInfrastructureError.setCause(exc);
        }
        com.fyber.inneractive.sdk.response.a aVarA3 = com.fyber.inneractive.sdk.response.a.a(eVar.g);
        if (aVarA3 != null) {
            Exception exc2 = eVar.x;
            if (exc2 != null) {
                inneractiveInfrastructureError.setCause(exc2);
            }
            com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.flow.c(new com.fyber.inneractive.sdk.flow.d(eVar, inneractiveAdRequest, aVarA3 == com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML ? "send_failed_display_creatives" : "send_failed_vast_creatives", this.c.c()), inneractiveInfrastructureError));
        }
        com.fyber.inneractive.sdk.config.global.s sVar2 = this.c;
        if (sVar2 == null) {
            InneractiveAdSpot spot = InneractiveAdSpotManager.get().getSpot(this.d);
            sVar2 = (spot == null || spot.getAdContent() == null) ? null : spot.getAdContent().c;
        }
        com.fyber.inneractive.sdk.flow.a.a(inneractiveAdRequest, inneractiveInfrastructureError, null, eVar, sVar2 != null ? sVar2.c() : null);
        if (this.f989b || (aVar = this.a) == null) {
            return;
        }
        ((com.fyber.inneractive.sdk.flow.k) aVar).b(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
    }

    public String b() {
        return null;
    }

    public void a() {
        this.f989b = true;
        this.a = null;
    }
}
