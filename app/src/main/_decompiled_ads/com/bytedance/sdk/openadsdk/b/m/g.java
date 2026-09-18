package com.bytedance.sdk.openadsdk.b.m;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PAGRewardProxyListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements PAGRewardedAdLoadListener {
    final PAGRewardedAdLoadListener a;

    /* JADX INFO: compiled from: PAGRewardProxyListener.java */
    class a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f475b;

        a(int i, String str) {
            this.a = i;
            this.f475b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener = g.this.a;
            if (pAGRewardedAdLoadListener != null) {
                pAGRewardedAdLoadListener.onError(this.a, this.f475b);
            }
        }
    }

    /* JADX INFO: compiled from: PAGRewardProxyListener.java */
    class b implements Runnable {
        final /* synthetic */ PAGRewardedAd a;

        b(PAGRewardedAd pAGRewardedAd) {
            this.a = pAGRewardedAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener = g.this.a;
            if (pAGRewardedAdLoadListener != null) {
                pAGRewardedAdLoadListener.onAdLoaded(this.a);
            }
        }
    }

    public g(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.a = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
        if (this.a != null) {
            y.a(new b(pAGRewardedAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.b
    public void onError(int i, String str) {
        if (this.a != null) {
            y.a(new a(i, str));
        }
    }
}
