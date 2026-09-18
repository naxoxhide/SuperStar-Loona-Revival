package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.network.c0;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c0.a {
    public final /* synthetic */ f a;

    public d(f fVar) {
        this.a = fVar;
    }

    @Override // com.fyber.inneractive.sdk.network.c0.a
    public void a(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "sdkInitNetworkRequest":
                com.fyber.inneractive.sdk.metrics.c cVar = com.fyber.inneractive.sdk.metrics.c.d;
                cVar.a(this.a.d).f();
                cVar.b(this.a.d).b();
                break;
            case "sdkGotServerResponse":
                com.fyber.inneractive.sdk.metrics.c.d.a(this.a.d).h();
                break;
            case "sdkParsedResponse":
                com.fyber.inneractive.sdk.metrics.c.d.a(this.a.d).d();
                break;
            case "sdkRequestEndedButWillBeRetried":
                com.fyber.inneractive.sdk.metrics.c.d.b(this.a.d).b("retrying");
                break;
        }
    }
}
