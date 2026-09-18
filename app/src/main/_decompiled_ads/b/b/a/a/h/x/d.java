package b.b.a.a.h.x;

import b.b.a.a.h.k;
import java.util.Map;

/* JADX INFO: compiled from: ImageResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class d<T> implements k {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f175b;
    private T c;
    private Map<String, String> d;
    private boolean e;
    private int f;

    public d a(c cVar, T t) {
        this.f175b = t;
        cVar.e();
        this.a = cVar.a();
        cVar.b();
        cVar.c();
        this.e = cVar.r();
        cVar.k();
        this.f = cVar.j();
        return this;
    }

    @Override // b.b.a.a.h.k
    public Map<String, String> b() {
        return this.d;
    }

    @Override // b.b.a.a.h.k
    public T c() {
        return this.f175b;
    }

    @Override // b.b.a.a.h.k
    public int d() {
        return this.f;
    }

    @Override // b.b.a.a.h.k
    public T e() {
        return this.c;
    }

    @Override // b.b.a.a.h.k
    public boolean f() {
        return this.e;
    }

    public d a(c cVar, T t, Map<String, String> map, boolean z) {
        this.d = map;
        return a(cVar, t);
    }

    @Override // b.b.a.a.h.k
    public String a() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.a.a.h.k
    public void a(Object obj) {
        this.c = this.f175b;
        this.f175b = obj;
    }
}
