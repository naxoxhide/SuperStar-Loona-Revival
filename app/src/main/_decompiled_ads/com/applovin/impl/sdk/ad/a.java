package com.applovin.impl.sdk.ad;

import android.net.Uri;
import com.applovin.impl.adview.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e {
    private final String aFX;
    private final String aFY;
    private final String aFZ;
    private final com.applovin.impl.sdk.a.c aGa;

    public a(JSONObject jSONObject, JSONObject jSONObject2, b bVar, n nVar) {
        super(jSONObject, jSONObject2, bVar, nVar);
        this.aFX = Fz();
        this.aFY = FH();
        this.aFZ = FE();
        this.aGa = new com.applovin.impl.sdk.a.c(this);
    }

    @Override // com.applovin.impl.sdk.ad.e
    public void Fy() {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, TJAdUnitConstants.String.HTML, this.aFX);
            JsonUtils.putString(this.adObject, "stream_url", this.aFZ);
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        JSONObject jSONObjectDeepCopy;
        synchronized (this.fullResponseLock) {
            jSONObjectDeepCopy = JsonUtils.deepCopy(this.fullResponse);
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectDeepCopy, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, TJAdUnitConstants.String.HTML, this.aFX);
            JsonUtils.putString(jSONObject, "video", this.aFY);
            JsonUtils.putString(jSONObject, "stream_url", this.aFZ);
        }
        return jSONObjectDeepCopy;
    }

    public String Fz() {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, TJAdUnitConstants.String.HTML, "");
        }
        return string;
    }

    public void cT(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, TJAdUnitConstants.String.HTML, str);
        }
    }

    @Override // com.applovin.impl.sdk.ad.e, com.applovin.impl.sdk.a.a
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", false);
    }

    @Override // com.applovin.impl.sdk.ad.e
    /* JADX INFO: renamed from: FA, reason: merged with bridge method [inline-methods] */
    public com.applovin.impl.sdk.a.c getAdEventTracker() {
        return this.aGa;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public String FB() {
        return this.aFY;
    }

    public String FC() {
        return this.aFZ;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public boolean FD() {
        return this.adObject.has("stream_url");
    }

    private String FE() {
        return getStringFromAdObject("stream_url", "");
    }

    public void FF() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    @Override // com.applovin.impl.sdk.ad.e
    public Uri FG() {
        String strFE = FE();
        if (StringUtils.isValidString(strFE)) {
            return Uri.parse(strFE);
        }
        String strFH = FH();
        if (StringUtils.isValidString(strFH)) {
            return Uri.parse(strFH);
        }
        return null;
    }

    public void j(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "video", uri.toString());
        }
    }

    public String FH() {
        return getStringFromAdObject("video", "");
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        return FG() != null;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public Uri FI() {
        String stringFromAdObject = getStringFromAdObject(CampaignEx.JSON_KEY_CLICK_URL, "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.e
    public Uri FJ() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return FI();
    }

    public float FK() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public boolean FL() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", false);
        }
        return true;
    }

    public j.a FM() {
        return gA(getIntFromAdObject("expandable_style", j.a.INVISIBLE.getValue()));
    }
}
