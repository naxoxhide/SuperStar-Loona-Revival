package com.applovin.impl.mediation.d;

import android.content.Context;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.v;
import com.applovin.impl.sdk.x;
import com.applovin.impl.sdk.y;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.applovin.impl.sdk.e.d {
    private final Context E;
    private final String adUnitId;
    private final Map<String, Object> alQ;
    private final com.applovin.impl.mediation.ads.a.InterfaceC0117a amJ;
    private final JSONArray awo;
    private final Map<String, Object> extraParameters;
    private final MaxAdFormat format;
    private final Map<String, Object> localExtraParameters;

    public c(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, JSONArray jSONArray, Context context, n nVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        super("TaskFetchMediatedAd", nVar, str);
        this.adUnitId = str;
        this.format = maxAdFormat;
        this.localExtraParameters = map;
        this.extraParameters = map2;
        this.alQ = map3;
        this.awo = jSONArray;
        this.E = context;
        this.amJ = interfaceC0117a;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Fetching next ad for " + this.format.getLabel() + " ad unit " + this.adUnitId);
        }
        v.Fd();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOE)).booleanValue() && u.Lx()) {
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "User is connected to a VPN");
            }
        }
        com.applovin.impl.sdk.d.g gVarBP = this.sdk.BP();
        gVarBP.a(com.applovin.impl.sdk.d.f.aTc);
        if (gVarBP.b(com.applovin.impl.sdk.d.f.aSQ) == 0) {
            gVarBP.b(com.applovin.impl.sdk.d.f.aSQ, System.currentTimeMillis());
        }
        try {
            JSONObject jSONObjectZD = zD();
            HashMap map = new HashMap();
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPV)).booleanValue() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
                map.put("rid", UUID.randomUUID().toString());
            }
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
            }
            if (this.sdk.CC().isEnabled()) {
                map.put("test_mode", "1");
            }
            List<String> listXj = this.sdk.CC().xj();
            String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.FILTER_AD_NETWORK);
            if (listXj != null && !listXj.isEmpty()) {
                String strM0 = c$$ExternalSynthetic0.m0(",", listXj);
                map.put("filter_ad_network", strM0);
                if (!this.sdk.CC().isEnabled()) {
                    map.put("fhkZsVqYC7", "1");
                }
                if (this.sdk.CC().xi()) {
                    map.put("force_ad_network", strM0);
                }
            } else if (StringUtils.isValidString(str)) {
                map.put("filter_ad_network", str);
            }
            a(gVarBP);
            final com.applovin.impl.sdk.network.c cVarIe = com.applovin.impl.sdk.network.c.D(this.sdk).db("POST").l(zC()).da(zA()).dc(zB()).k(map).K(jSONObjectZD).aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aKb)).booleanValue()).ad(new JSONObject()).gD(((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJf)).intValue()).gC(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNK)).intValue()).gE(((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJe)).intValue()).a(p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPM)).intValue())).aT(true).Ie();
            w<JSONObject> wVar = new w<JSONObject>(cVarIe, this.sdk) { // from class: com.applovin.impl.mediation.d.c.1
                @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void d(JSONObject jSONObject, int i) {
                    if (i != 200) {
                        c.this.e(i, null);
                        this.sdk.Cq().b(cVarIe.zJ(), "fetchMediatedAd", i);
                    } else {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.aHr.getLatencyMillis());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.aHr.HJ());
                        c.this.q(jSONObject);
                    }
                }

                @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
                public void a(int i, String str2, JSONObject jSONObject) {
                    c.this.e(i, str2);
                    this.sdk.Cq().b(cVarIe.zJ(), "fetchMediatedAd", i);
                }
            };
            wVar.e(com.applovin.impl.sdk.c.a.aJc);
            wVar.f(com.applovin.impl.sdk.c.a.aJd);
            this.sdk.BM().b(wVar);
        } catch (Throwable th) {
            x xVar3 = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Unable to fetch ad for ad unit " + this.adUnitId, th);
            }
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }

    private String zA() {
        return com.applovin.impl.mediation.e.b.b(this.sdk);
    }

    private String zB() {
        return com.applovin.impl.mediation.e.b.c(this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject) {
        try {
            i.j(jSONObject, this.sdk);
            i.i(jSONObject, this.sdk);
            i.k(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.d(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.e(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.f(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.z(jSONObject);
            com.applovin.impl.sdk.g.o(this.sdk);
            MaxAdFormat fromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, null));
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQM)).booleanValue()) {
                if (u.a(this.format, fromString)) {
                    r(jSONObject);
                    return;
                }
                String label = fromString != null ? fromString.getLabel() : "UNKNOWN";
                String str = "Requested ad format " + this.format.getLabel() + " is not compatible with received ad format " + label;
                x.H(this.tag, str);
                this.amJ.onAdLoadFailed(this.adUnitId, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str));
                this.sdk.Cq().a(r.a.INTEGRATION_ERROR, "incompatible_ad_format", "pubId=" + ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKl)) + ",adUnitId=" + this.adUnitId + ",adInstanceFormat=" + this.format.getLabel() + ",adResponseFormat=" + label);
                return;
            }
            if (this.format != fromString) {
                x.H(this.tag, "Ad format requested (" + this.format.getLabel() + ") does not match ad format for ad unit id " + this.adUnitId + " (" + (fromString != null ? fromString.getLabel() : "UNKNOWN") + ")");
            }
            r(jSONObject);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Unable to process mediated ad response for ad unit " + this.adUnitId, th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private void r(JSONObject jSONObject) {
        com.applovin.impl.sdk.e.d fVar;
        if (this.sdk.a(com.applovin.impl.sdk.c.a.aJX, this.format)) {
            fVar = new e(this.adUnitId, this.format, this.localExtraParameters, jSONObject, this.E, this.sdk, this.amJ);
        } else {
            fVar = new f(this.adUnitId, this.format, this.localExtraParameters, jSONObject, this.E, this.sdk, this.amJ);
        }
        this.sdk.BM().b(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, String str) {
        MaxErrorImpl maxErrorImpl;
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.i(this.tag, "Unable to fetch ad for ad unit " + this.adUnitId + ": server returned " + i);
        }
        if (i == -800) {
            this.sdk.BP().a(com.applovin.impl.sdk.d.f.aTd);
        }
        if (i == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str);
        } else if (i == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str);
        } else if (StringUtils.isValidString(str)) {
            maxErrorImpl = new MaxErrorImpl(-1000, str);
        } else {
            maxErrorImpl = new MaxErrorImpl(-1);
        }
        m.a(this.amJ, this.adUnitId, maxErrorImpl);
    }

    private void a(com.applovin.impl.sdk.d.g gVar) {
        long jB = gVar.b(com.applovin.impl.sdk.d.f.aSQ);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jB > TimeUnit.MINUTES.toMillis(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aOf)).intValue())) {
            gVar.b(com.applovin.impl.sdk.d.f.aSQ, jCurrentTimeMillis);
            gVar.c(com.applovin.impl.sdk.d.f.aSR);
            gVar.c(com.applovin.impl.sdk.d.f.aSS);
        }
    }

    private Map<String, String> zC() {
        HashMap map = new HashMap(2);
        map.put("AppLovin-Ad-Unit-Id", this.adUnitId);
        map.put("AppLovin-Ad-Format", this.format.getLabel());
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", this.extraParameters.get("retry_attempt"), map);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", this.extraParameters.get("retry_delay_sec"), map);
        return map;
    }

    private JSONObject zD() throws JSONException {
        Map<String, Object> mapA;
        if (this.sdk.BT() != null) {
            mapA = this.sdk.BT().a(null, false, true);
        } else {
            mapA = this.sdk.BQ().a(null, false, true);
        }
        mapA.putAll(this.alQ);
        JSONObject jSONObject = new JSONObject(mapA);
        u(jSONObject);
        t(jSONObject);
        s(jSONObject);
        v(jSONObject);
        w(jSONObject);
        return jSONObject;
    }

    private void s(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray((Collection) this.sdk.Cu().tZ()));
            jSONObject2.put(TapjoyConstants.TJC_INSTALLED, com.applovin.impl.mediation.e.c.f(this.sdk));
            jSONObject2.put("initialized", this.sdk.Cv().tW());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.sdk.Cv().tV().keySet()));
            jSONObject2.put("loaded_classnames", new JSONArray((Collection) this.sdk.Cu().tX()));
            jSONObject2.put("failed_classnames", new JSONArray((Collection) this.sdk.Cu().tY()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to populate adapter classNames", e);
            }
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    private void t(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.awo;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    private void u(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.adUnitId);
        jSONObject2.put(FirebaseAnalytics.Param.AD_FORMAT, this.format.getLabel());
        Map map = CollectionUtils.map(this.extraParameters);
        y.a aVarCO = this.sdk.CA().cO(this.adUnitId);
        if (aVarCO != null) {
            if (Boolean.parseBoolean(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.ENABLE_SEQUENTIAL_CACHING))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", ADXLogUtil.PLATFORM_APPLOVIN);
            } else {
                map.put("previous_winning_network", aVarCO.yz());
                map.put("previous_winning_network_name", aVarCO.getNetworkName());
                CollectionUtils.putStringIfValid("second_previous_winning_network", aVarCO.Fl(), map);
                CollectionUtils.putStringIfValid("second_previous_winning_network_name", aVarCO.Fm(), map);
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void v(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.sdk.Cw().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData == null || !u.ai(n.getApplicationContext())) {
            return;
        }
        JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
    }

    private void w(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.sdk.getSettings().getExtraParameters()));
    }
}
