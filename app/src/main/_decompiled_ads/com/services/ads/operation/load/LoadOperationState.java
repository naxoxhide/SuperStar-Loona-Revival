package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;

/* JADX INFO: loaded from: classes4.dex */
public class LoadOperationState extends OperationState {
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;

    public LoadOperationState(String str, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsLoadListener;
        this.loadOptions = unityAdsLoadOptions;
    }

    public void onUnityAdsFailedToLoad(final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.load.-$$Lambda$LoadOperationState$oT-ZhD0dbnciHfzuBniREdokSfQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUnityAdsFailedToLoad$0$LoadOperationState(unityAdsLoadError, str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUnityAdsFailedToLoad$0$LoadOperationState(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.listener.onUnityAdsFailedToLoad(this.placementId, unityAdsLoadError, str);
    }

    public void onUnityAdsAdLoaded() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.load.-$$Lambda$LoadOperationState$Itln7qypDWWbTtwL0MG8cjQ5C40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUnityAdsAdLoaded$1$LoadOperationState();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUnityAdsAdLoaded$1$LoadOperationState() {
        this.listener.onUnityAdsAdLoaded(this.placementId);
    }

    public boolean isBanner() {
        return this instanceof LoadBannerOperationState;
    }
}
