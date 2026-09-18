package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MaxRewardedAd implements MaxFullscreenAdImpl.a {
    private static final Map<String, MaxRewardedAd> aYt = new HashMap();
    private static final Object aYu = new Object();
    private static WeakReference<Activity> aYv = new WeakReference<>(null);
    private final MaxFullscreenAdImpl aYs;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk) {
        this.aYs = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.a());
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
        u.N(str2, "MaxRewardedAd");
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

    public String getAdUnitId() {
        return this.aYs.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.aYs.isReady();
        this.aYs.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.aYs.getAdUnitId());
        return zIsReady;
    }

    public void destroy() {
        this.aYs.logApiCall("destroy()");
        synchronized (aYu) {
            aYt.remove(this.aYs.getAdUnitId());
        }
        this.aYs.destroy();
    }

    public static void updateActivity(Activity activity) {
        a.logApiCall("MaxRewardedAd", "updateActivity(activity=" + activity + ")");
        if (activity != null) {
            aYv = new WeakReference<>(activity);
        }
    }

    public void setExtraParameter(String str, String str2) {
        this.aYs.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYs.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.aYs.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYs.setLocalExtraParameter(str, obj);
    }

    public static MaxRewardedAd getInstance(String str, Activity activity) {
        return getInstance(str, AppLovinSdk.getInstance(activity), activity);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Activity activity) {
        a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
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
        updateActivity(activity);
        synchronized (aYu) {
            Map<String, MaxRewardedAd> map = aYt;
            MaxRewardedAd maxRewardedAd = map.get(str);
            if (maxRewardedAd != null) {
                return maxRewardedAd;
            }
            MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk);
            map.put(str, maxRewardedAd2);
            return maxRewardedAd2;
        }
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a
    public Activity getActivity() {
        this.aYs.logApiCall("getActivity()");
        return aYv.get();
    }

    public String toString() {
        return "" + this.aYs;
    }
}
