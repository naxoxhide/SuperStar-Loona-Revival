package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements com.fyber.inneractive.sdk.network.k.a, com.fyber.inneractive.sdk.interfaces.a.InterfaceC0270a, com.fyber.inneractive.sdk.interfaces.a.b {
    public com.fyber.inneractive.sdk.interfaces.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f923b;
    public com.fyber.inneractive.sdk.config.global.s c;
    public com.fyber.inneractive.sdk.network.k d;
    public final String e;
    public boolean f = false;

    public interface a {
    }

    public k(String str) {
        this.e = str;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a.InterfaceC0270a
    public void a(InneractiveAdRequest inneractiveAdRequest) {
        T t;
        e0 e0Var;
        IAlog.d("%sgot onAdLoaded!", d());
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        if (aVar != null) {
            a aVar2 = this.f923b;
            if (aVar2 != null) {
                Content content = ((h) aVar).c;
                u uVar = (u) aVar2;
                t tVar = uVar.a;
                if (tVar.j || (e0Var = tVar.f) == null || !e0Var.supportsRefresh()) {
                    uVar.a.j = false;
                    t tVar2 = uVar.a;
                    tVar2.e = content;
                    content.a = inneractiveAdRequest;
                    if (tVar2.e()) {
                        t tVar3 = uVar.a;
                        InneractiveAdSpot.RequestListener requestListener = tVar3.f930b;
                        if (requestListener != null) {
                            requestListener.onInneractiveSuccessfulAdRequest(tVar3);
                        }
                    } else {
                        t tVar4 = uVar.a;
                        tVar4.getClass();
                        IAlog.a("%sCannot find appropriate unit controller for unit: %s", IAlog.a(tVar4), uVar.a.e.d);
                        j jVar = uVar.a.h;
                        uVar.a(inneractiveAdRequest, jVar != null ? jVar.a() : null, new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, g.COULD_NOT_SELECT_UNIT_CONTROLLER, new Exception("Cannot find appropriate unit controller for unit: " + uVar.a.e.d)));
                        uVar.a.e = null;
                    }
                } else if (uVar.a.f.canRefreshAd()) {
                    t tVar5 = uVar.a;
                    tVar5.e = content;
                    content.a = inneractiveAdRequest;
                    t.c cVar = tVar5.i;
                    if (cVar != null) {
                        cVar.onAdRefreshed(tVar5);
                    } else {
                        e0 e0Var2 = tVar5.f;
                        if (e0Var2 instanceof InneractiveAdViewUnitController) {
                            ((InneractiveAdViewUnitController) e0Var2).onAdRefreshed(tVar5);
                        }
                    }
                } else {
                    t tVar6 = uVar.a;
                    tVar6.getClass();
                    IAlog.a("%sad loaded successfully, but the selected unit controller has rejected the refresh!", IAlog.a(tVar6));
                    t tVar7 = uVar.a;
                    tVar7.i.onAdRefreshFailed(tVar7, InneractiveErrorCode.CANCELLED);
                }
                String str = uVar.a.a;
                com.fyber.inneractive.sdk.metrics.c cVar2 = com.fyber.inneractive.sdk.metrics.c.d;
                cVar2.a(str).e();
                cVar2.a(str).b();
                t tVar8 = uVar.a;
                q qVar = tVar8.e;
                if (qVar != null && (t = qVar.f927b) != 0 && t.n != null) {
                    q qVar2 = tVar8.e;
                    T t2 = qVar2.f927b;
                    new com.fyber.inneractive.sdk.metrics.b(t2, tVar8.c, tVar8.a, t2.n, qVar2.c.c()).a();
                }
            }
            this.a = null;
        }
        b(inneractiveAdRequest);
    }

    public void a(com.fyber.inneractive.sdk.response.e eVar, InneractiveAdRequest inneractiveAdRequest) {
    }

    public void b(InneractiveAdRequest inneractiveAdRequest) {
    }

    public void b(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        if (IAlog.a <= 3) {
            Thread.dumpStack();
        }
        IAlog.d("%sgot onAdRequestFailed! with: %s", d(), inneractiveInfrastructureError.getErrorCode());
        if (this.f923b != null) {
            if (eVar != null && eVar.i != null) {
                inneractiveInfrastructureError.setCause(new Exception(eVar.i + ": " + eVar.j));
            }
            ((u) this.f923b).a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
    }

    public String d() {
        return IAlog.a(this);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a.InterfaceC0270a
    public void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        Content content;
        IAlog.d("%sgot onFailedLoading! with: %s", d(), inneractiveInfrastructureError);
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        a((aVar == null || (content = ((h) aVar).c) == 0) ? null : content.a, a(), inneractiveInfrastructureError);
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.d("%sgot handleFailedLoading! with: %s", d(), inneractiveInfrastructureError);
        a aVar = this.f923b;
        if (aVar != null) {
            ((u) aVar).a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
        a(eVar, inneractiveAdRequest);
    }

    public com.fyber.inneractive.sdk.response.e a() {
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        h hVar = (h) aVar;
        if (hVar.c != 0) {
            return hVar.c.d();
        }
        return null;
    }

    public void a(boolean z) {
        this.f = true;
        com.fyber.inneractive.sdk.interfaces.a aVar = this.a;
        if (aVar == null || !z) {
            return;
        }
        aVar.a();
        this.a = null;
    }
}
