package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class v {
    public static final v f = new v(0, 0, 0, 0.0d);
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2822b;
    public final long c;
    public final double d;
    public long e;

    public v(long j, long j2, long j3, double d) {
        this.a = j;
        this.f2822b = j2;
        this.c = j3;
        this.d = d;
        this.e = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return this.a == vVar.a && this.f2822b == vVar.f2822b && this.c == vVar.c && this.d == vVar.d && this.e == vVar.e;
    }
}
