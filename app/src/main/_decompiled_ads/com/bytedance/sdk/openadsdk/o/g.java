package com.bytedance.sdk.openadsdk.o;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayablePlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private com.bytedance.sdk.openadsdk.o.a A;
    private com.bytedance.sdk.openadsdk.o.c B;
    private int C;
    private int D;
    private JSONObject E;
    private String F;
    private String G;
    private String H;
    private Map<String, String> I;
    private JSONObject J;
    private String K;
    private JSONObject L;
    private float M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private String X;
    private boolean Y;
    private boolean Z;
    private boolean a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f815b;
    private boolean b0;
    private Runnable c;
    private String c0;
    private String d0;
    private TimerTask e;
    private boolean e0;
    private com.bytedance.sdk.openadsdk.o.b f;
    private ViewTreeObserver.OnGlobalLayoutListener f0;
    private String h;
    private String i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private int t;
    private int u;
    private h v;
    private Context w;
    private WebView x;
    private WeakReference<View> y;
    private com.bytedance.sdk.openadsdk.o.e z;
    private final Handler a = new Handler(Looper.getMainLooper());
    private Timer d = new Timer();
    private boolean g = true;

    /* JADX INFO: compiled from: PlayablePlugin.java */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                View view = (View) g.this.y.get();
                if (view == null) {
                    return;
                }
                g.this.a(view);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "onSizeChanged error", th);
            }
        }
    }

    /* JADX INFO: compiled from: PlayablePlugin.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.k) {
                g.this.k = false;
                g.this.a.removeCallbacks(g.this.c);
                g.this.b(2, "ContainerLoadTimeOut");
            }
        }
    }

    /* JADX INFO: compiled from: PlayablePlugin.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.k) {
                g.this.k = false;
                g.this.a.removeCallbacks(g.this.f815b);
                g.this.b(3, "JSSDKLoadTimeOut");
            }
        }
    }

    /* JADX INFO: compiled from: PlayablePlugin.java */
    class d extends TimerTask {

        /* JADX INFO: compiled from: PlayablePlugin.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.o.g$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: PlayablePlugin.java */
            class C0251a implements ValueCallback<String> {
                C0251a() {
                }

                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    if (g.this.f != null) {
                        g.this.f.a(System.currentTimeMillis());
                    }
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT < 19 || g.this.x == null) {
                    return;
                }
                g.this.x.evaluateJavascript("javascript:playable_callJS()", new C0251a());
            }
        }

        d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            g.this.a.post(new a());
        }
    }

    /* JADX INFO: compiled from: PlayablePlugin.java */
    class e implements ValueCallback<String> {
        e(g gVar) {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            com.bytedance.sdk.openadsdk.o.f.a("Playable_CrashMonitor", "load inject js=" + str);
        }
    }

    /* JADX INFO: compiled from: PlayablePlugin.java */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.h(g.this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.o.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlayablePlugin.java */
    class RunnableC0252g implements Runnable {
        RunnableC0252g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.i(g.this);
        }
    }

    /* JADX INFO: compiled from: PlayablePlugin.java */
    enum h {
        MAIN,
        RIFLE
    }

    private g(Context context, WebView webView, com.bytedance.sdk.openadsdk.o.c cVar, com.bytedance.sdk.openadsdk.o.a aVar) {
        new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.h = null;
        this.i = "embeded_ad";
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = 10L;
        this.n = 10L;
        this.o = 0L;
        this.p = -1L;
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
        this.t = 0;
        this.u = 0;
        this.C = 0;
        this.D = 0;
        this.E = new JSONObject();
        this.I = new HashMap();
        this.e0 = false;
        this.f0 = new a();
        this.v = h.MAIN;
        this.x = webView;
        com.bytedance.sdk.openadsdk.o.h.b(webView);
        b(webView);
        a(context, cVar, aVar);
        q();
    }

    static /* synthetic */ int h(g gVar) {
        int i = gVar.t;
        gVar.t = i + 1;
        return i;
    }

    static /* synthetic */ int i(g gVar) {
        int i = gVar.u;
        gVar.u = i + 1;
        return i;
    }

    private void q() {
        this.f = new com.bytedance.sdk.openadsdk.o.b(this);
        this.f815b = new b();
        this.c = new c();
        this.e = new d();
    }

    private boolean r() {
        String str = this.K;
        if (str != null) {
            return str.contains("/union-fe/playable/") || this.K.contains("/union-fe-sg/playable/") || this.K.contains("/union-fe-i18n/playable/");
        }
        return false;
    }

    public Set<String> j() {
        return this.z.a();
    }

    public Map<String, String> k() {
        return this.I;
    }

    public com.bytedance.sdk.openadsdk.o.d l() {
        return this.A.a();
    }

    public JSONObject m() {
        return this.L;
    }

    public JSONObject n() {
        return this.E;
    }

    public boolean o() {
        return this.Z;
    }

    public JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.M);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.N);
            jSONObject2.put("height", this.O);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.Q);
            jSONObject3.put("y", this.P);
            jSONObject3.put("width", this.R);
            jSONObject3.put("height", this.S);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.U);
            jSONObject4.put("y", this.T);
            jSONObject4.put("width", this.V);
            jSONObject4.put("height", this.W);
            jSONObject.put(TJAdUnitConstants.String.VISIBLE, jSONObject4);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void s() {
        this.a.removeCallbacks(this.f815b);
        this.a.removeCallbacks(this.c);
    }

    public String t() {
        return "function playable_callJS(){return \"Android call the JS method is callJS\";}";
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
        com.bytedance.sdk.openadsdk.o.f.a("Playable_CrashMonitor", "-- Detected that the page is stuck for more than 2s and needs to be reported");
        b("PL_sdk_page_stuck", (JSONObject) null);
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void x() {
        this.M = 0.0f;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
    }

    public void y() {
        this.A.b();
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        try {
            this.y = new WeakReference<>(view);
            a(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f0);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public g c(boolean z) {
        if (this.Z == z) {
            return this;
        }
        this.Z = z;
        b(z ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", (JSONObject) null);
        if (this.q == -1 && this.Z) {
            this.q = System.currentTimeMillis();
            b("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.Z) {
            this.p = System.currentTimeMillis();
        } else if (this.p != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.p;
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "playable show time +" + jCurrentTimeMillis);
            this.o += jCurrentTimeMillis;
            this.p = -1L;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", this.Z);
            d("viewableChange", jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "setViewable error", th);
        }
        return this;
    }

    public String d() {
        return this.F;
    }

    public g e(String str) {
        this.F = str;
        return this;
    }

    public Context f() {
        return this.w;
    }

    public g g(String str) {
        this.X = str;
        return this;
    }

    public g h(String str) {
        this.G = str;
        return this;
    }

    public g i(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.L = jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "setPlayableStyle error", th);
        }
        return this;
    }

    public g j(String str) {
        if (str != null) {
            try {
                int iIndexOf = str.indexOf("?");
                if (iIndexOf != -1) {
                    str = str.substring(0, iIndexOf);
                }
            } catch (Throwable unused) {
            }
        }
        this.K = str;
        return this;
    }

    public void d(String str, JSONObject jSONObject) {
        if (com.bytedance.sdk.openadsdk.o.f.a()) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "CALL JS [" + str + "] " + (jSONObject != null ? jSONObject.toString() : ""));
        }
        com.bytedance.sdk.openadsdk.o.c cVar = this.B;
        if (cVar != null) {
            cVar.a(str, jSONObject);
        }
    }

    public String e() {
        return this.H;
    }

    public g f(String str) {
        this.H = str;
        return this;
    }

    public String g() {
        return this.X;
    }

    public String h() {
        return this.G;
    }

    private void a(Context context, com.bytedance.sdk.openadsdk.o.c cVar, com.bytedance.sdk.openadsdk.o.a aVar) {
        this.h = UUID.randomUUID().toString();
        this.w = context;
        this.z = new com.bytedance.sdk.openadsdk.o.e(this);
        this.A = aVar;
        this.B = cVar;
    }

    public g e(JSONObject jSONObject) {
        this.J = jSONObject;
        return this;
    }

    public g b(boolean z) {
        this.a0 = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.a0);
            d("change_playable_click", jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public boolean i() {
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.C == view.getWidth() && this.D == view.getHeight()) {
                return;
            }
            this.C = view.getWidth();
            this.D = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.C);
            jSONObject.put("height", this.D);
            d("resize", jSONObject);
            this.E = jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public void d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            this.r = System.currentTimeMillis();
            jSONObject.put("playable_full_url", str);
            long j = this.q;
            jSONObject.put("playable_page_show_duration", j != -1 ? this.r - j : 0L);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        b("PL_sdk_html_load_start", jSONObject);
        if (this.j && this.v == h.MAIN) {
            this.a.postDelayed(this.f815b, this.m * 1000);
            this.a.postDelayed(this.c, this.n * 1000);
            this.j = false;
        }
    }

    public com.bytedance.sdk.openadsdk.o.a b() {
        return this.A;
    }

    protected void b(int i, String str) {
        a(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportRenderFatal error", th);
        }
        b("PL_sdk_global_faild", jSONObject);
    }

    public g a(String str, String str2) {
        this.I.put(str, str2);
        return this;
    }

    public g a(boolean z) {
        this.Y = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.Y);
            d("volumeChange", jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    private String b(String str, String str2) {
        return String.format("rubeex://playable-lynx?accessKey=%1s&groupId=%2s&cardId=main", str, str2);
    }

    private void b(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.Z);
            jSONObject.put("playable_session_id", this.h);
            h hVar = this.v;
            h hVar2 = h.MAIN;
            if (hVar == hVar2) {
                jSONObject.put("playable_url", this.K);
            } else {
                jSONObject.put("playable_url", b(this.c0, this.d0));
            }
            jSONObject.put("playable_is_prerender", this.b0);
            jSONObject.put("playable_render_type", this.v.ordinal());
            jSONObject.put("playable_sdk_version", "5.2.2");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.i);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.J.opt(BidResponsedEx.KEY_CID));
            jSONObject2.put("log_extra", this.J.opt("log_extra"));
            if (this.A != null) {
                if (this.v == hVar2 && r()) {
                    com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportEvent by ActionProxy");
                    this.A.a("playable_track", jSONObject2);
                    this.A.b(jSONObject);
                    return;
                } else {
                    if (this.v != hVar2) {
                        com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportEvent by ActionProxy");
                        this.A.a("playable_track", jSONObject2);
                        this.A.b(jSONObject);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportEvent error no not playable url");
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportEvent error no impl");
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportEvent error", th);
        }
    }

    protected void d(JSONObject jSONObject) {
        this.A.f(jSONObject);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optBoolean("success", true) || !this.k) {
            return;
        }
        this.k = false;
        this.a.removeCallbacks(this.f815b);
        this.a.removeCallbacks(this.c);
        b(4, "CaseRenderFail");
    }

    private void a(int i, String str) {
        if (this.A == null || !r()) {
            return;
        }
        this.A.a(i, str);
    }

    public JSONObject c() {
        return this.J;
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.o.b bVar;
        JSONObject jSONObject = new JSONObject();
        try {
            this.s = System.currentTimeMillis();
            jSONObject.put("playable_full_url", str);
            long j = this.r;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? this.s - j : 0L);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        b("PL_sdk_html_load_finish", jSONObject);
        this.a.removeCallbacks(this.f815b);
        if (Build.VERSION.SDK_INT >= 19 && this.g) {
            this.g = false;
            this.x.evaluateJavascript(t(), new e(this));
        }
        try {
            if (this.v == h.MAIN && this.l && (bVar = this.f) != null) {
                this.l = false;
                bVar.a(System.currentTimeMillis());
                this.d.schedule(this.e, 0L, 1500L);
                this.f.a(1000);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void a(String str) {
        this.a.post(new f());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:36:0x002e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void a() {
        /*
            r7 = this;
            boolean r0 = r7.e0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r7.e0 = r0
            r7.x()
            java.lang.ref.WeakReference<android.view.View> r0 = r7.y     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L2e
            android.view.View r0 = (android.view.View) r0     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L2e
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2e
            r2 = 16
            if (r1 < r2) goto L25
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()     // Catch: java.lang.Throwable -> L2e
            android.view.ViewTreeObserver$OnGlobalLayoutListener r1 = r7.f0     // Catch: java.lang.Throwable -> L2e
            r0.removeOnGlobalLayoutListener(r1)     // Catch: java.lang.Throwable -> L2e
            goto L2e
        L25:
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()     // Catch: java.lang.Throwable -> L2e
            android.view.ViewTreeObserver$OnGlobalLayoutListener r1 = r7.f0     // Catch: java.lang.Throwable -> L2e
            r0.removeGlobalOnLayoutListener(r1)     // Catch: java.lang.Throwable -> L2e
        L2e:
            com.bytedance.sdk.openadsdk.o.e r0 = r7.z     // Catch: java.lang.Throwable -> L33
            r0.e()     // Catch: java.lang.Throwable -> L33
        L33:
            java.util.Timer r0 = r7.d     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L3a
            r0.cancel()     // Catch: java.lang.Throwable -> L45
        L3a:
            com.bytedance.sdk.openadsdk.o.b r0 = r7.f     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L5e
            r0.a()     // Catch: java.lang.Throwable -> L45
            r0 = 0
            r7.f = r0     // Catch: java.lang.Throwable -> L45
            goto L5e
        L45:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "crash -- "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Playable_CrashMonitor"
            com.bytedance.sdk.openadsdk.o.f.a(r1, r0)
        L5e:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L76
            r0.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "playable_all_times"
            int r2 = r7.t     // Catch: java.lang.Throwable -> L76
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "playable_hit_times"
            int r2 = r7.u     // Catch: java.lang.Throwable -> L76
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "PL_sdk_preload_times"
            r7.b(r1, r0)     // Catch: java.lang.Throwable -> L76
        L76:
            long r0 = r7.p     // Catch: java.lang.Throwable -> Lb5
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La4
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb5
            long r4 = r7.p     // Catch: java.lang.Throwable -> Lb5
            long r0 = r0 - r4
            java.lang.String r4 = "PlayablePlugin"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r5.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r6 = "playable show time +"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb5
            com.bytedance.sdk.openadsdk.o.f.a(r4, r5)     // Catch: java.lang.Throwable -> Lb5
            long r4 = r7.o     // Catch: java.lang.Throwable -> Lb5
            long r4 = r4 + r0
            r7.o = r4     // Catch: java.lang.Throwable -> Lb5
            r7.p = r2     // Catch: java.lang.Throwable -> Lb5
        La4:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb5
            r0.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r1 = "playable_user_play_duration"
            long r2 = r7.o     // Catch: java.lang.Throwable -> Lb5
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r1 = "PL_sdk_user_play_duration"
            r7.b(r1, r0)     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.o.g.a():void");
    }

    protected void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str, jSONObject);
    }

    protected void c(JSONObject jSONObject) {
        this.A.e(jSONObject);
    }

    public void b(String str) {
        this.a.post(new RunnableC0252g());
    }

    protected void b(JSONObject jSONObject) {
        this.A.d(jSONObject);
    }

    public void a(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i);
            jSONObject.put("description", str);
            jSONObject.put("failingUrl", str2);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "onWebReceivedError error", th);
        }
        b("PL_sdk_html_load_error", jSONObject);
        if (this.k) {
            this.k = false;
            this.a.removeCallbacks(this.f815b);
            this.a.removeCallbacks(this.c);
            b(1, "ContainerLoadFail");
        }
    }

    public void a(boolean z, String str, int i) {
        if (z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i);
                jSONObject.put("failingUrl", str);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            b("PL_sdk_html_load_error", jSONObject);
            if (this.k) {
                this.k = false;
                this.a.removeCallbacks(this.f815b);
                this.a.removeCallbacks(this.c);
                b(1, "ContainerLoadFail");
            }
        }
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (com.bytedance.sdk.openadsdk.o.f.a()) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "PlayablePlugin JSB-REQ [" + str + "] " + (jSONObject != null ? jSONObject.toString() : ""));
        }
        JSONObject jSONObjectA = this.z.a(str, jSONObject);
        if (com.bytedance.sdk.openadsdk.o.f.a()) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayablePlugin", "PlayablePlugin JSB-RSP [" + str + "] time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + (jSONObjectA != null ? jSONObjectA.toString() : ""));
        }
        return jSONObjectA;
    }

    public static g a(Context context, WebView webView, com.bytedance.sdk.openadsdk.o.c cVar, com.bytedance.sdk.openadsdk.o.a aVar) {
        if (webView == null || cVar == null || aVar == null) {
            return null;
        }
        return new g(context, webView, cVar, aVar);
    }
}
