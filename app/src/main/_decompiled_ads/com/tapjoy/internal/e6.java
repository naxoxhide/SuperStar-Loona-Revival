package com.tapjoy.internal;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class e6 extends q4 {
    public static final d6 d = new d6();
    public final List c;

    public e6(r4 r4Var, g0 g0Var) {
        super(d, g0Var);
        this.c = i3.a("pushes", (AbstractList) r4Var);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e6)) {
            return false;
        }
        e6 e6Var = (e6) obj;
        return a().equals(e6Var.a()) && this.c.equals(e6Var.c);
    }

    public final int hashCode() {
        int i = this.f2802b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (a().hashCode() * 37) + this.c.hashCode();
        this.f2802b = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.c.isEmpty()) {
            sb.append(", pushes=").append(this.c);
        }
        return sb.replace(0, 2, "PushList{").append('}').toString();
    }
}
