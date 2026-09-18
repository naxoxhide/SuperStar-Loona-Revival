package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class b6 extends u5 {
    public b6() {
        super(3, c6.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        c6 c6Var = (c6) obj;
        u5.k.a(w5Var, 1, c6Var.c);
        q5 q5Var = u5.g;
        q5Var.a(w5Var, 2, c6Var.d);
        Long l = c6Var.e;
        if (l != null) {
            q5Var.a(w5Var, 3, l);
        }
        w5Var.a(c6Var.a());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        c6 c6Var = (c6) obj;
        int iA = u5.k.a(1, c6Var.c);
        q5 q5Var = u5.g;
        int iA2 = q5Var.a(2, c6Var.d) + iA;
        Long l = c6Var.e;
        return c6Var.a().b() + iA2 + (l != null ? q5Var.a(3, l) : 0);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws IOException {
        g0 g0Var;
        long jB = v5Var.b();
        String strB = null;
        Long lValueOf = null;
        b0 b0Var = null;
        w5 w5Var = null;
        Long lValueOf2 = null;
        while (true) {
            int iD = v5Var.d();
            if (iD == -1) {
                break;
            }
            if (iD == 1) {
                strB = ((b0) v5Var.a).b(v5Var.a());
            } else if (iD == 2) {
                lValueOf = Long.valueOf(v5Var.h());
            } else if (iD != 3) {
                int i = v5Var.h;
                Object objA = s1.a(i).a(v5Var);
                if (w5Var == null) {
                    b0Var = new b0();
                    w5Var = new w5(b0Var);
                }
                try {
                    s1.a(i).a(w5Var, iD, objA);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            } else {
                lValueOf2 = Long.valueOf(v5Var.h());
            }
        }
        v5Var.a(jB);
        if (strB != null && lValueOf != null) {
            if (b0Var != null) {
                g0Var = new g0(b0Var.clone().c());
            } else {
                g0Var = g0.e;
            }
            return new c6(strB, lValueOf, lValueOf2, g0Var);
        }
        i3.a(strB, "id", lValueOf, "received");
        throw null;
    }
}
