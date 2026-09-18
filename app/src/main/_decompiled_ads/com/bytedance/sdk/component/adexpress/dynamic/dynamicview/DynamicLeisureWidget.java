package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.h;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLeisureWidget extends DynamicBaseWidgetImp {
    public DynamicLeisureWidget(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        this.e = 0;
        this.f = 0;
        return super.getWidgetLayoutParams();
    }
}
