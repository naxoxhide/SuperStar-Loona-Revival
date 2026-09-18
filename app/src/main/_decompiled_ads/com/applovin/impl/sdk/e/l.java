package com.applovin.impl.sdk.e;

import android.app.ActivityManager;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.security.ProviderInstaller;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l extends d {
    private static final AtomicBoolean aUa = new AtomicBoolean();
    private final int aCO;
    private final Object aUb;
    private a aUc;

    public interface a {
        void G(JSONObject jSONObject);
    }

    public l(int i, com.applovin.impl.sdk.n nVar, a aVar) {
        super("TaskFetchBasicSettings", nVar, true);
        this.aUb = new Object();
        this.aCO = i;
        this.aUc = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!com.applovin.impl.sdk.utils.h.La() && aUa.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(com.applovin.impl.sdk.n.getApplicationContext());
            } catch (Throwable th) {
                com.applovin.impl.sdk.x xVar = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.c(this.tag, "Cannot update security provider", th);
                }
            }
        }
        Map<String, String> mapER = ER();
        final com.applovin.impl.sdk.network.c cVarIe = com.applovin.impl.sdk.network.c.D(this.sdk).da(KB()).dc(KC()).k(mapER).K(vR()).aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQf)).booleanValue()).db("POST").ad(new JSONObject()).gC(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNQ)).intValue()).gE(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNT)).intValue()).gD(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNP)).intValue()).aR(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOc)).booleanValue()).a(com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPL)).intValue())).aT(true).Ie();
        this.sdk.BM().a(new b(this.sdk), q.b.TIMEOUT, ((long) ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNP)).intValue()) + 250);
        w<JSONObject> wVar = new w<JSONObject>(cVarIe, this.sdk, Kf()) { // from class: com.applovin.impl.sdk.e.l.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject, int i) {
                l.this.Q(jSONObject);
                this.sdk.Cq().b(cVarIe.zJ(), "fetchBasicSettings", i);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject) {
                com.applovin.impl.sdk.x xVar2 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i(this.tag, "Unable to fetch basic SDK settings: server returned " + i);
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                l.this.Q(jSONObject);
                this.sdk.Cq().b(cVarIe.zJ(), "fetchBasicSettings", i);
            }
        };
        wVar.e(com.applovin.impl.sdk.c.b.aLn);
        wVar.f(com.applovin.impl.sdk.c.b.aLo);
        this.sdk.BM().b(wVar);
    }

    protected Map<String, String> ER() {
        HashMap map = new HashMap();
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPU)).booleanValue() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
            map.put("rid", UUID.randomUUID().toString());
        }
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
        }
        Boolean boolB = com.applovin.impl.privacy.a.zN().B(rQ());
        if (boolB != null) {
            map.put(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, boolB.toString());
        }
        Boolean boolB2 = com.applovin.impl.privacy.a.zM().B(rQ());
        if (boolB2 != null) {
            map.put(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, boolB2.toString());
        }
        Boolean boolB3 = com.applovin.impl.privacy.a.zO().B(rQ());
        if (boolB3 != null) {
            map.put(AppLovinSdkExtraParameterKey.DO_NOT_SELL, boolB3.toString());
        }
        return map;
    }

    protected JSONObject vR() {
        Map<String, Object> mapCY;
        Map<String, Object> mapCQ;
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
                jSONObject.put("rid", UUID.randomUUID().toString());
            }
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            jSONObject.put("is_cross_promo", this.sdk.Bo());
            jSONObject.put("init_count", this.aCO);
            jSONObject.put("server_installed_at", this.sdk.a(com.applovin.impl.sdk.c.b.aKq));
            if (this.sdk.CH()) {
                jSONObject.put("first_install", true);
            }
            if (!this.sdk.BJ()) {
                jSONObject.put("first_install_v2", true);
            }
            JsonUtils.putStringIfValid(jSONObject, "plugin_version", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOy));
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider", this.sdk.getMediationProvider());
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider_v2", this.sdk.CI());
            jSONObject.put("installed_mediation_adapters", com.applovin.impl.mediation.e.c.f(this.sdk));
            if (this.sdk.BT() != null) {
                mapCY = this.sdk.BT().DF();
            } else {
                mapCY = this.sdk.BQ().CY();
            }
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, mapCY.get(CampaignEx.JSON_KEY_PACKAGE_NAME));
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, mapCY.get(TapjoyConstants.TJC_APP_VERSION_NAME));
            jSONObject.put("test_ads", mapCY.get("test_ads"));
            jSONObject.put("debug", mapCY.get("debug"));
            jSONObject.put("tg", mapCY.get("tg"));
            jSONObject.put("target_sdk", mapCY.get("target_sdk"));
            List<String> initializationAdUnitIds = this.sdk.getSettings().getInitializationAdUnitIds();
            if (initializationAdUnitIds != null && initializationAdUnitIds.size() > 0) {
                List<String> listRemoveTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(initializationAdUnitIds);
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(listRemoveTrimmedEmptyStrings, listRemoveTrimmedEmptyStrings.size()));
            }
            jSONObject.put("IABTCF_TCString", mapCY.get("IABTCF_TCString"));
            jSONObject.put("IABTCF_gdprApplies", mapCY.get("IABTCF_gdprApplies"));
            Object obj = mapCY.get("IABTCF_AddtlConsent");
            if (obj instanceof String) {
                JsonUtils.putStringIfValid(jSONObject, "IABTCF_AddtlConsent", (String) obj);
            }
            jSONObject.put("consent_flow_info", this.sdk.Cj().zZ());
            if (this.sdk.BT() != null) {
                mapCQ = this.sdk.BT().CQ();
            } else {
                mapCQ = this.sdk.BQ().CQ();
            }
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, mapCQ.get(TapjoyConstants.TJC_PLATFORM));
            jSONObject.put("os", mapCQ.get("os"));
            jSONObject.put("locale", mapCQ.get("locale"));
            jSONObject.put("brand", mapCQ.get("brand"));
            jSONObject.put("brand_name", mapCQ.get("brand_name"));
            jSONObject.put("hardware", mapCQ.get("hardware"));
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, mapCQ.get(DeviceRequestsHelper.DEVICE_INFO_MODEL));
            jSONObject.put("revision", mapCQ.get("revision"));
            jSONObject.put("is_tablet", mapCQ.get("is_tablet"));
            jSONObject.put("screen_size_in", mapCQ.get("screen_size_in"));
            jSONObject.put("supported_abis", mapCQ.get("supported_abis"));
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOH)).booleanValue()) {
                jSONObject.put("mtl", this.sdk.Cc().getLastTrimMemoryLevel());
            }
            try {
                ActivityManager activityManager = (ActivityManager) com.applovin.impl.sdk.n.getApplicationContext().getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("fm", memoryInfo.availMem);
                    jSONObject.put("tm", memoryInfo.totalMem);
                    jSONObject.put("lmt", memoryInfo.threshold);
                    jSONObject.put("lm", memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            Map<String, String> allData = this.sdk.BA().getAllData();
            if (!allData.isEmpty()) {
                jSONObject.put("targeting_data", new JSONObject(allData));
            }
            if (this.sdk.BT() != null) {
                com.applovin.impl.sdk.utils.d.a aVarDJ = this.sdk.BS().DJ();
                jSONObject.put("dnt", aVarDJ.KO());
                jSONObject.put("dnt_code", aVarDJ.KQ().KR());
                Boolean boolB = com.applovin.impl.privacy.a.zM().B(rQ());
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOu)).booleanValue() && StringUtils.isValidString(aVarDJ.KP()) && !Boolean.TRUE.equals(boolB)) {
                    jSONObject.put("idfa", aVarDJ.KP());
                }
                com.applovin.impl.sdk.q.b bVarDG = this.sdk.BS().DG();
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOn)).booleanValue() && bVarDG != null && !Boolean.TRUE.equals(boolB)) {
                    jSONObject.put("idfv", bVarDG.mQ());
                    jSONObject.put("idfv_scope", bVarDG.Eq());
                }
            } else {
                com.applovin.impl.sdk.utils.d.a aVarDf = this.sdk.BQ().Df();
                jSONObject.put("dnt", aVarDf.KO());
                jSONObject.put("dnt_code", aVarDf.KQ().KR());
                Boolean boolB2 = com.applovin.impl.privacy.a.zM().B(rQ());
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOu)).booleanValue() && StringUtils.isValidString(aVarDf.KP()) && !Boolean.TRUE.equals(boolB2)) {
                    jSONObject.put("idfa", aVarDf.KP());
                }
                com.applovin.impl.sdk.o.a aVarDg = this.sdk.BQ().Dg();
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOn)).booleanValue() && aVarDg != null && !Boolean.TRUE.equals(boolB2)) {
                    jSONObject.put("idfv", aVarDg.f11do);
                    jSONObject.put("idfv_scope", aVarDg.aDd);
                }
            }
            String name = this.sdk.getUserSegment().getName();
            if (StringUtils.isValidString(name)) {
                jSONObject.put("user_segment_name", StringUtils.encodeUriString(name));
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOq)).booleanValue()) {
                jSONObject.put("compass_random_token", this.sdk.By());
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOs)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.sdk.Bz());
            }
            if (this.sdk.CC().isEnabled()) {
                jSONObject.put("test_mode", true);
            }
            List<String> listXj = this.sdk.CC().xj();
            if (listXj != null && !listXj.isEmpty()) {
                jSONObject.put("test_mode_networks", listXj);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.sdk.getSettings().getExtraParameters()));
            if (this.aCO > 1) {
                ArrayService arrayServiceCp = this.sdk.Cp();
                if (arrayServiceCp.getIsDirectDownloadEnabled() != null) {
                    jSONObject.put("ah_dd_enabled", arrayServiceCp.getIsDirectDownloadEnabled());
                }
                jSONObject.put("ah_sdk_version_code", arrayServiceCp.getAppHubVersionCode());
                jSONObject.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceCp.getRandomUserToken()));
                jSONObject.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceCp.getAppHubPackageName()));
            }
        } catch (JSONException e) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.c(this.tag, "Failed to create JSON body", e);
            }
            this.sdk.Cq().d(this.tag, "createJSONBody", e);
        }
        return jSONObject;
    }

    private String KB() {
        return com.applovin.impl.sdk.utils.i.a((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLn), "5.0/i", getSdk());
    }

    private String KC() {
        return com.applovin.impl.sdk.utils.i.a((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLo), "5.0/i", getSdk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(JSONObject jSONObject) {
        a aVar;
        synchronized (this.aUb) {
            aVar = this.aUc;
            this.aUc = null;
        }
        if (aVar != null) {
            aVar.G(jSONObject);
        }
    }

    private class b extends d {
        public b(com.applovin.impl.sdk.n nVar) {
            super("TaskTimeoutFetchBasicSettings", nVar, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.aUc != null) {
                com.applovin.impl.sdk.x xVar = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i(this.tag, "Timing out fetch basic settings...");
                }
                l.this.Q(new JSONObject());
            }
        }
    }
}
