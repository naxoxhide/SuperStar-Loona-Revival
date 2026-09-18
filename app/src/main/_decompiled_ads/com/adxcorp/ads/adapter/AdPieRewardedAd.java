package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.ads.mediation.MRewardedVideoAd;
import com.adxcorp.ads.mediation.videoads.FinishState;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdPieRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "AdPieRewardedAd";
    private Activity mActivity;
    private RCustomEventListener mCustomEventListener;
    private MediationData mMediationData;
    private MRewardedVideoAd mRewardedVideoAd;

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
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        if (this.mRewardedVideoAd == null) {
            this.mRewardedVideoAd = new MRewardedVideoAd(this.mActivity, null);
        }
        this.mRewardedVideoAd.setAdListener(new MRewardedVideoAd.RewardedVideoAdListener() { // from class: com.adxcorp.ads.adapter.AdPieRewardedAd.1
            @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
            public void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings) {
            }

            @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Failure, " + i);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoStarted() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_IMPRESSION);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdImpression();
                    AdPieRewardedAd.this.mCustomEventListener.onPaidEvent(AdPieRewardedAd.this.mMediationData.getEcpm());
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
            public void onRewardedVideoFinished(FinishState finishState) {
                int i = AnonymousClass2.$SwitchMap$com$adxcorp$ads$mediation$videoads$FinishState[finishState.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                        if (AdPieRewardedAd.this.mCustomEventListener != null) {
                            AdPieRewardedAd.this.mCustomEventListener.onAdRewarded();
                        }
                    }
                } else if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                }
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdClosed();
                }
            }
        });
        this.mRewardedVideoAd.parsingBidResponse(this.mMediationData);
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.adapter.AdPieRewardedAd$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$adxcorp$ads$mediation$videoads$FinishState;

        static {
            int[] iArr = new int[FinishState.values().length];
            $SwitchMap$com$adxcorp$ads$mediation$videoads$FinishState = iArr;
            try {
                iArr[FinishState.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$mediation$videoads$FinishState[FinishState.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$mediation$videoads$FinishState[FinishState.SKIPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$mediation$videoads$FinishState[FinishState.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        MRewardedVideoAd mRewardedVideoAd = this.mRewardedVideoAd;
        if (mRewardedVideoAd != null && mRewardedVideoAd.isLoaded()) {
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
        MRewardedVideoAd mRewardedVideoAd = this.mRewardedVideoAd;
        if (mRewardedVideoAd != null) {
            mRewardedVideoAd.destroy();
            this.mRewardedVideoAd = null;
        }
    }

    public void setMediationData(MediationData mediationData) {
        this.mMediationData = mediationData;
    }
}
