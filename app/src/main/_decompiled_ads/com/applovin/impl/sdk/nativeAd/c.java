package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.e.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends k {
    private final AppLovinNativeAdLoadListener awc;

    public c(com.applovin.impl.sdk.ad.d dVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super(dVar, str, nVar);
        this.awc = appLovinNativeAdLoadListener;
    }

    @Override // com.applovin.impl.sdk.e.k
    protected String zA() {
        return i.I(this.sdk);
    }

    @Override // com.applovin.impl.sdk.e.k
    protected String zB() {
        return i.J(this.sdk);
    }

    @Override // com.applovin.impl.sdk.e.k
    protected com.applovin.impl.sdk.e.d I(JSONObject jSONObject) {
        return new d(jSONObject, this.awc, this.sdk);
    }

    @Override // com.applovin.impl.sdk.e.k
    protected void e(int i, String str) {
        super.e(i, str);
        this.awc.onNativeAdLoadFailed(new AppLovinError(i, str));
    }
}
