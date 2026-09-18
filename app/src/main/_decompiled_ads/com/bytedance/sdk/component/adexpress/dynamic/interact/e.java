package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: compiled from: ClickSlideUpShakeInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends o<ClickSlideUpShakeView> {

    /* JADX INFO: compiled from: ClickSlideUpShakeInteract.java */
    class a implements ShakeAnimationView.c {
        a(e eVar, ShakeClickView shakeClickView) {
        }
    }

    public e(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar, int i, int i2, int i3) {
        super(context, dynamicBaseWidget, gVar);
        this.f280b = context;
        this.d = gVar;
        this.c = dynamicBaseWidget;
        a(i, i2, i3, gVar);
    }

    private void a(int i, int i2, int i3, b.b.a.a.d.d.h.g gVar) {
        this.a = new ClickSlideUpShakeView(this.f280b, i, i2, i3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) b.b.a.a.d.g.d.a(this.f280b, 300.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.b.a.a.d.g.d.a(this.f280b, gVar.U() > 0 ? gVar.U() : 0.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClipChildren(false);
        this.a.setSlideText(this.d.B());
        SlideUpView slideUpView = this.a;
        if (slideUpView instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) slideUpView).setShakeText(this.d.x());
            ShakeClickView shakeView = ((ClickSlideUpShakeView) this.a).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new a(this, shakeView));
                shakeView.setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o
    protected void e() {
    }
}
