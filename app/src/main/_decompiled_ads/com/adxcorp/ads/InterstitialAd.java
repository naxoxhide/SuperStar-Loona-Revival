package com.adxcorp.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.adxcorp.ads.common.BaseFullScreenAd;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.adxcorp.ads.mediation.MInterstitialAd;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class InterstitialAd extends BaseFullScreenAd {
    private static final String TAG = "InterstitialAd";
    private MInterstitialAd.InterstitialAdListener mAdEventListener;
    private Thread mAdThread;
    private final String mAdxUnitId;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private MInterstitialAd mInterstitialAd;
    private InterstitialListener mInterstitialListener;
    private boolean mIsCustomEventLoaded;
    private boolean mIsLoading;
    private OnPaidEventListener mOnPaidEventListener;

    public interface InterstitialListener {
        void onAdClicked();

        void onAdClosed();

        void onAdError(int i);

        void onAdFailedToShow();

        void onAdImpression();

        void onAdLoaded();
    }

    public InterstitialAd(Activity activity, String str) {
        this.mActivity = activity;
        this.mAdxUnitId = str;
        init();
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        this.mInterstitialListener = interstitialListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    private void init() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::init");
        this.mInterstitialAd = new MInterstitialAd(this.mActivity, this.mAdxUnitId);
        addEventListener();
        this.mInterstitialAd.setAdListener(this.mAdEventListener);
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.InterstitialAd$1, reason: invalid class name */
    class AnonymousClass1 implements MInterstitialAd.InterstitialAdListener {
        AnonymousClass1() {
        }

        @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
        public void onAdLoaded() {
            InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdLoaded:::");
                    InterstitialAd.this.mIsLoading = false;
                    if (InterstitialAd.this.mInterstitialListener != null) {
                        InterstitialAd.this.mInterstitialListener.onAdLoaded();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
        public void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings) {
            if (InterstitialAd.this.mIsDestroyed) {
                return;
            }
            ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onMediationLoaded:::");
            InterstitialAd.this.mMediationSettings = mediationSettings;
            InterstitialAd.this.mMediationData = arrayList;
            if (InterstitialAd.this.mMediationData != null) {
                InterstitialAd.this.mIsCustomEventLoaded = false;
                InterstitialAd.this.loadAdNetwork(new ICustomEventListener() { // from class: com.adxcorp.ads.InterstitialAd.1.2
                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdLoaded() {
                        InterstitialAd.this.mIsCustomEventLoaded = true;
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.onAdLoaded();
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdError() {
                        InterstitialAd.this.mIsCustomEventLoaded = false;
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.onAdFailedToLoad(100);
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdClicked() {
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.onAdClicked();
                        }
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
                    public void onAdImpression() {
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.onAdShown();
                        }
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener
                    public void onAdClosed() {
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.onAdDismissed();
                        }
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener
                    public void onAdFailedToShow() {
                        InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdFailedToShow:::");
                                if (InterstitialAd.this.mInterstitialListener != null) {
                                    InterstitialAd.this.mInterstitialListener.onAdFailedToShow();
                                }
                            }
                        });
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener
                    public void onPaidEvent(final double d) {
                        InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.1.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onPaidEvent:::" + d);
                                if (InterstitialAd.this.mOnPaidEventListener != null) {
                                    InterstitialAd.this.mOnPaidEventListener.onPaidEvent(d);
                                }
                            }
                        });
                    }
                });
            } else {
                ADXLogUtil.d(InterstitialAd.TAG, "Mediation data is null!");
                if (InterstitialAd.this.mAdEventListener != null) {
                    InterstitialAd.this.mAdEventListener.onAdFailedToLoad(111);
                }
            }
        }

        @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
        public void onAdFailedToLoad(final int i) {
            InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.1.3
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdError:::" + i);
                    if (i != 106) {
                        InterstitialAd.this.mIsLoading = false;
                    }
                    if (InterstitialAd.this.mInterstitialListener != null) {
                        InterstitialAd.this.mInterstitialListener.onAdError(i);
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
        public void onAdShown() {
            InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.1.4
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdImpression:::");
                    if (InterstitialAd.this.mInterstitialListener != null) {
                        InterstitialAd.this.mInterstitialListener.onAdImpression();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
        public void onAdClicked() {
            InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.1.5
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdClicked:::");
                    if (InterstitialAd.this.mInterstitialListener != null) {
                        InterstitialAd.this.mInterstitialListener.onAdClicked();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
        public void onAdDismissed() {
            InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.1.6
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdClosed:::");
                    if (InterstitialAd.this.mInterstitialListener != null) {
                        InterstitialAd.this.mInterstitialListener.onAdClosed();
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
        this.mInterstitialListener = null;
        this.mOnPaidEventListener = null;
    }

    public void loadAd() {
        try {
            if (this.mIsLoading) {
                ADXLogUtil.d(TAG, "AdSDK (" + this.mAdxUnitId + ") is already loading an ad. Wait for previous load to finish.");
                MInterstitialAd.InterstitialAdListener interstitialAdListener = this.mAdEventListener;
                if (interstitialAdListener != null) {
                    interstitialAdListener.onAdFailedToLoad(106);
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
            Thread thread2 = new Thread(new Runnable() { // from class: com.adxcorp.ads.InterstitialAd.2
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(InterstitialAd.TAG, ":::loadAd:::");
                    try {
                        InterstitialAd.this.mInterstitialAd.load();
                    } catch (Exception e) {
                        ADXLogUtil.e(InterstitialAd.TAG, e);
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.onAdFailedToLoad(104);
                        }
                    }
                }
            });
            this.mAdThread = thread2;
            thread2.start();
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            MInterstitialAd.InterstitialAdListener interstitialAdListener2 = this.mAdEventListener;
            if (interstitialAdListener2 != null) {
                interstitialAdListener2.onAdFailedToLoad(104);
            }
        }
    }

    @Override // com.adxcorp.ads.common.BaseFullScreenAd
    public boolean isLoaded() {
        if (this.mIsCustomEventLoaded) {
            return true;
        }
        MInterstitialAd mInterstitialAd = this.mInterstitialAd;
        return mInterstitialAd != null && mInterstitialAd.isLoaded();
    }

    @Override // com.adxcorp.ads.common.BaseFullScreenAd
    public void show() {
        ADXLogUtil.d(TAG, ":::show:::");
        if (this.mIsCustomEventLoaded) {
            if (this.mCustomEvent == null || !(this.mCustomEvent instanceof IntersCustomEvent)) {
                return;
            }
            this.mIsCustomEventLoaded = false;
            ((IntersCustomEvent) this.mCustomEvent).show();
            return;
        }
        MInterstitialAd mInterstitialAd = this.mInterstitialAd;
        if (mInterstitialAd == null || !mInterstitialAd.isLoaded()) {
            return;
        }
        this.mInterstitialAd.show();
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
            MInterstitialAd mInterstitialAd = this.mInterstitialAd;
            if (mInterstitialAd != null) {
                mInterstitialAd.destroy();
                this.mInterstitialAd = null;
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
