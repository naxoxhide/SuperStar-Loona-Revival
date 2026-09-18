package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class c6 extends q4 {
    public static final b6 f = new b6();
    public final String c;
    public final Long d;
    public final Long e;

    public c6(String str, Long l, Long l2, g0 g0Var) {
        super(f, g0Var);
        this.c = str;
        this.d = l;
        this.e = l2;
    }

    public final a6 b() {
        a6 a6Var = new a6();
        a6Var.c = this.c;
        a6Var.d = this.e;
        g0 g0VarA = a();
        if (g0VarA.b() > 0) {
            if (a6Var.f2796b == null) {
                b0 b0Var = new b0();
                a6Var.a = b0Var;
                a6Var.f2796b = new w5(b0Var);
            }
            try {
                a6Var.f2796b.a(g0VarA);
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }
        return a6Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c6)) {
            return false;
        }
        c6 c6Var = (c6) obj;
        return a().equals(c6Var.a()) && this.c.equals(c6Var.c) && this.d.equals(c6Var.d) && i3.a(this.e, c6Var.e);
    }

    public final int hashCode() {
        int i = this.f2802b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (this.d.hashCode() + ((this.c.hashCode() + (a().hashCode() * 37)) * 37)) * 37;
        Long l = this.e;
        int iHashCode2 = iHashCode + (l != null ? l.hashCode() : 0);
        this.f2802b = iHashCode2;
        return iHashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id=").append(this.c);
        sb.append(", received=").append(this.d);
        if (this.e != null) {
            sb.append(", clicked=").append(this.e);
        }
        return sb.replace(0, 2, "Push{").append('}').toString();
    }
}
