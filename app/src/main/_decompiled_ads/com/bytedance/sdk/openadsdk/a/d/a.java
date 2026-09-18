package com.bytedance.sdk.openadsdk.a.d;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PAGInterstitialAdListenerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements PAGInterstitialAdLoadListener {
    private PAGInterstitialAdLoadListener a;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PAGInterstitialAdListenerAdapter.java */
    class RunnableC0169a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f393b;

        RunnableC0169a(int i, String str) {
            this.a = i;
            this.f393b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.onError(this.a, this.f393b);
            }
        }
    }

    /* JADX INFO: compiled from: PAGInterstitialAdListenerAdapter.java */
    class b implements Runnable {
        final /* synthetic */ PAGInterstitialAd a;

        b(PAGInterstitialAd pAGInterstitialAd) {
            this.a = pAGInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.onAdLoaded(this.a);
            }
        }
    }

    public a(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.a = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.b
    public void onError(int i, String str) {
        if (this.a == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        y.a(new RunnableC0169a(i, str));
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
        if (this.a == null) {
            return;
        }
        y.a(new b(pAGInterstitialAd));
    }
}
