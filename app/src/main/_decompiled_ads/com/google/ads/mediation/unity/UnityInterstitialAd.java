package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class UnityInterstitialAd implements MediationInterstitialAd, IUnityAdsLoadListener, IUnityAdsShowListener {
    static final String ERROR_MSG_INTERSTITIAL_INITIALIZATION_FAILED = "Unity Ads initialization failed for game ID '%s' with error message: %s";
    private WeakReference<Activity> activityWeakReference;
    private final MediationInterstitialAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> adLoadCallback;
    private MediationInterstitialAdCallback interstitialAdCallback;
    private String objectId;
    private String placementId;
    private final UnityAdsLoader unityAdsLoader;
    private final UnityInitializer unityInitializer;

    public UnityInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, UnityInitializer unityInitializer, UnityAdsLoader unityAdsLoader) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
        this.unityInitializer = unityInitializer;
        this.unityAdsLoader = unityAdsLoader;
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad successfully loaded for placement ID: %s", str));
        this.placementId = str;
        this.interstitialAdCallback = this.adLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure(" + str2 + ")");
        this.placementId = str;
        AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsLoadError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
        this.adLoadCallback.onFailure(adErrorCreateSDKError);
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(String str) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_IMPRESSION);
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad started for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String str) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad was clicked for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.reportAdClicked();
        this.interstitialAdCallback.onAdLeftApplication();
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad finished playing for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsShowError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adErrorCreateSDKError);
        }
    }

    public void loadAd() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        final Context context = this.adConfiguration.getContext();
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString("gameId");
        String string2 = serverParameters.getString("zoneId");
        this.placementId = string2;
        if (!UnityAdsAdapterUtils.areValidIds(string, string2)) {
            this.adLoadCallback.onFailure(new AdError(101, "Missing or invalid server parameters.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN));
        } else if (!(context instanceof Activity)) {
            this.adLoadCallback.onFailure(new AdError(105, "Unity Ads requires an Activity context to load ads.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN));
        } else {
            this.activityWeakReference = new WeakReference<>((Activity) context);
            this.unityInitializer.initializeUnityAds(context, string, new IUnityAdsInitializationListener() { // from class: com.google.ads.mediation.unity.UnityInterstitialAd.1
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() {
                    Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load interstitial ad with placement ID: %s", string, UnityInterstitialAd.this.placementId));
                    UnityAdsAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), context);
                    UnityInterstitialAd.this.objectId = UUID.randomUUID().toString();
                    UnityInterstitialAd.this.unityAdsLoader.load(UnityInterstitialAd.this.placementId, UnityInterstitialAd.this.unityAdsLoader.createUnityAdsLoadOptionsWithId(UnityInterstitialAd.this.objectId), UnityInterstitialAd.this);
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsInitializationError, String.format(UnityInterstitialAd.ERROR_MSG_INTERSTITIAL_INITIALIZATION_FAILED, string, str));
                    Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
                    UnityInterstitialAd.this.adLoadCallback.onFailure(adErrorCreateSDKError);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        WeakReference<Activity> weakReference = this.activityWeakReference;
        Activity activity = weakReference == null ? null : weakReference.get();
        if (activity == null) {
            Log.w(UnityMediationAdapter.TAG, "Failed to show interstitial ad for placement ID '" + this.placementId + "' from Unity Ads: Activity context is null.");
            if (this.interstitialAdCallback != null) {
                this.interstitialAdCallback.onAdFailedToShow(new AdError(104, "Activity context is null.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN));
                return;
            }
            return;
        }
        if (this.placementId == null) {
            Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
        }
        this.unityAdsLoader.show(activity, this.placementId, this.unityAdsLoader.createUnityAdsShowOptionsWithId(this.objectId), this);
    }
}
