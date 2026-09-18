package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends AppLovinAdImpl {
    private AppLovinAd aGV;
    private final d aGW;

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return null;
    }

    @Override // com.applovin.impl.sdk.a.a
    public String getOpenMeasurementContentUrl() {
        return null;
    }

    @Override // com.applovin.impl.sdk.a.a
    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    @Override // com.applovin.impl.sdk.a.a
    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return false;
    }

    @Override // com.applovin.impl.sdk.a.a
    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    public f(d dVar, n nVar) {
        super(new JSONObject(), new JSONObject(), b.UNKNOWN, nVar);
        this.aGW = dVar;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public d getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) HA();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.aGW;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public b getSource() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) HA();
        return appLovinAdImpl != null ? appLovinAdImpl.getSource() : b.UNKNOWN;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean isExpired() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) HA();
        return appLovinAdImpl != null && appLovinAdImpl.isExpired();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public long getAdIdNumber() {
        AppLovinAd appLovinAdHA = HA();
        if (appLovinAdHA != null) {
            return appLovinAdHA.getAdIdNumber();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return getAdZone().getSize();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return getAdZone().getType();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (this.aGW.FQ()) {
            return null;
        }
        return this.aGW.mQ();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public boolean isVideoAd() {
        AppLovinAd appLovinAdHA = HA();
        return appLovinAdHA != null && appLovinAdHA.isVideoAd();
    }

    public AppLovinAd Hz() {
        return this.aGV;
    }

    public void e(AppLovinAd appLovinAd) {
        this.aGV = appLovinAd;
    }

    public AppLovinAd HA() {
        AppLovinAd appLovinAd = this.aGV;
        return appLovinAd != null ? appLovinAd : HB();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        AppLovinAd appLovinAdHA = HA();
        if (appLovinAdHA instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdHA).getCreatedAtMillis();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        AppLovinAd appLovinAdHA = HA();
        if (appLovinAdHA instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdHA).getOriginalFullResponse();
        }
        return null;
    }

    private AppLovinAd HB() {
        return (AppLovinAd) this.sdk.BY().c(this.aGW);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        return new Bundle();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + HC() + "'}";
    }

    private String HC() {
        d adZone = getAdZone();
        if (adZone == null || adZone.FQ()) {
            return null;
        }
        return adZone.mQ();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAd appLovinAdHA = HA();
        if (appLovinAdHA != null) {
            return appLovinAdHA.equals(obj);
        }
        return super.equals(obj);
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        AppLovinAd appLovinAdHA = HA();
        if (appLovinAdHA != null) {
            return appLovinAdHA.hashCode();
        }
        return super.hashCode();
    }
}
