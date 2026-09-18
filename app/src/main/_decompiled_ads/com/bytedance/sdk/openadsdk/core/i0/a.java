package com.bytedance.sdk.openadsdk.core.i0;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastAdConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    b f599b;
    c c;
    private String d;
    private String e;
    private String f;
    private String g;
    private double h;
    private int i;
    private int j;
    private String k;
    private String n;
    d a = new d(this);
    private Set<j> l = new HashSet();
    private String m = "VAST_ACTION_BUTTON";

    private JSONArray j() {
        JSONArray jSONArray = new JSONArray();
        for (j jVar : this.l) {
            if (jVar != null) {
                jSONArray.put(jVar.d());
            }
        }
        return jSONArray;
    }

    public String a() {
        return this.f;
    }

    public String b() {
        return this.e;
    }

    public c c() {
        return this.c;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoTrackers", this.a.c());
        b bVar = this.f599b;
        if (bVar != null) {
            jSONObject.put("vastIcon", bVar.e());
        }
        c cVar = this.c;
        if (cVar != null) {
            jSONObject.put("endCard", cVar.e());
        }
        jSONObject.put("title", this.d);
        jSONObject.put("description", this.e);
        jSONObject.put("clickThroughUrl", this.f);
        jSONObject.put("videoUrl", this.g);
        jSONObject.put("videDuration", this.h);
        jSONObject.put("tag", this.k);
        jSONObject.put(TJAdUnitConstants.String.VIDEO_WIDTH, this.i);
        jSONObject.put(TJAdUnitConstants.String.VIDEO_HEIGHT, this.j);
        jSONObject.put("viewabilityVendor", j());
        return jSONObject;
    }

    public String e() {
        return this.k;
    }

    public void f(String str) {
        this.d = str;
    }

    public String g() {
        return this.d;
    }

    public b h() {
        return this.f599b;
    }

    public Set<j> i() {
        return this.l;
    }

    public double k() {
        return this.h;
    }

    public int l() {
        return this.j;
    }

    public d m() {
        return this.a;
    }

    public String n() {
        return this.g;
    }

    public int o() {
        return this.i;
    }

    public void p() {
    }

    public void a(b bVar) {
        if (bVar != null) {
            bVar.a(this.g);
        }
        this.f599b = bVar;
    }

    public void b(String str) {
        this.m = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.n = str;
    }

    public String f() {
        c cVar;
        String str = this.f;
        if (!TextUtils.isEmpty(this.n)) {
            String str2 = this.n;
            this.n = null;
            return str2;
        }
        String str3 = this.m;
        str3.hashCode();
        if (str3.equals("VAST_ICON")) {
            b bVar = this.f599b;
            if (bVar != null && !TextUtils.isEmpty(bVar.h)) {
                str = this.f599b.h;
            }
        } else if (str3.equals("VAST_END_CARD") && (cVar = this.c) != null && !TextUtils.isEmpty(cVar.h)) {
            str = this.c.h;
        }
        this.m = "VAST_ACTION_BUTTON";
        return str;
    }

    public void g(String str) {
        this.g = str;
    }

    public void b(int i) {
        this.i = i;
    }

    public void a(c cVar) {
        if (cVar != null) {
            cVar.a(this.g);
        }
        this.c = cVar;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(double d) {
        this.h = d;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.a.a(jSONObject.optJSONObject("videoTrackers"));
        aVar.f599b = b.b(jSONObject.optJSONObject("vastIcon"));
        aVar.c = c.a(jSONObject.optJSONObject("endCard"));
        aVar.d = jSONObject.optString("title");
        aVar.e = jSONObject.optString("description");
        aVar.f = jSONObject.optString("clickThroughUrl");
        aVar.g = jSONObject.optString("videoUrl");
        aVar.h = jSONObject.optDouble("videDuration");
        aVar.k = jSONObject.optString("tag");
        aVar.i = jSONObject.optInt(TJAdUnitConstants.String.VIDEO_WIDTH);
        aVar.i = jSONObject.optInt(TJAdUnitConstants.String.VIDEO_HEIGHT);
        aVar.l.addAll(j.a(jSONObject.optJSONArray("viewabilityVendor")));
        return aVar;
    }

    public void d(String str) {
        this.k = str;
        this.a.b(str);
    }

    public void a(q qVar) {
        this.a.a(qVar);
        b bVar = this.f599b;
        if (bVar != null) {
            bVar.a(qVar);
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(qVar);
        }
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(Set<j> set) {
        if (set == null || set.size() <= 0) {
            return;
        }
        this.l.addAll(set);
    }
}
