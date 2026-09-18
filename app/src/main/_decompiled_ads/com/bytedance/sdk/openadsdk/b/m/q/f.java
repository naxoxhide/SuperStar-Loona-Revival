package com.bytedance.sdk.openadsdk.b.m.q;

import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.r;

/* JADX INFO: compiled from: RewardFullTypeFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static b a(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        q qVar = aVar.a;
        if ((qVar instanceof r) && ((r) qVar).s1()) {
            return new e(aVar);
        }
        if (g.e(qVar)) {
            return new g(aVar);
        }
        if (h.a(qVar)) {
            return new h(aVar);
        }
        if (i.a(qVar)) {
            return new i(aVar);
        }
        return c.a(qVar) ? new c(aVar) : new d(aVar);
    }
}
