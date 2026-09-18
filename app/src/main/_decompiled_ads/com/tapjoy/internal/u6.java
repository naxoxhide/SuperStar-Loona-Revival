package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class u6 {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2820b;
    public int c;
    public boolean d;
    public final boolean e;
    public u6 f;
    public u6 g;

    public u6() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final u6 a() {
        u6 u6Var = this.f;
        u6 u6Var2 = u6Var != this ? u6Var : null;
        u6 u6Var3 = this.g;
        u6Var3.f = u6Var;
        this.f.g = u6Var3;
        this.f = null;
        this.g = null;
        return u6Var2;
    }

    public u6(u6 u6Var) {
        this(u6Var.a, u6Var.f2820b, u6Var.c);
        u6Var.d = true;
    }

    public u6(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.f2820b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }
}
