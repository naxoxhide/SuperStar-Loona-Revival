package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: PAGBannerVideoAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends a {
    public c(Context context, q qVar, AdSlot adSlot) {
        super(context, qVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public void a(Context context, q qVar, AdSlot adSlot) {
        this.f560b = new BannerExpressVideoView(context, qVar, adSlot);
    }

    public com.bytedance.sdk.openadsdk.m.g.a h() {
        BannerExpressView bannerExpressView = this.f560b;
        if (bannerExpressView != null) {
            return ((BannerExpressVideoView) bannerExpressView).getVideoModel();
        }
        return null;
    }
}
