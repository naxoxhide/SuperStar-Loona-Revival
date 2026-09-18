package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView;

/* JADX INFO: compiled from: BrushMaskInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements f<DynamicBrushMaskView> {
    private DynamicBrushMaskView a;

    public a(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        this.a = new DynamicBrushMaskView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.b.a.a.d.g.d.a(context, gVar.U() > 0 ? gVar.U() : 0.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClipChildren(false);
        this.a.setBrushText(gVar.B());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
        DynamicBrushMaskView dynamicBrushMaskView = this.a;
        if (dynamicBrushMaskView != null) {
            dynamicBrushMaskView.a();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        DynamicBrushMaskView dynamicBrushMaskView = this.a;
        if (dynamicBrushMaskView != null) {
            dynamicBrushMaskView.c();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DynamicBrushMaskView b() {
        return this.a;
    }
}
