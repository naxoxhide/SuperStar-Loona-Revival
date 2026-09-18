package com.applovin.mediation.ads;

import android.content.Context;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAppOpenAd {
    private final MaxFullscreenAdImpl aYq;

    public MaxAppOpenAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context));
    }

    public MaxAppOpenAd(String str, AppLovinSdk appLovinSdk) {
        a.logApiCall("MaxAppOpenAd", "MaxAppOpenAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        this.aYq = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.APP_OPEN, null, "MaxAppOpenAd", appLovinSdk.a());
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.aYq.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.aYq.setListener(maxAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.aYq.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.aYq.setRevenueListener(maxAdRevenueListener);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.aYq.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.aYq.setRequestListener(maxAdRequestListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.aYq.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.aYq.setExpirationListener(maxAdExpirationListener);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.aYq.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.aYq.setAdReviewListener(maxAdReviewListener);
    }

    public void loadAd() {
        this.aYq.logApiCall("loadAd()");
        this.aYq.loadAd(null);
    }

    public void showAd() {
        showAd(null);
    }

    public void showAd(String str) {
        showAd(str, null);
    }

    public void showAd(String str, String str2) {
        this.aYq.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        u.N(str2, "MaxAppOpenAd");
        this.aYq.showAd(str, str2, null);
    }

    public String getAdUnitId() {
        return this.aYq.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.aYq.isReady();
        this.aYq.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.aYq.getAdUnitId());
        return zIsReady;
    }

    public void destroy() {
        this.aYq.logApiCall("destroy()");
        this.aYq.destroy();
    }

    public void setExtraParameter(String str, String str2) {
        this.aYq.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYq.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.aYq.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYq.setLocalExtraParameter(str, obj);
    }

    public String toString() {
        return "" + this.aYq;
    }
}
