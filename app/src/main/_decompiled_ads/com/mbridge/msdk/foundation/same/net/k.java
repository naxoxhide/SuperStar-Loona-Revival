package com.mbridge.msdk.foundation.same.net;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k<T> {
    public T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.net.a.a f2154b;
    public com.mbridge.msdk.foundation.same.net.e.c c;

    public static <T> k<T> a(T t, com.mbridge.msdk.foundation.same.net.e.c cVar) {
        return new k<>(t, cVar);
    }

    public static <T> k<T> a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        return new k<>(aVar);
    }

    private k(T t, com.mbridge.msdk.foundation.same.net.e.c cVar) {
        this.a = null;
        this.f2154b = null;
        this.c = null;
        this.a = t;
        this.c = cVar;
    }

    private k(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        this.a = null;
        this.f2154b = null;
        this.c = null;
        this.f2154b = aVar;
    }
}
