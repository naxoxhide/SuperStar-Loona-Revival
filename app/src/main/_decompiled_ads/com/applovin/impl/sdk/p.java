package com.applovin.impl.sdk;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Base64;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private final q aBj;
    private final n sdk;
    private final Object aCX = new Object();
    private final Object aDg = new Object();
    private final Context E = n.getApplicationContext();
    private final Map<String, Object> aCW = CV();
    private final Map<String, Object> avX = CZ();

    public Map<String, Object> CQ() {
        return this.aCW;
    }

    public Map<String, Object> CR() {
        return this.avX;
    }

    protected p(n nVar) {
        this.sdk = nVar;
        this.aBj = nVar.BS();
    }

    protected String getBidToken() {
        String strEncodeToString = Base64.encodeToString(new JSONObject(CP()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPI)).booleanValue() ? com.applovin.impl.sdk.utils.p.a(strEncodeToString, com.applovin.impl.sdk.utils.u.N(this.sdk), com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPJ)).intValue()), this.sdk.getSdkKey(), this.sdk) : strEncodeToString;
    }

    private Map<String, String> CP() {
        return com.applovin.impl.sdk.utils.u.s(a(null, true, false));
    }

    public Map<String, Object> a(Map<String, String> map, boolean z, boolean z2) {
        HashMap map2;
        Map<String, Object> mapAL = aL(z);
        Map<String, Object> mapDF = DF();
        Map<String, Object> mapDc = Dc();
        Map<String, Object> mapDE = DE();
        Map<String, String> allData = this.sdk.BA().getAllData();
        Map<String, Object> mapDb = Db();
        if (z2) {
            map2 = new HashMap(mapDb.size() + 19);
            map2.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, mapAL);
            map2.put("app_info", mapDF);
            if (mapDc != null) {
                map2.put("connection_info", mapDc);
            }
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (mapDE != null) {
                map2.put("location_info", mapDE);
            }
            if (allData != null) {
                map2.put("targeting_data", allData);
            }
        } else {
            map2 = new HashMap(mapAL.size() + 14 + mapDF.size() + (map != null ? map.size() : 0) + (mapDE != null ? mapDE.size() : 0) + allData.size() + mapDb.size());
            map2.putAll(mapAL);
            map2.putAll(mapDF);
            if (mapDc != null) {
                map2.putAll(mapDc);
            }
            if (map != null) {
                map2.putAll(map);
            }
            if (mapDE != null) {
                map2.putAll(mapDE);
            }
            if (!allData.isEmpty()) {
                map2.putAll(allData);
            }
        }
        map2.putAll(mapDb);
        map2.put("accept", "custom_size,launch_app,video");
        map2.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.sdk.getMediationProvider(), map2);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.sdk.CI(), map2);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOy), map2);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.sdk.Bw()), map2);
        CollectionUtils.putStringIfValid("rid", UUID.randomUUID().toString(), map2);
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
            CollectionUtils.putStringIfValid(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey(), map2);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPi)).booleanValue()) {
            com.applovin.impl.sdk.d.g gVarBP = this.sdk.BP();
            CollectionUtils.putLongIfValid("li", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSO)), map2);
            CollectionUtils.putLongIfValid(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK, Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSR)), map2);
            CollectionUtils.putLongIfValid("mad", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSP)), map2);
            CollectionUtils.putLongIfValid("msad", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSS)), map2);
            CollectionUtils.putLongIfValid("pf", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSW)), map2);
            CollectionUtils.putLongIfValid("mpf", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aTd)), map2);
            CollectionUtils.putLongIfValid("gpf", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aSX)), map2);
            CollectionUtils.putLongIfValid("asoac", Long.valueOf(gVarBP.b(com.applovin.impl.sdk.d.f.aTb)), map2);
        }
        return map2;
    }

    public Map<String, Object> CS() {
        return aL(false);
    }

    public Map<String, Object> aL(boolean z) {
        Map<String, Object> map;
        com.applovin.impl.sdk.utils.d.a aVarDJ;
        synchronized (this.aCX) {
            map = CollectionUtils.map(this.aCW);
        }
        if (z) {
            aVarDJ = this.aBj.DH();
            if (aVarDJ != null) {
                this.aBj.DK();
            } else if (com.applovin.impl.sdk.utils.u.Lv()) {
                aVarDJ = new com.applovin.impl.sdk.utils.d.a();
                map.put("inc", true);
            } else {
                aVarDJ = this.sdk.BS().DJ();
            }
        } else {
            aVarDJ = this.sdk.BS().DJ();
        }
        CollectionUtils.putBooleanIfValid(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, com.applovin.impl.privacy.a.zN().B(this.E), map);
        CollectionUtils.putBooleanIfValid(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, com.applovin.impl.privacy.a.zM().B(this.E), map);
        CollectionUtils.putBooleanIfValid(AppLovinSdkExtraParameterKey.DO_NOT_SELL, com.applovin.impl.privacy.a.zO().B(this.E), map);
        CollectionUtils.putBooleanIfValid("dnt", Boolean.valueOf(aVarDJ.KO()), map);
        CollectionUtils.putStringIfValid("dnt_code", aVarDJ.KQ().KR(), map);
        CollectionUtils.putStringIfValid("idfa", aVarDJ.KP(), map);
        q.b bVarDG = this.aBj.DG();
        if (bVarDG != null) {
            CollectionUtils.putStringIfValid("idfv", bVarDG.mQ(), map);
            CollectionUtils.putIntegerIfValid("idfv_scope", Integer.valueOf(bVarDG.Eq()), map);
        }
        CollectionUtils.putIntegerIfValid(TapjoyConstants.TJC_VOLUME, z ? this.aBj.DI() : this.aBj.DW().Es(), map);
        CollectionUtils.putIntegerIfValid("lpm", this.aBj.DU().EM(), map);
        CollectionUtils.putIntegerIfValid("sb", this.aBj.DP(), map);
        CollectionUtils.putIntegerIfValid("mute_switch", Integer.valueOf(this.aBj.DW().Er()), map);
        CollectionUtils.putLongIfValid("fs", this.aBj.DM(), map);
        CollectionUtils.putStringIfValid("network", this.aBj.DL(), map);
        CollectionUtils.putBooleanIfValid("ma", this.aBj.DW().Eu(), map);
        CollectionUtils.putBooleanIfValid("spo", this.aBj.DW().Ev(), map);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(true ^ this.sdk.Cc().isApplicationPaused()), map);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.sdk.Cc().getAppEnteredForegroundTimeMillis()), map);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.sdk.Cc().getAppEnteredBackgroundTimeMillis()), map);
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOC)).booleanValue()) {
            CollectionUtils.putLongIfValid("fm", this.aBj.DZ().EI(), map);
            CollectionUtils.putLongIfValid("lmt", this.aBj.DZ().EJ(), map);
            CollectionUtils.putBooleanIfValid("lm", this.aBj.DZ().EK(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOD)).booleanValue()) {
            CollectionUtils.putIntegerIfValid("rat", this.aBj.DV().EN(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOA)).booleanValue()) {
            CollectionUtils.putStringIfValid("so", this.aBj.DW().Et(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOE)).booleanValue()) {
            CollectionUtils.putBooleanIfValid("vs", Boolean.valueOf(this.aBj.DS()), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOO)).booleanValue()) {
            CollectionUtils.putFloatIfValid("da", this.aBj.DN(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOP)).booleanValue()) {
            CollectionUtils.putFloatIfValid("dm", this.aBj.DO(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOz)).booleanValue()) {
            CollectionUtils.putIntegerIfValid("act", this.aBj.DX().Ex(), map);
            CollectionUtils.putIntegerIfValid("acm", this.aBj.DX().Ew(), map);
            CollectionUtils.putBooleanIfValid("sowpie", this.aBj.DX().Ey(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOK)).booleanValue()) {
            CollectionUtils.putBooleanIfValid("adr", Boolean.valueOf(this.aBj.Dv()), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOH)).booleanValue()) {
            CollectionUtils.putIntegerIfValid("mtl", Integer.valueOf(this.sdk.Cc().getLastTrimMemoryLevel()), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aON)).booleanValue() && com.applovin.impl.sdk.utils.u.Q(this.sdk)) {
            af.A(this.sdk);
            CollectionUtils.putStringIfValid("ua", af.Fw(), map);
        }
        ArrayService arrayServiceCp = this.sdk.Cp();
        if (arrayServiceCp.isAppHubInstalled()) {
            if (arrayServiceCp.getIsDirectDownloadEnabled() != null) {
                CollectionUtils.putBooleanIfValid("ah_dd_enabled", arrayServiceCp.getIsDirectDownloadEnabled(), map);
            }
            CollectionUtils.putLongIfValid("ah_sdk_version_code", Long.valueOf(arrayServiceCp.getAppHubVersionCode()), map);
            CollectionUtils.putStringIfValid("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceCp.getRandomUserToken()), map);
            CollectionUtils.putStringIfValid("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceCp.getAppHubPackageName()), map);
        }
        return map;
    }

    public void DD() {
        synchronized (this.aCX) {
            h(this.aCW);
        }
    }

    private Map<String, Object> CV() {
        HashMap map = new HashMap(36);
        CollectionUtils.putStringIfValid("kb", this.aBj.Ee(), map);
        CollectionUtils.putBooleanIfValid("gy", Boolean.valueOf(this.aBj.Ed()), map);
        CollectionUtils.putDoubleIfValid("tz_offset", Double.valueOf(this.aBj.Ec()), map);
        CollectionUtils.putLongIfValid("tm", Long.valueOf(this.aBj.DZ().EL()), map);
        CollectionUtils.putLongIfValid("tds", Long.valueOf(this.aBj.Ef()), map);
        CollectionUtils.putStringIfValid(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, this.aBj.DV().getCountryCode(), map);
        CollectionUtils.putStringIfValid("carrier", this.aBj.DV().EO(), map);
        CollectionUtils.putStringIfValid("mcc", this.aBj.DV().EP(), map);
        CollectionUtils.putStringIfValid("mnc", this.aBj.DV().EQ(), map);
        CollectionUtils.putIntegerIfValid("adnsd", Integer.valueOf(this.aBj.DY().EC()), map);
        CollectionUtils.putIntegerIfValid("dx", Integer.valueOf(this.aBj.DY().EA()), map);
        CollectionUtils.putIntegerIfValid("dy", Integer.valueOf(this.aBj.DY().EB()), map);
        CollectionUtils.putFloatIfValid("adns", Float.valueOf(this.aBj.DY().EF()), map);
        CollectionUtils.putFloatIfValid("xdpi", Float.valueOf(this.aBj.DY().ED()), map);
        CollectionUtils.putFloatIfValid("ydpi", Float.valueOf(this.aBj.DY().EE()), map);
        CollectionUtils.putDoubleIfValid("screen_size_in", Double.valueOf(this.aBj.DY().EG()), map);
        CollectionUtils.putBooleanIfValid("hdr", this.aBj.DY().EH(), map);
        CollectionUtils.putStringIfValid("orientation_lock", this.aBj.Eb(), map);
        CollectionUtils.putIntegerIfValid("api_level", Integer.valueOf(Build.VERSION.SDK_INT), map);
        CollectionUtils.putStringIfValid("brand", Build.MANUFACTURER, map);
        CollectionUtils.putStringIfValid("brand_name", Build.BRAND, map);
        CollectionUtils.putStringIfValid("hardware", Build.HARDWARE, map);
        CollectionUtils.putStringIfValid("locale", Locale.getDefault().toString(), map);
        CollectionUtils.putStringIfValid(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL, map);
        CollectionUtils.putStringIfValid("os", Build.VERSION.RELEASE, map);
        CollectionUtils.putStringIfValid("revision", Build.DEVICE, map);
        CollectionUtils.putStringIfValid(TapjoyConstants.TJC_PLATFORM, AppLovinSdkUtils.isFireOS(this.E) ? "fireos" : "android", map);
        CollectionUtils.putBooleanIfValid("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()), map);
        CollectionUtils.putBooleanIfValid("aida", Boolean.valueOf(com.applovin.impl.sdk.utils.d.KN()), map);
        CollectionUtils.putBooleanIfValid("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.E)), map);
        CollectionUtils.putBooleanIfValid("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.E)), map);
        CollectionUtils.putLongIfValid("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), map);
        CollectionUtils.putLongIfValid("tbalsi_ms", Long.valueOf(this.sdk.CG() - n.CE()), map);
        CollectionUtils.putIntegerIfValid("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()), map);
        CollectionUtils.putStringArrayIfValid("supported_abis", this.aBj.Dx(), map);
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(aa.Fr()), map);
        h(map);
        return map;
    }

    private void h(Map<String, Object> map) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aON)).booleanValue() && com.applovin.impl.sdk.utils.u.Q(this.sdk)) {
            af.A(this.sdk);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOF)).booleanValue() && !map.containsKey("af")) {
            CollectionUtils.putLongIfValid("af", Long.valueOf(this.aBj.DQ()), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOG)).booleanValue() && !map.containsKey("font")) {
            CollectionUtils.putFloatIfValid("font", Float.valueOf(this.aBj.DR()), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOM)).booleanValue() && !map.containsKey("sua")) {
            CollectionUtils.putStringIfValid("sua", System.getProperty("http.agent"), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOI)).booleanValue() && !map.containsKey("network_restricted")) {
            CollectionUtils.putBooleanIfValid("network_restricted", Boolean.valueOf(this.aBj.De()), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOQ)).booleanValue()) {
            CollectionUtils.putBooleanIfValid("is_pc", Boolean.valueOf(this.aBj.DT()), map);
        }
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

    private Map<String, Object> DE() {
        if (!this.sdk.getSettings().isLocationCollectionEnabled() || !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPf)).booleanValue()) {
            return null;
        }
        HashMap map = new HashMap(4);
        w wVarCo = this.sdk.Co();
        boolean zFf = wVarCo.Ff();
        CollectionUtils.putBooleanIfValid("loc_services_enabled", Boolean.valueOf(zFf), map);
        if (!zFf) {
            return map;
        }
        CollectionUtils.putBooleanIfValid("loc_auth", Boolean.valueOf(wVarCo.Fe()), map);
        if (!this.sdk.Co().Fg()) {
            return map;
        }
        CollectionUtils.putStringIfValid("loc_lat", com.applovin.impl.sdk.utils.u.a(wVarCo.Fi(), ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPh)).intValue()), map);
        CollectionUtils.putStringIfValid("loc_long", com.applovin.impl.sdk.utils.u.a(wVarCo.Fj(), ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPh)).intValue()), map);
        return map;
    }

    public Map<String, Object> DF() {
        Map<String, Object> map;
        synchronized (this.aDg) {
            map = CollectionUtils.map(this.avX);
        }
        CollectionUtils.putBooleanIfValid("first_install", Boolean.valueOf(this.sdk.CH()), map);
        CollectionUtils.putBooleanIfValid("first_install_v2", Boolean.valueOf(!this.sdk.BJ()), map);
        CollectionUtils.putBooleanIfValid("test_ads", Boolean.valueOf(this.aBj.CX()), map);
        CollectionUtils.putBooleanIfValid("muted", Boolean.valueOf(this.sdk.getSettings().isMuted()), map);
        CollectionUtils.putStringIfValid("user_segment_name", this.sdk.getUserSegment().getName(), map);
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.sdk.Ck().Ap(), map);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.sdk.Ck().Aq(), map);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.sdk.Ck().Ar(), map);
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOo)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.sdk.Bx(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOr)).booleanValue()) {
            CollectionUtils.putStringIfValid("compass_random_token", this.sdk.By(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOt)).booleanValue()) {
            CollectionUtils.putStringIfValid("applovin_random_token", this.sdk.Bz(), map);
        }
        if (this.sdk.BU() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.sdk.BU().Fq(), map);
        }
        return map;
    }

    private Map<String, Object> CZ() {
        HashMap map = new HashMap(21);
        CollectionUtils.putStringIfValid(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, this.aBj.Eg().getName(), map);
        CollectionUtils.putStringIfValid(TapjoyConstants.TJC_APP_VERSION_NAME, this.aBj.Eg().getVersion(), map);
        CollectionUtils.putStringIfValid(CampaignEx.JSON_KEY_PACKAGE_NAME, this.aBj.Eg().Ek(), map);
        CollectionUtils.putStringIfValid("vz", this.aBj.Eg().El(), map);
        CollectionUtils.putStringIfValid("installer_name", this.aBj.Eg().Em(), map);
        CollectionUtils.putIntegerIfValid("app_version_code", Integer.valueOf(this.aBj.Eg().getVersionCode()), map);
        CollectionUtils.putIntegerIfValid("target_sdk", Integer.valueOf(this.aBj.Eg().Ep()), map);
        CollectionUtils.putLongIfValid("first_install_v3_ms", this.aBj.Eg().En(), map);
        CollectionUtils.putLongIfValid("ia", Long.valueOf(this.aBj.Eg().Eo()), map);
        CollectionUtils.putLongIfValid("ia_v2", this.aBj.Eg().Ej(), map);
        CollectionUtils.putStringIfValid("tg", com.applovin.impl.sdk.utils.t.M(this.sdk), map);
        CollectionUtils.putStringIfValid("sdk_version", AppLovinSdk.VERSION, map);
        CollectionUtils.putStringIfValid("omid_sdk_version", this.sdk.Cn().getSdkVersion(), map);
        CollectionUtils.putStringIfValid("api_did", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aKh), map);
        CollectionUtils.putBooleanIfValid("debug", Boolean.valueOf(com.applovin.impl.sdk.utils.u.b(this.E, this.sdk)), map);
        CollectionUtils.putBooleanIfValid("j8", Boolean.valueOf(n.CF()), map);
        CollectionUtils.putIntegerIfValid("epv", Integer.valueOf(com.applovin.impl.sdk.utils.u.LA()), map);
        CollectionUtils.putLongIfValid("alts_ms", Long.valueOf(n.CE()), map);
        CollectionUtils.putBooleanIfValid("ps_tpg", Boolean.valueOf(aa.M(this.E)), map);
        CollectionUtils.putBooleanIfValid("ps_apg", Boolean.valueOf(aa.N(this.E)), map);
        CollectionUtils.putBooleanIfValid("ps_capg", Boolean.valueOf(aa.O(this.E)), map);
        CollectionUtils.putBooleanIfValid("ps_aipg", Boolean.valueOf(aa.P(this.E)), map);
        return map;
    }

    public Map<String, Object> Db() {
        HashMap map = new HashMap(5);
        CollectionUtils.putStringIfValid("sc", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aKn), map);
        CollectionUtils.putStringIfValid("sc2", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aKo), map);
        CollectionUtils.putStringIfValid("sc3", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aKp), map);
        CollectionUtils.putStringIfValid("server_installed_at", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aKq), map);
        CollectionUtils.putStringIfValid("persisted_data", (String) this.sdk.a(com.applovin.impl.sdk.c.d.aRH), map);
        return map;
    }
}
