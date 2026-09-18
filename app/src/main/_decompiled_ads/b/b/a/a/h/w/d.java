package b.b.a.a.h.w;

import b.b.a.a.h.f;
import b.b.a.a.h.g;
import java.util.Map;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class d<T> implements f {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f167b;
    private String c;
    Map<String, String> d;
    private g e;

    public d(int i, T t, String str) {
        this.a = i;
        this.f167b = t;
        this.c = str;
    }

    public void a(g gVar) {
        this.e = gVar;
    }

    @Override // b.b.a.a.h.f
    public Map<String, String> b() {
        return this.d;
    }

    @Override // b.b.a.a.h.f
    public g c() {
        return this.e;
    }

    @Override // b.b.a.a.h.f
    public String d() {
        return this.c;
    }

    @Override // b.b.a.a.h.f
    public T getData() {
        return this.f167b;
    }

    @Override // b.b.a.a.h.f
    public int a() {
        return this.a;
    }

    public d(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.d = map;
    }
}
