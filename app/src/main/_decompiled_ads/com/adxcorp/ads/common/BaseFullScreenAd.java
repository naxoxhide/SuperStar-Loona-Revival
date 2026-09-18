package com.adxcorp.ads.common;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.adxcorp.ads.adapter.AdPieInterstitialAd;
import com.adxcorp.ads.adapter.AdPieRewardedAd;
import com.adxcorp.ads.adapter.AdxAdPieInterstitialAd;
import com.adxcorp.ads.adapter.AdxAdPieRewardedAd;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFullScreenAd {
    protected Activity mActivity;
    protected CustomEvent mCustomEvent;
    private CustomEventListener mCustomEventListener;
    protected ArrayList<MediationData> mMediationData;
    protected MediationSettings mMediationSettings;
    private String TAG = BaseFullScreenAd.class.getSimpleName();
    private int mAdIdx = 0;
    private int mAdTotalSize = 0;
    protected boolean mIsDestroyed = false;
    private long mCustomEventTimeout = 15000;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.common.BaseFullScreenAd.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 204) {
                BaseFullScreenAd.this.failedAdNetwork();
            }
        }
    };

    protected abstract boolean isLoaded();

    protected abstract void show();

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadAdNetwork(CustomEventListener customEventListener) {
        this.mCustomEventListener = customEventListener;
        this.mAdIdx = 0;
        this.mAdTotalSize = this.mMediationData.size();
        int i = 0;
        for (int i2 = 0; i2 < this.mAdTotalSize; i2++) {
            try {
                String adNetworkName = this.mMediationData.get(i2).getAdNetworkName();
                if (!TextUtils.isEmpty(adNetworkName) && !adNetworkName.equals(ADXLogUtil.PLATFORM_ADPIE)) {
                    i++;
                }
            } catch (Exception unused) {
            }
        }
        if (i == 1) {
            this.mCustomEventTimeout = AdConstants.MEDIATION_CUSTOM_EVENT_TIMEOUT;
        } else {
            MediationSettings mediationSettings = this.mMediationSettings;
            if (mediationSettings != null && mediationSettings.getMediationRequestTimeout() >= 1000) {
                this.mCustomEventTimeout = this.mMediationSettings.getMediationRequestTimeout();
            } else {
                this.mCustomEventTimeout = 15000L;
            }
        }
        loadAdNetwork(0);
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x010a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0110  */
    /* JADX WARN: Code duplicated, block: B:69:0x0114  */
    /* JADX WARN: Code duplicated, block: B:71:0x0118  */
    /* JADX WARN: Code duplicated, block: B:77:0x014d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0153  */
    /* JADX WARN: Code duplicated, block: B:80:0x0157  */
    /* JADX WARN: Code duplicated, block: B:82:0x015b  */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    private void loadAdNetwork(int i) {
        final MediationData mediationData;
        CustomEventListener customEventListener;
        CustomEventListener customEventListener2;
        String str;
        if (this.mIsDestroyed) {
            return;
        }
        final boolean[] zArr = {false};
        String customEventName = null;
        try {
            final MediationData mediationData2 = this.mMediationData.get(i);
            try {
                if (!TextUtils.isEmpty(mediationData2.getBidResponse())) {
                    CustomEventListener customEventListener3 = this.mCustomEventListener;
                    if (customEventListener3 instanceof ICustomEventListener) {
                        customEventName = "com.adxcorp.ads.adapter.AdPieInterstitialAd";
                    } else if (customEventListener3 instanceof RCustomEventListener) {
                        customEventName = "com.adxcorp.ads.adapter.AdPieRewardedAd";
                    }
                } else {
                    customEventName = mediationData2.getCustomEventName();
                }
                try {
                    CustomEvent customEvent = (CustomEvent) instantiateClassWithEmptyConstructor(customEventName, CustomEvent.class);
                    this.mCustomEvent = customEvent;
                    if (customEvent instanceof AdPieInterstitialAd) {
                        ((AdPieInterstitialAd) customEvent).setMediationData(mediationData2);
                    } else if (customEvent instanceof AdPieRewardedAd) {
                        ((AdPieRewardedAd) customEvent).setMediationData(mediationData2);
                    } else {
                        if (customEvent instanceof AdxAdPieInterstitialAd) {
                            ((AdxAdPieInterstitialAd) customEvent).setFloorPrice(String.valueOf(mediationData2.getEcpm()));
                        } else if (customEvent instanceof AdxAdPieRewardedAd) {
                            ((AdxAdPieRewardedAd) customEvent).setFloorPrice(String.valueOf(mediationData2.getEcpm()));
                        }
                        CustomEventListener customEventListener4 = this.mCustomEventListener;
                        if (customEventListener4 instanceof ICustomEventListener) {
                            ReportUtil.sendMetric(mediationData2, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_ATTEMPT);
                        } else if (customEventListener4 instanceof RCustomEventListener) {
                            ReportUtil.sendMetric(mediationData2, "rv", ReportUtil.EVENT_TYPE_ATTEMPT);
                        }
                    }
                    CustomEventListener customEventListener5 = this.mCustomEventListener;
                    try {
                        if (customEventListener5 instanceof ICustomEventListener) {
                            str = customEventName;
                            try {
                                mediationData = mediationData2;
                                this.mCustomEvent.internalLoadAd(this.mActivity, mediationData2, this.mCustomEventTimeout, new ICustomEventListener() { // from class: com.adxcorp.ads.common.BaseFullScreenAd.2
                                    @Override // com.adxcorp.ads.common.CustomEventListener
                                    public void onAdLoaded() {
                                        BaseFullScreenAd.this.loadMaxBiddingKit(mediationData2.getEcpm(), new MaxBiddingKitListener() { // from class: com.adxcorp.ads.common.BaseFullScreenAd.2.1
                                            @Override // com.adxcorp.ads.common.MaxBiddingKitListener
                                            public void onAdLoadResult(boolean z) {
                                                ADXLogUtil.d(BaseFullScreenAd.this.TAG, "loadMaxBiddingKit:::type1:::" + mediationData2.getEcpm() + ":::" + z);
                                                if (BaseFullScreenAd.this.mIsDestroyed) {
                                                    return;
                                                }
                                                if (!z) {
                                                    ReportUtil.sendMetric(mediationData2, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_FILL);
                                                }
                                                if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                                    BaseFullScreenAd.this.mCustomEventListener.onAdLoaded();
                                                }
                                                zArr[0] = true;
                                            }
                                        });
                                    }

                                    @Override // com.adxcorp.ads.common.CustomEventListener
                                    public void onAdError() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData2, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_NO_FILL);
                                        BaseFullScreenAd.this.mHandler.sendEmptyMessage(204);
                                    }

                                    @Override // com.adxcorp.ads.common.CustomEventListener
                                    public void onAdClicked() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData2, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, "click");
                                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                            BaseFullScreenAd.this.mCustomEventListener.onAdClicked();
                                        }
                                    }

                                    @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
                                    public void onAdImpression() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData2, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, "impression");
                                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                            ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdImpression();
                                        }
                                    }

                                    @Override // com.adxcorp.ads.common.ICustomEventListener
                                    public void onAdClosed() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData2, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, "close");
                                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                            ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdClosed();
                                        }
                                    }

                                    @Override // com.adxcorp.ads.common.ICustomEventListener
                                    public void onAdFailedToShow() {
                                        if (BaseFullScreenAd.this.mIsDestroyed || BaseFullScreenAd.this.mCustomEventListener == null) {
                                            return;
                                        }
                                        ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdFailedToShow();
                                    }

                                    @Override // com.adxcorp.ads.common.ICustomEventListener
                                    public void onPaidEvent(double d) {
                                        if (BaseFullScreenAd.this.mIsDestroyed || d < 0.0d || BaseFullScreenAd.this.mCustomEventListener == null) {
                                            return;
                                        }
                                        ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onPaidEvent(d);
                                    }
                                });
                            } catch (Error e) {
                                e = e;
                                mediationData = mediationData2;
                                customEventName = str;
                                ADXLogUtil.d(this.TAG, "Error : " + customEventName + ", AD index : " + i);
                                e.printStackTrace();
                                if (zArr[0]) {
                                }
                                customEventListener2 = this.mCustomEventListener;
                                if (customEventListener2 instanceof ICustomEventListener) {
                                    ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_NO_FILL);
                                } else if (customEventListener2 instanceof RCustomEventListener) {
                                    ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_NO_FILL);
                                }
                                this.mHandler.sendEmptyMessage(204);
                            } catch (Exception e2) {
                                e = e2;
                                mediationData = mediationData2;
                                customEventName = str;
                                ADXLogUtil.d(this.TAG, "Exception : " + customEventName + ", AD index : " + i);
                                e.printStackTrace();
                                if (zArr[0]) {
                                }
                                customEventListener = this.mCustomEventListener;
                                if (customEventListener instanceof ICustomEventListener) {
                                    ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_NO_FILL);
                                } else if (customEventListener instanceof RCustomEventListener) {
                                    ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_NO_FILL);
                                }
                                this.mHandler.sendEmptyMessage(204);
                            }
                        } else {
                            str = customEventName;
                            mediationData = mediationData2;
                            if (customEventListener5 instanceof RCustomEventListener) {
                                this.mCustomEvent.internalLoadAd(this.mActivity, mediationData, this.mCustomEventTimeout, new RCustomEventListener() { // from class: com.adxcorp.ads.common.BaseFullScreenAd.3
                                    @Override // com.adxcorp.ads.common.CustomEventListener
                                    public void onAdLoaded() {
                                        BaseFullScreenAd.this.loadMaxBiddingKit(mediationData.getEcpm(), new MaxBiddingKitListener() { // from class: com.adxcorp.ads.common.BaseFullScreenAd.3.1
                                            @Override // com.adxcorp.ads.common.MaxBiddingKitListener
                                            public void onAdLoadResult(boolean z) {
                                                ADXLogUtil.d(BaseFullScreenAd.this.TAG, "loadMaxBiddingKit:::type1:::" + mediationData.getEcpm() + ":::" + z);
                                                if (BaseFullScreenAd.this.mIsDestroyed) {
                                                    return;
                                                }
                                                if (!z) {
                                                    ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_FILL);
                                                }
                                                if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                                    BaseFullScreenAd.this.mCustomEventListener.onAdLoaded();
                                                }
                                                zArr[0] = true;
                                            }
                                        });
                                    }

                                    @Override // com.adxcorp.ads.common.CustomEventListener
                                    public void onAdError() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_NO_FILL);
                                        BaseFullScreenAd.this.mHandler.sendEmptyMessage(204);
                                    }

                                    @Override // com.adxcorp.ads.common.CustomEventListener
                                    public void onAdClicked() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData, "rv", "click");
                                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                            BaseFullScreenAd.this.mCustomEventListener.onAdClicked();
                                        }
                                    }

                                    @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
                                    public void onAdImpression() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData, "rv", "impression");
                                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                            ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdImpression();
                                        }
                                    }

                                    @Override // com.adxcorp.ads.common.RCustomEventListener
                                    public void onAdClosed() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData, "rv", "close");
                                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                            ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdClosed();
                                        }
                                    }

                                    @Override // com.adxcorp.ads.common.RCustomEventListener
                                    public void onAdRewarded() {
                                        if (BaseFullScreenAd.this.mIsDestroyed) {
                                            return;
                                        }
                                        ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_REWARD);
                                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                                            ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdRewarded();
                                        }
                                    }

                                    @Override // com.adxcorp.ads.common.RCustomEventListener
                                    public void onAdFailedToShow() {
                                        if (BaseFullScreenAd.this.mIsDestroyed || BaseFullScreenAd.this.mCustomEventListener == null) {
                                            return;
                                        }
                                        ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdFailedToShow();
                                    }

                                    @Override // com.adxcorp.ads.common.RCustomEventListener
                                    public void onPaidEvent(double d) {
                                        if (BaseFullScreenAd.this.mIsDestroyed || d < 0.0d || BaseFullScreenAd.this.mCustomEventListener == null) {
                                            return;
                                        }
                                        ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onPaidEvent(d);
                                    }
                                });
                            }
                        }
                    } catch (Error e3) {
                        e = e3;
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (Error e5) {
                    e = e5;
                    mediationData = mediationData2;
                    ADXLogUtil.d(this.TAG, "Error : " + customEventName + ", AD index : " + i);
                    e.printStackTrace();
                    if (zArr[0]) {
                        customEventListener2 = this.mCustomEventListener;
                        if (customEventListener2 instanceof ICustomEventListener) {
                            ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_NO_FILL);
                        } else if (customEventListener2 instanceof RCustomEventListener) {
                            ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_NO_FILL);
                        }
                        this.mHandler.sendEmptyMessage(204);
                    }
                } catch (Exception e6) {
                    e = e6;
                    mediationData = mediationData2;
                    ADXLogUtil.d(this.TAG, "Exception : " + customEventName + ", AD index : " + i);
                    e.printStackTrace();
                    if (zArr[0]) {
                        customEventListener = this.mCustomEventListener;
                        if (customEventListener instanceof ICustomEventListener) {
                            ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_NO_FILL);
                        } else if (customEventListener instanceof RCustomEventListener) {
                            ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_NO_FILL);
                        }
                        this.mHandler.sendEmptyMessage(204);
                    }
                }
            } catch (Error e7) {
                e = e7;
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Exception e9) {
            ADXLogUtil.d(this.TAG, "Exception - AD index : " + i + ", message : " + e9.getMessage());
            this.mHandler.sendEmptyMessage(204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failedAdNetwork() {
        if (this.mIsDestroyed) {
            return;
        }
        int i = this.mAdIdx;
        if (i + 1 < this.mAdTotalSize) {
            int i2 = i + 1;
            this.mAdIdx = i2;
            loadAdNetwork(i2);
        } else {
            final double biddingKitEcpm = 0.05d;
            try {
                biddingKitEcpm = this.mMediationSettings.getBiddingKitEcpm();
            } catch (Exception unused) {
            }
            loadMaxBiddingKit(biddingKitEcpm, new MaxBiddingKitListener() { // from class: com.adxcorp.ads.common.BaseFullScreenAd.4
                @Override // com.adxcorp.ads.common.MaxBiddingKitListener
                public void onAdLoadResult(boolean z) {
                    ADXLogUtil.d(BaseFullScreenAd.this.TAG, "loadMaxBiddingKit:::type2:::" + biddingKitEcpm + ":::" + z);
                    if (!z) {
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            BaseFullScreenAd.this.mCustomEventListener.onAdError();
                        }
                    } else if (BaseFullScreenAd.this.mCustomEventListener != null) {
                        BaseFullScreenAd.this.mCustomEventListener.onAdLoaded();
                    }
                }
            });
        }
    }

    private <T> T instantiateClassWithEmptyConstructor(String str, Class<? extends T> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, NullPointerException, InvocationTargetException {
        Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor((Class[]) null);
        declaredConstructor.setAccessible(true);
        return (T) declaredConstructor.newInstance(new Object[0]);
    }

    protected void destroy() {
        this.mIsDestroyed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMaxBiddingKit(double d, final MaxBiddingKitListener maxBiddingKitListener) {
        if (this.mIsDestroyed) {
            return;
        }
        MediationSettings mediationSettings = this.mMediationSettings;
        if (mediationSettings != null && !mediationSettings.isEnableBiddingKit()) {
            ADXLogUtil.d(this.TAG, "MAX bidding kit not enabled on dashboard.");
            if (maxBiddingKitListener != null) {
                maxBiddingKitListener.onAdLoadResult(false);
                return;
            }
            return;
        }
        final MediationData mediationData = new MediationData();
        String str = "";
        try {
            CustomEventListener customEventListener = this.mCustomEventListener;
            if (customEventListener instanceof ICustomEventListener) {
                str = "com.adxcorp.ads.adapter.AppLovinInterstitialAd";
            } else if (customEventListener instanceof RCustomEventListener) {
                str = "com.adxcorp.ads.adapter.AppLovinRewardedAd";
            }
            mediationData.setMediationId(this.mMediationSettings.getBiddingKitMediationId());
            mediationData.setEcpm(d);
            mediationData.setRequestId(this.mMediationSettings.getBiddingKitRequestId());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY, this.mMediationSettings.getBiddingKitAdUnitId());
            jSONObject.put("enableBiddingKit", this.mMediationSettings.isEnableBiddingKit());
            jSONObject.put("ecpm", d);
            mediationData.setCustomEventParams(jSONObject.toString());
            mediationData.setMetricEndpointFormat(this.mMediationSettings.getBiddingKitMetricEndpointFormat());
            mediationData.setAdNetworkName("applovin");
            mediationData.setCustomEventName(str);
            ADXLogUtil.d(this.TAG, "[loadMaxBiddingKit] mediationData : " + mediationData);
            final CustomEvent customEvent = (CustomEvent) instantiateClassWithEmptyConstructor(str, CustomEvent.class);
            CustomEventListener customEventListener2 = this.mCustomEventListener;
            if (customEventListener2 instanceof ICustomEventListener) {
                ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_ATTEMPT);
                customEvent.internalLoadAd(this.mActivity, mediationData, 5000L, new ICustomEventListener() { // from class: com.adxcorp.ads.common.BaseFullScreenAd.5
                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdLoaded() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        try {
                            if (BaseFullScreenAd.this.mCustomEvent != null) {
                                BaseFullScreenAd.this.mCustomEvent.destroy();
                            }
                        } catch (Exception e) {
                            ADXLogUtil.e(BaseFullScreenAd.this.TAG, e);
                        }
                        BaseFullScreenAd.this.mCustomEvent = customEvent;
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_FILL);
                        MaxBiddingKitListener maxBiddingKitListener2 = maxBiddingKitListener;
                        if (maxBiddingKitListener2 != null) {
                            maxBiddingKitListener2.onAdLoadResult(true);
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdError() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, ReportUtil.EVENT_TYPE_NO_FILL);
                        try {
                            CustomEvent customEvent2 = customEvent;
                            if (customEvent2 != null) {
                                customEvent2.destroy();
                            }
                        } catch (Exception e) {
                            ADXLogUtil.e(BaseFullScreenAd.this.TAG, e);
                        }
                        MaxBiddingKitListener maxBiddingKitListener2 = maxBiddingKitListener;
                        if (maxBiddingKitListener2 != null) {
                            maxBiddingKitListener2.onAdLoadResult(false);
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdClicked() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, "click");
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            BaseFullScreenAd.this.mCustomEventListener.onAdClicked();
                        }
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
                    public void onAdImpression() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, "impression");
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdImpression();
                        }
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener
                    public void onAdClosed() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, ReportUtil.INVENTORY_TYPE_INTERSTITIAL, "close");
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdClosed();
                        }
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener
                    public void onAdFailedToShow() {
                        if (BaseFullScreenAd.this.mIsDestroyed || BaseFullScreenAd.this.mCustomEventListener == null) {
                            return;
                        }
                        ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdFailedToShow();
                    }

                    @Override // com.adxcorp.ads.common.ICustomEventListener
                    public void onPaidEvent(double d2) {
                        if (BaseFullScreenAd.this.mIsDestroyed || d2 < 0.0d || BaseFullScreenAd.this.mCustomEventListener == null) {
                            return;
                        }
                        ((ICustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onPaidEvent(d2);
                    }
                });
            } else if (customEventListener2 instanceof RCustomEventListener) {
                ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_ATTEMPT);
                customEvent.internalLoadAd(this.mActivity, mediationData, 5000L, new RCustomEventListener() { // from class: com.adxcorp.ads.common.BaseFullScreenAd.6
                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdLoaded() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        try {
                            if (BaseFullScreenAd.this.mCustomEvent != null) {
                                BaseFullScreenAd.this.mCustomEvent.destroy();
                            }
                        } catch (Exception e) {
                            ADXLogUtil.e(BaseFullScreenAd.this.TAG, e);
                        }
                        BaseFullScreenAd.this.mCustomEvent = customEvent;
                        ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_FILL);
                        MaxBiddingKitListener maxBiddingKitListener2 = maxBiddingKitListener;
                        if (maxBiddingKitListener2 != null) {
                            maxBiddingKitListener2.onAdLoadResult(true);
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdError() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_NO_FILL);
                        try {
                            CustomEvent customEvent2 = customEvent;
                            if (customEvent2 != null) {
                                customEvent2.destroy();
                            }
                            MaxBiddingKitListener maxBiddingKitListener2 = maxBiddingKitListener;
                            if (maxBiddingKitListener2 != null) {
                                maxBiddingKitListener2.onAdLoadResult(false);
                            }
                        } catch (Exception e) {
                            ADXLogUtil.e(BaseFullScreenAd.this.TAG, e);
                        }
                    }

                    @Override // com.adxcorp.ads.common.CustomEventListener
                    public void onAdClicked() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, "rv", "click");
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            BaseFullScreenAd.this.mCustomEventListener.onAdClicked();
                        }
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
                    public void onAdImpression() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, "rv", "impression");
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdImpression();
                        }
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onAdClosed() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, "rv", "close");
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdClosed();
                        }
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onAdRewarded() {
                        if (BaseFullScreenAd.this.mIsDestroyed) {
                            return;
                        }
                        ReportUtil.sendMetric(mediationData, "rv", ReportUtil.EVENT_TYPE_REWARD);
                        if (BaseFullScreenAd.this.mCustomEventListener != null) {
                            ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdRewarded();
                        }
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onAdFailedToShow() {
                        if (BaseFullScreenAd.this.mIsDestroyed || BaseFullScreenAd.this.mCustomEventListener == null) {
                            return;
                        }
                        ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onAdFailedToShow();
                    }

                    @Override // com.adxcorp.ads.common.RCustomEventListener
                    public void onPaidEvent(double d2) {
                        if (BaseFullScreenAd.this.mIsDestroyed || d2 < 0.0d || BaseFullScreenAd.this.mCustomEventListener == null) {
                            return;
                        }
                        ((RCustomEventListener) BaseFullScreenAd.this.mCustomEventListener).onPaidEvent(d2);
                    }
                });
            }
        } catch (Error e) {
            ADXLogUtil.d(this.TAG, " - Error : " + e.getMessage());
            e.printStackTrace();
            if (maxBiddingKitListener != null) {
                maxBiddingKitListener.onAdLoadResult(false);
            }
        } catch (Exception e2) {
            ADXLogUtil.d(this.TAG, " - Exception : " + e2.getMessage());
            e2.printStackTrace();
            if (maxBiddingKitListener != null) {
                maxBiddingKitListener.onAdLoadResult(false);
            }
        }
    }
}
