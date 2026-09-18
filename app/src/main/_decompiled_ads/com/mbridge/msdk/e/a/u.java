package com.mbridge.msdk.e.a;

/* JADX INFO: compiled from: VolleyError.java */
/* JADX INFO: loaded from: classes4.dex */
public class u extends Exception {
    public final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2033b;

    public u() {
        this.a = null;
    }

    public u(k kVar) {
        this.a = kVar;
    }

    public u(Throwable th) {
        super(th);
        this.a = null;
    }

    final void a(long j) {
        this.f2033b = j;
    }
}
