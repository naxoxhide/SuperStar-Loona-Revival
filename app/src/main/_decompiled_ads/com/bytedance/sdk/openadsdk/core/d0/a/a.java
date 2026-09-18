package com.bytedance.sdk.openadsdk.core.d0.a;

import android.util.SparseArray;
import android.view.View;
import b.b.a.a.d.f.k;
import com.bytedance.sdk.openadsdk.core.c0.c;
import com.bytedance.sdk.openadsdk.core.f0.m;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: DynamicClickListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c implements b.b.a.a.d.d.j.a {
    protected WeakReference<View> t;
    private k u;

    @Override // b.b.a.a.d.d.j.a
    public void a(k kVar) {
        this.u = kVar;
    }

    @Override // b.b.a.a.d.d.j.a
    public void b(View view) {
        new WeakReference(view);
    }

    @Override // b.b.a.a.d.d.j.a
    public void a(View view) {
        this.t = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.c
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        a(view, ((Integer) view.getTag()).intValue(), f, f2, f3, f4, sparseArray);
    }

    private void a(View view, int i, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray) {
        String strValueOf;
        if (this.u != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.t;
            if (weakReference != null) {
                int[] iArrA = b0.a(weakReference.get());
                if (iArrA != null) {
                    iArr = iArrA;
                }
                int[] iArrC = b0.c(this.t.get());
                if (iArrC != null) {
                    iArr2 = iArrC;
                }
            }
            try {
                int i2 = b.b.a.a.d.d.a.u;
                strValueOf = view.getTag(i2) != null ? String.valueOf(view.getTag(i2)) : "";
            } catch (Exception unused) {
            }
            this.u.a(view, i, new m.b().a(f).b(f2).c(f3).d(f4).a(this.e).b(this.f).d(iArr[0]).e(iArr[1]).c(iArr2[0]).b(iArr2[1]).a(sparseArray).a(this.j).a(strValueOf).a());
        }
    }
}
