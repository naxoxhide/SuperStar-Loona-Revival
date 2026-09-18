package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private static final AtomicReference<com.applovin.impl.sdk.utils.d.a> aCZ = new AtomicReference<>();
    private static final AtomicReference<a> aDb = new AtomicReference<>();
    private final Context E;
    private final Map<String, Object> aCW;
    private boolean aCY;
    private final Map<String, Object> avX;
    private final x logger;
    private final n sdk;
    private final Object aCX = new Object();
    private final AtomicReference<Integer> aDa = new AtomicReference<>();

    public static class b {
        public int aDe = -1;
        public int adn = -1;
        public Boolean aDf = null;
    }

    protected o(n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.E = n.getApplicationContext();
        this.aCW = CV();
        this.avX = CZ();
    }

    String getBidToken() {
        String strEncodeToString = Base64.encodeToString(new JSONObject(CP()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPI)).booleanValue() ? com.applovin.impl.sdk.utils.p.a(strEncodeToString, com.applovin.impl.sdk.utils.u.N(this.sdk), com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPJ)).intValue()), this.sdk.getSdkKey(), this.sdk) : strEncodeToString;
    }

    private Map<String, String> CP() {
        return com.applovin.impl.sdk.utils.u.s(a(null, true, false));
    }

    public Map<String, Object> a(Map<String, String> map, boolean z, boolean z2) {
        HashMap map2 = new HashMap(64);
        Map<String, Object> mapAL = aL(z);
        Map<String, Object> mapCY = CY();
        Map<String, Object> mapDc = Dc();
        Map<String, Object> mapDd = Dd();
        Map<String, String> allData = this.sdk.BA().getAllData();
        if (z2) {
            map2.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, mapAL);
            map2.put("app_info", mapCY);
            if (mapDc != null) {
                map2.put("connection_info", mapDc);
            }
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (mapDd != null) {
                map2.put("location_info", mapDd);
            }
            if (!allData.isEmpty()) {
                map2.put("targeting_data", allData);
            }
        } else {
            map2.putAll(mapAL);
            map2.putAll(mapCY);
            if (mapDc != null) {
                map2.putAll(mapDc);
            }
            if (map != null) {
                map2.putAll(map);
            }
            if (mapDd != null) {
                map2.putAll(mapDd);
            }
            if (!allData.isEmpty()) {
                map2.putAll(allData);
            }
        }
        map2.put("accept", "custom_size,launch_app,video");
        map2.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.sdk.getMediationProvider(), map2);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.sdk.CI(), map2);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOy), map2);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.sdk.Bw()), map2);
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
            map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
        }
        map2.putAll(Db());
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPi)).booleanValue()) {
            com.applovin.impl.sdk.d.g gVarBP = this.sdk.BP();
            map2.put("li", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSO)));
            map2.put(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK, Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSR)));
            map2.put("mad", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSP)));
            map2.put("msad", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSS)));
            map2.put("pf", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSW)));
            map2.put("mpf", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aTd)));
            map2.put("gpf", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSX)));
            map2.put("asoac", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aTb)));
        }
        map2.put("rid", UUID.randomUUID().toString());
        return map2;
    }

    public Map<String, Object> CQ() {
        return CollectionUtils.map(this.aCW);
    }

    public Map<String, Object> CR() {
        return CollectionUtils.map(this.avX);
    }

    public Map<String, Object> CS() {
        return aL(false);
    }

    public Map<String, Object> aL(boolean z) {
        Map<String, Object> map;
        synchronized (this.aCX) {
            map = CollectionUtils.map(this.aCW);
        }
        return a(map, z);
    }

    public void CT() {
        synchronized (this.aCX) {
            g(this.aCW);
        }
    }

    public String CU() {
        return AppLovinSdkUtils.isFireOS(this.E) ? "fireos" : "android";
    }

    private Map<String, Object> CV() {
        HashMap map = new HashMap(34);
        map.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.MANUFACTURER);
        map.put("brand_name", Build.BRAND);
        map.put("hardware", Build.HARDWARE);
        map.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        map.put("aida", Boolean.valueOf(com.applovin.impl.sdk.utils.d.KN()));
        map.put("locale", Locale.getDefault().toString());
        map.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        map.put("os", Build.VERSION.RELEASE);
        map.put(TapjoyConstants.TJC_PLATFORM, CU());
        map.put("revision", Build.DEVICE);
        map.put("tz_offset", Double.valueOf(Dp()));
        map.put("gy", Boolean.valueOf(Dq()));
        map.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, Dr());
        map.put("mcc", Ds());
        map.put("mnc", Dt());
        map.put("carrier", Du());
        map.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.E)));
        map.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.E)));
        map.put("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        map.put("hdr", Dw());
        map.put("supported_abis", Dx());
        DisplayMetrics displayMetrics = this.E.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map.put("adns", Float.valueOf(displayMetrics.density));
            map.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            map.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            map.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point pointW = com.applovin.impl.sdk.utils.h.W(this.E);
            map.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(pointW.x, 2.0d) + Math.pow(pointW.y, 2.0d)) / ((double) displayMetrics.xdpi)));
            com.applovin.impl.sdk.utils.h.a aVarA = com.applovin.impl.sdk.utils.h.a(this.E, this.sdk);
            if (aVarA != null) {
                map.put("tl_cr", Integer.valueOf(aVarA.Lf()));
                map.put("tr_cr", Integer.valueOf(aVarA.Lg()));
                map.put("bl_cr", Integer.valueOf(aVarA.Lh()));
                map.put("br_cr", Integer.valueOf(aVarA.Li()));
            }
        }
        map.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        map.put("tbalsi_ms", Long.valueOf(this.sdk.CG() - n.CE()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(aa.Fr()), map);
        g(map);
        return map;
    }

    private void g(Map<String, Object> map) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOF)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(Di()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOG)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(Dj()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aON)).booleanValue() && com.applovin.impl.sdk.utils.u.Q(this.sdk)) {
            af.A(this.sdk);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOM)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOI)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(De()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOQ)).booleanValue()) {
            boolean z = true;
            boolean z2 = this.E.getResources().getConfiguration().keyboard == 2;
            boolean zHasSystemFeature = this.E.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
            boolean zHasSystemFeature2 = this.E.getPackageManager().hasSystemFeature("android.hardware.type.pc");
            if (!z2 || (!zHasSystemFeature && !zHasSystemFeature2)) {
                z = false;
            }
            map.put("is_pc", Boolean.valueOf(z));
        }
    }

    private Map<String, Object> a(Map<String, Object> map, boolean z) {
        com.applovin.impl.sdk.utils.d.a aVarDf;
        PowerManager powerManager;
        Map<String, Object> map2 = CollectionUtils.map(map);
        Point pointW = com.applovin.impl.sdk.utils.h.W(this.E);
        map2.put("dx", Integer.valueOf(pointW.x));
        map2.put("dy", Integer.valueOf(pointW.y));
        if (z) {
            aVarDf = aCZ.get();
            if (aVarDf != null) {
                DA();
            } else if (com.applovin.impl.sdk.utils.u.Lv()) {
                aVarDf = new com.applovin.impl.sdk.utils.d.a();
                map2.put("inc", true);
            } else {
                aVarDf = this.sdk.BQ().Df();
            }
        } else {
            aVarDf = this.sdk.BQ().Df();
        }
        String strKP = aVarDf.KP();
        if (StringUtils.isValidString(strKP)) {
            map2.put("idfa", strKP);
        }
        map2.put("dnt", Boolean.valueOf(aVarDf.KO()));
        map2.put("dnt_code", aVarDf.KQ().KR());
        a aVar = aDb.get();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOn)).booleanValue() && aVar != null) {
            map2.put("idfv", aVar.f11do);
            map2.put("idfv_scope", Integer.valueOf(aVar.aDd));
        }
        Object objB = com.applovin.impl.privacy.a.zN().B(this.E);
        if (objB != null) {
            map2.put(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, objB);
        }
        Object objB2 = com.applovin.impl.privacy.a.zM().B(this.E);
        if (objB2 != null) {
            map2.put(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, objB2);
        }
        Object objB3 = com.applovin.impl.privacy.a.zO().B(this.E);
        if (objB3 != null) {
            map2.put(AppLovinSdkExtraParameterKey.DO_NOT_SELL, objB3);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOz)).booleanValue()) {
            b bVarDh = Dh();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(bVarDh.aDe), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(bVarDh.adn), map2);
            CollectionUtils.putBooleanIfValid("sowpie", bVarDh.aDf, map2);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOH)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.sdk.Cc().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOK)).booleanValue()) {
            map2.put("adr", Boolean.valueOf(Dv()));
        }
        Object objDm = z ? (Integer) this.aDa.get() : Dm();
        if (objDm != null) {
            map2.put(TapjoyConstants.TJC_VOLUME, objDm);
        }
        CollectionUtils.putBooleanIfValid("ma", Dn(), map2);
        CollectionUtils.putBooleanIfValid("spo", Do(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.sdk.Cc().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.sdk.Cc().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.sdk.Cc().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((Settings.System.getInt(this.E.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e) {
            if (x.Fk()) {
                this.logger.c("DataCollector", "Unable to collect screen brightness", e);
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aON)).booleanValue() && com.applovin.impl.sdk.utils.u.Q(this.sdk)) {
            af.A(this.sdk);
            String strFw = af.Fw();
            if (StringUtils.isValidString(strFw)) {
                map2.put("ua", strFw);
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOB)).booleanValue()) {
            try {
                map2.put("fs", Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th) {
                map2.put("fs", -1);
                map2.put("tds", -1);
                if (x.Fk()) {
                    this.logger.c("DataCollector", "Unable to collect total & free space.", th);
                }
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOC)).booleanValue()) {
            ActivityManager activityManager = (ActivityManager) this.E.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                try {
                    activityManager.getMemoryInfo(memoryInfo);
                    map2.put("fm", Long.valueOf(memoryInfo.availMem));
                    map2.put("tm", Long.valueOf(memoryInfo.totalMem));
                    map2.put("lmt", Long.valueOf(memoryInfo.threshold));
                    map2.put("lm", Boolean.valueOf(memoryInfo.lowMemory));
                } catch (Throwable th2) {
                    map2.put("fm", -1);
                    map2.put("tm", -1);
                    map2.put("lmt", -1);
                    if (x.Fk()) {
                        this.logger.c("DataCollector", "Unable to collect memory info.", th2);
                    }
                }
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOD)).booleanValue() && com.applovin.impl.sdk.utils.h.d("android.permission.READ_PHONE_STATE", this.E) && com.applovin.impl.sdk.utils.h.KX()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.E.getSystemService("phone")).getDataNetworkType()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOA)).booleanValue()) {
            String strDk = Dk();
            if (!TextUtils.isEmpty(strDk)) {
                map2.put("so", strDk);
            }
        }
        map2.put("orientation_lock", CW());
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOE)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(com.applovin.impl.sdk.utils.u.Lx()));
        }
        if (com.applovin.impl.sdk.utils.h.KV() && (powerManager = (PowerManager) this.E.getSystemService("power")) != null) {
            map2.put("lpm", Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOO)).booleanValue() && this.sdk.Cg() != null) {
            map2.put("da", Float.valueOf(this.sdk.Cg().Lq()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOP)).booleanValue() && this.sdk.Cg() != null) {
            map2.put("dm", Float.valueOf(this.sdk.Cg().Lp()));
        }
        map2.put("mute_switch", Integer.valueOf(this.sdk.Ch().AT()));
        map2.put("network", com.applovin.impl.sdk.utils.i.G(this.sdk));
        String strDl = Dl();
        if (StringUtils.isValidString(strDl)) {
            map2.put("kb", strDl);
        }
        ArrayService arrayServiceCp = this.sdk.Cp();
        if (arrayServiceCp.isAppHubInstalled()) {
            if (arrayServiceCp.getIsDirectDownloadEnabled() != null) {
                map2.put("ah_dd_enabled", arrayServiceCp.getIsDirectDownloadEnabled());
            }
            map2.put("ah_sdk_version_code", Long.valueOf(arrayServiceCp.getAppHubVersionCode()));
            map2.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceCp.getRandomUserToken()));
            map2.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceCp.getAppHubPackageName()));
        }
        return map2;
    }

    private String CW() {
        int orientation = AppLovinSdkUtils.getOrientation(this.E);
        if (orientation == 1) {
            return TJAdUnitConstants.String.PORTRAIT;
        }
        return orientation == 2 ? TJAdUnitConstants.String.LANDSCAPE : IntegrityManager.INTEGRITY_TYPE_NONE;
    }

    public boolean CX() {
        return this.aCY;
    }

    public Map<String, Object> CY() {
        Map<String, Object> map = CollectionUtils.map(this.avX);
        map.put("first_install", Boolean.valueOf(this.sdk.CH()));
        map.put("first_install_v2", Boolean.valueOf(!this.sdk.BJ()));
        map.put("test_ads", Boolean.valueOf(this.aCY));
        map.put("muted", Boolean.valueOf(this.sdk.getSettings().isMuted()));
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOo)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.sdk.Bx(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOr)).booleanValue()) {
            map.put("compass_random_token", this.sdk.By());
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOt)).booleanValue()) {
            map.put("applovin_random_token", this.sdk.Bz());
        }
        String name = this.sdk.getUserSegment().getName();
        if (StringUtils.isValidString(name)) {
            map.put("user_segment_name", name);
        }
        map.putAll(Da());
        if (this.sdk.BU() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.sdk.BU().Fq(), map);
        }
        return map;
    }

    private Map<String, Object> CZ() {
        PackageInfo packageInfo;
        HashMap map = new HashMap();
        PackageManager packageManager = this.E.getPackageManager();
        ApplicationInfo applicationInfo = this.E.getApplicationInfo();
        long jLastModified = new File(applicationInfo.sourceDir).lastModified();
        String installerPackageName = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.E.getPackageName(), 0);
            try {
                installerPackageName = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        map.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(applicationInfo));
        map.put(TapjoyConstants.TJC_APP_VERSION_NAME, packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        map.put(CampaignEx.JSON_KEY_PACKAGE_NAME, applicationInfo.packageName);
        map.put("vz", StringUtils.toShortSHA1Hash(applicationInfo.packageName));
        if (installerPackageName == null) {
            installerPackageName = "";
        }
        map.put("installer_name", installerPackageName);
        map.put("tg", com.applovin.impl.sdk.utils.t.M(this.sdk));
        map.put("debug", Boolean.valueOf(com.applovin.impl.sdk.utils.u.b(n.getApplicationContext(), this.sdk)));
        map.put("ia", Long.valueOf(jLastModified));
        map.put("alts_ms", Long.valueOf(n.CE()));
        map.put("j8", Boolean.valueOf(n.CF()));
        map.put("ps_tpg", Boolean.valueOf(aa.M(this.E)));
        map.put("ps_apg", Boolean.valueOf(aa.N(this.E)));
        map.put("ps_capg", Boolean.valueOf(aa.O(this.E)));
        map.put("ps_aipg", Boolean.valueOf(aa.P(this.E)));
        Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.d.aRf);
        if (l != null) {
            map.put("ia_v2", l);
        } else {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRf, Long.valueOf(jLastModified));
        }
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("omid_sdk_version", this.sdk.Cn().getSdkVersion());
        map.put("api_did", this.sdk.a(com.applovin.impl.sdk.c.b.aKh));
        map.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        map.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        map.put("epv", Integer.valueOf(com.applovin.impl.sdk.utils.u.LA()));
        return map;
    }

    private Map<String, Object> Da() {
        HashMap map = new HashMap();
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.sdk.Ck().Ap(), map);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.sdk.Ck().Aq(), map);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.sdk.Ck().Ar(), map);
        return map;
    }

    public Map<String, Object> Db() {
        HashMap map = new HashMap();
        map.put("sc", this.sdk.a(com.applovin.impl.sdk.c.b.aKn));
        map.put("sc2", this.sdk.a(com.applovin.impl.sdk.c.b.aKo));
        map.put("sc3", this.sdk.a(com.applovin.impl.sdk.c.b.aKp));
        map.put("server_installed_at", this.sdk.a(com.applovin.impl.sdk.c.b.aKq));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.sdk.a(com.applovin.impl.sdk.c.d.aRH), map);
        return map;
    }

    public Map<String, Object> Dc() {
        com.applovin.impl.sdk.network.b.c cVarHI = this.sdk.BO().HI();
        if (cVarHI == null) {
            return null;
        }
        HashMap map = new HashMap(4);
        map.put("lrm_ts_ms", String.valueOf(cVarHI.HK()));
        map.put("lrm_url", cVarHI.HL());
        map.put("lrm_ct_ms", String.valueOf(cVarHI.HN()));
        map.put("lrm_rs", String.valueOf(cVarHI.HM()));
        return map;
    }

    public Map<String, Object> Dd() {
        if (!this.sdk.getSettings().isLocationCollectionEnabled() || !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPf)).booleanValue()) {
            return null;
        }
        HashMap map = new HashMap();
        w wVarCo = this.sdk.Co();
        boolean zFf = wVarCo.Ff();
        map.put("loc_services_enabled", Boolean.valueOf(zFf));
        if (!zFf) {
            return map;
        }
        map.put("loc_auth", Boolean.valueOf(wVarCo.Fe()));
        if (wVarCo.Fg()) {
            map.put("loc_lat", com.applovin.impl.sdk.utils.u.a(wVarCo.Fi(), ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPh)).intValue()));
            map.put("loc_long", com.applovin.impl.sdk.utils.u.a(wVarCo.Fj(), ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPh)).intValue()));
        }
        return map;
    }

    private boolean De() {
        ConnectivityManager connectivityManager;
        if (com.applovin.impl.sdk.utils.h.KX() && (connectivityManager = (ConnectivityManager) this.E.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().c("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    public com.applovin.impl.sdk.utils.d.a Df() {
        com.applovin.impl.sdk.utils.d.a aVarS = com.applovin.impl.sdk.utils.d.S(this.E);
        if (aVarS == null) {
            return new com.applovin.impl.sdk.utils.d.a();
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOm)).booleanValue()) {
            if (aVarS.KO() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOl)).booleanValue()) {
                aVarS.dB("");
            }
            aCZ.set(aVarS);
        } else {
            aVarS = new com.applovin.impl.sdk.utils.d.a();
        }
        boolean z = false;
        if (StringUtils.isValidString(aVarS.KP())) {
            List<String> testDeviceAdvertisingIds = this.sdk.getSettings().getTestDeviceAdvertisingIds();
            if (testDeviceAdvertisingIds != null && testDeviceAdvertisingIds.contains(aVarS.KP())) {
                z = true;
            }
            this.aCY = z;
        } else {
            this.aCY = false;
        }
        return aVarS;
    }

    public static void a(com.applovin.impl.sdk.utils.d.a aVar) {
        aCZ.set(aVar);
    }

    public a Dg() {
        return aDb.get();
    }

    public static void a(a aVar) {
        aDb.set(aVar);
    }

    private b Dh() {
        b bVar = new b();
        Intent intentRegisterReceiver = this.E.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra > 0 && intExtra2 > 0) {
            bVar.adn = (int) ((intExtra / intExtra2) * 100.0f);
        } else {
            bVar.adn = -1;
        }
        bVar.aDe = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        if (com.applovin.impl.sdk.utils.h.KT()) {
            bVar.aDf = Boolean.valueOf(Settings.Global.getInt(this.E.getContentResolver(), "stay_on_while_plugged_in", -1) > 0);
        } else {
            bVar.aDf = Boolean.valueOf(((((intentRegisterReceiver.getIntExtra("plugged", -1) & 1) | 2) | 4) | 8) > 0);
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:120:0x01df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x01aa, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:112:0x01c1, please report this as an issue */
    private long Di() {
        long j;
        int iCI;
        int iCI2;
        int iCI3;
        long j2;
        long j3;
        long j4;
        List listAsList = Arrays.asList(StringUtils.emptyIfNull(Settings.Secure.getString(this.E.getContentResolver(), "enabled_accessibility_services")).split(CertificateUtil.DELIMITER));
        long j5 = listAsList.contains("AccessibilityMenuService") ? 256L : 0L;
        if (listAsList.contains("SelectToSpeakService")) {
            j5 |= 512;
        }
        if (listAsList.contains("SoundAmplifierService")) {
            j5 |= 2;
        }
        if (listAsList.contains("SpeechToTextAccessibilityService")) {
            j5 |= 128;
        }
        if (listAsList.contains("SwitchAccessService")) {
            j5 |= 4;
        }
        if ((this.E.getResources().getConfiguration().uiMode & 48) == 32) {
            j5 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        if (cH("accessibility_enabled")) {
            j5 |= 8;
        }
        if (cH("touch_exploration_enabled")) {
            j5 |= 16;
        }
        if (com.applovin.impl.sdk.utils.h.KV()) {
            if (cH("accessibility_display_inversion_enabled")) {
                j5 |= 32;
            }
            if (cH("skip_first_use_hints")) {
                j5 |= 64;
            }
        }
        if (cH("lock_screen_allow_remote_input")) {
            j5 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        if (cH("enabled_accessibility_audio_description_by_default")) {
            j5 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        if (cH("accessibility_shortcut_on_lock_screen")) {
            j5 |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        if (cH("wear_talkback_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE;
        }
        if (cH("hush_gesture_used")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        if (cH("high_text_contrast_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        if (cH("accessibility_display_magnification_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        if (cH("accessibility_display_magnification_navbar_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        if (cH("accessibility_captioning_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        if (cH("accessibility_display_daltonizer_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        if (cH("accessibility_autoclick_enabled")) {
            j5 |= 2097152;
        }
        if (cH("accessibility_large_pointer_icon")) {
            j5 |= 4194304;
        }
        if (cH("reduce_bright_colors_activated")) {
            j5 |= 8388608;
        }
        if (cH("reduce_bright_colors_persist_across_reboots")) {
            j5 |= 16777216;
        }
        if (cH("tty_mode_enabled")) {
            j5 |= 33554432;
        }
        if (cH("rtt_calling_mode")) {
            j5 |= 67108864;
        }
        if (cH("accessibility_floating_menu_fade_enabled")) {
            j5 |= 134217728;
        }
        if (cH("accessibility_show_window_magnification_prompt")) {
            j5 |= 268435456;
        }
        if (cH("accessibility_floating_menu_migration_tooltip_prompt")) {
            j5 |= 536870912;
        }
        int iCI4 = cI("accessibility_magnification_mode");
        if (iCI4 == 0) {
            j = 1073741824;
        } else if (iCI4 == 1) {
            j = 2147483648L;
        } else {
            if (iCI4 != 2) {
                if (iCI4 == 3) {
                    j = 8589934592L;
                }
                iCI = cI("accessibility_button_mode");
                if (iCI == 0) {
                    j4 = iCI == 1 ? 34359738368L : 17179869184L;
                    iCI2 = cI("accessibility_floating_menu_size");
                    if (iCI2 == 0) {
                        j3 = iCI2 == 1 ? 137438953472L : 68719476736L;
                        iCI3 = cI("accessibility_floating_menu_icon_type");
                        if (iCI3 == 0) {
                            j2 = 274877906944L;
                        } else {
                            if (iCI3 == 1) {
                                return j5;
                            }
                            j2 = 549755813888L;
                        }
                        return j5 | j2;
                    }
                    j5 |= j3;
                    iCI3 = cI("accessibility_floating_menu_icon_type");
                    if (iCI3 == 0) {
                        j2 = 274877906944L;
                    } else {
                        if (iCI3 == 1) {
                            return j5;
                        }
                        j2 = 549755813888L;
                    }
                    return j5 | j2;
                }
                j5 |= j4;
                iCI2 = cI("accessibility_floating_menu_size");
                if (iCI2 == 0) {
                    if (iCI2 == 1) {
                    }
                    iCI3 = cI("accessibility_floating_menu_icon_type");
                    if (iCI3 == 0) {
                        j2 = 274877906944L;
                    } else {
                        if (iCI3 == 1) {
                            return j5;
                        }
                        j2 = 549755813888L;
                    }
                    return j5 | j2;
                }
                j5 |= j3;
                iCI3 = cI("accessibility_floating_menu_icon_type");
                if (iCI3 == 0) {
                    j2 = 274877906944L;
                } else {
                    if (iCI3 == 1) {
                        return j5;
                    }
                    j2 = 549755813888L;
                }
                return j5 | j2;
            }
            j = 4294967296L;
        }
        j5 |= j;
        iCI = cI("accessibility_button_mode");
        if (iCI == 0) {
            if (iCI == 1) {
            }
            iCI2 = cI("accessibility_floating_menu_size");
            if (iCI2 == 0) {
                if (iCI2 == 1) {
                }
                iCI3 = cI("accessibility_floating_menu_icon_type");
                if (iCI3 == 0) {
                    j2 = 274877906944L;
                } else {
                    if (iCI3 == 1) {
                        return j5;
                    }
                    j2 = 549755813888L;
                }
                return j5 | j2;
            }
            j5 |= j3;
            iCI3 = cI("accessibility_floating_menu_icon_type");
            if (iCI3 == 0) {
                j2 = 274877906944L;
            } else {
                if (iCI3 == 1) {
                    return j5;
                }
                j2 = 549755813888L;
            }
            return j5 | j2;
        }
        j5 |= j4;
        iCI2 = cI("accessibility_floating_menu_size");
        if (iCI2 == 0) {
            if (iCI2 == 1) {
            }
            iCI3 = cI("accessibility_floating_menu_icon_type");
            if (iCI3 == 0) {
                j2 = 274877906944L;
            } else {
                if (iCI3 == 1) {
                    return j5;
                }
                j2 = 549755813888L;
            }
            return j5 | j2;
        }
        j5 |= j3;
        iCI3 = cI("accessibility_floating_menu_icon_type");
        if (iCI3 == 0) {
            j2 = 274877906944L;
        } else {
            if (iCI3 == 1) {
                return j5;
            }
            j2 = 549755813888L;
        }
        return j5 | j2;
    }

    private boolean cH(String str) {
        return cI(str) == 1;
    }

    private int cI(String str) {
        try {
            return Settings.Secure.getInt(this.E.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private float Dj() {
        try {
            return Settings.System.getFloat(this.E.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            if (!x.Fk()) {
                return -1.0f;
            }
            this.logger.c("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    private String Dk() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (com.applovin.impl.sdk.utils.h.KW()) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                sb.append(audioDeviceInfo.getType());
                sb.append(",");
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append(3);
                sb.append(",");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb.append(7);
                sb.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append(8);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string) && x.Fk()) {
            this.logger.f("DataCollector", "No sound outputs detected");
        }
        return string;
    }

    private String Dl() {
        if (!com.applovin.impl.sdk.utils.h.KX()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.E.getResources().getConfiguration().getLocales();
            for (int i = 0; i < locales.size(); i++) {
                sb.append(locales.get(i));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Integer Dm() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        try {
            return Integer.valueOf((int) (audioManager.getStreamVolume(3) * ((Float) this.sdk.a(com.applovin.impl.sdk.c.b.aOL)).floatValue()));
        } catch (Throwable th) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("DataCollector", "Unable to collect device volume", th);
            }
            return null;
        }
    }

    private Boolean Dn() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean Do() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private double Dp() {
        return Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d) / 10.0d;
    }

    private boolean Dq() {
        SensorManager sensorManager = (SensorManager) this.E.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private String Dr() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String Ds() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!x.Fk()) {
                return "";
            }
            this.logger.c("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String Dt() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!x.Fk()) {
                return "";
            }
            this.logger.c("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String Du() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!x.Fk()) {
                return "";
            }
            this.logger.c("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private boolean Dv() {
        try {
            return Dy() || Dz();
        } catch (Throwable unused) {
            return false;
        }
    }

    private Boolean Dw() {
        if (com.applovin.impl.sdk.utils.h.KY()) {
            return Boolean.valueOf(this.E.getResources().getConfiguration().isScreenHdr());
        }
        return null;
    }

    private String[] Dx() {
        if (com.applovin.impl.sdk.utils.h.KV()) {
            return Build.SUPPORTED_ABIS;
        }
        return null;
    }

    private boolean Dy() {
        String str = Build.TAGS;
        return str != null && str.contains(cJ("lz}$blpz"));
    }

    private boolean Dz() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i = 0; i < 9; i++) {
            if (new File(cJ(strArr[i])).exists()) {
                return true;
            }
        }
        return false;
    }

    private String cJ(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = 9; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    public void DA() {
        this.sdk.BM().a(new com.applovin.impl.sdk.e.i(this.sdk, new com.applovin.impl.sdk.e.i.a() { // from class: com.applovin.impl.sdk.o.1
            @Override // com.applovin.impl.sdk.e.i.a
            public void b(com.applovin.impl.sdk.utils.d.a aVar) {
                o.aCZ.set(aVar);
            }
        }), com.applovin.impl.sdk.e.q.b.ADVERTISING_INFO_COLLECTION);
        this.sdk.BM().a(new com.applovin.impl.sdk.e.ab(this.sdk, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$o$uSWQ_Q3Fnacr7O4SzS1-KMlYklw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.DB();
            }
        }), com.applovin.impl.sdk.e.q.b.CACHING_OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void DB() {
        this.aDa.set(Dm());
    }

    public static class a {
        public final int aDd;

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public final String f11do;

        public a(String str, int i) {
            this.f11do = str;
            this.aDd = i;
        }
    }
}
