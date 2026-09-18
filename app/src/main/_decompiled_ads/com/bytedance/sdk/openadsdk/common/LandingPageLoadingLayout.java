package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.p;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class LandingPageLoadingLayout extends PAGFrameLayout {
    private e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f523b;
    private long c;
    private Runnable d;
    private Runnable e;
    View f;

    class a implements View.OnClickListener {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f524b;

        a(q qVar, String str) {
            this.a = qVar;
            this.f524b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(LandingPageLoadingLayout.this.getContext(), this.a, this.f524b);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LandingPageLoadingLayout.this.a != null) {
                LandingPageLoadingLayout.this.setVisibility(0);
                LandingPageLoadingLayout.this.a.d();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LandingPageLoadingLayout.this.n();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LandingPageLoadingLayout landingPageLoadingLayout = LandingPageLoadingLayout.this;
            landingPageLoadingLayout.f(landingPageLoadingLayout.f523b);
        }
    }

    public LandingPageLoadingLayout(Context context) {
        super(context);
        this.c = 10L;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(i);
        }
        if (i == 100) {
            n();
        }
    }

    private void m() {
        setBackgroundColor(-1);
        this.f = new PAGTextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b0.a(getContext(), 32.0f), b0.a(getContext(), 14.0f));
        this.f.setVisibility(8);
        this.f.setId(520093739);
        layoutParams.gravity = 8388691;
        layoutParams.leftMargin = b0.a(getContext(), 16.0f);
        layoutParams.bottomMargin = b0.a(getContext(), 16.0f);
        this.f.setBackgroundResource(t.e(getContext(), "tt_ad_logo_new"));
        addView(this.f, layoutParams);
        setVisibility(8);
    }

    public void e(int i) {
        if (i == 100 || i - this.f523b >= 7) {
            this.f523b = i;
            if (b.a.a.a.a.a.b.d.a.b()) {
                f(this.f523b);
                return;
            }
            if (this.e == null) {
                this.e = new d();
            }
            post(this.e);
        }
    }

    public void n() {
        this.f523b = 0;
        e eVar = this.a;
        if (eVar != null) {
            removeView(eVar.d);
            this.a.a();
        }
        setVisibility(8);
        this.a = null;
        Runnable runnable = this.d;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.e = null;
        this.d = null;
    }

    public void o() {
        post(new b());
        if (this.d == null) {
            this.d = new c();
        }
        postDelayed(this.d, this.c * 1000);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.d;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.d = null;
        }
    }

    public void a(q qVar, String str) {
        a(qVar, str, false);
    }

    public void a(q qVar, String str, boolean z) {
        int iG0;
        String str2;
        String[] strArr;
        n nVar;
        p pVar;
        n nVarB0 = null;
        if (qVar != null) {
            p pVarH0 = qVar.h0();
            if (pVarH0 != null) {
                this.c = pVarH0.b();
            }
            String strJ = qVar.j();
            String[] strArrJ0 = qVar.J0();
            iG0 = qVar.g0();
            if (qVar.b0() != null && !TextUtils.isEmpty(qVar.b0().d())) {
                nVarB0 = qVar.b0();
            }
            nVar = nVarB0;
            pVar = pVarH0;
            str2 = strJ;
            strArr = strArrJ0;
        } else {
            iG0 = 0;
            str2 = null;
            strArr = null;
            nVar = null;
            pVar = null;
        }
        if (iG0 == 1) {
            this.a = new com.bytedance.sdk.openadsdk.common.d(getContext(), str2, strArr, nVar, pVar);
        } else {
            this.a = new com.bytedance.sdk.openadsdk.common.c(getContext(), str2, strArr, nVar, pVar);
        }
        View viewB = this.a.b();
        if (viewB.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewB.getParent()).removeView(viewB);
        }
        addView(viewB);
        View view = this.f;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            }
            this.f.setOnClickListener(new a(qVar, str));
        }
    }
}
