package com.adxcorp.ads.common;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class BannerCustomEvent extends CustomEvent {
    private BCustomEventListener mCustomEventListener;
    private Timer mTimer;
    private String TAG = BannerCustomEvent.class.getSimpleName();
    private boolean mIsFinished = false;
    private BCustomEventListener proxyCustomEventListener = new BCustomEventListener() { // from class: com.adxcorp.ads.common.BannerCustomEvent.1
        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdLoaded() {
            if (BannerCustomEvent.this.mIsFinished) {
                return;
            }
            BannerCustomEvent.this.mIsFinished = true;
            BannerCustomEvent.this.stopTimer();
            if (BannerCustomEvent.this.mCustomEventListener != null) {
                BannerCustomEvent.this.mCustomEventListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdError() {
            if (BannerCustomEvent.this.mIsFinished) {
                return;
            }
            BannerCustomEvent.this.mIsFinished = true;
            BannerCustomEvent.this.stopTimer();
            if (BannerCustomEvent.this.mCustomEventListener != null) {
                BannerCustomEvent.this.mCustomEventListener.onAdError();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdClicked() {
            if (BannerCustomEvent.this.mCustomEventListener != null) {
                BannerCustomEvent.this.mCustomEventListener.onAdClicked();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdImpression() {
            if (BannerCustomEvent.this.mCustomEventListener != null) {
                BannerCustomEvent.this.mCustomEventListener.onAdImpression();
            }
        }
    };

    public abstract View getAdView();

    public abstract void impression();

    public abstract void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener);

    public abstract void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size);

    @Override // com.adxcorp.ads.common.CustomEvent
    public void internalLoadAd(Context context, MediationData mediationData, long j, CustomEventListener customEventListener) {
        this.mCustomEventListener = (BCustomEventListener) customEventListener;
        this.mIsFinished = false;
        stopTimer();
        startTimer(j);
        loadAd(context, (Map<String, String>) convertJsonToMap(mediationData), this.proxyCustomEventListener);
    }

    public void clearAnimation() {
        View adView = getAdView();
        if (adView != null) {
            adView.clearAnimation();
        }
    }

    public void startAnimation(Animation animation) {
        View adView = getAdView();
        if (adView != null) {
            adView.startAnimation(animation);
        }
    }

    public void setVisibility(int i) {
        View adView = getAdView();
        if (adView != null) {
            adView.setVisibility(i);
        }
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
            if (BannerCustomEvent.this.mIsFinished) {
                return;
            }
            BannerCustomEvent.this.mIsFinished = true;
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(BannerCustomEvent.this.TAG, "CustomEvent loading time is delayed.");
            }
            if (BannerCustomEvent.this.mCustomEventListener != null) {
                BannerCustomEvent.this.mCustomEventListener.onAdError();
            }
        }
    }
}
