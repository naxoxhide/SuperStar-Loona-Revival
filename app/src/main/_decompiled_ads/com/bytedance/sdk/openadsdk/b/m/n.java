package com.bytedance.sdk.openadsdk.b.m;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: compiled from: TTFullScreenVideoAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements TTClientBidding {
    private final f a;

    n(Context context, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
        this.a = new f(context, aVar);
    }

    public f a() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.loss(d, str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.win(d);
        }
    }

    public void a(boolean z) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(z);
        }
    }

    public void a(String str) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(str);
        }
    }
}
