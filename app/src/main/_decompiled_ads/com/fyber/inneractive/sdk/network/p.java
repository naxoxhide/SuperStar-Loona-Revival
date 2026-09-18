package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes2.dex */
public class p extends k {
    public final InneractiveAdRequest e;
    public final d0 f;

    public class a implements w<com.fyber.inneractive.sdk.response.e> {
        public a() {
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(com.fyber.inneractive.sdk.response.e eVar, Exception exc, boolean z) {
            InneractiveErrorCode inneractiveErrorCode;
            k.a aVar;
            com.fyber.inneractive.sdk.response.e eVar2 = eVar;
            if (exc == null) {
                p pVar = p.this;
                pVar.a(pVar.e, eVar2);
                return;
            }
            p.this.getClass();
            if (exc instanceof s0) {
                inneractiveErrorCode = ((s0) exc).a == 204 ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.SERVER_INTERNAL_ERROR;
            } else {
                inneractiveErrorCode = (!(exc instanceof FileNotFoundException) && (exc instanceof a0)) ? InneractiveErrorCode.SERVER_INVALID_RESPONSE : InneractiveErrorCode.CONNECTION_ERROR;
            }
            p pVar2 = p.this;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, com.fyber.inneractive.sdk.flow.g.NETWORK_ERROR, exc);
            InneractiveAdRequest inneractiveAdRequest = pVar2.e;
            if (pVar2.a == null) {
                return;
            }
            if (pVar2.f989b) {
                IAlog.d("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
            } else {
                if (pVar2.f989b || (aVar = pVar2.a) == null) {
                    return;
                }
                ((com.fyber.inneractive.sdk.flow.k) aVar).b(inneractiveAdRequest, eVar2, inneractiveInfrastructureError);
            }
        }
    }

    public class b implements c0.a {
        public b() {
        }

        @Override // com.fyber.inneractive.sdk.network.c0.a
        public void a(String str) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "sdkInitNetworkRequest":
                    com.fyber.inneractive.sdk.metrics.c.d.a(p.this.d).f();
                    break;
                case "sdkGotServerResponse":
                    com.fyber.inneractive.sdk.metrics.c.d.a(p.this.d).g();
                    break;
                case "sdkParsedResponse":
                    com.fyber.inneractive.sdk.metrics.c.d.a(p.this.d).d();
                    break;
            }
        }
    }

    public p(InneractiveAdRequest inneractiveAdRequest, String str, com.fyber.inneractive.sdk.config.global.s sVar, k.a aVar) {
        super(sVar, str, aVar);
        this.e = inneractiveAdRequest;
        this.f = new d0(new a(), inneractiveAdRequest, sVar);
        c();
    }

    @Override // com.fyber.inneractive.sdk.network.k
    public void a() {
        super.a();
        this.f.a = true;
    }

    @Override // com.fyber.inneractive.sdk.network.k
    public String b() {
        return this.f.a();
    }

    public final void c() {
        this.f.d = new b();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x0074  */
    public boolean d() {
        boolean z;
        InneractiveInfrastructureError inneractiveInfrastructureError;
        InneractiveAdRequest inneractiveAdRequest;
        k.a aVar;
        this.f989b = false;
        IAlog.a("IARemoteAdFetcher: requestAd called", new Object[0]);
        InneractiveAdRequest inneractiveAdRequest2 = this.e;
        if (inneractiveAdRequest2 == null || !TextUtils.isEmpty(inneractiveAdRequest2.getSpotId())) {
            if (com.fyber.inneractive.sdk.util.l.b("android.permission.INTERNET")) {
                if (!com.fyber.inneractive.sdk.util.l.b("android.permission.ACCESS_NETWORK_STATE")) {
                    IAlog.b("It is recommended to add ACCESS_NETWORK_STATE permission to the Manifest for better targetting", new Object[0]);
                }
                if (!com.fyber.inneractive.sdk.util.l.b("android.permission.READ_PHONE_STATE")) {
                    IAlog.e("It is recomended to add the READ_PHONE_STATE permission to the manifest for better targetting", new Object[0]);
                }
                z = true;
            } else {
                IAlog.b("INTERNET permission is missing. Please add it to the Manifest and re-try, otherwise ads will not be requested and displayed! ", new Object[0]);
            }
            if (!z) {
                IAConfigManager.M.s.b(this.f);
                return true;
            }
            inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, com.fyber.inneractive.sdk.flow.g.VALIDATE_PARAMS_FAILED, new Exception("appID is null or empty or INTERNET permission is missing"));
            inneractiveAdRequest = this.e;
            if (!this.f989b && (aVar = this.a) != null) {
                ((com.fyber.inneractive.sdk.flow.k) aVar).b(inneractiveAdRequest, null, inneractiveInfrastructureError);
            }
            return false;
        }
        IAlog.b("appID is null or empty. Please provide a valid appID and re-try.", new Object[0]);
        z = false;
        if (!z) {
            IAConfigManager.M.s.b(this.f);
            return true;
        }
        inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, com.fyber.inneractive.sdk.flow.g.VALIDATE_PARAMS_FAILED, new Exception("appID is null or empty or INTERNET permission is missing"));
        inneractiveAdRequest = this.e;
        if (!this.f989b) {
            ((com.fyber.inneractive.sdk.flow.k) aVar).b(inneractiveAdRequest, null, inneractiveInfrastructureError);
        }
        return false;
    }
}
