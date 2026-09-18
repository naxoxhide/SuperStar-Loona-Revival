package com.igaworks.adpopcorn.activity.b;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class g extends Dialog {
    private int A;
    private int B;
    private Runnable C;
    private Handler D;
    private int E;
    private int F;
    private View.OnTouchListener G;
    private WebViewClient H;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.model.g f1536b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private TextView d;
    private com.igaworks.adpopcorn.activity.c.g e;
    private boolean f;
    private boolean g;
    private GradientDrawable h;
    private GradientDrawable i;
    private GradientDrawable j;
    private GradientDrawable k;
    private GradientDrawable l;
    private GradientDrawable m;
    private com.igaworks.adpopcorn.activity.c.j.a n;
    private RelativeLayout o;
    private FrameLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private TextView u;
    private TextView v;
    private TextView w;
    private boolean x;
    private com.igaworks.adpopcorn.cores.common.b y;
    private boolean z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.a();
            g.this.l();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.a();
            g.this.k();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.igaworks.adpopcorn.cores.common.h.a(g.this.a, "APNewsWebViewDialog", "click outside resultpopup", 3);
            if (g.this.x) {
                g.this.b();
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.dismiss();
        }
    }

    class e extends WebViewClient {
        e() {
        }

        private boolean a(WebView webView, String str) {
            com.igaworks.adpopcorn.cores.common.h.a(g.this.a, "APNewsWebViewDialog", "urlLoading : " + str, 3);
            if (!g.this.f || str == null || (!str.contains("http://") && !str.contains("https://") && !str.startsWith("market://"))) {
                webView.loadUrl(str);
                return false;
            }
            g.this.f = false;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            g.this.a.startActivity(intent);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.igaworks.adpopcorn.cores.common.h.a(g.this.a, "APNewsWebViewDialog", "onPageFinished : " + str, 3);
            g.this.f = false;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                String string = Build.VERSION.SDK_INT >= 21 ? webResourceRequest.getUrl().toString() : webView.getUrl();
                com.igaworks.adpopcorn.cores.common.h.a(g.this.a, "APNewsWebViewDialog", "shouldOverrideUrlLoading : " + string, 3);
                return a(webView, string);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                com.igaworks.adpopcorn.cores.common.h.a(g.this.a, "APNewsWebViewDialog", "shouldOverrideUrlLoading : " + str, 3);
                return a(webView, str);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    class f implements View.OnTouchListener {
        private float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f1537b;
        private float c = 0.0f;

        f() {
        }

        private boolean a(float f, float f2) {
            float fAbs = this.c + Math.abs(f - f2);
            this.c = fAbs;
            return fAbs > ((float) g.this.F);
        }

        private boolean a(float f, float f2, float f3, float f4) {
            return Math.abs(f - f2) <= ((float) g.this.E) && Math.abs(f3 - f4) <= ((float) g.this.E);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = motionEvent.getX();
                this.f1537b = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (a(this.a, x, this.f1537b, y)) {
                g.this.f = true;
            }
            if (g.this.g || !a(this.f1537b, y)) {
                return false;
            }
            g.this.g = true;
            if (g.this.x) {
                return false;
            }
            g.this.m();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.g$g, reason: collision with other inner class name */
    class RunnableC0413g implements Runnable {
        RunnableC0413g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g.this.z || g.this.x) {
                return;
            }
            g.a(g.this, 150);
            if (Build.VERSION.SDK_INT > 11) {
                try {
                    g.this.n.setProgress(g.this.A);
                } catch (Exception unused) {
                    g.this.n.setProgress(g.this.f1536b.G() * 1000);
                }
            }
            if (g.this.A < g.this.B) {
                g.this.D.postDelayed(g.this.C, 150L);
                return;
            }
            com.igaworks.adpopcorn.cores.common.h.a(g.this.a, "APNewsWebViewDialog", "on complete", 3);
            g.this.x = true;
            g.this.l();
            if (g.this.y != null) {
                g.this.y.a();
            }
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.onBackPressed();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.onBackPressed();
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.o != null) {
                g.this.o.setVisibility(4);
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.o != null) {
                g.this.o.setVisibility(4);
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.a(false);
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.a();
            g.this.k();
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.a();
            g.this.k();
        }
    }

    public g(Context context, int i2, com.igaworks.adpopcorn.cores.model.g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, com.igaworks.adpopcorn.cores.common.b bVar) {
        super(context, i2);
        this.f = false;
        this.g = false;
        this.E = 200;
        this.F = 1000;
        this.G = new f();
        this.H = new e();
        this.a = context;
        this.f1536b = gVar;
        this.c = gVar2;
        this.x = gVar.b0();
        this.y = bVar;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.h = gradientDrawable;
        gradientDrawable.setShape(0);
        this.h.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 8));
        this.h.setGradientType(0);
        this.h.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, 1), Color.parseColor("#1a000000"));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.i = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.i.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 29));
        this.i.setGradientType(0);
        this.i.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, 1), Color.parseColor("#1a000000"));
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{452958464, 452958464});
        this.j = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.j.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 16));
        this.j.setGradientType(0);
        this.j.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, 2), Color.parseColor("#33ff9900"));
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-12424980, -12424980});
        this.k = gradientDrawable4;
        gradientDrawable4.setShape(0);
        this.k.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, com.igaworks.adpopcorn.cores.common.d.a(context, 8), com.igaworks.adpopcorn.cores.common.d.a(context, 8), com.igaworks.adpopcorn.cores.common.d.a(context, 8), com.igaworks.adpopcorn.cores.common.d.a(context, 8)});
        this.k.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-723724, -723724});
        this.l = gradientDrawable5;
        gradientDrawable5.setShape(0);
        this.l.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, com.igaworks.adpopcorn.cores.common.d.a(context, 8), com.igaworks.adpopcorn.cores.common.d.a(context, 8)});
        this.l.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-12424980, -12424980});
        this.m = gradientDrawable6;
        gradientDrawable6.setShape(0);
        this.m.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, com.igaworks.adpopcorn.cores.common.d.a(context, 8), com.igaworks.adpopcorn.cores.common.d.a(context, 8), 0.0f, 0.0f});
        this.m.setGradientType(0);
        if (gVar != null) {
            this.F = gVar.I();
        }
    }

    static /* synthetic */ int a(g gVar, int i2) {
        int i3 = gVar.A + i2;
        gVar.A = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            LinearLayout linearLayout = this.q;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            j();
            if (z) {
                LinearLayout linearLayout = this.r;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                LinearLayout linearLayout2 = this.s;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            } else {
                LinearLayout linearLayout3 = this.r;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                LinearLayout linearLayout4 = this.s;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
            }
            LinearLayout linearLayout5 = this.q;
            if (linearLayout5 == null || linearLayout5.getVisibility() == 0) {
                return;
            }
            this.q.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        FrameLayout frameLayout = this.p;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.t;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private View c() {
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        frameLayout.addView(linearLayout);
        linearLayout.addView(i());
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
        linearLayout2.setBackgroundColor(Color.parseColor("#eeeeee"));
        linearLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(this.a.getApplicationContext());
        frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.e = new com.igaworks.adpopcorn.activity.c.g(this.a.getApplicationContext());
        this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.e.getSettings().setJavaScriptEnabled(true);
        this.e.setWebViewClient(this.H);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.setVerticalScrollbarOverlay(false);
        this.e.setHorizontalScrollBarEnabled(false);
        this.e.setHorizontalScrollbarOverlay(false);
        this.e.setBackgroundColor(-1);
        this.e.setOnTouchListener(this.G);
        this.e.getSettings().setDefaultTextEncodingName("UTF-8");
        this.e.getSettings().setAllowFileAccess(true);
        this.e.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.e.getSettings().setDomStorageEnabled(true);
        this.e.getSettings().setDatabaseEnabled(true);
        com.igaworks.adpopcorn.cores.common.h.a(this.a, "APNewsWebViewDialog", "APNewsWebViewDialog isUseNewsWebViewCache : " + this.f1536b.g0(), 3);
        com.igaworks.adpopcorn.cores.model.g gVar = this.f1536b;
        if (gVar != null && !gVar.g0()) {
            this.e.getSettings().setCacheMode(2);
            this.e.clearCache(true);
        }
        frameLayout2.addView(this.e);
        if (!this.x) {
            frameLayout2.addView(f());
            frameLayout2.addView(h());
        }
        linearLayout.addView(frameLayout2);
        if (!this.x) {
            frameLayout.addView(g());
            frameLayout.addView(e());
        }
        return frameLayout;
    }

    private void d() {
        this.D = new Handler(Looper.getMainLooper());
        this.z = false;
        this.A = 0;
        this.B = this.f1536b.G() * 1000;
        this.C = new RunnableC0413g();
    }

    private View e() {
        this.t = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.t.setLayoutParams(layoutParams);
        this.t.setOrientation(1);
        this.t.setGravity(17);
        this.t.setBackgroundColor(Color.parseColor("#33000000"));
        this.t.setOnClickListener(new c());
        LinearLayout linearLayout = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 320), -2);
        layoutParams2.gravity = 17;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(this.h);
        this.t.addView(linearLayout);
        this.u = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 23));
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        this.u.setLayoutParams(layoutParams3);
        linearLayout.addView(this.u);
        com.igaworks.adpopcorn.cores.common.k.b(this.u, this.c.C2, 16, Color.parseColor("#191919"), null, 0, 1, TextUtils.TruncateAt.END, true);
        this.v = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 220), -2);
        layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        layoutParams4.gravity = 17;
        this.v.setLayoutParams(layoutParams4);
        this.v.setGravity(17);
        linearLayout.addView(this.v);
        com.igaworks.adpopcorn.cores.common.k.b(this.v, this.c.E2, 14, Color.parseColor("#8E8E8E"), null, 0, 2, TextUtils.TruncateAt.END, false);
        this.w = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
        layoutParams5.gravity = 17;
        this.w.setLayoutParams(layoutParams5);
        this.w.setGravity(17);
        this.w.setBackgroundDrawable(this.k);
        linearLayout.addView(this.w);
        com.igaworks.adpopcorn.cores.common.k.b(this.w, this.c.H, 14, Color.parseColor("#ffffff"), null, 0, 2, TextUtils.TruncateAt.END, false);
        this.w.setOnClickListener(new d());
        this.t.setVisibility(8);
        return this.t;
    }

    private RelativeLayout f() {
        this.o = new RelativeLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 240), com.igaworks.adpopcorn.cores.common.d.a(this.a, 96));
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 30);
        this.o.setLayoutParams(layoutParams);
        this.o.setBackgroundDrawable(this.h);
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 14);
        layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 14);
        textView.setLayoutParams(layoutParams2);
        this.o.addView(textView);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.c.x2, 13, Color.parseColor("#191919"), null, 0, 1, TextUtils.TruncateAt.END, true);
        TextView textView2 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(10);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 38);
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 37);
        textView2.setLayoutParams(layoutParams3);
        this.o.addView(textView2);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, this.c.y2, 12, Color.parseColor("#707070"), null, 0, 3, TextUtils.TruncateAt.END, false);
        ImageView imageView = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 9), com.igaworks.adpopcorn.cores.common.d.a(this.a, 9));
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_news_close.png", imageView, false);
        imageView.setOnClickListener(new j());
        layoutParams4.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 18);
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 17);
        layoutParams4.addRule(10);
        layoutParams4.addRule(11);
        imageView.setColorFilter(Color.parseColor("#191919"), PorterDuff.Mode.MULTIPLY);
        imageView.setLayoutParams(layoutParams4);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.o.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
        layoutParams5.addRule(10);
        layoutParams5.addRule(11);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOnClickListener(new k());
        this.o.addView(linearLayout);
        return this.o;
    }

    private View g() {
        this.q = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.q.setLayoutParams(layoutParams);
        this.q.setOrientation(1);
        this.q.setGravity(17);
        this.q.setBackgroundColor(Color.parseColor("#33000000"));
        this.q.setOnClickListener(new m());
        LinearLayout linearLayout = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 320), com.igaworks.adpopcorn.cores.common.d.a(this.a, 239));
        layoutParams2.gravity = 17;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(this.h);
        this.q.addView(linearLayout);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 23));
        layoutParams3.gravity = 17;
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        textView.setLayoutParams(layoutParams3);
        linearLayout.addView(textView);
        com.igaworks.adpopcorn.cores.common.k.b(textView, this.c.x2, 16, Color.parseColor("#191919"), null, 0, 1, TextUtils.TruncateAt.END, true);
        FrameLayout frameLayout = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 54), com.igaworks.adpopcorn.cores.common.d.a(this.a, 54));
        layoutParams4.gravity = 17;
        frameLayout.setLayoutParams(layoutParams4);
        frameLayout.setBackgroundDrawable(this.i);
        int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        com.igaworks.adpopcorn.activity.c.j.a aVar = new com.igaworks.adpopcorn.activity.c.j.a(this.a, 5);
        aVar.setStyle(2);
        aVar.setPadding(iA, iA, iA, iA);
        aVar.setProgressBackgroundColor(Color.parseColor("#F6F6F6"));
        aVar.setProgressStartColor(Color.parseColor("#FF9900"));
        aVar.setProgressEndColor(Color.parseColor("#FF9900"));
        aVar.setMax(4);
        aVar.setProgress(1);
        frameLayout.addView(aVar);
        TextView textView2 = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 32), com.igaworks.adpopcorn.cores.common.d.a(this.a, 32));
        layoutParams5.gravity = 17;
        textView2.setLayoutParams(layoutParams5);
        textView2.setBackgroundDrawable(this.j);
        textView2.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView2, "+" + this.f1536b.F(), 15, Color.parseColor("#ff9900"), null, 0, 1, TextUtils.TruncateAt.END, false);
        frameLayout.addView(textView2);
        linearLayout.addView(frameLayout);
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 249), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
        layoutParams6.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams6.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        layoutParams6.gravity = 17;
        textView3.setLayoutParams(layoutParams6);
        textView3.setGravity(17);
        linearLayout.addView(textView3);
        com.igaworks.adpopcorn.cores.common.k.b(textView3, this.c.z2, 14, Color.parseColor("#707070"), null, 0, 3, TextUtils.TruncateAt.END, false);
        this.r = new LinearLayout(this.a);
        this.r.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42)));
        this.r.setOrientation(0);
        this.r.setGravity(17);
        linearLayout.addView(this.r);
        TextView textView4 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
        layoutParams7.gravity = 17;
        textView4.setLayoutParams(layoutParams7);
        textView4.setGravity(17);
        textView4.setBackgroundDrawable(this.k);
        this.r.addView(textView4);
        com.igaworks.adpopcorn.cores.common.k.b(textView4, this.c.H, 14, Color.parseColor("#ffffff"), null, 0, 2, TextUtils.TruncateAt.END, false);
        this.r.setOnClickListener(new n());
        this.s = new LinearLayout(this.a);
        this.s.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42)));
        this.s.setOrientation(0);
        this.s.setGravity(17);
        linearLayout.addView(this.s);
        TextView textView5 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), 1.0f);
        layoutParams8.gravity = 17;
        textView5.setLayoutParams(layoutParams8);
        textView5.setGravity(17);
        textView5.setBackgroundDrawable(this.l);
        this.s.addView(textView5);
        com.igaworks.adpopcorn.cores.common.k.b(textView5, this.c.A2, 14, Color.parseColor("#B1B1B1"), null, 0, 2, TextUtils.TruncateAt.END, false);
        textView5.setOnClickListener(new a());
        TextView textView6 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), 1.0f);
        layoutParams9.gravity = 17;
        textView6.setLayoutParams(layoutParams9);
        textView6.setGravity(17);
        textView6.setBackgroundDrawable(this.m);
        this.s.addView(textView6);
        com.igaworks.adpopcorn.cores.common.k.b(textView6, this.c.B2, 14, Color.parseColor("#ffffff"), null, 0, 2, TextUtils.TruncateAt.END, false);
        textView6.setOnClickListener(new b());
        this.q.setVisibility(8);
        return this.q;
    }

    private View h() {
        this.p = new FrameLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 58), com.igaworks.adpopcorn.cores.common.d.a(this.a, 58));
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        this.p.setLayoutParams(layoutParams);
        this.p.setBackgroundDrawable(this.i);
        int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        com.igaworks.adpopcorn.activity.c.j.a aVar = new com.igaworks.adpopcorn.activity.c.j.a(this.a, 5);
        this.n = aVar;
        aVar.setStyle(2);
        this.n.setPadding(iA, iA, iA, iA);
        this.n.setProgressBackgroundColor(Color.parseColor("#F6F6F6"));
        this.n.setProgressStartColor(Color.parseColor("#FF9900"));
        this.n.setProgressEndColor(Color.parseColor("#FF9900"));
        this.n.setMax(this.f1536b.G() * 1000);
        this.n.setProgress(0);
        this.p.addView(this.n);
        TextView textView = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 32), com.igaworks.adpopcorn.cores.common.d.a(this.a, 32));
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setBackgroundDrawable(this.j);
        textView.setGravity(17);
        com.igaworks.adpopcorn.cores.common.k.b(textView, "+" + this.f1536b.F(), 15, Color.parseColor("#ff9900"), null, 0, 1, TextUtils.TruncateAt.END, false);
        this.p.addView(textView);
        this.p.setOnClickListener(new l());
        return this.p;
    }

    private RelativeLayout i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 48)));
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        ImageView imageView = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15));
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_news_back_navigation.png", imageView, false);
        imageView.setOnClickListener(new h());
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setColorFilter(Color.parseColor("#191919"), PorterDuff.Mode.MULTIPLY);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, 48));
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOnClickListener(new i());
        relativeLayout.addView(linearLayout);
        this.d = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 45);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        this.d.setLayoutParams(layoutParams3);
        this.d.setGravity(17);
        relativeLayout.addView(this.d);
        TextView textView = this.d;
        if (textView != null) {
            com.igaworks.adpopcorn.cores.common.k.b(textView, this.f1536b.H(), 14, Color.parseColor("#191919"), null, 0, 1, TextUtils.TruncateAt.END, true);
        }
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        TextView textView;
        String str;
        LinearLayout linearLayout = this.t;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        if (this.x) {
            TextView textView2 = this.u;
            if (textView2 != null) {
                com.igaworks.adpopcorn.cores.common.k.b(textView2, this.c.C2, 16, Color.parseColor("#191919"), null, 0, 1, TextUtils.TruncateAt.END, true);
            }
            TextView textView3 = this.v;
            if (textView3 != null) {
                com.igaworks.adpopcorn.cores.common.k.b(textView3, this.c.E2, 14, Color.parseColor("#8E8E8E"), null, 0, 2, TextUtils.TruncateAt.END, false);
            }
            textView = this.w;
            if (textView == null) {
                return;
            } else {
                str = this.c.G2;
            }
        } else {
            TextView textView4 = this.u;
            if (textView4 != null) {
                com.igaworks.adpopcorn.cores.common.k.b(textView4, this.c.D2, 16, Color.parseColor("#191919"), null, 0, 1, TextUtils.TruncateAt.END, true);
            }
            TextView textView5 = this.v;
            if (textView5 != null) {
                com.igaworks.adpopcorn.cores.common.k.b(textView5, String.format(this.c.F2, Integer.valueOf(this.f1536b.G())), 14, Color.parseColor("#8E8E8E"), null, 0, 2, TextUtils.TruncateAt.END, false);
            }
            textView = this.w;
            if (textView == null) {
                return;
            } else {
                str = this.c.H;
            }
        }
        com.igaworks.adpopcorn.cores.common.k.b(textView, str, 14, Color.parseColor("#ffffff"), null, 0, 1, TextUtils.TruncateAt.END, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            this.z = true;
            Handler handler = this.D;
            if (handler != null) {
                handler.postDelayed(this.C, 300L);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.igaworks.adpopcorn.cores.common.h.a(this.a, "APNewsWebViewDialog", "APNewsWebViewDialog dismiss", 3);
        try {
            Handler handler = this.D;
            if (handler != null) {
                handler.removeCallbacks(this.C);
            }
        } catch (Exception unused) {
        }
    }

    public void j() {
        try {
            this.z = false;
        } catch (Exception unused) {
        }
    }

    public void k() {
        Handler handler;
        try {
            if (!this.g || this.x) {
                return;
            }
            LinearLayout linearLayout = this.q;
            if ((linearLayout == null || linearLayout.getVisibility() != 0) && (handler = this.D) != null) {
                this.z = true;
                handler.postDelayed(this.C, 300L);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        LinearLayout linearLayout = this.q;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            a();
            k();
            return;
        }
        if (this.x) {
            super.onBackPressed();
            com.igaworks.adpopcorn.cores.common.b bVar = this.y;
            if (bVar != null) {
                bVar.a();
            }
            l();
            return;
        }
        LinearLayout linearLayout2 = this.t;
        if (linearLayout2 == null || linearLayout2.getVisibility() != 0) {
            a(true);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = fC;
        layoutParams.windowAnimations = com.igaworks.adpopcorn.a.a.a(this.a, "IGAWDialogAnimationFromBottom", "style");
        getWindow().setAttributes(layoutParams);
        d();
        setContentView(c());
        com.igaworks.adpopcorn.activity.c.g gVar = this.e;
        if (gVar != null) {
            gVar.loadUrl(this.f1536b.z());
        }
        if (this.x || !this.g) {
            return;
        }
        m();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
