package b.b.a.a.h.x;

import android.content.Context;
import b.b.a.a.h.l;
import b.b.a.a.h.m;
import b.b.a.a.h.p;
import b.b.a.a.h.q;
import b.b.a.a.h.r;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: LoadConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements m {
    private l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f176b;
    private b.b.a.a.h.d c;
    private q d;
    private r e;
    private b.b.a.a.h.c f;
    private p g;
    private b.b.a.a.h.b h;

    /* JADX INFO: compiled from: LoadConfig.java */
    public static class b {
        private l a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ExecutorService f177b;
        private b.b.a.a.h.d c;
        private q d;
        private r e;
        private b.b.a.a.h.c f;
        private p g;
        private b.b.a.a.h.b h;

        public b a(b.b.a.a.h.b bVar) {
            this.h = bVar;
            return this;
        }

        public b a(ExecutorService executorService) {
            this.f177b = executorService;
            return this;
        }

        public b a(b.b.a.a.h.d dVar) {
            this.c = dVar;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    @Override // b.b.a.a.h.m
    public b.b.a.a.h.c a() {
        return this.f;
    }

    @Override // b.b.a.a.h.m
    public l b() {
        return this.a;
    }

    @Override // b.b.a.a.h.m
    public b.b.a.a.h.b c() {
        return this.h;
    }

    @Override // b.b.a.a.h.m
    public q d() {
        return this.d;
    }

    @Override // b.b.a.a.h.m
    public p e() {
        return this.g;
    }

    @Override // b.b.a.a.h.m
    public b.b.a.a.h.d f() {
        return this.c;
    }

    @Override // b.b.a.a.h.m
    public r g() {
        return this.e;
    }

    @Override // b.b.a.a.h.m
    public ExecutorService h() {
        return this.f176b;
    }

    private e(b bVar) {
        this.a = bVar.a;
        this.f176b = bVar.f177b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.h = bVar.h;
        this.g = bVar.g;
    }

    public static e a(Context context) {
        return new b().a();
    }
}
