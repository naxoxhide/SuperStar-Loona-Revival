package com.mbridge.msdk.splash.d;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.ZoomOutTypeEnum;
import com.mbridge.msdk.splash.view.MBSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;

/* JADX INFO: compiled from: SplashProvider.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2441b = "SplashProvider";
    private boolean A;
    private CampaignEx B;
    private MBSplashPopView C;
    private String c;
    private String d;
    private MBridgeIds e;
    private long g;
    private com.mbridge.msdk.splash.c.c h;
    private com.mbridge.msdk.splash.c.d i;
    private b j;
    private MBSplashShowListener k;
    private d l;
    private MBSplashView m;
    private MBSplashWebview n;
    private ViewGroup o;
    private View p;
    private f q;
    private boolean r;
    private ViewGroup s;
    private e t;
    private boolean u;
    private int f = 5;
    private int v = 1;
    private int w = w.l(com.mbridge.msdk.foundation.controller.b.d().g());
    private int x = w.m(com.mbridge.msdk.foundation.controller.b.d().g());
    private Object y = new Object();
    private Object z = new Object();
    public boolean a = false;
    private boolean D = false;

    public final void a(ViewGroup viewGroup) {
        this.s = viewGroup;
    }

    public final boolean a() {
        return this.r;
    }

    public final void a(boolean z) {
        this.r = z;
    }

    public final void a(int i) {
        this.v = i;
    }

    public c(String str, String str2) {
        this.d = str;
        this.c = str2;
        this.e = new MBridgeIds(str, str2);
        if (this.i == null) {
            this.i = new com.mbridge.msdk.splash.c.d(com.mbridge.msdk.foundation.controller.b.d().g(), this.d, this.c);
        }
        if (this.n == null) {
            try {
                this.n = new MBSplashWebview(com.mbridge.msdk.foundation.controller.b.d().g());
            } catch (Exception unused) {
            }
            MBSplashWebview mBSplashWebview = this.n;
            if (mBSplashWebview != null) {
                mBSplashWebview.setWebViewClient(new com.mbridge.msdk.splash.view.a(this.c, this.i.a()));
            }
        }
        if (this.m == null) {
            MBSplashView mBSplashView = new MBSplashView(com.mbridge.msdk.foundation.controller.b.d().g());
            this.m = mBSplashView;
            mBSplashView.setSplashWebview(this.n);
        }
        if (this.t == null) {
            this.t = new e();
        }
        this.t.a(com.mbridge.msdk.foundation.controller.b.d().g(), com.mbridge.msdk.foundation.controller.b.d().h(), com.mbridge.msdk.foundation.controller.b.d().j(), this.c);
    }

    public final void a(long j) {
        this.g = j;
    }

    public final long b() {
        return this.g;
    }

    public final boolean c() {
        return this.u;
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        if (this.j == null) {
            this.j = new b(this, this.e);
        }
        this.j.a(mBSplashLoadListener);
    }

    public final void a(MBSplashShowListener mBSplashShowListener) {
        this.k = mBSplashShowListener;
    }

    public final void a(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            b bVar = this.j;
            if (bVar != null) {
                bVar.a("token is null or empty", 1);
                return;
            }
            return;
        }
        a(str, 1);
    }

    public final void b(String str) throws Throwable {
        a(str, 1);
    }

    public final void a(String str, Activity activity) throws Throwable {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA == null) {
            b bVar = this.j;
            if (bVar != null) {
                bVar.a("activity is except,please check it", 1);
                return;
            }
            return;
        }
        a(str, viewGroupA);
    }

    public final void a(String str, ViewGroup viewGroup) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            b bVar = this.j;
            if (bVar != null) {
                bVar.a("token is null or empty", 1);
                return;
            }
            return;
        }
        b(str, viewGroup);
    }

    public final void b(String str, Activity activity) throws Throwable {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA == null) {
            b bVar = this.j;
            if (bVar != null) {
                bVar.a("activity is except,please check it", 1);
                return;
            }
            return;
        }
        b(str, viewGroupA);
    }

    public final void b(String str, ViewGroup viewGroup) throws Throwable {
        this.o = viewGroup;
        MBSplashView mBSplashView = this.m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        a(str, 2);
    }

    public final boolean c(String str) {
        return com.mbridge.msdk.splash.c.b.a(this.m, this.d, this.c, str, this.u, this.f, false, true) != null;
    }

    public final void b(boolean z) {
        this.u = z;
    }

    public final void b(int i) {
        this.f = i;
    }

    public final int d() {
        return this.f;
    }

    public final void a(int i, int i2) {
        b(i2, i);
    }

    public final String e() {
        if (!this.a) {
            com.mbridge.msdk.splash.c.c cVar = this.h;
            return cVar != null ? cVar.a() : "";
        }
        com.mbridge.msdk.splash.c.d dVar = this.i;
        return dVar != null ? dVar.b() : "";
    }

    public final void c(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA == null) {
            MBSplashShowListener mBSplashShowListener = this.k;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.e, "activity is except,please check it");
                return;
            }
            return;
        }
        c(str, viewGroupA);
    }

    public final void c(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            MBSplashShowListener mBSplashShowListener = this.k;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.e, "token is null or empty");
                return;
            }
            return;
        }
        d(str, viewGroup);
    }

    public final void d(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA == null) {
            MBSplashShowListener mBSplashShowListener = this.k;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.e, "activity is except,please check it");
                return;
            }
            return;
        }
        d(str, viewGroupA);
    }

    public final void d(String str, ViewGroup viewGroup) {
        this.o = viewGroup;
        MBSplashView mBSplashView = this.m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        CampaignEx campaignExA = com.mbridge.msdk.splash.c.b.a(this.m, this.d, this.c, str, this.u, this.f, true, false);
        if (campaignExA != null) {
            if (this.q == null) {
                this.q = com.mbridge.msdk.c.d.a().c(com.mbridge.msdk.foundation.controller.b.d().h(), this.c);
            }
            d dVar = new d(this, this.k, campaignExA);
            this.l = dVar;
            if (this.w == 0 || this.x == 0) {
                if (dVar != null) {
                    dVar.a(this.e, "width or height is 0  or width or height is too small");
                    return;
                }
                return;
            }
            int i = this.f;
            if (i >= 2 && i <= 10) {
                a(campaignExA, this.q.o(), false);
                return;
            } else {
                if (dVar != null) {
                    dVar.a(this.e, "countDownTime must in 2 - 10 ,but now is " + this.f);
                    return;
                }
                return;
            }
        }
        MBSplashShowListener mBSplashShowListener = this.k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.e, "campaignEx is vali");
        }
    }

    final void a(CampaignEx campaignEx, int i, boolean z) {
        if (campaignEx != null && z) {
            if (this.q == null) {
                this.q = com.mbridge.msdk.c.d.a().c(com.mbridge.msdk.foundation.controller.b.d().h(), this.c);
            }
            this.l = new d(this, this.k, campaignEx);
        }
        if (this.o == null) {
            d dVar = this.l;
            if (dVar != null) {
                dVar.a(this.e, "container is null");
                return;
            }
            return;
        }
        if (this.i == null) {
            this.i = new com.mbridge.msdk.splash.c.d(this.o.getContext(), this.d, this.c);
        }
        this.B = campaignEx;
        b(campaignEx, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final CampaignEx campaignEx, final int i, final boolean z) {
        if (!com.mbridge.msdk.splash.c.b.a(this.m, campaignEx)) {
            if (i > 0) {
                this.i.a.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.b(campaignEx, i - 1, z);
                    }
                }, 1L);
                return;
            }
            d dVar = this.l;
            if (dVar != null) {
                dVar.a(this.e, "campaignEx is not ready");
                return;
            }
            return;
        }
        d(true);
        ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.o.setLayoutParams(layoutParams);
        this.o.removeAllViews();
        this.i.a(this.f);
        this.i.a(this.s);
        this.i.a(this.l);
        aa.d(f2441b, "start show process");
        ViewGroup viewGroup = this.o;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            ao.a(this.m);
            this.o.addView(this.m);
        }
        this.i.a(this.u);
        this.i.a(campaignEx, this.m);
    }

    private void a(String str, int i) throws Throwable {
        synchronized (this.y) {
            if (this.r) {
                b bVar = this.j;
                if (bVar != null) {
                    bVar.a("current unit is loading", i);
                    this.r = true;
                }
                return;
            }
            this.r = true;
            int i2 = this.f;
            if (i2 < 2 || i2 > 10) {
                b bVar2 = this.j;
                if (bVar2 != null) {
                    bVar2.a("countDownTime must in 2 - 10 ,but now is " + this.f, i);
                    return;
                }
                return;
            }
            if (this.w == 0 || this.x == 0) {
                b bVar3 = this.j;
                if (bVar3 != null) {
                    bVar3.a("width or height is 0  or width or height is too small", i);
                    return;
                }
                return;
            }
            boolean zA = false;
            try {
                zA = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.b.d().g());
            } catch (Exception unused) {
            }
            if (!zA) {
                b bVar4 = this.j;
                if (bVar4 != null) {
                    bVar4.a("WebView is not available", i);
                    return;
                }
                return;
            }
            this.m.clearResState();
            this.q = com.mbridge.msdk.c.d.a().c(com.mbridge.msdk.foundation.controller.b.d().h(), this.c);
            if (this.h == null) {
                this.h = new com.mbridge.msdk.splash.c.c(this.d, this.c, this.g * 1000);
            }
            b bVar5 = this.j;
            if (bVar5 != null) {
                bVar5.a(str);
                this.h.a(this.j);
            }
            this.m.resetLoadState();
            this.h.a(this.f);
            this.h.a(this.m);
            this.h.a(this.q);
            this.h.a(this.w, this.x);
            this.h.a(this.u);
            this.h.b(this.v);
            this.h.a(str, i);
        }
    }

    public final void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.p = view;
        if (view != null) {
            b(layoutParams.width, layoutParams.height);
            MBSplashView mBSplashView = this.m;
            if (mBSplashView != null) {
                mBSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    private void b(int i, int i2) {
        int iL = w.l(com.mbridge.msdk.foundation.controller.b.d().g());
        int iM = w.m(com.mbridge.msdk.foundation.controller.b.d().g());
        int i3 = this.v;
        if (i3 == 1) {
            if (iM >= i2 * 4) {
                this.x = iM - i2;
                this.w = iL;
                return;
            } else {
                this.x = 0;
                this.w = 0;
                return;
            }
        }
        if (i3 == 2) {
            if (iL >= i * 4) {
                this.w = iL - i;
                this.x = iM;
            } else {
                this.x = 0;
                this.w = 0;
            }
        }
    }

    public final void c(boolean z) {
        this.A = z;
    }

    public final ViewGroup a(ZoomOutTypeEnum zoomOutTypeEnum) {
        MBSplashPopView mBSplashPopView = new MBSplashPopView(com.mbridge.msdk.foundation.controller.b.d().g(), new MBSplashPopView.a(this.d, this.c, zoomOutTypeEnum.getIndex(), this.B), this.l);
        this.C = mBSplashPopView;
        return mBSplashPopView;
    }

    public final void f() {
        this.D = true;
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null) {
            mBSplashPopView.startCountDown();
        }
    }

    public final void g() {
        this.D = false;
        MBSplashShowListener mBSplashShowListener = this.k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayFinish(new MBridgeIds(this.d, this.c));
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null) {
            mBSplashPopView.release();
        }
    }

    public final void h() {
        com.mbridge.msdk.splash.c.d dVar = this.i;
        if (dVar != null) {
            dVar.d();
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView == null || !this.D) {
            return;
        }
        mBSplashPopView.reStartCountDown();
    }

    public final void d(final boolean z) {
        MBSplashWebview mBSplashWebview = this.n;
        if (mBSplashWebview != null) {
            mBSplashWebview.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.d.c.2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z;
                }
            });
        }
        MBSplashView mBSplashView = this.m;
        if (mBSplashView != null) {
            mBSplashView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.d.c.3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z;
                }
            });
        }
    }

    private ViewGroup a(Activity activity) {
        Throwable th;
        ViewGroup viewGroup;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (activity == null) {
            aa.c(f2441b, "splash can't show because, activity is null or activity is finishing");
            return null;
        }
        try {
            viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
            try {
                try {
                    return (ViewGroup) viewGroup.getChildAt(0);
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    return viewGroup;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return viewGroup;
            }
        } catch (Throwable th3) {
            th = th3;
            viewGroup = null;
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            MBSplashView mBSplashView = this.m;
            if (mBSplashView != null) {
                mBSplashView.setNotchPadding(i, i2, i3, i4);
            }
            if (this.n != null) {
                g.a().a((WebView) this.n, "oncutoutfetched", Base64.encodeToString(o.a(-999, i, i2, i3, i4).getBytes(), 0));
            }
        } catch (Throwable th) {
            aa.d(f2441b, th.getMessage());
        }
    }

    public final void i() {
        com.mbridge.msdk.splash.c.d dVar = this.i;
        if (dVar != null) {
            dVar.e();
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView == null || !this.D) {
            return;
        }
        mBSplashPopView.pauseCountDown();
    }

    public final void j() {
        this.B = null;
        if (this.k != null) {
            this.k = null;
        }
        if (this.j != null) {
            this.j = null;
        }
        if (this.l != null) {
            this.l = null;
        }
        com.mbridge.msdk.splash.c.c cVar = this.h;
        if (cVar != null) {
            cVar.b();
        }
        com.mbridge.msdk.splash.c.d dVar = this.i;
        if (dVar != null) {
            dVar.c();
        }
    }
}
