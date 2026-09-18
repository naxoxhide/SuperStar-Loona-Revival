package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* JADX INFO: compiled from: SlideRightInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements f {
    private SlideRightView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f278b;
    private b.b.a.a.d.d.h.g c;

    public m(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        this.f278b = context;
        this.c = gVar;
        d();
    }

    private void d() {
        this.a = new SlideRightView(this.f278b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.b.a.a.d.g.d.a(this.f278b, 120.0f), (int) b.b.a.a.d.g.d.a(this.f278b, 120.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        this.a.setClipChildren(false);
        this.a.setGuideText(this.c.B());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public ViewGroup b() {
        return this.a;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        this.a.c();
    }
}
