package com.applovin.mediation.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.kakao.adfit.ads.AdListener;
import com.kakao.adfit.ads.ba.BannerAdView;
import com.kakao.adfit.ads.na.AdFitAdInfoIconPosition;
import com.kakao.adfit.ads.na.AdFitMediaView;
import com.kakao.adfit.ads.na.AdFitNativeAdBinder;
import com.kakao.adfit.ads.na.AdFitNativeAdLayout;
import com.kakao.adfit.ads.na.AdFitNativeAdLoader;
import com.kakao.adfit.ads.na.AdFitNativeAdRequest;
import com.kakao.adfit.ads.na.AdFitNativeAdView;
import com.kakao.adfit.ads.na.AdFitVideoAutoPlayPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class AdFitMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxNativeAdAdapter {
    private static final String TAG = "AdFitMediationAdapter";
    private AdFitNativeAdBinder mAdFitNativeAdBinder;
    private AdFitNativeAdLoader mAdFitNativeAdLoader;
    private AdFitNativeAdRequest mAdFitNativeAdRequest;
    private AdFitNativeAdView mAdFitNativeAdView;
    private BannerAdView mBannerAdView;
    private AdFitMediaView mMediaView;

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return "3.12.9.0";
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return "3.12.9";
    }

    public AdFitMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        log("Destroy called for adapter " + this);
        BannerAdView bannerAdView = this.mBannerAdView;
        if (bannerAdView != null) {
            bannerAdView.removeAllViews();
            this.mBannerAdView.destroy();
            this.mBannerAdView = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, final Activity activity, final MaxAdViewAdapterListener maxAdViewAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        d("Loading " + maxAdFormat.getLabel() + " AdView ad for placement: " + thirdPartyAdPlacementId + "...");
        ADXLogUtil.d(TAG, "loadAdViewAd - " + maxAdapterResponseParameters.getServerParameters());
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.AdFitMediationAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AdFitMediationAdapter.this.mBannerAdView == null) {
                        AdFitMediationAdapter.this.mBannerAdView = new BannerAdView(activity);
                        AdFitMediationAdapter.this.mBannerAdView.setClientId(thirdPartyAdPlacementId);
                    }
                    AdFitMediationAdapter.this.mBannerAdView.setAdListener(new AdListener() { // from class: com.applovin.mediation.adapters.AdFitMediationAdapter.1.1
                        @Override // com.kakao.adfit.ads.AdListener
                        public void onAdLoaded() {
                            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                            if (maxAdViewAdapterListener != null) {
                                maxAdViewAdapterListener.onAdViewAdLoaded(AdFitMediationAdapter.this.mBannerAdView);
                                maxAdViewAdapterListener.onAdViewAdDisplayed();
                            }
                        }

                        @Override // com.kakao.adfit.ads.AdListener
                        public void onAdFailed(int i) {
                            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i + (i == 302 ? " (NO FILL)" : ""));
                            if (maxAdViewAdapterListener != null) {
                                maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
                            }
                        }

                        @Override // com.kakao.adfit.ads.AdListener
                        public void onAdClicked() {
                            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                            if (maxAdViewAdapterListener != null) {
                                maxAdViewAdapterListener.onAdViewAdClicked();
                            }
                        }
                    });
                    AdFitMediationAdapter.this.mBannerAdView.loadAd();
                }
            });
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            if (maxAdViewAdapterListener != null) {
                maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
            }
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        d("Loading native ad for ad id: " + thirdPartyAdPlacementId + "...");
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        ADXLogUtil.d(TAG, "loadNativeAd - " + serverParameters);
        try {
            AppLovinSdkUtils.runOnUiThread(new AnonymousClass2(serverParameters, activity, thirdPartyAdPlacementId, maxNativeAdAdapterListener));
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.AdFitMediationAdapter$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$adId;
        final /* synthetic */ Bundle val$bundle;
        final /* synthetic */ Activity val$finalActivity;
        final /* synthetic */ MaxNativeAdAdapterListener val$listener;

        AnonymousClass2(Bundle bundle, Activity activity, String str, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.val$bundle = bundle;
            this.val$finalActivity = activity;
            this.val$adId = str;
            this.val$listener = maxNativeAdAdapterListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = (this.val$bundle.containsKey("custom_parameters") && this.val$bundle.getBundle("custom_parameters").containsKey("test_mode")) ? this.val$bundle.getBundle("custom_parameters").getBoolean("test_mode") : false;
            AdFitMediationAdapter.this.mAdFitNativeAdLoader = AdFitNativeAdLoader.create(this.val$finalActivity, this.val$adId);
            AdFitMediationAdapter.this.mAdFitNativeAdRequest = new AdFitNativeAdRequest.Builder().setAdInfoIconPosition(AdFitAdInfoIconPosition.RIGHT_TOP).setVideoAutoPlayPolicy(AdFitVideoAutoPlayPolicy.NONE).setTestModeEnabled(z).build();
            AdFitMediationAdapter.this.mAdFitNativeAdLoader.loadAd(AdFitMediationAdapter.this.mAdFitNativeAdRequest, new AdFitNativeAdLoader.AdLoadListener() { // from class: com.applovin.mediation.adapters.AdFitMediationAdapter.2.1
                @Override // com.kakao.adfit.ads.na.AdFitNativeAdLoader.AdLoadListener
                public void onAdLoaded(AdFitNativeAdBinder adFitNativeAdBinder) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_SUCCESS);
                    AdFitMediationAdapter.this.mAdFitNativeAdBinder = adFitNativeAdBinder;
                    AdFitMediationAdapter.this.mAdFitNativeAdBinder.setOnAdClickListener(new AdFitNativeAdBinder.OnAdClickListener() { // from class: com.applovin.mediation.adapters.AdFitMediationAdapter.2.1.1
                        @Override // com.kakao.adfit.ads.na.AdFitNativeAdBinder.OnAdClickListener
                        public void onAdClicked(View view) {
                            ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_CLICK);
                            if (AnonymousClass2.this.val$listener != null) {
                                AnonymousClass2.this.val$listener.onNativeAdClicked();
                            }
                        }
                    });
                    AdFitMediationAdapter.this.mAdFitNativeAdView = new AdFitNativeAdView(AnonymousClass2.this.val$finalActivity);
                    AdFitMediationAdapter.this.mMediaView = new AdFitMediaView(AnonymousClass2.this.val$finalActivity);
                    TextView textView = new TextView(AnonymousClass2.this.val$finalActivity);
                    ImageView imageView = new ImageView(AnonymousClass2.this.val$finalActivity);
                    Button button = new Button(AnonymousClass2.this.val$finalActivity);
                    AdFitMediationAdapter.this.mAdFitNativeAdBinder.bind(new AdFitNativeAdLayout.Builder(AdFitMediationAdapter.this.mAdFitNativeAdView).setTitleView(textView).setMediaView(AdFitMediationAdapter.this.mMediaView).setProfileIconView(imageView).setCallToActionButton(button).build());
                    MaxAdFitNativeAd maxAdFitNativeAd = AdFitMediationAdapter.this.new MaxAdFitNativeAd(new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(textView.getText().toString()).setCallToAction(button.getText().toString()).setIcon(new MaxNativeAd.MaxNativeAdImage(imageView.getDrawable())).setMediaView(AdFitMediationAdapter.this.mMediaView), AnonymousClass2.this.val$listener);
                    if (AnonymousClass2.this.val$listener != null) {
                        AnonymousClass2.this.val$listener.onNativeAdLoaded(maxAdFitNativeAd, null);
                    }
                }

                @Override // com.kakao.adfit.ads.na.AdFitNativeAdLoader.AdLoadListener
                public void onAdLoadError(int i) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE, "Failure, " + i);
                    if (AnonymousClass2.this.val$listener != null) {
                        AnonymousClass2.this.val$listener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
                    }
                }
            });
        }
    }

    private class MaxAdFitNativeAd extends MaxNativeAd {
        private MaxNativeAdAdapterListener listener;

        public MaxAdFitNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        public MaxAdFitNativeAd(MaxNativeAd.Builder builder, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            super(builder);
            this.listener = maxNativeAdAdapterListener;
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
            ADXLogUtil.d(AdFitMediationAdapter.TAG, "prepareViewForInteraction");
            try {
                View mainView = maxNativeAdView.getMainView();
                maxNativeAdView.removeView(mainView);
                AdFitMediationAdapter.this.mAdFitNativeAdView.addView(mainView);
                maxNativeAdView.addView(AdFitMediationAdapter.this.mAdFitNativeAdView);
                AdFitMediationAdapter.this.mAdFitNativeAdBinder.bind(new AdFitNativeAdLayout.Builder(AdFitMediationAdapter.this.mAdFitNativeAdView).setTitleView(maxNativeAdView.getTitleTextView()).setMediaView(AdFitMediationAdapter.this.mMediaView).setProfileIconView(maxNativeAdView.getIconImageView()).setCallToActionButton(maxNativeAdView.getCallToActionButton()).build());
                AdFitMediationAdapter.this.mAdFitNativeAdView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.applovin.mediation.adapters.AdFitMediationAdapter.MaxAdFitNativeAd.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        AdFitMediationAdapter.this.mAdFitNativeAdView.removeOnAttachStateChangeListener(this);
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_IMPRESSION);
                        if (MaxAdFitNativeAd.this.listener != null) {
                            MaxAdFitNativeAd.this.listener.onNativeAdDisplayed(null);
                        }
                    }
                });
            } catch (Exception e) {
                ADXLogUtil.e(AdFitMediationAdapter.TAG, e);
            }
        }
    }
}
