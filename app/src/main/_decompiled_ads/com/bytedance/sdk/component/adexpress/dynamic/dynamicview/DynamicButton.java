package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        AnimationButton animationButton = new AnimationButton(context);
        this.m = animationButton;
        animationButton.setTag(Integer.valueOf(getClickArea()));
        addView(this.m, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if (TextUtils.equals("download-progress-button", this.k.n().f()) && TextUtils.isEmpty(this.j.o())) {
            this.m.setVisibility(4);
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.m.setTextAlignment(this.j.P());
        }
        ((TextView) this.m).setText(this.j.o());
        ((TextView) this.m).setTextColor(this.j.S());
        ((TextView) this.m).setTextSize(this.j.s());
        ((TextView) this.m).setGravity(17);
        ((TextView) this.m).setIncludeFontPadding(false);
        if ("fillButton".equals(this.k.n().f())) {
            this.m.setPadding(0, 0, 0, 0);
        } else {
            this.m.setPadding(this.j.J(), this.j.L(), this.j.K(), this.j.I());
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (!b.b.a.a.d.c.c() || !"fillButton".equals(this.k.n().f())) {
            return super.getWidgetLayoutParams();
        }
        ((TextView) this.m).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) this.m).setMaxLines(1);
        FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
        widgetLayoutParams.width -= this.j.k() * 2;
        widgetLayoutParams.height -= this.j.k() * 2;
        widgetLayoutParams.topMargin += this.j.k();
        int iK = widgetLayoutParams.leftMargin + this.j.k();
        widgetLayoutParams.leftMargin = iK;
        if (Build.VERSION.SDK_INT >= 17) {
            widgetLayoutParams.setMarginStart(iK);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
        }
        return widgetLayoutParams;
    }
}
