package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class c3 extends q4 {
    public static final b3 f = new b3();
    public final a3 c;
    public final p d;
    public final ra e;

    public c3(a3 a3Var, p pVar, ra raVar, g0 g0Var) {
        super(f, g0Var);
        this.c = a3Var;
        this.d = pVar;
        this.e = raVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c3)) {
            return false;
        }
        c3 c3Var = (c3) obj;
        return a().equals(c3Var.a()) && i3.a(this.c, c3Var.c) && i3.a(this.d, c3Var.d) && i3.a(this.e, c3Var.e);
    }

    public final int hashCode() {
        int i = this.f2802b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        a3 a3Var = this.c;
        int iHashCode2 = (iHashCode + (a3Var != null ? a3Var.hashCode() : 0)) * 37;
        p pVar = this.d;
        int iHashCode3 = (iHashCode2 + (pVar != null ? pVar.hashCode() : 0)) * 37;
        ra raVar = this.e;
        int iHashCode4 = iHashCode3 + (raVar != null ? raVar.hashCode() : 0);
        this.f2802b = iHashCode4;
        return iHashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.c != null) {
            sb.append(", info=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", app=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", user=").append(this.e);
        }
        return sb.replace(0, 2, "InfoSet{").append('}').toString();
    }
}
