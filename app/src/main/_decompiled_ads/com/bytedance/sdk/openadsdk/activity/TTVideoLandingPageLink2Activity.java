package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserDownloadButton;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserNewBottomBar;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.common.PangleViewStub;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.b0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity implements com.bytedance.sdk.openadsdk.i.d {
    private LandingPageLoadingLayout W;
    private View X;
    private View Y;
    private boolean Z;
    private TextView a0;
    private TextView b0;
    private TextView c0;
    private TextView d0;
    private TTRoundRectImageView e0;
    private TextView f0;
    private TextView g0;
    private long h0;
    private boolean i0 = false;
    private boolean j0;
    private com.bytedance.sdk.openadsdk.common.g k0;
    private LinearLayout l0;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            TTVideoLandingPageLink2Activity.this.b("click_video");
            return false;
        }
    }

    class b implements b.a.a.a.a.a.a.g.c.a {
        b() {
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, int i) {
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, long j2) {
            if (TTVideoLandingPageLink2Activity.this.d0 != null) {
                int iMax = (int) Math.max(0L, (j2 - j) / 1000);
                TTVideoLandingPageLink2Activity.this.d0.setText(iMax + "");
                if (iMax <= 0) {
                    TTVideoLandingPageLink2Activity.this.d0.setVisibility(8);
                }
            }
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void b(long j, int i) {
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void h() {
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.bytedance.sdk.openadsdk.d.c.b(TTVideoLandingPageLink2Activity.this.o, "landingpage_split_screen");
        }
    }

    class d extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        d(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                if (TTVideoLandingPageLink2Activity.this.X != null && !TTVideoLandingPageLink2Activity.this.Z) {
                    TTVideoLandingPageLink2Activity.this.X.setVisibility(8);
                }
                if (TTVideoLandingPageLink2Activity.this.l0 != null) {
                    TTVideoLandingPageLink2Activity.this.l0.setVisibility(0);
                }
                TTVideoLandingPageLink2Activity.this.i0 = true;
                TTVideoLandingPageLink2Activity.this.y();
                TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
                com.bytedance.sdk.openadsdk.d.c.a(tTVideoLandingPageLink2Activity.o, tTVideoLandingPageLink2Activity.D, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.h0, true);
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            TTVideoLandingPageLink2Activity.this.h0 = System.currentTimeMillis();
        }
    }

    class e extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
        e(x xVar, com.bytedance.sdk.openadsdk.d.j jVar) {
            super(xVar, jVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (TTVideoLandingPageLink2Activity.this.j0 && TTVideoLandingPageLink2Activity.this.k0 != null && i == 100) {
                TTVideoLandingPageLink2Activity.this.k0.a(webView);
            }
            if (TTVideoLandingPageLink2Activity.this.W != null) {
                TTVideoLandingPageLink2Activity.this.W.e(i);
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTVideoLandingPageLink2Activity.this.Z = true;
                if (TTVideoLandingPageLink2Activity.this.W != null) {
                    TTVideoLandingPageLink2Activity.this.W.n();
                }
                TTVideoLandingPageLink2Activity.this.Y.setVisibility(0);
                if (TTVideoLandingPageLink2Activity.this.i0) {
                    return;
                }
                TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
                com.bytedance.sdk.openadsdk.d.c.a(tTVideoLandingPageLink2Activity.o, tTVideoLandingPageLink2Activity.D, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.h0, false);
            } catch (Exception unused) {
            }
        }
    }

    class g implements PangleViewStub.a {
        g(TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.PangleViewStub.a
        public View a(Context context) {
            return new LandingPageBrowserDownloadButton(context);
        }
    }

    class h implements PangleViewStub.a {
        h(TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.PangleViewStub.a
        public View a(Context context) {
            return new LandingPageBrowserNewBottomBar(context);
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTDelegateActivity.a(TTVideoLandingPageLink2Activity.this.o, "");
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
            TTWebsiteActivity.a(tTVideoLandingPageLink2Activity.e, tTVideoLandingPageLink2Activity.o, tTVideoLandingPageLink2Activity.D);
        }
    }

    class k implements View.OnTouchListener {
        float a = 0.0f;

        k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.a = motionEvent.getY();
            }
            com.bytedance.sdk.openadsdk.d.j jVar = TTVideoLandingPageLink2Activity.this.K;
            if (jVar != null) {
                jVar.a(motionEvent.getActionMasked());
            }
            if (motionEvent.getAction() == 2) {
                float y = motionEvent.getY() - this.a;
                if (y > 8.0f) {
                    if (TTVideoLandingPageLink2Activity.this.k0 != null) {
                        TTVideoLandingPageLink2Activity.this.k0.c();
                    }
                    return false;
                }
                if (y < -8.0f && TTVideoLandingPageLink2Activity.this.k0 != null) {
                    TTVideoLandingPageLink2Activity.this.k0.a();
                }
            }
            return false;
        }
    }

    class l implements View.OnTouchListener {
        l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.openadsdk.d.j jVar = TTVideoLandingPageLink2Activity.this.K;
            if (jVar == null) {
                return false;
            }
            jVar.a(motionEvent.getActionMasked());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        LandingPageLoadingLayout landingPageLoadingLayout = this.W;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.n();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LandingPageLoadingLayout landingPageLoadingLayout = this.W;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.o();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.l.e() || this.o == null || this.a == null) {
            finish();
            return;
        }
        this.j0 = o.d().Y();
        this.a.setWebViewClient(new d(this.e, this.i, this.g, this.K, true));
        this.a.setWebChromeClient(new e(this.i, this.K));
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.s1);
        this.f0 = textView;
        if (textView != null && this.o.h0() != null) {
            this.f0.setText(this.o.h0().a());
        }
        long jB = 10000;
        q qVar = this.o;
        if (qVar != null && qVar.h0() != null) {
            jB = this.o.h0().b() * 1000;
        }
        com.bytedance.sdk.openadsdk.core.l.c().postDelayed(new f(), jB);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        y();
        if (!this.Z && this.K != null && this.a != null && this.W.getVisibility() == 8) {
            this.K.a(this.a);
        }
        super.onDestroy();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public void q() {
        super.q();
        q qVar = this.o;
        if (qVar != null) {
            qVar.a(true);
        }
        TextView textView = this.g0;
        if (textView != null) {
            textView.setText(i());
            this.g0.setClickable(true);
            this.g0.setOnClickListener(this.T);
            this.g0.setOnTouchListener(this.T);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void s() {
        if (h()) {
            super.s();
            if (this.m.getNativeVideoController() != null) {
                this.m.getNativeVideoController().d(false);
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.m.getNativeVideoController()).h(false);
                this.k.setClickable(true);
                this.k.setOnTouchListener(new a());
            }
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.m.getNativeVideoController()).a(new b());
            return;
        }
        try {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.bytedance.sdk.openadsdk.n.c.b().a(this.o.d0().get(0), imageView, this.o);
            this.k.setVisibility(0);
            this.k.removeAllViews();
            this.k.addView(imageView);
            imageView.setOnClickListener(new c());
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void t() {
        super.t();
        TextView textView = (TextView) findViewById(520093713);
        this.c0 = textView;
        if (textView != null) {
            textView.setText(t.k(o.a(), "tt_reward_feedback"));
            this.c0.setOnClickListener(new i());
        }
        this.d0 = (TextView) findViewById(520093714);
        this.W = (LandingPageLoadingLayout) findViewById(com.bytedance.sdk.openadsdk.utils.h.Q);
        this.X = findViewById(com.bytedance.sdk.openadsdk.utils.h.P);
        this.Y = findViewById(com.bytedance.sdk.openadsdk.utils.h.G);
        this.a0 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.S);
        this.b0 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.T);
        this.e0 = (TTRoundRectImageView) findViewById(com.bytedance.sdk.openadsdk.utils.h.R);
        this.g0 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.U);
        if (this.o.b0() != null && !TextUtils.isEmpty(this.o.b0().d())) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.o.b0(), this.e0, this.o);
        }
        this.a0.setText(this.o.F0());
        this.b0.setText(this.o.B());
        ((TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.V)).setOnClickListener(new j());
        boolean zY = o.d().Y();
        this.j0 = zY;
        if (zY) {
            ((PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.h.X)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.h.h0);
            this.l0 = linearLayout;
            linearLayout.setVisibility(8);
            this.k0 = new com.bytedance.sdk.openadsdk.common.g(this, this.l0, this.a, this.o, "landingpage_split_screen");
            if (this.a.getWebView() != null) {
                this.a.getWebView().setOnTouchListener(new k());
            }
        } else if (this.a.getWebView() != null) {
            this.a.getWebView().setOnTouchListener(new l());
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.W;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.o, this.D);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected boolean h() {
        int i2 = this.l;
        return i2 == 5 || i2 == 15 || i2 == 50;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected View j() {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setBackgroundColor(-1);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this);
        pAGLinearLayout.addView(pAGFrameLayout, new LinearLayout.LayoutParams(-1, b0.a(this, 220.0f)));
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(this);
        pAGFrameLayout2.setId(com.bytedance.sdk.openadsdk.utils.h.H);
        pAGFrameLayout.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(this);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setPadding(0, b0.a(this, 20.0f), 0, 0);
        pAGFrameLayout.addView(pAGLinearLayout2, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout2.addView(view, layoutParams);
        ShadowTextView shadowTextView = new ShadowTextView(this);
        shadowTextView.setId(520093713);
        shadowTextView.setGravity(17);
        shadowTextView.setText(t.j(this, "tt_reward_feedback"));
        shadowTextView.setTextColor(-1);
        shadowTextView.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, b0.a(this, 28.0f));
        int iA = b0.a(this, 16.0f);
        layoutParams2.rightMargin = iA;
        layoutParams2.leftMargin = iA;
        pAGLinearLayout2.addView(shadowTextView, layoutParams2);
        ShadowImageView shadowImageView = new ShadowImageView(this);
        shadowImageView.setId(com.bytedance.sdk.openadsdk.utils.h.I);
        shadowImageView.setPadding(b0.a(this, 7.0f), b0.a(this, 7.0f), b0.a(this, 7.0f), b0.a(this, 7.0f));
        shadowImageView.setImageResource(t.e(this, "tt_video_close_drawable"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(b0.a(this, 28.0f), b0.a(this, 28.0f));
        layoutParams3.rightMargin = b0.a(this, 12.0f);
        pAGLinearLayout2.addView(shadowImageView, layoutParams3);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(this);
        pAGRelativeLayout.setVisibility(8);
        pAGRelativeLayout.setId(com.bytedance.sdk.openadsdk.utils.h.J);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = b0.a(this, 10.0f);
        pAGLinearLayout.addView(pAGRelativeLayout, layoutParams4);
        CornerIV cornerIV = new CornerIV(this);
        cornerIV.setId(com.bytedance.sdk.openadsdk.utils.h.K);
        cornerIV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        cornerIV.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(b0.a(this, 44.0f), b0.a(this, 44.0f));
        layoutParams5.addRule(9);
        layoutParams5.leftMargin = b0.a(this, 5.0f);
        pAGRelativeLayout.addView(cornerIV, layoutParams5);
        PAGTextView pAGTextView = new PAGTextView(this);
        int i2 = com.bytedance.sdk.openadsdk.utils.h.L;
        pAGTextView.setId(i2);
        pAGTextView.setBackgroundResource(t.e(this, "tt_circle_solid_mian"));
        pAGTextView.setGravity(17);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 19.0f);
        pAGTextView.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(b0.a(this, 44.0f), b0.a(this, 44.0f));
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = b0.a(this, 5.0f);
        pAGRelativeLayout.addView(pAGTextView, layoutParams6);
        PAGTextView pAGTextView2 = new PAGTextView(this);
        pAGTextView2.setId(com.bytedance.sdk.openadsdk.utils.h.M);
        pAGTextView2.setMaxLines(1);
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView2.setTextColor(Color.parseColor("#e5000000"));
        pAGTextView2.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = b0.a(this, 5.0f);
        layoutParams7.rightMargin = b0.a(this, 80.0f);
        layoutParams7.addRule(1, i2);
        pAGRelativeLayout.addView(pAGTextView2, layoutParams7);
        PAGTextView pAGTextView3 = new PAGTextView(this);
        pAGTextView3.setId(com.bytedance.sdk.openadsdk.utils.h.N);
        pAGTextView3.setClickable(true);
        pAGTextView3.setMaxLines(1);
        pAGTextView3.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView3.setFocusable(true);
        pAGTextView3.setGravity(17);
        pAGTextView3.setText(t.j(this, "tt_video_mobile_go_detail"));
        pAGTextView3.setTextColor(-1);
        pAGTextView3.setTextSize(2, 14.0f);
        pAGTextView3.setPadding(b0.a(this, 2.0f), b0.a(this, 2.0f), b0.a(this, 2.0f), b0.a(this, 2.0f));
        pAGTextView3.setBackgroundResource(t.e(this, "tt_ad_cover_btn_begin_bg"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(b0.a(this, 90.0f), b0.a(this, 36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = b0.a(this, 5.0f);
        pAGRelativeLayout.addView(pAGTextView3, layoutParams8);
        PAGFrameLayout pAGFrameLayout3 = new PAGFrameLayout(this);
        pAGLinearLayout.addView(pAGFrameLayout3, new LinearLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(this);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.O);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.topMargin = b0.a(this, 2.0f);
        pAGFrameLayout3.addView(sSWebView, layoutParams9);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(this);
        pAGRelativeLayout2.setId(com.bytedance.sdk.openadsdk.utils.h.P);
        pAGRelativeLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
        pAGFrameLayout3.addView(pAGRelativeLayout2, new FrameLayout.LayoutParams(-1, -1));
        LandingPageLoadingLayout landingPageLoadingLayout = new LandingPageLoadingLayout(this);
        landingPageLoadingLayout.setId(com.bytedance.sdk.openadsdk.utils.h.Q);
        pAGRelativeLayout2.addView(landingPageLoadingLayout, new RelativeLayout.LayoutParams(-1, -1));
        PAGLinearLayout pAGLinearLayout3 = new PAGLinearLayout(this);
        pAGLinearLayout3.setId(com.bytedance.sdk.openadsdk.utils.h.G);
        pAGLinearLayout3.setOrientation(1);
        pAGLinearLayout3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(13);
        pAGRelativeLayout2.addView(pAGLinearLayout3, layoutParams10);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(this);
        tTRoundRectImageView.setId(com.bytedance.sdk.openadsdk.utils.h.R);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(b0.a(this, 80.0f), b0.a(this, 80.0f));
        layoutParams11.gravity = 17;
        pAGLinearLayout3.addView(tTRoundRectImageView, layoutParams11);
        PAGTextView pAGTextView4 = new PAGTextView(this);
        pAGTextView4.setId(com.bytedance.sdk.openadsdk.utils.h.S);
        pAGTextView4.setTextColor(Color.parseColor("#161823"));
        pAGTextView4.setTextSize(0, b0.a(this, 24.0f));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.gravity = 17;
        layoutParams12.topMargin = b0.a(this, 12.0f);
        pAGLinearLayout3.addView(pAGTextView4, layoutParams12);
        PAGTextView pAGTextView5 = new PAGTextView(this);
        pAGTextView5.setId(com.bytedance.sdk.openadsdk.utils.h.T);
        pAGTextView5.setTextColor(Color.parseColor("#80161823"));
        pAGTextView5.setTextSize(0, b0.a(this, 16.0f));
        if (Build.VERSION.SDK_INT >= 17) {
            pAGTextView5.setTextAlignment(4);
        }
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 17;
        int iA2 = b0.a(this, 60.0f);
        layoutParams13.rightMargin = iA2;
        layoutParams13.leftMargin = iA2;
        layoutParams13.topMargin = b0.a(this, 8.0f);
        pAGLinearLayout3.addView(pAGTextView5, layoutParams13);
        PAGTextView pAGTextView6 = new PAGTextView(this);
        pAGTextView6.setId(com.bytedance.sdk.openadsdk.utils.h.U);
        pAGTextView6.setGravity(17);
        pAGTextView6.setTextColor(-1);
        pAGTextView6.setText(t.j(this, "tt_video_mobile_go_detail"));
        pAGTextView6.setBackgroundResource(t.e(this, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(b0.a(this, 255.0f), b0.a(this, 44.0f));
        layoutParams14.gravity = 17;
        layoutParams14.topMargin = b0.a(this, 32.0f);
        pAGLinearLayout3.addView(pAGTextView6, layoutParams14);
        PAGTextView pAGTextView7 = new PAGTextView(this);
        pAGTextView7.setId(com.bytedance.sdk.openadsdk.utils.h.V);
        pAGTextView7.setBackgroundResource(t.e(this, "tt_ad_logo_new"));
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(b0.a(this, 32.0f), b0.a(this, 14.0f));
        layoutParams15.addRule(12);
        layoutParams15.leftMargin = b0.a(this, 16.0f);
        layoutParams15.bottomMargin = b0.a(this, 20.0f);
        pAGRelativeLayout2.addView(pAGTextView7, layoutParams15);
        View pangleViewStub = new PangleViewStub(this, new g(this));
        pangleViewStub.setId(com.bytedance.sdk.openadsdk.utils.h.W);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-1, b0.a(this, 48.0f));
        layoutParams16.gravity = 81;
        pAGFrameLayout3.addView(pangleViewStub, layoutParams16);
        View pangleViewStub2 = new PangleViewStub(this, new h(this));
        pangleViewStub2.setId(com.bytedance.sdk.openadsdk.utils.h.X);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, b0.a(this, 44.0f));
        layoutParams17.gravity = 80;
        pAGFrameLayout3.addView(pangleViewStub2, layoutParams17);
        return pAGLinearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.bytedance.sdk.openadsdk.d.c.a(this.o, "landingpage_split_screen", str, (JSONObject) null);
    }
}
