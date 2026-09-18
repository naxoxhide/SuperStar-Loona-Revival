package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements b.b.a.a.d.d.c {
    private boolean z;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.z = dynamicRootView.getRenderRequest().n();
        }
        this.e = this.f;
        ImageView imageView = new ImageView(context);
        this.m = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.m, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // b.b.a.a.d.d.c
    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        ((ImageView) this.m).setScaleType(ImageView.ScaleType.CENTER_CROP);
        GradientDrawable gradientDrawable = (GradientDrawable) t.f(getContext(), "tt_ad_skip_btn_bg");
        gradientDrawable.setCornerRadius(this.f / 2);
        gradientDrawable.setColor(this.j.a());
        ((ImageView) this.m).setBackgroundDrawable(gradientDrawable);
        ((ImageView) this.m).setImageResource(this.z ? t.e(getContext(), "tt_close_move_details_normal") : t.e(getContext(), "tt_skip_btn_wrapper"));
        setVisibility(8);
        return true;
    }
}
