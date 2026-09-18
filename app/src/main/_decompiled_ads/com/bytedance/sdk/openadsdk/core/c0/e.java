package com.bytedance.sdk.openadsdk.core.c0;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: RewardBarClickListener.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends a {
    public e(Context context, q qVar, String str, int i) {
        super(context, qVar, str, i);
    }

    protected abstract void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3, boolean z);

    @Override // com.bytedance.sdk.openadsdk.core.c0.a, com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        if (a(view, z)) {
            a(view, f, f2, f3, f4, sparseArray, this.i, this.g, this.h, z);
        }
        super.a(view, f, f2, f3, f4, sparseArray, z);
    }
}
