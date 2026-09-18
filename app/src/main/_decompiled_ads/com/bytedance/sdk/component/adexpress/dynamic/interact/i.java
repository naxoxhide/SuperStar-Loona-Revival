package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* JADX INFO: compiled from: LongPressInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements f {
    private HandLongPressView a;

    public i(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        this.a = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.b.a.a.d.g.d.a(context, 180.0f), (int) b.b.a.a.d.g.d.a(context, 180.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        this.a.setGuideText(gVar.B());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
        this.a.a();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public ViewGroup b() {
        return this.a;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        this.a.d();
    }
}
