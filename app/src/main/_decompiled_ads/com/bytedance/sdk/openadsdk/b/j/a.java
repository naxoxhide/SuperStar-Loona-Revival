package com.bytedance.sdk.openadsdk.b.j;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;

/* JADX INFO: compiled from: PAGInterstitialAdWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.openadsdk.a.d.b {
    private final PAGInterstitialAdInteractionListener a;

    public a(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.a = pAGInterstitialAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.a.d.b
    public void onAdClose() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.a;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.a.d.b
    public void onAdShow() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.a;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.a.d.b
    public void onAdVideoBarClick() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.a;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdClicked();
        }
    }
}
