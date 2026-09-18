package com.bytedance.sdk.openadsdk.core.f0;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MaterialMeta.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q {
    private long a = 0;

    /* JADX INFO: compiled from: MaterialMeta.java */
    public static class a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f587b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public static b.b.a.a.d.e.c.c a(a aVar, String str) {
            return b.b.a.a.d.e.c.c.a().b(aVar.d()).c(aVar.e()).e(aVar.f()).a(aVar.a()).f(aVar.g()).d(str);
        }

        public String b() {
            return this.e;
        }

        public String c() {
            return this.g;
        }

        public String d() {
            return this.a;
        }

        public String e() {
            return this.f587b;
        }

        public String f() {
            return this.c;
        }

        public String g() {
            return this.f;
        }

        public void b(String str) {
            this.e = str;
        }

        public void c(String str) {
            this.g = str;
        }

        public void d(String str) {
            this.a = str;
        }

        public void e(String str) {
            this.f587b = str;
        }

        public void f(String str) {
            this.c = str;
        }

        public void g(String str) {
            this.f = str;
        }

        public String a() {
            return this.d;
        }

        public void a(String str) {
            this.d = str;
        }
    }

    public static boolean a(q qVar, boolean z, boolean z2, boolean z3) {
        if (b(qVar) || z3 || qVar == null || qVar.N0() == null || TextUtils.isEmpty(qVar.N0().d())) {
            return false;
        }
        if (qVar.N0() == null || qVar.N0().g() != 1) {
            com.bytedance.sdk.component.utils.m.a("MaterialMeta", "can show end card follow js WebViewClient");
            return z;
        }
        com.bytedance.sdk.component.utils.m.a("MaterialMeta", "can show end card follow js");
        return z2;
    }

    public static boolean b(q qVar) {
        return (qVar == null || qVar.N0() == null || qVar.N0().e() == 0) ? false : true;
    }

    public static long d(String str) {
        return c(a(str));
    }

    public static int e(String str) {
        return d(a(str));
    }

    public static q l1() {
        return new u();
    }

    public abstract String A();

    public abstract void A(int i);

    public abstract int A0();

    public abstract String B();

    public abstract void B(int i);

    public abstract String B0();

    public abstract int C();

    public abstract void C(int i);

    public abstract boolean C0();

    public abstract String D();

    public abstract void D(int i);

    public abstract JSONObject D0();

    public abstract String E();

    public abstract void E(int i);

    public abstract List<String> E0();

    public abstract String F();

    public abstract void F(int i);

    public abstract String F0();

    public abstract int G();

    public abstract void G(int i);

    public long G0() {
        return this.a;
    }

    public abstract String H();

    public abstract void H(int i);

    public abstract String H0();

    public abstract int I();

    public abstract void I(int i);

    public abstract a I0();

    public abstract String J();

    public abstract void J(int i);

    public abstract String[] J0();

    public abstract int K();

    public abstract String K0();

    public abstract com.bytedance.sdk.component.widget.b.a L();

    public abstract int L0();

    public abstract long M();

    public abstract com.bytedance.sdk.openadsdk.core.i0.a M0();

    public abstract String N();

    public abstract b.a.a.a.a.a.a.f.b N0();

    public abstract JSONObject O();

    public abstract int O0();

    public abstract JSONObject P();

    public abstract int P0();

    public abstract long Q();

    public abstract boolean Q0();

    public abstract int R();

    public abstract boolean R0();

    public abstract int S();

    public abstract boolean S0();

    public abstract double T();

    public abstract boolean T0();

    public abstract String U();

    public abstract boolean U0();

    public abstract int V();

    public abstract boolean V0();

    public abstract List<FilterWord> W();

    public abstract boolean W0();

    public abstract String X();

    public abstract boolean X0();

    public abstract b.a.a.a.a.a.a.f.b Y();

    public abstract boolean Y0();

    public abstract b.a.a.a.a.a.a.f.b Z();

    public abstract boolean Z0();

    public abstract void a(double d);

    public abstract void a(float f);

    public abstract void a(int i);

    public abstract void a(int i, int i2);

    public abstract void a(long j);

    public abstract void a(b.a.a.a.a.a.a.f.b bVar);

    public abstract void a(AdSlot adSlot);

    public abstract void a(FilterWord filterWord);

    public abstract void a(c cVar);

    public abstract void a(d dVar);

    public abstract void a(h hVar);

    public abstract void a(j jVar);

    public abstract void a(k kVar);

    public abstract void a(l lVar);

    public abstract void a(n nVar);

    public abstract void a(p pVar);

    public abstract void a(a aVar);

    public abstract void a(t tVar);

    public abstract void a(com.bytedance.sdk.openadsdk.core.i0.a aVar);

    public abstract void a(Map<String, Object> map);

    public abstract void a(JSONObject jSONObject);

    public abstract void a(boolean z);

    public abstract void a(String[] strArr);

    public abstract boolean a();

    public abstract int a0();

    public abstract boolean a1();

    public abstract void b(double d);

    public abstract void b(int i);

    public abstract void b(long j);

    public abstract void b(b.a.a.a.a.a.a.f.b bVar);

    public abstract void b(n nVar);

    public abstract void b(boolean z);

    public abstract boolean b();

    public abstract n b0();

    public abstract boolean b1();

    public abstract String c(String str);

    public abstract void c(int i);

    public void c(long j) {
        this.a = j;
    }

    public abstract void c(b.a.a.a.a.a.a.f.b bVar);

    public abstract void c(n nVar);

    public abstract void c(boolean z);

    public abstract boolean c();

    public abstract int c0();

    public abstract boolean c1();

    public abstract void d(int i);

    public abstract void d(boolean z);

    public abstract List<n> d0();

    public abstract boolean d1();

    public abstract String e();

    public abstract void e(int i);

    public abstract void e(JSONObject jSONObject);

    public abstract void e(boolean z);

    public abstract int e0();

    public abstract boolean e1();

    public abstract AdSlot f();

    public abstract void f(int i);

    public abstract void f(String str);

    public abstract void f(JSONObject jSONObject);

    public abstract void f(boolean z);

    public abstract int f0();

    public abstract boolean f1();

    public abstract int g();

    public abstract void g(int i);

    public abstract void g(String str);

    public abstract int g0();

    public abstract boolean g1();

    public abstract c h();

    public abstract void h(int i);

    public abstract void h(String str);

    public abstract p h0();

    public abstract boolean h1();

    public abstract String i();

    public abstract void i(int i);

    public abstract void i(String str);

    public abstract Map<String, Object> i0();

    public abstract boolean i1();

    public abstract String j();

    public abstract void j(int i);

    public abstract void j(String str);

    public abstract int j0();

    public abstract boolean j1();

    public abstract int k();

    public abstract void k(int i);

    public abstract void k(String str);

    public abstract int k0();

    public abstract boolean k1();

    public abstract d l();

    public abstract void l(int i);

    public abstract void l(String str);

    public abstract int l0();

    public abstract int m();

    public abstract void m(int i);

    public abstract void m(String str);

    public abstract int m0();

    public abstract void m1();

    public abstract long n();

    public abstract void n(int i);

    public abstract void n(String str);

    public abstract String n0();

    public abstract JSONObject n1();

    public abstract float o();

    public abstract void o(int i);

    public abstract void o(String str);

    public abstract int o0();

    public abstract void o1();

    public abstract String p();

    public abstract void p(int i);

    public abstract void p(String str);

    public abstract int p0();

    public abstract int q();

    public abstract void q(int i);

    public abstract void q(String str);

    public abstract List<String> q0();

    public abstract String r();

    public abstract void r(int i);

    public abstract void r(String str);

    public abstract int r0();

    public abstract h s();

    public abstract void s(int i);

    public abstract void s(String str);

    public abstract int s0();

    public abstract z t();

    public abstract void t(int i);

    public abstract void t(String str);

    public abstract t t0();

    public abstract List<String> u();

    public abstract void u(int i);

    public abstract void u(String str);

    public abstract int u0();

    public abstract int v();

    public abstract void v(int i);

    public abstract void v(String str);

    public abstract long v0();

    public abstract n w();

    public abstract void w(int i);

    public abstract void w(String str);

    public abstract int w0();

    public abstract String x();

    public abstract void x(int i);

    public abstract void x(String str);

    public abstract int x0();

    public abstract int y();

    public abstract void y(int i);

    public abstract void y(String str);

    public abstract int y0();

    public abstract j z();

    public abstract void z(int i);

    public abstract int z0();

    public static double b(String str) {
        return b(a(str));
    }

    public static boolean c(q qVar) {
        if (qVar == null) {
            return false;
        }
        int iC0 = qVar.c0();
        return qVar.k1() || iC0 == 5 || iC0 == 15 || iC0 == 50;
    }

    public static int d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    private static double b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    private static long c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public boolean d() {
        return (TextUtils.isEmpty(E()) || TextUtils.isEmpty(F())) ? false : true;
    }

    public static boolean a(q qVar) {
        return (qVar == null || qVar.N0() == null || qVar.N0().g() != 1) ? false : true;
    }

    public static com.bytedance.sdk.openadsdk.core.j0.a.b a(String str, q qVar) {
        qVar.z(0);
        int iR = qVar.R();
        int i = 3;
        if (iR == 3) {
            i = 4;
        } else if (iR == 7) {
            i = 1;
        } else if (iR == 8) {
            i = 2;
        }
        return new com.bytedance.sdk.openadsdk.core.j0.a.b(str, qVar.Y(), qVar.Z(), qVar.u0(), qVar.P0(), i);
    }

    public static JSONObject a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.m.b("MaterialMeta", e.getMessage());
            }
        }
        return null;
    }
}
