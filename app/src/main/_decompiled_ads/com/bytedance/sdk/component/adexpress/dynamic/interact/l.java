package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.layout.TTHandShake;
import com.bytedance.sdk.component.adexpress.layout.TTHandShake16;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;

/* JADX INFO: compiled from: ShakeInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class l implements f<ShakeAnimationView> {
    private ShakeAnimationView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277b;
    private DynamicBaseWidget c;
    private b.b.a.a.d.d.h.g d;
    private String e;
    private int f;
    private int g;
    private int h;

    /* JADX INFO: compiled from: ShakeInteract.java */
    class a implements ShakeAnimationView.c {
        a(l lVar) {
        }
    }

    public l(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar, String str, int i, int i2, int i3) {
        this.f277b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        this.e = str;
        this.f = i;
        this.g = i2;
        this.h = i3;
        e();
    }

    private void e() {
        if ("16".equals(this.e)) {
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(this.f277b, new TTHandShake16(this.f277b), this.f, this.g, this.h);
            this.a = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.a.getShakeLayout().setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
        } else {
            this.a = new ShakeAnimationView(this.f277b, new TTHandShake(this.f277b), this.f, this.g, this.h);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.b.a.a.d.g.d.a(this.f277b, 80.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setShakeText(this.d.B());
        this.a.setClipChildren(false);
        this.a.setOnShakeViewListener(new a(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void a() {
        this.a.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void c() {
        this.a.a();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView b() {
        return this.a;
    }
}
