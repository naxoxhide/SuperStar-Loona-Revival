package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class DSPAdChoice extends PAGImageView {
    public DSPAdChoice(Context context) {
        super(context);
        a();
    }

    private void a() {
        setVisibility(8);
        setId(h.g1);
    }

    public void a(int i, q qVar) {
        if (qVar.k1() || (qVar.V0() && qVar.d())) {
            b0.a((View) this, 0);
            com.bytedance.sdk.openadsdk.n.c.b().a((int) b0.a(getContext(), i, true), this, qVar);
        }
    }
}
