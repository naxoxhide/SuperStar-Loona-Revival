package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.widget.ImageView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements b.b.a.a.d.d.b {
    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        ImageView imageView = new ImageView(context);
        this.m = imageView;
        imageView.setTag(5);
        addView(this.m, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if (b.b.a.a.d.g.c.a(this.l.getRenderRequest().a())) {
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.l.k);
        GradientDrawable gradientDrawable = (GradientDrawable) t.f(getContext(), "tt_ad_skip_btn_bg");
        gradientDrawable.setCornerRadius(this.f / 2);
        gradientDrawable.setColor(this.j.a());
        ((ImageView) this.m).setBackgroundDrawable(gradientDrawable);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean i() {
        return true;
    }

    @Override // b.b.a.a.d.d.b
    public void setSoundMute(boolean z) {
        int iE;
        if (b.b.a.a.d.g.c.a(this.l.getRenderRequest().a())) {
            iE = z ? t.e(getContext(), "tt_reward_full_mute") : t.e(getContext(), "tt_reward_full_unmute");
        } else {
            iE = z ? t.e(getContext(), "tt_mute") : t.e(getContext(), "tt_unmute");
        }
        ((ImageView) this.m).setImageResource(iE);
        if (((ImageView) this.m).getDrawable() == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ((ImageView) this.m).getDrawable().setAutoMirrored(true);
    }
}
