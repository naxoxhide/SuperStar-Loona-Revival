package com.applovin.impl.sdk.e;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class o extends n {
    private final com.applovin.impl.sdk.ad.c aUf;

    public o(com.applovin.impl.sdk.ad.c cVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        super(com.applovin.impl.sdk.ad.d.cU("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", nVar);
        this.aUf = cVar;
    }

    @Override // com.applovin.impl.sdk.e.k
    protected Map<String, String> HG() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.aUf.mQ());
        map.put("adtoken_prefix", this.aUf.FO());
        return map;
    }

    @Override // com.applovin.impl.sdk.e.k
    protected com.applovin.impl.sdk.ad.b getSource() {
        return com.applovin.impl.sdk.ad.b.REGULAR_AD_TOKEN;
    }
}
