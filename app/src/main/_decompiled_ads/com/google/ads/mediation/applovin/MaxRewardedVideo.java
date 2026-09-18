package com.google.ads.mediation.applovin;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.AdErrorUtil;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.rewarded.RewardItem;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MaxRewardedVideo extends Adapter implements MediationRewardedAd {
    public static final String ADUNIT_ID_EXTRA_KEY = "adunit_id";
    private static final String DOMAIN = "com.google.ads.mediation.applovin";
    private static final int ERROR_AD_NOT_READY = 103;
    private static final int ERROR_CONTEXT_NOT_ACTIVITY = 102;
    private static final int ERROR_INTERNAL_SDK = 105;
    private static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    private static final int ERROR_LOAD_TIMEOUT = 106;
    private static final int ERROR_SDK_INITIALIZATION = 104;
    private static final String TAG = "MaxRewardedVideo";
    private Context mContext;
    private Handler mHandler;
    private boolean mIsFinished;
    private MaxRewardedAd mMaxRewardedAd;
    private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    private MediationRewardedAdCallback mMediationRewardedAdCallback;

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (!(context instanceof Activity)) {
            initializationCompleteCallback.onInitializationFailed("AppLovin SDK requires an Activity context to initialize");
        } else {
            initializationCompleteCallback.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        return getSDKVersionInfo();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String[] strArrSplit = AppLovinSdk.VERSION.split("\\.");
        return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        this.mIsFinished = false;
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        handler.postDelayed(new Runnable() { // from class: com.google.ads.mediation.applovin.MaxRewardedVideo.1
            @Override // java.lang.Runnable
            public void run() {
                if (MaxRewardedVideo.this.mIsFinished) {
                    return;
                }
                MaxRewardedVideo.this.mIsFinished = true;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(MaxRewardedVideo.TAG, "CustomEvent loading time is delayed.");
                }
                if (MaxRewardedVideo.this.mMediationAdLoadCallback != null) {
                    MaxRewardedVideo.this.mMediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(106, "CustomEvent loading time is delayed.", "com.google.ads.mediation.applovin"));
                }
            }
        }, 15000L);
        Context context = mediationRewardedAdConfiguration.getContext();
        if (!(context instanceof Activity)) {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_FAILURE);
            mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(102, "AppLovin SDK requires an Activity context to load ads.", "com.google.ads.mediation.applovin"));
            return;
        }
        try {
            String string = new JSONObject(mediationRewardedAdConfiguration.getServerParameters().getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD)).getString(ADUNIT_ID_EXTRA_KEY);
            this.mContext = context;
            this.mMediationAdLoadCallback = mediationAdLoadCallback;
            if (!AppLovinSdk.getInstance(context).isInitialized()) {
                AppLovinSdk.getInstance(this.mContext).initializeSdk();
            }
            MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(string, (Activity) this.mContext);
            this.mMaxRewardedAd = maxRewardedAd;
            maxRewardedAd.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.mMaxRewardedAd.setListener(new MaxRewardedAdListener() { // from class: com.google.ads.mediation.applovin.MaxRewardedVideo.2
                @Override // com.applovin.mediation.MaxRewardedAdListener
                public void onRewardedVideoStarted(MaxAd maxAd) {
                    ADXLogUtil.d(MaxRewardedVideo.TAG, "onRewardedVideoStarted");
                    if (MaxRewardedVideo.this.mMediationRewardedAdCallback != null) {
                        MaxRewardedVideo.this.mMediationRewardedAdCallback.onVideoStart();
                    }
                }

                @Override // com.applovin.mediation.MaxRewardedAdListener
                public void onRewardedVideoCompleted(MaxAd maxAd) {
                    ADXLogUtil.d(MaxRewardedVideo.TAG, "onRewardedVideoCompleted");
                    if (MaxRewardedVideo.this.mMediationRewardedAdCallback != null) {
                        MaxRewardedVideo.this.mMediationRewardedAdCallback.onVideoComplete();
                    }
                }

                @Override // com.applovin.mediation.MaxRewardedAdListener
                public void onUserRewarded(MaxAd maxAd, final MaxReward maxReward) {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    RewardItem rewardItem = new RewardItem() { // from class: com.google.ads.mediation.applovin.MaxRewardedVideo.2.1
                        @Override // com.google.android.gms.ads.rewarded.RewardItem
                        public String getType() {
                            return maxReward.getLabel();
                        }

                        @Override // com.google.android.gms.ads.rewarded.RewardItem
                        public int getAmount() {
                            return maxReward.getAmount();
                        }
                    };
                    if (MaxRewardedVideo.this.mMediationRewardedAdCallback != null) {
                        MaxRewardedVideo.this.mMediationRewardedAdCallback.onUserEarnedReward(rewardItem);
                    }
                }

                @Override // com.applovin.mediation.MaxAdListener
                public void onAdLoaded(MaxAd maxAd) {
                    if (MaxRewardedVideo.this.mIsFinished) {
                        return;
                    }
                    MaxRewardedVideo.this.mIsFinished = true;
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                    ADXLogUtil.d(MaxRewardedVideo.TAG, "onAdLoaded : " + maxAd.getNetworkName());
                    if (MaxRewardedVideo.this.mMediationAdLoadCallback != null) {
                        MaxRewardedVideo maxRewardedVideo = MaxRewardedVideo.this;
                        maxRewardedVideo.mMediationRewardedAdCallback = (MediationRewardedAdCallback) maxRewardedVideo.mMediationAdLoadCallback.onSuccess(MaxRewardedVideo.this);
                    }
                }

                @Override // com.applovin.mediation.MaxAdListener
                public void onAdDisplayed(MaxAd maxAd) {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_IMPRESSION);
                    ADXLogUtil.d(MaxRewardedVideo.TAG, "onAdDisplayed : " + maxAd.getNetworkName() + ", CreativeId : " + maxAd.getCreativeId());
                    if (MaxRewardedVideo.this.mMediationRewardedAdCallback != null) {
                        MaxRewardedVideo.this.mMediationRewardedAdCallback.onAdOpened();
                    }
                }

                @Override // com.applovin.mediation.MaxAdListener
                public void onAdHidden(MaxAd maxAd) {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                    if (MaxRewardedVideo.this.mMediationRewardedAdCallback != null) {
                        MaxRewardedVideo.this.mMediationRewardedAdCallback.onAdClosed();
                    }
                }

                @Override // com.applovin.mediation.MaxAdListener
                public void onAdClicked(MaxAd maxAd) {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                    if (MaxRewardedVideo.this.mMediationRewardedAdCallback != null) {
                        MaxRewardedVideo.this.mMediationRewardedAdCallback.reportAdClicked();
                    }
                }

                @Override // com.applovin.mediation.MaxAdListener
                public void onAdLoadFailed(String str, MaxError maxError) {
                    if (MaxRewardedVideo.this.mIsFinished) {
                        return;
                    }
                    MaxRewardedVideo.this.mIsFinished = true;
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, "Failure, " + maxError.getCode() + "(" + maxError.getMessage() + ")");
                    if (MaxRewardedVideo.this.mMediationAdLoadCallback != null) {
                        MaxRewardedVideo.this.mMediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(maxError.getCode(), maxError.getMessage(), "com.google.ads.mediation.applovin"));
                    }
                }

                @Override // com.applovin.mediation.MaxAdListener
                public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                    ADXLogUtil.d(MaxRewardedVideo.TAG, "onAdDisplayFailed : " + maxAd.getNetworkName() + ", " + maxError.getCode() + ", " + maxError.getMessage());
                    if (MaxRewardedVideo.this.mMediationRewardedAdCallback != null) {
                        MaxRewardedVideo.this.mMediationRewardedAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(105, "A video error occurred.", "com.google.ads.mediation.applovin"));
                    }
                }
            });
            this.mMaxRewardedAd.loadAd();
        } catch (Exception unused) {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_FAILURE);
            mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "AppLovin SDK Internal Error", "com.google.ads.mediation.applovin"));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        MaxRewardedAd maxRewardedAd = this.mMaxRewardedAd;
        if (maxRewardedAd != null && maxRewardedAd.isReady()) {
            this.mMaxRewardedAd.showAd();
            return;
        }
        ADXLogUtil.d(TAG, "The rewarded ad wasn't loaded yet.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(103, "No ad to show.", "com.google.ads.mediation.applovin"));
        }
    }
}
