package b.a.a.a.a.a.a.f;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: VideoUrlModel.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {
    private b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f24b;
    private String c;
    private int d;
    private int e;
    private long f;
    private boolean g;
    private boolean h;
    public int i;
    private int j;
    private int k;
    public int q;
    public final HashMap<String, Object> l = new HashMap<>();
    private int m = 10000;
    private int n = 10000;
    private int o = 10000;
    private int p = 0;
    private JSONObject r = new JSONObject();

    public c(String str, b bVar, b bVar2, int i, int i2) {
        this.j = 0;
        this.k = 0;
        this.c = str;
        this.a = bVar;
        this.f24b = bVar2;
        this.j = i;
        this.k = i2;
    }

    public void a(long j) {
        this.f = j;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.c = str;
    }

    public long d() {
        return this.f;
    }

    public void d(String str) {
    }

    public String e() {
        if (t()) {
            return this.f24b.h();
        }
        b bVar = this.a;
        if (bVar != null) {
            return bVar.h();
        }
        return null;
    }

    public void e(String str) {
    }

    public void f(int i) {
        this.d = i;
    }

    public int g() {
        return this.r.optInt("pitaya_cache_size", 0);
    }

    public float h() {
        if (t()) {
            return this.f24b.i();
        }
        b bVar = this.a;
        if (bVar != null) {
            return bVar.i();
        }
        return -1.0f;
    }

    public int i() {
        return this.j;
    }

    public int j() {
        if (t()) {
            return this.f24b.r();
        }
        b bVar = this.a;
        if (bVar != null) {
            return bVar.r();
        }
        return 0;
    }

    public int k() {
        return this.n;
    }

    public int l() {
        return this.p;
    }

    public String m() {
        if (t()) {
            return this.f24b.t();
        }
        b bVar = this.a;
        if (bVar != null) {
            return bVar.t();
        }
        return null;
    }

    public b n() {
        return this.a;
    }

    public b o() {
        return this.f24b;
    }

    public long p() {
        if (t()) {
            return this.f24b.p();
        }
        b bVar = this.a;
        if (bVar != null) {
            return bVar.p();
        }
        return 0L;
    }

    public int q() {
        return this.d;
    }

    public int r() {
        return this.o;
    }

    public boolean s() {
        return this.h;
    }

    public boolean t() {
        b bVar;
        if (this.k == 1 && (bVar = this.f24b) != null && !TextUtils.isEmpty(bVar.t())) {
            if (b.a.a.a.a.a.a.c.c() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.j == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean u() {
        if (t()) {
            return this.f24b.u();
        }
        b bVar = this.a;
        if (bVar != null) {
            return bVar.u();
        }
        return true;
    }

    public boolean v() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void b(int i) {
        this.e = i;
    }

    public int c() {
        return this.m;
    }

    public void d(int i) {
        this.i = i;
    }

    public int f() {
        return this.e;
    }

    public void g(int i) {
        this.o = i;
    }

    public synchronized void a(String str, Object obj) {
        this.l.put(str, obj);
    }

    public void c(int i) {
        this.n = i;
    }

    public synchronized Object a(String str) {
        return this.l.get(str);
    }

    public void a(int i) {
        this.m = i;
    }

    public void e(int i) {
        this.p = i;
    }
}
