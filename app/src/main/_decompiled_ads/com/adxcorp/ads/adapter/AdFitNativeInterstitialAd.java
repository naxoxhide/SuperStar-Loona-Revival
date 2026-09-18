package com.adxcorp.ads.adapter;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.kakao.adfit.ads.na.AdFitAdInfoIconPosition;
import com.kakao.adfit.ads.na.AdFitMediaView;
import com.kakao.adfit.ads.na.AdFitNativeAdBinder;
import com.kakao.adfit.ads.na.AdFitNativeAdLayout;
import com.kakao.adfit.ads.na.AdFitNativeAdLoader;
import com.kakao.adfit.ads.na.AdFitNativeAdRequest;
import com.kakao.adfit.ads.na.AdFitNativeAdView;
import com.kakao.adfit.ads.na.AdFitVideoAutoPlayPolicy;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdFitNativeInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "AdFitNativeInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private ICustomEventListener mCustomEventListener;
    private AdFitInterstitialDialog mDialog;
    private double mEcpm;
    private boolean testMode;

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = iCustomEventListener;
        if (Build.VERSION.SDK_INT < 21) {
            ICustomEventListener iCustomEventListener2 = this.mCustomEventListener;
            if (iCustomEventListener2 != null) {
                iCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (context == null) {
            Log.d(str, "Context cannot be null.");
            ICustomEventListener iCustomEventListener3 = this.mCustomEventListener;
            if (iCustomEventListener3 != null) {
                iCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            Log.d(str, "An Activity Context is required.");
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        this.mActivity = (Activity) context;
        this.mAdUnitId = map.get("app_code");
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.testMode = false;
        if (map.containsKey("test_mode")) {
            this.testMode = Boolean.parseBoolean(map.get("test_mode"));
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            ICustomEventListener iCustomEventListener5 = this.mCustomEventListener;
            if (iCustomEventListener5 != null) {
                iCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        AdFitNativeAdLoader.create(this.mActivity, this.mAdUnitId).loadAd(new AdFitNativeAdRequest.Builder().setAdInfoIconPosition(AdFitAdInfoIconPosition.RIGHT_TOP).setVideoAutoPlayPolicy(AdFitVideoAutoPlayPolicy.NONE).setTestModeEnabled(this.testMode).build(), new AdFitNativeAdLoader.AdLoadListener() { // from class: com.adxcorp.ads.adapter.AdFitNativeInterstitialAd.1
            @Override // com.kakao.adfit.ads.na.AdFitNativeAdLoader.AdLoadListener
            public void onAdLoaded(AdFitNativeAdBinder adFitNativeAdBinder) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                AdFitNativeInterstitialAd adFitNativeInterstitialAd = AdFitNativeInterstitialAd.this;
                AdFitNativeInterstitialAd adFitNativeInterstitialAd2 = AdFitNativeInterstitialAd.this;
                adFitNativeInterstitialAd.mDialog = adFitNativeInterstitialAd2.new AdFitInterstitialDialog(adFitNativeInterstitialAd2.mActivity, adFitNativeAdBinder);
                if (AdFitNativeInterstitialAd.this.mCustomEventListener != null) {
                    AdFitNativeInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.kakao.adfit.ads.na.AdFitNativeAdLoader.AdLoadListener
            public void onAdLoadError(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, "Failure, " + i);
                if (AdFitNativeInterstitialAd.this.mCustomEventListener != null) {
                    AdFitNativeInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }
        });
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        ADXLogUtil.d(TAG, ":::show:::");
        try {
            this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.adxcorp.ads.adapter.AdFitNativeInterstitialAd.2
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_IMPRESSION);
                    if (AdFitNativeInterstitialAd.this.mCustomEventListener != null) {
                        AdFitNativeInterstitialAd.this.mCustomEventListener.onAdImpression();
                        AdFitNativeInterstitialAd.this.mCustomEventListener.onPaidEvent(AdFitNativeInterstitialAd.this.mEcpm);
                    }
                }
            });
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.adxcorp.ads.adapter.AdFitNativeInterstitialAd.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                    if (AdFitNativeInterstitialAd.this.mCustomEventListener != null) {
                        AdFitNativeInterstitialAd.this.mCustomEventListener.onAdClosed();
                    }
                }
            });
            this.mDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
            ICustomEventListener iCustomEventListener = this.mCustomEventListener;
            if (iCustomEventListener != null) {
                iCustomEventListener.onAdFailedToShow();
            }
        }
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent, com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
    }

    private class AdFitInterstitialDialog extends Dialog {
        private AdFitNativeAdBinder adFitNativeAdBinder;

        public AdFitInterstitialDialog(Context context, AdFitNativeAdBinder adFitNativeAdBinder) {
            super(context, R.style.Theme.Translucent.NoTitleBar);
            this.adFitNativeAdBinder = adFitNativeAdBinder;
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(com.adxcorp.library.standard.R.layout.adfit_native_interstitial_view);
            AdFitNativeAdView adFitNativeAdView = new AdFitNativeAdView(AdFitNativeInterstitialAd.this.mActivity);
            TextView textView = (TextView) findViewById(com.adxcorp.library.standard.R.id.ad_headline);
            ImageView imageView = (ImageView) findViewById(com.adxcorp.library.standard.R.id.ad_icon);
            Button button = (Button) findViewById(com.adxcorp.library.standard.R.id.ad_cta);
            FrameLayout frameLayout = (FrameLayout) findViewById(com.adxcorp.library.standard.R.id.ad_media);
            AdFitMediaView adFitMediaView = new AdFitMediaView(AdFitNativeInterstitialAd.this.mActivity);
            frameLayout.removeAllViews();
            frameLayout.addView(adFitMediaView);
            this.adFitNativeAdBinder.bind(new AdFitNativeAdLayout.Builder(adFitNativeAdView).setTitleView(textView).setMediaView(adFitMediaView).setProfileIconView(imageView).setCallToActionButton(button).build());
            FrameLayout frameLayout2 = (FrameLayout) findViewById(com.adxcorp.library.standard.R.id.ad_native_root);
            adFitNativeAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            FrameLayout frameLayout3 = (FrameLayout) findViewById(com.adxcorp.library.standard.R.id.ad_native_container);
            frameLayout2.removeView(frameLayout3);
            adFitNativeAdView.addView(frameLayout3);
            frameLayout2.addView(adFitNativeAdView);
            this.adFitNativeAdBinder.setOnAdClickListener(new AdFitNativeAdBinder.OnAdClickListener() { // from class: com.adxcorp.ads.adapter.AdFitNativeInterstitialAd.AdFitInterstitialDialog.1
                @Override // com.kakao.adfit.ads.na.AdFitNativeAdBinder.OnAdClickListener
                public void onAdClicked(View view) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                    if (AdFitNativeInterstitialAd.this.mCustomEventListener != null) {
                        AdFitNativeInterstitialAd.this.mCustomEventListener.onAdClicked();
                    }
                }
            });
            findViewById(com.adxcorp.library.standard.R.id.btn_close_ad).setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.adapter.AdFitNativeInterstitialAd.AdFitInterstitialDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdFitInterstitialDialog.this.dismiss();
                }
            });
        }
    }
}
