package com.applovin.impl.mediation.b;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends e implements com.applovin.impl.sdk.ad.g {
    private final AtomicBoolean auA;
    private final AtomicBoolean auB;

    public d(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        super(i, map, jSONObject, jSONObject2, null, nVar);
        this.auA = new AtomicBoolean();
        this.auB = new AtomicBoolean();
    }

    private d(d dVar, com.applovin.impl.mediation.g gVar) {
        super(dVar.ah(), dVar.getLocalExtraParameters(), dVar.yy(), dVar.yx(), gVar, dVar.sdk);
        this.auA = new AtomicBoolean();
        this.auB = new AtomicBoolean();
    }

    @Override // com.applovin.impl.mediation.b.a
    public a k(com.applovin.impl.mediation.g gVar) {
        return new d(this, gVar);
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.aut.a(maxNativeAdView);
    }

    public MaxNativeAdView yk() {
        return this.aut.ud();
    }

    public void c(ViewGroup viewGroup) {
        this.aut.b(viewGroup);
    }

    public ViewGroup yl() {
        return this.aut.ue();
    }

    public String ym() {
        return BundleUtils.getString("template", "", getServerParameters());
    }

    public boolean isContainerClickable() {
        return b("inacc", (Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJW)).booleanValue();
    }

    public boolean ur() {
        return this.aut == null;
    }

    public AtomicBoolean yn() {
        return this.auA;
    }

    public AtomicBoolean yo() {
        return this.auB;
    }

    @Override // com.applovin.impl.sdk.ad.g
    public long getTimeToLiveMillis() {
        return yi() - (SystemClock.elapsedRealtime() - xL());
    }

    private long yi() {
        long longFromAdObject = getLongFromAdObject("ad_expiration_ms", -1L);
        return longFromAdObject < 0 ? getLongFromFullResponse("ad_expiration_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJE)).longValue()) : longFromAdObject;
    }

    @Override // com.applovin.impl.sdk.ad.g
    public void setExpired() {
        MaxNativeAd nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.setExpired();
        }
    }
}
