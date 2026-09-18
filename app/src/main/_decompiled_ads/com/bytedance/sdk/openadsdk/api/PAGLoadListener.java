package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.openadsdk.common.b;

/* JADX INFO: loaded from: classes2.dex */
public interface PAGLoadListener<Ad> extends b {
    void onAdLoaded(Ad ad);

    @Override // com.bytedance.sdk.openadsdk.common.b
    void onError(int i, String str);
}
