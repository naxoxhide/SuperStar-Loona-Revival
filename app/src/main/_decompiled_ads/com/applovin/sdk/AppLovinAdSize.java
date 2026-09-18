package com.applovin.sdk;

import com.kbeanie.imagechooser.api.ChooserType;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinAdSize {
    public static final int SPAN = -1;
    private final int dE;
    private final String dp;
    private final int height;
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, 250, "MREC");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize CROSS_PROMO = new AppLovinAdSize(-1, -1, "XPROMO");
    public static final AppLovinAdSize NATIVE = new AppLovinAdSize(-1, -1, "NATIVE");

    private AppLovinAdSize(int i, int i2, String str) {
        this.dE = i;
        this.height = i2;
        this.dp = str;
    }

    public int getWidth() {
        return this.dE;
    }

    public int getHeight() {
        return this.height;
    }

    public String getLabel() {
        return this.dp.toUpperCase(Locale.ENGLISH);
    }

    public String toString() {
        return getLabel();
    }

    public static AppLovinAdSize fromString(String str) {
        if ("BANNER".equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("XPROMO".equalsIgnoreCase(str)) {
            return CROSS_PROMO;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Size: " + str);
    }
}
