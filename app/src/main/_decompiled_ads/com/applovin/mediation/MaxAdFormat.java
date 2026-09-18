package com.applovin.mediation;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.mediation.e.c;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes.dex */
public class MaxAdFormat {
    private final String aou;
    private final String dp;
    public static final MaxAdFormat BANNER = new MaxAdFormat("BANNER", ADXLogUtil.INVENTORY_BANNER);
    public static final MaxAdFormat MREC = new MaxAdFormat("MREC", "MREC");
    public static final MaxAdFormat LEADER = new MaxAdFormat("LEADER", "Leader");
    public static final MaxAdFormat INTERSTITIAL = new MaxAdFormat("INTER", "Interstitial");
    public static final MaxAdFormat APP_OPEN = new MaxAdFormat("APPOPEN", "App Open");
    public static final MaxAdFormat REWARDED = new MaxAdFormat("REWARDED", "Rewarded");
    public static final MaxAdFormat REWARDED_INTERSTITIAL = new MaxAdFormat("REWARDED_INTER", "Rewarded Interstitial");
    public static final MaxAdFormat NATIVE = new MaxAdFormat("NATIVE", ADXLogUtil.INVENTORY_NATIVE);
    public static final MaxAdFormat CROSS_PROMO = new MaxAdFormat("XPROMO", "Cross Promo");

    public static MaxAdFormat formatFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(ReportUtil.INVENTORY_TYPE_BANNER)) {
            return BANNER;
        }
        if (str.equalsIgnoreCase("mrec")) {
            return MREC;
        }
        if (str.equalsIgnoreCase("xpromo")) {
            return CROSS_PROMO;
        }
        if (str.equalsIgnoreCase("native")) {
            return NATIVE;
        }
        if (str.equalsIgnoreCase("leaderboard") || str.equalsIgnoreCase("leader")) {
            return LEADER;
        }
        if (str.equalsIgnoreCase(ReportUtil.INVENTORY_TYPE_INTERSTITIAL) || str.equalsIgnoreCase("inter")) {
            return INTERSTITIAL;
        }
        if (str.equalsIgnoreCase("appopen") || str.equalsIgnoreCase(FirebaseAnalytics.Event.APP_OPEN)) {
            return APP_OPEN;
        }
        if (str.equalsIgnoreCase("rewarded") || str.equalsIgnoreCase(ReportUtil.EVENT_TYPE_REWARD)) {
            return REWARDED;
        }
        if (str.equalsIgnoreCase("rewarded_inter") || str.equalsIgnoreCase("rewarded_interstitial")) {
            return REWARDED_INTERSTITIAL;
        }
        x.H("AppLovinSdk", "Unknown ad format: " + str);
        return null;
    }

    private MaxAdFormat(String str, String str2) {
        this.dp = str;
        this.aou = str2;
    }

    public String getLabel() {
        return this.dp;
    }

    public AppLovinSdkUtils.Size getSize() {
        if (this == BANNER) {
            return new AppLovinSdkUtils.Size(320, 50);
        }
        if (this == LEADER) {
            return new AppLovinSdkUtils.Size(728, 90);
        }
        if (this == MREC) {
            return new AppLovinSdkUtils.Size(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, 250);
        }
        if (this == CROSS_PROMO) {
            return new AppLovinSdkUtils.Size(-1, -1);
        }
        return new AppLovinSdkUtils.Size(0, 0);
    }

    public AppLovinSdkUtils.Size getAdaptiveSize(Activity activity) {
        return getAdaptiveSize(-1, activity);
    }

    public AppLovinSdkUtils.Size getAdaptiveSize(int i, Context context) {
        if (this == BANNER || this == LEADER) {
            return c.a(i, this, context);
        }
        return getSize();
    }

    public boolean isFullscreenAd() {
        return this == INTERSTITIAL || this == APP_OPEN || this == REWARDED || this == REWARDED_INTERSTITIAL;
    }

    public boolean isAdViewAd() {
        return this == BANNER || this == MREC || this == LEADER || this == CROSS_PROMO;
    }

    public boolean isBannerOrLeaderAd() {
        return this == BANNER || this == LEADER;
    }

    public String toString() {
        return "MaxAdFormat{label='" + this.dp + "'}";
    }

    @Deprecated
    public String getDisplayName() {
        return this.aou;
    }
}
