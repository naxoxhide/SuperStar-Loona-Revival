package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.b0;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExpressClickCreativeListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends com.bytedance.sdk.openadsdk.core.c0.a {
    public f(Context context, q qVar, String str, int i) {
        super(context, qVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.b
    protected com.bytedance.sdk.openadsdk.core.f0.i a(float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject) {
        float f7;
        float f8;
        float f9;
        float fA;
        int i3;
        int i4;
        int i5;
        long j3;
        long j4;
        char c;
        int iA;
        int iA2;
        int[] iArrA = b0.a(view);
        int i6 = 0;
        if (iArrA == null || iArrA.length != 2) {
            f7 = f;
            f8 = f2;
            f9 = f3;
            fA = f4;
            i3 = 0;
            i4 = 0;
        } else {
            i3 = iArrA[0];
            i4 = iArrA[1];
            if (this.I == 0) {
                float fA2 = (b0.a(this.t, f) + i3) - 0.5f;
                float fA3 = (b0.a(this.t, f2) + i4) - 0.5f;
                float fA4 = (b0.a(this.t, f3) + i3) - 0.5f;
                fA = (b0.a(this.t, f4) + i4) - 0.5f;
                f9 = fA4;
                f7 = fA2;
                f8 = fA3;
            } else {
                f7 = f;
                f8 = f2;
                f9 = f3;
                fA = f4;
            }
        }
        int[] iArrA2 = new int[2];
        int[] iArrC = new int[2];
        com.bytedance.sdk.openadsdk.core.f0.m mVar = this.u;
        if (mVar != null) {
            j3 = mVar.e;
            j4 = mVar.f;
            if (this.I == 0) {
                iArrA2[0] = b0.a(this.t, mVar.g) + i3;
                iArrA2[1] = b0.a(this.t, this.u.h) + i4;
                iA = b0.a(this.t, this.u.i);
                iA2 = b0.a(this.t, this.u.j);
                c = 0;
                i5 = 1;
            } else {
                c = 0;
                iArrA2[0] = mVar.g;
                i5 = 1;
                iArrA2[1] = mVar.h;
                iA = mVar.i;
                iA2 = mVar.j;
            }
            iArrC[c] = iA;
            iArrC[i5] = iA2;
            if (iA == 0 && iA2 == 0 && view2 != null) {
                iArrA2 = b0.a(view2);
                iArrC = b0.c(view2);
            }
            i6 = 0;
        } else {
            i5 = 1;
            j3 = j;
            j4 = j2;
        }
        this.I = i6;
        return new com.bytedance.sdk.openadsdk.core.f0.i.b().b(f7).c(f8).e(f9).f(fA).a(j3).b(j4).c(iArrA).a(iArrA2).d(b0.c(view)).b(iArrC).f(this.g).c(this.h).e(this.i).d(com.bytedance.sdk.openadsdk.core.h.a().s() ? i5 : 2).a(sparseArray).a(str).a(f5).b(i).d(f6).a(i2).a(jSONObject).a();
    }

    public void a(com.bytedance.sdk.openadsdk.core.f0.m mVar) {
        this.u = mVar;
    }
}
