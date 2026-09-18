package com.bytedance.sdk.openadsdk.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LandingPageLog.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final int[] G = {10, 30, 50, 75, 100};
    private volatile long A;
    private final AtomicInteger B;
    private final AtomicInteger C;
    private final AtomicBoolean D;
    private volatile int E;
    private int F;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f719b;
    private int c;
    private final AtomicBoolean d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;
    private int h;
    private boolean i;
    private String j;
    private String k;
    private final Context l;
    private final q m;
    private String n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private boolean t;
    private final AtomicInteger u;
    private WebView v;
    private boolean w;
    private o x;
    private boolean y;
    private i z;

    /* JADX INFO: compiled from: LandingPageLog.java */
    private class b {
        private b() {
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 100;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue <= 100) {
                    i = iIntValue < 0 ? 0 : iIntValue;
                }
            } catch (Throwable unused) {
            }
            j.this.u.set(i);
        }

        /* synthetic */ b(j jVar, a aVar) {
            this();
        }
    }

    public j(q qVar, WebView webView, i iVar, int i) {
        this(qVar, webView);
        this.z = iVar;
        this.F = i;
    }

    public void d() {
        com.bytedance.sdk.component.utils.m.a("LandingPageLog", "onDestroy");
        WebView webView = this.v;
        if (webView != null) {
            webView.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
            this.v = null;
        }
        if (this.e.compareAndSet(false, true)) {
            c.a(this.m, this.n, System.currentTimeMillis() - this.s, this.F);
            return;
        }
        if (this.c != 2 || this.g.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", this.c);
            jSONObject.put("max_scroll_percent", this.u.get());
            jSONObject.put("jump_times", this.B.getAndSet(0));
            jSONObject.put("click_times", this.C.getAndSet(0));
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (JSONException unused) {
        }
        a("stay_page", jSONObject, 0L);
    }

    public void e() {
        com.bytedance.sdk.component.utils.m.a("LandingPageLog", "onResume");
        if (this.s == 0) {
            this.s = System.currentTimeMillis();
        }
        this.o = System.currentTimeMillis();
    }

    public void f() {
        com.bytedance.sdk.component.utils.m.a("LandingPageLog", "onStop");
        if ("landingpage".equals(this.n) || "landingpage_endcard".equals(this.n) || "landingpage_split_screen".equals(this.n) || "landingpage_direct".equals(this.n)) {
            if (this.c == 2) {
                if (this.p > 0 || !c()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - Math.max(this.o, this.p);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("load_status", this.c);
                        jSONObject.put("max_scroll_percent", this.u.get());
                        jSONObject.put("jump_times", this.B.getAndSet(0));
                        jSONObject.put("click_times", this.C.getAndSet(0));
                        jSONObject.putOpt("render_type", "h5");
                        jSONObject.putOpt("render_type_2", 0);
                    } catch (JSONException unused) {
                    }
                    this.g.set(true);
                    a("stay_page", jSONObject, Math.min(jCurrentTimeMillis, 600000L));
                }
            }
        }
    }

    public q b() {
        return this.m;
    }

    public boolean c() {
        return this.y;
    }

    public void a(long j) {
        this.p = j;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n = str;
    }

    public j(q qVar, WebView webView) {
        this.a = 0;
        this.f719b = -1L;
        this.c = 1;
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = -1;
        this.n = "landingpage";
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.t = false;
        this.u = new AtomicInteger(0);
        this.w = false;
        this.y = false;
        this.A = 0L;
        this.B = new AtomicInteger(0);
        this.C = new AtomicInteger(0);
        this.D = new AtomicBoolean(false);
        this.E = 0;
        this.F = -1;
        this.l = com.bytedance.sdk.openadsdk.core.o.a();
        this.m = qVar;
        this.v = webView;
        if (webView == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.addJavascriptInterface(new b(this, null), "JS_LANDING_PAGE_LOG_OBJ");
        }
        if (qVar == null || qVar.O() == null) {
            return;
        }
        this.f719b = qVar.O().optLong("page_id", -1L);
    }

    public o a() {
        return this.x;
    }

    public void a(o oVar) {
        this.x = oVar;
    }

    public j a(boolean z) {
        this.w = z;
        return this;
    }

    public void a(WebView webView, int i) {
        if (webView == null) {
            return;
        }
        com.bytedance.sdk.component.utils.m.a("LandingPageLog", "onWebProgress: " + i);
        if (this.A == 0) {
            this.A = SystemClock.elapsedRealtime();
        }
        if (this.q == 0 && i > 0) {
            this.q = System.currentTimeMillis();
        } else if (this.r == 0 && i == 100) {
            this.r = System.currentTimeMillis();
        }
        if (this.a != G.length && ("landingpage".equals(this.n) || "landingpage_endcard".equals(this.n) || "landingpage_split_screen".equals(this.n) || "landingpage_direct".equals(this.n))) {
            int i2 = this.a;
            while (true) {
                int[] iArr = G;
                if (i2 >= iArr.length || i < iArr[this.a]) {
                    break;
                }
                int i3 = i2 + 1;
                this.a = i3;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", webView.getUrl());
                    long j = this.f719b;
                    if (j != -1) {
                        jSONObject.put("page_id", j);
                    }
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("pct", iArr[i2]);
                } catch (Exception unused) {
                }
                a("progress_load_finish", jSONObject);
                i2 = i3;
            }
        }
        if (i == 100) {
            a(webView.getUrl(), NotificationCompat.CATEGORY_PROGRESS, Math.min(this.r - this.q, 600000L));
        }
    }

    /* JADX INFO: compiled from: LandingPageLog.java */
    class a extends b.b.a.a.j.c.a {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.d.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LandingPageLog.java */
        class RunnableC0225a implements Runnable {
            final /* synthetic */ String a;

            RunnableC0225a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.l.a(j.this.v, this.a);
            }
        }

        a(int i) {
            this.a = i;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(BidResponsedEx.KEY_CID, j.this.b().e());
                jSONObject.putOpt("ad_id", j.this.b().e());
                jSONObject.put("log_extra", j.this.b().N());
                String strReplace = bVar.a().replace("\"/** adInfo **/\"", jSONObject.toString()).replace("\"/** first_page **/\"", String.valueOf(this.a)).replace("\"/** ix_to_externalurl **/\"", j.this.f719b != -1 ? "1" : "0");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                String strA = j.this.a(strReplace);
                if (TextUtils.isEmpty(strA) || j.this.v == null) {
                    return;
                }
                y.a(new RunnableC0225a(strA));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("LandingPageLog", "TTWebViewClient : onPageFinished", e);
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            com.bytedance.sdk.component.utils.m.a("send landing page js error", iOException.toString());
        }
    }

    private void a(String str, String str2, long j) {
        if (this.f.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("type", str2);
            } catch (Throwable unused) {
            }
            a("load_finish_progress", jSONObject, j);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        WebView webView2 = this.v;
        if (webView2 != null) {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView2.copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null && webBackForwardListCopyBackForwardList.getCurrentIndex() > this.E) {
                this.B.incrementAndGet();
            }
            this.E = webBackForwardListCopyBackForwardList.getCurrentIndex();
        }
        if (this.A == 0) {
            this.A = SystemClock.elapsedRealtime();
        }
        o oVar = this.x;
        if (oVar != null) {
            oVar.n();
        }
        if (this.d.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                int i = this.F;
                if (i >= 0) {
                    jSONObject.putOpt("preload_status", Integer.valueOf(i));
                }
            } catch (Exception unused) {
            }
            a("load_start", jSONObject);
        }
    }

    public void a(WebView webView, String str, boolean z) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        o oVar = this.x;
        if (oVar != null) {
            oVar.o();
        }
        int i = 1;
        if (webView != null && !this.t && this.w) {
            this.t = true;
            com.bytedance.sdk.component.utils.l.a(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.e.compareAndSet(false, true)) {
            if (this.c != 3) {
                this.c = 2;
            }
            this.o = System.currentTimeMillis();
            if (this.c == 2) {
                long j = this.r - this.q;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", this.h);
                    jSONObject.put("error_msg", this.j);
                    jSONObject.put("error_url", this.k);
                    int i2 = this.F;
                    if (i2 >= 0) {
                        jSONObject.put("preload_status", i2);
                    }
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("url", this.m.H0());
                } catch (Exception unused) {
                }
                try {
                    com.bytedance.sdk.openadsdk.core.settings.e eVarX = com.bytedance.sdk.openadsdk.core.o.d().x();
                    if (z && !TextUtils.isEmpty(eVarX.a) && eVarX.f673b) {
                        WebView webView2 = this.v;
                        if (webView2 != null && (webBackForwardListCopyBackForwardList = webView2.copyBackForwardList()) != null && webBackForwardListCopyBackForwardList.getCurrentIndex() != 0) {
                            i = 0;
                        }
                        String str2 = eVarX.a;
                        b.b.a.a.j.d.b bVarB = com.bytedance.sdk.openadsdk.n.c.b().d().b();
                        bVarB.b(str2);
                        HashMap map = new HashMap();
                        map.put("content-type", "application/json; charset=utf-8");
                        bVarB.a(map);
                        bVarB.a(new a(i));
                    }
                } catch (Throwable unused2) {
                }
                long jMin = Math.min(j, 600000L);
                a("load_finish", jSONObject, jMin);
                a(str, "load_finish", jMin);
                i iVar = this.z;
                if (iVar != null) {
                    iVar.a(i);
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.h);
                jSONObject2.put("error_msg", this.j);
                jSONObject2.put("error_url", this.k);
                int i3 = this.F;
                if (i3 >= 0) {
                    jSONObject2.put("preload_status", i3);
                }
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject2.put("url", this.m.H0());
            } catch (Exception unused3) {
            }
            a("load_fail", jSONObject2);
            if (this.i) {
                jSONObject2.remove("render_type");
                jSONObject2.remove("render_type_2");
                a("load_fail_main", jSONObject2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "javascript:" + str;
    }

    public void a(WebView webView, int i, String str, String str2, String str3, boolean z) {
        o oVar = this.x;
        if (oVar != null) {
            oVar.m();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.c != 2) {
            this.c = 3;
        }
        this.h = i;
        this.j = str;
        this.k = str2;
        this.i = z;
    }

    public void a(SSWebView sSWebView) {
        int i;
        Bitmap bitmapB;
        q qVar;
        if ((!"landingpage".equals(this.n) && !"landingpage_endcard".equals(this.n) && !"landingpage_split_screen".equals(this.n) && !"landingpage_direct".equals(this.n)) || (i = com.bytedance.sdk.openadsdk.core.o.d().i()) == 0 || new Random().nextInt(100) + 1 > i || sSWebView == null || sSWebView.getWebView() == null || sSWebView.getVisibility() != 0 || (bitmapB = b0.b(sSWebView)) == null || (qVar = this.m) == null) {
            return;
        }
        b0.c(qVar, this.n, "landing_page_blank", bitmapB, sSWebView.getUrl(), this.f719b);
    }

    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
        }
    }

    private void a(String str, JSONObject jSONObject) {
        a(str, jSONObject, -1L);
    }

    private void a(String str, JSONObject jSONObject, long j) {
        if (!this.w || this.m == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                jSONObject.put("is_playable", t.i(this.m) ? 1 : 0);
                jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.j0.b.a.b().a(this.m) ? 1 : 0);
            } catch (JSONException unused) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                } catch (JSONException unused2) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused3) {
            }
        }
        c.c(this.m, this.n, str, jSONObject2);
    }

    public void a(int i) {
        if (this.A != 0) {
            if (i == 1 || i == 3) {
                this.C.incrementAndGet();
                if (this.D.getAndSet(true)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.m.H0());
                } catch (JSONException unused) {
                }
                a("click_time", jSONObject, Math.max(SystemClock.elapsedRealtime() - this.A, 0L));
            }
        }
    }
}
