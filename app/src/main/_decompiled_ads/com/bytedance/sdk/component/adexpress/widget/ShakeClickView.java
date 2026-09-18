package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicHandShake;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView h;

    public ShakeClickView(Context context, View view, int i, int i2, int i3) {
        super(context, view, i, i2, i3);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    protected void a(Context context, View view) {
        addView(view);
        if (view instanceof TTDynamicHandShake) {
            this.h = ((TTDynamicHandShake) view).getTvButText();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.h == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.h.setText(str);
            return;
        }
        try {
            this.h.setText(t.j(this.h.getContext(), "tt_splash_default_click_shake"));
        } catch (Exception e) {
            m.b("shakeClickView", e.getMessage());
        }
    }
}
