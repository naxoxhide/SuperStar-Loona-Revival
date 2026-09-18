package b.b.a.a.d.f;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: RenderRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    private JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f117b;
    private String c;
    private i d;
    private int e;
    private boolean f;
    private long g;
    private int h;
    private Map<String, String> i;
    private int j;
    private boolean k;
    private String l;
    private int m;
    private int n;
    private int o;
    private int p;
    private double q;
    private int r;
    private boolean s;

    /* JADX INFO: compiled from: RenderRequest.java */
    public static class a {
        private JSONObject a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f118b;
        private String c;
        private i d;
        private int e;
        private String f;
        private String g;
        private String h;
        private boolean i;
        private int j;
        private long k;
        private int l;
        private String m;
        private Map<String, String> n;
        private int o;
        private boolean p;
        private String q;
        private int r;
        private int s;
        private int t;
        private int u;
        private String v;
        private double w;
        private int x;
        private boolean y = true;

        public a a(e eVar) {
            this.f118b = eVar;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.g = str;
            return this;
        }

        public a d(int i) {
            this.e = i;
            return this;
        }

        public a e(int i) {
            this.j = i;
            return this;
        }

        public a a(boolean z) {
            this.y = z;
            return this;
        }

        public a b(int i) {
            this.o = i;
            return this;
        }

        public a c(boolean z) {
            this.i = z;
            return this;
        }

        public a d(String str) {
            this.h = str;
            return this;
        }

        public a e(String str) {
            this.q = str;
            return this;
        }

        public a a(i iVar) {
            this.d = iVar;
            return this;
        }

        public a b(boolean z) {
            this.p = z;
            return this;
        }

        public a c(int i) {
            this.x = i;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a a(long j) {
            this.k = j;
            return this;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(Map<String, String> map) {
            this.n = map;
            return this;
        }

        public m a() {
            return new m(this);
        }

        public a a(double d) {
            this.w = d;
            return this;
        }
    }

    public m(a aVar) {
        this.a = aVar.a;
        this.f117b = aVar.f118b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        String unused = aVar.f;
        String unused2 = aVar.g;
        String unused3 = aVar.h;
        this.f = aVar.i;
        int unused4 = aVar.j;
        this.g = aVar.k;
        this.h = aVar.l;
        String unused5 = aVar.m;
        this.i = aVar.n;
        this.j = aVar.o;
        this.k = aVar.p;
        this.l = aVar.q;
        this.m = aVar.r;
        this.n = aVar.s;
        this.o = aVar.t;
        this.p = aVar.u;
        String unused6 = aVar.v;
        this.q = aVar.w;
        this.r = aVar.x;
        this.s = aVar.y;
    }

    public String a() {
        return this.c;
    }

    public boolean b() {
        return this.s;
    }

    public long c() {
        return this.g;
    }

    public int d() {
        return this.p;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.r;
    }

    public int g() {
        return this.o;
    }

    public double h() {
        return this.q;
    }

    public int i() {
        return this.m;
    }

    public String j() {
        return this.l;
    }

    public Map<String, String> k() {
        return this.i;
    }

    public int l() {
        return this.h;
    }

    public boolean m() {
        return this.f;
    }

    public boolean n() {
        return this.k;
    }

    public i o() {
        return this.d;
    }

    public int p() {
        return this.j;
    }

    public JSONObject q() {
        e eVar;
        if (this.a == null && (eVar = this.f117b) != null) {
            this.a = eVar.a();
        }
        return this.a;
    }

    public int r() {
        return this.e;
    }
}
