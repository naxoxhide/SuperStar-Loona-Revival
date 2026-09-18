package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUp3DView;

/* JADX INFO: compiled from: SlideUp3DInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements f<SlideUp3DView> {
    private SlideUp3DView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f279b;
    private b.b.a.a.d.d.h.g c;

    public n(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        this.f279b = context;
        this.c = gVar;
        e();
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
    public SlideUp3DView b() {
        return this.a;
    }

    protected void e() {
        this.a = new SlideUp3DView(this.f279b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) b.b.a.a.d.g.d.a(this.f279b, 250.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.b.a.a.d.g.d.a(this.f279b, 120.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setGuideText(this.c.B());
    }
}
