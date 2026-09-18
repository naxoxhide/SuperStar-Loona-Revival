package com.mbridge.msdk.e.a;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.mbridge.msdk.e.a.a.C0475a f2032b;
    public final u c;
    public boolean d;

    /* JADX INFO: compiled from: Response.java */
    public interface a {
        void a(u uVar);
    }

    /* JADX INFO: compiled from: Response.java */
    public interface b<T> {
        void a(T t);
    }

    public static <T> o<T> a(T t, com.mbridge.msdk.e.a.a.C0475a c0475a) {
        return new o<>(t, c0475a);
    }

    public static <T> o<T> a(u uVar) {
        return new o<>(uVar);
    }

    public final boolean a() {
        return this.c == null;
    }

    private o(T t, com.mbridge.msdk.e.a.a.C0475a c0475a) {
        this.d = false;
        this.a = t;
        this.f2032b = c0475a;
        this.c = null;
    }

    private o(u uVar) {
        this.d = false;
        this.a = null;
        this.f2032b = null;
        this.c = uVar;
    }
}
