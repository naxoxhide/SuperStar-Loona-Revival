package com.kakao.adfit.common.volley;

/* JADX INFO: loaded from: classes2.dex */
public class VolleyError extends Exception {
    public final com.kakao.adfit.m.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1715b;

    public VolleyError() {
        this.a = null;
    }

    void a(long j) {
        this.f1715b = j;
    }

    public VolleyError(com.kakao.adfit.m.d dVar) {
        this.a = dVar;
    }

    public VolleyError(String str) {
        super(str);
        this.a = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.a = null;
    }
}
