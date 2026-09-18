package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* JADX INFO: compiled from: UnlockInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class p implements f<DynamicUnlockView> {
    private final DynamicUnlockView a;

    public p(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.a = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.b.a.a.d.g.d.a(context, gVar.U() > 0 ? gVar.U() : 0.0f);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(gVar.B());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
        DynamicUnlockView dynamicUnlockView = this.a;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.a();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        DynamicUnlockView dynamicUnlockView = this.a;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.b();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView b() {
        return this.a;
    }
}
