package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: compiled from: SlideUpInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class o<E extends SlideUpView> implements f<E> {
    protected SlideUpView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f280b;
    protected DynamicBaseWidget c;
    protected b.b.a.a.d.d.h.g d;
    protected int e;

    public o(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar, int i) {
        this.e = i;
        this.f280b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        e();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
        this.a.a();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        this.a.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public E b() {
        return (E) this.a;
    }

    protected void e() {
        this.a = new SlideUpView(this.f280b, this.d.D());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) b.b.a.a.d.g.d.a(this.f280b, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.b.a.a.d.g.d.a(this.f280b, 100 - this.e);
        this.a.setLayoutParams(layoutParams);
        try {
            this.a.setGuideText(this.d.B());
        } catch (Throwable unused) {
        }
    }

    public o(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar) {
        this(context, dynamicBaseWidget, gVar, 0);
    }
}
