package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class ShowOperationState extends OperationState {
    public WeakReference<Activity> activity;
    public IUnityAdsShowListener listener;
    public UnityAdsShowOptions showOptions;

    public ShowOperationState(String str, IUnityAdsShowListener iUnityAdsShowListener, Activity activity, UnityAdsShowOptions unityAdsShowOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsShowListener;
        this.activity = new WeakReference<>(activity);
        this.showOptions = unityAdsShowOptions;
    }

    public void onUnityAdsShowFailure(final UnityAds.UnityAdsShowError unityAdsShowError, final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.-$$Lambda$ShowOperationState$wH0FRZEAXHKY5TAco05gxa2-f8A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUnityAdsShowFailure$0$ShowOperationState(unityAdsShowError, str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUnityAdsShowFailure$0$ShowOperationState(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.listener.onUnityAdsShowFailure(this.placementId, unityAdsShowError, str);
    }

    public void onUnityAdsShowClick() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.-$$Lambda$ShowOperationState$LtdDY2IKxisnprb-WaBoksAh_dw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUnityAdsShowClick$1$ShowOperationState();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUnityAdsShowClick$1$ShowOperationState() {
        this.listener.onUnityAdsShowClick(this.placementId);
    }

    public void onUnityAdsShowStart(final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.-$$Lambda$ShowOperationState$G7k4m1TFCDvY7Htij4AjCueUaxA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUnityAdsShowStart$2$ShowOperationState(str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUnityAdsShowStart$2$ShowOperationState(String str) {
        this.listener.onUnityAdsShowStart(str);
    }

    public void onUnityAdsShowComplete(final UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.-$$Lambda$ShowOperationState$81CxapuZhnCMOS8kbs1G2boA3E8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUnityAdsShowComplete$3$ShowOperationState(unityAdsShowCompletionState);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onUnityAdsShowComplete$3$ShowOperationState(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this.listener.onUnityAdsShowComplete(this.placementId, unityAdsShowCompletionState);
    }
}
