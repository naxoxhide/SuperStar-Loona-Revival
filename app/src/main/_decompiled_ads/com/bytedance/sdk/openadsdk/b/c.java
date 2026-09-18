package com.bytedance.sdk.openadsdk.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.view.ButtonFlash;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenBaseLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenHtmlLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenOneLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenThreeLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenTwoLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.n;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.i;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: AppOpenAdNativeManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static String w = "Skip";
    protected final Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final q f437b;
    protected final boolean c;
    protected final FrameLayout d;
    protected final com.bytedance.sdk.openadsdk.b.a e;
    protected final int f;
    protected int g;
    private RelativeLayout h;
    protected FrameLayout i;
    private ImageView j;
    private TextView k;
    private ButtonFlash l;
    private ImageView m;
    private float n;
    private float o;
    private TextView q;
    private TextView r;
    protected final com.bytedance.sdk.openadsdk.b.p.a s;
    private boolean u;
    private com.bytedance.sdk.openadsdk.b.p.c v;
    private final com.bytedance.sdk.openadsdk.component.view.a p = new com.bytedance.sdk.openadsdk.component.view.a();
    private boolean t = false;

    /* JADX INFO: compiled from: AppOpenAdNativeManager.java */
    class a implements PAGAppOpenHtmlLayout.b {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.component.view.PAGAppOpenHtmlLayout.b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.component.view.PAGAppOpenHtmlLayout.b
        public void a(View view, int i) {
            c.this.e.b();
        }

        @Override // com.bytedance.sdk.openadsdk.component.view.PAGAppOpenHtmlLayout.b
        public void b() {
        }
    }

    /* JADX INFO: compiled from: AppOpenAdNativeManager.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                c cVar = c.this;
                TTWebsiteActivity.a(cVar.a, cVar.f437b, "open_ad");
            } catch (Throwable th) {
                m.b("AppOpenAdNativeManager", th.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppOpenAdNativeManager.java */
    class ViewOnClickListenerC0174c implements View.OnClickListener {
        ViewOnClickListenerC0174c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.bytedance.sdk.openadsdk.b.a aVar = c.this.e;
            if (aVar != null) {
                aVar.b(view);
            }
        }
    }

    /* JADX INFO: compiled from: AppOpenAdNativeManager.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            if (cVar.e == null || !cVar.t) {
                return;
            }
            c.this.e.a(view);
        }
    }

    /* JADX INFO: compiled from: AppOpenAdNativeManager.java */
    class e implements com.bytedance.sdk.openadsdk.core.c0.b.a {
        e() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b.a
        public void a(View view, int i) {
            c.this.e.b();
        }
    }

    /* JADX INFO: compiled from: AppOpenAdNativeManager.java */
    class f implements i.b {
        f() {
        }

        @Override // com.bytedance.sdk.openadsdk.utils.i.b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.utils.i.b
        public void a(com.bytedance.sdk.openadsdk.n.d.b bVar) {
            if (bVar.b()) {
                c.this.a(bVar);
                if (bVar.d() != null) {
                    c.this.a(bVar.c());
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.utils.i.b
        public void b() {
        }
    }

    /* JADX INFO: compiled from: AppOpenAdNativeManager.java */
    public class g implements com.bytedance.sdk.openadsdk.b.f.l {
        WeakReference<Activity> a;

        g(Activity activity) {
            this.a = new WeakReference<>(activity);
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.l
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.l
        public void a(Bitmap bitmap) {
            if (this.a.get() == null || this.a.get().isFinishing()) {
                return;
            }
            c.this.a(bitmap);
        }
    }

    public c(Activity activity, q qVar, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.b.a aVar, int i, boolean z, com.bytedance.sdk.openadsdk.b.p.a aVar2) {
        this.a = activity;
        this.f437b = qVar;
        this.d = frameLayout;
        this.g = i;
        this.c = z;
        this.e = aVar;
        this.f = qVar.S();
        this.s = aVar2;
    }

    private void f() {
        this.p.a();
        this.l.setText(this.f437b.r());
        if (!this.c) {
            b(8);
            a(0);
            a();
            this.e.e();
            return;
        }
        b(0);
        a(8);
        if (a(this.i)) {
            this.e.e();
        } else {
            this.e.d();
        }
        com.bytedance.sdk.openadsdk.b.f.a(this.f437b, new g(this.a), 25);
    }

    public void b() {
        this.k.setOnClickListener(new b());
        this.q.setOnClickListener(new ViewOnClickListenerC0174c());
        this.r.setOnClickListener(new d());
        if (this.f437b.V0()) {
            return;
        }
        com.bytedance.sdk.openadsdk.b.h.a aVarA = com.bytedance.sdk.openadsdk.b.h.b.a(this.f437b, this.a, this.s);
        aVarA.a(new e());
        aVarA.a(this.v);
        if (this.f437b.k() == 1) {
            this.h.setOnClickListener(aVarA);
            this.h.setOnTouchListener(aVarA);
        }
        this.l.setOnClickListener(aVarA);
        this.l.setOnTouchListener(aVarA);
    }

    public com.bytedance.sdk.openadsdk.b.p.c c() {
        return this.v;
    }

    public int d() {
        return -1;
    }

    public void e() {
        ButtonFlash buttonFlash = this.l;
        if (buttonFlash != null) {
            buttonFlash.c();
        }
        com.bytedance.sdk.openadsdk.b.p.c cVar = this.v;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void g() {
        this.u = n.j0().q(String.valueOf(this.f));
        if (this.f437b.V0()) {
            this.e.e();
        } else {
            f();
        }
    }

    public void a(ViewGroup viewGroup) {
        try {
            w = t.k(o.a(), "tt_txt_skip");
        } catch (Throwable th) {
            m.b("AppOpenAdNativeManager", th.getMessage());
        }
        PAGAppOpenBaseLayout pAGAppOpenTwoLayout = new PAGAppOpenTwoLayout(this.a);
        int iM = this.f437b.m();
        m.a("AppOpenAdNativeManager", "attachExpressView: splashLayoutId=" + iM);
        if (iM == 1) {
            pAGAppOpenTwoLayout = new PAGAppOpenOneLayout(this.a);
        } else if (iM == 3) {
            pAGAppOpenTwoLayout = new PAGAppOpenThreeLayout(this.a);
        } else if (iM == 4) {
            pAGAppOpenTwoLayout = new PAGAppOpenHtmlLayout(this.a, this.f437b);
        }
        if (this.f437b.m() == 3 && this.g != 2) {
            this.g = 2;
            this.e.c();
        }
        this.h = pAGAppOpenTwoLayout;
        viewGroup.addView(pAGAppOpenTwoLayout);
        this.m = pAGAppOpenTwoLayout.getBackImage();
        this.i = pAGAppOpenTwoLayout.getVideoContainer();
        this.j = pAGAppOpenTwoLayout.getImageView();
        this.l = pAGAppOpenTwoLayout.getClickButton();
        this.k = pAGAppOpenTwoLayout.getAdLogo();
        if (pAGAppOpenTwoLayout.getDspAdChoice() != null) {
            pAGAppOpenTwoLayout.getDspAdChoice().a(14, this.f437b);
        }
        if (!this.f437b.V0()) {
            this.p.a(pAGAppOpenTwoLayout, this.f437b, this.o, this.n, this.c);
        }
        this.q = pAGAppOpenTwoLayout.getTopDisLike();
        this.r = pAGAppOpenTwoLayout.getTopSkip();
        if (pAGAppOpenTwoLayout instanceof PAGAppOpenHtmlLayout) {
            ((PAGAppOpenHtmlLayout) pAGAppOpenTwoLayout).setRenderListener(new a());
        }
    }

    protected boolean a(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.b.p.c cVar = new com.bytedance.sdk.openadsdk.b.p.c(this.a);
        this.v = cVar;
        cVar.a(frameLayout, this.f437b);
        this.v.a(this.e);
        try {
            return this.v.h();
        } catch (Throwable th) {
            m.b("AppOpenAdNativeManager", "open_ad", "ttAppOpenAd playVideo error: " + th.getMessage());
            return false;
        }
    }

    private void a() {
        com.bytedance.sdk.openadsdk.core.f0.n nVar = this.f437b.d0().get(0);
        i.a(new com.bytedance.sdk.openadsdk.n.a(nVar.d(), nVar.c()), nVar.e(), nVar.b(), new f(), com.bytedance.sdk.openadsdk.b.o.a.a(TextUtils.isEmpty(nVar.c()) ? com.bytedance.sdk.component.utils.e.a(nVar.d()) : nVar.c()).getParent(), 25);
    }

    private void b(int i) {
        b0.a((View) this.i, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.m.setImageDrawable(new BitmapDrawable(o.a().getResources(), bitmap));
            } catch (Throwable unused) {
                m.b("AppOpenAdNativeManager", "open_ad", "bindBackGroundImage error");
            }
        }
    }

    void a(com.bytedance.sdk.openadsdk.n.d.b bVar) {
        if (bVar.d() != null) {
            this.j.setImageBitmap(bVar.d());
            return;
        }
        if (this.f437b.d0() == null || this.f437b.d0().get(0) == null) {
            return;
        }
        Drawable drawableA = i.a(bVar.a(), this.f437b.d0().get(0).e());
        this.j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.j.setImageDrawable(drawableA);
    }

    void a(int i) {
        b0.a((View) this.j, i);
    }

    public void a(float f2, float f3) {
        this.o = f2;
        this.n = f3;
    }

    public void a(int i, int i2, boolean z) {
        if (this.r != null) {
            String strValueOf = String.valueOf(i);
            if (z) {
                this.t = z;
                if (this.u) {
                    strValueOf = w;
                } else {
                    strValueOf = ((Object) strValueOf) + " | " + w;
                }
            }
            this.r.setText(strValueOf);
        }
    }
}
