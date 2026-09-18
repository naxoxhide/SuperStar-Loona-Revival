package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class MaxRewardedInterstitialAd implements MaxFullscreenAdImpl.a {
    private static WeakReference<Activity> aYr = new WeakReference<>(null);
    private final MaxFullscreenAdImpl aYs;

    public MaxRewardedInterstitialAd(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxRewardedInterstitialAd(String str, AppLovinSdk appLovinSdk, Activity activity) {
        a.logApiCall("MaxRewardedInterstitialAd", "MaxRewardedInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        aYr = new WeakReference<>(activity);
        this.aYs = new MaxFullscreenAdImpl(str, MaxAdFormat.REWARDED_INTERSTITIAL, this, "MaxRewardedInterstitialAd", appLovinSdk.a());
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.aYs.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.aYs.setListener(maxRewardedAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.aYs.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.aYs.setRevenueListener(maxAdRevenueListener);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.aYs.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.aYs.setRequestListener(maxAdRequestListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.aYs.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.aYs.setExpirationListener(maxAdExpirationListener);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.aYs.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.aYs.setAdReviewListener(maxAdReviewListener);
    }

    public void loadAd() {
        this.aYs.logApiCall("loadAd()");
        this.aYs.loadAd(getActivity());
    }

    public void showAd() {
        showAd(null);
    }

    public void showAd(String str) {
        showAd(str, (String) null);
    }

    public void showAd(String str, String str2) {
        this.aYs.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        this.aYs.showAd(str, str2, getActivity());
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd(null, viewGroup, lifecycle);
    }

    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd(str, null, viewGroup, lifecycle);
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.aYs.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.aYs.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }

    public boolean isReady() {
        boolean zIsReady = this.aYs.isReady();
        this.aYs.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.aYs.getAdUnitId());
        return zIsReady;
    }

    public void destroy() {
        this.aYs.logApiCall("destroy()");
        this.aYs.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a
    public Activity getActivity() {
        this.aYs.logApiCall("getActivity()");
        return aYr.get();
    }

    public void setExtraParameter(String str, String str2) {
        this.aYs.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYs.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.aYs.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYs.setLocalExtraParameter(str, obj);
    }

    public String toString() {
        return "" + this.aYs;
    }
}
