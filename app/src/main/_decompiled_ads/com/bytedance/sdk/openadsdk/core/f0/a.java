package com.bytedance.sdk.openadsdk.core.f0;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0196a f572b;
    private boolean c;
    private boolean f;
    private List<q> d = new ArrayList();
    private List<g> e = new ArrayList();
    private volatile boolean g = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.f0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdInfo.java */
    public static class C0196a extends q.a {
        private int h;

        public void a(int i) {
            this.h = i;
        }

        public int h() {
            return this.h;
        }

        public JSONObject i() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", d());
                jSONObject.put("md5", e());
                jSONObject.put("url", f());
                jSONObject.put("data", a());
                jSONObject.put("diff_data", b());
                jSONObject.put("version", g());
                jSONObject.put("dynamic_creative", c());
                jSONObject.put("count_down_time", h());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public static C0196a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0196a c0196a = new C0196a();
            c0196a.d(jSONObject.optString("id"));
            c0196a.e(jSONObject.optString("md5"));
            c0196a.f(jSONObject.optString("url"));
            c0196a.a(jSONObject.optString("data"));
            c0196a.b(jSONObject.optString("diff_data"));
            c0196a.g(jSONObject.optString("version"));
            c0196a.c(jSONObject.optString("dynamic_creative"));
            c0196a.a(jSONObject.optInt("count_down_time"));
            if (a(c0196a)) {
                return c0196a;
            }
            return null;
        }

        private static boolean a(C0196a c0196a) {
            return (c0196a == null || TextUtils.isEmpty(c0196a.d()) || TextUtils.isEmpty(c0196a.f())) ? false : true;
        }
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(long j) {
    }

    public void a(String str) {
    }

    public List<q> b() {
        return this.d;
    }

    public void b(String str) {
    }

    public String c() {
        q qVarA = a();
        return qVarA != null ? qVarA.U() : "";
    }

    public void c(String str) {
    }

    public int d() {
        return this.a;
    }

    public C0196a e() {
        return this.f572b;
    }

    public boolean f() {
        List<q> list = this.d;
        return list != null && list.size() > 0;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        if (e() == null || b() == null || b().size() <= 1) {
            this.c = false;
            a((C0196a) null);
        } else {
            this.c = true;
        }
        return this.c;
    }

    public boolean i() {
        return this.f;
    }

    public void j() {
        this.g = false;
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            C0196a c0196aE = e();
            if (c0196aE != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObjectI = c0196aE.i();
                if (jSONObjectI != null) {
                    jSONObject2.put("tpl_info", jSONObjectI);
                    jSONObject.put("choose_ui_data", jSONObject2);
                }
            }
            List<q> list = this.d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.d.size(); i++) {
                    jSONArray.put(this.d.get(i).n1());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("is_choose_ad_original", this.f);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("AdInfo", "toJsonObj: ", th);
            return null;
        }
    }

    public void a(q qVar) {
        this.d.add(qVar);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        a(C0196a.a(jSONObject.optJSONObject("tpl_info")));
    }

    public void a(List<q> list) {
        this.d = list;
    }

    public void a(g gVar) {
        this.e.add(gVar);
    }

    public static Map<String, q> a(a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (q qVar : aVar.b()) {
            if (!TextUtils.isEmpty(qVar.X())) {
                map.put(qVar.X(), qVar);
            }
        }
        if (map.size() != 0) {
            return map;
        }
        return null;
    }

    public q a() {
        if (this.d.size() > 0) {
            return this.d.get(0);
        }
        return null;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(C0196a c0196a) {
        this.f572b = c0196a;
        if (c0196a == null) {
            return;
        }
        b.b.a.a.d.e.b.a.a(q.a.a(c0196a, ""));
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            a aVar = new a();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("choose_ui_data");
            if (jSONObjectOptJSONObject != null) {
                aVar.b(jSONObjectOptJSONObject);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(com.bytedance.sdk.openadsdk.core.b.f(jSONArrayOptJSONArray.optJSONObject(i)));
                }
                aVar.a(arrayList);
            }
            aVar.a(jSONObject.optBoolean("is_choose_ad_original", false));
            return aVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("AdInfo", "fromJson: ", th);
            return null;
        }
    }
}
