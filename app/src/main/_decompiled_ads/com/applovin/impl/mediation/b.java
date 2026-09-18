package com.applovin.impl.mediation;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.m;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class b implements a.InterfaceC0115a, c.a {
    private final a akS;
    private final c akT;
    private final n sdk;

    public b(n nVar) {
        this.sdk = nVar;
        this.akS = new a(nVar);
        this.akT = new c(nVar, this);
    }

    public void b(com.applovin.impl.mediation.b.c cVar) {
        long jXV = cVar.xV();
        if (jXV >= 0) {
            this.akT.a(cVar, jXV);
        }
        boolean z = Boolean.parseBoolean(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.SHOULD_SCHEDULE_AD_HIDDEN_ON_AD_DESTROY));
        if (cVar.xW() || cVar.xX() || z) {
            this.akS.ay(z);
            this.akS.a(cVar, this);
        }
    }

    public void tS() {
        this.akT.tT();
        this.akS.W();
    }

    @Override // com.applovin.impl.mediation.c.a
    public void c(com.applovin.impl.mediation.b.c cVar) {
        e(cVar);
    }

    @Override // com.applovin.impl.mediation.a.InterfaceC0115a
    public void a(final com.applovin.impl.mediation.b.c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$b$li7Puy02Saiifv65gyvMTkWuz-U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(cVar);
            }
        }, cVar.xY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void e(com.applovin.impl.mediation.b.c cVar) {
        if (cVar != null && cVar.xO().compareAndSet(false, true)) {
            m.c(cVar.xB().uf(), cVar);
        }
    }
}
