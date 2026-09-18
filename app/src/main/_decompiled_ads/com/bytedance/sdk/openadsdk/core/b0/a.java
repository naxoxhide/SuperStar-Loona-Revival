package com.bytedance.sdk.openadsdk.core.b0;

import com.bytedance.sdk.openadsdk.core.f0.b;
import com.bytedance.sdk.openadsdk.core.p;

/* JADX INFO: compiled from: AdCallBackAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements p.a {
    private final p.a a;

    public a(p.a aVar) {
        this.a = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.a
    public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, b bVar) {
        p.a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.a(aVar, bVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.a
    public void onError(int i, String str) {
        p.a aVar = this.a;
        if (aVar != null) {
            aVar.onError(i, str);
        }
    }
}
