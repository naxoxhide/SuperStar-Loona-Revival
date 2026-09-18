package com.mbridge.msdk.advanced.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.advanced.view.MBOutNativeAdvancedViewGroup;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAdvancedProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1890b = "NativeAdvancedProvider";
    private MBOutNativeAdvancedViewGroup B;
    private boolean C;
    private boolean D;
    private boolean E;
    private String c;
    private String d;
    private MBridgeIds e;
    private com.mbridge.msdk.advanced.a.a f;
    private com.mbridge.msdk.advanced.a.b g;
    private b h;
    private NativeAdvancedAdListener i;
    private d j;
    private MBNativeAdvancedView k;
    private MBNativeAdvancedWebview l;
    private com.mbridge.msdk.advanced.view.a m;
    private f n;
    private boolean o;
    private e p;
    private JSONObject z;
    public boolean a = false;
    private int q = -1;
    private boolean r = false;
    private int s = 0;
    private boolean t = false;
    private int u = 0;
    private boolean v = false;
    private int w = 0;
    private int x = 0;
    private Object y = new Object();
    private boolean A = false;
    private boolean F = true;
    private ViewTreeObserver.OnScrollChangedListener G = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.mbridge.msdk.advanced.b.c.1
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (c.this.F) {
                c.this.F = false;
                if (c.this.B != null) {
                    c.this.B.postDelayed(new Runnable() { // from class: com.mbridge.msdk.advanced.b.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.F = true;
                        }
                    }, 1000L);
                }
                try {
                    c.this.g();
                } catch (Exception unused) {
                }
            }
        }
    };

    public final boolean a() {
        return this.o;
    }

    public final void a(boolean z) {
        this.o = z;
    }

    public final MBOutNativeAdvancedViewGroup b() {
        return this.B;
    }

    public c(String str, String str2, Activity activity) {
        com.mbridge.msdk.advanced.view.a aVar;
        ViewGroup.LayoutParams layoutParams;
        Context context;
        this.d = str;
        this.c = str2;
        this.e = new MBridgeIds(str, str2);
        if (this.g == null) {
            com.mbridge.msdk.advanced.a.b bVar = new com.mbridge.msdk.advanced.a.b(com.mbridge.msdk.foundation.controller.b.d().g(), this.d, this.c);
            this.g = bVar;
            bVar.a(this);
        }
        if (this.l == null) {
            try {
                this.l = new MBNativeAdvancedWebview(com.mbridge.msdk.foundation.controller.b.d().g());
            } catch (Exception unused) {
            }
            if (this.m == null) {
                try {
                    this.m = new com.mbridge.msdk.advanced.view.a(this.c, this.g.b(), this);
                } catch (Exception unused2) {
                }
            }
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview != null && (aVar = this.m) != null) {
                mBNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.k == null) {
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (activity == null) {
                context = activity;
                context = contextG;
            }
            context = activity;
            MBNativeAdvancedView mBNativeAdvancedView = new MBNativeAdvancedView(context);
            this.k = mBNativeAdvancedView;
            mBNativeAdvancedView.setAdvancedNativeWebview(this.l);
            MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.l;
            if (mBNativeAdvancedWebview2 != null && mBNativeAdvancedWebview2.getParent() == null) {
                this.k.addView(this.l, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.B == null) {
            this.B = new MBOutNativeAdvancedViewGroup(com.mbridge.msdk.foundation.controller.b.d().g());
            if (this.w == 0 || this.x == 0) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            } else {
                layoutParams = new ViewGroup.LayoutParams(this.w, this.x);
            }
            this.B.setLayoutParams(layoutParams);
            this.B.setProvider(this);
            this.B.addView(this.k);
            this.B.getViewTreeObserver().addOnScrollChangedListener(this.G);
        }
        if (this.p == null) {
            this.p = new e();
        }
        this.p.a(com.mbridge.msdk.foundation.controller.b.d().g(), com.mbridge.msdk.foundation.controller.b.d().h(), com.mbridge.msdk.foundation.controller.b.d().j(), this.c);
    }

    public final void a(JSONObject jSONObject) {
        this.A = true;
        b(jSONObject);
    }

    private void b(JSONObject jSONObject) {
        if (this.A) {
            this.z = jSONObject;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.js.a.a(this.l, "setStyleList", "", jSONObject);
        }
    }

    private void f(int i) {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
        if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
            return;
        }
        try {
            if (this.l != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i);
                g.a().a((WebView) this.l, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            aa.a(f1890b, th.getMessage());
        }
    }

    public final int c() {
        return this.q;
    }

    public final void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.i = nativeAdvancedAdListener;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            NativeAdvancedAdListener nativeAdvancedAdListener = this.i;
            if (nativeAdvancedAdListener != null) {
                nativeAdvancedAdListener.onLoadFailed(this.e, "bid  token is null or empty");
                return;
            }
            return;
        }
        b(str);
    }

    public final void b(String str) {
        b bVar = new b(this, this.e);
        this.h = bVar;
        bVar.a(this.i);
        this.h.a(str);
        a(str, 2);
    }

    public final boolean c(String str) {
        return (this.B == null || com.mbridge.msdk.advanced.a.c.a(this.k, this.d, this.c, str, this.q, false, true) == null) ? false : true;
    }

    public final void a(int i) {
        this.r = true;
        g(i);
    }

    private void g(int i) {
        if (this.r) {
            this.q = i;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            int i2 = this.q;
            if (i2 == 1) {
                this.g.a(true);
                com.mbridge.msdk.advanced.js.a.a(this.l, "showCloseButton", "", null);
            } else if (i2 == 0) {
                this.g.a(false);
                com.mbridge.msdk.advanced.js.a.a(this.l, "hideCloseButton", "", null);
            }
        }
    }

    public final void b(int i) {
        this.t = true;
        h(i);
    }

    private void h(int i) {
        if (this.t) {
            this.s = i;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.js.a.a(this.l, "setVolume", CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i));
        }
    }

    public final void c(int i) {
        this.v = true;
        i(i);
    }

    private void i(int i) {
        if (this.v) {
            this.u = i;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.js.a.a(this.l, "setVideoPlayMode", "autoPlay", Integer.valueOf(i));
        }
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (this.n == null) {
                this.n = com.mbridge.msdk.c.d.a().d(com.mbridge.msdk.foundation.controller.b.d().h(), this.c);
            }
            d dVar = new d(this, this.i, campaignEx);
            this.j = dVar;
            if (this.w != 0 && this.x != 0) {
                a(campaignEx, false);
            } else if (dVar != null) {
                dVar.a(this.e, "width or height is 0  or width or height is too small");
            }
        }
    }

    final void a(CampaignEx campaignEx, boolean z) {
        f();
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.B;
        if (mBOutNativeAdvancedViewGroup == null || mBOutNativeAdvancedViewGroup.getParent() == null) {
            return;
        }
        if (campaignEx != null && z) {
            if (this.n == null) {
                this.n = com.mbridge.msdk.c.d.a().d(com.mbridge.msdk.foundation.controller.b.d().h(), this.c);
            }
            this.j = new d(this, this.i, campaignEx);
        }
        if (this.g == null) {
            com.mbridge.msdk.advanced.a.b bVar = new com.mbridge.msdk.advanced.a.b(com.mbridge.msdk.foundation.controller.b.d().g(), this.d, this.c);
            this.g = bVar;
            bVar.a(this);
        }
        b(campaignEx);
    }

    public final String d() {
        if (this.a) {
            com.mbridge.msdk.advanced.a.b bVar = this.g;
            return bVar != null ? bVar.a() : "";
        }
        com.mbridge.msdk.advanced.a.a aVar = this.f;
        return aVar != null ? aVar.a() : "";
    }

    private void b(CampaignEx campaignEx) {
        if (com.mbridge.msdk.advanced.a.c.a(this.k, campaignEx, this.d, this.c)) {
            this.g.a(this.j);
            this.g.a(campaignEx, this.k, true);
        }
    }

    private void f() {
        g(this.q);
        h(this.s);
        i(this.u);
        b(this.z);
        f(w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
    }

    private void a(String str, int i) {
        this.F = true;
        synchronized (this.y) {
            if (this.o) {
                if (this.h != null) {
                    this.h.a(new com.mbridge.msdk.foundation.entity.e(16, "current unit is loading"), i);
                    this.o = true;
                }
                return;
            }
            this.o = true;
            boolean zA = false;
            if (this.w == 0 || this.x == 0) {
                if (this.h != null) {
                    this.h.a(new com.mbridge.msdk.foundation.entity.e(0, "width or height is 0  or width or height is too small"), i);
                    return;
                }
                return;
            }
            if (this.k == null) {
                if (this.h != null) {
                    this.h.a(new com.mbridge.msdk.foundation.entity.e(1, "view is not ready"), i);
                    return;
                }
                return;
            }
            try {
                zA = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.b.d().g());
            } catch (Exception unused) {
            }
            if (!zA) {
                if (this.h != null) {
                    this.h.a(new com.mbridge.msdk.foundation.entity.e(1, "WebView is not available"), i);
                    return;
                }
                return;
            }
            this.k.clearResStateAndRemoveClose();
            f fVarF = com.mbridge.msdk.c.d.a().f(com.mbridge.msdk.foundation.controller.b.d().h(), this.c);
            this.n = fVarF;
            if (fVarF == null) {
                this.n = f.c(this.c);
            }
            if (this.f == null) {
                this.f = new com.mbridge.msdk.advanced.a.a(this.d, this.c, 0L);
            }
            b bVar = this.h;
            if (bVar != null) {
                bVar.a(str);
                this.f.a(this.h);
            }
            this.k.resetLoadState();
            this.f.a(this.k);
            this.f.a(this.n);
            this.f.a(this.w, this.x);
            this.f.a(this.q);
            this.f.a(str, i);
        }
    }

    public final String d(String str) {
        com.mbridge.msdk.advanced.a.a aVar = this.f;
        return aVar != null ? aVar.a(str) : "";
    }

    public final void d(int i) {
        if (i == 1) {
            this.C = true;
        } else if (i == 2) {
            this.D = true;
        } else if (i == 3) {
            this.E = true;
        }
        try {
            g();
        } catch (Exception unused) {
        }
    }

    public final void e(int i) {
        if (i == 1) {
            this.C = false;
        } else if (i == 2) {
            this.D = false;
        } else if (i == 3) {
            this.E = false;
        }
        com.mbridge.msdk.advanced.a.b bVar = this.g;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.C && this.D && this.E) {
            CampaignEx campaignExA = com.mbridge.msdk.advanced.a.c.a(this.k, this.d, this.c, "", this.q, true, true);
            if (campaignExA != null) {
                campaignExA.getImpReportType();
            }
            if (an.a(this.k.getAdvancedNativeWebview(), 0) || this.B.getAlpha() < 0.5f || this.B.getVisibility() != 0) {
                return;
            }
            com.mbridge.msdk.advanced.a.b bVar = this.g;
            if (bVar != null) {
                bVar.d();
            }
            a(campaignExA);
        }
    }

    public final void e() {
        if (this.i != null) {
            this.i = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.j != null) {
            this.j = null;
        }
        com.mbridge.msdk.advanced.a.a aVar = this.f;
        if (aVar != null) {
            aVar.a((MBNativeAdvancedView) null);
            this.f.b();
        }
        com.mbridge.msdk.advanced.a.b bVar = this.g;
        if (bVar != null) {
            bVar.c();
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.k;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        com.mbridge.msdk.advanced.common.b.b(this.d + this.c + d());
        com.mbridge.msdk.advanced.view.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a();
        }
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.B;
        if (mBOutNativeAdvancedViewGroup != null) {
            mBOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.G);
            this.B.removeAllViews();
            this.B = null;
        }
    }

    public final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.x = i;
        this.w = i2;
        this.B.setLayoutParams(new ViewGroup.LayoutParams(i2, i));
    }
}
