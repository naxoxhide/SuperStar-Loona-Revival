package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.n;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    private final com.applovin.impl.sdk.ad.c aHg;

    public b(com.applovin.impl.sdk.ad.c cVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super(com.applovin.impl.sdk.ad.d.cU("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, nVar);
        this.aHg = cVar;
    }

    @Override // com.applovin.impl.sdk.e.k
    protected Map<String, String> HG() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.aHg.mQ());
        map.put("adtoken_prefix", this.aHg.FO());
        return map;
    }
}
