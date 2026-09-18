package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import b.b.a.a.h.o;
import b.b.a.a.h.u;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.PangleViewStub;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.n;
import com.bytedance.sdk.openadsdk.utils.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTVideoLandingPageActivity extends TTBaseActivity implements com.bytedance.sdk.openadsdk.i.d {
    protected Button A;
    protected b.c.a.a.a.a.c B;
    protected String D;
    protected int I;
    protected com.bytedance.sdk.openadsdk.m.g.a J;
    protected com.bytedance.sdk.openadsdk.d.j K;
    protected String M;
    private ILoader N;
    private int R;
    private int S;
    protected SSWebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ImageView f416b;
    protected ImageView c;
    protected TextView d;
    protected Context e;
    protected int f;
    protected String g;
    protected String h;
    protected x i;
    protected int j;
    protected FrameLayout k;
    protected NativeVideoTsView m;
    protected long n;
    protected q o;
    protected RelativeLayout u;
    protected TextView v;
    protected CornerIV w;
    protected TextView x;
    protected TextView y;
    protected PangleViewStub z;
    protected int l = -1;
    protected int p = 0;
    protected int q = 0;
    protected int r = 0;
    protected int s = 0;
    protected String t = "ダウンロード";
    protected boolean C = false;
    protected boolean E = false;
    protected boolean F = true;
    protected boolean G = false;
    protected String H = null;
    protected AtomicBoolean L = new AtomicBoolean(true);
    private volatile int O = 0;
    private volatile int P = 0;
    private volatile int Q = 0;
    protected com.bytedance.sdk.openadsdk.core.c0.a T = null;
    private final b.a.a.a.a.a.a.g.c.b U = new k();
    private final w.b V = new a();

    class a implements w.b {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$a$a, reason: collision with other inner class name */
        class RunnableC0172a implements Runnable {
            final /* synthetic */ int a;

            RunnableC0172a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.a);
            }
        }

        a() {
        }

        @Override // com.bytedance.sdk.component.utils.w.b
        public void a(Context context, Intent intent, boolean z, int i) {
            y.a(new RunnableC0172a(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            SSWebView sSWebView;
            String str;
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            if (tTVideoLandingPageActivity.I == 0 && i != 0 && (sSWebView = tTVideoLandingPageActivity.a) != null && (str = tTVideoLandingPageActivity.H) != null) {
                sSWebView.c(str);
            }
            NativeVideoTsView nativeVideoTsView = TTVideoLandingPageActivity.this.m;
            if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                if (!tTVideoLandingPageActivity2.E && tTVideoLandingPageActivity2.I != i) {
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) tTVideoLandingPageActivity2.m.getNativeVideoController()).g(i);
                }
            }
            TTVideoLandingPageActivity.this.I = i;
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.a((View) TTVideoLandingPageActivity.this.c, this.a);
        }
    }

    class c implements com.bytedance.sdk.openadsdk.d.i {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.d.i
        public void a(int i) {
            com.bytedance.sdk.openadsdk.d.c.o.a(TTVideoLandingPageActivity.this.R, TTVideoLandingPageActivity.this.Q, TTVideoLandingPageActivity.this.P, TTVideoLandingPageActivity.this.O - TTVideoLandingPageActivity.this.P, TTVideoLandingPageActivity.this.o, "landingpage_split_screen", i);
        }
    }

    class d extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        d(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                if (TextUtils.isEmpty(TTVideoLandingPageActivity.this.M)) {
                    return super.shouldInterceptRequest(webView, str);
                }
                TTVideoLandingPageActivity.g(TTVideoLandingPageActivity.this);
                WebResourceResponseModel webResourceResponseModelA = com.bytedance.sdk.openadsdk.f.b.c().a(TTVideoLandingPageActivity.this.N, TTVideoLandingPageActivity.this.M, str);
                if (webResourceResponseModelA != null && webResourceResponseModelA.getWebResourceResponse() != null) {
                    TTVideoLandingPageActivity.e(TTVideoLandingPageActivity.this);
                    m.a("TTVideoLandingPage", "GeckoLog: hit++");
                    return webResourceResponseModelA.getWebResourceResponse();
                }
                if (webResourceResponseModelA != null && webResourceResponseModelA.getMsg() == 2) {
                    TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this);
                }
                return super.shouldInterceptRequest(webView, str);
            } catch (Throwable th) {
                m.b("TTVideoLandingPage", "shouldInterceptRequest url error", th);
                return super.shouldInterceptRequest(webView, str);
            }
        }
    }

    class e extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
        e(TTVideoLandingPageActivity tTVideoLandingPageActivity, x xVar, com.bytedance.sdk.openadsdk.d.j jVar) {
            super(xVar, jVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    class f implements DownloadListener {
        f() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            b.c.a.a.a.a.c cVar = TTVideoLandingPageActivity.this.B;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            if (tTVideoLandingPageActivity.A == null || tTVideoLandingPageActivity.isFinishing()) {
                return;
            }
            TTVideoLandingPageActivity.this.A.setText(this.a);
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SSWebView sSWebView = TTVideoLandingPageActivity.this.a;
            if (sSWebView != null) {
                if (sSWebView.c()) {
                    TTVideoLandingPageActivity.this.a.h();
                    return;
                }
                if (TTVideoLandingPageActivity.this.v()) {
                    TTVideoLandingPageActivity.this.onBackPressed();
                    return;
                }
                JSONObject jSONObjectA = null;
                NativeVideoTsView nativeVideoTsView = TTVideoLandingPageActivity.this.m;
                if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
                    TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                    jSONObjectA = a0.a(tTVideoLandingPageActivity.o, tTVideoLandingPageActivity.m.getNativeVideoController().l(), TTVideoLandingPageActivity.this.m.getNativeVideoController().h());
                }
                JSONObject jSONObject = jSONObjectA;
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                com.bytedance.sdk.openadsdk.d.c.a(tTVideoLandingPageActivity2.o, "embeded_ad", "detail_back", tTVideoLandingPageActivity2.l(), TTVideoLandingPageActivity.this.k(), jSONObject, (com.bytedance.sdk.openadsdk.d.g) null);
                TTVideoLandingPageActivity.this.finish();
            }
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeVideoTsView nativeVideoTsView = TTVideoLandingPageActivity.this.m;
            if (nativeVideoTsView != null) {
                JSONObject jSONObjectA = null;
                if (nativeVideoTsView.getNativeVideoController() != null) {
                    TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                    jSONObjectA = a0.a(tTVideoLandingPageActivity.o, tTVideoLandingPageActivity.m.getNativeVideoController().l(), TTVideoLandingPageActivity.this.m.getNativeVideoController().h());
                }
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                com.bytedance.sdk.openadsdk.d.c.a(tTVideoLandingPageActivity2.o, "embeded_ad", "detail_skip", tTVideoLandingPageActivity2.l(), TTVideoLandingPageActivity.this.k(), jSONObjectA, (com.bytedance.sdk.openadsdk.d.g) null);
            }
            TTVideoLandingPageActivity.this.finish();
        }
    }

    class j implements o<Bitmap> {
        j() {
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
        }

        @Override // b.b.a.a.h.o
        public void a(b.b.a.a.h.k<Bitmap> kVar) {
            try {
                Bitmap bitmapC = kVar.c();
                if (Build.VERSION.SDK_INT >= 17) {
                    new l(bitmapC, TTVideoLandingPageActivity.this.m.getNativeVideoController().g(), null).execute(new Void[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    class k implements b.a.a.a.a.a.a.g.c.b {
        k() {
        }

        @Override // b.a.a.a.a.a.a.g.c.b
        public void a(boolean z) {
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity.C = z;
            if (tTVideoLandingPageActivity.isFinishing()) {
                return;
            }
            if (!z) {
                b0.a((View) TTVideoLandingPageActivity.this.a, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.k.getLayoutParams();
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                marginLayoutParams.width = tTVideoLandingPageActivity2.r;
                marginLayoutParams.height = tTVideoLandingPageActivity2.s;
                marginLayoutParams.leftMargin = tTVideoLandingPageActivity2.q;
                marginLayoutParams.topMargin = tTVideoLandingPageActivity2.p;
                tTVideoLandingPageActivity2.k.setLayoutParams(marginLayoutParams);
                return;
            }
            b0.a((View) TTVideoLandingPageActivity.this.a, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.k.getLayoutParams();
            TTVideoLandingPageActivity tTVideoLandingPageActivity3 = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity3.q = marginLayoutParams2.leftMargin;
            tTVideoLandingPageActivity3.p = marginLayoutParams2.topMargin;
            tTVideoLandingPageActivity3.r = marginLayoutParams2.width;
            tTVideoLandingPageActivity3.s = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            tTVideoLandingPageActivity3.k.setLayoutParams(marginLayoutParams2);
        }
    }

    private static class l extends AsyncTask<Void, Void, Drawable> {
        private Bitmap a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<b.a.a.a.a.a.a.g.b> f420b;

        /* synthetic */ l(Bitmap bitmap, b.a.a.a.a.a.a.g.b bVar, c cVar) {
            this(bitmap, bVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap bitmapA = b.b.a.a.d.g.a.a(com.bytedance.sdk.openadsdk.core.o.a(), this.a, 25);
                if (bitmapA == null) {
                    return null;
                }
                return new BitmapDrawable(com.bytedance.sdk.openadsdk.core.o.a().getResources(), bitmapA);
            } catch (Throwable th) {
                m.b("TTVideoLandingPage", th.getMessage());
                return null;
            }
        }

        private l(Bitmap bitmap, b.a.a.a.a.a.a.g.b bVar) {
            this.a = bitmap;
            this.f420b = new WeakReference<>(bVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            WeakReference<b.a.a.a.a.a.a.g.b> weakReference;
            if (drawable == null || (weakReference = this.f420b) == null || weakReference.get() == null) {
                return;
            }
            this.f420b.get().a(drawable);
        }
    }

    static /* synthetic */ int c(TTVideoLandingPageActivity tTVideoLandingPageActivity) {
        int i2 = tTVideoLandingPageActivity.Q;
        tTVideoLandingPageActivity.Q = i2 + 1;
        return i2;
    }

    static /* synthetic */ int e(TTVideoLandingPageActivity tTVideoLandingPageActivity) {
        int i2 = tTVideoLandingPageActivity.P;
        tTVideoLandingPageActivity.P = i2 + 1;
        return i2;
    }

    static /* synthetic */ int g(TTVideoLandingPageActivity tTVideoLandingPageActivity) {
        int i2 = tTVideoLandingPageActivity.O;
        tTVideoLandingPageActivity.O = i2 + 1;
        return i2;
    }

    private void m() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null || u()) {
            return;
        }
        this.m.p();
    }

    private void n() {
        if (this.m == null || u()) {
            return;
        }
        this.m.p();
    }

    private void p() {
        q qVar = this.o;
        if (qVar == null || qVar.e0() != 4) {
            return;
        }
        this.z.setVisibility(0);
        Button button = (Button) findViewById(com.bytedance.sdk.openadsdk.utils.h.m0);
        this.A = button;
        if (button != null) {
            a(i());
            this.A.setOnClickListener(this.T);
            this.A.setOnTouchListener(this.T);
        }
    }

    private void r() {
        x xVar = new x(this);
        this.i = xVar;
        xVar.a(this.a).g(this.g).j(this.h).b(this.j).a(this.o).c(this.o.L0()).b(this.a).i("landingpage_split_screen").h(this.o.D());
    }

    private boolean u() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.m.getNativeVideoController().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return !TextUtils.isEmpty(this.H) && this.H.contains("__luban_sdk");
    }

    protected abstract boolean h();

    protected abstract View j();

    protected int k() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.m.getNativeVideoController().m();
    }

    protected long l() {
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.m.getNativeVideoController().a();
    }

    protected void o() {
        String strF0;
        q qVar = this.o;
        if (qVar == null || qVar.e0() != 4) {
            return;
        }
        b0.a((View) this.u, 0);
        if (!TextUtils.isEmpty(this.o.K0())) {
            strF0 = this.o.K0();
        } else if (TextUtils.isEmpty(this.o.B())) {
            strF0 = !TextUtils.isEmpty(this.o.F0()) ? this.o.F0() : "";
        } else {
            strF0 = this.o.B();
        }
        if (this.o.b0() != null && this.o.b0().d() != null) {
            b0.a((View) this.w, 0);
            b0.a((View) this.v, 4);
            com.bytedance.sdk.openadsdk.n.c.b().a(this.o.b0(), this.w, this.o);
        } else if (!TextUtils.isEmpty(strF0)) {
            b0.a((View) this.w, 4);
            b0.a((View) this.v, 0);
            this.v.setText(strF0.substring(0, 1));
        }
        if (!TextUtils.isEmpty(this.o.r())) {
            this.y.setText(this.o.r());
        }
        if (!TextUtils.isEmpty(strF0)) {
            this.x.setText(strF0);
        }
        b0.a((View) this.x, 0);
        b0.a((View) this.y, 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if (this.C && (nativeVideoTsView = this.m) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((b.a.a.a.a.a.a.g.a) this.m.getNativeVideoController()).d(null, null);
            this.C = false;
        } else if (!v() || this.L.getAndSet(true)) {
            super.onBackPressed();
        } else {
            b(true);
            c(0);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.l.e()) {
            finish();
            return;
        }
        Long lValueOf = Long.valueOf(SystemClock.elapsedRealtime());
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.o.a(this);
        } catch (Throwable unused2) {
        }
        this.I = p.b(getApplicationContext());
        try {
            setContentView(j());
            this.e = this;
            Intent intent = getIntent();
            this.f = intent.getIntExtra("sdk_version", 1);
            this.g = intent.getStringExtra("adid");
            this.h = intent.getStringExtra("log_extra");
            this.j = intent.getIntExtra("source", -1);
            this.H = intent.getStringExtra("url");
            String stringExtra = intent.getStringExtra("web_title");
            this.D = intent.getStringExtra("event_tag");
            this.M = intent.getStringExtra("gecko_id");
            this.G = intent.getBooleanExtra("video_is_auto_play", true);
            if (bundle != null && bundle.getLong("video_play_position") > 0) {
                this.n = bundle.getLong("video_play_position", 0L);
            }
            String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.o = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(stringExtra3));
                    } catch (Exception unused3) {
                    }
                }
                q qVar = this.o;
                if (qVar != null) {
                    this.l = qVar.c0();
                }
            } else {
                q qVarE = s.g().e();
                this.o = qVarE;
                if (qVarE != null) {
                    this.l = qVarE.c0();
                }
                s.g().a();
            }
            if (this.o == null) {
                finish();
                return;
            }
            if (!TextUtils.isEmpty(this.M)) {
                this.N = com.bytedance.sdk.openadsdk.f.b.c().a();
                int iA = com.bytedance.sdk.openadsdk.f.b.c().a(this.N, this.M);
                this.R = iA;
                this.S = iA > 0 ? 2 : 0;
            }
            if (stringExtra2 != null) {
                try {
                    this.J = com.bytedance.sdk.openadsdk.m.g.a.a(new JSONObject(stringExtra2));
                } catch (Exception unused4) {
                }
                com.bytedance.sdk.openadsdk.m.g.a aVar = this.J;
                if (aVar != null) {
                    this.n = aVar.g;
                }
            }
            if (bundle != null) {
                String string = bundle.getString("material_meta");
                if (this.o == null) {
                    try {
                        this.o = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(string));
                    } catch (Throwable unused5) {
                    }
                }
                long j2 = bundle.getLong("video_play_position");
                bundle.getBoolean("is_complete");
                if (j2 > 0) {
                    this.n = j2;
                }
            }
            t();
            q();
            r();
            c(4);
            int i2 = Build.VERSION.SDK_INT;
            boolean z = i2 >= 16;
            if (this.a != null) {
                com.bytedance.sdk.openadsdk.core.widget.webview.b.a(this.e).a(z).b(false).a(this.a.getWebView());
                com.bytedance.sdk.openadsdk.d.j jVarA = new com.bytedance.sdk.openadsdk.d.j(this.o, this.a.getWebView(), new c(), this.S).a(true);
                this.K = jVarA;
                jVarA.b("landingpage_split_screen");
            }
            this.a.setLandingPage(true);
            this.a.setTag("landingpage_split_screen");
            this.a.setMaterialMeta(this.o.L());
            this.a.setWebViewClient(new d(this.e, this.i, this.g, this.K, true));
            SSWebView sSWebView = this.a;
            if (sSWebView != null) {
                sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.utils.k.a(sSWebView.getWebView(), this.f));
            }
            if (i2 >= 21) {
                this.a.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.d.c.a(this.o, "landingpage_split_screen", this.S);
            n.a(this.a, this.H);
            this.a.setWebChromeClient(new e(this, this.i, this.K));
            this.a.setDownloadListener(new f());
            TextView textView = this.d;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = t.k(this, "tt_web_title_default");
                }
                textView.setText(stringExtra);
            }
            w();
            s();
            p();
            com.bytedance.sdk.openadsdk.d.c.o.a(SystemClock.elapsedRealtime() - lValueOf.longValue(), this.o, "landingpage_split_screen", this.N, this.M);
        } catch (Throwable unused6) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        x();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
            this.o.a(false);
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.a;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.a0.a(sSWebView.getWebView());
        }
        this.a = null;
        x xVar = this.i;
        if (xVar != null) {
            xVar.o();
        }
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.m.getNativeVideoController().c();
        }
        this.m = null;
        this.o = null;
        com.bytedance.sdk.openadsdk.d.j jVar = this.K;
        if (jVar != null) {
            jVar.d();
        }
        if (!TextUtils.isEmpty(this.M)) {
            com.bytedance.sdk.openadsdk.d.c.o.a(this.P, this.O, this.o);
        }
        com.bytedance.sdk.openadsdk.f.b.c().a(this.N);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        x xVar = this.i;
        if (xVar != null) {
            xVar.p();
        }
        n();
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        a(this.m.getNativeVideoController());
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.F) {
            m();
        }
        this.F = false;
        x xVar = this.i;
        if (xVar != null) {
            xVar.q();
        }
        com.bytedance.sdk.openadsdk.d.j jVar = this.K;
        if (jVar != null) {
            jVar.e();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        q qVar = this.o;
        bundle.putString("material_meta", qVar != null ? qVar.n1().toString() : null);
        bundle.putLong("video_play_position", this.n);
        bundle.putBoolean("is_complete", this.E);
        long jO = this.n;
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jO = this.m.getNativeVideoController().o();
        }
        bundle.putLong("video_play_position", jO);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.d.j jVar = this.K;
        if (jVar != null) {
            jVar.f();
        }
    }

    public void q() {
        q qVar = this.o;
        if (qVar == null) {
            return;
        }
        this.B = b.c.a.a.a.a.d.a(this, qVar, this.D);
        com.bytedance.sdk.openadsdk.core.c0.a aVar = new com.bytedance.sdk.openadsdk.core.c0.a(this, this.o, this.D, this.j);
        this.T = aVar;
        aVar.b(false);
        this.T.d(true);
        this.y.setOnClickListener(this.T);
        this.y.setOnTouchListener(this.T);
        this.T.a(this.B);
    }

    protected void s() {
        if (h()) {
            try {
                NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.e, this.o, true, null);
                this.m = nativeVideoTsView;
                if (nativeVideoTsView.getNativeVideoController() != null) {
                    this.m.getNativeVideoController().d(false);
                }
                if (this.E) {
                    this.k.setVisibility(0);
                    this.k.removeAllViews();
                    this.k.addView(this.m);
                    this.m.c(true);
                } else {
                    if (!this.G) {
                        this.n = 0L;
                    }
                    if (this.J != null && this.m.getNativeVideoController() != null) {
                        this.m.getNativeVideoController().b(this.J.g);
                        this.m.getNativeVideoController().a(this.J.e);
                        this.m.setIsQuiet(com.bytedance.sdk.openadsdk.core.o.d().f(String.valueOf(this.o.S())));
                    }
                    if (this.m.a(this.n, this.F, this.E)) {
                        this.k.setVisibility(0);
                        this.k.removeAllViews();
                        this.k.addView(this.m);
                    }
                    if (this.m.getNativeVideoController() != null) {
                        this.m.getNativeVideoController().d(false);
                        this.m.getNativeVideoController().a(this.U);
                    }
                }
                String strD = this.o.d0().get(0).d();
                com.bytedance.sdk.openadsdk.h.d.a().a(strD).b(this.o.d0().get(0).e()).a(this.o.d0().get(0).b()).d(b0.g(com.bytedance.sdk.openadsdk.core.o.a())).c(b0.i(com.bytedance.sdk.openadsdk.core.o.a())).a(u.BITMAP).a(new com.bytedance.sdk.openadsdk.h.b(this.o, strD, new j()), b.b.a.a.h.t.IO);
                this.m.findViewById(520093726).setOnTouchListener(null);
                this.m.findViewById(520093726).setOnClickListener(null);
            } catch (Exception e2) {
                m.b("TTVideoLandingPage", e2.getMessage());
            }
            if (this.I == 0) {
                try {
                    Toast.makeText(this, t.j(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    protected void t() {
        this.z = (PangleViewStub) findViewById(com.bytedance.sdk.openadsdk.utils.h.W);
        this.a = (SSWebView) findViewById(com.bytedance.sdk.openadsdk.utils.h.O);
        ImageView imageView = (ImageView) findViewById(520093720);
        this.f416b = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new h());
        }
        NativeVideoTsView nativeVideoTsView = this.m;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setIsAutoPlay(this.G);
        }
        ImageView imageView2 = (ImageView) findViewById(com.bytedance.sdk.openadsdk.utils.h.I);
        this.c = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new i());
        }
        this.d = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.o0);
        this.k = (FrameLayout) findViewById(com.bytedance.sdk.openadsdk.utils.h.H);
        this.u = (RelativeLayout) findViewById(com.bytedance.sdk.openadsdk.utils.h.J);
        this.v = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.L);
        this.x = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.M);
        this.y = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.h.N);
        this.w = (CornerIV) findViewById(com.bytedance.sdk.openadsdk.utils.h.K);
        o();
    }

    protected void w() {
        w.a(this.V, this.e);
    }

    protected void x() {
        try {
            w.a(this.V);
        } catch (Exception unused) {
        }
    }

    private void a(String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.A) == null) {
            return;
        }
        button.post(new g(str));
    }

    private void b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z);
            this.i.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    private void c(int i2) {
        if (this.c == null || !v()) {
            return;
        }
        y.a(new b(i2));
    }

    protected String i() {
        q qVar = this.o;
        if (qVar != null && !TextUtils.isEmpty(qVar.r())) {
            this.t = this.o.r();
        }
        return this.t;
    }

    private void a(b.a.a.a.a.a.a.g.c cVar) {
        this.E = this.E || cVar.n();
        Boolean bool = Boolean.TRUE;
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_is_update_flag", bool);
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(this.E));
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.o()));
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.a() + cVar.l()));
        com.bytedance.sdk.openadsdk.m.i.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.a()));
    }

    @Override // com.bytedance.sdk.openadsdk.i.d
    public void a(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null) {
            return;
        }
        jSONArray.length();
    }
}
