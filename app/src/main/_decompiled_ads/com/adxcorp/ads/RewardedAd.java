package com.adxcorp.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.adxcorp.ads.common.BaseFullScreenAd;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.ads.mediation.MRewardedVideoAd;
import com.adxcorp.ads.mediation.videoads.FinishState;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RewardedAd extends BaseFullScreenAd {
    private static final String TAG = "RewardedAd";
    private MRewardedVideoAd.RewardedVideoAdListener mAdEventListener;
    private Thread mAdThread;
    private final String mAdxUnitId;
    private String mCustomData;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsCustomEventLoaded;
    private boolean mIsLoading;
    private OnPaidEventListener mOnPaidEventListener;
    private RewardedAdListener mRewardedAdListener;
    private MRewardedVideoAd mRewardedVideoAd;
    private String mUserId;

    public interface RewardedAdListener {
        void onAdClicked();

        void onAdClosed();

        void onAdError(int i);

        void onAdFailedToShow();

        void onAdImpression();

        void onAdLoaded();

        void onAdRewarded();
    }

    public RewardedAd(Activity activity, String str) {
        this.mActivity = activity;
        this.mAdxUnitId = str;
        init();
    }

    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.mRewardedAdListener = rewardedAdListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    public void setUserIdForSSV(String str) {
        this.mUserId = str;
    }

    public void setCustomDataForSSV(String str) {
        this.mCustomData = str;
    }

    private void init() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::init");
        this.mRewardedVideoAd = new MRewardedVideoAd(this.mActivity, this.mAdxUnitId);
        addEventListener();
        this.mRewardedVideoAd.setAdListener(this.mAdEventListener);
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.RewardedAd$1, reason: invalid class name */
    class AnonymousClass1 implements MRewardedVideoAd.RewardedVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
        public void onRewardedVideoLoaded() {
            if (RewardedAd.this.mIsDestroyed) {
                return;
            }
            RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdLoaded:::");
                    RewardedAd.this.mIsLoading = false;
                    if (RewardedAd.this.mRewardedAdListener != null) {
                        RewardedAd.this.mRewardedAdListener.onAdLoaded();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
        public void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings) {
            if (RewardedAd.this.mIsDestroyed) {
                return;
            }
            ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onMediationLoaded:::");
            RewardedAd.this.mMediationSettings = mediationSettings;
            RewardedAd.this.mMediationData = arrayList;
            if (RewardedAd.this.mMediationData != null) {
                RewardedAd.this.mIsCustomEventLoaded = false;
                RewardedAd.this.loadAdNetwork(new RCustomEventListener() { // from class: com.adxcorp.ads.RewardedAd.1.2
                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdLoaded() {
                        RewardedAd.this.mIsCustomEventLoaded = true;
                        if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.onRewardedVideoLoaded();
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdError() {
                        RewardedAd.this.mIsCustomEventLoaded = false;
                        if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.onRewardedVideoFailedToLoad(100);
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdClicked() {
                        if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.onRewardedVideoClicked();
                        }
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
                    public void onAdImpression() {
                        if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.onRewardedVideoStarted();
                        }
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onAdClosed() {
                        if (RewardedAd.this.mIsDestroyed) {
                            return;
                        }
                        RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdClosed:::");
                                if (RewardedAd.this.mRewardedAdListener != null) {
                                    RewardedAd.this.mRewardedAdListener.onAdClosed();
                                }
                            }
                        });
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onAdRewarded() {
                        if (RewardedAd.this.mIsDestroyed) {
                            return;
                        }
                        RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdRewarded:::");
                                if (RewardedAd.this.mRewardedAdListener != null) {
                                    RewardedAd.this.mRewardedAdListener.onAdRewarded();
                                }
                            }
                        });
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onAdFailedToShow() {
                        RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdFailedToShow:::");
                                if (RewardedAd.this.mRewardedAdListener != null) {
                                    RewardedAd.this.mRewardedAdListener.onAdFailedToShow();
                                }
                            }
                        });
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onPaidEvent(final double d) {
                        RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.2.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onPaidEvent:::" + d);
                                if (RewardedAd.this.mOnPaidEventListener != null) {
                                    RewardedAd.this.mOnPaidEventListener.onPaidEvent(d);
                                }
                            }
                        });
                    }
                });
            } else {
                ADXLogUtil.d(RewardedAd.TAG, "Mediation data is null!");
                if (RewardedAd.this.mAdEventListener != null) {
                    RewardedAd.this.mAdEventListener.onRewardedVideoFailedToLoad(111);
                }
            }
        }

        @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
        public void onRewardedVideoFailedToLoad(final int i) {
            if (RewardedAd.this.mIsDestroyed) {
                return;
            }
            RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.3
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdError:::" + i);
                    if (i != 106) {
                        RewardedAd.this.mIsLoading = false;
                    }
                    if (RewardedAd.this.mRewardedAdListener != null) {
                        RewardedAd.this.mRewardedAdListener.onAdError(i);
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
        public void onRewardedVideoClicked() {
            if (RewardedAd.this.mIsDestroyed) {
                return;
            }
            RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.4
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdClicked:::");
                    if (RewardedAd.this.mRewardedAdListener != null) {
                        RewardedAd.this.mRewardedAdListener.onAdClicked();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
        public void onRewardedVideoStarted() {
            if (RewardedAd.this.mIsDestroyed) {
                return;
            }
            RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.5
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdImpression:::");
                    if (RewardedAd.this.mRewardedAdListener != null) {
                        RewardedAd.this.mRewardedAdListener.onAdImpression();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MRewardedVideoAd.RewardedVideoAdListener
        public void onRewardedVideoFinished(final FinishState finishState) {
            if (RewardedAd.this.mIsDestroyed) {
                return;
            }
            RewardedAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.1.6
                @Override // java.lang.Runnable
                public void run() {
                    if (RewardedAd.this.mRewardedAdListener != null) {
                        if (finishState == FinishState.COMPLETED) {
                            ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdRewarded:::");
                            RewardedAd.this.mRewardedAdListener.onAdRewarded();
                        }
                        ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdClosed:::");
                        RewardedAd.this.mRewardedAdListener.onAdClosed();
                    }
                }
            });
        }
    }

    private void addEventListener() {
        this.mAdEventListener = new AnonymousClass1();
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
        this.mRewardedAdListener = null;
        this.mOnPaidEventListener = null;
    }

    public void loadAd() {
        try {
            if (this.mIsLoading) {
                ADXLogUtil.d(TAG, "AdSDK (" + this.mAdxUnitId + ") is already loading an ad. Wait for previous load to finish.");
                MRewardedVideoAd.RewardedVideoAdListener rewardedVideoAdListener = this.mAdEventListener;
                if (rewardedVideoAdListener != null) {
                    rewardedVideoAdListener.onRewardedVideoFailedToLoad(106);
                    return;
                }
                return;
            }
            this.mIsLoading = true;
            Thread thread = this.mAdThread;
            if (thread != null) {
                thread.interrupt();
                this.mAdThread = null;
            }
            Thread thread2 = new Thread(new Runnable() { // from class: com.adxcorp.ads.RewardedAd.2
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(RewardedAd.TAG, ":::loadAd:::");
                    try {
                        RewardedAd.this.mRewardedVideoAd.setSSVOption(RewardedAd.this.mUserId, RewardedAd.this.mCustomData);
                        RewardedAd.this.mRewardedVideoAd.load();
                    } catch (Exception e) {
                        ADXLogUtil.e(RewardedAd.TAG, e);
                        if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.onRewardedVideoFailedToLoad(104);
                        }
                    }
                }
            });
            this.mAdThread = thread2;
            thread2.start();
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            MRewardedVideoAd.RewardedVideoAdListener rewardedVideoAdListener2 = this.mAdEventListener;
            if (rewardedVideoAdListener2 != null) {
                rewardedVideoAdListener2.onRewardedVideoFailedToLoad(104);
            }
        }
    }

    @Override // com.adxcorp.ads.common.BaseFullScreenAd
    public boolean isLoaded() {
        if (this.mIsCustomEventLoaded) {
            return true;
        }
        MRewardedVideoAd mRewardedVideoAd = this.mRewardedVideoAd;
        return mRewardedVideoAd != null && mRewardedVideoAd.isLoaded();
    }

    @Override // com.adxcorp.ads.common.BaseFullScreenAd
    public void show() {
        ADXLogUtil.d(TAG, ":::show:::");
        if (this.mIsCustomEventLoaded) {
            if (this.mCustomEvent == null || !(this.mCustomEvent instanceof RewardedCustomEvent)) {
                return;
            }
            this.mIsCustomEventLoaded = false;
            ((RewardedCustomEvent) this.mCustomEvent).show();
            return;
        }
        MRewardedVideoAd mRewardedVideoAd = this.mRewardedVideoAd;
        if (mRewardedVideoAd == null || !mRewardedVideoAd.isLoaded()) {
            return;
        }
        this.mRewardedVideoAd.show();
    }

    @Override // com.adxcorp.ads.common.BaseFullScreenAd
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        try {
            removeEventListener();
            Thread thread = this.mAdThread;
            if (thread != null) {
                thread.interrupt();
                this.mAdThread = null;
            }
            MRewardedVideoAd mRewardedVideoAd = this.mRewardedVideoAd;
            if (mRewardedVideoAd != null) {
                mRewardedVideoAd.destroy();
                this.mRewardedVideoAd = null;
            }
            if (this.mCustomEvent != null) {
                this.mCustomEvent.destroy();
                this.mCustomEvent = null;
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }
}
