package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: RewardFullExpressVideoLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private final Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f546b;
    private final String c;
    private FullRewardExpressView d;
    b.c.a.a.a.a.c e;
    Handler f;
    boolean g = false;
    boolean h = false;
    boolean i = false;
    private final com.bytedance.sdk.openadsdk.b.m.p.a j;

    public c(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.j = aVar;
        this.a = aVar.V;
        this.f546b = aVar.a;
        this.c = aVar.g;
    }

    public void a(AdSlot adSlot) {
        if (this.i) {
            return;
        }
        this.i = true;
        this.d = new FullRewardExpressView(this.j, adSlot, this.c);
    }

    public void b(boolean z) {
        this.g = z;
    }

    public int c() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public FullRewardExpressView d() {
        return this.d;
    }

    public Handler e() {
        if (this.f == null) {
            this.f = new Handler(Looper.getMainLooper());
        }
        return this.f;
    }

    public FrameLayout f() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return null;
        }
        FrameLayout videoFrameLayout = fullRewardExpressView.getVideoFrameLayout();
        if (this.d.y()) {
            a();
        }
        return videoFrameLayout;
    }

    public boolean g() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return false;
        }
        return fullRewardExpressView.y();
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.g;
    }

    public void j() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.z();
    }

    public void k() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.B();
        }
    }

    public void l() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.C();
        this.d.B();
    }

    public void b() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.q();
        }
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(g gVar, f fVar) {
        q qVar;
        if (this.d == null || (qVar = this.f546b) == null) {
            return;
        }
        this.e = a(qVar);
        gVar.b(this.d);
        gVar.a(this.e);
        this.d.setClickListener(gVar);
        fVar.b(this.d);
        fVar.a(this.e);
        this.d.setClickCreativeListener(fVar);
    }

    private b.c.a.a.a.a.c a(q qVar) {
        if (qVar.e0() == 4) {
            return b.c.a.a.a.a.d.a(this.a, qVar, this.c);
        }
        return null;
    }

    public void a(l lVar) {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(lVar);
    }

    public void a(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(pAGBannerAdWrapperListener);
    }

    public void a() {
        if (q.c(this.f546b) && this.f546b.O0() == 3 && this.f546b.p0() == 0) {
            try {
                if (this.f546b.j0() == 1) {
                    int iA = b0.a(o.a(), 90.0f);
                    FrameLayout frameLayout = (FrameLayout) this.d.getBackupContainerBackgroundView();
                    if (frameLayout != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams.bottomMargin = iA;
                        frameLayout.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
