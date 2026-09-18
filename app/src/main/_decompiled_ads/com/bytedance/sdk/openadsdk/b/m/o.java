package com.bytedance.sdk.openadsdk.b.m;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: compiled from: TTRewardVideoAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class o implements TTClientBidding {
    private h a;

    o(Context context, com.bytedance.sdk.openadsdk.core.f0.a aVar, AdSlot adSlot) {
        this.a = new h(context, aVar, adSlot);
    }

    public h a() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.loss(d, str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.win(d);
        }
    }

    public void a(String str) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.a(str);
        }
    }
}
