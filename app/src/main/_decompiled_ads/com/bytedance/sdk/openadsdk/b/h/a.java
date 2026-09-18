package com.bytedance.sdk.openadsdk.b.h;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.c0.c;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.q.c.e;
import java.util.HashMap;

/* JADX INFO: compiled from: TTAppOpenAdClickListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.core.c0.a {
    private final com.bytedance.sdk.openadsdk.b.p.a R;

    public a(Context context, q qVar, String str, int i, com.bytedance.sdk.openadsdk.b.p.a aVar) {
        super(context, qVar, str, i);
        this.R = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.a, com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        if (view.getTag() == "open_ad_click_button_tag") {
            a("click_bar");
        } else {
            a("click_material");
        }
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(this.R.a()));
        a(map);
        super.a(view, f, f2, f3, f4, sparseArray, z);
        e.a(this.v, 9);
    }
}
