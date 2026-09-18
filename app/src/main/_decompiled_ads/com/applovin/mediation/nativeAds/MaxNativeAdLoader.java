package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MaxNativeAdLoader {
    private final MaxNativeAdLoaderImpl aYz;

    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.aYz = new MaxNativeAdLoaderImpl(str, appLovinSdk.a());
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        this.aYz.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.aYz.loadAd(maxNativeAdView);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        this.aYz.logApiCall("render(adView=" + maxNativeAdView + ", ad=" + maxAd + ")");
        return this.aYz.render(maxNativeAdView, maxAd);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        this.aYz.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.aYz.setNativeAdListener(maxNativeAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.aYz.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.aYz.setRevenueListener(maxAdRevenueListener);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.aYz.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.aYz.setAdReviewListener(maxAdReviewListener);
    }

    public void setPlacement(String str) {
        this.aYz.logApiCall("setPlacement(placement=" + str + ")");
        this.aYz.setPlacement(str);
    }

    public String getPlacement() {
        this.aYz.logApiCall("getPlacement()");
        return this.aYz.getPlacement();
    }

    public void setCustomData(String str) {
        this.aYz.logApiCall("setCustomData(value=" + str + ")");
        this.aYz.setCustomData(str);
    }

    public String getAdUnitId() {
        return this.aYz.getAdUnitId();
    }

    public void destroy() {
        this.aYz.logApiCall("destroy()");
        this.aYz.destroy();
    }

    public void destroy(MaxAd maxAd) {
        this.aYz.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.aYz.destroy(maxAd);
    }

    public void setExtraParameter(String str, String str2) {
        this.aYz.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYz.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.aYz.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYz.setLocalExtraParameter(str, obj);
    }

    public void a(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        this.aYz.logApiCall("a()");
        this.aYz.registerClickableViews(list, viewGroup, maxAd);
    }

    public void b(MaxAd maxAd) {
        this.aYz.logApiCall("b()");
        this.aYz.handleNativeAdViewRendered(maxAd);
    }
}
