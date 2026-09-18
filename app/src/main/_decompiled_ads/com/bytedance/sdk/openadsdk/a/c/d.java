package com.bytedance.sdk.openadsdk.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: PAGNativeAdDataImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements PAGNativeAdData {
    private final a a;

    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdChoicesView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdLogoView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getButtonText() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getDescription() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGImageItem getIcon() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGNativeAdData.PAGNativeMediaType getMediaType() {
        return q.c(this.a.c) ? PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeVideo : PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeImage;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGMediaView getMediaView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.g();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getTitle() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }
}
