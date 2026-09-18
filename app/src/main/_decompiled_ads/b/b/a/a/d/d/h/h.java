package b.b.a.a.d.d.h;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DynamicLayoutUnit.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f91b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private e i;
    private List<h> j;
    private h k;
    private List<List<h>> l;
    private String m;
    private Map<Integer, String> n = new HashMap();

    public void a(String str) {
        this.m = str;
    }

    public String b() {
        return this.m;
    }

    public Map<Integer, String> c() {
        return this.n;
    }

    public void d(float f) {
        this.e = f;
    }

    public void e(float f) {
        this.f = f;
    }

    public void f(float f) {
        this.f91b = f;
    }

    public String g() {
        return this.a;
    }

    public float h() {
        f fVarG = this.i.g();
        return k() + fVarG.d0() + fVarG.a0() + (fVarG.p() * 2.0f);
    }

    public float i() {
        f fVarG = this.i.g();
        return j() + fVarG.b0() + fVarG.c0() + (fVarG.p() * 2.0f);
    }

    public int j() {
        f fVarG = this.i.g();
        return fVarG.X() + fVarG.Y();
    }

    public int k() {
        f fVarG = this.i.g();
        return fVarG.Z() + fVarG.W();
    }

    public h l() {
        return this.k;
    }

    public String m() {
        return this.i.g().d();
    }

    public e n() {
        return this.i;
    }

    public float o() {
        return this.d;
    }

    public float p() {
        return this.e;
    }

    public float q() {
        return this.f;
    }

    public float r() {
        return this.f91b;
    }

    public float s() {
        return this.c;
    }

    public boolean t() {
        return this.i.g().p0() < 0 || this.i.g().s() < 0 || this.i.g().S() < 0 || this.i.g().f0() < 0;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.a + "', x=" + this.f91b + ", y=" + this.c + ", width=" + this.f + ", height=" + this.g + ", remainWidth=" + this.h + ", rootBrick=" + this.i + ", childrenBrickUnits=" + this.j + '}';
    }

    public boolean u() {
        List<h> list = this.j;
        return list == null || list.size() <= 0;
    }

    public boolean v() {
        return TextUtils.equals(this.i.g().q0(), "flex");
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.n.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(float f) {
        this.d = f;
    }

    public List<List<h>> d() {
        return this.l;
    }

    public List<h> e() {
        return this.j;
    }

    public float f() {
        return this.g;
    }

    public void g(float f) {
        this.c = f;
    }

    public void b(float f) {
        this.h = f;
    }

    public void c(String str) {
        this.i.g().d(str);
    }

    public void b(List<h> list) {
        this.j = list;
    }

    public void a(float f) {
        this.g = f;
    }

    public void a(e eVar) {
        this.i = eVar;
    }

    public void a(h hVar) {
        this.k = hVar;
    }

    public void a(List<List<h>> list) {
        this.l = list;
    }

    public void a() {
        List<List<h>> list = this.l;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<h> list2 : this.l) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.l = arrayList;
    }

    public String a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.f());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.a);
        if (this.i.g() != null) {
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.i.g().c());
        }
        sb.append(CertificateUtil.DELIMITER);
        sb.append(i);
        return sb.toString();
    }
}
