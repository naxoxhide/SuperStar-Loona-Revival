package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class UnityRewardedInterstitialAd {
    private Activity activity;
    private UnityRewardedInterstitialAdCallback callback;
    private RewardedInterstitialAd rewardedInterstitialAd;

    public void destroy() {
    }

    public UnityRewardedInterstitialAd(Activity activity, UnityRewardedInterstitialAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedInterstitialAd$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$adUnitId;
        final /* synthetic */ AdRequest val$request;

        AnonymousClass1(final String val$adUnitId, final AdRequest val$request) {
            this.val$adUnitId = val$adUnitId;
            this.val$request = val$request;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardedInterstitialAd.load(UnityRewardedInterstitialAd.this.activity, this.val$adUnitId, this.val$request, new C03771());
        }

        /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedInterstitialAd$1$1, reason: invalid class name and collision with other inner class name */
        class C03771 extends RewardedInterstitialAdLoadCallback {
            C03771() {
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedInterstitialAd ad) {
                UnityRewardedInterstitialAd.this.rewardedInterstitialAd = ad;
                UnityRewardedInterstitialAd.this.rewardedInterstitialAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.1
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(final AdValue adValue) {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityRewardedInterstitialAd.this.callback != null) {
                                    UnityRewardedInterstitialAd.this.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                                }
                            }
                        }).start();
                    }
                });
                UnityRewardedInterstitialAd.this.rewardedInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(final AdError error) {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityRewardedInterstitialAd.this.callback != null) {
                                    UnityRewardedInterstitialAd.this.callback.onAdFailedToShowFullScreenContent(error);
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityRewardedInterstitialAd.this.callback != null) {
                                    UnityRewardedInterstitialAd.this.callback.onAdShowedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityRewardedInterstitialAd.this.callback != null) {
                                    UnityRewardedInterstitialAd.this.callback.onAdDismissedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityRewardedInterstitialAd.this.callback != null) {
                                    UnityRewardedInterstitialAd.this.callback.onAdImpression();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityRewardedInterstitialAd.this.callback != null) {
                                    UnityRewardedInterstitialAd.this.callback.onAdClicked();
                                }
                            }
                        }).start();
                    }
                });
                new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UnityRewardedInterstitialAd.this.callback != null) {
                            UnityRewardedInterstitialAd.this.callback.onRewardedInterstitialAdLoaded();
                        }
                    }
                }).start();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(final LoadAdError error) {
                new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UnityRewardedInterstitialAd.this.callback != null) {
                            UnityRewardedInterstitialAd.this.callback.onRewardedInterstitialAdFailedToLoad(error);
                        }
                    }
                }).start();
            }
        }
    }

    public void loadAd(final String adUnitId, final AdRequest request) {
        this.activity.runOnUiThread(new AnonymousClass1(adUnitId, request));
    }

    public void show() {
        if (this.rewardedInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show rewarded interstitial ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedInterstitialAd$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UnityRewardedInterstitialAd.this.rewardedInterstitialAd.show(UnityRewardedInterstitialAd.this.activity, new OnUserEarnedRewardListener() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.2.1
                @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                public void onUserEarnedReward(final RewardItem rewardItem) {
                    new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UnityRewardedInterstitialAd.this.callback != null) {
                                UnityRewardedInterstitialAd.this.callback.onUserEarnedReward(rewardItem.getType(), rewardItem.getAmount());
                            }
                        }
                    }).start();
                }
            });
        }
    }

    public void setServerSideVerificationOptions(final ServerSideVerificationOptions serverSideVerificationOptions) {
        if (this.rewardedInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried set server side verification before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.3
                @Override // java.lang.Runnable
                public void run() {
                    UnityRewardedInterstitialAd.this.rewardedInterstitialAd.setServerSideVerificationOptions(serverSideVerificationOptions);
                }
            });
        }
    }

    public ResponseInfo getResponseInfo() {
        if (this.rewardedInterstitialAd == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(new Callable<ResponseInfo>() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ResponseInfo call() {
                return UnityRewardedInterstitialAd.this.rewardedInterstitialAd.getResponseInfo();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (ResponseInfo) futureTask.get();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check unity rewarded interstitial ad response info: %s", e.getLocalizedMessage()));
            return null;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check unity rewarded interstitial ad response info: %s", e2.getLocalizedMessage()));
            return null;
        }
    }

    public RewardItem getRewardItem() {
        if (this.rewardedInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to get reward item before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
            return null;
        }
        FutureTask futureTask = new FutureTask(new Callable<RewardItem>() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RewardItem call() {
                return UnityRewardedInterstitialAd.this.rewardedInterstitialAd.getRewardItem();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (RewardItem) futureTask.get();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to get reward item: %s", e.getLocalizedMessage()));
            return null;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to get reward item: %s", e2.getLocalizedMessage()));
            return null;
        }
    }
}
