package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (b.b.a.a.d.c.c()) {
            ImageView imageView = new ImageView(context);
            this.m = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.e = this.f;
        } else {
            this.m = new TextView(context);
        }
        this.m.setTag(3);
        addView(this.m, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.m);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().m()) {
            return;
        }
        this.m.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if (b.b.a.a.d.c.c()) {
            GradientDrawable gradientDrawable = (GradientDrawable) t.f(getContext(), "tt_ad_skip_btn_bg");
            gradientDrawable.setCornerRadius(this.f / 2);
            gradientDrawable.setColor(this.j.a());
            ((ImageView) this.m).setBackgroundDrawable(gradientDrawable);
            ((ImageView) this.m).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.m).setImageResource(t.e(getContext(), "tt_reward_full_feedback"));
            return true;
        }
        ((TextView) this.m).setText(getText());
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            this.m.setTextAlignment(this.j.P());
        }
        ((TextView) this.m).setTextColor(this.j.S());
        ((TextView) this.m).setTextSize(this.j.s());
        if (i >= 16) {
            this.m.setBackground(getBackgroundDrawable());
        }
        if (this.j.X()) {
            int iG = this.j.G();
            if (iG > 0) {
                ((TextView) this.m).setLines(iG);
                ((TextView) this.m).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.m).setMaxLines(1);
            ((TextView) this.m).setGravity(17);
            ((TextView) this.m).setEllipsize(TextUtils.TruncateAt.END);
        }
        this.m.setPadding((int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.J()), (int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.L()), (int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.K()), (int) b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.j.I()));
        ((TextView) this.m).setGravity(17);
        return true;
    }

    public String getText() {
        return t.k(b.b.a.a.d.c.a(), "tt_reward_feedback");
    }
}
