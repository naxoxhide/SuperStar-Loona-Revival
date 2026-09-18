package com.fyber.inneractive.sdk.flow;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveError;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.VerificationScriptResource;
import com.iab.omid.library.fyber.adsession.media.MediaEvents;
import com.iab.omid.library.fyber.publisher.AdSessionStatePublisher;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class o extends h<com.fyber.inneractive.sdk.response.g, f0> implements com.fyber.inneractive.sdk.player.h.b {
    public com.fyber.inneractive.sdk.player.h m;

    public o(String str) {
    }

    @Override // com.fyber.inneractive.sdk.flow.h, com.fyber.inneractive.sdk.interfaces.a
    public void a() {
        d();
        this.k.a();
        this.m.a();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    @Override // com.fyber.inneractive.sdk.flow.h, com.fyber.inneractive.sdk.interfaces.a.b
    public void b() {
        InneractiveVideoError inneractiveVideoError;
        if (this.m != null) {
            Response response = this.f920b;
            if (response != 0) {
                com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) response;
                if (gVar.K != null) {
                    inneractiveVideoError = gVar.K.d.size() == 0 ? new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, null) : new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, null);
                } else {
                    inneractiveVideoError = null;
                }
            } else {
                inneractiveVideoError = null;
            }
            this.m.a(inneractiveVideoError, null, null, true);
        }
        a();
        super.b();
    }

    @Override // com.fyber.inneractive.sdk.flow.h
    public String f() {
        return "send_failed_vast_creatives";
    }

    @Override // com.fyber.inneractive.sdk.flow.h
    public void j() {
        com.fyber.inneractive.sdk.model.vast.b bVar;
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration;
        com.fyber.inneractive.sdk.model.vast.b bVar2;
        IAlog.a(IAlog.a(this) + "start called", new Object[0]);
        com.fyber.inneractive.sdk.config.b0 b0VarG = g();
        Response response = this.f920b;
        AdSessionContext adSessionContextCreateNativeAdSessionContext = null;
        com.fyber.inneractive.sdk.model.vast.b bVar3 = response == 0 ? null : ((com.fyber.inneractive.sdk.response.g) response).K;
        if (bVar3 != null && bVar3.d.size() < bVar3.i) {
            bVar3.d.clear();
            bVar3.g.clear();
            bVar3.d.addAll(bVar3.k);
            bVar3.g.addAll(bVar3.l);
        }
        f0 f0Var = new f0(b0VarG, this.g, (com.fyber.inneractive.sdk.response.g) this.f920b, this.a);
        this.c = f0Var;
        com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) this.f920b;
        com.fyber.inneractive.sdk.player.h hVar = new com.fyber.inneractive.sdk.player.h(gVar, this.a, f0Var, this);
        this.m = hVar;
        f0 f0Var2 = (f0) this.c;
        f0Var2.i = hVar;
        f0Var2.f = this.h;
        hVar.e = null;
        if (gVar != null && (bVar2 = gVar.K) != null) {
            hVar.e = bVar2.d.poll();
        }
        if (hVar.e == null) {
            hVar.b();
            com.fyber.inneractive.sdk.player.h.b bVar4 = hVar.d;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.VAST_NO_MEDIA_FILES);
            o oVar = (o) bVar4;
            oVar.a((InneractiveError) inneractiveInfrastructureError);
            oVar.a(inneractiveInfrastructureError);
            return;
        }
        hVar.e();
        com.fyber.inneractive.sdk.player.a.InterfaceC0275a interfaceC0275a = hVar.f;
        if (interfaceC0275a != null) {
            com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) interfaceC0275a;
            if (eVar.g != null) {
                com.fyber.inneractive.sdk.measurement.d dVar = new com.fyber.inneractive.sdk.measurement.d();
                com.fyber.inneractive.sdk.measurement.a aVar = eVar.g;
                List<com.fyber.inneractive.sdk.measurement.f> list = eVar.v.e;
                f0 f0Var3 = eVar.e;
                try {
                    try {
                        CreativeType creativeType = CreativeType.VIDEO;
                        ImpressionType impressionType = ImpressionType.UNSPECIFIED;
                        Owner owner = Owner.NATIVE;
                        adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
                    } catch (Throwable th) {
                        dVar.a(th);
                        adSessionConfigurationCreateAdSessionConfiguration = null;
                    }
                    List<VerificationScriptResource> listA = dVar.a(list);
                    if (((com.fyber.inneractive.sdk.measurement.b) aVar).e != null && ((com.fyber.inneractive.sdk.measurement.b) aVar).f946b != null) {
                        try {
                            adSessionContextCreateNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(((com.fyber.inneractive.sdk.measurement.b) aVar).e, ((com.fyber.inneractive.sdk.measurement.b) aVar).f946b, listA, "", "");
                        } catch (Throwable th2) {
                            dVar.a(th2);
                        }
                    }
                    AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, adSessionContextCreateNativeAdSessionContext);
                    dVar.a = adSessionCreateAdSession;
                    AdSessionStatePublisher adSessionStatePublisher = adSessionCreateAdSession.getAdSessionStatePublisher();
                    if (adSessionStatePublisher != null) {
                        adSessionStatePublisher.getWebView();
                        WebView webView = adSessionStatePublisher.getWebView();
                        if (webView != null) {
                            webView.setWebViewClient(dVar.g);
                        }
                    }
                    dVar.f948b = AdEvents.createAdEvents(dVar.a);
                    dVar.c = MediaEvents.createMediaEvents(dVar.a);
                    dVar.a.start();
                    dVar.f = f0Var3;
                } catch (Throwable th3) {
                    dVar.a(th3);
                }
                eVar.h = dVar;
                eVar.i = new com.fyber.inneractive.sdk.player.f(dVar);
            }
            if (eVar.h == null && (bVar = eVar.v) != null) {
                for (com.fyber.inneractive.sdk.measurement.f fVar : bVar.e) {
                    com.fyber.inneractive.sdk.measurement.g gVar2 = com.fyber.inneractive.sdk.measurement.g.ERROR_DURING_RESOURCE_LOAD;
                    com.fyber.inneractive.sdk.model.vast.t tVar = com.fyber.inneractive.sdk.model.vast.t.EVENT_VERIFICATION_NOT_EXECUTED;
                    com.fyber.inneractive.sdk.player.e.a(new com.fyber.inneractive.sdk.measurement.e(fVar, fVar.a(tVar), gVar2), tVar);
                }
            }
        }
        hVar.d();
    }
}
