package com.bytedance.sdk.openadsdk.a.b;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PAGBannerAdListenerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements PAGBannerAdLoadListener {
    private final PAGBannerAdLoadListener a;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PAGBannerAdListenerAdapter.java */
    class RunnableC0165a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f385b;

        RunnableC0165a(int i, String str) {
            this.a = i;
            this.f385b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a.onError(this.a, this.f385b);
        }
    }

    /* JADX INFO: compiled from: PAGBannerAdListenerAdapter.java */
    class b implements Runnable {
        final /* synthetic */ PAGBannerAd a;

        b(PAGBannerAd pAGBannerAd) {
            this.a = pAGBannerAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a.onAdLoaded(this.a);
        }
    }

    public a(PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        this.a = pAGBannerAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.b
    public void onError(int i, String str) {
        if (this.a == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        y.a(new RunnableC0165a(i, str));
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(PAGBannerAd pAGBannerAd) {
        if (this.a == null) {
            return;
        }
        y.a(new b(pAGBannerAd));
    }
}
