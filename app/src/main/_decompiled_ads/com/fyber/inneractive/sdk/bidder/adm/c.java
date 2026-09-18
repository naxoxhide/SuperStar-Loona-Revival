package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.k;
import com.fyber.inneractive.sdk.flow.l;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.network.o;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class c implements w<com.fyber.inneractive.sdk.response.e> {
    public final /* synthetic */ f.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.response.e f845b;
    public final /* synthetic */ f c;

    public c(f fVar, f.a aVar, com.fyber.inneractive.sdk.response.e eVar) {
        this.c = fVar;
        this.a = aVar;
        this.f845b = eVar;
    }

    @Override // com.fyber.inneractive.sdk.network.w
    public void a(com.fyber.inneractive.sdk.response.e eVar, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.response.e eVar2 = eVar;
        if (exc != null) {
            com.fyber.inneractive.sdk.metrics.c.d.b(this.c.d).b(exc.getMessage());
            f.a aVar = this.a;
            if (aVar != null) {
                ((t.a) aVar).a(exc, f.a(this.c, exc) ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.CONNECTION_ERROR, this.f845b);
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.c cVar = com.fyber.inneractive.sdk.metrics.c.d;
        cVar.b(this.c.d).b("success");
        f.a aVar2 = this.a;
        if (aVar2 != null) {
            t.a aVar3 = (t.a) aVar2;
            t tVar = t.this;
            tVar.getClass();
            IAlog.a("%s : InneractiveAdSpotImpl data available", IAlog.a(tVar));
            t tVar2 = t.this;
            s sVar = aVar3.f931b;
            k.a aVar4 = tVar2.d;
            l lVar = tVar2.l;
            if (lVar != null) {
                lVar.f923b = aVar4;
                cVar.b(tVar2.getLocalUniqueId()).a();
                lVar.g = eVar2;
                if (!IAConfigManager.i()) {
                    IAConfigManager.addListener(lVar);
                    IAConfigManager.a();
                } else {
                    lVar.c = sVar;
                    o oVar = new o(sVar, eVar2, tVar2.getLocalUniqueId(), lVar);
                    lVar.d = oVar;
                    oVar.c();
                }
            }
        }
    }
}
