package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class IAConfigManager {
    public static long N;
    public final com.fyber.inneractive.sdk.util.e0 A;
    public com.fyber.inneractive.sdk.network.c0<c> B;
    public com.fyber.inneractive.sdk.network.c0<com.fyber.inneractive.sdk.config.global.l> C;
    public com.fyber.inneractive.sdk.config.d D;
    public final com.fyber.inneractive.sdk.ignite.c E;
    public final com.fyber.inneractive.sdk.dv.handler.a F;
    public final com.fyber.inneractive.sdk.cache.i G;
    public final com.fyber.inneractive.sdk.network.c H;
    public final Map<com.fyber.inneractive.sdk.util.t, com.fyber.inneractive.sdk.util.s> I;
    public com.fyber.inneractive.sdk.measurement.a J;
    public WebView K;
    public final com.fyber.inneractive.sdk.config.global.s L;
    public Map<String, z> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, a0> f864b = new HashMap();
    public String c;
    public String d;
    public String e;
    public Context f;
    public List<OnConfigurationReadyAndValidListener> g;
    public boolean h;
    public final s i;
    public InneractiveUserConfig j;
    public String k;
    public boolean l;
    public String m;
    public InneractiveMediationName n;
    public String o;
    public String p;
    public List<String> q;
    public boolean r;
    public final com.fyber.inneractive.sdk.network.y s;
    public String t;
    public j u;
    public com.fyber.inneractive.sdk.config.e v;
    public k w;
    public final f0 x;
    public s0 y;
    public com.fyber.inneractive.sdk.config.global.a z;
    public static final IAConfigManager M = new IAConfigManager();
    public static final Runnable O = new b();

    public interface OnConfigurationReadyAndValidListener {
        void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc);
    }

    public class a extends WebViewClient {
        public a(IAConfigManager iAConfigManager) {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            WebView webView = iAConfigManager.K;
            if (webView == null || iAConfigManager.f == null) {
                return;
            }
            webView.destroy();
            iAConfigManager.K = iAConfigManager.a(iAConfigManager.f);
        }
    }

    public static class c {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f865b;
        public String c;
        public Map<String, z> d = new HashMap();
        public Map<String, a0> e = new HashMap();
        public e f = new e();
    }

    public static class d extends Exception {
    }

    public static class e {
        public Set<Vendor> a = new HashSet();
    }

    public IAConfigManager() {
        new HashSet();
        this.h = false;
        this.i = new s();
        this.l = false;
        this.r = false;
        this.s = new com.fyber.inneractive.sdk.network.y();
        this.t = "";
        this.x = new f0();
        this.A = new com.fyber.inneractive.sdk.util.e0();
        this.E = new com.fyber.inneractive.sdk.ignite.c();
        this.F = com.fyber.inneractive.sdk.util.l.a("com.google.android.gms.ads.MobileAds", "com.google.android.gms.ads.query.QueryInfoGenerationCallback") ? new com.fyber.inneractive.sdk.dv.handler.c() : new com.fyber.inneractive.sdk.dv.handler.d();
        this.G = new com.fyber.inneractive.sdk.cache.i();
        this.H = new com.fyber.inneractive.sdk.network.c();
        this.I = new HashMap();
        this.L = com.fyber.inneractive.sdk.config.global.s.b();
        this.g = new CopyOnWriteArrayList();
    }

    public static void a(String str, String str2) {
        com.fyber.inneractive.sdk.util.m.f1343b.post(new r(str, str2));
    }

    public static void addListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        M.g.add(onConfigurationReadyAndValidListener);
    }

    public static com.fyber.inneractive.sdk.config.e b() {
        return M.v;
    }

    public static j c() {
        return M.u;
    }

    public static com.fyber.inneractive.sdk.ignite.c d() {
        return M.E;
    }

    public static f0 e() {
        return M.x;
    }

    public static s0 f() {
        return M.y;
    }

    public static String g() {
        return M.D.d;
    }

    public static boolean h() {
        return M.e != null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0030 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    /* JADX WARN: Code duplicated, block: B:9:0x002e A[DONT_INVERT] */
    public static boolean i() {
        boolean zH = h();
        int i = f.a;
        boolean zBooleanValue = Boolean.valueOf(System.getProperty("ia.testEnvironmentConfiguration.forceConfigRefresh", Boolean.toString(false))).booleanValue();
        if (zH) {
            if (!(System.currentTimeMillis() - N <= 3600000)) {
                if (zBooleanValue) {
                    j jVar = M.u;
                    jVar.d = false;
                    com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.util.k(jVar.e));
                }
                a();
                M.G.a();
                com.fyber.inneractive.sdk.web.z zVar = com.fyber.inneractive.sdk.web.z.c;
                zVar.getClass();
                com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.web.y(zVar));
            } else if (zBooleanValue) {
                if (zBooleanValue) {
                    j jVar2 = M.u;
                    jVar2.d = false;
                    com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.util.k(jVar2.e));
                }
                a();
                M.G.a();
                com.fyber.inneractive.sdk.web.z zVar2 = com.fyber.inneractive.sdk.web.z.c;
                zVar2.getClass();
                com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.web.y(zVar2));
            }
        } else if (zBooleanValue) {
            if (zBooleanValue) {
                j jVar3 = M.u;
                jVar3.d = false;
                com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.util.k(jVar3.e));
            }
            a();
            M.G.a();
            com.fyber.inneractive.sdk.web.z zVar3 = com.fyber.inneractive.sdk.web.z.c;
            zVar3.getClass();
            com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.web.y(zVar3));
        }
        return zH;
    }

    public static void removeListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        M.g.remove(onConfigurationReadyAndValidListener);
    }

    public final WebView a(Context context) {
        try {
            WebView webView = new WebView(context);
            webView.setWebViewClient(new a(this));
            return webView;
        } catch (Throwable unused) {
            IAlog.a("failed to create a new webview", new Object[0]);
            return null;
        }
    }

    public final void a(Exception exc) {
        for (OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener : this.g) {
            if (onConfigurationReadyAndValidListener != null) {
                boolean zH = h();
                IAlog.d("notifying listener configuration state has been resolved", new Object[0]);
                onConfigurationReadyAndValidListener.onConfigurationReadyAndValid(this, zH, !zH ? exc : null);
            }
        }
    }

    public static void a() {
        IAConfigManager iAConfigManager = M;
        com.fyber.inneractive.sdk.network.c0<c> c0Var = iAConfigManager.B;
        if (c0Var != null) {
            iAConfigManager.s.a.offer(c0Var);
            c0Var.a(q0.QUEUED);
        }
        j jVar = iAConfigManager.u;
        if (jVar.d) {
            return;
        }
        jVar.b();
    }
}
