package b.b.a.a.f.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public j a;

    /* JADX INFO: compiled from: Request.java */
    public static class a {
        b.b.a.a.f.a.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, List<String>> f149b;
        g c;
        String d;
        Object e;
        m f;

        /* JADX INFO: renamed from: b.b.a.a.f.a.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Request.java */
        class C0032a extends l {
            C0032a() {
            }

            @Override // b.b.a.a.f.a.l
            public m a() {
                return a.this.f;
            }

            @Override // b.b.a.a.f.a.l
            public b.b.a.a.f.a.a b() {
                return a.this.a;
            }

            @Override // b.b.a.a.f.a.l
            public Map c() {
                return a.this.f149b;
            }

            @Override // b.b.a.a.f.a.l
            public String d() {
                return a.this.d;
            }

            @Override // b.b.a.a.f.a.l
            public Object f() {
                return a.this.e;
            }

            @Override // b.b.a.a.f.a.l
            public g g() {
                return a.this.c;
            }

            public String toString() {
                return "";
            }
        }

        public a() {
            this.f149b = new HashMap();
        }

        public a a(b.b.a.a.f.a.a aVar) {
            this.a = aVar;
            return this;
        }

        public a b(String str, String str2) {
            return a(str, str2);
        }

        public a a(Object obj) {
            this.e = obj;
            return this;
        }

        public a b() {
            return a("GET", (m) null);
        }

        a(l lVar) {
            this.c = lVar.g();
            this.d = lVar.d();
            this.f149b = lVar.c();
            this.e = lVar.f();
            this.f = lVar.a();
            this.a = lVar.b();
        }

        public a a(String str) {
            return a(g.b(str));
        }

        public a a(g gVar) {
            this.c = gVar;
            return this;
        }

        public a a(String str, String str2) {
            if (!this.f149b.containsKey(str)) {
                this.f149b.put(str, new ArrayList());
            }
            this.f149b.get(str).add(str2);
            return this;
        }

        private a a(String str, m mVar) {
            this.d = str;
            this.f = mVar;
            return this;
        }

        public a a(m mVar) {
            return a("POST", mVar);
        }

        public l a() {
            return new C0032a();
        }
    }

    public abstract m a();

    public void a(j jVar) {
        this.a = jVar;
    }

    public abstract b.b.a.a.f.a.a b();

    public abstract Map<String, List<String>> c();

    public abstract String d();

    public a e() {
        return new a(this);
    }

    public abstract Object f();

    public abstract g g();
}
