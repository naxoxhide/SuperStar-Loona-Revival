package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.privacy.a;
import com.applovin.impl.sdk.x;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinPrivacySettings {
    public static void setHasUserConsent(boolean z, Context context) {
        x.D("AppLovinPrivacySettings", "setHasUserConsent()");
        if (a.b(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z), null, null);
        }
    }

    public static boolean hasUserConsent(Context context) {
        x.D("AppLovinPrivacySettings", "hasUserConsent()");
        Boolean boolB = a.zN().B(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    public static boolean isUserConsentSet(Context context) {
        x.D("AppLovinPrivacySettings", "isUserConsentSet()");
        return a.zN().B(context) != null;
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        x.D("AppLovinPrivacySettings", "setIsAgeRestrictedUser()");
        if (a.a(z, context)) {
            AppLovinSdk.reinitializeAll(null, Boolean.valueOf(z), null);
        }
    }

    public static boolean isAgeRestrictedUser(Context context) {
        x.D("AppLovinPrivacySettings", "isAgeRestrictedUser()");
        Boolean boolB = a.zM().B(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUserSet(Context context) {
        x.D("AppLovinPrivacySettings", "isAgeRestrictedUserSet()");
        return a.zM().B(context) != null;
    }

    public static void setDoNotSell(boolean z, Context context) {
        x.D("AppLovinPrivacySettings", "setDoNotSell()");
        if (a.c(z, context)) {
            AppLovinSdk.reinitializeAll(null, null, Boolean.valueOf(z));
        }
    }

    public static boolean isDoNotSell(Context context) {
        x.D("AppLovinPrivacySettings", "isDoNotSell()");
        Boolean boolB = a.zO().B(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSellSet(Context context) {
        x.D("AppLovinPrivacySettings", "isDoNotSellSet()");
        return a.zO().B(context) != null;
    }
}
