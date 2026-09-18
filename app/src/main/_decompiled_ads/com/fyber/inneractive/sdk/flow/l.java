package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;

/* JADX INFO: loaded from: classes2.dex */
public class l extends k implements IAConfigManager.OnConfigurationReadyAndValidListener {
    public com.fyber.inneractive.sdk.response.e g;

    public l(String str) {
        super(str);
    }

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.a.InterfaceC0270a
    public void a(InneractiveAdRequest inneractiveAdRequest) {
        com.fyber.inneractive.sdk.metrics.c.d.b(this.e).a("success");
        super.a(inneractiveAdRequest);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a.b
    public void b() {
        com.fyber.inneractive.sdk.metrics.c.d.b(this.e).a("dyn_timeout");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a.b
    public void c() {
        com.fyber.inneractive.sdk.metrics.c.d.b(this.e).a("retrying");
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (z) {
            return;
        }
        b(null, a(), new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.NO_APP_CONFIG_AVAILABLE, exc));
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public void b(InneractiveAdRequest inneractiveAdRequest) {
        String str;
        com.fyber.inneractive.sdk.response.e eVar = this.g;
        if (eVar == null || (str = eVar.z) == null) {
            return;
        }
        com.fyber.inneractive.sdk.metrics.g gVarB = com.fyber.inneractive.sdk.metrics.c.d.b(str);
        com.fyber.inneractive.sdk.config.global.s sVarB = this.c;
        if (sVarB == null) {
            sVarB = com.fyber.inneractive.sdk.config.global.s.b();
        }
        gVarB.a(eVar, inneractiveAdRequest, sVarB);
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public void a(boolean z) {
        com.fyber.inneractive.sdk.network.k kVar = this.d;
        if (kVar != null) {
            kVar.a();
        }
        this.f = true;
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        if (aVar == null || !z) {
            return;
        }
        aVar.a();
        this.a = null;
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public void a(com.fyber.inneractive.sdk.response.e eVar, InneractiveAdRequest inneractiveAdRequest) {
        String str;
        if (eVar == null || (str = eVar.z) == null) {
            return;
        }
        com.fyber.inneractive.sdk.metrics.g gVarB = com.fyber.inneractive.sdk.metrics.c.d.b(str);
        com.fyber.inneractive.sdk.config.global.s sVarB = this.c;
        if (sVarB == null) {
            sVarB = com.fyber.inneractive.sdk.config.global.s.b();
        }
        gVarB.a(eVar, inneractiveAdRequest, sVarB);
    }
}
