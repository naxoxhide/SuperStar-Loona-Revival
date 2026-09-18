package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import b.a.a.a.a.a.a.g.c;
import b.b.a.a.d.b;
import b.b.a.a.d.f.d;
import b.b.a.a.d.f.n;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PAGAppOpenAdExpressView extends NativeExpressView {
    private FrameLayout a0;
    private com.bytedance.sdk.openadsdk.b.n.a b0;
    boolean c0;

    class a implements Runnable {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PAGAppOpenAdExpressView.this.b(this.a);
        }
    }

    public PAGAppOpenAdExpressView(Context context, q qVar, AdSlot adSlot, String str) {
        super(context, qVar, adSlot, str, true);
        this.c0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n nVar) {
        if (nVar == null) {
            return;
        }
        if (nVar.j() != null) {
            if (this.c0) {
                nVar.j().setTag(b.b.a.a.d.d.a.f, 1);
                ((FrameLayout) nVar.j()).removeAllViews();
                FrameLayout frameLayout = (FrameLayout) nVar.j();
                this.a0 = frameLayout;
                ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).gravity = 17;
                this.c0 = false;
                return;
            }
            return;
        }
        double dL = nVar.l();
        double dM = nVar.m();
        double dK = nVar.k();
        double dI = nVar.i();
        int iA = b0.a(this.a, (float) dL);
        int iA2 = b0.a(this.a, (float) dM);
        int iA3 = b0.a(this.a, (float) dK);
        int iA4 = b0.a(this.a, (float) dI);
        m.a("ExpressView", "vW x vH =" + dK + "x" + dI);
        if (dI == 0.0d || dK == 0.0d) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a0.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iA3, iA4);
        }
        layoutParams.width = iA3;
        layoutParams.height = iA4;
        layoutParams.topMargin = iA2;
        layoutParams.leftMargin = iA;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(iA);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.a0.setLayoutParams(layoutParams);
    }

    public void c(n nVar) {
        if (nVar == null) {
            return;
        }
        y.a(new a(nVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void e() {
        com.bytedance.sdk.openadsdk.b.n.a aVar = this.b0;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void f() {
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public int getDynamicShowType() {
        if (this.N == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.b.o.a.a(this.h, o.d().w(String.valueOf(this.h.S())));
    }

    public FrameLayout getVideoFrameLayout() {
        return this.a0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void j() {
        com.bytedance.sdk.openadsdk.b.n.a aVar = this.b0;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void m() {
        this.o = true;
        FrameLayout frameLayout = new FrameLayout(this.a);
        this.a0 = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        super.m();
    }

    public void setExpressVideoListenerProxy(c.a aVar) {
    }

    public void setTopListener(com.bytedance.sdk.openadsdk.b.n.a aVar) {
        this.b0 = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, b.b.a.a.d.f.o
    public void a(d<? extends View> dVar, n nVar) {
        if (nVar != null && nVar.n()) {
            c(nVar);
        }
        super.a(dVar, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void a(int i) {
        super.a(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, b.b.a.a.d.f.h
    public void a(View view, int i, b bVar) {
        if (i != -1 && bVar != null && i == 3) {
            e();
        } else {
            super.a(view, i, bVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void a(b.b.a.a.d.f.m.a aVar) {
        aVar.e(com.bytedance.sdk.openadsdk.b.o.a.a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void a(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.b.o.a.a(jSONObject, this.h.S());
    }
}
