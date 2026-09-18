package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.Constants;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTAndroidObject.java */
/* JADX INFO: loaded from: classes2.dex */
public class x implements com.bytedance.sdk.component.utils.y.a, com.bytedance.sdk.openadsdk.i.b, b.b.a.a.d.h.b {
    private static final Map<String, Boolean> N;
    protected Map<String, Object> A;
    private com.bytedance.sdk.openadsdk.d.o D;
    private b.b.a.a.e.r E;
    private String F;
    private com.bytedance.sdk.openadsdk.core.widget.webview.a H;
    private com.bytedance.sdk.openadsdk.k.f I;
    private boolean J;
    private boolean K;
    private Context L;
    private j M;
    private WeakReference<SSWebView> a;
    private String c;
    private com.bytedance.sdk.openadsdk.core.widget.b d;
    private com.bytedance.sdk.openadsdk.i.c e;
    private WeakReference<View> f;
    private String g;
    private int h;
    private int i;
    private com.bytedance.sdk.openadsdk.core.f0.q k;
    private b.b.a.a.d.f.k l;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.l m;
    private JSONObject n;
    private com.bytedance.sdk.openadsdk.i.d o;
    private com.bytedance.sdk.openadsdk.k.a p;
    private com.bytedance.sdk.openadsdk.k.e q;
    private com.bytedance.sdk.openadsdk.k.d r;
    private JSONObject s;
    private com.bytedance.sdk.openadsdk.core.c0.d t;
    private com.bytedance.sdk.openadsdk.k.b u;
    private com.bytedance.sdk.openadsdk.k.i v;
    private List<com.bytedance.sdk.openadsdk.core.f0.q> x;
    private HashMap<String, com.bytedance.sdk.openadsdk.core.i> y;
    private boolean j = true;
    private boolean w = true;
    private boolean z = false;
    private boolean B = false;
    boolean C = false;
    private boolean G = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.component.utils.y f709b = new com.bytedance.sdk.component.utils.y(Looper.getMainLooper(), this);

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class a implements b.b.a.a.e.l {
        a(x xVar) {
        }

        @Override // b.b.a.a.e.l
        public <T> T a(String str, Type type) {
            return null;
        }

        @Override // b.b.a.a.e.l
        public <T> String a(T t) {
            return null;
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class b implements Runnable {
        final /* synthetic */ JSONObject a;

        b(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.k(this.a);
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class c implements Runnable {
        final /* synthetic */ JSONObject a;

        c(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.e(this.a);
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class d implements Runnable {
        final /* synthetic */ JSONObject a;

        d(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.f(this.a);
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.k();
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.this.H != null) {
                x.this.H.initRenderFinish();
            }
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class g implements com.bytedance.sdk.openadsdk.k.c {
        g(x xVar, JSONObject jSONObject, k kVar) {
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class h implements com.bytedance.sdk.openadsdk.k.c {
        h(x xVar) {
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    class i extends b.b.a.a.k.g {
        final /* synthetic */ Uri c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, Uri uri) {
            super(str);
            this.c = uri;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            String strD;
            JSONObject jSONObject;
            String queryParameter = this.c.getQueryParameter("category");
            String queryParameter2 = this.c.getQueryParameter("tag");
            x.this.F = queryParameter2;
            String queryParameter3 = this.c.getQueryParameter(Constants.ScionAnalytics.PARAM_LABEL);
            if (x.this.e(queryParameter3)) {
                long j2 = 0;
                try {
                    j = Long.parseLong(this.c.getQueryParameter("value"));
                } catch (Exception unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(this.c.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                long j3 = j2;
                JSONObject jSONObjectC = null;
                String queryParameter4 = this.c.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(queryParameter4);
                        try {
                            jSONObject2.putOpt("ua_policy", Integer.valueOf(x.this.i));
                        } catch (Exception unused3) {
                        }
                        jSONObjectC = jSONObject2;
                    } catch (Exception unused4) {
                    }
                }
                if ("click".equals(queryParameter3)) {
                    jSONObjectC = x.this.c(jSONObjectC);
                }
                if ("landing_perf_error".equals(queryParameter3) || "landing_perf_stats".equals(queryParameter3)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        for (String str : this.c.getQueryParameterNames()) {
                            try {
                                if ("extra".equals(str)) {
                                    jSONObject3.put("ad_extra_data", new JSONObject(this.c.getQueryParameter(str)).optString("ad_extra_data"));
                                } else {
                                    jSONObject3.put(str, this.c.getQueryParameter(str));
                                }
                            } catch (Exception unused5) {
                            }
                        }
                        strD = x.this.c;
                        jSONObject = jSONObject3;
                    } catch (Exception unused6) {
                        return;
                    }
                } else {
                    strD = x.this.d(queryParameter2);
                    jSONObject = jSONObjectC;
                }
                com.bytedance.sdk.openadsdk.d.c.a(x.this.k, queryParameter, strD, queryParameter3, j, j3, jSONObject);
            }
        }
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    public interface j {
        void a();
    }

    /* JADX INFO: compiled from: TTAndroidObject.java */
    public static class k {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f713b;
        public String c;
        public JSONObject d;
        public int e;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        N = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
    }

    public x(Context context) {
        this.L = context;
    }

    private WebView f() {
        WeakReference<SSWebView> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.a.get().getWebView();
    }

    private void h(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.k.b bVar = this.u;
        if (bVar == null || jSONObject == null) {
            return;
        }
        bVar.a(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.l lVar = this.m;
        if (lVar != null) {
            lVar.j();
        }
    }

    @JProtect
    private void l(JSONObject jSONObject) {
        int i2;
        double dOptDouble;
        com.bytedance.sdk.openadsdk.k.f fVar;
        x xVar = this;
        if (xVar.l == null || jSONObject == null) {
            return;
        }
        b.b.a.a.d.f.n nVar = new b.b.a.a.d.f.n();
        nVar.b(1);
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
            double dOptDouble2 = 0.0d;
            if (jSONObjectOptJSONObject != null) {
                dOptDouble2 = jSONObjectOptJSONObject.optDouble("width");
                dOptDouble = jSONObjectOptJSONObject.optDouble("height");
            } else {
                dOptDouble = 0.0d;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.VIDEO_INFO_EVENT);
            if (jSONObjectOptJSONObject2 != null) {
                try {
                    double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                    double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                    double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                    double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                    if (xVar.a(jSONObjectOptJSONObject2)) {
                        nVar.c((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft"));
                        nVar.d((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight"));
                        nVar.a((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft"));
                        nVar.b((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight"));
                    }
                    nVar.e(dOptDouble3);
                    nVar.f(dOptDouble4);
                    nVar.d(dOptDouble5);
                    nVar.c(dOptDouble6);
                } catch (Exception unused) {
                    i2 = 101;
                    xVar = this;
                }
            } else {
                dOptDouble = dOptDouble;
            }
            try {
                String strOptString = jSONObject.optString("message", com.bytedance.sdk.openadsdk.core.g.a(101));
                int iOptInt = jSONObject.optInt("code", 101);
                try {
                    nVar.b(zOptBoolean);
                    nVar.b(dOptDouble2);
                    nVar.a(dOptDouble);
                    nVar.a(strOptString);
                    nVar.a(iOptInt);
                    xVar = this;
                    xVar.l.a(nVar);
                    if (jSONObjectOptJSONObject2 == null || (fVar = xVar.I) == null) {
                        return;
                    }
                    fVar.a(nVar);
                    return;
                } catch (Exception unused2) {
                    xVar = this;
                }
            } catch (Exception unused3) {
                xVar = this;
                i2 = 101;
            }
        } catch (Exception unused4) {
        }
        i2 = 101;
        nVar.a(i2);
        nVar.a(com.bytedance.sdk.openadsdk.core.g.a(i2));
        xVar.l.a(nVar);
    }

    private void m(JSONObject jSONObject) {
        if (jSONObject == null || this.o == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                this.o.a(false, null);
            } else {
                this.o.a(true, jSONArrayOptJSONArray);
            }
        } catch (Exception unused) {
            this.o.a(false, null);
        }
    }

    private void o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "TTAndroidObject handlerDynamicTrack");
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.k.a(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void q(JSONObject jSONObject) {
        WebView webViewF;
        if (jSONObject == null || (webViewF = f()) == null) {
            return;
        }
        String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ")";
        com.bytedance.sdk.component.utils.l.a(webViewF, str);
        if (com.bytedance.sdk.component.utils.m.b()) {
            com.bytedance.sdk.component.utils.m.e("TTAD.AndroidObject", "js_msg " + str);
        }
    }

    private void t() {
        if (this.e == null) {
            this.e = com.bytedance.sdk.openadsdk.i.a.a(this, this.k);
        }
    }

    private boolean v() {
        com.bytedance.sdk.openadsdk.core.f0.q qVar = this.k;
        if (qVar == null || qVar.D0() == null || com.bytedance.sdk.openadsdk.core.f0.t.i(this.k) || this.z || this.k.D0().optInt("parent_type") != 2) {
            return false;
        }
        int iR = this.k.R();
        if (iR != 8 && iR != 7) {
            return false;
        }
        this.z = true;
        return true;
    }

    private void x() {
        if (this.L == null || TextUtils.isEmpty(o.d().W())) {
            return;
        }
        TTWebsiteActivity.a(this.L, this.k, this.F);
    }

    public x a(boolean z) {
        return this;
    }

    @Override // b.b.a.a.d.h.b
    public void a(String str) {
    }

    @JProtect
    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.k.c cVar) {
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            b(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // b.b.a.a.d.h.b
    public void b(String str) {
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            com.bytedance.sdk.openadsdk.utils.y.a(new c(new JSONObject(str)));
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void chooseAdResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("video_choose");
            long jOptLong = jSONObject.optLong("video_choose_duration");
            com.bytedance.sdk.openadsdk.k.f fVar = this.I;
            if (fVar != null) {
                fVar.a(iOptInt, jOptLong);
            }
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            com.bytedance.sdk.openadsdk.utils.y.a(new d(new JSONObject(str)));
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            o(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public x g(String str) {
        return this;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.k.b bVar;
        if (this.K && (bVar = this.u) != null) {
            bVar.a();
            return;
        }
        Context context = this.L;
        if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.o.a((Activity) context)) {
            ((Activity) this.L).finish();
        }
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        i(jSONObject);
        return jSONObject.toString();
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public String getTemplateInfo() {
        a("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.n;
            if (jSONObject != null) {
                jSONObject.put("setting", e());
                com.bytedance.sdk.openadsdk.core.f0.q qVar = this.k;
                if (qVar != null) {
                    this.n.put(ShareConstants.MEDIA_EXTENSION, qVar.P());
                }
            }
            a("getTemplateInfo", false);
            return this.n.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public x h(String str) {
        return this;
    }

    public x i(String str) {
        this.c = str;
        return this;
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "initRenderFinish");
        com.bytedance.sdk.openadsdk.utils.y.a(new f());
    }

    public x j(String str) {
        this.g = str;
        return this;
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            com.bytedance.sdk.openadsdk.utils.y.a(new b(new JSONObject(str)));
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.m.b("TTAD.AndroidObject", "");
        }
    }

    public boolean n() {
        com.bytedance.sdk.openadsdk.core.f0.q qVar = this.k;
        return qVar != null && qVar.e1();
    }

    public void p(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("landingStyle");
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("fallback_url");
        boolean z = this.L instanceof Activity;
        try {
            jSONObject.put("is_activity", z);
        } catch (JSONException unused) {
        }
        boolean z2 = true;
        com.bytedance.sdk.openadsdk.d.c.b(this.k, this.F, 1, jSONObject);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        if (iOptInt == 0) {
            WebView webViewF = f();
            if (webViewF != null) {
                webViewF.loadUrl(strOptString);
                com.bytedance.sdk.openadsdk.d.c.b(this.k, this.F, 2, (JSONObject) null);
            } else {
                com.bytedance.sdk.openadsdk.d.c.b(this.k, this.F, -1, (JSONObject) null);
            }
        } else if (iOptInt == 1) {
            if (z) {
                com.bytedance.sdk.openadsdk.utils.o.b((Activity) this.L, strOptString, this.k, this.F);
            }
        } else if (iOptInt == 2) {
            if (z && !com.bytedance.sdk.openadsdk.utils.o.a((Activity) this.L, strOptString, this.k, this.F)) {
                com.bytedance.sdk.openadsdk.utils.o.b((Activity) this.L, strOptString2, this.k, this.F);
            }
        } else if (iOptInt != 3) {
            z2 = false;
        } else if (z) {
            if (z.a(this.L, strOptString, this.k, this.h, this.F, false)) {
                com.bytedance.sdk.openadsdk.d.c.b(this.k, this.F, 3, (JSONObject) null);
            } else {
                com.bytedance.sdk.openadsdk.d.c.b(this.k, this.F, -2, (JSONObject) null);
            }
        }
        com.bytedance.sdk.openadsdk.core.widget.b bVar = this.d;
        if (bVar == null || !z2) {
            return;
        }
        bVar.a();
    }

    public x r(JSONObject jSONObject) {
        this.n = jSONObject;
        return this;
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            l(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JProtect
    public void s() {
        a((JSONObject) null, new h(this));
    }

    @Override // b.b.a.a.d.h.b
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.utils.y.a(new e());
    }

    public void u() {
        b.b.a.a.e.r rVar = this.E;
        if (rVar == null) {
            return;
        }
        rVar.b();
        this.E = null;
    }

    public boolean w() {
        return this.C;
    }

    private List<String> d() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject) {
        if (this.m == null || jSONObject == null) {
            return;
        }
        try {
            this.m.a(jSONObject.optInt("stateType", -1));
        } catch (Exception unused) {
        }
    }

    private void i() {
        com.bytedance.sdk.openadsdk.k.i iVar = this.v;
        if (iVar == null) {
            return;
        }
        iVar.a();
    }

    private void j() {
        com.bytedance.sdk.openadsdk.k.i iVar = this.v;
        if (iVar == null) {
            return;
        }
        iVar.b();
    }

    private void n(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.d.o oVar;
        if (jSONObject == null || (oVar = this.D) == null) {
            return;
        }
        oVar.a(jSONObject);
    }

    public void r() {
        j jVar = this.M;
        if (jVar != null) {
            jVar.a();
        }
    }

    private void d(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.f0.t.d(this.k))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.f0.t.d(this.k));
    }

    public void k(String str) {
        this.F = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(JSONObject jSONObject) {
        if (this.m == null || jSONObject == null) {
            return;
        }
        try {
            this.m.a(jSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE, false));
        } catch (Exception unused) {
        }
    }

    public x a(com.bytedance.sdk.openadsdk.core.widget.b bVar) {
        this.d = bVar;
        return this;
    }

    public x b(SSWebView sSWebView) {
        com.bytedance.sdk.component.utils.m.b("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        if (sSWebView.getWebView() == null) {
            return this;
        }
        try {
            b.b.a.a.e.r rVarA = b.b.a.a.e.r.a(sSWebView.getWebView()).a(new com.bytedance.sdk.openadsdk.j.a()).a("ToutiaoJSBridge").a(new a(this)).a(com.bytedance.sdk.openadsdk.core.h.a().p()).b(true).c().a();
            this.E = rVarA;
            com.bytedance.sdk.openadsdk.j.b.e.a(rVarA, this);
            com.bytedance.sdk.openadsdk.j.b.a.a(this.E, this);
            com.bytedance.sdk.openadsdk.j.b.b.a(this.E, this);
            com.bytedance.sdk.openadsdk.j.b.c.a(this.E, this);
            com.bytedance.sdk.openadsdk.j.b.d.a(this.E, this);
            com.bytedance.sdk.openadsdk.j.b.f.a(this.E, this);
            com.bytedance.sdk.openadsdk.j.b.g.a(this.E, this);
        } catch (Exception unused) {
        }
        return this;
    }

    public x c(int i2) {
        this.i = i2;
        return this;
    }

    public x a(SSWebView sSWebView) {
        this.a = new WeakReference<>(sSWebView);
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.f0.q c() {
        return this.k;
    }

    public void d(boolean z) {
        this.C = z;
    }

    public void f(JSONObject jSONObject) {
        double d2;
        double d3;
        double dOptDouble;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "TTAndroidObject handleClickEvent");
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("clickInfo");
            double d10 = 0.0d;
            if (jSONObjectOptJSONObject2 != null) {
                double dOptDouble2 = jSONObjectOptJSONObject2.optDouble("down_x", 0.0d);
                dOptDouble = jSONObjectOptJSONObject2.optDouble("down_y", 0.0d);
                double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("up_x", 0.0d);
                double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("up_y", 0.0d);
                double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("down_time", 0.0d);
                double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("up_time", 0.0d);
                double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("button_x", 0.0d);
                double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("button_y", 0.0d);
                double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("button_width", 0.0d);
                double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("button_height", 0.0d);
                jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("rectInfo");
                d9 = dOptDouble10;
                d10 = dOptDouble2;
                d3 = dOptDouble3;
                d4 = dOptDouble5;
                d5 = dOptDouble6;
                d6 = dOptDouble7;
                d7 = dOptDouble8;
                d8 = dOptDouble9;
                d2 = dOptDouble4;
            } else {
                d2 = 0.0d;
                d3 = 0.0d;
                dOptDouble = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                d9 = 0.0d;
                jSONObjectOptJSONObject = null;
            }
            com.bytedance.sdk.openadsdk.core.f0.m mVarA = new com.bytedance.sdk.openadsdk.core.f0.m.b().a((float) d10).b((float) dOptDouble).c((float) d3).d((float) d2).a((long) d4).b((long) d5).d((int) d6).e((int) d7).c((int) d8).b((int) d9).a(strOptString2).a((SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a>) null).a(true).a(iOptInt).a(jSONObjectOptJSONObject).f(jSONObject.optInt("clickAreaCategory", -1)).a();
            b.b.a.a.d.f.k kVar = this.l;
            if (kVar != null) {
                kVar.a(null, iOptInt, mVarA);
            }
            a(strOptString, iOptInt, mVarA);
        } catch (Exception unused) {
            b.b.a.a.d.f.k kVar2 = this.l;
            if (kVar2 != null) {
                kVar2.a(null, -1, null);
            }
        }
    }

    public void h() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.l lVar = this.m;
        if (lVar != null) {
            lVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if (this.u != null) {
            return com.bytedance.sdk.openadsdk.utils.a0.b(this.h);
        }
        return this.l == null ? com.bytedance.sdk.openadsdk.utils.a0.c(this.h) : str;
    }

    private boolean i(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.l lVar = this.m;
        if (lVar != null && jSONObject != null) {
            double dK = lVar.k();
            int i2 = this.m.i();
            try {
                jSONObject.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, dK / 1000.0d);
                jSONObject.put("state", i2);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean j(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", a(this.x));
        } catch (Exception unused) {
        }
        return true;
    }

    public x a(com.bytedance.sdk.openadsdk.d.o oVar) {
        this.D = oVar;
        return this;
    }

    public x c(boolean z) {
        this.w = z;
        return this;
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            q(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public x a(View view) {
        this.f = new WeakReference<>(view);
        return this;
    }

    public void g(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.f0.q qVarF = com.bytedance.sdk.openadsdk.core.b.f(jSONObject);
        if (qVarF != null) {
            com.bytedance.sdk.openadsdk.core.c0.a aVar = new com.bytedance.sdk.openadsdk.core.c0.a(o.a(), qVarF, this.F, this.h);
            aVar.a(b.c.a.a.a.a.d.a(o.a(), qVarF, this.F));
            aVar.onClick(null);
        }
    }

    public void q() {
        com.bytedance.sdk.openadsdk.i.c cVar = this.e;
        if (cVar != null) {
            cVar.a();
        }
        if (v()) {
            s();
        }
    }

    @JProtect
    private JSONObject a() {
        try {
            View view = this.f.get();
            SSWebView sSWebView = this.a.get();
            if (view != null && sSWebView != null) {
                int[] iArrB = b0.b(view);
                int[] iArrB2 = b0.b((View) sSWebView);
                if (iArrB != null && iArrB2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", b0.b(o.a(), iArrB[0] - iArrB2[0]));
                    jSONObject.put("y", b0.b(o.a(), iArrB[1] - iArrB2[1]));
                    jSONObject.put("w", b0.b(o.a(), view.getWidth()));
                    jSONObject.put("h", b0.b(o.a(), view.getHeight()));
                    jSONObject.put("isExist", true);
                    return jSONObject;
                }
                com.bytedance.sdk.component.utils.m.b("TTAD.AndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                return null;
            }
            com.bytedance.sdk.component.utils.m.b("TTAD.AndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "setCloseButtonInfo error", th);
            return null;
        }
    }

    @JProtect
    private JSONObject e() {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (o.d() == null) {
            return jSONObject;
        }
        try {
            com.bytedance.sdk.openadsdk.core.f0.q qVar = this.k;
            int iS = qVar != null ? qVar.S() : 0;
            com.bytedance.sdk.openadsdk.core.f0.q qVar2 = this.k;
            int iR = qVar2 != null ? qVar2.R() : 0;
            int iA = o.d().a(String.valueOf(iS));
            int iR2 = o.d().r(String.valueOf(iS));
            boolean zC = o.d().c(String.valueOf(iS));
            boolean z2 = true;
            boolean z3 = !com.bytedance.sdk.openadsdk.core.f0.q.c(this.k) && o.d().j(String.valueOf(iS)) == 1;
            if (iR != 7 && iR != 8) {
                z = o.d().f(String.valueOf(iS));
            } else {
                z = o.d().z(String.valueOf(iS));
            }
            jSONObject.put("voice_control", z);
            jSONObject.put("rv_skip_time", iA);
            jSONObject.put("fv_skip_show", zC);
            jSONObject.put("iv_skip_time", iR2);
            com.bytedance.sdk.openadsdk.core.f0.q qVar3 = this.k;
            if (qVar3 == null || !qVar3.g1()) {
                z2 = false;
            }
            jSONObject.put("show_dislike", z2);
            com.bytedance.sdk.openadsdk.core.f0.q qVar4 = this.k;
            jSONObject.put("video_adaptation", qVar4 != null ? qVar4.O0() : 0);
            jSONObject.put("skip_change_to_close", z3);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void o() {
        com.bytedance.sdk.openadsdk.i.c cVar = this.e;
        if (cVar != null) {
            cVar.onDestroy();
        }
        this.L = null;
    }

    public boolean m() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c(JSONObject jSONObject) {
        if (this.A != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                for (Map.Entry<String, Object> entry : this.A.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.m.b(e2.toString());
            }
        }
        return jSONObject;
    }

    private void c(String str) {
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView webViewF = f();
                    if (webViewF != null) {
                        com.bytedance.sdk.component.utils.l.a(webViewF, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/")) {
                    int iIndexOf = str.indexOf(38, 30);
                    if (iIndexOf <= 0) {
                        return;
                    }
                    String strSubstring = str.substring(30, iIndexOf);
                    String strSubstring2 = str.substring(iIndexOf + 1);
                    if (strSubstring.equals("SCENE_FETCHQUEUE") && strSubstring2.length() > 0) {
                        f(strSubstring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || l();
    }

    public void e(boolean z) {
        this.K = z;
    }

    public x a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        this.k = qVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.k.b bVar) {
        this.u = bVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.k.i iVar) {
        this.v = iVar;
        return this;
    }

    public x a(Map<String, Object> map) {
        this.A = map;
        return this;
    }

    public x a(b.b.a.a.d.f.k kVar) {
        this.l = kVar;
        return this;
    }

    public b.b.a.a.e.r b() {
        return this.E;
    }

    public x a(com.bytedance.sdk.openadsdk.core.nativeexpress.l lVar) {
        this.m = lVar;
        return this;
    }

    public x b(boolean z) {
        this.B = z;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.i.d dVar) {
        this.o = dVar;
        return this;
    }

    public x b(int i2) {
        this.h = i2;
        return this;
    }

    public void p() {
        com.bytedance.sdk.openadsdk.i.c cVar = this.e;
        if (cVar != null) {
            cVar.b();
        }
    }

    public x a(com.bytedance.sdk.openadsdk.core.c0.d dVar) {
        this.t = dVar;
        return this;
    }

    public x b(List<com.bytedance.sdk.openadsdk.core.f0.q> list) {
        this.x = list;
        return this;
    }

    private void b(JSONObject jSONObject) throws Exception {
        if (this.J) {
            com.bytedance.sdk.openadsdk.core.f0.q qVar = this.k;
            if ((qVar instanceof com.bytedance.sdk.openadsdk.core.f0.r) && ((com.bytedance.sdk.openadsdk.core.f0.r) qVar).s1()) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("adInfos", jSONArray);
                for (com.bytedance.sdk.openadsdk.core.f0.q qVar2 : ((com.bytedance.sdk.openadsdk.core.f0.r) this.k).r1()) {
                    JSONObject jSONObject2 = new JSONObject();
                    a(jSONObject2, qVar2);
                    jSONArray.put(jSONObject2);
                }
                return;
            }
        }
        a(jSONObject, this.k);
    }

    public x a(com.bytedance.sdk.openadsdk.k.a aVar) {
        this.p = aVar;
        return this;
    }

    private void f(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                k kVar = new k();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        kVar.a = jSONObjectOptJSONObject.optString("__msg_type", null);
                        kVar.f713b = jSONObjectOptJSONObject.optString("__callback_id", null);
                        kVar.c = jSONObjectOptJSONObject.optString("func");
                        kVar.d = jSONObjectOptJSONObject.optJSONObject("params");
                        kVar.e = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(kVar.a) && !TextUtils.isEmpty(kVar.c)) {
                    Message messageObtainMessage = this.f709b.obtainMessage(11);
                    messageObtainMessage.obj = kVar;
                    this.f709b.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.component.utils.m.b()) {
                com.bytedance.sdk.component.utils.m.f("TTAD.AndroidObject", "failed to parse jsbridge msg queue " + str);
            } else {
                com.bytedance.sdk.component.utils.m.f("TTAD.AndroidObject", "failed to parse jsbridge msg queue");
            }
        }
    }

    public x a(com.bytedance.sdk.openadsdk.k.e eVar) {
        this.q = eVar;
        return this;
    }

    boolean l() {
        com.bytedance.sdk.openadsdk.core.f0.q qVar = this.k;
        return qVar != null && qVar.C() == 1;
    }

    public x a(com.bytedance.sdk.openadsdk.k.d dVar) {
        this.r = dVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.k.f fVar) {
        this.I = fVar;
        return this;
    }

    @JProtect
    private void a(JSONObject jSONObject, int i2) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = d().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.common.a.b());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.common.a.d());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.common.a.a());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.common.a.f());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.common.a.c());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.common.a.e());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.common.a.a(o.a()));
        if (DeviceUtils.l(o.a())) {
            jSONObject.put("device_platform", "Android_Pad");
        } else {
            jSONObject.put("device_platform", "Android");
        }
        jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, Build.VERSION.RELEASE);
    }

    private void b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            q(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void b(Uri uri) {
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.component.utils.m.f("TTAD.AndroidObject", "handlrUir: not match schema host");
                } else {
                    c(uri.toString());
                }
            } else {
                com.bytedance.sdk.openadsdk.d.c.a(new i("log_event_handleUri", uri));
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.c("TTAD.AndroidObject", "handleUri exception: ", e2);
        }
    }

    private static void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.f0.q qVar) throws Exception {
        String strE = qVar.e();
        if (!TextUtils.isEmpty(strE)) {
            jSONObject.put(BidResponsedEx.KEY_CID, strE);
        }
        String strN = qVar.N();
        if (!TextUtils.isEmpty(strN)) {
            jSONObject.put("log_extra", strN);
        }
        String strD = qVar.D();
        if (!TextUtils.isEmpty(strD)) {
            jSONObject.put(DownloadModel.DOWNLOAD_URL, strD);
        }
        jSONObject.put("dc", TextUtils.isEmpty(o.d().j()) ? o.d().j() : "SG");
        jSONObject.put("language", com.bytedance.sdk.openadsdk.utils.a0.d(o.a()));
        jSONObject.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.n.j0().R());
    }

    public void f(boolean z) {
        this.J = z;
    }

    /* JADX WARN: Code duplicated, block: B:227:0x03bc A[PHI: r4
      0x03bc: PHI (r4v21 org.json.JSONObject) = (r4v16 org.json.JSONObject), (r4v22 org.json.JSONObject) binds: [B:226:0x03ba, B:210:0x0371] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @JProtect
    public JSONObject a(k kVar, int i2) throws Exception {
        JSONObject jSONObjectA;
        Context context;
        JSONObject jSONObject;
        if (!NotificationCompat.CATEGORY_CALL.equals(kVar.a)) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.h.a().p()) {
            Log.d("TTAD.AndroidObject", "[JSB-REQ] version:" + i2 + " method:" + kVar.c);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str = kVar.c;
        str.hashCode();
        int streamVolume = -1;
        switch (str) {
            case "subscribe_app_ad":
                t();
                com.bytedance.sdk.openadsdk.d.c.a(this.k, this.F, 0, (JSONObject) null);
                Context context2 = this.L;
                if (context2 != null) {
                    this.e.a(context2, kVar.d, this.g, this.h, this.j);
                    break;
                } else {
                    com.bytedance.sdk.openadsdk.d.c.a(this.k, this.F, -1, (JSONObject) null);
                    break;
                }
                break;
            case "adInfo":
                b(jSONObject2);
                break;
            case "pauseWebView":
                i();
                break;
            case "changeVideoState":
                e(kVar.d);
                break;
            case "openAdLandPageLinks":
                com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "METHOD_OPEN_OPEN_AD_LANDPAGE_LINKS");
                p(kVar.d);
                break;
            case "webview_time_track":
                n(kVar.d);
                break;
            case "clickEvent":
                f(kVar.d);
                break;
            case "appInfo":
                a(jSONObject2, kVar.e);
                break;
            case "getScreenSize":
                com.bytedance.sdk.openadsdk.k.a aVar = this.p;
                if (aVar != null) {
                    int iA = aVar.a();
                    int iB = this.p.b();
                    jSONObject2.put("width", iA);
                    jSONObject2.put("height", iB);
                    break;
                }
                break;
            case "openPrivacy":
                com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "openPrivacy");
                x();
                break;
            case "getMaterialMeta":
                j(jSONObject2);
                break;
            case "send_temai_product_ids":
                m(kVar.d);
                break;
            case "getTeMaiAds":
                jSONObjectA = this.s;
                if (jSONObjectA != null) {
                    jSONObject2 = jSONObjectA;
                    break;
                }
                break;
            case "download_app_ad":
                this.G = true;
                com.bytedance.sdk.openadsdk.d.c.a(this.k, this.F, 1, (JSONObject) null);
                com.bytedance.sdk.openadsdk.core.c0.d dVar = this.t;
                if (dVar != null) {
                    dVar.a(this.w);
                    break;
                } else {
                    com.bytedance.sdk.openadsdk.i.c cVar = this.e;
                    if (cVar != null && (context = this.L) != null) {
                        cVar.a(context, kVar.d, this.F);
                    } else {
                        com.bytedance.sdk.openadsdk.d.c.a(this.k, this.F, -2, (JSONObject) null);
                    }
                    break;
                }
                break;
            case "close":
                com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "METHOD_CLOSE");
                g();
                break;
            case "unsubscribe_app_ad":
                com.bytedance.sdk.openadsdk.i.c cVar2 = this.e;
                if (cVar2 != null) {
                    cVar2.a(kVar.d);
                    break;
                }
                break;
            case "getCloseButtonInfo":
                jSONObjectA = a();
                if (jSONObjectA != null) {
                    jSONObject2 = jSONObjectA;
                    break;
                }
                break;
            case "isViewable":
                jSONObject2.put("viewStatus", this.B ? 1 : 0);
                break;
            case "getNativeSiteCustomData":
                com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "METHOD_GET_NATIVE_SITE_CUSTOM_DATA");
                com.bytedance.sdk.openadsdk.core.f0.q qVar = this.k;
                if (qVar != null && !TextUtils.isEmpty(qVar.x())) {
                    jSONObject2.put("data", this.k.x());
                    break;
                }
                break;
            case "sendReward":
                this.C = true;
                com.bytedance.sdk.openadsdk.k.e eVar = this.q;
                if (eVar != null) {
                    eVar.a();
                    break;
                }
                break;
            case "dynamicTrack":
                o(kVar.d);
                break;
            case "getTemplateInfo":
                JSONObject jSONObject3 = this.n;
                if (jSONObject3 != null) {
                    jSONObject3.put("setting", e());
                    com.bytedance.sdk.openadsdk.core.f0.q qVar2 = this.k;
                    if (qVar2 != null) {
                        this.n.put(ShareConstants.MEDIA_EXTENSION, qVar2.P());
                    }
                }
                jSONObject2 = this.n;
                break;
            case "cancel_download_app_ad":
                com.bytedance.sdk.openadsdk.i.c cVar3 = this.e;
                if (cVar3 != null) {
                    cVar3.b(kVar.d);
                    break;
                }
                break;
            case "getCurrentVideoState":
                i(jSONObject2);
                break;
            case "getVolume":
                AudioManager audioManager = (AudioManager) o.a().getSystemService("audio");
                if (audioManager != null) {
                    streamVolume = audioManager.getStreamVolume(3);
                    com.bytedance.sdk.component.utils.m.a("TTAD.AndroidObject", "Music volume >>>> AudioManager-->currentVolume=" + streamVolume);
                }
                jSONObject2.put("endcard_mute", streamVolume <= 0);
                break;
            case "pauseWebViewTimers":
                j();
                break;
            case "muteVideo":
                k(kVar.d);
                break;
            case "renderDidFinish":
                l(kVar.d);
                break;
            case "removeLoading":
                com.bytedance.sdk.openadsdk.k.d dVar2 = this.r;
                if (dVar2 != null) {
                    dVar2.a();
                    break;
                }
                break;
            case "endcard_load":
                h(kVar.d);
                break;
            case "getNetworkData":
                a(kVar, jSONObject2);
                break;
            case "playable_style":
                d(jSONObject2);
                break;
            case "sendLog":
                JSONObject jSONObject4 = kVar.d;
                if (jSONObject4 != null && (jSONObject = jSONObject4.getJSONObject("extJson")) != null && jSONObject.has("category") && jSONObject.has("tag") && jSONObject.has(Constants.ScionAnalytics.PARAM_LABEL)) {
                    String string = jSONObject.getString("category");
                    String string2 = jSONObject.getString("tag");
                    String string3 = jSONObject.getString(Constants.ScionAnalytics.PARAM_LABEL);
                    long j2 = jSONObject4.getLong("value");
                    long j3 = jSONObject4.getLong("extValue");
                    try {
                        jSONObject.putOpt("ua_policy", Integer.valueOf(this.i));
                        break;
                    } catch (Exception unused) {
                    }
                    if ("click".equals(string3)) {
                        jSONObject = c(jSONObject);
                    }
                    com.bytedance.sdk.openadsdk.d.c.a(this.k, string, d(string2), string3, j2, j3, jSONObject);
                    break;
                }
                break;
            case "skipVideo":
                k();
                break;
            case "landscape_click":
                Context context3 = this.L;
                if (context3 instanceof com.bytedance.sdk.openadsdk.core.j0.c.b) {
                    ((com.bytedance.sdk.openadsdk.core.j0.c.b) context3).d();
                    break;
                }
                break;
        }
        if (i2 == 1 && !TextUtils.isEmpty(kVar.f713b)) {
            b(kVar.f713b, jSONObject2);
            if (com.bytedance.sdk.openadsdk.core.h.a().p()) {
                Log.d("TTAD.AndroidObject", "[JSB-RSP] version:" + i2 + " data=" + jSONObject2);
            }
        }
        return jSONObject2;
    }

    private void a(String str, boolean z) {
        if (this.D == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.D.e(str);
        } else {
            this.D.d(str);
        }
    }

    private boolean a(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private void a(k kVar, JSONObject jSONObject) {
        if (kVar == null) {
            return;
        }
        try {
            a(kVar.d, new g(this, jSONObject, kVar));
        } catch (Exception unused) {
        }
    }

    @JProtect
    private boolean a(String str, int i2, com.bytedance.sdk.openadsdk.core.f0.m mVar) {
        HashMap<String, com.bytedance.sdk.openadsdk.core.i> map;
        com.bytedance.sdk.openadsdk.core.i iVar;
        if (TextUtils.isEmpty(str) || (map = this.y) == null || (iVar = map.get(str)) == null) {
            return false;
        }
        iVar.a(i2, mVar);
        return true;
    }

    public static JSONArray a(List<com.bytedance.sdk.openadsdk.core.f0.q> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            jSONArray.put(list.get(i2).n1());
        }
        return jSONArray;
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (N.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void a(int i2) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.l lVar = this.m;
        if (lVar != null) {
            lVar.d(i2);
        }
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof k) {
                try {
                    a((k) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.b
    public void a(String str, JSONObject jSONObject) {
        c(str, jSONObject);
    }

    public void a(j jVar) {
        this.M = jVar;
    }
}
