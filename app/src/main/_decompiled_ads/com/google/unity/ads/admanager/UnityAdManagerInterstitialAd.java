package com.google.unity.ads.admanager;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.unity.ads.PluginUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class UnityAdManagerInterstitialAd {
    private final Activity activity;
    private AdManagerInterstitialAd adManagerInterstitialAd;
    private final UnityAdManagerInterstitialAdCallback callback;

    public void destroy() {
    }

    public UnityAdManagerInterstitialAd(Activity activity, UnityAdManagerInterstitialAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void loadAd(final String adUnitId, final AdManagerAdRequest request) {
        final AdManagerInterstitialAdCallback adManagerInterstitialAdCallback = new AdManagerInterstitialAdCallback(this.adManagerInterstitialAd, this.callback);
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerInterstitialAd$mi7C5QZ-QlkSYChEowKbNXszyz4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAd$0$UnityAdManagerInterstitialAd(adUnitId, request, adManagerInterstitialAdCallback);
            }
        });
    }

    public /* synthetic */ void lambda$loadAd$0$UnityAdManagerInterstitialAd(String str, AdManagerAdRequest adManagerAdRequest, AdManagerInterstitialAdCallback adManagerInterstitialAdCallback) {
        AdManagerInterstitialAd.load(this.activity, str, adManagerAdRequest, adManagerInterstitialAdCallback);
    }

    public ResponseInfo getResponseInfo() {
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerInterstitialAd$N37iiOrwWseSaogcPCaKWCsOD_Y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getResponseInfo$1$UnityAdManagerInterstitialAd();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (ResponseInfo) futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check Ad Manager interstitial response info: %s", e.getLocalizedMessage()));
            return null;
        }
    }

    public /* synthetic */ ResponseInfo lambda$getResponseInfo$1$UnityAdManagerInterstitialAd() throws Exception {
        return this.adManagerInterstitialAd.getResponseInfo();
    }

    public void show() {
        if (this.adManagerInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show Ad Manager interstitial ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.-$$Lambda$UnityAdManagerInterstitialAd$nq6A6eRvHJFba44qvaifuDFH8n0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$show$2$UnityAdManagerInterstitialAd();
                }
            });
        }
    }

    public /* synthetic */ void lambda$show$2$UnityAdManagerInterstitialAd() {
        this.adManagerInterstitialAd.show(this.activity);
    }
}
