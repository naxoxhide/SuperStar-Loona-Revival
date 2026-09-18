package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.layout.TTHandWriggleGuide;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideView;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: compiled from: WriggleGuideInteract.java */
/* JADX INFO: loaded from: classes2.dex */
public class q implements f<WriggleGuideAnimationView> {
    private WriggleGuideAnimationView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f281b;
    private DynamicBaseWidget c;
    private b.b.a.a.d.d.h.g d;
    private String e;
    private int f;

    /* JADX INFO: compiled from: WriggleGuideInteract.java */
    class a implements WriggleGuideAnimationView.c {
        a(q qVar, WriggleGuideView wriggleGuideView) {
        }
    }

    public q(Context context, DynamicBaseWidget dynamicBaseWidget, b.b.a.a.d.d.h.g gVar, String str, int i) {
        this.f281b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        this.e = str;
        this.f = i;
        e();
    }

    private void e() {
        int iU = this.d.U();
        if ("18".equals(this.e)) {
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(this.f281b, new TTHandWriggleGuide(this.f281b), this.f);
            this.a = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.a.getWriggleLayout().setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
            if (this.a.getTopTextView() != null) {
                this.a.getTopTextView().setText(t.j(this.f281b, "tt_splash_wriggle_top_text_style_17"));
            }
        } else {
            this.a = new WriggleGuideAnimationView(this.f281b, new TTHandWriggleGuide(this.f281b), this.f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.a.setTranslationY(-((int) b.b.a.a.d.g.d.a(this.f281b, iU)));
        this.a.setLayoutParams(layoutParams);
        this.a.setShakeText(this.d.B());
        this.a.setClipChildren(false);
        this.a.setOnShakeViewListener(new a(this, this.a.getWriggleProgressIv()));
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
    public WriggleGuideAnimationView b() {
        return this.a;
    }
}
