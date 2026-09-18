package com.bytedance.sdk.openadsdk.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebviewTimeTrack.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.f0.q f726b;
    private Boolean c;
    private Boolean d;
    private Boolean e;
    private JSONObject f;
    private JSONArray g;
    private JSONArray h;

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class a implements Runnable {
        final /* synthetic */ JSONObject a;

        a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = this.a;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
            o oVar = o.this;
            oVar.a(oVar.f, "webview_load_error", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class a0 implements Runnable {
        a0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "webview_load_success", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "native_endcard_show", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class b0 implements Runnable {
        b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b((JSONObject) null);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "native_endcard_close", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o.this.a(jSONObject, "type", "native_enterBackground");
            o oVar = o.this;
            oVar.a(oVar.g, jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o.this.a(jSONObject, "type", "native_enterForeground");
            o oVar = o.this;
            oVar.a(oVar.g, jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class f implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f728b;
        final /* synthetic */ long c;
        final /* synthetic */ int d;

        f(String str, long j, long j2, int i) {
            this.a = str;
            this.f728b = j;
            this.c = j2;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.a) || this.f728b < this.c) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, "start_ts", Long.valueOf(this.c));
            o.this.a(jSONObject, "end_ts", Long.valueOf(this.f728b));
            o.this.a(jSONObject, "intercept_type", Integer.valueOf(this.d));
            o.this.a(jSONObject, "type", "intercept_html");
            o.this.a(jSONObject, "url", this.a);
            o.this.a(jSONObject, "duration", Long.valueOf(this.f728b - this.c));
            o oVar = o.this;
            oVar.a(oVar.h, jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class g implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f729b;
        final /* synthetic */ long c;
        final /* synthetic */ int d;

        g(String str, long j, long j2, int i) {
            this.a = str;
            this.f729b = j;
            this.c = j2;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.a) || this.f729b < this.c) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, "start_ts", Long.valueOf(this.c));
            o.this.a(jSONObject, "end_ts", Long.valueOf(this.f729b));
            o.this.a(jSONObject, "intercept_type", Integer.valueOf(this.d));
            o.this.a(jSONObject, "type", "intercept_js");
            o.this.a(jSONObject, "url", this.a);
            o.this.a(jSONObject, "duration", Long.valueOf(this.f729b - this.c));
            o oVar = o.this;
            oVar.a(oVar.h, jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class h implements Runnable {
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o.this.a(jSONObject, "jsb", this.a);
            o oVar = o.this;
            oVar.a(oVar.f, "webview_jsb_start", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class i implements Runnable {
        final /* synthetic */ String a;

        i(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o.this.a(jSONObject, "jsb", this.a);
            o oVar = o.this;
            oVar.a(oVar.f, "webview_jsb_end", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class j implements Runnable {
        final /* synthetic */ JSONObject a;

        j(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            if (o.this.f == null || (jSONObject = this.a) == null) {
                return;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                o oVar = o.this;
                oVar.a(oVar.f, next, this.a.opt(next));
            }
            o.this.d = Boolean.TRUE;
            o.this.q();
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(jSONObject, "render_sequence", Integer.valueOf(oVar.f726b.y0()));
            o.this.a(jSONObject, "webview_count", Integer.valueOf(b.b.a.a.d.h.e.e().b()));
            o.this.a(jSONObject, "available_cache_count", Integer.valueOf(b.b.a.a.d.h.e.e().c()));
            o oVar2 = o.this;
            oVar2.a(oVar2.f, "render_start", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o.this.a()) {
                if (o.this.g != null && o.this.g.length() != 0) {
                    try {
                        o.this.f.put("native_switchBackgroundAndForeground", o.this.g);
                    } catch (Exception unused) {
                    }
                }
                if (o.this.h != null && o.this.h.length() != 0) {
                    try {
                        o.this.f.put("intercept_source", o.this.h);
                    } catch (Exception unused2) {
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("webview_time_track", o.this.f);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.m.b("WebviewTimeTrack", "trySendTrackInfo json error", e);
                }
                if (com.bytedance.sdk.openadsdk.core.h.a().p() && o.this.f != null) {
                    com.bytedance.sdk.component.utils.m.a("WebviewTimeTrack", o.this.f.toString());
                }
                com.bytedance.sdk.openadsdk.d.c.b(o.this.f726b, o.this.a, "webview_time_track", jSONObject);
            }
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class m implements Runnable {
        final /* synthetic */ String a;

        m(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, this.a, jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class n implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f734b;

        n(int i, String str) {
            this.a = i;
            this.f734b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o.this.a(jSONObject, "code", Integer.valueOf(this.a));
            o oVar = o.this;
            oVar.a(oVar.f, this.f734b, jSONObject);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.d.o$o, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class RunnableC0226o implements Runnable {
        RunnableC0226o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "native_render_end", jSONObject);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            o.this.a(jSONObject2, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis2));
            o oVar2 = o.this;
            oVar2.a(oVar2.f, "render_success", jSONObject2);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "no_native_render", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "render_failed", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class r implements Runnable {
        final /* synthetic */ String a;

        r(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, this.a, jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class s implements Runnable {
        final /* synthetic */ String a;

        s(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, this.a, jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class t implements Runnable {
        t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "render_success", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class u implements Runnable {
        final /* synthetic */ int a;

        u(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o.this.a(jSONObject, "isWebViewCache", Integer.valueOf(this.a));
            o oVar = o.this;
            oVar.a(oVar.f, "before_webview_request", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class v implements Runnable {
        final /* synthetic */ int a;

        v(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b(this.a, null);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class w implements Runnable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f739b;

        w(int i, String str) {
            this.a = i;
            this.f739b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o.this.a(jSONObject, "code", Integer.valueOf(this.a));
            String str = this.f739b;
            if (str != null) {
                o.this.a(jSONObject, "msg", str);
            }
            o oVar = o.this;
            oVar.a(oVar.f, "render_error", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class x implements Runnable {
        x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "native_render_start", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class y implements Runnable {
        y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "native_render_end", jSONObject);
        }
    }

    /* JADX INFO: compiled from: WebviewTimeTrack.java */
    class z implements Runnable {
        z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            o.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, Long.valueOf(jCurrentTimeMillis));
            o oVar = o.this;
            oVar.a(oVar.f, "webview_load_start", (Object) jSONObject, false);
        }
    }

    public o(int i2, String str, com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        this.a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.c = bool;
        this.d = bool;
        this.e = bool;
        this.a = str;
        this.f726b = qVar;
        this.f = new JSONObject();
        this.g = new JSONArray();
        this.h = new JSONArray();
        a(this.f, "webview_source", Integer.valueOf(i2));
    }

    public void g() {
        com.bytedance.sdk.component.utils.i.a().post(new RunnableC0226o());
    }

    public void h() {
        com.bytedance.sdk.component.utils.i.a().post(new x());
    }

    public void i() {
        com.bytedance.sdk.component.utils.i.a().post(new p());
    }

    public void j() {
        com.bytedance.sdk.component.utils.i.a().post(new q());
    }

    public void k() {
        com.bytedance.sdk.component.utils.i.a().post(new k());
    }

    public void l() {
        com.bytedance.sdk.component.utils.i.a().post(new t());
    }

    public void m() {
        com.bytedance.sdk.component.utils.i.a().post(new b0());
    }

    public void n() {
        com.bytedance.sdk.component.utils.i.a().post(new z());
    }

    public void o() {
        com.bytedance.sdk.component.utils.i.a().post(new a0());
    }

    public void p() {
        this.c = Boolean.TRUE;
    }

    public void q() {
        com.bytedance.sdk.component.utils.i.a().post(new l());
    }

    public void b(int i2) {
        com.bytedance.sdk.component.utils.i.a().post(new v(i2));
    }

    public void c() {
        com.bytedance.sdk.component.utils.i.a().post(new b());
    }

    public void d() {
        com.bytedance.sdk.component.utils.i.a().post(new d());
    }

    public void e() {
        com.bytedance.sdk.component.utils.i.a().post(new e());
    }

    public void f() {
        com.bytedance.sdk.component.utils.i.a().post(new y());
    }

    public void b(int i2, String str) {
        com.bytedance.sdk.component.utils.i.a().post(new w(i2, str));
    }

    public void c(String str) {
        com.bytedance.sdk.component.utils.i.a().post(new s(str));
    }

    public void d(String str) {
        com.bytedance.sdk.component.utils.i.a().post(new i(str));
    }

    public void e(String str) {
        com.bytedance.sdk.component.utils.i.a().post(new h(str));
    }

    public void b(JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.i.a().post(new a(jSONObject));
    }

    public void b() {
        com.bytedance.sdk.component.utils.i.a().post(new c());
    }

    public void a(String str, long j2, long j3, int i2) {
        com.bytedance.sdk.component.utils.i.a().post(new f(str, j3, j2, i2));
    }

    public void b(String str, long j2, long j3, int i2) {
        com.bytedance.sdk.component.utils.i.a().post(new g(str, j3, j2, i2));
    }

    public void a(JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.i.a().post(new j(jSONObject));
    }

    public void b(String str) {
        com.bytedance.sdk.component.utils.i.a().post(new m(str));
    }

    public void a(boolean z2) {
        this.e = Boolean.valueOf(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return this.e.booleanValue() || (this.d.booleanValue() && this.c.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj, boolean z2) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z2) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj) {
        a(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception unused) {
        }
    }

    public void a(int i2, String str) {
        com.bytedance.sdk.component.utils.i.a().post(new n(i2, str));
    }

    public void a(String str) {
        com.bytedance.sdk.component.utils.i.a().post(new r(str));
    }

    public void a(int i2) {
        com.bytedance.sdk.component.utils.i.a().post(new u(i2));
    }
}
