package com.applovin.impl.mediation.nativeAds.a;

import android.content.Context;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.d;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class b extends MaxNativeAdListener implements MaxAdRevenueListener {
    private final MaxNativeAdLoader auM;
    private a auP;
    private final int oW;
    private final Queue<MaxAd> auN = new LinkedList();
    private boolean auO = false;
    private final Object rT = new Object();

    public interface a {
        void onAdRevenuePaid(MaxAd maxAd);

        void onNativeAdClicked(MaxAd maxAd);

        void onNativeAdLoadFailed(String str, MaxError maxError);

        void onNativeAdLoaded();
    }

    public b(MaxAdPlacerSettings maxAdPlacerSettings, Context context, a aVar) {
        this.oW = maxAdPlacerSettings.getMaxPreloadedAdCount();
        this.auP = aVar;
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(maxAdPlacerSettings.getAdUnitId(), context);
        this.auM = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this);
        maxNativeAdLoader.setRevenueListener(this);
        maxNativeAdLoader.setPlacement(maxAdPlacerSettings.getPlacement());
        maxNativeAdLoader.setLocalExtraParameter(MaxNativeAdLoaderImpl.KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE, d.a.NATIVE_AD_PLACER);
    }

    public void destroy() {
        this.auP = null;
        clearAds();
        this.auM.destroy();
    }

    public boolean yM() {
        boolean z;
        synchronized (this.rT) {
            z = !this.auN.isEmpty();
        }
        return z;
    }

    public void loadAds() {
        synchronized (this.rT) {
            if (!this.auO && this.auN.size() < this.oW) {
                this.auO = true;
                this.auM.loadAd();
            }
        }
    }

    public MaxAd yN() {
        MaxAd maxAdRemove;
        synchronized (this.rT) {
            maxAdRemove = null;
            while (!this.auN.isEmpty() && (maxAdRemove == null || maxAdRemove.getNativeAd().isExpired())) {
                maxAdRemove = this.auN.remove();
            }
            loadAds();
        }
        return maxAdRemove;
    }

    public void destroyAd(MaxAd maxAd) {
        this.auM.destroy(maxAd);
    }

    public void clearAds() {
        synchronized (this.rT) {
            Iterator<MaxAd> it = this.auN.iterator();
            while (it.hasNext()) {
                destroyAd(it.next());
            }
            this.auN.clear();
        }
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        return this.auM.render(maxNativeAdView, maxAd);
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        synchronized (this.rT) {
            this.auN.add(maxAd);
            this.auO = false;
            loadAds();
        }
        a aVar = this.auP;
        if (aVar != null) {
            aVar.onNativeAdLoaded();
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        a aVar = this.auP;
        if (aVar != null) {
            aVar.onNativeAdLoadFailed(str, maxError);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdClicked(MaxAd maxAd) {
        a aVar = this.auP;
        if (aVar != null) {
            aVar.onNativeAdClicked(maxAd);
        }
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        a aVar = this.auP;
        if (aVar != null) {
            aVar.onAdRevenuePaid(maxAd);
        }
    }
}
