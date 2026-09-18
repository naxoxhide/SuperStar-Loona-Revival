package com.adxcorp.ads.common;

import android.content.Context;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntersCustomEvent extends CustomEvent {
    private ICustomEventListener mCustomEventListener;
    private Timer mTimer;
    private String TAG = IntersCustomEvent.class.getSimpleName();
    private boolean mIsFinished = false;
    private ICustomEventListener proxyCustomEventListener = new ICustomEventListener() { // from class: com.adxcorp.ads.common.IntersCustomEvent.1
        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdLoaded() {
            if (IntersCustomEvent.this.mIsFinished) {
                return;
            }
            IntersCustomEvent.this.mIsFinished = true;
            IntersCustomEvent.this.stopTimer();
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdError() {
            if (IntersCustomEvent.this.mIsFinished) {
                return;
            }
            IntersCustomEvent.this.mIsFinished = true;
            IntersCustomEvent.this.stopTimer();
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onAdError();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdClicked() {
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onAdClicked();
            }
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
        public void onAdImpression() {
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onAdImpression();
            }
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener
        public void onAdClosed() {
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onAdClosed();
            }
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener
        public void onAdFailedToShow() {
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onAdFailedToShow();
            }
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener
        public void onPaidEvent(double d) {
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onPaidEvent(d);
            }
        }
    };

    public abstract void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener);

    public abstract void show();

    @Override // com.adxcorp.ads.common.CustomEvent
    public void internalLoadAd(Context context, MediationData mediationData, long j, CustomEventListener customEventListener) {
        this.mCustomEventListener = (ICustomEventListener) customEventListener;
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
            if (IntersCustomEvent.this.mIsFinished) {
                return;
            }
            IntersCustomEvent.this.mIsFinished = true;
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(IntersCustomEvent.this.TAG, "CustomEvent loading time is delayed.");
            }
            if (IntersCustomEvent.this.mCustomEventListener != null) {
                IntersCustomEvent.this.mCustomEventListener.onAdError();
            }
        }
    }
}
