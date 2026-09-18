package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PAGAppOpenAdWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bytedance.sdk.openadsdk.a.e.b {
    private final PAGAppOpenAdInteractionListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f440b = new AtomicBoolean(false);

    public e(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.a = pAGAppOpenAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.a.e.b
    public void a() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.f440b.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.a) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }

    @Override // com.bytedance.sdk.openadsdk.a.e.b
    public void onAdClicked() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.a.e.b
    public void onAdShow() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.a.e.b
    public void onAdSkip() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdDismissed();
        }
    }
}
