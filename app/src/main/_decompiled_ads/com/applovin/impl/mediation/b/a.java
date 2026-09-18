package com.applovin.impl.mediation.b;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends f implements MaxAd {
    private final int Y;
    private final String aph;
    private final AtomicBoolean aur;
    private final AtomicBoolean aus;
    protected com.applovin.impl.mediation.g aut;
    private String auu;
    private com.applovin.impl.mediation.a.c auv;
    private String loadTag;
    private long requestLatencyMillis;
    private MaxAdWaterfallInfo waterfall;

    public abstract a k(com.applovin.impl.mediation.g gVar);

    public int ah() {
        return this.Y;
    }

    public static a a(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        String string = JsonUtils.getString(jSONObject2, FirebaseAnalytics.Param.AD_FORMAT, null);
        MaxAdFormat fromString = MaxAdFormat.formatFromString(string);
        Objects.requireNonNull(fromString, "Invalid ad format for string: " + string);
        if (fromString.isAdViewAd()) {
            return new b(i, map, jSONObject, jSONObject2, nVar);
        }
        if (fromString == MaxAdFormat.NATIVE) {
            return new d(i, map, jSONObject, jSONObject2, nVar);
        }
        if (fromString.isFullscreenAd()) {
            return new c(i, map, jSONObject, jSONObject2, nVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    protected a(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.g gVar, n nVar) {
        super(map, jSONObject, jSONObject2, nVar);
        this.aur = new AtomicBoolean();
        this.aus = new AtomicBoolean();
        this.Y = i;
        this.aut = gVar;
        this.aph = gVar != null ? gVar.getAdapterVersion() : null;
    }

    public String xr() {
        return getStringFromAdObject("bcode", "");
    }

    public long xs() {
        return getLongFromAdObject("bwt_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJY)).longValue());
    }

    public long xt() {
        return getLongFromAdObject("twt_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJZ)).longValue());
    }

    public void setWaterfall(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.waterfall = maxAdWaterfallInfo;
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdWaterfallInfo getWaterfall() {
        return this.waterfall;
    }

    public void setRequestLatencyMillis(long j) {
        this.requestLatencyMillis = j;
    }

    @Override // com.applovin.mediation.MaxAd
    public long getRequestLatencyMillis() {
        return this.requestLatencyMillis;
    }

    public void setLoadTag(String str) {
        this.loadTag = str;
    }

    public String getLoadTag() {
        return this.loadTag;
    }

    public void bV(String str) {
        this.auu = str;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdReviewCreativeId() {
        return this.auu;
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(getStringFromAdObject(FirebaseAnalytics.Param.AD_FORMAT, getStringFromFullResponse(FirebaseAnalytics.Param.AD_FORMAT, null)));
    }

    @Override // com.applovin.mediation.MaxAd
    public AppLovinSdkUtils.Size getSize() {
        int intFromAdObject = getIntFromAdObject("ad_width", -3);
        int intFromAdObject2 = getIntFromAdObject("ad_height", -3);
        if (intFromAdObject == -3 || intFromAdObject2 == -3) {
            return getFormat().getSize();
        }
        return new AppLovinSdkUtils.Size(intFromAdObject, intFromAdObject2);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkName() {
        return getStringFromAdObject("network_name", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(getThirdPartyAdPlacementId());
    }

    @Override // com.applovin.mediation.MaxAd
    public String getCreativeId() {
        return getStringFromAdObject(CampaignEx.JSON_KEY_CREATIVE_ID, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public double getRevenue() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJV)).booleanValue() && getFormat().isFullscreenAd() && !xN().get()) {
            this.sdk.BL();
            if (!x.Fk()) {
                return 0.0d;
            }
            this.sdk.BL().i("MediatedAd", "Attempting to retrieve revenue when not available yet");
            return 0.0d;
        }
        return JsonUtils.getDouble(getJsonObjectFromAdObject("revenue_parameters", null), "revenue", -1.0d);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getRevenuePrecision() {
        return JsonUtils.getString(getJsonObjectFromAdObject("revenue_parameters", null), "precision", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspName() {
        return getStringFromAdObject("dsp_name", null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspId() {
        return getStringFromAdObject("dsp_id", null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str, String str2) {
        JSONObject jSONObjectXv = xv();
        if (jSONObjectXv.has(str)) {
            return JsonUtils.getString(jSONObjectXv, str, str2);
        }
        Bundle serverParameters = getServerParameters();
        if (serverParameters.containsKey(str)) {
            return serverParameters.getString(str);
        }
        JSONObject jSONObjectXw = xw();
        if (jSONObjectXw.has(str)) {
            return JsonUtils.getString(jSONObjectXw, str, str2);
        }
        return getStringFromAdObject(str, str2);
    }

    public double xu() {
        return a("price", -1.0f);
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectXv = xv();
        JsonUtils.putAll(jSONObjectXv, jSONObject);
        a("ad_values", jSONObjectXv);
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectXw = xw();
        JsonUtils.putAll(jSONObjectXw, jSONObject);
        a("publisher_extra_info", jSONObjectXw);
    }

    public JSONObject xv() {
        return getJsonObjectFromAdObject("ad_values", new JSONObject());
    }

    public JSONObject xw() {
        return getJsonObjectFromAdObject("publisher_extra_info", new JSONObject());
    }

    public JSONObject xx() {
        return getJsonObjectFromAdObject("revenue_parameters", new JSONObject());
    }

    public String xy() {
        return JsonUtils.getString(xx(), "revenue_event", "");
    }

    public String xz() {
        return getStringFromFullResponse("event_id", "");
    }

    public String xA() {
        return getStringFromAdObject("adomain", null);
    }

    public boolean isReady() {
        com.applovin.impl.mediation.g gVar = this.aut;
        return gVar != null && gVar.isEnabled() && this.aut.ug();
    }

    public com.applovin.impl.mediation.g xB() {
        return this.aut;
    }

    public String getAdapterVersion() {
        return this.aph;
    }

    public Bundle getCredentials() {
        JSONObject jsonObjectFromAdObject;
        if (bX("credentials")) {
            jsonObjectFromAdObject = getJsonObjectFromAdObject("credentials", new JSONObject());
        } else {
            jsonObjectFromAdObject = getJsonObjectFromAdObject("server_parameters", new JSONObject());
            JsonUtils.putString(jsonObjectFromAdObject, FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, getThirdPartyAdPlacementId());
        }
        return JsonUtils.toBundle(jsonObjectFromAdObject);
    }

    public String getBidResponse() {
        return getStringFromAdObject("bid_response", null);
    }

    public boolean isBidding() {
        return StringUtils.isValidString(getBidResponse());
    }

    public long getBidExpirationMillis() {
        return getLongFromAdObject("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1L, getServerParameters()));
    }

    public boolean xC() {
        return b("is_js_tag_ad", (Boolean) false).booleanValue();
    }

    public MaxAdFormat xD() {
        String stringFromAdObject = getStringFromAdObject("haf", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return MaxAdFormat.formatFromString(stringFromAdObject);
        }
        return null;
    }

    public boolean xE() {
        return xD() != null;
    }

    public com.applovin.impl.mediation.a.c xF() {
        com.applovin.impl.mediation.a.c cVar = this.auv;
        if (cVar != null) {
            return cVar;
        }
        com.applovin.impl.mediation.a.c cVar2 = new com.applovin.impl.mediation.a.c(getJsonObjectFromAdObject("hybrid_ad_config", null));
        this.auv = cVar2;
        return cVar2;
    }

    public View getAdView() {
        com.applovin.impl.mediation.g gVar;
        if (!isReady() || (gVar = this.aut) == null) {
            return null;
        }
        return gVar.ub();
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxNativeAd getNativeAd() {
        com.applovin.impl.mediation.g gVar = this.aut;
        if (gVar != null) {
            return gVar.uc();
        }
        return null;
    }

    public String getThirdPartyAdPlacementId() {
        return getStringFromAdObject("third_party_ad_placement_id", null);
    }

    public String xG() {
        return getStringFromFullResponse("waterfall_name", "");
    }

    public String xH() {
        return getStringFromFullResponse("waterfall_test_name", "");
    }

    public long xI() {
        if (xJ() > 0) {
            return xL() - xJ();
        }
        return -1L;
    }

    private long xJ() {
        return getLongFromAdObject("load_started_time_ms", 0L);
    }

    public void xK() {
        e("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public long xL() {
        return getLongFromAdObject("load_completed_time_ms", 0L);
    }

    public void xM() {
        e("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public AtomicBoolean xN() {
        return this.aur;
    }

    public AtomicBoolean xO() {
        return this.aus;
    }

    public void xP() {
        this.aut = null;
        this.waterfall = null;
    }

    public void S(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("ad_values")) {
            g(BundleUtils.toJSONObject(bundle.getBundle("ad_values")));
        }
        if (bundle.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && !bX(CampaignEx.JSON_KEY_CREATIVE_ID)) {
            x(CampaignEx.JSON_KEY_CREATIVE_ID, BundleUtils.getString(CampaignEx.JSON_KEY_CREATIVE_ID, bundle));
        }
        if (bundle.containsKey("ad_width") && !bX("ad_width") && bundle.containsKey("ad_height") && !bX("ad_height")) {
            int i = BundleUtils.getInt("ad_width", bundle);
            int i2 = BundleUtils.getInt("ad_height", bundle);
            d("ad_width", i);
            d("ad_height", i2);
        }
        if (bundle.containsKey("publisher_extra_info")) {
            h(BundleUtils.toJSONObject(bundle.getBundle("publisher_extra_info")));
        }
    }

    @Override // com.applovin.impl.mediation.b.f
    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + getThirdPartyAdPlacementId() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }
}
