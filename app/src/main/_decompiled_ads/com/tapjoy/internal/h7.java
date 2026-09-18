package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class h7 extends u5 {
    public h7() {
        super(3, i7.class);
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
                r4VarA.add(((b0) v5Var.a).b(v5Var.a()));
            }
        }
        v5Var.a(jB);
        return new i7(r4VarA, b0Var != null ? new g0(b0Var.clone().c()) : g0.e);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        i7 i7Var = (i7) obj;
        u5.k.a().a(w5Var, 1, i7Var.c);
        w5Var.a(i7Var.a());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        i7 i7Var = (i7) obj;
        return i7Var.a().b() + u5.k.a().a(1, i7Var.c);
    }
}
