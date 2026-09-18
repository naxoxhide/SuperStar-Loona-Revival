package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.b.m.p.k;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: RewardFullVideoLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Activity f547b;
    private final com.bytedance.sdk.openadsdk.b.m.p.a c;
    final q d;
    private final boolean e;
    private final String f;
    private int g;
    ImageView h;
    RelativeLayout i;
    FrameLayout j;
    View k;
    View l;
    TextView m;
    ImageView n;
    RelativeLayout o;
    k p;
    public o s;
    private boolean t;
    private RFDownloadBarLayout u;
    ProgressBar v;
    int a = 3;
    protected int q = 0;
    protected final AtomicBoolean r = new AtomicBoolean(false);
    Runnable w = new b();

    /* JADX INFO: compiled from: RewardFullVideoLayout.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m.d("mAdLogo", "mAdLogo,,,,,,,onClick,,,,,");
            try {
                e eVar = e.this;
                TTWebsiteActivity.a(eVar.f547b, eVar.d, eVar.f);
            } catch (Throwable th) {
                m.b("TTAD.RFullVideoLayout", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLayout.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RelativeLayout relativeLayout;
            try {
                q qVar = e.this.d;
                if ((qVar != null && qVar.X0()) || e.this.c.R == null || (relativeLayout = e.this.i) == null) {
                    return;
                }
                int[] iArr = new int[2];
                relativeLayout.getLocationOnScreen(iArr);
                e.this.c.R.a(iArr[0]);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLayout.java */
    class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            e.this.c.T.q();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public e(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.c = aVar;
        this.f547b = aVar.V;
        this.d = aVar.a;
        this.f = aVar.g;
        this.e = aVar.f;
    }

    private void h() {
        RelativeLayout relativeLayout;
        RFDownloadBarLayout rFDownloadBarLayout = (RFDownloadBarLayout) this.f547b.findViewById(h.l);
        this.u = rFDownloadBarLayout;
        rFDownloadBarLayout.a(this.c);
        this.m = (TextView) this.f547b.findViewById(520093757);
        this.n = (ImageView) this.f547b.findViewById(h.g1);
        this.h = (ImageView) this.f547b.findViewById(520093706);
        this.i = (RelativeLayout) this.f547b.findViewById(520093708);
        this.j = (FrameLayout) this.f547b.findViewById(h.k);
        this.k = this.f547b.findViewById(h.p);
        this.l = this.f547b.findViewById(h.q0);
        this.o = (RelativeLayout) this.f547b.findViewById(h.f1);
        k kVar = this.p;
        if (kVar == null || kVar.b() == null || (relativeLayout = this.o) == null) {
            return;
        }
        relativeLayout.addView(this.p.b(), new LinearLayout.LayoutParams(-1, -1));
        this.p.i();
    }

    public void c(int i) {
        b0.a((View) this.u, i);
    }

    public void d(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
        marginLayoutParams.setMargins(16, 0, 0, i);
        this.m.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
        marginLayoutParams2.setMargins(0, 0, 7, i);
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams2.setMarginStart(0);
            marginLayoutParams2.setMarginEnd(7);
        }
        this.n.setLayoutParams(marginLayoutParams2);
    }

    public FrameLayout e() {
        return this.j;
    }

    public void f() {
        if (this.t) {
            return;
        }
        this.t = true;
        this.g = this.c.j;
        if (i()) {
            k kVar = new k(this.c);
            this.p = kVar;
            kVar.c();
        }
        h();
        o oVar = new o(this.f547b, this.d, this.f, this.j);
        this.s = oVar;
        oVar.h();
    }

    void g() {
        int iO0 = this.d.o0();
        this.a = iO0;
        if (iO0 == -200) {
            this.a = com.bytedance.sdk.openadsdk.core.o.d().h(this.d.S() + "");
        }
        if (this.a != -1 || i() || (this.c.Y instanceof com.bytedance.sdk.openadsdk.b.m.q.c)) {
            return;
        }
        c(0);
    }

    protected boolean i() {
        return true;
    }

    public void j() {
        o oVar = this.s;
        if (oVar != null) {
            oVar.k();
        }
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.removeCallbacks(this.w);
        }
    }

    public void k() {
        o oVar = this.s;
        if (oVar != null) {
            oVar.m();
        }
    }

    public void l() {
        o oVar = this.s;
        if (oVar != null) {
            oVar.n();
        }
    }

    public void m() {
        o oVar = this.s;
        if (oVar != null) {
            oVar.o();
        }
    }

    protected void n() {
        RFDownloadBarLayout rFDownloadBarLayout = this.u;
        if (rFDownloadBarLayout == null) {
            return;
        }
        rFDownloadBarLayout.i();
    }

    public void o() {
        this.c.L.c().onClick(this.u);
    }

    public void p() {
        this.j.removeAllViews();
    }

    public void q() {
        try {
            k kVar = this.p;
            if (kVar != null) {
                kVar.a();
            }
            RelativeLayout relativeLayout = this.o;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable unused) {
            RelativeLayout relativeLayout2 = this.o;
            if (relativeLayout2 != null) {
                relativeLayout2.setAlpha(0.0f);
            }
        }
    }

    public void r() {
        if (this.n.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 11, 16);
            if (Build.VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(0);
                marginLayoutParams.setMarginEnd(11);
            }
            this.n.setLayoutParams(marginLayoutParams);
        }
    }

    public void s() {
        b0.a((View) this.j, 8);
        b0.a(this.k, 8);
        b0.a(this.l, 8);
        c(8);
        b0.a((View) this.h, 8);
        b0.a((View) this.i, 8);
        b0.a((View) this.m, 8);
        b0.a((View) this.o, 8);
        b0.a((View) this.n, 8);
    }

    public void a(boolean z) {
        int i = 8;
        b0.a((View) this.m, t.h(this.d) ? 8 : 0);
        ImageView imageView = this.n;
        if (this.d.k1() && this.d.d()) {
            i = 0;
        }
        b0.a((View) imageView, i);
        b(z);
        if (this.e) {
            g();
        }
    }

    void b(boolean z) {
        RelativeLayout relativeLayout;
        if (this.g != 1 && (relativeLayout = this.i) != null && z) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                int iA = a("status_bar_height");
                int iA2 = a("navigation_bar_height");
                if (iA > 0) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (iA > marginLayoutParams.topMargin) {
                        marginLayoutParams.topMargin = iA;
                        this.c.R.b(iA);
                    }
                }
                if (iA2 > 0) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (iA2 > marginLayoutParams2.rightMargin) {
                        marginLayoutParams2.rightMargin = iA2;
                    }
                }
            }
        }
        if (this.c.Y instanceof com.bytedance.sdk.openadsdk.b.m.q.c) {
            return;
        }
        c(0);
    }

    public boolean c() {
        ImageView imageView = this.h;
        return imageView != null && this.i != null && imageView.getVisibility() == 0 && this.i.getVisibility() == 0;
    }

    public void e(int i) {
        b0.a((View) this.m, i);
    }

    public void a(int i) {
        if (this.v == null) {
            this.v = new PAGProgressBar(this.c.V);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.v.setLayoutParams(layoutParams);
            this.v.setIndeterminateDrawable(this.c.V.getResources().getDrawable(com.bytedance.sdk.component.utils.t.e(this.c.V, "tt_video_loading_progress_bar")));
            this.c.T.e().addView(this.v);
        }
        this.v.setVisibility(i);
    }

    public View d() {
        return this.u;
    }

    public void f(int i) {
        int i2 = this.a;
        if (i2 == -1 || i != i2 || this.r.get()) {
            return;
        }
        c(0);
        this.r.set(true);
        n();
    }

    public void a(int i, int i2) {
        FrameLayout frameLayout;
        if (this.d.p0() == 1 && (frameLayout = this.j) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int i3 = b0.i(this.f547b);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = i3;
            int i4 = (i3 * 9) / 16;
            layoutParams.height = i4;
            this.j.setLayoutParams(layoutParams);
            this.q = (b0.g(this.f547b) - i4) / 2;
            m.b("TTAD.RFullVideoLayout", "NonContentAreaHeight:" + this.q);
        }
    }

    public void b(int i) {
        RelativeLayout relativeLayout;
        b0.a((View) this.h, i);
        b0.a((View) this.i, i);
        if (b.b.a.a.d.g.b.a(this.c.W) || (relativeLayout = this.i) == null) {
            return;
        }
        relativeLayout.post(this.w);
    }

    public View b() {
        return this.i;
    }

    public void a(com.bytedance.sdk.openadsdk.core.c0.c cVar, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        View view;
        View view2;
        q qVar;
        if (this.j != null && (qVar = this.d) != null && qVar.s() != null) {
            if (this.d.s().f && !o.f(this.d)) {
                a((View.OnClickListener) cVar);
                a(cVar);
            } else {
                a(onClickListener);
            }
        }
        q qVar2 = this.d;
        if (qVar2 != null && qVar2.p0() == 1) {
            if (this.d.s() != null && (view2 = this.k) != null) {
                b0.a(view2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams.height = this.q;
                this.k.setLayoutParams(layoutParams);
                if (this.d.s().f577b) {
                    this.k.setOnClickListener(cVar);
                    this.k.setOnTouchListener(onTouchListener);
                } else {
                    this.k.setOnClickListener(onClickListener);
                }
            }
            if (this.d.s() != null && (view = this.l) != null) {
                b0.a(view, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams2.height = this.q;
                this.l.setLayoutParams(layoutParams2);
                if (this.d.s().d) {
                    this.l.setOnClickListener(cVar);
                    this.l.setOnTouchListener(onTouchListener);
                } else {
                    this.l.setOnClickListener(onClickListener);
                }
            }
        }
        TextView textView = this.m;
        if (textView != null) {
            textView.setOnClickListener(new a());
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setClickable(true);
            com.bytedance.sdk.openadsdk.n.c.b().a((int) b0.a(com.bytedance.sdk.openadsdk.core.o.a(), 14.0f, true), this.n, this.c.a);
        }
    }

    private int a(String str) {
        Resources resources = this.f547b.getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier(str, "dimen", "android"));
        }
        return 0;
    }

    public void a(View.OnClickListener onClickListener) {
        b0.a(this.j, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    private void a(com.bytedance.sdk.openadsdk.core.c0.c cVar) {
        b0.a((View) this.j, (View.OnTouchListener) cVar, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    public void a(float f) {
        b0.a(this.h, f);
        b0.a(this.i, f);
    }

    public void a(Animation animation) {
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.startAnimation(animation);
        }
    }

    public void a() {
        try {
            TTBaseVideoActivity tTBaseVideoActivity = this.c.V;
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(tTBaseVideoActivity, com.bytedance.sdk.component.utils.t.a(tTBaseVideoActivity, "tt_fade_out"));
            if (animationLoadAnimation != null) {
                animationLoadAnimation.setAnimationListener(new c());
                this.c.T.a(animationLoadAnimation);
            } else {
                this.c.T.q();
            }
        } catch (Throwable unused) {
            this.c.T.q();
        }
    }
}
