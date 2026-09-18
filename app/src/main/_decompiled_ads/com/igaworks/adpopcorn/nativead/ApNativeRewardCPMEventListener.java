package com.igaworks.adpopcorn.nativead;

/* JADX INFO: loaded from: classes2.dex */
public interface ApNativeRewardCPMEventListener {
    void onClicked();

    void onImpression();

    void onNativeAdLoadFailed(ApNativeRewardCPMError apNativeRewardCPMError);

    void onNativeAdLoadSuccess();
}
