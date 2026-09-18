package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* JADX INFO: compiled from: PressInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements f<PressInteractView> {
    private PressInteractView a;

    public k(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        this.a = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.b.a.a.d.g.d.a(context, 180.0f), (int) b.b.a.a.d.g.d.a(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) b.b.a.a.d.g.d.a(context, 20.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setGuideText(gVar.B());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
        this.a.a();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        this.a.d();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public PressInteractView b() {
        return this.a;
    }
}
