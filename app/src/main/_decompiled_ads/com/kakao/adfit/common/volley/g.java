package com.kakao.adfit.common.volley;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes2.dex */
public class g<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.kakao.adfit.common.volley.a.C0448a f1726b;
    public final VolleyError c;
    public boolean d;

    /* JADX INFO: compiled from: Response.java */
    public interface a {
        void a(VolleyError volleyError);
    }

    /* JADX INFO: compiled from: Response.java */
    public interface b<T> {
        void a(T t);
    }

    private g(T t, com.kakao.adfit.common.volley.a.C0448a c0448a) {
        this.d = false;
        this.a = t;
        this.f1726b = c0448a;
        this.c = null;
    }

    public static <T> g<T> a(T t, com.kakao.adfit.common.volley.a.C0448a c0448a) {
        return new g<>(t, c0448a);
    }

    public static <T> g<T> a(VolleyError volleyError) {
        return new g<>(volleyError);
    }

    public boolean a() {
        return this.c == null;
    }

    private g(VolleyError volleyError) {
        this.d = false;
        this.a = null;
        this.f1726b = null;
        this.c = volleyError;
    }
}
