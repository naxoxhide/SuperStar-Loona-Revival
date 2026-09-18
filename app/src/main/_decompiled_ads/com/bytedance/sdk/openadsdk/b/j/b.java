package com.bytedance.sdk.openadsdk.b.j;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PAGInterstitialProxyListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements PAGInterstitialAdLoadListener {
    final PAGInterstitialAdLoadListener a;

    /* JADX INFO: compiled from: PAGInterstitialProxyListener.java */
    class a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f454b;

        a(int i, String str) {
            this.a = i;
            this.f454b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = b.this.a;
            if (pAGInterstitialAdLoadListener != null) {
                pAGInterstitialAdLoadListener.onError(this.a, this.f454b);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.j.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PAGInterstitialProxyListener.java */
    class RunnableC0179b implements Runnable {
        final /* synthetic */ PAGInterstitialAd a;

        RunnableC0179b(PAGInterstitialAd pAGInterstitialAd) {
            this.a = pAGInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = b.this.a;
            if (pAGInterstitialAdLoadListener != null) {
                pAGInterstitialAdLoadListener.onAdLoaded(this.a);
            }
        }
    }

    public b(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.a = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
        if (this.a != null) {
            y.a(new RunnableC0179b(pAGInterstitialAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.b
    public void onError(int i, String str) {
        if (this.a != null) {
            y.a(new a(i, str));
        }
    }
}
