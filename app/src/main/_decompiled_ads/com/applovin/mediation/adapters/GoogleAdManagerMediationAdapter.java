package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapters.googleadmanager.BuildConfig;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleAdManagerMediationAdapter extends MediationAdapterBase implements MaxInterstitialAdapter, MaxRewardedInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    private static final int ADVERTISER_VIEW_TAG = 8;
    private static final int BODY_VIEW_TAG = 4;
    private static final int CALL_TO_ACTION_VIEW_TAG = 5;
    private static final int ICON_VIEW_TAG = 3;
    private static final int MEDIA_VIEW_CONTAINER_TAG = 2;
    private static final int TITLE_LABEL_TAG = 1;
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private AdManagerAdView adView;
    private AppOpenAd appOpenAd;
    private AppOpenAdListener appOpenAdListener;
    private AdManagerInterstitialAd interstitialAd;
    private NativeAd nativeAd;
    private NativeAdView nativeAdView;
    private RewardedAd rewardedAd;
    private RewardedAdListener rewardedAdListener;
    private RewardedInterstitialAd rewardedInterstitialAd;
    private RewardedInterstitialAdListener rewardedInterstitialAdListener;

    public GoogleAdManagerMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        log("Initializing Google Ad Manager SDK...");
        if (initialized.compareAndSet(false, true)) {
            MobileAds.initialize(getContext(activity));
        }
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return String.valueOf(MobileAds.getVersion());
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        log("Destroy called for adapter " + this);
        AdManagerInterstitialAd adManagerInterstitialAd = this.interstitialAd;
        if (adManagerInterstitialAd != null) {
            adManagerInterstitialAd.setFullScreenContentCallback(null);
            this.interstitialAd = null;
        }
        AppOpenAd appOpenAd = this.appOpenAd;
        if (appOpenAd != null) {
            appOpenAd.setFullScreenContentCallback(null);
            this.appOpenAd = null;
            this.appOpenAdListener = null;
        }
        RewardedInterstitialAd rewardedInterstitialAd = this.rewardedInterstitialAd;
        if (rewardedInterstitialAd != null) {
            rewardedInterstitialAd.setFullScreenContentCallback(null);
            this.rewardedInterstitialAd = null;
            this.rewardedInterstitialAdListener = null;
        }
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null) {
            rewardedAd.setFullScreenContentCallback(null);
            this.rewardedAd = null;
            this.rewardedAdListener = null;
        }
        AdManagerAdView adManagerAdView = this.adView;
        if (adManagerAdView != null) {
            adManagerAdView.destroy();
            this.adView = null;
        }
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.nativeAd = null;
        }
        NativeAdView nativeAdView = this.nativeAdView;
        if (nativeAdView != null) {
            nativeAdView.destroy();
            this.nativeAdView = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading interstitial ad: " + thirdPartyAdPlacementId + "...");
        updateMuteState(maxAdapterResponseParameters);
        setRequestConfiguration(maxAdapterResponseParameters);
        AdManagerInterstitialAd.load(activity, thirdPartyAdPlacementId, createAdRequestWithParameters(maxAdapterResponseParameters, activity), new AdManagerInterstitialAdLoadCallback() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(AdManagerInterstitialAd adManagerInterstitialAd) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                GoogleAdManagerMediationAdapter.this.log("Interstitial ad loaded: " + thirdPartyAdPlacementId + "...");
                GoogleAdManagerMediationAdapter.this.interstitialAd = adManagerInterstitialAd;
                GoogleAdManagerMediationAdapter.this.interstitialAd.setFullScreenContentCallback(GoogleAdManagerMediationAdapter.this.new InterstitialAdListener(thirdPartyAdPlacementId, maxInterstitialAdapterListener));
                ResponseInfo responseInfo = GoogleAdManagerMediationAdapter.this.interstitialAd.getResponseInfo();
                String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                if (AppLovinSdk.VERSION_CODE >= 9150000 && AppLovinSdkUtils.isValidString(responseId)) {
                    Bundle bundle = new Bundle(1);
                    bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, responseId);
                    maxInterstitialAdapterListener.onInterstitialAdLoaded(bundle);
                    return;
                }
                maxInterstitialAdapterListener.onInterstitialAdLoaded();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
                MaxAdapterError maxError = GoogleAdManagerMediationAdapter.toMaxError(loadAdError);
                GoogleAdManagerMediationAdapter.this.log("Interstitial ad (" + thirdPartyAdPlacementId + ") failed to load with error: " + maxError);
                maxInterstitialAdapterListener.onInterstitialAdLoadFailed(maxError);
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing interstitial ad: " + thirdPartyAdPlacementId + "...");
        AdManagerInterstitialAd adManagerInterstitialAd = this.interstitialAd;
        if (adManagerInterstitialAd != null) {
            adManagerInterstitialAd.show(activity);
        } else {
            log("Interstitial ad failed to show: " + thirdPartyAdPlacementId);
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAppOpenAdapter
    public void loadAppOpenAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading app open ad: " + thirdPartyAdPlacementId + "...");
        updateMuteState(maxAdapterResponseParameters);
        setRequestConfiguration(maxAdapterResponseParameters);
        AdManagerAdRequest adManagerAdRequestCreateAdRequestWithParameters = createAdRequestWithParameters(maxAdapterResponseParameters, activity);
        Context context = getContext(activity);
        AppOpenAd.load(context, thirdPartyAdPlacementId, adManagerAdRequestCreateAdRequestWithParameters, AppLovinSdkUtils.getOrientation(context), new AppOpenAd.AppOpenAdLoadCallback() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.2
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(AppOpenAd appOpenAd) {
                GoogleAdManagerMediationAdapter.this.log("App open ad loaded: " + thirdPartyAdPlacementId + "...");
                GoogleAdManagerMediationAdapter.this.appOpenAd = appOpenAd;
                GoogleAdManagerMediationAdapter.this.appOpenAdListener = GoogleAdManagerMediationAdapter.this.new AppOpenAdListener(thirdPartyAdPlacementId, maxAppOpenAdapterListener);
                appOpenAd.setFullScreenContentCallback(GoogleAdManagerMediationAdapter.this.appOpenAdListener);
                ResponseInfo responseInfo = GoogleAdManagerMediationAdapter.this.appOpenAd.getResponseInfo();
                String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                if (AppLovinSdkUtils.isValidString(responseId)) {
                    Bundle bundle = new Bundle(1);
                    bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, responseId);
                    maxAppOpenAdapterListener.onAppOpenAdLoaded(bundle);
                    return;
                }
                maxAppOpenAdapterListener.onAppOpenAdLoaded();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                MaxAdapterError maxError = GoogleAdManagerMediationAdapter.toMaxError(loadAdError);
                GoogleAdManagerMediationAdapter.this.log("App open ad (" + thirdPartyAdPlacementId + ") failed to load with error: " + maxError);
                maxAppOpenAdapterListener.onAppOpenAdLoadFailed(maxError);
            }
        });
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAppOpenAdapter
    public void showAppOpenAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing app open ad: " + thirdPartyAdPlacementId + "...");
        AppOpenAd appOpenAd = this.appOpenAd;
        if (appOpenAd != null) {
            appOpenAd.show(activity);
        } else {
            log("App open ad failed to show: " + thirdPartyAdPlacementId);
            maxAppOpenAdapterListener.onAppOpenAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "App open ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter
    public void loadRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading rewarded interstitial ad: " + thirdPartyAdPlacementId + "...");
        updateMuteState(maxAdapterResponseParameters);
        setRequestConfiguration(maxAdapterResponseParameters);
        RewardedInterstitialAd.load((Context) activity, thirdPartyAdPlacementId, (AdRequest) createAdRequestWithParameters(maxAdapterResponseParameters, activity), new RewardedInterstitialAdLoadCallback() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.3
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedInterstitialAd rewardedInterstitialAd) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad loaded: " + thirdPartyAdPlacementId);
                GoogleAdManagerMediationAdapter.this.rewardedInterstitialAd = rewardedInterstitialAd;
                GoogleAdManagerMediationAdapter.this.rewardedInterstitialAdListener = new RewardedInterstitialAdListener(thirdPartyAdPlacementId, maxRewardedInterstitialAdapterListener);
                GoogleAdManagerMediationAdapter.this.rewardedInterstitialAd.setFullScreenContentCallback(GoogleAdManagerMediationAdapter.this.rewardedInterstitialAdListener);
                ResponseInfo responseInfo = GoogleAdManagerMediationAdapter.this.rewardedInterstitialAd.getResponseInfo();
                String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                if (AppLovinSdk.VERSION_CODE > 9150000 && AppLovinSdkUtils.isValidString(responseId)) {
                    Bundle bundle = new Bundle(1);
                    bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, responseId);
                    maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoaded(bundle);
                    return;
                }
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoaded();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV_INTERSTITIAL, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
                MaxAdapterError maxError = GoogleAdManagerMediationAdapter.toMaxError(loadAdError);
                GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad (" + thirdPartyAdPlacementId + ") failed to load with error: " + maxError);
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoadFailed(maxError);
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter
    public void showRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing rewarded interstitial ad: " + thirdPartyAdPlacementId + "...");
        if (this.rewardedInterstitialAd != null) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedInterstitialAd.show(activity, new OnUserEarnedRewardListener() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.4
                @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                public void onUserEarnedReward(RewardItem rewardItem) {
                    GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad user earned reward: " + thirdPartyAdPlacementId);
                    GoogleAdManagerMediationAdapter.this.rewardedInterstitialAdListener.hasGrantedReward = true;
                }
            });
        } else {
            log("Rewarded interstitial ad failed to show: " + thirdPartyAdPlacementId);
            maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded Interstitial ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading rewarded ad: " + thirdPartyAdPlacementId + "...");
        updateMuteState(maxAdapterResponseParameters);
        setRequestConfiguration(maxAdapterResponseParameters);
        RewardedAd.load((Context) activity, thirdPartyAdPlacementId, createAdRequestWithParameters(maxAdapterResponseParameters, activity), new RewardedAdLoadCallback() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.5
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedAd rewardedAd) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                GoogleAdManagerMediationAdapter.this.log("Rewarded ad loaded: " + thirdPartyAdPlacementId + "...");
                GoogleAdManagerMediationAdapter.this.rewardedAd = rewardedAd;
                GoogleAdManagerMediationAdapter.this.rewardedAdListener = GoogleAdManagerMediationAdapter.this.new RewardedAdListener(thirdPartyAdPlacementId, maxRewardedAdapterListener);
                GoogleAdManagerMediationAdapter.this.rewardedAd.setFullScreenContentCallback(GoogleAdManagerMediationAdapter.this.rewardedAdListener);
                ResponseInfo responseInfo = GoogleAdManagerMediationAdapter.this.rewardedAd.getResponseInfo();
                String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                if (AppLovinSdk.VERSION_CODE >= 9150000 && AppLovinSdkUtils.isValidString(responseId)) {
                    Bundle bundle = new Bundle(1);
                    bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, responseId);
                    maxRewardedAdapterListener.onRewardedAdLoaded(bundle);
                    return;
                }
                maxRewardedAdapterListener.onRewardedAdLoaded();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
                MaxAdapterError maxError = GoogleAdManagerMediationAdapter.toMaxError(loadAdError);
                GoogleAdManagerMediationAdapter.this.log("Rewarded ad (" + thirdPartyAdPlacementId + ") failed to load with error: " + maxError);
                maxRewardedAdapterListener.onRewardedAdLoadFailed(maxError);
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing rewarded ad: " + thirdPartyAdPlacementId + "...");
        if (this.rewardedAd != null) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show(activity, new OnUserEarnedRewardListener() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.6
                @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                public void onUserEarnedReward(RewardItem rewardItem) {
                    GoogleAdManagerMediationAdapter.this.log("Rewarded ad user earned reward: " + thirdPartyAdPlacementId);
                    GoogleAdManagerMediationAdapter.this.rewardedAdListener.hasGrantedReward = true;
                }
            });
        } else {
            log("Rewarded ad failed to show: " + thirdPartyAdPlacementId);
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        log("Loading " + (z ? "native " : "") + maxAdFormat.getLabel() + " ad for placement id: " + thirdPartyAdPlacementId + "...");
        setRequestConfiguration(maxAdapterResponseParameters);
        Context context = getContext(activity);
        AdManagerAdRequest adManagerAdRequestCreateAdRequestWithParameters = createAdRequestWithParameters(maxAdapterResponseParameters, context);
        if (z) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE_BANNER, ADXLogUtil.EVENT_LOAD);
            NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
            builder.setAdChoicesPlacement(getAdChoicesPlacement(maxAdapterResponseParameters));
            builder.setRequestMultipleImages(maxAdFormat == MaxAdFormat.MREC);
            NativeAdViewListener nativeAdViewListener = new NativeAdViewListener(maxAdapterResponseParameters, maxAdFormat, activity, maxAdViewAdapterListener);
            new AdLoader.Builder(context, thirdPartyAdPlacementId).withNativeAdOptions(builder.build()).forNativeAd(nativeAdViewListener).withAdListener(nativeAdViewListener).build().loadAd(adManagerAdRequestCreateAdRequestWithParameters);
            return;
        }
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        AdManagerAdView adManagerAdView = new AdManagerAdView(context);
        this.adView = adManagerAdView;
        adManagerAdView.setAdUnitId(thirdPartyAdPlacementId);
        this.adView.setAdListener(new AdViewListener(thirdPartyAdPlacementId, maxAdFormat, maxAdViewAdapterListener));
        this.adView.setAdSize(toAdSize(maxAdFormat, maxAdapterResponseParameters.getServerParameters().getBoolean(AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER, false), maxAdapterResponseParameters, context));
        this.adView.loadAd(adManagerAdRequestCreateAdRequestWithParameters);
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading native ad for placement id: " + thirdPartyAdPlacementId + "...");
        setRequestConfiguration(maxAdapterResponseParameters);
        Context context = getContext(activity);
        AdManagerAdRequest adManagerAdRequestCreateAdRequestWithParameters = createAdRequestWithParameters(maxAdapterResponseParameters, context);
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        builder.setAdChoicesPlacement(getAdChoicesPlacement(maxAdapterResponseParameters));
        builder.setRequestMultipleImages(BundleUtils.getString("template", "", maxAdapterResponseParameters.getServerParameters()).contains("medium"));
        NativeAdListener nativeAdListener = new NativeAdListener(maxAdapterResponseParameters, context, maxNativeAdAdapterListener);
        new AdLoader.Builder(context, thirdPartyAdPlacementId).withNativeAdOptions(builder.build()).forNativeAd(nativeAdListener).withAdListener(nativeAdListener).build().loadAd((AdRequest) adManagerAdRequestCreateAdRequestWithParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x0018  */
    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    public static MaxAdapterError toMaxError(AdError adError) {
        int code = adError.getCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (code == 0) {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        } else if (code == 1) {
            maxAdapterError = MaxAdapterError.BAD_REQUEST;
        } else if (code == 2) {
            maxAdapterError = MaxAdapterError.NO_CONNECTION;
        } else if (code == 3) {
            maxAdapterError = MaxAdapterError.NO_FILL;
        } else {
            switch (code) {
                case 8:
                case 11:
                    maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                    break;
                case 9:
                    maxAdapterError = MaxAdapterError.NO_FILL;
                    break;
                case 10:
                    maxAdapterError = MaxAdapterError.BAD_REQUEST;
                    break;
            }
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), code, adError.getMessage());
    }

    private AdSize toAdSize(MaxAdFormat maxAdFormat, boolean z, MaxAdapterParameters maxAdapterParameters, Context context) {
        if (maxAdFormat == MaxAdFormat.BANNER || maxAdFormat == MaxAdFormat.LEADER) {
            if (z) {
                return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, getAdaptiveBannerWidth(maxAdapterParameters, context));
            }
            return maxAdFormat == MaxAdFormat.BANNER ? AdSize.BANNER : AdSize.LEADERBOARD;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    private int getAdaptiveBannerWidth(MaxAdapterParameters maxAdapterParameters, Context context) {
        if (AppLovinSdk.VERSION_CODE >= 11000000) {
            Object obj = maxAdapterParameters.getLocalExtraParameters().get("adaptive_banner_width");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj != null) {
                e("Expected parameter \"adaptive_banner_width\" to be of type Integer, received: " + obj.getClass());
            }
        }
        return AppLovinSdkUtils.pxToDp(context, getApplicationWindowWidth(context));
    }

    public static int getApplicationWindowWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            return windowManager.getCurrentWindowMetrics().getBounds().width();
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private void setRequestConfiguration(MaxAdapterParameters maxAdapterParameters) {
        RequestConfiguration.Builder builder = MobileAds.getRequestConfiguration().toBuilder();
        Boolean boolIsAgeRestrictedUser = maxAdapterParameters.isAgeRestrictedUser();
        if (boolIsAgeRestrictedUser != null) {
            builder.setTagForChildDirectedTreatment(boolIsAgeRestrictedUser.booleanValue() ? 1 : 0);
        }
        MobileAds.setRequestConfiguration(builder.build());
    }

    private AdManagerAdRequest createAdRequestWithParameters(MaxAdapterParameters maxAdapterParameters, Context context) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        Bundle serverParameters = maxAdapterParameters.getServerParameters();
        if (serverParameters.getBoolean("set_mediation_identifier", true)) {
            builder.setRequestAgent(mediationTag());
        }
        Bundle bundle = new Bundle();
        String string = BundleUtils.getString("event_id", serverParameters);
        if (AppLovinSdkUtils.isValidString(string)) {
            bundle.putString("placement_req_id", string);
        }
        Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
        if (boolHasUserConsent != null && !boolHasUserConsent.booleanValue()) {
            bundle.putString("npa", "1");
        }
        Boolean boolIsDoNotSell = maxAdapterParameters.isDoNotSell();
        if (boolIsDoNotSell != null && boolIsDoNotSell.booleanValue()) {
            bundle.putInt("rdp", 1);
            PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("gad_rdp", 1).commit();
        } else {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove("gad_rdp").commit();
        }
        if (AppLovinSdk.VERSION_CODE >= 11000000) {
            Map<String, Object> localExtraParameters = maxAdapterParameters.getLocalExtraParameters();
            Object obj = localExtraParameters.get("google_max_ad_content_rating");
            if (obj instanceof String) {
                bundle.putString("max_ad_content_rating", (String) obj);
            }
            Object obj2 = localExtraParameters.get("google_content_url");
            if (obj2 instanceof String) {
                builder.setContentUrl((String) obj2);
            }
            Object obj3 = localExtraParameters.get("google_neighbouring_content_url_strings");
            if (obj3 instanceof List) {
                try {
                    builder.setNeighboringContentUrls((List) obj3);
                } catch (Throwable th) {
                    e("Neighbouring content URL strings extra param needs to be of type List<String>.", th);
                }
            }
            Object obj4 = localExtraParameters.get("ppid");
            if (obj4 instanceof String) {
                builder.setPublisherProvidedId((String) obj4);
            }
            Object obj5 = localExtraParameters.get("custom_targeting");
            if (obj5 instanceof Map) {
                try {
                    Map map = (Map) obj5;
                    for (String str : map.keySet()) {
                        Object obj6 = map.get(str);
                        if (obj6 instanceof String) {
                            builder.addCustomTargeting(str, (String) obj6);
                        } else if (obj6 instanceof List) {
                            builder.addCustomTargeting(str, (List<String>) obj6);
                        } else {
                            e("Object in the map needs to be either of type String or List<String>.");
                        }
                    }
                } catch (Throwable th2) {
                    e("Custom targeting extra param value needs to be of type Map<String, Object>.", th2);
                }
            }
        }
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    private static void updateMuteState(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        MobileAds.setAppMuted(true);
    }

    private int getAdChoicesPlacement(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        if (AppLovinSdk.VERSION_CODE < 11000000) {
            return 1;
        }
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        Object obj = localExtraParameters != null ? localExtraParameters.get("gam_ad_choices_placement") : null;
        if (isValidAdChoicesPlacement(obj)) {
            return ((Integer) obj).intValue();
        }
        return 1;
    }

    private boolean isValidAdChoicesPlacement(Object obj) {
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() == 0 || num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext(Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }

    private class InterstitialAdListener extends FullScreenContentCallback {
        private final MaxInterstitialAdapterListener listener;
        private final String placementId;

        InterstitialAdListener(String str, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.placementId = str;
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            GoogleAdManagerMediationAdapter.this.log("Interstitial ad shown: " + this.placementId);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", adError.getCode(), adError.getMessage());
            GoogleAdManagerMediationAdapter.this.log("Interstitial ad (" + this.placementId + ") failed to show with error: " + maxAdapterError);
            this.listener.onInterstitialAdDisplayFailed(maxAdapterError);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_IMPRESSION);
            GoogleAdManagerMediationAdapter.this.log("Interstitial ad impression recorded: " + this.placementId);
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
            GoogleAdManagerMediationAdapter.this.log("Interstitial ad clicked: " + this.placementId);
            this.listener.onInterstitialAdClicked();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
            GoogleAdManagerMediationAdapter.this.log("Interstitial ad hidden: " + this.placementId);
            this.listener.onInterstitialAdHidden();
        }
    }

    private class AppOpenAdListener extends FullScreenContentCallback {
        private final MaxAppOpenAdapterListener listener;
        private final String placementId;

        AppOpenAdListener(String str, MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
            this.placementId = str;
            this.listener = maxAppOpenAdapterListener;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            GoogleAdManagerMediationAdapter.this.log("App open ad shown: " + this.placementId);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad display failed", adError.getCode(), adError.getMessage());
            GoogleAdManagerMediationAdapter.this.log("App open ad (" + this.placementId + ") failed to show with error: " + maxAdapterError);
            this.listener.onAppOpenAdDisplayFailed(maxAdapterError);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            GoogleAdManagerMediationAdapter.this.log("App open ad impression recorded: " + this.placementId);
            this.listener.onAppOpenAdDisplayed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            GoogleAdManagerMediationAdapter.this.log("App open ad clicked: " + this.placementId);
            this.listener.onAppOpenAdClicked();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            GoogleAdManagerMediationAdapter.this.log("App open ad hidden: " + this.placementId);
            this.listener.onAppOpenAdHidden();
        }
    }

    private class RewardedInterstitialAdListener extends FullScreenContentCallback {
        private boolean hasGrantedReward;
        private final MaxRewardedInterstitialAdapterListener listener;
        private final String placementId;

        private RewardedInterstitialAdListener(String str, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
            this.placementId = str;
            this.listener = maxRewardedInterstitialAdapterListener;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad shown: " + this.placementId);
            this.listener.onRewardedInterstitialAdVideoStarted();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", adError.getCode(), adError.getMessage());
            GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad (" + this.placementId + ") failed to show with error: " + maxAdapterError);
            this.listener.onRewardedInterstitialAdDisplayFailed(maxAdapterError);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV_INTERSTITIAL, ADXLogUtil.EVENT_IMPRESSION);
            GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad impression recorded: " + this.placementId);
            this.listener.onRewardedInterstitialAdDisplayed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
            GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad clicked" + this.placementId);
            this.listener.onRewardedInterstitialAdClicked();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            this.listener.onRewardedInterstitialAdVideoCompleted();
            if (this.hasGrantedReward || GoogleAdManagerMediationAdapter.this.shouldAlwaysRewardUser()) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV_INTERSTITIAL, ADXLogUtil.EVENT_REWARD);
                MaxReward reward = GoogleAdManagerMediationAdapter.this.getReward();
                GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
            GoogleAdManagerMediationAdapter.this.log("Rewarded interstitial ad hidden: " + this.placementId);
            this.listener.onRewardedInterstitialAdHidden();
        }
    }

    private class RewardedAdListener extends FullScreenContentCallback {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;
        private final String placementId;

        RewardedAdListener(String str, MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.placementId = str;
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            GoogleAdManagerMediationAdapter.this.log("Rewarded ad shown: " + this.placementId);
            this.listener.onRewardedAdVideoStarted();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", adError.getCode(), adError.getMessage());
            GoogleAdManagerMediationAdapter.this.log("Rewarded ad (" + this.placementId + ") failed to show with error: " + maxAdapterError);
            this.listener.onRewardedAdDisplayFailed(maxAdapterError);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_IMPRESSION);
            GoogleAdManagerMediationAdapter.this.log("Rewarded ad impression recorded: " + this.placementId);
            this.listener.onRewardedAdDisplayed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
            GoogleAdManagerMediationAdapter.this.log("Rewarded ad clicked: " + this.placementId);
            this.listener.onRewardedAdClicked();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            this.listener.onRewardedAdVideoCompleted();
            if (this.hasGrantedReward || GoogleAdManagerMediationAdapter.this.shouldAlwaysRewardUser()) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                MaxReward reward = GoogleAdManagerMediationAdapter.this.getReward();
                GoogleAdManagerMediationAdapter.this.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
            GoogleAdManagerMediationAdapter.this.log("Rewarded ad hidden: " + this.placementId);
            this.listener.onRewardedAdHidden();
        }
    }

    private class AdViewListener extends AdListener {
        final MaxAdFormat adFormat;
        final MaxAdViewAdapterListener listener;
        final String placementId;

        AdViewListener(String str, MaxAdFormat maxAdFormat, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.placementId = str;
            this.adFormat = maxAdFormat;
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
            GoogleAdManagerMediationAdapter.this.log(this.adFormat.getLabel() + " ad loaded: " + this.placementId);
            if (AppLovinSdk.VERSION_CODE < 9150000) {
                this.listener.onAdViewAdLoaded(GoogleAdManagerMediationAdapter.this.adView);
                return;
            }
            Bundle bundle = new Bundle(3);
            ResponseInfo responseInfo = GoogleAdManagerMediationAdapter.this.adView.getResponseInfo();
            String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
            if (AppLovinSdkUtils.isValidString(responseId)) {
                bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, responseId);
            }
            AdSize adSize = GoogleAdManagerMediationAdapter.this.adView.getAdSize();
            if (adSize != null) {
                bundle.putInt("ad_width", adSize.getWidth());
                bundle.putInt("ad_height", adSize.getHeight());
            }
            this.listener.onAdViewAdLoaded(GoogleAdManagerMediationAdapter.this.adView, bundle);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_BANNER, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
            MaxAdapterError maxError = GoogleAdManagerMediationAdapter.toMaxError(loadAdError);
            GoogleAdManagerMediationAdapter.this.log(this.adFormat.getLabel() + " ad (" + this.placementId + ") failed to load with error code: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            GoogleAdManagerMediationAdapter.this.log(this.adFormat.getLabel() + " ad shown: " + this.placementId);
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            GoogleAdManagerMediationAdapter.this.log(this.adFormat.getLabel() + " ad opened");
            this.listener.onAdViewAdClicked();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            GoogleAdManagerMediationAdapter.this.log(this.adFormat.getLabel() + " ad closed");
        }
    }

    private class NativeAdViewListener extends AdListener implements NativeAd.OnNativeAdLoadedListener {
        final WeakReference<Activity> activityRef;
        final MaxAdFormat adFormat;
        final MaxAdViewAdapterListener listener;
        final String placementId;
        final Bundle serverParameters;

        NativeAdViewListener(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.placementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.serverParameters = maxAdapterResponseParameters.getServerParameters();
            this.activityRef = new WeakReference<>(activity);
            this.adFormat = maxAdFormat;
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            GoogleAdManagerMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad loaded: " + this.placementId);
            if (!TextUtils.isEmpty(nativeAd.getHeadline())) {
                GoogleAdManagerMediationAdapter.this.nativeAd = nativeAd;
                final Activity activity = this.activityRef.get();
                final Context context = GoogleAdManagerMediationAdapter.this.getContext(activity);
                final MediaView mediaView = new MediaView(context);
                MediaContent mediaContent = nativeAd.getMediaContent();
                if (mediaContent != null) {
                    mediaView.setMediaContent(mediaContent);
                }
                NativeAd.Image icon = nativeAd.getIcon();
                MaxNativeAd.MaxNativeAdImage maxNativeAdImage = null;
                if (icon != null) {
                    if (icon.getDrawable() != null) {
                        maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(icon.getDrawable());
                    } else {
                        maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(icon.getUri());
                    }
                }
                final MaxNativeAd maxNativeAdBuild = new MaxNativeAd.Builder().setAdFormat(this.adFormat).setTitle(nativeAd.getHeadline()).setBody(nativeAd.getBody()).setCallToAction(nativeAd.getCallToAction()).setIcon(maxNativeAdImage).setMediaView(mediaView).build();
                final String string = BundleUtils.getString("template", "", this.serverParameters);
                if (string.contains("vertical") && AppLovinSdk.VERSION_CODE < 9140500) {
                    GoogleAdManagerMediationAdapter.this.log("Vertical native banners are only supported on MAX SDK 9.14.5 and above. Default native template will be used.");
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.NativeAdViewListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MaxNativeAdView maxNativeAdView;
                        if (AppLovinSdk.VERSION_CODE >= 11010000) {
                            maxNativeAdView = new MaxNativeAdView(maxNativeAdBuild, string, context);
                        } else {
                            maxNativeAdView = new MaxNativeAdView(maxNativeAdBuild, string, activity);
                        }
                        GoogleAdManagerMediationAdapter.this.nativeAdView = new NativeAdView(context);
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setIconView(maxNativeAdView.getIconContentView());
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setHeadlineView(maxNativeAdView.getTitleTextView());
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setBodyView(maxNativeAdView.getBodyTextView());
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setMediaView(mediaView);
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setCallToActionView(maxNativeAdView.getCallToActionButton());
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setNativeAd(nativeAd);
                        GoogleAdManagerMediationAdapter.this.nativeAdView.addView(maxNativeAdView);
                        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                        ResponseInfo responseInfo = nativeAd.getResponseInfo();
                        String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                        if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(responseId)) {
                            NativeAdViewListener.this.listener.onAdViewAdLoaded(GoogleAdManagerMediationAdapter.this.nativeAdView);
                            return;
                        }
                        Bundle bundle = new Bundle(1);
                        bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, responseId);
                        NativeAdViewListener.this.listener.onAdViewAdLoaded(GoogleAdManagerMediationAdapter.this.nativeAdView, bundle);
                    }
                });
                return;
            }
            GoogleAdManagerMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load: Google native ad is missing one or more required assets");
            this.listener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            nativeAd.destroy();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE_BANNER, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
            MaxAdapterError maxError = GoogleAdManagerMediationAdapter.toMaxError(loadAdError);
            GoogleAdManagerMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad (" + this.placementId + ") failed to load with error: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            GoogleAdManagerMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad shown");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE_BANNER, ADXLogUtil.EVENT_CLICK);
            GoogleAdManagerMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad clicked");
            this.listener.onAdViewAdClicked();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            GoogleAdManagerMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad opened");
            this.listener.onAdViewAdExpanded();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            GoogleAdManagerMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad closed");
            this.listener.onAdViewAdCollapsed();
        }
    }

    private class NativeAdListener extends AdListener implements NativeAd.OnNativeAdLoadedListener {
        final Context context;
        final MaxNativeAdAdapterListener listener;
        final String placementId;
        final Bundle serverParameters;

        public NativeAdListener(MaxAdapterResponseParameters maxAdapterResponseParameters, Context context, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.placementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.serverParameters = maxAdapterResponseParameters.getServerParameters();
            this.context = context;
            this.listener = maxNativeAdAdapterListener;
        }

        @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            GoogleAdManagerMediationAdapter.this.log("Native ad loaded: " + this.placementId);
            GoogleAdManagerMediationAdapter.this.nativeAd = nativeAd;
            if (AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", this.serverParameters)) && TextUtils.isEmpty(nativeAd.getHeadline())) {
                GoogleAdManagerMediationAdapter.this.e("Native ad (" + nativeAd + ") does not have required assets.");
                this.listener.onNativeAdLoadFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
            } else {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter.NativeAdListener.1
                    /* JADX WARN: Code duplicated, block: B:11:0x0056  */
                    @Override // java.lang.Runnable
                    public void run() {
                        float intrinsicWidth;
                        View view;
                        Drawable mainImage;
                        MaxNativeAd.MaxNativeAdImage maxNativeAdImage;
                        MediaContent mediaContent = nativeAd.getMediaContent();
                        List<NativeAd.Image> images = nativeAd.getImages();
                        if (mediaContent != null) {
                            MediaView mediaView = new MediaView(NativeAdListener.this.context);
                            mediaView.setMediaContent(mediaContent);
                            mainImage = mediaContent.getMainImage();
                            intrinsicWidth = mediaContent.getAspectRatio();
                            view = mediaView;
                        } else if (images == null || images.size() <= 0) {
                            intrinsicWidth = 0.0f;
                            view = null;
                            mainImage = null;
                        } else {
                            NativeAd.Image image = images.get(0);
                            ImageView imageView = new ImageView(NativeAdListener.this.context);
                            Drawable drawable = image.getDrawable();
                            if (drawable != null) {
                                imageView.setImageDrawable(image.getDrawable());
                                intrinsicWidth = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
                                mainImage = null;
                                view = imageView;
                            } else {
                                intrinsicWidth = 0.0f;
                                view = null;
                                mainImage = null;
                            }
                        }
                        NativeAd.Image icon = nativeAd.getIcon();
                        if (icon == null) {
                            maxNativeAdImage = null;
                        } else if (icon.getDrawable() != null) {
                            maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(icon.getDrawable());
                        } else {
                            maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(icon.getUri());
                        }
                        MaxNativeAd.Builder mediaView2 = new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(nativeAd.getHeadline()).setAdvertiser(nativeAd.getAdvertiser()).setBody(nativeAd.getBody()).setCallToAction(nativeAd.getCallToAction()).setIcon(maxNativeAdImage).setMediaView(view);
                        if (AppLovinSdk.VERSION_CODE >= 11040399) {
                            mediaView2.setMainImage(new MaxNativeAd.MaxNativeAdImage(mainImage));
                        }
                        if (AppLovinSdk.VERSION_CODE >= 11040000) {
                            mediaView2.setMediaContentAspectRatio(intrinsicWidth);
                        }
                        if (AppLovinSdk.VERSION_CODE >= 11070000) {
                            mediaView2.setStarRating(nativeAd.getStarRating());
                        }
                        MaxGoogleAdManagerNativeAd maxGoogleAdManagerNativeAd = GoogleAdManagerMediationAdapter.this.new MaxGoogleAdManagerNativeAd(mediaView2);
                        ResponseInfo responseInfo = nativeAd.getResponseInfo();
                        String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                        Bundle bundle = new Bundle(1);
                        bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, responseId);
                        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_SUCCESS);
                        NativeAdListener.this.listener.onNativeAdLoaded(maxGoogleAdManagerNativeAd, bundle);
                    }
                });
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
            MaxAdapterError maxError = GoogleAdManagerMediationAdapter.toMaxError(loadAdError);
            GoogleAdManagerMediationAdapter.this.log("Native ad (" + this.placementId + ") failed to load with error: " + maxError);
            this.listener.onNativeAdLoadFailed(maxError);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_IMPRESSION);
            GoogleAdManagerMediationAdapter.this.log("Native ad shown");
            this.listener.onNativeAdDisplayed(null);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_CLICK);
            GoogleAdManagerMediationAdapter.this.log("Native ad clicked");
            this.listener.onNativeAdClicked();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            GoogleAdManagerMediationAdapter.this.log("Native ad opened");
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            GoogleAdManagerMediationAdapter.this.log("Native ad closed");
        }
    }

    private class MaxGoogleAdManagerNativeAd extends MaxNativeAd {
        public MaxGoogleAdManagerNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
            prepareForInteraction(Collections.emptyList(), maxNativeAdView);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            ViewGroup viewGroup2;
            MediaView mediaView;
            MediaContent mediaContent;
            NativeAd nativeAd = GoogleAdManagerMediationAdapter.this.nativeAd;
            if (nativeAd != null) {
                GoogleAdManagerMediationAdapter.this.nativeAdView = new NativeAdView(viewGroup.getContext());
                if (viewGroup instanceof MaxNativeAdView) {
                    MaxNativeAdView maxNativeAdView = (MaxNativeAdView) viewGroup;
                    View mainView = maxNativeAdView.getMainView();
                    maxNativeAdView.removeView(mainView);
                    GoogleAdManagerMediationAdapter.this.nativeAdView.addView(mainView);
                    maxNativeAdView.addView(GoogleAdManagerMediationAdapter.this.nativeAdView);
                    GoogleAdManagerMediationAdapter.this.nativeAdView.setIconView(maxNativeAdView.getIconImageView());
                    GoogleAdManagerMediationAdapter.this.nativeAdView.setHeadlineView(maxNativeAdView.getTitleTextView());
                    GoogleAdManagerMediationAdapter.this.nativeAdView.setAdvertiserView(maxNativeAdView.getAdvertiserTextView());
                    GoogleAdManagerMediationAdapter.this.nativeAdView.setBodyView(maxNativeAdView.getBodyTextView());
                    GoogleAdManagerMediationAdapter.this.nativeAdView.setCallToActionView(maxNativeAdView.getCallToActionButton());
                    View mediaView2 = getMediaView();
                    if (mediaView2 instanceof MediaView) {
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setMediaView((MediaView) mediaView2);
                    } else if (mediaView2 instanceof ImageView) {
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setImageView(mediaView2);
                    }
                    GoogleAdManagerMediationAdapter.this.nativeAdView.setNativeAd(nativeAd);
                } else {
                    for (View view : list) {
                        Object tag = view.getTag();
                        if (tag != null) {
                            int iIntValue = ((Integer) tag).intValue();
                            if (iIntValue == 1) {
                                GoogleAdManagerMediationAdapter.this.nativeAdView.setHeadlineView(view);
                            } else if (iIntValue == 3) {
                                GoogleAdManagerMediationAdapter.this.nativeAdView.setIconView(view);
                            } else if (iIntValue == 4) {
                                GoogleAdManagerMediationAdapter.this.nativeAdView.setBodyView(view);
                            } else if (iIntValue == 5) {
                                GoogleAdManagerMediationAdapter.this.nativeAdView.setCallToActionView(view);
                            } else if (iIntValue == 8) {
                                GoogleAdManagerMediationAdapter.this.nativeAdView.setAdvertiserView(view);
                            }
                        }
                    }
                    View mediaView3 = getMediaView();
                    if (mediaView3 == null || (viewGroup2 = (ViewGroup) mediaView3.getParent()) == null) {
                        return true;
                    }
                    viewGroup2.removeView(mediaView3);
                    boolean z = (viewGroup2 instanceof RelativeLayout) || (viewGroup2 instanceof FrameLayout);
                    if (!z && (mediaView3 instanceof MediaView) && (mediaContent = (mediaView = (MediaView) mediaView3).getMediaContent()) != null && mediaContent.hasVideoContent()) {
                        mediaView3 = new AutoMeasuringMediaView(viewGroup.getContext());
                        mediaView.setMediaContent(nativeAd.getMediaContent());
                    }
                    GoogleAdManagerMediationAdapter.this.nativeAdView.addView(mediaView3, new ViewGroup.LayoutParams(-1, -1));
                    if (mediaView3 instanceof MediaView) {
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setMediaView((MediaView) mediaView3);
                    } else if (mediaView3 instanceof ImageView) {
                        GoogleAdManagerMediationAdapter.this.nativeAdView.setImageView((ImageView) mediaView3);
                    }
                    GoogleAdManagerMediationAdapter.this.nativeAdView.setNativeAd(nativeAd);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (z) {
                        viewGroup2.addView(GoogleAdManagerMediationAdapter.this.nativeAdView, layoutParams);
                    } else {
                        GoogleAdManagerMediationAdapter.this.nativeAdView.measure(View.MeasureSpec.makeMeasureSpec(viewGroup2.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(viewGroup2.getHeight(), 1073741824));
                        GoogleAdManagerMediationAdapter.this.nativeAdView.layout(0, 0, viewGroup2.getWidth(), viewGroup2.getHeight());
                        viewGroup2.addView(GoogleAdManagerMediationAdapter.this.nativeAdView);
                    }
                }
                return true;
            }
            GoogleAdManagerMediationAdapter.this.e("Failed to register native ad views: native ad is null.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class AutoMeasuringMediaView extends MediaView {
        AutoMeasuringMediaView(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            requestLayout();
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            super.requestLayout();
            post(new Runnable() { // from class: com.applovin.mediation.adapters.-$$Lambda$GoogleAdManagerMediationAdapter$AutoMeasuringMediaView$tZqZmPd-dC2ZdSPMN6Ds9N7_LVs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$requestLayout$0$GoogleAdManagerMediationAdapter$AutoMeasuringMediaView();
                }
            });
        }

        public /* synthetic */ void lambda$requestLayout$0$GoogleAdManagerMediationAdapter$AutoMeasuringMediaView() {
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            layout(getLeft(), getTop(), getRight(), getBottom());
        }
    }
}
