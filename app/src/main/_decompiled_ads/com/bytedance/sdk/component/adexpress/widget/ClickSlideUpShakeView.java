package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicHandShake;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpShakeView extends SlideUpView {
    private ShakeClickView l;

    public ClickSlideUpShakeView(Context context, int i, int i2, int i3) {
        super(context);
        a(context, i, i2, i3);
    }

    private void a(Context context, int i, int i2, int i3) {
        ShakeClickView shakeClickView = new ShakeClickView(context, new TTDynamicHandShake(context), i, i2, i3);
        this.l = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.l.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.l;
    }

    public void setShakeText(String str) {
        if (this.l == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.l.setShakeText("");
        } else {
            this.l.setShakeText(str);
        }
    }
}
