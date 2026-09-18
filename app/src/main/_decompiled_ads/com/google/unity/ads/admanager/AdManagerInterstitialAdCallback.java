package com.google.unity.ads.admanager;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class AdManagerInterstitialAdCallback extends AdManagerInterstitialAdLoadCallback {
    private AdManagerInterstitialAd adManagerInterstitialAd;
    private UnityAdManagerInterstitialAdCallback callback;

    AdManagerInterstitialAdCallback(AdManagerInterstitialAd adManagerInterstitialAd, UnityAdManagerInterstitialAdCallback callback) {
        this.adManagerInterstitialAd = adManagerInterstitialAd;
        this.callback = callback;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public void onAdLoaded(AdManagerInterstitialAd ad) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.adManagerInterstitialAd = ad;
        ad.setOnPaidEventListener(new AnonymousClass1(executorServiceNewSingleThreadExecutor));
        this.adManagerInterstitialAd.setAppEventListener(new AnonymousClass2(executorServiceNewSingleThreadExecutor));
        this.adManagerInterstitialAd.setFullScreenContentCallback(new AnonymousClass3(executorServiceNewSingleThreadExecutor));
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$7Xt_QFd1amKYKc_8hsl0qdxEHms
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAdLoaded$0$AdManagerInterstitialAdCallback();
            }
        });
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$1, reason: invalid class name */
    class AnonymousClass1 implements OnPaidEventListener {
        final /* synthetic */ ExecutorService val$service;

        AnonymousClass1(final ExecutorService val$service) {
            this.val$service = val$service;
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$1$gEYtCmIEHclETc2o-axPQhJQU8M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPaidEvent$0$AdManagerInterstitialAdCallback$1(adValue);
                }
            });
        }

        public /* synthetic */ void lambda$onPaidEvent$0$AdManagerInterstitialAdCallback$1(AdValue adValue) {
            if (AdManagerInterstitialAdCallback.this.callback != null) {
                AdManagerInterstitialAdCallback.this.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$2, reason: invalid class name */
    class AnonymousClass2 implements AppEventListener {
        final /* synthetic */ ExecutorService val$service;

        AnonymousClass2(final ExecutorService val$service) {
            this.val$service = val$service;
        }

        @Override // com.google.android.gms.ads.admanager.AppEventListener
        public void onAppEvent(final String name, final String data) {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$2$fDbudJWhLDKmkpbIxZQXAhNIRQY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAppEvent$0$AdManagerInterstitialAdCallback$2(name, data);
                }
            });
        }

        public /* synthetic */ void lambda$onAppEvent$0$AdManagerInterstitialAdCallback$2(String str, String str2) {
            if (AdManagerInterstitialAdCallback.this.callback != null) {
                AdManagerInterstitialAdCallback.this.callback.onAppEvent(str, str2);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$3, reason: invalid class name */
    class AnonymousClass3 extends FullScreenContentCallback {
        final /* synthetic */ ExecutorService val$service;

        AnonymousClass3(final ExecutorService val$service) {
            this.val$service = val$service;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(final AdError error) {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$3$zu_vYVCsJYye4vRaEfT0f9xNAsU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdFailedToShowFullScreenContent$0$AdManagerInterstitialAdCallback$3(error);
                }
            });
        }

        public /* synthetic */ void lambda$onAdFailedToShowFullScreenContent$0$AdManagerInterstitialAdCallback$3(AdError adError) {
            if (AdManagerInterstitialAdCallback.this.callback != null) {
                AdManagerInterstitialAdCallback.this.callback.onAdFailedToShowFullScreenContent(adError);
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$3$LtAbN7qmFKg4XhhYMmqeQ7886Co
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdShowedFullScreenContent$1$AdManagerInterstitialAdCallback$3();
                }
            });
        }

        public /* synthetic */ void lambda$onAdShowedFullScreenContent$1$AdManagerInterstitialAdCallback$3() {
            if (AdManagerInterstitialAdCallback.this.callback != null) {
                AdManagerInterstitialAdCallback.this.callback.onAdShowedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$3$r2x4U8NzBRU9sRnUkxawuvCNBTE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdDismissedFullScreenContent$2$AdManagerInterstitialAdCallback$3();
                }
            });
        }

        public /* synthetic */ void lambda$onAdDismissedFullScreenContent$2$AdManagerInterstitialAdCallback$3() {
            if (AdManagerInterstitialAdCallback.this.callback != null) {
                AdManagerInterstitialAdCallback.this.callback.onAdDismissedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$3$nXKZN9OTmqG0W5DrOarLlw7T9Fc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdImpression$3$AdManagerInterstitialAdCallback$3();
                }
            });
        }

        public /* synthetic */ void lambda$onAdImpression$3$AdManagerInterstitialAdCallback$3() {
            if (AdManagerInterstitialAdCallback.this.callback != null) {
                AdManagerInterstitialAdCallback.this.callback.onAdImpression();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$AdManagerInterstitialAdCallback$3$9OYCWCEb2cdcgqdfaPvzyHDPYmQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdClicked$4$AdManagerInterstitialAdCallback$3();
                }
            });
        }

        public /* synthetic */ void lambda$onAdClicked$4$AdManagerInterstitialAdCallback$3() {
            if (AdManagerInterstitialAdCallback.this.callback != null) {
                AdManagerInterstitialAdCallback.this.callback.onAdClicked();
            }
        }
    }

    public /* synthetic */ void lambda$onAdLoaded$0$AdManagerInterstitialAdCallback() {
        UnityAdManagerInterstitialAdCallback unityAdManagerInterstitialAdCallback = this.callback;
        if (unityAdManagerInterstitialAdCallback != null) {
            unityAdManagerInterstitialAdCallback.onInterstitialAdLoaded();
        }
    }
}
