package com.kakao.adfit.ads.na;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: AdFitNativeAdBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH'J\b\u0010\u000e\u001a\u00020\nH'R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;", "", "()V", "onAdClickListener", "Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;", "getOnAdClickListener", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;", "setOnAdClickListener", "(Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;)V", "bind", "", "layout", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdTemplateLayout;", "unbind", "OnAdClickListener", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AdFitNativeAdBinder {

    /* JADX INFO: compiled from: AdFitNativeAdBinder.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;", "", "onAdClicked", "", "view", "Landroid/view/View;", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnAdClickListener {
        void onAdClicked(View view);
    }

    public abstract void bind(AdFitNativeAdLayout layout);

    public abstract void bind(AdFitNativeAdTemplateLayout layout);

    public abstract OnAdClickListener getOnAdClickListener();

    public abstract void setOnAdClickListener(OnAdClickListener onAdClickListener);

    public abstract void unbind();
}
