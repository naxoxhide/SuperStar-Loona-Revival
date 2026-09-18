package com.bytedance.sdk.openadsdk.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.y;
import com.google.firebase.messaging.Constants;
import com.tapjoy.TJAdUnitConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements b.b.a.a.i.a.m.c.b {
    private static final Set<String> q = new HashSet(Arrays.asList("insight_log"));
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final JSONObject f715b;
    private long c;
    private long d;
    private AtomicBoolean e;
    private JSONObject f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private com.bytedance.sdk.openadsdk.d.q.a l;
    private String m;
    private String n;
    private int o;
    private String p;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdEvent.java */
    public static final class C0221a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f716b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private JSONObject i;
        private String j;
        private final int k = p.b(com.bytedance.sdk.openadsdk.core.o.a());
        private String l;
        private com.bytedance.sdk.openadsdk.d.q.b m;
        private com.bytedance.sdk.openadsdk.d.q.a n;
        private final long o;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.d.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdEvent.java */
        class C0222a extends b.b.a.a.k.g {
            final /* synthetic */ a c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0222a(C0221a c0221a, String str, a aVar) {
                super(str);
                this.c = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.d.p.d.a(this.c);
            }
        }

        public C0221a(long j) {
            this.o = j;
        }

        public C0221a b(String str) {
            this.d = str;
            return this;
        }

        public C0221a c(String str) {
            this.h = str;
            return this;
        }

        public C0221a d(String str) {
            this.c = str;
            return this;
        }

        public C0221a e(String str) {
            this.e = str;
            return this;
        }

        public C0221a f(String str) {
            this.f = str;
            return this;
        }

        public C0221a g(String str) {
            this.f716b = str;
            return this;
        }

        public C0221a h(String str) {
            this.g = str;
            return this;
        }

        public C0221a a(String str) {
            this.l = str;
            return this;
        }

        public C0221a a(JSONObject jSONObject, q qVar) {
            JSONObject jSONObject2;
            if (jSONObject == null) {
                return this;
            }
            this.i = jSONObject;
            if (t.i(qVar) && this.i != null && !TJAdUnitConstants.String.BEACON_SHOW_PATH.equals(this.c)) {
                try {
                    String strOptString = this.i.optString("ad_extra_data", null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        jSONObject2 = new JSONObject(strOptString);
                    } else {
                        jSONObject2 = new JSONObject();
                    }
                    jSONObject2.put("interaction_method", qVar.k0());
                    jSONObject2.put("real_interaction_method", qVar.v());
                    this.i.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
            }
            return this;
        }

        public void a(com.bytedance.sdk.openadsdk.d.q.a aVar) {
            this.n = aVar;
            a aVar2 = new a(this);
            try {
                com.bytedance.sdk.openadsdk.d.q.b bVar = this.m;
                if (bVar != null) {
                    bVar.a(aVar2.f715b, this.o);
                } else {
                    new com.bytedance.sdk.openadsdk.d.q.c().a(aVar2.f715b, this.o);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.d("AdEvent", th);
            }
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                y.d(new C0222a(this, "dispatchEvent", aVar2));
            } else {
                com.bytedance.sdk.openadsdk.d.p.d.a(aVar2);
            }
        }
    }

    public a(String str, JSONObject jSONObject) {
        this.e = new AtomicBoolean(false);
        this.f = new JSONObject();
        this.a = str;
        this.f715b = jSONObject;
    }

    private boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0") || TextUtils.isEmpty(str3)) {
            return false;
        }
        str2.hashCode();
        str2.hashCode();
        switch (str2) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    private boolean b(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    private void c() throws JSONException {
        this.f715b.putOpt("app_log_url", this.p);
        this.f715b.putOpt("tag", this.g);
        this.f715b.putOpt(Constants.ScionAnalytics.PARAM_LABEL, this.h);
        this.f715b.putOpt("category", this.i);
        if (!TextUtils.isEmpty(this.j)) {
            try {
                this.f715b.putOpt("value", Long.valueOf(Long.parseLong(this.j)));
            } catch (NumberFormatException unused) {
                this.f715b.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.k)) {
            try {
                this.f715b.putOpt("ext_value", Long.valueOf(Long.parseLong(this.k)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.n)) {
            this.f715b.putOpt("log_extra", this.n);
        }
        if (!TextUtils.isEmpty(this.m)) {
            try {
                this.f715b.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.m)));
            } catch (NumberFormatException unused3) {
            }
        }
        a(this.f715b, this.h);
        try {
            this.f715b.putOpt("nt", Integer.valueOf(this.o));
        } catch (Exception unused4) {
        }
        Iterator<String> itKeys = this.f.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.f715b.putOpt(next, this.f.opt(next));
        }
    }

    private void d() {
        JSONObject jSONObject = this.f;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("value");
            String strOptString2 = this.f.optString("category");
            String strOptString3 = this.f.optString("log_extra");
            if (a(this.j, this.i, this.n)) {
                if (!TextUtils.isEmpty(strOptString) && TextUtils.equals(strOptString, "0")) {
                    return;
                }
                if (!TextUtils.isEmpty(strOptString2) && !b(strOptString2)) {
                    return;
                }
            } else {
                if ((TextUtils.isEmpty(strOptString) || TextUtils.equals(strOptString, "0")) && (TextUtils.isEmpty(this.j) || TextUtils.equals(this.j, "0"))) {
                    return;
                }
                if ((TextUtils.isEmpty(this.i) || !b(this.i)) && (TextUtils.isEmpty(strOptString2) || !b(strOptString2))) {
                    return;
                }
                if (TextUtils.isEmpty(this.n) && TextUtils.isEmpty(strOptString3)) {
                    return;
                }
            }
        } else if (!a(this.j, this.i, this.n)) {
            return;
        }
        this.c = com.bytedance.sdk.openadsdk.d.p.d.a.incrementAndGet();
    }

    public JSONObject e() {
        if (this.e.get()) {
            return this.f715b;
        }
        try {
            c();
            com.bytedance.sdk.openadsdk.d.q.a aVar = this.l;
            if (aVar != null) {
                aVar.a(this.f715b);
            }
            if (this.f715b.has("ad_extra_data")) {
                Object objOpt = this.f715b.opt("ad_extra_data");
                if (objOpt != null) {
                    try {
                        if (objOpt instanceof JSONObject) {
                            com.bytedance.sdk.component.utils.m.b("AdEvent", "ad_extra_data is JSONObject");
                            if (!((JSONObject) objOpt).has("adiff")) {
                                ((JSONObject) objOpt).put("adiff", this.a);
                            }
                            this.f715b.put("ad_extra_data", objOpt.toString());
                        } else if (objOpt instanceof String) {
                            JSONObject jSONObject = new JSONObject((String) objOpt);
                            if (!jSONObject.has("adiff")) {
                                jSONObject.put("adiff", this.a);
                            }
                            this.f715b.put("ad_extra_data", jSONObject.toString());
                        }
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.m.b("AdEvent", "json error", e.getMessage());
                    }
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("adiff", this.a);
                    this.f715b.put("ad_extra_data", jSONObject2.toString());
                } catch (JSONException e2) {
                    com.bytedance.sdk.component.utils.m.b("AdEvent", "json error", e2.getMessage());
                }
            }
            this.e.set(true);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.d("AdEvent", th);
        }
        return this.f715b;
    }

    public String f() {
        return this.a;
    }

    public boolean g() {
        Set<String> setW;
        if (this.f715b == null || (setW = com.bytedance.sdk.openadsdk.core.o.d().w()) == null) {
            return false;
        }
        String strOptString = this.f715b.optString(Constants.ScionAnalytics.PARAM_LABEL);
        if (!TextUtils.isEmpty(strOptString)) {
            return setW.contains(strOptString);
        }
        if (TextUtils.isEmpty(this.h)) {
            return false;
        }
        return setW.contains(this.h);
    }

    @Override // b.b.a.a.i.a.m.c.b
    public long b() {
        return this.c;
    }

    public JSONObject a(boolean z) {
        JSONObject jSONObjectE = e();
        try {
            if (z) {
                JSONObject jSONObject = new JSONObject(jSONObjectE.toString());
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    jSONObjectOptJSONObject.remove("app_log_url");
                }
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(jSONObjectE.toString());
            jSONObject2.remove("app_log_url");
            return jSONObject2;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.m.b("AdEvent", e.getMessage());
            return jSONObjectE;
        }
    }

    @Override // b.b.a.a.i.a.m.c.b
    public JSONObject a(String str) {
        return e();
    }

    @Override // b.b.a.a.i.a.m.c.b
    public long a() {
        return this.d;
    }

    private static void a(JSONObject jSONObject, String str) {
        try {
            Set<String> set = q;
            if (!set.contains(str) && !set.contains(jSONObject.get(Constants.ScionAnalytics.PARAM_LABEL))) {
                jSONObject.putOpt("is_ad_event", "1");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("AdEvent", th);
        }
    }

    a(C0221a c0221a) {
        this.e = new AtomicBoolean(false);
        this.f = new JSONObject();
        if (!TextUtils.isEmpty(c0221a.a)) {
            this.a = c0221a.a;
        } else {
            this.a = com.bytedance.sdk.openadsdk.utils.q.a();
        }
        this.l = c0221a.n;
        this.n = c0221a.e;
        this.g = c0221a.f716b;
        this.h = c0221a.c;
        if (!TextUtils.isEmpty(c0221a.d)) {
            this.i = c0221a.d;
        } else {
            this.i = "app_union";
        }
        this.m = c0221a.j;
        this.j = c0221a.g;
        this.k = c0221a.h;
        String unused = c0221a.f;
        this.o = c0221a.k;
        this.p = c0221a.l;
        this.f = c0221a.i = c0221a.i != null ? c0221a.i : new JSONObject();
        JSONObject jSONObject = new JSONObject();
        this.f715b = jSONObject;
        if (!TextUtils.isEmpty(c0221a.l)) {
            try {
                jSONObject.put("app_log_url", c0221a.l);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.m.b("AdEvent", e.getMessage());
            }
        }
        this.d = System.currentTimeMillis();
        d();
    }
}
