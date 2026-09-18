package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class NativeVideoTsView extends PAGFrameLayout implements y.a, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.g, b.a.a.a.a.a.a.g.c.a {
    private static Integer M = 0;
    private static Integer N = 1;
    private long A;
    private boolean B;
    private final String C;
    private View D;
    private b.a.a.a.a.a.a.g.c.InterfaceC0008c E;
    public i F;
    private ViewTreeObserver.OnGlobalLayoutListener G;
    private final AtomicBoolean H;
    private Runnable I;
    private boolean J;
    private AtomicBoolean K;
    private final ViewTreeObserver.OnScrollChangedListener L;
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final q f679b;
    protected b.a.a.a.a.a.a.g.c c;
    private ViewGroup d;
    protected FrameLayout e;
    private boolean f;
    protected boolean g;
    private boolean h;
    public boolean i;
    public com.bytedance.sdk.openadsdk.d.g j;
    private String k;
    private boolean l;
    private boolean m;
    private boolean n;
    protected RelativeLayout o;
    protected ImageView p;
    protected ImageView q;
    protected ImageView r;
    protected boolean s;
    protected String t;
    protected int u;
    private boolean v;
    private long w;
    private boolean x;
    private final Handler y;
    private boolean z;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            NativeVideoTsView.this.q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            NativeVideoTsView.this.q();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeVideoTsView.this.x();
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NativeVideoTsView nativeVideoTsView;
            b.a.a.a.a.a.a.g.c cVar;
            if (NativeVideoTsView.this.d == null || NativeVideoTsView.this.d.getViewTreeObserver() == null || (cVar = (nativeVideoTsView = NativeVideoTsView.this).c) == null) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) cVar).b(nativeVideoTsView.d.getWidth(), NativeVideoTsView.this.d.getHeight());
            NativeVideoTsView.this.a(this);
            NativeVideoTsView.this.G = null;
        }
    }

    class d implements Runnable {
        final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a;

        d(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.a = onGlobalLayoutListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ViewTreeObserver viewTreeObserver = NativeVideoTsView.this.d.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this.a);
                }
            } catch (Exception unused) {
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
            nativeVideoTsView.a(nativeVideoTsView.z, NativeVideoTsView.M.intValue());
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeVideoTsView.this.N();
        }
    }

    class g implements ViewTreeObserver.OnScrollChangedListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            NativeVideoTsView.this.q();
        }
    }

    public interface h {
        void a(View view, int i);
    }

    public interface i {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    public NativeVideoTsView(Context context, q qVar, boolean z, com.bytedance.sdk.openadsdk.d.g gVar) {
        this(context, qVar, z, "embeded_ad", false, false, gVar);
    }

    private void A() {
        this.c = new com.bytedance.sdk.openadsdk.core.video.nativevideo.c(this.a, this.e, this.f679b, this.t, !H(), this.m, this.n, this.j);
        B();
        if (this.G == null) {
            this.G = new c();
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.G);
        }
    }

    private void B() {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar == null) {
            return;
        }
        cVar.b(this.f);
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.c).a((com.bytedance.sdk.openadsdk.core.video.nativevideo.c.g) this);
        this.c.a(this);
    }

    private boolean E() {
        q qVar = this.f679b;
        if (qVar == null) {
            return false;
        }
        return qVar.U0();
    }

    private boolean F() {
        if (H() || !E()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private boolean H() {
        return this.h;
    }

    private boolean J() {
        return 2 == o.d().b(this.f679b.S());
    }

    private boolean K() {
        return 5 == o.d().b(this.f679b.S());
    }

    private void L() {
        boolean zA = false;
        if (this.c == null || H() || (E() && !com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false))) {
            return;
        }
        long jA = this.c.a() + this.c.l();
        long jA2 = this.c.a();
        long jA3 = 0;
        if (E()) {
            zA = com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            jA3 = com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            jA = com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.c.a() + this.c.l());
            jA2 = com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_duration", this.c.a());
            com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            this.c.a(zA);
            this.c.c(jA3);
            this.c.b(jA);
            this.c.a(jA2);
        }
        m.b("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + zA + ",position=" + jA3 + ",totalPlayDuration=" + jA + ",duration=" + jA2);
    }

    private void O() {
        if (H() || !E()) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", bool);
    }

    private void P() {
        this.y.removeMessages(1);
        l.c().removeCallbacks(this.I);
    }

    private void m() {
        addView(a(this.a));
        A();
        addOnAttachStateChangeListener(new a());
    }

    private void o() {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar == null) {
            A();
        } else if ((cVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c) && !H()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.c).I();
        }
        if (this.c == null || !this.H.get()) {
            return;
        }
        this.H.set(false);
        C();
        if (!G()) {
            if (this.c.n()) {
                m.a("NativeVideoTsView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.c.n());
                c(true);
                return;
            } else {
                m.d("NativeVideoTsView", "attachTask.......mRlImgCover.....VISIBLE");
                D();
                b0.a((View) this.o, 0);
                return;
            }
        }
        b0.a((View) this.o, 8);
        ImageView imageView = this.q;
        if (imageView != null) {
            b0.a((View) imageView, 8);
        }
        q qVar = this.f679b;
        if (qVar == null || qVar.N0() == null) {
            m.b("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(this.f679b.u0()).d(), this.f679b);
        bVarA.b(this.f679b.e());
        bVarA.f(this.d.getWidth());
        bVarA.b(this.d.getHeight());
        bVarA.e(this.f679b.N());
        bVarA.a(0L);
        bVarA.a(I());
        a(bVarA);
        this.c.a(bVarA);
        this.c.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Handler handler = this.y;
        if (handler == null || jElapsedRealtime - this.A <= 500) {
            return;
        }
        this.A = jElapsedRealtime;
        handler.sendEmptyMessageDelayed(1, 500L);
    }

    private void t() {
        this.F = null;
        if ((this.c instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c) && !H()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.c).L();
        }
        v();
        b(false);
        u();
    }

    private void u() {
        if (!this.H.get()) {
            this.H.set(true);
            b.a.a.a.a.a.a.g.c cVar = this.c;
            if (cVar != null) {
                cVar.a(true, 3);
            }
        }
        this.K.set(false);
    }

    private void w() {
        this.z = r();
        com.bytedance.sdk.openadsdk.utils.y.a(this.I);
    }

    private void y() {
        b(0L, 0);
        this.E = null;
    }

    private void z() {
        b0.d(this.q);
        b0.d(this.o);
    }

    protected void C() {
        q qVar = this.f679b;
        if (qVar == null) {
            return;
        }
        int iS = qVar.S();
        int iB = o.d().b(iS);
        int iB2 = p.b(o.a());
        if (iB == 1) {
            this.f = a0.h(iB2);
        } else if (iB == 2) {
            this.f = a0.f(iB2) || a0.h(iB2) || a0.g(iB2);
        } else if (iB == 3) {
            this.f = false;
        } else if (iB == 5) {
            this.f = a0.h(iB2) || a0.g(iB2);
        }
        if (this.h) {
            this.g = false;
        } else if (!this.i || !com.bytedance.sdk.openadsdk.core.nativeexpress.p.b(this.t)) {
            this.g = o.d().f(String.valueOf(iS));
        }
        if ("open_ad".equals(this.t)) {
            this.f = true;
            this.g = true;
        }
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            cVar.b(this.f);
        }
        this.i = true;
    }

    public void D() {
        View view;
        if (this.a == null || (view = this.D) == null || view.getParent() == null || this.f679b == null || this.o != null) {
            return;
        }
        ViewParent parent = this.D.getParent();
        RelativeLayout relativeLayoutB = b(this.a);
        if (parent != null && (parent instanceof ViewGroup)) {
            a(relativeLayoutB, (ViewGroup) parent, this.D);
        }
        this.o = relativeLayoutB;
        if (this.s) {
            b0.a((View) this.r, 0);
        }
        if (this.f679b.N0() != null && this.f679b.N0().b() != null) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.f679b.N0().b(), this.f679b.N0().c(), this.f679b.N0().a(), this.p, this.f679b);
        }
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setClickable(true);
            this.r.setOnClickListener(new b());
        }
    }

    public boolean G() {
        return this.f;
    }

    public boolean I() {
        return this.g;
    }

    public boolean M() {
        boolean z = false;
        if (p.b(o.a()) == 0) {
            return false;
        }
        if (this.c.h() != null && this.c.h().h()) {
            a(false, M.intValue());
            Handler handler = this.y;
            z = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z;
    }

    public void N() {
        if (p.b(o.a()) != 0 && r()) {
            if (this.c.h() != null && this.c.h().i()) {
                a(true, N.intValue());
                C();
                Handler handler = this.y;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                return;
            }
            if (G() || this.K.get()) {
                return;
            }
            this.K.set(true);
            z();
            q qVar = this.f679b;
            if (qVar != null && qVar.N0() != null) {
                z();
                this.f679b.N0();
                com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(this.f679b.u0()).d(), this.f679b);
                bVarA.b(this.f679b.e());
                bVarA.f(this.d.getWidth());
                bVarA.b(this.d.getHeight());
                bVarA.e(this.f679b.N());
                bVarA.a(this.w);
                bVarA.a(I());
                bVarA.c(CacheDirFactory.getICacheDir(this.f679b.u0()).d());
                a(bVarA);
                this.c.a(bVarA);
            }
            Handler handler2 = this.y;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500L);
            }
            b(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.g
    public void d() {
        b.a.a.a.a.a.a.g.c.InterfaceC0008c interfaceC0008c = this.E;
        if (interfaceC0008c != null) {
            interfaceC0008c.g();
        }
    }

    public double getCurrentPlayTime() {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            return (cVar.o() * 1.0d) / 1000.0d;
        }
        return 0.0d;
    }

    public b.a.a.a.a.a.a.g.c getNativeVideoController() {
        return this.c;
    }

    @Override // b.a.a.a.a.a.a.g.c.a
    public void h() {
        m.a("NativeVideoTsView", "embeded_ad", "onTimeOut、、、、、、、、");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        getViewTreeObserver().addOnScrollChangedListener(this.L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.L);
        }
        ViewGroup viewGroup = this.d;
        if (viewGroup == null || this.G == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver2 = viewGroup.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.G);
            this.G = null;
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        o();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        i iVar;
        b.a.a.a.a.a.a.g.c cVar;
        if (!this.h && (iVar = this.F) != null && (cVar = this.c) != null) {
            iVar.a(cVar.n(), this.c.a(), this.c.k(), this.c.o(), this.f);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        t();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        b.a.a.a.a.a.a.g.c cVar;
        b.a.a.a.a.a.a.g.c cVar2;
        b.a.a.a.a.a.a.g.c cVar3;
        b.a.a.a.a.a.a.g.c cVar4;
        if ("open_ad".equals(this.t)) {
            P();
            return;
        }
        this.l = z;
        super.onWindowFocusChanged(z);
        L();
        if (F() && (cVar4 = this.c) != null && cVar4.n()) {
            O();
            b0.a((View) this.o, 8);
            c(true);
            y();
            return;
        }
        C();
        if (!H() && G() && (cVar2 = this.c) != null && !cVar2.p()) {
            if (this.y != null) {
                if (z && (cVar3 = this.c) != null && !cVar3.n()) {
                    this.y.obtainMessage(1).sendToTarget();
                    return;
                } else {
                    P();
                    a(false, M.intValue());
                    return;
                }
            }
            return;
        }
        if (G()) {
            return;
        }
        if (!z && (cVar = this.c) != null && cVar.h() != null && this.c.h().h()) {
            P();
            a(false, M.intValue());
        } else if (z) {
            this.y.obtainMessage(1).sendToTarget();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        b.a.a.a.a.a.a.g.c cVar;
        q qVar;
        b.a.a.a.a.a.a.g.c cVar2;
        b.a.a.a.a.a.a.g.c cVar3;
        super.onWindowVisibilityChanged(i2);
        L();
        if (this.J) {
            this.J = i2 == 0;
        }
        if (F() && (cVar3 = this.c) != null && cVar3.n()) {
            O();
            b0.a((View) this.o, 8);
            c(true);
            y();
            return;
        }
        C();
        if (H() || !G() || (cVar = this.c) == null || cVar.p() || (qVar = this.f679b) == null) {
            return;
        }
        if (!this.v || qVar.N0() == null) {
            m.b("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
        } else {
            this.f679b.N0();
            com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(this.f679b.u0()).d(), this.f679b);
            bVarA.b(this.f679b.e());
            bVarA.f(this.d.getWidth());
            bVarA.b(this.d.getHeight());
            bVarA.e(this.f679b.N());
            bVarA.a(this.w);
            bVarA.a(I());
            a(bVarA);
            this.c.a(bVarA);
            this.v = false;
            b0.a((View) this.o, 8);
        }
        if (i2 != 0 || this.y == null || (cVar2 = this.c) == null || cVar2.n()) {
            return;
        }
        this.y.obtainMessage(1).sendToTarget();
    }

    public void p() {
        if (getNativeVideoController() == null || !(getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = (com.bytedance.sdk.openadsdk.core.video.nativevideo.c) getNativeVideoController();
        cVar.c(cVar.g(), this);
    }

    boolean r() {
        return com.bytedance.sdk.openadsdk.core.y.b(this, 50, com.bytedance.sdk.openadsdk.core.nativeexpress.p.b(this.t) ? 1 : 5);
    }

    public void s() {
        q qVar = this.f679b;
        if (qVar == null || qVar.M0() == null) {
            return;
        }
        this.f679b.M0().p();
        this.f679b.M0().m().b(this.w);
    }

    public void setAdCreativeClickListener(h hVar) {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) cVar).a(hVar);
        }
    }

    public void setControllerStatusCallBack(i iVar) {
        this.F = iVar;
    }

    public void setIsAutoPlay(boolean z) {
        if (this.B) {
            return;
        }
        int iB = o.d().b(this.f679b.S());
        if (z && iB != 4 && (!p.e(this.a) ? !(!p.f(this.a) ? p.g(this.a) : J() || K()) : !J())) {
            z = false;
        }
        this.f = z;
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            cVar.b(z);
        }
        if (this.f) {
            b0.a((View) this.o, 8);
        } else {
            D();
            RelativeLayout relativeLayout = this.o;
            if (relativeLayout != null) {
                b0.a((View) relativeLayout, 0);
                q qVar = this.f679b;
                if (qVar != null && qVar.N0() != null) {
                    com.bytedance.sdk.openadsdk.n.c.b().a(this.f679b.N0().b(), this.f679b.N0().c(), this.f679b.N0().a(), this.p, this.f679b);
                }
            }
        }
        this.B = true;
    }

    public void setIsQuiet(boolean z) {
        this.g = z;
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            cVar.e(z);
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.s = z;
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) cVar).a(pAGNativeAd);
        }
    }

    public void setVideoAdInteractionListener(b.a.a.a.a.a.a.g.c.InterfaceC0008c interfaceC0008c) {
        this.E = interfaceC0008c;
    }

    public void setVideoAdLoadListener(b.a.a.a.a.a.a.g.c.d dVar) {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            cVar.a(dVar);
        }
    }

    public void setVideoCacheUrl(String str) {
    }

    public void setVideoPlayCallback(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar) {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) cVar).a(bVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 4 || i2 == 8) {
            u();
        }
    }

    public void v() {
        b.a.a.a.a.a.a.g.b bVarG;
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar == null || (bVarG = cVar.g()) == null) {
            return;
        }
        bVarG.c();
        View mediaView = bVarG.getMediaView();
        if (mediaView != null) {
            mediaView.setVisibility(8);
            if (mediaView.getParent() != null) {
                ((ViewGroup) mediaView.getParent()).removeView(mediaView);
            }
        }
    }

    protected void x() {
        if (M()) {
            return;
        }
        N();
    }

    public NativeVideoTsView(Context context, q qVar, String str, boolean z, boolean z2, com.bytedance.sdk.openadsdk.d.g gVar) {
        this(context, qVar, false, str, z, z2, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.g
    public void c(int i2) {
        C();
    }

    public NativeVideoTsView(Context context, q qVar, com.bytedance.sdk.openadsdk.d.g gVar) {
        this(context, qVar, false, gVar);
    }

    @Override // b.a.a.a.a.a.a.g.c.a
    public void b(long j, int i2) {
        m.a("NativeVideoTsView", "onComplete() called with: totalPlayTime = [" + j + "], percent = [" + i2 + "]");
        b.a.a.a.a.a.a.g.c.InterfaceC0008c interfaceC0008c = this.E;
        if (interfaceC0008c != null) {
            interfaceC0008c.b();
        }
    }

    public void c(boolean z) {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar != null) {
            cVar.a(z);
            b.a.a.a.a.a.a.g.b bVarG = this.c.g();
            if (bVarG != null) {
                bVarG.e();
                View mediaView = bVarG.getMediaView();
                if (mediaView != null) {
                    if (mediaView.getParent() != null) {
                        ((ViewGroup) mediaView.getParent()).removeView(mediaView);
                    }
                    mediaView.setVisibility(0);
                    addView(mediaView);
                    bVarG.a(this.f679b, new WeakReference<>(this.a), false);
                }
            }
        }
    }

    public NativeVideoTsView(Context context, q qVar, boolean z, String str, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.d.g gVar) {
        super(context);
        this.f = true;
        this.g = true;
        this.h = false;
        this.i = false;
        this.l = true;
        this.m = false;
        this.n = true;
        this.s = true;
        this.t = "embeded_ad";
        this.u = 50;
        this.v = true;
        this.x = false;
        this.y = new y(l.a().getLooper(), this);
        this.B = false;
        this.C = Build.MODEL;
        this.H = new AtomicBoolean(false);
        this.I = new e();
        this.J = true;
        this.K = new AtomicBoolean(false);
        this.L = new g();
        try {
            if (qVar.i1()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.k = CacheDirFactory.getICacheDir(0).a();
                } else {
                    this.k = com.bytedance.sdk.openadsdk.utils.g.a();
                }
            }
        } catch (Throwable unused) {
        }
        if (gVar != null) {
            this.j = gVar;
        }
        this.t = str;
        this.a = context;
        this.f679b = qVar;
        this.h = z;
        setContentDescription("NativeVideoTsView");
        this.m = z2;
        this.n = z3;
        C();
        m();
    }

    @Override // b.a.a.a.a.a.a.g.c.a
    public void a(long j, int i2) {
        m.a("NativeVideoTsView", "onError() called with: totalPlayTime = [" + j + "], percent = [" + i2 + "]");
    }

    @Override // b.a.a.a.a.a.a.g.c.a
    public void a(long j, long j2) {
        b.a.a.a.a.a.a.g.c.InterfaceC0008c interfaceC0008c = this.E;
        if (interfaceC0008c != null) {
            interfaceC0008c.a(j, j2);
        }
    }

    private RelativeLayout b(Context context) {
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        pAGRelativeLayout.setVisibility(8);
        PAGImageView pAGImageView = new PAGImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        pAGImageView.setLayoutParams(layoutParams);
        pAGImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.p = pAGImageView;
        PAGImageView pAGImageView2 = new PAGImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        pAGImageView2.setLayoutParams(layoutParams2);
        pAGImageView2.setVisibility(8);
        pAGImageView2.setBackground(t.f(context, "tt_new_play_video"));
        this.r = pAGImageView2;
        pAGRelativeLayout.addView(pAGImageView);
        pAGRelativeLayout.addView(pAGImageView2);
        return pAGRelativeLayout;
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        frameLayout.setVisibility(8);
        this.d = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout.addView(frameLayout2);
        this.e = frameLayout2;
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(view);
        this.D = view;
        return frameLayout;
    }

    private void a(View view, ViewGroup viewGroup, View view2) {
        int iIndexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    protected void b(boolean z) {
        if (this.q == null) {
            this.q = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.h.a().l() != null) {
                this.q.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.a().l());
            } else {
                this.q.setImageResource(t.e(o.a(), "tt_new_play_video"));
            }
            this.q.setScaleType(ImageView.ScaleType.FIT_XY);
            int iA = b0.a(getContext(), this.u);
            int iA2 = b0.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = iA2;
            layoutParams.bottomMargin = iA2;
            this.d.addView(this.q, layoutParams);
            this.q.setOnClickListener(new f());
        }
        if (z) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            try {
                ViewTreeObserver viewTreeObserver = this.d.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        com.bytedance.sdk.component.utils.i.b().post(new d(onGlobalLayoutListener));
    }

    public boolean a(long j, boolean z, boolean z2) {
        b.a.a.a.a.a.a.g.c cVar;
        boolean zA = false;
        this.d.setVisibility(0);
        this.w = j;
        if (!H()) {
            return true;
        }
        this.c.d(false);
        q qVar = this.f679b;
        if (qVar != null && qVar.N0() != null) {
            com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(this.f679b.u0()).d(), this.f679b);
            bVarA.b(this.f679b.e());
            bVarA.f(this.d.getWidth());
            bVarA.b(this.d.getHeight());
            bVarA.e(this.f679b.N());
            bVarA.a(j);
            bVarA.a(I());
            a(bVarA);
            if (z2) {
                this.c.b(bVarA);
                return true;
            }
            zA = this.c.a(bVarA);
        }
        if (((j > 0 && !z && !z2) || (j > 0 && z && !this.x)) && (cVar = this.c) != null) {
            com.bytedance.sdk.openadsdk.d.r.b.o.a aVar = new com.bytedance.sdk.openadsdk.d.r.b.o.a();
            aVar.b(cVar.o());
            aVar.c(this.c.a());
            aVar.a(this.c.l());
            com.bytedance.sdk.openadsdk.d.r.a.a.b(this.c.g(), aVar);
        }
        return zA;
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2) {
        if (this.f679b == null || this.c == null) {
            return;
        }
        boolean zF = F();
        O();
        if (zF && this.c.n()) {
            m.a("NativeVideoTsView", "changeVideoStatus---isFromDetailPage()=" + zF + "，mNativeVideoController.isPlayComplete()=" + this.c.n());
            c(true);
            y();
            return;
        }
        if (z && this.l && !this.c.n() && !this.c.p()) {
            if (this.c.h() != null && this.c.h().i()) {
                if (this.f || i2 == 1) {
                    b.a.a.a.a.a.a.g.c cVar = this.c;
                    if (cVar != null) {
                        setIsQuiet(cVar.i());
                    }
                    if ("ALP-AL00".equals(this.C)) {
                        this.c.f();
                    } else {
                        if (!com.bytedance.sdk.openadsdk.core.h.a().u()) {
                            zF = true;
                        }
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.c).g(zF);
                    }
                    b(false);
                    b.a.a.a.a.a.a.g.c.InterfaceC0008c interfaceC0008c = this.E;
                    if (interfaceC0008c != null) {
                        interfaceC0008c.c();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f && this.c.h() == null) {
                if (!this.H.get()) {
                    this.H.set(true);
                }
                this.K.set(false);
                o();
                return;
            }
            return;
        }
        if (this.c.h() == null || !this.c.h().h()) {
            return;
        }
        this.c.d();
        b(true);
        b.a.a.a.a.a.a.g.c.InterfaceC0008c interfaceC0008c2 = this.E;
        if (interfaceC0008c2 != null) {
            interfaceC0008c2.onVideoAdPaused();
        }
    }

    public com.bytedance.sdk.openadsdk.core.i0.f a(List<Pair<View, FriendlyObstructionPurpose>> list) {
        b.a.a.a.a.a.a.g.c cVar = this.c;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c) {
            return ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) cVar).a(this, list);
        }
        return null;
    }

    private void a(b.a.a.a.a.a.a.f.c cVar) {
        try {
            if (this.f679b.i1()) {
                cVar.c(this.k);
            }
        } catch (Throwable unused) {
        }
    }
}
