package com.google.unity.ads.admanager;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.unity.ads.Banner;
import com.google.unity.ads.PluginUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class UnityAdManagerBannerView extends Banner {
    private final ExecutorService service;

    public UnityAdManagerBannerView(Activity activity, UnityAdManagerAdListener listener) {
        this.unityPlayerActivity = activity;
        this.unityListener = listener;
        this.service = Executors.newSingleThreadExecutor();
    }

    @Override // com.google.unity.ads.Banner
    protected void createAdView(final String publisherId, final AdSize adSize) {
        this.adView = new AdManagerAdView(this.unityPlayerActivity);
        this.adView.setBackgroundColor(0);
        this.adView.setAdUnitId(publisherId);
        this.adView.setAdSize(adSize);
        this.adView.setVisibility(8);
        this.adView.setDescendantFocusability(393216);
        this.unityPlayerActivity.addContentView(this.adView, getLayoutParams());
        this.adView.setAdListener(new AnonymousClass1());
        this.adView.setOnPaidEventListener(new AnonymousClass2());
        ((AdManagerAdView) this.adView).setAppEventListener(new AnonymousClass3());
        setLayoutChangeListener();
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerBannerView$1, reason: invalid class name */
    class AnonymousClass1 extends AdListener {
        AnonymousClass1() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            if (!UnityAdManagerBannerView.this.hidden) {
                UnityAdManagerBannerView.this.show();
            }
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$1$4HOyO8QFGkLzc2Nk0eGwRJA5-Uk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdLoaded$0$UnityAdManagerBannerView$1();
                }
            });
        }

        public /* synthetic */ void lambda$onAdLoaded$0$UnityAdManagerBannerView$1() {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                UnityAdManagerBannerView.this.unityListener.onAdLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(final LoadAdError error) {
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$1$J52DxQhloD3w_IERAdpgg9s1ZKo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdFailedToLoad$1$UnityAdManagerBannerView$1(error);
                }
            });
        }

        public /* synthetic */ void lambda$onAdFailedToLoad$1$UnityAdManagerBannerView$1(LoadAdError loadAdError) {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                UnityAdManagerBannerView.this.unityListener.onAdFailedToLoad(loadAdError);
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$1$zAVNdlL0A2VWLTWrc9mNI8SAD_8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdOpened$2$UnityAdManagerBannerView$1();
                }
            });
        }

        public /* synthetic */ void lambda$onAdOpened$2$UnityAdManagerBannerView$1() {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                UnityAdManagerBannerView.this.unityListener.onAdOpened();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$1$p5dIQW411m5G1nGeOBkc8IwsOQA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdClosed$3$UnityAdManagerBannerView$1();
                }
            });
        }

        public /* synthetic */ void lambda$onAdClosed$3$UnityAdManagerBannerView$1() {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                UnityAdManagerBannerView.this.unityListener.onAdClosed();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$1$LE4kBUD6QMFSRqAWkvYe6crlIb8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdImpression$4$UnityAdManagerBannerView$1();
                }
            });
        }

        public /* synthetic */ void lambda$onAdImpression$4$UnityAdManagerBannerView$1() {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                UnityAdManagerBannerView.this.unityListener.onAdImpression();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$1$dnudQSLU2p0Ncxy8xd02pAZWW7E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdClicked$5$UnityAdManagerBannerView$1();
                }
            });
        }

        public /* synthetic */ void lambda$onAdClicked$5$UnityAdManagerBannerView$1() {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                UnityAdManagerBannerView.this.unityListener.onAdClicked();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerBannerView$2, reason: invalid class name */
    class AnonymousClass2 implements OnPaidEventListener {
        AnonymousClass2() {
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$2$qwpqMSmJ-5vxH9Ug_0XX-PqWMCA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPaidEvent$0$UnityAdManagerBannerView$2(adValue);
                }
            });
        }

        public /* synthetic */ void lambda$onPaidEvent$0$UnityAdManagerBannerView$2(AdValue adValue) {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                UnityAdManagerBannerView.this.unityListener.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerBannerView$3, reason: invalid class name */
    class AnonymousClass3 implements AppEventListener {
        AnonymousClass3() {
        }

        @Override // com.google.android.gms.ads.admanager.AppEventListener
        public void onAppEvent(final String name, final String data) {
            UnityAdManagerBannerView.this.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$3$F7HoZoNUdOYfp0ka7PnBEH1mtwQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAppEvent$0$UnityAdManagerBannerView$3(name, data);
                }
            });
        }

        public /* synthetic */ void lambda$onAppEvent$0$UnityAdManagerBannerView$3(String str, String str2) {
            if (UnityAdManagerBannerView.this.unityListener != null) {
                ((UnityAdManagerAdListener) UnityAdManagerBannerView.this.unityListener).onAppEvent(str, str2);
            }
        }
    }

    public /* synthetic */ void lambda$loadAd$0$UnityAdManagerBannerView(AdManagerAdRequest adManagerAdRequest) {
        ((AdManagerAdView) this.adView).loadAd(adManagerAdRequest);
    }

    public void loadAd(final AdManagerAdRequest request) {
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$gu3Vso-c47IeWgrRblVur5RlAOE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAd$0$UnityAdManagerBannerView(request);
            }
        });
    }

    public List<AdSize> getAdSizes() {
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$nmZV8xmtMPTtfui1ElUV_RiWg0M
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getAdSizes$1$UnityAdManagerBannerView();
            }
        });
        this.unityPlayerActivity.runOnUiThread(futureTask);
        AdSize[] adSizeArr = new AdSize[0];
        try {
            adSizeArr = (AdSize[]) futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad sizes: %s", e.getLocalizedMessage()));
        }
        return Arrays.asList(adSizeArr);
    }

    public /* synthetic */ AdSize[] lambda$getAdSizes$1$UnityAdManagerBannerView() throws Exception {
        return ((AdManagerAdView) this.adView).getAdSizes();
    }

    public void setAdSizes(final List<AdSize> adSizes) {
        if (adSizes == null || adSizes.size() < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerBannerView$NlU7wmCPDdE5p40Hl7O-MRV7RjE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setAdSizes$2$UnityAdManagerBannerView(adSizes);
            }
        });
    }

    public /* synthetic */ void lambda$setAdSizes$2$UnityAdManagerBannerView(List list) {
        ((AdManagerAdView) this.adView).setAdSizes((AdSize[]) list.toArray(new AdSize[list.size()]));
    }
}
