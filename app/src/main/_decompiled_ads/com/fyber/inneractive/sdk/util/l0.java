package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes2.dex */
public class l0 {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1342b;

    public l0(int i, int i2) {
        this.a = i;
        this.f1342b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l0.class != obj.getClass()) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.a == l0Var.a && this.f1342b == l0Var.f1342b;
    }

    public int hashCode() {
        return (this.a * 31) + this.f1342b;
    }
}
