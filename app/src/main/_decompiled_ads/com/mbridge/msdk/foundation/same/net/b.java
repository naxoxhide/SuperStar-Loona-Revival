package com.mbridge.msdk.foundation.same.net;

/* JADX INFO: compiled from: DefaultRetryPolicy.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements l {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2128b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public b() {
        this(30000, 0);
    }

    public b(int i, int i2) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.a = i <= 0 ? 30000 : i;
        this.c = i2;
    }

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = Math.max(i, 0);
        this.f = Math.max(i2, 0);
        this.g = Math.max(i3, 0);
        this.h = Math.max(i4, 0);
        this.c = Math.max(i5, 0);
        this.d = i6;
    }

    public b(int i, int i2, int i3, int i4, int i5) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = Math.max(i, 0);
        this.f = Math.max(i2, 0);
        this.g = Math.max(i3, 0);
        this.h = Math.max(i4, 0);
        this.c = Math.max(i5, 0);
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int a() {
        return this.c;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int b() {
        return this.a;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final boolean a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        int i = this.f2128b + 1;
        this.f2128b = i;
        return i <= this.c;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int c() {
        return this.e;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int d() {
        return this.f;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int e() {
        return this.g;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int f() {
        return this.h;
    }
}
