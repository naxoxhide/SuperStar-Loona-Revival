package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import android.view.View;

/* JADX INFO: compiled from: H5AdInteractionManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nativeexpress.f f598b;
    private View c;

    public void a(int i, com.bytedance.sdk.openadsdk.core.f0.m mVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.f fVar;
        if (i == -1 || mVar == null) {
            return;
        }
        float f = mVar.a;
        float f2 = mVar.f582b;
        float f3 = mVar.c;
        float f4 = mVar.d;
        SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray = mVar.n;
        if (i != 1) {
            if (i == 2 && (fVar = this.f598b) != null) {
                fVar.a(mVar);
                this.f598b.a(this.c, f, f2, f3, f4, sparseArray, true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = this.a;
        if (gVar != null) {
            gVar.a(mVar);
            this.a.a(this.c, f, f2, f3, f4, sparseArray, true);
        }
    }
}
