package com.bytedance.sdk.openadsdk.b.m.p;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import b.b.a.a.e.r;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullPlayableManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.openadsdk.k.g, Handler.Callback {
    private static final com.bytedance.sdk.openadsdk.o.f.a w = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f497b;
    private final Activity c;
    private final q d;
    private final String e;
    private final com.bytedance.sdk.openadsdk.b.m.p.a f;
    private m n;
    private PlayableLoadingView p;
    private HomeWatcherReceiver r;
    private com.bytedance.sdk.openadsdk.o.g s;
    private boolean t;
    private boolean u;
    protected final AtomicBoolean a = new AtomicBoolean(false);
    private final Handler g = new Handler(this);
    boolean h = false;
    boolean i = false;
    long j = 0;
    int k = 0;
    int l = 0;
    int m = 0;
    private int o = 1;
    private boolean q = true;
    private final com.bytedance.sdk.openadsdk.k.d v = new h();

    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    static class a implements com.bytedance.sdk.openadsdk.o.f.a {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.f.a
        public void a(String str, String str2) {
            com.bytedance.sdk.component.utils.m.a(str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.o.f.a
        public void a(String str, String str2, Throwable th) {
            com.bytedance.sdk.component.utils.m.b(str, str2, th);
        }
    }

    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    class c implements com.bytedance.sdk.openadsdk.o.c {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.c
        public void a(String str, JSONObject jSONObject) {
            g.this.f.Q.d().a(str, jSONObject);
        }
    }

    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    class d implements com.bytedance.sdk.openadsdk.l.a {
        d(g gVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("PlayablePlugin_is_null", true);
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("PlayablePlugin_init").c(jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    class e extends b.b.a.a.e.e<JSONObject, JSONObject> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference f499b;

        e(g gVar, WeakReference weakReference) {
            this.f499b = weakReference;
        }

        @Override // b.b.a.a.e.e
        public JSONObject a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
            try {
                com.bytedance.sdk.openadsdk.o.g gVar = (com.bytedance.sdk.openadsdk.o.g) this.f499b.get();
                if (gVar == null) {
                    return null;
                }
                return gVar.a(a(), jSONObject);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.p.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    class C0185g implements HomeWatcherReceiver.a {
        C0185g() {
        }

        @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.a
        public void a() {
            g.this.i = true;
        }

        @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.a
        public void b() {
            g.this.i = true;
        }
    }

    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    class h implements com.bytedance.sdk.openadsdk.k.d {
        h() {
        }

        @Override // com.bytedance.sdk.openadsdk.k.d
        public void a() {
            if (g.this.f.V.isFinishing() || !g.this.f.a.h1() || t.j(g.this.f.a)) {
                return;
            }
            g.this.g.removeMessages(800);
            g.this.g.sendMessage(g.d(1));
        }

        @Override // com.bytedance.sdk.openadsdk.k.d
        public void a(int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.k.d
        public void b() {
        }
    }

    public g(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.f = aVar;
        this.c = aVar.V;
        this.e = aVar.g;
        this.d = aVar.a;
    }

    private boolean g() {
        if (this.p == null) {
            return false;
        }
        if (this.d.h1() && t.h(this.d)) {
            this.p.p();
            return true;
        }
        this.p.n();
        return false;
    }

    private void h() {
        this.p = (PlayableLoadingView) this.c.findViewById(com.bytedance.sdk.openadsdk.utils.h.h1);
    }

    public void f() {
        if (this.t) {
            return;
        }
        this.t = true;
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f;
        this.n = aVar.Q;
        this.o = aVar.j;
        h();
        if (t.i(this.d)) {
            DeviceUtils.AudioInfoReceiver.a(this);
        }
        if (g() && t.h(this.d) && t.j(this.d)) {
            Handler handler = this.g;
            handler.sendMessageDelayed(handler.obtainMessage(800, 2, 0), 10000L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 900) {
            if (!this.f497b || !t.h(this.f.a)) {
                return true;
            }
            int i2 = message.arg1;
            if (i2 > 0) {
                this.f.R.b(true);
                int iC = this.f.I.c(i2);
                if (iC == i2) {
                    this.f.R.a(String.valueOf(i2), null);
                } else if (iC > 0) {
                    this.f.R.a(String.valueOf(i2), String.format(com.bytedance.sdk.component.utils.t.k(this.f.V.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(iC)));
                } else {
                    this.f.R.a(String.valueOf(i2), com.bytedance.sdk.component.utils.t.k(this.f.V.getApplicationContext(), "tt_txt_skip"));
                    this.f.R.d(true);
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                messageObtain.arg1 = i2 - 1;
                this.g.sendMessageDelayed(messageObtain, 1000L);
                this.f.I.b(i2);
            } else if (t.g(this.d)) {
                this.f.R.f();
                this.f.R.d(true);
            } else {
                this.f.R.b(false);
                this.f.D.set(true);
                this.f.Y.A();
            }
            this.f.V.u();
        } else if (i == 800) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                if (this.f.a.N0() != null) {
                    jSONObject.put("playable_url", this.f.a.N0().d());
                }
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFPM", "handleMessage json error", e2);
            }
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f;
            com.bytedance.sdk.openadsdk.d.c.b(aVar.a, aVar.V.a, "remove_loading_page", jSONObject);
            this.g.removeMessages(800);
            this.f.I.e();
        }
        return true;
    }

    public boolean i() {
        return this.h;
    }

    public boolean j() {
        return this.f497b;
    }

    public void k() {
        if (this.u) {
            return;
        }
        this.u = true;
        f(false);
        a(this.c.getApplicationContext());
        com.bytedance.sdk.openadsdk.o.g gVar = this.s;
        if (gVar != null) {
            gVar.a();
        }
        this.g.removeCallbacksAndMessages(null);
        DeviceUtils.AudioInfoReceiver.b(this);
    }

    public void l() {
        com.bytedance.sdk.openadsdk.o.g gVar = this.s;
        if (gVar != null) {
            gVar.u();
            this.s.c(false);
        }
        this.g.removeMessages(900);
    }

    public void m() {
        com.bytedance.sdk.openadsdk.o.g gVar = this.s;
        if (gVar != null) {
            gVar.v();
            if (b0.e(this.f.Q.c())) {
                this.s.c(true);
            }
        }
    }

    public void n() {
        this.g.removeMessages(900);
        this.g.removeMessages(600);
    }

    public void o() {
        try {
            HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
            this.r = homeWatcherReceiver;
            homeWatcherReceiver.a(new C0185g());
            this.c.getApplicationContext().registerReceiver(this.r, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    public void p() {
        this.h = true;
    }

    public void q() {
        if (this.a.getAndSet(true)) {
            return;
        }
        this.n.I();
        if (t.g(this.d)) {
            this.n.F();
        }
    }

    public void r() {
        this.j = System.currentTimeMillis();
        Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(900, a(), 0));
        f(true);
    }

    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    class f extends com.bytedance.sdk.openadsdk.core.widget.webview.d {
        f(Context context, x xVar, String str, com.bytedance.sdk.openadsdk.d.j jVar, boolean z) {
            super(context, xVar, str, jVar, z);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (g.this.q) {
                com.bytedance.sdk.openadsdk.d.c.c(g.this.d, g.this.e, "loading_h5_success", null);
            }
            super.onPageFinished(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            g.this.q = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            g.this.q = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            g.this.q = false;
        }
    }

    private String c() {
        String strL = o.d().L();
        com.bytedance.sdk.component.utils.m.d("Playable", "getPlayableLoadH5Url->loadH5Url=" + strL);
        if (TextUtils.isEmpty(strL) || this.d.h() == null) {
            return strL;
        }
        String strA = this.d.h().a();
        double dF = this.d.h().f();
        int iC = this.d.h().c();
        String strD = (this.d.b0() == null || TextUtils.isEmpty(this.d.b0().d())) ? "" : this.d.b0().d();
        String strE = this.d.e();
        String strE2 = this.d.h().e();
        String strD2 = this.d.h().d();
        String strA2 = this.d.h().a();
        String strK0 = this.d.K0();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appname=").append(URLEncoder.encode(strA)).append("&stars=").append(dF).append("&comments=").append(iC).append("&icon=").append(URLEncoder.encode(strD)).append("&downloading=").append(true).append("&id=").append(URLEncoder.encode(strE)).append("&packageName=").append(URLEncoder.encode(strE2)).append("&downloadUrl=").append(URLEncoder.encode(strD2)).append("&name=").append(URLEncoder.encode(strA2)).append("&orientation=").append(this.o == 1 ? TJAdUnitConstants.String.PORTRAIT : TJAdUnitConstants.String.LANDSCAPE).append("&apptitle=").append(URLEncoder.encode(strK0));
        String str = strL + "?" + ((Object) stringBuffer);
        com.bytedance.sdk.component.utils.m.d("Playable", "Playable-loadH5Url=" + str);
        return str;
    }

    public static Message d(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 800;
        messageObtain.arg1 = i;
        return messageObtain;
    }

    public void b(int i) {
        this.k = i - 1;
    }

    public void e(boolean z) {
        if (z) {
            try {
                if (!TextUtils.isEmpty(this.n.b()) && this.n.g() != 0) {
                    com.bytedance.sdk.openadsdk.l.b.a().a(this.n.b(), this.n.g(), this.n.i());
                }
            } catch (Throwable unused) {
            }
        }
        if (z) {
            try {
                if (TextUtils.isEmpty(this.n.b())) {
                    return;
                }
                com.bytedance.sdk.openadsdk.l.b.a().b(this.n.b());
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullPlayableManager.java */
    class b extends com.bytedance.sdk.openadsdk.o.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.k.e a;

        b(com.bytedance.sdk.openadsdk.k.e eVar) {
            this.a = eVar;
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public com.bytedance.sdk.openadsdk.o.d a() {
            String strE = com.bytedance.sdk.openadsdk.common.a.e();
            strE.hashCode();
            strE.hashCode();
            switch (strE) {
                case "2g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_2G;
                case "3g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_3G;
                case "4g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_4G;
                case "5g":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_5G;
                case "wifi":
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_WIFI;
                default:
                    return com.bytedance.sdk.openadsdk.o.d.TYPE_UNKNOWN;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void a(JSONObject jSONObject) {
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void b() {
            g.this.f.Q.d().d(true);
            com.bytedance.sdk.openadsdk.k.e eVar = this.a;
            if (eVar != null) {
                eVar.a();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void c(JSONObject jSONObject) {
        }

        @Override // com.bytedance.sdk.openadsdk.o.a
        public void b(JSONObject jSONObject) {
            com.bytedance.sdk.openadsdk.d.c.b(g.this.d, g.this.e, "playable_track", jSONObject);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.k.e eVar, boolean z) {
        r rVarB;
        if (t.i(this.d)) {
            if (com.bytedance.sdk.openadsdk.core.h.a().p()) {
                com.bytedance.sdk.openadsdk.o.f.a(w);
            }
            b bVar = new b(eVar);
            c cVar = new c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BidResponsedEx.KEY_CID, this.d.e());
                jSONObject.put("log_extra", this.d.N());
                com.bytedance.sdk.openadsdk.o.g gVarA = com.bytedance.sdk.openadsdk.o.g.a(o.a(), this.f.Q.c().getWebView(), cVar, bVar).j(this.f.Q.b()).g(com.bytedance.sdk.openadsdk.common.a.a(o.a())).e(com.bytedance.sdk.openadsdk.common.a.b()).e(jSONObject).a("sdkEdition", com.bytedance.sdk.openadsdk.common.a.f()).h(com.bytedance.sdk.openadsdk.common.a.d()).f(com.bytedance.sdk.openadsdk.common.a.c()).b(false).a(z);
                this.s = gVarA;
                if (gVarA == null) {
                    com.bytedance.sdk.openadsdk.l.b.a("PlayablePlugin_init", false, (com.bytedance.sdk.openadsdk.l.a) new d(this));
                }
            } catch (Exception unused) {
                if (this.s == null) {
                    com.bytedance.sdk.openadsdk.l.b.a("PlayablePlugin_init", false, (com.bytedance.sdk.openadsdk.l.a) new d(this));
                }
            } catch (Throwable th) {
                if (this.s == null) {
                    com.bytedance.sdk.openadsdk.l.b.a("PlayablePlugin_init", false, (com.bytedance.sdk.openadsdk.l.a) new d(this));
                }
                throw th;
            }
            if (this.s != null && !TextUtils.isEmpty(t.d(this.d))) {
                this.s.i(t.d(this.d));
            }
            com.bytedance.sdk.openadsdk.o.g gVar = this.s;
            if (gVar != null) {
                Set<String> setJ = gVar.j();
                WeakReference weakReference = new WeakReference(this.s);
                for (String str : setJ) {
                    if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (rVarB = this.f.Q.d().b()) != null) {
                        rVarB.a(str, new e(this, weakReference));
                    }
                }
            }
        }
    }

    public void b(boolean z) {
        com.bytedance.sdk.openadsdk.o.g gVar = this.s;
        if (gVar != null) {
            gVar.c(z);
        }
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.o.g gVar = this.s;
        if (gVar != null) {
            gVar.d(str);
        }
    }

    public void d(boolean z) {
        if (Build.VERSION.SDK_INT < 19 || !z) {
            return;
        }
        this.n.c().setDomStorageEnabled(true);
    }

    public com.bytedance.sdk.openadsdk.k.d b() {
        return this.v;
    }

    public int d() {
        return this.k;
    }

    public void e() {
        PlayableLoadingView playableLoadingView = this.p;
        if (playableLoadingView != null) {
            playableLoadingView.n();
        }
    }

    public void e(int i) {
        this.k = i;
    }

    public void f(int i) {
        PlayableLoadingView playableLoadingView = this.p;
        if (playableLoadingView != null) {
            playableLoadingView.setProgress(i);
        }
    }

    public void f(boolean z) {
        this.f497b = z;
        if (z) {
            return;
        }
        this.g.removeMessages(900);
    }

    public void c(String str) {
        if (this.i) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.j);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFPM", "sendPlayableEvent error", e2);
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.d, this.e, str, jSONObject);
            if ("return_foreground".equals(str)) {
                this.i = false;
            }
        }
    }

    public int c(int i) {
        return this.m - (this.l - i);
    }

    public void c(boolean z) {
        if (z) {
            boolean zH = t.h(this.d);
            if (zH && this.d.h1() && !t.j(this.d)) {
                Handler handler = this.g;
                handler.sendMessageDelayed(handler.obtainMessage(800, 0, 0), 1000L);
            }
            if (zH) {
                this.f.I.q();
                this.f.Q.c(true);
                this.f.Q.a(true);
                com.bytedance.sdk.openadsdk.d.c.c(this.f.a, this.e, "py_loading_success", null);
            }
        }
    }

    public void a(DownloadListener downloadListener) {
        SSWebView sSWebViewH = this.n.h();
        if (sSWebViewH == null) {
            return;
        }
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        sSWebViewH.setWebViewClient(new f(this.c, this.n.e(), this.d.e(), null, false));
        com.bytedance.sdk.component.utils.m.a("TTAD.RFPM", "startWebViewLoading: " + strC);
        sSWebViewH.c(strC);
        sSWebViewH.setDisplayZoomControls(false);
        sSWebViewH.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.n.e(), this.n.f()));
        sSWebViewH.setDownloadListener(downloadListener);
    }

    private void a(Context context) {
        try {
            this.r.a(null);
            context.getApplicationContext().unregisterReceiver(this.r);
        } catch (Throwable unused) {
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.j);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFPM", "endShow json error", e2);
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.c0.e eVar) {
        PlayableLoadingView playableLoadingView = this.p;
        if (playableLoadingView == null || playableLoadingView.getPlayView() == null || !t.h(this.d)) {
            return;
        }
        this.p.getPlayView().setOnClickListener(eVar);
        this.p.getPlayView().setOnTouchListener(eVar);
    }

    public int a() {
        return this.l;
    }

    public void a(int i, q qVar, boolean z) {
        if (qVar == null) {
            return;
        }
        this.l = qVar.r0();
        this.m = o.d().a(String.valueOf(i), z);
    }

    @Override // com.bytedance.sdk.openadsdk.k.g
    public void a(int i) {
        if (!t.m(this.f.a) || this.f.u.get()) {
            if (t.h(this.f.a) || t.m(this.f.a)) {
                if (this.f.O.b()) {
                    com.bytedance.sdk.component.utils.m.a("TTAD.RFPM", "onVolumeChanged by SDK mIsMute=" + this.f.d + " mVolume=" + i + " mLastVolume=" + this.f.O.a());
                    if (i == 0) {
                        this.f.R.e(true);
                        this.f.G.b(true);
                        return;
                    } else {
                        this.f.R.e(false);
                        this.f.G.b(false);
                        return;
                    }
                }
                this.f.O.a(-1);
                com.bytedance.sdk.component.utils.m.a("TTAD.RFPM", "onVolumeChanged by User mIsMute=" + this.f.d + " mVolume=" + i + " mLastVolume=" + this.f.O.a());
                com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f;
                if (aVar.e) {
                    if (i == 0) {
                        aVar.d = true;
                        aVar.R.e(true);
                        this.f.G.b(true);
                    } else {
                        aVar.d = false;
                        aVar.R.e(false);
                        this.f.G.b(false);
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        com.bytedance.sdk.openadsdk.o.g gVar = this.s;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public void a(int i, String str, String str2) {
        try {
            com.bytedance.sdk.openadsdk.o.g gVar = this.s;
            if (gVar != null) {
                gVar.a(i, str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public void a(boolean z, String str, int i) {
        try {
            com.bytedance.sdk.openadsdk.o.g gVar = this.s;
            if (gVar != null) {
                gVar.a(z, str, i);
            }
        } catch (Exception unused) {
        }
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.o.g gVar = this.s;
        if (gVar != null) {
            gVar.c(str);
        }
    }

    public void a(long j) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 900;
        messageObtain.arg1 = d();
        this.g.sendMessageDelayed(messageObtain, j);
    }
}
