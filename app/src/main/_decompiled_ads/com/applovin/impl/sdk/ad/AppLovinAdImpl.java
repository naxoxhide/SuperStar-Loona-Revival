package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppLovinAdImpl extends AppLovinAdBase implements g, AppLovinAd {
    private final Bundle aGq;
    private f aGr;
    private d azx;
    private boolean isExpired;
    protected final b source;

    public abstract JSONObject getOriginalFullResponse();

    protected AppLovinAdImpl(JSONObject jSONObject, JSONObject jSONObject2, b bVar, n nVar) {
        super(jSONObject, jSONObject2, nVar);
        this.aGq = new Bundle();
        this.source = bVar;
    }

    public String getRawFullResponse() {
        String string;
        synchronized (this.fullResponseLock) {
            string = this.fullResponse.toString();
        }
        return string;
    }

    public boolean hasVideoUrl() {
        this.sdk.BL();
        if (!x.Fk()) {
            return false;
        }
        this.sdk.BL().i("AppLovinAd", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", false);
    }

    public void setHasShown(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                try {
                    this.adObject.put("shown", z);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", false);
    }

    public Bundle getMAXAdValues() {
        return this.aGq;
    }

    public void setMaxAdValue(String str, Object obj) {
        BundleUtils.put(str, obj, this.aGq);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1L);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", null));
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse("ad_type", null));
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (getAdZone().FQ()) {
            return null;
        }
        return getStringFromFullResponse(AppLovinUtils.ServerParameterKeys.ZONE_ID, null);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public boolean isVideoAd() {
        if (this.adObject.has("is_video_ad")) {
            return getBooleanFromAdObject("is_video_ad", false);
        }
        return hasVideoUrl();
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getAdValue(String str, String str2) {
        return JsonUtils.getString(getJsonObjectFromAdObject("ad_values", new JSONObject()), str, str2);
    }

    public d getAdZone() {
        d dVar = this.azx;
        if (dVar != null) {
            if (dVar.getSize() != null && this.azx.getType() != null) {
                return this.azx;
            }
            if (getSize() == null && getType() == null) {
                return this.azx;
            }
        }
        d dVarA = d.a(getSize(), getType(), getStringFromFullResponse(AppLovinUtils.ServerParameterKeys.ZONE_ID, null), getBooleanFromFullResponse("is_bidding", false), getBooleanFromFullResponse("is_direct_sold", false));
        this.azx = dVarA;
        return dVarA;
    }

    public b getSource() {
        return this.source;
    }

    public f getDummyAd() {
        return this.aGr;
    }

    public void setDummyAd(f fVar) {
        this.aGr = fVar;
    }

    public boolean canExpire() {
        return getSize() == AppLovinAdSize.INTERSTITIAL && yi() > 0;
    }

    @Override // com.applovin.impl.sdk.ad.g
    public long getTimeToLiveMillis() {
        if (!canExpire()) {
            return Long.MAX_VALUE;
        }
        return yi() - (System.currentTimeMillis() - getCreatedAtMillis());
    }

    private long yi() {
        return getLongFromAdObject("ad_expiration_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aLY)).longValue());
    }

    public boolean isExpired() {
        return this.isExpired;
    }

    @Override // com.applovin.impl.sdk.ad.g
    public void setExpired() {
        this.isExpired = true;
    }

    public boolean equals(Object obj) {
        AppLovinAd appLovinAdHA;
        if ((obj instanceof f) && (appLovinAdHA = ((f) obj).HA()) != null) {
            obj = appLovinAdHA;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getAdIdNumber() == ((AppLovinAdImpl) obj).getAdIdNumber();
    }

    public int hashCode() {
        return (int) getAdIdNumber();
    }

    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", source=" + getSource() + ", zoneId=\"" + getZoneId() + "\"}";
    }
}
