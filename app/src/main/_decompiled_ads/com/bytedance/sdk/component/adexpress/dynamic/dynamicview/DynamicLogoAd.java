package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import b.b.a.a.d.d.i.j;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        TextView textView = new TextView(context);
        this.m = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.m, getWidgetLayoutParams());
    }

    private boolean k() {
        if (b.b.a.a.d.c.c()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.j.f90b) && this.j.f90b.contains("adx:")) || j.b();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        if (Build.VERSION.SDK_INT >= 17) {
            this.m.setTextAlignment(this.j.P());
        }
        ((TextView) this.m).setTextColor(this.j.S());
        ((TextView) this.m).setTextSize(this.j.s());
        if (b.b.a.a.d.c.c()) {
            ((TextView) this.m).setIncludeFontPadding(false);
            ((TextView) this.m).setTextSize(Math.min(((b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), this.f) - this.j.L()) - this.j.I()) - 0.5f, this.j.s()));
            ((TextView) this.m).setText(t.j(getContext(), "tt_logo_en"));
            return true;
        }
        if (!k()) {
            ((TextView) this.m).setText(t.j(getContext(), "tt_logo_cn"));
            return true;
        }
        if (j.b()) {
            ((TextView) this.m).setText(j.a());
            return true;
        }
        ((TextView) this.m).setText(j.a(this.j.f90b));
        return true;
    }
}
