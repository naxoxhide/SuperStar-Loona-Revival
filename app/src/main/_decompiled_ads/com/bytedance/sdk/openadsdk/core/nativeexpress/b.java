package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: BrandBannerController.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0211b f651b;
    private b.b.a.a.d.f.o c;
    private NativeExpressView d;
    q e;
    private int f;
    private int g;
    private ScheduledFuture<?> h;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BrandBannerController.java */
    public static class C0211b implements b.b.a.a.d.f.d<View>, DspHtmlWebView.e {
        private com.bytedance.sdk.openadsdk.dislike.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TTDislikeDialogAbstract f652b;
        private String c;
        private final Context d;
        private final int e;
        private final int f;
        private FrameLayout g;
        private q h;
        AtomicBoolean i = new AtomicBoolean(false);
        private final int j;
        private String k;
        private DspHtmlWebView l;
        private b.b.a.a.d.f.g m;
        WeakReference<View> n;
        private PAGBannerAdWrapperListener o;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.b$b$a */
        /* JADX INFO: compiled from: BrandBannerController.java */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTWebsiteActivity.a(C0211b.this.d, C0211b.this.h, C0211b.this.k);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BrandBannerController.java */
        class ViewOnClickListenerC0212b implements View.OnClickListener {
            ViewOnClickListenerC0212b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0211b.this.k();
            }
        }

        public C0211b(Context context, q qVar, int i, int i2, String str) {
            this.k = str;
            if (qVar != null && qVar.X0()) {
                this.k = "fullscreen_interstitial_ad";
            }
            this.d = context;
            this.e = i;
            this.f = i2;
            this.h = qVar;
            this.j = b0.a(context, 3.0f);
            i();
        }

        private ImageView f() {
            PAGImageView pAGImageView = new PAGImageView(this.d);
            pAGImageView.setImageDrawable(this.d.getResources().getDrawable(t.e(this.d, "tt_dislike_icon2")));
            int iA = b0.a(this.d, 15.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = GravityCompat.END;
            int i = this.j;
            layoutParams.rightMargin = i;
            layoutParams.topMargin = i;
            pAGImageView.setLayoutParams(layoutParams);
            pAGImageView.setOnClickListener(new ViewOnClickListenerC0212b());
            return pAGImageView;
        }

        private View g() {
            TTBackUpAdImageView tTBackUpAdImageView = new TTBackUpAdImageView(this.d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            q qVar = this.h;
            if (qVar == null || !qVar.X0()) {
                int i = this.j;
                layoutParams.topMargin = i;
                layoutParams.leftMargin = i;
            } else {
                layoutParams.leftMargin = b0.a(this.d, 20.0f);
                layoutParams.bottomMargin = b0.a(this.d, 20.0f);
                layoutParams.gravity = 8388691;
            }
            tTBackUpAdImageView.setLayoutParams(layoutParams);
            tTBackUpAdImageView.setOnClickListener(new a());
            return tTBackUpAdImageView;
        }

        private DspHtmlWebView h() {
            DspHtmlWebView dspHtmlWebViewA = com.bytedance.sdk.openadsdk.core.nativeexpress.c.c().a();
            this.l = dspHtmlWebViewA;
            if (dspHtmlWebViewA == null) {
                this.l = new DspHtmlWebView(this.d);
            }
            com.bytedance.sdk.openadsdk.core.nativeexpress.c.c().c(this.l);
            this.l.a(this.h, this, this.k);
            this.l.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.l;
        }

        private void i() {
            FrameLayout frameLayout = new FrameLayout(this.d);
            this.g = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
            }
            layoutParams.width = this.e;
            layoutParams.height = this.f;
            layoutParams.gravity = 17;
            this.g.setLayoutParams(layoutParams);
            DspHtmlWebView dspHtmlWebViewH = h();
            this.g.addView(dspHtmlWebViewH);
            View viewG = g();
            this.g.addView(viewG);
            q qVar = this.h;
            if (qVar == null || !qVar.X0()) {
                ImageView imageViewF = f();
                this.g.addView(imageViewF);
                this.n = new WeakReference<>(imageViewF);
                dspHtmlWebViewH.a(imageViewF, FriendlyObstructionPurpose.CLOSE_AD);
            } else {
                dspHtmlWebViewH.setBackgroundColor(-16777216);
                this.n = new WeakReference<>(((Activity) this.d).findViewById(520093713));
                dspHtmlWebViewH.a(((Activity) this.d).findViewById(com.bytedance.sdk.openadsdk.utils.h.r1), FriendlyObstructionPurpose.OTHER);
            }
            dspHtmlWebViewH.a(viewG, FriendlyObstructionPurpose.OTHER);
        }

        @Override // b.b.a.a.d.f.d
        public int b() {
            return 5;
        }

        @Override // b.b.a.a.d.f.d
        public View e() {
            return this.g;
        }

        public void j() {
            this.g = null;
            this.a = null;
            this.f652b = null;
            this.m = null;
            this.h = null;
            DspHtmlWebView dspHtmlWebView = this.l;
            if (dspHtmlWebView != null) {
                dspHtmlWebView.g();
                com.bytedance.sdk.openadsdk.core.nativeexpress.c.c().b(this.l);
            }
            this.i.set(true);
        }

        public void k() {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f652b;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.b bVar = this.a;
            if (bVar != null) {
                bVar.a();
            } else {
                TTDelegateActivity.a(this.h, this.c);
            }
        }

        @Override // b.b.a.a.d.f.d
        public void a(b.b.a.a.d.f.g gVar) {
            q qVar;
            if (this.i.get()) {
                return;
            }
            if (this.d == null || (qVar = this.h) == null) {
                gVar.a(106);
                return;
            }
            this.m = gVar;
            if (TextUtils.isEmpty(qVar.H())) {
                gVar.a(106);
            } else {
                this.l.v();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public View c() {
            FrameLayout frameLayout = this.g;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public View d() {
            WeakReference<View> weakReference = this.n;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public void a(com.bytedance.sdk.openadsdk.core.t tVar) {
            if (tVar instanceof com.bytedance.sdk.openadsdk.dislike.b) {
                this.a = (com.bytedance.sdk.openadsdk.dislike.b) tVar;
            }
        }

        public void a(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            q qVar;
            if (tTDislikeDialogAbstract != null && (qVar = this.h) != null) {
                tTDislikeDialogAbstract.setMaterialMeta(qVar.N(), this.h.W());
            }
            this.f652b = tTDislikeDialogAbstract;
        }

        public void a(String str) {
            this.c = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public void a(View view, int i) {
            PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.o;
            if (pAGBannerAdWrapperListener != null) {
                pAGBannerAdWrapperListener.onAdClicked(this.l, 2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public void a() {
            if (this.m != null) {
                b.b.a.a.d.f.n nVar = new b.b.a.a.d.f.n();
                nVar.b(true);
                nVar.b(b0.b(this.d, this.e));
                nVar.a(b0.b(this.d, this.f));
                this.m.a(this.g, nVar);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView.e
        public void a(int i, int i2) {
            b.b.a.a.d.f.g gVar = this.m;
            if (gVar != null) {
                gVar.a(i);
            }
        }

        public void a(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
            this.o = pAGBannerAdWrapperListener;
        }
    }

    /* JADX INFO: compiled from: BrandBannerController.java */
    private static class c implements Runnable {
        d a;

        public c(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(107, 107);
            }
        }
    }

    /* JADX INFO: compiled from: BrandBannerController.java */
    interface d {
        void a();

        void a(int i, int i2);

        void a(String str);

        void b(String str);
    }

    public b(Context context, NativeExpressView nativeExpressView, q qVar, String str) {
        this.e = qVar;
        this.a = context;
        this.d = nativeExpressView;
        a(nativeExpressView);
        this.f651b = new C0211b(context, qVar, this.f, this.g, str);
    }

    private void a(NativeExpressView nativeExpressView) {
        q qVar = this.e;
        if (qVar != null && qVar.X0()) {
            this.f = -1;
            this.g = -1;
            return;
        }
        m mVarB = BannerExpressBackupView.b(nativeExpressView.getExpectExpressWidth(), nativeExpressView.getExpectExpressHeight());
        if (nativeExpressView.getExpectExpressWidth() <= 0 || nativeExpressView.getExpectExpressHeight() <= 0) {
            int i = b0.i(this.a);
            this.f = i;
            this.g = Float.valueOf(i / mVarB.f658b).intValue();
        } else {
            this.f = b0.a(this.a, nativeExpressView.getExpectExpressWidth());
            this.g = b0.a(this.a, nativeExpressView.getExpectExpressHeight());
        }
        int i2 = this.f;
        if (i2 <= 0 || i2 <= b0.i(this.a)) {
            return;
        }
        float fI = b0.i(this.a) / this.f;
        this.f = b0.i(this.a);
        this.g = Float.valueOf(this.g * fI).intValue();
    }

    public void b() {
        C0211b c0211b = this.f651b;
        if (c0211b != null) {
            c0211b.j();
            this.f651b = null;
        }
        a();
        this.c = null;
        this.d = null;
    }

    public void c() {
        q qVar = this.e;
        if (qVar != null && qVar.X0()) {
            this.h = y.e().schedule(new c(this.f651b.l), com.bytedance.sdk.openadsdk.core.o.d().e(), TimeUnit.MILLISECONDS);
        }
        C0211b c0211b = this.f651b;
        if (c0211b != null) {
            c0211b.a(new a());
            return;
        }
        b.b.a.a.d.f.o oVar = this.c;
        if (oVar != null) {
            oVar.b(106);
        }
    }

    /* JADX INFO: compiled from: BrandBannerController.java */
    class a implements b.b.a.a.d.f.g {
        a() {
        }

        @Override // b.b.a.a.d.f.g
        public void a(View view, b.b.a.a.d.f.n nVar) {
            if (b.this.d != null && view != null) {
                b.this.d.removeView(view);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                b.this.d.addView(view, new ViewGroup.LayoutParams(-1, -1));
                if (b.this.c != null) {
                    b.this.c.a(b.this.f651b, nVar);
                }
            } else if (b.this.c != null) {
                b.this.c.b(106);
            }
            b.this.a();
        }

        @Override // b.b.a.a.d.f.g
        public void a(int i) {
            if (b.this.c != null) {
                b.this.c.b(106);
            }
            b.this.a();
        }
    }

    public void a(b.b.a.a.d.f.o oVar) {
        this.c = oVar;
    }

    public void a(com.bytedance.sdk.openadsdk.core.t tVar) {
        C0211b c0211b = this.f651b;
        if (c0211b != null) {
            c0211b.a(tVar);
        }
    }

    public void a(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        C0211b c0211b = this.f651b;
        if (c0211b != null) {
            c0211b.a(tTDislikeDialogAbstract);
        }
    }

    public void a(String str) {
        C0211b c0211b = this.f651b;
        if (c0211b != null) {
            c0211b.a(str);
        }
    }

    public void a(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        C0211b c0211b = this.f651b;
        if (c0211b != null) {
            c0211b.a(pAGBannerAdWrapperListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            ScheduledFuture<?> scheduledFuture = this.h;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.h.cancel(false);
            this.h = null;
        } catch (Throwable unused) {
        }
    }
}
