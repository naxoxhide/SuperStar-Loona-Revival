package com.bytedance.sdk.openadsdk.a.c;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PAGNativeAdLoadListenerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements PAGNativeAdLoadListener {
    private final PAGNativeAdLoadListener a;

    /* JADX INFO: compiled from: PAGNativeAdLoadListenerAdapter.java */
    class a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f388b;

        a(int i, String str) {
            this.a = i;
            this.f388b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a.onError(this.a, this.f388b);
        }
    }

    /* JADX INFO: compiled from: PAGNativeAdLoadListenerAdapter.java */
    class b implements Runnable {
        final /* synthetic */ PAGNativeAd a;

        b(PAGNativeAd pAGNativeAd) {
            this.a = pAGNativeAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a.onAdLoaded(this.a);
        }
    }

    public e(PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        this.a = pAGNativeAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.b
    public void onError(int i, String str) {
        if (this.a == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        y.a(new a(i, str));
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(PAGNativeAd pAGNativeAd) {
        if (this.a == null) {
            return;
        }
        y.a(new b(pAGNativeAd));
    }
}
