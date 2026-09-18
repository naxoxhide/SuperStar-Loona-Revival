package com.applovin.impl.mediation.c.b;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.mediation.c.b {
    public static final Uri avV = Uri.parse("https://api.taboola.com/");
    private final String avK;
    private String avN;
    private final Uri avW;
    private final Map<String, Object> avX;
    private String avY;

    public a(String str, String str2, String str3, n nVar) {
        super("TaboolaApiService", nVar);
        this.avN = "init";
        this.avY = "";
        this.avK = str;
        this.avW = Uri.withAppendedPath(URLUtil.isValidUrl(str3) ? Uri.parse(str3) : avV, "2.0/json/" + str2);
        HashMap map = new HashMap(3);
        this.avX = map;
        map.put("type", TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE);
        map.put(DynamicLink.Builder.KEY_API_KEY, str);
        map.put("origin", "SERVER");
    }

    public void a(MaxAdapterInitializationParameters maxAdapterInitializationParameters, b bVar) {
        String str = (String) this.sdk.b(com.applovin.impl.mediation.c.c.avA, null, this.avs);
        Long l = (Long) this.sdk.b(com.applovin.impl.mediation.c.c.avB, null, this.avs);
        if (!StringUtils.isValidString(str) || l == null) {
            a(bVar);
        } else if (maxAdapterInitializationParameters.getServerParameters().getLong("user_id_expiration_millis", TimeUnit.DAYS.toMillis(30L)) - (System.currentTimeMillis() - l.longValue()) > TimeUnit.HOURS.toMillis(1L)) {
            this.avY = str;
            bVar.onInitialized(true, null);
        } else {
            a(bVar);
        }
    }

    public void a(final MaxAdapterResponseParameters maxAdapterResponseParameters, final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJSONObject(jSONObject, "app", new JSONObject(this.avX));
        JsonUtils.putJSONObject(jSONObject, "consent", zy());
        JsonUtils.putJSONObject(jSONObject, "user", a(maxAdapterResponseParameters));
        JsonUtils.putJSONObject(jSONObject, "source", b(maxAdapterResponseParameters));
        JsonUtils.putJSONObject(jSONObject, "view", c(maxAdapterResponseParameters));
        JsonUtils.putJsonArray(jSONObject, "placements", d(maxAdapterResponseParameters));
        this.sdk.BM().b(new w<JSONObject>(com.applovin.impl.sdk.network.c.D(this.sdk).da(this.avW.toString() + "/recommendations.get").db("POST").K(jSONObject).ad(new JSONObject()).aS(false).aU(false).Ie(), this.sdk) { // from class: com.applovin.impl.mediation.c.b.a.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject2, int i) {
                if (i == 200 && jSONObject2 != null) {
                    a.this.avN = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject2, "user", new JSONObject()), "session", "");
                    this.sdk.BM().b(new c(jSONObject2, maxAdapterResponseParameters, MaxAdFormat.NATIVE, appLovinNativeAdLoadListener, this.sdk));
                    return;
                }
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to fetch " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + " Taboola ad: server returned " + i);
                }
                appLovinNativeAdLoadListener.onNativeAdLoadFailed(new AppLovinError(i, "Taboola server returned with code: " + jSONObject2));
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject2) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to fetch " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + " Taboola ad: server returned " + i);
                }
                appLovinNativeAdLoadListener.onNativeAdLoadFailed(new AppLovinError(i, "Taboola server returned with code: " + jSONObject2));
            }
        });
    }

    private void a(final b bVar) {
        HashMap map = new HashMap(2);
        map.put("app.type", TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE);
        map.put("app.apikey", this.avK);
        this.sdk.BM().b(new w<JSONObject>(com.applovin.impl.sdk.network.c.D(this.sdk).da(this.avW.toString() + "/user.sync").db("GET").k(map).ad(new JSONObject()).aS(false).aU(false).Ie(), this.sdk) { // from class: com.applovin.impl.mediation.c.b.a.2
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject, int i) {
                if (i == 200 && jSONObject != null) {
                    a.this.avY = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "user", new JSONObject()), "id", "");
                    this.sdk.a(com.applovin.impl.mediation.c.c.avA, a.this.avY, a.this.avs);
                    this.sdk.a(com.applovin.impl.mediation.c.c.avB, Long.valueOf(System.currentTimeMillis()), a.this.avs);
                    bVar.onInitialized(true, null);
                    return;
                }
                String str = "Unable to fetch user id. Server returned " + i;
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, str);
                }
                bVar.onInitialized(false, str);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to fetch user id. Server returned " + i);
                }
                bVar.onInitialized(false, str);
            }
        });
    }

    private JSONObject zy() {
        Map<String, Object> mapCY;
        JSONObject jSONObject = new JSONObject();
        if (this.sdk.BT() != null) {
            mapCY = this.sdk.BT().DF();
        } else {
            mapCY = this.sdk.BQ().CY();
        }
        Object obj = mapCY.get("IABTCF_gdprApplies");
        if (obj != null) {
            JsonUtils.putObject(jSONObject, "gdpr_applies", obj);
            JsonUtils.putString(jSONObject, "daisyBit", String.valueOf(mapCY.get("IABTCF_TCString")));
        }
        return jSONObject;
    }

    private JSONObject a(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        Map<String, Object> mapCS;
        if (this.sdk.BT() != null) {
            mapCS = this.sdk.BT().CS();
        } else {
            mapCS = this.sdk.BQ().CS();
        }
        String strValueOf = String.valueOf(mapCS.get("ua"));
        String strValueOf2 = String.valueOf(mapCS.get("idfa"));
        String str = this.avN;
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        if (localExtraParameters.containsKey("taboola_session")) {
            Object obj = localExtraParameters.get("taboola_session");
            if (obj instanceof String) {
                str = (String) obj;
            }
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "session", str);
        if (strValueOf == null) {
            strValueOf = "";
        }
        JsonUtils.putString(jSONObject, "agent", strValueOf);
        if (strValueOf2 == null) {
            strValueOf2 = "";
        }
        JsonUtils.putString(jSONObject, DeviceRequestsHelper.DEVICE_INFO_DEVICE, strValueOf2);
        JsonUtils.putString(jSONObject, "id", this.avY);
        JsonUtils.putString(jSONObject, "realip", maxAdapterResponseParameters.getServerParameters().getString("s2s_ip", ""));
        return jSONObject;
    }

    private JSONObject b(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "type", maxAdapterResponseParameters.getCustomParameters().getString("source_type", ""));
        JsonUtils.putString(jSONObject, "id", maxAdapterResponseParameters.getCustomParameters().getString("source_id", ""));
        JsonUtils.putString(jSONObject, "url", maxAdapterResponseParameters.getCustomParameters().getString("source_url", ""));
        return jSONObject;
    }

    private JSONObject c(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "id", a(maxAdapterResponseParameters, "taboola_view_id", ""));
        return jSONObject;
    }

    private JSONArray d(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "name", maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        JsonUtils.putInt(jSONObject, "recCount", 1);
        JsonUtils.putString(jSONObject, "organicType", maxAdapterResponseParameters.getCustomParameters().getString("placement_type", "MIX"));
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        if (localExtraParameters.containsKey("taboola_thumbnail_height") && localExtraParameters.containsKey("taboola_thumbnail_width")) {
            Integer numA = a(maxAdapterResponseParameters, "taboola_thumbnail_height", (Integer) 0);
            Integer numA2 = a(maxAdapterResponseParameters, "taboola_thumbnail_width", (Integer) 0);
            if (numA.intValue() > 0 && numA2.intValue() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.putInt(jSONObject2, "width", numA.intValue());
                JsonUtils.putInt(jSONObject2, "height", numA2.intValue());
                JsonUtils.putJSONObject(jSONObject, "thumbnail", jSONObject2);
            }
        }
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    private String a(MaxAdapterResponseParameters maxAdapterResponseParameters, String str, String str2) {
        if (maxAdapterResponseParameters.getLocalExtraParameters().containsKey(str)) {
            Object obj = maxAdapterResponseParameters.getLocalExtraParameters().get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return maxAdapterResponseParameters.getCustomParameters().getString(str, str2);
    }

    private Integer a(MaxAdapterResponseParameters maxAdapterResponseParameters, String str, Integer num) {
        if (maxAdapterResponseParameters.getLocalExtraParameters().containsKey(str)) {
            Object obj = maxAdapterResponseParameters.getLocalExtraParameters().get(str);
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
        }
        return Integer.valueOf(maxAdapterResponseParameters.getCustomParameters().getInt(str, num.intValue()));
    }
}
