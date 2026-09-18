package com.tapjoy.internal;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class i7 extends q4 {
    public static final h7 d = new h7();
    public final List c;

    public i7(AbstractList abstractList, g0 g0Var) {
        super(d, g0Var);
        this.c = i3.a("elements", abstractList);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i7)) {
            return false;
        }
        i7 i7Var = (i7) obj;
        return a().equals(i7Var.a()) && this.c.equals(i7Var.c);
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
            sb.append(", elements=").append(this.c);
        }
        return sb.replace(0, 2, "StringList{").append('}').toString();
    }
}
