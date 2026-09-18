package com.applovin.impl.adview;

import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: loaded from: classes.dex */
public class AppLovinAppOpenAd {
    private final AppLovinInterstitialAdDialog agP;

    public String toString() {
        return "AppLovinAppOpenAd{}";
    }

    public AppLovinAppOpenAd(AppLovinSdk appLovinSdk) {
        this.agP = AppLovinInterstitialAd.create(appLovinSdk, com.applovin.impl.sdk.n.getApplicationContext());
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.agP.setAdDisplayListener(appLovinAdDisplayListener);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.agP.setAdClickListener(appLovinAdClickListener);
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.agP.setAdVideoPlaybackListener(appLovinAdVideoPlaybackListener);
    }

    public void show(AppLovinAd appLovinAd) {
        this.agP.showAndRender(appLovinAd);
    }
}
