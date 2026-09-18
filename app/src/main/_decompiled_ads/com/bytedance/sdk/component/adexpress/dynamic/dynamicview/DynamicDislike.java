package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        DislikeView dislikeView = new DislikeView(context);
        this.m = dislikeView;
        dislikeView.setTag(3);
        addView(this.m, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.m);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        int iA = (int) b.b.a.a.d.g.d.a(this.i, this.j.l());
        View view = this.m;
        if (!(view instanceof DislikeView)) {
            return true;
        }
        ((DislikeView) view).setRadius((int) b.b.a.a.d.g.d.a(this.i, this.j.j()));
        ((DislikeView) this.m).setStrokeWidth(iA);
        ((DislikeView) this.m).setStrokeColor(this.j.i());
        ((DislikeView) this.m).setBgColor(this.j.a());
        ((DislikeView) this.m).setDislikeColor(this.j.S());
        ((DislikeView) this.m).setDislikeWidth((int) b.b.a.a.d.g.d.a(this.i, 1.0f));
        return true;
    }
}
