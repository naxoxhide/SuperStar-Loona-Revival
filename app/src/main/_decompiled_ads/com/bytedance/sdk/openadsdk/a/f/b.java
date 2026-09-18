package com.bytedance.sdk.openadsdk.a.f;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PARewardedAdListenerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements PAGRewardedAdLoadListener {
    private PAGRewardedAdLoadListener a;

    /* JADX INFO: compiled from: PARewardedAdListenerAdapter.java */
    class a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f397b;

        a(int i, String str) {
            this.a = i;
            this.f397b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.a != null) {
                b.this.a.onError(this.a, this.f397b);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PARewardedAdListenerAdapter.java */
    class RunnableC0171b implements Runnable {
        final /* synthetic */ PAGRewardedAd a;

        RunnableC0171b(PAGRewardedAd pAGRewardedAd) {
            this.a = pAGRewardedAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.a != null) {
                b.this.a.onAdLoaded(this.a);
            }
        }
    }

    public b(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.a = pAGRewardedAdLoadListener;
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
    public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
        if (this.a == null) {
            return;
        }
        y.a(new RunnableC0171b(pAGRewardedAd));
    }
}
