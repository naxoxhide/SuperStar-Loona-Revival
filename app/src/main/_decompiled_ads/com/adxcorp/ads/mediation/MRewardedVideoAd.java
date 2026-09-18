package com.adxcorp.ads.mediation;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.common.AdData;
import com.adxcorp.ads.mediation.common.AdResponse;
import com.adxcorp.ads.mediation.controller.AdController;
import com.adxcorp.ads.mediation.event.AdEventListener;
import com.adxcorp.ads.mediation.videoads.FinishState;
import com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MRewardedVideoAd {
    public static final String TAG = "MRewardedVideoAd";
    private AdData adData;
    private boolean initialized;
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private Context mContext;
    private FinishState mFinishState;
    private RewardedVideoAdListener mRewardedVideoAdListener = null;
    private RewardedVideoState mRewardedVideoState = RewardedVideoState.NOT_READY;
    private HashMap<String, String> mSSVOptions;
    private String mSlotId;

    public interface RewardedVideoAdListener {
        void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings);

        void onRewardedVideoClicked();

        void onRewardedVideoFailedToLoad(int i);

        void onRewardedVideoFinished(FinishState finishState);

        void onRewardedVideoLoaded();

        void onRewardedVideoStarted();
    }

    public MRewardedVideoAd(Context context, String str) {
        this.mContext = context;
        this.mSlotId = str;
        init();
    }

    public RewardedVideoAdListener getAdListener() {
        return this.mRewardedVideoAdListener;
    }

    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.mRewardedVideoAdListener = rewardedVideoAdListener;
    }

    public void setSSVOption(String str, String str2) {
        HashMap<String, String> map = this.mSSVOptions;
        if (map == null) {
            this.mSSVOptions = new HashMap<>();
        } else {
            map.clear();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mSSVOptions.put("userId", str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mSSVOptions.put("customData", str2);
    }

    private void init() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::init");
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            addEventListener();
            this.mAdController = new AdController(this.mContext, this.mAdEventListener);
            this.initialized = true;
        } catch (ClassNotFoundException e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void addEventListener() {
        this.mAdEventListener = new AdEventListener() { // from class: com.adxcorp.ads.mediation.MRewardedVideoAd.1
            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void receivedResponse(AdResponse adResponse) {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (MRewardedVideoAd.this.mAdEventListener != null) {
                                    MRewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                MRewardedVideoAd.this.adData = adResponse.getAdData();
                                if (MRewardedVideoAd.this.adData != null) {
                                    if (MRewardedVideoAd.this.adData.getIcType() == 52) {
                                        MRewardedVideoAd.this.preloadResource();
                                    } else {
                                        ADXLogUtil.i(MRewardedVideoAd.TAG, "'" + MRewardedVideoAd.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (MRewardedVideoAd.this.mAdEventListener != null) {
                                            MRewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (MRewardedVideoAd.this.mAdEventListener != null) {
                                    MRewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (MRewardedVideoAd.this.mAdEventListener != null) {
                                MRewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (MRewardedVideoAd.this.mAdEventListener != null) {
                            MRewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.e(MRewardedVideoAd.TAG, e);
                        }
                        notifyAdFailedToLoad(104);
                    }
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed) {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyMediationLoaded");
                if (MRewardedVideoAd.this.mRewardedVideoAdListener != null) {
                    MRewardedVideoAd.this.mRewardedVideoAdListener.onMediationLoaded(arrayList, mediationSettings);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyAdLoaded(Object... objArr) {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyAdLoaded");
                if (MRewardedVideoAd.this.mRewardedVideoAdListener != null) {
                    MRewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyAdFailedToLoad(int i) {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                MRewardedVideoAd.this.mRewardedVideoState = RewardedVideoState.NOT_READY;
                MRewardedVideoAd.this.adData = null;
                if (MRewardedVideoAd.this.mRewardedVideoAdListener != null) {
                    MRewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoFailedToLoad(i);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyAdShown() {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyAdShown");
                MRewardedVideoAd.this.mRewardedVideoState = RewardedVideoState.SHOW;
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyAdDismissed() {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyAdDismissed - " + MRewardedVideoAd.this.mFinishState);
                MRewardedVideoAd.this.mRewardedVideoState = RewardedVideoState.NOT_READY;
                if (MRewardedVideoAd.this.mRewardedVideoAdListener != null) {
                    MRewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoFinished(MRewardedVideoAd.this.mFinishState);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyAdClicked() {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyAdClicked");
                if (MRewardedVideoAd.this.mRewardedVideoAdListener != null) {
                    MRewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoClicked();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyVideoAdStarted() {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyVideoAdStarted");
                if (MRewardedVideoAd.this.mRewardedVideoAdListener != null) {
                    MRewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoStarted();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyVideoAdSkipped() {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyVideoAdSkipped");
                MRewardedVideoAd.this.mFinishState = FinishState.SKIPPED;
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyVideoAdError() {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyVideoAdError");
                MRewardedVideoAd.this.mFinishState = FinishState.ERROR;
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void notifyVideoAdCompleted() {
                ADXLogUtil.d(MRewardedVideoAd.TAG, MRewardedVideoAd.this.mSlotId + ":::notifyVideoAdCompleted");
                MRewardedVideoAd.this.mFinishState = FinishState.COMPLETED;
            }
        };
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
    }

    public void load() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::load");
        this.mRewardedVideoState = RewardedVideoState.NOT_READY;
        this.mFinishState = FinishState.UNKNOWN;
        this.adData = null;
        if (!this.initialized) {
            init();
        }
        try {
            this.mAdController.setSlotID(this.mSlotId);
            this.mAdController.loadAd(this.mSSVOptions);
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdFailedToLoad(104);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadResource() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.mRewardedVideoState = RewardedVideoState.READY;
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdLoaded(new Object[0]);
                return;
            }
            return;
        }
        this.mRewardedVideoState = RewardedVideoState.NOT_READY;
        AdEventListener adEventListener2 = this.mAdEventListener;
        if (adEventListener2 != null) {
            adEventListener2.notifyAdFailedToLoad(100);
        }
    }

    public boolean show() {
        AdData adData;
        String str = TAG;
        ADXLogUtil.d(str, this.mSlotId + ":::show:::" + MediationSDK.getInstance().getNetworkConnectionType() + "," + Build.VERSION.SDK_INT);
        try {
            if (MediationSDK.getInstance().getNetworkConnectionType() != 0) {
                if (this.mRewardedVideoState.isReady() && (adData = this.adData) != null) {
                    if (adData.getIcType() == 52) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            VideoFullScreenActivity.start(this.mContext, VideoFullScreenActivity.class, this.mSlotId, this.adData, this.mAdEventListener);
                            return true;
                        }
                        ADXLogUtil.i(str, this.mSlotId + ":::show:::Check your android os version.");
                        return false;
                    }
                    ADXLogUtil.i(str, ":::show:::'" + this.adData.getIcType() + "' inventory and contentType are not matched.");
                    return false;
                }
                if (this.adData == null) {
                    ADXLogUtil.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                    return false;
                }
                ADXLogUtil.i(str, this.mSlotId + ":::show:::RewardedVideoState is not ready.");
                return false;
            }
            ADXLogUtil.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            return false;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return false;
        }
    }

    public boolean isLoaded() {
        return this.mRewardedVideoState.isReady();
    }

    public void destroy() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::destroy");
        HashMap<String, String> map = this.mSSVOptions;
        if (map != null) {
            map.clear();
            this.mSSVOptions = null;
        }
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
    }

    public void parsingBidResponse(MediationData mediationData) {
        AdController adController = this.mAdController;
        if (adController == null) {
            ADXLogUtil.d(TAG, "AdController cannot be null.");
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdFailedToLoad(104);
                return;
            }
            return;
        }
        if (mediationData == null) {
            ADXLogUtil.d(TAG, "Mediation data cannot be null.");
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.notifyAdFailedToLoad(108);
                return;
            }
            return;
        }
        adController.parsingBidResponse(mediationData);
    }

    private enum RewardedVideoState {
        NOT_READY,
        READY,
        SHOW;

        boolean isReady() {
            return this == READY;
        }
    }
}
