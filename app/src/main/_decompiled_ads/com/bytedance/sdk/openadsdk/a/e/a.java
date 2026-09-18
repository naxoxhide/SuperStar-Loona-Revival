package com.bytedance.sdk.openadsdk.a.e;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PAGAppOpenAdListenerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements PAGAppOpenAdLoadListener {
    private final PAGAppOpenAdLoadListener a;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PAGAppOpenAdListenerAdapter.java */
    class RunnableC0170a implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f395b;

        RunnableC0170a(int i, String str) {
            this.a = i;
            this.f395b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.onError(this.a, this.f395b);
            }
        }
    }

    /* JADX INFO: compiled from: PAGAppOpenAdListenerAdapter.java */
    class b implements Runnable {
        final /* synthetic */ PAGAppOpenAd a;

        b(PAGAppOpenAd pAGAppOpenAd) {
            this.a = pAGAppOpenAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.onAdLoaded(this.a);
            }
        }
    }

    public a(PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        this.a = pAGAppOpenAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.b
    public void onError(int i, String str) {
        if (this.a == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        y.a(new RunnableC0170a(i, str));
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
        if (this.a == null) {
            return;
        }
        y.a(new b(pAGAppOpenAd));
    }
}
