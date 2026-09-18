package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: compiled from: ClickSlideUpInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends o<ClickSlideUpView> {
    public d(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        super(context, dynamicBaseWidget, gVar);
        a(gVar);
    }

    private void a(b.b.a.a.d.d.h.g gVar) {
        this.a = new ClickSlideUpView(this.f280b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.b.a.a.d.g.d.a(this.f280b, gVar.U());
        this.a.setLayoutParams(layoutParams);
        this.a.setSlideText(this.d.B());
        SlideUpView slideUpView = this.a;
        if (slideUpView instanceof ClickSlideUpView) {
            ((ClickSlideUpView) slideUpView).setButtonText(this.d.o());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o, com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        this.a.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o
    protected void e() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o, com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
        this.a.a();
    }
}
