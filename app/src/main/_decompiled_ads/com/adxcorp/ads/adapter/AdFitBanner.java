package com.adxcorp.ads.adapter;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.kakao.adfit.ads.AdListener;
import com.kakao.adfit.ads.ba.BannerAdView;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AdFitBanner extends BannerCustomEvent {
    private static final String TAG = "AdFitBanner";
    private String mAdUnitId;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private BannerAdView mBannerAdView;
    private Context mContext;
    private BCustomEventListener mCustomEventListener;
    private boolean mIsLoaded;

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public View getAdView() {
        return this.mBannerAdView;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = bCustomEventListener;
        if (Build.VERSION.SDK_INT < 21) {
            BCustomEventListener bCustomEventListener2 = this.mCustomEventListener;
            if (bCustomEventListener2 != null) {
                bCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        this.mContext = context;
        String str2 = map.get("app_code");
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.d(str, "The AdUnitId cannot be null.");
            BCustomEventListener bCustomEventListener3 = this.mCustomEventListener;
            if (bCustomEventListener3 != null) {
                bCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        if (this.mContext == null) {
            Log.d(str, "Context cannot be null.");
            BCustomEventListener bCustomEventListener4 = this.mCustomEventListener;
            if (bCustomEventListener4 != null) {
                bCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        if (this.mBannerAdView == null) {
            BannerAdView bannerAdView = new BannerAdView(this.mContext);
            this.mBannerAdView = bannerAdView;
            bannerAdView.setClientId(this.mAdUnitId);
        }
        applyBannerAdSize();
        this.mBannerAdView.setAdListener(new AdListener() { // from class: com.adxcorp.ads.adapter.AdFitBanner.1
            @Override // com.kakao.adfit.ads.AdListener
            public void onAdLoaded() {
                if (AdFitBanner.this.mIsLoaded) {
                    return;
                }
                AdFitBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdFitBanner.this.mCustomEventListener != null) {
                    AdFitBanner.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.kakao.adfit.ads.AdListener
            public void onAdFailed(int i) {
                if (AdFitBanner.this.mIsLoaded) {
                    return;
                }
                AdFitBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i + (i == 302 ? " (NO FILL)" : ""));
                if (AdFitBanner.this.mCustomEventListener != null) {
                    AdFitBanner.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.kakao.adfit.ads.AdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                if (AdFitBanner.this.mCustomEventListener != null) {
                    AdFitBanner.this.mCustomEventListener.onAdClicked();
                }
            }
        });
        this.mIsLoaded = false;
        this.mBannerAdView.loadAd();
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent, com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        BannerAdView bannerAdView = this.mBannerAdView;
        if (bannerAdView != null) {
            bannerAdView.removeAllViews();
            this.mBannerAdView.destroy();
            this.mBannerAdView = null;
        }
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size) {
        this.mBannerAdSize = banner_ad_size;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void impression() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADFIT, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_IMPRESSION);
        BCustomEventListener bCustomEventListener = this.mCustomEventListener;
        if (bCustomEventListener != null) {
            bCustomEventListener.onAdImpression();
        }
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.adapter.AdFitBanner$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE;

        static {
            int[] iArr = new int[AdConstants.BANNER_AD_SIZE.values().length];
            $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE = iArr;
            try {
                iArr[AdConstants.BANNER_AD_SIZE.AD_SIZE_320x50.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_320x100.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_300x250.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_728x90.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void applyBannerAdSize() {
        if (this.mBannerAdView == null || AnonymousClass2.$SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[this.mBannerAdSize.ordinal()] != 4) {
            return;
        }
        Log.d(TAG, this.mBannerAdSize + " not supported.");
    }
}
