package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tapjoy.internal.a3;
import com.tapjoy.internal.a7;
import com.tapjoy.internal.b4;
import com.tapjoy.internal.c3;
import com.tapjoy.internal.ca;
import com.tapjoy.internal.d3;
import com.tapjoy.internal.d4;
import com.tapjoy.internal.e7;
import com.tapjoy.internal.f1;
import com.tapjoy.internal.i8;
import com.tapjoy.internal.k3;
import com.tapjoy.internal.l8;
import com.tapjoy.internal.na;
import com.tapjoy.internal.pa;
import com.tapjoy.internal.ra;
import com.tapjoy.internal.t6;
import com.tapjoy.internal.v1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyConnectCore {
    public static Double A0 = null;
    public static Long B0 = null;
    public static final String BEACON = "sdk_beacons";
    public static final String BEACON_ENABLED = "enabled";
    public static Integer C0 = null;
    public static Integer D0 = null;
    public static Integer E0 = null;
    public static String F0 = null;
    public static String G0 = null;
    public static String H0 = null;
    public static boolean U = false;
    public static PackageManager V = null;
    public static TapjoyGpsHelper W = null;
    public static boolean a0 = false;
    public static Context d = null;
    public static TapjoyConnectCore e = null;
    public static TapjoyURLConnection f = null;
    public static TJConnectListener g = null;
    public static String g0 = null;
    public static TJSetUserIDListener h = null;
    public static String h0 = null;
    public static boolean i = false;
    public static String i0 = null;
    public static boolean j = false;
    public static String j0;
    public static Integer k0;
    public static String l0;
    public static Long m0;
    public static String n0;
    public static Integer o0;
    public static HashSet p0;
    public static Integer q0;
    public static Integer r0;
    public static Integer s0;
    public static Long t0;
    public static Long u0;
    public static Long v0;
    public static Long w0;
    public static String x0;
    public static Integer y0;
    public static Double z0;
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2710b = false;
    public final ExecutorService c = Executors.newSingleThreadExecutor();
    public static final Vector k = new Vector(Arrays.asList(TapjoyConstants.dependencyClassNames));
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static String q = "";
    public static String r = "";
    public static String s = "";
    public static String t = "";
    public static String u = "";
    public static String v = "";
    public static String w = "";
    public static int x = 1;
    public static float y = 1.0f;
    public static int z = 1;
    public static String A = "";
    public static String B = "";
    public static String C = "";
    public static String D = "";
    public static String E = "";
    public static String F = "";
    public static String G = "";
    public static String H = "";
    public static String I = "";
    public static String J = "";
    public static String K = "native";
    public static String L = "";
    public static String M = "";
    public static boolean N = false;
    public static String O = "";
    public static String P = "";
    public static String Q = "";
    public static String R = "";
    public static Map S = new HashMap();
    public static long T = 0;
    public static int X = 0;
    public static int Y = 0;
    public static String Z = "";
    public static String b0 = "";
    public static String c0 = "";
    public static String d0 = "";
    public static Hashtable e0 = TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS;
    public static final ConcurrentHashMap f0 = new ConcurrentHashMap();
    public static boolean I0 = false;

    public class PPAThread implements Runnable {
        public final Map a;

        public PPAThread(Map<String, String> map) {
            this.a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = TapjoyConnectCore.f.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map<String, String>) null, (Map<String, String>) null, this.a).response;
            if (str == null) {
                return;
            }
            TapjoyConnectCore.this.getClass();
            try {
                try {
                    d4 d4VarA = b4.a(str);
                    if (!d4VarA.e()) {
                        d4VarA.close();
                        Logger logger = l8.a;
                        TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Completed Pay-Per-Action call failed."));
                    } else {
                        d4VarA.r();
                        TapjoyLog.d("TapjoyConnect", "Successfully sent completed Pay-Per-Action to Tapjoy server.");
                        d4VarA.close();
                        Logger logger2 = l8.a;
                    }
                } catch (IOException e) {
                    TapjoyLog.v("TapjoyConnect", e.getMessage());
                    l8.a(null);
                } catch (RuntimeException e2) {
                    TapjoyLog.v("TapjoyConnect", e2.getMessage());
                    l8.a(null);
                }
            } catch (Throwable th) {
                l8.a(null);
                throw th;
            }
        }
    }

    public static void a(int i2, String str) {
        if (!TextUtils.isEmpty(J)) {
            v1.m.a(d, J, I);
        }
        TapjoyUtil.runOnMainThread(new f0(i2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        d0 = str;
        this.c.execute(new Runnable() { // from class: com.tapjoy.-$$Lambda$9RuLSnNdykMkuElldqdDrHbJsng
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.completeConnectCall();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:30:0x01be  */
    /* JADX WARN: Code duplicated, block: B:41:0x01e5  */
    public static HashMap c() {
        String str;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        TapjoyUtil.safePut(map3, TapjoyConstants.TJC_PLUGIN, K, true);
        TapjoyUtil.safePut(map3, TapjoyConstants.TJC_SDK_TYPE, L, true);
        TapjoyUtil.safePut(map3, "app_id", t, true);
        TapjoyUtil.safePut(map3, TapjoyConstants.TJC_LIBRARY_VERSION, v, true);
        TapjoyUtil.safePut(map3, TapjoyConstants.TJC_LIBRARY_REVISION, TapjoyRevision.GIT_REVISION, true);
        TapjoyUtil.safePut(map3, TapjoyConstants.TJC_BRIDGE_VERSION, w, true);
        TapjoyUtil.safePut(map3, TapjoyConstants.TJC_APP_VERSION_NAME, u, true);
        map2.putAll(map3);
        HashMap map4 = new HashMap();
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_NAME, p, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_PLATFORM, C, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, s, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_MANUFACTURER, q, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_TYPE_NAME, r, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_SCREEN_LAYOUT_SIZE, "" + z, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_STORE_NAME, H, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_STORE_VIEW, String.valueOf(N), true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_CARRIER_NAME, D, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_CARRIER_COUNTRY_CODE, E, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_MOBILE_NETWORK_CODE, G, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_MOBILE_COUNTRY_CODE, F, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, Locale.getDefault().getCountry(), true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_LANGUAGE, Locale.getDefault().getLanguage(), true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_CONNECTION_TYPE, getConnectionType(), true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_CONNECTION_SUBTYPE, getConnectionSubType(), true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, "" + x, true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_VOLUME, TapjoyUtil.getVolume(d));
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_THEME, TapjoyUtil.getTheme(d), true);
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_DEVICE_SCREEN_BRIGHTNESS, TapjoyUtil.getScreenBrightness(d));
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_AVAILABLE_DISK_SPACE, TapjoyUtil.getAvailableDiskSpace());
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_TOTAL_DISK_SPACE, TapjoyUtil.getTotalDiskSpace());
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_BATTERY_LEVEL, Float.valueOf(TJDeviceInfo.getBatteryLevel(d)));
        TapjoyUtil.safePut(map4, TapjoyConstants.TJC_BOOT_UPTIME, Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime())));
        map2.putAll(map4);
        HashMap map5 = new HashMap();
        String str2 = Z;
        int i2 = 0;
        if (str2 != null && str2.length() > 0) {
            if (W.isAdvertisingIdAllowed()) {
                TapjoyUtil.safePut(map5, TapjoyConstants.TJC_ADVERTISING_ID, Z, true);
            }
            TapjoyUtil.safePut(map5, TapjoyConstants.TJC_AD_TRACKING_ENABLED, String.valueOf(a0), true);
        }
        TapjoyUtil.safePut(map5, TapjoyConstants.TJC_ADVERTISING_ID_OPTOUT, String.valueOf(!W.isAdvertisingIdAllowed()), true);
        if (!TextUtils.isEmpty(d0)) {
            TapjoyUtil.safePut(map5, TapjoyConstants.TJC_APP_SET_ID, d0, true);
        }
        if (getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).equals("true")) {
            String str3 = Z;
            if (str3 != null && str3.length() > 0) {
                if (!((!W.isGooglePlayServicesAvailable() && W.isGooglePlayManifestConfigured()) || getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) == null || !getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true"))) {
                    TapjoyUtil.safePut(map5, TapjoyConstants.TJC_ANDROID_ID, l, true);
                }
            } else {
                TapjoyUtil.safePut(map5, TapjoyConstants.TJC_ANDROID_ID, l, true);
            }
        } else {
            if (!((!W.isGooglePlayServicesAvailable() && W.isGooglePlayManifestConfigured()) || getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) == null || !getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true"))) {
                TapjoyUtil.safePut(map5, TapjoyConstants.TJC_ANDROID_ID, l, true);
            }
        }
        TapjoyUtil.safePut(map5, TapjoyConstants.TJC_INSTALL_ID, n, true);
        TapjoyUtil.safePut(map5, TapjoyConstants.TJC_TEST_ID, o, true);
        TapjoyUtil.safePut(map5, TapjoyConstants.TJC_USER_ID, A, true);
        TapjoyUtil.safePut(map5, TapjoyConstants.TJC_ADVERTISING_ID_CHECK_DISABLED, b0, true);
        TapjoyUtil.safePut(map5, TapjoyConstants.TJC_LEGACY_ID_FALLBACK_ALLOWED, c0, true);
        int i3 = X;
        if (i3 != 0) {
            TapjoyUtil.safePut(map5, TapjoyConstants.TJC_PACKAGED_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i3), true);
        }
        int i4 = Y;
        if (i4 != 0) {
            TapjoyUtil.safePut(map5, TapjoyConstants.TJC_DEVICE_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i4), true);
        }
        String str4 = m;
        if (str4 == null || str4.length() == 0 || System.currentTimeMillis() - T > TapjoyConstants.SESSION_ID_INACTIVITY_TIME) {
            String strSHA256 = null;
            TapjoyLog.i("TapjoyConnect", "generating sessionID...");
            try {
                strSHA256 = TapjoyUtil.SHA256((System.currentTimeMillis() / 1000) + t);
                T = System.currentTimeMillis();
            } catch (Exception e2) {
                TapjoyLog.e("TapjoyConnect", "unable to generate session id: " + e2.toString());
            }
            m = strSHA256;
        } else {
            T = System.currentTimeMillis();
        }
        TapjoyUtil.safePut(map5, "session_id", m, true);
        map2.putAll(map5);
        HashMap map6 = new HashMap();
        TapjoyUtil.safePut(map6, TapjoyConstants.TJC_APP_GROUP_ID, O, true);
        TapjoyUtil.safePut(map6, TapjoyConstants.TJC_STORE, P, true);
        TapjoyUtil.safePut(map6, TapjoyConstants.TJC_ANALYTICS_API_KEY, Q, true);
        TapjoyUtil.safePut(map6, TapjoyConstants.TJC_MANAGED_DEVICE_ID, R, true);
        map2.putAll(map6);
        TJPrivacyPolicy tJPrivacyPolicy = TJPrivacyPolicy.getInstance();
        tJPrivacyPolicy.getClass();
        HashMap map7 = new HashMap();
        TJStatus tJStatus = tJPrivacyPolicy.a;
        TJStatus tJStatus2 = TJStatus.UNKNOWN;
        if (tJStatus != tJStatus2 && tJStatus != null) {
            TapjoyUtil.safePut(map7, "gdpr", tJStatus.toString(), true);
        }
        TJStatus tJStatus3 = tJPrivacyPolicy.f2700b;
        if (tJStatus3 != tJStatus2 && tJStatus3 != null) {
            TapjoyUtil.safePut(map7, "cgdpr", tJStatus3.toString(), true);
        }
        TJStatus tJStatus4 = tJPrivacyPolicy.c;
        if (tJStatus4 != tJStatus2 && tJStatus4 != null) {
            TapjoyUtil.safePut(map7, "below_consent_age", tJStatus4.toString(), true);
        }
        if (!TextUtils.isEmpty(tJPrivacyPolicy.d) && (str = tJPrivacyPolicy.d) != null) {
            TapjoyUtil.safePut(map7, "us_privacy", str, true);
        }
        map2.putAll(map7);
        TJUserParameters tJUserParameters = TJUserParameters.getInstance();
        tJUserParameters.getClass();
        HashMap map8 = new HashMap();
        TJSegment tJSegment = tJUserParameters.e;
        if (tJSegment != null && tJSegment != TJSegment.UNKNOWN) {
            TapjoyUtil.safePut(map8, TapjoyConstants.TJC_USER_SEGMENT, tJSegment.toString(), true);
        }
        map2.putAll(map8);
        if (TapjoyCache.getInstance() != null && TapjoyCache.getInstance().getCachedOfferIDs() != null && TapjoyCache.getInstance().getCachedOfferIDs().length() > 0) {
            TapjoyUtil.safePut(map2, TapjoyConstants.TJC_CACHED_OFFERS, TapjoyCache.getInstance().getCachedOfferIDs(), true);
        }
        map.putAll(map2);
        HashMap map9 = new HashMap();
        g();
        HashMap map10 = new HashMap();
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_ANALYTICS_ID, g0, true);
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_PACKAGE_ID, h0, true);
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_PACKAGE_SIGN, i0, true);
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY, C0);
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH, D0);
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT, E0);
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_DEVICE_COUNTRY_SIM, F0, true);
        TapjoyUtil.safePut(map10, TapjoyConstants.TJC_DEVICE_TIMEZONE, G0, true);
        map9.putAll(map10);
        HashMap map11 = new HashMap();
        TapjoyUtil.safePut(map11, TapjoyConstants.TJC_PACKAGE_VERSION, j0, true);
        TapjoyUtil.safePut(map11, TapjoyConstants.TJC_PACKAGE_REVISION, k0);
        TapjoyUtil.safePut(map11, TapjoyConstants.TJC_INSTALLER, l0, true);
        if (TextUtils.isEmpty(H)) {
            TapjoyUtil.safePut(map11, TapjoyConstants.TJC_STORE_NAME, H0, true);
        }
        map9.putAll(map11);
        HashMap map12 = new HashMap();
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_INSTALLED, m0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_REFERRER, n0, true);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_USER_LEVEL, o0);
        Iterator it = p0.iterator();
        while (it.hasNext()) {
            TapjoyUtil.safePut(map12, "user_tags[" + i2 + "]", (String) it.next(), true);
            i2++;
        }
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY, q0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY, r0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_SESSION_TOTAL_COUNT, s0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_SESSION_TOTAL_LENGTH, t0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_SESSION_LAST_AT, u0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_SESSION_LAST_LENGTH, w0);
        if (v0 != null) {
            TapjoyUtil.safePut(map12, TapjoyConstants.TJC_SESSION_CURRENT_LENGTH, Long.valueOf(System.currentTimeMillis() - v0.longValue()));
        }
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_PURCHASE_CURRENCY, x0, true);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_PURCHASE_TOTAL_COUNT, y0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_PURCHASE_TOTAL_PRICE, z0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_PURCHASE_LAST_PRICE, A0);
        TapjoyUtil.safePut(map12, TapjoyConstants.TJC_PURCHASE_LAST_AT, B0);
        map9.putAll(map12);
        map.putAll(map9);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        b();
        new TJAppSetId().fetch(d, new TJTaskHandler() { // from class: com.tapjoy.-$$Lambda$TapjoyConnectCore$Fi3vjez-sTBSqM6IKiqZDZ7HAQw
            @Override // com.tapjoy.TJTaskHandler
            public final void onComplete(Object obj) {
                this.f$0.b((String) obj);
            }
        });
    }

    public static /* synthetic */ void e() {
        TJConnectListener tJConnectListener = g;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectSuccess();
        }
    }

    public static /* synthetic */ void f() {
        TJConnectListener tJConnectListener = g;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectSuccess();
        }
    }

    public static void g() {
        Context context = d;
        v1 v1Var = v1.m;
        v1Var.b(context);
        v1Var.e.c();
        c3 c3VarA = v1Var.e.a();
        a3 a3Var = c3VarA.c;
        g0 = a3Var.d;
        h0 = a3Var.n;
        i0 = a3Var.o;
        C0 = a3Var.i;
        D0 = a3Var.j;
        E0 = a3Var.k;
        F0 = a3Var.q;
        G0 = a3Var.m;
        com.tapjoy.internal.p pVar = c3VarA.d;
        j0 = pVar.c;
        k0 = pVar.d;
        l0 = pVar.e;
        H0 = pVar.f;
        ra raVar = c3VarA.e;
        m0 = raVar.c;
        n0 = raVar.d;
        o0 = raVar.u;
        p0 = new HashSet(raVar.v);
        q0 = raVar.e;
        r0 = raVar.f;
        s0 = raVar.h;
        t0 = raVar.i;
        u0 = raVar.j;
        v0 = raVar.k;
        w0 = raVar.l;
        x0 = raVar.m;
        y0 = raVar.n;
        z0 = raVar.o;
        A0 = raVar.q;
        B0 = raVar.p;
    }

    public static String getAndroidID() {
        return l;
    }

    public static String getAppID() {
        return t;
    }

    public static String getCarrierName() {
        return D;
    }

    public static String getConnectURL() {
        return TapjoyConfig.TJC_CONNECT_SERVICE_URL;
    }

    public static Context getContext() {
        return d;
    }

    public static String getCustomParameter() {
        return B;
    }

    public static float getDeviceScreenDensityScale() {
        return y;
    }

    public static Map<String, String> getGenericURLParams() {
        HashMap mapC = c();
        TapjoyUtil.safePut(mapC, "app_id", t, true);
        return mapC;
    }

    public static String getHostURL() {
        return getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL);
    }

    public static TapjoyConnectCore getInstance() {
        return e;
    }

    public static String getPlacementURL() {
        return getConnectFlagValue(TapjoyConnectFlag.PLACEMENT_URL);
    }

    public static String getRedirectDomain() {
        return M;
    }

    public static String getSecretKey() {
        return I;
    }

    public static String getSupportURL(String str) {
        if (str == null) {
            str = t;
        }
        return getHostURL() + "support_requests/new?currency_id=" + str + "&app_id=" + t + "&udid=" + R + "&language_code=" + Locale.getDefault().getLanguage();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006e A[Catch: Exception -> 0x00a3, TryCatch #0 {Exception -> 0x00a3, blocks: (B:3:0x0010, B:5:0x0024, B:10:0x002f, B:38:0x0084, B:11:0x0032, B:14:0x003a, B:19:0x0049, B:21:0x0051, B:37:0x007e, B:23:0x0059, B:25:0x005f, B:30:0x006e, B:32:0x0072, B:36:0x007b), top: B:44:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007b A[Catch: Exception -> 0x00a3, TryCatch #0 {Exception -> 0x00a3, blocks: (B:3:0x0010, B:5:0x0024, B:10:0x002f, B:38:0x0084, B:11:0x0032, B:14:0x003a, B:19:0x0049, B:21:0x0051, B:37:0x007e, B:23:0x0059, B:25:0x005f, B:30:0x006e, B:32:0x0072, B:36:0x007b), top: B:44:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x007e A[Catch: Exception -> 0x00a3, TryCatch #0 {Exception -> 0x00a3, blocks: (B:3:0x0010, B:5:0x0024, B:10:0x002f, B:38:0x0084, B:11:0x0032, B:14:0x003a, B:19:0x0049, B:21:0x0051, B:37:0x007e, B:23:0x0059, B:25:0x005f, B:30:0x006e, B:32:0x0072, B:36:0x007b), top: B:44:0x0010 }] */
    public static Map<String, String> getTimeStampAndVerifierParams() {
        String strSHA256;
        String str;
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            StringBuilder sbAppend = new StringBuilder().append(t).append(CertificateUtil.DELIMITER);
            String str3 = Z;
            boolean z2 = false;
            if (str3 != null && str3.length() > 0) {
                str2 = Z;
            } else {
                if (getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).equals("true")) {
                    str = l;
                    if (str != null && str.length() > 0) {
                        z2 = true;
                    }
                    if (z2) {
                        str2 = l;
                    } else {
                        TapjoyLog.e("TapjoyConnect", "Error -- no valid device identifier");
                        str2 = null;
                    }
                } else {
                    if ((W.isGooglePlayServicesAvailable() && W.isGooglePlayManifestConfigured()) || getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) == null || !getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true")) {
                        TapjoyLog.e("TapjoyConnect", "Error -- no valid device identifier");
                        str2 = null;
                    } else {
                        str = l;
                        if (str != null) {
                            z2 = true;
                        }
                        if (z2) {
                            str2 = l;
                        } else {
                            TapjoyLog.e("TapjoyConnect", "Error -- no valid device identifier");
                            str2 = null;
                        }
                    }
                }
            }
            strSHA256 = TapjoyUtil.SHA256(sbAppend.append(str2).append(CertificateUtil.DELIMITER).append(jCurrentTimeMillis).append(CertificateUtil.DELIMITER).append(I).toString());
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error in computing verifier value -- " + e2.toString()));
            strSHA256 = "";
        }
        HashMap map = new HashMap();
        TapjoyUtil.safePut(map, "timestamp", String.valueOf(jCurrentTimeMillis), true);
        TapjoyUtil.safePut(map, TapjoyConstants.TJC_VERIFIER, strSHA256, true);
        return map;
    }

    public static Map<String, String> getURLParams() {
        Map<String, String> genericURLParams = getGenericURLParams();
        genericURLParams.putAll(getTimeStampAndVerifierParams());
        return genericURLParams;
    }

    public static String getUserID() {
        return A;
    }

    public static String getUserToken() {
        Map map = S;
        if (map == null || map.isEmpty()) {
            return !TextUtils.isEmpty(A) ? R + CertificateUtil.DELIMITER + A : R;
        }
        Map map2 = S;
        HashMap map3 = new HashMap();
        for (String str : map2.keySet()) {
            TapjoyUtil.safePut(map3, str, String.valueOf(map2.get(str)), true);
        }
        if (!TextUtils.isEmpty(A)) {
            TapjoyUtil.safePut(map3, TapjoyConstants.TJC_TOKEN_PARAM_USER_ID, A, true);
        }
        return Base64.encodeToString(TapjoyUtil.convertURLParams((Map<String, String>) map3, false).getBytes(), 2);
    }

    public static boolean isConnected() {
        return U;
    }

    public static boolean isFullScreenViewOpen() {
        Iterator it = f0.values().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (iIntValue == 1 || iIntValue == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUnitTestMode() {
        return getConnectFlagValue("unit_test_mode") == "true";
    }

    public static boolean isViewOpen() {
        StringBuilder sb = new StringBuilder("isViewOpen: ");
        ConcurrentHashMap concurrentHashMap = f0;
        TapjoyLog.d("TapjoyConnect", sb.append(concurrentHashMap.size()).toString());
        return !concurrentHashMap.isEmpty();
    }

    public static void optOutAdvertisingID(Context context, boolean z2) {
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
            editorEdit.putBoolean(TapjoyConstants.PREF_OPTOUT_ADVERTISING_ID, z2);
            editorEdit.apply();
            if (Tapjoy.isConnected()) {
                boolean z3 = true;
                if (!z2) {
                    String str = Z;
                    if (str != null && str.length() != 0) {
                        z3 = false;
                    }
                    if (z3 || Z.equals("00000000-0000-0000-0000-000000000000")) {
                        I0 = false;
                        new Thread(new h0()).start();
                        return;
                    }
                    return;
                }
                Z = "";
                TapjoyGpsHelper tapjoyGpsHelper = W;
                if (tapjoyGpsHelper != null) {
                    tapjoyGpsHelper.resetAdvertisingID();
                    v1 v1Var = v1.m;
                    String str2 = Z;
                    d3 d3Var = v1Var.e;
                    String strB = d3Var.e.u.b();
                    pa paVar = d3Var.c;
                    paVar.r = str2;
                    paVar.s = Boolean.TRUE;
                    d3Var.e.u.a(str2);
                    d3Var.e.v.a(true);
                    e7.d.countDown();
                    if (TextUtils.isEmpty(strB) || str2.equals(strB)) {
                        return;
                    }
                    a7.a(d3Var.e.f2768b, false);
                }
            }
        }
    }

    public static void requestTapjoyConnect(Context context, String str) throws TapjoyIntegrationException {
        requestTapjoyConnect(context, str, null);
    }

    public static void setCustomParameter(String str) {
        B = str;
    }

    public static void setPlugin(String str) {
        K = str;
    }

    public static void setSDKType(String str) {
        L = str;
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        A = str;
        h = tJSetUserIDListener;
        TapjoyLog.d("TapjoyConnect", "URL parameters: " + getURLParams());
        new Thread(new g0()).start();
    }

    public static void setViewShowing(boolean z2) {
        if (z2) {
            f0.put("", 1);
        } else {
            f0.clear();
        }
    }

    public static void viewDidClose(String str) {
        TapjoyLog.d("TapjoyConnect", "viewDidClose: " + str);
        f0.remove(str);
        k3.e.notifyObservers();
    }

    public static void viewWillOpen(String str, int i2) {
        TapjoyLog.d("TapjoyConnect", "viewWillOpen: " + str);
        f0.put(str, Integer.valueOf(i2));
    }

    public void actionComplete(String str) {
        TapjoyLog.i("TapjoyConnect", "actionComplete: " + str);
        HashMap mapC = c();
        TapjoyUtil.safePut(mapC, "app_id", str, true);
        mapC.putAll(getTimeStampAndVerifierParams());
        TapjoyLog.d("TapjoyConnect", "PPA URL parameters: " + mapC);
        this.c.execute(new PPAThread(mapC));
    }

    public void appPause() {
        this.a = true;
    }

    public void appResume() {
        if (this.a) {
            TapjoyLog.i("TapjoyConnect", "generating sessionID...");
            try {
                TapjoyUtil.SHA256((System.currentTimeMillis() / 1000) + t);
                T = System.currentTimeMillis();
            } catch (Exception e2) {
                TapjoyLog.e("TapjoyConnect", "unable to generate session id: " + e2.toString());
            }
            this.a = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0070  */
    public void completeConnectCall() {
        boolean z2;
        TapjoyLog.d("TapjoyConnect", "starting connect call...");
        String hostURL = getHostURL() != TapjoyConfig.TJC_SERVICE_URL ? getHostURL() : TapjoyConfig.TJC_CONNECT_SERVICE_URL;
        if (isConnected()) {
            z2 = false;
        } else {
            TapjoyAppSettings tapjoyAppSettings = TapjoyAppSettings.getInstance();
            String strSHA1 = t + u + v + Z + n;
            try {
                strSHA1 = TapjoyUtil.SHA1(strSHA1);
            } catch (Exception unused) {
            }
            String connectResult = tapjoyAppSettings.getConnectResult(strSHA1, na.a());
            if (connectResult == null || !a(connectResult, true)) {
                z2 = false;
            } else {
                TapjoyLog.i("TapjoyConnect", "Connect using stored connect result");
                U = true;
                TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.-$$Lambda$Rvsbb8AsVmn7vk7nQ6q3KpwITCM
                    @Override // java.lang.Runnable
                    public final void run() {
                        TapjoyConnectCore.e();
                    }
                });
                k3.a.notifyObservers();
                z2 = true;
            }
        }
        Map<String, String> uRLParams = getURLParams();
        uRLParams.putAll(TJUserParameters.getInstance().a());
        TapjoyHttpURLResponse responseFromURL = f.getResponseFromURL(hostURL + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map<String, String>) null, (Map<String, String>) null, uRLParams);
        if (responseFromURL == null || responseFromURL.statusCode != 200) {
            if (!z2) {
                if (responseFromURL != null) {
                    a(responseFromURL.statusCode, "Invalid response");
                } else {
                    a(3, "No response");
                }
            }
            k3.f2775b.notifyObservers(Boolean.FALSE);
            return;
        }
        if (!a(responseFromURL.response, false)) {
            if (!z2) {
                a(responseFromURL.statusCode, "Invalid response formatting");
            }
            k3.f2775b.notifyObservers(Boolean.FALSE);
            return;
        }
        TapjoyLog.i("TapjoyConnect", "Successfully connected to Tapjoy");
        U = true;
        for (Map.Entry<String, String> entry : getGenericURLParams().entrySet()) {
            TapjoyLog.d("TapjoyConnect", entry.getKey() + ": " + entry.getValue());
        }
        if (!z2) {
            TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.-$$Lambda$J7VFnr83uKxiJi-Im69XSzKiRwk
                @Override // java.lang.Runnable
                public final void run() {
                    TapjoyConnectCore.f();
                }
            });
            k3.a.notifyObservers();
        }
        k3.f2775b.notifyObservers(Boolean.TRUE);
    }

    public boolean isInitialized() {
        return this.f2710b;
    }

    public void release() {
        e = null;
        f = null;
        TapjoyLog.d("TapjoyConnect", "Releasing core static instance.");
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable<String, ?> hashtable) throws TapjoyIntegrationException {
        requestTapjoyConnect(context, str, hashtable, null);
    }

    public static String getConnectFlagValue(String str) {
        Hashtable hashtable = e0;
        return (hashtable == null || hashtable.get(str) == null) ? "" : e0.get(str).toString();
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable<String, ?> hashtable, TJConnectListener tJConnectListener) throws TapjoyIntegrationException {
        try {
            com.tapjoy.internal.m mVar = new com.tapjoy.internal.m(str);
            if (mVar.f2780b == 1) {
                t = mVar.c;
                I = mVar.d;
                J = mVar.e;
                if (hashtable != null) {
                    e0.putAll(hashtable);
                    t6 t6Var = ca.c.a;
                    t6Var.getClass();
                    HashMap map = new HashMap();
                    for (Map.Entry<String, ?> entry : hashtable.entrySet()) {
                        String key = (String) t6.f.get(entry.getKey());
                        if (key == null) {
                            key = entry.getKey();
                        }
                        t6Var.c.a.remove(key);
                        map.put(key, entry.getValue());
                    }
                    t6Var.d.a = map;
                    t6Var.setChanged();
                }
                v1 v1Var = v1.m;
                v1Var.b(context);
                v1Var.h = str;
                g = tJConnectListener;
                if (e == null) {
                    e = new TapjoyConnectCore();
                }
                TapjoyConnectCore tapjoyConnectCore = e;
                tapjoyConnectCore.getClass();
                try {
                    a(context);
                    tapjoyConnectCore.a();
                    tapjoyConnectCore.f2710b = true;
                    return;
                } catch (TapjoyIntegrationException e2) {
                    TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e2.getMessage()));
                    a(1, e2.getMessage());
                    k3.f2775b.notifyObservers(Boolean.FALSE);
                    return;
                } catch (TapjoyException e3) {
                    TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e3.getMessage()));
                    a(2, e3.getMessage());
                    k3.f2775b.notifyObservers(Boolean.FALSE);
                    return;
                }
            }
            throw new IllegalArgumentException("The given API key was not for Android.");
        } catch (IllegalArgumentException e4) {
            throw new TapjoyIntegrationException(e4.getMessage());
        }
    }

    public static void b() {
        if (I0) {
            return;
        }
        try {
            W.loadAdvertisingId(!(getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).equals("true")));
            if (W.isGooglePlayServicesAvailable() && W.isGooglePlayManifestConfigured()) {
                Y = W.getDeviceGooglePlayServicesVersion();
                X = W.getPackagedGooglePlayServicesVersion();
            }
            if (W.isAdIdAvailable()) {
                a0 = W.isAdTrackingEnabled();
                Z = W.getAdvertisingId();
                v1 v1Var = v1.m;
                String str = Z;
                boolean z2 = !a0;
                d3 d3Var = v1Var.e;
                String strB = d3Var.e.u.b();
                pa paVar = d3Var.c;
                paVar.r = str;
                paVar.s = Boolean.valueOf(z2);
                d3Var.e.u.a(str);
                d3Var.e.v.a(z2);
                e7.d.countDown();
                if (!TextUtils.isEmpty(strB) && !str.equals(strB)) {
                    a7.a(d3Var.e.f2768b, false);
                }
            }
            I0 = true;
        } catch (Exception e2) {
            TapjoyLog.i("TapjoyConnect", "Error fetching advertising id: " + e2.toString());
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0067 A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:3:0x0008, B:5:0x001d, B:10:0x0028, B:39:0x007e, B:11:0x002b, B:14:0x0033, B:19:0x0042, B:21:0x004a, B:38:0x0078, B:23:0x0052, B:25:0x0058, B:30:0x0067, B:32:0x006b, B:37:0x0075), top: B:44:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075 A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:3:0x0008, B:5:0x001d, B:10:0x0028, B:39:0x007e, B:11:0x002b, B:14:0x0033, B:19:0x0042, B:21:0x004a, B:38:0x0078, B:23:0x0052, B:25:0x0058, B:30:0x0067, B:32:0x006b, B:37:0x0075), top: B:44:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0078 A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:3:0x0008, B:5:0x001d, B:10:0x0028, B:39:0x007e, B:11:0x002b, B:14:0x0033, B:19:0x0042, B:21:0x004a, B:38:0x0078, B:23:0x0052, B:25:0x0058, B:30:0x0067, B:32:0x006b, B:37:0x0075), top: B:44:0x0008 }] */
    public static String getAwardCurrencyVerifier(long j2, int i2, String str) {
        String str2;
        String str3;
        try {
            StringBuilder sbAppend = new StringBuilder().append(t).append(CertificateUtil.DELIMITER);
            String str4 = Z;
            boolean z2 = true;
            if (str4 != null && str4.length() > 0) {
                str3 = Z;
            } else {
                if (!(getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).equals("true"))) {
                    if (!((W.isGooglePlayServicesAvailable() && W.isGooglePlayManifestConfigured()) || getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) == null || !getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true"))) {
                        str2 = l;
                        if (str2 != null) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            str3 = l;
                        } else {
                            TapjoyLog.e("TapjoyConnect", "Error -- no valid device identifier");
                            str3 = null;
                        }
                    } else {
                        TapjoyLog.e("TapjoyConnect", "Error -- no valid device identifier");
                        str3 = null;
                    }
                } else {
                    str2 = l;
                    if (str2 != null || str2.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        str3 = l;
                    } else {
                        TapjoyLog.e("TapjoyConnect", "Error -- no valid device identifier");
                        str3 = null;
                    }
                }
            }
            return TapjoyUtil.SHA256(sbAppend.append(str3).append(CertificateUtil.DELIMITER).append(j2).append(CertificateUtil.DELIMITER).append(I).append(CertificateUtil.DELIMITER).append(i2).append(CertificateUtil.DELIMITER).append(str).toString());
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error in computing awardCurrencyVerifier -- " + e2.toString()));
            return "";
        }
    }

    public static String getConnectionSubType() {
        String subtypeName = "";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            subtypeName = connectivityManager.getActiveNetworkInfo().getSubtypeName();
            TapjoyLog.d("TapjoyConnect", "connection_sub_type: " + subtypeName);
            return subtypeName;
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", "getConnectionSubType error: " + e2.toString());
            return subtypeName;
        }
    }

    public static String getConnectionType() {
        String str = "";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.getSystemService("connectivity");
            if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                int type = connectivityManager.getActiveNetworkInfo().getType();
                str = (type == 1 || type == 6) ? TapjoyConstants.TJC_CONNECTION_TYPE_WIFI : TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE;
                TapjoyLog.d("TapjoyConnect", "connectivity: " + connectivityManager.getActiveNetworkInfo().getType());
                TapjoyLog.d("TapjoyConnect", "connection_type: ".concat(str));
            }
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", "getConnectionType error: " + e2.toString());
        }
        return str;
    }

    public final void a() {
        this.c.execute(new Runnable() { // from class: com.tapjoy.-$$Lambda$TapjoyConnectCore$aFXVP5Qgzhv7kna_UwHwAk1heeA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static void a(Context context) throws TapjoyException {
        d = context;
        V = context.getPackageManager();
        TJPrivacyPolicy.getInstance().a(context);
        TJUserParameters.getInstance().setContext(context);
        ca.c.a(context);
        W = new TapjoyGpsHelper(d);
        if (f == null) {
            f = new TapjoyURLConnection();
        }
        if (e0 == null) {
            e0 = new Hashtable();
        }
        try {
            PackageManager packageManager = V;
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(d.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    for (String str : TapjoyConnectFlag.FLAG_ARRAY) {
                        String string = applicationInfo.metaData.getString("tapjoy." + str);
                        if (string != null) {
                            TapjoyLog.d("TapjoyConnect", "Found manifest flag: " + str + ", " + string);
                            if ((str.equals(TapjoyConnectFlag.SERVICE_URL) || str.equals(TapjoyConnectFlag.PLACEMENT_URL)) && !string.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                                string = string.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            }
                            e0.put(str, string);
                        }
                    }
                    TapjoyLog.d("TapjoyConnect", "Metadata successfully loaded");
                } else {
                    TapjoyLog.d("TapjoyConnect", "No metadata present.");
                }
            }
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error reading manifest meta-data -- " + e2.toString()));
        }
        int identifier = d.getResources().getIdentifier("raw/tapjoy_config", null, d.getPackageName());
        if (identifier != 0) {
            try {
                Properties properties = new Properties();
                properties.load(d.getResources().openRawResource(identifier));
                Enumeration enumerationKeys = properties.keys();
                while (enumerationKeys.hasMoreElements()) {
                    try {
                        String str2 = (String) enumerationKeys.nextElement();
                        String strConcat = (String) properties.get(str2);
                        if ((str2.equals(TapjoyConnectFlag.SERVICE_URL) || str2.equals(TapjoyConnectFlag.PLACEMENT_URL)) && !strConcat.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                            strConcat = strConcat.concat(RemoteSettings.FORWARD_SLASH_STRING);
                        }
                        e0.put(str2, strConcat);
                    } catch (ClassCastException unused) {
                        TapjoyLog.e("TapjoyConnect", "Error parsing configuration properties in tapjoy_config.txt");
                    }
                }
            } catch (Exception unused2) {
            }
        }
        if (TextUtils.isEmpty(getConnectFlagValue("unit_test_mode"))) {
            try {
                List listAsList = Arrays.asList(V.getPackageInfo(d.getPackageName(), 1).activities);
                if (listAsList != null) {
                    Iterator it = listAsList.iterator();
                    while (it.hasNext()) {
                        a((ActivityInfo) it.next());
                    }
                }
                Vector vector = k;
                if (vector.size() != 0) {
                    if (vector.size() == 1) {
                        throw new TapjoyIntegrationException("Missing " + vector.size() + " dependency class in manifest: " + vector.toString());
                    }
                    throw new TapjoyIntegrationException("Missing " + vector.size() + " dependency classes in manifest: " + vector.toString());
                }
                Vector vector2 = new Vector();
                for (String str3 : TapjoyConstants.dependencyPermissions) {
                    if (!(V.checkPermission(str3, d.getPackageName()) == 0)) {
                        vector2.add(str3);
                    }
                }
                if (vector2.size() != 0) {
                    if (vector2.size() == 1) {
                        throw new TapjoyIntegrationException("Missing 1 permission in manifest: " + vector2.toString());
                    }
                    throw new TapjoyIntegrationException("Missing " + vector2.size() + " permissions in manifest: " + vector2.toString());
                }
                Vector vector3 = new Vector();
                if (vector3.size() != 0) {
                    if (vector3.size() == 1) {
                        TapjoyLog.w("TapjoyConnect", "WARNING -- " + vector3.toString() + " permission was not found in manifest. The exclusion of this permission could cause problems.");
                    } else {
                        TapjoyLog.w("TapjoyConnect", "WARNING -- " + vector3.toString() + " permissions were not found in manifest. The exclusion of these permissions could cause problems.");
                    }
                }
                try {
                    TJAdUnitJSBridge.class.getMethod(TJAdUnitConstants.String.CLOSE_REQUESTED, Boolean.class);
                    if (getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) != null && getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true")) {
                        TapjoyLog.i("TapjoyConnect", "Skipping integration check for Google Play Services and Advertising ID. Do this only if you do not have access to Google Play Services.");
                    } else {
                        W.checkGooglePlayIntegration();
                    }
                } catch (NoSuchMethodException unused3) {
                    throw new TapjoyIntegrationException("Try configuring Proguard or other code obfuscators to ignore com.tapjoy classes. Visit http://dev.tapjoy.comfor more information.");
                }
            } catch (Exception unused4) {
                throw new TapjoyIntegrationException("Error while getting package info.");
            }
        }
        String strB = f1.b(d);
        l = strB;
        if (strB != null) {
            l = strB.toLowerCase();
        }
        try {
            u = V.getPackageInfo(d.getPackageName(), 0).versionName;
            r = "android";
            C = "android";
            p = Build.MODEL;
            q = Build.MANUFACTURER;
            s = Build.VERSION.RELEASE;
            v = "13.3.0";
            w = TapjoyConstants.TJC_BRIDGE_VERSION_NUMBER;
            try {
                TapjoyDisplayMetricsUtil tapjoyDisplayMetricsUtil = new TapjoyDisplayMetricsUtil(d);
                x = tapjoyDisplayMetricsUtil.getScreenDensityDPI();
                y = tapjoyDisplayMetricsUtil.getScreenDensityScale();
                z = tapjoyDisplayMetricsUtil.getScreenLayoutSize();
            } catch (Exception e3) {
                TapjoyLog.e("TapjoyConnect", "Error getting screen density/dimensions/layout: " + e3.toString());
            }
            TelephonyManager telephonyManager = (TelephonyManager) d.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    D = telephonyManager.getNetworkOperatorName();
                    E = telephonyManager.getNetworkCountryIso();
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (networkOperator != null && (networkOperator.length() == 5 || networkOperator.length() == 6)) {
                        F = networkOperator.substring(0, 3);
                        G = networkOperator.substring(3);
                    }
                } catch (SecurityException unused5) {
                    TapjoyLog.i("TapjoyConnect", "Error accessing network operator info");
                }
            }
            n = f1.c(d);
            o = f1.d(d);
            TapjoyLog.i("TapjoyConnect", "Tapjoy device test id: " + o);
            if (getConnectFlagValue(TapjoyConnectFlag.STORE_NAME) != null && getConnectFlagValue(TapjoyConnectFlag.STORE_NAME).length() > 0) {
                H = getConnectFlagValue(TapjoyConnectFlag.STORE_NAME);
                if (!new ArrayList(Arrays.asList(TapjoyConnectFlag.STORE_ARRAY)).contains(H)) {
                    TapjoyLog.w("TapjoyConnect", "Warning -- undefined STORE_NAME: " + H);
                }
            }
            try {
                N = a(H);
            } catch (Exception e4) {
                TapjoyLog.e("TapjoyConnect", "Error trying to detect store intent on devicee: " + e4.toString());
            }
            g();
            if (getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).length() > 0) {
                c0 = getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK);
            }
            if (getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) != null && getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).length() > 0) {
                b0 = getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK);
            }
            if (getConnectFlagValue(TapjoyConnectFlag.USER_ID) != null && getConnectFlagValue(TapjoyConnectFlag.USER_ID).length() > 0) {
                TapjoyLog.i("TapjoyConnect", "Setting userID to: " + getConnectFlagValue(TapjoyConnectFlag.USER_ID));
                setUserID(getConnectFlagValue(TapjoyConnectFlag.USER_ID), null);
            }
            M = TapjoyUtil.getRedirectDomain(getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL));
            if (e0 != null) {
                TapjoyLog.i("TapjoyConnect", "Connect Flags:");
                TapjoyLog.i("TapjoyConnect", "--------------------");
                for (Map.Entry entry : e0.entrySet()) {
                    TapjoyLog.i("TapjoyConnect", "key: " + ((String) entry.getKey()) + ", value: " + Uri.encode(entry.getValue().toString()));
                }
                TapjoyLog.i("TapjoyConnect", "hostURL: [" + getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL) + "]");
                TapjoyLog.i("TapjoyConnect", "redirectDomain: [" + M + "]");
                TapjoyLog.i("TapjoyConnect", "--------------------");
            }
        } catch (PackageManager.NameNotFoundException e5) {
            throw new TapjoyException(e5.getMessage());
        }
    }

    public static void a(ActivityInfo activityInfo) throws TapjoyIntegrationException {
        Vector vector = k;
        if (vector.contains(activityInfo.name)) {
            int iIndexOf = vector.indexOf(activityInfo.name);
            try {
                Class.forName((String) vector.get(iIndexOf));
                Vector vector2 = new Vector();
                if ((activityInfo.configChanges & 128) != 128) {
                    vector2.add("orientation");
                }
                if ((activityInfo.configChanges & 32) != 32) {
                    vector2.add("keyboardHidden");
                }
                if (vector2.size() != 0) {
                    if (vector2.size() == 1) {
                        throw new TapjoyIntegrationException(vector2.toString() + " property is not specified in manifest configChanges for " + ((String) vector.get(iIndexOf)));
                    }
                    throw new TapjoyIntegrationException(vector2.toString() + " properties are not specified in manifest configChanges for " + ((String) vector.get(iIndexOf)));
                }
                if ((activityInfo.configChanges & 1024) != 1024) {
                    TapjoyLog.w("TapjoyConnect", "WARNING -- screenSize property is not specified in manifest configChanges for " + ((String) vector.get(iIndexOf)));
                }
                if (activityInfo.name.equals("com.tapjoy.TJAdUnitActivity") && (activityInfo.flags & 512) != 512) {
                    throw new TapjoyIntegrationException("'hardwareAccelerated' property not specified in manifest for " + ((String) vector.get(iIndexOf)));
                }
                vector.remove(iIndexOf);
            } catch (ClassNotFoundException unused) {
                throw new TapjoyIntegrationException("[ClassNotFoundException] Could not find dependency class " + ((String) k.get(iIndexOf)));
            }
        }
    }

    public static boolean a(String str, boolean z2) throws Throwable {
        d4 d4Var;
        d4 d4Var2;
        Map map;
        try {
            try {
                d4 d4VarA = b4.a(str);
                try {
                    try {
                        LinkedHashMap linkedHashMapK = d4VarA.k();
                        String str2 = (String) linkedHashMapK.get("override_service_url");
                        String str3 = "";
                        if (str2 == null) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            getInstance().getClass();
                            e0.put(TapjoyConnectFlag.SERVICE_URL, !str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING) ? str2.concat(RemoteSettings.FORWARD_SLASH_STRING) : str2);
                        }
                        if (linkedHashMapK.containsKey(BEACON) && (map = (Map) linkedHashMapK.get(BEACON)) != null && map.containsKey("enabled") && (map.get("enabled") instanceof Boolean)) {
                            if (Boolean.TRUE.equals((Boolean) map.get("enabled"))) {
                                i8.a(getURLParams(), map);
                            }
                        }
                        String str4 = (String) linkedHashMapK.get(TapjoyConstants.TJC_APP_GROUP_ID);
                        if (str4 == null) {
                            str4 = "";
                        }
                        String str5 = (String) linkedHashMapK.get(TapjoyConstants.TJC_STORE);
                        if (str5 == null) {
                            str5 = "";
                        }
                        String str6 = (String) linkedHashMapK.get(TapjoyConstants.TJC_ANALYTICS_API_KEY);
                        if (str6 == null) {
                            str6 = "";
                        }
                        Object obj = linkedHashMapK.get("user_token_config");
                        String str7 = (String) linkedHashMapK.get(TapjoyConstants.TJC_MANAGED_DEVICE_ID);
                        if (str7 != null) {
                            str3 = str7;
                        }
                        Object obj2 = linkedHashMapK.get("cache_max_age");
                        com.tapjoy.internal.m mVar = new com.tapjoy.internal.m(str6);
                        if (mVar.f2780b != 1) {
                            v1.m.a(d, com.tapjoy.internal.m.a(mVar.c), mVar.d);
                            O = str4;
                            P = str5;
                            Q = str6;
                            R = str3;
                            if (linkedHashMapK.containsKey(TapjoyConstants.PREF_SERVER_CURRENCY_LIST)) {
                                try {
                                    List list = (List) linkedHashMapK.get(TapjoyConstants.PREF_SERVER_CURRENCY_LIST);
                                    if (d != null && list != null && !list.isEmpty()) {
                                        JSONArray jSONArray = new JSONArray((Collection) list);
                                        SharedPreferences.Editor editorEdit = d.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
                                        editorEdit.putBoolean(TapjoyConstants.PREF_CURRENCY_SELF_MANAGED, jSONArray.getJSONObject(0).getString(TapjoyConstants.PREF_SERVER_CURRENCY_TYPE).equalsIgnoreCase(TapjoyConstants.PREF_SERVER_CURRENCY_SELF_MANAGED));
                                        editorEdit.putString(TapjoyConstants.PREF_SERVER_CURRENCY_IDS, jSONArray.toString());
                                        editorEdit.apply();
                                    }
                                } catch (Exception unused) {
                                    TapjoyLog.e("TapjoyConnect", "Error saving currency id list.");
                                }
                            }
                            if (obj instanceof Map) {
                                S = (Map) obj;
                            }
                            if (TextUtils.isEmpty(str2) || !i) {
                                d4Var = null;
                            } else {
                                d4Var = null;
                                setUserID(A, null);
                            }
                            d4VarA.close();
                            if (!z2) {
                                try {
                                    a(str, obj2);
                                    ca.c.a(linkedHashMapK.get(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS));
                                } catch (IOException e2) {
                                    e = e2;
                                    d4Var2 = d4Var;
                                    TapjoyLog.v("TapjoyConnect", e.getMessage());
                                    l8.a(d4Var2);
                                    return false;
                                } catch (RuntimeException e3) {
                                    e = e3;
                                    d4Var2 = d4Var;
                                    TapjoyLog.v("TapjoyConnect", e.getMessage());
                                    l8.a(d4Var2);
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    d4Var2 = d4Var;
                                    l8.a(d4Var2);
                                    throw th;
                                }
                            }
                            Logger logger = l8.a;
                            return true;
                        }
                        throw new IOException("Invalid analytics_api_key");
                    } catch (IOException e4) {
                        e = e4;
                        d4Var2 = d4VarA;
                        TapjoyLog.v("TapjoyConnect", e.getMessage());
                        l8.a(d4Var2);
                        return false;
                    } catch (RuntimeException e5) {
                        e = e5;
                        d4Var2 = d4VarA;
                        TapjoyLog.v("TapjoyConnect", e.getMessage());
                        l8.a(d4Var2);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    d4Var2 = d4VarA;
                    l8.a(d4Var2);
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                d4Var = null;
            } catch (RuntimeException e7) {
                e = e7;
                d4Var = null;
            } catch (Throwable th3) {
                th = th3;
                d4Var = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (str.length() < 1) {
            intent.setData(Uri.parse("market://details"));
            if (V.queryIntentActivities(intent, 0).size() > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    public static void a(String str, Object obj) {
        long jLongValue;
        try {
            if (obj instanceof String) {
                jLongValue = Long.parseLong(((String) obj).trim());
            } else {
                if (obj instanceof Number) {
                    jLongValue = ((Number) obj).longValue();
                } else {
                    jLongValue = 0;
                }
                if (jLongValue <= 0) {
                    TapjoyAppSettings.getInstance().removeConnectResult();
                    return;
                }
                TapjoyAppSettings tapjoyAppSettings = TapjoyAppSettings.getInstance();
                String strSHA1 = t + u + v + Z + n;
                try {
                    strSHA1 = TapjoyUtil.SHA1(strSHA1);
                } catch (Exception unused) {
                }
                tapjoyAppSettings.saveConnectResultAndParams(str, strSHA1, na.a() + (jLongValue * 1000));
            }
        } catch (NumberFormatException unused2) {
        }
        if (jLongValue <= 0) {
            TapjoyAppSettings.getInstance().removeConnectResult();
            return;
        }
        TapjoyAppSettings tapjoyAppSettings2 = TapjoyAppSettings.getInstance();
        String strSHA2 = t + u + v + Z + n;
        strSHA2 = TapjoyUtil.SHA1(strSHA2);
        tapjoyAppSettings2.saveConnectResultAndParams(str, strSHA2, na.a() + (jLongValue * 1000));
    }
}
