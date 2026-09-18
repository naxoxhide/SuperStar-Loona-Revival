package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        ImageView imageView = new ImageView(context);
        this.m = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (b.b.a.a.d.c.c()) {
            this.f = Math.max(dynamicRootView.getLogoUnionHeight(), this.f);
        }
        addView(this.m, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if (b.b.a.a.d.c.c()) {
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.m).setImageResource(t.e(getContext(), "tt_ad_logo_reward_full"));
        } else {
            ((ImageView) this.m).setImageResource(t.e(getContext(), "tt_ad_logo"));
        }
        ((ImageView) this.m).setColorFilter(this.j.S(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
