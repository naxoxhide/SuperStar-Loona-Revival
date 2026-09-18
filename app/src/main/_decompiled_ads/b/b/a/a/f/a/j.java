package b.b.a.a.f.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: OkHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements Cloneable {
    public List<h> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f146b;
    public TimeUnit c;
    public long d;
    public TimeUnit e;
    public long f;
    public TimeUnit g;

    public j(a aVar) {
        this.f146b = aVar.f147b;
        this.d = aVar.d;
        this.f = aVar.f;
        List<h> list = aVar.a;
        this.a = list;
        this.c = aVar.c;
        this.e = aVar.e;
        this.g = aVar.g;
        this.a = list;
    }

    public abstract b a(l lVar);

    public abstract d a();

    public a c() {
        return new a(this);
    }

    /* JADX INFO: compiled from: OkHttpClient.java */
    public static final class a {
        public final List<h> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f147b;
        public TimeUnit c;
        public long d;
        public TimeUnit e;
        public long f;
        public TimeUnit g;

        public a() {
            this.a = new ArrayList();
            this.f147b = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.c = timeUnit;
            this.d = 10000L;
            this.e = timeUnit;
            this.f = 10000L;
            this.g = timeUnit;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.f147b = j;
            this.c = timeUnit;
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.d = j;
            this.e = timeUnit;
            return this;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.f = j;
            this.g = timeUnit;
            return this;
        }

        public a a(h hVar) {
            this.a.add(hVar);
            return this;
        }

        public j a() {
            return b.b.a.a.f.a.p.a.a(this);
        }

        public a(String str) {
            this.a = new ArrayList();
            this.f147b = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.c = timeUnit;
            this.d = 10000L;
            this.e = timeUnit;
            this.f = 10000L;
            this.g = timeUnit;
        }

        public a(j jVar) {
            this.a = new ArrayList();
            this.f147b = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.c = timeUnit;
            this.d = 10000L;
            this.e = timeUnit;
            this.f = 10000L;
            this.g = timeUnit;
            this.f147b = jVar.f146b;
            this.c = jVar.c;
            this.d = jVar.d;
            this.e = jVar.e;
            this.f = jVar.f;
            this.g = jVar.g;
        }
    }
}
