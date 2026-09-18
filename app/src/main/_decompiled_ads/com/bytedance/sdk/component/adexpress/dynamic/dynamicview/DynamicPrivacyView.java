package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.d.d.h.g;
import b.b.a.a.d.d.h.h;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    private TextView A;
    private TextView B;
    private LinearLayout C;
    private TextView z;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.z = new TextView(this.i);
        this.A = new TextView(this.i);
        this.C = new LinearLayout(this.i);
        this.B = new TextView(this.i);
        this.z.setTag(9);
        this.A.setTag(10);
        this.C.addView(this.A);
        this.C.addView(this.B);
        this.C.addView(this.z);
        addView(this.C, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        this.A.setText("Permission list");
        this.B.setText(" | ");
        this.z.setText("Privacy policy");
        g gVar = this.j;
        if (gVar != null) {
            this.A.setTextColor(gVar.S());
            this.A.setTextSize(this.j.s());
            this.B.setTextColor(this.j.S());
            this.z.setTextColor(this.j.S());
            this.z.setTextSize(this.j.s());
            return false;
        }
        this.A.setTextColor(-1);
        this.A.setTextSize(12.0f);
        this.B.setTextColor(-1);
        this.z.setTextColor(-1);
        this.z.setTextSize(12.0f);
        return false;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected boolean d() {
        this.z.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.z.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.A.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.A.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.e, this.f);
    }
}
