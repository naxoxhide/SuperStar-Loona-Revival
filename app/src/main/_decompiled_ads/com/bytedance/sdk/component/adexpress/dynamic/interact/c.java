package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: compiled from: ClickSlideUpInteract2.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends o<ClickSlideUpView> {
    public c(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        super(context, dynamicBaseWidget, gVar);
        a(gVar);
    }

    private void a(b.b.a.a.d.d.h.g gVar) {
        this.a = new ClickSlideUpView2(this.f280b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.a.setLayoutParams(layoutParams);
        SlideUpView slideUpView = this.a;
        if (slideUpView instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) slideUpView).setButtonText(this.d.B());
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
