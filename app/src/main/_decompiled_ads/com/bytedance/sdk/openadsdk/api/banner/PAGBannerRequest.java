package com.bytedance.sdk.openadsdk.api.banner;

import com.bytedance.sdk.openadsdk.api.PAGRequest;

/* JADX INFO: loaded from: classes2.dex */
public class PAGBannerRequest extends PAGRequest {
    private PAGBannerSize d;

    public PAGBannerRequest(PAGBannerSize pAGBannerSize) {
        this.d = pAGBannerSize;
    }

    public PAGBannerSize getAdSize() {
        return this.d;
    }

    public void setAdSize(PAGBannerSize pAGBannerSize) {
        this.d = pAGBannerSize;
    }
}
