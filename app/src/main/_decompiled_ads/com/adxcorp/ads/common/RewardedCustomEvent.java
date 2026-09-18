package com.adxcorp.ads.common;

import android.content.Context;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class RewardedCustomEvent extends CustomEvent {
    private RCustomEventListener mCustomEventListener;
    private Timer mTimer;
    private String TAG = RewardedCustomEvent.class.getSimpleName();
    private boolean mIsFinished = false;
    private RCustomEventListener proxyCustomEventListener = new RCustomEventListener() { // from class: com.adxcorp.ads.common.RewardedCustomEvent.1
        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdLoaded() {
            if (RewardedCustomEvent.this.mIsFinished) {
                return;
            }
            RewardedCustomEvent.this.mIsFinished = true;
            RewardedCustomEvent.this.stopTimer();
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdError() {
            if (RewardedCustomEvent.this.mIsFinished) {
                return;
            }
            RewardedCustomEvent.this.mIsFinished = true;
            RewardedCustomEvent.this.stopTimer();
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdError();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdClicked() {
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdClicked();
            }
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
        public void onAdImpression() {
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdImpression();
            }
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener
        public void onAdClosed() {
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdClosed();
            }
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener
        public void onAdRewarded() {
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdRewarded();
            }
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener
        public void onAdFailedToShow() {
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdFailedToShow();
            }
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener
        public void onPaidEvent(double d) {
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onPaidEvent(d);
            }
        }
    };

    public abstract void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener);

    public abstract void show();

    @Override // com.adxcorp.ads.common.CustomEvent
    public void internalLoadAd(Context context, MediationData mediationData, long j, CustomEventListener customEventListener) {
        this.mCustomEventListener = (RCustomEventListener) customEventListener;
        this.mIsFinished = false;
        stopTimer();
        startTimer(j);
        loadAd(context, (Map<String, String>) convertJsonToMap(mediationData), this.proxyCustomEventListener);
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        stopTimer();
    }

    private void startTimer(long j) {
        this.mTimer = new Timer();
        this.mTimer.schedule(new AdCheckTimerTask(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    class AdCheckTimerTask extends TimerTask {
        AdCheckTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (RewardedCustomEvent.this.mIsFinished) {
                return;
            }
            RewardedCustomEvent.this.mIsFinished = true;
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(RewardedCustomEvent.this.TAG, "CustomEvent loading time is delayed.");
            }
            if (RewardedCustomEvent.this.mCustomEventListener != null) {
                RewardedCustomEvent.this.mCustomEventListener.onAdError();
            }
        }
    }
}
