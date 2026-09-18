package com.applovin.impl.mediation.c;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends com.applovin.impl.sdk.e.d {
    private static JSONObject avD;
    private static JSONObject avE;
    private static JSONObject avF;
    protected final JSONObject avG;
    private final AppLovinAdSize avH;
    private final AppLovinAdType avI;
    protected String avJ;
    protected final MaxAdFormat format;
    protected final MaxAdapterResponseParameters parameters;
    protected final n sdk;

    protected abstract JSONObject zt();

    public d(String str, JSONObject jSONObject, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, n nVar) {
        super(str, nVar);
        this.avG = jSONObject;
        this.parameters = maxAdapterResponseParameters;
        this.format = maxAdFormat;
        this.sdk = nVar;
        this.avH = d(maxAdFormat);
        this.avI = e(maxAdFormat);
    }

    protected JSONObject o(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "ad_size", this.avH.toString());
        JsonUtils.putString(jSONObject2, "ad_type", this.avI.toString());
        JsonUtils.putString(jSONObject2, "dsp_name", this.avJ);
        JsonUtils.putInt(jSONObject2, "status", 200);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        JsonUtils.putJsonArray(jSONObject2, CampaignUnit.JSON_KEY_ADS, jSONArray);
        return jSONObject2;
    }

    protected JSONObject a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectZu = zu();
        JsonUtils.putAll(jSONObjectZu, JsonUtils.deserialize(this.parameters.getServerParameters().getString("ad_object")));
        JsonUtils.putString(jSONObjectZu, TJAdUnitConstants.String.HTML, str);
        JsonUtils.putJSONObject(jSONObjectZu, "click_tracking_urls", jSONObject);
        JsonUtils.putJSONObject(jSONObjectZu, "imp_urls", jSONObject2);
        return jSONObjectZu;
    }

    protected JSONObject a(a aVar) {
        JSONObject jSONObjectZv = zv();
        JsonUtils.putAll(jSONObjectZv, JsonUtils.deserialize(this.parameters.getServerParameters().getString("ad_object")));
        JsonUtils.putJSONObject(jSONObjectZv, "ortb_response", b(aVar));
        return jSONObjectZv;
    }

    private JSONObject zu() {
        JSONObject jSONObject = avD;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putInt(jSONObject2, "ad_id", 0);
        JsonUtils.putString(jSONObject2, "base_url", "file://");
        JsonUtils.putString(jSONObject2, "graphic_background_color", "#000000");
        JsonUtils.putBoolean(jSONObject2, "lock_current_orientation", true);
        JsonUtils.putBoolean(jSONObject2, "omsdk_enabled", false);
        JsonUtils.putBoolean(jSONObject2, "playback_requires_user_action", true);
        JsonUtils.putString(jSONObject2, "presentation_mode", "activity");
        JsonUtils.putBoolean(jSONObject2, "unhide_adview_on_render", true);
        JsonUtils.putJSONObject(jSONObject2, "web_view_settings", zw());
        avD = jSONObject2;
        return jSONObject2;
    }

    private JSONObject zv() {
        JSONObject jSONObject = avE;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putInt(jSONObject2, "ad_id", 0);
        JsonUtils.putBoolean(jSONObject2, "uerp", true);
        JsonUtils.putString(jSONObject2, "presentation_mode", "activity");
        JsonUtils.putJSONObject(jSONObject2, "web_view_settings", zw());
        avE = jSONObject2;
        return jSONObject2;
    }

    private JSONObject b(a aVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArray(jSONObject, "assets", c(aVar));
        JsonUtils.putJSONObject(jSONObject, "link", d(aVar));
        JsonUtils.putJsonArray(jSONObject, "eventtrackers", e(aVar));
        JsonUtils.putString(jSONObject, "ver", aVar.getVersion());
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putJSONObject(jSONObject2, "native", jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        JsonUtils.putString(jSONObject3, "version", aVar.getVersion());
        JsonUtils.putJSONObject(jSONObject3, "value", jSONObject2);
        return jSONObject3;
    }

    private JSONArray c(a aVar) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, "id", 1);
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "text", aVar.getTitle());
        JsonUtils.putJSONObject(jSONObject, "title", jSONObject2);
        jSONArray.put(jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        JsonUtils.putInt(jSONObject3, "id", 8);
        JSONObject jSONObject4 = new JSONObject();
        JsonUtils.putString(jSONObject4, "value", aVar.getAdvertiser());
        JsonUtils.putJSONObject(jSONObject3, "data", jSONObject4);
        jSONArray.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        JsonUtils.putInt(jSONObject5, "id", 4);
        JSONObject jSONObject6 = new JSONObject();
        JsonUtils.putString(jSONObject6, "value", aVar.getBody());
        JsonUtils.putJSONObject(jSONObject5, "data", jSONObject6);
        jSONArray.put(jSONObject5);
        if (StringUtils.isValidString(aVar.yZ())) {
            JSONObject jSONObject7 = new JSONObject();
            JsonUtils.putInt(jSONObject7, "id", 2);
            JSONObject jSONObject8 = new JSONObject();
            JsonUtils.putString(jSONObject8, "url", aVar.yZ());
            JsonUtils.putInt(jSONObject8, "w", aVar.za());
            JsonUtils.putInt(jSONObject8, "h", aVar.zb());
            JsonUtils.putJSONObject(jSONObject7, "img", jSONObject8);
            jSONArray.put(jSONObject7);
        }
        return jSONArray;
    }

    private JSONObject d(a aVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "url", aVar.zc());
        JsonUtils.putJsonArray(jSONObject, "clicktrackers", aVar.zd());
        return jSONObject;
    }

    private JSONArray e(a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (String str : aVar.zf()) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, "url", str);
            JsonUtils.putInt(jSONObject, "event", 1);
            JsonUtils.putInt(jSONObject, "method", 1);
            jSONArray.put(jSONObject);
        }
        for (String str2 : aVar.ze()) {
            JSONObject jSONObject2 = new JSONObject();
            JsonUtils.putString(jSONObject2, "url", str2);
            JsonUtils.putInt(jSONObject2, "type", 1);
            JsonUtils.putInt(jSONObject2, "method", 2);
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    private static AppLovinAdSize d(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isFullscreenAd()) {
            return AppLovinAdSize.INTERSTITIAL;
        }
        if (MaxAdFormat.BANNER == maxAdFormat) {
            return AppLovinAdSize.BANNER;
        }
        if (MaxAdFormat.LEADER == maxAdFormat) {
            return AppLovinAdSize.LEADER;
        }
        if (MaxAdFormat.MREC == maxAdFormat) {
            return AppLovinAdSize.MREC;
        }
        if (MaxAdFormat.NATIVE == maxAdFormat) {
            return AppLovinAdSize.NATIVE;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    private static AppLovinAdType e(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd() || MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            return AppLovinAdType.REGULAR;
        }
        if (MaxAdFormat.NATIVE == maxAdFormat) {
            return AppLovinAdType.NATIVE;
        }
        if (MaxAdFormat.REWARDED == maxAdFormat) {
            return AppLovinAdType.INCENTIVIZED;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            return AppLovinAdType.AUTO_INCENTIVIZED;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            return AppLovinAdType.APP_OPEN;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    private static JSONObject zw() {
        JSONObject jSONObject = avF;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putBoolean(jSONObject2, "allow_file_access", true);
        avF = jSONObject2;
        return jSONObject2;
    }
}
