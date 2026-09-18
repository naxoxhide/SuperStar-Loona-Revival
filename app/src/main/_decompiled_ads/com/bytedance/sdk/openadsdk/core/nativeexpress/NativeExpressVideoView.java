package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressVideoView extends NativeExpressView implements l, b.a.a.a.a.a.a.g.c.d, b.a.a.a.a.a.a.g.c.InterfaceC0008c {
    private ExpressVideoView a0;
    private com.bytedance.sdk.openadsdk.m.g.a b0;
    private long c0;
    private long d0;
    int e0;
    boolean f0;
    boolean g0;
    int h0;
    boolean i0;
    boolean j0;

    class a implements NativeVideoTsView.i {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.i
        public void a(boolean z, long j, long j2, long j3, boolean z2) {
            NativeExpressVideoView.this.b0.a = z;
            NativeExpressVideoView.this.b0.e = j;
            NativeExpressVideoView.this.b0.f = j2;
            NativeExpressVideoView.this.b0.g = j3;
            NativeExpressVideoView.this.b0.d = z2;
        }
    }

    class b implements Runnable {
        final /* synthetic */ b.b.a.a.d.f.n a;

        b(b.b.a.a.d.f.n nVar) {
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeExpressVideoView.this.b(this.a);
        }
    }

    public NativeExpressVideoView(Context context, q qVar, AdSlot adSlot, String str) {
        super(context, qVar, adSlot, str, false);
        this.e0 = 1;
        this.f0 = false;
        this.g0 = true;
        this.i0 = true;
        this.j0 = true;
        G();
    }

    private void F() {
        try {
            this.b0 = new com.bytedance.sdk.openadsdk.m.g.a();
            ExpressVideoView expressVideoView = new ExpressVideoView(this.a, this.h, this.f, this.x);
            this.a0 = expressVideoView;
            expressVideoView.setShouldCheckNetChange(false);
            this.a0.setControllerStatusCallBack(new a());
            this.a0.setVideoAdLoadListener(this);
            this.a0.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.f)) {
                this.a0.setIsAutoPlay(this.f0 ? this.g.isAutoPlay() : this.g0);
            } else if ("open_ad".equals(this.f)) {
                this.a0.setIsAutoPlay(true);
            } else {
                this.a0.setIsAutoPlay(this.g0);
            }
            if ("open_ad".equals(this.f)) {
                this.a0.setIsQuiet(true);
            } else {
                boolean zF = com.bytedance.sdk.openadsdk.core.o.d().f(String.valueOf(this.h0));
                this.u = zF;
                this.a0.setIsQuiet(zF);
            }
            this.a0.R();
        } catch (Exception unused) {
            this.a0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b.b.a.a.d.f.n nVar) {
        double dL = nVar.l();
        double dM = nVar.m();
        double dK = nVar.k();
        double dI = nVar.i();
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "videoWH=" + dK + "x" + dI);
        if (dK == 0.0d || dI == 0.0d) {
            return;
        }
        int iA = b0.a(this.a, (float) dL);
        int iA2 = b0.a(this.a, (float) dM);
        int iA3 = b0.a(this.a, (float) dK);
        int iA4 = b0.a(this.a, (float) dI);
        float fMin = Math.min(Math.min(b0.a(this.a, nVar.f()), b0.a(this.a, nVar.g())), Math.min(b0.a(this.a, nVar.d()), b0.a(this.a, nVar.e())));
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
        this.l.removeAllViews();
        if (this.a0 != null) {
            if (nVar.j() == null) {
                this.l.addView(this.a0);
            } else if (this.j0) {
                nVar.j().setTag(b.b.a.a.d.d.a.f, 1);
                ((FrameLayout) nVar.j()).removeAllViews();
                ((FrameLayout) nVar.j()).addView(this.a0, new FrameLayout.LayoutParams(-1, -1));
                this.j0 = false;
            }
            b0.b(this.l, fMin);
            this.a0.a(0L, true, false);
            f(this.h0);
            if (!com.bytedance.sdk.component.utils.p.g(this.a) && !this.g0 && this.i0) {
                this.a0.T();
            }
            setShowAdInteractionView(false);
        }
    }

    private void c(b.b.a.a.d.f.n nVar) {
        if (nVar == null) {
            return;
        }
        y.a(new b(nVar));
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.a0;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    protected void G() {
        this.l = new FrameLayout(this.a);
        q qVar = this.h;
        int iS = qVar != null ? qVar.S() : 0;
        this.h0 = iS;
        f(iS);
        F();
        addView(this.l, new FrameLayout.LayoutParams(-1, -1));
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void e() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void f() {
    }

    void f(int i) {
        int iB = com.bytedance.sdk.openadsdk.core.o.d().b(i);
        if (3 == iB) {
            this.f0 = false;
            this.g0 = false;
        } else if (4 == iB) {
            this.f0 = true;
        } else {
            int iB2 = com.bytedance.sdk.component.utils.p.b(com.bytedance.sdk.openadsdk.core.o.a());
            if (1 == iB) {
                this.f0 = false;
                this.g0 = a0.h(iB2);
            } else if (2 == iB) {
                if (a0.f(iB2) || a0.h(iB2) || a0.g(iB2)) {
                    this.f0 = false;
                    this.g0 = true;
                }
            } else if (5 == iB && (a0.h(iB2) || a0.g(iB2))) {
                this.f0 = false;
                this.g0 = true;
            }
        }
        if (!this.g0) {
            this.e0 = 3;
        }
        com.bytedance.sdk.component.utils.m.d("NativeVideoAdView", "mIsAutoPlay=" + this.g0 + ",status=" + iB);
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void g() {
        this.i0 = false;
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onVideoAdStartPlay");
        this.e0 = 2;
    }

    protected ExpressVideoView getExpressVideoView() {
        return this.a0;
    }

    public b.a.a.a.a.a.a.g.c getVideoController() {
        ExpressVideoView expressVideoView = this.a0;
        if (expressVideoView != null) {
            return expressVideoView.getNativeVideoController();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.m.g.a getVideoModel() {
        return this.b0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public int i() {
        ExpressVideoView expressVideoView;
        if (this.e0 == 3 && (expressVideoView = this.a0) != null) {
            expressVideoView.R();
        }
        ExpressVideoView expressVideoView2 = this.a0;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().b()) {
            return this.e0;
        }
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void j() {
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public long k() {
        return this.c0;
    }

    @Override // b.a.a.a.a.a.a.g.c.d
    public void l() {
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onVideoLoad");
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void onVideoAdPaused() {
        this.i0 = false;
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onVideoAdPaused");
        this.n = true;
        this.e0 = 3;
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void c() {
        this.i0 = false;
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onVideoAdContinuePlay");
        this.n = false;
        this.e0 = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, b.b.a.a.d.f.o
    public void a(b.b.a.a.d.f.d<? extends View> dVar, b.b.a.a.d.f.n nVar) {
        this.N = dVar;
        if ((dVar instanceof p) && ((p) dVar).m() != null) {
            ((p) this.N).m().a((l) this);
        }
        if (nVar != null && nVar.n()) {
            c(nVar);
        }
        super.a(dVar, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void a(boolean z) {
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onMuteVideo,mute:" + z);
        ExpressVideoView expressVideoView = this.a0;
        if (expressVideoView != null) {
            expressVideoView.setIsQuiet(z);
            setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.l
    public void a(int i) {
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onChangeVideoState,stateType:" + i);
        ExpressVideoView expressVideoView = this.a0;
        if (expressVideoView == null) {
            com.bytedance.sdk.component.utils.m.b("TTAD.NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            expressVideoView.a(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            expressVideoView.setCanInterruptVideoPlay(true);
            this.a0.performClick();
        } else if (i == 4) {
            expressVideoView.getNativeVideoController().c();
        } else {
            if (i != 5) {
                return;
            }
            expressVideoView.a(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, b.b.a.a.d.f.h
    public void a(View view, int i, b.b.a.a.d.b bVar) {
        if (i == -1 || bVar == null) {
            return;
        }
        if (i != 11) {
            super.a(view, i, bVar);
            return;
        }
        try {
            ExpressVideoView expressVideoView = this.a0;
            if (expressVideoView != null) {
                expressVideoView.setCanInterruptVideoPlay(true);
                this.a0.performClick();
                if (this.n) {
                    this.a0.findViewById(com.bytedance.sdk.openadsdk.utils.h.J0).setVisibility(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void a(long j, long j2) {
        this.i0 = false;
        int i = this.e0;
        if (i != 5 && i != 3 && j > this.c0) {
            this.e0 = 2;
        }
        this.c0 = j;
        this.d0 = j2;
        b.b.a.a.d.f.b bVar = this.L;
        if (bVar == null || bVar.c() == null) {
            return;
        }
        this.L.c().setTimeUpdate(((int) (j2 - j)) / 1000);
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void b() {
        this.i0 = false;
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onVideoComplete");
        this.e0 = 5;
        b.b.a.a.d.f.b bVar = this.L;
        if (bVar == null || bVar.c() == null) {
            return;
        }
        this.L.c().a();
    }

    @Override // b.a.a.a.a.a.a.g.c.d
    public void a(int i, int i2) {
        com.bytedance.sdk.component.utils.m.a("TTAD.NativeExpressVideoView", "onVideoError,errorCode:" + i + ",extraCode:" + i2);
        this.c0 = this.d0;
        this.e0 = 4;
    }
}
