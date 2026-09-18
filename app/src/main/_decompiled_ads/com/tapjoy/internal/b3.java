package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class b3 extends u5 {
    public b3() {
        super(3, c3.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        c3 c3Var = (c3) obj;
        a3 a3Var = c3Var.c;
        if (a3Var != null) {
            a3.u.a(w5Var, 1, a3Var);
        }
        p pVar = c3Var.d;
        if (pVar != null) {
            p.g.a(w5Var, 2, pVar);
        }
        ra raVar = c3Var.e;
        if (raVar != null) {
            ra.x.a(w5Var, 3, raVar);
        }
        w5Var.a(c3Var.a());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        c3 c3Var = (c3) obj;
        a3 a3Var = c3Var.c;
        int iA = a3Var != null ? a3.u.a(1, a3Var) : 0;
        p pVar = c3Var.d;
        int iA2 = iA + (pVar != null ? p.g.a(2, pVar) : 0);
        ra raVar = c3Var.e;
        return c3Var.a().b() + iA2 + (raVar != null ? ra.x.a(3, raVar) : 0);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws IOException {
        g0 g0Var;
        long jB = v5Var.b();
        b0 b0Var = null;
        a3 a3Var = null;
        p pVar = null;
        ra raVar = null;
        w5 w5Var = null;
        while (true) {
            int iD = v5Var.d();
            if (iD == -1) {
                break;
            }
            if (iD == 1) {
                a3Var = (a3) a3.u.a(v5Var);
            } else if (iD == 2) {
                pVar = (p) p.g.a(v5Var);
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
                raVar = (ra) ra.x.a(v5Var);
            }
        }
        v5Var.a(jB);
        if (b0Var != null) {
            g0Var = new g0(b0Var.clone().c());
        } else {
            g0Var = g0.e;
        }
        return new c3(a3Var, pVar, raVar, g0Var);
    }
}
