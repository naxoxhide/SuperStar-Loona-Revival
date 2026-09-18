package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class o extends u5 {
    public o() {
        super(3, p.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        p pVar = (p) obj;
        String str = pVar.c;
        if (str != null) {
            u5.k.a(w5Var, 1, str);
        }
        Integer num = pVar.d;
        if (num != null) {
            u5.e.a(w5Var, 2, num);
        }
        String str2 = pVar.e;
        if (str2 != null) {
            u5.k.a(w5Var, 4, str2);
        }
        String str3 = pVar.f;
        if (str3 != null) {
            u5.k.a(w5Var, 5, str3);
        }
        w5Var.a(pVar.a());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        p pVar = (p) obj;
        String str = pVar.c;
        int iA = str != null ? u5.k.a(1, str) : 0;
        Integer num = pVar.d;
        int iA2 = iA + (num != null ? u5.e.a(2, num) : 0);
        String str2 = pVar.e;
        int iA3 = iA2 + (str2 != null ? u5.k.a(4, str2) : 0);
        String str3 = pVar.f;
        return pVar.a().b() + iA3 + (str3 != null ? u5.k.a(5, str3) : 0);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws IOException {
        g0 g0Var;
        long jB = v5Var.b();
        b0 b0Var = null;
        w5 w5Var = null;
        String strB = null;
        Integer numValueOf = null;
        String strB2 = null;
        String strB3 = null;
        while (true) {
            int iD = v5Var.d();
            if (iD == -1) {
                break;
            }
            if (iD == 1) {
                strB = ((b0) v5Var.a).b(v5Var.a());
            } else if (iD == 2) {
                numValueOf = Integer.valueOf(v5Var.g());
            } else if (iD == 3) {
                ((b0) v5Var.a).b(v5Var.a());
            } else if (iD == 4) {
                strB2 = ((b0) v5Var.a).b(v5Var.a());
            } else if (iD == 5) {
                strB3 = ((b0) v5Var.a).b(v5Var.a());
            } else {
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
            }
        }
        v5Var.a(jB);
        if (b0Var != null) {
            g0Var = new g0(b0Var.clone().c());
        } else {
            g0Var = g0.e;
        }
        return new p(strB, numValueOf, strB2, strB3, g0Var);
    }
}
