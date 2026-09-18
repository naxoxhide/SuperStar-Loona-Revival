package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.RewardedVideoAd;
import com.gomfactory.adpie.sdk.videoads.FinishState;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdxAdPieRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "AdxAdPieRewardedAd";
    private Activity mActivity;
    private String mAdUnitId;
    private String mAppId;
    private RCustomEventListener mCustomEventListener;
    private double mEcpm;
    private String mFloorPrice;
    private RewardedVideoAd mRewardedVideoAd;

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = rCustomEventListener;
        if (context == null) {
            Log.d(str, "Activity cannot be null.");
            RCustomEventListener rCustomEventListener2 = this.mCustomEventListener;
            if (rCustomEventListener2 != null) {
                rCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            Log.d(str, "An Activity Context is required.");
            RCustomEventListener rCustomEventListener3 = this.mCustomEventListener;
            if (rCustomEventListener3 != null) {
                rCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        this.mActivity = (Activity) context;
        this.mAppId = map.get("mid");
        this.mAdUnitId = map.get("sid");
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mAppId)) {
            Log.d(TAG, "The AppId cannot be null.");
            RCustomEventListener rCustomEventListener4 = this.mCustomEventListener;
            if (rCustomEventListener4 != null) {
                rCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            RCustomEventListener rCustomEventListener5 = this.mCustomEventListener;
            if (rCustomEventListener5 != null) {
                rCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        if (!AdPieSDK.getInstance().isInitialized()) {
            AdPieSDK.getInstance().initialize(this.mActivity.getApplicationContext(), this.mAppId, new AdPieSDK.OnInitializedListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieRewardedAd.1
                @Override // com.gomfactory.adpie.sdk.AdPieSDK.OnInitializedListener
                public void onCompleted(boolean z) {
                    AdxAdPieRewardedAd.this.requestAd();
                }
            });
        } else {
            requestAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        if (this.mRewardedVideoAd == null) {
            this.mRewardedVideoAd = new RewardedVideoAd(this.mActivity, this.mAdUnitId);
        }
        this.mRewardedVideoAd.setAdListener(new RewardedVideoAd.RewardedVideoAdListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieRewardedAd.2
            @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Failure, " + i);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoStarted() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_IMPRESSION);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdImpression();
                    AdxAdPieRewardedAd.this.mCustomEventListener.onPaidEvent(AdxAdPieRewardedAd.this.mEcpm);
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoFinished(FinishState finishState) {
                int i = AnonymousClass3.$SwitchMap$com$gomfactory$adpie$sdk$videoads$FinishState[finishState.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                        if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                            AdxAdPieRewardedAd.this.mCustomEventListener.onAdRewarded();
                        }
                    }
                } else if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                }
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdClosed();
                }
            }
        });
        this.mRewardedVideoAd.setExtraParameter("floorPrice", this.mFloorPrice);
        this.mRewardedVideoAd.load();
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.adapter.AdxAdPieRewardedAd$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$gomfactory$adpie$sdk$videoads$FinishState;

        static {
            int[] iArr = new int[FinishState.values().length];
            $SwitchMap$com$gomfactory$adpie$sdk$videoads$FinishState = iArr;
            try {
                iArr[FinishState.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$videoads$FinishState[FinishState.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$videoads$FinishState[FinishState.SKIPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$videoads$FinishState[FinishState.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd != null && rewardedVideoAd.isLoaded()) {
            this.mRewardedVideoAd.show();
        } else {
            Log.d(TAG, "Rewarded ad not ready.");
        }
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent, com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
            this.mRewardedVideoAd = null;
        }
    }

    public void setFloorPrice(String str) {
        this.mFloorPrice = str;
    }
}
