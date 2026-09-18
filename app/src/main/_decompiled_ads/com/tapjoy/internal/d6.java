package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class d6 extends u5 {
    public d6() {
        super(3, e6.class);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws IOException {
        r4 r4VarA = i3.a();
        long jB = v5Var.b();
        b0 b0Var = null;
        w5 w5Var = null;
        while (true) {
            int iD = v5Var.d();
            if (iD == -1) {
                break;
            }
            if (iD != 1) {
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
                r4VarA.add((c6) c6.f.a(v5Var));
            }
        }
        v5Var.a(jB);
        return new e6(r4VarA, b0Var != null ? new g0(b0Var.clone().c()) : g0.e);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        e6 e6Var = (e6) obj;
        c6.f.a().a(w5Var, 1, e6Var.c);
        w5Var.a(e6Var.a());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        e6 e6Var = (e6) obj;
        return e6Var.a().b() + c6.f.a().a(1, e6Var.c);
    }
}
