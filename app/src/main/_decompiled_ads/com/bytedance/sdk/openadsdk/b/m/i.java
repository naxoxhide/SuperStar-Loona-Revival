package com.bytedance.sdk.openadsdk.b.m;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;

/* JADX INFO: compiled from: PAGRewardedAdWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements com.bytedance.sdk.openadsdk.a.f.a {
    private final PAGRewardedAdInteractionListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PAGRewardedAdInteractionCallback f479b;

    public i(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.a = pAGRewardedAdInteractionListener;
        this.f479b = null;
    }

    @Override // com.bytedance.sdk.openadsdk.a.f.a
    public void onAdClose() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdDismissed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.f479b;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.a.f.a
    public void onAdShow() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdShowed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.f479b;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.a.f.a
    public void onAdVideoBarClick() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdClicked();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.f479b;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.a.f.a
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.a;
        if (pAGRewardedAdInteractionListener != null) {
            if (z) {
                pAGRewardedAdInteractionListener.onUserEarnedReward(new PAGRewardItem(i, str));
                return;
            } else {
                pAGRewardedAdInteractionListener.onUserEarnedRewardFail(i2, str2);
                return;
            }
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.f479b;
        if (pAGRewardedAdInteractionCallback != null) {
            if (z) {
                pAGRewardedAdInteractionCallback.onUserEarnedReward(new PAGRewardItem(i, str));
            } else {
                pAGRewardedAdInteractionCallback.onUserEarnedRewardFail(new PAGErrorModel(i2, str2));
            }
        }
    }

    public i(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.f479b = pAGRewardedAdInteractionCallback;
        this.a = null;
    }
}
