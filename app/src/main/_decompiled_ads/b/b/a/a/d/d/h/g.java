package b.b.a.a.d.d.h;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import b.b.a.a.d.d.i.j;
import com.facebook.appevents.integrity.IntegrityManager;
import com.tapjoy.TJAdUnitConstants;

/* JADX INFO: compiled from: DynamicLayoutNativeValue.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f90b;
    private f c;
    private e d;
    private String e;

    public g(e eVar) {
        this.d = eVar;
        this.a = eVar.c();
        this.f90b = eVar.a();
        this.e = eVar.b();
        if (b.b.a.a.d.c.b() == 1) {
            this.c = eVar.d();
        } else {
            this.c = eVar.g();
        }
        if (b.b.a.a.d.c.c()) {
            this.c = eVar.g();
        }
    }

    private boolean V() {
        if (b.b.a.a.d.c.c()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.f90b) && this.f90b.contains("adx:")) || j.b();
    }

    private boolean Y() {
        return (b.b.a.a.d.c.c() && (this.d.f().contains("logo-union") || this.d.f().contains("logounion") || this.d.f().contains("logoad"))) || "logo-union".equals(this.d.f()) || "logounion".equals(this.d.f()) || "logoad".equals(this.d.f());
    }

    public int A() {
        return this.c.J();
    }

    public String B() {
        return this.c.K();
    }

    public int C() {
        return this.c.L();
    }

    public String D() {
        return this.c.M();
    }

    public boolean E() {
        return this.c.N();
    }

    public int F() {
        return this.c.O();
    }

    public int G() {
        return this.c.U();
    }

    public int H() {
        return this.c.j();
    }

    public int I() {
        return (int) this.c.a0();
    }

    public int J() {
        return (int) this.c.b0();
    }

    public int K() {
        return (int) this.c.c0();
    }

    public int L() {
        return (int) this.c.d0();
    }

    public int M() {
        return this.c.i0();
    }

    public double N() {
        if (this.a == 11) {
            try {
                double d = Double.parseDouble(this.f90b);
                return !b.b.a.a.d.c.c() ? (int) d : d;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public String O() {
        return this.a == 0 ? this.f90b : "";
    }

    public int P() {
        String strK0 = this.c.k0();
        if ("left".equals(strK0)) {
            return 17;
        }
        if ("center".equals(strK0)) {
            return 4;
        }
        return "right".equals(strK0) ? 3 : 2;
    }

    public int Q() {
        return this.c.l0();
    }

    public int R() {
        return this.c.m0();
    }

    public int S() {
        return b(this.c.v());
    }

    public double T() {
        return this.c.o0();
    }

    public int U() {
        return this.c.r0();
    }

    public boolean W() {
        return this.c.P();
    }

    public boolean X() {
        return this.c.v0();
    }

    public boolean Z() {
        return this.c.t0();
    }

    public void a(float f) {
        this.c.a(f);
    }

    public double b() {
        return this.c.e();
    }

    public boolean c() {
        return this.c.f();
    }

    public int d() {
        return this.c.g();
    }

    public String e() {
        return this.c.h();
    }

    public String f() {
        return this.c.i();
    }

    public int g() {
        return this.c.k();
    }

    public int h() {
        return this.c.l();
    }

    public int i() {
        return b(this.c.m());
    }

    public float j() {
        return this.c.n();
    }

    public int k() {
        return this.c.o();
    }

    public float l() {
        return this.c.p();
    }

    public int m() {
        return this.c.q();
    }

    public int n() {
        return this.c.r();
    }

    public String o() {
        int i = this.a;
        return (i == 2 || i == 13) ? this.f90b : "";
    }

    public int p() {
        String strT = this.c.t();
        if ("skip-with-time-skip-btn".equals(this.d.f()) || "skip".equals(this.d.f()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.d.f())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.d.f()) && !"skip-with-time".equals(this.d.f())) {
            if (this.a == 10 && TextUtils.equals(this.c.u(), "click")) {
                return 5;
            }
            if (Y() && V()) {
                return 0;
            }
            if (Y()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.d.f())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strT) && !strT.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                if (strT.equals("video") || (this.d.c() == 7 && TextUtils.equals(strT, "normal"))) {
                    return (b.b.a.a.d.c.c() && this.d.g() != null && this.d.g().g0()) ? 11 : 4;
                }
                if (strT.equals("normal")) {
                    return 1;
                }
                return (strT.equals("creative") || "slide".equals(this.c.u())) ? 2 : 0;
            }
        }
        return 0;
    }

    public String q() {
        return this.c.u();
    }

    public String r() {
        return this.e;
    }

    public float s() {
        return this.c.A();
    }

    public int t() {
        int iP = P();
        if (iP == 4) {
            return 17;
        }
        return iP == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String u() {
        return this.c.D();
    }

    public String v() {
        return this.a == 1 ? this.f90b : "";
    }

    public String w() {
        return this.c.E();
    }

    public String x() {
        return this.c.F();
    }

    public int y() {
        return this.c.G();
    }

    public boolean z() {
        return this.c.I();
    }

    public static int b(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals(TJAdUnitConstants.String.TRANSPARENT)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null && strArrSplit.length == 4) {
            return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
        }
        return -16777216;
    }

    public int a() {
        return b(this.c.d());
    }

    public static float[] a(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public boolean a(int i) {
        e eVar = this.d;
        if (eVar == null) {
            return false;
        }
        if (i == 1) {
            this.c = eVar.d();
        } else {
            this.c = eVar.g();
        }
        return this.c != null;
    }
}
