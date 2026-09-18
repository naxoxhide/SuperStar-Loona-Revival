package com.bytedance.sdk.openadsdk.component.reward.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import b.b.a.a.d.f.n;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.r;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.PangleWebView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: loaded from: classes2.dex */
public class FullRewardExpressView extends NativeExpressView {
    public static float c0 = 100.0f;
    l a0;
    FullRewardExpressBackupView b0;

    class a implements b.b.a.a.d.f.c {
        a() {
        }

        @Override // b.b.a.a.d.f.c
        public boolean a(ViewGroup viewGroup, int i) {
            try {
                ((NativeExpressView) viewGroup).o();
                FullRewardExpressView.this.b0 = new FullRewardExpressBackupView(viewGroup.getContext());
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                fullRewardExpressView.b0.a(((NativeExpressView) fullRewardExpressView).h, (NativeExpressView) viewGroup);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ n a;

        b(n nVar) {
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            FullRewardExpressView.this.b(this.a);
        }
    }

    public FullRewardExpressView(com.bytedance.sdk.openadsdk.b.m.p.a aVar, AdSlot adSlot, String str) {
        super(aVar.V, aVar.a, adSlot, str, aVar.d);
    }

    private void F() {
        setBackupListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(n nVar) {
        if (nVar == null) {
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
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l.getLayoutParams();
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
        this.l.setLayoutParams(layoutParams);
    }

    public void c(n nVar) {
        if (nVar == null) {
            return;
        }
        y.a(new b(nVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void d(int i) {
        l lVar = this.a0;
        if (lVar != null) {
            lVar.d(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void e() {
        l lVar = this.a0;
        if (lVar != null) {
            lVar.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void f() {
        l lVar = this.a0;
        if (lVar != null) {
            lVar.f();
        }
    }

    public View getBackupContainerBackgroundView() {
        if (y()) {
            return this.b0.getBackupContainerBackgroundView();
        }
        return null;
    }

    public FrameLayout getVideoFrameLayout() {
        return y() ? this.b0.getVideoContainer() : this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public int i() {
        l lVar = this.a0;
        if (lVar != null) {
            return lVar.i();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void j() {
        m.a("TTAD.FRExpressView", "onSkipVideo");
        l lVar = this.a0;
        if (lVar != null) {
            lVar.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public long k() {
        l lVar = this.a0;
        if (lVar != null) {
            return lVar.k();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void m() {
        this.o = true;
        FrameLayout frameLayout = new FrameLayout(this.a);
        this.l = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        super.m();
        SSWebView webView = getWebView();
        if (webView != null) {
            webView.setBackgroundColor(0);
            WebView webView2 = webView.getWebView();
            if (webView2 instanceof PangleWebView) {
                ((PangleWebView) webView2).setDestroyOnDetached(true);
            }
        }
        F();
    }

    public void setExpressVideoListenerProxy(l lVar) {
        this.a0 = lVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, b.b.a.a.d.f.o
    public void a(b.b.a.a.d.f.d<? extends View> dVar, n nVar) {
        q qVar = this.h;
        if (qVar != null && qVar.X0()) {
            super.a(dVar, nVar);
            return;
        }
        if (dVar instanceof p) {
            p pVar = (p) dVar;
            if (pVar.m() != null) {
                pVar.m().a((l) this);
            }
        }
        if (nVar != null && nVar.n()) {
            c(nVar);
        }
        super.a(dVar, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected boolean a(n nVar) {
        q qVar = this.h;
        if ((qVar instanceof r) && ((r) qVar).s1() && nVar.n() && nVar.h() == 1) {
            return false;
        }
        return super.a(nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void a(boolean z) {
        m.a("TTAD.FRExpressView", "onMuteVideo,mute:" + z);
        l lVar = this.a0;
        if (lVar != null) {
            lVar.a(z);
        }
        setSoundMute(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void a(int i) {
        m.a("TTAD.FRExpressView", "onChangeVideoState,stateType:" + i);
        l lVar = this.a0;
        if (lVar != null) {
            lVar.a(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, b.b.a.a.d.f.h
    public void a(View view, int i, b.b.a.a.d.b bVar) {
        if (i != -1 && bVar != null && i == 3) {
            e();
        } else {
            super.a(view, i, bVar);
        }
    }
}
