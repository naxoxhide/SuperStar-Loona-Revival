package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.mintegral.BuildConfig;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener;
import com.mbridge.msdk.interstitialvideo.out.MBBidInterstitialVideoHandler;
import com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler;
import com.mbridge.msdk.mbbid.out.BidConstants;
import com.mbridge.msdk.mbbid.out.BidManager;
import com.mbridge.msdk.nativex.view.MBMediaView;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBBidNativeHandler;
import com.mbridge.msdk.out.MBBidRewardVideoHandler;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.out.OnMBMediaViewListener;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.out.RewardVideoListener;
import com.mbridge.msdk.system.a;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class MintegralMediationAdapter extends MediationAdapterBase implements MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter, MaxSignalProvider {
    private static final String APP_ID_PARAMETER = "app_id";
    private static final String APP_KEY_PARAMETER = "app_key";
    private static final String BAD_REQUEST = "request parameter is null";
    private static final int DEFAULT_IMAGE_TASK_TIMEOUT_SECONDS = 5;
    private static final String EXCEPTION_APP_ID_EMPTY = "EXCEPTION_APP_ID_EMPTY";
    private static final String EXCEPTION_APP_NOT_FOUND = "EXCEPTION_APP_NOT_FOUND";
    private static final String EXCEPTION_IV_RECALLNET_INVALIDATE = "EXCEPTION_IV_RECALLNET_INVALIDATE";
    private static final String EXCEPTION_RETURN_EMPTY = "EXCEPTION_RETURN_EMPTY";
    private static final String EXCEPTION_SIGN_ERROR = "EXCEPTION_SIGN_ERROR";
    private static final String EXCEPTION_TIMEOUT = "EXCEPTION_TIMEOUT";
    private static final String EXCEPTION_UNIT_ADTYPE_ERROR = "EXCEPTION_UNIT_ADTYPE_ERROR";
    private static final String EXCEPTION_UNIT_ID_EMPTY = "EXCEPTION_UNIT_ID_EMPTY";
    private static final String EXCEPTION_UNIT_NOT_FOUND = "EXCEPTION_UNIT_NOT_FOUND";
    private static final String EXCEPTION_UNIT_NOT_FOUND_IN_APP = "EXCEPTION_UNIT_NOT_FOUND_IN_APP";
    private static final String NETWORK_ERROR = "network exception";
    private static final String NETWORK_IO_ERROR = "Network error,I/O exception";
    private static final String NOT_INITIALIZED = "init error";
    private static final String NO_FILL_1 = "no ads available can show";
    private static final String NO_FILL_2 = "no ads available";
    private static final String NO_FILL_3 = "no server ads available";
    private static final String NO_FILL_4 = "no ads source";
    private static final String NO_FILL_5 = "load no ad";
    private static final String TAG = "MintegralMediationAdapter";
    private static final String TIMEOUT = "load timeout";
    private static final String UNIT_ID_EMPTY = "UnitId is null";
    private static String sSdkVersion;
    private List<View> clickableViews;
    private MBBannerView mbBannerView;
    private MBBidInterstitialVideoHandler mbBidInterstitialVideoHandler;
    private MBBidNativeHandler mbBidNativeAdViewHandler;
    private MBBidNativeHandler mbBidNativeHandler;
    private MBBidRewardVideoHandler mbBidRewardVideoHandler;
    private MBInterstitialVideoHandler mbInterstitialVideoHandler;
    private MBRewardVideoHandler mbRewardVideoHandler;
    private String mbUnitId;
    private MaxNativeAd nativeAd;
    private Campaign nativeAdCampaign;
    private ViewGroup nativeAdContainer;
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final Map<String, MBInterstitialVideoHandler> mbInterstitialVideoHandlers = new HashMap();
    private static final Map<String, MBBidInterstitialVideoHandler> mbBidInterstitialVideoHandlers = new HashMap();
    private static final Map<String, MBRewardVideoHandler> mbRewardVideoHandlers = new HashMap();
    private static final Map<String, MBBidRewardVideoHandler> mbBidRewardVideoHandlers = new HashMap();
    private static final MintegralMediationAdapterRouter router = (MintegralMediationAdapterRouter) MediationAdapterRouter.getSharedInstance(MintegralMediationAdapterRouter.class);

    public MintegralMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        MBridgeConstans.DEBUG = maxAdapterInitializationParameters.isTesting();
        if (initialized.compareAndSet(false, true)) {
            String string = maxAdapterInitializationParameters.getServerParameters().getString("app_id");
            String string2 = maxAdapterInitializationParameters.getServerParameters().getString("app_key");
            log("Initializing Mintegral SDK with app id: " + string + " and app key: " + string2 + "...");
            a mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            Context context = getContext(activity);
            Boolean boolHasUserConsent = maxAdapterInitializationParameters.hasUserConsent();
            if (boolHasUserConsent != null) {
                boolean zBooleanValue = boolHasUserConsent.booleanValue();
                mBridgeSDK.setUserPrivateInfoType(context, MBridgeConstans.AUTHORITY_ALL_INFO, zBooleanValue ? 1 : 0);
                mBridgeSDK.setConsentStatus(context, zBooleanValue ? 1 : 0);
            }
            Boolean boolIsDoNotSell = maxAdapterInitializationParameters.isDoNotSell();
            if (boolIsDoNotSell != null && boolIsDoNotSell.booleanValue()) {
                mBridgeSDK.setDoNotTrackStatus(context, true);
            }
            Boolean boolIsAgeRestrictedUser = maxAdapterInitializationParameters.isAgeRestrictedUser();
            if (boolIsAgeRestrictedUser != null) {
                mBridgeSDK.setCoppaStatus(context, boolIsAgeRestrictedUser.booleanValue());
            }
            mBridgeSDK.init(mBridgeSDK.getMBConfigurationMap(string, string2), context);
        }
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        if (sSdkVersion == null) {
            sSdkVersion = getVersionString(MBConfiguration.class, "SDK_VERSION");
        }
        return sSdkVersion;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        MBInterstitialVideoHandler mBInterstitialVideoHandler = this.mbInterstitialVideoHandler;
        if (mBInterstitialVideoHandler != null) {
            mBInterstitialVideoHandler.setInterstitialVideoListener(null);
            this.mbInterstitialVideoHandler = null;
        }
        MBBidInterstitialVideoHandler mBBidInterstitialVideoHandler = this.mbBidInterstitialVideoHandler;
        if (mBBidInterstitialVideoHandler != null) {
            mBBidInterstitialVideoHandler.setInterstitialVideoListener(null);
            this.mbBidInterstitialVideoHandler = null;
        }
        MBRewardVideoHandler mBRewardVideoHandler = this.mbRewardVideoHandler;
        if (mBRewardVideoHandler != null) {
            mBRewardVideoHandler.setRewardVideoListener(null);
            this.mbRewardVideoHandler = null;
        }
        MBBidRewardVideoHandler mBBidRewardVideoHandler = this.mbBidRewardVideoHandler;
        if (mBBidRewardVideoHandler != null) {
            mBBidRewardVideoHandler.setRewardVideoListener(null);
            this.mbBidRewardVideoHandler = null;
        }
        MBBannerView mBBannerView = this.mbBannerView;
        if (mBBannerView != null) {
            mBBannerView.release();
            this.mbBannerView = null;
        }
        MBBidNativeHandler mBBidNativeHandler = this.mbBidNativeHandler;
        if (mBBidNativeHandler != null) {
            mBBidNativeHandler.unregisterView(this.nativeAdContainer, this.clickableViews, this.nativeAdCampaign);
            this.mbBidNativeHandler.bidRelease();
            this.mbBidNativeHandler.setAdListener(null);
            this.mbBidNativeHandler = null;
        }
        MBBidNativeHandler mBBidNativeHandler2 = this.mbBidNativeAdViewHandler;
        if (mBBidNativeHandler2 != null) {
            mBBidNativeHandler2.unregisterView(this.nativeAdContainer, this.clickableViews, this.nativeAdCampaign);
            this.mbBidNativeAdViewHandler.bidRelease();
            this.mbBidNativeAdViewHandler.setAdListener(null);
            this.mbBidNativeAdViewHandler = null;
        }
        MaxNativeAd maxNativeAd = this.nativeAd;
        if (maxNativeAd != null) {
            if (maxNativeAd.getMediaView() instanceof MBMediaView) {
                ((MBMediaView) this.nativeAd.getMediaView()).destory();
            }
            this.nativeAd = null;
        }
        this.nativeAdCampaign = null;
        router.removeAdapter(this, this.mbUnitId);
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        String buyerUid;
        log("Collecting signal...");
        String adUnitId = maxAdapterSignalCollectionParameters.getAdUnitId();
        if (AppLovinSdkUtils.isValidString(adUnitId)) {
            Bundle bundle = BundleUtils.getBundle(adUnitId, Bundle.EMPTY, BundleUtils.getBundle("credentials", Bundle.EMPTY, maxAdapterSignalCollectionParameters.getServerParameters()));
            HashMap map = new HashMap(3);
            map.put(BidConstants.BID_FILTER_KEY_PLACEMENT_ID, BundleUtils.getString(com.google.ads.mediation.facebook.FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, "", bundle));
            map.put(BidConstants.BID_FILTER_KEY_UNIT_ID, BundleUtils.getString("ad_unit_id", "", bundle));
            map.put(BidConstants.BID_FILTER_KEY_AD_TYPE, toMintegralAdType(maxAdapterSignalCollectionParameters.getAdFormat()));
            buyerUid = BidManager.getBuyerUid(getContext(activity), map);
        } else {
            buyerUid = BidManager.getBuyerUid(getContext(activity));
        }
        maxSignalCollectionListener.onSignalCollected(buyerUid);
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        this.mbUnitId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        String string = BundleUtils.getString(com.google.ads.mediation.facebook.FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, maxAdapterResponseParameters.getServerParameters());
        MintegralMediationAdapterRouter mintegralMediationAdapterRouter = router;
        mintegralMediationAdapterRouter.addInterstitialAdapter(this, maxInterstitialAdapterListener, this.mbUnitId);
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding interstitial ad for unit id: " + this.mbUnitId + " and placement id: " + string + "...");
            Map<String, MBBidInterstitialVideoHandler> map = mbBidInterstitialVideoHandlers;
            if (map.containsKey(this.mbUnitId)) {
                this.mbBidInterstitialVideoHandler = map.get(this.mbUnitId);
            } else {
                MBBidInterstitialVideoHandler mBBidInterstitialVideoHandler = new MBBidInterstitialVideoHandler(activity, string, this.mbUnitId);
                this.mbBidInterstitialVideoHandler = mBBidInterstitialVideoHandler;
                map.put(this.mbUnitId, mBBidInterstitialVideoHandler);
            }
            this.mbBidInterstitialVideoHandler.setInterstitialVideoListener(mintegralMediationAdapterRouter.getInterstitialListener());
            this.mbBidInterstitialVideoHandler.playVideoMute(1);
            this.mbBidInterstitialVideoHandler.loadFromBid(maxAdapterResponseParameters.getBidResponse());
            return;
        }
        log("Loading mediated interstitial ad for unit id: " + this.mbUnitId + " and placement id: " + string + "...");
        Map<String, MBInterstitialVideoHandler> map2 = mbInterstitialVideoHandlers;
        if (map2.containsKey(this.mbUnitId)) {
            this.mbInterstitialVideoHandler = map2.get(this.mbUnitId);
        } else {
            MBInterstitialVideoHandler mBInterstitialVideoHandler = new MBInterstitialVideoHandler(activity, string, this.mbUnitId);
            this.mbInterstitialVideoHandler = mBInterstitialVideoHandler;
            map2.put(this.mbUnitId, mBInterstitialVideoHandler);
        }
        this.mbInterstitialVideoHandler.setInterstitialVideoListener(mintegralMediationAdapterRouter.getInterstitialListener());
        if (this.mbInterstitialVideoHandler.isReady()) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
            log("A mediated interstitial ad is ready already");
            if (AppLovinSdk.VERSION_CODE >= 9150000 && !TextUtils.isEmpty(this.mbInterstitialVideoHandler.getRequestId())) {
                Bundle bundle = new Bundle(1);
                bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, this.mbInterstitialVideoHandler.getRequestId());
                mintegralMediationAdapterRouter.onAdLoaded(this.mbUnitId, bundle);
                return;
            }
            mintegralMediationAdapterRouter.onAdLoaded(this.mbUnitId);
            return;
        }
        this.mbInterstitialVideoHandler.playVideoMute(1);
        this.mbInterstitialVideoHandler.load();
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        MintegralMediationAdapterRouter mintegralMediationAdapterRouter = router;
        mintegralMediationAdapterRouter.addShowingAdapter(this);
        MBBidInterstitialVideoHandler mBBidInterstitialVideoHandler = this.mbBidInterstitialVideoHandler;
        if (mBBidInterstitialVideoHandler != null && mBBidInterstitialVideoHandler.isBidReady()) {
            log("Showing bidding interstitial...");
            this.mbBidInterstitialVideoHandler.showFromBid();
            return;
        }
        MBInterstitialVideoHandler mBInterstitialVideoHandler = this.mbInterstitialVideoHandler;
        if (mBInterstitialVideoHandler != null && mBInterstitialVideoHandler.isReady()) {
            log("Showing mediated interstitial...");
            this.mbInterstitialVideoHandler.show();
        } else {
            log("Unable to show interstitial - no ad loaded...");
            mintegralMediationAdapterRouter.onAdDisplayFailed(this.mbUnitId, new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        this.mbUnitId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        String string = BundleUtils.getString(com.google.ads.mediation.facebook.FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, maxAdapterResponseParameters.getServerParameters());
        MintegralMediationAdapterRouter mintegralMediationAdapterRouter = router;
        mintegralMediationAdapterRouter.addRewardedAdapter(this, maxRewardedAdapterListener, this.mbUnitId);
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding rewarded ad for unit id: " + this.mbUnitId + " and placement id: " + string + "...");
            Map<String, MBBidRewardVideoHandler> map = mbBidRewardVideoHandlers;
            if (map.containsKey(this.mbUnitId)) {
                this.mbBidRewardVideoHandler = map.get(this.mbUnitId);
            } else {
                MBBidRewardVideoHandler mBBidRewardVideoHandler = new MBBidRewardVideoHandler(activity, string, this.mbUnitId);
                this.mbBidRewardVideoHandler = mBBidRewardVideoHandler;
                map.put(this.mbUnitId, mBBidRewardVideoHandler);
            }
            this.mbBidRewardVideoHandler.setRewardVideoListener(mintegralMediationAdapterRouter.getRewardedListener());
            this.mbBidRewardVideoHandler.playVideoMute(1);
            this.mbBidRewardVideoHandler.loadFromBid(maxAdapterResponseParameters.getBidResponse());
            return;
        }
        log("Loading mediated rewarded ad for unit id: " + this.mbUnitId + " and placement id: " + string + "...");
        Map<String, MBRewardVideoHandler> map2 = mbRewardVideoHandlers;
        if (map2.containsKey(this.mbUnitId)) {
            this.mbRewardVideoHandler = map2.get(this.mbUnitId);
        } else {
            MBRewardVideoHandler mBRewardVideoHandler = new MBRewardVideoHandler(activity, string, this.mbUnitId);
            this.mbRewardVideoHandler = mBRewardVideoHandler;
            map2.put(this.mbUnitId, mBRewardVideoHandler);
        }
        this.mbRewardVideoHandler.setRewardVideoListener(mintegralMediationAdapterRouter.getRewardedListener());
        if (this.mbRewardVideoHandler.isReady()) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
            log("A mediated rewarded ad is ready already");
            if (AppLovinSdk.VERSION_CODE >= 9150000 && !TextUtils.isEmpty(this.mbRewardVideoHandler.getRequestId())) {
                Bundle bundle = new Bundle(1);
                bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, this.mbRewardVideoHandler.getRequestId());
                mintegralMediationAdapterRouter.onAdLoaded(this.mbUnitId, bundle);
                return;
            }
            mintegralMediationAdapterRouter.onAdLoaded(this.mbUnitId);
            return;
        }
        this.mbRewardVideoHandler.playVideoMute(1);
        this.mbRewardVideoHandler.load();
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        MintegralMediationAdapterRouter mintegralMediationAdapterRouter = router;
        mintegralMediationAdapterRouter.addShowingAdapter(this);
        configureReward(maxAdapterResponseParameters);
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        String string = serverParameters.getString("reward_id", "");
        String string2 = serverParameters.getString("user_id", "");
        MBBidRewardVideoHandler mBBidRewardVideoHandler = this.mbBidRewardVideoHandler;
        if (mBBidRewardVideoHandler != null && mBBidRewardVideoHandler.isBidReady()) {
            log("Showing bidding rewarded ad...");
            this.mbBidRewardVideoHandler.showFromBid(string, string2);
            return;
        }
        MBRewardVideoHandler mBRewardVideoHandler = this.mbRewardVideoHandler;
        if (mBRewardVideoHandler != null && mBRewardVideoHandler.isReady()) {
            log("Showing mediated rewarded ad...");
            this.mbRewardVideoHandler.show(string, string2);
        } else {
            log("Unable to show rewarded ad - no ad loaded...");
            mintegralMediationAdapterRouter.onAdDisplayFailed(this.mbUnitId, new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, final MaxAdViewAdapterListener maxAdViewAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        this.mbUnitId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        String string = BundleUtils.getString(com.google.ads.mediation.facebook.FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, maxAdapterResponseParameters.getServerParameters());
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        log("Loading" + (z ? " native " : " ") + maxAdFormat.getLabel() + " AdView ad for placement: " + string + "...");
        if (z) {
            Map<String, Object> nativeProperties = MBBidNativeHandler.getNativeProperties(string, this.mbUnitId);
            nativeProperties.put("ad_num", 1);
            nativeProperties.put(MBridgeConstans.NATIVE_VIDEO_SUPPORT, true);
            NativeAdViewListener nativeAdViewListener = new NativeAdViewListener(maxAdapterResponseParameters, maxAdFormat, getContext(activity), maxAdViewAdapterListener);
            MBBidNativeHandler mBBidNativeHandler = new MBBidNativeHandler(nativeProperties, getContext(activity));
            this.mbBidNativeAdViewHandler = mBBidNativeHandler;
            mBBidNativeHandler.setAdListener(nativeAdViewListener);
            this.mbBidNativeAdViewHandler.bidLoad(maxAdapterResponseParameters.getBidResponse());
            return;
        }
        MBBannerView mBBannerView = new MBBannerView(getContext(activity));
        this.mbBannerView = mBBannerView;
        mBBannerView.init(toBannerSize(maxAdFormat), string, this.mbUnitId);
        this.mbBannerView.setAllowShowCloseBtn(false);
        this.mbBannerView.setRefreshTime(0);
        this.mbBannerView.setBannerAdListener(new BannerAdListener() { // from class: com.applovin.mediation.adapters.MintegralMediationAdapter.1
            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLoadSuccessed(MBridgeIds mBridgeIds) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                MintegralMediationAdapter.this.log("Banner ad loaded for: " + mBridgeIds);
                if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(MintegralMediationAdapter.this.mbBannerView.getRequestId())) {
                    maxAdViewAdapterListener.onAdViewAdLoaded(MintegralMediationAdapter.this.mbBannerView);
                    return;
                }
                Bundle bundle = new Bundle(1);
                bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, MintegralMediationAdapter.this.mbBannerView.getRequestId());
                maxAdViewAdapterListener.onAdViewAdLoaded(MintegralMediationAdapter.this.mbBannerView, bundle);
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_BANNER, "Failure, " + str);
                MintegralMediationAdapter.this.log("Banner ad failed to load: " + str + " for: " + mBridgeIds);
                maxAdViewAdapterListener.onAdViewAdLoadFailed(MintegralMediationAdapter.toMaxError(str));
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLogImpression(MBridgeIds mBridgeIds) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_IMPRESSION);
                MintegralMediationAdapter.this.log("Banner ad displayed");
                maxAdViewAdapterListener.onAdViewAdDisplayed();
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onClick(MBridgeIds mBridgeIds) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                MintegralMediationAdapter.this.log("Banner ad clicked");
                maxAdViewAdapterListener.onAdViewAdClicked();
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLeaveApp(MBridgeIds mBridgeIds) {
                MintegralMediationAdapter.this.log("Banner ad will leave application");
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void showFullScreen(MBridgeIds mBridgeIds) {
                MintegralMediationAdapter.this.log("Banner ad expanded");
                maxAdViewAdapterListener.onAdViewAdExpanded();
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void closeFullScreen(MBridgeIds mBridgeIds) {
                MintegralMediationAdapter.this.log("Banner ad collapsed");
                maxAdViewAdapterListener.onAdViewAdCollapsed();
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onCloseBanner(MBridgeIds mBridgeIds) {
                MintegralMediationAdapter.this.log("Banner ad closed");
            }
        });
        if (AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse())) {
            this.mbBannerView.loadFromBid(maxAdapterResponseParameters.getBidResponse());
        } else {
            this.mbBannerView.load();
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD);
        this.mbUnitId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        String string = BundleUtils.getString(com.google.ads.mediation.facebook.FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, maxAdapterResponseParameters.getServerParameters());
        log("Loading bidding native ad for unit id: " + this.mbUnitId + " and placement id: " + string + "...");
        Map<String, Object> nativeProperties = MBBidNativeHandler.getNativeProperties(string, this.mbUnitId);
        nativeProperties.put("ad_num", 1);
        nativeProperties.put(MBridgeConstans.NATIVE_VIDEO_SUPPORT, true);
        NativeAdListener nativeAdListener = new NativeAdListener(maxAdapterResponseParameters, getContext(activity), maxNativeAdAdapterListener);
        MBBidNativeHandler mBBidNativeHandler = new MBBidNativeHandler(nativeProperties, getContext(activity));
        this.mbBidNativeHandler = mBBidNativeHandler;
        mBBidNativeHandler.setAdListener(nativeAdListener);
        this.mbBidNativeHandler.bidLoad(maxAdapterResponseParameters.getBidResponse());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaxNativeAdView createMaxNativeAdViewWithNativeAd(MaxNativeAd maxNativeAd, String str, Context context) {
        if (str.contains("vertical")) {
            if (AppLovinSdk.VERSION_CODE < 9140500) {
                log("Vertical native banners are only supported on MAX SDK 9.14.5 and above. Default horizontal native template will be used.");
            }
            if (str.equals("vertical")) {
                return new MaxNativeAdView(maxNativeAd, maxNativeAd.getFormat() == MaxAdFormat.LEADER ? "vertical_leader_template" : "vertical_media_banner_template", context);
            }
            return new MaxNativeAdView(maxNativeAd, str, context);
        }
        if (AppLovinSdk.VERSION_CODE < 9140500) {
            if (!AppLovinSdkUtils.isValidString(str)) {
                str = "no_body_banner_template";
            }
            return new MaxNativeAdView(maxNativeAd, str, context);
        }
        if (!AppLovinSdkUtils.isValidString(str)) {
            str = "media_banner_template";
        }
        return new MaxNativeAdView(maxNativeAd, str, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ExecutorService getExecutorServiceToUse() {
        if (AppLovinSdk.VERSION_CODE >= 11000000) {
            return getCachingExecutorService();
        }
        return executor;
    }

    private static String toMintegralAdType(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
            return BidConstants.BID_FILTER_VALUE_AD_TYPE_INTERSTITIAL_VIDEO;
        }
        if (maxAdFormat == MaxAdFormat.REWARDED) {
            return BidConstants.BID_FILTER_VALUE_AD_TYPE_REWARD_VIDEO;
        }
        if (maxAdFormat == MaxAdFormat.APP_OPEN) {
            return BidConstants.BID_FILTER_VALUE_AD_TYPE_SPLASH;
        }
        if (maxAdFormat == MaxAdFormat.BANNER || maxAdFormat == MaxAdFormat.LEADER || maxAdFormat == MaxAdFormat.MREC) {
            return BidConstants.BID_FILTER_VALUE_AD_TYPE_BANNER;
        }
        return maxAdFormat == MaxAdFormat.NATIVE ? BidConstants.BID_FILTER_VALUE_AD_TYPE_NATIVE : "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(String str) {
        MaxAdapterError maxAdapterError;
        if (NOT_INITIALIZED.equals(str) || str.contains(EXCEPTION_IV_RECALLNET_INVALIDATE)) {
            maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
        } else if (str.contains(NO_FILL_1) || str.contains(NO_FILL_2) || str.contains(NO_FILL_3) || str.contains(NO_FILL_4) || str.contains(NO_FILL_5) || str.contains(EXCEPTION_RETURN_EMPTY)) {
            maxAdapterError = MaxAdapterError.NO_FILL;
        } else if (NETWORK_ERROR.equalsIgnoreCase(str) || str.contains(NETWORK_IO_ERROR)) {
            maxAdapterError = MaxAdapterError.NO_CONNECTION;
        } else if (BAD_REQUEST.equalsIgnoreCase(str)) {
            maxAdapterError = MaxAdapterError.BAD_REQUEST;
        } else if (TIMEOUT.equalsIgnoreCase(str) || str.contains(EXCEPTION_TIMEOUT)) {
            maxAdapterError = MaxAdapterError.TIMEOUT;
        } else if (str.contains(EXCEPTION_SIGN_ERROR) || str.contains(EXCEPTION_UNIT_NOT_FOUND) || str.contains(EXCEPTION_UNIT_ID_EMPTY) || str.contains(EXCEPTION_UNIT_NOT_FOUND_IN_APP) || str.contains(EXCEPTION_UNIT_ADTYPE_ERROR) || str.contains(EXCEPTION_APP_ID_EMPTY) || str.contains(EXCEPTION_APP_NOT_FOUND) || str.contains(UNIT_ID_EMPTY)) {
            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
        } else {
            maxAdapterError = MaxAdapterError.UNSPECIFIED;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), 0, str);
    }

    private Context getContext(Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }

    private BannerSize toBannerSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER || maxAdFormat == MaxAdFormat.LEADER) {
            return new BannerSize(3, 0, 0);
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return new BannerSize(2, 0, 0);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<View> getClickableViews(MaxNativeAdView maxNativeAdView) {
        if (AppLovinSdk.VERSION_CODE < 11050300) {
            ArrayList arrayList = new ArrayList(5);
            if (maxNativeAdView.getTitleTextView() != null) {
                arrayList.add(maxNativeAdView.getTitleTextView());
            }
            if (maxNativeAdView.getAdvertiserTextView() != null) {
                arrayList.add(maxNativeAdView.getAdvertiserTextView());
            }
            if (maxNativeAdView.getBodyTextView() != null) {
                arrayList.add(maxNativeAdView.getBodyTextView());
            }
            if (maxNativeAdView.getCallToActionButton() != null) {
                arrayList.add(maxNativeAdView.getCallToActionButton());
            }
            if (maxNativeAdView.getIconImageView() != null) {
                arrayList.add(maxNativeAdView.getIconImageView());
            }
            return arrayList;
        }
        return maxNativeAdView.getClickableViews();
    }

    private static class MintegralMediationAdapterRouter extends MediationAdapterRouter {
        private final InterstitialVideoListener interstitialVideoListener = new InterstitialVideoListener() { // from class: com.applovin.mediation.adapters.MintegralMediationAdapter.MintegralMediationAdapterRouter.1
            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
                String requestId;
                MintegralMediationAdapterRouter.this.log("Interstitial successfully loaded and video has been downloaded for: " + mBridgeIds);
                String unitId = mBridgeIds.getUnitId();
                MBInterstitialVideoHandler mBInterstitialVideoHandler = (MBInterstitialVideoHandler) MintegralMediationAdapter.mbInterstitialVideoHandlers.get(unitId);
                MBBidInterstitialVideoHandler mBBidInterstitialVideoHandler = (MBBidInterstitialVideoHandler) MintegralMediationAdapter.mbBidInterstitialVideoHandlers.get(unitId);
                if (mBBidInterstitialVideoHandler != null) {
                    requestId = mBBidInterstitialVideoHandler.getRequestId();
                } else {
                    requestId = mBInterstitialVideoHandler.getRequestId();
                }
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AppLovinSdk.VERSION_CODE >= 9150000 && !TextUtils.isEmpty(requestId)) {
                    Bundle bundle = new Bundle(1);
                    bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, requestId);
                    MintegralMediationAdapterRouter.this.onAdLoaded(unitId, bundle);
                    return;
                }
                MintegralMediationAdapterRouter.this.onAdLoaded(unitId);
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onLoadSuccess(MBridgeIds mBridgeIds) {
                MintegralMediationAdapterRouter.this.log("Interstitial successfully loaded but video still needs to be downloaded for: " + mBridgeIds);
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + str);
                MintegralMediationAdapterRouter.this.log("Interstitial failed to load: " + str + " for: " + mBridgeIds);
                MintegralMediationAdapterRouter.this.onAdLoadFailed(mBridgeIds.getUnitId(), MintegralMediationAdapter.toMaxError(str));
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onAdShow(MBridgeIds mBridgeIds) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_IMPRESSION);
                MintegralMediationAdapterRouter.this.log("Interstitial displayed");
                MintegralMediationAdapterRouter.this.onAdDisplayed(mBridgeIds.getUnitId());
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onShowFail(MBridgeIds mBridgeIds, String str) {
                Log.d(MintegralMediationAdapter.TAG, "onShowFail - MBridgeIds : " + mBridgeIds + ", errorMsg : " + str);
                MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, str);
                MintegralMediationAdapterRouter.this.log("Interstitial failed to show: " + maxAdapterError);
                MintegralMediationAdapterRouter.this.onAdDisplayFailed(mBridgeIds.getUnitId(), maxAdapterError);
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onVideoAdClicked(MBridgeIds mBridgeIds) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                MintegralMediationAdapterRouter.this.log("Interstitial clicked");
                MintegralMediationAdapterRouter.this.onAdClicked(mBridgeIds.getUnitId());
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                MintegralMediationAdapterRouter.this.log("Interstitial hidden");
                MintegralMediationAdapterRouter.this.onAdHidden(mBridgeIds.getUnitId());
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onVideoComplete(MBridgeIds mBridgeIds) {
                MintegralMediationAdapterRouter.this.log("Interstitial video completed");
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                MintegralMediationAdapterRouter.this.log("Interstitial with reward hidden");
            }

            @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
            public void onEndcardShow(MBridgeIds mBridgeIds) {
                MintegralMediationAdapterRouter.this.log("Interstitial endcard shown");
            }
        };
        private final RewardVideoListener rewardVideoListener = new RewardVideoListener() { // from class: com.applovin.mediation.adapters.MintegralMediationAdapter.MintegralMediationAdapterRouter.2
            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
                String requestId;
                MintegralMediationAdapterRouter.this.log("Rewarded ad successfully loaded and video has been downloaded for: " + mBridgeIds);
                String unitId = mBridgeIds.getUnitId();
                MBRewardVideoHandler mBRewardVideoHandler = (MBRewardVideoHandler) MintegralMediationAdapter.mbRewardVideoHandlers.get(unitId);
                MBBidRewardVideoHandler mBBidRewardVideoHandler = (MBBidRewardVideoHandler) MintegralMediationAdapter.mbBidRewardVideoHandlers.get(unitId);
                if (mBBidRewardVideoHandler != null) {
                    requestId = mBBidRewardVideoHandler.getRequestId();
                } else {
                    requestId = mBRewardVideoHandler.getRequestId();
                }
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AppLovinSdk.VERSION_CODE >= 9150000 && !TextUtils.isEmpty(requestId)) {
                    Bundle bundle = new Bundle(1);
                    bundle.putString(CampaignEx.JSON_KEY_CREATIVE_ID, requestId);
                    MintegralMediationAdapterRouter.this.onAdLoaded(unitId, bundle);
                    return;
                }
                MintegralMediationAdapterRouter.this.onAdLoaded(unitId);
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onLoadSuccess(MBridgeIds mBridgeIds) {
                MintegralMediationAdapterRouter.this.log("Rewarded ad successfully loaded but video still needs to be downloaded for: " + mBridgeIds);
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, "Failure, " + str);
                MintegralMediationAdapterRouter.this.log("Rewarded ad failed to load: " + str + " for: " + mBridgeIds);
                MintegralMediationAdapterRouter.this.onAdLoadFailed(mBridgeIds.getUnitId(), MintegralMediationAdapter.toMaxError(str));
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onAdShow(MBridgeIds mBridgeIds) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_IMPRESSION);
                MintegralMediationAdapterRouter.this.log("Rewarded ad displayed");
                String unitId = mBridgeIds.getUnitId();
                MintegralMediationAdapterRouter.this.onAdDisplayed(unitId);
                MintegralMediationAdapterRouter.this.onRewardedAdVideoStarted(unitId);
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onShowFail(MBridgeIds mBridgeIds, String str) {
                Log.d(MintegralMediationAdapter.TAG, "onShowFail - MBridgeIds : " + mBridgeIds + ", errorMsg : " + str);
                MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, str);
                MintegralMediationAdapterRouter.this.log("Rewarded ad failed to show: " + maxAdapterError);
                MintegralMediationAdapterRouter.this.onAdDisplayFailed(mBridgeIds.getUnitId(), maxAdapterError);
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoAdClicked(MBridgeIds mBridgeIds) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                MintegralMediationAdapterRouter.this.log("Rewarded ad clicked");
                MintegralMediationAdapterRouter.this.onAdClicked(mBridgeIds.getUnitId());
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                MintegralMediationAdapterRouter.this.log("Rewarded ad hidden");
                String unitId = mBridgeIds.getUnitId();
                if (rewardInfo.isCompleteView()) {
                    ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    MintegralMediationAdapterRouter.this.onRewardedAdVideoCompleted(unitId);
                    MintegralMediationAdapterRouter mintegralMediationAdapterRouter = MintegralMediationAdapterRouter.this;
                    mintegralMediationAdapterRouter.onUserRewarded(unitId, mintegralMediationAdapterRouter.getReward(unitId));
                } else if (MintegralMediationAdapterRouter.this.shouldAlwaysRewardUser(unitId)) {
                    ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    MintegralMediationAdapterRouter mintegralMediationAdapterRouter2 = MintegralMediationAdapterRouter.this;
                    mintegralMediationAdapterRouter2.onUserRewarded(unitId, mintegralMediationAdapterRouter2.getReward(unitId));
                }
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                MintegralMediationAdapterRouter.this.onAdHidden(unitId);
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoComplete(MBridgeIds mBridgeIds) {
                MintegralMediationAdapterRouter.this.log("Rewarded ad video completed");
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onEndcardShow(MBridgeIds mBridgeIds) {
                MintegralMediationAdapterRouter.this.log("Rewarded ad endcard shown");
            }
        };

        @Override // com.applovin.mediation.adapters.MediationAdapterRouter
        void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        }

        private MintegralMediationAdapterRouter() {
        }

        InterstitialVideoListener getInterstitialListener() {
            return this.interstitialVideoListener;
        }

        RewardVideoListener getRewardedListener() {
            return this.rewardVideoListener;
        }
    }

    private class NativeAdViewListener implements NativeListener.NativeAdListener, OnMBMediaViewListener {
        private final MaxAdFormat adFormat;
        private final Context context;
        private final MaxAdViewAdapterListener listener;
        private final String placementId;
        private final Bundle serverParameters;
        private final String unitId;

        NativeAdViewListener(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Context context, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.serverParameters = maxAdapterResponseParameters.getServerParameters();
            this.adFormat = maxAdFormat;
            this.context = context;
            this.listener = maxAdViewAdapterListener;
            this.unitId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.placementId = BundleUtils.getString(com.google.ads.mediation.facebook.FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, maxAdapterResponseParameters.getServerParameters());
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdLoaded(List<Campaign> list, int i) {
            if (list == null || list.isEmpty()) {
                MintegralMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load for unit id: " + this.unitId + " placement id: " + this.placementId + " with error: no fill");
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
                return;
            }
            final Campaign campaign = list.get(0);
            if (!TextUtils.isEmpty(campaign.getAppName())) {
                MintegralMediationAdapter.this.nativeAdCampaign = campaign;
                MintegralMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad loaded for unit id: " + this.unitId + " placement id: " + this.placementId);
                MintegralMediationAdapter.this.getExecutorServiceToUse().submit(new Runnable() { // from class: com.applovin.mediation.adapters.MintegralMediationAdapter.NativeAdViewListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String iconUrl = campaign.getIconUrl();
                        String imageUrl = campaign.getImageUrl();
                        Future<Drawable> futureCreateDrawableFuture = MintegralMediationAdapter.this.createDrawableFuture(iconUrl, NativeAdViewListener.this.context.getResources());
                        new MaxNativeAd.MaxNativeAdImage(Uri.parse(imageUrl));
                        final MaxNativeAd.MaxNativeAdImage maxNativeAdImage = null;
                        try {
                            Drawable drawable = futureCreateDrawableFuture.get(BundleUtils.getInt("image_task_timeout_seconds", 5, NativeAdViewListener.this.serverParameters), TimeUnit.SECONDS);
                            if (drawable != null) {
                                maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(drawable);
                            }
                        } catch (Throwable th) {
                            MintegralMediationAdapter.this.log("Failed to fetch icon image from URL: " + iconUrl, th);
                        }
                        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.MintegralMediationAdapter.NativeAdViewListener.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MBMediaView mBMediaView = new MBMediaView(NativeAdViewListener.this.context);
                                mBMediaView.setNativeAd(campaign);
                                mBMediaView.setOnMediaViewListener(NativeAdViewListener.this);
                                MBAdChoice mBAdChoice = new MBAdChoice(NativeAdViewListener.this.context);
                                mBAdChoice.setCampaign(campaign);
                                MaxNativeAd.Builder mediaView = new MaxNativeAd.Builder().setAdFormat(NativeAdViewListener.this.adFormat).setTitle(campaign.getAppName()).setBody(campaign.getAppDesc()).setCallToAction(campaign.getAdCall()).setIcon(maxNativeAdImage).setOptionsView(mBAdChoice).setMediaView(mBMediaView);
                                MintegralMediationAdapter.this.nativeAd = MintegralMediationAdapter.this.new MaxMintegralNativeAd(mediaView);
                                MaxNativeAdView maxNativeAdViewCreateMaxNativeAdViewWithNativeAd = MintegralMediationAdapter.this.createMaxNativeAdViewWithNativeAd(MintegralMediationAdapter.this.nativeAd, BundleUtils.getString("template", "", NativeAdViewListener.this.serverParameters), NativeAdViewListener.this.context);
                                MintegralMediationAdapter.this.nativeAd.prepareForInteraction(MintegralMediationAdapter.this.getClickableViews(maxNativeAdViewCreateMaxNativeAdViewWithNativeAd), maxNativeAdViewCreateMaxNativeAdViewWithNativeAd);
                                NativeAdViewListener.this.listener.onAdViewAdLoaded(maxNativeAdViewCreateMaxNativeAdViewWithNativeAd);
                            }
                        });
                    }
                });
            } else {
                MintegralMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load for unit id: " + this.unitId + " placement id: " + this.placementId + " with error: missing required assets");
                this.listener.onAdViewAdLoadFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdLoadError(String str) {
            MaxAdapterError maxError = MintegralMediationAdapter.toMaxError(str);
            MintegralMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load for unit id: " + this.unitId + " placement id: " + this.placementId + " with error: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onLoggingImpression(int i) {
            MintegralMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad shown for unit id: " + this.unitId + " placement id: " + this.placementId);
            this.listener.onAdViewAdDisplayed(null);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdClick(Campaign campaign) {
            MintegralMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad clicked for unit id: " + this.unitId + " placement id: " + this.placementId);
            this.listener.onAdViewAdClicked();
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdFramesLoaded(List<Frame> list) {
            MintegralMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad frames loaded for unit id: " + this.unitId + " placement id: " + this.placementId);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onEnterFullscreen() {
            MintegralMediationAdapter.this.log("Media view entered fullscreen");
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onExitFullscreen() {
            MintegralMediationAdapter.this.log("Media view exited fullscreen");
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onStartRedirection(Campaign campaign, String str) {
            MintegralMediationAdapter.this.log("Media view started redirection with url: " + str);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onFinishRedirection(Campaign campaign, String str) {
            MintegralMediationAdapter.this.log("Media view finished redirection with url: " + str);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            MintegralMediationAdapter.this.log("Media view redirection failed with url: " + str);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onVideoAdClicked(Campaign campaign) {
            MintegralMediationAdapter.this.log("Media view clicked for unit id: " + this.unitId + " placement id: " + this.placementId);
            this.listener.onAdViewAdClicked();
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onVideoStart() {
            MintegralMediationAdapter.this.log("Media view video started");
        }
    }

    private class NativeAdListener implements NativeListener.NativeAdListener, OnMBMediaViewListener {
        private final Context context;
        private final MaxNativeAdAdapterListener listener;
        private final MaxAdapterResponseParameters parameters;
        private final String placementId;
        private final String unitId;

        NativeAdListener(MaxAdapterResponseParameters maxAdapterResponseParameters, Context context, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.parameters = maxAdapterResponseParameters;
            this.context = context;
            this.listener = maxNativeAdAdapterListener;
            this.unitId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.placementId = BundleUtils.getString(com.google.ads.mediation.facebook.FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, maxAdapterResponseParameters.getServerParameters());
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdLoaded(List<Campaign> list, int i) {
            if (list == null || list.isEmpty()) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_FAILURE);
                MintegralMediationAdapter.this.log("Native ad failed to load for unit id: " + this.unitId + " placement id: " + this.placementId + " with error: no fill");
                this.listener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
                return;
            }
            Campaign campaign = list.get(0);
            if (!AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", this.parameters.getServerParameters())) || !TextUtils.isEmpty(campaign.getAppName())) {
                MintegralMediationAdapter.this.nativeAdCampaign = campaign;
                MintegralMediationAdapter.this.log("Native ad loaded for unit id: " + this.unitId + " placement id: " + this.placementId);
                processNativeAd(campaign);
            } else {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_FAILURE);
                MintegralMediationAdapter.this.log("Native ad failed to load for unit id: " + this.unitId + " placement id: " + this.placementId + " with error: missing required assets");
                this.listener.onNativeAdLoadFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdLoadError(String str) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_NATIVE, "Failure, " + str);
            MaxAdapterError maxError = MintegralMediationAdapter.toMaxError(str);
            MintegralMediationAdapter.this.log("Native ad failed to load for unit id: " + this.unitId + " placement id: " + this.placementId + " with error: " + maxError);
            this.listener.onNativeAdLoadFailed(maxError);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onLoggingImpression(int i) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_IMPRESSION);
            MintegralMediationAdapter.this.log("Native ad shown for unit id: " + this.unitId + " placement id: " + this.placementId);
            this.listener.onNativeAdDisplayed(null);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdClick(Campaign campaign) {
            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_CLICK);
            MintegralMediationAdapter.this.log("Native ad clicked for unit id: " + this.unitId + " placement id: " + this.placementId);
            this.listener.onNativeAdClicked();
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
        public void onAdFramesLoaded(List<Frame> list) {
            MintegralMediationAdapter.this.log("Native ad frames loaded for unit id: " + this.unitId + " placement id: " + this.placementId);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onEnterFullscreen() {
            MintegralMediationAdapter.this.log("Media view entered fullscreen");
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onExitFullscreen() {
            MintegralMediationAdapter.this.log("Media view exited fullscreen");
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onStartRedirection(Campaign campaign, String str) {
            MintegralMediationAdapter.this.log("Media view started redirection with url: " + str);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onFinishRedirection(Campaign campaign, String str) {
            MintegralMediationAdapter.this.log("Media view finished redirection with url: " + str);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            MintegralMediationAdapter.this.log("Media view redirection failed with url: " + str);
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onVideoAdClicked(Campaign campaign) {
            MintegralMediationAdapter.this.log("Media view clicked for unit id: " + this.unitId + " placement id: " + this.placementId);
            this.listener.onNativeAdClicked();
        }

        @Override // com.mbridge.msdk.out.OnMBMediaViewListener
        public void onVideoStart() {
            MintegralMediationAdapter.this.log("Media view video started");
        }

        private void processNativeAd(final Campaign campaign) {
            MintegralMediationAdapter.this.getExecutorServiceToUse().submit(new Runnable() { // from class: com.applovin.mediation.adapters.MintegralMediationAdapter.NativeAdListener.1
                @Override // java.lang.Runnable
                public void run() {
                    String iconUrl = campaign.getIconUrl();
                    String imageUrl = campaign.getImageUrl();
                    Future<Drawable> futureCreateDrawableFuture = MintegralMediationAdapter.this.createDrawableFuture(iconUrl, NativeAdListener.this.context.getResources());
                    final MaxNativeAd.MaxNativeAdImage maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(Uri.parse(imageUrl));
                    final MaxNativeAd.MaxNativeAdImage maxNativeAdImage2 = null;
                    try {
                        Drawable drawable = futureCreateDrawableFuture.get(BundleUtils.getInt("image_task_timeout_seconds", 5, NativeAdListener.this.parameters.getServerParameters()), TimeUnit.SECONDS);
                        if (drawable != null) {
                            maxNativeAdImage2 = new MaxNativeAd.MaxNativeAdImage(drawable);
                        }
                    } catch (Throwable th) {
                        MintegralMediationAdapter.this.log("Failed to fetch icon image from URL: " + iconUrl, th);
                    }
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.MintegralMediationAdapter.NativeAdListener.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MBMediaView mBMediaView = new MBMediaView(NativeAdListener.this.context);
                            mBMediaView.setNativeAd(campaign);
                            mBMediaView.setOnMediaViewListener(NativeAdListener.this);
                            MBAdChoice mBAdChoice = new MBAdChoice(NativeAdListener.this.context);
                            mBAdChoice.setCampaign(campaign);
                            MaxNativeAd.Builder mediaView = new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(campaign.getAppName()).setBody(campaign.getAppDesc()).setCallToAction(campaign.getAdCall()).setIcon(maxNativeAdImage2).setOptionsView(mBAdChoice).setMediaView(mBMediaView);
                            if (AppLovinSdk.VERSION_CODE >= 11040399) {
                                mediaView.setMainImage(maxNativeAdImage);
                            }
                            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_MINTEGRAL, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_SUCCESS);
                            if (AppLovinSdk.VERSION_CODE >= 11070000) {
                                mediaView.setStarRating(Double.valueOf(campaign.getRating()));
                            }
                            MintegralMediationAdapter.this.nativeAd = MintegralMediationAdapter.this.new MaxMintegralNativeAd(mediaView);
                            NativeAdListener.this.listener.onNativeAdLoaded(MintegralMediationAdapter.this.nativeAd, null);
                        }
                    });
                }
            });
        }
    }

    private class MaxMintegralNativeAd extends MaxNativeAd {
        public MaxMintegralNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
            prepareForInteraction(MintegralMediationAdapter.this.getClickableViews(maxNativeAdView), maxNativeAdView);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            Campaign campaign = MintegralMediationAdapter.this.nativeAdCampaign;
            if (campaign == null) {
                MintegralMediationAdapter.this.e("Failed to register native ad views: native ad is null.");
                return false;
            }
            MintegralMediationAdapter.this.d("Preparing views for interaction: " + list + " with container: " + viewGroup);
            if (getFormat() == MaxAdFormat.NATIVE) {
                if (MintegralMediationAdapter.this.mbBidNativeHandler != null) {
                    MintegralMediationAdapter.this.mbBidNativeHandler.registerView(viewGroup, list, campaign);
                } else {
                    MintegralMediationAdapter.this.e("Failed to register native ad views: mbBidNativeHandler is null.");
                }
            } else if (MintegralMediationAdapter.this.mbBidNativeAdViewHandler != null) {
                MintegralMediationAdapter.this.mbBidNativeAdViewHandler.registerView(viewGroup, list, campaign);
            } else {
                MintegralMediationAdapter.this.e("Failed to register native ad views: mbBidNativeAdViewHandler is null.");
            }
            MintegralMediationAdapter.this.nativeAdContainer = viewGroup;
            MintegralMediationAdapter.this.clickableViews = list;
            return true;
        }
    }
}
