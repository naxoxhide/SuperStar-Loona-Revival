package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class Interstitial {
    private Activity activity;
    private UnityInterstitialAdCallback callback;
    private InterstitialAd interstitialAd;

    public void destroy() {
    }

    public Interstitial(Activity activity, UnityInterstitialAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    /* JADX INFO: renamed from: com.google.unity.ads.Interstitial$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$adUnitId;
        final /* synthetic */ AdRequest val$request;

        AnonymousClass1(final String val$adUnitId, final AdRequest val$request) {
            this.val$adUnitId = val$adUnitId;
            this.val$request = val$request;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterstitialAd.load(Interstitial.this.activity, this.val$adUnitId, this.val$request, new C03591());
        }

        /* JADX INFO: renamed from: com.google.unity.ads.Interstitial$1$1, reason: invalid class name and collision with other inner class name */
        class C03591 extends InterstitialAdLoadCallback {
            C03591() {
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(InterstitialAd ad) {
                Interstitial.this.interstitialAd = ad;
                Interstitial.this.interstitialAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.google.unity.ads.Interstitial.1.1.1
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(final AdValue adValue) {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Interstitial.this.callback != null) {
                                    Interstitial.this.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                                }
                            }
                        }).start();
                    }
                });
                Interstitial.this.interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.google.unity.ads.Interstitial.1.1.2
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(final AdError error) {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Interstitial.this.callback != null) {
                                    Interstitial.this.callback.onAdFailedToShowFullScreenContent(error);
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Interstitial.this.callback != null) {
                                    Interstitial.this.callback.onAdShowedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Interstitial.this.callback != null) {
                                    Interstitial.this.callback.onAdDismissedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.2.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Interstitial.this.callback != null) {
                                    Interstitial.this.callback.onAdImpression();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.2.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Interstitial.this.callback != null) {
                                    Interstitial.this.callback.onAdClicked();
                                }
                            }
                        }).start();
                    }
                });
                new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Interstitial.this.callback != null) {
                            Interstitial.this.callback.onInterstitialAdLoaded();
                        }
                    }
                }).start();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(final LoadAdError error) {
                new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial.1.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Interstitial.this.callback != null) {
                            Interstitial.this.callback.onInterstitialAdFailedToLoad(error);
                        }
                    }
                }).start();
            }
        }
    }

    public void loadAd(final String adUnitId, final AdRequest request) {
        this.activity.runOnUiThread(new AnonymousClass1(adUnitId, request));
    }

    public ResponseInfo getResponseInfo() {
        FutureTask futureTask = new FutureTask(new Callable<ResponseInfo>() { // from class: com.google.unity.ads.Interstitial.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ResponseInfo call() {
                return Interstitial.this.interstitialAd.getResponseInfo();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (ResponseInfo) futureTask.get();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check interstitial response info: %s", e.getLocalizedMessage()));
            return null;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check interstitial response info: %s", e2.getLocalizedMessage()));
            return null;
        }
    }

    public void show() {
        if (this.interstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show interstitial ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial.3
                @Override // java.lang.Runnable
                public void run() {
                    Interstitial.this.interstitialAd.show(Interstitial.this.activity);
                }
            });
        }
    }
}
