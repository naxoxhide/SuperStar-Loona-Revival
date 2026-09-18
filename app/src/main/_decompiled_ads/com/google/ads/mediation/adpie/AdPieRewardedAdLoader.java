package com.google.ads.mediation.adpie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.AdPieError;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.RewardedVideoAd;
import com.gomfactory.adpie.sdk.videoads.FinishState;
import com.google.ads.mediation.AdErrorUtil;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.rewarded.RewardItem;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdPieRewardedAdLoader implements MediationRewardedAd, RewardedVideoAd.RewardedVideoAdListener {
    private static final String APP_ID = "app_id";
    private static final String DOMAIN = "com.google.ads.mediation.adpie";
    private static final String SLOT_ID = "slot_id";
    private String TAG = AdPieRewardedAdLoader.class.getSimpleName();
    private String mAppId;
    private RewardedVideoAd mRewardedVideoAd;
    private String mSlotId;
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;
    private final MediationRewardedAdConfiguration mediationRewardedAdConfiguration;
    private MediationRewardedAdCallback rewardedAdCallback;

    public AdPieRewardedAdLoader(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mediationRewardedAdConfiguration = mediationRewardedAdConfiguration;
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public void loadAd() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        try {
            Log.d(this.TAG, "severParameters : " + this.mediationRewardedAdConfiguration.getServerParameters());
            JSONObject jSONObject = new JSONObject(this.mediationRewardedAdConfiguration.getServerParameters().getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD));
            this.mAppId = jSONObject.getString("app_id");
            this.mSlotId = jSONObject.getString(SLOT_ID);
            Log.d(this.TAG, "AppId : " + this.mAppId + ", SlotId : " + this.mSlotId);
            if (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mSlotId)) {
                this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
                return;
            }
            final Context context = this.mediationRewardedAdConfiguration.getContext();
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(context, this.mAppId, new AdPieSDK.OnInitializedListener() { // from class: com.google.ads.mediation.adpie.AdPieRewardedAdLoader.1
                    @Override // com.gomfactory.adpie.sdk.AdPieSDK.OnInitializedListener
                    public void onCompleted(boolean z) {
                        if (!z) {
                            AdPieRewardedAdLoader.this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(104, "Failed to initialize SDK.", AdPieRewardedAdLoader.DOMAIN));
                        } else {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.ads.mediation.adpie.AdPieRewardedAdLoader.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdPieRewardedAdLoader.this.mRewardedVideoAd = new RewardedVideoAd(context, AdPieRewardedAdLoader.this.mSlotId);
                                    AdPieRewardedAdLoader.this.mRewardedVideoAd.setAdListener(AdPieRewardedAdLoader.this);
                                    AdPieRewardedAdLoader.this.mRewardedVideoAd.load();
                                }
                            });
                        }
                    }
                });
                return;
            }
            RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(context, this.mSlotId);
            this.mRewardedVideoAd = rewardedVideoAd;
            rewardedVideoAd.setAdListener(this);
            this.mRewardedVideoAd.load();
        } catch (Exception e) {
            e.printStackTrace();
            this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd != null && rewardedVideoAd.isLoaded()) {
            this.mRewardedVideoAd.show();
        } else {
            this.rewardedAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(0, "No ad to show.", DOMAIN));
        }
    }

    @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
    public void onRewardedVideoLoaded() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
        this.rewardedAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
    public void onRewardedVideoFailedToLoad(int i) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Failure, " + i + AdPieError.getMessage(i));
        this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(i, AdPieError.getMessage(i), DOMAIN));
    }

    @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
    public void onRewardedVideoClicked() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
        this.rewardedAdCallback.reportAdClicked();
    }

    @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
    public void onRewardedVideoStarted() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_IMPRESSION);
        this.rewardedAdCallback.onAdOpened();
        this.rewardedAdCallback.onVideoStart();
        this.rewardedAdCallback.reportAdImpression();
    }

    @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
    public void onRewardedVideoFinished(FinishState finishState) {
        if (finishState == FinishState.COMPLETED) {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
            this.rewardedAdCallback.onVideoComplete();
            this.rewardedAdCallback.onUserEarnedReward(new RewardItem() { // from class: com.google.ads.mediation.adpie.AdPieRewardedAdLoader.2
                @Override // com.google.android.gms.ads.rewarded.RewardItem
                public int getAmount() {
                    return 1;
                }

                @Override // com.google.android.gms.ads.rewarded.RewardItem
                public String getType() {
                    return ReportUtil.EVENT_TYPE_REWARD;
                }
            });
        } else if (finishState == FinishState.ERROR || finishState == FinishState.UNKNOWN) {
            this.rewardedAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(0, "A video error occurred.", DOMAIN));
        }
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
        this.rewardedAdCallback.onAdClosed();
    }
}
