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
import com.google.android.gms.ads.appopen.AppOpenAd;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class UnityAppOpenAd {
    private final Activity activity;
    private AppOpenAd appOpenAd;
    private final UnityAppOpenAdCallback callback;

    public void destroy() {
    }

    public UnityAppOpenAd(Activity activity, UnityAppOpenAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void loadAd(final String adUnitId, final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$nbfbmdEoxT3uEtj79fieqHaWzgc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAd$0$UnityAppOpenAd(adUnitId, request);
            }
        });
    }

    public /* synthetic */ void lambda$loadAd$0$UnityAppOpenAd(String str, AdRequest adRequest) {
        AppOpenAd.load(this.activity, str, adRequest, new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityAppOpenAd$1, reason: invalid class name */
    class AnonymousClass1 extends AppOpenAd.AppOpenAdLoadCallback {
        AnonymousClass1() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(AppOpenAd ad) {
            UnityAppOpenAd.this.appOpenAd = ad;
            UnityAppOpenAd.this.appOpenAd.setOnPaidEventListener(new C03651());
            UnityAppOpenAd.this.appOpenAd.setFullScreenContentCallback(new AnonymousClass2());
            UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$E_epqce-254RxUX1BQPluiIG7C4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdLoaded$0$UnityAppOpenAd$1();
                }
            });
        }

        /* JADX INFO: renamed from: com.google.unity.ads.UnityAppOpenAd$1$1, reason: invalid class name and collision with other inner class name */
        class C03651 implements OnPaidEventListener {
            C03651() {
            }

            @Override // com.google.android.gms.ads.OnPaidEventListener
            public void onPaidEvent(final AdValue adValue) {
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$1$TQaJIuC9NA3GZlNAp2Z3aQSJs6s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPaidEvent$0$UnityAppOpenAd$1$1(adValue);
                    }
                });
            }

            public /* synthetic */ void lambda$onPaidEvent$0$UnityAppOpenAd$1$1(AdValue adValue) {
                if (UnityAppOpenAd.this.callback != null) {
                    UnityAppOpenAd.this.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                }
            }
        }

        /* JADX INFO: renamed from: com.google.unity.ads.UnityAppOpenAd$1$2, reason: invalid class name */
        class AnonymousClass2 extends FullScreenContentCallback {
            AnonymousClass2() {
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(final AdError error) {
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$2$k2Dmr9IpCxJEkt-VQGvMhHmclaQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAdFailedToShowFullScreenContent$0$UnityAppOpenAd$1$2(error);
                    }
                });
            }

            public /* synthetic */ void lambda$onAdFailedToShowFullScreenContent$0$UnityAppOpenAd$1$2(AdError adError) {
                if (UnityAppOpenAd.this.callback != null) {
                    UnityAppOpenAd.this.callback.onAdFailedToShowFullScreenContent(adError);
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$2$UxALjwfBfdgyzj9-YSN0BePoaEU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAdShowedFullScreenContent$1$UnityAppOpenAd$1$2();
                    }
                });
            }

            public /* synthetic */ void lambda$onAdShowedFullScreenContent$1$UnityAppOpenAd$1$2() {
                if (UnityAppOpenAd.this.callback != null) {
                    UnityAppOpenAd.this.callback.onAdShowedFullScreenContent();
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$2$888CNFKnKi213Wa_M_OyEBI1eOo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAdDismissedFullScreenContent$2$UnityAppOpenAd$1$2();
                    }
                });
            }

            public /* synthetic */ void lambda$onAdDismissedFullScreenContent$2$UnityAppOpenAd$1$2() {
                if (UnityAppOpenAd.this.callback != null) {
                    UnityAppOpenAd.this.callback.onAdDismissedFullScreenContent();
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdImpression() {
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$2$gTAmI86bPafCZwcpNcgSivgvWdw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAdImpression$3$UnityAppOpenAd$1$2();
                    }
                });
            }

            public /* synthetic */ void lambda$onAdImpression$3$UnityAppOpenAd$1$2() {
                if (UnityAppOpenAd.this.callback != null) {
                    UnityAppOpenAd.this.callback.onAdImpression();
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdClicked() {
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$2$FrzuxaeoAQC4X2aJETO2XZJ0NHc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAdClicked$4$UnityAppOpenAd$1$2();
                    }
                });
            }

            public /* synthetic */ void lambda$onAdClicked$4$UnityAppOpenAd$1$2() {
                if (UnityAppOpenAd.this.callback != null) {
                    UnityAppOpenAd.this.callback.onAdClicked();
                }
            }
        }

        public /* synthetic */ void lambda$onAdLoaded$0$UnityAppOpenAd$1() {
            if (UnityAppOpenAd.this.callback != null) {
                UnityAppOpenAd.this.callback.onAppOpenAdLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(final LoadAdError error) {
            UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.-$$Lambda$UnityAppOpenAd$1$751l0yq_q3zoFkKVGsdcFMokiV4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAdFailedToLoad$1$UnityAppOpenAd$1(error);
                }
            });
        }

        public /* synthetic */ void lambda$onAdFailedToLoad$1$UnityAppOpenAd$1(LoadAdError loadAdError) {
            if (UnityAppOpenAd.this.callback != null) {
                UnityAppOpenAd.this.callback.onAppOpenAdFailedToLoad(loadAdError);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityAppOpenAd$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$adUnitId;
        final /* synthetic */ int val$orientation;
        final /* synthetic */ AdRequest val$request;

        AnonymousClass2(final String val$adUnitId, final AdRequest val$request, final int val$orientation) {
            this.val$adUnitId = val$adUnitId;
            this.val$request = val$request;
            this.val$orientation = val$orientation;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppOpenAd.load(UnityAppOpenAd.this.activity, this.val$adUnitId, this.val$request, this.val$orientation, new AnonymousClass1());
        }

        /* JADX INFO: renamed from: com.google.unity.ads.UnityAppOpenAd$2$1, reason: invalid class name */
        class AnonymousClass1 extends AppOpenAd.AppOpenAdLoadCallback {
            AnonymousClass1() {
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(AppOpenAd ad) {
                UnityAppOpenAd.this.appOpenAd = ad;
                UnityAppOpenAd.this.appOpenAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.1
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(final AdValue adValue) {
                        UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityAppOpenAd.this.callback != null) {
                                    UnityAppOpenAd.this.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                                }
                            }
                        });
                    }
                });
                UnityAppOpenAd.this.appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.2
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(final AdError error) {
                        UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityAppOpenAd.this.callback != null) {
                                    UnityAppOpenAd.this.callback.onAdFailedToShowFullScreenContent(error);
                                }
                            }
                        });
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityAppOpenAd.this.callback != null) {
                                    UnityAppOpenAd.this.callback.onAdShowedFullScreenContent();
                                }
                            }
                        });
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityAppOpenAd.this.callback != null) {
                                    UnityAppOpenAd.this.callback.onAdDismissedFullScreenContent();
                                }
                            }
                        });
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.2.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityAppOpenAd.this.callback != null) {
                                    UnityAppOpenAd.this.callback.onAdImpression();
                                }
                            }
                        });
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.2.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UnityAppOpenAd.this.callback != null) {
                                    UnityAppOpenAd.this.callback.onAdClicked();
                                }
                            }
                        });
                    }
                });
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UnityAppOpenAd.this.callback != null) {
                            UnityAppOpenAd.this.callback.onAppOpenAdLoaded();
                        }
                    }
                });
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(final LoadAdError error) {
                UnityAppOpenAd.this.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.2.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UnityAppOpenAd.this.callback != null) {
                            UnityAppOpenAd.this.callback.onAppOpenAdFailedToLoad(error);
                        }
                    }
                });
            }
        }
    }

    public void loadAd(final String adUnitId, final AdRequest request, final int orientation) {
        this.activity.runOnUiThread(new AnonymousClass2(adUnitId, request, orientation));
    }

    public void show() {
        if (this.appOpenAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show app open ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAd.3
                @Override // java.lang.Runnable
                public void run() {
                    UnityAppOpenAd.this.appOpenAd.show(UnityAppOpenAd.this.activity);
                }
            });
        }
    }

    public ResponseInfo getResponseInfo() {
        if (this.appOpenAd == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(new Callable<ResponseInfo>() { // from class: com.google.unity.ads.UnityAppOpenAd.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ResponseInfo call() {
                return UnityAppOpenAd.this.appOpenAd.getResponseInfo();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (ResponseInfo) futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check unity app open ad response info: %s", e.getLocalizedMessage()));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnNewThread(final Runnable action) {
        new Thread(action).start();
    }
}
