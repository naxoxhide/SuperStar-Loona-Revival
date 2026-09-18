package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.tapjoy.internal.ba;
import com.tapjoy.internal.d3;
import com.tapjoy.internal.i2;
import com.tapjoy.internal.j2;
import com.tapjoy.internal.p1;
import com.tapjoy.internal.r1;
import com.tapjoy.internal.r9;
import com.tapjoy.internal.t1;
import com.tapjoy.internal.v1;
import com.tapjoy.internal.w9;
import com.tapjoy.internal.x9;
import com.tapjoy.internal.y6;
import com.tapjoy.internal.y9;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class Tapjoy {

    @Deprecated
    public static final String INTENT_EXTRA_PUSH_PAYLOAD = "com.tapjoy.PUSH_PAYLOAD";

    public static void actionComplete(String str) {
        if (y9.f2836b.a("actionComplete")) {
            TapjoyConnectCore.getInstance().actionComplete(str);
        }
    }

    @Deprecated
    public static void activateInstallReferrerClient(Context context) {
        try {
            y9.f2836b.a(context);
        } catch (TapjoyIntegrationException e) {
            Log.w(ADXLogUtil.PLATFORM_TAPJOY, e.getMessage());
        }
    }

    public static void addUserTag(String str) {
        HashSet hashSet;
        HashSet hashSet2;
        y9.f2836b.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v1 v1Var = v1.m;
        if (v1Var.a()) {
            d3 d3Var = v1Var.e;
            synchronized (d3Var) {
                hashSet = new HashSet(d3Var.c.v);
            }
            hashSet2 = hashSet;
        } else {
            hashSet2 = new HashSet();
        }
        if (hashSet2.add(str)) {
            v1Var.a(hashSet2);
        }
    }

    public static void awardCurrency(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        ba baVar = y9.f2836b;
        if (!baVar.a("awardCurrency")) {
            if (tJAwardCurrencyListener != null) {
                tJAwardCurrencyListener.onAwardCurrencyResponseFailure("Tapjoy SDK is not connected");
            }
        } else {
            TJCurrency tJCurrency = baVar.e;
            if (tJCurrency != null) {
                tJCurrency.awardCurrency(i, tJAwardCurrencyListener);
            }
        }
    }

    public static void clearUserTags() {
        y9.f2836b.getClass();
        v1.m.a((Set) null);
    }

    public static boolean connect(Context context, String str) {
        ba baVar = y9.f2836b;
        baVar.getClass();
        return baVar.f.a(context, str, null, null);
    }

    public static void endSession() {
        if (y9.f2836b.b("endSession")) {
            com.tapjoy.internal.e.a();
            v1 v1Var = v1.m;
            v1Var.j = false;
            TapjoyConnectCore.getInstance().appPause();
            if (v1Var.b()) {
                y6 y6Var = v1Var.g;
                if (y6Var.f2834b.get()) {
                    y6Var.c.run();
                }
            }
        }
    }

    public static void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        ba baVar = y9.f2836b;
        if (!baVar.a("getCurrencyBalance")) {
            if (tJGetCurrencyBalanceListener != null) {
                tJGetCurrencyBalanceListener.onGetCurrencyBalanceResponseFailure("Tapjoy SDK is not connected");
            }
        } else {
            TJCurrency tJCurrency = baVar.e;
            if (tJCurrency != null) {
                tJCurrency.getCurrencyBalance(tJGetCurrencyBalanceListener);
            }
        }
    }

    public static String getCustomParameter() {
        y9.f2836b.getClass();
        return TapjoyConnectCore.getCustomParameter();
    }

    @Deprecated
    public static TJPlacement getLimitedPlacement(String str, TJPlacementListener tJPlacementListener) {
        return null;
    }

    public static int getMaxLevel() {
        y9.f2836b.getClass();
        return TJUserParameters.getInstance().getUserMaxLevel();
    }

    public static TJPlacement getPlacement(String str, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        y9.f2836b.getClass();
        synchronized (TJPlacementManager.a) {
            tJPlacement = new TJPlacement(TJPlacementManager.a(str, "", "", false), tJPlacementListener);
        }
        return tJPlacement;
    }

    public static TJPrivacyPolicy getPrivacyPolicy() {
        y9.f2836b.getClass();
        return TJPrivacyPolicy.getInstance();
    }

    public static String getSupportURL() {
        if (y9.f2836b.a("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(null);
        }
        return null;
    }

    public static TJSegment getUserSegment() {
        y9.f2836b.getClass();
        return TJUserParameters.getInstance().getUserSegment();
    }

    public static Set<String> getUserTags() {
        HashSet hashSet;
        y9.f2836b.getClass();
        v1 v1Var = v1.m;
        if (!v1Var.a()) {
            return new HashSet();
        }
        d3 d3Var = v1Var.e;
        synchronized (d3Var) {
            hashSet = new HashSet(d3Var.c.v);
        }
        return hashSet;
    }

    @Deprecated
    public static String getUserToken() {
        y9.f2836b.getClass();
        return TapjoyConnectCore.getUserToken();
    }

    public static String getVersion() {
        y9.f2836b.getClass();
        return "13.3.0";
    }

    public static boolean isConnected() {
        return y9.f2836b.a;
    }

    @Deprecated
    public static boolean isLimitedConnected() {
        return false;
    }

    @Deprecated
    public static boolean isPushNotificationDisabled() {
        return y9.f2836b.a();
    }

    @Deprecated
    public static synchronized boolean limitedConnect(Context context, String str, TJConnectListener tJConnectListener) {
        tJConnectListener.onConnectFailure(1, TapjoyErrorMessage.API_NOT_AVAILABLE_ERROR);
        return false;
    }

    public static void loadSharedLibrary() {
        try {
            System.loadLibrary("tapjoy");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void onActivityStart(Activity activity) {
        TapjoyUtil.runOnMainThread(new w9(activity));
    }

    public static void onActivityStop(Activity activity) {
        TapjoyUtil.runOnMainThread(new x9(activity));
    }

    public static void optOutAdvertisingID(Context context, boolean z) {
        y9.f2836b.getClass();
        TapjoyConnectCore.optOutAdvertisingID(context, z);
    }

    public static void removeUserTag(String str) {
        HashSet hashSet;
        HashSet hashSet2;
        y9.f2836b.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v1 v1Var = v1.m;
        if (v1Var.a()) {
            d3 d3Var = v1Var.e;
            synchronized (d3Var) {
                hashSet = new HashSet(d3Var.c.v);
            }
            hashSet2 = hashSet;
        } else {
            hashSet2 = new HashSet();
        }
        if (hashSet2.remove(str)) {
            v1Var.a(hashSet2);
        }
    }

    public static void setActivity(Activity activity) {
        y9.f2836b.getClass();
        if (activity != null) {
            com.tapjoy.internal.t.c.a(activity);
        } else {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Cannot set activity to NULL"));
        }
    }

    public static void setCustomParameter(String str) {
        y9.f2836b.getClass();
        TapjoyConnectCore.setCustomParameter(str);
    }

    public static void setDebugEnabled(boolean z) {
        y9.f2836b.getClass();
        TapjoyLog.setDebugEnabled(z);
    }

    @Deprecated
    public static void setDeviceToken(String str) {
        String str2;
        y9.f2836b.getClass();
        v1 v1Var = v1.m;
        synchronized (v1Var) {
            if (v1Var.i) {
                if (str == null && (str2 = v1Var.k) != null) {
                    str = str2;
                }
                v1Var.k = null;
                if (str != null) {
                    v1Var.a(str);
                }
            } else if (str != null) {
                v1Var.k = str;
            }
        }
    }

    public static void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        ba baVar = y9.f2836b;
        if (baVar.e == null || !baVar.a("setEarnedCurrencyListener")) {
            return;
        }
        baVar.e.setEarnedCurrencyListener(tJEarnedCurrencyListener);
    }

    public static void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        y9.f2836b.getClass();
        v1.m.getClass();
        if (gLSurfaceView != null) {
            com.tapjoy.internal.h.a(gLSurfaceView);
        }
    }

    @Deprecated
    public static void setInstallReferrer(Context context, String str) {
        String strB;
        y9.f2836b.getClass();
        v1 v1Var = v1.m;
        if (v1Var.d == null) {
            v1Var.b(context);
        }
        Context context2 = v1Var.d;
        if (str != null) {
            v1Var.b(context2);
            d3 d3Var = v1Var.e;
            synchronized (d3Var) {
                strB = d3Var.e.d.b();
            }
            if (TextUtils.isEmpty(strB)) {
                v1Var.e.a(str);
                if (str.length() > 0) {
                    p1 p1Var = v1Var.f;
                    p1Var.getClass();
                    p1Var.a(p1Var.a(r1.APP, TapjoyConstants.TJC_REFERRER));
                }
            }
        }
    }

    public static void setMaxLevel(int i) {
        y9.f2836b.getClass();
        TJUserParameters.getInstance().setUserMaxLevel(i);
    }

    @Deprecated
    public static void setPushNotificationDisabled(boolean z) {
        j2 j2Var;
        y9.f2836b.getClass();
        v1 v1Var = v1.m;
        if (v1Var.a() && v1Var.e.a(z) && v1Var.i) {
            String strA = null;
            if (TextUtils.isEmpty(null)) {
                return;
            }
            if (v1Var.k == null) {
                Context context = v1Var.d;
                synchronized (j2.class) {
                    if (j2.c == null) {
                        j2.c = new j2(context);
                    }
                    j2Var = j2.c;
                }
                i2 i2Var = j2Var.f2763b;
                Context context2 = j2Var.a;
                i2Var.getClass();
                strA = r9.a(context2.getApplicationContext().getSharedPreferences("fiverocks", 0).getString("gcm.regId", ""));
            }
            v1Var.b(strA);
        }
    }

    @Deprecated
    public static void setReceiveRemoteNotification(Context context, Map<String, String> map) {
        j2 j2Var;
        y9.f2836b.getClass();
        v1 v1Var = v1.m;
        if (v1Var.d == null) {
            v1Var.b(context);
        }
        Context context2 = v1Var.d;
        synchronized (j2.class) {
            if (j2.c == null) {
                j2.c = new j2(context2);
            }
            j2Var = j2.c;
        }
        Context context3 = v1Var.d;
        j2Var.getClass();
        j2.a(context3, map);
    }

    @Deprecated
    public static void setUserCohortVariable(int i, String str) {
    }

    @Deprecated
    public static void setUserFriendCount(int i) {
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        String strTrim;
        ba baVar = y9.f2836b;
        if (!baVar.b("setUserID")) {
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDFailure(baVar.d);
                return;
            }
            return;
        }
        TapjoyConnectCore.setUserID(str, tJSetUserIDListener);
        v1 v1Var = v1.m;
        if (v1Var.a()) {
            if (str == null || str.length() == 0 || (strTrim = str.trim()) == null || strTrim.length() == 0) {
                strTrim = null;
            }
            v1Var.e.b(strTrim);
        }
    }

    public static void setUserLevel(int i) {
        y9.f2836b.getClass();
        v1 v1Var = v1.m;
        if (v1Var.a()) {
            v1Var.e.a(i > -1 ? Integer.valueOf(i) : null);
        }
    }

    public static void setUserSegment(TJSegment tJSegment) {
        y9.f2836b.getClass();
        TJUserParameters.getInstance().setUserSegment(tJSegment);
    }

    public static void setUserTags(Set<String> set) {
        y9.f2836b.getClass();
        v1.m.a(set);
    }

    @Deprecated
    public static void setVideoListener(TJVideoListener tJVideoListener) {
        if (y9.f2836b.b("setVideoListener")) {
            TJAdUnit.J = tJVideoListener;
        }
    }

    public static void spendCurrency(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        ba baVar = y9.f2836b;
        if (!baVar.a("spendCurrency")) {
            if (tJSpendCurrencyListener != null) {
                tJSpendCurrencyListener.onSpendCurrencyResponseFailure("Tapjoy SDK is not connected");
            }
        } else {
            TJCurrency tJCurrency = baVar.e;
            if (tJCurrency != null) {
                tJCurrency.spendCurrency(i, tJSpendCurrencyListener);
            }
        }
    }

    public static void startSession() {
        if (y9.f2836b.b("startSession")) {
            com.tapjoy.internal.e.a();
            TapjoyConnectCore.getInstance().appResume();
            v1 v1Var = v1.m;
            if (v1Var.b() && v1Var.d()) {
                com.tapjoy.internal.q.a(null);
            }
        }
    }

    @Deprecated
    public static void trackEvent(String str) {
    }

    @Deprecated
    public static void trackEvent(String str, long j) {
    }

    @Deprecated
    public static void trackEvent(String str, String str2, long j) {
    }

    @Deprecated
    public static void trackEvent(String str, String str2, String str3, String str4) {
    }

    @Deprecated
    public static void trackEvent(String str, String str2, String str3, String str4, long j) {
    }

    @Deprecated
    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j) {
    }

    @Deprecated
    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
    }

    @Deprecated
    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
    }

    @Deprecated
    public static void trackEvent(String str, String str2, String str3, String str4, Map<String, Long> map) {
    }

    @Deprecated
    public static void trackPurchase(String str, String str2) {
        y9.f2836b.getClass();
        t1.a(str, null, null, str2);
    }

    public static boolean connect(Context context, String str, Hashtable<String, ?> hashtable) {
        return y9.f2836b.f.a(context, str, hashtable, null);
    }

    public static String getSupportURL(String str) {
        if (y9.f2836b.a("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0023  */
    public static void trackPurchase(String str, String str2, double d, String str3) {
        String str4;
        y9.f2836b.getClass();
        v1 v1Var = v1.m;
        if (v1Var.b()) {
            String str5 = null;
            if (str == null || str.length() == 0) {
                str4 = null;
            } else {
                String strTrim = str.trim();
                if (strTrim.length() == 0) {
                    str4 = null;
                } else {
                    str4 = strTrim;
                }
            }
            if (str4 == null) {
                return;
            }
            if (str2 != null && str2.length() != 0) {
                String strTrim2 = str2.trim();
                if (strTrim2.length() != 0) {
                    str5 = strTrim2;
                }
            }
            if (str5 != null && str5.length() == 3) {
                v1Var.f.a(str4, str5.toUpperCase(Locale.US), d, null, null, com.tapjoy.internal.u.a(str3));
            }
        }
    }

    public static synchronized boolean connect(Context context, String str, Hashtable<String, ?> hashtable, TJConnectListener tJConnectListener) {
        return y9.f2836b.f.a(context, str, hashtable, tJConnectListener);
    }

    @Deprecated
    public static void setUserID(String str) {
        setUserID(str, null);
    }

    public static void trackPurchase(String str, String str2, String str3, String str4) {
        y9.f2836b.getClass();
        t1.a(str, str2, str3, str4);
    }
}
